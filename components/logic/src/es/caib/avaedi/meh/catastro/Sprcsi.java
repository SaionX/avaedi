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
 * Java class for sprcsi complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="sprcsi">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;sequence>
 *           &lt;element name="sprs" type="{http://www.catastro.meh.es/}spri"/>
 *           &lt;element name="exp" type="{http://www.catastro.meh.es/}mov"/>
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
@XmlType(name = "sprcsi", propOrder = { "sprs", "exp" })
public class Sprcsi {

	protected Spri sprs;
	protected Mov exp;

	/**
	 * Gets the value of the sprs property.
	 * 
	 * @return possible object is {@link Spri }
	 * 
	 */
	public Spri getSprs() {
		return sprs;
	}

	/**
	 * Sets the value of the sprs property.
	 * 
	 * @param value
	 *            allowed object is {@link Spri }
	 * 
	 */
	public void setSprs(Spri value) {
		this.sprs = value;
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

}