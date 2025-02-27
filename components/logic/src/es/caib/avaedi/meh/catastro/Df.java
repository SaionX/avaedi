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
 * Domicilio fiscal
 * 
 * <p>
 * Java class for df complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="df">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="loine" type="{http://www.catastro.meh.es/}loine" minOccurs="0"/>
 *         &lt;element name="cmc" type="{http://www.catastro.meh.es/}cmc" minOccurs="0"/>
 *         &lt;element name="np" type="{http://www.catastro.meh.es/}np" minOccurs="0"/>
 *         &lt;element name="nm" type="{http://www.catastro.meh.es/}nm" minOccurs="0"/>
 *         &lt;element name="nem" type="{http://www.catastro.meh.es/}nem" minOccurs="0"/>
 *         &lt;element name="dir" type="{http://www.catastro.meh.es/}dir" minOccurs="0"/>
 *         &lt;element name="loint" type="{http://www.catastro.meh.es/}loint" minOccurs="0"/>
 *         &lt;element name="pos" type="{http://www.catastro.meh.es/}pos" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "df", propOrder = { "loine", "cmc", "np", "nm", "nem", "dir", "loint", "pos" })
@XmlSeeAlso({ Dfsp.class, Dfreps.class, Dfn.class })
public class Df {

	protected Loine loine;
	protected BigInteger cmc;
	protected String np;
	protected String nm;
	protected String nem;
	protected Dir dir;
	protected Loint loint;
	protected Pos pos;

	/**
	 * Gets the value of the loine property.
	 * 
	 * @return possible object is {@link Loine }
	 * 
	 */
	public Loine getLoine() {
		return loine;
	}

	/**
	 * Sets the value of the loine property.
	 * 
	 * @param value
	 *            allowed object is {@link Loine }
	 * 
	 */
	public void setLoine(Loine value) {
		this.loine = value;
	}

	/**
	 * Gets the value of the cmc property.
	 * 
	 * @return possible object is {@link BigInteger }
	 * 
	 */
	public BigInteger getCmc() {
		return cmc;
	}

	/**
	 * Sets the value of the cmc property.
	 * 
	 * @param value
	 *            allowed object is {@link BigInteger }
	 * 
	 */
	public void setCmc(BigInteger value) {
		this.cmc = value;
	}

	/**
	 * Gets the value of the np property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getNp() {
		return np;
	}

	/**
	 * Sets the value of the np property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setNp(String value) {
		this.np = value;
	}

	/**
	 * Gets the value of the nm property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getNm() {
		return nm;
	}

	/**
	 * Sets the value of the nm property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setNm(String value) {
		this.nm = value;
	}

	/**
	 * Gets the value of the nem property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getNem() {
		return nem;
	}

	/**
	 * Sets the value of the nem property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setNem(String value) {
		this.nem = value;
	}

	/**
	 * Gets the value of the dir property.
	 * 
	 * @return possible object is {@link Dir }
	 * 
	 */
	public Dir getDir() {
		return dir;
	}

	/**
	 * Sets the value of the dir property.
	 * 
	 * @param value
	 *            allowed object is {@link Dir }
	 * 
	 */
	public void setDir(Dir value) {
		this.dir = value;
	}

	/**
	 * Gets the value of the loint property.
	 * 
	 * @return possible object is {@link Loint }
	 * 
	 */
	public Loint getLoint() {
		return loint;
	}

	/**
	 * Sets the value of the loint property.
	 * 
	 * @param value
	 *            allowed object is {@link Loint }
	 * 
	 */
	public void setLoint(Loint value) {
		this.loint = value;
	}

	/**
	 * Gets the value of the pos property.
	 * 
	 * @return possible object is {@link Pos }
	 * 
	 */
	public Pos getPos() {
		return pos;
	}

	/**
	 * Sets the value of the pos property.
	 * 
	 * @param value
	 *            allowed object is {@link Pos }
	 * 
	 */
	public void setPos(Pos value) {
		this.pos = value;
	}

}
