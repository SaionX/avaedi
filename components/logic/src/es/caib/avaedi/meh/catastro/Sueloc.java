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
 * Java class for sueloc complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="sueloc">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;choice minOccurs="0">
 *           &lt;sequence>
 *             &lt;element name="sueloeam" type="{http://www.catastro.meh.es/}suelo"/>
 *             &lt;element name="movam" type="{http://www.catastro.meh.es/}movam"/>
 *           &lt;/sequence>
 *           &lt;sequence>
 *             &lt;element name="sueloeb" type="{http://www.catastro.meh.es/}suelo"/>
 *             &lt;element name="movb" type="{http://www.catastro.meh.es/}movb"/>
 *           &lt;/sequence>
 *         &lt;/choice>
 *         &lt;sequence minOccurs="0">
 *           &lt;element name="suelos" type="{http://www.catastro.meh.es/}suelo"/>
 *           &lt;element name="exp" type="{http://www.catastro.meh.es/}mov"/>
 *         &lt;/sequence>
 *         &lt;sequence minOccurs="0">
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
@XmlType(name = "sueloc", propOrder = { "sueloeam", "movam", "sueloeb", "movb", "suelos", "exp", "suelof", "movf" })
public class Sueloc {

	protected Suelo sueloeam;
	protected Movam movam;
	protected Suelo sueloeb;
	protected Movb movb;
	protected Suelo suelos;
	protected Mov exp;
	protected Suelo suelof;
	protected Movf movf;

	/**
	 * Gets the value of the sueloeam property.
	 * 
	 * @return possible object is {@link Suelo }
	 * 
	 */
	public Suelo getSueloeam() {
		return sueloeam;
	}

	/**
	 * Sets the value of the sueloeam property.
	 * 
	 * @param value
	 *            allowed object is {@link Suelo }
	 * 
	 */
	public void setSueloeam(Suelo value) {
		this.sueloeam = value;
	}

	/**
	 * Gets the value of the movam property.
	 * 
	 * @return possible object is {@link Movam }
	 * 
	 */
	public Movam getMovam() {
		return movam;
	}

	/**
	 * Sets the value of the movam property.
	 * 
	 * @param value
	 *            allowed object is {@link Movam }
	 * 
	 */
	public void setMovam(Movam value) {
		this.movam = value;
	}

	/**
	 * Gets the value of the sueloeb property.
	 * 
	 * @return possible object is {@link Suelo }
	 * 
	 */
	public Suelo getSueloeb() {
		return sueloeb;
	}

	/**
	 * Sets the value of the sueloeb property.
	 * 
	 * @param value
	 *            allowed object is {@link Suelo }
	 * 
	 */
	public void setSueloeb(Suelo value) {
		this.sueloeb = value;
	}

	/**
	 * Gets the value of the movb property.
	 * 
	 * @return possible object is {@link Movb }
	 * 
	 */
	public Movb getMovb() {
		return movb;
	}

	/**
	 * Sets the value of the movb property.
	 * 
	 * @param value
	 *            allowed object is {@link Movb }
	 * 
	 */
	public void setMovb(Movb value) {
		this.movb = value;
	}

	/**
	 * Gets the value of the suelos property.
	 * 
	 * @return possible object is {@link Suelo }
	 * 
	 */
	public Suelo getSuelos() {
		return suelos;
	}

	/**
	 * Sets the value of the suelos property.
	 * 
	 * @param value
	 *            allowed object is {@link Suelo }
	 * 
	 */
	public void setSuelos(Suelo value) {
		this.suelos = value;
	}

	/**
	 * Gets the value of the exp property.
	 * 
	 * @return possible object is {@link Mov }
	 * 
	 */
	public Mov getExp() {
		return exp;
	}

	/**
	 * Sets the value of the exp property.
	 * 
	 * @param value
	 *            allowed object is {@link Mov }
	 * 
	 */
	public void setExp(Mov value) {
		this.exp = value;
	}

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