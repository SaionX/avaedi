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
 * Datos de entrada
 * 
 * <p>
 * Java class for den complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="den">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="idp_in" type="{http://www.catastro.meh.es/}idp_in" minOccurs="0"/>
 *           &lt;element name="idbiu" type="{http://www.catastro.meh.es/}idbiu" minOccurs="0"/>
 *           &lt;element name="idbil" type="{http://www.catastro.meh.es/}idbil" minOccurs="0"/>
 *         &lt;/choice>
 *         &lt;element name="err" type="{http://www.catastro.meh.es/}err" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "den", propOrder = { "idpIn", "idbiu", "idbil", "err" })
public class Den {

	@XmlElement(name = "idp_in")
	protected IdpIn idpIn;
	protected Idbiu idbiu;
	protected Idbil idbil;
	protected Err err;

	/**
	 * Gets the value of the idpIn property.
	 * 
	 * @return possible object is {@link IdpIn }
	 * 
	 */
	public IdpIn getIdpIn() {
		return idpIn;
	}

	/**
	 * Sets the value of the idpIn property.
	 * 
	 * @param value
	 *            allowed object is {@link IdpIn }
	 * 
	 */
	public void setIdpIn(IdpIn value) {
		this.idpIn = value;
	}

	/**
	 * Gets the value of the idbiu property.
	 * 
	 * @return possible object is {@link Idbiu }
	 * 
	 */
	public Idbiu getIdbiu() {
		return idbiu;
	}

	/**
	 * Sets the value of the idbiu property.
	 * 
	 * @param value
	 *            allowed object is {@link Idbiu }
	 * 
	 */
	public void setIdbiu(Idbiu value) {
		this.idbiu = value;
	}

	/**
	 * Gets the value of the idbil property.
	 * 
	 * @return possible object is {@link Idbil }
	 * 
	 */
	public Idbil getIdbil() {
		return idbil;
	}

	/**
	 * Sets the value of the idbil property.
	 * 
	 * @param value
	 *            allowed object is {@link Idbil }
	 * 
	 */
	public void setIdbil(Idbil value) {
		this.idbil = value;
	}

	/**
	 * Gets the value of the err property.
	 * 
	 * @return possible object is {@link Err }
	 * 
	 */
	public Err getErr() {
		return err;
	}

	/**
	 * Sets the value of the err property.
	 * 
	 * @param value
	 *            allowed object is {@link Err }
	 * 
	 */
	public void setErr(Err value) {
		this.err = value;
	}

}
