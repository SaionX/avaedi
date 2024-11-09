//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.11 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2016.09.08 a las 10:32:16 PM CEST 
//

package es.caib.avaedi.iee.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.jvnet.jaxb2_commons.lang.Equals;
import org.jvnet.jaxb2_commons.lang.EqualsStrategy;
import org.jvnet.jaxb2_commons.lang.HashCode;
import org.jvnet.jaxb2_commons.lang.HashCodeStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBEqualsStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBHashCodeStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;
import org.jvnet.jaxb2_commons.locator.util.LocatorUtils;

/**
 * <p>Clase Java para acustica_mejorasacusticasType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="acustica_mejorasacusticasType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="acustica_medidasmejoras" type="{}acustica_medidasmejorasType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "acustica_mejorasacusticasType", propOrder = { "acusticaMedidasmejoras" })
@Entity(name = "AcusticaMejorasacusticasType")
@Table(name = "AED_ACU_MEJORASACUSTICAS")
@Inheritance(strategy = InheritanceType.JOINED)
public class AcusticaMejorasacusticasType implements Serializable, Equals, HashCode {

    @XmlElement(name = "acustica_medidasmejoras")
    protected List<AcusticaMedidasmejorasType> acusticaMedidasmejoras;
	@XmlAttribute(name = "Hjid")
	protected Long hjid;

    /**
     * Gets the value of the acusticaMedidasmejoras property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the acusticaMedidasmejoras property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAcusticaMedidasmejoras().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AcusticaMedidasmejorasType }
     * 
     * 
     */
    @OneToMany(targetEntity = AcusticaMedidasmejorasType.class, cascade = {CascadeType.ALL})
    @JoinColumn(name = "ACUSTICA_MEDIDASMEJORAS_AED_ACU_MEJORASACUSTICAS_HJID")
    public List<AcusticaMedidasmejorasType> getAcusticaMedidasmejoras() {
        if (acusticaMedidasmejoras == null) {
            acusticaMedidasmejoras = new ArrayList<AcusticaMedidasmejorasType>();
        }
        return this.acusticaMedidasmejoras;
    }

    /**
     * 
     * 
     */
    public void setAcusticaMedidasmejoras(List<AcusticaMedidasmejorasType> acusticaMedidasmejoras) {
        this.acusticaMedidasmejoras = acusticaMedidasmejoras;
    }
	/**
	 * Obtiene el valor de la propiedad hjid.
	 * 
	 * @return possible object is {@link Long }
	 * 
	 */
	@Id
	@Column(name = "HJID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getHjid() {
		return hjid;
	}

	/**
	 * Define el valor de la propiedad hjid.
	 * 
	 * @param value
	 *            allowed object is {@link Long }
	 * 
	 */
	public void setHjid(Long value) {
		this.hjid = value;
	}

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final AcusticaMejorasacusticasType that = ((AcusticaMejorasacusticasType) object);
        {
            List<AcusticaMedidasmejorasType> lhsAcusticaMedidasmejoras;
            lhsAcusticaMedidasmejoras = (((this.acusticaMedidasmejoras!= null)&&(!this.acusticaMedidasmejoras.isEmpty()))?this.getAcusticaMedidasmejoras():null);
            List<AcusticaMedidasmejorasType> rhsAcusticaMedidasmejoras;
            rhsAcusticaMedidasmejoras = (((that.acusticaMedidasmejoras!= null)&&(!that.acusticaMedidasmejoras.isEmpty()))?that.getAcusticaMedidasmejoras():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "acusticaMedidasmejoras", lhsAcusticaMedidasmejoras), LocatorUtils.property(thatLocator, "acusticaMedidasmejoras", rhsAcusticaMedidasmejoras), lhsAcusticaMedidasmejoras, rhsAcusticaMedidasmejoras)) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object object) {
        final EqualsStrategy strategy = JAXBEqualsStrategy.INSTANCE;
        return equals(null, null, object, strategy);
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            List<AcusticaMedidasmejorasType> theAcusticaMedidasmejoras;
            theAcusticaMedidasmejoras = (((this.acusticaMedidasmejoras!= null)&&(!this.acusticaMedidasmejoras.isEmpty()))?this.getAcusticaMedidasmejoras():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "acusticaMedidasmejoras", theAcusticaMedidasmejoras), currentHashCode, theAcusticaMedidasmejoras);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }
}
