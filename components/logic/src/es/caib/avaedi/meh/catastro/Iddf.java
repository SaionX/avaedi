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
 * Java class for iddf complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="iddf">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idd" type="{http://www.catastro.meh.es/}idd"/>
 *         &lt;choice>
 *           &lt;element name="idfcat" type="{http://www.catastro.meh.es/}idfcat"/>
 *           &lt;element name="idbicat" type="{http://www.catastro.meh.es/}idcat"/>
 *         &lt;/choice>
 *         &lt;element name="lexp" type="{http://www.catastro.meh.es/}lexp" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "iddf", propOrder = { "idd", "idfcat", "idbicat", "lexp" })
public class Iddf {

	@XmlElement(required = true)
	protected String idd;
	protected Idfcat idfcat;
	protected Idcat idbicat;
	protected Lexp lexp;

	/**
	 * Gets the value of the idd property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getIdd() {
		return idd;
	}

	/**
	 * Sets the value of the idd property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setIdd(String value) {
		this.idd = value;
	}

	/**
	 * Gets the value of the idfcat property.
	 * 
	 * @return possible object is {@link Idfcat }
	 * 
	 */
	public Idfcat getIdfcat() {
		return idfcat;
	}

	/**
	 * Sets the value of the idfcat property.
	 * 
	 * @param value
	 *            allowed object is {@link Idfcat }
	 * 
	 */
	public void setIdfcat(Idfcat value) {
		this.idfcat = value;
	}

	/**
	 * Gets the value of the idbicat property.
	 * 
	 * @return possible object is {@link Idcat }
	 * 
	 */
	public Idcat getIdbicat() {
		return idbicat;
	}

	/**
	 * Sets the value of the idbicat property.
	 * 
	 * @param value
	 *            allowed object is {@link Idcat }
	 * 
	 */
	public void setIdbicat(Idcat value) {
		this.idbicat = value;
	}

	/**
	 * Gets the value of the lexp property.
	 * 
	 * @return possible object is {@link Lexp }
	 * 
	 */
	public Lexp getLexp() {
		return lexp;
	}

	/**
	 * Sets the value of the lexp property.
	 * 
	 * @param value
	 *            allowed object is {@link Lexp }
	 * 
	 */
	public void setLexp(Lexp value) {
		this.lexp = value;
	}

}