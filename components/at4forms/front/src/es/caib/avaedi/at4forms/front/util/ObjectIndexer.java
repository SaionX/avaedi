package es.caib.avaedi.at4forms.front.util;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;

public class ObjectIndexer {

	/**
	 * Devuelve un índice para la colección
	 * @param col
	 * @return
	 */
	public static <T extends Indexable<R>, R> Map<R, T> index( Collection<T> col ) {

		Map<R, T> index = new HashMap<R, T>();
		if (col != null) {
			for (T ele : col) {

				index.put(ele.getIndex(), ele);

			}
		}

		return index;


	}



	/**
	 * Devuelve un índice para la colección
	 * @param col
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T, R> Map<R, T> indexFor( Collection<T> col, R beanPropertyType, String beanPropertyName ) {

		Map<R, T> index = new HashMap<R, T>();
		if ((col != null) && (col.size() > 0)) {
			T first = col.iterator().next();
			PropertyDescriptor prop = BeanUtils.getPropertyDescriptor(first.getClass(), beanPropertyName);

			Method getMethod = prop.getReadMethod();

			if (!getMethod.getReturnType().isAssignableFrom(beanPropertyType.getClass()) ) {
				throw new IllegalArgumentException("El tipo " + beanPropertyType.getClass() + " no es compatible con la propiedad " + beanPropertyName );
			}
			try {
				for (T ele : col) {
						index.put((R) getMethod.invoke(ele), ele);
				}
			} catch (IllegalAccessException e) {
				throw new IllegalArgumentException("El tipo " + beanPropertyType.getClass() + " no es compatible con la propiedad " + beanPropertyName, e );
			} catch (InvocationTargetException e) {
				throw new IllegalArgumentException("El tipo " + beanPropertyType.getClass() + " no es compatible con la propiedad " + beanPropertyName, e );
			}
		}

		return index;


	}

	/** Devuelve la colección agrupada por el índice */
	public static  <T extends Indexable<R>, R> Map<R, List<T>> group( Collection<T> col ) {

		Map<R, List<T>> index = new HashMap<R, List<T>>();
		if (col != null) {
			for (T ele : col) {

				if (!index.containsKey(ele.getIndex())) {
					index.put(ele.getIndex(), new ArrayList<T>());
				}
				index.get(ele.getIndex()).add(ele);

			}
		}

		return index;


	}

	/**
	 * Devuelve un índice para la colección
	 * @param col
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T, R> Map<R, List<T>> groupBy( Collection<T> col, R beanPropertyType, String beanPropertyName ) {

		try {

			Map<R, List<T>> index = new HashMap<R, List<T>>();

			if ((col != null) && (col.size() > 0)) {
				T first = col.iterator().next();
				PropertyDescriptor prop = BeanUtils.getPropertyDescriptor(first.getClass(), beanPropertyName);
				if ( prop == null ) {
					throw new IllegalArgumentException("No encontrada la propiedad " + beanPropertyName + " en " + first.getClass() );
				}
				Method getMethod = prop.getReadMethod();

				if (!getMethod.getReturnType().isAssignableFrom(beanPropertyType.getClass()) ) {
					throw new IllegalArgumentException("El tipo " + first.getClass() + " no es compatible con la propiedad " + beanPropertyName );
				}
				for (T ele : col) {

					R indexValue = (R) getMethod.invoke(ele);
					if (!index.containsKey(indexValue)) {
						index.put(indexValue, new ArrayList<T>());
					}
					index.get(indexValue).add(ele);
				}
			}
			return index;
		} catch (IllegalAccessException e) {
			throw new IllegalArgumentException("El tipo " + beanPropertyType.getClass() + " no es compatible con la propiedad " + beanPropertyName, e );
		} catch (InvocationTargetException e) {
			throw new IllegalArgumentException("El tipo " + beanPropertyType.getClass() + " no es compatible con la propiedad " + beanPropertyName, e );
		}



	}



}
