//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.08.05 at 01:58:41 PM CEST 
//

package es.caib.avaedi.meh.catastro;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for consulta_coord complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="consulta_coord">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="control" type="{http://www.catastro.meh.es/}cabcoord"/>
 *         &lt;sequence>
 *           &lt;element name="coordenadas" type="{http://www.catastro.meh.es/}coords" minOccurs="0"/>
 *           &lt;element name="lerr" type="{http://www.catastro.meh.es/}lerr" minOccurs="0"/>
 *         &lt;/sequence>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consulta_coord", propOrder = { "control", "coordenadas", "lerr" })
@XmlRootElement(name = "consulta_coordenadas")
public class ConsultaCoord {

	@XmlElement(required = true)
	protected Cabcoord control;
	protected Coords coordenadas;
	protected Lerr lerr;

	/**
	 * Gets the value of the control property.
	 * 
	 * @return possible object is {@link Cabcoord }
	 * 
	 */
	public Cabcoord getControl() {
		return control;
	}

	/**
	 * Sets the value of the control property.
	 * 
	 * @param value
	 *            allowed object is {@link Cabcoord }
	 * 
	 */
	public void setControl(Cabcoord value) {
		this.control = value;
	}

	/**
	 * Gets the value of the coordenadas property.
	 * 
	 * @return possible object is {@link Coords }
	 * 
	 */
	public Coords getCoordenadas() {
		return coordenadas;
	}

	/**
	 * Sets the value of the coordenadas property.
	 * 
	 * @param value
	 *            allowed object is {@link Coords }
	 * 
	 */
	public void setCoordenadas(Coords value) {
		this.coordenadas = value;
	}

	/**
	 * Gets the value of the lerr property.
	 * 
	 * @return possible object is {@link Lerr }
	 * 
	 */
	public Lerr getLerr() {
		return lerr;
	}

	/**
	 * Sets the value of the lerr property.
	 * 
	 * @param value
	 *            allowed object is {@link Lerr }
	 * 
	 */
	public void setLerr(Lerr value) {
		this.lerr = value;
	}

}