package es.caib.avaedi.logic.util;

/*
 import org.hibernate.Hibernate;
 import org.hibernate.proxy.HibernateProxy;
 */
import es.caib.avaedi.at4forms.logic.vo.DefaultTransferObjectFactory;

public class TransferObjectFactory extends DefaultTransferObjectFactory {

	/**
	 * Problema con herencia, casts y proxies
	 * http://stackoverflow.com/questions/
	 * 8770124/hibernate-4-classcastexception-
	 * on-lazy-loading-while-eager-works-fine
	 * http://stackoverflow.com/questions/
	 * 2216547/converting-hibernate-proxy-to-real-object
	 * 
	 * Otra posible solución sería usar algo así:
	 * http://ganeshsubramanian.com/blog
	 * /2009/02/27/hibernate-inheritance-classcastexception-part-1/
	 * http://ganeshsubramanian
	 * .com/blog/2009/02/28/hibernate-inheritance-classcastexception-part-2/
	 * 
	 * @param <T>
	 * @param entity
	 * @return
	 * @SuppressWarnings("unchecked") private static <T> T
	 *                                initializeAndUnproxy(T entity) { if
	 *                                (entity == null) { throw new
	 *                                NullPointerException(
	 *                                "Entity passed for initialization is null"
	 *                                ); }
	 * 
	 *                                Hibernate.initialize(entity); if (entity
	 *                                instanceof HibernateProxy) { entity = (T)
	 *                                ((HibernateProxy)
	 *                                entity).getHibernateLazyInitializer()
	 *                                .getImplementation(); } return entity; }
	 */

}
