//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.08.05 at 02:13:53 PM CEST 
//

package es.caib.avaedi.meh.catastro;

import java.math.BigInteger;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

/**
 * Cabecera
 * 
 * <p>
 * Java class for cab complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="cab">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ieg" type="{http://www.catastro.meh.es/}ieg" minOccurs="0"/>
 *         &lt;element name="ifi" type="{http://www.catastro.meh.es/}ifi" minOccurs="0"/>
 *         &lt;element name="ifo" type="{http://www.catastro.meh.es/}ifi" minOccurs="0"/>
 *         &lt;element name="idd" type="{http://www.catastro.meh.es/}idd" minOccurs="0"/>
 *         &lt;element name="liddf" type="{http://www.catastro.meh.es/}liddf" minOccurs="0"/>
 *         &lt;element name="lenv" type="{http://www.catastro.meh.es/}lenv" minOccurs="0"/>
 *         &lt;element name="ced" type="{http://www.catastro.meh.es/}ced" minOccurs="0"/>
 *         &lt;element name="sol" type="{http://www.catastro.meh.es/}idp" minOccurs="0"/>
 *         &lt;element name="dpad" type="{http://www.catastro.meh.es/}dpad" minOccurs="0"/>
 *         &lt;element name="iper" type="{http://www.catastro.meh.es/}iper" minOccurs="0"/>
 *         &lt;element name="cuexp" type="{http://www.catastro.meh.es/}cuexp" minOccurs="0"/>
 *         &lt;element name="cufin" type="{http://www.catastro.meh.es/}cufin" minOccurs="0"/>
 *         &lt;element name="cubi" type="{http://www.catastro.meh.es/}cubi" minOccurs="0"/>
 *         &lt;element name="cutit" type="{http://www.catastro.meh.es/}cutit" minOccurs="0"/>
 *         &lt;element name="cuprov" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="cumun" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="cupol" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="cupar" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="cuca" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="cunum" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="cudnp" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="cucons" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="cucul" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="cucoor" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="cuerr" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="cde" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cab", propOrder = { "ieg", "ifi", "ifo", "idd", "liddf", "lenv", "ced", "sol", "dpad", "iper", "cuexp", "cufin", "cubi", "cutit", "cuprov", "cumun", "cupol", "cupar", "cuca", "cunum", "cudnp", "cucons", "cucul", "cucoor", "cuerr", "cde" })
@XmlSeeAlso({ Cabrprov.class })
public class Cab {

	protected Ieg ieg;
	protected Ifi ifi;
	protected Ifi ifo;
	protected String idd;
	protected Liddf liddf;
	protected Lenv lenv;
	protected String ced;
	protected Idp sol;
	protected Dpad dpad;
	protected Iper iper;
	protected BigInteger cuexp;
	protected BigInteger cufin;
	protected BigInteger cubi;
	protected BigInteger cutit;
	protected Integer cuprov;
	protected Integer cumun;
	protected Integer cupol;
	protected Integer cupar;
	protected Integer cuca;
	protected Integer cunum;
	protected Integer cudnp;
	protected Integer cucons;
	protected Integer cucul;
	protected Integer cucoor;
	protected Integer cuerr;
	protected Integer cde;

	/**
	 * Gets the value of the ieg property.
	 * 
	 * @return possible object is {@link Ieg }
	 * 
	 */
	public Ieg getIeg() {
		return ieg;
	}

	/**
	 * Sets the value of the ieg property.
	 * 
	 * @param value
	 *            allowed object is {@link Ieg }
	 * 
	 */
	public void setIeg(Ieg value) {
		this.ieg = value;
	}

	/**
	 * Gets the value of the ifi property.
	 * 
	 * @return possible object is {@link Ifi }
	 * 
	 */
	public Ifi getIfi() {
		return ifi;
	}

	/**
	 * Sets the value of the ifi property.
	 * 
	 * @param value
	 *            allowed object is {@link Ifi }
	 * 
	 */
	public void setIfi(Ifi value) {
		this.ifi = value;
	}

	/**
	 * Gets the value of the ifo property.
	 * 
	 * @return possible object is {@link Ifi }
	 * 
	 */
	public Ifi getIfo() {
		return ifo;
	}

	/**
	 * Sets the value of the ifo property.
	 * 
	 * @param value
	 *            allowed object is {@link Ifi }
	 * 
	 */
	public void setIfo(Ifi value) {
		this.ifo = value;
	}

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
	 * Gets the value of the liddf property.
	 * 
	 * @return possible object is {@link Liddf }
	 * 
	 */
	public Liddf getLiddf() {
		return liddf;
	}

	/**
	 * Sets the value of the liddf property.
	 * 
	 * @param value
	 *            allowed object is {@link Liddf }
	 * 
	 */
	public void setLiddf(Liddf value) {
		this.liddf = value;
	}

	/**
	 * Gets the value of the lenv property.
	 * 
	 * @return possible object is {@link Lenv }
	 * 
	 */
	public Lenv getLenv() {
		return lenv;
	}

	/**
	 * Sets the value of the lenv property.
	 * 
	 * @param value
	 *            allowed object is {@link Lenv }
	 * 
	 */
	public void setLenv(Lenv value) {
		this.lenv = value;
	}

	/**
	 * Gets the value of the ced property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCed() {
		return ced;
	}

	/**
	 * Sets the value of the ced property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCed(String value) {
		this.ced = value;
	}

	/**
	 * Gets the value of the sol property.
	 * 
	 * @return possible object is {@link Idp }
	 * 
	 */
	public Idp getSol() {
		return sol;
	}

	/**
	 * Sets the value of the sol property.
	 * 
	 * @param value
	 *            allowed object is {@link Idp }
	 * 
	 */
	public void setSol(Idp value) {
		this.sol = value;
	}

	/**
	 * Gets the value of the dpad property.
	 * 
	 * @return possible object is {@link Dpad }
	 * 
	 */
	public Dpad getDpad() {
		return dpad;
	}

	/**
	 * Sets the value of the dpad property.
	 * 
	 * @param value
	 *            allowed object is {@link Dpad }
	 * 
	 */
	public void setDpad(Dpad value) {
		this.dpad = value;
	}

	/**
	 * Gets the value of the iper property.
	 * 
	 * @return possible object is {@link Iper }
	 * 
	 */
	public Iper getIper() {
		return iper;
	}

	/**
	 * Sets the value of the iper property.
	 * 
	 * @param value
	 *            allowed object is {@link Iper }
	 * 
	 */
	public void setIper(Iper value) {
		this.iper = value;
	}

	/**
	 * Gets the value of the cuexp property.
	 * 
	 * @return possible object is {@link BigInteger }
	 * 
	 */
	public BigInteger getCuexp() {
		return cuexp;
	}

	/**
	 * Sets the value of the cuexp property.
	 * 
	 * @param value
	 *            allowed object is {@link BigInteger }
	 * 
	 */
	public void setCuexp(BigInteger value) {
		this.cuexp = value;
	}

	/**
	 * Gets the value of the cufin property.
	 * 
	 * @return possible object is {@link BigInteger }
	 * 
	 */
	public BigInteger getCufin() {
		return cufin;
	}

	/**
	 * Sets the value of the cufin property.
	 * 
	 * @param value
	 *            allowed object is {@link BigInteger }
	 * 
	 */
	public void setCufin(BigInteger value) {
		this.cufin = value;
	}

	/**
	 * Gets the value of the cubi property.
	 * 
	 * @return possible object is {@link BigInteger }
	 * 
	 */
	public BigInteger getCubi() {
		return cubi;
	}

	/**
	 * Sets the value of the cubi property.
	 * 
	 * @param value
	 *            allowed object is {@link BigInteger }
	 * 
	 */
	public void setCubi(BigInteger value) {
		this.cubi = value;
	}

	/**
	 * Gets the value of the cutit property.
	 * 
	 * @return possible object is {@link BigInteger }
	 * 
	 */
	public BigInteger getCutit() {
		return cutit;
	}

	/**
	 * Sets the value of the cutit property.
	 * 
	 * @param value
	 *            allowed object is {@link BigInteger }
	 * 
	 */
	public void setCutit(BigInteger value) {
		this.cutit = value;
	}

	/**
	 * Gets the value of the cuprov property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getCuprov() {
		return cuprov;
	}

	/**
	 * Sets the value of the cuprov property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setCuprov(Integer value) {
		this.cuprov = value;
	}

	/**
	 * Gets the value of the cumun property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getCumun() {
		return cumun;
	}

	/**
	 * Sets the value of the cumun property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setCumun(Integer value) {
		this.cumun = value;
	}

	/**
	 * Gets the value of the cupol property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getCupol() {
		return cupol;
	}

	/**
	 * Sets the value of the cupol property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setCupol(Integer value) {
		this.cupol = value;
	}

	/**
	 * Gets the value of the cupar property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getCupar() {
		return cupar;
	}

	/**
	 * Sets the value of the cupar property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setCupar(Integer value) {
		this.cupar = value;
	}

	/**
	 * Gets the value of the cuca property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getCuca() {
		return cuca;
	}

	/**
	 * Sets the value of the cuca property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setCuca(Integer value) {
		this.cuca = value;
	}

	/**
	 * Gets the value of the cunum property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getCunum() {
		return cunum;
	}

	/**
	 * Sets the value of the cunum property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setCunum(Integer value) {
		this.cunum = value;
	}

	/**
	 * Gets the value of the cudnp property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getCudnp() {
		return cudnp;
	}

	/**
	 * Sets the value of the cudnp property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setCudnp(Integer value) {
		this.cudnp = value;
	}

	/**
	 * Gets the value of the cucons property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getCucons() {
		return cucons;
	}

	/**
	 * Sets the value of the cucons property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setCucons(Integer value) {
		this.cucons = value;
	}

	/**
	 * Gets the value of the cucul property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getCucul() {
		return cucul;
	}

	/**
	 * Sets the value of the cucul property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setCucul(Integer value) {
		this.cucul = value;
	}

	/**
	 * Gets the value of the cucoor property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getCucoor() {
		return cucoor;
	}

	/**
	 * Sets the value of the cucoor property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setCucoor(Integer value) {
		this.cucoor = value;
	}

	/**
	 * Gets the value of the cuerr property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getCuerr() {
		return cuerr;
	}

	/**
	 * Sets the value of the cuerr property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setCuerr(Integer value) {
		this.cuerr = value;
	}

	/**
	 * Gets the value of the cde property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getCde() {
		return cde;
	}

	/**
	 * Sets the value of the cde property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setCde(Integer value) {
		this.cde = value;
	}

}