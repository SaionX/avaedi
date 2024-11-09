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

import javax.persistence.Basic;
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
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.jvnet.hyperjaxb3.item.Item;
import org.jvnet.hyperjaxb3.item.ItemUtils;
import org.jvnet.jaxb2_commons.lang.Equals;
import org.jvnet.jaxb2_commons.lang.EqualsStrategy;
import org.jvnet.jaxb2_commons.lang.HashCode;
import org.jvnet.jaxb2_commons.lang.HashCodeStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBEqualsStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBHashCodeStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;
import org.jvnet.jaxb2_commons.locator.util.LocatorUtils;

/**
 * <p>
 * Clase Java para conservacion_datosgenerales_fechavisitasType complex type.
 * 
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que
 * haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="conservacion_datosgenerales_fechavisitasType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="fecha_visita" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "conservacion_datosgenerales_fechavisitasType", propOrder = { "fechaVisita" })
@Entity(name = "ConservacionDatosgeneralesFechavisitasType")
@Table(name = "AED_CONS_DATGEN_FECHAVISITAS")
@Inheritance(strategy = InheritanceType.JOINED)
public class ConservacionDatosgeneralesFechavisitasType implements Serializable, Equals, HashCode {

	@XmlElement(name = "fecha_visita")
	protected List<String> fechaVisita;
	@XmlAttribute(name = "Hjid")
	protected Long hjid;
	protected transient List<ConservacionDatosgeneralesFechavisitasType.ConservacionDatosgeneralesFechavisitasTypeFechaVisitaItem> fechaVisitaItems;

	/**
	 * Gets the value of the fechaVisita property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the fechaVisita property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getFechaVisita().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link String }
	 * 
	 * 
	 */
	@Transient
	public List<String> getFechaVisita() {
		if (fechaVisita == null) {
			fechaVisita = new ArrayList<String>();
		}
		return this.fechaVisita;
	}

	/**
     * 
     * 
     */
	public void setFechaVisita(List<String> fechaVisita) {
		this.fechaVisita = fechaVisita;
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

	@OneToMany(targetEntity = ConservacionDatosgeneralesFechavisitasType.ConservacionDatosgeneralesFechavisitasTypeFechaVisitaItem.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "FECHA_VISITA_ITEMS_AED_CONS_DATGEN_FECHAVISITAS_HJID")
	public List<ConservacionDatosgeneralesFechavisitasType.ConservacionDatosgeneralesFechavisitasTypeFechaVisitaItem> getFechaVisitaItems() {
		if (this.fechaVisitaItems == null) {
			this.fechaVisitaItems = new ArrayList<ConservacionDatosgeneralesFechavisitasType.ConservacionDatosgeneralesFechavisitasTypeFechaVisitaItem>();
		}
		if (ItemUtils.shouldBeWrapped(this.fechaVisita)) {
			this.fechaVisita = ItemUtils.wrap(this.fechaVisita, this.fechaVisitaItems, ConservacionDatosgeneralesFechavisitasType.ConservacionDatosgeneralesFechavisitasTypeFechaVisitaItem.class);
		}
		return this.fechaVisitaItems;
	}

	public void setFechaVisitaItems(List<ConservacionDatosgeneralesFechavisitasType.ConservacionDatosgeneralesFechavisitasTypeFechaVisitaItem> value) {
		this.fechaVisita = null;
		this.fechaVisitaItems = null;
		this.fechaVisitaItems = value;
		if (this.fechaVisitaItems == null) {
			this.fechaVisitaItems = new ArrayList<ConservacionDatosgeneralesFechavisitasType.ConservacionDatosgeneralesFechavisitasTypeFechaVisitaItem>();
		}
		if (ItemUtils.shouldBeWrapped(this.fechaVisita)) {
			this.fechaVisita = ItemUtils.wrap(this.fechaVisita, this.fechaVisitaItems, ConservacionDatosgeneralesFechavisitasType.ConservacionDatosgeneralesFechavisitasTypeFechaVisitaItem.class);
		}
	}

	public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
		if ((object == null) || (this.getClass() != object.getClass())) {
			return false;
		}
		if (this == object) {
			return true;
		}
		final ConservacionDatosgeneralesFechavisitasType that = ((ConservacionDatosgeneralesFechavisitasType) object);
		{
			List<String> lhsFechaVisita;
			lhsFechaVisita = (((this.fechaVisita != null) && (!this.fechaVisita.isEmpty())) ? this.getFechaVisita() : null);
			List<String> rhsFechaVisita;
			rhsFechaVisita = (((that.fechaVisita != null) && (!that.fechaVisita.isEmpty())) ? that.getFechaVisita() : null);
			if (!strategy.equals(LocatorUtils.property(thisLocator, "fechaVisita", lhsFechaVisita), LocatorUtils.property(thatLocator, "fechaVisita", rhsFechaVisita), lhsFechaVisita, rhsFechaVisita)) {
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
			List<String> theFechaVisita;
			theFechaVisita = (((this.fechaVisita != null) && (!this.fechaVisita.isEmpty())) ? this.getFechaVisita() : null);
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "fechaVisita", theFechaVisita), currentHashCode, theFechaVisita);
		}
		return currentHashCode;
	}

	public int hashCode() {
		final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
		return this.hashCode(null, strategy);
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@Entity(name = "ConservacionDatosgeneralesFechavisitasType$ConservacionDatosgeneralesFechavisitasTypeFechaVisitaItem")
	@Table(name = "AED_CONS_DATGEN_FECHAVISITAS_FECHA_VISITA_ITEM")
	@Inheritance(strategy = InheritanceType.JOINED)
	public static class ConservacionDatosgeneralesFechavisitasTypeFechaVisitaItem implements Serializable, Item<String> {

		@XmlElement(name = "fecha_visita")
		protected String item;
		@XmlAttribute(name = "Hjid")
		protected Long hjid;

		/**
		 * Obtiene el valor de la propiedad item.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		@Basic
		@Column(name = "ITEM", length = 255)
		public String getItem() {
			return item;
		}

		/**
		 * Define el valor de la propiedad item.
		 * 
		 * @param value
		 *            allowed object is {@link String }
		 * 
		 */
		public void setItem(String value) {
			this.item = value;
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

	}

}
