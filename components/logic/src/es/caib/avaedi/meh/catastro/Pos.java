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
 * Datos postales
 * 
 * <p>
 * Java class for pos complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="pos">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dp" type="{http://www.catastro.meh.es/}dp"/>
 *         &lt;element name="ac" type="{http://www.catastro.meh.es/}ac" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "pos", propOrder = { "dp", "ac" })
public class Pos {

	@XmlElement(required = true)
	protected String dp;
	protected String ac;

	/**
	 * Gets the value of the dp property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDp() {
		return dp;
	}

	/**
	 * Sets the value of the dp property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDp(String value) {
		this.dp = value;
	}

	/**
	 * Gets the value of the ac property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getAc() {
		return ac;
	}

	/**
	 * Sets the value of the ac property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setAc(String value) {
		this.ac = value;
	}

}
