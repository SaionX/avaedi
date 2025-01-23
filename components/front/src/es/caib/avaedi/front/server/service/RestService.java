package es.caib.avaedi.front.server.service;

import io.swagger.annotations.Api;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.EntityTag;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.UriInfo;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import es.caib.avaedi.at4forms.common.exception.GenericBusinessException;
import es.caib.avaedi.at4forms.common.search.FilterConfig;
import es.caib.avaedi.at4forms.common.search.PagingConfig;
import es.caib.avaedi.at4forms.common.search.ResultadoBusqueda;
import es.caib.avaedi.at4forms.common.util.Constants;
import es.caib.avaedi.front.server.BaseRestService;
import es.caib.avaedi.front.server.RestServiceException;
import es.caib.avaedi.front.server.service.vo.EstadoInspeccionVO;
import es.caib.avaedi.front.server.service.vo.EstadoInspeccionVO.EdificioVO;
import es.caib.avaedi.logic.bo.DatosCatastroBO;
import es.caib.avaedi.logic.bo.EdificioBO;
import es.caib.avaedi.logic.bo.IslaBO;
import es.caib.avaedi.logic.bo.MunicipioBO;
import es.caib.avaedi.logic.bo.TipoViaBO;
import es.caib.avaedi.logic.bo.ViaBO;
import es.caib.avaedi.logic.server.vo.IslaRestVO;
import es.caib.avaedi.logic.server.vo.MunicipioRestVO;
import es.caib.avaedi.logic.server.vo.ViaRestVO;
import es.caib.avaedi.logic.vo.EdificioFormVO;
import es.caib.avaedi.logic.vo.EdificioSoapVO;
import es.caib.avaedi.logic.vo.InformeListadoVO;
import es.caib.avaedi.logic.vo.IslaListadoVO;
import es.caib.avaedi.logic.vo.MunicipioListadoVO;
import es.caib.avaedi.logic.vo.NumeroSoapVO;
import es.caib.avaedi.meh.catastro.CatastroSoapException;

import static es.caib.avaedi.at4forms.common.util.Constants.*;

/**
 * Servicio rest
 * 
 * @author garrom@at4.net
 * 
 */

@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
@Path("/v1")
@Component
@Api
public class RestService extends BaseRestService {

	/**
	 * @author agarcia
	 * @throws NamingException
	 */
	/* TODO: Comprobar que funciona en jboss simplemente con la solucion en setServletContext
	public RestService() throws NamingException {
		super();
		// Instanciar los Beans, si estamos en modo EJB
		if (RuntimeServerHelper.getInstance().isJBoss()) {
			//En jboss no tenemos jersey-spring y por tanto tenemos que cargar nosotros los beans
			InitialContext context = new InitialContext();
			municipioBO = (MunicipioBO) context.lookup("/avaedi/MunicipioBeanEjb/local");
			islaBO = (IslaBO) context.lookup("/avaedi/IslaBeanEjb/local");
			tipoViaBO = (TipoViaBO) context.lookup("/avaedi/TipoViaBeanEjb/local");
			viaBO = (ViaBO) context.lookup("/avaedi/ViaBeanEjb/local");
			informeBO = (InformeBO) context.lookup("/avaedi/InformeBeanEjb/local");
			edificioBO = (EdificioBO) context.lookup("/avaedi/EdificioBeanEjb/local");
			datosCatastroBO = (DatosCatastroBO) context.lookup("/avaedi/DatosCatastroBeanEjb/local");
		}
	}
	*/
	
	@Context
    public void setServletContext(ServletContext context) {
		WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(context);
		municipioBO = (MunicipioBO) applicationContext.getBean("MunicipioBean");
		islaBO = (IslaBO) applicationContext.getBean("IslaBean");
		tipoViaBO = (TipoViaBO) applicationContext.getBean("TipoViaBean");
		viaBO = (ViaBO) applicationContext.getBean("ViaBean");
		//informeBO = (InformeBO) applicationContext.getBean("InformeBean");
		edificioBO = (EdificioBO) applicationContext.getBean("EdificioBean");
		datosCatastroBO = (DatosCatastroBO) applicationContext.getBean("DatosCatastroBean");
    }	

	/**
	 * Beans para acceder para acceder a los metodos
	 */

	/**************************
	
	 MUY IMPORTANTE, 
	 No podemos usar jersey-spring3, pq no funciona en jboss5, así que NO USAMOS autowired. 
	 Se configuran los beans en setServletContext
	
	**************************/

	protected MunicipioBO municipioBO;
	protected IslaBO islaBO;
	protected TipoViaBO tipoViaBO;
	protected ViaBO viaBO;
	//protected InformeBO informeBO;
	protected EdificioBO edificioBO;
	protected DatosCatastroBO datosCatastroBO;

	protected ObjectMapper mapper = new ObjectMapper();

	@OPTIONS
	@Path("islas")
	public Response optionsIslas() {
		return Response.ok("").header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization").header("Access-Control-Allow-Credentials", "true").header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD").header("Access-Control-Max-Age", "1209600").header("x-frame-options", "SAMEORIGIN").build();
	}

	@GET
	@Path("islas")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getIslas(@Context Request request, @Context UriInfo uriInfo) throws GenericBusinessException {
		ResultadoBusqueda<IslaListadoVO> islas = islaBO.getListado();
		CacheControl cc = new CacheControl();
		cc.setPrivate(true);

		List<IslaRestVO> result = new ArrayList<IslaRestVO>();

		Date lastModDate = new Date(0);
		for (IslaListadoVO islaraw : islas.getResultados()) {
			if (islaraw.getLastModified().getTime() > lastModDate.getTime()) {
				lastModDate = islaraw.getLastModified();
			}
			result.add(new IslaRestVO(islaraw));
		}
		String etagS = this.buildEtag(uriInfo, "lastttime" + lastModDate.getTime());

		EntityTag etag = new EntityTag(etagS);
		ResponseBuilder builder = request.evaluatePreconditions(etag);
		// cached resource did change -> serve updated content
		if (builder == null) {
			builder = Response.ok(result);
		}
		builder.tag(etag);
		builder.cacheControl(cc);
		builder.header("Access-Control-Allow-Origin", "*");
		builder.header("x-frame-options", "SAMEORIGIN");
		return builder.build();
	}

	@OPTIONS
	@Path("municipios")
	public Response optionsMunicipios() {
		return Response.ok("").header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization").header("Access-Control-Allow-Credentials", "true").header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD").header("Access-Control-Max-Age", "1209600").header("x-frame-options", "SAMEORIGIN").build();
	}

	@GET
	@Path("municipios")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getMunicipios(@QueryParam("isla") String isla, @Context Request request, @Context UriInfo uriInfo) throws GenericBusinessException {

		List<FilterConfig> municipioFilters = new ArrayList<FilterConfig>();
		if (isla != null) {
			municipioFilters.add(new FilterConfig(FilterConfig.TYPE_LIST, "isla", isla));
		}
		PagingConfig paginacion = new PagingConfig();
		paginacion.setSort("nombre");
		ResultadoBusqueda<MunicipioListadoVO> municipios = municipioBO.getListado(municipioFilters, paginacion);

		List<MunicipioRestVO> result = new ArrayList<MunicipioRestVO>();

		Date lastModDate = new Date(0);
		for (MunicipioListadoVO municipioraw : municipios.getResultados()) {
			if (municipioraw.getLastModified().getTime() > lastModDate.getTime()) {
				lastModDate = municipioraw.getLastModified();
			}
			result.add(new MunicipioRestVO(municipioraw));
		}

		CacheControl cc = new CacheControl();
		cc.setPrivate(true);

		String etagS = this.buildEtag(uriInfo, "lastttime" + lastModDate.getTime());

		EntityTag etag = new EntityTag(etagS);
		ResponseBuilder builder = request.evaluatePreconditions(etag);
		// cached resource did change -> serve updated content
		if (builder == null) {
			builder = Response.ok(result);
		}
		builder.tag(etag);
		builder.cacheControl(cc);
		builder.header("Access-Control-Allow-Origin", "*");
		builder.header("x-frame-options", "SAMEORIGIN");
		return builder.build();
	}

	@OPTIONS
	@Path("vias")
	public Response optionsVias() {
		return Response.ok("").header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization").header("Access-Control-Allow-Credentials", "true").header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD").header("Access-Control-Max-Age", "1209600").header("x-frame-options", "SAMEORIGIN").build();
	}

	@GET
	@Path("vias")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getVias(@QueryParam("municipioId") String municipioId, @QueryParam("searchString") String query, @Context Request request, @Context UriInfo uriInfo) throws GenericBusinessException {
		List<FilterConfig> viaFilters = new ArrayList<FilterConfig>();

		if (municipioId != null) {
			viaFilters.add(new FilterConfig(FilterConfig.TYPE_LIST, "municipio.clave", municipioId));
		}
		if (query != null) {
			viaFilters.add(new FilterConfig(FilterConfig.TYPE_STRING, "nombre", "ilike", query));
		}

		PagingConfig paginacion = new PagingConfig();
		paginacion.setSort("nombre");
		ResultadoBusqueda<ViaRestVO> vias = viaBO.restListado(viaFilters, paginacion);

		List<ViaRestVO> result = new ArrayList<ViaRestVO>();

		Date lastModDate = new Date(0);
		for (ViaRestVO via : vias.getResultados()) {

			if (via.getLastModified().getTime() > lastModDate.getTime()) {
				lastModDate = via.getLastModified();
			}
			result.add(via);
		}

		CacheControl cc = new CacheControl();
		cc.setPrivate(true);

		String etagS = this.buildEtag(uriInfo, "lastttime" + lastModDate.getTime());

		EntityTag etag = new EntityTag(etagS);
		ResponseBuilder builder = request.evaluatePreconditions(etag);
		// cached resource did change -> serve updated content
		if (builder == null) {
			builder = Response.ok(result);
		}
		builder.tag(etag);
		builder.cacheControl(cc);
		builder.header("Access-Control-Allow-Origin", "*");
		builder.header("x-frame-options", "SAMEORIGIN");
		return builder.build();
	}

	@OPTIONS
	@Path("estadoInspeccion")
	public Response optionsEdificios() {
		return Response.ok("").header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization").header("Access-Control-Allow-Credentials", "true").header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD").header("Access-Control-Max-Age", "1209600").header("x-frame-options", "SAMEORIGIN").build();
	}

	@GET
	@Path("estadoInspeccion")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getEstadoInspeccion(@QueryParam("viaId") String viaId, @QueryParam("numeroCatastro") String numeroCatastro, @Context Request request, @Context UriInfo uriInfo) throws GenericBusinessException {

		List<FilterConfig> edificioFilters = new ArrayList<FilterConfig>();

		if (viaId != null) {
			edificioFilters.add(new FilterConfig(FilterConfig.TYPE_NUMERIC, "via.clave", viaId));
		}
		if (numeroCatastro != null) {
			edificioFilters.add(new FilterConfig(FilterConfig.TYPE_STRING, "numeroCatastro", numeroCatastro));
		}

		EstadoInspeccionVO result = new EstadoInspeccionVO();

		//1.- Buscamos edificios con datos en la BD
		ResultadoBusqueda<EdificioFormVO> res = edificioBO.getListadoCompleto(edificioFilters, new PagingConfig());
		Collection<EdificioFormVO> edificios = res.getResultados();

		boolean datosComunesSet = false;
		if (edificios.size() > 0) {

			for (EdificioFormVO edi : edificios) {

				if (!datosComunesSet) {
					//Cargamos los datos comunes del edificio cuyo número coincida con el del catastro
					result.setAntiguedad(edi.getAntiguedad());
					result.setCentroX(edi.getCentroX());
					result.setCentroY(edi.getCentroY());
					result.setReferenciaCatastral(result.getReferenciaCatastral());
					datosComunesSet = true;
				}
				result.setDireccion(edi.getViaLabel() + " " + edi.getNumeroCatastro());
				EdificioVO ediVO = new EdificioVO();
				this.setEstadoITE(ediVO, edi.getAntiguedad(), edi);
				ediVO.setNumeroExtra(edi.getNumeroExtra());
				result.getEdificios().add(ediVO);
			}

		} else {
			//Si en nuestra bd no tenemos los datos comunes, tenemos que buscarlos del catastro

			EdificioSoapVO resultado;
			try {
				resultado = datosCatastroBO.getEdificio(Integer.parseInt(viaId), numeroCatastro);
			} catch (NumberFormatException e) {
				throw new RestServiceException(500, "Ha introducido un viaId inválido.");
			} catch (CatastroSoapException e) {
				throw new RestServiceException(e.getCode(), e.getMsg());
			}
			
			result.setDireccion(resultado.getViaLabelEs() + " " + resultado.getNumeroCatastro());

			result.setAntiguedad(resultado.getAntiguedad());
			result.setReferenciaCatastral(resultado.getCodigoCatastroCorto());

			result.setCentroX(resultado.getCentroX());
			result.setCentroY(resultado.getCentroY());

			result.setReferenciaCatastral(result.getReferenciaCatastral());

			//Si no habíamos encontrado ningún edificio en nuestra bd
			EdificioVO ediVO = new EdificioVO();
			this.setEstadoITE(ediVO, result.getAntiguedad(), null);
			ediVO.setNumeroExtra(null);
			result.getEdificios().add(ediVO);

		}

		ResponseBuilder builder = Response.ok(result);

		builder.header("Access-Control-Allow-Origin", "*");
		builder.header("x-frame-options", "SAMEORIGIN");

		return builder.build();
	}

	@OPTIONS
	@Path("numeros")
	public Response optionsNumeros() {
		return Response.ok("").header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization").header("Access-Control-Allow-Credentials", "true").header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD").header("Access-Control-Max-Age", "1209600").header("x-frame-options", "SAMEORIGIN").build();
	}

	@GET
	@Path("numeros")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getNumeros(@QueryParam("municipioId") String municipioIdS, @QueryParam("viaId") String viaIdS, @QueryParam("searchString") String numero, @Context Request request, @Context UriInfo uriInfo) throws GenericBusinessException {
		CacheControl cc = new CacheControl();
		cc.setPrivate(true);
		Integer municipioId = null, viaId = null;
		try {
			if (municipioIdS != null) {
				municipioId = Integer.parseInt(municipioIdS);
			}
			viaId = Integer.parseInt(viaIdS);
		} catch (NumberFormatException e) {
			throw new RestServiceException(403, "Required params not send");
		}

		List<NumeroSoapVO> result;
		try {
			result = datosCatastroBO.getNumeros(municipioId, viaId, numero);
		} catch (CatastroSoapException e) {
			throw new RestServiceException(e.getCode(), e.getMsg());
		}

		ResponseBuilder builder = Response.ok(result);
		builder.header("Access-Control-Allow-Origin", "*");
		builder.header("x-frame-options", "SAMEORIGIN");
		return builder.build();

	}

	/* Calculadora!!

		La calculadora actual i d' acord a la normativa actual ha de calcular les següents dades:
			a) Quan he de fer la IAE (parcial) de 30 anys : als 30 anys de la data de construcció.
			b) Quan he de fer la IAE (completa) de 50 anys: als 50 anys de la data de construcció.
			c) Quan he de renovar la IAE que ja s' ha elaborat i registre a l' aplicació; als 10 anys de la data d' informe favorable.
	 */
	private void setEstadoITE(EdificioVO ediVO, Integer antiguedad, EdificioFormVO edi) {

		int plazoIte = 0;
//		String estatInspeccio = "Sense dades";

		Calendar calendar = Calendar.getInstance();
		int anyoActual = calendar.get(Calendar.YEAR);
		Integer anyUltimInformeFavorable = null;
		Integer estatUltimInforme = null;
		if (edi != null) {
			anyUltimInformeFavorable = edi.getAnyUltimInformeFavorable();
			estatUltimInforme = edi.getEstatUltimInforme();
		}

		int anyIeeParcial = antiguedad + PLAZO_IEE_PARCIAL;
		int anyIeeTotal = antiguedad + PLAZO_IEE_TOTAL;

		//Buscamos el año en que debe pasarse inspección (plazoIte)
		if (antiguedad == null || antiguedad == 0) {
			plazoIte = 0;
		} else if (anyoActual <= anyIeeParcial) {
			plazoIte = anyIeeParcial;
		} else if (anyoActual > anyIeeParcial && anyoActual <= anyIeeTotal) {
			if (anyUltimInformeFavorable < anyIeeParcial) {
				plazoIte = anyIeeParcial;
			} else if (anyUltimInformeFavorable < anyIeeParcial + PLAZO_IEE_SIG) {
				plazoIte = anyIeeParcial + PLAZO_IEE_SIG;
			} else {
				plazoIte = antiguedad + PLAZO_IEE_TOTAL;
			}
		} else { // (anyoActual > anyIeeTotal) {
			if (anyUltimInformeFavorable == null || anyUltimInformeFavorable < anyIeeTotal) {
				plazoIte = anyIeeTotal;
			} else {
				plazoIte = antiguedad + ((anyUltimInformeFavorable - antiguedad + PLAZO_IEE_SIG) / PLAZO_IEE_SIG) * PLAZO_IEE_SIG;
			}
		}

		if (estatUltimInforme != null) {
			if (estatUltimInforme == Constants.ESTADO_INFORME_FAVORABLE) {
				int anyoSiguienteInforme = anyUltimInformeFavorable + PLAZO_IEE_SIG;
				if (anyoSiguienteInforme > plazoIte) { //El informe mejora la fecha previa de plazo
					plazoIte = anyoSiguienteInforme;
				}
			}
		}


		// Generam el text a mostrar com a estat d'inspecció, i la propera data d'informe
		if (plazoIte == 0) {
			// Desconegut
			ediVO.setEstadoInspeccionCa("Sense dades");
			ediVO.setEstadoInspeccionEs("Sin datos");

			if (estatUltimInforme != null) {
				// Si plazoIte == 0, no tenim cap informe favorable
				if (estatUltimInforme == Constants.ESTADO_INFORME_EN_TRAMITE || estatUltimInforme == ESTADO_INFORME_EN_CURSO) {
					ediVO.setEstadoInspeccionCa("En tramitació");
					ediVO.setEstadoInspeccionEs("En tramitación");
				} else if (estatUltimInforme == Constants.ESTADO_INFORME_DESFAVORABLE) {
					ediVO.setEstadoInspeccionCa("Sense dades. Amb un últim informe desfavorable.");
					ediVO.setEstadoInspeccionEs("Sin datos. Con un último informe desfavorable.");
				}
			}

		} else if (plazoIte >= anyoActual) {
			// En termini
			ediVO.setEstadoInspeccionCa("En termini");
			ediVO.setEstadoInspeccionEs("En plazo");
			ediVO.setProximaIEE( plazoIte );

			if (estatUltimInforme != null) {
				if (estatUltimInforme == Constants.ESTADO_INFORME_FAVORABLE) {
					if (plazoIte > anyoActual) {
						ediVO.setEstadoInspeccionCa("Favorable");
						ediVO.setEstadoInspeccionEs("Favorable");
					} else if (plazoIte == anyoActual) {
						ediVO.setEstadoInspeccionCa("Favorable. A punt de caducar.");
						ediVO.setEstadoInspeccionEs("Favorable. A punto de caducar.");
					}
				} else if (estatUltimInforme == Constants.ESTADO_INFORME_EN_TRAMITE || estatUltimInforme == ESTADO_INFORME_EN_CURSO) {
					ediVO.setEstadoInspeccionCa("En tramitació");
					ediVO.setEstadoInspeccionEs("En tramitación");
				} else if (estatUltimInforme == Constants.ESTADO_INFORME_DESFAVORABLE) {
					ediVO.setEstadoInspeccionCa("En termini. Amb un últim informe desfavorable.");
					ediVO.setEstadoInspeccionEs("En plazo. Con un último informe desfavorable.");
				}
			}

		} else {
			//El plaç ha passadt
			ediVO.setEstadoInspeccionCa("No presentat. Es requereix la presentació immediata.");
			ediVO.setEstadoInspeccionEs("No presentado. Se requiere la presentación inmediata.");

			if (estatUltimInforme != null) {
				if (estatUltimInforme == Constants.ESTADO_INFORME_FAVORABLE) {
					ediVO.setEstadoInspeccionCa("Favorable caducada. Es requereix la presentació immediata.");
					ediVO.setEstadoInspeccionEs("Favorable caducado. Se requiere la presertación inmediate.");
					ediVO.setProximaIEE( anyoActual );
				} else if (estatUltimInforme == Constants.ESTADO_INFORME_EN_TRAMITE || estatUltimInforme == ESTADO_INFORME_EN_CURSO) {
					ediVO.setEstadoInspeccionCa("En tramitació");
					ediVO.setEstadoInspeccionEs("En tramitación");
					ediVO.setProximaIEE( anyoActual );
				} else if (estatUltimInforme == Constants.ESTADO_INFORME_DESFAVORABLE) {
					//Tenemos un informe desfavorable y el plazo caducado
					ediVO.setEstadoInspeccionCa("Desfavorable. Es requereix l'esmena immediata.");
					ediVO.setEstadoInspeccionEs("Desfavorable. Se requiere la enmienda inmediata.");
					ediVO.setProximaIEE( anyoActual );
				}
			}
		}

//		if (edi != null && estatUltimInforme != null) {
//			//Tenemos informe para el edificio
//			if (estatUltimInforme == Constants.ESTADO_INFORME_FAVORABLE) {
//				int anyoSiguienteInforme = anyUltimInformeFavorable + PLAZO_IEE_SIG;
//				if (anyoSiguienteInforme > plazoIte) { //El informe mejora la fecha previa de plazo
//					ediVO.setProximaIEE( anyoSiguienteInforme );
//					ediVO.setEstadoInspeccionCa("Favorable");
//					ediVO.setEstadoInspeccionEs("Favorable");
//				}
//			} else if (estatUltimInforme == Constants.ESTADO_INFORME_EN_TRAMITE) {
//				ediVO.setEstadoInspeccionCa("En tramitació");
//				ediVO.setEstadoInspeccionEs("En tramitación");
//				ediVO.setProximaIEE( anyoActual );
//			} else if (estatUltimInforme == Constants.ESTADO_INFORME_DESFAVORABLE) {
//				if (plazoIte < anyoActual) { //Tenemos un informe desfavorable y el plazo caducado
//					ediVO.setEstadoInspeccionCa("Desfavorable. Es requereix l'esmena immediata.");
//					ediVO.setEstadoInspeccionEs("Desfavorable. Se requiere la enmienda inmediata.");
//					ediVO.setProximaIEE(anyoActual);
//				} else {
//					ediVO.setEstadoInspeccionCa("En termini, amb un últim informe desfavorable.");
//					ediVO.setEstadoInspeccionEs("En plazo, con un último informe desfavorable.");
//				}
//			}
//		}
	}

}
