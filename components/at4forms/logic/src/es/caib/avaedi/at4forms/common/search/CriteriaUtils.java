package es.caib.avaedi.at4forms.common.search;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.persister.collection.BasicCollectionPersister;
import org.hibernate.persister.entity.AbstractEntityPersister;
import org.hibernate.persister.entity.Joinable;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.hibernate.engine.SessionFactoryImplementor;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.type.BooleanType;
import org.hibernate.type.CharacterType;
import org.hibernate.type.ComponentType;
import org.hibernate.type.DoubleType;
import org.hibernate.type.EntityType;
import org.hibernate.type.FloatType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.LongType;
import org.hibernate.type.SetType;
import org.hibernate.type.ShortType;
import org.hibernate.type.StringType;
import org.hibernate.type.Type;
import org.springframework.dao.support.DataAccessUtils;

import es.caib.avaedi.at4forms.common.search.PagingConfig.Aggregate;
import es.caib.avaedi.at4forms.common.util.log.LogService;

import org.slf4j.Logger;

/**
 * Clase de utilidades para manejo de búsquedas hibernate basadas en criteria.
 * 
 * @author agarcia
 * 
 */
public class CriteriaUtils {

	/**
	 * The logger object.
	 */
	private static final Logger log = LogService.getLogger(CriteriaUtils.class);

	/**
	 * Constante para la comparación =
	 */
	public static final String COMPARISON_EQUAL = "eq";

	/**
	 * Constante para la comparación <>
	 */
	public static final String COMPARISON_NOTEQ = "ne";

	/**
	 * Constante para la comparación <
	 */
	public static final String COMPARISON_LESST = "lt";

	/**
	 * Constante para la comparación >
	 */
	public static final String COMPARISON_GREAT = "gt";

	/**
	 * Constante para la comparación "is not null"
	 */
	public static final String COMPARISON_ISNOTNULL = "isnotnull";

	/**
	 * Constante para la comparación "is null"
	 */
	public static final String COMPARISON_ISNULL = "isnull";

	/**
	 * Constante para la comparación "in" (usada en collections, sólo)
	 */
	public static final String COMPARISON_IN = "in";

	/**
	 * Constante para la comparación "not in" (usada en collections, sólo)
	 */
	public static final String COMPARISON_NOTIN = "notin";

	/**
	 * Encapsula el Criteria de hibernate, permitiendo reutilizar alias en caso
	 * de que se creen duplicados
	 * 
	 * @author agarcia
	 * 
	 */
	public static class QueryCriteria {

		private Criteria coreCriteria = null;
		private Map<String, Criteria> aliasCriterias = new HashMap<String, Criteria>();

		public QueryCriteria(Criteria coreCriteria) {
			this.coreCriteria = coreCriteria;
		}

		/**
		 * Devuelve el criteria core
		 * 
		 * @return el criteria core
		 */
		public Criteria getCriteria() {
			return this.coreCriteria;
		}

		/**
		 * Devuelve un subcriteria para el alias. Si ya existía uno, lo devuelve
		 * y en caso contrario lo crea nuevo
		 * 
		 * @param alias
		 * @return un subcriteria para el alias
		 */
		private Criteria getCriteria(String alias, int joinType) {
			if (!this.aliasCriterias.containsKey(alias)) {
				this.aliasCriterias.put(alias, this.coreCriteria.createCriteria(alias, joinType));
			}
			return this.aliasCriterias.get(alias);
		}

	}

	/**
	 * Añade la ordenación fijada en paginacion al criterio. También ordena por
	 * agrupación si se informa groupBy
	 * 
	 * @param criteria
	 * @param paginacion
	 */
	public static void setSort(QueryCriteria criteria, PagingConfig paginacion) {
		if (paginacion != null) {
			if ((paginacion.getGroupBy() != null) && !paginacion.getGroupBy().equals("")) {
				if ((paginacion.getSort() == null) || !fieldInOrder(paginacion.getGroupBy(), paginacion.getSort())) {
					//Si está ordenado por el mismo campo, usaremos la ordenación, sino añadimos agrupación
					addOrder(criteria, paginacion.getGroupBy(), PagingConfig.ORDER_DIRECTION_ASC);
				}
			}
			if ((paginacion.getSort() != null) && !paginacion.getSort().equals("")) {
				addOrder(criteria, paginacion.getSort(), paginacion.getDirection());
			}
		}

	}

	/**
	 * Indica si un campo determinado está incluido en la ordenación
	 * 
	 * @param field
	 * @param orderBy
	 * @return
	 */
	private static boolean fieldInOrder(String field, String orderByProperty) {
		if (orderByProperty.contains(",")) {
			//Se ordena por varios campos
			String[] campos = orderByProperty.split(",");
			for (int i = 0; i < campos.length; i++) {
				if (campos[i].equals(field)) {
					return true;
				}
			}
			return false;
		} else {
			return orderByProperty.equals(field);
		}

	}

	/**
	 * Añade el campo orderByProperty como ordenación. <br/>
	 * Se puede usar ',' para usar más de un campo campos, por ejemplo:
	 * "codigoExpediente,codigoTarea"<br/>
	 * Se puede usar '#' para especificar componentes, por ejemplo:
	 * "id#codigoExpediente,id#codigoTarea"<br/>
	 * Se puede usar '.' para especificar asociaciones, por ejemplo
	 * "estadoExpediente.id" También se pueden separar por comas las direcciones
	 * si se quiere diferenciar la ordenación de cada campo
	 * 
	 * @param criteria
	 * @param orderByProperty
	 * @param orderDirection
	 */
	private static void addOrder(QueryCriteria criteria, String orderByProperty, String orderDirection) {
		if (orderByProperty.contains(",")) {
			//Se ordena por varios campos
			String[] campos = orderByProperty.split(",");
			String[] directions = orderDirection.split(",");
			for (int i = 0; i < campos.length; i++) {
				orderDirection = directions[Math.min(i, directions.length - 1)];
				addOrder(criteria, campos[i], orderDirection);
			}

		} else if (orderByProperty.contains(".")) {
			//La ordenación contiene asociaciones
			String[] campos = orderByProperty.split("\\.");
			String tabla = campos[0], campo = campos[1];

			if (orderDirection.equals(PagingConfig.ORDER_DIRECTION_DESC)) {
				//En una ordenación, hay que hacer un LEFT_JOIN para que no se eliminen registros con la relación vacía
				criteria.getCriteria(tabla, CriteriaSpecification.LEFT_JOIN).addOrder(Order.desc(campo));
			} else {
				criteria.getCriteria(tabla, CriteriaSpecification.LEFT_JOIN).addOrder(Order.asc(campo));
			}

		} else if (orderByProperty.contains("#")) {
			String campo = orderByProperty.replace('#', '.');

			if (orderDirection.equals(PagingConfig.ORDER_DIRECTION_DESC)) {
				criteria.getCriteria().addOrder(Order.desc(campo));
			} else {
				criteria.getCriteria().addOrder(Order.asc(campo));
			}

		} else {

			if (orderDirection.equals(PagingConfig.ORDER_DIRECTION_DESC)) {
				criteria.getCriteria().addOrder(Order.desc(orderByProperty));
			} else {
				criteria.getCriteria().addOrder(Order.asc(orderByProperty));
			}

		}

	}

	/**
	 * Añade ordenación según paginacion al criteria
	 * 
	 * @param criteria
	 * @param paginacion
	 */
	/*
	 * public static void setSort(DetachedCriteria criteria, PagingConfig
	 * paginacion) {
	 * 
	 * if (paginacion != null) { if ((paginacion.getGroupBy() != null) &&
	 * !paginacion.getGroupBy().equals("")) { if ((paginacion.getSort() == null)
	 * || !paginacion.getSort().equals(paginacion.getGroupBy())) { //Si está
	 * ordenado por el mismo campo, usaremos la ordenación, sino añadimos
	 * agrupación criteria.addOrder(Order.asc(paginacion.getGroupBy())); } } if
	 * ((paginacion.getSort() != null) && !paginacion.getSort().equals("")) { if
	 * (paginacion.getDirection().equals(PagingConfig.ORDER_DIRECTION_ASC)) {
	 * criteria.addOrder(Order.asc(paginacion.getSort())); } else {
	 * criteria.addOrder(Order.desc(paginacion.getSort())); } } } }
	 */

	/**
	 * Añade ordenación según paginacion al criteria
	 * 
	 * @param criteria
	 * @param paginacion
	 */
	public static void setSort(DetachedCriteria criteria, PagingConfig paginacion) {
		if (paginacion != null) {
			if ((paginacion.getGroupBy() != null) && !paginacion.getGroupBy().equals("")) {
				if ((paginacion.getSort() == null) || !fieldInOrder(paginacion.getGroupBy(), paginacion.getSort())) {
					//Si está ordenado por el mismo campo, usaremos la ordenación, sino añadimos agrupación
					addOrder(criteria, paginacion.getGroupBy(), PagingConfig.ORDER_DIRECTION_ASC);
				}
			}
			if ((paginacion.getSort() != null) && !paginacion.getSort().equals("")) {
				addOrder(criteria, paginacion.getSort(), paginacion.getDirection());
			}
		}

	}

	/**
	 * Añade el campo orderByProperty como ordenación. <br/>
	 * Se puede usar ',' para usar más de un campo campos, por ejemplo:
	 * "codigoExpediente,codigoTarea"<br/>
	 * Se puede usar '#' para especificar componentes, por ejemplo:
	 * "id#codigoExpediente,id#codigoTarea"<br/>
	 * Se puede usar '.' para especificar asociaciones, por ejemplo
	 * "estadoExpediente.id" También se pueden separar por comas las direcciones
	 * si se quiere diferenciar la ordenación de cada campo
	 * 
	 * @param criteria
	 * @param orderByProperty
	 * @param orderDirection
	 */
	private static void addOrder(DetachedCriteria criteria, String orderByProperty, String orderDirection) {
		if (orderByProperty.contains(",")) {
			//Se ordena por varios campos
			String[] campos = orderByProperty.split(",");
			String[] directions = orderDirection.split(",");
			for (int i = 0; i < campos.length; i++) {
				orderDirection = directions[Math.min(i, directions.length - 1)];
				addOrder(criteria, campos[i], orderDirection);
			}

		} else if (orderByProperty.contains("#")) {
			String campo = orderByProperty.replace('#', '.');

			if (orderDirection.equals(PagingConfig.ORDER_DIRECTION_DESC)) {
				criteria.addOrder(Order.desc(campo));
			} else {
				criteria.addOrder(Order.asc(campo));
			}

		} else {

			if (orderDirection.equals(PagingConfig.ORDER_DIRECTION_DESC)) {
				criteria.addOrder(Order.desc(orderByProperty));
			} else {
				criteria.addOrder(Order.asc(orderByProperty));
			}

		}

	}

	/**
	 * Añade los filtros a los criterios hibernate recibidos.
	 * 
	 * @param clazz
	 * @param sessionFactory
	 * @param filters
	 * @param criteria
	 * @param countCriteria
	 * @throws CriteriaUtilsException
	 */
	public static void addFilters(Class<?> clazz, SessionFactory sessionFactory, Collection<FilterConfig> filters, QueryCriteria criteria, QueryCriteria countCriteria) throws CriteriaUtilsException {

		if (filters == null) {
			return;
		}

		Iterator<FilterConfig> iter = filters.iterator();
		while (iter.hasNext()) {
			FilterConfig filter = iter.next();

			//Comprobamos que el filtro sea correcto
			if (filter.getField() == null) {
				throw new CriteriaUtilsException("Recibido filtro incompleto");
			}

			ClassMetadata mainClassMetaData = sessionFactory.getClassMetadata(clazz);

			if (filter.getRelation() != null) {
				//Se trata de un filtro para una one2many

				if (filter.getField().contains(",")) {
					throw new CriteriaUtilsException("No se soportan filtros OR (,) en relation one2many");
				}

				String relation = filter.getRelation();
				filter.setRelation(null);

				//Datos de la relación
				SetType relSetType = (SetType) mainClassMetaData.getPropertyType(relation);
				EntityType relEntityType = (EntityType) relSetType.getElementType((SessionFactoryImplementor) sessionFactory);
				String relEntityName = relEntityType.getAssociatedEntityName();
				ClassMetadata relClassMetadata = sessionFactory.getClassMetadata(relEntityName);

				//Criterias para el subquery
				DetachedCriteria subquery = DetachedCriteria.forEntityName(relEntityName, "subquery");
				DetachedCriteria countSubquery = DetachedCriteria.forEntityName(relEntityName, "subquery");

				//Filtro en el subquery
				if (filter.getField().contains(".")) {
					//El filtro contiene asociaciones tabla.campo
					String[] campos = filter.getField().split("\\.");
					String tabla = campos[0];
					EntityType entityType = (EntityType) relClassMetadata.getPropertyType(tabla);
					Criterion filterCriterion = createCriterionForFilter(filter, sessionFactory.getClassMetadata(entityType.getAssociatedEntityName()), sessionFactory);
					subquery.add(filterCriterion);
					countSubquery.add(filterCriterion);
					/*
					 * debido a un bug en DetachedCriteria, esto no funciona
					 * DetachedCriteria assocCriteria =
					 * subquery.createCriteria(tabla); DetachedCriteria
					 * assocCountCriteria = countSubquery.createCriteria(tabla);
					 * EntityType entityType = (EntityType)
					 * relClassMetadata.getPropertyType(tabla);
					 * filter.setField(campo); Criterion filterCriterion =
					 * createCriterionForFilter(filter,
					 * sessionFactory.getClassMetadata
					 * (entityType.getAssociatedEntityName()));
					 * assocCriteria.add(filterCriterion);
					 * assocCountCriteria.add(filterCriterion);
					 */

				} else {
					//El filtro no contiene asociaciones
					Criterion filterCriterion = createCriterionForFilter(filter, relClassMetadata, sessionFactory);
					subquery.add(filterCriterion);
					countSubquery.add(filterCriterion);
				}

				//Join entre tabla y subtabla
				String mainIdentifier = mainClassMetaData.getIdentifierPropertyName();

				String joinPath = filter.getInverseProperty() + "." + mainIdentifier;
				subquery.add(Restrictions.eqProperty(joinPath, criteria.getCriteria().getAlias() + "." + mainIdentifier));
				countSubquery.add(Restrictions.eqProperty(joinPath, countCriteria.getCriteria().getAlias() + "." + mainIdentifier));

				//Exists
				criteria.getCriteria().add(Subqueries.exists(subquery.setProjection(Projections.id())));
				countCriteria.getCriteria().add(Subqueries.exists(countSubquery.setProjection(Projections.id())));

			} else if (filter.getField().contains(".")) {

				//El filtro contiene asociaciones tabla.campo
				/*
				 * puede ser: tabla1.campo (tarea.id) id1.campo
				 * (id.codigoExpediente) tabla1.tabla2.campo tabla1.id1.campo
				 * tabla1.tabla2.id1.campo etc.
				 */
				if (filter.getField().contains(",")) {
					throw new CriteriaUtilsException("No se soportan filtros OR (,) en asociaciones");
				}

				int beginIndex = filter.getField().indexOf('.');
				String tabla = filter.getField().substring(0, beginIndex);
				String campo = filter.getField().substring(beginIndex + 1);

				//String[] campos = filter.getField().split("\\.");
				//String tabla = campos[0], campo = campos[1];

				ClassMetadata currentMetaData = mainClassMetaData;
				Criteria currentCriteria = criteria.getCriteria();
				Criteria currentCountCriteria = countCriteria.getCriteria();

				Type type = currentMetaData.getPropertyType(tabla);

				if (EntityType.class.isAssignableFrom(type.getClass())) {
					//Se trata de una asociacion, en caso contrario se tratará de un componente (por ejemplo id.campo en claves múltiples)
					boolean isEntity = true;
					currentCriteria = criteria.getCriteria(tabla, CriteriaSpecification.INNER_JOIN);
					currentCountCriteria = countCriteria.getCriteria(tabla, CriteriaSpecification.INNER_JOIN);
					filter.setField(campo);
					EntityType entityType = (EntityType) currentMetaData.getPropertyType(tabla);
					currentMetaData = sessionFactory.getClassMetadata(entityType.getAssociatedEntityName());

					while (campo.contains(".") && isEntity) {
						beginIndex = filter.getField().indexOf('.');
						tabla = filter.getField().substring(0, beginIndex);
						campo = filter.getField().substring(beginIndex + 1);
						type = currentMetaData.getPropertyType(tabla);
						if (EntityType.class.isAssignableFrom(type.getClass())) {
							isEntity = true;
							currentCriteria = currentCriteria.createCriteria(tabla);
							currentCountCriteria = currentCountCriteria.createCriteria(tabla);
							entityType = (EntityType) currentMetaData.getPropertyType(tabla);
							currentMetaData = sessionFactory.getClassMetadata(entityType.getAssociatedEntityName());
							filter.setField(campo);

						} else {
							isEntity = false;
						}

					}

				}

				addFilter(filter, currentMetaData, currentCriteria, currentCountCriteria, sessionFactory);

			} else {

				addFilter(filter, mainClassMetaData, criteria.getCriteria(), countCriteria.getCriteria(), sessionFactory);

			}

		}

	}

	private static void addFilter(FilterConfig filter, ClassMetadata classMetadata, Criteria criteria, Criteria countCriteria, SessionFactory sessionFactory) throws CriteriaUtilsException {

		if (filter.getField().contains(",")) {
			//Es un filtro "OR"
			Disjunction criterion = Restrictions.disjunction();
			String[] fields = filter.getField().split(",");
			for (String field : fields) {
				filter.setField(field.trim());
				criterion.add(createCriterionForFilter(filter, classMetadata, sessionFactory));
			}

			criteria.add(criterion);
			countCriteria.add(criterion);
		} else {
			Criterion criterion = createCriterionForFilter(filter, classMetadata, sessionFactory);
			criteria.add(criterion);
			countCriteria.add(criterion);
		}

	}

	private static Criterion createCriterionForFilter(FilterConfig filter, ClassMetadata classMetadata, SessionFactory sessionFactory) throws CriteriaUtilsException {

		if (COMPARISON_ISNOTNULL.equals(filter.getComparison())) {

			Type type = classMetadata.getPropertyType(filter.getField());
			if (type.isCollectionType()) {
				return Restrictions.isNotEmpty(filter.getField());
			} else {
				return Restrictions.isNotNull(filter.getField());
			}

		} else if (COMPARISON_ISNULL.equals(filter.getComparison())) {

			Type type = classMetadata.getPropertyType(filter.getField());
			if (type.isCollectionType()) {
				return Restrictions.isEmpty(filter.getField());
			} else {
				return Restrictions.isNull(filter.getField());

			}

		}

		if (filter.getType().equals(FilterConfig.TYPE_AUTO)) {

			Object value = getObjectForType(getPropertyType(filter, classMetadata), filter.getValue());
			if ((filter.getComparison() == null) || filter.getComparison().equals(COMPARISON_EQUAL)) {

				return Restrictions.eq(filter.getField(), value);

			} else if (filter.getComparison().equals(COMPARISON_NOTEQ)) {

				return Restrictions.ne(filter.getField(), value);

			} else if (filter.getComparison().equals(COMPARISON_LESST)) {

				return Restrictions.lt(filter.getField(), value);

			} else if (filter.getComparison().equals(COMPARISON_GREAT)) {

				return Restrictions.gt(filter.getField(), value);

			}

		} else if (filter.getType().equals(FilterConfig.TYPE_CHAR)) {

			if ((filter.getComparison() != null) && filter.getComparison().equals(COMPARISON_EQUAL)) {
				return Restrictions.eq(filter.getField(), filter.getValue().charAt(0));
			}

		} else if (filter.getType().equals(FilterConfig.TYPE_STRING)) {

			if ((filter.getComparison() != null) && filter.getComparison().equals(COMPARISON_EQUAL)) {
				return Restrictions.eq(filter.getField(), filter.getValue());
			} else {
				return Restrictions.ilike(filter.getField(), filter.getValue(), MatchMode.ANYWHERE);
			}

		} else if (filter.getType().equals(FilterConfig.TYPE_LIST)) {

			Type type = getPropertyType(filter, classMetadata);
			if (SetType.class.isAssignableFrom(type.getClass())) {
				//Es un collection, en realidad. Lo normal es que venga de una columna many2many
				filter.setType(FilterConfig.TYPE_COLLECTION);
				filter.setComparison(COMPARISON_IN);
				return createCriterionForFilter(filter, classMetadata, sessionFactory);
			}

			String[] filterListString = filter.getValue().split(",");
			//Debemos convertir los objetos al tipo correcto para el campo
			Object[] filterListObject = new Object[filterListString.length];

			for (int i = 0; i < filterListString.length; i++) {

				filterListObject[i] = CriteriaUtils.getObjectForType(type, filterListString[i]);
				if (filterListObject[i] == null) {
					filterListObject[i] = filterListString[i];

				}

			}

			/*
			 * agarcia: hay un bug en hibernate que hace que no funcione el
			 * Restrictions.in con valores compuestos.
			 * https://hibernate.atlassian.net/browse/HHH-1575 Vamos a tratar de
			 * hacer un Disjunction para cada valor, que es en realidad un OR
			 * equivalente a un in
			 */
			//return Restrictions.in(filter.getField(), filterListObject);
			Disjunction criterion = Restrictions.disjunction();
			for (Object value : filterListObject) {
				criterion.add(Restrictions.eq(filter.getField(), value));
			}
			return criterion;

		} else if (filter.getType().equals(FilterConfig.TYPE_BOOLEAN)) {

			if ((filter.getComparison() == null) || filter.getComparison().equals(COMPARISON_EQUAL)) {

				return Restrictions.eq(filter.getField(), Boolean.valueOf(filter.getValue()));

			} else if (filter.getComparison().equals(COMPARISON_NOTEQ)) {

				return Restrictions.ne(filter.getField(), Boolean.valueOf(filter.getValue()));

			}

		} else if (filter.getType().equals(FilterConfig.TYPE_NUMERIC)) {

			Object numericValue = null;

			Type type = getPropertyType(filter, classMetadata);
			numericValue = CriteriaUtils.getNumericObjectForType(type, filter.getValue());

			if (numericValue == null) {
				throw new CriteriaUtilsException("Campo no numéricos o no soportado: " + filter.getField());
			}

			if (filter.getComparison() == null || filter.getComparison().equals(COMPARISON_EQUAL)) {

				return Restrictions.eq(filter.getField(), numericValue);

			} else if (filter.getComparison().equals(COMPARISON_NOTEQ)) {

				return Restrictions.ne(filter.getField(), numericValue);

			} else if (filter.getComparison().equals(COMPARISON_LESST)) {

				return Restrictions.lt(filter.getField(), numericValue);

			} else if (filter.getComparison().equals(COMPARISON_GREAT)) {

				return Restrictions.gt(filter.getField(), numericValue);

			}

		} else if (filter.getType().equals(FilterConfig.TYPE_DATE) || filter.getType().equals(FilterConfig.TYPE_DATETIME)) {

			//Leemos la fecha
			Date dateValue = null;
			try {
				if (filter.getType().equals(FilterConfig.TYPE_DATE)) {
					DateFormat format = new SimpleDateFormat("MM/dd/yyyy");
					dateValue = format.parse(filter.getValue());
				} else {
					//datetime
					DateFormat format = new SimpleDateFormat("MM/dd/yyyy hh:mm");
					dateValue = format.parse(filter.getValue());
				}
			} catch (ParseException e) {
				throw new CriteriaUtilsException("Formato de fecha no válido (" + filter.getValue() + ") para filtro de tipo " + filter.getType(), e);
			}

			if (filter.getComparison() == null) {
				throw new CriteriaUtilsException("Recibido filtro incompleto");
			}

			if (filter.getComparison().equals(COMPARISON_NOTEQ)) {

				return Restrictions.ne(filter.getField(), dateValue);

			} else if (filter.getComparison().equals(COMPARISON_EQUAL)) {

				return Restrictions.eq(filter.getField(), dateValue);

			} else if (filter.getComparison().equals(COMPARISON_LESST)) {

				return Restrictions.lt(filter.getField(), dateValue);

			} else if (filter.getComparison().equals(COMPARISON_GREAT)) {

				return Restrictions.gt(filter.getField(), dateValue);

			}

		} else if (filter.getType().equals(FilterConfig.TYPE_COLLECTION)) {

			Type type = getPropertyType(filter, classMetadata);

			if (SetType.class.isAssignableFrom(type.getClass())) {
				String relatedEntity = ((SetType) type).getAssociatedEntityName((SessionFactoryImplementor) sessionFactory);
				ClassMetadata relatedMetaData = sessionFactory.getClassMetadata(relatedEntity);

				Joinable j = ((SetType) type).getAssociatedJoinable((SessionFactoryImplementor) sessionFactory);
				String relatedTable = j.getTableName();

				//identifier
				String[] idNames = getIdentifierColumnNames(classMetadata, sessionFactory);

				//Columnas relacionadas
				String[] columns = j.getKeyColumnNames();

				//Columnas relacionadas con relatedTable
				String[] elementColumns = ((BasicCollectionPersister) j).getElementColumnNames();

				//Tipo del id relacionado
				Type rType = relatedMetaData.getIdentifierType();

				//Podemos tener un valor o bien varios separados por tomas. 
				//Si, esto dará problemas con claves que contengan comas
				String[] filterListString = filter.getValue().split(",");
				Object[] filterListObject = new Object[filterListString.length];
				Type[] rTypes = new Type[filterListString.length];
				String params = "";
				for (int i = 0; i < filterListString.length; i++) {
					if (i > 0)
						params += ",";
					rTypes[i] = rType;
					params += "?";
					filterListObject[i] = CriteriaUtils.getObjectForType(rType, filterListString[i]);
					if (filterListObject[i] == null) {
						filterListObject[i] = filterListString[i];
					}

				}

				//Object value = getObjectForType(rType, filter.getValue());

				String clause = filter.getComparison().equals(CriteriaUtils.COMPARISON_NOTIN) ? "not exists" : "exists";

				//TODO: por ahora sólo funcionamos con claves simples.
				//TODO: comprobar si en hbn4 funciona con elements

				//return Restrictions.sqlRestriction("? in elements({alias}." + filter.getField() +")", value, relatedMetaData.getIdentifierType());
				return Restrictions.sqlRestriction(clause + " (select null from " + relatedTable + " zp " + "where " + "zp." + columns[0] + " = {alias}." + idNames[0] + " and " + "zp." + elementColumns[0] + " IN (" + params + "))", filterListObject, rTypes);
				//"? in (select id_zona from isn_zona_propiedad zp where zp.id_propiedad = {alias}.id";
				//"exists (select null from isn_zona_propiedad zp where zp.id_propiedad = {alias}.id and zp.id_zona = ?)";
			} else {

				throw new CriteriaUtilsException("Tipo de filtro no soportado (" + filter.getType() + ") para el campo " + filter.getField() + " que no es una colección");
			}

		}

		throw new CriteriaUtilsException("Tipo de filtro no soportado (" + filter.getType() + ")");

	}

	private static String[] getIdentifierColumnNames(ClassMetadata meta, SessionFactory sessionFactory) {
		AbstractEntityPersister persister = (AbstractEntityPersister) meta;
		String Id = persister.getIdentifierPropertyName();
		String[] columns = persister.getPropertyColumnNames(Id);
		return columns;
	}

	private static Type getPropertyType(FilterConfig filter, ClassMetadata classMetadata) {
		if (filter.getField().contains(".")) {
			String campo = null;
			String[] campos = filter.getField().split("\\.");
			campo = campos[1];
			List<String> properties = Arrays.asList(classMetadata.getPropertyNames());
			if (properties.contains(campo)) { //existe el campo
				//El filtro contiene asociaciones tabla.campo
				return classMetadata.getPropertyType(campo);
			} else {
				//Debe ser un componente (como por ejemplo id.campo en una clave compuesta)
				return classMetadata.getPropertyType(filter.getField());
			}
		} else {
			return classMetadata.getPropertyType(filter.getField());
		}
	}

	/**
	 * Devuelve el tipo de objeto adecuado para el tipo hibernate type
	 * convirtiendo el string value
	 * 
	 * @param type
	 * @param value
	 * @return objeto númerico (Integer, Double, etc)
	 */
	public static Object getNumericObjectForType(Type type, String value) {
		Object numericValue = null;
		if (type instanceof IntegerType) {
			numericValue = new Integer(value);
		} else if (type instanceof DoubleType) {
			numericValue = new Double(value);
		} else if (type instanceof FloatType) {
			numericValue = new Float(value);
		} else if (type instanceof LongType) {
			numericValue = new Long(value);
		} else if (type instanceof ShortType) {
			numericValue = new Short(value);
		}
		return numericValue;
	}

	/**
	 * Devuelve el tipo de objeto adecuado para el tipo hibernate type
	 * convirtiendo el string value
	 * 
	 * @param type
	 * @param value
	 * @return objeto númerico (Integer, Double, etc)
	 */
	@SuppressWarnings("unchecked")
	public static Object getObjectForType(Type type, String value) {
		Object finalValue = getNumericObjectForType(type, value);
		if (finalValue != null) {
			return finalValue;
		}

		if (type instanceof StringType) {
			return value;
		} else if (type instanceof BooleanType) {
			return Boolean.valueOf(value);
		} else if (type instanceof CharacterType) {
			return Character.valueOf(value.charAt(0));
		} else if (type instanceof ComponentType) {
			try {
				//En el caso de que sea un componente (clave compuesta) probablemente llegue el valor como XX|YY. 
				//Tenemos en los tipos de clave compuesta el método fromString(String) para convertir 
				Method method = ((ComponentType) type).getReturnedClass().getMethod("fromString", String.class);
				return method.invoke(type, value);
			} catch (NoSuchMethodException e) {
				log.warn("No se ha podido convertir el objeto: " + value + " a " + type.getName());
				return value;
			} catch (SecurityException e) {
				log.warn("No se ha podido convertir el objeto: " + value + " a " + type.getName());
				return value;
			} catch (IllegalAccessException e) {
				log.warn("No se ha podido convertir el objeto: " + value + " a " + type.getName());
				return value;
			} catch (IllegalArgumentException e) {
				log.warn("No se ha podido convertir el objeto: " + value + " a " + type.getName());
				return value;
			} catch (InvocationTargetException e) {
				log.warn("No se ha podido convertir el objeto: " + value + " a " + type.getName());
				return value;
			}
		} else {
			log.warn("No se ha podido convertir el objeto: " + value + " a " + type.getName());
			return value;
		}

	}

	/**
	 * Ejecuta una búsqueda basada en "criterias" de hibernate
	 * 
	 * @param criteria
	 * @param countCriteria
	 * @param paginacion
	 * @return resultado de la ejecución
	 */
	@SuppressWarnings("unchecked")
	public static <T> ResultadoBusqueda<T> getResultadoBusqueda(QueryCriteria criteria, QueryCriteria countCriteria, PagingConfig paginacion) {

		log.debug("started getResultadoBusqueda");
		if (paginacion == null) {
			paginacion = new PagingConfig();
		}

		CriteriaUtils.setSort(criteria, paginacion);
		criteria.getCriteria().setFirstResult(paginacion.getStart());
		if (paginacion.getLimit() > 0) {
			criteria.getCriteria().setFetchSize(paginacion.getLimit());
			criteria.getCriteria().setMaxResults(paginacion.getLimit());
		}
		/**
		 * Necesario para no obtener filas duplicadas en relaciones many2many
		 * con FetchMode = EAGER
		 * (http://brondsema.net/blog/index.php/2005/10/20/
		 * hibernate_many_to_many_relationships_and)
		 * criteria.getCriteria().setResultTransformer
		 * (CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		 * countCriteria.getCriteria
		 * ().setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		 * 
		 * Sin embargo, esto no funciona, en mi opinión por un bug en hibernate
		 * criteria API. Parece que primero aplica setMaxResults y después
		 * distinct; por lo que las queries paginadas se vuelven locas. Aquí hay
		 * una explicación:
		 * https://forums.hibernate.org/viewtopic.php?f=1&t=972637&view=next
		 */

		List<T> resultados = criteria.getCriteria().list();
		ResultadoBusqueda<T> resultado = new ResultadoBusqueda<T>();
		resultado.setError(false);
		resultado.setResultados(resultados);

		long count = 0;
		if ((paginacion.getLimit() > 0) || (paginacion.getStart() > 0) || paginacion.getAggregates().size() > 0) {
			ProjectionList projections = Projections.projectionList().add(Projections.rowCount(), "count");

			int aggregateNum = 1;
			for (Aggregate a : paginacion.getAggregates()) {
				if (a.getSummaryType().equals(PagingConfig.SUMMARY_SUM)) {
					projections.add(Projections.sum(a.getField()), "projection__" + aggregateNum);
				} else if (a.getSummaryType().equals(PagingConfig.SUMMARY_AVERAGE)) {
					projections.add(Projections.avg(a.getField()), "projection__" + aggregateNum);
				} else if (a.getSummaryType().equals(PagingConfig.SUMMARY_MAX)) {
					projections.add(Projections.max(a.getField()), "projection__" + aggregateNum);
				} else if (a.getSummaryType().equals(PagingConfig.SUMMARY_MIN)) {
					projections.add(Projections.min(a.getField()), "projection__" + aggregateNum);
				} else {
					throw new IllegalArgumentException("Aggregate no soportado:" + a.getSummaryType());
				}
				aggregateNum++;
			}

			//Si no hay límites, no hace falta ejecutar el count
			countCriteria.getCriteria().setProjection(projections);

			if (aggregateNum == 1) {
				//Sólo tenemos el count genérico
				Object countObj = countCriteria.getCriteria().uniqueResult();
				if (countObj != null) {
					count = countObj.hashCode();
				}
			} else {
				/* Tenemos más de una columna de agregados */
				Object[] agregates = (Object[]) DataAccessUtils.singleResult(countCriteria.getCriteria().list());
				count = ((Long) agregates[0]).intValue();

				aggregateNum = 1;
				for (Aggregate a : paginacion.getAggregates()) {
					resultado.addAggregate(a.getField(), agregates[aggregateNum]);
					aggregateNum++;
				}

			}

		} else {
			count = resultados.size();
		}

		resultado.setTotalNumRecords(count);

		if (log.isDebugEnabled()) {
			int tamanyoResultados = (resultados == null) ? 0 : resultados.size();
			log.debug("getResultadoBusqueda: " + tamanyoResultados);
			log.debug("getResultadoBusqueda: " + count + " resultados");
		}

		log.debug("finished getResultadoGenerico");
		return resultado;

	}

	/**
	 * Modifica los filtros adecuándolos a su uso por los dao, segun las
	 * asignaciones de nombres
	 * 
	 * @param filters
	 * @param pagingConfig
	 */

	public static void normalizeFilters(Map<String, String> assigments, Collection<FilterConfig> filters, PagingConfig pagingConfig) {
		normalizeOrders(assigments, pagingConfig);
		normalizeFilters(assigments, filters);
	}

	/*public static void normalizeOrders(Map<String, String> assigments, PagingConfig pagingConfig) {

		// Normalizamos la ordenación y la agrupación 
		for (Entry<String, String> entry : assigments.entrySet()) {

			if (pagingConfig != null) {

				if (pagingConfig.getGroupBy() != null) {

					if (pagingConfig.getGroupBy().equals(entry.getKey())) {
						pagingConfig.setGroupBy(entry.getValue());
						pagingConfig.setDirection(PagingConfig.ORDER_DIRECTION_ASC);
					}
				}
				if (pagingConfig.getSort() != null) {

					if (pagingConfig.getSort().equals(entry.getKey())) {
						pagingConfig.setSort(entry.getValue());
						pagingConfig.setDirection(PagingConfig.ORDER_DIRECTION_ASC);
					}
				}

			}

		}
	}*/
	
	public static void normalizeOrders(Map<String, String> assigments, PagingConfig pagingConfig) {
		
		if (pagingConfig != null) {
			
			if(pagingConfig.getDirection() == null || !(pagingConfig.getDirection().equals(PagingConfig.ORDER_DIRECTION_ASC) || pagingConfig.getDirection().equals(PagingConfig.ORDER_DIRECTION_DESC))){
				pagingConfig.setDirection(PagingConfig.ORDER_DIRECTION_ASC);
			}
			/* Normalizamos la ordenación y la agrupación */
			for (Entry<String, String> entry : assigments.entrySet()) {
				if (pagingConfig.getGroupBy() != null) {
					if (pagingConfig.getGroupBy().equals(entry.getKey())) {
						pagingConfig.setGroupBy(entry.getValue());
					}
				}
				if (pagingConfig.getSort() != null) {
					if (pagingConfig.getSort().equals(entry.getKey())) {
						pagingConfig.setSort(entry.getValue());
					}
				}
			}
		}
	}

	public static void normalizeFilters(Map<String, String> assigments, Collection<FilterConfig> filters) {

		if (filters == null) {
			filters = new ArrayList<FilterConfig>();
		}

		/**/

		/*
		 * No podemos añadir elementos a la colección filters mientras la
		 * estamos iterando, los añadiremos en newFilters y después mezclamos.
		 */
		Collection<FilterConfig> newFilters = new ArrayList<FilterConfig>();
		Iterator<FilterConfig> iter = filters.iterator();
		FilterConfig filter = null;
		while (iter.hasNext()) {
			filter = iter.next();

			for (Entry<String, String> entry : assigments.entrySet()) {
				if (filter.getField().equals(entry.getKey())) {
					////Eliminamos el filtro original de la colección. La forma de hacerlo es con el iterator
					iter.remove(); //
					newFilters.add(new FilterConfig(filter.getType(), entry.getValue(), filter.getComparison(), filter.getValue()));
				}
			}

		}

		//Añadimos los nuevos filtros
		filters.addAll(newFilters);

	}

}
