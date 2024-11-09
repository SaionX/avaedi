/**
 * 
 */
package es.caib.avaedi.at4forms.front.controller;

import java.awt.Color;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import es.caib.avaedi.at4forms.common.search.TipoCampoExportacion;
import es.caib.avaedi.at4forms.common.util.log.LogService;

import org.slf4j.Logger;

/**
 * @author agarcia
 *
 */
public class PdfBasicView extends AbstractPdfView {

	/** ancho mínimo para las columnas */
	private final float MIN_WIDTH = 30;
	
	/**
	 * The logger object.
	 */
	private static Logger log = LogService.getLogger(PdfBasicView.class);

	@Override
	protected Document newDocument() {
	  Document document = new Document(PageSize.A4.rotate());
	  return document;
	}
	
	public PdfBasicView () {
		setContentType("application/pdf");
	}

	@Override
    protected boolean generatesDownloadContent() {
        return true;
    }
	
	@Override
	protected void buildPdfMetadata(Map<String, Object> model, Document document, HttpServletRequest request) {
		
		//En buildPdfDocument no podemos cambiar el ancho de página puesto que AbstractPdfView ha efecutado el document.open antes
		//Así que creamos aquí la tabla que luego incrustaremos antes de 
		
		//Creamos la tabla para tener una idea del ancho que necesitamos.
		@SuppressWarnings("unchecked")
		List<String> cabeceras = (List<String>)model.get(ExportController.REPORT_HEADER_KEY);
		int numCols = cabeceras.size();
		float[] tableMaxWidths = new float[numCols ];
		PdfPTable table = this.initTable(document, numCols);
		this.creaCabeceras(cabeceras, tableMaxWidths, table);

	    @SuppressWarnings("unchecked")
		List<List<String>> resultados = (List<List<String>>)model.get(ExportController.REPORT_LIST_KEY);
	    @SuppressWarnings("unchecked")
	    List<TipoCampoExportacion> tiposCampo = (List<TipoCampoExportacion>)model.get(ExportController.REPORT_COLTYPE_KEY);
		this.creaContenidos(resultados, tiposCampo, tableMaxWidths, table);
		
		float[] widths = autoRedimensiona(table, tableMaxWidths, numCols);
	    
		/*
	    //filas de debug, con los anchos máximos y calculados
		Font debugFont = FontFactory.getFont(FontFactory.HELVETICA, 8, Font.NORMAL, new Color(0, 0, 0));
		Chunk content;
		for (int i = 0; i < numCols; i++) {
    		content = new Chunk( String.valueOf( Math.round(tableMaxWidths[i])), debugFont);
			table.addCell(new PdfPCell( new Phrase(content) ));
		}
		for (int i = 0; i < numCols; i++) {
    		content = new Chunk( String.valueOf( Math.round(widths[i])), debugFont);
			table.addCell(new PdfPCell( new Phrase(content) ));
		}
		*/
	    
		
		float neededWidth = table.getTotalWidth() + document.leftMargin() + document.rightMargin();
	    if (neededWidth <= PageSize.A4.rotate().getWidth()) {
			document.setPageSize(PageSize.A4.rotate());
	    } else if (neededWidth <= PageSize.A3.rotate().getWidth()) {
			document.setPageSize(PageSize.A3.rotate());
	    } else {
	    	document.setPageSize( new Rectangle(neededWidth, PageSize.A3.rotate().getHeight()) );
	    }
		table.setTotalWidth( (document.getPageSize().getWidth() - document.leftMargin() - document.rightMargin()) );

	    
		model.put (TABLE_KEY, table);
	    
	}

	private static final String TABLE_KEY = "TABLA_CONTENIDO";
	
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		//Importante para forzar la descarga
		response.setContentType("application/force-download");
		//response.setContentLength((int)f.length());
		//response.setHeader("Content-Disposition","attachment; filename=\"" + "xxx\"");//fileName);
		response.setHeader("Content-Disposition","attachment;");
		response.setHeader("Content-Transfer-Encoding", "binary");
		
		PdfPTable table = (PdfPTable) model.get(TABLE_KEY);
 
		document.add(table);		
	}


	private void creaContenidos(List<List<String>> resultados,
			List<TipoCampoExportacion> tiposCampo, float[] tableMaxWidths,
			PdfPTable table) {
		Font contentFont = FontFactory.getFont(FontFactory.HELVETICA, 9, Font.NORMAL, new Color(0, 0, 0));

		//Vamos a imprimir el contenido
    	int currentCol = 0;
    	Chunk content;
	    
	    for (List<String> fila : resultados) {
	    	currentCol = 0;
	    	for (String valor : fila) {
	    		if (valor != null) {
	    			content = new Chunk(valor, contentFont);
	    		} else {
	    			content = new Chunk("", contentFont);
	    		}
	    		
	    		PdfPCell cell = new PdfPCell( new Phrase(content) );
				anotaAncho(tableMaxWidths, currentCol, content, cell);

	    		TipoCampoExportacion tipoDeCampo = tiposCampo.get(currentCol);
  			  	if (tipoDeCampo.equals(TipoCampoExportacion.NUMBER)) {
  			  		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
  			  	}
  			  	table.addCell(cell);
  		      currentCol++;
	    	}
	    }
		
	}

	
	private PdfPTable initTable(Document document, int numCols) {
		PdfPTable table = new PdfPTable(numCols);
		//table.setWidthPercentage(100);
		table.setTotalWidth(document.getPageSize().getWidth() - document.leftMargin() - document.rightMargin());
	    table.setLockedWidth(true);
		table.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.setHeaderRows(1);
		table.getDefaultCell().setPadding(1);
		table.getDefaultCell().setBorderWidth(1);
		return table;
	}

	private void creaCabeceras(List<String> cabeceras, float[] tableMaxWidths,
			PdfPTable table) {

    	int currentCol = 0;
    	Chunk content;
    	
		Font headerFont = FontFactory.getFont(FontFactory.HELVETICA, 8, Font.BOLD, new Color(0, 0, 0));
    	for (String cabecera : cabeceras) {
    		content = new Chunk(cabecera, headerFont);
			table.addCell(new PdfPCell( new Phrase(content) ));
			//Anotamos el ancho para después redimensionar
			anotaAnchoCabecera(tableMaxWidths, currentCol, content, table);
			currentCol++;
	    }
		
	}

	private float[] autoRedimensiona(PdfPTable table, float[] tableMaxWidths, int numCols) {
		
		float anchoTabla = table.getTotalWidth() -  ( (numCols + 1) * table.getDefaultCell().getBorderWidth() );
		float anchoColumna = Math.max(anchoTabla / numCols, MIN_WIDTH);
		
		float widths[] = new float[numCols];
		float restante = 0;
		float faltante = 0;
		
		//Recorremos las columnas para determinar si necesitamos más ancho y si tenemos sobrante
		for (int i = 0; i < numCols; i++) {
			if (tableMaxWidths[i] >= anchoColumna) {
				faltante += tableMaxWidths[i] - anchoColumna;
				widths[i] = anchoColumna;
			} else /* if (tableMaxWidths[i] < anchoColumna) */ { 
				//Nos sobra ancho para esta columna
				restante += anchoColumna - tableMaxWidths[i];
				//Asignamos ya el ancho máximo
				widths[i] = tableMaxWidths[i];
			}
		}
		
		if (restante != 0 && faltante != 0) {
			//Si encontramos columnas que requieran ensanchar y columnas que se puedan estrechar, lo hacemos

			float ratio = restante / faltante;
			float faltanteColumna = 0;
			
			//Recorremos las columnas asignando ancho sobrante
			for (int i = 0; i < numCols; i++) {
				if (tableMaxWidths[i] > anchoColumna) {
					faltanteColumna = (tableMaxWidths[i] - anchoColumna);
					widths[i] = anchoColumna + ( ratio * faltanteColumna );
				}
			}
		}

		float WIDTH_TEXT = 100;
		float WIDTH_LARGE_TEXT = 300;
		float WIDTH_VERY_LARGE_TEXT = 1000;

		float MIN_WIDTH_TEXT = 60;
		float MIN_WIDTH_LARGE_TEXT = 100;
		float MIN_WIDTH_VERY_LARGE_TEXT = 200;
		
		//Recorremos las columnas revisando el ancho mínimo
		for (int i = 0; i < numCols; i++) {
			
			if (tableMaxWidths[i] >= WIDTH_VERY_LARGE_TEXT) {
				//very large text
				widths[i] = Math.max(MIN_WIDTH_VERY_LARGE_TEXT, widths[i]);
			} else if (tableMaxWidths[i] >= WIDTH_LARGE_TEXT) {
				//large text
				widths[i] = Math.max(MIN_WIDTH_LARGE_TEXT, widths[i]);
			} else if (tableMaxWidths[i] >= WIDTH_TEXT) {
				//large text
				widths[i] = Math.max(MIN_WIDTH_TEXT, widths[i]);
			} else {
				//será el MIN_WIDTH ya asignado
			}
		}

		float anchoFinal = 0;
		for (int i = 0; i < numCols; i++) {
			anchoFinal += widths[i];
		}
		
		float percentWidths[] = new float[numCols];
		for (int i = 0; i < numCols; i++) {
			percentWidths[i] = widths[i] / anchoFinal;
		}
		
		anchoFinal += ( (numCols + 1) * table.getDefaultCell().getBorderWidth() );
		
		try {
			table.setTotalWidth( (float)Math.floor(anchoFinal));
			table.setWidths(percentWidths);
		} catch (DocumentException e) {
			log.error("autoRedimensionaColumnas: error aplicando anchos calculados " + widths, e);
		}
		
		return widths;
	}

	/**
	 * Para el ancho de la cabecera, reservamos 2 lineas
	 * @param tableMaxWidths
	 * @param currentCol
	 * @param content
	 * @param table
	 */
	private void anotaAnchoCabecera(float[] tableMaxWidths, int currentCol,
			Chunk content, PdfPTable table) {
		float ancho = content.getWidthPoint() / 2;
		ancho += table.getDefaultCell().getPaddingLeft() + table.getDefaultCell().getPaddingRight();
		ancho = Math.max(ancho, MIN_WIDTH);
		tableMaxWidths[currentCol] = Math.max(ancho, tableMaxWidths[currentCol]);
		
	}

	private void anotaAncho(float[] tableMaxWidths, int currentCol, Chunk content, PdfPCell cell) {

		float ancho = content.getWidthPoint();
		ancho += cell.getPaddingLeft() + cell.getPaddingRight() + cell.getBorderWidth();
		tableMaxWidths[currentCol] = Math.max(ancho, tableMaxWidths[currentCol]);
		
	}

}
