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
 * Java class for fincacfi complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="fincacfi">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;sequence>
 *           &lt;element name="fincaf" type="{http://www.catastro.meh.es/}fincai"/>
 *           &lt;element name="movf" type="{http://www.catastro.meh.es/}movi"/>
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
@XmlType(name = "fincacfi", propOrder = { "fincaf", "movf" })
public class Fincacfi {

	protected Fincai fincaf;
	protected Movi movf;

	/**
	 * Gets the value of the fincaf property.
	 * 
	 * @return possible object is {@link Fincai }
	 * 
	 */
	public Fincai getFincaf() {
		return fincaf;
	}

	/**
	 * Sets the value of the fincaf property.
	 * 
	 * @param value
	 *            allowed object is {@link Fincai }
	 * 
	 */
	public void setFincaf(Fincai value) {
		this.fincaf = value;
	}

	/**
	 * Gets the value of the movf property.
	 * 
	 * @return possible object is {@link Movi }
	 * 
	 */
	public Movi getMovf() {
		return movf;
	}

	/**
	 * Sets the value of the movf property.
	 * 
	 * @param value
	 *            allowed object is {@link Movi }
	 * 
	 */
	public void setMovf(Movi value) {
		this.movf = value;
	}

}
