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
 * Java class for consce complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="consce">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;sequence>
 *             &lt;element name="conseam" type="{http://www.catastro.meh.es/}cons"/>
 *             &lt;element name="movam" type="{http://www.catastro.meh.es/}movam"/>
 *           &lt;/sequence>
 *           &lt;sequence>
 *             &lt;element name="conseb" type="{http://www.catastro.meh.es/}cons"/>
 *             &lt;element name="movb" type="{http://www.catastro.meh.es/}movb"/>
 *           &lt;/sequence>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consce", propOrder = { "conseam", "movam", "conseb", "movb" })
public class Consce {

	protected Cons conseam;
	protected Movam movam;
	protected Cons conseb;
	protected Movb movb;

	/**
	 * Gets the value of the conseam property.
	 * 
	 * @return possible object is {@link Cons }
	 * 
	 */
	public Cons getConseam() {
		return conseam;
	}

	/**
	 * Sets the value of the conseam property.
	 * 
	 * @param value
	 *            allowed object is {@link Cons }
	 * 
	 */
	public void setConseam(Cons value) {
		this.conseam = value;
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
	 * Gets the value of the conseb property.
	 * 
	 * @return possible object is {@link Cons }
	 * 
	 */
	public Cons getConseb() {
		return conseb;
	}

	/**
	 * Sets the value of the conseb property.
	 * 
	 * @param value
	 *            allowed object is {@link Cons }
	 * 
	 */
	public void setConseb(Cons value) {
		this.conseb = value;
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

}
