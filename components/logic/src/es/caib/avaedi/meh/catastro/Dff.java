//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.08.05 at 02:13:53 PM CEST 
//

package es.caib.avaedi.meh.catastro;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * Datos fisicos de la finca
 * 
 * <p>
 * Java class for dff complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="dff">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ssf" type="{http://www.catastro.meh.es/}ssf" minOccurs="0"/>
 *         &lt;element name="cen" type="{http://www.catastro.meh.es/}cen" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dff", propOrder = { "ssf", "cen" })
public class Dff {

	protected Ssf ssf;
	protected Cen cen;

	/**
	 * Gets the value of the ssf property.
	 * 
	 * @return possible object is {@link Ssf }
	 * 
	 */
	public Ssf getSsf() {
		return ssf;
	}

	/**
	 * Sets the value of the ssf property.
	 * 
	 * @param value
	 *            allowed object is {@link Ssf }
	 * 
	 */
	public void setSsf(Ssf value) {
		this.ssf = value;
	}

	/**
	 * Gets the value of the cen property.
	 * 
	 * @return possible object is {@link Cen }
	 * 
	 */
	public Cen getCen() {
		return cen;
	}

	/**
	 * Sets the value of the cen property.
	 * 
	 * @param value
	 *            allowed object is {@link Cen }
	 * 
	 */
	public void setCen(Cen value) {
		this.cen = value;
	}

}
