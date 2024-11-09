package es.caib.avaedi.at4forms.front.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import org.slf4j.Logger;

import es.caib.avaedi.at4forms.common.exception.GenericBusinessException;
import es.caib.avaedi.at4forms.common.util.StringUtils;
import es.caib.avaedi.at4forms.common.util.log.LogService;
import es.caib.avaedi.at4forms.front.util.Util;
import es.caib.avaedi.front.service.general.FormDataService;

/**
 * Controlador de la descarga de documentos
 * @author agarcia
 *
 */
@Controller("documentController")
public class DocumentController extends AbstractController {

	/**
	 * Bean para acceder a los métodos de servicio: FormDataService
	 */
	@Autowired
	private FormDataService formDataService;

	/**
	 * The logger object.
	 */
	private static Logger log = LogService.getLogger(DocumentController.class);

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws ServletException {

		log.debug("petición archivo INI");

		try {
			DocumentDownload archivo = this.formDataService.obtenerDocumento(request.getParameter("docname"), request.getParameter("objectId"), request);
			
			boolean inlineMode = !StringUtils.isEmpty(request.getParameter("mode")) && request.getParameter("mode").equals("inline");  

			if(archivo == null){

				response.sendError(HttpServletResponse.SC_NOT_FOUND);

			} else {
				// some response headers
				response.setHeader("Expires", "0");
				response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
				response.setHeader("Pragma", "public");
				// setting the content type
				response.setContentType(archivo.getMime());

				String ext = "";
				if (Util.MIME.contains(archivo.getMime())){
					ext += "." + Util.EXTENSIONS.elementAt(Util.MIME.indexOf(archivo.getMime()));
				}

				if (!inlineMode) {
					response.setHeader("Content-Disposition", "attachment; filename= " +
						archivo.getFilename() +
						ext);
				}
				//Adjuntamos el archivo a la respuesta
				ServletOutputStream stream = null;
				stream = response.getOutputStream();
				stream.write(archivo.getData());
				stream.close();
				
			}
			

		} catch (GenericBusinessException e) {
        	log.error(e.getMessage(), e);
        	throw new ServletException(e.getMessage());
		} catch (IOException e) {
        	log.error(e.getMessage(), e);
        	throw new ServletException(e.getMessage());
		}

        log.debug("petición archivo FIN");

        return null;

	}



}
