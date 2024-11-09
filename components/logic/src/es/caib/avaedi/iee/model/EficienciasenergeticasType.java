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
 * Clase Java para eficienciasenergeticasType complex type.
 * 
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que
 * haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="eficienciasenergeticasType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="indicador_global_emisiones" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="indicador_global_calificacion_tipo_id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="indicador_parcial_emisiones_calefaccion" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="indicador_parcial_emisiones_acs" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="indicador_parcial_emisiones_refrigeracion" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="demanda_global_calefaccion" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="demanda_global_calefaccion_calificacion_tipo_id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="demanda_global_refrigeracion" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="demanda_global_refrigeracion_calificacion_tipo_id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="indicador_global_primaria_consumo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="indicador_global_primaria_calificacion_tipo_id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="indicador_parcial_primaria_calefaccion" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="indicador_parcial_primaria_acs" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="indicador_parcial_primaria_refrigeracion" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="es_tecnico_inspeccion" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="tecnico" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="nif" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="titulacion" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="observaciones" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="ambito_aplicacion" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "eficienciasenergeticasType", propOrder = { "indicadorGlobalEmisiones", "indicadorGlobalCalificacionTipoId", "indicadorParcialEmisionesCalefaccion", "indicadorParcialEmisionesAcs", "indicadorParcialEmisionesRefrigeracion", "demandaGlobalCalefaccion", "demandaGlobalCalefaccionCalificacionTipoId", "demandaGlobalRefrigeracion", "demandaGlobalRefrigeracionCalificacionTipoId", "indicadorGlobalPrimariaConsumo", "indicadorGlobalPrimariaCalificacionTipoId", "indicadorParcialPrimariaCalefaccion", "indicadorParcialPrimariaAcs", "indicadorParcialPrimariaRefrigeracion", "esTecnicoInspeccion", "tecnico", "nif", "titulacion", "observaciones", "ambitoAplicacion" })
@Entity(name = "EficienciasenergeticasType")
@Table(name = "AED_EFICIENCIASENERGETICAS")
@Inheritance(strategy = InheritanceType.JOINED)
public class EficienciasenergeticasType implements Serializable, Equals, HashCode {

	@XmlElement(name = "indicador_global_emisiones", required = true)
	protected String indicadorGlobalEmisiones;
	@XmlElement(name = "indicador_global_calificacion_tipo_id")
	protected int indicadorGlobalCalificacionTipoId;
	@XmlElement(name = "indicador_parcial_emisiones_calefaccion", required = true)
	protected String indicadorParcialEmisionesCalefaccion;
	@XmlElement(name = "indicador_parcial_emisiones_acs", required = true)
	protected String indicadorParcialEmisionesAcs;
	@XmlElement(name = "indicador_parcial_emisiones_refrigeracion", required = true)
	protected String indicadorParcialEmisionesRefrigeracion;
	@XmlElement(name = "demanda_global_calefaccion", required = true)
	protected String demandaGlobalCalefaccion;
	@XmlElement(name = "demanda_global_calefaccion_calificacion_tipo_id")
	protected int demandaGlobalCalefaccionCalificacionTipoId;
	@XmlElement(name = "demanda_global_refrigeracion", required = true)
	protected String demandaGlobalRefrigeracion;
	@XmlElement(name = "demanda_global_refrigeracion_calificacion_tipo_id")
	protected int demandaGlobalRefrigeracionCalificacionTipoId;
	@XmlElement(name = "indicador_global_primaria_consumo", required = true)
	protected String indicadorGlobalPrimariaConsumo;
	@XmlElement(name = "indicador_global_primaria_calificacion_tipo_id")
	protected int indicadorGlobalPrimariaCalificacionTipoId;
	@XmlElement(name = "indicador_parcial_primaria_calefaccion", required = true)
	protected String indicadorParcialPrimariaCalefaccion;
	@XmlElement(name = "indicador_parcial_primaria_acs", required = true)
	protected String indicadorParcialPrimariaAcs;
	@XmlElement(name = "indicador_parcial_primaria_refrigeracion", required = true)
	protected String indicadorParcialPrimariaRefrigeracion;
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
	@XmlElement(name = "ambito_aplicacion")
	protected int ambitoAplicacion;
	@XmlAttribute(name = "Hjid")
	protected Long hjid;

	/**
	 * Obtiene el valor de la propiedad indicadorGlobalEmisiones.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "INDICADOR_GLOBAL_EMISIONES", length = 255)
	public String getIndicadorGlobalEmisiones() {
		return indicadorGlobalEmisiones;
	}

	/**
	 * Define el valor de la propiedad indicadorGlobalEmisiones.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setIndicadorGlobalEmisiones(String value) {
		this.indicadorGlobalEmisiones = value;
	}

	/**
	 * Obtiene el valor de la propiedad indicadorGlobalCalificacionTipoId.
	 * 
	 */
	@Basic
	@Column(name = "INDICADOR_GLOBAL_CALIFICACION_TIPO_ID", precision = 10, scale = 0)
	public int getIndicadorGlobalCalificacionTipoId() {
		return indicadorGlobalCalificacionTipoId;
	}

	/**
	 * Define el valor de la propiedad indicadorGlobalCalificacionTipoId.
	 * 
	 */
	public void setIndicadorGlobalCalificacionTipoId(int value) {
		this.indicadorGlobalCalificacionTipoId = value;
	}

	/**
	 * Obtiene el valor de la propiedad indicadorParcialEmisionesCalefaccion.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "INDICADOR_PARCIAL_EMISIONES_CALEFACCION", length = 255)
	public String getIndicadorParcialEmisionesCalefaccion() {
		return indicadorParcialEmisionesCalefaccion;
	}

	/**
	 * Define el valor de la propiedad indicadorParcialEmisionesCalefaccion.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setIndicadorParcialEmisionesCalefaccion(String value) {
		this.indicadorParcialEmisionesCalefaccion = value;
	}

	/**
	 * Obtiene el valor de la propiedad indicadorParcialEmisionesAcs.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "INDICADOR_PARCIAL_EMISIONES_ACS", length = 255)
	public String getIndicadorParcialEmisionesAcs() {
		return indicadorParcialEmisionesAcs;
	}

	/**
	 * Define el valor de la propiedad indicadorParcialEmisionesAcs.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setIndicadorParcialEmisionesAcs(String value) {
		this.indicadorParcialEmisionesAcs = value;
	}

	/**
	 * Obtiene el valor de la propiedad indicadorParcialEmisionesRefrigeracion.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "INDICADOR_PARCIAL_EMISIONES_REFRIGERACION", length = 255)
	public String getIndicadorParcialEmisionesRefrigeracion() {
		return indicadorParcialEmisionesRefrigeracion;
	}

	/**
	 * Define el valor de la propiedad indicadorParcialEmisionesRefrigeracion.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setIndicadorParcialEmisionesRefrigeracion(String value) {
		this.indicadorParcialEmisionesRefrigeracion = value;
	}

	/**
	 * Obtiene el valor de la propiedad demandaGlobalCalefaccion.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "DEMANDA_GLOBAL_CALEFACCION", length = 255)
	public String getDemandaGlobalCalefaccion() {
		return demandaGlobalCalefaccion;
	}

	/**
	 * Define el valor de la propiedad demandaGlobalCalefaccion.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDemandaGlobalCalefaccion(String value) {
		this.demandaGlobalCalefaccion = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * demandaGlobalCalefaccionCalificacionTipoId.
	 * 
	 */
	@Basic
	@Column(name = "DEMANDA_GLOBAL_CALEFACCION_CALIFICACION_TIPO_ID", precision = 10, scale = 0)
	public int getDemandaGlobalCalefaccionCalificacionTipoId() {
		return demandaGlobalCalefaccionCalificacionTipoId;
	}

	/**
	 * Define el valor de la propiedad
	 * demandaGlobalCalefaccionCalificacionTipoId.
	 * 
	 */
	public void setDemandaGlobalCalefaccionCalificacionTipoId(int value) {
		this.demandaGlobalCalefaccionCalificacionTipoId = value;
	}

	/**
	 * Obtiene el valor de la propiedad demandaGlobalRefrigeracion.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "DEMANDA_GLOBAL_REFRIGERACION", length = 255)
	public String getDemandaGlobalRefrigeracion() {
		return demandaGlobalRefrigeracion;
	}

	/**
	 * Define el valor de la propiedad demandaGlobalRefrigeracion.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDemandaGlobalRefrigeracion(String value) {
		this.demandaGlobalRefrigeracion = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * demandaGlobalRefrigeracionCalificacionTipoId.
	 * 
	 */
	@Basic
	@Column(name = "DEMANDA_GLOBAL_REFRIGERACION_CALIFICACION_TIPO_ID", precision = 10, scale = 0)
	public int getDemandaGlobalRefrigeracionCalificacionTipoId() {
		return demandaGlobalRefrigeracionCalificacionTipoId;
	}

	/**
	 * Define el valor de la propiedad
	 * demandaGlobalRefrigeracionCalificacionTipoId.
	 * 
	 */
	public void setDemandaGlobalRefrigeracionCalificacionTipoId(int value) {
		this.demandaGlobalRefrigeracionCalificacionTipoId = value;
	}

	/**
	 * Obtiene el valor de la propiedad indicadorGlobalPrimariaConsumo.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "INDICADOR_GLOBAL_PRIMARIA_CONSUMO", length = 255)
	public String getIndicadorGlobalPrimariaConsumo() {
		return indicadorGlobalPrimariaConsumo;
	}

	/**
	 * Define el valor de la propiedad indicadorGlobalPrimariaConsumo.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setIndicadorGlobalPrimariaConsumo(String value) {
		this.indicadorGlobalPrimariaConsumo = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * indicadorGlobalPrimariaCalificacionTipoId.
	 * 
	 */
	@Basic
	@Column(name = "INDICADOR_GLOBAL_PRIMARIA_CALIFICACION_TIPO_ID", precision = 10, scale = 0)
	public int getIndicadorGlobalPrimariaCalificacionTipoId() {
		return indicadorGlobalPrimariaCalificacionTipoId;
	}

	/**
	 * Define el valor de la propiedad
	 * indicadorGlobalPrimariaCalificacionTipoId.
	 * 
	 */
	public void setIndicadorGlobalPrimariaCalificacionTipoId(int value) {
		this.indicadorGlobalPrimariaCalificacionTipoId = value;
	}

	/**
	 * Obtiene el valor de la propiedad indicadorParcialPrimariaCalefaccion.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "INDICADOR_PARCIAL_PRIMARIA_CALEFACCION", length = 255)
	public String getIndicadorParcialPrimariaCalefaccion() {
		return indicadorParcialPrimariaCalefaccion;
	}

	/**
	 * Define el valor de la propiedad indicadorParcialPrimariaCalefaccion.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setIndicadorParcialPrimariaCalefaccion(String value) {
		this.indicadorParcialPrimariaCalefaccion = value;
	}

	/**
	 * Obtiene el valor de la propiedad indicadorParcialPrimariaAcs.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "INDICADOR_PARCIAL_PRIMARIA_ACS", length = 255)
	public String getIndicadorParcialPrimariaAcs() {
		return indicadorParcialPrimariaAcs;
	}

	/**
	 * Define el valor de la propiedad indicadorParcialPrimariaAcs.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setIndicadorParcialPrimariaAcs(String value) {
		this.indicadorParcialPrimariaAcs = value;
	}

	/**
	 * Obtiene el valor de la propiedad indicadorParcialPrimariaRefrigeracion.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "INDICADOR_PARCIAL_PRIMARIA_REFRIGERACION", length = 255)
	public String getIndicadorParcialPrimariaRefrigeracion() {
		return indicadorParcialPrimariaRefrigeracion;
	}

	/**
	 * Define el valor de la propiedad indicadorParcialPrimariaRefrigeracion.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setIndicadorParcialPrimariaRefrigeracion(String value) {
		this.indicadorParcialPrimariaRefrigeracion = value;
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
	 * Obtiene el valor de la propiedad ambitoAplicacion.
	 * 
	 */
	@Basic
	@Column(name = "AMBITO_APLICACION", precision = 10, scale = 0)
	public int getAmbitoAplicacion() {
		return ambitoAplicacion;
	}

	/**
	 * Define el valor de la propiedad ambitoAplicacion.
	 * 
	 */
	public void setAmbitoAplicacion(int value) {
		this.ambitoAplicacion = value;
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
		final EficienciasenergeticasType that = ((EficienciasenergeticasType) object);
		{
			String lhsIndicadorGlobalEmisiones;
			lhsIndicadorGlobalEmisiones = this.getIndicadorGlobalEmisiones();
			String rhsIndicadorGlobalEmisiones;
			rhsIndicadorGlobalEmisiones = that.getIndicadorGlobalEmisiones();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "indicadorGlobalEmisiones", lhsIndicadorGlobalEmisiones), LocatorUtils.property(thatLocator, "indicadorGlobalEmisiones", rhsIndicadorGlobalEmisiones), lhsIndicadorGlobalEmisiones, rhsIndicadorGlobalEmisiones)) {
				return false;
			}
		}
		{
			int lhsIndicadorGlobalCalificacionTipoId;
			lhsIndicadorGlobalCalificacionTipoId = this.getIndicadorGlobalCalificacionTipoId();
			int rhsIndicadorGlobalCalificacionTipoId;
			rhsIndicadorGlobalCalificacionTipoId = that.getIndicadorGlobalCalificacionTipoId();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "indicadorGlobalCalificacionTipoId", lhsIndicadorGlobalCalificacionTipoId), LocatorUtils.property(thatLocator, "indicadorGlobalCalificacionTipoId", rhsIndicadorGlobalCalificacionTipoId), lhsIndicadorGlobalCalificacionTipoId, rhsIndicadorGlobalCalificacionTipoId)) {
				return false;
			}
		}
		{
			String lhsIndicadorParcialEmisionesCalefaccion;
			lhsIndicadorParcialEmisionesCalefaccion = this.getIndicadorParcialEmisionesCalefaccion();
			String rhsIndicadorParcialEmisionesCalefaccion;
			rhsIndicadorParcialEmisionesCalefaccion = that.getIndicadorParcialEmisionesCalefaccion();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "indicadorParcialEmisionesCalefaccion", lhsIndicadorParcialEmisionesCalefaccion), LocatorUtils.property(thatLocator, "indicadorParcialEmisionesCalefaccion", rhsIndicadorParcialEmisionesCalefaccion), lhsIndicadorParcialEmisionesCalefaccion, rhsIndicadorParcialEmisionesCalefaccion)) {
				return false;
			}
		}
		{
			String lhsIndicadorParcialEmisionesAcs;
			lhsIndicadorParcialEmisionesAcs = this.getIndicadorParcialEmisionesAcs();
			String rhsIndicadorParcialEmisionesAcs;
			rhsIndicadorParcialEmisionesAcs = that.getIndicadorParcialEmisionesAcs();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "indicadorParcialEmisionesAcs", lhsIndicadorParcialEmisionesAcs), LocatorUtils.property(thatLocator, "indicadorParcialEmisionesAcs", rhsIndicadorParcialEmisionesAcs), lhsIndicadorParcialEmisionesAcs, rhsIndicadorParcialEmisionesAcs)) {
				return false;
			}
		}
		{
			String lhsIndicadorParcialEmisionesRefrigeracion;
			lhsIndicadorParcialEmisionesRefrigeracion = this.getIndicadorParcialEmisionesRefrigeracion();
			String rhsIndicadorParcialEmisionesRefrigeracion;
			rhsIndicadorParcialEmisionesRefrigeracion = that.getIndicadorParcialEmisionesRefrigeracion();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "indicadorParcialEmisionesRefrigeracion", lhsIndicadorParcialEmisionesRefrigeracion), LocatorUtils.property(thatLocator, "indicadorParcialEmisionesRefrigeracion", rhsIndicadorParcialEmisionesRefrigeracion), lhsIndicadorParcialEmisionesRefrigeracion, rhsIndicadorParcialEmisionesRefrigeracion)) {
				return false;
			}
		}
		{
			String lhsDemandaGlobalCalefaccion;
			lhsDemandaGlobalCalefaccion = this.getDemandaGlobalCalefaccion();
			String rhsDemandaGlobalCalefaccion;
			rhsDemandaGlobalCalefaccion = that.getDemandaGlobalCalefaccion();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "demandaGlobalCalefaccion", lhsDemandaGlobalCalefaccion), LocatorUtils.property(thatLocator, "demandaGlobalCalefaccion", rhsDemandaGlobalCalefaccion), lhsDemandaGlobalCalefaccion, rhsDemandaGlobalCalefaccion)) {
				return false;
			}
		}
		{
			int lhsDemandaGlobalCalefaccionCalificacionTipoId;
			lhsDemandaGlobalCalefaccionCalificacionTipoId = this.getDemandaGlobalCalefaccionCalificacionTipoId();
			int rhsDemandaGlobalCalefaccionCalificacionTipoId;
			rhsDemandaGlobalCalefaccionCalificacionTipoId = that.getDemandaGlobalCalefaccionCalificacionTipoId();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "demandaGlobalCalefaccionCalificacionTipoId", lhsDemandaGlobalCalefaccionCalificacionTipoId), LocatorUtils.property(thatLocator, "demandaGlobalCalefaccionCalificacionTipoId", rhsDemandaGlobalCalefaccionCalificacionTipoId), lhsDemandaGlobalCalefaccionCalificacionTipoId, rhsDemandaGlobalCalefaccionCalificacionTipoId)) {
				return false;
			}
		}
		{
			String lhsDemandaGlobalRefrigeracion;
			lhsDemandaGlobalRefrigeracion = this.getDemandaGlobalRefrigeracion();
			String rhsDemandaGlobalRefrigeracion;
			rhsDemandaGlobalRefrigeracion = that.getDemandaGlobalRefrigeracion();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "demandaGlobalRefrigeracion", lhsDemandaGlobalRefrigeracion), LocatorUtils.property(thatLocator, "demandaGlobalRefrigeracion", rhsDemandaGlobalRefrigeracion), lhsDemandaGlobalRefrigeracion, rhsDemandaGlobalRefrigeracion)) {
				return false;
			}
		}
		{
			int lhsDemandaGlobalRefrigeracionCalificacionTipoId;
			lhsDemandaGlobalRefrigeracionCalificacionTipoId = this.getDemandaGlobalRefrigeracionCalificacionTipoId();
			int rhsDemandaGlobalRefrigeracionCalificacionTipoId;
			rhsDemandaGlobalRefrigeracionCalificacionTipoId = that.getDemandaGlobalRefrigeracionCalificacionTipoId();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "demandaGlobalRefrigeracionCalificacionTipoId", lhsDemandaGlobalRefrigeracionCalificacionTipoId), LocatorUtils.property(thatLocator, "demandaGlobalRefrigeracionCalificacionTipoId", rhsDemandaGlobalRefrigeracionCalificacionTipoId), lhsDemandaGlobalRefrigeracionCalificacionTipoId, rhsDemandaGlobalRefrigeracionCalificacionTipoId)) {
				return false;
			}
		}
		{
			String lhsIndicadorGlobalPrimariaConsumo;
			lhsIndicadorGlobalPrimariaConsumo = this.getIndicadorGlobalPrimariaConsumo();
			String rhsIndicadorGlobalPrimariaConsumo;
			rhsIndicadorGlobalPrimariaConsumo = that.getIndicadorGlobalPrimariaConsumo();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "indicadorGlobalPrimariaConsumo", lhsIndicadorGlobalPrimariaConsumo), LocatorUtils.property(thatLocator, "indicadorGlobalPrimariaConsumo", rhsIndicadorGlobalPrimariaConsumo), lhsIndicadorGlobalPrimariaConsumo, rhsIndicadorGlobalPrimariaConsumo)) {
				return false;
			}
		}
		{
			int lhsIndicadorGlobalPrimariaCalificacionTipoId;
			lhsIndicadorGlobalPrimariaCalificacionTipoId = this.getIndicadorGlobalPrimariaCalificacionTipoId();
			int rhsIndicadorGlobalPrimariaCalificacionTipoId;
			rhsIndicadorGlobalPrimariaCalificacionTipoId = that.getIndicadorGlobalPrimariaCalificacionTipoId();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "indicadorGlobalPrimariaCalificacionTipoId", lhsIndicadorGlobalPrimariaCalificacionTipoId), LocatorUtils.property(thatLocator, "indicadorGlobalPrimariaCalificacionTipoId", rhsIndicadorGlobalPrimariaCalificacionTipoId), lhsIndicadorGlobalPrimariaCalificacionTipoId, rhsIndicadorGlobalPrimariaCalificacionTipoId)) {
				return false;
			}
		}
		{
			String lhsIndicadorParcialPrimariaCalefaccion;
			lhsIndicadorParcialPrimariaCalefaccion = this.getIndicadorParcialPrimariaCalefaccion();
			String rhsIndicadorParcialPrimariaCalefaccion;
			rhsIndicadorParcialPrimariaCalefaccion = that.getIndicadorParcialPrimariaCalefaccion();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "indicadorParcialPrimariaCalefaccion", lhsIndicadorParcialPrimariaCalefaccion), LocatorUtils.property(thatLocator, "indicadorParcialPrimariaCalefaccion", rhsIndicadorParcialPrimariaCalefaccion), lhsIndicadorParcialPrimariaCalefaccion, rhsIndicadorParcialPrimariaCalefaccion)) {
				return false;
			}
		}
		{
			String lhsIndicadorParcialPrimariaAcs;
			lhsIndicadorParcialPrimariaAcs = this.getIndicadorParcialPrimariaAcs();
			String rhsIndicadorParcialPrimariaAcs;
			rhsIndicadorParcialPrimariaAcs = that.getIndicadorParcialPrimariaAcs();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "indicadorParcialPrimariaAcs", lhsIndicadorParcialPrimariaAcs), LocatorUtils.property(thatLocator, "indicadorParcialPrimariaAcs", rhsIndicadorParcialPrimariaAcs), lhsIndicadorParcialPrimariaAcs, rhsIndicadorParcialPrimariaAcs)) {
				return false;
			}
		}
		{
			String lhsIndicadorParcialPrimariaRefrigeracion;
			lhsIndicadorParcialPrimariaRefrigeracion = this.getIndicadorParcialPrimariaRefrigeracion();
			String rhsIndicadorParcialPrimariaRefrigeracion;
			rhsIndicadorParcialPrimariaRefrigeracion = that.getIndicadorParcialPrimariaRefrigeracion();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "indicadorParcialPrimariaRefrigeracion", lhsIndicadorParcialPrimariaRefrigeracion), LocatorUtils.property(thatLocator, "indicadorParcialPrimariaRefrigeracion", rhsIndicadorParcialPrimariaRefrigeracion), lhsIndicadorParcialPrimariaRefrigeracion, rhsIndicadorParcialPrimariaRefrigeracion)) {
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
		{
			int lhsAmbitoAplicacion;
			lhsAmbitoAplicacion = this.getAmbitoAplicacion();
			int rhsAmbitoAplicacion;
			rhsAmbitoAplicacion = that.getAmbitoAplicacion();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "ambitoAplicacion", lhsAmbitoAplicacion), LocatorUtils.property(thatLocator, "ambitoAplicacion", rhsAmbitoAplicacion), lhsAmbitoAplicacion, rhsAmbitoAplicacion)) {
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
			String theIndicadorGlobalEmisiones;
			theIndicadorGlobalEmisiones = this.getIndicadorGlobalEmisiones();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "indicadorGlobalEmisiones", theIndicadorGlobalEmisiones), currentHashCode, theIndicadorGlobalEmisiones);
		}
		{
			int theIndicadorGlobalCalificacionTipoId;
			theIndicadorGlobalCalificacionTipoId = this.getIndicadorGlobalCalificacionTipoId();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "indicadorGlobalCalificacionTipoId", theIndicadorGlobalCalificacionTipoId), currentHashCode, theIndicadorGlobalCalificacionTipoId);
		}
		{
			String theIndicadorParcialEmisionesCalefaccion;
			theIndicadorParcialEmisionesCalefaccion = this.getIndicadorParcialEmisionesCalefaccion();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "indicadorParcialEmisionesCalefaccion", theIndicadorParcialEmisionesCalefaccion), currentHashCode, theIndicadorParcialEmisionesCalefaccion);
		}
		{
			String theIndicadorParcialEmisionesAcs;
			theIndicadorParcialEmisionesAcs = this.getIndicadorParcialEmisionesAcs();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "indicadorParcialEmisionesAcs", theIndicadorParcialEmisionesAcs), currentHashCode, theIndicadorParcialEmisionesAcs);
		}
		{
			String theIndicadorParcialEmisionesRefrigeracion;
			theIndicadorParcialEmisionesRefrigeracion = this.getIndicadorParcialEmisionesRefrigeracion();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "indicadorParcialEmisionesRefrigeracion", theIndicadorParcialEmisionesRefrigeracion), currentHashCode, theIndicadorParcialEmisionesRefrigeracion);
		}
		{
			String theDemandaGlobalCalefaccion;
			theDemandaGlobalCalefaccion = this.getDemandaGlobalCalefaccion();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "demandaGlobalCalefaccion", theDemandaGlobalCalefaccion), currentHashCode, theDemandaGlobalCalefaccion);
		}
		{
			int theDemandaGlobalCalefaccionCalificacionTipoId;
			theDemandaGlobalCalefaccionCalificacionTipoId = this.getDemandaGlobalCalefaccionCalificacionTipoId();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "demandaGlobalCalefaccionCalificacionTipoId", theDemandaGlobalCalefaccionCalificacionTipoId), currentHashCode, theDemandaGlobalCalefaccionCalificacionTipoId);
		}
		{
			String theDemandaGlobalRefrigeracion;
			theDemandaGlobalRefrigeracion = this.getDemandaGlobalRefrigeracion();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "demandaGlobalRefrigeracion", theDemandaGlobalRefrigeracion), currentHashCode, theDemandaGlobalRefrigeracion);
		}
		{
			int theDemandaGlobalRefrigeracionCalificacionTipoId;
			theDemandaGlobalRefrigeracionCalificacionTipoId = this.getDemandaGlobalRefrigeracionCalificacionTipoId();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "demandaGlobalRefrigeracionCalificacionTipoId", theDemandaGlobalRefrigeracionCalificacionTipoId), currentHashCode, theDemandaGlobalRefrigeracionCalificacionTipoId);
		}
		{
			String theIndicadorGlobalPrimariaConsumo;
			theIndicadorGlobalPrimariaConsumo = this.getIndicadorGlobalPrimariaConsumo();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "indicadorGlobalPrimariaConsumo", theIndicadorGlobalPrimariaConsumo), currentHashCode, theIndicadorGlobalPrimariaConsumo);
		}
		{
			int theIndicadorGlobalPrimariaCalificacionTipoId;
			theIndicadorGlobalPrimariaCalificacionTipoId = this.getIndicadorGlobalPrimariaCalificacionTipoId();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "indicadorGlobalPrimariaCalificacionTipoId", theIndicadorGlobalPrimariaCalificacionTipoId), currentHashCode, theIndicadorGlobalPrimariaCalificacionTipoId);
		}
		{
			String theIndicadorParcialPrimariaCalefaccion;
			theIndicadorParcialPrimariaCalefaccion = this.getIndicadorParcialPrimariaCalefaccion();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "indicadorParcialPrimariaCalefaccion", theIndicadorParcialPrimariaCalefaccion), currentHashCode, theIndicadorParcialPrimariaCalefaccion);
		}
		{
			String theIndicadorParcialPrimariaAcs;
			theIndicadorParcialPrimariaAcs = this.getIndicadorParcialPrimariaAcs();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "indicadorParcialPrimariaAcs", theIndicadorParcialPrimariaAcs), currentHashCode, theIndicadorParcialPrimariaAcs);
		}
		{
			String theIndicadorParcialPrimariaRefrigeracion;
			theIndicadorParcialPrimariaRefrigeracion = this.getIndicadorParcialPrimariaRefrigeracion();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "indicadorParcialPrimariaRefrigeracion", theIndicadorParcialPrimariaRefrigeracion), currentHashCode, theIndicadorParcialPrimariaRefrigeracion);
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
		{
			int theAmbitoAplicacion;
			theAmbitoAplicacion = this.getAmbitoAplicacion();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "ambitoAplicacion", theAmbitoAplicacion), currentHashCode, theAmbitoAplicacion);
		}
		return currentHashCode;
	}

	public int hashCode() {
		final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
		return this.hashCode(null, strategy);
	}

}
