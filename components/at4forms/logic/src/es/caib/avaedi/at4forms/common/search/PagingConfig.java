package es.caib.avaedi.at4forms.common.search;

import java.util.List;
import java.util.ArrayList;

import org.directwebremoting.annotations.DataTransferObject;

/**
 * Incluye los datos de paginación y ordenación para una búsqueda
 * @author agarcia
 *
 */
@DataTransferObject
public class PagingConfig {

	/**
	 * Constante para la dirección de ordenación ascendente
	 */
	public static final String ORDER_DIRECTION_ASC = "ASC";

	/**
	 * Constante para la dirección de ordenación descendente
	 */
	public static final String ORDER_DIRECTION_DESC = "DESC";

	
	public static final String SUMMARY_SUM 		= "sum";
	public static final String SUMMARY_MAX 		= "max";
	public static final String SUMMARY_MIN 		= "min";
	public static final String SUMMARY_AVERAGE 	= "average";
	
	
	private int start = 0;
	private int limit = 0;
	private String sort = "";
	private String direction = "";
	private String groupBy = "";
	
	private List<Aggregate> aggregates = new ArrayList<Aggregate>();

	public PagingConfig() {
	}

	public PagingConfig(int limit) {
		this.limit = limit;
	}

	/** Devuelve la agrupación groupBy, campo/s por los que agrupar
	 * @return la agrupación groupBy, campo/s por los que agrupar
	 */
	public String getGroupBy() {
		return this.groupBy;
	}

	/** fija la agrupación groupBy
	 * @param groupBy la agrupación groupBy a fijar
	 */
	public void setGroupBy(String groupBy) {
		this.groupBy = groupBy;
	}

	/** Primer registro a incluir en la página
	 * @return Primer registro a incluir en la página
	 */
	public int getStart() {
		return this.start;
	}

	/** Primer registro a incluir en la página
	 * @param start Primer registro a incluir en la página
	 */
	public void setStart(int start) {
		this.start = start;
	}

	/** Número de registros a incluir
	 * @return Número de registros a incluir
	 */
	public int getLimit() {
		return this.limit;
	}

	/** Número de registros a incluir
	 * @param limit Número de registros a incluir
	 */
	public void setLimit(int limit) {
		this.limit = limit;
	}

	/** Dirección de la ordenación
	 * @see #ORDER_DIRECTION_ASC
	 * @see #ORDER_DIRECTION_DESC
	 * @return Dirección de la ordenación
	 */
	public String getDirection() {
		return this.direction;
	}

	/** Dirección de la ordenación
	 * @see #ORDER_DIRECTION_ASC
	 * @see #ORDER_DIRECTION_DESC
	 * @param direction Dirección de la ordenación
	 */
	public void setDirection(String direction) {
		this.direction = direction;
	}

	/** Campo o campos separados por comas por los que ordenar
	 * @return Campo/s por los que ordenar
	 */
	public String getSort() {
		return this.sort;
	}

	/** Campo/s por los que ordenar
	 * @param sort Campo o campos separados por comas por los que ordenar
	 */
	public void setSort(String sort) {
		this.sort = sort;
	}

	/** Añade un aggregate para el campo field
	 * @see #SUMMARY_SUM
	 * @see #SUMMARY_MAX
	 * @see #SUMMARY_MIN
	 * @see #SUMMARY_AVERAGE
	 * @param direction Dirección de la ordenación
	 */
	public void addAggregate(String field, String summaryType) {
		if ( !summaryType.equals(SUMMARY_AVERAGE) && !summaryType.equals(SUMMARY_MAX) && !summaryType.equals(SUMMARY_MIN) && !summaryType.equals(SUMMARY_SUM) ) {
			throw new IllegalArgumentException("Incorrecto summary Type:" + summaryType);
		}
		this.aggregates.add( new Aggregate(field, summaryType));
	}
	
    public class Aggregate {
    	private String field;
    	private String summaryType;
    	public Aggregate (String field, String summaryType) {
    		this.setField(field);
    		this.setSummaryType(summaryType);
    	}
		public void setField(String field) {
			this.field = field;
		}
		public String getField() {
			return field;
		}
		public void setSummaryType(String summaryType) {
			this.summaryType = summaryType;
		}
		public String getSummaryType() {
			return summaryType;
		}
    }
	
	public List<Aggregate> getAggregates() {
		return aggregates;
	}

}
