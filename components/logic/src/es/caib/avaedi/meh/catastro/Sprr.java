//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.08.05 at 02:00:57 PM CEST 
//

package es.caib.avaedi.meh.catastro;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for sprr complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="sprr">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cspr" type="{http://www.catastro.meh.es/}cspr_out"/>
 *         &lt;element name="dspr">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.catastro.meh.es/}dspr">
 *                 &lt;sequence>
 *                   &lt;element name="ccc" type="{http://www.catastro.meh.es/}ccc"/>
 *                   &lt;element name="dcc" type="{http://www.catastro.meh.es/}dcc"/>
 *                   &lt;element name="ip" type="{http://www.catastro.meh.es/}ip"/>
 *                   &lt;element name="ssp" type="{http://www.catastro.meh.es/}supg"/>
 *                   &lt;element name="vsp" type="{http://www.catastro.meh.es/}vcat"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sprr", propOrder = { "cspr", "dspr" })
public class Sprr {

	@XmlElement(required = true)
	protected String cspr;
	@XmlElement(required = true)
	protected Sprr.Dspr dspr;

	/**
	 * Gets the value of the cspr property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCspr() {
		return cspr;
	}

	/**
	 * Sets the value of the cspr property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCspr(String value) {
		this.cspr = value;
	}

	/**
	 * Gets the value of the dspr property.
	 * 
	 * @return possible object is {@link Sprr.Dspr }
	 * 
	 */
	public Sprr.Dspr getDspr() {
		return dspr;
	}

	/**
	 * Sets the value of the dspr property.
	 * 
	 * @param value
	 *            allowed object is {@link Sprr.Dspr }
	 * 
	 */
	public void setDspr(Sprr.Dspr value) {
		this.dspr = value;
	}

	/**
	 * <p>
	 * Java class for anonymous complex type.
	 * 
	 * <p>
	 * The following schema fragment specifies the expected content contained
	 * within this class.
	 * 
	 * <pre>
	 * &lt;complexType>
	 *   &lt;complexContent>
	 *     &lt;restriction base="{http://www.catastro.meh.es/}dspr">
	 *       &lt;sequence>
	 *         &lt;element name="ccc" type="{http://www.catastro.meh.es/}ccc"/>
	 *         &lt;element name="dcc" type="{http://www.catastro.meh.es/}dcc"/>
	 *         &lt;element name="ip" type="{http://www.catastro.meh.es/}ip"/>
	 *         &lt;element name="ssp" type="{http://www.catastro.meh.es/}supg"/>
	 *         &lt;element name="vsp" type="{http://www.catastro.meh.es/}vcat"/>
	 *       &lt;/sequence>
	 *     &lt;/restriction>
	 *   &lt;/complexContent>
	 * &lt;/complexType>
	 * </pre>
	 * 
	 * 
	 */
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "")
	public static class Dspr extends es.caib.avaedi.meh.catastro.Dspr {

	}

}
