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
 * Clase Java para acustica_datosgeneralesType complex type.
 * 
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que
 * haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="acustica_datosgeneralesType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="tipo_area_acustica" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="indice_ruido_dia" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="objetivo_calidad_acustica" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="estudio_especifico" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="zona_ruido_aeronaves" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="fachadas_no_expuestas_ruido" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="recintos_protegidos_recintos_protegidos" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="recintos_protegidos_recintos_habitables" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="recintos_protegidos_recintos_instalaciones" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="recintos_protegidos_ascensor" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="recintos_protegidos_zona_comun" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="existen_recintos_instalaciones" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="recintos_instalaciones_recintos_habitables" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="recintos_instalaciones_zonas_comunes" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
@XmlType(name = "acustica_datosgeneralesType", propOrder = { "tipoAreaAcustica", "indiceRuidoDia", "objetivoCalidadAcustica", "estudioEspecifico", "zonaRuidoAeronaves", "fachadasNoExpuestasRuido", "recintosProtegidosRecintosProtegidos", "recintosProtegidosRecintosHabitables", "recintosProtegidosRecintosInstalaciones", "recintosProtegidosAscensor", "recintosProtegidosZonaComun", "existenRecintosInstalaciones", "recintosInstalacionesRecintosHabitables", "recintosInstalacionesZonasComunes", "observaciones" })
@Entity(name = "AcusticaDatosgeneralesType")
@Table(name = "AED_ACU_DATGEN")
@Inheritance(strategy = InheritanceType.JOINED)
public class AcusticaDatosgeneralesType implements Serializable, Equals, HashCode {

	@XmlElement(name = "tipo_area_acustica", required = true)
	protected String tipoAreaAcustica;
	@XmlElement(name = "indice_ruido_dia")
	protected int indiceRuidoDia;
	@XmlElement(name = "objetivo_calidad_acustica")
	protected int objetivoCalidadAcustica;
	@XmlElement(name = "estudio_especifico")
	protected int estudioEspecifico;
	@XmlElement(name = "zona_ruido_aeronaves")
	protected int zonaRuidoAeronaves;
	@XmlElement(name = "fachadas_no_expuestas_ruido")
	protected int fachadasNoExpuestasRuido;
	@XmlElement(name = "recintos_protegidos_recintos_protegidos")
	protected int recintosProtegidosRecintosProtegidos;
	@XmlElement(name = "recintos_protegidos_recintos_habitables")
	protected int recintosProtegidosRecintosHabitables;
	@XmlElement(name = "recintos_protegidos_recintos_instalaciones")
	protected int recintosProtegidosRecintosInstalaciones;
	@XmlElement(name = "recintos_protegidos_ascensor")
	protected int recintosProtegidosAscensor;
	@XmlElement(name = "recintos_protegidos_zona_comun")
	protected int recintosProtegidosZonaComun;
	@XmlElement(name = "existen_recintos_instalaciones", required = true)
	protected String existenRecintosInstalaciones;
	@XmlElement(name = "recintos_instalaciones_recintos_habitables", required = true)
	protected String recintosInstalacionesRecintosHabitables;
	@XmlElement(name = "recintos_instalaciones_zonas_comunes", required = true)
	protected String recintosInstalacionesZonasComunes;
	@XmlElement(required = true)
	protected String observaciones;
	@XmlAttribute(name = "Hjid")
	protected Long hjid;

	/**
	 * Obtiene el valor de la propiedad tipoAreaAcustica.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "TIPO_AREA_ACUSTICA", length = 255)
	public String getTipoAreaAcustica() {
		return tipoAreaAcustica;
	}

	/**
	 * Define el valor de la propiedad tipoAreaAcustica.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTipoAreaAcustica(String value) {
		this.tipoAreaAcustica = value;
	}

	/**
	 * Obtiene el valor de la propiedad indiceRuidoDia.
	 * 
	 */
	@Basic
	@Column(name = "INDICE_RUIDO_DIA", precision = 10, scale = 0)
	public int getIndiceRuidoDia() {
		return indiceRuidoDia;
	}

	/**
	 * Define el valor de la propiedad indiceRuidoDia.
	 * 
	 */
	public void setIndiceRuidoDia(int value) {
		this.indiceRuidoDia = value;
	}

	/**
	 * Obtiene el valor de la propiedad objetivoCalidadAcustica.
	 * 
	 */
	@Basic
	@Column(name = "OBJETIVO_CALIDAD_ACUSTICA", precision = 10, scale = 0)
	public int getObjetivoCalidadAcustica() {
		return objetivoCalidadAcustica;
	}

	/**
	 * Define el valor de la propiedad objetivoCalidadAcustica.
	 * 
	 */
	public void setObjetivoCalidadAcustica(int value) {
		this.objetivoCalidadAcustica = value;
	}

	/**
	 * Obtiene el valor de la propiedad estudioEspecifico.
	 * 
	 */
	@Basic
	@Column(name = "ESTUDIO_ESPECIFICO", precision = 10, scale = 0)
	public int getEstudioEspecifico() {
		return estudioEspecifico;
	}

	/**
	 * Define el valor de la propiedad estudioEspecifico.
	 * 
	 */
	public void setEstudioEspecifico(int value) {
		this.estudioEspecifico = value;
	}

	/**
	 * Obtiene el valor de la propiedad zonaRuidoAeronaves.
	 * 
	 */
	@Basic
	@Column(name = "ZONA_RUIDO_AERONAVES", precision = 10, scale = 0)
	public int getZonaRuidoAeronaves() {
		return zonaRuidoAeronaves;
	}

	/**
	 * Define el valor de la propiedad zonaRuidoAeronaves.
	 * 
	 */
	public void setZonaRuidoAeronaves(int value) {
		this.zonaRuidoAeronaves = value;
	}

	/**
	 * Obtiene el valor de la propiedad fachadasNoExpuestasRuido.
	 * 
	 */
	@Basic
	@Column(name = "FACHADAS_NO_EXPUESTAS_RUIDO", precision = 10, scale = 0)
	public int getFachadasNoExpuestasRuido() {
		return fachadasNoExpuestasRuido;
	}

	/**
	 * Define el valor de la propiedad fachadasNoExpuestasRuido.
	 * 
	 */
	public void setFachadasNoExpuestasRuido(int value) {
		this.fachadasNoExpuestasRuido = value;
	}

	/**
	 * Obtiene el valor de la propiedad recintosProtegidosRecintosProtegidos.
	 * 
	 */
	@Basic
	@Column(name = "RECINTOS_PROTEGIDOS_RECINTOS_PROTEGIDOS", precision = 10, scale = 0)
	public int getRecintosProtegidosRecintosProtegidos() {
		return recintosProtegidosRecintosProtegidos;
	}

	/**
	 * Define el valor de la propiedad recintosProtegidosRecintosProtegidos.
	 * 
	 */
	public void setRecintosProtegidosRecintosProtegidos(int value) {
		this.recintosProtegidosRecintosProtegidos = value;
	}

	/**
	 * Obtiene el valor de la propiedad recintosProtegidosRecintosHabitables.
	 * 
	 */
	@Basic
	@Column(name = "RECINTOS_PROTEGIDOS_RECINTOS_HABITABLES", precision = 10, scale = 0)
	public int getRecintosProtegidosRecintosHabitables() {
		return recintosProtegidosRecintosHabitables;
	}

	/**
	 * Define el valor de la propiedad recintosProtegidosRecintosHabitables.
	 * 
	 */
	public void setRecintosProtegidosRecintosHabitables(int value) {
		this.recintosProtegidosRecintosHabitables = value;
	}

	/**
	 * Obtiene el valor de la propiedad recintosProtegidosRecintosInstalaciones.
	 * 
	 */
	@Basic
	@Column(name = "RECINTOS_PROTEGIDOS_RECINTOS_INSTALACIONES", precision = 10, scale = 0)
	public int getRecintosProtegidosRecintosInstalaciones() {
		return recintosProtegidosRecintosInstalaciones;
	}

	/**
	 * Define el valor de la propiedad recintosProtegidosRecintosInstalaciones.
	 * 
	 */
	public void setRecintosProtegidosRecintosInstalaciones(int value) {
		this.recintosProtegidosRecintosInstalaciones = value;
	}

	/**
	 * Obtiene el valor de la propiedad recintosProtegidosAscensor.
	 * 
	 */
	@Basic
	@Column(name = "RECINTOS_PROTEGIDOS_ASCENSOR", precision = 10, scale = 0)
	public int getRecintosProtegidosAscensor() {
		return recintosProtegidosAscensor;
	}

	/**
	 * Define el valor de la propiedad recintosProtegidosAscensor.
	 * 
	 */
	public void setRecintosProtegidosAscensor(int value) {
		this.recintosProtegidosAscensor = value;
	}

	/**
	 * Obtiene el valor de la propiedad recintosProtegidosZonaComun.
	 * 
	 */
	@Basic
	@Column(name = "RECINTOS_PROTEGIDOS_ZONA_COMUN", precision = 10, scale = 0)
	public int getRecintosProtegidosZonaComun() {
		return recintosProtegidosZonaComun;
	}

	/**
	 * Define el valor de la propiedad recintosProtegidosZonaComun.
	 * 
	 */
	public void setRecintosProtegidosZonaComun(int value) {
		this.recintosProtegidosZonaComun = value;
	}

	/**
	 * Obtiene el valor de la propiedad existenRecintosInstalaciones.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "EXISTEN_RECINTOS_INSTALACIONES", length = 255)
	public String getExistenRecintosInstalaciones() {
		return existenRecintosInstalaciones;
	}

	/**
	 * Define el valor de la propiedad existenRecintosInstalaciones.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setExistenRecintosInstalaciones(String value) {
		this.existenRecintosInstalaciones = value;
	}

	/**
	 * Obtiene el valor de la propiedad recintosInstalacionesRecintosHabitables.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "RECINTOS_INSTALACIONES_RECINTOS_HABITABLES", length = 255)
	public String getRecintosInstalacionesRecintosHabitables() {
		return recintosInstalacionesRecintosHabitables;
	}

	/**
	 * Define el valor de la propiedad recintosInstalacionesRecintosHabitables.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRecintosInstalacionesRecintosHabitables(String value) {
		this.recintosInstalacionesRecintosHabitables = value;
	}

	/**
	 * Obtiene el valor de la propiedad recintosInstalacionesZonasComunes.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "RECINTOS_INSTALACIONES_ZONAS_COMUNES", length = 255)
	public String getRecintosInstalacionesZonasComunes() {
		return recintosInstalacionesZonasComunes;
	}

	/**
	 * Define el valor de la propiedad recintosInstalacionesZonasComunes.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRecintosInstalacionesZonasComunes(String value) {
		this.recintosInstalacionesZonasComunes = value;
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
		final AcusticaDatosgeneralesType that = ((AcusticaDatosgeneralesType) object);
		{
			String lhsTipoAreaAcustica;
			lhsTipoAreaAcustica = this.getTipoAreaAcustica();
			String rhsTipoAreaAcustica;
			rhsTipoAreaAcustica = that.getTipoAreaAcustica();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "tipoAreaAcustica", lhsTipoAreaAcustica), LocatorUtils.property(thatLocator, "tipoAreaAcustica", rhsTipoAreaAcustica), lhsTipoAreaAcustica, rhsTipoAreaAcustica)) {
				return false;
			}
		}
		{
			int lhsIndiceRuidoDia;
			lhsIndiceRuidoDia = this.getIndiceRuidoDia();
			int rhsIndiceRuidoDia;
			rhsIndiceRuidoDia = that.getIndiceRuidoDia();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "indiceRuidoDia", lhsIndiceRuidoDia), LocatorUtils.property(thatLocator, "indiceRuidoDia", rhsIndiceRuidoDia), lhsIndiceRuidoDia, rhsIndiceRuidoDia)) {
				return false;
			}
		}
		{
			int lhsObjetivoCalidadAcustica;
			lhsObjetivoCalidadAcustica = this.getObjetivoCalidadAcustica();
			int rhsObjetivoCalidadAcustica;
			rhsObjetivoCalidadAcustica = that.getObjetivoCalidadAcustica();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "objetivoCalidadAcustica", lhsObjetivoCalidadAcustica), LocatorUtils.property(thatLocator, "objetivoCalidadAcustica", rhsObjetivoCalidadAcustica), lhsObjetivoCalidadAcustica, rhsObjetivoCalidadAcustica)) {
				return false;
			}
		}
		{
			int lhsEstudioEspecifico;
			lhsEstudioEspecifico = this.getEstudioEspecifico();
			int rhsEstudioEspecifico;
			rhsEstudioEspecifico = that.getEstudioEspecifico();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "estudioEspecifico", lhsEstudioEspecifico), LocatorUtils.property(thatLocator, "estudioEspecifico", rhsEstudioEspecifico), lhsEstudioEspecifico, rhsEstudioEspecifico)) {
				return false;
			}
		}
		{
			int lhsZonaRuidoAeronaves;
			lhsZonaRuidoAeronaves = this.getZonaRuidoAeronaves();
			int rhsZonaRuidoAeronaves;
			rhsZonaRuidoAeronaves = that.getZonaRuidoAeronaves();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "zonaRuidoAeronaves", lhsZonaRuidoAeronaves), LocatorUtils.property(thatLocator, "zonaRuidoAeronaves", rhsZonaRuidoAeronaves), lhsZonaRuidoAeronaves, rhsZonaRuidoAeronaves)) {
				return false;
			}
		}
		{
			int lhsFachadasNoExpuestasRuido;
			lhsFachadasNoExpuestasRuido = this.getFachadasNoExpuestasRuido();
			int rhsFachadasNoExpuestasRuido;
			rhsFachadasNoExpuestasRuido = that.getFachadasNoExpuestasRuido();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "fachadasNoExpuestasRuido", lhsFachadasNoExpuestasRuido), LocatorUtils.property(thatLocator, "fachadasNoExpuestasRuido", rhsFachadasNoExpuestasRuido), lhsFachadasNoExpuestasRuido, rhsFachadasNoExpuestasRuido)) {
				return false;
			}
		}
		{
			int lhsRecintosProtegidosRecintosProtegidos;
			lhsRecintosProtegidosRecintosProtegidos = this.getRecintosProtegidosRecintosProtegidos();
			int rhsRecintosProtegidosRecintosProtegidos;
			rhsRecintosProtegidosRecintosProtegidos = that.getRecintosProtegidosRecintosProtegidos();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "recintosProtegidosRecintosProtegidos", lhsRecintosProtegidosRecintosProtegidos), LocatorUtils.property(thatLocator, "recintosProtegidosRecintosProtegidos", rhsRecintosProtegidosRecintosProtegidos), lhsRecintosProtegidosRecintosProtegidos, rhsRecintosProtegidosRecintosProtegidos)) {
				return false;
			}
		}
		{
			int lhsRecintosProtegidosRecintosHabitables;
			lhsRecintosProtegidosRecintosHabitables = this.getRecintosProtegidosRecintosHabitables();
			int rhsRecintosProtegidosRecintosHabitables;
			rhsRecintosProtegidosRecintosHabitables = that.getRecintosProtegidosRecintosHabitables();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "recintosProtegidosRecintosHabitables", lhsRecintosProtegidosRecintosHabitables), LocatorUtils.property(thatLocator, "recintosProtegidosRecintosHabitables", rhsRecintosProtegidosRecintosHabitables), lhsRecintosProtegidosRecintosHabitables, rhsRecintosProtegidosRecintosHabitables)) {
				return false;
			}
		}
		{
			int lhsRecintosProtegidosRecintosInstalaciones;
			lhsRecintosProtegidosRecintosInstalaciones = this.getRecintosProtegidosRecintosInstalaciones();
			int rhsRecintosProtegidosRecintosInstalaciones;
			rhsRecintosProtegidosRecintosInstalaciones = that.getRecintosProtegidosRecintosInstalaciones();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "recintosProtegidosRecintosInstalaciones", lhsRecintosProtegidosRecintosInstalaciones), LocatorUtils.property(thatLocator, "recintosProtegidosRecintosInstalaciones", rhsRecintosProtegidosRecintosInstalaciones), lhsRecintosProtegidosRecintosInstalaciones, rhsRecintosProtegidosRecintosInstalaciones)) {
				return false;
			}
		}
		{
			int lhsRecintosProtegidosAscensor;
			lhsRecintosProtegidosAscensor = this.getRecintosProtegidosAscensor();
			int rhsRecintosProtegidosAscensor;
			rhsRecintosProtegidosAscensor = that.getRecintosProtegidosAscensor();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "recintosProtegidosAscensor", lhsRecintosProtegidosAscensor), LocatorUtils.property(thatLocator, "recintosProtegidosAscensor", rhsRecintosProtegidosAscensor), lhsRecintosProtegidosAscensor, rhsRecintosProtegidosAscensor)) {
				return false;
			}
		}
		{
			int lhsRecintosProtegidosZonaComun;
			lhsRecintosProtegidosZonaComun = this.getRecintosProtegidosZonaComun();
			int rhsRecintosProtegidosZonaComun;
			rhsRecintosProtegidosZonaComun = that.getRecintosProtegidosZonaComun();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "recintosProtegidosZonaComun", lhsRecintosProtegidosZonaComun), LocatorUtils.property(thatLocator, "recintosProtegidosZonaComun", rhsRecintosProtegidosZonaComun), lhsRecintosProtegidosZonaComun, rhsRecintosProtegidosZonaComun)) {
				return false;
			}
		}
		{
			String lhsExistenRecintosInstalaciones;
			lhsExistenRecintosInstalaciones = this.getExistenRecintosInstalaciones();
			String rhsExistenRecintosInstalaciones;
			rhsExistenRecintosInstalaciones = that.getExistenRecintosInstalaciones();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "existenRecintosInstalaciones", lhsExistenRecintosInstalaciones), LocatorUtils.property(thatLocator, "existenRecintosInstalaciones", rhsExistenRecintosInstalaciones), lhsExistenRecintosInstalaciones, rhsExistenRecintosInstalaciones)) {
				return false;
			}
		}
		{
			String lhsRecintosInstalacionesRecintosHabitables;
			lhsRecintosInstalacionesRecintosHabitables = this.getRecintosInstalacionesRecintosHabitables();
			String rhsRecintosInstalacionesRecintosHabitables;
			rhsRecintosInstalacionesRecintosHabitables = that.getRecintosInstalacionesRecintosHabitables();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "recintosInstalacionesRecintosHabitables", lhsRecintosInstalacionesRecintosHabitables), LocatorUtils.property(thatLocator, "recintosInstalacionesRecintosHabitables", rhsRecintosInstalacionesRecintosHabitables), lhsRecintosInstalacionesRecintosHabitables, rhsRecintosInstalacionesRecintosHabitables)) {
				return false;
			}
		}
		{
			String lhsRecintosInstalacionesZonasComunes;
			lhsRecintosInstalacionesZonasComunes = this.getRecintosInstalacionesZonasComunes();
			String rhsRecintosInstalacionesZonasComunes;
			rhsRecintosInstalacionesZonasComunes = that.getRecintosInstalacionesZonasComunes();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "recintosInstalacionesZonasComunes", lhsRecintosInstalacionesZonasComunes), LocatorUtils.property(thatLocator, "recintosInstalacionesZonasComunes", rhsRecintosInstalacionesZonasComunes), lhsRecintosInstalacionesZonasComunes, rhsRecintosInstalacionesZonasComunes)) {
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
			String theTipoAreaAcustica;
			theTipoAreaAcustica = this.getTipoAreaAcustica();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "tipoAreaAcustica", theTipoAreaAcustica), currentHashCode, theTipoAreaAcustica);
		}
		{
			int theIndiceRuidoDia;
			theIndiceRuidoDia = this.getIndiceRuidoDia();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "indiceRuidoDia", theIndiceRuidoDia), currentHashCode, theIndiceRuidoDia);
		}
		{
			int theObjetivoCalidadAcustica;
			theObjetivoCalidadAcustica = this.getObjetivoCalidadAcustica();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "objetivoCalidadAcustica", theObjetivoCalidadAcustica), currentHashCode, theObjetivoCalidadAcustica);
		}
		{
			int theEstudioEspecifico;
			theEstudioEspecifico = this.getEstudioEspecifico();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "estudioEspecifico", theEstudioEspecifico), currentHashCode, theEstudioEspecifico);
		}
		{
			int theZonaRuidoAeronaves;
			theZonaRuidoAeronaves = this.getZonaRuidoAeronaves();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "zonaRuidoAeronaves", theZonaRuidoAeronaves), currentHashCode, theZonaRuidoAeronaves);
		}
		{
			int theFachadasNoExpuestasRuido;
			theFachadasNoExpuestasRuido = this.getFachadasNoExpuestasRuido();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "fachadasNoExpuestasRuido", theFachadasNoExpuestasRuido), currentHashCode, theFachadasNoExpuestasRuido);
		}
		{
			int theRecintosProtegidosRecintosProtegidos;
			theRecintosProtegidosRecintosProtegidos = this.getRecintosProtegidosRecintosProtegidos();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "recintosProtegidosRecintosProtegidos", theRecintosProtegidosRecintosProtegidos), currentHashCode, theRecintosProtegidosRecintosProtegidos);
		}
		{
			int theRecintosProtegidosRecintosHabitables;
			theRecintosProtegidosRecintosHabitables = this.getRecintosProtegidosRecintosHabitables();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "recintosProtegidosRecintosHabitables", theRecintosProtegidosRecintosHabitables), currentHashCode, theRecintosProtegidosRecintosHabitables);
		}
		{
			int theRecintosProtegidosRecintosInstalaciones;
			theRecintosProtegidosRecintosInstalaciones = this.getRecintosProtegidosRecintosInstalaciones();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "recintosProtegidosRecintosInstalaciones", theRecintosProtegidosRecintosInstalaciones), currentHashCode, theRecintosProtegidosRecintosInstalaciones);
		}
		{
			int theRecintosProtegidosAscensor;
			theRecintosProtegidosAscensor = this.getRecintosProtegidosAscensor();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "recintosProtegidosAscensor", theRecintosProtegidosAscensor), currentHashCode, theRecintosProtegidosAscensor);
		}
		{
			int theRecintosProtegidosZonaComun;
			theRecintosProtegidosZonaComun = this.getRecintosProtegidosZonaComun();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "recintosProtegidosZonaComun", theRecintosProtegidosZonaComun), currentHashCode, theRecintosProtegidosZonaComun);
		}
		{
			String theExistenRecintosInstalaciones;
			theExistenRecintosInstalaciones = this.getExistenRecintosInstalaciones();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "existenRecintosInstalaciones", theExistenRecintosInstalaciones), currentHashCode, theExistenRecintosInstalaciones);
		}
		{
			String theRecintosInstalacionesRecintosHabitables;
			theRecintosInstalacionesRecintosHabitables = this.getRecintosInstalacionesRecintosHabitables();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "recintosInstalacionesRecintosHabitables", theRecintosInstalacionesRecintosHabitables), currentHashCode, theRecintosInstalacionesRecintosHabitables);
		}
		{
			String theRecintosInstalacionesZonasComunes;
			theRecintosInstalacionesZonasComunes = this.getRecintosInstalacionesZonasComunes();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "recintosInstalacionesZonasComunes", theRecintosInstalacionesZonasComunes), currentHashCode, theRecintosInstalacionesZonasComunes);
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
