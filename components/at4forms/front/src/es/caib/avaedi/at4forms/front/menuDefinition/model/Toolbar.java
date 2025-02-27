//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.07.10 at 07:38:55 PM CEST 
//


package es.caib.avaedi.at4forms.front.menuDefinition.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Toolbar complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Toolbar">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="unbounded">
 *         &lt;element ref="{}LINK" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{}FORM" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/choice>
 *       &lt;attribute name="PERMS" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="TITLE" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="CONTEXT" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Toolbar", propOrder = {
    "linkOrFORM"
})
public class Toolbar {

    @XmlElements({
        @XmlElement(name = "LINK", type = Link.class),
        @XmlElement(name = "FORM", type = Form.class)
    })
    protected List<Object> linkOrFORM;
    @XmlAttribute(name = "PERMS")
    protected String perms;
    @XmlAttribute(name = "TITLE", required = true)
    protected String title;
    @XmlAttribute(name = "CONTEXT")
    protected String context;

    /**
     * Gets the value of the linkOrFORM property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the linkOrFORM property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLINKOrFORM().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Link }
     * {@link Form }
     * 
     * 
     */
    public List<Object> getLINKOrFORM() {
        if (linkOrFORM == null) {
            linkOrFORM = new ArrayList<Object>();
        }
        return this.linkOrFORM;
    }

    /**
     * Gets the value of the perms property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPERMS() {
        return perms;
    }

    /**
     * Sets the value of the perms property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPERMS(String value) {
        this.perms = value;
    }

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTITLE() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTITLE(String value) {
        this.title = value;
    }

    /**
     * Gets the value of the context property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCONTEXT() {
        return context;
    }

    /**
     * Sets the value of the context property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCONTEXT(String value) {
        this.context = value;
    }

}
