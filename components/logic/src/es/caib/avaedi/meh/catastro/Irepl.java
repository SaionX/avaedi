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
 * <p>
 * Java class for irepl complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="irepl">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="noec" type="{http://www.catastro.meh.es/}noec"/>
 *         &lt;element name="pctrep" type="{http://www.catastro.meh.es/}pctrep" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "irepl", propOrder = { "noec", "pctrep" })
@XmlSeeAlso({ Ireplb.class })
public class Irepl {

	@XmlElement(required = true)
	protected String noec;
	protected String pctrep;

	/**
	 * Gets the value of the noec property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getNoec() {
		return noec;
	}

	/**
	 * Sets the value of the noec property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setNoec(String value) {
		this.noec = value;
	}

	/**
	 * Gets the value of the pctrep property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPctrep() {
		return pctrep;
	}

	/**
	 * Sets the value of the pctrep property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPctrep(String value) {
		this.pctrep = value;
	}

}