//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.08.05 at 02:13:53 PM CEST 
//

package es.caib.avaedi.meh.catastro;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * Datos de notificacion del nuevo valor
 * 
 * <p>
 * Java class for notif complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="notif">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="annv" type="{http://www.w3.org/2001/XMLSchema}gYear"/>
 *         &lt;element name="nnv" type="{http://www.catastro.meh.es/}nnv"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "notif", propOrder = { "annv", "nnv" })
public class Notif {

	@XmlElement(required = true)
	@XmlSchemaType(name = "gYear")
	protected XMLGregorianCalendar annv;
	@XmlElement(required = true)
	protected String nnv;

	/**
	 * Gets the value of the annv property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public XMLGregorianCalendar getAnnv() {
		return annv;
	}

	/**
	 * Sets the value of the annv property.
	 * 
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setAnnv(XMLGregorianCalendar value) {
		this.annv = value;
	}

	/**
	 * Gets the value of the nnv property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getNnv() {
		return nnv;
	}

	/**
	 * Sets the value of the nnv property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setNnv(String value) {
		this.nnv = value;
	}

}