package es.caib.avaedi.at4forms.front.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBody;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;

import es.caib.avaedi.at4forms.common.util.log.LogService;

import org.slf4j.Logger;


public abstract class DocxParser {

	/**
	 * The logger object.
	 */
	private static Logger log = LogService.getLogger(DocxParser.class);
	
	/** Añade el documento 2 al final del documento 1 
	 * @param src1Document
	 * @param src2Document
	 * @throws XmlException 
	 * @throws Exception
	 */
	public static void append(XWPFDocument src1Document, XWPFDocument src2Document) throws XmlException {
	    CTBody src1Body = src1Document.getDocument().getBody();
	    CTBody src2Body = src2Document.getDocument().getBody();        
	    appendBody(src1Body, src2Body);
	}

	private static void appendBody(CTBody src, CTBody append) throws XmlException {
	    XmlOptions optionsOuter = new XmlOptions();
	    optionsOuter.setSaveOuter();
	    String appendString = append.xmlText(optionsOuter);
	    String srcString = src.xmlText();
	    String prefix = srcString.substring(0,srcString.indexOf(">")+1);
	    String mainPart = srcString.substring(srcString.indexOf(">")+1,srcString.lastIndexOf("<"));
	    String sufix = srcString.substring( srcString.lastIndexOf("<") );
	    String addPart = appendString.substring(appendString.indexOf(">") + 1, appendString.lastIndexOf("<"));
	    CTBody makeBody = CTBody.Factory.parse(prefix+mainPart+addPart+sufix);
	    src.set(makeBody);
	}
	
	
	/**
	 * Parsea el documento reemplazado las marcas $key$ por los valores del mapa record
	 * @param document
	 * @param record
	 */
	public static void replaceText(XWPFDocument document, Map<String, String> record){

        XWPFHeaderFooterPolicy hfPolicy = document.getHeaderFooterPolicy();

        // Start out with all headers and footers
        replaceHeaders(hfPolicy, record);
        
        // First up, all our paragraph based text
        Iterator<XWPFParagraph> i = document.getParagraphsIterator();
        while(i.hasNext()) {
            XWPFParagraph paragraph = i.next();

            CTSectPr ctSectPr = null;
			if (paragraph.getCTP().getPPr()!=null) {
			    ctSectPr = paragraph.getCTP().getPPr().getSectPr();
			}

			XWPFHeaderFooterPolicy headerFooterPolicy = null;

			if (ctSectPr!=null) {
			    headerFooterPolicy = new XWPFHeaderFooterPolicy(document, ctSectPr);
			    replaceHeaders(headerFooterPolicy, record);
			}

			replaceParagraph(paragraph, record);

			/* TODO: comments? footnotes?
			// Add comments
			XWPFCommentsDecorator decorator = new XWPFCommentsDecorator(paragraph, null);
			text.append(decorator.getCommentText()).append('\n');
			
			// Do endnotes and footnotes
			String footnameText = paragraph.getFootnoteText();
            if(footnameText != null && footnameText.length() > 0) {
			  text.append(footnameText + "\n");
            }
            */

			if (ctSectPr!=null) {
			    replaceFooters(headerFooterPolicy, record);
			}
        }

        // Then our table based text
        for (XWPFTable tbl : document.getTables()) {
    	   for (XWPFTableRow row : tbl.getRows()) {
    	      for (XWPFTableCell cell : row.getTableCells()) {
    	    	  replaceParagraphs(cell.getParagraphs(), record);
    	      }
    	   }
    	}        
        // Finish up with all the footers
        replaceFooters(hfPolicy, record);
        
        //return text.toString();
    }

	private static void replaceFooters(XWPFHeaderFooterPolicy hfPolicy, Map<String, String> record) {
        if(hfPolicy.getFirstPageFooter() != null) {
        	replaceParagraphs(hfPolicy.getFirstPageFooter().getParagraphs(), record);
        }
        if(hfPolicy.getEvenPageFooter() != null) {
        	replaceParagraphs(hfPolicy.getEvenPageFooter().getParagraphs(), record);
        }
        if(hfPolicy.getDefaultFooter() != null) {
        	replaceParagraphs(hfPolicy.getDefaultFooter().getParagraphs(), record);
        }
    }

    private static void replaceHeaders(XWPFHeaderFooterPolicy hfPolicy, Map<String, String> record) {
        if(hfPolicy.getFirstPageHeader() != null) {
        	replaceParagraphs(hfPolicy.getFirstPageHeader().getParagraphs(), record);
        }
        if(hfPolicy.getEvenPageHeader() != null) {
        	replaceParagraphs(hfPolicy.getEvenPageHeader().getParagraphs(), record);
        }
        if(hfPolicy.getDefaultHeader() != null) {
        	replaceParagraphs(hfPolicy.getDefaultHeader().getParagraphs(), record);
        }
    }	
	
    private static void replaceParagraphs(List<XWPFParagraph> paragraphs, Map<String, String> record) {
		
    	for (XWPFParagraph p : paragraphs) {
    		replaceParagraph(p, record);
    	}
		
	}

    private static void replaceParagraph(XWPFParagraph p, Map<String, String> record) {
    	
		for (XWPFRun r : p.getRuns()) {
			
			int numTexts= r.getCTR().sizeOfTArray();
			for (int i = 0; i < numTexts; i++) {
				String text = r.getText(i);
				if (text != null && text.contains("$")) {
					for (Entry<String, String> entry : record.entrySet()) {
						String marca = "$" + entry.getKey() + "$";
						if (text.contains(marca)) {
							if (entry.getValue() != null) {
								text = text.replace(marca, entry.getValue());
							} else {
								text = text.replace(marca, "");
							}
							r.setText(text, i);
						}
					}
				}
			}
			
			/* TODO: reeplazar hipervínculos 
           if(r instanceof XWPFHyperlinkRun) {
               XWPFHyperlink link = ((XWPFHyperlinkRun)r).getHyperlink(p.getDocument());
               if(link != null && link.getURL() != null)
                  link.setUrl( link.getURL().replace(findText, replaceText));
            }
			/* */
		}
	
    }
	
}
