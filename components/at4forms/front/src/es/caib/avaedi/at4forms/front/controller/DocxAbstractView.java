package es.caib.avaedi.at4forms.front.controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.xmlbeans.XmlException;
import org.springframework.web.servlet.view.AbstractView;

import org.slf4j.Logger;

import es.caib.avaedi.at4forms.common.exception.GenericBusinessException;
import es.caib.avaedi.at4forms.common.util.log.LogService;
import es.caib.avaedi.at4forms.front.util.ImageUtil;


public abstract class DocxAbstractView extends AbstractView {

	/**
	 * The logger object.
	 */
	private static Logger log = LogService.getLogger(DocxAbstractView.class);
	
	public DocxAbstractView() {
		setContentType(ImageUtil.MIME_TYPES.get("docx"));
	}

	@Override
	protected boolean generatesDownloadContent() {
		return true;
	}
	
	@Override
	protected final void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {

		ByteArrayOutputStream baos = createTemporaryOutputStream();
		
		XWPFDocument doc = this.buildDocxDocument(model);
		if (doc != null) {
			doc.write(baos);
		}

		writeToResponse(response, baos);
	}

	protected XWPFDocument buildDocxDocument (Map<String, Object> model) throws GenericBusinessException {
		
		@SuppressWarnings("unchecked")
		List<String> campos = (List<String>) model.get(ExportController.REPORT_FIELDNAME_KEY);
		@SuppressWarnings("unchecked")
		List<List<String>> resultados = (List<List<String>>) model.get(ExportController.REPORT_LIST_KEY);
		
		if (resultados.size() < 1) {
			return new XWPFDocument(); //Si no hay resultados, devolvemos un documento vacío 
		}
		
		//"precompilamos" la plantilla. Esto significa calcular los campos existentes
		XWPFDocument template = this.getRecordTemplate(model);
		String fullTemplateText = new XWPFWordExtractor(template).getText();
		Set<String> camposExistentes = new HashSet<String>(); //Es importante que esté ordenado
		String marca;
		for (String campo : campos) {
			marca = "$" + campo + "$";
			if (fullTemplateText.contains(marca)) {
				camposExistentes.add(campo);
			}
		}

		byte[] templateBytes = null;
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			template.write(baos);
			templateBytes = baos.toByteArray();
		} catch (IOException e) {
			log.error(e.getMessage(), e);
			throw new GenericBusinessException("Error cargando bytes de la plantilla", e);
		}

		XWPFDocument ret = null;
		Map<String, String> record;

		for (List<String> datosRegistro : resultados ) {
			record = new HashMap<String, String>();
			int i = 0;
			for (String campo : campos) {
				if (camposExistentes.contains(campo)) {
					record.put(campo, datosRegistro.get(i));
				}
				i++;
			}
			XWPFDocument recordDoc = this.buildDocxRecordDocument(templateBytes, record);
			if (ret == null) {
				ret = recordDoc;
			} else {
				try {
					DocxParser.append(ret, recordDoc);
				} catch (XmlException e) {
					log.error(e.getMessage(), e);
					throw new GenericBusinessException("Error concatenando plantillas docx", e);
				}
			}
			
		}
		
		return ret;
		
	}
	
	private XWPFDocument buildDocxRecordDocument(byte[] templateBytes, Map<String, String> record) throws GenericBusinessException {

		try {
			return this.apply2template(templateBytes, record);
		} catch (IOException e) {
			log.error(e.getMessage(), e);
			throw new GenericBusinessException(e);
		}

	}
	
	/**
	 * Reemplaza los datos del registro en la plantilla
	 * @param doc
	 * @param record
	 * @return 
	 * @throws IOException 
	 */
	private XWPFDocument apply2template(byte[] templateBytes, Map<String, String> record) throws IOException {

		XWPFDocument ret = new XWPFDocument(new ByteArrayInputStream(templateBytes));
		DocxParser.replaceText(ret, record);
		return ret;
		
	}

	/**
	 * Devuelve la plantilla docx, puede ser estática o generada al vuelo para el modelo 
	 * @param model
	 * @return
	 * @throws GenericBusinessException
	 */
	protected abstract XWPFDocument getRecordTemplate(Map<String, Object> model) throws GenericBusinessException;

}
