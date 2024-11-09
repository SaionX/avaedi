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
 * Clase Java para accesibilidad_valoracionfinalesType complex type.
 * 
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que
 * haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="accesibilidad_valoracionfinalesType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="satisface_condiciones_basicas" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="deficiencias_vivienda_exterior" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="deficiencias_vivienda_entreplantas" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="deficiencias_vivienda_plantas" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="deficiencias_vivienda_aparcamiento" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="deficiencias_vivienda_piscinas" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="deficiencias_vivienda_servicioshigienicos" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="deficiencias_vivienda_mecanismos" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="deficiencias_vivienda_informacionsenalizacion" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="deficiencias_publico_exterior" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="deficiencias_publico_entreplantas" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="deficiencias_publico_plantas" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="deficiencias_publico_alojamientosaccesibles" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="deficiencias_publico_aparcamiento" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="deficiencias_publico_plazasreservadas" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="deficiencias_publico_piscinas" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="deficiencias_publico_servicioshigienicos" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="deficiencias_publico_mobiliariofijo" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="deficiencias_publico_mecanismos" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="deficiencias_publico_informacionsenalizacion" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "accesibilidad_valoracionfinalesType", propOrder = { "satisfaceCondicionesBasicas", "deficienciasViviendaExterior", "deficienciasViviendaEntreplantas", "deficienciasViviendaPlantas", "deficienciasViviendaAparcamiento", "deficienciasViviendaPiscinas", "deficienciasViviendaServicioshigienicos", "deficienciasViviendaMecanismos", "deficienciasViviendaInformacionsenalizacion", "deficienciasPublicoExterior", "deficienciasPublicoEntreplantas", "deficienciasPublicoPlantas", "deficienciasPublicoAlojamientosaccesibles", "deficienciasPublicoAparcamiento", "deficienciasPublicoPlazasreservadas", "deficienciasPublicoPiscinas", "deficienciasPublicoServicioshigienicos", "deficienciasPublicoMobiliariofijo", "deficienciasPublicoMecanismos", "deficienciasPublicoInformacionsenalizacion" })
@Entity(name = "AccesibilidadValoracionfinalesType")
@Table(name = "AED_ACC_VALORACIONFINALES")
@Inheritance(strategy = InheritanceType.JOINED)
public class AccesibilidadValoracionfinalesType implements Serializable, Equals, HashCode {

	@XmlElement(name = "satisface_condiciones_basicas")
	protected int satisfaceCondicionesBasicas;
	@XmlElement(name = "deficiencias_vivienda_exterior", required = true)
	protected String deficienciasViviendaExterior;
	@XmlElement(name = "deficiencias_vivienda_entreplantas", required = true)
	protected String deficienciasViviendaEntreplantas;
	@XmlElement(name = "deficiencias_vivienda_plantas", required = true)
	protected String deficienciasViviendaPlantas;
	@XmlElement(name = "deficiencias_vivienda_aparcamiento", required = true)
	protected String deficienciasViviendaAparcamiento;
	@XmlElement(name = "deficiencias_vivienda_piscinas", required = true)
	protected String deficienciasViviendaPiscinas;
	@XmlElement(name = "deficiencias_vivienda_servicioshigienicos", required = true)
	protected String deficienciasViviendaServicioshigienicos;
	@XmlElement(name = "deficiencias_vivienda_mecanismos", required = true)
	protected String deficienciasViviendaMecanismos;
	@XmlElement(name = "deficiencias_vivienda_informacionsenalizacion", required = true)
	protected String deficienciasViviendaInformacionsenalizacion;
	@XmlElement(name = "deficiencias_publico_exterior")
	protected int deficienciasPublicoExterior;
	@XmlElement(name = "deficiencias_publico_entreplantas")
	protected int deficienciasPublicoEntreplantas;
	@XmlElement(name = "deficiencias_publico_plantas")
	protected int deficienciasPublicoPlantas;
	@XmlElement(name = "deficiencias_publico_alojamientosaccesibles")
	protected int deficienciasPublicoAlojamientosaccesibles;
	@XmlElement(name = "deficiencias_publico_aparcamiento")
	protected int deficienciasPublicoAparcamiento;
	@XmlElement(name = "deficiencias_publico_plazasreservadas")
	protected int deficienciasPublicoPlazasreservadas;
	@XmlElement(name = "deficiencias_publico_piscinas")
	protected int deficienciasPublicoPiscinas;
	@XmlElement(name = "deficiencias_publico_servicioshigienicos")
	protected int deficienciasPublicoServicioshigienicos;
	@XmlElement(name = "deficiencias_publico_mobiliariofijo")
	protected int deficienciasPublicoMobiliariofijo;
	@XmlElement(name = "deficiencias_publico_mecanismos")
	protected int deficienciasPublicoMecanismos;
	@XmlElement(name = "deficiencias_publico_informacionsenalizacion")
	protected int deficienciasPublicoInformacionsenalizacion;
	@XmlAttribute(name = "Hjid")
	protected Long hjid;

	/**
	 * Obtiene el valor de la propiedad satisfaceCondicionesBasicas.
	 * 
	 */
	@Basic
	@Column(name = "SATISFACE_CONDICIONES_BASICAS", precision = 10, scale = 0)
	public int getSatisfaceCondicionesBasicas() {
		return satisfaceCondicionesBasicas;
	}

	/**
	 * Define el valor de la propiedad satisfaceCondicionesBasicas.
	 * 
	 */
	public void setSatisfaceCondicionesBasicas(int value) {
		this.satisfaceCondicionesBasicas = value;
	}

	/**
	 * Obtiene el valor de la propiedad deficienciasViviendaExterior.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "DEFICIENCIAS_VIVIENDA_EXTERIOR", length = 255)
	public String getDeficienciasViviendaExterior() {
		return deficienciasViviendaExterior;
	}

	/**
	 * Define el valor de la propiedad deficienciasViviendaExterior.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDeficienciasViviendaExterior(String value) {
		this.deficienciasViviendaExterior = value;
	}

	/**
	 * Obtiene el valor de la propiedad deficienciasViviendaEntreplantas.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "DEFICIENCIAS_VIVIENDA_ENTREPLANTAS", length = 255)
	public String getDeficienciasViviendaEntreplantas() {
		return deficienciasViviendaEntreplantas;
	}

	/**
	 * Define el valor de la propiedad deficienciasViviendaEntreplantas.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDeficienciasViviendaEntreplantas(String value) {
		this.deficienciasViviendaEntreplantas = value;
	}

	/**
	 * Obtiene el valor de la propiedad deficienciasViviendaPlantas.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "DEFICIENCIAS_VIVIENDA_PLANTAS", length = 255)
	public String getDeficienciasViviendaPlantas() {
		return deficienciasViviendaPlantas;
	}

	/**
	 * Define el valor de la propiedad deficienciasViviendaPlantas.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDeficienciasViviendaPlantas(String value) {
		this.deficienciasViviendaPlantas = value;
	}

	/**
	 * Obtiene el valor de la propiedad deficienciasViviendaAparcamiento.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "DEFICIENCIAS_VIVIENDA_APARCAMIENTO", length = 255)
	public String getDeficienciasViviendaAparcamiento() {
		return deficienciasViviendaAparcamiento;
	}

	/**
	 * Define el valor de la propiedad deficienciasViviendaAparcamiento.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDeficienciasViviendaAparcamiento(String value) {
		this.deficienciasViviendaAparcamiento = value;
	}

	/**
	 * Obtiene el valor de la propiedad deficienciasViviendaPiscinas.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "DEFICIENCIAS_VIVIENDA_PISCINAS", length = 255)
	public String getDeficienciasViviendaPiscinas() {
		return deficienciasViviendaPiscinas;
	}

	/**
	 * Define el valor de la propiedad deficienciasViviendaPiscinas.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDeficienciasViviendaPiscinas(String value) {
		this.deficienciasViviendaPiscinas = value;
	}

	/**
	 * Obtiene el valor de la propiedad deficienciasViviendaServicioshigienicos.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "DEFICIENCIAS_VIVIENDA_SERVICIOSHIGIENICOS", length = 255)
	public String getDeficienciasViviendaServicioshigienicos() {
		return deficienciasViviendaServicioshigienicos;
	}

	/**
	 * Define el valor de la propiedad deficienciasViviendaServicioshigienicos.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDeficienciasViviendaServicioshigienicos(String value) {
		this.deficienciasViviendaServicioshigienicos = value;
	}

	/**
	 * Obtiene el valor de la propiedad deficienciasViviendaMecanismos.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "DEFICIENCIAS_VIVIENDA_MECANISMOS", length = 255)
	public String getDeficienciasViviendaMecanismos() {
		return deficienciasViviendaMecanismos;
	}

	/**
	 * Define el valor de la propiedad deficienciasViviendaMecanismos.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDeficienciasViviendaMecanismos(String value) {
		this.deficienciasViviendaMecanismos = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * deficienciasViviendaInformacionsenalizacion.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "DEFICIENCIAS_VIVIENDA_INFORMACIONSENALIZACION", length = 255)
	public String getDeficienciasViviendaInformacionsenalizacion() {
		return deficienciasViviendaInformacionsenalizacion;
	}

	/**
	 * Define el valor de la propiedad
	 * deficienciasViviendaInformacionsenalizacion.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDeficienciasViviendaInformacionsenalizacion(String value) {
		this.deficienciasViviendaInformacionsenalizacion = value;
	}

	/**
	 * Obtiene el valor de la propiedad deficienciasPublicoExterior.
	 * 
	 */
	@Basic
	@Column(name = "DEFICIENCIAS_PUBLICO_EXTERIOR", precision = 10, scale = 0)
	public int getDeficienciasPublicoExterior() {
		return deficienciasPublicoExterior;
	}

	/**
	 * Define el valor de la propiedad deficienciasPublicoExterior.
	 * 
	 */
	public void setDeficienciasPublicoExterior(int value) {
		this.deficienciasPublicoExterior = value;
	}

	/**
	 * Obtiene el valor de la propiedad deficienciasPublicoEntreplantas.
	 * 
	 */
	@Basic
	@Column(name = "DEFICIENCIAS_PUBLICO_ENTREPLANTAS", precision = 10, scale = 0)
	public int getDeficienciasPublicoEntreplantas() {
		return deficienciasPublicoEntreplantas;
	}

	/**
	 * Define el valor de la propiedad deficienciasPublicoEntreplantas.
	 * 
	 */
	public void setDeficienciasPublicoEntreplantas(int value) {
		this.deficienciasPublicoEntreplantas = value;
	}

	/**
	 * Obtiene el valor de la propiedad deficienciasPublicoPlantas.
	 * 
	 */
	@Basic
	@Column(name = "DEFICIENCIAS_PUBLICO_PLANTAS", precision = 10, scale = 0)
	public int getDeficienciasPublicoPlantas() {
		return deficienciasPublicoPlantas;
	}

	/**
	 * Define el valor de la propiedad deficienciasPublicoPlantas.
	 * 
	 */
	public void setDeficienciasPublicoPlantas(int value) {
		this.deficienciasPublicoPlantas = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * deficienciasPublicoAlojamientosaccesibles.
	 * 
	 */
	@Basic
	@Column(name = "DEFICIENCIAS_PUBLICO_ALOJAMIENTOSACCESIBLES", precision = 10, scale = 0)
	public int getDeficienciasPublicoAlojamientosaccesibles() {
		return deficienciasPublicoAlojamientosaccesibles;
	}

	/**
	 * Define el valor de la propiedad
	 * deficienciasPublicoAlojamientosaccesibles.
	 * 
	 */
	public void setDeficienciasPublicoAlojamientosaccesibles(int value) {
		this.deficienciasPublicoAlojamientosaccesibles = value;
	}

	/**
	 * Obtiene el valor de la propiedad deficienciasPublicoAparcamiento.
	 * 
	 */
	@Basic
	@Column(name = "DEFICIENCIAS_PUBLICO_APARCAMIENTO", precision = 10, scale = 0)
	public int getDeficienciasPublicoAparcamiento() {
		return deficienciasPublicoAparcamiento;
	}

	/**
	 * Define el valor de la propiedad deficienciasPublicoAparcamiento.
	 * 
	 */
	public void setDeficienciasPublicoAparcamiento(int value) {
		this.deficienciasPublicoAparcamiento = value;
	}

	/**
	 * Obtiene el valor de la propiedad deficienciasPublicoPlazasreservadas.
	 * 
	 */
	@Basic
	@Column(name = "DEFICIENCIAS_PUBLICO_PLAZASRESERVADAS", precision = 10, scale = 0)
	public int getDeficienciasPublicoPlazasreservadas() {
		return deficienciasPublicoPlazasreservadas;
	}

	/**
	 * Define el valor de la propiedad deficienciasPublicoPlazasreservadas.
	 * 
	 */
	public void setDeficienciasPublicoPlazasreservadas(int value) {
		this.deficienciasPublicoPlazasreservadas = value;
	}

	/**
	 * Obtiene el valor de la propiedad deficienciasPublicoPiscinas.
	 * 
	 */
	@Basic
	@Column(name = "DEFICIENCIAS_PUBLICO_PISCINAS", precision = 10, scale = 0)
	public int getDeficienciasPublicoPiscinas() {
		return deficienciasPublicoPiscinas;
	}

	/**
	 * Define el valor de la propiedad deficienciasPublicoPiscinas.
	 * 
	 */
	public void setDeficienciasPublicoPiscinas(int value) {
		this.deficienciasPublicoPiscinas = value;
	}

	/**
	 * Obtiene el valor de la propiedad deficienciasPublicoServicioshigienicos.
	 * 
	 */
	@Basic
	@Column(name = "DEFICIENCIAS_PUBLICO_SERVICIOSHIGIENICOS", precision = 10, scale = 0)
	public int getDeficienciasPublicoServicioshigienicos() {
		return deficienciasPublicoServicioshigienicos;
	}

	/**
	 * Define el valor de la propiedad deficienciasPublicoServicioshigienicos.
	 * 
	 */
	public void setDeficienciasPublicoServicioshigienicos(int value) {
		this.deficienciasPublicoServicioshigienicos = value;
	}

	/**
	 * Obtiene el valor de la propiedad deficienciasPublicoMobiliariofijo.
	 * 
	 */
	@Basic
	@Column(name = "DEFICIENCIAS_PUBLICO_MOBILIARIOFIJO", precision = 10, scale = 0)
	public int getDeficienciasPublicoMobiliariofijo() {
		return deficienciasPublicoMobiliariofijo;
	}

	/**
	 * Define el valor de la propiedad deficienciasPublicoMobiliariofijo.
	 * 
	 */
	public void setDeficienciasPublicoMobiliariofijo(int value) {
		this.deficienciasPublicoMobiliariofijo = value;
	}

	/**
	 * Obtiene el valor de la propiedad deficienciasPublicoMecanismos.
	 * 
	 */
	@Basic
	@Column(name = "DEFICIENCIAS_PUBLICO_MECANISMOS", precision = 10, scale = 0)
	public int getDeficienciasPublicoMecanismos() {
		return deficienciasPublicoMecanismos;
	}

	/**
	 * Define el valor de la propiedad deficienciasPublicoMecanismos.
	 * 
	 */
	public void setDeficienciasPublicoMecanismos(int value) {
		this.deficienciasPublicoMecanismos = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * deficienciasPublicoInformacionsenalizacion.
	 * 
	 */
	@Basic
	@Column(name = "DEFICIENCIAS_PUBLICO_INFORMACIONSENALIZACION", precision = 10, scale = 0)
	public int getDeficienciasPublicoInformacionsenalizacion() {
		return deficienciasPublicoInformacionsenalizacion;
	}

	/**
	 * Define el valor de la propiedad
	 * deficienciasPublicoInformacionsenalizacion.
	 * 
	 */
	public void setDeficienciasPublicoInformacionsenalizacion(int value) {
		this.deficienciasPublicoInformacionsenalizacion = value;
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
		final AccesibilidadValoracionfinalesType that = ((AccesibilidadValoracionfinalesType) object);
		{
			int lhsSatisfaceCondicionesBasicas;
			lhsSatisfaceCondicionesBasicas = this.getSatisfaceCondicionesBasicas();
			int rhsSatisfaceCondicionesBasicas;
			rhsSatisfaceCondicionesBasicas = that.getSatisfaceCondicionesBasicas();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "satisfaceCondicionesBasicas", lhsSatisfaceCondicionesBasicas), LocatorUtils.property(thatLocator, "satisfaceCondicionesBasicas", rhsSatisfaceCondicionesBasicas), lhsSatisfaceCondicionesBasicas, rhsSatisfaceCondicionesBasicas)) {
				return false;
			}
		}
		{
			String lhsDeficienciasViviendaExterior;
			lhsDeficienciasViviendaExterior = this.getDeficienciasViviendaExterior();
			String rhsDeficienciasViviendaExterior;
			rhsDeficienciasViviendaExterior = that.getDeficienciasViviendaExterior();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "deficienciasViviendaExterior", lhsDeficienciasViviendaExterior), LocatorUtils.property(thatLocator, "deficienciasViviendaExterior", rhsDeficienciasViviendaExterior), lhsDeficienciasViviendaExterior, rhsDeficienciasViviendaExterior)) {
				return false;
			}
		}
		{
			String lhsDeficienciasViviendaEntreplantas;
			lhsDeficienciasViviendaEntreplantas = this.getDeficienciasViviendaEntreplantas();
			String rhsDeficienciasViviendaEntreplantas;
			rhsDeficienciasViviendaEntreplantas = that.getDeficienciasViviendaEntreplantas();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "deficienciasViviendaEntreplantas", lhsDeficienciasViviendaEntreplantas), LocatorUtils.property(thatLocator, "deficienciasViviendaEntreplantas", rhsDeficienciasViviendaEntreplantas), lhsDeficienciasViviendaEntreplantas, rhsDeficienciasViviendaEntreplantas)) {
				return false;
			}
		}
		{
			String lhsDeficienciasViviendaPlantas;
			lhsDeficienciasViviendaPlantas = this.getDeficienciasViviendaPlantas();
			String rhsDeficienciasViviendaPlantas;
			rhsDeficienciasViviendaPlantas = that.getDeficienciasViviendaPlantas();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "deficienciasViviendaPlantas", lhsDeficienciasViviendaPlantas), LocatorUtils.property(thatLocator, "deficienciasViviendaPlantas", rhsDeficienciasViviendaPlantas), lhsDeficienciasViviendaPlantas, rhsDeficienciasViviendaPlantas)) {
				return false;
			}
		}
		{
			String lhsDeficienciasViviendaAparcamiento;
			lhsDeficienciasViviendaAparcamiento = this.getDeficienciasViviendaAparcamiento();
			String rhsDeficienciasViviendaAparcamiento;
			rhsDeficienciasViviendaAparcamiento = that.getDeficienciasViviendaAparcamiento();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "deficienciasViviendaAparcamiento", lhsDeficienciasViviendaAparcamiento), LocatorUtils.property(thatLocator, "deficienciasViviendaAparcamiento", rhsDeficienciasViviendaAparcamiento), lhsDeficienciasViviendaAparcamiento, rhsDeficienciasViviendaAparcamiento)) {
				return false;
			}
		}
		{
			String lhsDeficienciasViviendaPiscinas;
			lhsDeficienciasViviendaPiscinas = this.getDeficienciasViviendaPiscinas();
			String rhsDeficienciasViviendaPiscinas;
			rhsDeficienciasViviendaPiscinas = that.getDeficienciasViviendaPiscinas();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "deficienciasViviendaPiscinas", lhsDeficienciasViviendaPiscinas), LocatorUtils.property(thatLocator, "deficienciasViviendaPiscinas", rhsDeficienciasViviendaPiscinas), lhsDeficienciasViviendaPiscinas, rhsDeficienciasViviendaPiscinas)) {
				return false;
			}
		}
		{
			String lhsDeficienciasViviendaServicioshigienicos;
			lhsDeficienciasViviendaServicioshigienicos = this.getDeficienciasViviendaServicioshigienicos();
			String rhsDeficienciasViviendaServicioshigienicos;
			rhsDeficienciasViviendaServicioshigienicos = that.getDeficienciasViviendaServicioshigienicos();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "deficienciasViviendaServicioshigienicos", lhsDeficienciasViviendaServicioshigienicos), LocatorUtils.property(thatLocator, "deficienciasViviendaServicioshigienicos", rhsDeficienciasViviendaServicioshigienicos), lhsDeficienciasViviendaServicioshigienicos, rhsDeficienciasViviendaServicioshigienicos)) {
				return false;
			}
		}
		{
			String lhsDeficienciasViviendaMecanismos;
			lhsDeficienciasViviendaMecanismos = this.getDeficienciasViviendaMecanismos();
			String rhsDeficienciasViviendaMecanismos;
			rhsDeficienciasViviendaMecanismos = that.getDeficienciasViviendaMecanismos();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "deficienciasViviendaMecanismos", lhsDeficienciasViviendaMecanismos), LocatorUtils.property(thatLocator, "deficienciasViviendaMecanismos", rhsDeficienciasViviendaMecanismos), lhsDeficienciasViviendaMecanismos, rhsDeficienciasViviendaMecanismos)) {
				return false;
			}
		}
		{
			String lhsDeficienciasViviendaInformacionsenalizacion;
			lhsDeficienciasViviendaInformacionsenalizacion = this.getDeficienciasViviendaInformacionsenalizacion();
			String rhsDeficienciasViviendaInformacionsenalizacion;
			rhsDeficienciasViviendaInformacionsenalizacion = that.getDeficienciasViviendaInformacionsenalizacion();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "deficienciasViviendaInformacionsenalizacion", lhsDeficienciasViviendaInformacionsenalizacion), LocatorUtils.property(thatLocator, "deficienciasViviendaInformacionsenalizacion", rhsDeficienciasViviendaInformacionsenalizacion), lhsDeficienciasViviendaInformacionsenalizacion, rhsDeficienciasViviendaInformacionsenalizacion)) {
				return false;
			}
		}
		{
			int lhsDeficienciasPublicoExterior;
			lhsDeficienciasPublicoExterior = this.getDeficienciasPublicoExterior();
			int rhsDeficienciasPublicoExterior;
			rhsDeficienciasPublicoExterior = that.getDeficienciasPublicoExterior();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "deficienciasPublicoExterior", lhsDeficienciasPublicoExterior), LocatorUtils.property(thatLocator, "deficienciasPublicoExterior", rhsDeficienciasPublicoExterior), lhsDeficienciasPublicoExterior, rhsDeficienciasPublicoExterior)) {
				return false;
			}
		}
		{
			int lhsDeficienciasPublicoEntreplantas;
			lhsDeficienciasPublicoEntreplantas = this.getDeficienciasPublicoEntreplantas();
			int rhsDeficienciasPublicoEntreplantas;
			rhsDeficienciasPublicoEntreplantas = that.getDeficienciasPublicoEntreplantas();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "deficienciasPublicoEntreplantas", lhsDeficienciasPublicoEntreplantas), LocatorUtils.property(thatLocator, "deficienciasPublicoEntreplantas", rhsDeficienciasPublicoEntreplantas), lhsDeficienciasPublicoEntreplantas, rhsDeficienciasPublicoEntreplantas)) {
				return false;
			}
		}
		{
			int lhsDeficienciasPublicoPlantas;
			lhsDeficienciasPublicoPlantas = this.getDeficienciasPublicoPlantas();
			int rhsDeficienciasPublicoPlantas;
			rhsDeficienciasPublicoPlantas = that.getDeficienciasPublicoPlantas();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "deficienciasPublicoPlantas", lhsDeficienciasPublicoPlantas), LocatorUtils.property(thatLocator, "deficienciasPublicoPlantas", rhsDeficienciasPublicoPlantas), lhsDeficienciasPublicoPlantas, rhsDeficienciasPublicoPlantas)) {
				return false;
			}
		}
		{
			int lhsDeficienciasPublicoAlojamientosaccesibles;
			lhsDeficienciasPublicoAlojamientosaccesibles = this.getDeficienciasPublicoAlojamientosaccesibles();
			int rhsDeficienciasPublicoAlojamientosaccesibles;
			rhsDeficienciasPublicoAlojamientosaccesibles = that.getDeficienciasPublicoAlojamientosaccesibles();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "deficienciasPublicoAlojamientosaccesibles", lhsDeficienciasPublicoAlojamientosaccesibles), LocatorUtils.property(thatLocator, "deficienciasPublicoAlojamientosaccesibles", rhsDeficienciasPublicoAlojamientosaccesibles), lhsDeficienciasPublicoAlojamientosaccesibles, rhsDeficienciasPublicoAlojamientosaccesibles)) {
				return false;
			}
		}
		{
			int lhsDeficienciasPublicoAparcamiento;
			lhsDeficienciasPublicoAparcamiento = this.getDeficienciasPublicoAparcamiento();
			int rhsDeficienciasPublicoAparcamiento;
			rhsDeficienciasPublicoAparcamiento = that.getDeficienciasPublicoAparcamiento();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "deficienciasPublicoAparcamiento", lhsDeficienciasPublicoAparcamiento), LocatorUtils.property(thatLocator, "deficienciasPublicoAparcamiento", rhsDeficienciasPublicoAparcamiento), lhsDeficienciasPublicoAparcamiento, rhsDeficienciasPublicoAparcamiento)) {
				return false;
			}
		}
		{
			int lhsDeficienciasPublicoPlazasreservadas;
			lhsDeficienciasPublicoPlazasreservadas = this.getDeficienciasPublicoPlazasreservadas();
			int rhsDeficienciasPublicoPlazasreservadas;
			rhsDeficienciasPublicoPlazasreservadas = that.getDeficienciasPublicoPlazasreservadas();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "deficienciasPublicoPlazasreservadas", lhsDeficienciasPublicoPlazasreservadas), LocatorUtils.property(thatLocator, "deficienciasPublicoPlazasreservadas", rhsDeficienciasPublicoPlazasreservadas), lhsDeficienciasPublicoPlazasreservadas, rhsDeficienciasPublicoPlazasreservadas)) {
				return false;
			}
		}
		{
			int lhsDeficienciasPublicoPiscinas;
			lhsDeficienciasPublicoPiscinas = this.getDeficienciasPublicoPiscinas();
			int rhsDeficienciasPublicoPiscinas;
			rhsDeficienciasPublicoPiscinas = that.getDeficienciasPublicoPiscinas();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "deficienciasPublicoPiscinas", lhsDeficienciasPublicoPiscinas), LocatorUtils.property(thatLocator, "deficienciasPublicoPiscinas", rhsDeficienciasPublicoPiscinas), lhsDeficienciasPublicoPiscinas, rhsDeficienciasPublicoPiscinas)) {
				return false;
			}
		}
		{
			int lhsDeficienciasPublicoServicioshigienicos;
			lhsDeficienciasPublicoServicioshigienicos = this.getDeficienciasPublicoServicioshigienicos();
			int rhsDeficienciasPublicoServicioshigienicos;
			rhsDeficienciasPublicoServicioshigienicos = that.getDeficienciasPublicoServicioshigienicos();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "deficienciasPublicoServicioshigienicos", lhsDeficienciasPublicoServicioshigienicos), LocatorUtils.property(thatLocator, "deficienciasPublicoServicioshigienicos", rhsDeficienciasPublicoServicioshigienicos), lhsDeficienciasPublicoServicioshigienicos, rhsDeficienciasPublicoServicioshigienicos)) {
				return false;
			}
		}
		{
			int lhsDeficienciasPublicoMobiliariofijo;
			lhsDeficienciasPublicoMobiliariofijo = this.getDeficienciasPublicoMobiliariofijo();
			int rhsDeficienciasPublicoMobiliariofijo;
			rhsDeficienciasPublicoMobiliariofijo = that.getDeficienciasPublicoMobiliariofijo();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "deficienciasPublicoMobiliariofijo", lhsDeficienciasPublicoMobiliariofijo), LocatorUtils.property(thatLocator, "deficienciasPublicoMobiliariofijo", rhsDeficienciasPublicoMobiliariofijo), lhsDeficienciasPublicoMobiliariofijo, rhsDeficienciasPublicoMobiliariofijo)) {
				return false;
			}
		}
		{
			int lhsDeficienciasPublicoMecanismos;
			lhsDeficienciasPublicoMecanismos = this.getDeficienciasPublicoMecanismos();
			int rhsDeficienciasPublicoMecanismos;
			rhsDeficienciasPublicoMecanismos = that.getDeficienciasPublicoMecanismos();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "deficienciasPublicoMecanismos", lhsDeficienciasPublicoMecanismos), LocatorUtils.property(thatLocator, "deficienciasPublicoMecanismos", rhsDeficienciasPublicoMecanismos), lhsDeficienciasPublicoMecanismos, rhsDeficienciasPublicoMecanismos)) {
				return false;
			}
		}
		{
			int lhsDeficienciasPublicoInformacionsenalizacion;
			lhsDeficienciasPublicoInformacionsenalizacion = this.getDeficienciasPublicoInformacionsenalizacion();
			int rhsDeficienciasPublicoInformacionsenalizacion;
			rhsDeficienciasPublicoInformacionsenalizacion = that.getDeficienciasPublicoInformacionsenalizacion();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "deficienciasPublicoInformacionsenalizacion", lhsDeficienciasPublicoInformacionsenalizacion), LocatorUtils.property(thatLocator, "deficienciasPublicoInformacionsenalizacion", rhsDeficienciasPublicoInformacionsenalizacion), lhsDeficienciasPublicoInformacionsenalizacion, rhsDeficienciasPublicoInformacionsenalizacion)) {
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
			int theSatisfaceCondicionesBasicas;
			theSatisfaceCondicionesBasicas = this.getSatisfaceCondicionesBasicas();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "satisfaceCondicionesBasicas", theSatisfaceCondicionesBasicas), currentHashCode, theSatisfaceCondicionesBasicas);
		}
		{
			String theDeficienciasViviendaExterior;
			theDeficienciasViviendaExterior = this.getDeficienciasViviendaExterior();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "deficienciasViviendaExterior", theDeficienciasViviendaExterior), currentHashCode, theDeficienciasViviendaExterior);
		}
		{
			String theDeficienciasViviendaEntreplantas;
			theDeficienciasViviendaEntreplantas = this.getDeficienciasViviendaEntreplantas();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "deficienciasViviendaEntreplantas", theDeficienciasViviendaEntreplantas), currentHashCode, theDeficienciasViviendaEntreplantas);
		}
		{
			String theDeficienciasViviendaPlantas;
			theDeficienciasViviendaPlantas = this.getDeficienciasViviendaPlantas();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "deficienciasViviendaPlantas", theDeficienciasViviendaPlantas), currentHashCode, theDeficienciasViviendaPlantas);
		}
		{
			String theDeficienciasViviendaAparcamiento;
			theDeficienciasViviendaAparcamiento = this.getDeficienciasViviendaAparcamiento();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "deficienciasViviendaAparcamiento", theDeficienciasViviendaAparcamiento), currentHashCode, theDeficienciasViviendaAparcamiento);
		}
		{
			String theDeficienciasViviendaPiscinas;
			theDeficienciasViviendaPiscinas = this.getDeficienciasViviendaPiscinas();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "deficienciasViviendaPiscinas", theDeficienciasViviendaPiscinas), currentHashCode, theDeficienciasViviendaPiscinas);
		}
		{
			String theDeficienciasViviendaServicioshigienicos;
			theDeficienciasViviendaServicioshigienicos = this.getDeficienciasViviendaServicioshigienicos();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "deficienciasViviendaServicioshigienicos", theDeficienciasViviendaServicioshigienicos), currentHashCode, theDeficienciasViviendaServicioshigienicos);
		}
		{
			String theDeficienciasViviendaMecanismos;
			theDeficienciasViviendaMecanismos = this.getDeficienciasViviendaMecanismos();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "deficienciasViviendaMecanismos", theDeficienciasViviendaMecanismos), currentHashCode, theDeficienciasViviendaMecanismos);
		}
		{
			String theDeficienciasViviendaInformacionsenalizacion;
			theDeficienciasViviendaInformacionsenalizacion = this.getDeficienciasViviendaInformacionsenalizacion();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "deficienciasViviendaInformacionsenalizacion", theDeficienciasViviendaInformacionsenalizacion), currentHashCode, theDeficienciasViviendaInformacionsenalizacion);
		}
		{
			int theDeficienciasPublicoExterior;
			theDeficienciasPublicoExterior = this.getDeficienciasPublicoExterior();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "deficienciasPublicoExterior", theDeficienciasPublicoExterior), currentHashCode, theDeficienciasPublicoExterior);
		}
		{
			int theDeficienciasPublicoEntreplantas;
			theDeficienciasPublicoEntreplantas = this.getDeficienciasPublicoEntreplantas();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "deficienciasPublicoEntreplantas", theDeficienciasPublicoEntreplantas), currentHashCode, theDeficienciasPublicoEntreplantas);
		}
		{
			int theDeficienciasPublicoPlantas;
			theDeficienciasPublicoPlantas = this.getDeficienciasPublicoPlantas();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "deficienciasPublicoPlantas", theDeficienciasPublicoPlantas), currentHashCode, theDeficienciasPublicoPlantas);
		}
		{
			int theDeficienciasPublicoAlojamientosaccesibles;
			theDeficienciasPublicoAlojamientosaccesibles = this.getDeficienciasPublicoAlojamientosaccesibles();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "deficienciasPublicoAlojamientosaccesibles", theDeficienciasPublicoAlojamientosaccesibles), currentHashCode, theDeficienciasPublicoAlojamientosaccesibles);
		}
		{
			int theDeficienciasPublicoAparcamiento;
			theDeficienciasPublicoAparcamiento = this.getDeficienciasPublicoAparcamiento();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "deficienciasPublicoAparcamiento", theDeficienciasPublicoAparcamiento), currentHashCode, theDeficienciasPublicoAparcamiento);
		}
		{
			int theDeficienciasPublicoPlazasreservadas;
			theDeficienciasPublicoPlazasreservadas = this.getDeficienciasPublicoPlazasreservadas();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "deficienciasPublicoPlazasreservadas", theDeficienciasPublicoPlazasreservadas), currentHashCode, theDeficienciasPublicoPlazasreservadas);
		}
		{
			int theDeficienciasPublicoPiscinas;
			theDeficienciasPublicoPiscinas = this.getDeficienciasPublicoPiscinas();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "deficienciasPublicoPiscinas", theDeficienciasPublicoPiscinas), currentHashCode, theDeficienciasPublicoPiscinas);
		}
		{
			int theDeficienciasPublicoServicioshigienicos;
			theDeficienciasPublicoServicioshigienicos = this.getDeficienciasPublicoServicioshigienicos();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "deficienciasPublicoServicioshigienicos", theDeficienciasPublicoServicioshigienicos), currentHashCode, theDeficienciasPublicoServicioshigienicos);
		}
		{
			int theDeficienciasPublicoMobiliariofijo;
			theDeficienciasPublicoMobiliariofijo = this.getDeficienciasPublicoMobiliariofijo();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "deficienciasPublicoMobiliariofijo", theDeficienciasPublicoMobiliariofijo), currentHashCode, theDeficienciasPublicoMobiliariofijo);
		}
		{
			int theDeficienciasPublicoMecanismos;
			theDeficienciasPublicoMecanismos = this.getDeficienciasPublicoMecanismos();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "deficienciasPublicoMecanismos", theDeficienciasPublicoMecanismos), currentHashCode, theDeficienciasPublicoMecanismos);
		}
		{
			int theDeficienciasPublicoInformacionsenalizacion;
			theDeficienciasPublicoInformacionsenalizacion = this.getDeficienciasPublicoInformacionsenalizacion();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "deficienciasPublicoInformacionsenalizacion", theDeficienciasPublicoInformacionsenalizacion), currentHashCode, theDeficienciasPublicoInformacionsenalizacion);
		}
		return currentHashCode;
	}

	public int hashCode() {
		final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
		return this.hashCode(null, strategy);
	}

}
