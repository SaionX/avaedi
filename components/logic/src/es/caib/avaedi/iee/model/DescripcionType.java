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
 * Clase Java para descripcionType complex type.
 * 
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que
 * haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="descripcionType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="conservacion_sistemasconstructivos_tipo_id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="nombre_deficiencia" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="localizacion_deficiencia" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="descripcion_deficiencia" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="pruebas_ensayos_realizados" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="observaciones" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="deficiencia_tipo_id" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int"&gt;
 *               &lt;enumeration value="1"/&gt;
 *               &lt;enumeration value="2"/&gt;
 *               &lt;enumeration value="3"/&gt;
 *               &lt;enumeration value="4"/&gt;
 *               &lt;enumeration value="5"/&gt;
 *               &lt;enumeration value="6"/&gt;
 *               &lt;enumeration value="7"/&gt;
 *               &lt;enumeration value="8"/&gt;
 *               &lt;enumeration value="9"/&gt;
 *               &lt;enumeration value="10"/&gt;
 *               &lt;enumeration value="11"/&gt;
 *               &lt;enumeration value="12"/&gt;
 *               &lt;enumeration value="13"/&gt;
 *               &lt;enumeration value="14"/&gt;
 *               &lt;enumeration value="15"/&gt;
 *               &lt;enumeration value="16"/&gt;
 *               &lt;enumeration value="17"/&gt;
 *               &lt;enumeration value="18"/&gt;
 *               &lt;enumeration value="19"/&gt;
 *               &lt;enumeration value="20"/&gt;
 *               &lt;enumeration value="21"/&gt;
 *               &lt;enumeration value="22"/&gt;
 *               &lt;enumeration value="23"/&gt;
 *               &lt;enumeration value="24"/&gt;
 *               &lt;enumeration value="25"/&gt;
 *               &lt;enumeration value="26"/&gt;
 *               &lt;enumeration value="27"/&gt;
 *               &lt;enumeration value="28"/&gt;
 *               &lt;enumeration value="29"/&gt;
 *               &lt;enumeration value="30"/&gt;
 *               &lt;enumeration value="31"/&gt;
 *               &lt;enumeration value="32"/&gt;
 *               &lt;enumeration value="33"/&gt;
 *               &lt;enumeration value="34"/&gt;
 *               &lt;enumeration value="35"/&gt;
 *               &lt;enumeration value="36"/&gt;
 *               &lt;enumeration value="37"/&gt;
 *               &lt;enumeration value="38"/&gt;
 *               &lt;enumeration value="39"/&gt;
 *               &lt;enumeration value="40"/&gt;
 *               &lt;enumeration value="41"/&gt;
 *               &lt;enumeration value="42"/&gt;
 *               &lt;enumeration value="43"/&gt;
 *               &lt;enumeration value="44"/&gt;
 *               &lt;enumeration value="45"/&gt;
 *               &lt;enumeration value="46"/&gt;
 *               &lt;enumeration value="47"/&gt;
 *               &lt;enumeration value="48"/&gt;
 *               &lt;enumeration value="49"/&gt;
 *               &lt;enumeration value="50"/&gt;
 *               &lt;enumeration value="51"/&gt;
 *               &lt;enumeration value="52"/&gt;
 *               &lt;enumeration value="53"/&gt;
 *               &lt;enumeration value="54"/&gt;
 *               &lt;enumeration value="55"/&gt;
 *               &lt;enumeration value="56"/&gt;
 *               &lt;enumeration value="57"/&gt;
 *               &lt;enumeration value="58"/&gt;
 *               &lt;enumeration value="59"/&gt;
 *               &lt;enumeration value="60"/&gt;
 *               &lt;enumeration value="61"/&gt;
 *               &lt;enumeration value="62"/&gt;
 *               &lt;enumeration value="63"/&gt;
 *               &lt;enumeration value="64"/&gt;
 *               &lt;enumeration value="65"/&gt;
 *               &lt;enumeration value="66"/&gt;
 *               &lt;enumeration value="67"/&gt;
 *               &lt;enumeration value="68"/&gt;
 *               &lt;enumeration value="69"/&gt;
 *               &lt;enumeration value="70"/&gt;
 *               &lt;enumeration value="71"/&gt;
 *               &lt;enumeration value="72"/&gt;
 *               &lt;enumeration value="73"/&gt;
 *               &lt;enumeration value="74"/&gt;
 *               &lt;enumeration value="75"/&gt;
 *               &lt;enumeration value="76"/&gt;
 *               &lt;enumeration value="77"/&gt;
 *               &lt;enumeration value="78"/&gt;
 *               &lt;enumeration value="79"/&gt;
 *               &lt;enumeration value="80"/&gt;
 *               &lt;enumeration value="81"/&gt;
 *               &lt;enumeration value="82"/&gt;
 *               &lt;enumeration value="83"/&gt;
 *               &lt;enumeration value="84"/&gt;
 *               &lt;enumeration value="85"/&gt;
 *               &lt;enumeration value="86"/&gt;
 *               &lt;enumeration value="87"/&gt;
 *               &lt;enumeration value="88"/&gt;
 *               &lt;enumeration value="89"/&gt;
 *               &lt;enumeration value="90"/&gt;
 *               &lt;enumeration value="91"/&gt;
 *               &lt;enumeration value="92"/&gt;
 *               &lt;enumeration value="93"/&gt;
 *               &lt;enumeration value="94"/&gt;
 *               &lt;enumeration value="95"/&gt;
 *               &lt;enumeration value="96"/&gt;
 *               &lt;enumeration value="97"/&gt;
 *               &lt;enumeration value="98"/&gt;
 *               &lt;enumeration value="99"/&gt;
 *               &lt;enumeration value="100"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="es_grave" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "descripcionType", propOrder = { "conservacionSistemasconstructivosTipoId", "nombreDeficiencia", "localizacionDeficiencia", "descripcionDeficiencia", "pruebasEnsayosRealizados", "observaciones", "deficienciaTipoId", "esGrave" })
@Entity(name = "DescripcionType")
@Table(name = "AED_DESCRIPCION")
@Inheritance(strategy = InheritanceType.JOINED)
public class DescripcionType implements Serializable, Equals, HashCode {

	@XmlElement(name = "conservacion_sistemasconstructivos_tipo_id")
	protected int conservacionSistemasconstructivosTipoId;
	@XmlElement(name = "nombre_deficiencia", required = true)
	protected String nombreDeficiencia;
	@XmlElement(name = "localizacion_deficiencia", required = true)
	protected String localizacionDeficiencia;
	@XmlElement(name = "descripcion_deficiencia", required = true)
	protected String descripcionDeficiencia;
	@XmlElement(name = "pruebas_ensayos_realizados", required = true)
	protected String pruebasEnsayosRealizados;
	@XmlElement(required = true)
	protected String observaciones;
	@XmlElement(name = "deficiencia_tipo_id")
	protected List<Integer> deficienciaTipoId;
	@XmlElement(name = "es_grave")
	protected int esGrave;
	@XmlAttribute(name = "Hjid")
	protected Long hjid;
	protected transient List<DescripcionType.DescripcionTypeDeficienciaTipoIdItem> deficienciaTipoIdItems;

	/**
	 * Obtiene el valor de la propiedad conservacionSistemasconstructivosTipoId.
	 * 
	 */
	@Basic
	@Column(name = "CONSERVACION_SISTEMASCONSTRUCTIVOS_TIPO_ID", precision = 10, scale = 0)
	public int getConservacionSistemasconstructivosTipoId() {
		return conservacionSistemasconstructivosTipoId;
	}

	/**
	 * Define el valor de la propiedad conservacionSistemasconstructivosTipoId.
	 * 
	 */
	public void setConservacionSistemasconstructivosTipoId(int value) {
		this.conservacionSistemasconstructivosTipoId = value;
	}

	/**
	 * Obtiene el valor de la propiedad nombreDeficiencia.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "NOMBRE_DEFICIENCIA", length = 255)
	public String getNombreDeficiencia() {
		return nombreDeficiencia;
	}

	/**
	 * Define el valor de la propiedad nombreDeficiencia.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setNombreDeficiencia(String value) {
		this.nombreDeficiencia = value;
	}

	/**
	 * Obtiene el valor de la propiedad localizacionDeficiencia.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "LOCALIZACION_DEFICIENCIA", length = 255)
	public String getLocalizacionDeficiencia() {
		return localizacionDeficiencia;
	}

	/**
	 * Define el valor de la propiedad localizacionDeficiencia.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setLocalizacionDeficiencia(String value) {
		this.localizacionDeficiencia = value;
	}

	/**
	 * Obtiene el valor de la propiedad descripcionDeficiencia.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "DESCRIPCION_DEFICIENCIA", length = 255)
	public String getDescripcionDeficiencia() {
		return descripcionDeficiencia;
	}

	/**
	 * Define el valor de la propiedad descripcionDeficiencia.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDescripcionDeficiencia(String value) {
		this.descripcionDeficiencia = value;
	}

	/**
	 * Obtiene el valor de la propiedad pruebasEnsayosRealizados.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "PRUEBAS_ENSAYOS_REALIZADOS", length = 255)
	public String getPruebasEnsayosRealizados() {
		return pruebasEnsayosRealizados;
	}

	/**
	 * Define el valor de la propiedad pruebasEnsayosRealizados.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPruebasEnsayosRealizados(String value) {
		this.pruebasEnsayosRealizados = value;
	}

	/**
	 * Obtiene el valor de la propiedad observaciones.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "OBSERVACIONES", length = 255)
	public String getObservaciones() {
		return observaciones;
	}

	/**
	 * Define el valor de la propiedad observaciones.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setObservaciones(String value) {
		this.observaciones = value;
	}

	/**
	 * Gets the value of the deficienciaTipoId property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the deficienciaTipoId property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getDeficienciaTipoId().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link Integer }
	 * 
	 * 
	 */
	@Transient
	public List<Integer> getDeficienciaTipoId() {
		if (deficienciaTipoId == null) {
			deficienciaTipoId = new ArrayList<Integer>();
		}
		return this.deficienciaTipoId;
	}

	/**
     * 
     * 
     */
	public void setDeficienciaTipoId(List<Integer> deficienciaTipoId) {
		this.deficienciaTipoId = deficienciaTipoId;
	}

	/**
	 * Obtiene el valor de la propiedad esGrave.
	 * 
	 */
	@Basic
	@Column(name = "ES_GRAVE", precision = 10, scale = 0)
	public int getEsGrave() {
		return esGrave;
	}

	/**
	 * Define el valor de la propiedad esGrave.
	 * 
	 */
	public void setEsGrave(int value) {
		this.esGrave = value;
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

	@OneToMany(targetEntity = DescripcionType.DescripcionTypeDeficienciaTipoIdItem.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "DEFICIENCIA_TIPO_ID_ITEMS_AED_DESCRIPCION_HJID")
	public List<DescripcionType.DescripcionTypeDeficienciaTipoIdItem> getDeficienciaTipoIdItems() {
		if (this.deficienciaTipoIdItems == null) {
			this.deficienciaTipoIdItems = new ArrayList<DescripcionType.DescripcionTypeDeficienciaTipoIdItem>();
		}
		if (ItemUtils.shouldBeWrapped(this.deficienciaTipoId)) {
			this.deficienciaTipoId = ItemUtils.wrap(this.deficienciaTipoId, this.deficienciaTipoIdItems, DescripcionType.DescripcionTypeDeficienciaTipoIdItem.class);
		}
		return this.deficienciaTipoIdItems;
	}

	public void setDeficienciaTipoIdItems(List<DescripcionType.DescripcionTypeDeficienciaTipoIdItem> value) {
		this.deficienciaTipoId = null;
		this.deficienciaTipoIdItems = null;
		this.deficienciaTipoIdItems = value;
		if (this.deficienciaTipoIdItems == null) {
			this.deficienciaTipoIdItems = new ArrayList<DescripcionType.DescripcionTypeDeficienciaTipoIdItem>();
		}
		if (ItemUtils.shouldBeWrapped(this.deficienciaTipoId)) {
			this.deficienciaTipoId = ItemUtils.wrap(this.deficienciaTipoId, this.deficienciaTipoIdItems, DescripcionType.DescripcionTypeDeficienciaTipoIdItem.class);
		}
	}

	public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
		if ((object == null) || (this.getClass() != object.getClass())) {
			return false;
		}
		if (this == object) {
			return true;
		}
		final DescripcionType that = ((DescripcionType) object);
		{
			int lhsConservacionSistemasconstructivosTipoId;
			lhsConservacionSistemasconstructivosTipoId = this.getConservacionSistemasconstructivosTipoId();
			int rhsConservacionSistemasconstructivosTipoId;
			rhsConservacionSistemasconstructivosTipoId = that.getConservacionSistemasconstructivosTipoId();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "conservacionSistemasconstructivosTipoId", lhsConservacionSistemasconstructivosTipoId), LocatorUtils.property(thatLocator, "conservacionSistemasconstructivosTipoId", rhsConservacionSistemasconstructivosTipoId), lhsConservacionSistemasconstructivosTipoId, rhsConservacionSistemasconstructivosTipoId)) {
				return false;
			}
		}
		{
			String lhsNombreDeficiencia;
			lhsNombreDeficiencia = this.getNombreDeficiencia();
			String rhsNombreDeficiencia;
			rhsNombreDeficiencia = that.getNombreDeficiencia();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "nombreDeficiencia", lhsNombreDeficiencia), LocatorUtils.property(thatLocator, "nombreDeficiencia", rhsNombreDeficiencia), lhsNombreDeficiencia, rhsNombreDeficiencia)) {
				return false;
			}
		}
		{
			String lhsLocalizacionDeficiencia;
			lhsLocalizacionDeficiencia = this.getLocalizacionDeficiencia();
			String rhsLocalizacionDeficiencia;
			rhsLocalizacionDeficiencia = that.getLocalizacionDeficiencia();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "localizacionDeficiencia", lhsLocalizacionDeficiencia), LocatorUtils.property(thatLocator, "localizacionDeficiencia", rhsLocalizacionDeficiencia), lhsLocalizacionDeficiencia, rhsLocalizacionDeficiencia)) {
				return false;
			}
		}
		{
			String lhsDescripcionDeficiencia;
			lhsDescripcionDeficiencia = this.getDescripcionDeficiencia();
			String rhsDescripcionDeficiencia;
			rhsDescripcionDeficiencia = that.getDescripcionDeficiencia();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "descripcionDeficiencia", lhsDescripcionDeficiencia), LocatorUtils.property(thatLocator, "descripcionDeficiencia", rhsDescripcionDeficiencia), lhsDescripcionDeficiencia, rhsDescripcionDeficiencia)) {
				return false;
			}
		}
		{
			String lhsPruebasEnsayosRealizados;
			lhsPruebasEnsayosRealizados = this.getPruebasEnsayosRealizados();
			String rhsPruebasEnsayosRealizados;
			rhsPruebasEnsayosRealizados = that.getPruebasEnsayosRealizados();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "pruebasEnsayosRealizados", lhsPruebasEnsayosRealizados), LocatorUtils.property(thatLocator, "pruebasEnsayosRealizados", rhsPruebasEnsayosRealizados), lhsPruebasEnsayosRealizados, rhsPruebasEnsayosRealizados)) {
				return false;
			}
		}
		{
			String lhsObservaciones;
			lhsObservaciones = this.getObservaciones();
			String rhsObservaciones;
			rhsObservaciones = that.getObservaciones();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "observaciones", lhsObservaciones), LocatorUtils.property(thatLocator, "observaciones", rhsObservaciones), lhsObservaciones, rhsObservaciones)) {
				return false;
			}
		}
		{
			List<Integer> lhsDeficienciaTipoId;
			lhsDeficienciaTipoId = (((this.deficienciaTipoId != null) && (!this.deficienciaTipoId.isEmpty())) ? this.getDeficienciaTipoId() : null);
			List<Integer> rhsDeficienciaTipoId;
			rhsDeficienciaTipoId = (((that.deficienciaTipoId != null) && (!that.deficienciaTipoId.isEmpty())) ? that.getDeficienciaTipoId() : null);
			if (!strategy.equals(LocatorUtils.property(thisLocator, "deficienciaTipoId", lhsDeficienciaTipoId), LocatorUtils.property(thatLocator, "deficienciaTipoId", rhsDeficienciaTipoId), lhsDeficienciaTipoId, rhsDeficienciaTipoId)) {
				return false;
			}
		}
		{
			int lhsEsGrave;
			lhsEsGrave = this.getEsGrave();
			int rhsEsGrave;
			rhsEsGrave = that.getEsGrave();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "esGrave", lhsEsGrave), LocatorUtils.property(thatLocator, "esGrave", rhsEsGrave), lhsEsGrave, rhsEsGrave)) {
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
			int theConservacionSistemasconstructivosTipoId;
			theConservacionSistemasconstructivosTipoId = this.getConservacionSistemasconstructivosTipoId();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "conservacionSistemasconstructivosTipoId", theConservacionSistemasconstructivosTipoId), currentHashCode, theConservacionSistemasconstructivosTipoId);
		}
		{
			String theNombreDeficiencia;
			theNombreDeficiencia = this.getNombreDeficiencia();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "nombreDeficiencia", theNombreDeficiencia), currentHashCode, theNombreDeficiencia);
		}
		{
			String theLocalizacionDeficiencia;
			theLocalizacionDeficiencia = this.getLocalizacionDeficiencia();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "localizacionDeficiencia", theLocalizacionDeficiencia), currentHashCode, theLocalizacionDeficiencia);
		}
		{
			String theDescripcionDeficiencia;
			theDescripcionDeficiencia = this.getDescripcionDeficiencia();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "descripcionDeficiencia", theDescripcionDeficiencia), currentHashCode, theDescripcionDeficiencia);
		}
		{
			String thePruebasEnsayosRealizados;
			thePruebasEnsayosRealizados = this.getPruebasEnsayosRealizados();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "pruebasEnsayosRealizados", thePruebasEnsayosRealizados), currentHashCode, thePruebasEnsayosRealizados);
		}
		{
			String theObservaciones;
			theObservaciones = this.getObservaciones();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "observaciones", theObservaciones), currentHashCode, theObservaciones);
		}
		{
			List<Integer> theDeficienciaTipoId;
			theDeficienciaTipoId = (((this.deficienciaTipoId != null) && (!this.deficienciaTipoId.isEmpty())) ? this.getDeficienciaTipoId() : null);
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "deficienciaTipoId", theDeficienciaTipoId), currentHashCode, theDeficienciaTipoId);
		}
		{
			int theEsGrave;
			theEsGrave = this.getEsGrave();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "esGrave", theEsGrave), currentHashCode, theEsGrave);
		}
		return currentHashCode;
	}

	public int hashCode() {
		final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
		return this.hashCode(null, strategy);
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@Entity(name = "DescripcionType$DescripcionTypeDeficienciaTipoIdItem")
	@Table(name = "AED_DESCRIPCION_DEFICIENCIA_TIPO_ID_ITEM")
	@Inheritance(strategy = InheritanceType.JOINED)
	public static class DescripcionTypeDeficienciaTipoIdItem implements Serializable, Item<Integer> {

		@XmlElement(name = "deficiencia_tipo_id")
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
