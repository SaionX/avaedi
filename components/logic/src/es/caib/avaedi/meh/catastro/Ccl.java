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
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for ccl complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="ccl">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ccc" type="{http://www.catastro.meh.es/}ccc"/>
 *         &lt;element name="dcc" type="{http://www.catastro.meh.es/}dcc"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ccl", propOrder = { "ccc", "dcc" })
public class Ccl {

	@XmlElement(required = true)
	protected String ccc;
	@XmlElement(required = true)
	protected String dcc;

	/**
	 * Gets the value of the ccc property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCcc() {
		return ccc;
	}

	/**
	 * Sets the value of the ccc property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCcc(String value) {
		this.ccc = value;
	}

	/**
	 * Gets the value of the dcc property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDcc() {
		return dcc;
	}

	/**
	 * Sets the value of the dcc property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDcc(String value) {
		this.dcc = value;
	}

}
