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
 * Expediente de la D.G. del Catastro
 * 
 * <p>
 * Java class for expg complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="expg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="aexpg" type="{http://www.w3.org/2001/XMLSchema}gYear"/>
 *         &lt;element name="rexpg" type="{http://www.catastro.meh.es/}rexpg"/>
 *         &lt;element name="ero" type="{http://www.catastro.meh.es/}ero"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "expg", propOrder = { "aexpg", "rexpg", "ero" })
public class Expg {

	@XmlElement(required = true)
	@XmlSchemaType(name = "gYear")
	protected XMLGregorianCalendar aexpg;
	@XmlElement(required = true)
	protected String rexpg;
	protected int ero;

	/**
	 * Gets the value of the aexpg property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public XMLGregorianCalendar getAexpg() {
		return aexpg;
	}

	/**
	 * Sets the value of the aexpg property.
	 * 
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setAexpg(XMLGregorianCalendar value) {
		this.aexpg = value;
	}

	/**
	 * Gets the value of the rexpg property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRexpg() {
		return rexpg;
	}

	/**
	 * Sets the value of the rexpg property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRexpg(String value) {
		this.rexpg = value;
	}

	/**
	 * Gets the value of the ero property.
	 * 
	 */
	public int getEro() {
		return ero;
	}

	/**
	 * Sets the value of the ero property.
	 * 
	 */
	public void setEro(int value) {
		this.ero = value;
	}

}