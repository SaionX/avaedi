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
 * <p>
 * Java class for elemr complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="elemr">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bicreg" type="{http://www.catastro.meh.es/}bireg" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "elemr", propOrder = { "bicreg" })
public class Elemr {

	protected Bireg bicreg;

	/**
	 * Gets the value of the bicreg property.
	 * 
	 * @return possible object is {@link Bireg }
	 * 
	 */
	public Bireg getBicreg() {
		return bicreg;
	}

	/**
	 * Sets the value of the bicreg property.
	 * 
	 * @param value
	 *            allowed object is {@link Bireg }
	 * 
	 */
	public void setBicreg(Bireg value) {
		this.bicreg = value;
	}

}