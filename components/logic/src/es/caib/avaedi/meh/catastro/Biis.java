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
 * Bien Inmueble
 * 
 * <p>
 * Java class for biis complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="biis">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idbi" type="{http://www.catastro.meh.es/}idbi" minOccurs="0"/>
 *         &lt;element name="idcat" type="{http://www.catastro.meh.es/}idcati" minOccurs="0"/>
 *         &lt;element name="idine" type="{http://www.catastro.meh.es/}idine" minOccurs="0"/>
 *         &lt;element name="idreg" type="{http://www.catastro.meh.es/}idreg" minOccurs="0"/>
 *         &lt;element name="idbis" type="{http://www.catastro.meh.es/}idbis" minOccurs="0"/>
 *         &lt;element name="rc" type="{http://www.catastro.meh.es/}rc" minOccurs="0"/>
 *         &lt;element name="idad" type="{http://www.catastro.meh.es/}idadis" minOccurs="0"/>
 *         &lt;element name="tbi" type="{http://www.catastro.meh.es/}tbi" minOccurs="0"/>
 *         &lt;element name="dt" type="{http://www.catastro.meh.es/}dt" minOccurs="0"/>
 *         &lt;element name="ldt" type="{http://www.catastro.meh.es/}stringnb" minOccurs="0"/>
 *         &lt;element name="inrbi" type="{http://www.catastro.meh.es/}inrbi" minOccurs="0"/>
 *         &lt;element name="debi" type="{http://www.catastro.meh.es/}debi" minOccurs="0"/>
 *         &lt;element name="dcbl" type="{http://www.catastro.meh.es/}dcbl" minOccurs="0"/>
 *         &lt;element name="spas" type="{http://www.catastro.meh.es/}spas" minOccurs="0"/>
 *         &lt;element name="rep" type="{http://www.catastro.meh.es/}repr" minOccurs="0"/>
 *         &lt;element name="lcol" type="{http://www.catastro.meh.es/}lcol" minOccurs="0"/>
 *         &lt;element name="lcons" type="{http://www.catastro.meh.es/}lcons" minOccurs="0"/>
 *         &lt;element name="evbi" type="{http://www.catastro.meh.es/}evbi" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "biis", propOrder = { "idbi", "idcat", "idine", "idreg", "idbis", "rc", "idad", "tbi", "dt", "ldt", "inrbi", "debi", "dcbl", "spas", "rep", "lcol", "lcons", "evbi" })
public class Biis {

	protected Idbi idbi;
	protected Idcati idcat;
	protected Idine idine;
	protected Idreg idreg;
	protected Idbis idbis;
	protected Rc rc;
	protected Idadis idad;
	protected Tbi tbi;
	protected Dt dt;
	protected String ldt;
	protected Inrbi inrbi;
	protected Debi debi;
	protected Dcbl dcbl;
	protected Spas spas;
	protected Repr rep;
	protected Lcol lcol;
	protected Lcons lcons;
	protected Evbi evbi;

	/**
	 * Gets the value of the idbi property.
	 * 
	 * @return possible object is {@link Idbi }
	 * 
	 */
	public Idbi getIdbi() {
		return idbi;
	}

	/**
	 * Sets the value of the idbi property.
	 * 
	 * @param value
	 *            allowed object is {@link Idbi }
	 * 
	 */
	public void setIdbi(Idbi value) {
		this.idbi = value;
	}

	/**
	 * Gets the value of the idcat property.
	 * 
	 * @return possible object is {@link Idcati }
	 * 
	 */
	public Idcati getIdcat() {
		return idcat;
	}

	/**
	 * Sets the value of the idcat property.
	 * 
	 * @param value
	 *            allowed object is {@link Idcati }
	 * 
	 */
	public void setIdcat(Idcati value) {
		this.idcat = value;
	}

	/**
	 * Gets the value of the idine property.
	 * 
	 * @return possible object is {@link Idine }
	 * 
	 */
	public Idine getIdine() {
		return idine;
	}

	/**
	 * Sets the value of the idine property.
	 * 
	 * @param value
	 *            allowed object is {@link Idine }
	 * 
	 */
	public void setIdine(Idine value) {
		this.idine = value;
	}

	/**
	 * Gets the value of the idreg property.
	 * 
	 * @return possible object is {@link Idreg }
	 * 
	 */
	public Idreg getIdreg() {
		return idreg;
	}

	/**
	 * Sets the value of the idreg property.
	 * 
	 * @param value
	 *            allowed object is {@link Idreg }
	 * 
	 */
	public void setIdreg(Idreg value) {
		this.idreg = value;
	}

	/**
	 * Gets the value of the idbis property.
	 * 
	 * @return possible object is {@link Idbis }
	 * 
	 */
	public Idbis getIdbis() {
		return idbis;
	}

	/**
	 * Sets the value of the idbis property.
	 * 
	 * @param value
	 *            allowed object is {@link Idbis }
	 * 
	 */
	public void setIdbis(Idbis value) {
		this.idbis = value;
	}

	/**
	 * Gets the value of the rc property.
	 * 
	 * @return possible object is {@link Rc }
	 * 
	 */
	public Rc getRc() {
		return rc;
	}

	/**
	 * Sets the value of the rc property.
	 * 
	 * @param value
	 *            allowed object is {@link Rc }
	 * 
	 */
	public void setRc(Rc value) {
		this.rc = value;
	}

	/**
	 * Gets the value of the idad property.
	 * 
	 * @return possible object is {@link Idadis }
	 * 
	 */
	public Idadis getIdad() {
		return idad;
	}

	/**
	 * Sets the value of the idad property.
	 * 
	 * @param value
	 *            allowed object is {@link Idadis }
	 * 
	 */
	public void setIdad(Idadis value) {
		this.idad = value;
	}

	/**
	 * Gets the value of the tbi property.
	 * 
	 * @return possible object is {@link Tbi }
	 * 
	 */
	public Tbi getTbi() {
		return tbi;
	}

	/**
	 * Sets the value of the tbi property.
	 * 
	 * @param value
	 *            allowed object is {@link Tbi }
	 * 
	 */
	public void setTbi(Tbi value) {
		this.tbi = value;
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
	 * Gets the value of the inrbi property.
	 * 
	 * @return possible object is {@link Inrbi }
	 * 
	 */
	public Inrbi getInrbi() {
		return inrbi;
	}

	/**
	 * Sets the value of the inrbi property.
	 * 
	 * @param value
	 *            allowed object is {@link Inrbi }
	 * 
	 */
	public void setInrbi(Inrbi value) {
		this.inrbi = value;
	}

	/**
	 * Gets the value of the debi property.
	 * 
	 * @return possible object is {@link Debi }
	 * 
	 */
	public Debi getDebi() {
		return debi;
	}

	/**
	 * Sets the value of the debi property.
	 * 
	 * @param value
	 *            allowed object is {@link Debi }
	 * 
	 */
	public void setDebi(Debi value) {
		this.debi = value;
	}

	/**
	 * Gets the value of the dcbl property.
	 * 
	 * @return possible object is {@link Dcbl }
	 * 
	 */
	public Dcbl getDcbl() {
		return dcbl;
	}

	/**
	 * Sets the value of the dcbl property.
	 * 
	 * @param value
	 *            allowed object is {@link Dcbl }
	 * 
	 */
	public void setDcbl(Dcbl value) {
		this.dcbl = value;
	}

	/**
	 * Gets the value of the spas property.
	 * 
	 * @return possible object is {@link Spas }
	 * 
	 */
	public Spas getSpas() {
		return spas;
	}

	/**
	 * Sets the value of the spas property.
	 * 
	 * @param value
	 *            allowed object is {@link Spas }
	 * 
	 */
	public void setSpas(Spas value) {
		this.spas = value;
	}

	/**
	 * Gets the value of the rep property.
	 * 
	 * @return possible object is {@link Repr }
	 * 
	 */
	public Repr getRep() {
		return rep;
	}

	/**
	 * Sets the value of the rep property.
	 * 
	 * @param value
	 *            allowed object is {@link Repr }
	 * 
	 */
	public void setRep(Repr value) {
		this.rep = value;
	}

	/**
	 * Gets the value of the lcol property.
	 * 
	 * @return possible object is {@link Lcol }
	 * 
	 */
	public Lcol getLcol() {
		return lcol;
	}

	/**
	 * Sets the value of the lcol property.
	 * 
	 * @param value
	 *            allowed object is {@link Lcol }
	 * 
	 */
	public void setLcol(Lcol value) {
		this.lcol = value;
	}

	/**
	 * Gets the value of the lcons property.
	 * 
	 * @return possible object is {@link Lcons }
	 * 
	 */
	public Lcons getLcons() {
		return lcons;
	}

	/**
	 * Sets the value of the lcons property.
	 * 
	 * @param value
	 *            allowed object is {@link Lcons }
	 * 
	 */
	public void setLcons(Lcons value) {
		this.lcons = value;
	}

	/**
	 * Gets the value of the evbi property.
	 * 
	 * @return possible object is {@link Evbi }
	 * 
	 */
	public Evbi getEvbi() {
		return evbi;
	}

	/**
	 * Sets the value of the evbi property.
	 * 
	 * @param value
	 *            allowed object is {@link Evbi }
	 * 
	 */
	public void setEvbi(Evbi value) {
		this.evbi = value;
	}

}
