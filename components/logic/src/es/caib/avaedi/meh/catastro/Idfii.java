//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.08.05 at 02:13:53 PM CEST 
//

package es.caib.avaedi.meh.catastro;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

/**
 * Identificacion de finca
 * 
 * <p>
 * Java class for idfii complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="idfii">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="pc" type="{http://www.catastro.meh.es/}pc" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "idfii", propOrder = { "pc" })
@XmlSeeAlso({ Idfcatii.class })
public class Idfii {

	protected Pc pc;

	/**
	 * Gets the value of the pc property.
	 * 
	 * @return possible object is {@link Pc }
	 * 
	 */
	public Pc getPc() {
		return pc;
	}

	/**
	 * Sets the value of the pc property.
	 * 
	 * @param value
	 *            allowed object is {@link Pc }
	 * 
	 */
	public void setPc(Pc value) {
		this.pc = value;
	}

}