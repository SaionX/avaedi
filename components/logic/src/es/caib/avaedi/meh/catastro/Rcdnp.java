//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.08.05 at 01:59:03 PM CEST 
//

package es.caib.avaedi.meh.catastro;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for rcdnp complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="rcdnp">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="rc" type="{http://www.catastro.meh.es/}rc"/>
 *         &lt;element name="dt" type="{http://www.catastro.meh.es/}dtdnp" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "rcdnp", propOrder = { "rc", "dt" })
public class Rcdnp {

	@XmlElement(required = true)
	protected Rc rc;
	protected Dtdnp dt;

	/**
	 * Gets the value of the rc property.
	 * 
	 * @return possible object is {@link Rc }
	 * 
	 */
	public Rc getRc() {
		return rc;
	}

	/**
	 * Sets the value of the rc property.
	 * 
	 * @param value
	 *            allowed object is {@link Rc }
	 * 
	 */
	public void setRc(Rc value) {
		this.rc = value;
	}

	/**
	 * Gets the value of the dt property.
	 * 
	 * @return possible object is {@link Dtdnp }
	 * 
	 */
	public Dtdnp getDt() {
		return dt;
	}

	/**
	 * Sets the value of the dt property.
	 * 
	 * @param value
	 *            allowed object is {@link Dtdnp }
	 * 
	 */
	public void setDt(Dtdnp value) {
		this.dt = value;
	}

}