package es.caib.avaedi.at4forms.common.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Repository;

/**
 * Permite obtener servicios (beans) spring en cualquier entorno
 * Es necesario configurar el bean en spring, claro
 * @author agarcia
 *
 */
@Repository
public class ApplicationContextHolder implements ApplicationContextAware
{
    private static BeanFactory factory;
    private static ApplicationContextHolder context;

    private ApplicationContextHolder() {}

    public static ApplicationContextHolder getInstance ()
    {
        if ( context == null ) {
			context = new ApplicationContextHolder ();
		}
        return context;
    }

    /**
     * Fija el ApplicationContext
     * @see ApplicationContextAware#setApplicationContext(ApplicationContext)
     */
    public void setApplicationContext ( ApplicationContext applicationContext )
            throws BeansException
    {
    	factory = applicationContext;
    }

    /** Obtiene el bean de nombre serviceName
     *
     * @param serviceName
     * @return el bean de nombre serviceName
     */
    public Object getService ( String serviceName )
    {
        return ApplicationContextHolder.factory.getBean ( serviceName );
    }

    /** Obtiene el bean de nombre serviceName
    *
    * @param serviceName
    * @return el bean de nombre serviceName
    */
   public <T> T getBean ( String serviceName, Class<T> clazz )
   {
       return ApplicationContextHolder.factory.getBean ( serviceName, clazz);
   }
}