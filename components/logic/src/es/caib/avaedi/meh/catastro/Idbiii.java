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
 * Identificacion del bien inmueble
 * 
 * <p>
 * Java class for idbiii complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="idbiii">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="rc" type="{http://www.catastro.meh.es/}rc" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "idbiii", propOrder = { "rc" })
@XmlSeeAlso({ Idcatii.class })
public class Idbiii {

	protected Rc rc;

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

}