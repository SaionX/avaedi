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
 * Clase Java para historicoType complex type.
 * 
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que
 * haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="historicoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="fecha_inspeccion" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="tecnico" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="resultado" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="grado_ejecucion_efectividad_obras" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
@XmlType(name = "historicoType", propOrder = { "fechaInspeccion", "tecnico", "resultado", "gradoEjecucionEfectividadObras", "observaciones" })
@Entity(name = "HistoricoType")
@Table(name = "AED_HISTORICO")
@Inheritance(strategy = InheritanceType.JOINED)
public class HistoricoType implements Serializable, Equals, HashCode {

	@XmlElement(name = "fecha_inspeccion", required = true)
	protected String fechaInspeccion;
	@XmlElement(required = true)
	protected String tecnico;
	@XmlElement(required = true)
	protected String resultado;
	@XmlElement(name = "grado_ejecucion_efectividad_obras", required = true)
	protected String gradoEjecucionEfectividadObras;
	@XmlElement(required = true)
	protected String observaciones;
	@XmlAttribute(name = "Hjid")
	protected Long hjid;

	/**
	 * Obtiene el valor de la propiedad fechaInspeccion.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "FECHA_INSPECCION", length = 255)
	public String getFechaInspeccion() {
		return fechaInspeccion;
	}

	/**
	 * Define el valor de la propiedad fechaInspeccion.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setFechaInspeccion(String value) {
		this.fechaInspeccion = value;
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
	 * Obtiene el valor de la propiedad resultado.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "RESULTADO", length = 255)
	public String getResultado() {
		return resultado;
	}

	/**
	 * Define el valor de la propiedad resultado.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setResultado(String value) {
		this.resultado = value;
	}

	/**
	 * Obtiene el valor de la propiedad gradoEjecucionEfectividadObras.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "GRADO_EJECUCION_EFECTIVIDAD_OBRAS", length = 255)
	public String getGradoEjecucionEfectividadObras() {
		return gradoEjecucionEfectividadObras;
	}

	/**
	 * Define el valor de la propiedad gradoEjecucionEfectividadObras.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setGradoEjecucionEfectividadObras(String value) {
		this.gradoEjecucionEfectividadObras = value;
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
		final HistoricoType that = ((HistoricoType) object);
		{
			String lhsFechaInspeccion;
			lhsFechaInspeccion = this.getFechaInspeccion();
			String rhsFechaInspeccion;
			rhsFechaInspeccion = that.getFechaInspeccion();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "fechaInspeccion", lhsFechaInspeccion), LocatorUtils.property(thatLocator, "fechaInspeccion", rhsFechaInspeccion), lhsFechaInspeccion, rhsFechaInspeccion)) {
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
			String lhsResultado;
			lhsResultado = this.getResultado();
			String rhsResultado;
			rhsResultado = that.getResultado();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "resultado", lhsResultado), LocatorUtils.property(thatLocator, "resultado", rhsResultado), lhsResultado, rhsResultado)) {
				return false;
			}
		}
		{
			String lhsGradoEjecucionEfectividadObras;
			lhsGradoEjecucionEfectividadObras = this.getGradoEjecucionEfectividadObras();
			String rhsGradoEjecucionEfectividadObras;
			rhsGradoEjecucionEfectividadObras = that.getGradoEjecucionEfectividadObras();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "gradoEjecucionEfectividadObras", lhsGradoEjecucionEfectividadObras), LocatorUtils.property(thatLocator, "gradoEjecucionEfectividadObras", rhsGradoEjecucionEfectividadObras), lhsGradoEjecucionEfectividadObras, rhsGradoEjecucionEfectividadObras)) {
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
			String theFechaInspeccion;
			theFechaInspeccion = this.getFechaInspeccion();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "fechaInspeccion", theFechaInspeccion), currentHashCode, theFechaInspeccion);
		}
		{
			String theTecnico;
			theTecnico = this.getTecnico();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "tecnico", theTecnico), currentHashCode, theTecnico);
		}
		{
			String theResultado;
			theResultado = this.getResultado();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "resultado", theResultado), currentHashCode, theResultado);
		}
		{
			String theGradoEjecucionEfectividadObras;
			theGradoEjecucionEfectividadObras = this.getGradoEjecucionEfectividadObras();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "gradoEjecucionEfectividadObras", theGradoEjecucionEfectividadObras), currentHashCode, theGradoEjecucionEfectividadObras);
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
