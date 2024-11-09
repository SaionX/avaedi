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
 * Clase Java para estructuras_verticalpilaresType complex type.
 * 
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que
 * haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="estructuras_verticalpilaresType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int"&gt;
 *               &lt;enumeration value="1"/&gt;
 *               &lt;enumeration value="2"/&gt;
 *               &lt;enumeration value="3"/&gt;
 *               &lt;enumeration value="4"/&gt;
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
@XmlType(name = "estructuras_verticalpilaresType", propOrder = { "id" })
@Entity(name = "EstructurasVerticalpilaresType")
@Table(name = "AED_EVE_PILARES")
@Inheritance(strategy = InheritanceType.JOINED)
public class EstructurasVerticalpilaresType implements Serializable, Equals, HashCode {

	protected List<Integer> id;
	@XmlAttribute(name = "Hjid")
	protected Long hjid;
	protected transient List<EstructurasVerticalpilaresType.EstructurasVerticalpilaresTypeIdItem> idItems;

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

	@OneToMany(targetEntity = EstructurasVerticalpilaresType.EstructurasVerticalpilaresTypeIdItem.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "ID_ITEMS_AED_EVE_PILARES_HJID")
	public List<EstructurasVerticalpilaresType.EstructurasVerticalpilaresTypeIdItem> getIdItems() {
		if (this.idItems == null) {
			this.idItems = new ArrayList<EstructurasVerticalpilaresType.EstructurasVerticalpilaresTypeIdItem>();
		}
		if (ItemUtils.shouldBeWrapped(this.id)) {
			this.id = ItemUtils.wrap(this.id, this.idItems, EstructurasVerticalpilaresType.EstructurasVerticalpilaresTypeIdItem.class);
		}
		return this.idItems;
	}

	public void setIdItems(List<EstructurasVerticalpilaresType.EstructurasVerticalpilaresTypeIdItem> value) {
		this.id = null;
		this.idItems = null;
		this.idItems = value;
		if (this.idItems == null) {
			this.idItems = new ArrayList<EstructurasVerticalpilaresType.EstructurasVerticalpilaresTypeIdItem>();
		}
		if (ItemUtils.shouldBeWrapped(this.id)) {
			this.id = ItemUtils.wrap(this.id, this.idItems, EstructurasVerticalpilaresType.EstructurasVerticalpilaresTypeIdItem.class);
		}
	}

	public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
		if ((object == null) || (this.getClass() != object.getClass())) {
			return false;
		}
		if (this == object) {
			return true;
		}
		final EstructurasVerticalpilaresType that = ((EstructurasVerticalpilaresType) object);
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
	@Entity(name = "EstructurasVerticalpilaresType$EstructurasVerticalpilaresTypeIdItem")
	@Table(name = "AED_EVE_PILARES_ITEM")
	@Inheritance(strategy = InheritanceType.JOINED)
	public static class EstructurasVerticalpilaresTypeIdItem implements Serializable, Item<Integer> {

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
