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
 * Java class for bijei complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="bijei">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.catastro.meh.es/}biji">
 *       &lt;sequence>
 *         &lt;element name="bi" type="{http://www.catastro.meh.es/}bii"/>
 *         &lt;element name="mov" type="{http://www.catastro.meh.es/}mov"/>
 *         &lt;element name="lsf" type="{http://www.catastro.meh.es/}lsfe"/>
 *         &lt;element name="lsi" type="{http://www.catastro.meh.es/}lsi" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bijei")
public class Bijei extends Biji {

}