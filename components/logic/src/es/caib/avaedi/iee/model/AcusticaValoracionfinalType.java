//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.11 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2016.09.08 a las 10:32:16 PM CEST 
//

package es.caib.avaedi.iee.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
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
 * <p>
 * Clase Java para acustica_valoracionfinalType complex type.
 * 
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que
 * haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="acustica_valoracionfinalType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="proteccion_ruido_exterior_tipo_id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="proteccion_ruido_interior_aereo_vertical_tipo_id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="proteccion_ruido_interior_aereo_horizontal_tipo_id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="proteccion_ruido_interior_impactos_vertical_tipo_id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="proteccion_ruido_interior_impactos_horizontal_tipo_id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="proteccion_ruido_instalaciones_tipo_id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="observaciones" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "acustica_valoracionfinalType", propOrder = { "proteccionRuidoExteriorTipoId", "proteccionRuidoInteriorAereoVerticalTipoId", "proteccionRuidoInteriorAereoHorizontalTipoId", "proteccionRuidoInteriorImpactosVerticalTipoId", "proteccionRuidoInteriorImpactosHorizontalTipoId", "proteccionRuidoInstalacionesTipoId", "observaciones" })
@Entity(name = "AcusticaValoracionfinalType")
@Table(name = "AED_ACU_VALORACIONFINAL")
@Inheritance(strategy = InheritanceType.JOINED)
public class AcusticaValoracionfinalType implements Serializable, Equals, HashCode {

	@XmlElement(name = "proteccion_ruido_exterior_tipo_id")
	protected int proteccionRuidoExteriorTipoId;
	@XmlElement(name = "proteccion_ruido_interior_aereo_vertical_tipo_id")
	protected int proteccionRuidoInteriorAereoVerticalTipoId;
	@XmlElement(name = "proteccion_ruido_interior_aereo_horizontal_tipo_id")
	protected int proteccionRuidoInteriorAereoHorizontalTipoId;
	@XmlElement(name = "proteccion_ruido_interior_impactos_vertical_tipo_id")
	protected int proteccionRuidoInteriorImpactosVerticalTipoId;
	@XmlElement(name = "proteccion_ruido_interior_impactos_horizontal_tipo_id")
	protected int proteccionRuidoInteriorImpactosHorizontalTipoId;
	@XmlElement(name = "proteccion_ruido_instalaciones_tipo_id")
	protected int proteccionRuidoInstalacionesTipoId;
	@XmlElement(required = true)
	protected String observaciones;
	@XmlAttribute(name = "Hjid")
	protected Long hjid;

	/**
	 * Obtiene el valor de la propiedad proteccionRuidoExteriorTipoId.
	 * 
	 */
	@Basic
	@Column(name = "PROTECCION_RUIDO_EXTERIOR_TIPO_ID", precision = 10, scale = 0)
	public int getProteccionRuidoExteriorTipoId() {
		return proteccionRuidoExteriorTipoId;
	}

	/**
	 * Define el valor de la propiedad proteccionRuidoExteriorTipoId.
	 * 
	 */
	public void setProteccionRuidoExteriorTipoId(int value) {
		this.proteccionRuidoExteriorTipoId = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * proteccionRuidoInteriorAereoVerticalTipoId.
	 * 
	 */
	@Basic
	@Column(name = "PROTECCION_RUIDO_INTERIOR_AEREO_VERTICAL_TIPO_ID", precision = 10, scale = 0)
	public int getProteccionRuidoInteriorAereoVerticalTipoId() {
		return proteccionRuidoInteriorAereoVerticalTipoId;
	}

	/**
	 * Define el valor de la propiedad
	 * proteccionRuidoInteriorAereoVerticalTipoId.
	 * 
	 */
	public void setProteccionRuidoInteriorAereoVerticalTipoId(int value) {
		this.proteccionRuidoInteriorAereoVerticalTipoId = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * proteccionRuidoInteriorAereoHorizontalTipoId.
	 * 
	 */
	@Basic
	@Column(name = "PROTECCION_RUIDO_INTERIOR_AEREO_HORIZONTAL_TIPO_ID", precision = 10, scale = 0)
	public int getProteccionRuidoInteriorAereoHorizontalTipoId() {
		return proteccionRuidoInteriorAereoHorizontalTipoId;
	}

	/**
	 * Define el valor de la propiedad
	 * proteccionRuidoInteriorAereoHorizontalTipoId.
	 * 
	 */
	public void setProteccionRuidoInteriorAereoHorizontalTipoId(int value) {
		this.proteccionRuidoInteriorAereoHorizontalTipoId = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * proteccionRuidoInteriorImpactosVerticalTipoId.
	 * 
	 */
	@Basic
	@Column(name = "PROTECCION_RUIDO_INTERIOR_IMPACTOS_VERTICAL_TIPO_ID", precision = 10, scale = 0)
	public int getProteccionRuidoInteriorImpactosVerticalTipoId() {
		return proteccionRuidoInteriorImpactosVerticalTipoId;
	}

	/**
	 * Define el valor de la propiedad
	 * proteccionRuidoInteriorImpactosVerticalTipoId.
	 * 
	 */
	public void setProteccionRuidoInteriorImpactosVerticalTipoId(int value) {
		this.proteccionRuidoInteriorImpactosVerticalTipoId = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * proteccionRuidoInteriorImpactosHorizontalTipoId.
	 * 
	 */
	@Basic
	@Column(name = "PROTECCION_RUIDO_INTERIOR_IMPACTOS_HORIZONTAL_TIPO_ID", precision = 10, scale = 0)
	public int getProteccionRuidoInteriorImpactosHorizontalTipoId() {
		return proteccionRuidoInteriorImpactosHorizontalTipoId;
	}

	/**
	 * Define el valor de la propiedad
	 * proteccionRuidoInteriorImpactosHorizontalTipoId.
	 * 
	 */
	public void setProteccionRuidoInteriorImpactosHorizontalTipoId(int value) {
		this.proteccionRuidoInteriorImpactosHorizontalTipoId = value;
	}

	/**
	 * Obtiene el valor de la propiedad proteccionRuidoInstalacionesTipoId.
	 * 
	 */
	@Basic
	@Column(name = "PROTECCION_RUIDO_INSTALACIONES_TIPO_ID", precision = 10, scale = 0)
	public int getProteccionRuidoInstalacionesTipoId() {
		return proteccionRuidoInstalacionesTipoId;
	}

	/**
	 * Define el valor de la propiedad proteccionRuidoInstalacionesTipoId.
	 * 
	 */
	public void setProteccionRuidoInstalacionesTipoId(int value) {
		this.proteccionRuidoInstalacionesTipoId = value;
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
		if ((object == null) || (this.getClass() != object.getClass())) {
			return false;
		}
		if (this == object) {
			return true;
		}
		final AcusticaValoracionfinalType that = ((AcusticaValoracionfinalType) object);
		{
			int lhsProteccionRuidoExteriorTipoId;
			lhsProteccionRuidoExteriorTipoId = this.getProteccionRuidoExteriorTipoId();
			int rhsProteccionRuidoExteriorTipoId;
			rhsProteccionRuidoExteriorTipoId = that.getProteccionRuidoExteriorTipoId();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "proteccionRuidoExteriorTipoId", lhsProteccionRuidoExteriorTipoId), LocatorUtils.property(thatLocator, "proteccionRuidoExteriorTipoId", rhsProteccionRuidoExteriorTipoId), lhsProteccionRuidoExteriorTipoId, rhsProteccionRuidoExteriorTipoId)) {
				return false;
			}
		}
		{
			int lhsProteccionRuidoInteriorAereoVerticalTipoId;
			lhsProteccionRuidoInteriorAereoVerticalTipoId = this.getProteccionRuidoInteriorAereoVerticalTipoId();
			int rhsProteccionRuidoInteriorAereoVerticalTipoId;
			rhsProteccionRuidoInteriorAereoVerticalTipoId = that.getProteccionRuidoInteriorAereoVerticalTipoId();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "proteccionRuidoInteriorAereoVerticalTipoId", lhsProteccionRuidoInteriorAereoVerticalTipoId), LocatorUtils.property(thatLocator, "proteccionRuidoInteriorAereoVerticalTipoId", rhsProteccionRuidoInteriorAereoVerticalTipoId), lhsProteccionRuidoInteriorAereoVerticalTipoId, rhsProteccionRuidoInteriorAereoVerticalTipoId)) {
				return false;
			}
		}
		{
			int lhsProteccionRuidoInteriorAereoHorizontalTipoId;
			lhsProteccionRuidoInteriorAereoHorizontalTipoId = this.getProteccionRuidoInteriorAereoHorizontalTipoId();
			int rhsProteccionRuidoInteriorAereoHorizontalTipoId;
			rhsProteccionRuidoInteriorAereoHorizontalTipoId = that.getProteccionRuidoInteriorAereoHorizontalTipoId();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "proteccionRuidoInteriorAereoHorizontalTipoId", lhsProteccionRuidoInteriorAereoHorizontalTipoId), LocatorUtils.property(thatLocator, "proteccionRuidoInteriorAereoHorizontalTipoId", rhsProteccionRuidoInteriorAereoHorizontalTipoId), lhsProteccionRuidoInteriorAereoHorizontalTipoId, rhsProteccionRuidoInteriorAereoHorizontalTipoId)) {
				return false;
			}
		}
		{
			int lhsProteccionRuidoInteriorImpactosVerticalTipoId;
			lhsProteccionRuidoInteriorImpactosVerticalTipoId = this.getProteccionRuidoInteriorImpactosVerticalTipoId();
			int rhsProteccionRuidoInteriorImpactosVerticalTipoId;
			rhsProteccionRuidoInteriorImpactosVerticalTipoId = that.getProteccionRuidoInteriorImpactosVerticalTipoId();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "proteccionRuidoInteriorImpactosVerticalTipoId", lhsProteccionRuidoInteriorImpactosVerticalTipoId), LocatorUtils.property(thatLocator, "proteccionRuidoInteriorImpactosVerticalTipoId", rhsProteccionRuidoInteriorImpactosVerticalTipoId), lhsProteccionRuidoInteriorImpactosVerticalTipoId, rhsProteccionRuidoInteriorImpactosVerticalTipoId)) {
				return false;
			}
		}
		{
			int lhsProteccionRuidoInteriorImpactosHorizontalTipoId;
			lhsProteccionRuidoInteriorImpactosHorizontalTipoId = this.getProteccionRuidoInteriorImpactosHorizontalTipoId();
			int rhsProteccionRuidoInteriorImpactosHorizontalTipoId;
			rhsProteccionRuidoInteriorImpactosHorizontalTipoId = that.getProteccionRuidoInteriorImpactosHorizontalTipoId();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "proteccionRuidoInteriorImpactosHorizontalTipoId", lhsProteccionRuidoInteriorImpactosHorizontalTipoId), LocatorUtils.property(thatLocator, "proteccionRuidoInteriorImpactosHorizontalTipoId", rhsProteccionRuidoInteriorImpactosHorizontalTipoId), lhsProteccionRuidoInteriorImpactosHorizontalTipoId, rhsProteccionRuidoInteriorImpactosHorizontalTipoId)) {
				return false;
			}
		}
		{
			int lhsProteccionRuidoInstalacionesTipoId;
			lhsProteccionRuidoInstalacionesTipoId = this.getProteccionRuidoInstalacionesTipoId();
			int rhsProteccionRuidoInstalacionesTipoId;
			rhsProteccionRuidoInstalacionesTipoId = that.getProteccionRuidoInstalacionesTipoId();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "proteccionRuidoInstalacionesTipoId", lhsProteccionRuidoInstalacionesTipoId), LocatorUtils.property(thatLocator, "proteccionRuidoInstalacionesTipoId", rhsProteccionRuidoInstalacionesTipoId), lhsProteccionRuidoInstalacionesTipoId, rhsProteccionRuidoInstalacionesTipoId)) {
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
		return true;
	}

	public boolean equals(Object object) {
		final EqualsStrategy strategy = JAXBEqualsStrategy.INSTANCE;
		return equals(null, null, object, strategy);
	}

	public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
		int currentHashCode = 1;
		{
			int theProteccionRuidoExteriorTipoId;
			theProteccionRuidoExteriorTipoId = this.getProteccionRuidoExteriorTipoId();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "proteccionRuidoExteriorTipoId", theProteccionRuidoExteriorTipoId), currentHashCode, theProteccionRuidoExteriorTipoId);
		}
		{
			int theProteccionRuidoInteriorAereoVerticalTipoId;
			theProteccionRuidoInteriorAereoVerticalTipoId = this.getProteccionRuidoInteriorAereoVerticalTipoId();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "proteccionRuidoInteriorAereoVerticalTipoId", theProteccionRuidoInteriorAereoVerticalTipoId), currentHashCode, theProteccionRuidoInteriorAereoVerticalTipoId);
		}
		{
			int theProteccionRuidoInteriorAereoHorizontalTipoId;
			theProteccionRuidoInteriorAereoHorizontalTipoId = this.getProteccionRuidoInteriorAereoHorizontalTipoId();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "proteccionRuidoInteriorAereoHorizontalTipoId", theProteccionRuidoInteriorAereoHorizontalTipoId), currentHashCode, theProteccionRuidoInteriorAereoHorizontalTipoId);
		}
		{
			int theProteccionRuidoInteriorImpactosVerticalTipoId;
			theProteccionRuidoInteriorImpactosVerticalTipoId = this.getProteccionRuidoInteriorImpactosVerticalTipoId();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "proteccionRuidoInteriorImpactosVerticalTipoId", theProteccionRuidoInteriorImpactosVerticalTipoId), currentHashCode, theProteccionRuidoInteriorImpactosVerticalTipoId);
		}
		{
			int theProteccionRuidoInteriorImpactosHorizontalTipoId;
			theProteccionRuidoInteriorImpactosHorizontalTipoId = this.getProteccionRuidoInteriorImpactosHorizontalTipoId();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "proteccionRuidoInteriorImpactosHorizontalTipoId", theProteccionRuidoInteriorImpactosHorizontalTipoId), currentHashCode, theProteccionRuidoInteriorImpactosHorizontalTipoId);
		}
		{
			int theProteccionRuidoInstalacionesTipoId;
			theProteccionRuidoInstalacionesTipoId = this.getProteccionRuidoInstalacionesTipoId();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "proteccionRuidoInstalacionesTipoId", theProteccionRuidoInstalacionesTipoId), currentHashCode, theProteccionRuidoInstalacionesTipoId);
		}
		{
			String theObservaciones;
			theObservaciones = this.getObservaciones();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "observaciones", theObservaciones), currentHashCode, theObservaciones);
		}
		return currentHashCode;
	}

	public int hashCode() {
		final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
		return this.hashCode(null, strategy);
	}

}
