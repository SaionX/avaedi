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
 * Numero de bienes
 * 
 * <p>
 * Java class for nbi complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="nbi">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nbu" type="{http://www.catastro.meh.es/}cta"/>
 *         &lt;element name="nbr" type="{http://www.catastro.meh.es/}cta"/>
 *         &lt;element name="nbce" type="{http://www.catastro.meh.es/}cta"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "nbi", propOrder = { "nbu", "nbr", "nbce" })
public class Nbi {

	protected int nbu;
	protected int nbr;
	protected int nbce;

	/**
	 * Gets the value of the nbu property.
	 * 
	 */
	public int getNbu() {
		return nbu;
	}

	/**
	 * Sets the value of the nbu property.
	 * 
	 */
	public void setNbu(int value) {
		this.nbu = value;
	}

	/**
	 * Gets the value of the nbr property.
	 * 
	 */
	public int getNbr() {
		return nbr;
	}

	/**
	 * Sets the value of the nbr property.
	 * 
	 */
	public void setNbr(int value) {
		this.nbr = value;
	}

	/**
	 * Gets the value of the nbce property.
	 * 
	 */
	public int getNbce() {
		return nbce;
	}

	/**
	 * Sets the value of the nbce property.
	 * 
	 */
	public void setNbce(int value) {
		this.nbce = value;
	}

}