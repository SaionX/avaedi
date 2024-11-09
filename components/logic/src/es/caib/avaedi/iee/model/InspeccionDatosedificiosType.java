//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.11 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2016.09.08 a las 10:32:16 PM CEST 
//

package es.caib.avaedi.iee.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.jvnet.jaxb2_commons.lang.Equals;
import org.jvnet.jaxb2_commons.lang.EqualsStrategy;
import org.jvnet.jaxb2_commons.lang.HashCode;
import org.jvnet.jaxb2_commons.lang.HashCodeStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBEqualsStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBHashCodeStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;
import org.jvnet.jaxb2_commons.locator.util.LocatorUtils;

import es.caib.avaedi.logic.util.BigDecimalFormatter;

/**
 * <p>
 * Clase Java para inspeccion_datosedificiosType complex type.
 * 
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que
 * haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="inspeccion_datosedificiosType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="inspeccion_datosedificio_uso_tipo_id"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int"&gt;
 *               &lt;enumeration value="1"/&gt;
 *               &lt;enumeration value="2"/&gt;
 *               &lt;enumeration value="3"/&gt;
 *               &lt;enumeration value="4"/&gt;
 *               &lt;enumeration value="5"/&gt;
 *               &lt;enumeration value="6"/&gt;
 *               &lt;enumeration value="7"/&gt;
 *               &lt;enumeration value="8"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="uso_texto" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="ano_construccion" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="ano_construccion_referencia" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="ano_rehabilitacion" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="ano_rehabilitacion_referencia" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="superficie_parcela" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="superficie_construida" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="altura_sobre_rasante" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="plantas_sobre_rasante_uso_principal" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="plantas_sobre_rasante_usos_secundarios" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="plantas_sobre_rasante_usos_secundarios_tipo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="plantas_bajo_rasante_uso_principal" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="plantas_bajo_rasante_usos_secundarios" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="plantas_bajo_rasante_usos_secundarios_tipo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="num_viviendas" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="superficie_media_viviendas" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="num_locales" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="superficie_media_locales" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="num_aparcamientos" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="superficie_media_aparcamientos" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="num_trasteros" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="superficie_media_trasteros" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="inspeccion_datosedificio_parcela_tipo_id"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int"&gt;
 *               &lt;enumeration value="1"/&gt;
 *               &lt;enumeration value="2"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="inspeccion_datosedificio_nucleosescaleras_tipo_id"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int"&gt;
 *               &lt;enumeration value="1"/&gt;
 *               &lt;enumeration value="2"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="inspeccion_datosedificio_unnucleoescaleras_tipo_id"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int"&gt;
 *               &lt;enumeration value="1"/&gt;
 *               &lt;enumeration value="2"/&gt;
 *               &lt;enumeration value="3"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="total_escaleras" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="total_ascensores" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="total_viviendas_con_acceso_varios_nucleos" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="total_viviendas_sin_acceso_ascensor" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="media_viviendas_por_planta" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "inspeccion_datosedificiosType", propOrder = { "inspeccionDatosedificioUsoTipoId", "usoTexto", "anoConstruccion", "anoConstruccionReferencia", "anoRehabilitacion", "anoRehabilitacionReferencia", "superficieParcela", "superficieConstruida", "alturaSobreRasante", "plantasSobreRasanteUsoPrincipal", "plantasSobreRasanteUsosSecundarios", "plantasSobreRasanteUsosSecundariosTipo", "plantasBajoRasanteUsoPrincipal", "plantasBajoRasanteUsosSecundarios", "plantasBajoRasanteUsosSecundariosTipo", "numViviendas", "superficieMediaViviendas", "numLocales", "superficieMediaLocales", "numAparcamientos", "superficieMediaAparcamientos", "numTrasteros", "superficieMediaTrasteros", "inspeccionDatosedificioParcelaTipoId", "inspeccionDatosedificioNucleosescalerasTipoId", "inspeccionDatosedificioUnnucleoescalerasTipoId", "totalEscaleras", "totalAscensores", "totalViviendasConAccesoVariosNucleos", "totalViviendasSinAccesoAscensor", "mediaViviendasPorPlanta" })
@Embeddable
public class InspeccionDatosedificiosType implements Serializable, Equals, HashCode {

	@XmlElement(name = "inspeccion_datosedificio_uso_tipo_id")
	protected int inspeccionDatosedificioUsoTipoId;
	@XmlElement(name = "uso_texto", required = true)
	protected String usoTexto;
	@XmlElement(name = "ano_construccion")
	protected int anoConstruccion;
	@XmlElement(name = "ano_construccion_referencia", required = true)
	protected String anoConstruccionReferencia;
	@XmlElement(name = "ano_rehabilitacion")
	protected int anoRehabilitacion;
	@XmlElement(name = "ano_rehabilitacion_referencia", required = true)
	protected String anoRehabilitacionReferencia;
	@XmlElement(name = "superficie_parcela", required = true)
    @XmlJavaTypeAdapter(BigDecimalFormatter.class)
	protected BigDecimal superficieParcela;
	@XmlElement(name = "superficie_construida", required = true)
    @XmlJavaTypeAdapter(BigDecimalFormatter.class)
	protected BigDecimal superficieConstruida;
	@XmlElement(name = "altura_sobre_rasante", required = true)
    @XmlJavaTypeAdapter(BigDecimalFormatter.class)
	protected BigDecimal alturaSobreRasante;
	@XmlElement(name = "plantas_sobre_rasante_uso_principal")
	protected int plantasSobreRasanteUsoPrincipal;
	@XmlElement(name = "plantas_sobre_rasante_usos_secundarios")
	protected int plantasSobreRasanteUsosSecundarios;
	@XmlElement(name = "plantas_sobre_rasante_usos_secundarios_tipo", required = true)
	protected String plantasSobreRasanteUsosSecundariosTipo;
	@XmlElement(name = "plantas_bajo_rasante_uso_principal")
	protected int plantasBajoRasanteUsoPrincipal;
	@XmlElement(name = "plantas_bajo_rasante_usos_secundarios")
	protected int plantasBajoRasanteUsosSecundarios;
	@XmlElement(name = "plantas_bajo_rasante_usos_secundarios_tipo", required = true)
	protected String plantasBajoRasanteUsosSecundariosTipo;
	@XmlElement(name = "num_viviendas")
	protected int numViviendas;
	@XmlElement(name = "superficie_media_viviendas", required = true)
    @XmlJavaTypeAdapter(BigDecimalFormatter.class)
	protected BigDecimal superficieMediaViviendas;
	@XmlElement(name = "num_locales")
	protected int numLocales;
	@XmlElement(name = "superficie_media_locales", required = true)
    @XmlJavaTypeAdapter(BigDecimalFormatter.class)
	protected BigDecimal superficieMediaLocales;
	@XmlElement(name = "num_aparcamientos")
	protected int numAparcamientos;
	@XmlElement(name = "superficie_media_aparcamientos", required = true)
    @XmlJavaTypeAdapter(BigDecimalFormatter.class)
	protected BigDecimal superficieMediaAparcamientos;
	@XmlElement(name = "num_trasteros")
	protected int numTrasteros;
	@XmlElement(name = "superficie_media_trasteros", required = true)
    @XmlJavaTypeAdapter(BigDecimalFormatter.class)
	protected BigDecimal superficieMediaTrasteros;
	@XmlElement(name = "inspeccion_datosedificio_parcela_tipo_id")
	protected int inspeccionDatosedificioParcelaTipoId;
	@XmlElement(name = "inspeccion_datosedificio_nucleosescaleras_tipo_id")
	protected int inspeccionDatosedificioNucleosescalerasTipoId;
	@XmlElement(name = "inspeccion_datosedificio_unnucleoescaleras_tipo_id")
	protected int inspeccionDatosedificioUnnucleoescalerasTipoId;
	@XmlElement(name = "total_escaleras", required = true)
	protected String totalEscaleras;
	@XmlElement(name = "total_ascensores", required = true)
	protected String totalAscensores;
	@XmlElement(name = "total_viviendas_con_acceso_varios_nucleos", required = true)
	protected String totalViviendasConAccesoVariosNucleos;
	@XmlElement(name = "total_viviendas_sin_acceso_ascensor", required = true)
	protected String totalViviendasSinAccesoAscensor;
	@XmlElement(name = "media_viviendas_por_planta")
	protected int mediaViviendasPorPlanta;

	/**
	 * Obtiene el valor de la propiedad inspeccionDatosedificioUsoTipoId.
	 * 
	 */
	@Basic
	@Column(name = "INSPECCION_DATOSEDIFICIO_USO_TIPO_ID")
	public int getInspeccionDatosedificioUsoTipoId() {
		return inspeccionDatosedificioUsoTipoId;
	}

	/**
	 * Define el valor de la propiedad inspeccionDatosedificioUsoTipoId.
	 * 
	 */
	public void setInspeccionDatosedificioUsoTipoId(int value) {
		this.inspeccionDatosedificioUsoTipoId = value;
	}

	/**
	 * Obtiene el valor de la propiedad usoTexto.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "USO_TEXTO", length = 255)
	public String getUsoTexto() {
		return usoTexto;
	}

	/**
	 * Define el valor de la propiedad usoTexto.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setUsoTexto(String value) {
		this.usoTexto = value;
	}

	/**
	 * Obtiene el valor de la propiedad anoConstruccion.
	 * 
	 */
	@Basic
	@Column(name = "ANO_CONSTRUCCION", precision = 5, scale = 0)
	public int getAnoConstruccion() {
		return anoConstruccion;
	}

	/**
	 * Define el valor de la propiedad anoConstruccion.
	 * 
	 */
	public void setAnoConstruccion(int value) {
		this.anoConstruccion = value;
	}

	/**
	 * Obtiene el valor de la propiedad anoConstruccionReferencia.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "ANO_CONSTRUCCION_REFERENCIA", length = 255)
	public String getAnoConstruccionReferencia() {
		return anoConstruccionReferencia;
	}

	/**
	 * Define el valor de la propiedad anoConstruccionReferencia.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setAnoConstruccionReferencia(String value) {
		this.anoConstruccionReferencia = value;
	}

	/**
	 * Obtiene el valor de la propiedad anoRehabilitacion.
	 * 
	 */
	@Basic
	@Column(name = "ANO_REHABILITACION", precision = 5, scale = 0)
	public int getAnoRehabilitacion() {
		return anoRehabilitacion;
	}

	/**
	 * Define el valor de la propiedad anoRehabilitacion.
	 * 
	 */
	public void setAnoRehabilitacion(int value) {
		this.anoRehabilitacion = value;
	}

	/**
	 * Obtiene el valor de la propiedad anoRehabilitacionReferencia.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "ANO_REHABILITACION_REFERENCIA", length = 255)
	public String getAnoRehabilitacionReferencia() {
		return anoRehabilitacionReferencia;
	}

	/**
	 * Define el valor de la propiedad anoRehabilitacionReferencia.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setAnoRehabilitacionReferencia(String value) {
		this.anoRehabilitacionReferencia = value;
	}

	/**
	 * Obtiene el valor de la propiedad superficieParcela.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	@Basic
	@Column(name = "SUPERFICIE_PARCELA", precision = 20, scale = 10)
	public BigDecimal getSuperficieParcela() {
		return superficieParcela;
	}

	/**
	 * Define el valor de la propiedad superficieParcela.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setSuperficieParcela(BigDecimal value) {
		this.superficieParcela = value;
	}

	/**
	 * Obtiene el valor de la propiedad superficieConstruida.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	@Basic
	@Column(name = "SUPERFICIE_CONSTRUIDA", precision = 20, scale = 10)
	public BigDecimal getSuperficieConstruida() {
		return superficieConstruida;
	}

	/**
	 * Define el valor de la propiedad superficieConstruida.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setSuperficieConstruida(BigDecimal value) {
		this.superficieConstruida = value;
	}

	/**
	 * Obtiene el valor de la propiedad alturaSobreRasante.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	@Basic
	@Column(name = "ALTURA_SOBRE_RASANTE", precision = 20, scale = 10)
	public BigDecimal getAlturaSobreRasante() {
		return alturaSobreRasante;
	}

	/**
	 * Define el valor de la propiedad alturaSobreRasante.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setAlturaSobreRasante(BigDecimal value) {
		this.alturaSobreRasante = value;
	}

	/**
	 * Obtiene el valor de la propiedad plantasSobreRasanteUsoPrincipal.
	 * 
	 */
	@Basic
	@Column(name = "PLANTAS_SOBRE_RASANTE_USO_PRINCIPAL", precision = 10, scale = 0)
	public int getPlantasSobreRasanteUsoPrincipal() {
		return plantasSobreRasanteUsoPrincipal;
	}

	/**
	 * Define el valor de la propiedad plantasSobreRasanteUsoPrincipal.
	 * 
	 */
	public void setPlantasSobreRasanteUsoPrincipal(int value) {
		this.plantasSobreRasanteUsoPrincipal = value;
	}

	/**
	 * Obtiene el valor de la propiedad plantasSobreRasanteUsosSecundarios.
	 * 
	 */
	@Basic
	@Column(name = "PLANTAS_SOBRE_RASANTE_USOS_SECUNDARIOS", precision = 10, scale = 0)
	public int getPlantasSobreRasanteUsosSecundarios() {
		return plantasSobreRasanteUsosSecundarios;
	}

	/**
	 * Define el valor de la propiedad plantasSobreRasanteUsosSecundarios.
	 * 
	 */
	public void setPlantasSobreRasanteUsosSecundarios(int value) {
		this.plantasSobreRasanteUsosSecundarios = value;
	}

	/**
	 * Obtiene el valor de la propiedad plantasSobreRasanteUsosSecundariosTipo.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "PLANTAS_SOBRE_RASANTE_USOS_SECUNDARIOS_TIPO", length = 255)
	public String getPlantasSobreRasanteUsosSecundariosTipo() {
		return plantasSobreRasanteUsosSecundariosTipo;
	}

	/**
	 * Define el valor de la propiedad plantasSobreRasanteUsosSecundariosTipo.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPlantasSobreRasanteUsosSecundariosTipo(String value) {
		this.plantasSobreRasanteUsosSecundariosTipo = value;
	}

	/**
	 * Obtiene el valor de la propiedad plantasBajoRasanteUsoPrincipal.
	 * 
	 */
	@Basic
	@Column(name = "PLANTAS_BAJO_RASANTE_USO_PRINCIPAL", precision = 10, scale = 0)
	public int getPlantasBajoRasanteUsoPrincipal() {
		return plantasBajoRasanteUsoPrincipal;
	}

	/**
	 * Define el valor de la propiedad plantasBajoRasanteUsoPrincipal.
	 * 
	 */
	public void setPlantasBajoRasanteUsoPrincipal(int value) {
		this.plantasBajoRasanteUsoPrincipal = value;
	}

	/**
	 * Obtiene el valor de la propiedad plantasBajoRasanteUsosSecundarios.
	 * 
	 */
	@Basic
	@Column(name = "PLANTAS_BAJO_RASANTE_USOS_SECUNDARIOS", precision = 10, scale = 0)
	public int getPlantasBajoRasanteUsosSecundarios() {
		return plantasBajoRasanteUsosSecundarios;
	}

	/**
	 * Define el valor de la propiedad plantasBajoRasanteUsosSecundarios.
	 * 
	 */
	public void setPlantasBajoRasanteUsosSecundarios(int value) {
		this.plantasBajoRasanteUsosSecundarios = value;
	}

	/**
	 * Obtiene el valor de la propiedad plantasBajoRasanteUsosSecundariosTipo.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "PLANTAS_BAJO_RASANTE_USOS_SECUNDARIOS_TIPO", length = 255)
	public String getPlantasBajoRasanteUsosSecundariosTipo() {
		return plantasBajoRasanteUsosSecundariosTipo;
	}

	/**
	 * Define el valor de la propiedad plantasBajoRasanteUsosSecundariosTipo.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPlantasBajoRasanteUsosSecundariosTipo(String value) {
		this.plantasBajoRasanteUsosSecundariosTipo = value;
	}

	/**
	 * Obtiene el valor de la propiedad numViviendas.
	 * 
	 */
	@Basic
	@Column(name = "NUM_VIVIENDAS", precision = 10, scale = 0)
	public int getNumViviendas() {
		return numViviendas;
	}

	/**
	 * Define el valor de la propiedad numViviendas.
	 * 
	 */
	public void setNumViviendas(int value) {
		this.numViviendas = value;
	}

	/**
	 * Obtiene el valor de la propiedad superficieMediaViviendas.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	@Basic
	@Column(name = "SUPERFICIE_MEDIA_VIVIENDAS", precision = 20, scale = 10)
	public BigDecimal getSuperficieMediaViviendas() {
		return superficieMediaViviendas;
	}

	/**
	 * Define el valor de la propiedad superficieMediaViviendas.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setSuperficieMediaViviendas(BigDecimal value) {
		this.superficieMediaViviendas = value;
	}

	/**
	 * Obtiene el valor de la propiedad numLocales.
	 * 
	 */
	@Basic
	@Column(name = "NUM_LOCALES", precision = 10, scale = 0)
	public int getNumLocales() {
		return numLocales;
	}

	/**
	 * Define el valor de la propiedad numLocales.
	 * 
	 */
	public void setNumLocales(int value) {
		this.numLocales = value;
	}

	/**
	 * Obtiene el valor de la propiedad superficieMediaLocales.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	@Basic
	@Column(name = "SUPERFICIE_MEDIA_LOCALES", precision = 20, scale = 10)
	public BigDecimal getSuperficieMediaLocales() {
		return superficieMediaLocales;
	}

	/**
	 * Define el valor de la propiedad superficieMediaLocales.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setSuperficieMediaLocales(BigDecimal value) {
		this.superficieMediaLocales = value;
	}

	/**
	 * Obtiene el valor de la propiedad numAparcamientos.
	 * 
	 */
	@Basic
	@Column(name = "NUM_APARCAMIENTOS", precision = 10, scale = 0)
	public int getNumAparcamientos() {
		return numAparcamientos;
	}

	/**
	 * Define el valor de la propiedad numAparcamientos.
	 * 
	 */
	public void setNumAparcamientos(int value) {
		this.numAparcamientos = value;
	}

	/**
	 * Obtiene el valor de la propiedad superficieMediaAparcamientos.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	@Basic
	@Column(name = "SUPERFICIE_MEDIA_APARCAMIENTOS", precision = 20, scale = 10)
	public BigDecimal getSuperficieMediaAparcamientos() {
		return superficieMediaAparcamientos;
	}

	/**
	 * Define el valor de la propiedad superficieMediaAparcamientos.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setSuperficieMediaAparcamientos(BigDecimal value) {
		this.superficieMediaAparcamientos = value;
	}

	/**
	 * Obtiene el valor de la propiedad numTrasteros.
	 * 
	 */
	@Basic
	@Column(name = "NUM_TRASTEROS", precision = 10, scale = 0)
	public int getNumTrasteros() {
		return numTrasteros;
	}

	/**
	 * Define el valor de la propiedad numTrasteros.
	 * 
	 */
	public void setNumTrasteros(int value) {
		this.numTrasteros = value;
	}

	/**
	 * Obtiene el valor de la propiedad superficieMediaTrasteros.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	@Basic
	@Column(name = "SUPERFICIE_MEDIA_TRASTEROS", precision = 20, scale = 10)
	public BigDecimal getSuperficieMediaTrasteros() {
		return superficieMediaTrasteros;
	}

	/**
	 * Define el valor de la propiedad superficieMediaTrasteros.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setSuperficieMediaTrasteros(BigDecimal value) {
		this.superficieMediaTrasteros = value;
	}

	/**
	 * Obtiene el valor de la propiedad inspeccionDatosedificioParcelaTipoId.
	 * 
	 */
	@Basic
	@Column(name = "INSPECCION_DATOSEDIFICIO_PARCELA_TIPO_ID")
	public int getInspeccionDatosedificioParcelaTipoId() {
		return inspeccionDatosedificioParcelaTipoId;
	}

	/**
	 * Define el valor de la propiedad inspeccionDatosedificioParcelaTipoId.
	 * 
	 */
	public void setInspeccionDatosedificioParcelaTipoId(int value) {
		this.inspeccionDatosedificioParcelaTipoId = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * inspeccionDatosedificioNucleosescalerasTipoId.
	 * 
	 */
	@Basic
	@Column(name = "INSPECCION_DATOSEDIFICIO_NUCLEOSESCALERAS_TIPO_ID")
	public int getInspeccionDatosedificioNucleosescalerasTipoId() {
		return inspeccionDatosedificioNucleosescalerasTipoId;
	}

	/**
	 * Define el valor de la propiedad
	 * inspeccionDatosedificioNucleosescalerasTipoId.
	 * 
	 */
	public void setInspeccionDatosedificioNucleosescalerasTipoId(int value) {
		this.inspeccionDatosedificioNucleosescalerasTipoId = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * inspeccionDatosedificioUnnucleoescalerasTipoId.
	 * 
	 */
	@Basic
	@Column(name = "INSPECCION_DATOSEDIFICIO_UNNUCLEOESCALERAS_TIPO_ID")
	public int getInspeccionDatosedificioUnnucleoescalerasTipoId() {
		return inspeccionDatosedificioUnnucleoescalerasTipoId;
	}

	/**
	 * Define el valor de la propiedad
	 * inspeccionDatosedificioUnnucleoescalerasTipoId.
	 * 
	 */
	public void setInspeccionDatosedificioUnnucleoescalerasTipoId(int value) {
		this.inspeccionDatosedificioUnnucleoescalerasTipoId = value;
	}

	/**
	 * Obtiene el valor de la propiedad totalEscaleras.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "TOTAL_ESCALERAS", length = 255)
	public String getTotalEscaleras() {
		return totalEscaleras;
	}

	/**
	 * Define el valor de la propiedad totalEscaleras.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTotalEscaleras(String value) {
		this.totalEscaleras = value;
	}

	/**
	 * Obtiene el valor de la propiedad totalAscensores.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "TOTAL_ASCENSORES", length = 255)
	public String getTotalAscensores() {
		return totalAscensores;
	}

	/**
	 * Define el valor de la propiedad totalAscensores.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTotalAscensores(String value) {
		this.totalAscensores = value;
	}

	/**
	 * Obtiene el valor de la propiedad totalViviendasConAccesoVariosNucleos.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "TOTAL_VIVIENDAS_CON_ACCESO_VARIOS_NUCLEOS", length = 255)
	public String getTotalViviendasConAccesoVariosNucleos() {
		return totalViviendasConAccesoVariosNucleos;
	}

	/**
	 * Define el valor de la propiedad totalViviendasConAccesoVariosNucleos.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTotalViviendasConAccesoVariosNucleos(String value) {
		this.totalViviendasConAccesoVariosNucleos = value;
	}

	/**
	 * Obtiene el valor de la propiedad totalViviendasSinAccesoAscensor.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "TOTAL_VIVIENDAS_SIN_ACCESO_ASCENSOR", length = 255)
	public String getTotalViviendasSinAccesoAscensor() {
		return totalViviendasSinAccesoAscensor;
	}

	/**
	 * Define el valor de la propiedad totalViviendasSinAccesoAscensor.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTotalViviendasSinAccesoAscensor(String value) {
		this.totalViviendasSinAccesoAscensor = value;
	}

	/**
	 * Obtiene el valor de la propiedad mediaViviendasPorPlanta.
	 * 
	 */
	@Basic
	@Column(name = "MEDIA_VIVIENDAS_POR_PLANTA", precision = 10, scale = 0)
	public int getMediaViviendasPorPlanta() {
		return mediaViviendasPorPlanta;
	}

	/**
	 * Define el valor de la propiedad mediaViviendasPorPlanta.
	 * 
	 */
	public void setMediaViviendasPorPlanta(int value) {
		this.mediaViviendasPorPlanta = value;
	}

	public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
		if ((object == null) || (this.getClass() != object.getClass())) {
			return false;
		}
		if (this == object) {
			return true;
		}
		final InspeccionDatosedificiosType that = ((InspeccionDatosedificiosType) object);
		{
			int lhsInspeccionDatosedificioUsoTipoId;
			lhsInspeccionDatosedificioUsoTipoId = this.getInspeccionDatosedificioUsoTipoId();
			int rhsInspeccionDatosedificioUsoTipoId;
			rhsInspeccionDatosedificioUsoTipoId = that.getInspeccionDatosedificioUsoTipoId();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "inspeccionDatosedificioUsoTipoId", lhsInspeccionDatosedificioUsoTipoId), LocatorUtils.property(thatLocator, "inspeccionDatosedificioUsoTipoId", rhsInspeccionDatosedificioUsoTipoId), lhsInspeccionDatosedificioUsoTipoId, rhsInspeccionDatosedificioUsoTipoId)) {
				return false;
			}
		}
		{
			String lhsUsoTexto;
			lhsUsoTexto = this.getUsoTexto();
			String rhsUsoTexto;
			rhsUsoTexto = that.getUsoTexto();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "usoTexto", lhsUsoTexto), LocatorUtils.property(thatLocator, "usoTexto", rhsUsoTexto), lhsUsoTexto, rhsUsoTexto)) {
				return false;
			}
		}
		{
			int lhsAnoConstruccion;
			lhsAnoConstruccion = this.getAnoConstruccion();
			int rhsAnoConstruccion;
			rhsAnoConstruccion = that.getAnoConstruccion();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "anoConstruccion", lhsAnoConstruccion), LocatorUtils.property(thatLocator, "anoConstruccion", rhsAnoConstruccion), lhsAnoConstruccion, rhsAnoConstruccion)) {
				return false;
			}
		}
		{
			String lhsAnoConstruccionReferencia;
			lhsAnoConstruccionReferencia = this.getAnoConstruccionReferencia();
			String rhsAnoConstruccionReferencia;
			rhsAnoConstruccionReferencia = that.getAnoConstruccionReferencia();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "anoConstruccionReferencia", lhsAnoConstruccionReferencia), LocatorUtils.property(thatLocator, "anoConstruccionReferencia", rhsAnoConstruccionReferencia), lhsAnoConstruccionReferencia, rhsAnoConstruccionReferencia)) {
				return false;
			}
		}
		{
			int lhsAnoRehabilitacion;
			lhsAnoRehabilitacion = this.getAnoRehabilitacion();
			int rhsAnoRehabilitacion;
			rhsAnoRehabilitacion = that.getAnoRehabilitacion();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "anoRehabilitacion", lhsAnoRehabilitacion), LocatorUtils.property(thatLocator, "anoRehabilitacion", rhsAnoRehabilitacion), lhsAnoRehabilitacion, rhsAnoRehabilitacion)) {
				return false;
			}
		}
		{
			String lhsAnoRehabilitacionReferencia;
			lhsAnoRehabilitacionReferencia = this.getAnoRehabilitacionReferencia();
			String rhsAnoRehabilitacionReferencia;
			rhsAnoRehabilitacionReferencia = that.getAnoRehabilitacionReferencia();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "anoRehabilitacionReferencia", lhsAnoRehabilitacionReferencia), LocatorUtils.property(thatLocator, "anoRehabilitacionReferencia", rhsAnoRehabilitacionReferencia), lhsAnoRehabilitacionReferencia, rhsAnoRehabilitacionReferencia)) {
				return false;
			}
		}
		{
			BigDecimal lhsSuperficieParcela;
			lhsSuperficieParcela = this.getSuperficieParcela();
			BigDecimal rhsSuperficieParcela;
			rhsSuperficieParcela = that.getSuperficieParcela();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "superficieParcela", lhsSuperficieParcela), LocatorUtils.property(thatLocator, "superficieParcela", rhsSuperficieParcela), lhsSuperficieParcela, rhsSuperficieParcela)) {
				return false;
			}
		}
		{
			BigDecimal lhsSuperficieConstruida;
			lhsSuperficieConstruida = this.getSuperficieConstruida();
			BigDecimal rhsSuperficieConstruida;
			rhsSuperficieConstruida = that.getSuperficieConstruida();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "superficieConstruida", lhsSuperficieConstruida), LocatorUtils.property(thatLocator, "superficieConstruida", rhsSuperficieConstruida), lhsSuperficieConstruida, rhsSuperficieConstruida)) {
				return false;
			}
		}
		{
			BigDecimal lhsAlturaSobreRasante;
			lhsAlturaSobreRasante = this.getAlturaSobreRasante();
			BigDecimal rhsAlturaSobreRasante;
			rhsAlturaSobreRasante = that.getAlturaSobreRasante();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "alturaSobreRasante", lhsAlturaSobreRasante), LocatorUtils.property(thatLocator, "alturaSobreRasante", rhsAlturaSobreRasante), lhsAlturaSobreRasante, rhsAlturaSobreRasante)) {
				return false;
			}
		}
		{
			int lhsPlantasSobreRasanteUsoPrincipal;
			lhsPlantasSobreRasanteUsoPrincipal = this.getPlantasSobreRasanteUsoPrincipal();
			int rhsPlantasSobreRasanteUsoPrincipal;
			rhsPlantasSobreRasanteUsoPrincipal = that.getPlantasSobreRasanteUsoPrincipal();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "plantasSobreRasanteUsoPrincipal", lhsPlantasSobreRasanteUsoPrincipal), LocatorUtils.property(thatLocator, "plantasSobreRasanteUsoPrincipal", rhsPlantasSobreRasanteUsoPrincipal), lhsPlantasSobreRasanteUsoPrincipal, rhsPlantasSobreRasanteUsoPrincipal)) {
				return false;
			}
		}
		{
			int lhsPlantasSobreRasanteUsosSecundarios;
			lhsPlantasSobreRasanteUsosSecundarios = this.getPlantasSobreRasanteUsosSecundarios();
			int rhsPlantasSobreRasanteUsosSecundarios;
			rhsPlantasSobreRasanteUsosSecundarios = that.getPlantasSobreRasanteUsosSecundarios();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "plantasSobreRasanteUsosSecundarios", lhsPlantasSobreRasanteUsosSecundarios), LocatorUtils.property(thatLocator, "plantasSobreRasanteUsosSecundarios", rhsPlantasSobreRasanteUsosSecundarios), lhsPlantasSobreRasanteUsosSecundarios, rhsPlantasSobreRasanteUsosSecundarios)) {
				return false;
			}
		}
		{
			String lhsPlantasSobreRasanteUsosSecundariosTipo;
			lhsPlantasSobreRasanteUsosSecundariosTipo = this.getPlantasSobreRasanteUsosSecundariosTipo();
			String rhsPlantasSobreRasanteUsosSecundariosTipo;
			rhsPlantasSobreRasanteUsosSecundariosTipo = that.getPlantasSobreRasanteUsosSecundariosTipo();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "plantasSobreRasanteUsosSecundariosTipo", lhsPlantasSobreRasanteUsosSecundariosTipo), LocatorUtils.property(thatLocator, "plantasSobreRasanteUsosSecundariosTipo", rhsPlantasSobreRasanteUsosSecundariosTipo), lhsPlantasSobreRasanteUsosSecundariosTipo, rhsPlantasSobreRasanteUsosSecundariosTipo)) {
				return false;
			}
		}
		{
			int lhsPlantasBajoRasanteUsoPrincipal;
			lhsPlantasBajoRasanteUsoPrincipal = this.getPlantasBajoRasanteUsoPrincipal();
			int rhsPlantasBajoRasanteUsoPrincipal;
			rhsPlantasBajoRasanteUsoPrincipal = that.getPlantasBajoRasanteUsoPrincipal();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "plantasBajoRasanteUsoPrincipal", lhsPlantasBajoRasanteUsoPrincipal), LocatorUtils.property(thatLocator, "plantasBajoRasanteUsoPrincipal", rhsPlantasBajoRasanteUsoPrincipal), lhsPlantasBajoRasanteUsoPrincipal, rhsPlantasBajoRasanteUsoPrincipal)) {
				return false;
			}
		}
		{
			int lhsPlantasBajoRasanteUsosSecundarios;
			lhsPlantasBajoRasanteUsosSecundarios = this.getPlantasBajoRasanteUsosSecundarios();
			int rhsPlantasBajoRasanteUsosSecundarios;
			rhsPlantasBajoRasanteUsosSecundarios = that.getPlantasBajoRasanteUsosSecundarios();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "plantasBajoRasanteUsosSecundarios", lhsPlantasBajoRasanteUsosSecundarios), LocatorUtils.property(thatLocator, "plantasBajoRasanteUsosSecundarios", rhsPlantasBajoRasanteUsosSecundarios), lhsPlantasBajoRasanteUsosSecundarios, rhsPlantasBajoRasanteUsosSecundarios)) {
				return false;
			}
		}
		{
			String lhsPlantasBajoRasanteUsosSecundariosTipo;
			lhsPlantasBajoRasanteUsosSecundariosTipo = this.getPlantasBajoRasanteUsosSecundariosTipo();
			String rhsPlantasBajoRasanteUsosSecundariosTipo;
			rhsPlantasBajoRasanteUsosSecundariosTipo = that.getPlantasBajoRasanteUsosSecundariosTipo();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "plantasBajoRasanteUsosSecundariosTipo", lhsPlantasBajoRasanteUsosSecundariosTipo), LocatorUtils.property(thatLocator, "plantasBajoRasanteUsosSecundariosTipo", rhsPlantasBajoRasanteUsosSecundariosTipo), lhsPlantasBajoRasanteUsosSecundariosTipo, rhsPlantasBajoRasanteUsosSecundariosTipo)) {
				return false;
			}
		}
		{
			int lhsNumViviendas;
			lhsNumViviendas = this.getNumViviendas();
			int rhsNumViviendas;
			rhsNumViviendas = that.getNumViviendas();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "numViviendas", lhsNumViviendas), LocatorUtils.property(thatLocator, "numViviendas", rhsNumViviendas), lhsNumViviendas, rhsNumViviendas)) {
				return false;
			}
		}
		{
			BigDecimal lhsSuperficieMediaViviendas;
			lhsSuperficieMediaViviendas = this.getSuperficieMediaViviendas();
			BigDecimal rhsSuperficieMediaViviendas;
			rhsSuperficieMediaViviendas = that.getSuperficieMediaViviendas();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "superficieMediaViviendas", lhsSuperficieMediaViviendas), LocatorUtils.property(thatLocator, "superficieMediaViviendas", rhsSuperficieMediaViviendas), lhsSuperficieMediaViviendas, rhsSuperficieMediaViviendas)) {
				return false;
			}
		}
		{
			int lhsNumLocales;
			lhsNumLocales = this.getNumLocales();
			int rhsNumLocales;
			rhsNumLocales = that.getNumLocales();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "numLocales", lhsNumLocales), LocatorUtils.property(thatLocator, "numLocales", rhsNumLocales), lhsNumLocales, rhsNumLocales)) {
				return false;
			}
		}
		{
			BigDecimal lhsSuperficieMediaLocales;
			lhsSuperficieMediaLocales = this.getSuperficieMediaLocales();
			BigDecimal rhsSuperficieMediaLocales;
			rhsSuperficieMediaLocales = that.getSuperficieMediaLocales();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "superficieMediaLocales", lhsSuperficieMediaLocales), LocatorUtils.property(thatLocator, "superficieMediaLocales", rhsSuperficieMediaLocales), lhsSuperficieMediaLocales, rhsSuperficieMediaLocales)) {
				return false;
			}
		}
		{
			int lhsNumAparcamientos;
			lhsNumAparcamientos = this.getNumAparcamientos();
			int rhsNumAparcamientos;
			rhsNumAparcamientos = that.getNumAparcamientos();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "numAparcamientos", lhsNumAparcamientos), LocatorUtils.property(thatLocator, "numAparcamientos", rhsNumAparcamientos), lhsNumAparcamientos, rhsNumAparcamientos)) {
				return false;
			}
		}
		{
			BigDecimal lhsSuperficieMediaAparcamientos;
			lhsSuperficieMediaAparcamientos = this.getSuperficieMediaAparcamientos();
			BigDecimal rhsSuperficieMediaAparcamientos;
			rhsSuperficieMediaAparcamientos = that.getSuperficieMediaAparcamientos();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "superficieMediaAparcamientos", lhsSuperficieMediaAparcamientos), LocatorUtils.property(thatLocator, "superficieMediaAparcamientos", rhsSuperficieMediaAparcamientos), lhsSuperficieMediaAparcamientos, rhsSuperficieMediaAparcamientos)) {
				return false;
			}
		}
		{
			int lhsNumTrasteros;
			lhsNumTrasteros = this.getNumTrasteros();
			int rhsNumTrasteros;
			rhsNumTrasteros = that.getNumTrasteros();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "numTrasteros", lhsNumTrasteros), LocatorUtils.property(thatLocator, "numTrasteros", rhsNumTrasteros), lhsNumTrasteros, rhsNumTrasteros)) {
				return false;
			}
		}
		{
			BigDecimal lhsSuperficieMediaTrasteros;
			lhsSuperficieMediaTrasteros = this.getSuperficieMediaTrasteros();
			BigDecimal rhsSuperficieMediaTrasteros;
			rhsSuperficieMediaTrasteros = that.getSuperficieMediaTrasteros();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "superficieMediaTrasteros", lhsSuperficieMediaTrasteros), LocatorUtils.property(thatLocator, "superficieMediaTrasteros", rhsSuperficieMediaTrasteros), lhsSuperficieMediaTrasteros, rhsSuperficieMediaTrasteros)) {
				return false;
			}
		}
		{
			int lhsInspeccionDatosedificioParcelaTipoId;
			lhsInspeccionDatosedificioParcelaTipoId = this.getInspeccionDatosedificioParcelaTipoId();
			int rhsInspeccionDatosedificioParcelaTipoId;
			rhsInspeccionDatosedificioParcelaTipoId = that.getInspeccionDatosedificioParcelaTipoId();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "inspeccionDatosedificioParcelaTipoId", lhsInspeccionDatosedificioParcelaTipoId), LocatorUtils.property(thatLocator, "inspeccionDatosedificioParcelaTipoId", rhsInspeccionDatosedificioParcelaTipoId), lhsInspeccionDatosedificioParcelaTipoId, rhsInspeccionDatosedificioParcelaTipoId)) {
				return false;
			}
		}
		{
			int lhsInspeccionDatosedificioNucleosescalerasTipoId;
			lhsInspeccionDatosedificioNucleosescalerasTipoId = this.getInspeccionDatosedificioNucleosescalerasTipoId();
			int rhsInspeccionDatosedificioNucleosescalerasTipoId;
			rhsInspeccionDatosedificioNucleosescalerasTipoId = that.getInspeccionDatosedificioNucleosescalerasTipoId();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "inspeccionDatosedificioNucleosescalerasTipoId", lhsInspeccionDatosedificioNucleosescalerasTipoId), LocatorUtils.property(thatLocator, "inspeccionDatosedificioNucleosescalerasTipoId", rhsInspeccionDatosedificioNucleosescalerasTipoId), lhsInspeccionDatosedificioNucleosescalerasTipoId, rhsInspeccionDatosedificioNucleosescalerasTipoId)) {
				return false;
			}
		}
		{
			int lhsInspeccionDatosedificioUnnucleoescalerasTipoId;
			lhsInspeccionDatosedificioUnnucleoescalerasTipoId = this.getInspeccionDatosedificioUnnucleoescalerasTipoId();
			int rhsInspeccionDatosedificioUnnucleoescalerasTipoId;
			rhsInspeccionDatosedificioUnnucleoescalerasTipoId = that.getInspeccionDatosedificioUnnucleoescalerasTipoId();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "inspeccionDatosedificioUnnucleoescalerasTipoId", lhsInspeccionDatosedificioUnnucleoescalerasTipoId), LocatorUtils.property(thatLocator, "inspeccionDatosedificioUnnucleoescalerasTipoId", rhsInspeccionDatosedificioUnnucleoescalerasTipoId), lhsInspeccionDatosedificioUnnucleoescalerasTipoId, rhsInspeccionDatosedificioUnnucleoescalerasTipoId)) {
				return false;
			}
		}
		{
			String lhsTotalEscaleras;
			lhsTotalEscaleras = this.getTotalEscaleras();
			String rhsTotalEscaleras;
			rhsTotalEscaleras = that.getTotalEscaleras();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "totalEscaleras", lhsTotalEscaleras), LocatorUtils.property(thatLocator, "totalEscaleras", rhsTotalEscaleras), lhsTotalEscaleras, rhsTotalEscaleras)) {
				return false;
			}
		}
		{
			String lhsTotalAscensores;
			lhsTotalAscensores = this.getTotalAscensores();
			String rhsTotalAscensores;
			rhsTotalAscensores = that.getTotalAscensores();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "totalAscensores", lhsTotalAscensores), LocatorUtils.property(thatLocator, "totalAscensores", rhsTotalAscensores), lhsTotalAscensores, rhsTotalAscensores)) {
				return false;
			}
		}
		{
			String lhsTotalViviendasConAccesoVariosNucleos;
			lhsTotalViviendasConAccesoVariosNucleos = this.getTotalViviendasConAccesoVariosNucleos();
			String rhsTotalViviendasConAccesoVariosNucleos;
			rhsTotalViviendasConAccesoVariosNucleos = that.getTotalViviendasConAccesoVariosNucleos();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "totalViviendasConAccesoVariosNucleos", lhsTotalViviendasConAccesoVariosNucleos), LocatorUtils.property(thatLocator, "totalViviendasConAccesoVariosNucleos", rhsTotalViviendasConAccesoVariosNucleos), lhsTotalViviendasConAccesoVariosNucleos, rhsTotalViviendasConAccesoVariosNucleos)) {
				return false;
			}
		}
		{
			String lhsTotalViviendasSinAccesoAscensor;
			lhsTotalViviendasSinAccesoAscensor = this.getTotalViviendasSinAccesoAscensor();
			String rhsTotalViviendasSinAccesoAscensor;
			rhsTotalViviendasSinAccesoAscensor = that.getTotalViviendasSinAccesoAscensor();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "totalViviendasSinAccesoAscensor", lhsTotalViviendasSinAccesoAscensor), LocatorUtils.property(thatLocator, "totalViviendasSinAccesoAscensor", rhsTotalViviendasSinAccesoAscensor), lhsTotalViviendasSinAccesoAscensor, rhsTotalViviendasSinAccesoAscensor)) {
				return false;
			}
		}
		{
			int lhsMediaViviendasPorPlanta;
			lhsMediaViviendasPorPlanta = this.getMediaViviendasPorPlanta();
			int rhsMediaViviendasPorPlanta;
			rhsMediaViviendasPorPlanta = that.getMediaViviendasPorPlanta();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "mediaViviendasPorPlanta", lhsMediaViviendasPorPlanta), LocatorUtils.property(thatLocator, "mediaViviendasPorPlanta", rhsMediaViviendasPorPlanta), lhsMediaViviendasPorPlanta, rhsMediaViviendasPorPlanta)) {
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
			int theInspeccionDatosedificioUsoTipoId;
			theInspeccionDatosedificioUsoTipoId = this.getInspeccionDatosedificioUsoTipoId();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "inspeccionDatosedificioUsoTipoId", theInspeccionDatosedificioUsoTipoId), currentHashCode, theInspeccionDatosedificioUsoTipoId);
		}
		{
			String theUsoTexto;
			theUsoTexto = this.getUsoTexto();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "usoTexto", theUsoTexto), currentHashCode, theUsoTexto);
		}
		{
			int theAnoConstruccion;
			theAnoConstruccion = this.getAnoConstruccion();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "anoConstruccion", theAnoConstruccion), currentHashCode, theAnoConstruccion);
		}
		{
			String theAnoConstruccionReferencia;
			theAnoConstruccionReferencia = this.getAnoConstruccionReferencia();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "anoConstruccionReferencia", theAnoConstruccionReferencia), currentHashCode, theAnoConstruccionReferencia);
		}
		{
			int theAnoRehabilitacion;
			theAnoRehabilitacion = this.getAnoRehabilitacion();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "anoRehabilitacion", theAnoRehabilitacion), currentHashCode, theAnoRehabilitacion);
		}
		{
			String theAnoRehabilitacionReferencia;
			theAnoRehabilitacionReferencia = this.getAnoRehabilitacionReferencia();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "anoRehabilitacionReferencia", theAnoRehabilitacionReferencia), currentHashCode, theAnoRehabilitacionReferencia);
		}
		{
			BigDecimal theSuperficieParcela;
			theSuperficieParcela = this.getSuperficieParcela();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "superficieParcela", theSuperficieParcela), currentHashCode, theSuperficieParcela);
		}
		{
			BigDecimal theSuperficieConstruida;
			theSuperficieConstruida = this.getSuperficieConstruida();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "superficieConstruida", theSuperficieConstruida), currentHashCode, theSuperficieConstruida);
		}
		{
			BigDecimal theAlturaSobreRasante;
			theAlturaSobreRasante = this.getAlturaSobreRasante();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "alturaSobreRasante", theAlturaSobreRasante), currentHashCode, theAlturaSobreRasante);
		}
		{
			int thePlantasSobreRasanteUsoPrincipal;
			thePlantasSobreRasanteUsoPrincipal = this.getPlantasSobreRasanteUsoPrincipal();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "plantasSobreRasanteUsoPrincipal", thePlantasSobreRasanteUsoPrincipal), currentHashCode, thePlantasSobreRasanteUsoPrincipal);
		}
		{
			int thePlantasSobreRasanteUsosSecundarios;
			thePlantasSobreRasanteUsosSecundarios = this.getPlantasSobreRasanteUsosSecundarios();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "plantasSobreRasanteUsosSecundarios", thePlantasSobreRasanteUsosSecundarios), currentHashCode, thePlantasSobreRasanteUsosSecundarios);
		}
		{
			String thePlantasSobreRasanteUsosSecundariosTipo;
			thePlantasSobreRasanteUsosSecundariosTipo = this.getPlantasSobreRasanteUsosSecundariosTipo();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "plantasSobreRasanteUsosSecundariosTipo", thePlantasSobreRasanteUsosSecundariosTipo), currentHashCode, thePlantasSobreRasanteUsosSecundariosTipo);
		}
		{
			int thePlantasBajoRasanteUsoPrincipal;
			thePlantasBajoRasanteUsoPrincipal = this.getPlantasBajoRasanteUsoPrincipal();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "plantasBajoRasanteUsoPrincipal", thePlantasBajoRasanteUsoPrincipal), currentHashCode, thePlantasBajoRasanteUsoPrincipal);
		}
		{
			int thePlantasBajoRasanteUsosSecundarios;
			thePlantasBajoRasanteUsosSecundarios = this.getPlantasBajoRasanteUsosSecundarios();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "plantasBajoRasanteUsosSecundarios", thePlantasBajoRasanteUsosSecundarios), currentHashCode, thePlantasBajoRasanteUsosSecundarios);
		}
		{
			String thePlantasBajoRasanteUsosSecundariosTipo;
			thePlantasBajoRasanteUsosSecundariosTipo = this.getPlantasBajoRasanteUsosSecundariosTipo();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "plantasBajoRasanteUsosSecundariosTipo", thePlantasBajoRasanteUsosSecundariosTipo), currentHashCode, thePlantasBajoRasanteUsosSecundariosTipo);
		}
		{
			int theNumViviendas;
			theNumViviendas = this.getNumViviendas();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "numViviendas", theNumViviendas), currentHashCode, theNumViviendas);
		}
		{
			BigDecimal theSuperficieMediaViviendas;
			theSuperficieMediaViviendas = this.getSuperficieMediaViviendas();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "superficieMediaViviendas", theSuperficieMediaViviendas), currentHashCode, theSuperficieMediaViviendas);
		}
		{
			int theNumLocales;
			theNumLocales = this.getNumLocales();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "numLocales", theNumLocales), currentHashCode, theNumLocales);
		}
		{
			BigDecimal theSuperficieMediaLocales;
			theSuperficieMediaLocales = this.getSuperficieMediaLocales();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "superficieMediaLocales", theSuperficieMediaLocales), currentHashCode, theSuperficieMediaLocales);
		}
		{
			int theNumAparcamientos;
			theNumAparcamientos = this.getNumAparcamientos();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "numAparcamientos", theNumAparcamientos), currentHashCode, theNumAparcamientos);
		}
		{
			BigDecimal theSuperficieMediaAparcamientos;
			theSuperficieMediaAparcamientos = this.getSuperficieMediaAparcamientos();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "superficieMediaAparcamientos", theSuperficieMediaAparcamientos), currentHashCode, theSuperficieMediaAparcamientos);
		}
		{
			int theNumTrasteros;
			theNumTrasteros = this.getNumTrasteros();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "numTrasteros", theNumTrasteros), currentHashCode, theNumTrasteros);
		}
		{
			BigDecimal theSuperficieMediaTrasteros;
			theSuperficieMediaTrasteros = this.getSuperficieMediaTrasteros();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "superficieMediaTrasteros", theSuperficieMediaTrasteros), currentHashCode, theSuperficieMediaTrasteros);
		}
		{
			int theInspeccionDatosedificioParcelaTipoId;
			theInspeccionDatosedificioParcelaTipoId = this.getInspeccionDatosedificioParcelaTipoId();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "inspeccionDatosedificioParcelaTipoId", theInspeccionDatosedificioParcelaTipoId), currentHashCode, theInspeccionDatosedificioParcelaTipoId);
		}
		{
			int theInspeccionDatosedificioNucleosescalerasTipoId;
			theInspeccionDatosedificioNucleosescalerasTipoId = this.getInspeccionDatosedificioNucleosescalerasTipoId();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "inspeccionDatosedificioNucleosescalerasTipoId", theInspeccionDatosedificioNucleosescalerasTipoId), currentHashCode, theInspeccionDatosedificioNucleosescalerasTipoId);
		}
		{
			int theInspeccionDatosedificioUnnucleoescalerasTipoId;
			theInspeccionDatosedificioUnnucleoescalerasTipoId = this.getInspeccionDatosedificioUnnucleoescalerasTipoId();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "inspeccionDatosedificioUnnucleoescalerasTipoId", theInspeccionDatosedificioUnnucleoescalerasTipoId), currentHashCode, theInspeccionDatosedificioUnnucleoescalerasTipoId);
		}
		{
			String theTotalEscaleras;
			theTotalEscaleras = this.getTotalEscaleras();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "totalEscaleras", theTotalEscaleras), currentHashCode, theTotalEscaleras);
		}
		{
			String theTotalAscensores;
			theTotalAscensores = this.getTotalAscensores();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "totalAscensores", theTotalAscensores), currentHashCode, theTotalAscensores);
		}
		{
			String theTotalViviendasConAccesoVariosNucleos;
			theTotalViviendasConAccesoVariosNucleos = this.getTotalViviendasConAccesoVariosNucleos();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "totalViviendasConAccesoVariosNucleos", theTotalViviendasConAccesoVariosNucleos), currentHashCode, theTotalViviendasConAccesoVariosNucleos);
		}
		{
			String theTotalViviendasSinAccesoAscensor;
			theTotalViviendasSinAccesoAscensor = this.getTotalViviendasSinAccesoAscensor();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "totalViviendasSinAccesoAscensor", theTotalViviendasSinAccesoAscensor), currentHashCode, theTotalViviendasSinAccesoAscensor);
		}
		{
			int theMediaViviendasPorPlanta;
			theMediaViviendasPorPlanta = this.getMediaViviendasPorPlanta();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "mediaViviendasPorPlanta", theMediaViviendasPorPlanta), currentHashCode, theMediaViviendasPorPlanta);
		}
		return currentHashCode;
	}

	public int hashCode() {
		final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
		return this.hashCode(null, strategy);
	}

}
