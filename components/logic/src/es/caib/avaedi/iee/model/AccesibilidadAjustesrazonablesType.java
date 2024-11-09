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
 * Clase Java para accesibilidad_ajustesrazonablesType complex type.
 * 
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que
 * haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="accesibilidad_ajustesrazonablesType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="personasdiscapacitadasomayores" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="viviendasnoitinerarioaccesible" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="observaciones_analisis_no_medidas" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="observaciones_consideracionesinmueble" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="importegastoscomunes" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="financiacionayuda" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="observaciones_cargaeconomica" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="edificionosusceptibleajustes" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="edificiosusceptibleajustes_total" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="ajustesrazonables_descripcion" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="ajustesrazonables_coste" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "accesibilidad_ajustesrazonablesType", propOrder = { "personasdiscapacitadasomayores", "viviendasnoitinerarioaccesible", "observacionesAnalisisNoMedidas", "observacionesConsideracionesinmueble", "importegastoscomunes", "financiacionayuda", "observacionesCargaeconomica", "edificionosusceptibleajustes", "edificiosusceptibleajustesTotal", "ajustesrazonablesDescripcion", "ajustesrazonablesCoste" })
@Entity(name = "AccesibilidadAjustesrazonablesType")
@Table(name = "AED_ACC_AJUSTESRAZONABLES")
@Inheritance(strategy = InheritanceType.JOINED)
public class AccesibilidadAjustesrazonablesType implements Serializable, Equals, HashCode {

	@XmlElement(required = true)
	protected String personasdiscapacitadasomayores;
	@XmlElement(required = true)
	protected String viviendasnoitinerarioaccesible;
	@XmlElement(name = "observaciones_analisis_no_medidas", required = true)
	protected String observacionesAnalisisNoMedidas;
	@XmlElement(name = "observaciones_consideracionesinmueble", required = true)
	protected String observacionesConsideracionesinmueble;
	@XmlElement(required = true)
	protected String importegastoscomunes;
	@XmlElement(required = true)
	protected String financiacionayuda;
	@XmlElement(name = "observaciones_cargaeconomica", required = true)
	protected String observacionesCargaeconomica;
	protected int edificionosusceptibleajustes;
	@XmlElement(name = "edificiosusceptibleajustes_total")
	protected int edificiosusceptibleajustesTotal;
	@XmlElement(name = "ajustesrazonables_descripcion", required = true)
	protected String ajustesrazonablesDescripcion;
	@XmlElement(name = "ajustesrazonables_coste", required = true)
	protected String ajustesrazonablesCoste;
	@XmlAttribute(name = "Hjid")
	protected Long hjid;

	/**
	 * Obtiene el valor de la propiedad personasdiscapacitadasomayores.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "PERSONASDISCAPACITADASOMAYORES", length = 255)
	public String getPersonasdiscapacitadasomayores() {
		return personasdiscapacitadasomayores;
	}

	/**
	 * Define el valor de la propiedad personasdiscapacitadasomayores.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPersonasdiscapacitadasomayores(String value) {
		this.personasdiscapacitadasomayores = value;
	}

	/**
	 * Obtiene el valor de la propiedad viviendasnoitinerarioaccesible.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "VIVIENDASNOITINERARIOACCESIBLE", length = 255)
	public String getViviendasnoitinerarioaccesible() {
		return viviendasnoitinerarioaccesible;
	}

	/**
	 * Define el valor de la propiedad viviendasnoitinerarioaccesible.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setViviendasnoitinerarioaccesible(String value) {
		this.viviendasnoitinerarioaccesible = value;
	}

	/**
	 * Obtiene el valor de la propiedad observacionesAnalisisNoMedidas.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "OBSERVACIONES_ANALISIS_NO_MEDIDAS", length = 255)
	public String getObservacionesAnalisisNoMedidas() {
		return observacionesAnalisisNoMedidas;
	}

	/**
	 * Define el valor de la propiedad observacionesAnalisisNoMedidas.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setObservacionesAnalisisNoMedidas(String value) {
		this.observacionesAnalisisNoMedidas = value;
	}

	/**
	 * Obtiene el valor de la propiedad observacionesConsideracionesinmueble.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "OBSERVACIONES_CONSIDERACIONESINMUEBLE", length = 255)
	public String getObservacionesConsideracionesinmueble() {
		return observacionesConsideracionesinmueble;
	}

	/**
	 * Define el valor de la propiedad observacionesConsideracionesinmueble.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setObservacionesConsideracionesinmueble(String value) {
		this.observacionesConsideracionesinmueble = value;
	}

	/**
	 * Obtiene el valor de la propiedad importegastoscomunes.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "IMPORTEGASTOSCOMUNES", length = 255)
	public String getImportegastoscomunes() {
		return importegastoscomunes;
	}

	/**
	 * Define el valor de la propiedad importegastoscomunes.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setImportegastoscomunes(String value) {
		this.importegastoscomunes = value;
	}

	/**
	 * Obtiene el valor de la propiedad financiacionayuda.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "FINANCIACIONAYUDA", length = 255)
	public String getFinanciacionayuda() {
		return financiacionayuda;
	}

	/**
	 * Define el valor de la propiedad financiacionayuda.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setFinanciacionayuda(String value) {
		this.financiacionayuda = value;
	}

	/**
	 * Obtiene el valor de la propiedad observacionesCargaeconomica.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "OBSERVACIONES_CARGAECONOMICA", length = 255)
	public String getObservacionesCargaeconomica() {
		return observacionesCargaeconomica;
	}

	/**
	 * Define el valor de la propiedad observacionesCargaeconomica.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setObservacionesCargaeconomica(String value) {
		this.observacionesCargaeconomica = value;
	}

	/**
	 * Obtiene el valor de la propiedad edificionosusceptibleajustes.
	 * 
	 */
	@Basic
	@Column(name = "EDIFICIONOSUSCEPTIBLEAJUSTES", precision = 10, scale = 0)
	public int getEdificionosusceptibleajustes() {
		return edificionosusceptibleajustes;
	}

	/**
	 * Define el valor de la propiedad edificionosusceptibleajustes.
	 * 
	 */
	public void setEdificionosusceptibleajustes(int value) {
		this.edificionosusceptibleajustes = value;
	}

	/**
	 * Obtiene el valor de la propiedad edificiosusceptibleajustesTotal.
	 * 
	 */
	@Basic
	@Column(name = "EDIFICIOSUSCEPTIBLEAJUSTES_TOTAL", precision = 10, scale = 0)
	public int getEdificiosusceptibleajustesTotal() {
		return edificiosusceptibleajustesTotal;
	}

	/**
	 * Define el valor de la propiedad edificiosusceptibleajustesTotal.
	 * 
	 */
	public void setEdificiosusceptibleajustesTotal(int value) {
		this.edificiosusceptibleajustesTotal = value;
	}

	/**
	 * Obtiene el valor de la propiedad ajustesrazonablesDescripcion.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "AJUSTESRAZONABLES_DESCRIPCION", length = 255)
	public String getAjustesrazonablesDescripcion() {
		return ajustesrazonablesDescripcion;
	}

	/**
	 * Define el valor de la propiedad ajustesrazonablesDescripcion.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setAjustesrazonablesDescripcion(String value) {
		this.ajustesrazonablesDescripcion = value;
	}

	/**
	 * Obtiene el valor de la propiedad ajustesrazonablesCoste.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "AJUSTESRAZONABLES_COSTE", length = 255)
	public String getAjustesrazonablesCoste() {
		return ajustesrazonablesCoste;
	}

	/**
	 * Define el valor de la propiedad ajustesrazonablesCoste.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setAjustesrazonablesCoste(String value) {
		this.ajustesrazonablesCoste = value;
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
		final AccesibilidadAjustesrazonablesType that = ((AccesibilidadAjustesrazonablesType) object);
		{
			String lhsPersonasdiscapacitadasomayores;
			lhsPersonasdiscapacitadasomayores = this.getPersonasdiscapacitadasomayores();
			String rhsPersonasdiscapacitadasomayores;
			rhsPersonasdiscapacitadasomayores = that.getPersonasdiscapacitadasomayores();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "personasdiscapacitadasomayores", lhsPersonasdiscapacitadasomayores), LocatorUtils.property(thatLocator, "personasdiscapacitadasomayores", rhsPersonasdiscapacitadasomayores), lhsPersonasdiscapacitadasomayores, rhsPersonasdiscapacitadasomayores)) {
				return false;
			}
		}
		{
			String lhsViviendasnoitinerarioaccesible;
			lhsViviendasnoitinerarioaccesible = this.getViviendasnoitinerarioaccesible();
			String rhsViviendasnoitinerarioaccesible;
			rhsViviendasnoitinerarioaccesible = that.getViviendasnoitinerarioaccesible();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "viviendasnoitinerarioaccesible", lhsViviendasnoitinerarioaccesible), LocatorUtils.property(thatLocator, "viviendasnoitinerarioaccesible", rhsViviendasnoitinerarioaccesible), lhsViviendasnoitinerarioaccesible, rhsViviendasnoitinerarioaccesible)) {
				return false;
			}
		}
		{
			String lhsObservacionesAnalisisNoMedidas;
			lhsObservacionesAnalisisNoMedidas = this.getObservacionesAnalisisNoMedidas();
			String rhsObservacionesAnalisisNoMedidas;
			rhsObservacionesAnalisisNoMedidas = that.getObservacionesAnalisisNoMedidas();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "observacionesAnalisisNoMedidas", lhsObservacionesAnalisisNoMedidas), LocatorUtils.property(thatLocator, "observacionesAnalisisNoMedidas", rhsObservacionesAnalisisNoMedidas), lhsObservacionesAnalisisNoMedidas, rhsObservacionesAnalisisNoMedidas)) {
				return false;
			}
		}
		{
			String lhsObservacionesConsideracionesinmueble;
			lhsObservacionesConsideracionesinmueble = this.getObservacionesConsideracionesinmueble();
			String rhsObservacionesConsideracionesinmueble;
			rhsObservacionesConsideracionesinmueble = that.getObservacionesConsideracionesinmueble();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "observacionesConsideracionesinmueble", lhsObservacionesConsideracionesinmueble), LocatorUtils.property(thatLocator, "observacionesConsideracionesinmueble", rhsObservacionesConsideracionesinmueble), lhsObservacionesConsideracionesinmueble, rhsObservacionesConsideracionesinmueble)) {
				return false;
			}
		}
		{
			String lhsImportegastoscomunes;
			lhsImportegastoscomunes = this.getImportegastoscomunes();
			String rhsImportegastoscomunes;
			rhsImportegastoscomunes = that.getImportegastoscomunes();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "importegastoscomunes", lhsImportegastoscomunes), LocatorUtils.property(thatLocator, "importegastoscomunes", rhsImportegastoscomunes), lhsImportegastoscomunes, rhsImportegastoscomunes)) {
				return false;
			}
		}
		{
			String lhsFinanciacionayuda;
			lhsFinanciacionayuda = this.getFinanciacionayuda();
			String rhsFinanciacionayuda;
			rhsFinanciacionayuda = that.getFinanciacionayuda();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "financiacionayuda", lhsFinanciacionayuda), LocatorUtils.property(thatLocator, "financiacionayuda", rhsFinanciacionayuda), lhsFinanciacionayuda, rhsFinanciacionayuda)) {
				return false;
			}
		}
		{
			String lhsObservacionesCargaeconomica;
			lhsObservacionesCargaeconomica = this.getObservacionesCargaeconomica();
			String rhsObservacionesCargaeconomica;
			rhsObservacionesCargaeconomica = that.getObservacionesCargaeconomica();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "observacionesCargaeconomica", lhsObservacionesCargaeconomica), LocatorUtils.property(thatLocator, "observacionesCargaeconomica", rhsObservacionesCargaeconomica), lhsObservacionesCargaeconomica, rhsObservacionesCargaeconomica)) {
				return false;
			}
		}
		{
			int lhsEdificionosusceptibleajustes;
			lhsEdificionosusceptibleajustes = this.getEdificionosusceptibleajustes();
			int rhsEdificionosusceptibleajustes;
			rhsEdificionosusceptibleajustes = that.getEdificionosusceptibleajustes();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "edificionosusceptibleajustes", lhsEdificionosusceptibleajustes), LocatorUtils.property(thatLocator, "edificionosusceptibleajustes", rhsEdificionosusceptibleajustes), lhsEdificionosusceptibleajustes, rhsEdificionosusceptibleajustes)) {
				return false;
			}
		}
		{
			int lhsEdificiosusceptibleajustesTotal;
			lhsEdificiosusceptibleajustesTotal = this.getEdificiosusceptibleajustesTotal();
			int rhsEdificiosusceptibleajustesTotal;
			rhsEdificiosusceptibleajustesTotal = that.getEdificiosusceptibleajustesTotal();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "edificiosusceptibleajustesTotal", lhsEdificiosusceptibleajustesTotal), LocatorUtils.property(thatLocator, "edificiosusceptibleajustesTotal", rhsEdificiosusceptibleajustesTotal), lhsEdificiosusceptibleajustesTotal, rhsEdificiosusceptibleajustesTotal)) {
				return false;
			}
		}
		{
			String lhsAjustesrazonablesDescripcion;
			lhsAjustesrazonablesDescripcion = this.getAjustesrazonablesDescripcion();
			String rhsAjustesrazonablesDescripcion;
			rhsAjustesrazonablesDescripcion = that.getAjustesrazonablesDescripcion();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "ajustesrazonablesDescripcion", lhsAjustesrazonablesDescripcion), LocatorUtils.property(thatLocator, "ajustesrazonablesDescripcion", rhsAjustesrazonablesDescripcion), lhsAjustesrazonablesDescripcion, rhsAjustesrazonablesDescripcion)) {
				return false;
			}
		}
		{
			String lhsAjustesrazonablesCoste;
			lhsAjustesrazonablesCoste = this.getAjustesrazonablesCoste();
			String rhsAjustesrazonablesCoste;
			rhsAjustesrazonablesCoste = that.getAjustesrazonablesCoste();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "ajustesrazonablesCoste", lhsAjustesrazonablesCoste), LocatorUtils.property(thatLocator, "ajustesrazonablesCoste", rhsAjustesrazonablesCoste), lhsAjustesrazonablesCoste, rhsAjustesrazonablesCoste)) {
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
			String thePersonasdiscapacitadasomayores;
			thePersonasdiscapacitadasomayores = this.getPersonasdiscapacitadasomayores();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "personasdiscapacitadasomayores", thePersonasdiscapacitadasomayores), currentHashCode, thePersonasdiscapacitadasomayores);
		}
		{
			String theViviendasnoitinerarioaccesible;
			theViviendasnoitinerarioaccesible = this.getViviendasnoitinerarioaccesible();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "viviendasnoitinerarioaccesible", theViviendasnoitinerarioaccesible), currentHashCode, theViviendasnoitinerarioaccesible);
		}
		{
			String theObservacionesAnalisisNoMedidas;
			theObservacionesAnalisisNoMedidas = this.getObservacionesAnalisisNoMedidas();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "observacionesAnalisisNoMedidas", theObservacionesAnalisisNoMedidas), currentHashCode, theObservacionesAnalisisNoMedidas);
		}
		{
			String theObservacionesConsideracionesinmueble;
			theObservacionesConsideracionesinmueble = this.getObservacionesConsideracionesinmueble();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "observacionesConsideracionesinmueble", theObservacionesConsideracionesinmueble), currentHashCode, theObservacionesConsideracionesinmueble);
		}
		{
			String theImportegastoscomunes;
			theImportegastoscomunes = this.getImportegastoscomunes();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "importegastoscomunes", theImportegastoscomunes), currentHashCode, theImportegastoscomunes);
		}
		{
			String theFinanciacionayuda;
			theFinanciacionayuda = this.getFinanciacionayuda();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "financiacionayuda", theFinanciacionayuda), currentHashCode, theFinanciacionayuda);
		}
		{
			String theObservacionesCargaeconomica;
			theObservacionesCargaeconomica = this.getObservacionesCargaeconomica();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "observacionesCargaeconomica", theObservacionesCargaeconomica), currentHashCode, theObservacionesCargaeconomica);
		}
		{
			int theEdificionosusceptibleajustes;
			theEdificionosusceptibleajustes = this.getEdificionosusceptibleajustes();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "edificionosusceptibleajustes", theEdificionosusceptibleajustes), currentHashCode, theEdificionosusceptibleajustes);
		}
		{
			int theEdificiosusceptibleajustesTotal;
			theEdificiosusceptibleajustesTotal = this.getEdificiosusceptibleajustesTotal();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "edificiosusceptibleajustesTotal", theEdificiosusceptibleajustesTotal), currentHashCode, theEdificiosusceptibleajustesTotal);
		}
		{
			String theAjustesrazonablesDescripcion;
			theAjustesrazonablesDescripcion = this.getAjustesrazonablesDescripcion();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "ajustesrazonablesDescripcion", theAjustesrazonablesDescripcion), currentHashCode, theAjustesrazonablesDescripcion);
		}
		{
			String theAjustesrazonablesCoste;
			theAjustesrazonablesCoste = this.getAjustesrazonablesCoste();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "ajustesrazonablesCoste", theAjustesrazonablesCoste), currentHashCode, theAjustesrazonablesCoste);
		}
		return currentHashCode;
	}

	public int hashCode() {
		final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
		return this.hashCode(null, strategy);
	}

}
