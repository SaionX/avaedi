package es.caib.avaedi.front.server;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.media.multipart.MultiPartFeature;

import es.caib.avaedi.front.server.service.RestService;
import es.caib.avaedi.front.server.service.RestTestService;

/**
 */
public class RestApplication extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> s = new HashSet<Class<?>>();
		s.add(MultiPartFeature.class);
		s.add(ApiListingResource.class);
		s.add(SwaggerSerializers.class);
		s.add(RestService.class);
		s.add(RestTestService.class);
		//s.add(CorsResponseFilter.class);
		//s.add(es.caib.avaedi.logic.vo.PedidoFormVO.class);
		return s;
	}

	public RestApplication() {
		BeanConfig beanConfig = new BeanConfig();
		beanConfig.setVersion("1.0.2");
		beanConfig.setSchemes(new String[] { "http" });
		//TODO: ¿esto no debería ser dinámico?
		beanConfig.setHost("dgtic.in.at4.net:9090");
		beanConfig.setBasePath("/avaediback/rest");
		beanConfig.setResourcePackage("es.caib.avaedi.front.server.service");
		beanConfig.setScan(true);

	}

}