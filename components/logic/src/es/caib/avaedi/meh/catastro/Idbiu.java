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
 * <p>
 * Java class for idbiu complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="idbiu">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="loine" type="{http://www.catastro.meh.es/}loine"/>
 *         &lt;element name="rbiu" type="{http://www.catastro.meh.es/}rbiu"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "idbiu", propOrder = { "loine", "rbiu" })
public class Idbiu {

	@XmlElement(required = true)
	protected Loine loine;
	@XmlElement(required = true)
	protected Rbiu rbiu;

	/**
	 * Gets the value of the loine property.
	 * 
	 * @return possible object is {@link Loine }
	 * 
	 */
	public Loine getLoine() {
		return loine;
	}

	/**
	 * Sets the value of the loine property.
	 * 
	 * @param value
	 *            allowed object is {@link Loine }
	 * 
	 */
	public void setLoine(Loine value) {
		this.loine = value;
	}

	/**
	 * Gets the value of the rbiu property.
	 * 
	 * @return possible object is {@link Rbiu }
	 * 
	 */
	public Rbiu getRbiu() {
		return rbiu;
	}

	/**
	 * Sets the value of the rbiu property.
	 * 
	 * @param value
	 *            allowed object is {@link Rbiu }
	 * 
	 */
	public void setRbiu(Rbiu value) {
		this.rbiu = value;
	}

}