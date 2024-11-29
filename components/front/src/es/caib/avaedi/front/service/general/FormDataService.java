package es.caib.avaedi.front.service.general;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.directwebremoting.io.FileTransfer;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import es.caib.avaedi.at4forms.common.exception.GenericBusinessException;
import es.caib.avaedi.at4forms.common.exception.PrincipalException;
import es.caib.avaedi.at4forms.common.realm.BaseFrontPrincipal;
import es.caib.avaedi.at4forms.common.search.CriteriaUtils;
import es.caib.avaedi.at4forms.common.search.DatosExportacion;
import es.caib.avaedi.at4forms.common.search.FilterConfig;
import es.caib.avaedi.at4forms.common.search.PagingConfig;
import es.caib.avaedi.at4forms.common.search.ResultadoActualizacion;
import es.caib.avaedi.at4forms.common.search.ResultadoBusqueda;
import es.caib.avaedi.at4forms.common.search.ResultadoExportacion;
import es.caib.avaedi.at4forms.common.search.TipoCampoExportacion;
import es.caib.avaedi.at4forms.common.util.log.LogService;
import es.caib.avaedi.at4forms.front.service.BaseFormDataService;
import es.caib.avaedi.at4forms.front.service.FormService;
import es.caib.avaedi.at4forms.front.service.items.ContenidoFormulario;
import es.caib.avaedi.at4forms.logic.vo.FormVO;
import es.caib.avaedi.at4forms.logic.vo.ListadoVO;
import es.caib.avaedi.common.realm.Constants;
import es.caib.avaedi.front.config.AuthUtils;
import es.caib.avaedi.front.config.LocalAuthenticationProvider;
import es.caib.avaedi.logic.bo.ImportadorBO;
import es.caib.avaedi.logic.util.ArchivoDTO;
import es.caib.avaedi.logic.vo.ResultadoImportacionListadoVO;

@Service("FormDataService")
@RemoteProxy
public class FormDataService extends BaseFormDataService {

	private static Logger log = LogService.getLogger(FormDataService.class);

	@Autowired
	LocalAuthenticationProvider authProvider;

	public BaseFrontPrincipal getUsuari(HttpServletRequest request) throws PrincipalException {
		log.debug("FormDataService.getUsuari desde FormDataService");
		//return (BaseFrontPrincipal)request.getUserPrincipal();
		try {
			return authProvider.loadFromAuthenticatedRequest(request);
		} catch (GenericBusinessException e) {
			throw new PrincipalException(e);
		}
	}

	@Autowired
	@Qualifier("ImportadorBean")
	private ImportadorBO importadorBO;

	@RemoteMethod
	public ResultadoImportacionListadoVO importIee(FileTransfer fileIEE, FileTransfer filePDF, Date dataFirma, String tipusIEE, boolean renovacio, boolean subsana, HttpServletRequest request) throws GenericBusinessException {
		ResultadoImportacionListadoVO ret = new ResultadoImportacionListadoVO();
		BaseFrontPrincipal usuari = this.getUsuari(request);
		String municipioIdS = AuthUtils.municipioId(usuari);
		Integer municipioId = municipioIdS == null ? null : Integer.parseInt(municipioIdS);
		boolean validarMunicipio = usuari.isInRole(Constants.MUNICIPI);
		String user = usuari.getUsername();
		
		try {
			if (fileIEE == null) {
				throw new GenericBusinessException("No se ha enviado correctamente el archivo .iee");
			}
			if (filePDF == null) {
				throw new GenericBusinessException("No se ha enviado correctamente el archivo .pdf");
			}
			try {
				ArchivoDTO iee = new ArchivoDTO();
				iee.setFilename(fileIEE.getFilename());
				iee.setMimeType(fileIEE.getMimeType());
				iee.setStream(fileIEE.getInputStream());
				
				ArchivoDTO pdf = new ArchivoDTO();
				pdf.setFilename(filePDF.getFilename());
				pdf.setMimeType(filePDF.getMimeType());
				pdf.setStream(filePDF.getInputStream());
				
				ret = importadorBO.importarInforme(iee, pdf, user, validarMunicipio, municipioId, dataFirma, tipusIEE, renovacio, subsana);
			} catch (IOException e) {
				throw new GenericBusinessException("Error al abrir túnel de lectura de datos con los archivos subidos");
			}
		} catch (GenericBusinessException e) {
			ret.setCorrecto(false);
			ret.setErrorMsg(e.getMessage());
			ret.addException(e);
		} catch (Exception e) {
			log.error("Excepcion no controlada en la importacion", e);
			ret.setCorrecto(false);
			ret.setErrorMsg("Error inesperado, para más información, consulte la traza del error.");
			ret.addException(e);
		}
		return ret;
	}

	@RemoteMethod
	public ResultadoImportacionListadoVO importIte(FileTransfer filePDF, Date dataFirma, String numeroCadastre, boolean favorable, HttpServletRequest request) throws GenericBusinessException {
		ResultadoImportacionListadoVO ret = new ResultadoImportacionListadoVO();
		BaseFrontPrincipal usuari = this.getUsuari(request);
		String municipioIdS = AuthUtils.municipioId(usuari);
		Integer municipioId = municipioIdS == null ? null : Integer.parseInt(municipioIdS);
		boolean validarMunicipio = usuari.isInRole(Constants.MUNICIPI);
		String user = usuari.getUsername();


		try {
			if (filePDF == null) {
				throw new GenericBusinessException("No se ha enviado correctamente el archivo .pdf");
			}
			try {
				ArchivoDTO pdf = new ArchivoDTO();
				pdf.setFilename(filePDF.getFilename());
				pdf.setMimeType(filePDF.getMimeType());
				pdf.setStream(filePDF.getInputStream());

				ret = importadorBO.importarInformeIte(pdf, user, validarMunicipio, municipioId, dataFirma, numeroCadastre, favorable);
			} catch (IOException e) {
				throw new GenericBusinessException("Error al abrir túnel de lectura de datos con los archivos subidos");
			}
		} catch (GenericBusinessException e) {
			ret.setCorrecto(false);
			ret.setErrorMsg(e.getMessage());
			ret.addException(e);
		} catch (Exception e) {
			log.error("Excepcion no controlada en la importacion", e);
			ret.setCorrecto(false);
			ret.setErrorMsg("Error inesperado, para más información, consulte la traza del error.");
			ret.addException(e);
		}
		return ret;
	}

	@RemoteMethod
	public ResultadoImportacionListadoVO subsanacio(FileTransfer filePDF, Date dataFirma, String numeroCadastre, HttpServletRequest request) throws GenericBusinessException {
		ResultadoImportacionListadoVO ret = new ResultadoImportacionListadoVO();
		BaseFrontPrincipal usuari = this.getUsuari(request);
		String municipioIdS = AuthUtils.municipioId(usuari);
		Integer municipioId = municipioIdS == null ? null : Integer.parseInt(municipioIdS);
		boolean validarMunicipio = usuari.isInRole(Constants.MUNICIPI);
		String user = usuari.getUsername();

		try {
			if (filePDF == null) {
				throw new GenericBusinessException("No se ha enviado correctamente el archivo .pdf");
			}
			try {
				ArchivoDTO pdf = new ArchivoDTO();
				pdf.setFilename(filePDF.getFilename());
				pdf.setMimeType(filePDF.getMimeType());
				pdf.setStream(filePDF.getInputStream());

				ret = importadorBO.importarInformeSubsana(pdf, user, validarMunicipio, municipioId, dataFirma, numeroCadastre);
			} catch (IOException e) {
				throw new GenericBusinessException("Error al abrir túnel de lectura de datos con los archivos subidos");
			}
		} catch (GenericBusinessException e) {
			ret.setCorrecto(false);
			ret.setErrorMsg(e.getMessage());
			ret.addException(e);
		} catch (Exception e) {
			log.error("Excepcion no controlada en la importacion", e);
			ret.setCorrecto(false);
			ret.setErrorMsg("Error inesperado, para más información, consulte la traza del error.");
			ret.addException(e);
		}
		return ret;
	}

	@RemoteMethod
	public ResultadoImportacionListadoVO saveImport(Integer claveInforme, Integer estadoInformeId, String numeroExtra, Integer edificioAction) {
		ResultadoImportacionListadoVO ret = new ResultadoImportacionListadoVO();
		try {
			ret = importadorBO.saveImport(claveInforme, estadoInformeId, numeroExtra, edificioAction);
		} catch (GenericBusinessException e) {
			ret.setCorrecto(false);
			ret.setErrorMsg(e.getMessage());
		} catch (Exception e) {
			log.error("Excepcion no controlada en la importacion", e);
			ret.setCorrecto(false);
			ret.setErrorMsg("Error inesperado, para más información, consulte la traza pintada en consola.");
		}

		return ret;
	}
	
	@RemoteMethod
	public boolean cancelImport(Long claveInforme, HttpServletRequest request) throws GenericBusinessException {
		
		BaseFrontPrincipal usuari = this.getUsuari(request);
		
		String municipioIdS = AuthUtils.municipioId(usuari);
		
		Integer municipioId = municipioIdS == null ? null : Integer.parseInt(municipioIdS);
		
		boolean validarMunicipio = usuari.isInRole(Constants.MUNICIPI);
		
		return importadorBO.cancelImport(claveInforme, validarMunicipio, municipioId);
	}
	
	
	@RemoteMethod
	public ResultadoExportacion getInspeccionExportacion(HttpServletRequest request) throws GenericBusinessException {
		BaseFrontPrincipal usuari = getUsuari(request);
		Locale locale = this.getLocale(request);
		log.debug("started getInspeccionExportacion");
		ResultadoExportacion resultado = new ResultadoExportacion();
		//Array de forms que van a incluirse a esta exportacion.
		//NOTA: Deben ser 1-1 con inspeccion ya que los resultados se van a buscar por id de inspeccion.
		String[] formNames = {"accesibilidadpublicos", "accesibilidadvaloracionfinales","accesibilidadajustesrazonables","acusticas",
				"acusticadatosgenerales", "acusticavaloracionfinal", "acusticacomprobaciones", 
				"acusticaruidoinstalaciones", "acusticaruidosexteriores", "acusticaruidosinterioreshorizontales", "acusticaruidosinterioresverticales", 
				"acusticaruidosinterioresuniones", "cerramientoscubiertas", "instalaciones", "estructura", "eficienciasenergeticas",
				"cimentaciones", "conservacion"
		};
		
		FormService<?, ?, ?> inspeccion = this.getForm("inspeccion");
		Collection<FilterConfig> filtersi = null;
		PagingConfig pagingConfigi = new PagingConfig();
		
		//TODO: Usar estos filtros, comentados ahora porque para probar no hacemos un post y esto provoca nullpointer
		//Collection<FilterConfig> filters = getFilters(request);
		//PagingConfig pagingConfig = getPagingConfig(request);
		
		//Creo que esto ahora sobra y podria ser null
		List<String> camposAexportar = getCamposAexportar(request);
		ResultadoExportacion reInspeccion = inspeccion.getExportacion(filtersi, pagingConfigi, camposAexportar, getUsuari(request), this.getLocale(request));
		
		//Primero hacemos una exportacion normal de inspeccion y añadimos las cabeceras, campos y tiposcampos de los datos de importacion
		resultado.getCabeceras().addAll(reInspeccion.getCabeceras());
		resultado.getTiposCampo().addAll(reInspeccion.getTiposCampo());
		resultado.getCampos().addAll(reInspeccion.getCampos());
		
		
		//Iteramos todas las filas para coger todos los primeros valores, que son el ID
		List<List<String>> resultadosInspeccion = reInspeccion.getResultados();
		List<String> idsInspeccion = new ArrayList<String>();
		for(int i = 0; i < resultadosInspeccion.size(); i++){
			idsInspeccion.add(resultadosInspeccion.get(i).get(0));
		}

		List<ResultadoExportacion> subformsExport = new ArrayList<ResultadoExportacion>();
		
		//Iteramos todos los formnames para incluir todos los datos que nos interesan
		for(String formName : formNames){
			FormService<?, ?, ? > form = this.getForm(formName);
			//Por cada form diferente, cogemos los metadatos de columnas y demas y las añadimos a un objeto temporal de exportacion
			DatosExportacion datosExport = form.getDatosExportacion(locale);
			int cabsize = datosExport.getCabeceras().size();
			ResultadoExportacion ri = new ResultadoExportacion();
			ri.setCabeceras(datosExport.getCabeceras());
			ri.setCampos(datosExport.getCampos());
			ri.setResultados(new ArrayList<List<String>>());
			ri.setTiposCampo(datosExport.getTiposCampo());
			//Por cada id de cada fila, es decir, por cada inspeccion a exportar, cogeremos un elemento que le pertenece
			for(String id : idsInspeccion){
				//ListadoVO rowLVO = (ListadoVO) form.load(id, usuari, locale);
				ContenidoFormulario<?> data = form.load(id, usuari, locale);
				ListadoVO rowLVO = (ListadoVO) data.getData();
				List<String> rowdata = null;
				if(rowLVO == null){
					//Si el elemento es null, rellenamos un array de "n\a"
					rowdata = new ArrayList<String>();
					for(int ci = 0; ci<cabsize;ci++){
						rowdata.add("N\\A");
					}
				}else{
					//Si no es null, utilizamos este metodo que esta en cada service para rellenar el row
					rowdata = form.listadoToExportRow(rowLVO, locale);
				}
				//Una vez tenemos el row rellenado y los campos metidos en la exportacion, tambien metemos en el temporal de exportacion
				ri.getResultados().add(rowdata);
			}
			//Añadimos el temporal de exportacion al array de temporales
			subformsExport.add(ri);
		}
		
		//Iteramos todos los temporales para concatenar cabeceras, tipos y campos
		for(ResultadoExportacion ri : subformsExport){
			resultado.getCabeceras().addAll(ri.getCabeceras());
			resultado.getTiposCampo().addAll(ri.getTiposCampo());
			resultado.getCampos().addAll(ri.getCampos());
		}
		
		//Inicializamos los resultados de la exportacion
		resultado.setResultados(new ArrayList<List<String>>());
		
		
		//Iteramos los resultados empezando por las columnas de la exportacion de inspeccion
		//Como es la base y las demas dependen de estos datos, podemos estar seguro de que no habra inconsistencia
		for(int x = 0; x < reInspeccion.getResultados().size(); x++){
			List<String> grupoy = new ArrayList<String>();
			//Añadimos a la fila de la exportacion principal las celdas de inspeccion
			grupoy.addAll(reInspeccion.getResultados().get(x));
			for(int y = 0; y < subformsExport.size(); y++){
				//iteramos las otras exportaciones para añadir a la fila sus celdas
				List<String> rawgrupoz = subformsExport.get(y).getResultados().get(x);
				grupoy.addAll(rawgrupoz);
			}
			//Una vez tenemos todas las celdas añadidas a la fila, añadimos la fila al grupo de filas de la exportacion
			resultado.getResultados().add(grupoy);
			
		}
		

		log.debug("finished getInspeccionExportacion");
		return resultado;
		
	}

	@Override
	@RemoteMethod
	public ResultadoBusqueda<Map<String, String>> getRelationPopupData(String formName, String query, Collection<FilterConfig> extraFilters, HttpServletRequest request, ServletContext context) throws GenericBusinessException {

		//NOTA: implementar aquí para personalizar un relationpopup 

		/*
		 * PagingConfig order = new PagingConfig(); List<Map<String, String>>
		 * resultados = new ArrayList<Map<String, String>>(); Map<String,
		 * String> resultado = null;
		 * 
		 * Collection<FilterConfig> filters = new ArrayList<FilterConfig>();
		 * FilterConfig filter = null; filter = new
		 * FilterConfig(FilterConfig.TYPE_STRING, null, null, query); if ((query
		 * != null) && !query.equals("")) { filters.add(filter); } if
		 * (extraFilters != null && extraFilters.size() > 0) {
		 * filters.addAll(extraFilters); }
		 * 
		 * if(formName.equals("PedidoTipoCorteProducto")){
		 * ResultadoBusqueda<ProductoListadoVO> items =
		 * this.productoBO.getListado(filters, order);
		 * Iterator<ProductoListadoVO> iter = items.getResultados().iterator();
		 * ProductoListadoVO entity = null; while (iter.hasNext()) { entity =
		 * iter.next(); for(TipoCorteListadoVO i : entity.getTipoCortes()){
		 * resultado = new HashMap<String, String>(); resultado.put("ID",
		 * String.valueOf(i.getId())); resultado.put("DISPLAY",
		 * i.getPrimaryLabel()); resultado.put("producto",
		 * String.valueOf(entity.getId())); resultados.add(resultado); } }
		 * return new ResultadoBusqueda<Map<String, String>>(resultados); }
		 */

		return super.getRelationPopupData(formName, query, extraFilters, request, context);
	}

}
