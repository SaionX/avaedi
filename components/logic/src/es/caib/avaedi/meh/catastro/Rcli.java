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
 * Java class for rcli complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="rcli">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="pc1" type="{http://www.catastro.meh.es/}pcatastral1" minOccurs="0"/>
 *         &lt;element name="pc2" type="{http://www.catastro.meh.es/}pcatastral2" minOccurs="0"/>
 *         &lt;element name="car" type="{http://www.catastro.meh.es/}car" minOccurs="0"/>
 *         &lt;element name="cc1" type="{http://www.catastro.meh.es/}cc" minOccurs="0"/>
 *         &lt;element name="cc2" type="{http://www.catastro.meh.es/}cc" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "rcli", propOrder = { "pc1", "pc2", "car", "cc1", "cc2" })
public class Rcli {

	protected String pc1;
	protected String pc2;
	protected String car;
	protected String cc1;
	protected String cc2;

	/**
	 * Gets the value of the pc1 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPc1() {
		return pc1;
	}

	/**
	 * Sets the value of the pc1 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPc1(String value) {
		this.pc1 = value;
	}

	/**
	 * Gets the value of the pc2 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPc2() {
		return pc2;
	}

	/**
	 * Sets the value of the pc2 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPc2(String value) {
		this.pc2 = value;
	}

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