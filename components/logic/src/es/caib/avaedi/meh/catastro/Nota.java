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
 * Notaria
 * 
 * <p>
 * Java class for nota complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="nota">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cp" type="{http://www.catastro.meh.es/}cp"/>
 *         &lt;element name="cpb" type="{http://www.catastro.meh.es/}cpb"/>
 *         &lt;element name="cnt" type="{http://www.catastro.meh.es/}cnt"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "nota", propOrder = { "cp", "cpb", "cnt" })
public class Nota {

	@XmlElement(required = true)
	protected String cp;
	@XmlElement(required = true)
	protected String cpb;
	@XmlElement(required = true)
	protected String cnt;

	/**
	 * Gets the value of the cp property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCp() {
		return cp;
	}

	/**
	 * Sets the value of the cp property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCp(String value) {
		this.cp = value;
	}

	/**
	 * Gets the value of the cpb property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCpb() {
		return cpb;
	}

	/**
	 * Sets the value of the cpb property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCpb(String value) {
		this.cpb = value;
	}

	/**
	 * Gets the value of the cnt property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCnt() {
		return cnt;
	}

	/**
	 * Sets the value of the cnt property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCnt(String value) {
		this.cnt = value;
	}

}