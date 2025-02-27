//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.08.05 at 02:13:53 PM CEST 
//

package es.caib.avaedi.meh.catastro;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * Informacion de afectados
 * 
 * <p>
 * Java class for tafectados complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="tafectados">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="completitud" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="persona" type="{http://www.catastro.meh.es/}tpersonAfect" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tafectados", propOrder = { "completitud", "persona" })
public class Tafectados {

	protected String completitud;
	protected List<TpersonAfect> persona;

	/**
	 * Gets the value of the completitud property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCompletitud() {
		return completitud;
	}

	/**
	 * Sets the value of the completitud property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCompletitud(String value) {
		this.completitud = value;
	}

	/**
	 * Gets the value of the persona property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the persona property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getPersona().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link TpersonAfect }
	 * 
	 * 
	 */
	public List<TpersonAfect> getPersona() {
		if (persona == null) {
			persona = new ArrayList<TpersonAfect>();
		}
		return this.persona;
	}

}
