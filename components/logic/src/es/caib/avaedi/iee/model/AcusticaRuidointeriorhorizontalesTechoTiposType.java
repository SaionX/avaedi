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
 * Clase Java para acustica_ruidointeriorhorizontales_techo_tiposType complex
 * type.
 * 
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que
 * haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="acustica_ruidointeriorhorizontales_techo_tiposType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int"&gt;
 *               &lt;enumeration value="1"/&gt;
 *               &lt;enumeration value="2"/&gt;
 *               &lt;enumeration value="3"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "acustica_ruidointeriorhorizontales_techo_tiposType", propOrder = { "id" })
@Entity(name = "AcusticaRuidointeriorhorizontalesTechoTiposType")
@Table(name = "AED_ACU_RUIINTHOR_TECHO_TIP")
@Inheritance(strategy = InheritanceType.JOINED)
public class AcusticaRuidointeriorhorizontalesTechoTiposType implements Serializable, Equals, HashCode {

	protected List<Integer> id;
	@XmlAttribute(name = "Hjid")
	protected Long hjid;
	protected transient List<AcusticaRuidointeriorhorizontalesTechoTiposType.AcusticaRuidointeriorhorizontalesTechoTiposTypeIdItem> idItems;

	/**
	 * Gets the value of the id property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the id property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getId().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link Integer }
	 * 
	 * 
	 */
	@Transient
	public List<Integer> getId() {
		if (id == null) {
			id = new ArrayList<Integer>();
		}
		return this.id;
	}

	/**
     * 
     * 
     */
	public void setId(List<Integer> id) {
		this.id = id;
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

	@OneToMany(targetEntity = AcusticaRuidointeriorhorizontalesTechoTiposType.AcusticaRuidointeriorhorizontalesTechoTiposTypeIdItem.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "ID_ITEMS_AED_ACU_RUIINTHOR_TECHO_TIP_HJID")
	public List<AcusticaRuidointeriorhorizontalesTechoTiposType.AcusticaRuidointeriorhorizontalesTechoTiposTypeIdItem> getIdItems() {
		if (this.idItems == null) {
			this.idItems = new ArrayList<AcusticaRuidointeriorhorizontalesTechoTiposType.AcusticaRuidointeriorhorizontalesTechoTiposTypeIdItem>();
		}
		if (ItemUtils.shouldBeWrapped(this.id)) {
			this.id = ItemUtils.wrap(this.id, this.idItems, AcusticaRuidointeriorhorizontalesTechoTiposType.AcusticaRuidointeriorhorizontalesTechoTiposTypeIdItem.class);
		}
		return this.idItems;
	}

	public void setIdItems(List<AcusticaRuidointeriorhorizontalesTechoTiposType.AcusticaRuidointeriorhorizontalesTechoTiposTypeIdItem> value) {
		this.id = null;
		this.idItems = null;
		this.idItems = value;
		if (this.idItems == null) {
			this.idItems = new ArrayList<AcusticaRuidointeriorhorizontalesTechoTiposType.AcusticaRuidointeriorhorizontalesTechoTiposTypeIdItem>();
		}
		if (ItemUtils.shouldBeWrapped(this.id)) {
			this.id = ItemUtils.wrap(this.id, this.idItems, AcusticaRuidointeriorhorizontalesTechoTiposType.AcusticaRuidointeriorhorizontalesTechoTiposTypeIdItem.class);
		}
	}

	public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
		if ((object == null) || (this.getClass() != object.getClass())) {
			return false;
		}
		if (this == object) {
			return true;
		}
		final AcusticaRuidointeriorhorizontalesTechoTiposType that = ((AcusticaRuidointeriorhorizontalesTechoTiposType) object);
		{
			List<Integer> lhsId;
			lhsId = (((this.id != null) && (!this.id.isEmpty())) ? this.getId() : null);
			List<Integer> rhsId;
			rhsId = (((that.id != null) && (!that.id.isEmpty())) ? that.getId() : null);
			if (!strategy.equals(LocatorUtils.property(thisLocator, "id", lhsId), LocatorUtils.property(thatLocator, "id", rhsId), lhsId, rhsId)) {
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
			List<Integer> theId;
			theId = (((this.id != null) && (!this.id.isEmpty())) ? this.getId() : null);
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "id", theId), currentHashCode, theId);
		}
		return currentHashCode;
	}

	public int hashCode() {
		final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
		return this.hashCode(null, strategy);
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@Entity(name = "AcusticaRuidointeriorhorizontalesTechoTiposType$AcusticaRuidointeriorhorizontalesTechoTiposTypeIdItem")
	@Table(name = "AED_ACU_RUIINTHOR_TECHO_TIP_ITEM")
	@Inheritance(strategy = InheritanceType.JOINED)
	public static class AcusticaRuidointeriorhorizontalesTechoTiposTypeIdItem implements Serializable, Item<Integer> {

		@XmlElement(name = "id")
		protected Integer item;
		@XmlAttribute(name = "Hjid")
		protected Long hjid;

		/**
		 * Obtiene el valor de la propiedad item.
		 * 
		 * @return possible object is {@link Integer }
		 * 
		 */
		@Basic
		@Column(name = "ITEM")
		public Integer getItem() {
			return item;
		}

		/**
		 * Define el valor de la propiedad item.
		 * 
		 * @param value
		 *            allowed object is {@link Integer }
		 * 
		 */
		public void setItem(Integer value) {
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
