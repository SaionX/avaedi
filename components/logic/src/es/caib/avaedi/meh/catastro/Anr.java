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
 * Alteracion notarial
 * 
 * <p>
 * Java class for anr complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="anr">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="al1" type="{http://www.catastro.meh.es/}tan"/>
 *         &lt;element name="al2" type="{http://www.catastro.meh.es/}tan"/>
 *         &lt;element name="al3" type="{http://www.catastro.meh.es/}tan"/>
 *         &lt;element name="al4" type="{http://www.catastro.meh.es/}tan"/>
 *         &lt;element name="al5" type="{http://www.catastro.meh.es/}tan"/>
 *         &lt;element name="al6" type="{http://www.catastro.meh.es/}tan"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "anr", propOrder = { "al1", "al2", "al3", "al4", "al5", "al6" })
public class Anr {

	protected Tan al1;
	protected Tan al2;
	protected Tan al3;
	protected Tan al4;
	protected Tan al5;
	protected Tan al6;

	/**
	 * Gets the value of the al1 property.
	 * 
	 * @return possible object is {@link Tan }
	 * 
	 */
	public Tan getAl1() {
		return al1;
	}

	/**
	 * Sets the value of the al1 property.
	 * 
	 * @param value
	 *            allowed object is {@link Tan }
	 * 
	 */
	public void setAl1(Tan value) {
		this.al1 = value;
	}

	/**
	 * Gets the value of the al2 property.
	 * 
	 * @return possible object is {@link Tan }
	 * 
	 */
	public Tan getAl2() {
		return al2;
	}

	/**
	 * Sets the value of the al2 property.
	 * 
	 * @param value
	 *            allowed object is {@link Tan }
	 * 
	 */
	public void setAl2(Tan value) {
		this.al2 = value;
	}

	/**
	 * Gets the value of the al3 property.
	 * 
	 * @return possible object is {@link Tan }
	 * 
	 */
	public Tan getAl3() {
		return al3;
	}

	/**
	 * Sets the value of the al3 property.
	 * 
	 * @param value
	 *            allowed object is {@link Tan }
	 * 
	 */
	public void setAl3(Tan value) {
		this.al3 = value;
	}

	/**
	 * Gets the value of the al4 property.
	 * 
	 * @return possible object is {@link Tan }
	 * 
	 */
	public Tan getAl4() {
		return al4;
	}

	/**
	 * Sets the value of the al4 property.
	 * 
	 * @param value
	 *            allowed object is {@link Tan }
	 * 
	 */
	public void setAl4(Tan value) {
		this.al4 = value;
	}

	/**
	 * Gets the value of the al5 property.
	 * 
	 * @return possible object is {@link Tan }
	 * 
	 */
	public Tan getAl5() {
		return al5;
	}

	/**
	 * Sets the value of the al5 property.
	 * 
	 * @param value
	 *            allowed object is {@link Tan }
	 * 
	 */
	public void setAl5(Tan value) {
		this.al5 = value;
	}

	/**
	 * Gets the value of the al6 property.
	 * 
	 * @return possible object is {@link Tan }
	 * 
	 */
	public Tan getAl6() {
		return al6;
	}

	/**
	 * Sets the value of the al6 property.
	 * 
	 * @param value
	 *            allowed object is {@link Tan }
	 * 
	 */
	public void setAl6(Tan value) {
		this.al6 = value;
	}

}