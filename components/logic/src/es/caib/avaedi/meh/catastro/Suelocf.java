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
 * Java class for suelocf complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="suelocf">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;sequence>
 *           &lt;element name="suelof" type="{http://www.catastro.meh.es/}suelo"/>
 *           &lt;element name="movf" type="{http://www.catastro.meh.es/}movf"/>
 *         &lt;/sequence>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "suelocf", propOrder = { "suelof", "movf" })
public class Suelocf {

	protected Suelo suelof;
	protected Movf movf;

	/**
	 * Gets the value of the suelof property.
	 * 
	 * @return possible object is {@link Suelo }
	 * 
	 */
	public Suelo getSuelof() {
		return suelof;
	}

	/**
	 * Sets the value of the suelof property.
	 * 
	 * @param value
	 *            allowed object is {@link Suelo }
	 * 
	 */
	public void setSuelof(Suelo value) {
		this.suelof = value;
	}

	/**
	 * Gets the value of the movf property.
	 * 
	 * @return possible object is {@link Movf }
	 * 
	 */
	public Movf getMovf() {
		return movf;
	}

	/**
	 * Sets the value of the movf property.
	 * 
	 * @param value
	 *            allowed object is {@link Movf }
	 * 
	 */
	public void setMovf(Movf value) {
		this.movf = value;
	}

}
