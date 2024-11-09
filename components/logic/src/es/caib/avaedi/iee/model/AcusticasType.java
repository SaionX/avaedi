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
 * Clase Java para acusticasType complex type.
 * 
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que
 * haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="acusticasType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="es_tecnico_inspeccion" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="tecnico" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="nif" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="titulacion" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="incluir_informe_acustica" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
@XmlType(name = "acusticasType", propOrder = { "esTecnicoInspeccion", "tecnico", "nif", "titulacion", "incluirInformeAcustica", "observaciones" })
@Entity(name = "AcusticasType")
@Table(name = "AED_ACUSTICAS")
@Inheritance(strategy = InheritanceType.JOINED)
public class AcusticasType implements Serializable, Equals, HashCode {

	@XmlElement(name = "es_tecnico_inspeccion")
	protected int esTecnicoInspeccion;
	@XmlElement(required = true)
	protected String tecnico;
	@XmlElement(required = true)
	protected String nif;
	@XmlElement(required = true)
	protected String titulacion;
	@XmlElement(name = "incluir_informe_acustica", required = true)
	protected String incluirInformeAcustica;
	@XmlElement(required = true)
	protected String observaciones;
	@XmlAttribute(name = "Hjid")
	protected Long hjid;

	/**
	 * Obtiene el valor de la propiedad esTecnicoInspeccion.
	 * 
	 */
	@Basic
	@Column(name = "ES_TECNICO_INSPECCION", precision = 10, scale = 0)
	public int getEsTecnicoInspeccion() {
		return esTecnicoInspeccion;
	}

	/**
	 * Define el valor de la propiedad esTecnicoInspeccion.
	 * 
	 */
	public void setEsTecnicoInspeccion(int value) {
		this.esTecnicoInspeccion = value;
	}

	/**
	 * Obtiene el valor de la propiedad tecnico.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "TECNICO", length = 255)
	public String getTecnico() {
		return tecnico;
	}

	/**
	 * Define el valor de la propiedad tecnico.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTecnico(String value) {
		this.tecnico = value;
	}

	/**
	 * Obtiene el valor de la propiedad nif.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "NIF", length = 255)
	public String getNif() {
		return nif;
	}

	/**
	 * Define el valor de la propiedad nif.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setNif(String value) {
		this.nif = value;
	}

	/**
	 * Obtiene el valor de la propiedad titulacion.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "TITULACION", length = 255)
	public String getTitulacion() {
		return titulacion;
	}

	/**
	 * Define el valor de la propiedad titulacion.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTitulacion(String value) {
		this.titulacion = value;
	}

	/**
	 * Obtiene el valor de la propiedad incluirInformeAcustica.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "INCLUIR_INFORME_ACUSTICA", length = 255)
	public String getIncluirInformeAcustica() {
		return incluirInformeAcustica;
	}

	/**
	 * Define el valor de la propiedad incluirInformeAcustica.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setIncluirInformeAcustica(String value) {
		this.incluirInformeAcustica = value;
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
		final AcusticasType that = ((AcusticasType) object);
		{
			int lhsEsTecnicoInspeccion;
			lhsEsTecnicoInspeccion = this.getEsTecnicoInspeccion();
			int rhsEsTecnicoInspeccion;
			rhsEsTecnicoInspeccion = that.getEsTecnicoInspeccion();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "esTecnicoInspeccion", lhsEsTecnicoInspeccion), LocatorUtils.property(thatLocator, "esTecnicoInspeccion", rhsEsTecnicoInspeccion), lhsEsTecnicoInspeccion, rhsEsTecnicoInspeccion)) {
				return false;
			}
		}
		{
			String lhsTecnico;
			lhsTecnico = this.getTecnico();
			String rhsTecnico;
			rhsTecnico = that.getTecnico();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "tecnico", lhsTecnico), LocatorUtils.property(thatLocator, "tecnico", rhsTecnico), lhsTecnico, rhsTecnico)) {
				return false;
			}
		}
		{
			String lhsNif;
			lhsNif = this.getNif();
			String rhsNif;
			rhsNif = that.getNif();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "nif", lhsNif), LocatorUtils.property(thatLocator, "nif", rhsNif), lhsNif, rhsNif)) {
				return false;
			}
		}
		{
			String lhsTitulacion;
			lhsTitulacion = this.getTitulacion();
			String rhsTitulacion;
			rhsTitulacion = that.getTitulacion();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "titulacion", lhsTitulacion), LocatorUtils.property(thatLocator, "titulacion", rhsTitulacion), lhsTitulacion, rhsTitulacion)) {
				return false;
			}
		}
		{
			String lhsIncluirInformeAcustica;
			lhsIncluirInformeAcustica = this.getIncluirInformeAcustica();
			String rhsIncluirInformeAcustica;
			rhsIncluirInformeAcustica = that.getIncluirInformeAcustica();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "incluirInformeAcustica", lhsIncluirInformeAcustica), LocatorUtils.property(thatLocator, "incluirInformeAcustica", rhsIncluirInformeAcustica), lhsIncluirInformeAcustica, rhsIncluirInformeAcustica)) {
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
			int theEsTecnicoInspeccion;
			theEsTecnicoInspeccion = this.getEsTecnicoInspeccion();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "esTecnicoInspeccion", theEsTecnicoInspeccion), currentHashCode, theEsTecnicoInspeccion);
		}
		{
			String theTecnico;
			theTecnico = this.getTecnico();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "tecnico", theTecnico), currentHashCode, theTecnico);
		}
		{
			String theNif;
			theNif = this.getNif();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "nif", theNif), currentHashCode, theNif);
		}
		{
			String theTitulacion;
			theTitulacion = this.getTitulacion();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "titulacion", theTitulacion), currentHashCode, theTitulacion);
		}
		{
			String theIncluirInformeAcustica;
			theIncluirInformeAcustica = this.getIncluirInformeAcustica();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "incluirInformeAcustica", theIncluirInformeAcustica), currentHashCode, theIncluirInformeAcustica);
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
