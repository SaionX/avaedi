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
 * Clase Java para conservacion_datosgeneralesType complex type.
 * 
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que
 * haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="conservacion_datosgeneralesType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="num_viviendas_inspeccionadas" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="num_locales_inspeccionados" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="impedimentos_visita" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="medios_inspeccion" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="pruebas_realizadas" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="medidas_seguridad_visita" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="es_tecnico_inspeccion" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="tecnico" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="nif" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="titulacion" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
@XmlType(name = "conservacion_datosgeneralesType", propOrder = { "numViviendasInspeccionadas", "numLocalesInspeccionados", "impedimentosVisita", "mediosInspeccion", "pruebasRealizadas", "medidasSeguridadVisita", "esTecnicoInspeccion", "tecnico", "nif", "titulacion", "observaciones" })
@Entity(name = "ConservacionDatosgeneralesType")
@Table(name = "AED_CONS_DATGEN")
@Inheritance(strategy = InheritanceType.JOINED)
public class ConservacionDatosgeneralesType implements Serializable, Equals, HashCode {

	@XmlElement(name = "num_viviendas_inspeccionadas")
	protected int numViviendasInspeccionadas;
	@XmlElement(name = "num_locales_inspeccionados")
	protected int numLocalesInspeccionados;
	@XmlElement(name = "impedimentos_visita", required = true)
	protected String impedimentosVisita;
	@XmlElement(name = "medios_inspeccion", required = true)
	protected String mediosInspeccion;
	@XmlElement(name = "pruebas_realizadas", required = true)
	protected String pruebasRealizadas;
	@XmlElement(name = "medidas_seguridad_visita", required = true)
	protected String medidasSeguridadVisita;
	@XmlElement(name = "es_tecnico_inspeccion")
	protected int esTecnicoInspeccion;
	@XmlElement(required = true)
	protected String tecnico;
	@XmlElement(required = true)
	protected String nif;
	@XmlElement(required = true)
	protected String titulacion;
	@XmlElement(required = true)
	protected String observaciones;
	@XmlAttribute(name = "Hjid")
	protected Long hjid;

	/**
	 * Obtiene el valor de la propiedad numViviendasInspeccionadas.
	 * 
	 */
	@Basic
	@Column(name = "NUM_VIVIENDAS_INSPECCIONADAS", precision = 10, scale = 0)
	public int getNumViviendasInspeccionadas() {
		return numViviendasInspeccionadas;
	}

	/**
	 * Define el valor de la propiedad numViviendasInspeccionadas.
	 * 
	 */
	public void setNumViviendasInspeccionadas(int value) {
		this.numViviendasInspeccionadas = value;
	}

	/**
	 * Obtiene el valor de la propiedad numLocalesInspeccionados.
	 * 
	 */
	@Basic
	@Column(name = "NUM_LOCALES_INSPECCIONADOS", precision = 10, scale = 0)
	public int getNumLocalesInspeccionados() {
		return numLocalesInspeccionados;
	}

	/**
	 * Define el valor de la propiedad numLocalesInspeccionados.
	 * 
	 */
	public void setNumLocalesInspeccionados(int value) {
		this.numLocalesInspeccionados = value;
	}

	/**
	 * Obtiene el valor de la propiedad impedimentosVisita.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "IMPEDIMENTOS_VISITA", length = 255)
	public String getImpedimentosVisita() {
		return impedimentosVisita;
	}

	/**
	 * Define el valor de la propiedad impedimentosVisita.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setImpedimentosVisita(String value) {
		this.impedimentosVisita = value;
	}

	/**
	 * Obtiene el valor de la propiedad mediosInspeccion.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "MEDIOS_INSPECCION", length = 255)
	public String getMediosInspeccion() {
		return mediosInspeccion;
	}

	/**
	 * Define el valor de la propiedad mediosInspeccion.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setMediosInspeccion(String value) {
		this.mediosInspeccion = value;
	}

	/**
	 * Obtiene el valor de la propiedad pruebasRealizadas.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "PRUEBAS_REALIZADAS", length = 255)
	public String getPruebasRealizadas() {
		return pruebasRealizadas;
	}

	/**
	 * Define el valor de la propiedad pruebasRealizadas.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPruebasRealizadas(String value) {
		this.pruebasRealizadas = value;
	}

	/**
	 * Obtiene el valor de la propiedad medidasSeguridadVisita.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "MEDIDAS_SEGURIDAD_VISITA", length = 255)
	public String getMedidasSeguridadVisita() {
		return medidasSeguridadVisita;
	}

	/**
	 * Define el valor de la propiedad medidasSeguridadVisita.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setMedidasSeguridadVisita(String value) {
		this.medidasSeguridadVisita = value;
	}

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
		final ConservacionDatosgeneralesType that = ((ConservacionDatosgeneralesType) object);
		{
			int lhsNumViviendasInspeccionadas;
			lhsNumViviendasInspeccionadas = this.getNumViviendasInspeccionadas();
			int rhsNumViviendasInspeccionadas;
			rhsNumViviendasInspeccionadas = that.getNumViviendasInspeccionadas();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "numViviendasInspeccionadas", lhsNumViviendasInspeccionadas), LocatorUtils.property(thatLocator, "numViviendasInspeccionadas", rhsNumViviendasInspeccionadas), lhsNumViviendasInspeccionadas, rhsNumViviendasInspeccionadas)) {
				return false;
			}
		}
		{
			int lhsNumLocalesInspeccionados;
			lhsNumLocalesInspeccionados = this.getNumLocalesInspeccionados();
			int rhsNumLocalesInspeccionados;
			rhsNumLocalesInspeccionados = that.getNumLocalesInspeccionados();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "numLocalesInspeccionados", lhsNumLocalesInspeccionados), LocatorUtils.property(thatLocator, "numLocalesInspeccionados", rhsNumLocalesInspeccionados), lhsNumLocalesInspeccionados, rhsNumLocalesInspeccionados)) {
				return false;
			}
		}
		{
			String lhsImpedimentosVisita;
			lhsImpedimentosVisita = this.getImpedimentosVisita();
			String rhsImpedimentosVisita;
			rhsImpedimentosVisita = that.getImpedimentosVisita();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "impedimentosVisita", lhsImpedimentosVisita), LocatorUtils.property(thatLocator, "impedimentosVisita", rhsImpedimentosVisita), lhsImpedimentosVisita, rhsImpedimentosVisita)) {
				return false;
			}
		}
		{
			String lhsMediosInspeccion;
			lhsMediosInspeccion = this.getMediosInspeccion();
			String rhsMediosInspeccion;
			rhsMediosInspeccion = that.getMediosInspeccion();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "mediosInspeccion", lhsMediosInspeccion), LocatorUtils.property(thatLocator, "mediosInspeccion", rhsMediosInspeccion), lhsMediosInspeccion, rhsMediosInspeccion)) {
				return false;
			}
		}
		{
			String lhsPruebasRealizadas;
			lhsPruebasRealizadas = this.getPruebasRealizadas();
			String rhsPruebasRealizadas;
			rhsPruebasRealizadas = that.getPruebasRealizadas();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "pruebasRealizadas", lhsPruebasRealizadas), LocatorUtils.property(thatLocator, "pruebasRealizadas", rhsPruebasRealizadas), lhsPruebasRealizadas, rhsPruebasRealizadas)) {
				return false;
			}
		}
		{
			String lhsMedidasSeguridadVisita;
			lhsMedidasSeguridadVisita = this.getMedidasSeguridadVisita();
			String rhsMedidasSeguridadVisita;
			rhsMedidasSeguridadVisita = that.getMedidasSeguridadVisita();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "medidasSeguridadVisita", lhsMedidasSeguridadVisita), LocatorUtils.property(thatLocator, "medidasSeguridadVisita", rhsMedidasSeguridadVisita), lhsMedidasSeguridadVisita, rhsMedidasSeguridadVisita)) {
				return false;
			}
		}
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
			int theNumViviendasInspeccionadas;
			theNumViviendasInspeccionadas = this.getNumViviendasInspeccionadas();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "numViviendasInspeccionadas", theNumViviendasInspeccionadas), currentHashCode, theNumViviendasInspeccionadas);
		}
		{
			int theNumLocalesInspeccionados;
			theNumLocalesInspeccionados = this.getNumLocalesInspeccionados();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "numLocalesInspeccionados", theNumLocalesInspeccionados), currentHashCode, theNumLocalesInspeccionados);
		}
		{
			String theImpedimentosVisita;
			theImpedimentosVisita = this.getImpedimentosVisita();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "impedimentosVisita", theImpedimentosVisita), currentHashCode, theImpedimentosVisita);
		}
		{
			String theMediosInspeccion;
			theMediosInspeccion = this.getMediosInspeccion();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "mediosInspeccion", theMediosInspeccion), currentHashCode, theMediosInspeccion);
		}
		{
			String thePruebasRealizadas;
			thePruebasRealizadas = this.getPruebasRealizadas();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "pruebasRealizadas", thePruebasRealizadas), currentHashCode, thePruebasRealizadas);
		}
		{
			String theMedidasSeguridadVisita;
			theMedidasSeguridadVisita = this.getMedidasSeguridadVisita();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "medidasSeguridadVisita", theMedidasSeguridadVisita), currentHashCode, theMedidasSeguridadVisita);
		}
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
