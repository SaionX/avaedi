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
 * <p>
 * Java class for lourbfr complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="lourbfr">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.catastro.meh.es/}lourb">
 *       &lt;sequence>
 *         &lt;element name="dir" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.catastro.meh.es/}dir">
 *                 &lt;sequence>
 *                   &lt;element name="cv" type="{http://www.catastro.meh.es/}cv"/>
 *                   &lt;element name="tv" type="{http://www.catastro.meh.es/}tv"/>
 *                   &lt;element name="nv" type="{http://www.catastro.meh.es/}nv"/>
 *                   &lt;element name="pnp" type="{http://www.catastro.meh.es/}pnp" minOccurs="0"/>
 *                   &lt;element name="plp" type="{http://www.catastro.meh.es/}plp" minOccurs="0"/>
 *                   &lt;element name="snp" type="{http://www.catastro.meh.es/}snp" minOccurs="0"/>
 *                   &lt;element name="slp" type="{http://www.catastro.meh.es/}slp" minOccurs="0"/>
 *                   &lt;element name="km" type="{http://www.catastro.meh.es/}km" minOccurs="0"/>
 *                   &lt;element name="td" type="{http://www.catastro.meh.es/}dne" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="bl" type="{http://www.catastro.meh.es/}bq" minOccurs="0"/>
 *         &lt;element name="dp" type="{http://www.catastro.meh.es/}dp" minOccurs="0"/>
 *         &lt;element name="dm" type="{http://www.catastro.meh.es/}dm" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "lourbfr")
public class Lourbfr extends Lourb {

}
