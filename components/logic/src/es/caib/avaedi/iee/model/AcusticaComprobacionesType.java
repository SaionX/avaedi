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
 * Clase Java para acustica_comprobacionesType complex type.
 * 
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que
 * haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="acustica_comprobacionesType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="mediciones_aislamiento_acustico" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="calas_catas_elementos_constructivos" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="cuestionarios_confort_acustico" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="otras" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="otras_texto" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
@XmlType(name = "acustica_comprobacionesType", propOrder = { "medicionesAislamientoAcustico", "calasCatasElementosConstructivos", "cuestionariosConfortAcustico", "otras", "otrasTexto", "observaciones" })
@Entity(name = "AcusticaComprobacionesType")
@Table(name = "AED_ACU_COMPROBACIONES")
@Inheritance(strategy = InheritanceType.JOINED)
public class AcusticaComprobacionesType implements Serializable, Equals, HashCode {

	@XmlElement(name = "mediciones_aislamiento_acustico")
	protected int medicionesAislamientoAcustico;
	@XmlElement(name = "calas_catas_elementos_constructivos")
	protected int calasCatasElementosConstructivos;
	@XmlElement(name = "cuestionarios_confort_acustico")
	protected int cuestionariosConfortAcustico;
	protected int otras;
	@XmlElement(name = "otras_texto", required = true)
	protected String otrasTexto;
	@XmlElement(required = true)
	protected String observaciones;
	@XmlAttribute(name = "Hjid")
	protected Long hjid;

	/**
	 * Obtiene el valor de la propiedad medicionesAislamientoAcustico.
	 * 
	 */
	@Basic
	@Column(name = "MEDICIONES_AISLAMIENTO_ACUSTICO", precision = 10, scale = 0)
	public int getMedicionesAislamientoAcustico() {
		return medicionesAislamientoAcustico;
	}

	/**
	 * Define el valor de la propiedad medicionesAislamientoAcustico.
	 * 
	 */
	public void setMedicionesAislamientoAcustico(int value) {
		this.medicionesAislamientoAcustico = value;
	}

	/**
	 * Obtiene el valor de la propiedad calasCatasElementosConstructivos.
	 * 
	 */
	@Basic
	@Column(name = "CALAS_CATAS_ELEMENTOS_CONSTRUCTIVOS", precision = 10, scale = 0)
	public int getCalasCatasElementosConstructivos() {
		return calasCatasElementosConstructivos;
	}

	/**
	 * Define el valor de la propiedad calasCatasElementosConstructivos.
	 * 
	 */
	public void setCalasCatasElementosConstructivos(int value) {
		this.calasCatasElementosConstructivos = value;
	}

	/**
	 * Obtiene el valor de la propiedad cuestionariosConfortAcustico.
	 * 
	 */
	@Basic
	@Column(name = "CUESTIONARIOS_CONFORT_ACUSTICO", precision = 10, scale = 0)
	public int getCuestionariosConfortAcustico() {
		return cuestionariosConfortAcustico;
	}

	/**
	 * Define el valor de la propiedad cuestionariosConfortAcustico.
	 * 
	 */
	public void setCuestionariosConfortAcustico(int value) {
		this.cuestionariosConfortAcustico = value;
	}

	/**
	 * Obtiene el valor de la propiedad otras.
	 * 
	 */
	@Basic
	@Column(name = "OTRAS", precision = 10, scale = 0)
	public int getOtras() {
		return otras;
	}

	/**
	 * Define el valor de la propiedad otras.
	 * 
	 */
	public void setOtras(int value) {
		this.otras = value;
	}

	/**
	 * Obtiene el valor de la propiedad otrasTexto.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "OTRAS_TEXTO", length = 255)
	public String getOtrasTexto() {
		return otrasTexto;
	}

	/**
	 * Define el valor de la propiedad otrasTexto.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setOtrasTexto(String value) {
		this.otrasTexto = value;
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
		final AcusticaComprobacionesType that = ((AcusticaComprobacionesType) object);
		{
			int lhsMedicionesAislamientoAcustico;
			lhsMedicionesAislamientoAcustico = this.getMedicionesAislamientoAcustico();
			int rhsMedicionesAislamientoAcustico;
			rhsMedicionesAislamientoAcustico = that.getMedicionesAislamientoAcustico();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "medicionesAislamientoAcustico", lhsMedicionesAislamientoAcustico), LocatorUtils.property(thatLocator, "medicionesAislamientoAcustico", rhsMedicionesAislamientoAcustico), lhsMedicionesAislamientoAcustico, rhsMedicionesAislamientoAcustico)) {
				return false;
			}
		}
		{
			int lhsCalasCatasElementosConstructivos;
			lhsCalasCatasElementosConstructivos = this.getCalasCatasElementosConstructivos();
			int rhsCalasCatasElementosConstructivos;
			rhsCalasCatasElementosConstructivos = that.getCalasCatasElementosConstructivos();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "calasCatasElementosConstructivos", lhsCalasCatasElementosConstructivos), LocatorUtils.property(thatLocator, "calasCatasElementosConstructivos", rhsCalasCatasElementosConstructivos), lhsCalasCatasElementosConstructivos, rhsCalasCatasElementosConstructivos)) {
				return false;
			}
		}
		{
			int lhsCuestionariosConfortAcustico;
			lhsCuestionariosConfortAcustico = this.getCuestionariosConfortAcustico();
			int rhsCuestionariosConfortAcustico;
			rhsCuestionariosConfortAcustico = that.getCuestionariosConfortAcustico();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "cuestionariosConfortAcustico", lhsCuestionariosConfortAcustico), LocatorUtils.property(thatLocator, "cuestionariosConfortAcustico", rhsCuestionariosConfortAcustico), lhsCuestionariosConfortAcustico, rhsCuestionariosConfortAcustico)) {
				return false;
			}
		}
		{
			int lhsOtras;
			lhsOtras = this.getOtras();
			int rhsOtras;
			rhsOtras = that.getOtras();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "otras", lhsOtras), LocatorUtils.property(thatLocator, "otras", rhsOtras), lhsOtras, rhsOtras)) {
				return false;
			}
		}
		{
			String lhsOtrasTexto;
			lhsOtrasTexto = this.getOtrasTexto();
			String rhsOtrasTexto;
			rhsOtrasTexto = that.getOtrasTexto();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "otrasTexto", lhsOtrasTexto), LocatorUtils.property(thatLocator, "otrasTexto", rhsOtrasTexto), lhsOtrasTexto, rhsOtrasTexto)) {
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
			int theMedicionesAislamientoAcustico;
			theMedicionesAislamientoAcustico = this.getMedicionesAislamientoAcustico();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "medicionesAislamientoAcustico", theMedicionesAislamientoAcustico), currentHashCode, theMedicionesAislamientoAcustico);
		}
		{
			int theCalasCatasElementosConstructivos;
			theCalasCatasElementosConstructivos = this.getCalasCatasElementosConstructivos();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "calasCatasElementosConstructivos", theCalasCatasElementosConstructivos), currentHashCode, theCalasCatasElementosConstructivos);
		}
		{
			int theCuestionariosConfortAcustico;
			theCuestionariosConfortAcustico = this.getCuestionariosConfortAcustico();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "cuestionariosConfortAcustico", theCuestionariosConfortAcustico), currentHashCode, theCuestionariosConfortAcustico);
		}
		{
			int theOtras;
			theOtras = this.getOtras();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "otras", theOtras), currentHashCode, theOtras);
		}
		{
			String theOtrasTexto;
			theOtrasTexto = this.getOtrasTexto();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "otrasTexto", theOtrasTexto), currentHashCode, theOtrasTexto);
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
