//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.08.05 at 02:00:57 PM CEST 
//

package es.caib.avaedi.meh.catastro;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for locsoo complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="locsoo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.catastro.meh.es/}locs">
 *       &lt;choice>
 *         &lt;element name="lous">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.catastro.meh.es/}lous">
 *                 &lt;sequence>
 *                   &lt;element name="lourb" type="{http://www.catastro.meh.es/}lourboo"/>
 *                   &lt;element name="lorus" type="{http://www.catastro.meh.es/}lorusoo" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="lors">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.catastro.meh.es/}lors">
 *                 &lt;sequence>
 *                   &lt;element name="lorus" type="{http://www.catastro.meh.es/}lorusroo"/>
 *                   &lt;element name="lourb" type="{http://www.catastro.meh.es/}lourbroo" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "locsoo")
public class Locsoo extends Locs {

}
