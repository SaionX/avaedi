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
 * Java class for ccvsuc complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="ccvsuc">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nf" type="{http://www.catastro.meh.es/}nf"/>
 *         &lt;element name="ilf" type="{http://www.catastro.meh.es/}ie"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ccvsuc", propOrder = { "nf", "ilf" })
public class Ccvsuc {

	@XmlElement(required = true)
	protected String nf;
	@XmlElement(required = true)
	protected Ie ilf;

	/**
	 * Gets the value of the nf property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getNf() {
		return nf;
	}

	/**
	 * Sets the value of the nf property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setNf(String value) {
		this.nf = value;
	}

	/**
	 * Gets the value of the ilf property.
	 * 
	 * @return possible object is {@link Ie }
	 * 
	 */
	public Ie getIlf() {
		return ilf;
	}

	/**
	 * Sets the value of the ilf property.
	 * 
	 * @param value
	 *            allowed object is {@link Ie }
	 * 
	 */
	public void setIlf(Ie value) {
		this.ilf = value;
	}

}
