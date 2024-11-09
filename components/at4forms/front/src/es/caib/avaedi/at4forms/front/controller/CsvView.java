package es.caib.avaedi.at4forms.front.controller;

import java.io.PrintWriter;
import java.io.Serializable;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractView;

import es.caib.avaedi.at4forms.common.util.log.LogService;

import org.slf4j.Logger;



/**
 * Vista que implementa un exportador a csv
 * @author agarcia
 *
 */
public class CsvView extends AbstractView implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -5130833055010431708L;

	/**
	 * The logger object.
	 */
	private static Logger log = LogService.getLogger(CsvView.class);


	@SuppressWarnings("unchecked")
	@Override
	protected void renderMergedOutputModel(@SuppressWarnings("rawtypes") Map model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		log.debug("started renderMergedOutputModel");
		this.setContentType("text/csv");
        response.setHeader("Cache-Control", "store");
        response.setHeader("Pragma", "cache");

        String filename = request.getParameter("filename");
        if ((filename == null) || filename.equals("null")) { // problema ie7
        	filename = "exportar";
        }
        if ((filename != null) && !filename.equals("")) {
        	String headerExt =  "attachment; filename=" + URLEncoder.encode(filename, response.getCharacterEncoding()) + ".csv";
        	response.setHeader("Content-Disposition", headerExt);
        } else {
        	response.setHeader("Content-Disposition", "attachment;");
        }

        PrintWriter out = response.getWriter();
	    StringBuffer linea;

        List<String> cabeceras = (List<String>)model.get(ExportController.REPORT_HEADER_KEY);

	    //Vamos imprimir la cabecera
	    short currentRow = 0;
	    short currentCol = 0;

	    Iterator<String> cabIter = cabeceras.iterator();

	    linea = new StringBuffer();
	    while (cabIter.hasNext()) {
	    	linea.append(stringToCsv(cabIter.next()));
	    	linea.append(";");
		    currentCol++;
	    }
        out.println(linea.toString());

	    //Vamos a imprimir el contenido
	    List<List<String>> resultados = (List<List<String>>)model.get(ExportController.REPORT_LIST_KEY);
	    Iterator<List<String>> filasIter = resultados.iterator();
	    //List<String> tiposCampo = (List<String>)model.get(REPORT_COLTYPE_KEY);

	    //DateFormat format = new SimpleDateFormat("dd/MM/yyyy");

	    while (filasIter.hasNext()) {
	    	currentRow++;
	    	currentCol = 0;
	    	Iterator<String> colIter = filasIter.next().iterator();
	    	linea = new StringBuffer();
	    	while (colIter.hasNext()) {
		      //String tipoDeCampo = tiposCampo.get(currentCol);
		      String valor = colIter.next();
		      linea.append(stringToCsv(valor));
		      linea.append(";");
		      currentCol++;
	    	}
		    out.println(linea.toString());
	    }


	    int maxNumRecords = (Integer)model.get(ExportController.REPORT_NUMRECORDS_KEY);
	    if (maxNumRecords > resultados.size()) {

		    out.println("Máximo número de registros sobrepasado, " +
	  	    		  "se muestran los primeros " + resultados.size() +
	  	    		  " de un total de " + maxNumRecords
	  	    		  );
	    }

		log.debug("finished renderMergedOutputModel");

	}


	/**
    * Convierte una cadena para que pueda ser escrita en un archivo csv
    *
    */
	public static String stringToCsv (String str) {
       if (str == null) {
           return "";
       } else if (str.equals("null")) {
    	   return "";
       } else {
           String ret = str.replaceAll("\"", "\"\"");
           ret = ret.replaceAll("\r\n", "\n");
           ret = ret.replaceAll("\n\r", "\n");
           return "\"" + ret + "\"";
       }
   }

}
