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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Form complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Form">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence maxOccurs="unbounded" minOccurs="0">
 *         &lt;element ref="{}SEARCH"/>
 *       &lt;/sequence>
 *       &lt;attribute name="MODE" type="{}Mode" default="plain" />
 *       &lt;attribute name="PERMS" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="TABLE" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
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
@XmlType(name = "Form", propOrder = {
    "search"
})
public class Form {

    @XmlElement(name = "SEARCH")
    protected List<Search> search;
    @XmlAttribute(name = "MODE")
    protected Mode mode;
    @XmlAttribute(name = "PERMS")
    protected String perms;
    @XmlAttribute(name = "TABLE", required = true)
    protected String table;
    @XmlAttribute(name = "TITLE", required = true)
    protected String title;
    @XmlAttribute(name = "CONTEXT")
    protected String context;
    @XmlAttribute(name = "ICON")
    protected String icon;

    /**
     * Gets the value of the search property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the search property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSEARCH().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Search }
     * 
     * 
     */
    public List<Search> getSEARCH() {
        if (search == null) {
            search = new ArrayList<Search>();
        }
        return this.search;
    }

    /**
     * Gets the value of the mode property.
     * 
     * @return
     *     possible object is
     *     {@link Mode }
     *     
     */
    public Mode getMODE() {
        if (mode == null) {
            return Mode.PLAIN;
        } else {
            return mode;
        }
    }

    /**
     * Sets the value of the mode property.
     * 
     * @param value
     *     allowed object is
     *     {@link Mode }
     *     
     */
    public void setMODE(Mode value) {
        this.mode = value;
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
     * Gets the value of the table property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTABLE() {
        return table;
    }

    /**
     * Sets the value of the table property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTABLE(String value) {
        this.table = value;
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
    /**
     * Gets the value of the icon property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getICON() {
        return icon;
    }

    /**
     * Sets the value of the icon property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setICON(String value) {
        this.icon = value;
    }


}
