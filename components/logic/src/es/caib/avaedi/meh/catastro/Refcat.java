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
 * Referencia Catastral redefinible
 * 
 * <p>
 * Java class for refcat complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="refcat">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.catastro.meh.es/}pc">
 *       &lt;sequence>
 *         &lt;element name="car" type="{http://www.catastro.meh.es/}car" minOccurs="0"/>
 *         &lt;element name="cc1" type="{http://www.catastro.meh.es/}cc" minOccurs="0"/>
 *         &lt;element name="cc2" type="{http://www.catastro.meh.es/}cc" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "refcat", propOrder = { "car", "cc1", "cc2" })
@XmlSeeAlso({ Rcu.class, Rcl.class, Rc.class })
public class Refcat extends Pc {

	protected String car;
	protected String cc1;
	protected String cc2;

	/**
	 * Gets the value of the car property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCar() {
		return car;
	}

	/**
	 * Sets the value of the car property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCar(String value) {
		this.car = value;
	}

	/**
	 * Gets the value of the cc1 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCc1() {
		return cc1;
	}

	/**
	 * Sets the value of the cc1 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCc1(String value) {
		this.cc1 = value;
	}

	/**
	 * Gets the value of the cc2 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCc2() {
		return cc2;
	}

	/**
	 * Sets the value of the cc2 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCc2(String value) {
		this.cc2 = value;
	}

}