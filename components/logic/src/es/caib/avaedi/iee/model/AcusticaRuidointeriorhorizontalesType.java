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
 * Clase Java para acustica_ruidointeriorhorizontalesType complex type.
 * 
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que
 * haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="acustica_ruidointeriorhorizontalesType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="plantatipo_canto_forjado" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="plantagaraje_canto_forjado" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="forjado_plantatipo_otro" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="forjado_plantagaraje_otro" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="suelo_flotante_tiene" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="techo_suspendido_tiene" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="estado_bueno" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="deficiencias_observaciones" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="caracteristicas_suelo_flotante_revestidas" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="caracteristicas_suelo_flotante_contacto_directo" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="caracteristicas_camara_aire_continua" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="caracteristicas_luminarias_empotradas_selladas" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="observaciones" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="acustica_ruidointeriorhorizontales_sueloflotante_tipos" type="{}acustica_ruidointeriorhorizontales_sueloflotante_tiposType"/&gt;
 *         &lt;element name="acustica_ruidointeriorhorizontales_sueloflotante_caracteristicas" type="{}acustica_ruidointeriorhorizontales_sueloflotante_caracteristicasType"/&gt;
 *         &lt;element name="acustica_ruidointeriorhorizontales_techo_tipos" type="{}acustica_ruidointeriorhorizontales_techo_tiposType"/&gt;
 *         &lt;element name="acustica_ruidointeriorhorizontales_techo_caracteristicas" type="{}acustica_ruidointeriorhorizontales_techo_caracteristicasType"/&gt;
 *         &lt;element name="acustica_ruidointeriorhorizontales_garaje_estructuraprincipal" type="{}acustica_ruidointeriorhorizontales_garaje_estructuraprincipalType"/&gt;
 *         &lt;element name="acustica_ruidointeriorhorizontales_tipo_estructuraprincipal" type="{}acustica_ruidointeriorhorizontales_tipo_estructuraprincipalType"/&gt;
 *         &lt;element name="acustica_ruidointeriorhorizontales_garaje_forjadosecundario" type="{}acustica_ruidointeriorhorizontales_garaje_forjadosecundarioType"/&gt;
 *         &lt;element name="acustica_ruidointeriorhorizontales_tipo_forjadosecundario" type="{}acustica_ruidointeriorhorizontales_tipo_forjadosecundarioType"/&gt;
 *         &lt;element name="acustica_ruidointeriorhorizontales_garaje_forjadoentrevigado" type="{}acustica_ruidointeriorhorizontales_garaje_forjadoentrevigadoType"/&gt;
 *         &lt;element name="acustica_ruidointeriorhorizontales_tipo_forjadoentrevigado" type="{}acustica_ruidointeriorhorizontales_tipo_forjadoentrevigadoType"/&gt;
 *         &lt;element name="acustica_ruidointeriorhorizontales_garaje_otros" type="{}acustica_ruidointeriorhorizontales_garaje_otrosType"/&gt;
 *         &lt;element name="acustica_ruidointeriorhorizontales_tipo_otros" type="{}acustica_ruidointeriorhorizontales_tipo_otrosType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "acustica_ruidointeriorhorizontalesType", propOrder = { "plantatipoCantoForjado", "plantagarajeCantoForjado", "forjadoPlantatipoOtro", "forjadoPlantagarajeOtro", "sueloFlotanteTiene", "techoSuspendidoTiene", "estadoBueno", "deficienciasObservaciones", "caracteristicasSueloFlotanteRevestidas", "caracteristicasSueloFlotanteContactoDirecto", "caracteristicasCamaraAireContinua", "caracteristicasLuminariasEmpotradasSelladas", "observaciones", "acusticaRuidointeriorhorizontalesSueloflotanteTipos", "acusticaRuidointeriorhorizontalesSueloflotanteCaracteristicas", "acusticaRuidointeriorhorizontalesTechoTipos", "acusticaRuidointeriorhorizontalesTechoCaracteristicas", "acusticaRuidointeriorhorizontalesGarajeEstructuraprincipal", "acusticaRuidointeriorhorizontalesTipoEstructuraprincipal", "acusticaRuidointeriorhorizontalesGarajeForjadosecundario", "acusticaRuidointeriorhorizontalesTipoForjadosecundario", "acusticaRuidointeriorhorizontalesGarajeForjadoentrevigado", "acusticaRuidointeriorhorizontalesTipoForjadoentrevigado", "acusticaRuidointeriorhorizontalesGarajeOtros", "acusticaRuidointeriorhorizontalesTipoOtros" })
@Entity(name = "AcusticaRuidointeriorhorizontalesType")
@Table(name = "AED_ACU_RUIINTHOR")
@Inheritance(strategy = InheritanceType.JOINED)
public class AcusticaRuidointeriorhorizontalesType implements Serializable, Equals, HashCode {

	@XmlElement(name = "plantatipo_canto_forjado", required = true)
	protected String plantatipoCantoForjado;
	@XmlElement(name = "plantagaraje_canto_forjado", required = true)
	protected String plantagarajeCantoForjado;
	@XmlElement(name = "forjado_plantatipo_otro", required = true)
	protected String forjadoPlantatipoOtro;
	@XmlElement(name = "forjado_plantagaraje_otro", required = true)
	protected String forjadoPlantagarajeOtro;
	@XmlElement(name = "suelo_flotante_tiene")
	protected int sueloFlotanteTiene;
	@XmlElement(name = "techo_suspendido_tiene")
	protected int techoSuspendidoTiene;
	@XmlElement(name = "estado_bueno")
	protected int estadoBueno;
	@XmlElement(name = "deficiencias_observaciones", required = true)
	protected String deficienciasObservaciones;
	@XmlElement(name = "caracteristicas_suelo_flotante_revestidas")
	protected int caracteristicasSueloFlotanteRevestidas;
	@XmlElement(name = "caracteristicas_suelo_flotante_contacto_directo")
	protected int caracteristicasSueloFlotanteContactoDirecto;
	@XmlElement(name = "caracteristicas_camara_aire_continua")
	protected int caracteristicasCamaraAireContinua;
	@XmlElement(name = "caracteristicas_luminarias_empotradas_selladas")
	protected int caracteristicasLuminariasEmpotradasSelladas;
	@XmlElement(required = true)
	protected String observaciones;
	@XmlElement(name = "acustica_ruidointeriorhorizontales_sueloflotante_tipos", required = true)
	protected AcusticaRuidointeriorhorizontalesSueloflotanteTiposType acusticaRuidointeriorhorizontalesSueloflotanteTipos;
	@XmlElement(name = "acustica_ruidointeriorhorizontales_sueloflotante_caracteristicas", required = true)
	protected AcusticaRuidointeriorhorizontalesSueloflotanteCaracteristicasType acusticaRuidointeriorhorizontalesSueloflotanteCaracteristicas;
	@XmlElement(name = "acustica_ruidointeriorhorizontales_techo_tipos", required = true)
	protected AcusticaRuidointeriorhorizontalesTechoTiposType acusticaRuidointeriorhorizontalesTechoTipos;
	@XmlElement(name = "acustica_ruidointeriorhorizontales_techo_caracteristicas", required = true)
	protected AcusticaRuidointeriorhorizontalesTechoCaracteristicasType acusticaRuidointeriorhorizontalesTechoCaracteristicas;
	@XmlElement(name = "acustica_ruidointeriorhorizontales_garaje_estructuraprincipal", required = true)
	protected AcusticaRuidointeriorhorizontalesGarajeEstructuraprincipalType acusticaRuidointeriorhorizontalesGarajeEstructuraprincipal;
	@XmlElement(name = "acustica_ruidointeriorhorizontales_tipo_estructuraprincipal", required = true)
	protected AcusticaRuidointeriorhorizontalesTipoEstructuraprincipalType acusticaRuidointeriorhorizontalesTipoEstructuraprincipal;
	@XmlElement(name = "acustica_ruidointeriorhorizontales_garaje_forjadosecundario", required = true)
	protected AcusticaRuidointeriorhorizontalesGarajeForjadosecundarioType acusticaRuidointeriorhorizontalesGarajeForjadosecundario;
	@XmlElement(name = "acustica_ruidointeriorhorizontales_tipo_forjadosecundario", required = true)
	protected AcusticaRuidointeriorhorizontalesTipoForjadosecundarioType acusticaRuidointeriorhorizontalesTipoForjadosecundario;
	@XmlElement(name = "acustica_ruidointeriorhorizontales_garaje_forjadoentrevigado", required = true)
	protected AcusticaRuidointeriorhorizontalesGarajeForjadoentrevigadoType acusticaRuidointeriorhorizontalesGarajeForjadoentrevigado;
	@XmlElement(name = "acustica_ruidointeriorhorizontales_tipo_forjadoentrevigado", required = true)
	protected AcusticaRuidointeriorhorizontalesTipoForjadoentrevigadoType acusticaRuidointeriorhorizontalesTipoForjadoentrevigado;
	@XmlElement(name = "acustica_ruidointeriorhorizontales_garaje_otros", required = true)
	protected AcusticaRuidointeriorhorizontalesGarajeOtrosType acusticaRuidointeriorhorizontalesGarajeOtros;
	@XmlElement(name = "acustica_ruidointeriorhorizontales_tipo_otros", required = true)
	protected AcusticaRuidointeriorhorizontalesTipoOtrosType acusticaRuidointeriorhorizontalesTipoOtros;
	@XmlAttribute(name = "Hjid")
	protected Long hjid;

	/**
	 * Obtiene el valor de la propiedad plantatipoCantoForjado.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "PLANTATIPO_CANTO_FORJADO", length = 255)
	public String getPlantatipoCantoForjado() {
		return plantatipoCantoForjado;
	}

	/**
	 * Define el valor de la propiedad plantatipoCantoForjado.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPlantatipoCantoForjado(String value) {
		this.plantatipoCantoForjado = value;
	}

	/**
	 * Obtiene el valor de la propiedad plantagarajeCantoForjado.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "PLANTAGARAJE_CANTO_FORJADO", length = 255)
	public String getPlantagarajeCantoForjado() {
		return plantagarajeCantoForjado;
	}

	/**
	 * Define el valor de la propiedad plantagarajeCantoForjado.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPlantagarajeCantoForjado(String value) {
		this.plantagarajeCantoForjado = value;
	}

	/**
	 * Obtiene el valor de la propiedad forjadoPlantatipoOtro.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "FORJADO_PLANTATIPO_OTRO", length = 255)
	public String getForjadoPlantatipoOtro() {
		return forjadoPlantatipoOtro;
	}

	/**
	 * Define el valor de la propiedad forjadoPlantatipoOtro.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setForjadoPlantatipoOtro(String value) {
		this.forjadoPlantatipoOtro = value;
	}

	/**
	 * Obtiene el valor de la propiedad forjadoPlantagarajeOtro.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "FORJADO_PLANTAGARAJE_OTRO", length = 255)
	public String getForjadoPlantagarajeOtro() {
		return forjadoPlantagarajeOtro;
	}

	/**
	 * Define el valor de la propiedad forjadoPlantagarajeOtro.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setForjadoPlantagarajeOtro(String value) {
		this.forjadoPlantagarajeOtro = value;
	}

	/**
	 * Obtiene el valor de la propiedad sueloFlotanteTiene.
	 * 
	 */
	@Basic
	@Column(name = "SUELO_FLOTANTE_TIENE", precision = 10, scale = 0)
	public int getSueloFlotanteTiene() {
		return sueloFlotanteTiene;
	}

	/**
	 * Define el valor de la propiedad sueloFlotanteTiene.
	 * 
	 */
	public void setSueloFlotanteTiene(int value) {
		this.sueloFlotanteTiene = value;
	}

	/**
	 * Obtiene el valor de la propiedad techoSuspendidoTiene.
	 * 
	 */
	@Basic
	@Column(name = "TECHO_SUSPENDIDO_TIENE", precision = 10, scale = 0)
	public int getTechoSuspendidoTiene() {
		return techoSuspendidoTiene;
	}

	/**
	 * Define el valor de la propiedad techoSuspendidoTiene.
	 * 
	 */
	public void setTechoSuspendidoTiene(int value) {
		this.techoSuspendidoTiene = value;
	}

	/**
	 * Obtiene el valor de la propiedad estadoBueno.
	 * 
	 */
	@Basic
	@Column(name = "ESTADO_BUENO", precision = 10, scale = 0)
	public int getEstadoBueno() {
		return estadoBueno;
	}

	/**
	 * Define el valor de la propiedad estadoBueno.
	 * 
	 */
	public void setEstadoBueno(int value) {
		this.estadoBueno = value;
	}

	/**
	 * Obtiene el valor de la propiedad deficienciasObservaciones.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "DEFICIENCIAS_OBSERVACIONES", length = 255)
	public String getDeficienciasObservaciones() {
		return deficienciasObservaciones;
	}

	/**
	 * Define el valor de la propiedad deficienciasObservaciones.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDeficienciasObservaciones(String value) {
		this.deficienciasObservaciones = value;
	}

	/**
	 * Obtiene el valor de la propiedad caracteristicasSueloFlotanteRevestidas.
	 * 
	 */
	@Basic
	@Column(name = "CARACTERISTICAS_SUELO_FLOTANTE_REVESTIDAS", precision = 10, scale = 0)
	public int getCaracteristicasSueloFlotanteRevestidas() {
		return caracteristicasSueloFlotanteRevestidas;
	}

	/**
	 * Define el valor de la propiedad caracteristicasSueloFlotanteRevestidas.
	 * 
	 */
	public void setCaracteristicasSueloFlotanteRevestidas(int value) {
		this.caracteristicasSueloFlotanteRevestidas = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * caracteristicasSueloFlotanteContactoDirecto.
	 * 
	 */
	@Basic
	@Column(name = "CARACTERISTICAS_SUELO_FLOTANTE_CONTACTO_DIRECTO", precision = 10, scale = 0)
	public int getCaracteristicasSueloFlotanteContactoDirecto() {
		return caracteristicasSueloFlotanteContactoDirecto;
	}

	/**
	 * Define el valor de la propiedad
	 * caracteristicasSueloFlotanteContactoDirecto.
	 * 
	 */
	public void setCaracteristicasSueloFlotanteContactoDirecto(int value) {
		this.caracteristicasSueloFlotanteContactoDirecto = value;
	}

	/**
	 * Obtiene el valor de la propiedad caracteristicasCamaraAireContinua.
	 * 
	 */
	@Basic
	@Column(name = "CARACTERISTICAS_CAMARA_AIRE_CONTINUA", precision = 10, scale = 0)
	public int getCaracteristicasCamaraAireContinua() {
		return caracteristicasCamaraAireContinua;
	}

	/**
	 * Define el valor de la propiedad caracteristicasCamaraAireContinua.
	 * 
	 */
	public void setCaracteristicasCamaraAireContinua(int value) {
		this.caracteristicasCamaraAireContinua = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * caracteristicasLuminariasEmpotradasSelladas.
	 * 
	 */
	@Basic
	@Column(name = "CARACTERISTICAS_LUMINARIAS_EMPOTRADAS_SELLADAS", precision = 10, scale = 0)
	public int getCaracteristicasLuminariasEmpotradasSelladas() {
		return caracteristicasLuminariasEmpotradasSelladas;
	}

	/**
	 * Define el valor de la propiedad
	 * caracteristicasLuminariasEmpotradasSelladas.
	 * 
	 */
	public void setCaracteristicasLuminariasEmpotradasSelladas(int value) {
		this.caracteristicasLuminariasEmpotradasSelladas = value;
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
	 * Obtiene el valor de la propiedad
	 * acusticaRuidointeriorhorizontalesSueloflotanteTipos.
	 * 
	 * @return possible object is
	 *         {@link AcusticaRuidointeriorhorizontalesSueloflotanteTiposType }
	 * 
	 */
	@ManyToOne(targetEntity = AcusticaRuidointeriorhorizontalesSueloflotanteTiposType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "ACUSTICA_RUIDOINTERIORHORIZONTALES_SUELOFLOTANTE_TIPOS_AED_ACU_RUIINTHOR_HJID")
	public AcusticaRuidointeriorhorizontalesSueloflotanteTiposType getAcusticaRuidointeriorhorizontalesSueloflotanteTipos() {
		return acusticaRuidointeriorhorizontalesSueloflotanteTipos;
	}

	/**
	 * Define el valor de la propiedad
	 * acusticaRuidointeriorhorizontalesSueloflotanteTipos.
	 * 
	 * @param value
	 *            allowed object is
	 *            {@link AcusticaRuidointeriorhorizontalesSueloflotanteTiposType }
	 * 
	 */
	public void setAcusticaRuidointeriorhorizontalesSueloflotanteTipos(AcusticaRuidointeriorhorizontalesSueloflotanteTiposType value) {
		this.acusticaRuidointeriorhorizontalesSueloflotanteTipos = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * acusticaRuidointeriorhorizontalesSueloflotanteCaracteristicas.
	 * 
	 * @return possible object is
	 *         {@link AcusticaRuidointeriorhorizontalesSueloflotanteCaracteristicasType }
	 * 
	 */
	@ManyToOne(targetEntity = AcusticaRuidointeriorhorizontalesSueloflotanteCaracteristicasType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "ACUSTICA_RUIDOINTERIORHORIZONTALES_SUELOFLOTANTE_CARACTERISTICAS_AED_ACU_RUIINTHOR_HJID")
	public AcusticaRuidointeriorhorizontalesSueloflotanteCaracteristicasType getAcusticaRuidointeriorhorizontalesSueloflotanteCaracteristicas() {
		return acusticaRuidointeriorhorizontalesSueloflotanteCaracteristicas;
	}

	/**
	 * Define el valor de la propiedad
	 * acusticaRuidointeriorhorizontalesSueloflotanteCaracteristicas.
	 * 
	 * @param value
	 *            allowed object is
	 *            {@link AcusticaRuidointeriorhorizontalesSueloflotanteCaracteristicasType }
	 * 
	 */
	public void setAcusticaRuidointeriorhorizontalesSueloflotanteCaracteristicas(AcusticaRuidointeriorhorizontalesSueloflotanteCaracteristicasType value) {
		this.acusticaRuidointeriorhorizontalesSueloflotanteCaracteristicas = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * acusticaRuidointeriorhorizontalesTechoTipos.
	 * 
	 * @return possible object is
	 *         {@link AcusticaRuidointeriorhorizontalesTechoTiposType }
	 * 
	 */
	@ManyToOne(targetEntity = AcusticaRuidointeriorhorizontalesTechoTiposType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "ACUSTICA_RUIDOINTERIORHORIZONTALES_TECHO_TIPOS_AED_ACU_RUIINTHOR_HJID")
	public AcusticaRuidointeriorhorizontalesTechoTiposType getAcusticaRuidointeriorhorizontalesTechoTipos() {
		return acusticaRuidointeriorhorizontalesTechoTipos;
	}

	/**
	 * Define el valor de la propiedad
	 * acusticaRuidointeriorhorizontalesTechoTipos.
	 * 
	 * @param value
	 *            allowed object is
	 *            {@link AcusticaRuidointeriorhorizontalesTechoTiposType }
	 * 
	 */
	public void setAcusticaRuidointeriorhorizontalesTechoTipos(AcusticaRuidointeriorhorizontalesTechoTiposType value) {
		this.acusticaRuidointeriorhorizontalesTechoTipos = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * acusticaRuidointeriorhorizontalesTechoCaracteristicas.
	 * 
	 * @return possible object is
	 *         {@link AcusticaRuidointeriorhorizontalesTechoCaracteristicasType }
	 * 
	 */
	@ManyToOne(targetEntity = AcusticaRuidointeriorhorizontalesTechoCaracteristicasType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "ACUSTICA_RUIDOINTERIORHORIZONTALES_TECHO_CARACTERISTICAS_AED_ACU_RUIINTHOR_HJID")
	public AcusticaRuidointeriorhorizontalesTechoCaracteristicasType getAcusticaRuidointeriorhorizontalesTechoCaracteristicas() {
		return acusticaRuidointeriorhorizontalesTechoCaracteristicas;
	}

	/**
	 * Define el valor de la propiedad
	 * acusticaRuidointeriorhorizontalesTechoCaracteristicas.
	 * 
	 * @param value
	 *            allowed object is
	 *            {@link AcusticaRuidointeriorhorizontalesTechoCaracteristicasType }
	 * 
	 */
	public void setAcusticaRuidointeriorhorizontalesTechoCaracteristicas(AcusticaRuidointeriorhorizontalesTechoCaracteristicasType value) {
		this.acusticaRuidointeriorhorizontalesTechoCaracteristicas = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * acusticaRuidointeriorhorizontalesGarajeEstructuraprincipal.
	 * 
	 * @return possible object is
	 *         {@link AcusticaRuidointeriorhorizontalesGarajeEstructuraprincipalType }
	 * 
	 */
	@ManyToOne(targetEntity = AcusticaRuidointeriorhorizontalesGarajeEstructuraprincipalType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "ACUSTICA_RUIDOINTERIORHORIZONTALES_GARAJE_ESTRUCTURAPRINCIPAL_AED_ACU_RUIINTHOR_HJID")
	public AcusticaRuidointeriorhorizontalesGarajeEstructuraprincipalType getAcusticaRuidointeriorhorizontalesGarajeEstructuraprincipal() {
		return acusticaRuidointeriorhorizontalesGarajeEstructuraprincipal;
	}

	/**
	 * Define el valor de la propiedad
	 * acusticaRuidointeriorhorizontalesGarajeEstructuraprincipal.
	 * 
	 * @param value
	 *            allowed object is
	 *            {@link AcusticaRuidointeriorhorizontalesGarajeEstructuraprincipalType }
	 * 
	 */
	public void setAcusticaRuidointeriorhorizontalesGarajeEstructuraprincipal(AcusticaRuidointeriorhorizontalesGarajeEstructuraprincipalType value) {
		this.acusticaRuidointeriorhorizontalesGarajeEstructuraprincipal = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * acusticaRuidointeriorhorizontalesTipoEstructuraprincipal.
	 * 
	 * @return possible object is
	 *         {@link AcusticaRuidointeriorhorizontalesTipoEstructuraprincipalType }
	 * 
	 */
	@ManyToOne(targetEntity = AcusticaRuidointeriorhorizontalesTipoEstructuraprincipalType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "ACUSTICA_RUIDOINTERIORHORIZONTALES_TIPO_ESTRUCTURAPRINCIPAL_AED_ACU_RUIINTHOR_HJID")
	public AcusticaRuidointeriorhorizontalesTipoEstructuraprincipalType getAcusticaRuidointeriorhorizontalesTipoEstructuraprincipal() {
		return acusticaRuidointeriorhorizontalesTipoEstructuraprincipal;
	}

	/**
	 * Define el valor de la propiedad
	 * acusticaRuidointeriorhorizontalesTipoEstructuraprincipal.
	 * 
	 * @param value
	 *            allowed object is
	 *            {@link AcusticaRuidointeriorhorizontalesTipoEstructuraprincipalType }
	 * 
	 */
	public void setAcusticaRuidointeriorhorizontalesTipoEstructuraprincipal(AcusticaRuidointeriorhorizontalesTipoEstructuraprincipalType value) {
		this.acusticaRuidointeriorhorizontalesTipoEstructuraprincipal = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * acusticaRuidointeriorhorizontalesGarajeForjadosecundario.
	 * 
	 * @return possible object is
	 *         {@link AcusticaRuidointeriorhorizontalesGarajeForjadosecundarioType }
	 * 
	 */
	@ManyToOne(targetEntity = AcusticaRuidointeriorhorizontalesGarajeForjadosecundarioType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "ACUSTICA_RUIDOINTERIORHORIZONTALES_GARAJE_FORJADOSECUNDARIO_AED_ACU_RUIINTHOR_HJID")
	public AcusticaRuidointeriorhorizontalesGarajeForjadosecundarioType getAcusticaRuidointeriorhorizontalesGarajeForjadosecundario() {
		return acusticaRuidointeriorhorizontalesGarajeForjadosecundario;
	}

	/**
	 * Define el valor de la propiedad
	 * acusticaRuidointeriorhorizontalesGarajeForjadosecundario.
	 * 
	 * @param value
	 *            allowed object is
	 *            {@link AcusticaRuidointeriorhorizontalesGarajeForjadosecundarioType }
	 * 
	 */
	public void setAcusticaRuidointeriorhorizontalesGarajeForjadosecundario(AcusticaRuidointeriorhorizontalesGarajeForjadosecundarioType value) {
		this.acusticaRuidointeriorhorizontalesGarajeForjadosecundario = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * acusticaRuidointeriorhorizontalesTipoForjadosecundario.
	 * 
	 * @return possible object is
	 *         {@link AcusticaRuidointeriorhorizontalesTipoForjadosecundarioType }
	 * 
	 */
	@ManyToOne(targetEntity = AcusticaRuidointeriorhorizontalesTipoForjadosecundarioType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "ACUSTICA_RUIDOINTERIORHORIZONTALES_TIPO_FORJADOSECUNDARIO_AED_ACU_RUIINTHOR_HJID")
	public AcusticaRuidointeriorhorizontalesTipoForjadosecundarioType getAcusticaRuidointeriorhorizontalesTipoForjadosecundario() {
		return acusticaRuidointeriorhorizontalesTipoForjadosecundario;
	}

	/**
	 * Define el valor de la propiedad
	 * acusticaRuidointeriorhorizontalesTipoForjadosecundario.
	 * 
	 * @param value
	 *            allowed object is
	 *            {@link AcusticaRuidointeriorhorizontalesTipoForjadosecundarioType }
	 * 
	 */
	public void setAcusticaRuidointeriorhorizontalesTipoForjadosecundario(AcusticaRuidointeriorhorizontalesTipoForjadosecundarioType value) {
		this.acusticaRuidointeriorhorizontalesTipoForjadosecundario = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * acusticaRuidointeriorhorizontalesGarajeForjadoentrevigado.
	 * 
	 * @return possible object is
	 *         {@link AcusticaRuidointeriorhorizontalesGarajeForjadoentrevigadoType }
	 * 
	 */
	@ManyToOne(targetEntity = AcusticaRuidointeriorhorizontalesGarajeForjadoentrevigadoType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "ACUSTICA_RUIDOINTERIORHORIZONTALES_GARAJE_FORJADOENTREVIGADO_AED_ACU_RUIINTHOR_HJID")
	public AcusticaRuidointeriorhorizontalesGarajeForjadoentrevigadoType getAcusticaRuidointeriorhorizontalesGarajeForjadoentrevigado() {
		return acusticaRuidointeriorhorizontalesGarajeForjadoentrevigado;
	}

	/**
	 * Define el valor de la propiedad
	 * acusticaRuidointeriorhorizontalesGarajeForjadoentrevigado.
	 * 
	 * @param value
	 *            allowed object is
	 *            {@link AcusticaRuidointeriorhorizontalesGarajeForjadoentrevigadoType }
	 * 
	 */
	public void setAcusticaRuidointeriorhorizontalesGarajeForjadoentrevigado(AcusticaRuidointeriorhorizontalesGarajeForjadoentrevigadoType value) {
		this.acusticaRuidointeriorhorizontalesGarajeForjadoentrevigado = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * acusticaRuidointeriorhorizontalesTipoForjadoentrevigado.
	 * 
	 * @return possible object is
	 *         {@link AcusticaRuidointeriorhorizontalesTipoForjadoentrevigadoType }
	 * 
	 */
	@ManyToOne(targetEntity = AcusticaRuidointeriorhorizontalesTipoForjadoentrevigadoType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "ACUSTICA_RUIDOINTERIORHORIZONTALES_TIPO_FORJADOENTREVIGADO_AED_ACU_RUIINTHOR_HJID")
	public AcusticaRuidointeriorhorizontalesTipoForjadoentrevigadoType getAcusticaRuidointeriorhorizontalesTipoForjadoentrevigado() {
		return acusticaRuidointeriorhorizontalesTipoForjadoentrevigado;
	}

	/**
	 * Define el valor de la propiedad
	 * acusticaRuidointeriorhorizontalesTipoForjadoentrevigado.
	 * 
	 * @param value
	 *            allowed object is
	 *            {@link AcusticaRuidointeriorhorizontalesTipoForjadoentrevigadoType }
	 * 
	 */
	public void setAcusticaRuidointeriorhorizontalesTipoForjadoentrevigado(AcusticaRuidointeriorhorizontalesTipoForjadoentrevigadoType value) {
		this.acusticaRuidointeriorhorizontalesTipoForjadoentrevigado = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * acusticaRuidointeriorhorizontalesGarajeOtros.
	 * 
	 * @return possible object is
	 *         {@link AcusticaRuidointeriorhorizontalesGarajeOtrosType }
	 * 
	 */
	@ManyToOne(targetEntity = AcusticaRuidointeriorhorizontalesGarajeOtrosType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "ACUSTICA_RUIDOINTERIORHORIZONTALES_GARAJE_OTROS_AED_ACU_RUIINTHOR_HJID")
	public AcusticaRuidointeriorhorizontalesGarajeOtrosType getAcusticaRuidointeriorhorizontalesGarajeOtros() {
		return acusticaRuidointeriorhorizontalesGarajeOtros;
	}

	/**
	 * Define el valor de la propiedad
	 * acusticaRuidointeriorhorizontalesGarajeOtros.
	 * 
	 * @param value
	 *            allowed object is
	 *            {@link AcusticaRuidointeriorhorizontalesGarajeOtrosType }
	 * 
	 */
	public void setAcusticaRuidointeriorhorizontalesGarajeOtros(AcusticaRuidointeriorhorizontalesGarajeOtrosType value) {
		this.acusticaRuidointeriorhorizontalesGarajeOtros = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * acusticaRuidointeriorhorizontalesTipoOtros.
	 * 
	 * @return possible object is
	 *         {@link AcusticaRuidointeriorhorizontalesTipoOtrosType }
	 * 
	 */
	@ManyToOne(targetEntity = AcusticaRuidointeriorhorizontalesTipoOtrosType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "ACUSTICA_RUIDOINTERIORHORIZONTALES_TIPO_OTROS_AED_ACU_RUIINTHOR_HJID")
	public AcusticaRuidointeriorhorizontalesTipoOtrosType getAcusticaRuidointeriorhorizontalesTipoOtros() {
		return acusticaRuidointeriorhorizontalesTipoOtros;
	}

	/**
	 * Define el valor de la propiedad
	 * acusticaRuidointeriorhorizontalesTipoOtros.
	 * 
	 * @param value
	 *            allowed object is
	 *            {@link AcusticaRuidointeriorhorizontalesTipoOtrosType }
	 * 
	 */
	public void setAcusticaRuidointeriorhorizontalesTipoOtros(AcusticaRuidointeriorhorizontalesTipoOtrosType value) {
		this.acusticaRuidointeriorhorizontalesTipoOtros = value;
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
		final AcusticaRuidointeriorhorizontalesType that = ((AcusticaRuidointeriorhorizontalesType) object);
		{
			String lhsPlantatipoCantoForjado;
			lhsPlantatipoCantoForjado = this.getPlantatipoCantoForjado();
			String rhsPlantatipoCantoForjado;
			rhsPlantatipoCantoForjado = that.getPlantatipoCantoForjado();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "plantatipoCantoForjado", lhsPlantatipoCantoForjado), LocatorUtils.property(thatLocator, "plantatipoCantoForjado", rhsPlantatipoCantoForjado), lhsPlantatipoCantoForjado, rhsPlantatipoCantoForjado)) {
				return false;
			}
		}
		{
			String lhsPlantagarajeCantoForjado;
			lhsPlantagarajeCantoForjado = this.getPlantagarajeCantoForjado();
			String rhsPlantagarajeCantoForjado;
			rhsPlantagarajeCantoForjado = that.getPlantagarajeCantoForjado();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "plantagarajeCantoForjado", lhsPlantagarajeCantoForjado), LocatorUtils.property(thatLocator, "plantagarajeCantoForjado", rhsPlantagarajeCantoForjado), lhsPlantagarajeCantoForjado, rhsPlantagarajeCantoForjado)) {
				return false;
			}
		}
		{
			String lhsForjadoPlantatipoOtro;
			lhsForjadoPlantatipoOtro = this.getForjadoPlantatipoOtro();
			String rhsForjadoPlantatipoOtro;
			rhsForjadoPlantatipoOtro = that.getForjadoPlantatipoOtro();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "forjadoPlantatipoOtro", lhsForjadoPlantatipoOtro), LocatorUtils.property(thatLocator, "forjadoPlantatipoOtro", rhsForjadoPlantatipoOtro), lhsForjadoPlantatipoOtro, rhsForjadoPlantatipoOtro)) {
				return false;
			}
		}
		{
			String lhsForjadoPlantagarajeOtro;
			lhsForjadoPlantagarajeOtro = this.getForjadoPlantagarajeOtro();
			String rhsForjadoPlantagarajeOtro;
			rhsForjadoPlantagarajeOtro = that.getForjadoPlantagarajeOtro();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "forjadoPlantagarajeOtro", lhsForjadoPlantagarajeOtro), LocatorUtils.property(thatLocator, "forjadoPlantagarajeOtro", rhsForjadoPlantagarajeOtro), lhsForjadoPlantagarajeOtro, rhsForjadoPlantagarajeOtro)) {
				return false;
			}
		}
		{
			int lhsSueloFlotanteTiene;
			lhsSueloFlotanteTiene = this.getSueloFlotanteTiene();
			int rhsSueloFlotanteTiene;
			rhsSueloFlotanteTiene = that.getSueloFlotanteTiene();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "sueloFlotanteTiene", lhsSueloFlotanteTiene), LocatorUtils.property(thatLocator, "sueloFlotanteTiene", rhsSueloFlotanteTiene), lhsSueloFlotanteTiene, rhsSueloFlotanteTiene)) {
				return false;
			}
		}
		{
			int lhsTechoSuspendidoTiene;
			lhsTechoSuspendidoTiene = this.getTechoSuspendidoTiene();
			int rhsTechoSuspendidoTiene;
			rhsTechoSuspendidoTiene = that.getTechoSuspendidoTiene();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "techoSuspendidoTiene", lhsTechoSuspendidoTiene), LocatorUtils.property(thatLocator, "techoSuspendidoTiene", rhsTechoSuspendidoTiene), lhsTechoSuspendidoTiene, rhsTechoSuspendidoTiene)) {
				return false;
			}
		}
		{
			int lhsEstadoBueno;
			lhsEstadoBueno = this.getEstadoBueno();
			int rhsEstadoBueno;
			rhsEstadoBueno = that.getEstadoBueno();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "estadoBueno", lhsEstadoBueno), LocatorUtils.property(thatLocator, "estadoBueno", rhsEstadoBueno), lhsEstadoBueno, rhsEstadoBueno)) {
				return false;
			}
		}
		{
			String lhsDeficienciasObservaciones;
			lhsDeficienciasObservaciones = this.getDeficienciasObservaciones();
			String rhsDeficienciasObservaciones;
			rhsDeficienciasObservaciones = that.getDeficienciasObservaciones();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "deficienciasObservaciones", lhsDeficienciasObservaciones), LocatorUtils.property(thatLocator, "deficienciasObservaciones", rhsDeficienciasObservaciones), lhsDeficienciasObservaciones, rhsDeficienciasObservaciones)) {
				return false;
			}
		}
		{
			int lhsCaracteristicasSueloFlotanteRevestidas;
			lhsCaracteristicasSueloFlotanteRevestidas = this.getCaracteristicasSueloFlotanteRevestidas();
			int rhsCaracteristicasSueloFlotanteRevestidas;
			rhsCaracteristicasSueloFlotanteRevestidas = that.getCaracteristicasSueloFlotanteRevestidas();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "caracteristicasSueloFlotanteRevestidas", lhsCaracteristicasSueloFlotanteRevestidas), LocatorUtils.property(thatLocator, "caracteristicasSueloFlotanteRevestidas", rhsCaracteristicasSueloFlotanteRevestidas), lhsCaracteristicasSueloFlotanteRevestidas, rhsCaracteristicasSueloFlotanteRevestidas)) {
				return false;
			}
		}
		{
			int lhsCaracteristicasSueloFlotanteContactoDirecto;
			lhsCaracteristicasSueloFlotanteContactoDirecto = this.getCaracteristicasSueloFlotanteContactoDirecto();
			int rhsCaracteristicasSueloFlotanteContactoDirecto;
			rhsCaracteristicasSueloFlotanteContactoDirecto = that.getCaracteristicasSueloFlotanteContactoDirecto();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "caracteristicasSueloFlotanteContactoDirecto", lhsCaracteristicasSueloFlotanteContactoDirecto), LocatorUtils.property(thatLocator, "caracteristicasSueloFlotanteContactoDirecto", rhsCaracteristicasSueloFlotanteContactoDirecto), lhsCaracteristicasSueloFlotanteContactoDirecto, rhsCaracteristicasSueloFlotanteContactoDirecto)) {
				return false;
			}
		}
		{
			int lhsCaracteristicasCamaraAireContinua;
			lhsCaracteristicasCamaraAireContinua = this.getCaracteristicasCamaraAireContinua();
			int rhsCaracteristicasCamaraAireContinua;
			rhsCaracteristicasCamaraAireContinua = that.getCaracteristicasCamaraAireContinua();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "caracteristicasCamaraAireContinua", lhsCaracteristicasCamaraAireContinua), LocatorUtils.property(thatLocator, "caracteristicasCamaraAireContinua", rhsCaracteristicasCamaraAireContinua), lhsCaracteristicasCamaraAireContinua, rhsCaracteristicasCamaraAireContinua)) {
				return false;
			}
		}
		{
			int lhsCaracteristicasLuminariasEmpotradasSelladas;
			lhsCaracteristicasLuminariasEmpotradasSelladas = this.getCaracteristicasLuminariasEmpotradasSelladas();
			int rhsCaracteristicasLuminariasEmpotradasSelladas;
			rhsCaracteristicasLuminariasEmpotradasSelladas = that.getCaracteristicasLuminariasEmpotradasSelladas();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "caracteristicasLuminariasEmpotradasSelladas", lhsCaracteristicasLuminariasEmpotradasSelladas), LocatorUtils.property(thatLocator, "caracteristicasLuminariasEmpotradasSelladas", rhsCaracteristicasLuminariasEmpotradasSelladas), lhsCaracteristicasLuminariasEmpotradasSelladas, rhsCaracteristicasLuminariasEmpotradasSelladas)) {
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
			AcusticaRuidointeriorhorizontalesSueloflotanteTiposType lhsAcusticaRuidointeriorhorizontalesSueloflotanteTipos;
			lhsAcusticaRuidointeriorhorizontalesSueloflotanteTipos = this.getAcusticaRuidointeriorhorizontalesSueloflotanteTipos();
			AcusticaRuidointeriorhorizontalesSueloflotanteTiposType rhsAcusticaRuidointeriorhorizontalesSueloflotanteTipos;
			rhsAcusticaRuidointeriorhorizontalesSueloflotanteTipos = that.getAcusticaRuidointeriorhorizontalesSueloflotanteTipos();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "acusticaRuidointeriorhorizontalesSueloflotanteTipos", lhsAcusticaRuidointeriorhorizontalesSueloflotanteTipos), LocatorUtils.property(thatLocator, "acusticaRuidointeriorhorizontalesSueloflotanteTipos", rhsAcusticaRuidointeriorhorizontalesSueloflotanteTipos), lhsAcusticaRuidointeriorhorizontalesSueloflotanteTipos, rhsAcusticaRuidointeriorhorizontalesSueloflotanteTipos)) {
				return false;
			}
		}
		{
			AcusticaRuidointeriorhorizontalesSueloflotanteCaracteristicasType lhsAcusticaRuidointeriorhorizontalesSueloflotanteCaracteristicas;
			lhsAcusticaRuidointeriorhorizontalesSueloflotanteCaracteristicas = this.getAcusticaRuidointeriorhorizontalesSueloflotanteCaracteristicas();
			AcusticaRuidointeriorhorizontalesSueloflotanteCaracteristicasType rhsAcusticaRuidointeriorhorizontalesSueloflotanteCaracteristicas;
			rhsAcusticaRuidointeriorhorizontalesSueloflotanteCaracteristicas = that.getAcusticaRuidointeriorhorizontalesSueloflotanteCaracteristicas();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "acusticaRuidointeriorhorizontalesSueloflotanteCaracteristicas", lhsAcusticaRuidointeriorhorizontalesSueloflotanteCaracteristicas), LocatorUtils.property(thatLocator, "acusticaRuidointeriorhorizontalesSueloflotanteCaracteristicas", rhsAcusticaRuidointeriorhorizontalesSueloflotanteCaracteristicas), lhsAcusticaRuidointeriorhorizontalesSueloflotanteCaracteristicas, rhsAcusticaRuidointeriorhorizontalesSueloflotanteCaracteristicas)) {
				return false;
			}
		}
		{
			AcusticaRuidointeriorhorizontalesTechoTiposType lhsAcusticaRuidointeriorhorizontalesTechoTipos;
			lhsAcusticaRuidointeriorhorizontalesTechoTipos = this.getAcusticaRuidointeriorhorizontalesTechoTipos();
			AcusticaRuidointeriorhorizontalesTechoTiposType rhsAcusticaRuidointeriorhorizontalesTechoTipos;
			rhsAcusticaRuidointeriorhorizontalesTechoTipos = that.getAcusticaRuidointeriorhorizontalesTechoTipos();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "acusticaRuidointeriorhorizontalesTechoTipos", lhsAcusticaRuidointeriorhorizontalesTechoTipos), LocatorUtils.property(thatLocator, "acusticaRuidointeriorhorizontalesTechoTipos", rhsAcusticaRuidointeriorhorizontalesTechoTipos), lhsAcusticaRuidointeriorhorizontalesTechoTipos, rhsAcusticaRuidointeriorhorizontalesTechoTipos)) {
				return false;
			}
		}
		{
			AcusticaRuidointeriorhorizontalesTechoCaracteristicasType lhsAcusticaRuidointeriorhorizontalesTechoCaracteristicas;
			lhsAcusticaRuidointeriorhorizontalesTechoCaracteristicas = this.getAcusticaRuidointeriorhorizontalesTechoCaracteristicas();
			AcusticaRuidointeriorhorizontalesTechoCaracteristicasType rhsAcusticaRuidointeriorhorizontalesTechoCaracteristicas;
			rhsAcusticaRuidointeriorhorizontalesTechoCaracteristicas = that.getAcusticaRuidointeriorhorizontalesTechoCaracteristicas();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "acusticaRuidointeriorhorizontalesTechoCaracteristicas", lhsAcusticaRuidointeriorhorizontalesTechoCaracteristicas), LocatorUtils.property(thatLocator, "acusticaRuidointeriorhorizontalesTechoCaracteristicas", rhsAcusticaRuidointeriorhorizontalesTechoCaracteristicas), lhsAcusticaRuidointeriorhorizontalesTechoCaracteristicas, rhsAcusticaRuidointeriorhorizontalesTechoCaracteristicas)) {
				return false;
			}
		}
		{
			AcusticaRuidointeriorhorizontalesGarajeEstructuraprincipalType lhsAcusticaRuidointeriorhorizontalesGarajeEstructuraprincipal;
			lhsAcusticaRuidointeriorhorizontalesGarajeEstructuraprincipal = this.getAcusticaRuidointeriorhorizontalesGarajeEstructuraprincipal();
			AcusticaRuidointeriorhorizontalesGarajeEstructuraprincipalType rhsAcusticaRuidointeriorhorizontalesGarajeEstructuraprincipal;
			rhsAcusticaRuidointeriorhorizontalesGarajeEstructuraprincipal = that.getAcusticaRuidointeriorhorizontalesGarajeEstructuraprincipal();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "acusticaRuidointeriorhorizontalesGarajeEstructuraprincipal", lhsAcusticaRuidointeriorhorizontalesGarajeEstructuraprincipal), LocatorUtils.property(thatLocator, "acusticaRuidointeriorhorizontalesGarajeEstructuraprincipal", rhsAcusticaRuidointeriorhorizontalesGarajeEstructuraprincipal), lhsAcusticaRuidointeriorhorizontalesGarajeEstructuraprincipal, rhsAcusticaRuidointeriorhorizontalesGarajeEstructuraprincipal)) {
				return false;
			}
		}
		{
			AcusticaRuidointeriorhorizontalesTipoEstructuraprincipalType lhsAcusticaRuidointeriorhorizontalesTipoEstructuraprincipal;
			lhsAcusticaRuidointeriorhorizontalesTipoEstructuraprincipal = this.getAcusticaRuidointeriorhorizontalesTipoEstructuraprincipal();
			AcusticaRuidointeriorhorizontalesTipoEstructuraprincipalType rhsAcusticaRuidointeriorhorizontalesTipoEstructuraprincipal;
			rhsAcusticaRuidointeriorhorizontalesTipoEstructuraprincipal = that.getAcusticaRuidointeriorhorizontalesTipoEstructuraprincipal();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "acusticaRuidointeriorhorizontalesTipoEstructuraprincipal", lhsAcusticaRuidointeriorhorizontalesTipoEstructuraprincipal), LocatorUtils.property(thatLocator, "acusticaRuidointeriorhorizontalesTipoEstructuraprincipal", rhsAcusticaRuidointeriorhorizontalesTipoEstructuraprincipal), lhsAcusticaRuidointeriorhorizontalesTipoEstructuraprincipal, rhsAcusticaRuidointeriorhorizontalesTipoEstructuraprincipal)) {
				return false;
			}
		}
		{
			AcusticaRuidointeriorhorizontalesGarajeForjadosecundarioType lhsAcusticaRuidointeriorhorizontalesGarajeForjadosecundario;
			lhsAcusticaRuidointeriorhorizontalesGarajeForjadosecundario = this.getAcusticaRuidointeriorhorizontalesGarajeForjadosecundario();
			AcusticaRuidointeriorhorizontalesGarajeForjadosecundarioType rhsAcusticaRuidointeriorhorizontalesGarajeForjadosecundario;
			rhsAcusticaRuidointeriorhorizontalesGarajeForjadosecundario = that.getAcusticaRuidointeriorhorizontalesGarajeForjadosecundario();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "acusticaRuidointeriorhorizontalesGarajeForjadosecundario", lhsAcusticaRuidointeriorhorizontalesGarajeForjadosecundario), LocatorUtils.property(thatLocator, "acusticaRuidointeriorhorizontalesGarajeForjadosecundario", rhsAcusticaRuidointeriorhorizontalesGarajeForjadosecundario), lhsAcusticaRuidointeriorhorizontalesGarajeForjadosecundario, rhsAcusticaRuidointeriorhorizontalesGarajeForjadosecundario)) {
				return false;
			}
		}
		{
			AcusticaRuidointeriorhorizontalesTipoForjadosecundarioType lhsAcusticaRuidointeriorhorizontalesTipoForjadosecundario;
			lhsAcusticaRuidointeriorhorizontalesTipoForjadosecundario = this.getAcusticaRuidointeriorhorizontalesTipoForjadosecundario();
			AcusticaRuidointeriorhorizontalesTipoForjadosecundarioType rhsAcusticaRuidointeriorhorizontalesTipoForjadosecundario;
			rhsAcusticaRuidointeriorhorizontalesTipoForjadosecundario = that.getAcusticaRuidointeriorhorizontalesTipoForjadosecundario();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "acusticaRuidointeriorhorizontalesTipoForjadosecundario", lhsAcusticaRuidointeriorhorizontalesTipoForjadosecundario), LocatorUtils.property(thatLocator, "acusticaRuidointeriorhorizontalesTipoForjadosecundario", rhsAcusticaRuidointeriorhorizontalesTipoForjadosecundario), lhsAcusticaRuidointeriorhorizontalesTipoForjadosecundario, rhsAcusticaRuidointeriorhorizontalesTipoForjadosecundario)) {
				return false;
			}
		}
		{
			AcusticaRuidointeriorhorizontalesGarajeForjadoentrevigadoType lhsAcusticaRuidointeriorhorizontalesGarajeForjadoentrevigado;
			lhsAcusticaRuidointeriorhorizontalesGarajeForjadoentrevigado = this.getAcusticaRuidointeriorhorizontalesGarajeForjadoentrevigado();
			AcusticaRuidointeriorhorizontalesGarajeForjadoentrevigadoType rhsAcusticaRuidointeriorhorizontalesGarajeForjadoentrevigado;
			rhsAcusticaRuidointeriorhorizontalesGarajeForjadoentrevigado = that.getAcusticaRuidointeriorhorizontalesGarajeForjadoentrevigado();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "acusticaRuidointeriorhorizontalesGarajeForjadoentrevigado", lhsAcusticaRuidointeriorhorizontalesGarajeForjadoentrevigado), LocatorUtils.property(thatLocator, "acusticaRuidointeriorhorizontalesGarajeForjadoentrevigado", rhsAcusticaRuidointeriorhorizontalesGarajeForjadoentrevigado), lhsAcusticaRuidointeriorhorizontalesGarajeForjadoentrevigado, rhsAcusticaRuidointeriorhorizontalesGarajeForjadoentrevigado)) {
				return false;
			}
		}
		{
			AcusticaRuidointeriorhorizontalesTipoForjadoentrevigadoType lhsAcusticaRuidointeriorhorizontalesTipoForjadoentrevigado;
			lhsAcusticaRuidointeriorhorizontalesTipoForjadoentrevigado = this.getAcusticaRuidointeriorhorizontalesTipoForjadoentrevigado();
			AcusticaRuidointeriorhorizontalesTipoForjadoentrevigadoType rhsAcusticaRuidointeriorhorizontalesTipoForjadoentrevigado;
			rhsAcusticaRuidointeriorhorizontalesTipoForjadoentrevigado = that.getAcusticaRuidointeriorhorizontalesTipoForjadoentrevigado();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "acusticaRuidointeriorhorizontalesTipoForjadoentrevigado", lhsAcusticaRuidointeriorhorizontalesTipoForjadoentrevigado), LocatorUtils.property(thatLocator, "acusticaRuidointeriorhorizontalesTipoForjadoentrevigado", rhsAcusticaRuidointeriorhorizontalesTipoForjadoentrevigado), lhsAcusticaRuidointeriorhorizontalesTipoForjadoentrevigado, rhsAcusticaRuidointeriorhorizontalesTipoForjadoentrevigado)) {
				return false;
			}
		}
		{
			AcusticaRuidointeriorhorizontalesGarajeOtrosType lhsAcusticaRuidointeriorhorizontalesGarajeOtros;
			lhsAcusticaRuidointeriorhorizontalesGarajeOtros = this.getAcusticaRuidointeriorhorizontalesGarajeOtros();
			AcusticaRuidointeriorhorizontalesGarajeOtrosType rhsAcusticaRuidointeriorhorizontalesGarajeOtros;
			rhsAcusticaRuidointeriorhorizontalesGarajeOtros = that.getAcusticaRuidointeriorhorizontalesGarajeOtros();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "acusticaRuidointeriorhorizontalesGarajeOtros", lhsAcusticaRuidointeriorhorizontalesGarajeOtros), LocatorUtils.property(thatLocator, "acusticaRuidointeriorhorizontalesGarajeOtros", rhsAcusticaRuidointeriorhorizontalesGarajeOtros), lhsAcusticaRuidointeriorhorizontalesGarajeOtros, rhsAcusticaRuidointeriorhorizontalesGarajeOtros)) {
				return false;
			}
		}
		{
			AcusticaRuidointeriorhorizontalesTipoOtrosType lhsAcusticaRuidointeriorhorizontalesTipoOtros;
			lhsAcusticaRuidointeriorhorizontalesTipoOtros = this.getAcusticaRuidointeriorhorizontalesTipoOtros();
			AcusticaRuidointeriorhorizontalesTipoOtrosType rhsAcusticaRuidointeriorhorizontalesTipoOtros;
			rhsAcusticaRuidointeriorhorizontalesTipoOtros = that.getAcusticaRuidointeriorhorizontalesTipoOtros();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "acusticaRuidointeriorhorizontalesTipoOtros", lhsAcusticaRuidointeriorhorizontalesTipoOtros), LocatorUtils.property(thatLocator, "acusticaRuidointeriorhorizontalesTipoOtros", rhsAcusticaRuidointeriorhorizontalesTipoOtros), lhsAcusticaRuidointeriorhorizontalesTipoOtros, rhsAcusticaRuidointeriorhorizontalesTipoOtros)) {
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
			String thePlantatipoCantoForjado;
			thePlantatipoCantoForjado = this.getPlantatipoCantoForjado();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "plantatipoCantoForjado", thePlantatipoCantoForjado), currentHashCode, thePlantatipoCantoForjado);
		}
		{
			String thePlantagarajeCantoForjado;
			thePlantagarajeCantoForjado = this.getPlantagarajeCantoForjado();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "plantagarajeCantoForjado", thePlantagarajeCantoForjado), currentHashCode, thePlantagarajeCantoForjado);
		}
		{
			String theForjadoPlantatipoOtro;
			theForjadoPlantatipoOtro = this.getForjadoPlantatipoOtro();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "forjadoPlantatipoOtro", theForjadoPlantatipoOtro), currentHashCode, theForjadoPlantatipoOtro);
		}
		{
			String theForjadoPlantagarajeOtro;
			theForjadoPlantagarajeOtro = this.getForjadoPlantagarajeOtro();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "forjadoPlantagarajeOtro", theForjadoPlantagarajeOtro), currentHashCode, theForjadoPlantagarajeOtro);
		}
		{
			int theSueloFlotanteTiene;
			theSueloFlotanteTiene = this.getSueloFlotanteTiene();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "sueloFlotanteTiene", theSueloFlotanteTiene), currentHashCode, theSueloFlotanteTiene);
		}
		{
			int theTechoSuspendidoTiene;
			theTechoSuspendidoTiene = this.getTechoSuspendidoTiene();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "techoSuspendidoTiene", theTechoSuspendidoTiene), currentHashCode, theTechoSuspendidoTiene);
		}
		{
			int theEstadoBueno;
			theEstadoBueno = this.getEstadoBueno();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "estadoBueno", theEstadoBueno), currentHashCode, theEstadoBueno);
		}
		{
			String theDeficienciasObservaciones;
			theDeficienciasObservaciones = this.getDeficienciasObservaciones();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "deficienciasObservaciones", theDeficienciasObservaciones), currentHashCode, theDeficienciasObservaciones);
		}
		{
			int theCaracteristicasSueloFlotanteRevestidas;
			theCaracteristicasSueloFlotanteRevestidas = this.getCaracteristicasSueloFlotanteRevestidas();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "caracteristicasSueloFlotanteRevestidas", theCaracteristicasSueloFlotanteRevestidas), currentHashCode, theCaracteristicasSueloFlotanteRevestidas);
		}
		{
			int theCaracteristicasSueloFlotanteContactoDirecto;
			theCaracteristicasSueloFlotanteContactoDirecto = this.getCaracteristicasSueloFlotanteContactoDirecto();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "caracteristicasSueloFlotanteContactoDirecto", theCaracteristicasSueloFlotanteContactoDirecto), currentHashCode, theCaracteristicasSueloFlotanteContactoDirecto);
		}
		{
			int theCaracteristicasCamaraAireContinua;
			theCaracteristicasCamaraAireContinua = this.getCaracteristicasCamaraAireContinua();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "caracteristicasCamaraAireContinua", theCaracteristicasCamaraAireContinua), currentHashCode, theCaracteristicasCamaraAireContinua);
		}
		{
			int theCaracteristicasLuminariasEmpotradasSelladas;
			theCaracteristicasLuminariasEmpotradasSelladas = this.getCaracteristicasLuminariasEmpotradasSelladas();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "caracteristicasLuminariasEmpotradasSelladas", theCaracteristicasLuminariasEmpotradasSelladas), currentHashCode, theCaracteristicasLuminariasEmpotradasSelladas);
		}
		{
			String theObservaciones;
			theObservaciones = this.getObservaciones();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "observaciones", theObservaciones), currentHashCode, theObservaciones);
		}
		{
			AcusticaRuidointeriorhorizontalesSueloflotanteTiposType theAcusticaRuidointeriorhorizontalesSueloflotanteTipos;
			theAcusticaRuidointeriorhorizontalesSueloflotanteTipos = this.getAcusticaRuidointeriorhorizontalesSueloflotanteTipos();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "acusticaRuidointeriorhorizontalesSueloflotanteTipos", theAcusticaRuidointeriorhorizontalesSueloflotanteTipos), currentHashCode, theAcusticaRuidointeriorhorizontalesSueloflotanteTipos);
		}
		{
			AcusticaRuidointeriorhorizontalesSueloflotanteCaracteristicasType theAcusticaRuidointeriorhorizontalesSueloflotanteCaracteristicas;
			theAcusticaRuidointeriorhorizontalesSueloflotanteCaracteristicas = this.getAcusticaRuidointeriorhorizontalesSueloflotanteCaracteristicas();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "acusticaRuidointeriorhorizontalesSueloflotanteCaracteristicas", theAcusticaRuidointeriorhorizontalesSueloflotanteCaracteristicas), currentHashCode, theAcusticaRuidointeriorhorizontalesSueloflotanteCaracteristicas);
		}
		{
			AcusticaRuidointeriorhorizontalesTechoTiposType theAcusticaRuidointeriorhorizontalesTechoTipos;
			theAcusticaRuidointeriorhorizontalesTechoTipos = this.getAcusticaRuidointeriorhorizontalesTechoTipos();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "acusticaRuidointeriorhorizontalesTechoTipos", theAcusticaRuidointeriorhorizontalesTechoTipos), currentHashCode, theAcusticaRuidointeriorhorizontalesTechoTipos);
		}
		{
			AcusticaRuidointeriorhorizontalesTechoCaracteristicasType theAcusticaRuidointeriorhorizontalesTechoCaracteristicas;
			theAcusticaRuidointeriorhorizontalesTechoCaracteristicas = this.getAcusticaRuidointeriorhorizontalesTechoCaracteristicas();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "acusticaRuidointeriorhorizontalesTechoCaracteristicas", theAcusticaRuidointeriorhorizontalesTechoCaracteristicas), currentHashCode, theAcusticaRuidointeriorhorizontalesTechoCaracteristicas);
		}
		{
			AcusticaRuidointeriorhorizontalesGarajeEstructuraprincipalType theAcusticaRuidointeriorhorizontalesGarajeEstructuraprincipal;
			theAcusticaRuidointeriorhorizontalesGarajeEstructuraprincipal = this.getAcusticaRuidointeriorhorizontalesGarajeEstructuraprincipal();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "acusticaRuidointeriorhorizontalesGarajeEstructuraprincipal", theAcusticaRuidointeriorhorizontalesGarajeEstructuraprincipal), currentHashCode, theAcusticaRuidointeriorhorizontalesGarajeEstructuraprincipal);
		}
		{
			AcusticaRuidointeriorhorizontalesTipoEstructuraprincipalType theAcusticaRuidointeriorhorizontalesTipoEstructuraprincipal;
			theAcusticaRuidointeriorhorizontalesTipoEstructuraprincipal = this.getAcusticaRuidointeriorhorizontalesTipoEstructuraprincipal();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "acusticaRuidointeriorhorizontalesTipoEstructuraprincipal", theAcusticaRuidointeriorhorizontalesTipoEstructuraprincipal), currentHashCode, theAcusticaRuidointeriorhorizontalesTipoEstructuraprincipal);
		}
		{
			AcusticaRuidointeriorhorizontalesGarajeForjadosecundarioType theAcusticaRuidointeriorhorizontalesGarajeForjadosecundario;
			theAcusticaRuidointeriorhorizontalesGarajeForjadosecundario = this.getAcusticaRuidointeriorhorizontalesGarajeForjadosecundario();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "acusticaRuidointeriorhorizontalesGarajeForjadosecundario", theAcusticaRuidointeriorhorizontalesGarajeForjadosecundario), currentHashCode, theAcusticaRuidointeriorhorizontalesGarajeForjadosecundario);
		}
		{
			AcusticaRuidointeriorhorizontalesTipoForjadosecundarioType theAcusticaRuidointeriorhorizontalesTipoForjadosecundario;
			theAcusticaRuidointeriorhorizontalesTipoForjadosecundario = this.getAcusticaRuidointeriorhorizontalesTipoForjadosecundario();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "acusticaRuidointeriorhorizontalesTipoForjadosecundario", theAcusticaRuidointeriorhorizontalesTipoForjadosecundario), currentHashCode, theAcusticaRuidointeriorhorizontalesTipoForjadosecundario);
		}
		{
			AcusticaRuidointeriorhorizontalesGarajeForjadoentrevigadoType theAcusticaRuidointeriorhorizontalesGarajeForjadoentrevigado;
			theAcusticaRuidointeriorhorizontalesGarajeForjadoentrevigado = this.getAcusticaRuidointeriorhorizontalesGarajeForjadoentrevigado();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "acusticaRuidointeriorhorizontalesGarajeForjadoentrevigado", theAcusticaRuidointeriorhorizontalesGarajeForjadoentrevigado), currentHashCode, theAcusticaRuidointeriorhorizontalesGarajeForjadoentrevigado);
		}
		{
			AcusticaRuidointeriorhorizontalesTipoForjadoentrevigadoType theAcusticaRuidointeriorhorizontalesTipoForjadoentrevigado;
			theAcusticaRuidointeriorhorizontalesTipoForjadoentrevigado = this.getAcusticaRuidointeriorhorizontalesTipoForjadoentrevigado();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "acusticaRuidointeriorhorizontalesTipoForjadoentrevigado", theAcusticaRuidointeriorhorizontalesTipoForjadoentrevigado), currentHashCode, theAcusticaRuidointeriorhorizontalesTipoForjadoentrevigado);
		}
		{
			AcusticaRuidointeriorhorizontalesGarajeOtrosType theAcusticaRuidointeriorhorizontalesGarajeOtros;
			theAcusticaRuidointeriorhorizontalesGarajeOtros = this.getAcusticaRuidointeriorhorizontalesGarajeOtros();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "acusticaRuidointeriorhorizontalesGarajeOtros", theAcusticaRuidointeriorhorizontalesGarajeOtros), currentHashCode, theAcusticaRuidointeriorhorizontalesGarajeOtros);
		}
		{
			AcusticaRuidointeriorhorizontalesTipoOtrosType theAcusticaRuidointeriorhorizontalesTipoOtros;
			theAcusticaRuidointeriorhorizontalesTipoOtros = this.getAcusticaRuidointeriorhorizontalesTipoOtros();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "acusticaRuidointeriorhorizontalesTipoOtros", theAcusticaRuidointeriorhorizontalesTipoOtros), currentHashCode, theAcusticaRuidointeriorhorizontalesTipoOtros);
		}
		return currentHashCode;
	}

	public int hashCode() {
		final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
		return this.hashCode(null, strategy);
	}

}
