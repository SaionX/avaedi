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
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

/**
 * Identificacion de la construccion
 * 
 * <p>
 * Java class for idcons complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="idcons">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="rcons" type="{http://www.catastro.meh.es/}rcons"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "idcons", propOrder = { "rcons" })
@XmlSeeAlso({ Idconscati.class, Idconscat.class })
public class Idcons {

	@XmlElement(required = true)
	protected Rcons rcons;

	/**
	 * Gets the value of the rcons property.
	 * 
	 * @return possible object is {@link Rcons }
	 * 
	 */
	public Rcons getRcons() {
		return rcons;
	}

	/**
	 * Sets the value of the rcons property.
	 * 
	 * @param value
	 *            allowed object is {@link Rcons }
	 * 
	 */
	public void setRcons(Rcons value) {
		this.rcons = value;
	}

}
