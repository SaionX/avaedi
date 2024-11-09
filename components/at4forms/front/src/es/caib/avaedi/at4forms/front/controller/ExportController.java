package es.caib.avaedi.at4forms.front.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.view.AbstractView;

import es.caib.avaedi.at4forms.common.exception.GenericBusinessException;
import es.caib.avaedi.at4forms.common.search.ResultadoExportacion;
import es.caib.avaedi.at4forms.common.util.log.LogService;
import es.caib.avaedi.front.service.general.FormDataService;

import org.slf4j.Logger;


/**
 * Controlador de la exportación de listados de formulario a a xls, csv y pdf
 * @author agarcia
 *
 */
@Controller("exportController")
public class ExportController extends AbstractController {

	public static final String REPORT_LIST_KEY = "resultados";
	public static final String REPORT_NUMRECORDS_KEY = "numRecords";
	public static final String REPORT_FIELDNAME_KEY = "campos";
	public static final String REPORT_HEADER_KEY = "cabecera";
	public static final String REPORT_COLTYPE_KEY = "tiposDeCampo";
	
	/**
	 * The logger object.
	 */
	private static Logger log = LogService.getLogger(ExportController.class);

	@Autowired
	private FormDataService formDataService;


	@SuppressWarnings({ "unchecked" })
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {

		log.debug("started handleRequestInternal");

		String uri = request.getRequestURI();
		String format = uri.substring(uri.lastIndexOf(".") + 1);

		//Permite incorporar nuevas exportaciones por service
		AbstractView view = this.formDataService.getExportFormat(request, format);
		
		if (view == null) {

			if (format.equals("xls")) {
				view = new ExcelView();
			} else if (format.equals("csv")) {
				view = new CsvView();
			} else if (format.equals("pdf")) {
				view = new PdfBasicView();
			} else if (format.equals("docx")) {
				view = new DocxBasicView();
			} else {
				String error = "formato " + format + " no soportado";
				log.error(error);
				throw new GenericBusinessException(error);
			}
			
		}

		log.debug("finished handleRequestInternal");
		return new ModelAndView(view, this.getModel(request));

	}

	@SuppressWarnings("rawtypes")
	protected Map getModel(HttpServletRequest request) throws GenericBusinessException {

		log.debug("started getModel");

		ResultadoExportacion resultadoExportacion = this.formDataService.getExportacion(request);

    	Map<String, Object> model = new HashMap<String, Object>();
    	model.put(REPORT_HEADER_KEY, resultadoExportacion.getCabeceras());
    	model.put(REPORT_COLTYPE_KEY, resultadoExportacion.getTiposCampo());
    	model.put(REPORT_FIELDNAME_KEY, resultadoExportacion.getCampos());
		model.put(REPORT_NUMRECORDS_KEY, resultadoExportacion.getResultados().size());
    	model.put(REPORT_LIST_KEY, resultadoExportacion.getResultados());

		log.debug("finished getModel");

    	return model;

	}


	/** Fija el bean FormDataService
	 * @param formDataService el bean FormDataService
	 */
	public void setFormDataService(FormDataService formDataService) {
		this.formDataService = formDataService;
	}

}
