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
 * Lindero
 * 
 * <p>
 * Java class for lind complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="lind">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="situ" type="{http://www.catastro.meh.es/}situ"/>
 *         &lt;element name="loclind">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.catastro.meh.es/}dt">
 *                 &lt;sequence>
 *                   &lt;element name="lourb">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.catastro.meh.es/}lourb">
 *                           &lt;sequence>
 *                             &lt;element name="dir" type="{http://www.catastro.meh.es/}dir" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "lind", propOrder = { "situ", "loclind" })
public class Lind {

	@XmlElement(required = true)
	protected Situ situ;
	@XmlElement(required = true)
	protected Lind.Loclind loclind;

	/**
	 * Gets the value of the situ property.
	 * 
	 * @return possible object is {@link Situ }
	 * 
	 */
	public Situ getSitu() {
		return situ;
	}

	/**
	 * Sets the value of the situ property.
	 * 
	 * @param value
	 *            allowed object is {@link Situ }
	 * 
	 */
	public void setSitu(Situ value) {
		this.situ = value;
	}

	/**
	 * Gets the value of the loclind property.
	 * 
	 * @return possible object is {@link Lind.Loclind }
	 * 
	 */
	public Lind.Loclind getLoclind() {
		return loclind;
	}

	/**
	 * Sets the value of the loclind property.
	 * 
	 * @param value
	 *            allowed object is {@link Lind.Loclind }
	 * 
	 */
	public void setLoclind(Lind.Loclind value) {
		this.loclind = value;
	}

	/**
	 * <p>
	 * Java class for anonymous complex type.
	 * 
	 * <p>
	 * The following schema fragment specifies the expected content contained
	 * within this class.
	 * 
	 * <pre>
	 * &lt;complexType>
	 *   &lt;complexContent>
	 *     &lt;restriction base="{http://www.catastro.meh.es/}dt">
	 *       &lt;sequence>
	 *         &lt;element name="lourb">
	 *           &lt;complexType>
	 *             &lt;complexContent>
	 *               &lt;restriction base="{http://www.catastro.meh.es/}lourb">
	 *                 &lt;sequence>
	 *                   &lt;element name="dir" type="{http://www.catastro.meh.es/}dir" minOccurs="0"/>
	 *                 &lt;/sequence>
	 *               &lt;/restriction>
	 *             &lt;/complexContent>
	 *           &lt;/complexType>
	 *         &lt;/element>
	 *       &lt;/sequence>
	 *     &lt;/restriction>
	 *   &lt;/complexContent>
	 * &lt;/complexType>
	 * </pre>
	 * 
	 * 
	 */
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "")
	public static class Loclind extends Dt {

	}

}