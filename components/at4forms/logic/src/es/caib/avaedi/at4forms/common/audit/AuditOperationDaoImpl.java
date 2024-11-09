package es.caib.avaedi.at4forms.common.audit;


import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.SessionFactory;
import org.hibernate.jdbc.Work;
import org.slf4j.Logger;
import org.springframework.stereotype.Repository;

import es.caib.avaedi.at4forms.common.basedao.BaseDaoImpl;
import es.caib.avaedi.at4forms.common.basedao.BaseModel;
import es.caib.avaedi.at4forms.common.util.FormData2Java;
import es.caib.avaedi.at4forms.common.util.log.LogService;

/**
 * Implementación para el interfaz AuditOperationDao
 * @author agarcia
 */
@Repository("AuditOperationDao")
public class AuditOperationDaoImpl extends BaseDaoImpl<AuditOperation> implements AuditOperationDao {

	/**
	 * The logger object.
	 */
	private static Logger log = LogService.getLogger(AuditOperationDaoImpl.class);
	
		public AuditOperationDaoImpl() {
			super(AuditOperation.class);
		}

		public AuditOperationDaoImpl(SessionFactory sessionFactory) {
			super(AuditOperation.class, sessionFactory);
		}

	   public <T> T getNewRecord(long id, String tableName, Class<T> typeClass) {
		   /* Esto no funciona, pq si dejamos que hibernate cargue las entidades entonces usa el id declarado para "cachear" y entonces new y old acaban siendo la misma instancia
		   Query query = this.getSessionFactory().getCurrentSession().createSQLQuery("SELECT (audit_new).*, -audit_id as id from audit." + tableName + "_audit where audit_id = ?")
		   .addEntity(typeClass);
		   query.setLong(0, id);
		   return (T) query.uniqueResult();
		   */
		   
		   String query = "SELECT (audit_new).* from audit." + tableName + "_audit where audit_id = ?";
		   return loadQuery(typeClass, query, id);

	   }   
	   
	   public <T> T getOldRecord(long id, String tableName, Class<T> typeClass) {
		   /* Esto no funciona, pq si dejamos que hibernate cargue las entidades entonces usa el id declarado para "cachear" y entonces new y old acaban siendo la misma instancia
		   Query query = this.getSessionFactory().getCurrentSession().createSQLQuery("SELECT (audit_old).*, -audit_id as id from audit." + tableName + "_audit where audit_id = ?")
		   .addEntity(typeClass);
		   query.setLong(0, id);
		   return (T) query.uniqueResult();
		   */
		  
		   String query = "SELECT (audit_old).*, -audit_id as id from audit." + tableName + "_audit where audit_id = ?";
		   return loadQuery(typeClass, query, id);

	   }

	   
	   private static final class Worker<T> implements Work {

		   private T instance = null;
		   private long id;
		   private String sql;
		   private Class<T> typeClass;
		   
			public Worker(T instance, Class<T> typeClass, String sql, long id) {
				this.instance = instance;
				this.typeClass = typeClass;
				this.sql = sql;
				this.id = id;
			}

			@Override
			public void execute(Connection connection) throws SQLException {

		    	PreparedStatement stmt = connection.prepareStatement(sql); 
		    	stmt.setLong(1, id);
		    	ResultSet rs = stmt.executeQuery();
		    	if (!rs.next()) {
		    		throw new SQLException("No se encuentra la auditoria de la clase " + typeClass.getName() + " para el id " + id);
		    	}
		    	
		        ResultSetMetaData meta = rs.getMetaData();
	            Map<String, Object> map = new HashMap<String, Object>();
	            for (int i = 1; i <= meta.getColumnCount(); i++) {
	                String key = meta.getColumnName(i);
	                String value = rs.getString(key);
	                map.put(key, value);
	            }
			    
	            loadFromMap(instance, typeClass, map);
				
			}
	   }
	   
	   private static <T> void loadFromMap(T instance, Class<T> typeClass, Map<String, Object> map) {

			//Inspeccionamos la clase para ver las columnas y así fijar los resultados del select
			List<Method> columns = getMethodsAnnotatedWith(typeClass, Column.class);
			List<Method> many2ones = getMethodsAnnotatedWith(typeClass, ManyToOne.class);
			
			String setterName = "";
			Method setter = null;

			for (Method getter : columns) {
			   try {
					Column annotInstance = getter.getAnnotation(Column.class);
					if (getter.getName().startsWith("get")) {
						setterName = "set" + getter.getName().substring(3);
					} else if (getter.getName().startsWith("is")) {
						setterName = "set" + getter.getName().substring(2);
					} else {
						continue;
					}
					setter = typeClass.getMethod(setterName, getter.getReturnType());
					String colName = annotInstance.name();
					if (colName == null) {
						throw new InstantiationException("No se encuentra una columna de la clase " + typeClass.getName() + " en la auditoria "); 
					}

					/* TODO: comprobar esto
					if (!rs.containsKey(colName)) {
						throw new InstantiationException("No se encuentra la columna " + colName + " en la auditoria de " + typeClass.getName()); 
					}
					*/
					//Object colValue = data.get(colName);
					
					//TODO: comprobar que el parámetro existe
					Class<?> setterType = setter.getParameterTypes()[0];
					Object colValue = getObject(map, colName, setterType);
					if (colValue != null) {
						//log.debug("AuditOperationDaoImpl.loadQuery cargando valor " + colValue.toString() + " para " + setterName);
						setValue(setter, instance, colValue);
					}
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
				
			for (Method getter : many2ones) {
				   try {
						if (!getter.getName().startsWith("get")) {
							continue;
						}
						//TODO: esto sólo funciona con claves simples
						JoinColumn annotInstance = getter.getAnnotation(JoinColumn.class);
						if (annotInstance == null || annotInstance.name() == null) {
							throw new InstantiationException("No se encuentra una columna de la clase " + typeClass.getName() + " en la auditoria "); 
						}
						setterName = "set" + getter.getName().substring(3);
						setter = typeClass.getMethod(setterName, getter.getReturnType());
						String colName = annotInstance.name();

						//TODO: comprobar que el parámetro existe
						Object colValue = getObject(map, colName, setter.getParameterTypes()[0]);
						if (colValue != null) {
							//log.debug("AuditOperationDaoImpl.loadQuery cargando valor " + colValue.toString() + " para " + setterName);
							setValue(setter, instance, colValue);
						}
					} catch (InstantiationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (NoSuchMethodException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SecurityException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}

	   }

	   private static void setValue(Method setter, Object instance, Object colValue) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
			Class<?> setterType = setter.getParameterTypes()[0];
			if (setterType.isPrimitive()) {
				if (setterType.equals(int.class)) {
					setter.invoke(instance, ((Integer)colValue).intValue());
				} else if (setterType.equals(short.class)) {
					setter.invoke(instance, ((Short)colValue).shortValue());
				} else if (setterType.equals(char.class)) {
					setter.invoke(instance, ((Character)colValue).charValue());
				} else if (setterType.equals(long.class)) {
					setter.invoke(instance, ((Long)colValue).longValue());
				} else if (setterType.equals(float.class)) {
					setter.invoke(instance, ((Float)colValue).floatValue());
				} else if (setterType.equals(double.class)) {
					setter.invoke(instance, ((Double)colValue).doubleValue());
				} else if (setterType.equals(boolean.class)) {
					setter.invoke(instance, ((Boolean)colValue).booleanValue());
				} else if (setterType.equals(byte.class)) {
					setter.invoke(instance, ((Byte)colValue).byteValue());
				} 
			} else {
				setter.invoke(instance, colValue);
			}
	   }
	   
	/**
	    * Carga un objeto del modelo auditado a partir de un SQL. 
	    * NOTA: Otra opción más sencilla sería que los objetos auditables tuvieran un constructor a partir de un Map.
	    * 
	    * @param <T>
	    * @param typeClass
	    * @param sql
	    * @param id
	    * @return
	    */
	   private <T> T loadQuery(final Class<T> typeClass, final String sql, final long id) {

		   
		   T instance = null;
		try {
			instance = typeClass.newInstance();
			   /* Esto da un "java.lang.UnsupportedOperationException: SQL queries do not currently support returning aliases"
			   Object[] data = (Object[]) query.uniqueResult();
			   String[] colNames = query.getReturnAliases();
			   Map<String, Integer> colIdx = new HashMap<String, Integer>();
			   for (int i = 0; i < colNames.length; i++) {
				   colIdx.put(colNames[i], i);
			   }
			    */

			   /* Esto es trabajando con el query hbn  
			   Query query = this.getSessionFactory().getCurrentSession().createSQLQuery(sql);
			   query.setLong(0, id);
			   query.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
			   Map<String,Object> data = (Map<String, Object>) query.uniqueResult();
			   loadFromMap(instance, typeClass, data);
			   /* */
			

				/* Esto sería trabajando con el resultset: */
			   this.getSessionFactory().getCurrentSession().doWork( new Worker<T>(instance, typeClass, sql, id) );
			   /* */
			   
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		   
		
		return instance;
		   
	   }
	   

	private static Object getObject(Map<String, Object> map, String colName, Class<?> type) {
		try {
			Object ret = map.get(colName);
			if (ret == null) {
				return null;
			}
			
			if (BaseModel.class.isAssignableFrom(type)) {
				//Si es un BaseModel, entonces esto será un ManyToOne.
				//Sólo nos interesa mantener aquí el PK.
				//TODO: esto sólo funciona con claves simples
				Object related = type.newInstance();
				List<Method> ids = getMethodsAnnotatedWith(type, Id.class);
				if (ids.size() != 1) {
					log.debug("No se puede convertir directamente: " + colName + " de " + ret.getClass().getName() + " a " + type.getName() );
					return null;
				}
				Method getter = ids.get(0);
				String setterName = "set" + getter.getName().substring(3);
				Method setter = type.getMethod(setterName, getter.getReturnType());
				Class<?> setterType = setter.getParameterTypes()[0];
				Object colValue = getObject(map, colName, setterType );
				if (colValue != null) {
					setValue(setter, related, colValue);
					return related;
				} else {
					log.debug("No se puede convertir directamente: " + colName + " de " + ret.getClass().getName() + " a " + type.getName() );
					return null;
				}
				
				
			}
			
			try {
				ret = type.cast(ret);
			} catch (ClassCastException cce) {
				log.debug("No se puede convertir directamente: " + colName + " de " + ret.getClass().getName() + " a " + type.getName() );
			}
			
			if (type.isAssignableFrom(ret.getClass())) {
				return ret;
			
			} else {

				if (type.equals(Double.class) || type.equals(double.class)) {
					
					if (ret.getClass().isAssignableFrom(BigDecimal.class)) {
						return ((BigDecimal)ret).doubleValue();
					} else if (ret.getClass().isAssignableFrom(String.class)) {
						return Double.valueOf((String)ret);
					}
					
				} else if (type.equals(Float.class) || type.equals(float.class)) {
					
					if (ret.getClass().isAssignableFrom(String.class)) {
						return Float.valueOf((String)ret);
					}
					
				} else if (type.equals(Integer.class) || type.equals(int.class)) {
					
					if (ret.getClass().isAssignableFrom(String.class)) {
						return Integer.valueOf((String)ret);
					}
					
				} else if (type.equals(Short.class) || type.equals(short.class)) {
					
					if (ret.getClass().isAssignableFrom(String.class)) {
						return Short.valueOf((String)ret);
					}
					
				} else if (type.equals(Character.class) || type.equals(char.class)) {
					
					if (ret.getClass().isAssignableFrom(String.class)) {
						return Character.valueOf( ((String)ret).charAt(0));
					}
					
				} else if (type.equals(Long.class) || type.equals(long.class)) {
					
					if (ret.getClass().isAssignableFrom(String.class)) {
						return Long.valueOf((String)ret);
					}
					
					
				} else if (type.equals(Date.class)) {
					
					if (ret.getClass().isAssignableFrom(String.class)) {
						return toDate((String)ret);
					}
					
				} else if (type.equals(Boolean.class) || type.equals(boolean.class)) {
					
					if (ret.getClass().isAssignableFrom(String.class)) {
						return "t".equals(ret);
					}
					
				}
				
				log.error("No se ha podido obtener la columna: " + colName + " de " + ret.getClass().getName() + " a " + type.getName() );
				
			}
			 
		} catch (InstantiationException e) {
			log.error("No se ha podido obtener la columna: " + colName, e);
		} catch (IllegalAccessException e) {
			log.error("No se ha podido obtener la columna: " + colName, e);
		} catch (NoSuchMethodException e) {
			log.error("No se ha podido obtener la columna: " + colName, e);
		} catch (SecurityException e) {
			log.error("No se ha podido obtener la columna: " + colName, e);
		} catch (IllegalArgumentException e) {
			log.error("No se ha podido obtener la columna: " + colName, e);
		} catch (InvocationTargetException e) {
			log.error("No se ha podido obtener la columna: " + colName, e);
		} catch (ParseException e) {
			log.error("No se ha podido obtener la columna: " + colName, e);
		}

		return null;
		
	}

	private static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	private static final DateFormat datetimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

	private static Date toDate(String data) throws ParseException {
		if (data != null) {
			if (data.length() > 11) {
				return datetimeFormat.parse(data);
			} else {
				return dateFormat.parse(data);
			}
		} else {
			return null;
		}
	}
	
	private static List<Method> getMethodsAnnotatedWith(final Class<?> type, final Class<? extends Annotation> annotation) {
		    final List<Method> methods = new ArrayList<Method>();
		    Class<?> klass = type;
	        // iterate though the list of methods declared in the class represented by klass variable, and add those annotated with the specified annotation
	        final List<Method> allMethods = new ArrayList<Method>(Arrays.asList(klass.getMethods()));       
	        for (final Method method : allMethods) {
	            if (method.isAnnotationPresent(annotation)) {
	                //Annotation annotInstance = method.getAnnotation(annotation);
	                // TODO process annotInstance
	                methods.add(method);
	            }
	        }
		    return methods;
		}


}

