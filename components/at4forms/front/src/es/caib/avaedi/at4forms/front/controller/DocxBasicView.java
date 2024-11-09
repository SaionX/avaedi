package es.caib.avaedi.at4forms.front.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblBorders;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase;


import es.caib.avaedi.at4forms.common.exception.GenericBusinessException;
import es.caib.avaedi.at4forms.common.search.TipoCampoExportacion;

public class DocxBasicView extends DocxAbstractView {

	private final static String BASE_TEMPLATE = "es/caib/avaedi/at4forms/front/controller/resources/DocxBasicView.docx";
	
	@Override
	@SuppressWarnings("unchecked")
	protected XWPFDocument getRecordTemplate(Map<String, Object> model) throws GenericBusinessException {

		List<String> cabeceras = (List<String>)model.get(ExportController.REPORT_HEADER_KEY);
		int numCols = cabeceras.size();
		List<List<String>> resultados = (List<List<String>>)model.get(ExportController.REPORT_LIST_KEY);
	    List<TipoCampoExportacion> tiposCampo = (List<TipoCampoExportacion>)model.get(ExportController.REPORT_COLTYPE_KEY);
	    List<String> campos = (List<String>)model.get(ExportController.REPORT_FIELDNAME_KEY);

		float[] tableNumChars = new float[numCols ];
		this.calculaCabeceras(cabeceras, tableNumChars);
		this.calculaContenidos(resultados, tableNumChars);
		
		try {
			return this.creaPlantillaRegistro(cabeceras, campos, tiposCampo, tableNumChars);
		} catch (IOException e) {
			throw new GenericBusinessException("Imposible crear plantilla docx, el sistema informa del error: " + e.getMessage(), e);
		}
	}

	private XWPFTable addTable (XWPFDocument doc, Integer rowCols) {
		XWPFParagraph p = doc.createParagraph();
		XWPFRun r = p.createRun();
        r.setText(System.lineSeparator());
		//XWPFTable table = p.getBody().insertNewTbl(p.getCTP().newCursor());

        if (rowCols > 1) {
    		XWPFTable table = doc.createTable(1, rowCols);
    		CTTblPrBase tblpro = table.getCTTbl().addNewTblPr();
    		CTTblBorders borders = tblpro.addNewTblBorders();
    		
    		borders.addNewBottom().setNil();
    		borders.addNewInsideH().setNil();
    		borders.addNewInsideV().setNil();
    		borders.addNewLeft().setNil();
    		borders.addNewRight().setNil();
    		borders.addNewTop().setNil();

    		//CTTblWidth width = tblpro.addNewTblW();
    		//width.setType(STTblWidth.DXA);
    		//width.setW(BigInteger.valueOf(100));
    		//table.createRow();
    		//XWPFTable table = doc.createTable(1, rowCols);
    		return table;
        } else {
        	return null;
        }
	}
	
	private XWPFDocument creaPlantillaRegistro(List<String> cabeceras,
			List<String> campos, List<TipoCampoExportacion> tiposCampo,
			float[] tableNumChars) throws IOException {

		//Pre-calculamos las filas
		Integer[] rowCols = this.calcularFilas(campos, tiposCampo, tableNumChars);
		
		String templateFilePath = this.getClass().getClassLoader().getResource(BASE_TEMPLATE).getFile();
		XWPFDocument doc = new XWPFDocument(new FileInputStream(templateFilePath));

		int fieldNum = 0;
		int currentCol = 0;
		int currentRow = 0;
		XWPFTable table = this.addTable(doc, rowCols[currentRow]);


		Map<String, Integer> auditFields = new HashMap<String, Integer>();
		
		for (String campo : campos) {

			if ( isAuditField(campo)) {
				auditFields.put(campo, fieldNum);
				fieldNum++;
				continue;
			}
			
			if ( currentCol >= rowCols[currentRow]) {
				//Tenemos que crear una nueva tabla
				currentRow++;
				table = this.addTable(doc, rowCols[currentRow]);
				currentCol = 0;
			}

			XWPFTableCell currentCell = null;
			if (table != null) {
				currentCell = table.getRow(0).getCell(currentCol);
			}

			XWPFParagraph p1;
			XWPFParagraph p2;
			
			if (currentCell != null) {
				//Estamos en una tabla
				p1 = currentCell.getParagraphs().get(0);
			} else {
				p1 = doc.createParagraph();
			}

			String cabecera = cabeceras.get(fieldNum);
			XWPFRun r1 = p1.createRun();
	        r1.setBold(true);
	        r1.setText(cabecera.toUpperCase());
	        r1.setItalic(false);
	        r1.setFontFamily("Arial");
	        r1.setUnderline(UnderlinePatterns.DOTTED);
	        
			if (currentCell != null) {
				//Estamos en una tabla
		        p2 = currentCell.addParagraph();
			} else {
				p2 = doc.createParagraph();
			}
		
			XWPFRun r2 = p2.createRun();
			r2.setBold(false);
			r2.setText("$" + campo + "$");
			r2.setItalic(false);
			r2.setFontFamily("Arial");
			
			currentCol++;
			fieldNum++;
			
		}
		
		XWPFParagraph aud = doc.createParagraph();
		//Campos de auditoría
		XWPFRun r1 = aud.createRun();
		r1.addBreak();
		r1.addBreak();
		for (String campo : new String[]{"dateCreation", "lastModified", "modUser", "creatorUser"}) {
			if (!auditFields.containsKey(campo)) {
				continue;
			}
			int fieldIdx = auditFields.get(campo);
			r1.setText(cabeceras.get(fieldIdx) + ": " + "$" + campo + "$");
			r1.addBreak();
		}
		r1.addBreak();
        r1.setItalic(true);
        r1.setFontFamily("Arial");
        r1.setFontSize(9);

        XWPFParagraph last = doc.createParagraph();
		last.setPageBreak(true);
		
		return doc;
	}

	private Integer[] calcularFilas(List<String> campos, List<TipoCampoExportacion> tiposCampo, float[] tableNumChars) {

		int MAX_WIDTH = 100, COL_OVERHEAD = 10;
		int currentCol = 0;
		int currentWidth = 0;
		int fieldNum = 0;
		
		List<Integer> rows = new ArrayList<Integer>();

		for (String campo : campos) {

			if ( isAuditField(campo)) {
				fieldNum++;
				continue;
			}
			
			float fieldW = tableNumChars[fieldNum];
			
			if ( currentCol > 0 && (currentWidth + fieldW) > MAX_WIDTH) {
				//Tenemos que crear una nueva tabla
				rows.add(currentCol); //número de columnas para la fila anterior
				currentCol = 1;
				currentWidth = 0;
			} else {
				currentCol++;
			}
			currentWidth += fieldW + COL_OVERHEAD;
			fieldNum++;
			
		}
		rows.add(currentCol); //número de columnas para la última fila
		return rows.toArray(new Integer[rows.size()]);
	}

	private boolean isAuditField(String campo) {
		
		return campo.equals("dateCreation") || campo.equals("lastModified") || campo.equals("modUser") || campo.equals("creatorUser");
	}

	private void calculaCabeceras(List<String> cabeceras, float[] tableNumChars) {

		int currentCol = 0;
    	for (String cabecera : cabeceras) {
			//Anotamos el ancho para después redimensionar
    		if (cabecera != null) {
        		tableNumChars[currentCol] = cabecera.length();
    		}
			currentCol++;
	    }
		
	}
	
	private void calculaContenidos(List<List<String>> resultados, float[] tableNumChars) {

		//Vamos a imprimir el contenido
    	int currentCol = 0;
	    for (List<String> fila : resultados) {
	    	currentCol = 0;
	    	for (String valor : fila) {
	    		if (valor != null) {
	        		tableNumChars[currentCol] = Math.max(valor.length(), tableNumChars[currentCol]);
	    		}
  		      currentCol++;
	    	}
	    }
		
	}
	

}
