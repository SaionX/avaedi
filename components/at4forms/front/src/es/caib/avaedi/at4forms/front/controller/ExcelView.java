package es.caib.avaedi.at4forms.front.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import es.caib.avaedi.at4forms.common.search.TipoCampoExportacion;
import es.caib.avaedi.at4forms.common.util.log.LogService;

import org.slf4j.Logger;



/**
 * Vista que implementa un exportador a xls
 * @author agarcia
 *
 */
public class ExcelView extends AbstractExcelView {

	/**
	 * The logger object.
	 */
	private static Logger log = LogService.getLogger(ExcelView.class);


	@SuppressWarnings("unchecked")
	@Override
	protected void buildExcelDocument(@SuppressWarnings("rawtypes") Map model,
            HSSFWorkbook workbook,
            HttpServletRequest request,
            HttpServletResponse response) {

		log.debug("started buildExcelDocument");

	    HSSFSheet sheet = workbook.createSheet("Resultados");
	    sheet.setDefaultColumnWidth(12);

		List<String> cabeceras = (List<String>)model.get(ExportController.REPORT_HEADER_KEY);

	    //Vamos imprimir la cabecera
	    short currentRow = 0;
	    short currentCol = 0;

	    //Creamos el estilo para la cabecera
	    HSSFFont font = workbook.createFont();
	    font.setFontHeightInPoints((short)10);
	    font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
	    font.setColor(HSSFColor.BLACK.index);
	    HSSFCellStyle cabStyle = workbook.createCellStyle();
	    cabStyle.setFont(font);
	    cabStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
	    cabStyle.setBottomBorderColor(HSSFColor.BLACK.index);
	    cabStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
	    cabStyle.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);

	    Iterator<String> cabIter = cabeceras.iterator();
	    while (cabIter.hasNext()) {
		    this.setText(this.getCell(sheet, currentRow, currentCol), cabIter.next());
		    this.getCell(sheet, currentRow, currentCol).setCellStyle(cabStyle);
		    currentCol++;
	    }

	    //Vamos a imprimir el contenido
	    List<List<String>> resultados = (List<List<String>>)model.get(ExportController.REPORT_LIST_KEY);
	    Iterator<List<String>> filasIter = resultados.iterator();
	    List<TipoCampoExportacion> tiposCampo = (List<TipoCampoExportacion>)model.get(ExportController.REPORT_COLTYPE_KEY);

	    DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
	    HSSFCellStyle cellDateStyle = workbook.createCellStyle();
	    cellDateStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("d-mmm-yy"));

	    //cellDateStyle.setDataFormat( new SimpleDateFormat());

	    int maxCol = tiposCampo.size()-1;
	    while (filasIter.hasNext()) {
	    	currentRow++;
	    	currentCol = 0;
	    	Iterator<String> colIter = filasIter.next().iterator();
	    	while (colIter.hasNext()) {
		      String valor = colIter.next();
		      TipoCampoExportacion tipoDeCampo = null;
	    	  //Seguro para evitar incurrir en IndexOutOfBoundsException cuando hay errores en quien genere el excel
	    	  if (currentCol > maxCol) {
	    		  log.error("Parece que hay más columnas en datos que en tipos de campo");
		    	  tipoDeCampo = TipoCampoExportacion.STRING;
	    	  } else {
		    	  tipoDeCampo = tiposCampo.get(currentCol);
	    	  }
		      if ((valor != null) && !valor.equals("")) {
			      if (tipoDeCampo.equals(TipoCampoExportacion.NUMBER)) {
			    	  try {
			    		  if (!valor.equals("null")) {
			    			  this.getCell(sheet, currentRow, currentCol).setCellValue(Double.parseDouble(valor));
			    		  }
			    	  } catch (java.lang.NumberFormatException ne) {
			    		  log.error(ne.getMessage(), ne);
			    	  }
			      } else if (tipoDeCampo.equals(TipoCampoExportacion.DATE)) {
			    	  try {
						this.getCell(sheet, currentRow, currentCol).setCellValue(format.parse(valor));
						this.getCell(sheet, currentRow, currentCol).setCellStyle(cellDateStyle);
					} catch (ParseException e) {
						log.error("Imposible parsear valor '" + valor + "' como fecha, incluyéndolo como texto");
						this.setText(this.getCell(sheet, currentRow, currentCol), valor);
					}
			      } else {
			    	  this.setText(this.getCell(sheet, currentRow, currentCol), valor);
			      }
		      }
		      currentCol++;

	    	}
	    }

	    int maxNumRecords = (Integer)model.get(ExportController.REPORT_NUMRECORDS_KEY);
	    if (maxNumRecords > resultados.size()) {

	  	    this.setText(this.getCell(sheet, ++currentRow, 0),
	  	    		  "Máximo número de registros sobrepasado, " +
	  	    		  "se muestran los primeros " + resultados.size() +
	  	    		  " de un total de " + maxNumRecords
	  	    		  );
		    HSSFFont warnFont = workbook.createFont();
		    warnFont.setFontHeightInPoints((short)10);
		    warnFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		    warnFont.setColor(HSSFColor.RED.index);

	  	    HSSFCellStyle warnStyle = workbook.createCellStyle();
	  	    warnStyle.setFont(warnFont);
	  	    warnStyle.setFillForegroundColor(HSSFColor.YELLOW.index);
	  	    warnStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
	  	    this.getCell(sheet, currentRow, 0).setCellStyle(warnStyle);
	    }

		log.debug("finished buildExcelDocument");

	}



}
