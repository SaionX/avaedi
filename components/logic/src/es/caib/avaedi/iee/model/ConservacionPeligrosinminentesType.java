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
 * Clase Java para conservacion_peligrosinminentesType complex type.
 * 
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que
 * haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="conservacion_peligrosinminentesType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="existe_peligro_inminente" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="descripcion" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="medidas" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="fecha_limite_actuacion" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "conservacion_peligrosinminentesType", propOrder = { "existePeligroInminente", "descripcion", "medidas", "fechaLimiteActuacion" })
@Entity(name = "ConservacionPeligrosinminentesType")
@Table(name = "AED_CONS_PELIGROSINMINENTES")
@Inheritance(strategy = InheritanceType.JOINED)
public class ConservacionPeligrosinminentesType implements Serializable, Equals, HashCode {

	@XmlElement(name = "existe_peligro_inminente")
	protected int existePeligroInminente;
	@XmlElement(required = true)
	protected String descripcion;
	@XmlElement(required = true)
	protected String medidas;
	@XmlElement(name = "fecha_limite_actuacion", required = true)
	protected String fechaLimiteActuacion;
	@XmlAttribute(name = "Hjid")
	protected Long hjid;

	/**
	 * Obtiene el valor de la propiedad existePeligroInminente.
	 * 
	 */
	@Basic
	@Column(name = "EXISTE_PELIGRO_INMINENTE", precision = 10, scale = 0)
	public int getExistePeligroInminente() {
		return existePeligroInminente;
	}

	/**
	 * Define el valor de la propiedad existePeligroInminente.
	 * 
	 */
	public void setExistePeligroInminente(int value) {
		this.existePeligroInminente = value;
	}

	/**
	 * Obtiene el valor de la propiedad descripcion.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "DESCRIPCION", length = 255)
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Define el valor de la propiedad descripcion.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDescripcion(String value) {
		this.descripcion = value;
	}

	/**
	 * Obtiene el valor de la propiedad medidas.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "MEDIDAS", length = 255)
	public String getMedidas() {
		return medidas;
	}

	/**
	 * Define el valor de la propiedad medidas.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setMedidas(String value) {
		this.medidas = value;
	}

	/**
	 * Obtiene el valor de la propiedad fechaLimiteActuacion.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "FECHA_LIMITE_ACTUACION", length = 255)
	public String getFechaLimiteActuacion() {
		return fechaLimiteActuacion;
	}

	/**
	 * Define el valor de la propiedad fechaLimiteActuacion.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setFechaLimiteActuacion(String value) {
		this.fechaLimiteActuacion = value;
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
		final ConservacionPeligrosinminentesType that = ((ConservacionPeligrosinminentesType) object);
		{
			int lhsExistePeligroInminente;
			lhsExistePeligroInminente = this.getExistePeligroInminente();
			int rhsExistePeligroInminente;
			rhsExistePeligroInminente = that.getExistePeligroInminente();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "existePeligroInminente", lhsExistePeligroInminente), LocatorUtils.property(thatLocator, "existePeligroInminente", rhsExistePeligroInminente), lhsExistePeligroInminente, rhsExistePeligroInminente)) {
				return false;
			}
		}
		{
			String lhsDescripcion;
			lhsDescripcion = this.getDescripcion();
			String rhsDescripcion;
			rhsDescripcion = that.getDescripcion();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "descripcion", lhsDescripcion), LocatorUtils.property(thatLocator, "descripcion", rhsDescripcion), lhsDescripcion, rhsDescripcion)) {
				return false;
			}
		}
		{
			String lhsMedidas;
			lhsMedidas = this.getMedidas();
			String rhsMedidas;
			rhsMedidas = that.getMedidas();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "medidas", lhsMedidas), LocatorUtils.property(thatLocator, "medidas", rhsMedidas), lhsMedidas, rhsMedidas)) {
				return false;
			}
		}
		{
			String lhsFechaLimiteActuacion;
			lhsFechaLimiteActuacion = this.getFechaLimiteActuacion();
			String rhsFechaLimiteActuacion;
			rhsFechaLimiteActuacion = that.getFechaLimiteActuacion();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "fechaLimiteActuacion", lhsFechaLimiteActuacion), LocatorUtils.property(thatLocator, "fechaLimiteActuacion", rhsFechaLimiteActuacion), lhsFechaLimiteActuacion, rhsFechaLimiteActuacion)) {
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
			int theExistePeligroInminente;
			theExistePeligroInminente = this.getExistePeligroInminente();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "existePeligroInminente", theExistePeligroInminente), currentHashCode, theExistePeligroInminente);
		}
		{
			String theDescripcion;
			theDescripcion = this.getDescripcion();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "descripcion", theDescripcion), currentHashCode, theDescripcion);
		}
		{
			String theMedidas;
			theMedidas = this.getMedidas();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "medidas", theMedidas), currentHashCode, theMedidas);
		}
		{
			String theFechaLimiteActuacion;
			theFechaLimiteActuacion = this.getFechaLimiteActuacion();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "fechaLimiteActuacion", theFechaLimiteActuacion), currentHashCode, theFechaLimiteActuacion);
		}
		return currentHashCode;
	}

	public int hashCode() {
		final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
		return this.hashCode(null, strategy);
	}

}
