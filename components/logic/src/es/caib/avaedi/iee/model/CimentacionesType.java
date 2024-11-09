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
 * Clase Java para cimentacionesType complex type.
 * 
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que
 * haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="cimentacionesType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="cimentacionprofunda_texto" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="cimentacionsuperficial_texto" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="sistemascontencion_texto" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="observaciones" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="cimentaciones_sistemascontenciones" type="{}cimentaciones_sistemascontencionesType"/&gt;
 *         &lt;element name="cimentaciones_cimentacionessuperficiales" type="{}cimentaciones_cimentacionessuperficialesType"/&gt;
 *         &lt;element name="cimentaciones_cimentacionesprofundas" type="{}cimentaciones_cimentacionesprofundasType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cimentacionesType", propOrder = { "cimentacionprofundaTexto", "cimentacionsuperficialTexto", "sistemascontencionTexto", "observaciones", "cimentacionesSistemascontenciones", "cimentacionesCimentacionessuperficiales", "cimentacionesCimentacionesprofundas" })
@Entity(name = "CimentacionesType")
@Table(name = "AED_CIMENTACIONES")
@Inheritance(strategy = InheritanceType.JOINED)
public class CimentacionesType implements Serializable, Equals, HashCode {

	@XmlElement(name = "cimentacionprofunda_texto", required = true)
	protected String cimentacionprofundaTexto;
	@XmlElement(name = "cimentacionsuperficial_texto", required = true)
	protected String cimentacionsuperficialTexto;
	@XmlElement(name = "sistemascontencion_texto", required = true)
	protected String sistemascontencionTexto;
	@XmlElement(required = true)
	protected String observaciones;
	@XmlElement(name = "cimentaciones_sistemascontenciones", required = true)
	protected CimentacionesSistemascontencionesType cimentacionesSistemascontenciones;
	@XmlElement(name = "cimentaciones_cimentacionessuperficiales", required = true)
	protected CimentacionesCimentacionessuperficialesType cimentacionesCimentacionessuperficiales;
	@XmlElement(name = "cimentaciones_cimentacionesprofundas", required = true)
	protected CimentacionesCimentacionesprofundasType cimentacionesCimentacionesprofundas;
	@XmlAttribute(name = "Hjid")
	protected Long hjid;

	/**
	 * Obtiene el valor de la propiedad cimentacionprofundaTexto.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "CIMENTACIONPROFUNDA_TEXTO", length = 255)
	public String getCimentacionprofundaTexto() {
		return cimentacionprofundaTexto;
	}

	/**
	 * Define el valor de la propiedad cimentacionprofundaTexto.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCimentacionprofundaTexto(String value) {
		this.cimentacionprofundaTexto = value;
	}

	/**
	 * Obtiene el valor de la propiedad cimentacionsuperficialTexto.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "CIMENTACIONSUPERFICIAL_TEXTO", length = 255)
	public String getCimentacionsuperficialTexto() {
		return cimentacionsuperficialTexto;
	}

	/**
	 * Define el valor de la propiedad cimentacionsuperficialTexto.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCimentacionsuperficialTexto(String value) {
		this.cimentacionsuperficialTexto = value;
	}

	/**
	 * Obtiene el valor de la propiedad sistemascontencionTexto.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "SISTEMASCONTENCION_TEXTO", length = 255)
	public String getSistemascontencionTexto() {
		return sistemascontencionTexto;
	}

	/**
	 * Define el valor de la propiedad sistemascontencionTexto.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSistemascontencionTexto(String value) {
		this.sistemascontencionTexto = value;
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
	 * Obtiene el valor de la propiedad cimentacionesSistemascontenciones.
	 * 
	 * @return possible object is {@link CimentacionesSistemascontencionesType }
	 * 
	 */
	@ManyToOne(targetEntity = CimentacionesSistemascontencionesType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "CIMENTACIONES_SISTEMASCONTENCIONES_AED_CIMENTACIONES_HJID")
	public CimentacionesSistemascontencionesType getCimentacionesSistemascontenciones() {
		return cimentacionesSistemascontenciones;
	}

	/**
	 * Define el valor de la propiedad cimentacionesSistemascontenciones.
	 * 
	 * @param value
	 *            allowed object is
	 *            {@link CimentacionesSistemascontencionesType }
	 * 
	 */
	public void setCimentacionesSistemascontenciones(CimentacionesSistemascontencionesType value) {
		this.cimentacionesSistemascontenciones = value;
	}

	/**
	 * Obtiene el valor de la propiedad cimentacionesCimentacionessuperficiales.
	 * 
	 * @return possible object is
	 *         {@link CimentacionesCimentacionessuperficialesType }
	 * 
	 */
	@ManyToOne(targetEntity = CimentacionesCimentacionessuperficialesType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "CIMENTACIONES_CIMENTACIONESSUPERFICIALES_AED_CIMENTACIONES_HJID")
	public CimentacionesCimentacionessuperficialesType getCimentacionesCimentacionessuperficiales() {
		return cimentacionesCimentacionessuperficiales;
	}

	/**
	 * Define el valor de la propiedad cimentacionesCimentacionessuperficiales.
	 * 
	 * @param value
	 *            allowed object is
	 *            {@link CimentacionesCimentacionessuperficialesType }
	 * 
	 */
	public void setCimentacionesCimentacionessuperficiales(CimentacionesCimentacionessuperficialesType value) {
		this.cimentacionesCimentacionessuperficiales = value;
	}

	/**
	 * Obtiene el valor de la propiedad cimentacionesCimentacionesprofundas.
	 * 
	 * @return possible object is
	 *         {@link CimentacionesCimentacionesprofundasType }
	 * 
	 */
	@ManyToOne(targetEntity = CimentacionesCimentacionesprofundasType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "CIMENTACIONES_CIMENTACIONESPROFUNDAS_AED_CIMENTACIONES_HJID")
	public CimentacionesCimentacionesprofundasType getCimentacionesCimentacionesprofundas() {
		return cimentacionesCimentacionesprofundas;
	}

	/**
	 * Define el valor de la propiedad cimentacionesCimentacionesprofundas.
	 * 
	 * @param value
	 *            allowed object is
	 *            {@link CimentacionesCimentacionesprofundasType }
	 * 
	 */
	public void setCimentacionesCimentacionesprofundas(CimentacionesCimentacionesprofundasType value) {
		this.cimentacionesCimentacionesprofundas = value;
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
		final CimentacionesType that = ((CimentacionesType) object);
		{
			String lhsCimentacionprofundaTexto;
			lhsCimentacionprofundaTexto = this.getCimentacionprofundaTexto();
			String rhsCimentacionprofundaTexto;
			rhsCimentacionprofundaTexto = that.getCimentacionprofundaTexto();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "cimentacionprofundaTexto", lhsCimentacionprofundaTexto), LocatorUtils.property(thatLocator, "cimentacionprofundaTexto", rhsCimentacionprofundaTexto), lhsCimentacionprofundaTexto, rhsCimentacionprofundaTexto)) {
				return false;
			}
		}
		{
			String lhsCimentacionsuperficialTexto;
			lhsCimentacionsuperficialTexto = this.getCimentacionsuperficialTexto();
			String rhsCimentacionsuperficialTexto;
			rhsCimentacionsuperficialTexto = that.getCimentacionsuperficialTexto();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "cimentacionsuperficialTexto", lhsCimentacionsuperficialTexto), LocatorUtils.property(thatLocator, "cimentacionsuperficialTexto", rhsCimentacionsuperficialTexto), lhsCimentacionsuperficialTexto, rhsCimentacionsuperficialTexto)) {
				return false;
			}
		}
		{
			String lhsSistemascontencionTexto;
			lhsSistemascontencionTexto = this.getSistemascontencionTexto();
			String rhsSistemascontencionTexto;
			rhsSistemascontencionTexto = that.getSistemascontencionTexto();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "sistemascontencionTexto", lhsSistemascontencionTexto), LocatorUtils.property(thatLocator, "sistemascontencionTexto", rhsSistemascontencionTexto), lhsSistemascontencionTexto, rhsSistemascontencionTexto)) {
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
			CimentacionesSistemascontencionesType lhsCimentacionesSistemascontenciones;
			lhsCimentacionesSistemascontenciones = this.getCimentacionesSistemascontenciones();
			CimentacionesSistemascontencionesType rhsCimentacionesSistemascontenciones;
			rhsCimentacionesSistemascontenciones = that.getCimentacionesSistemascontenciones();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "cimentacionesSistemascontenciones", lhsCimentacionesSistemascontenciones), LocatorUtils.property(thatLocator, "cimentacionesSistemascontenciones", rhsCimentacionesSistemascontenciones), lhsCimentacionesSistemascontenciones, rhsCimentacionesSistemascontenciones)) {
				return false;
			}
		}
		{
			CimentacionesCimentacionessuperficialesType lhsCimentacionesCimentacionessuperficiales;
			lhsCimentacionesCimentacionessuperficiales = this.getCimentacionesCimentacionessuperficiales();
			CimentacionesCimentacionessuperficialesType rhsCimentacionesCimentacionessuperficiales;
			rhsCimentacionesCimentacionessuperficiales = that.getCimentacionesCimentacionessuperficiales();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "cimentacionesCimentacionessuperficiales", lhsCimentacionesCimentacionessuperficiales), LocatorUtils.property(thatLocator, "cimentacionesCimentacionessuperficiales", rhsCimentacionesCimentacionessuperficiales), lhsCimentacionesCimentacionessuperficiales, rhsCimentacionesCimentacionessuperficiales)) {
				return false;
			}
		}
		{
			CimentacionesCimentacionesprofundasType lhsCimentacionesCimentacionesprofundas;
			lhsCimentacionesCimentacionesprofundas = this.getCimentacionesCimentacionesprofundas();
			CimentacionesCimentacionesprofundasType rhsCimentacionesCimentacionesprofundas;
			rhsCimentacionesCimentacionesprofundas = that.getCimentacionesCimentacionesprofundas();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "cimentacionesCimentacionesprofundas", lhsCimentacionesCimentacionesprofundas), LocatorUtils.property(thatLocator, "cimentacionesCimentacionesprofundas", rhsCimentacionesCimentacionesprofundas), lhsCimentacionesCimentacionesprofundas, rhsCimentacionesCimentacionesprofundas)) {
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
			String theCimentacionprofundaTexto;
			theCimentacionprofundaTexto = this.getCimentacionprofundaTexto();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "cimentacionprofundaTexto", theCimentacionprofundaTexto), currentHashCode, theCimentacionprofundaTexto);
		}
		{
			String theCimentacionsuperficialTexto;
			theCimentacionsuperficialTexto = this.getCimentacionsuperficialTexto();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "cimentacionsuperficialTexto", theCimentacionsuperficialTexto), currentHashCode, theCimentacionsuperficialTexto);
		}
		{
			String theSistemascontencionTexto;
			theSistemascontencionTexto = this.getSistemascontencionTexto();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "sistemascontencionTexto", theSistemascontencionTexto), currentHashCode, theSistemascontencionTexto);
		}
		{
			String theObservaciones;
			theObservaciones = this.getObservaciones();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "observaciones", theObservaciones), currentHashCode, theObservaciones);
		}
		{
			CimentacionesSistemascontencionesType theCimentacionesSistemascontenciones;
			theCimentacionesSistemascontenciones = this.getCimentacionesSistemascontenciones();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "cimentacionesSistemascontenciones", theCimentacionesSistemascontenciones), currentHashCode, theCimentacionesSistemascontenciones);
		}
		{
			CimentacionesCimentacionessuperficialesType theCimentacionesCimentacionessuperficiales;
			theCimentacionesCimentacionessuperficiales = this.getCimentacionesCimentacionessuperficiales();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "cimentacionesCimentacionessuperficiales", theCimentacionesCimentacionessuperficiales), currentHashCode, theCimentacionesCimentacionessuperficiales);
		}
		{
			CimentacionesCimentacionesprofundasType theCimentacionesCimentacionesprofundas;
			theCimentacionesCimentacionesprofundas = this.getCimentacionesCimentacionesprofundas();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "cimentacionesCimentacionesprofundas", theCimentacionesCimentacionesprofundas), currentHashCode, theCimentacionesCimentacionesprofundas);
		}
		return currentHashCode;
	}

	public int hashCode() {
		final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
		return this.hashCode(null, strategy);
	}

}
