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
 * Java class for pcd complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="pcd">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="pc" type="{http://www.catastro.meh.es/}pc"/>
 *         &lt;element name="dt" type="{http://www.catastro.meh.es/}dt"/>
 *         &lt;element name="ldt" type="{http://www.catastro.meh.es/}stringnb"/>
 *         &lt;element name="dis" type="{http://www.catastro.meh.es/}dis"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "pcd", propOrder = { "pc", "dt", "ldt", "dis" })
public class Pcd {

	@XmlElement(required = true)
	protected Pc pc;
	@XmlElement(required = true)
	protected Dt dt;
	@XmlElement(required = true)
	protected String ldt;
	@XmlElement(required = true)
	protected String dis;

	/**
	 * Gets the value of the pc property.
	 * 
	 * @return possible object is {@link Pc }
	 * 
	 */
	public Pc getPc() {
		return pc;
	}

	/**
	 * Sets the value of the pc property.
	 * 
	 * @param value
	 *            allowed object is {@link Pc }
	 * 
	 */
	public void setPc(Pc value) {
		this.pc = value;
	}

	/**
	 * Gets the value of the dt property.
	 * 
	 * @return possible object is {@link Dt }
	 * 
	 */
	public Dt getDt() {
		return dt;
	}

	/**
	 * Sets the value of the dt property.
	 * 
	 * @param value
	 *            allowed object is {@link Dt }
	 * 
	 */
	public void setDt(Dt value) {
		this.dt = value;
	}

	/**
	 * Gets the value of the ldt property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getLdt() {
		return ldt;
	}

	/**
	 * Sets the value of the ldt property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setLdt(String value) {
		this.ldt = value;
	}

	/**
	 * Gets the value of the dis property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDis() {
		return dis;
	}

	/**
	 * Sets the value of the dis property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDis(String value) {
		this.dis = value;
	}

}
