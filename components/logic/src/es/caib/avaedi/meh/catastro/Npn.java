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
 * Numero de protocolo notarial
 * 
 * <p>
 * Java class for npn complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="npn">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="not" type="{http://www.catastro.meh.es/}nota"/>
 *         &lt;element name="pn" type="{http://www.catastro.meh.es/}pn"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "npn", propOrder = { "not", "pn" })
public class Npn {

	@XmlElement(required = true)
	protected Nota not;
	@XmlElement(required = true)
	protected Pn pn;

	/**
	 * Gets the value of the not property.
	 * 
	 * @return possible object is {@link Nota }
	 * 
	 */
	public Nota getNot() {
		return not;
	}

	/**
	 * Sets the value of the not property.
	 * 
	 * @param value
	 *            allowed object is {@link Nota }
	 * 
	 */
	public void setNot(Nota value) {
		this.not = value;
	}

	/**
	 * Gets the value of the pn property.
	 * 
	 * @return possible object is {@link Pn }
	 * 
	 */
	public Pn getPn() {
		return pn;
	}

	/**
	 * Sets the value of the pn property.
	 * 
	 * @param value
	 *            allowed object is {@link Pn }
	 * 
	 */
	public void setPn(Pn value) {
		this.pn = value;
	}

}