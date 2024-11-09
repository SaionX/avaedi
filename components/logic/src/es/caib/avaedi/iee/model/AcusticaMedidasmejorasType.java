//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.11 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2016.09.08 a las 10:32:16 PM CEST 
//

package es.caib.avaedi.iee.model;

import java.io.Serializable;

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
import javax.persistence.ManyToOne;
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
 * Clase Java para acustica_medidasmejorasType complex type.
 * 
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que
 * haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="acustica_medidasmejorasType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="descripcion" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="analisis_tecnico" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="valoracion_economica" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="orden" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="observaciones" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="acustica_potencialmedidas" type="{}acustica_potencialmedidasType"/&gt;
 *         &lt;element name="acustica_incidenciamedidas" type="{}acustica_incidenciamedidasType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "acustica_medidasmejorasType", propOrder = { "descripcion", "analisisTecnico", "valoracionEconomica", "orden", "observaciones", "acusticaPotencialmedidas", "acusticaIncidenciamedidas" })
@Entity(name = "AcusticaMedidasmejorasType")
@Table(name = "AED_ACU_MEDIDASMEJORAS")
@Inheritance(strategy = InheritanceType.JOINED)
public class AcusticaMedidasmejorasType implements Serializable, Equals, HashCode {

	@XmlElement(required = true)
	protected String descripcion;
	@XmlElement(name = "analisis_tecnico", required = true)
	protected String analisisTecnico;
	@XmlElement(name = "valoracion_economica", required = true)
	protected String valoracionEconomica;
	protected int orden;
	@XmlElement(required = true)
	protected String observaciones;
	@XmlElement(name = "acustica_potencialmedidas", required = true)
	protected AcusticaPotencialmedidasType acusticaPotencialmedidas;
	@XmlElement(name = "acustica_incidenciamedidas", required = true)
	protected AcusticaIncidenciamedidasType acusticaIncidenciamedidas;
	@XmlAttribute(name = "Hjid")
	protected Long hjid;

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
	 * Obtiene el valor de la propiedad analisisTecnico.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "ANALISIS_TECNICO", length = 255)
	public String getAnalisisTecnico() {
		return analisisTecnico;
	}

	/**
	 * Define el valor de la propiedad analisisTecnico.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setAnalisisTecnico(String value) {
		this.analisisTecnico = value;
	}

	/**
	 * Obtiene el valor de la propiedad valoracionEconomica.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "VALORACION_ECONOMICA", length = 255)
	public String getValoracionEconomica() {
		return valoracionEconomica;
	}

	/**
	 * Define el valor de la propiedad valoracionEconomica.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setValoracionEconomica(String value) {
		this.valoracionEconomica = value;
	}

	/**
	 * Obtiene el valor de la propiedad orden.
	 * 
	 */
	@Basic
	@Column(name = "ORDEN", precision = 10, scale = 0)
	public int getOrden() {
		return orden;
	}

	/**
	 * Define el valor de la propiedad orden.
	 * 
	 */
	public void setOrden(int value) {
		this.orden = value;
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
	 * Obtiene el valor de la propiedad acusticaPotencialmedidas.
	 * 
	 * @return possible object is {@link AcusticaPotencialmedidasType }
	 * 
	 */
	@ManyToOne(targetEntity = AcusticaPotencialmedidasType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "ACUSTICA_POTENCIALMEDIDAS_AED_ACU_MEDIDASMEJORAS_HJID")
	public AcusticaPotencialmedidasType getAcusticaPotencialmedidas() {
		return acusticaPotencialmedidas;
	}

	/**
	 * Define el valor de la propiedad acusticaPotencialmedidas.
	 * 
	 * @param value
	 *            allowed object is {@link AcusticaPotencialmedidasType }
	 * 
	 */
	public void setAcusticaPotencialmedidas(AcusticaPotencialmedidasType value) {
		this.acusticaPotencialmedidas = value;
	}

	/**
	 * Obtiene el valor de la propiedad acusticaIncidenciamedidas.
	 * 
	 * @return possible object is {@link AcusticaIncidenciamedidasType }
	 * 
	 */
	@ManyToOne(targetEntity = AcusticaIncidenciamedidasType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "ACUSTICA_INCIDENCIAMEDIDAS_AED_ACU_MEDIDASMEJORAS_HJID")
	public AcusticaIncidenciamedidasType getAcusticaIncidenciamedidas() {
		return acusticaIncidenciamedidas;
	}

	/**
	 * Define el valor de la propiedad acusticaIncidenciamedidas.
	 * 
	 * @param value
	 *            allowed object is {@link AcusticaIncidenciamedidasType }
	 * 
	 */
	public void setAcusticaIncidenciamedidas(AcusticaIncidenciamedidasType value) {
		this.acusticaIncidenciamedidas = value;
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
		final AcusticaMedidasmejorasType that = ((AcusticaMedidasmejorasType) object);
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
			String lhsAnalisisTecnico;
			lhsAnalisisTecnico = this.getAnalisisTecnico();
			String rhsAnalisisTecnico;
			rhsAnalisisTecnico = that.getAnalisisTecnico();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "analisisTecnico", lhsAnalisisTecnico), LocatorUtils.property(thatLocator, "analisisTecnico", rhsAnalisisTecnico), lhsAnalisisTecnico, rhsAnalisisTecnico)) {
				return false;
			}
		}
		{
			String lhsValoracionEconomica;
			lhsValoracionEconomica = this.getValoracionEconomica();
			String rhsValoracionEconomica;
			rhsValoracionEconomica = that.getValoracionEconomica();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "valoracionEconomica", lhsValoracionEconomica), LocatorUtils.property(thatLocator, "valoracionEconomica", rhsValoracionEconomica), lhsValoracionEconomica, rhsValoracionEconomica)) {
				return false;
			}
		}
		{
			int lhsOrden;
			lhsOrden = this.getOrden();
			int rhsOrden;
			rhsOrden = that.getOrden();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "orden", lhsOrden), LocatorUtils.property(thatLocator, "orden", rhsOrden), lhsOrden, rhsOrden)) {
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
			AcusticaPotencialmedidasType lhsAcusticaPotencialmedidas;
			lhsAcusticaPotencialmedidas = this.getAcusticaPotencialmedidas();
			AcusticaPotencialmedidasType rhsAcusticaPotencialmedidas;
			rhsAcusticaPotencialmedidas = that.getAcusticaPotencialmedidas();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "acusticaPotencialmedidas", lhsAcusticaPotencialmedidas), LocatorUtils.property(thatLocator, "acusticaPotencialmedidas", rhsAcusticaPotencialmedidas), lhsAcusticaPotencialmedidas, rhsAcusticaPotencialmedidas)) {
				return false;
			}
		}
		{
			AcusticaIncidenciamedidasType lhsAcusticaIncidenciamedidas;
			lhsAcusticaIncidenciamedidas = this.getAcusticaIncidenciamedidas();
			AcusticaIncidenciamedidasType rhsAcusticaIncidenciamedidas;
			rhsAcusticaIncidenciamedidas = that.getAcusticaIncidenciamedidas();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "acusticaIncidenciamedidas", lhsAcusticaIncidenciamedidas), LocatorUtils.property(thatLocator, "acusticaIncidenciamedidas", rhsAcusticaIncidenciamedidas), lhsAcusticaIncidenciamedidas, rhsAcusticaIncidenciamedidas)) {
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
			String theDescripcion;
			theDescripcion = this.getDescripcion();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "descripcion", theDescripcion), currentHashCode, theDescripcion);
		}
		{
			String theAnalisisTecnico;
			theAnalisisTecnico = this.getAnalisisTecnico();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "analisisTecnico", theAnalisisTecnico), currentHashCode, theAnalisisTecnico);
		}
		{
			String theValoracionEconomica;
			theValoracionEconomica = this.getValoracionEconomica();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "valoracionEconomica", theValoracionEconomica), currentHashCode, theValoracionEconomica);
		}
		{
			int theOrden;
			theOrden = this.getOrden();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "orden", theOrden), currentHashCode, theOrden);
		}
		{
			String theObservaciones;
			theObservaciones = this.getObservaciones();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "observaciones", theObservaciones), currentHashCode, theObservaciones);
		}
		{
			AcusticaPotencialmedidasType theAcusticaPotencialmedidas;
			theAcusticaPotencialmedidas = this.getAcusticaPotencialmedidas();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "acusticaPotencialmedidas", theAcusticaPotencialmedidas), currentHashCode, theAcusticaPotencialmedidas);
		}
		{
			AcusticaIncidenciamedidasType theAcusticaIncidenciamedidas;
			theAcusticaIncidenciamedidas = this.getAcusticaIncidenciamedidas();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "acusticaIncidenciamedidas", theAcusticaIncidenciamedidas), currentHashCode, theAcusticaIncidenciamedidas);
		}
		return currentHashCode;
	}

	public int hashCode() {
		final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
		return this.hashCode(null, strategy);
	}

}
