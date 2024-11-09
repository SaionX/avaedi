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
 * Clase Java para cerramientoscubiertasType complex type.
 * 
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que
 * haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="cerramientoscubiertasType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="fachada_principal_superficie" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="fachada_principal_porcentaje" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="fachadaprincipal_camaraaire_tipo_id"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int"&gt;
 *               &lt;enumeration value="1"/&gt;
 *               &lt;enumeration value="2"/&gt;
 *               &lt;enumeration value="3"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="fachadaprincipal_aislamientotermico_tipo_id"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int"&gt;
 *               &lt;enumeration value="1"/&gt;
 *               &lt;enumeration value="2"/&gt;
 *               &lt;enumeration value="3"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="otras_fachadas_superficie" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="otras_fachadas_porcentaje" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="otrasfachadas_camaraaire_tipo_id"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int"&gt;
 *               &lt;enumeration value="1"/&gt;
 *               &lt;enumeration value="2"/&gt;
 *               &lt;enumeration value="3"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="otrasfachadas_aislamientotermico_tipo_id"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int"&gt;
 *               &lt;enumeration value="1"/&gt;
 *               &lt;enumeration value="2"/&gt;
 *               &lt;enumeration value="3"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="carpinteria_vidrio_superficie" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="carpinteria_vidrio_porcentaje" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="cubierta_plana_superficie" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="cubierta_plana_porcentaje" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="cubiertaplana_aislamientotermico_tipo_id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="cubiertaplana_laminaimpermeabilizante_tipo_id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="cubierta_inclinada_superficie" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="cubierta_inclinada_porcentaje" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="cubiertainclinada_aislamientotermico_tipo_id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="carpinteriavidrio_carpinteriapredominante_texto" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="carpinteriavidrio_vidriopredominante_texto" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="fachadaprincipal_acabadorevestido_texto" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="fachadaprincipal_acabadorevestido_porcentaje" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="fachadaprincipal_acabadovisto_texto" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="fachadaprincipal_acabadovisto_porcentaje" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="otrasfachadas_acabadorevestido_texto" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="otrasfachadas_acabadorevestido_porcentaje" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="otrasfachadas_acabadovisto_texto" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="otrasfachadas_acabadovisto_porcentaje" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="observaciones" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="cerramientoscubiertas_fachadaprincipalacabadosvistos" type="{}cerramientoscubiertas_fachadaprincipalacabadosvistosType"/&gt;
 *         &lt;element name="cerramientoscubiertas_fachadaprincipalacabadosrevestidos" type="{}cerramientoscubiertas_fachadaprincipalacabadosrevestidosType"/&gt;
 *         &lt;element name="cerramientoscubiertas_otrasfachadasacabadosvistos" type="{}cerramientoscubiertas_otrasfachadasacabadosvistosType"/&gt;
 *         &lt;element name="cerramientoscubiertas_otrasfachadasacabadosrevestidos" type="{}cerramientoscubiertas_otrasfachadasacabadosrevestidosType"/&gt;
 *         &lt;element name="cerramientoscubiertas_carpinteriavidriocarpinteriaspredominantes" type="{}cerramientoscubiertas_carpinteriavidriocarpinteriaspredominantesType"/&gt;
 *         &lt;element name="cerramientoscubiertas_carpinteriavidriovidriospredominantes" type="{}cerramientoscubiertas_carpinteriavidriovidriospredominantesType"/&gt;
 *         &lt;element name="cerramientoscubiertas_cubiertaplanatransitables" type="{}cerramientoscubiertas_cubiertaplanatransitablesType"/&gt;
 *         &lt;element name="cerramientoscubiertas_cubiertainclinadacoberturas" type="{}cerramientoscubiertas_cubiertainclinadacoberturasType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cerramientoscubiertasType", propOrder = { "fachadaPrincipalSuperficie", "fachadaPrincipalPorcentaje", "fachadaprincipalCamaraaireTipoId", "fachadaprincipalAislamientotermicoTipoId", "otrasFachadasSuperficie", "otrasFachadasPorcentaje", "otrasfachadasCamaraaireTipoId", "otrasfachadasAislamientotermicoTipoId", "carpinteriaVidrioSuperficie", "carpinteriaVidrioPorcentaje", "cubiertaPlanaSuperficie", "cubiertaPlanaPorcentaje", "cubiertaplanaAislamientotermicoTipoId", "cubiertaplanaLaminaimpermeabilizanteTipoId", "cubiertaInclinadaSuperficie", "cubiertaInclinadaPorcentaje", "cubiertainclinadaAislamientotermicoTipoId", "carpinteriavidrioCarpinteriapredominanteTexto", "carpinteriavidrioVidriopredominanteTexto", "fachadaprincipalAcabadorevestidoTexto", "fachadaprincipalAcabadorevestidoPorcentaje", "fachadaprincipalAcabadovistoTexto", "fachadaprincipalAcabadovistoPorcentaje", "otrasfachadasAcabadorevestidoTexto", "otrasfachadasAcabadorevestidoPorcentaje", "otrasfachadasAcabadovistoTexto", "otrasfachadasAcabadovistoPorcentaje", "observaciones", "cerramientoscubiertasFachadaprincipalacabadosvistos", "cerramientoscubiertasFachadaprincipalacabadosrevestidos", "cerramientoscubiertasOtrasfachadasacabadosvistos", "cerramientoscubiertasOtrasfachadasacabadosrevestidos", "cerramientoscubiertasCarpinteriavidriocarpinteriaspredominantes", "cerramientoscubiertasCarpinteriavidriovidriospredominantes", "cerramientoscubiertasCubiertaplanatransitables", "cerramientoscubiertasCubiertainclinadacoberturas" })
@Entity(name = "CerramientoscubiertasType")
@Table(name = "AED_CERRAMIENTOSCUBIS")
@Inheritance(strategy = InheritanceType.JOINED)
public class CerramientoscubiertasType implements Serializable, Equals, HashCode {

	@XmlElement(name = "fachada_principal_superficie", required = true)
    @XmlJavaTypeAdapter(BigDecimalFormatter.class)
	protected BigDecimal fachadaPrincipalSuperficie;
	@XmlElement(name = "fachada_principal_porcentaje", required = true)
	protected String fachadaPrincipalPorcentaje;
	@XmlElement(name = "fachadaprincipal_camaraaire_tipo_id")
	protected int fachadaprincipalCamaraaireTipoId;
	@XmlElement(name = "fachadaprincipal_aislamientotermico_tipo_id")
	protected int fachadaprincipalAislamientotermicoTipoId;
	@XmlElement(name = "otras_fachadas_superficie", required = true)
	protected String otrasFachadasSuperficie;
	@XmlElement(name = "otras_fachadas_porcentaje", required = true)
	protected String otrasFachadasPorcentaje;
	@XmlElement(name = "otrasfachadas_camaraaire_tipo_id")
	protected int otrasfachadasCamaraaireTipoId;
	@XmlElement(name = "otrasfachadas_aislamientotermico_tipo_id")
	protected int otrasfachadasAislamientotermicoTipoId;
	@XmlElement(name = "carpinteria_vidrio_superficie", required = true)
	protected String carpinteriaVidrioSuperficie;
	@XmlElement(name = "carpinteria_vidrio_porcentaje", required = true)
	protected String carpinteriaVidrioPorcentaje;
	@XmlElement(name = "cubierta_plana_superficie", required = true)
	protected String cubiertaPlanaSuperficie;
	@XmlElement(name = "cubierta_plana_porcentaje", required = true)
	protected String cubiertaPlanaPorcentaje;
	@XmlElement(name = "cubiertaplana_aislamientotermico_tipo_id")
	protected int cubiertaplanaAislamientotermicoTipoId;
	@XmlElement(name = "cubiertaplana_laminaimpermeabilizante_tipo_id")
	protected int cubiertaplanaLaminaimpermeabilizanteTipoId;
	@XmlElement(name = "cubierta_inclinada_superficie", required = true)
	protected String cubiertaInclinadaSuperficie;
	@XmlElement(name = "cubierta_inclinada_porcentaje", required = true)
	protected String cubiertaInclinadaPorcentaje;
	@XmlElement(name = "cubiertainclinada_aislamientotermico_tipo_id")
	protected int cubiertainclinadaAislamientotermicoTipoId;
	@XmlElement(name = "carpinteriavidrio_carpinteriapredominante_texto", required = true)
	protected String carpinteriavidrioCarpinteriapredominanteTexto;
	@XmlElement(name = "carpinteriavidrio_vidriopredominante_texto", required = true)
	protected String carpinteriavidrioVidriopredominanteTexto;
	@XmlElement(name = "fachadaprincipal_acabadorevestido_texto", required = true)
	protected String fachadaprincipalAcabadorevestidoTexto;
	@XmlElement(name = "fachadaprincipal_acabadorevestido_porcentaje", required = true)
	protected String fachadaprincipalAcabadorevestidoPorcentaje;
	@XmlElement(name = "fachadaprincipal_acabadovisto_texto", required = true)
	protected String fachadaprincipalAcabadovistoTexto;
	@XmlElement(name = "fachadaprincipal_acabadovisto_porcentaje", required = true)
	protected String fachadaprincipalAcabadovistoPorcentaje;
	@XmlElement(name = "otrasfachadas_acabadorevestido_texto", required = true)
	protected String otrasfachadasAcabadorevestidoTexto;
	@XmlElement(name = "otrasfachadas_acabadorevestido_porcentaje", required = true)
	protected String otrasfachadasAcabadorevestidoPorcentaje;
	@XmlElement(name = "otrasfachadas_acabadovisto_texto", required = true)
	protected String otrasfachadasAcabadovistoTexto;
	@XmlElement(name = "otrasfachadas_acabadovisto_porcentaje", required = true)
	protected String otrasfachadasAcabadovistoPorcentaje;
	@XmlElement(required = true)
	protected String observaciones;
	@XmlElement(name = "cerramientoscubiertas_fachadaprincipalacabadosvistos", required = true)
	protected CerramientoscubiertasFachadaprincipalacabadosvistosType cerramientoscubiertasFachadaprincipalacabadosvistos;
	@XmlElement(name = "cerramientoscubiertas_fachadaprincipalacabadosrevestidos", required = true)
	protected CerramientoscubiertasFachadaprincipalacabadosrevestidosType cerramientoscubiertasFachadaprincipalacabadosrevestidos;
	@XmlElement(name = "cerramientoscubiertas_otrasfachadasacabadosvistos", required = true)
	protected CerramientoscubiertasOtrasfachadasacabadosvistosType cerramientoscubiertasOtrasfachadasacabadosvistos;
	@XmlElement(name = "cerramientoscubiertas_otrasfachadasacabadosrevestidos", required = true)
	protected CerramientoscubiertasOtrasfachadasacabadosrevestidosType cerramientoscubiertasOtrasfachadasacabadosrevestidos;
	@XmlElement(name = "cerramientoscubiertas_carpinteriavidriocarpinteriaspredominantes", required = true)
	protected CerramientoscubiertasCarpinteriavidriocarpinteriaspredominantesType cerramientoscubiertasCarpinteriavidriocarpinteriaspredominantes;
	@XmlElement(name = "cerramientoscubiertas_carpinteriavidriovidriospredominantes", required = true)
	protected CerramientoscubiertasCarpinteriavidriovidriospredominantesType cerramientoscubiertasCarpinteriavidriovidriospredominantes;
	@XmlElement(name = "cerramientoscubiertas_cubiertaplanatransitables", required = true)
	protected CerramientoscubiertasCubiertaplanatransitablesType cerramientoscubiertasCubiertaplanatransitables;
	@XmlElement(name = "cerramientoscubiertas_cubiertainclinadacoberturas", required = true)
	protected CerramientoscubiertasCubiertainclinadacoberturasType cerramientoscubiertasCubiertainclinadacoberturas;
	@XmlAttribute(name = "Hjid")
	protected Long hjid;

	/**
	 * Obtiene el valor de la propiedad fachadaPrincipalSuperficie.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	@Basic
	@Column(name = "FACHADA_PRINCIPAL_SUPERFICIE", precision = 20, scale = 10)
	public BigDecimal getFachadaPrincipalSuperficie() {
		return fachadaPrincipalSuperficie;
	}

	/**
	 * Define el valor de la propiedad fachadaPrincipalSuperficie.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setFachadaPrincipalSuperficie(BigDecimal value) {
		this.fachadaPrincipalSuperficie = value;
	}

	/**
	 * Obtiene el valor de la propiedad fachadaPrincipalPorcentaje.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "FACHADA_PRINCIPAL_PORCENTAJE", length = 255)
	public String getFachadaPrincipalPorcentaje() {
		return fachadaPrincipalPorcentaje;
	}

	/**
	 * Define el valor de la propiedad fachadaPrincipalPorcentaje.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setFachadaPrincipalPorcentaje(String value) {
		this.fachadaPrincipalPorcentaje = value;
	}

	/**
	 * Obtiene el valor de la propiedad fachadaprincipalCamaraaireTipoId.
	 * 
	 */
	@Basic
	@Column(name = "FACHADAPRINCIPAL_CAMARAAIRE_TIPO_ID")
	public int getFachadaprincipalCamaraaireTipoId() {
		return fachadaprincipalCamaraaireTipoId;
	}

	/**
	 * Define el valor de la propiedad fachadaprincipalCamaraaireTipoId.
	 * 
	 */
	public void setFachadaprincipalCamaraaireTipoId(int value) {
		this.fachadaprincipalCamaraaireTipoId = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * fachadaprincipalAislamientotermicoTipoId.
	 * 
	 */
	@Basic
	@Column(name = "FACHADAPRINCIPAL_AISLAMIENTOTERMICO_TIPO_ID")
	public int getFachadaprincipalAislamientotermicoTipoId() {
		return fachadaprincipalAislamientotermicoTipoId;
	}

	/**
	 * Define el valor de la propiedad fachadaprincipalAislamientotermicoTipoId.
	 * 
	 */
	public void setFachadaprincipalAislamientotermicoTipoId(int value) {
		this.fachadaprincipalAislamientotermicoTipoId = value;
	}

	/**
	 * Obtiene el valor de la propiedad otrasFachadasSuperficie.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "OTRAS_FACHADAS_SUPERFICIE", length = 255)
	public String getOtrasFachadasSuperficie() {
		return otrasFachadasSuperficie;
	}

	/**
	 * Define el valor de la propiedad otrasFachadasSuperficie.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setOtrasFachadasSuperficie(String value) {
		this.otrasFachadasSuperficie = value;
	}

	/**
	 * Obtiene el valor de la propiedad otrasFachadasPorcentaje.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "OTRAS_FACHADAS_PORCENTAJE", length = 255)
	public String getOtrasFachadasPorcentaje() {
		return otrasFachadasPorcentaje;
	}

	/**
	 * Define el valor de la propiedad otrasFachadasPorcentaje.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setOtrasFachadasPorcentaje(String value) {
		this.otrasFachadasPorcentaje = value;
	}

	/**
	 * Obtiene el valor de la propiedad otrasfachadasCamaraaireTipoId.
	 * 
	 */
	@Basic
	@Column(name = "OTRASFACHADAS_CAMARAAIRE_TIPO_ID")
	public int getOtrasfachadasCamaraaireTipoId() {
		return otrasfachadasCamaraaireTipoId;
	}

	/**
	 * Define el valor de la propiedad otrasfachadasCamaraaireTipoId.
	 * 
	 */
	public void setOtrasfachadasCamaraaireTipoId(int value) {
		this.otrasfachadasCamaraaireTipoId = value;
	}

	/**
	 * Obtiene el valor de la propiedad otrasfachadasAislamientotermicoTipoId.
	 * 
	 */
	@Basic
	@Column(name = "OTRASFACHADAS_AISLAMIENTOTERMICO_TIPO_ID")
	public int getOtrasfachadasAislamientotermicoTipoId() {
		return otrasfachadasAislamientotermicoTipoId;
	}

	/**
	 * Define el valor de la propiedad otrasfachadasAislamientotermicoTipoId.
	 * 
	 */
	public void setOtrasfachadasAislamientotermicoTipoId(int value) {
		this.otrasfachadasAislamientotermicoTipoId = value;
	}

	/**
	 * Obtiene el valor de la propiedad carpinteriaVidrioSuperficie.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "CARPINTERIA_VIDRIO_SUPERFICIE", length = 255)
	public String getCarpinteriaVidrioSuperficie() {
		return carpinteriaVidrioSuperficie;
	}

	/**
	 * Define el valor de la propiedad carpinteriaVidrioSuperficie.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCarpinteriaVidrioSuperficie(String value) {
		this.carpinteriaVidrioSuperficie = value;
	}

	/**
	 * Obtiene el valor de la propiedad carpinteriaVidrioPorcentaje.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "CARPINTERIA_VIDRIO_PORCENTAJE", length = 255)
	public String getCarpinteriaVidrioPorcentaje() {
		return carpinteriaVidrioPorcentaje;
	}

	/**
	 * Define el valor de la propiedad carpinteriaVidrioPorcentaje.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCarpinteriaVidrioPorcentaje(String value) {
		this.carpinteriaVidrioPorcentaje = value;
	}

	/**
	 * Obtiene el valor de la propiedad cubiertaPlanaSuperficie.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "CUBIERTA_PLANA_SUPERFICIE", length = 255)
	public String getCubiertaPlanaSuperficie() {
		return cubiertaPlanaSuperficie;
	}

	/**
	 * Define el valor de la propiedad cubiertaPlanaSuperficie.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCubiertaPlanaSuperficie(String value) {
		this.cubiertaPlanaSuperficie = value;
	}

	/**
	 * Obtiene el valor de la propiedad cubiertaPlanaPorcentaje.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "CUBIERTA_PLANA_PORCENTAJE", length = 255)
	public String getCubiertaPlanaPorcentaje() {
		return cubiertaPlanaPorcentaje;
	}

	/**
	 * Define el valor de la propiedad cubiertaPlanaPorcentaje.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCubiertaPlanaPorcentaje(String value) {
		this.cubiertaPlanaPorcentaje = value;
	}

	/**
	 * Obtiene el valor de la propiedad cubiertaplanaAislamientotermicoTipoId.
	 * 
	 */
	@Basic
	@Column(name = "CUBIERTAPLANA_AISLAMIENTOTERMICO_TIPO_ID", precision = 10, scale = 0)
	public int getCubiertaplanaAislamientotermicoTipoId() {
		return cubiertaplanaAislamientotermicoTipoId;
	}

	/**
	 * Define el valor de la propiedad cubiertaplanaAislamientotermicoTipoId.
	 * 
	 */
	public void setCubiertaplanaAislamientotermicoTipoId(int value) {
		this.cubiertaplanaAislamientotermicoTipoId = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * cubiertaplanaLaminaimpermeabilizanteTipoId.
	 * 
	 */
	@Basic
	@Column(name = "CUBIERTAPLANA_LAMINAIMPERMEABILIZANTE_TIPO_ID", precision = 10, scale = 0)
	public int getCubiertaplanaLaminaimpermeabilizanteTipoId() {
		return cubiertaplanaLaminaimpermeabilizanteTipoId;
	}

	/**
	 * Define el valor de la propiedad
	 * cubiertaplanaLaminaimpermeabilizanteTipoId.
	 * 
	 */
	public void setCubiertaplanaLaminaimpermeabilizanteTipoId(int value) {
		this.cubiertaplanaLaminaimpermeabilizanteTipoId = value;
	}

	/**
	 * Obtiene el valor de la propiedad cubiertaInclinadaSuperficie.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "CUBIERTA_INCLINADA_SUPERFICIE", length = 255)
	public String getCubiertaInclinadaSuperficie() {
		return cubiertaInclinadaSuperficie;
	}

	/**
	 * Define el valor de la propiedad cubiertaInclinadaSuperficie.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCubiertaInclinadaSuperficie(String value) {
		this.cubiertaInclinadaSuperficie = value;
	}

	/**
	 * Obtiene el valor de la propiedad cubiertaInclinadaPorcentaje.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "CUBIERTA_INCLINADA_PORCENTAJE", length = 255)
	public String getCubiertaInclinadaPorcentaje() {
		return cubiertaInclinadaPorcentaje;
	}

	/**
	 * Define el valor de la propiedad cubiertaInclinadaPorcentaje.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCubiertaInclinadaPorcentaje(String value) {
		this.cubiertaInclinadaPorcentaje = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * cubiertainclinadaAislamientotermicoTipoId.
	 * 
	 */
	@Basic
	@Column(name = "CUBIERTAINCLINADA_AISLAMIENTOTERMICO_TIPO_ID", precision = 10, scale = 0)
	public int getCubiertainclinadaAislamientotermicoTipoId() {
		return cubiertainclinadaAislamientotermicoTipoId;
	}

	/**
	 * Define el valor de la propiedad
	 * cubiertainclinadaAislamientotermicoTipoId.
	 * 
	 */
	public void setCubiertainclinadaAislamientotermicoTipoId(int value) {
		this.cubiertainclinadaAislamientotermicoTipoId = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * carpinteriavidrioCarpinteriapredominanteTexto.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "CARPINTERIAVIDRIO_CARPINTERIAPREDOMINANTE_TEXTO", length = 255)
	public String getCarpinteriavidrioCarpinteriapredominanteTexto() {
		return carpinteriavidrioCarpinteriapredominanteTexto;
	}

	/**
	 * Define el valor de la propiedad
	 * carpinteriavidrioCarpinteriapredominanteTexto.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCarpinteriavidrioCarpinteriapredominanteTexto(String value) {
		this.carpinteriavidrioCarpinteriapredominanteTexto = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * carpinteriavidrioVidriopredominanteTexto.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "CARPINTERIAVIDRIO_VIDRIOPREDOMINANTE_TEXTO", length = 255)
	public String getCarpinteriavidrioVidriopredominanteTexto() {
		return carpinteriavidrioVidriopredominanteTexto;
	}

	/**
	 * Define el valor de la propiedad carpinteriavidrioVidriopredominanteTexto.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCarpinteriavidrioVidriopredominanteTexto(String value) {
		this.carpinteriavidrioVidriopredominanteTexto = value;
	}

	/**
	 * Obtiene el valor de la propiedad fachadaprincipalAcabadorevestidoTexto.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "FACHADAPRINCIPAL_ACABADOREVESTIDO_TEXTO", length = 255)
	public String getFachadaprincipalAcabadorevestidoTexto() {
		return fachadaprincipalAcabadorevestidoTexto;
	}

	/**
	 * Define el valor de la propiedad fachadaprincipalAcabadorevestidoTexto.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setFachadaprincipalAcabadorevestidoTexto(String value) {
		this.fachadaprincipalAcabadorevestidoTexto = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * fachadaprincipalAcabadorevestidoPorcentaje.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "FACHADAPRINCIPAL_ACABADOREVESTIDO_PORCENTAJE", length = 255)
	public String getFachadaprincipalAcabadorevestidoPorcentaje() {
		return fachadaprincipalAcabadorevestidoPorcentaje;
	}

	/**
	 * Define el valor de la propiedad
	 * fachadaprincipalAcabadorevestidoPorcentaje.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setFachadaprincipalAcabadorevestidoPorcentaje(String value) {
		this.fachadaprincipalAcabadorevestidoPorcentaje = value;
	}

	/**
	 * Obtiene el valor de la propiedad fachadaprincipalAcabadovistoTexto.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "FACHADAPRINCIPAL_ACABADOVISTO_TEXTO", length = 255)
	public String getFachadaprincipalAcabadovistoTexto() {
		return fachadaprincipalAcabadovistoTexto;
	}

	/**
	 * Define el valor de la propiedad fachadaprincipalAcabadovistoTexto.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setFachadaprincipalAcabadovistoTexto(String value) {
		this.fachadaprincipalAcabadovistoTexto = value;
	}

	/**
	 * Obtiene el valor de la propiedad fachadaprincipalAcabadovistoPorcentaje.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "FACHADAPRINCIPAL_ACABADOVISTO_PORCENTAJE", length = 255)
	public String getFachadaprincipalAcabadovistoPorcentaje() {
		return fachadaprincipalAcabadovistoPorcentaje;
	}

	/**
	 * Define el valor de la propiedad fachadaprincipalAcabadovistoPorcentaje.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setFachadaprincipalAcabadovistoPorcentaje(String value) {
		this.fachadaprincipalAcabadovistoPorcentaje = value;
	}

	/**
	 * Obtiene el valor de la propiedad otrasfachadasAcabadorevestidoTexto.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "OTRASFACHADAS_ACABADOREVESTIDO_TEXTO", length = 255)
	public String getOtrasfachadasAcabadorevestidoTexto() {
		return otrasfachadasAcabadorevestidoTexto;
	}

	/**
	 * Define el valor de la propiedad otrasfachadasAcabadorevestidoTexto.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setOtrasfachadasAcabadorevestidoTexto(String value) {
		this.otrasfachadasAcabadorevestidoTexto = value;
	}

	/**
	 * Obtiene el valor de la propiedad otrasfachadasAcabadorevestidoPorcentaje.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "OTRASFACHADAS_ACABADOREVESTIDO_PORCENTAJE", length = 255)
	public String getOtrasfachadasAcabadorevestidoPorcentaje() {
		return otrasfachadasAcabadorevestidoPorcentaje;
	}

	/**
	 * Define el valor de la propiedad otrasfachadasAcabadorevestidoPorcentaje.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setOtrasfachadasAcabadorevestidoPorcentaje(String value) {
		this.otrasfachadasAcabadorevestidoPorcentaje = value;
	}

	/**
	 * Obtiene el valor de la propiedad otrasfachadasAcabadovistoTexto.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "OTRASFACHADAS_ACABADOVISTO_TEXTO", length = 255)
	public String getOtrasfachadasAcabadovistoTexto() {
		return otrasfachadasAcabadovistoTexto;
	}

	/**
	 * Define el valor de la propiedad otrasfachadasAcabadovistoTexto.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setOtrasfachadasAcabadovistoTexto(String value) {
		this.otrasfachadasAcabadovistoTexto = value;
	}

	/**
	 * Obtiene el valor de la propiedad otrasfachadasAcabadovistoPorcentaje.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "OTRASFACHADAS_ACABADOVISTO_PORCENTAJE", length = 255)
	public String getOtrasfachadasAcabadovistoPorcentaje() {
		return otrasfachadasAcabadovistoPorcentaje;
	}

	/**
	 * Define el valor de la propiedad otrasfachadasAcabadovistoPorcentaje.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setOtrasfachadasAcabadovistoPorcentaje(String value) {
		this.otrasfachadasAcabadovistoPorcentaje = value;
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
	 * cerramientoscubiertasFachadaprincipalacabadosvistos.
	 * 
	 * @return possible object is
	 *         {@link CerramientoscubiertasFachadaprincipalacabadosvistosType }
	 * 
	 */
	@ManyToOne(targetEntity = CerramientoscubiertasFachadaprincipalacabadosvistosType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "CERRAMIENTOSCUBIERTAS_FACHADAPRINCIPALACABADOSVISTOS_AED_CERRAMIENTOSCUBIS_HJID")
	public CerramientoscubiertasFachadaprincipalacabadosvistosType getCerramientoscubiertasFachadaprincipalacabadosvistos() {
		return cerramientoscubiertasFachadaprincipalacabadosvistos;
	}

	/**
	 * Define el valor de la propiedad
	 * cerramientoscubiertasFachadaprincipalacabadosvistos.
	 * 
	 * @param value
	 *            allowed object is
	 *            {@link CerramientoscubiertasFachadaprincipalacabadosvistosType }
	 * 
	 */
	public void setCerramientoscubiertasFachadaprincipalacabadosvistos(CerramientoscubiertasFachadaprincipalacabadosvistosType value) {
		this.cerramientoscubiertasFachadaprincipalacabadosvistos = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * cerramientoscubiertasFachadaprincipalacabadosrevestidos.
	 * 
	 * @return possible object is
	 *         {@link CerramientoscubiertasFachadaprincipalacabadosrevestidosType }
	 * 
	 */
	@ManyToOne(targetEntity = CerramientoscubiertasFachadaprincipalacabadosrevestidosType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "CERRAMIENTOSCUBIERTAS_FACHADAPRINCIPALACABADOSREVESTIDOS_AED_CERRAMIENTOSCUBIS_HJID")
	public CerramientoscubiertasFachadaprincipalacabadosrevestidosType getCerramientoscubiertasFachadaprincipalacabadosrevestidos() {
		return cerramientoscubiertasFachadaprincipalacabadosrevestidos;
	}

	/**
	 * Define el valor de la propiedad
	 * cerramientoscubiertasFachadaprincipalacabadosrevestidos.
	 * 
	 * @param value
	 *            allowed object is
	 *            {@link CerramientoscubiertasFachadaprincipalacabadosrevestidosType }
	 * 
	 */
	public void setCerramientoscubiertasFachadaprincipalacabadosrevestidos(CerramientoscubiertasFachadaprincipalacabadosrevestidosType value) {
		this.cerramientoscubiertasFachadaprincipalacabadosrevestidos = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * cerramientoscubiertasOtrasfachadasacabadosvistos.
	 * 
	 * @return possible object is
	 *         {@link CerramientoscubiertasOtrasfachadasacabadosvistosType }
	 * 
	 */
	@ManyToOne(targetEntity = CerramientoscubiertasOtrasfachadasacabadosvistosType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "CERRAMIENTOSCUBIERTAS_OTRASFACHADASACABADOSVISTOS_AED_CERRAMIENTOSCUBIS_HJID")
	public CerramientoscubiertasOtrasfachadasacabadosvistosType getCerramientoscubiertasOtrasfachadasacabadosvistos() {
		return cerramientoscubiertasOtrasfachadasacabadosvistos;
	}

	/**
	 * Define el valor de la propiedad
	 * cerramientoscubiertasOtrasfachadasacabadosvistos.
	 * 
	 * @param value
	 *            allowed object is
	 *            {@link CerramientoscubiertasOtrasfachadasacabadosvistosType }
	 * 
	 */
	public void setCerramientoscubiertasOtrasfachadasacabadosvistos(CerramientoscubiertasOtrasfachadasacabadosvistosType value) {
		this.cerramientoscubiertasOtrasfachadasacabadosvistos = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * cerramientoscubiertasOtrasfachadasacabadosrevestidos.
	 * 
	 * @return possible object is
	 *         {@link CerramientoscubiertasOtrasfachadasacabadosrevestidosType }
	 * 
	 */
	@ManyToOne(targetEntity = CerramientoscubiertasOtrasfachadasacabadosrevestidosType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "CERRAMIENTOSCUBIERTAS_OTRASFACHADASACABADOSREVESTIDOS_AED_CERRAMIENTOSCUBIS_HJID")
	public CerramientoscubiertasOtrasfachadasacabadosrevestidosType getCerramientoscubiertasOtrasfachadasacabadosrevestidos() {
		return cerramientoscubiertasOtrasfachadasacabadosrevestidos;
	}

	/**
	 * Define el valor de la propiedad
	 * cerramientoscubiertasOtrasfachadasacabadosrevestidos.
	 * 
	 * @param value
	 *            allowed object is
	 *            {@link CerramientoscubiertasOtrasfachadasacabadosrevestidosType }
	 * 
	 */
	public void setCerramientoscubiertasOtrasfachadasacabadosrevestidos(CerramientoscubiertasOtrasfachadasacabadosrevestidosType value) {
		this.cerramientoscubiertasOtrasfachadasacabadosrevestidos = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * cerramientoscubiertasCarpinteriavidriocarpinteriaspredominantes.
	 * 
	 * @return possible object is
	 *         {@link CerramientoscubiertasCarpinteriavidriocarpinteriaspredominantesType }
	 * 
	 */
	@ManyToOne(targetEntity = CerramientoscubiertasCarpinteriavidriocarpinteriaspredominantesType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "CERRAMIENTOSCUBIERTAS_CARPINTERIAVIDRIOCARPINTERIASPREDOMINANTES_AED_CERRAMIENTOSCUBIS_HJID")
	public CerramientoscubiertasCarpinteriavidriocarpinteriaspredominantesType getCerramientoscubiertasCarpinteriavidriocarpinteriaspredominantes() {
		return cerramientoscubiertasCarpinteriavidriocarpinteriaspredominantes;
	}

	/**
	 * Define el valor de la propiedad
	 * cerramientoscubiertasCarpinteriavidriocarpinteriaspredominantes.
	 * 
	 * @param value
	 *            allowed object is
	 *            {@link CerramientoscubiertasCarpinteriavidriocarpinteriaspredominantesType }
	 * 
	 */
	public void setCerramientoscubiertasCarpinteriavidriocarpinteriaspredominantes(CerramientoscubiertasCarpinteriavidriocarpinteriaspredominantesType value) {
		this.cerramientoscubiertasCarpinteriavidriocarpinteriaspredominantes = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * cerramientoscubiertasCarpinteriavidriovidriospredominantes.
	 * 
	 * @return possible object is
	 *         {@link CerramientoscubiertasCarpinteriavidriovidriospredominantesType }
	 * 
	 */
	@ManyToOne(targetEntity = CerramientoscubiertasCarpinteriavidriovidriospredominantesType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "CERRAMIENTOSCUBIERTAS_CARPINTERIAVIDRIOVIDRIOSPREDOMINANTES_AED_CERRAMIENTOSCUBIS_HJID")
	public CerramientoscubiertasCarpinteriavidriovidriospredominantesType getCerramientoscubiertasCarpinteriavidriovidriospredominantes() {
		return cerramientoscubiertasCarpinteriavidriovidriospredominantes;
	}

	/**
	 * Define el valor de la propiedad
	 * cerramientoscubiertasCarpinteriavidriovidriospredominantes.
	 * 
	 * @param value
	 *            allowed object is
	 *            {@link CerramientoscubiertasCarpinteriavidriovidriospredominantesType }
	 * 
	 */
	public void setCerramientoscubiertasCarpinteriavidriovidriospredominantes(CerramientoscubiertasCarpinteriavidriovidriospredominantesType value) {
		this.cerramientoscubiertasCarpinteriavidriovidriospredominantes = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * cerramientoscubiertasCubiertaplanatransitables.
	 * 
	 * @return possible object is
	 *         {@link CerramientoscubiertasCubiertaplanatransitablesType }
	 * 
	 */
	@ManyToOne(targetEntity = CerramientoscubiertasCubiertaplanatransitablesType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "CERRAMIENTOSCUBIERTAS_CUBIERTAPLANATRANSITABLES_AED_CERRAMIENTOSCUBIS_HJID")
	public CerramientoscubiertasCubiertaplanatransitablesType getCerramientoscubiertasCubiertaplanatransitables() {
		return cerramientoscubiertasCubiertaplanatransitables;
	}

	/**
	 * Define el valor de la propiedad
	 * cerramientoscubiertasCubiertaplanatransitables.
	 * 
	 * @param value
	 *            allowed object is
	 *            {@link CerramientoscubiertasCubiertaplanatransitablesType }
	 * 
	 */
	public void setCerramientoscubiertasCubiertaplanatransitables(CerramientoscubiertasCubiertaplanatransitablesType value) {
		this.cerramientoscubiertasCubiertaplanatransitables = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * cerramientoscubiertasCubiertainclinadacoberturas.
	 * 
	 * @return possible object is
	 *         {@link CerramientoscubiertasCubiertainclinadacoberturasType }
	 * 
	 */
	@ManyToOne(targetEntity = CerramientoscubiertasCubiertainclinadacoberturasType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "CERRAMIENTOSCUBIERTAS_CUBIERTAINCLINADACOBERTURAS_AED_CERRAMIENTOSCUBIS_HJID")
	public CerramientoscubiertasCubiertainclinadacoberturasType getCerramientoscubiertasCubiertainclinadacoberturas() {
		return cerramientoscubiertasCubiertainclinadacoberturas;
	}

	/**
	 * Define el valor de la propiedad
	 * cerramientoscubiertasCubiertainclinadacoberturas.
	 * 
	 * @param value
	 *            allowed object is
	 *            {@link CerramientoscubiertasCubiertainclinadacoberturasType }
	 * 
	 */
	public void setCerramientoscubiertasCubiertainclinadacoberturas(CerramientoscubiertasCubiertainclinadacoberturasType value) {
		this.cerramientoscubiertasCubiertainclinadacoberturas = value;
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
		final CerramientoscubiertasType that = ((CerramientoscubiertasType) object);
		{
			BigDecimal lhsFachadaPrincipalSuperficie;
			lhsFachadaPrincipalSuperficie = this.getFachadaPrincipalSuperficie();
			BigDecimal rhsFachadaPrincipalSuperficie;
			rhsFachadaPrincipalSuperficie = that.getFachadaPrincipalSuperficie();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "fachadaPrincipalSuperficie", lhsFachadaPrincipalSuperficie), LocatorUtils.property(thatLocator, "fachadaPrincipalSuperficie", rhsFachadaPrincipalSuperficie), lhsFachadaPrincipalSuperficie, rhsFachadaPrincipalSuperficie)) {
				return false;
			}
		}
		{
			String lhsFachadaPrincipalPorcentaje;
			lhsFachadaPrincipalPorcentaje = this.getFachadaPrincipalPorcentaje();
			String rhsFachadaPrincipalPorcentaje;
			rhsFachadaPrincipalPorcentaje = that.getFachadaPrincipalPorcentaje();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "fachadaPrincipalPorcentaje", lhsFachadaPrincipalPorcentaje), LocatorUtils.property(thatLocator, "fachadaPrincipalPorcentaje", rhsFachadaPrincipalPorcentaje), lhsFachadaPrincipalPorcentaje, rhsFachadaPrincipalPorcentaje)) {
				return false;
			}
		}
		{
			int lhsFachadaprincipalCamaraaireTipoId;
			lhsFachadaprincipalCamaraaireTipoId = this.getFachadaprincipalCamaraaireTipoId();
			int rhsFachadaprincipalCamaraaireTipoId;
			rhsFachadaprincipalCamaraaireTipoId = that.getFachadaprincipalCamaraaireTipoId();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "fachadaprincipalCamaraaireTipoId", lhsFachadaprincipalCamaraaireTipoId), LocatorUtils.property(thatLocator, "fachadaprincipalCamaraaireTipoId", rhsFachadaprincipalCamaraaireTipoId), lhsFachadaprincipalCamaraaireTipoId, rhsFachadaprincipalCamaraaireTipoId)) {
				return false;
			}
		}
		{
			int lhsFachadaprincipalAislamientotermicoTipoId;
			lhsFachadaprincipalAislamientotermicoTipoId = this.getFachadaprincipalAislamientotermicoTipoId();
			int rhsFachadaprincipalAislamientotermicoTipoId;
			rhsFachadaprincipalAislamientotermicoTipoId = that.getFachadaprincipalAislamientotermicoTipoId();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "fachadaprincipalAislamientotermicoTipoId", lhsFachadaprincipalAislamientotermicoTipoId), LocatorUtils.property(thatLocator, "fachadaprincipalAislamientotermicoTipoId", rhsFachadaprincipalAislamientotermicoTipoId), lhsFachadaprincipalAislamientotermicoTipoId, rhsFachadaprincipalAislamientotermicoTipoId)) {
				return false;
			}
		}
		{
			String lhsOtrasFachadasSuperficie;
			lhsOtrasFachadasSuperficie = this.getOtrasFachadasSuperficie();
			String rhsOtrasFachadasSuperficie;
			rhsOtrasFachadasSuperficie = that.getOtrasFachadasSuperficie();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "otrasFachadasSuperficie", lhsOtrasFachadasSuperficie), LocatorUtils.property(thatLocator, "otrasFachadasSuperficie", rhsOtrasFachadasSuperficie), lhsOtrasFachadasSuperficie, rhsOtrasFachadasSuperficie)) {
				return false;
			}
		}
		{
			String lhsOtrasFachadasPorcentaje;
			lhsOtrasFachadasPorcentaje = this.getOtrasFachadasPorcentaje();
			String rhsOtrasFachadasPorcentaje;
			rhsOtrasFachadasPorcentaje = that.getOtrasFachadasPorcentaje();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "otrasFachadasPorcentaje", lhsOtrasFachadasPorcentaje), LocatorUtils.property(thatLocator, "otrasFachadasPorcentaje", rhsOtrasFachadasPorcentaje), lhsOtrasFachadasPorcentaje, rhsOtrasFachadasPorcentaje)) {
				return false;
			}
		}
		{
			int lhsOtrasfachadasCamaraaireTipoId;
			lhsOtrasfachadasCamaraaireTipoId = this.getOtrasfachadasCamaraaireTipoId();
			int rhsOtrasfachadasCamaraaireTipoId;
			rhsOtrasfachadasCamaraaireTipoId = that.getOtrasfachadasCamaraaireTipoId();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "otrasfachadasCamaraaireTipoId", lhsOtrasfachadasCamaraaireTipoId), LocatorUtils.property(thatLocator, "otrasfachadasCamaraaireTipoId", rhsOtrasfachadasCamaraaireTipoId), lhsOtrasfachadasCamaraaireTipoId, rhsOtrasfachadasCamaraaireTipoId)) {
				return false;
			}
		}
		{
			int lhsOtrasfachadasAislamientotermicoTipoId;
			lhsOtrasfachadasAislamientotermicoTipoId = this.getOtrasfachadasAislamientotermicoTipoId();
			int rhsOtrasfachadasAislamientotermicoTipoId;
			rhsOtrasfachadasAislamientotermicoTipoId = that.getOtrasfachadasAislamientotermicoTipoId();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "otrasfachadasAislamientotermicoTipoId", lhsOtrasfachadasAislamientotermicoTipoId), LocatorUtils.property(thatLocator, "otrasfachadasAislamientotermicoTipoId", rhsOtrasfachadasAislamientotermicoTipoId), lhsOtrasfachadasAislamientotermicoTipoId, rhsOtrasfachadasAislamientotermicoTipoId)) {
				return false;
			}
		}
		{
			String lhsCarpinteriaVidrioSuperficie;
			lhsCarpinteriaVidrioSuperficie = this.getCarpinteriaVidrioSuperficie();
			String rhsCarpinteriaVidrioSuperficie;
			rhsCarpinteriaVidrioSuperficie = that.getCarpinteriaVidrioSuperficie();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "carpinteriaVidrioSuperficie", lhsCarpinteriaVidrioSuperficie), LocatorUtils.property(thatLocator, "carpinteriaVidrioSuperficie", rhsCarpinteriaVidrioSuperficie), lhsCarpinteriaVidrioSuperficie, rhsCarpinteriaVidrioSuperficie)) {
				return false;
			}
		}
		{
			String lhsCarpinteriaVidrioPorcentaje;
			lhsCarpinteriaVidrioPorcentaje = this.getCarpinteriaVidrioPorcentaje();
			String rhsCarpinteriaVidrioPorcentaje;
			rhsCarpinteriaVidrioPorcentaje = that.getCarpinteriaVidrioPorcentaje();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "carpinteriaVidrioPorcentaje", lhsCarpinteriaVidrioPorcentaje), LocatorUtils.property(thatLocator, "carpinteriaVidrioPorcentaje", rhsCarpinteriaVidrioPorcentaje), lhsCarpinteriaVidrioPorcentaje, rhsCarpinteriaVidrioPorcentaje)) {
				return false;
			}
		}
		{
			String lhsCubiertaPlanaSuperficie;
			lhsCubiertaPlanaSuperficie = this.getCubiertaPlanaSuperficie();
			String rhsCubiertaPlanaSuperficie;
			rhsCubiertaPlanaSuperficie = that.getCubiertaPlanaSuperficie();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "cubiertaPlanaSuperficie", lhsCubiertaPlanaSuperficie), LocatorUtils.property(thatLocator, "cubiertaPlanaSuperficie", rhsCubiertaPlanaSuperficie), lhsCubiertaPlanaSuperficie, rhsCubiertaPlanaSuperficie)) {
				return false;
			}
		}
		{
			String lhsCubiertaPlanaPorcentaje;
			lhsCubiertaPlanaPorcentaje = this.getCubiertaPlanaPorcentaje();
			String rhsCubiertaPlanaPorcentaje;
			rhsCubiertaPlanaPorcentaje = that.getCubiertaPlanaPorcentaje();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "cubiertaPlanaPorcentaje", lhsCubiertaPlanaPorcentaje), LocatorUtils.property(thatLocator, "cubiertaPlanaPorcentaje", rhsCubiertaPlanaPorcentaje), lhsCubiertaPlanaPorcentaje, rhsCubiertaPlanaPorcentaje)) {
				return false;
			}
		}
		{
			int lhsCubiertaplanaAislamientotermicoTipoId;
			lhsCubiertaplanaAislamientotermicoTipoId = this.getCubiertaplanaAislamientotermicoTipoId();
			int rhsCubiertaplanaAislamientotermicoTipoId;
			rhsCubiertaplanaAislamientotermicoTipoId = that.getCubiertaplanaAislamientotermicoTipoId();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "cubiertaplanaAislamientotermicoTipoId", lhsCubiertaplanaAislamientotermicoTipoId), LocatorUtils.property(thatLocator, "cubiertaplanaAislamientotermicoTipoId", rhsCubiertaplanaAislamientotermicoTipoId), lhsCubiertaplanaAislamientotermicoTipoId, rhsCubiertaplanaAislamientotermicoTipoId)) {
				return false;
			}
		}
		{
			int lhsCubiertaplanaLaminaimpermeabilizanteTipoId;
			lhsCubiertaplanaLaminaimpermeabilizanteTipoId = this.getCubiertaplanaLaminaimpermeabilizanteTipoId();
			int rhsCubiertaplanaLaminaimpermeabilizanteTipoId;
			rhsCubiertaplanaLaminaimpermeabilizanteTipoId = that.getCubiertaplanaLaminaimpermeabilizanteTipoId();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "cubiertaplanaLaminaimpermeabilizanteTipoId", lhsCubiertaplanaLaminaimpermeabilizanteTipoId), LocatorUtils.property(thatLocator, "cubiertaplanaLaminaimpermeabilizanteTipoId", rhsCubiertaplanaLaminaimpermeabilizanteTipoId), lhsCubiertaplanaLaminaimpermeabilizanteTipoId, rhsCubiertaplanaLaminaimpermeabilizanteTipoId)) {
				return false;
			}
		}
		{
			String lhsCubiertaInclinadaSuperficie;
			lhsCubiertaInclinadaSuperficie = this.getCubiertaInclinadaSuperficie();
			String rhsCubiertaInclinadaSuperficie;
			rhsCubiertaInclinadaSuperficie = that.getCubiertaInclinadaSuperficie();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "cubiertaInclinadaSuperficie", lhsCubiertaInclinadaSuperficie), LocatorUtils.property(thatLocator, "cubiertaInclinadaSuperficie", rhsCubiertaInclinadaSuperficie), lhsCubiertaInclinadaSuperficie, rhsCubiertaInclinadaSuperficie)) {
				return false;
			}
		}
		{
			String lhsCubiertaInclinadaPorcentaje;
			lhsCubiertaInclinadaPorcentaje = this.getCubiertaInclinadaPorcentaje();
			String rhsCubiertaInclinadaPorcentaje;
			rhsCubiertaInclinadaPorcentaje = that.getCubiertaInclinadaPorcentaje();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "cubiertaInclinadaPorcentaje", lhsCubiertaInclinadaPorcentaje), LocatorUtils.property(thatLocator, "cubiertaInclinadaPorcentaje", rhsCubiertaInclinadaPorcentaje), lhsCubiertaInclinadaPorcentaje, rhsCubiertaInclinadaPorcentaje)) {
				return false;
			}
		}
		{
			int lhsCubiertainclinadaAislamientotermicoTipoId;
			lhsCubiertainclinadaAislamientotermicoTipoId = this.getCubiertainclinadaAislamientotermicoTipoId();
			int rhsCubiertainclinadaAislamientotermicoTipoId;
			rhsCubiertainclinadaAislamientotermicoTipoId = that.getCubiertainclinadaAislamientotermicoTipoId();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "cubiertainclinadaAislamientotermicoTipoId", lhsCubiertainclinadaAislamientotermicoTipoId), LocatorUtils.property(thatLocator, "cubiertainclinadaAislamientotermicoTipoId", rhsCubiertainclinadaAislamientotermicoTipoId), lhsCubiertainclinadaAislamientotermicoTipoId, rhsCubiertainclinadaAislamientotermicoTipoId)) {
				return false;
			}
		}
		{
			String lhsCarpinteriavidrioCarpinteriapredominanteTexto;
			lhsCarpinteriavidrioCarpinteriapredominanteTexto = this.getCarpinteriavidrioCarpinteriapredominanteTexto();
			String rhsCarpinteriavidrioCarpinteriapredominanteTexto;
			rhsCarpinteriavidrioCarpinteriapredominanteTexto = that.getCarpinteriavidrioCarpinteriapredominanteTexto();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "carpinteriavidrioCarpinteriapredominanteTexto", lhsCarpinteriavidrioCarpinteriapredominanteTexto), LocatorUtils.property(thatLocator, "carpinteriavidrioCarpinteriapredominanteTexto", rhsCarpinteriavidrioCarpinteriapredominanteTexto), lhsCarpinteriavidrioCarpinteriapredominanteTexto, rhsCarpinteriavidrioCarpinteriapredominanteTexto)) {
				return false;
			}
		}
		{
			String lhsCarpinteriavidrioVidriopredominanteTexto;
			lhsCarpinteriavidrioVidriopredominanteTexto = this.getCarpinteriavidrioVidriopredominanteTexto();
			String rhsCarpinteriavidrioVidriopredominanteTexto;
			rhsCarpinteriavidrioVidriopredominanteTexto = that.getCarpinteriavidrioVidriopredominanteTexto();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "carpinteriavidrioVidriopredominanteTexto", lhsCarpinteriavidrioVidriopredominanteTexto), LocatorUtils.property(thatLocator, "carpinteriavidrioVidriopredominanteTexto", rhsCarpinteriavidrioVidriopredominanteTexto), lhsCarpinteriavidrioVidriopredominanteTexto, rhsCarpinteriavidrioVidriopredominanteTexto)) {
				return false;
			}
		}
		{
			String lhsFachadaprincipalAcabadorevestidoTexto;
			lhsFachadaprincipalAcabadorevestidoTexto = this.getFachadaprincipalAcabadorevestidoTexto();
			String rhsFachadaprincipalAcabadorevestidoTexto;
			rhsFachadaprincipalAcabadorevestidoTexto = that.getFachadaprincipalAcabadorevestidoTexto();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "fachadaprincipalAcabadorevestidoTexto", lhsFachadaprincipalAcabadorevestidoTexto), LocatorUtils.property(thatLocator, "fachadaprincipalAcabadorevestidoTexto", rhsFachadaprincipalAcabadorevestidoTexto), lhsFachadaprincipalAcabadorevestidoTexto, rhsFachadaprincipalAcabadorevestidoTexto)) {
				return false;
			}
		}
		{
			String lhsFachadaprincipalAcabadorevestidoPorcentaje;
			lhsFachadaprincipalAcabadorevestidoPorcentaje = this.getFachadaprincipalAcabadorevestidoPorcentaje();
			String rhsFachadaprincipalAcabadorevestidoPorcentaje;
			rhsFachadaprincipalAcabadorevestidoPorcentaje = that.getFachadaprincipalAcabadorevestidoPorcentaje();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "fachadaprincipalAcabadorevestidoPorcentaje", lhsFachadaprincipalAcabadorevestidoPorcentaje), LocatorUtils.property(thatLocator, "fachadaprincipalAcabadorevestidoPorcentaje", rhsFachadaprincipalAcabadorevestidoPorcentaje), lhsFachadaprincipalAcabadorevestidoPorcentaje, rhsFachadaprincipalAcabadorevestidoPorcentaje)) {
				return false;
			}
		}
		{
			String lhsFachadaprincipalAcabadovistoTexto;
			lhsFachadaprincipalAcabadovistoTexto = this.getFachadaprincipalAcabadovistoTexto();
			String rhsFachadaprincipalAcabadovistoTexto;
			rhsFachadaprincipalAcabadovistoTexto = that.getFachadaprincipalAcabadovistoTexto();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "fachadaprincipalAcabadovistoTexto", lhsFachadaprincipalAcabadovistoTexto), LocatorUtils.property(thatLocator, "fachadaprincipalAcabadovistoTexto", rhsFachadaprincipalAcabadovistoTexto), lhsFachadaprincipalAcabadovistoTexto, rhsFachadaprincipalAcabadovistoTexto)) {
				return false;
			}
		}
		{
			String lhsFachadaprincipalAcabadovistoPorcentaje;
			lhsFachadaprincipalAcabadovistoPorcentaje = this.getFachadaprincipalAcabadovistoPorcentaje();
			String rhsFachadaprincipalAcabadovistoPorcentaje;
			rhsFachadaprincipalAcabadovistoPorcentaje = that.getFachadaprincipalAcabadovistoPorcentaje();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "fachadaprincipalAcabadovistoPorcentaje", lhsFachadaprincipalAcabadovistoPorcentaje), LocatorUtils.property(thatLocator, "fachadaprincipalAcabadovistoPorcentaje", rhsFachadaprincipalAcabadovistoPorcentaje), lhsFachadaprincipalAcabadovistoPorcentaje, rhsFachadaprincipalAcabadovistoPorcentaje)) {
				return false;
			}
		}
		{
			String lhsOtrasfachadasAcabadorevestidoTexto;
			lhsOtrasfachadasAcabadorevestidoTexto = this.getOtrasfachadasAcabadorevestidoTexto();
			String rhsOtrasfachadasAcabadorevestidoTexto;
			rhsOtrasfachadasAcabadorevestidoTexto = that.getOtrasfachadasAcabadorevestidoTexto();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "otrasfachadasAcabadorevestidoTexto", lhsOtrasfachadasAcabadorevestidoTexto), LocatorUtils.property(thatLocator, "otrasfachadasAcabadorevestidoTexto", rhsOtrasfachadasAcabadorevestidoTexto), lhsOtrasfachadasAcabadorevestidoTexto, rhsOtrasfachadasAcabadorevestidoTexto)) {
				return false;
			}
		}
		{
			String lhsOtrasfachadasAcabadorevestidoPorcentaje;
			lhsOtrasfachadasAcabadorevestidoPorcentaje = this.getOtrasfachadasAcabadorevestidoPorcentaje();
			String rhsOtrasfachadasAcabadorevestidoPorcentaje;
			rhsOtrasfachadasAcabadorevestidoPorcentaje = that.getOtrasfachadasAcabadorevestidoPorcentaje();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "otrasfachadasAcabadorevestidoPorcentaje", lhsOtrasfachadasAcabadorevestidoPorcentaje), LocatorUtils.property(thatLocator, "otrasfachadasAcabadorevestidoPorcentaje", rhsOtrasfachadasAcabadorevestidoPorcentaje), lhsOtrasfachadasAcabadorevestidoPorcentaje, rhsOtrasfachadasAcabadorevestidoPorcentaje)) {
				return false;
			}
		}
		{
			String lhsOtrasfachadasAcabadovistoTexto;
			lhsOtrasfachadasAcabadovistoTexto = this.getOtrasfachadasAcabadovistoTexto();
			String rhsOtrasfachadasAcabadovistoTexto;
			rhsOtrasfachadasAcabadovistoTexto = that.getOtrasfachadasAcabadovistoTexto();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "otrasfachadasAcabadovistoTexto", lhsOtrasfachadasAcabadovistoTexto), LocatorUtils.property(thatLocator, "otrasfachadasAcabadovistoTexto", rhsOtrasfachadasAcabadovistoTexto), lhsOtrasfachadasAcabadovistoTexto, rhsOtrasfachadasAcabadovistoTexto)) {
				return false;
			}
		}
		{
			String lhsOtrasfachadasAcabadovistoPorcentaje;
			lhsOtrasfachadasAcabadovistoPorcentaje = this.getOtrasfachadasAcabadovistoPorcentaje();
			String rhsOtrasfachadasAcabadovistoPorcentaje;
			rhsOtrasfachadasAcabadovistoPorcentaje = that.getOtrasfachadasAcabadovistoPorcentaje();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "otrasfachadasAcabadovistoPorcentaje", lhsOtrasfachadasAcabadovistoPorcentaje), LocatorUtils.property(thatLocator, "otrasfachadasAcabadovistoPorcentaje", rhsOtrasfachadasAcabadovistoPorcentaje), lhsOtrasfachadasAcabadovistoPorcentaje, rhsOtrasfachadasAcabadovistoPorcentaje)) {
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
			CerramientoscubiertasFachadaprincipalacabadosvistosType lhsCerramientoscubiertasFachadaprincipalacabadosvistos;
			lhsCerramientoscubiertasFachadaprincipalacabadosvistos = this.getCerramientoscubiertasFachadaprincipalacabadosvistos();
			CerramientoscubiertasFachadaprincipalacabadosvistosType rhsCerramientoscubiertasFachadaprincipalacabadosvistos;
			rhsCerramientoscubiertasFachadaprincipalacabadosvistos = that.getCerramientoscubiertasFachadaprincipalacabadosvistos();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "cerramientoscubiertasFachadaprincipalacabadosvistos", lhsCerramientoscubiertasFachadaprincipalacabadosvistos), LocatorUtils.property(thatLocator, "cerramientoscubiertasFachadaprincipalacabadosvistos", rhsCerramientoscubiertasFachadaprincipalacabadosvistos), lhsCerramientoscubiertasFachadaprincipalacabadosvistos, rhsCerramientoscubiertasFachadaprincipalacabadosvistos)) {
				return false;
			}
		}
		{
			CerramientoscubiertasFachadaprincipalacabadosrevestidosType lhsCerramientoscubiertasFachadaprincipalacabadosrevestidos;
			lhsCerramientoscubiertasFachadaprincipalacabadosrevestidos = this.getCerramientoscubiertasFachadaprincipalacabadosrevestidos();
			CerramientoscubiertasFachadaprincipalacabadosrevestidosType rhsCerramientoscubiertasFachadaprincipalacabadosrevestidos;
			rhsCerramientoscubiertasFachadaprincipalacabadosrevestidos = that.getCerramientoscubiertasFachadaprincipalacabadosrevestidos();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "cerramientoscubiertasFachadaprincipalacabadosrevestidos", lhsCerramientoscubiertasFachadaprincipalacabadosrevestidos), LocatorUtils.property(thatLocator, "cerramientoscubiertasFachadaprincipalacabadosrevestidos", rhsCerramientoscubiertasFachadaprincipalacabadosrevestidos), lhsCerramientoscubiertasFachadaprincipalacabadosrevestidos, rhsCerramientoscubiertasFachadaprincipalacabadosrevestidos)) {
				return false;
			}
		}
		{
			CerramientoscubiertasOtrasfachadasacabadosvistosType lhsCerramientoscubiertasOtrasfachadasacabadosvistos;
			lhsCerramientoscubiertasOtrasfachadasacabadosvistos = this.getCerramientoscubiertasOtrasfachadasacabadosvistos();
			CerramientoscubiertasOtrasfachadasacabadosvistosType rhsCerramientoscubiertasOtrasfachadasacabadosvistos;
			rhsCerramientoscubiertasOtrasfachadasacabadosvistos = that.getCerramientoscubiertasOtrasfachadasacabadosvistos();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "cerramientoscubiertasOtrasfachadasacabadosvistos", lhsCerramientoscubiertasOtrasfachadasacabadosvistos), LocatorUtils.property(thatLocator, "cerramientoscubiertasOtrasfachadasacabadosvistos", rhsCerramientoscubiertasOtrasfachadasacabadosvistos), lhsCerramientoscubiertasOtrasfachadasacabadosvistos, rhsCerramientoscubiertasOtrasfachadasacabadosvistos)) {
				return false;
			}
		}
		{
			CerramientoscubiertasOtrasfachadasacabadosrevestidosType lhsCerramientoscubiertasOtrasfachadasacabadosrevestidos;
			lhsCerramientoscubiertasOtrasfachadasacabadosrevestidos = this.getCerramientoscubiertasOtrasfachadasacabadosrevestidos();
			CerramientoscubiertasOtrasfachadasacabadosrevestidosType rhsCerramientoscubiertasOtrasfachadasacabadosrevestidos;
			rhsCerramientoscubiertasOtrasfachadasacabadosrevestidos = that.getCerramientoscubiertasOtrasfachadasacabadosrevestidos();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "cerramientoscubiertasOtrasfachadasacabadosrevestidos", lhsCerramientoscubiertasOtrasfachadasacabadosrevestidos), LocatorUtils.property(thatLocator, "cerramientoscubiertasOtrasfachadasacabadosrevestidos", rhsCerramientoscubiertasOtrasfachadasacabadosrevestidos), lhsCerramientoscubiertasOtrasfachadasacabadosrevestidos, rhsCerramientoscubiertasOtrasfachadasacabadosrevestidos)) {
				return false;
			}
		}
		{
			CerramientoscubiertasCarpinteriavidriocarpinteriaspredominantesType lhsCerramientoscubiertasCarpinteriavidriocarpinteriaspredominantes;
			lhsCerramientoscubiertasCarpinteriavidriocarpinteriaspredominantes = this.getCerramientoscubiertasCarpinteriavidriocarpinteriaspredominantes();
			CerramientoscubiertasCarpinteriavidriocarpinteriaspredominantesType rhsCerramientoscubiertasCarpinteriavidriocarpinteriaspredominantes;
			rhsCerramientoscubiertasCarpinteriavidriocarpinteriaspredominantes = that.getCerramientoscubiertasCarpinteriavidriocarpinteriaspredominantes();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "cerramientoscubiertasCarpinteriavidriocarpinteriaspredominantes", lhsCerramientoscubiertasCarpinteriavidriocarpinteriaspredominantes), LocatorUtils.property(thatLocator, "cerramientoscubiertasCarpinteriavidriocarpinteriaspredominantes", rhsCerramientoscubiertasCarpinteriavidriocarpinteriaspredominantes), lhsCerramientoscubiertasCarpinteriavidriocarpinteriaspredominantes, rhsCerramientoscubiertasCarpinteriavidriocarpinteriaspredominantes)) {
				return false;
			}
		}
		{
			CerramientoscubiertasCarpinteriavidriovidriospredominantesType lhsCerramientoscubiertasCarpinteriavidriovidriospredominantes;
			lhsCerramientoscubiertasCarpinteriavidriovidriospredominantes = this.getCerramientoscubiertasCarpinteriavidriovidriospredominantes();
			CerramientoscubiertasCarpinteriavidriovidriospredominantesType rhsCerramientoscubiertasCarpinteriavidriovidriospredominantes;
			rhsCerramientoscubiertasCarpinteriavidriovidriospredominantes = that.getCerramientoscubiertasCarpinteriavidriovidriospredominantes();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "cerramientoscubiertasCarpinteriavidriovidriospredominantes", lhsCerramientoscubiertasCarpinteriavidriovidriospredominantes), LocatorUtils.property(thatLocator, "cerramientoscubiertasCarpinteriavidriovidriospredominantes", rhsCerramientoscubiertasCarpinteriavidriovidriospredominantes), lhsCerramientoscubiertasCarpinteriavidriovidriospredominantes, rhsCerramientoscubiertasCarpinteriavidriovidriospredominantes)) {
				return false;
			}
		}
		{
			CerramientoscubiertasCubiertaplanatransitablesType lhsCerramientoscubiertasCubiertaplanatransitables;
			lhsCerramientoscubiertasCubiertaplanatransitables = this.getCerramientoscubiertasCubiertaplanatransitables();
			CerramientoscubiertasCubiertaplanatransitablesType rhsCerramientoscubiertasCubiertaplanatransitables;
			rhsCerramientoscubiertasCubiertaplanatransitables = that.getCerramientoscubiertasCubiertaplanatransitables();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "cerramientoscubiertasCubiertaplanatransitables", lhsCerramientoscubiertasCubiertaplanatransitables), LocatorUtils.property(thatLocator, "cerramientoscubiertasCubiertaplanatransitables", rhsCerramientoscubiertasCubiertaplanatransitables), lhsCerramientoscubiertasCubiertaplanatransitables, rhsCerramientoscubiertasCubiertaplanatransitables)) {
				return false;
			}
		}
		{
			CerramientoscubiertasCubiertainclinadacoberturasType lhsCerramientoscubiertasCubiertainclinadacoberturas;
			lhsCerramientoscubiertasCubiertainclinadacoberturas = this.getCerramientoscubiertasCubiertainclinadacoberturas();
			CerramientoscubiertasCubiertainclinadacoberturasType rhsCerramientoscubiertasCubiertainclinadacoberturas;
			rhsCerramientoscubiertasCubiertainclinadacoberturas = that.getCerramientoscubiertasCubiertainclinadacoberturas();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "cerramientoscubiertasCubiertainclinadacoberturas", lhsCerramientoscubiertasCubiertainclinadacoberturas), LocatorUtils.property(thatLocator, "cerramientoscubiertasCubiertainclinadacoberturas", rhsCerramientoscubiertasCubiertainclinadacoberturas), lhsCerramientoscubiertasCubiertainclinadacoberturas, rhsCerramientoscubiertasCubiertainclinadacoberturas)) {
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
			BigDecimal theFachadaPrincipalSuperficie;
			theFachadaPrincipalSuperficie = this.getFachadaPrincipalSuperficie();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "fachadaPrincipalSuperficie", theFachadaPrincipalSuperficie), currentHashCode, theFachadaPrincipalSuperficie);
		}
		{
			String theFachadaPrincipalPorcentaje;
			theFachadaPrincipalPorcentaje = this.getFachadaPrincipalPorcentaje();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "fachadaPrincipalPorcentaje", theFachadaPrincipalPorcentaje), currentHashCode, theFachadaPrincipalPorcentaje);
		}
		{
			int theFachadaprincipalCamaraaireTipoId;
			theFachadaprincipalCamaraaireTipoId = this.getFachadaprincipalCamaraaireTipoId();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "fachadaprincipalCamaraaireTipoId", theFachadaprincipalCamaraaireTipoId), currentHashCode, theFachadaprincipalCamaraaireTipoId);
		}
		{
			int theFachadaprincipalAislamientotermicoTipoId;
			theFachadaprincipalAislamientotermicoTipoId = this.getFachadaprincipalAislamientotermicoTipoId();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "fachadaprincipalAislamientotermicoTipoId", theFachadaprincipalAislamientotermicoTipoId), currentHashCode, theFachadaprincipalAislamientotermicoTipoId);
		}
		{
			String theOtrasFachadasSuperficie;
			theOtrasFachadasSuperficie = this.getOtrasFachadasSuperficie();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "otrasFachadasSuperficie", theOtrasFachadasSuperficie), currentHashCode, theOtrasFachadasSuperficie);
		}
		{
			String theOtrasFachadasPorcentaje;
			theOtrasFachadasPorcentaje = this.getOtrasFachadasPorcentaje();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "otrasFachadasPorcentaje", theOtrasFachadasPorcentaje), currentHashCode, theOtrasFachadasPorcentaje);
		}
		{
			int theOtrasfachadasCamaraaireTipoId;
			theOtrasfachadasCamaraaireTipoId = this.getOtrasfachadasCamaraaireTipoId();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "otrasfachadasCamaraaireTipoId", theOtrasfachadasCamaraaireTipoId), currentHashCode, theOtrasfachadasCamaraaireTipoId);
		}
		{
			int theOtrasfachadasAislamientotermicoTipoId;
			theOtrasfachadasAislamientotermicoTipoId = this.getOtrasfachadasAislamientotermicoTipoId();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "otrasfachadasAislamientotermicoTipoId", theOtrasfachadasAislamientotermicoTipoId), currentHashCode, theOtrasfachadasAislamientotermicoTipoId);
		}
		{
			String theCarpinteriaVidrioSuperficie;
			theCarpinteriaVidrioSuperficie = this.getCarpinteriaVidrioSuperficie();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "carpinteriaVidrioSuperficie", theCarpinteriaVidrioSuperficie), currentHashCode, theCarpinteriaVidrioSuperficie);
		}
		{
			String theCarpinteriaVidrioPorcentaje;
			theCarpinteriaVidrioPorcentaje = this.getCarpinteriaVidrioPorcentaje();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "carpinteriaVidrioPorcentaje", theCarpinteriaVidrioPorcentaje), currentHashCode, theCarpinteriaVidrioPorcentaje);
		}
		{
			String theCubiertaPlanaSuperficie;
			theCubiertaPlanaSuperficie = this.getCubiertaPlanaSuperficie();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "cubiertaPlanaSuperficie", theCubiertaPlanaSuperficie), currentHashCode, theCubiertaPlanaSuperficie);
		}
		{
			String theCubiertaPlanaPorcentaje;
			theCubiertaPlanaPorcentaje = this.getCubiertaPlanaPorcentaje();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "cubiertaPlanaPorcentaje", theCubiertaPlanaPorcentaje), currentHashCode, theCubiertaPlanaPorcentaje);
		}
		{
			int theCubiertaplanaAislamientotermicoTipoId;
			theCubiertaplanaAislamientotermicoTipoId = this.getCubiertaplanaAislamientotermicoTipoId();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "cubiertaplanaAislamientotermicoTipoId", theCubiertaplanaAislamientotermicoTipoId), currentHashCode, theCubiertaplanaAislamientotermicoTipoId);
		}
		{
			int theCubiertaplanaLaminaimpermeabilizanteTipoId;
			theCubiertaplanaLaminaimpermeabilizanteTipoId = this.getCubiertaplanaLaminaimpermeabilizanteTipoId();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "cubiertaplanaLaminaimpermeabilizanteTipoId", theCubiertaplanaLaminaimpermeabilizanteTipoId), currentHashCode, theCubiertaplanaLaminaimpermeabilizanteTipoId);
		}
		{
			String theCubiertaInclinadaSuperficie;
			theCubiertaInclinadaSuperficie = this.getCubiertaInclinadaSuperficie();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "cubiertaInclinadaSuperficie", theCubiertaInclinadaSuperficie), currentHashCode, theCubiertaInclinadaSuperficie);
		}
		{
			String theCubiertaInclinadaPorcentaje;
			theCubiertaInclinadaPorcentaje = this.getCubiertaInclinadaPorcentaje();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "cubiertaInclinadaPorcentaje", theCubiertaInclinadaPorcentaje), currentHashCode, theCubiertaInclinadaPorcentaje);
		}
		{
			int theCubiertainclinadaAislamientotermicoTipoId;
			theCubiertainclinadaAislamientotermicoTipoId = this.getCubiertainclinadaAislamientotermicoTipoId();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "cubiertainclinadaAislamientotermicoTipoId", theCubiertainclinadaAislamientotermicoTipoId), currentHashCode, theCubiertainclinadaAislamientotermicoTipoId);
		}
		{
			String theCarpinteriavidrioCarpinteriapredominanteTexto;
			theCarpinteriavidrioCarpinteriapredominanteTexto = this.getCarpinteriavidrioCarpinteriapredominanteTexto();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "carpinteriavidrioCarpinteriapredominanteTexto", theCarpinteriavidrioCarpinteriapredominanteTexto), currentHashCode, theCarpinteriavidrioCarpinteriapredominanteTexto);
		}
		{
			String theCarpinteriavidrioVidriopredominanteTexto;
			theCarpinteriavidrioVidriopredominanteTexto = this.getCarpinteriavidrioVidriopredominanteTexto();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "carpinteriavidrioVidriopredominanteTexto", theCarpinteriavidrioVidriopredominanteTexto), currentHashCode, theCarpinteriavidrioVidriopredominanteTexto);
		}
		{
			String theFachadaprincipalAcabadorevestidoTexto;
			theFachadaprincipalAcabadorevestidoTexto = this.getFachadaprincipalAcabadorevestidoTexto();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "fachadaprincipalAcabadorevestidoTexto", theFachadaprincipalAcabadorevestidoTexto), currentHashCode, theFachadaprincipalAcabadorevestidoTexto);
		}
		{
			String theFachadaprincipalAcabadorevestidoPorcentaje;
			theFachadaprincipalAcabadorevestidoPorcentaje = this.getFachadaprincipalAcabadorevestidoPorcentaje();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "fachadaprincipalAcabadorevestidoPorcentaje", theFachadaprincipalAcabadorevestidoPorcentaje), currentHashCode, theFachadaprincipalAcabadorevestidoPorcentaje);
		}
		{
			String theFachadaprincipalAcabadovistoTexto;
			theFachadaprincipalAcabadovistoTexto = this.getFachadaprincipalAcabadovistoTexto();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "fachadaprincipalAcabadovistoTexto", theFachadaprincipalAcabadovistoTexto), currentHashCode, theFachadaprincipalAcabadovistoTexto);
		}
		{
			String theFachadaprincipalAcabadovistoPorcentaje;
			theFachadaprincipalAcabadovistoPorcentaje = this.getFachadaprincipalAcabadovistoPorcentaje();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "fachadaprincipalAcabadovistoPorcentaje", theFachadaprincipalAcabadovistoPorcentaje), currentHashCode, theFachadaprincipalAcabadovistoPorcentaje);
		}
		{
			String theOtrasfachadasAcabadorevestidoTexto;
			theOtrasfachadasAcabadorevestidoTexto = this.getOtrasfachadasAcabadorevestidoTexto();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "otrasfachadasAcabadorevestidoTexto", theOtrasfachadasAcabadorevestidoTexto), currentHashCode, theOtrasfachadasAcabadorevestidoTexto);
		}
		{
			String theOtrasfachadasAcabadorevestidoPorcentaje;
			theOtrasfachadasAcabadorevestidoPorcentaje = this.getOtrasfachadasAcabadorevestidoPorcentaje();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "otrasfachadasAcabadorevestidoPorcentaje", theOtrasfachadasAcabadorevestidoPorcentaje), currentHashCode, theOtrasfachadasAcabadorevestidoPorcentaje);
		}
		{
			String theOtrasfachadasAcabadovistoTexto;
			theOtrasfachadasAcabadovistoTexto = this.getOtrasfachadasAcabadovistoTexto();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "otrasfachadasAcabadovistoTexto", theOtrasfachadasAcabadovistoTexto), currentHashCode, theOtrasfachadasAcabadovistoTexto);
		}
		{
			String theOtrasfachadasAcabadovistoPorcentaje;
			theOtrasfachadasAcabadovistoPorcentaje = this.getOtrasfachadasAcabadovistoPorcentaje();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "otrasfachadasAcabadovistoPorcentaje", theOtrasfachadasAcabadovistoPorcentaje), currentHashCode, theOtrasfachadasAcabadovistoPorcentaje);
		}
		{
			String theObservaciones;
			theObservaciones = this.getObservaciones();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "observaciones", theObservaciones), currentHashCode, theObservaciones);
		}
		{
			CerramientoscubiertasFachadaprincipalacabadosvistosType theCerramientoscubiertasFachadaprincipalacabadosvistos;
			theCerramientoscubiertasFachadaprincipalacabadosvistos = this.getCerramientoscubiertasFachadaprincipalacabadosvistos();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "cerramientoscubiertasFachadaprincipalacabadosvistos", theCerramientoscubiertasFachadaprincipalacabadosvistos), currentHashCode, theCerramientoscubiertasFachadaprincipalacabadosvistos);
		}
		{
			CerramientoscubiertasFachadaprincipalacabadosrevestidosType theCerramientoscubiertasFachadaprincipalacabadosrevestidos;
			theCerramientoscubiertasFachadaprincipalacabadosrevestidos = this.getCerramientoscubiertasFachadaprincipalacabadosrevestidos();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "cerramientoscubiertasFachadaprincipalacabadosrevestidos", theCerramientoscubiertasFachadaprincipalacabadosrevestidos), currentHashCode, theCerramientoscubiertasFachadaprincipalacabadosrevestidos);
		}
		{
			CerramientoscubiertasOtrasfachadasacabadosvistosType theCerramientoscubiertasOtrasfachadasacabadosvistos;
			theCerramientoscubiertasOtrasfachadasacabadosvistos = this.getCerramientoscubiertasOtrasfachadasacabadosvistos();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "cerramientoscubiertasOtrasfachadasacabadosvistos", theCerramientoscubiertasOtrasfachadasacabadosvistos), currentHashCode, theCerramientoscubiertasOtrasfachadasacabadosvistos);
		}
		{
			CerramientoscubiertasOtrasfachadasacabadosrevestidosType theCerramientoscubiertasOtrasfachadasacabadosrevestidos;
			theCerramientoscubiertasOtrasfachadasacabadosrevestidos = this.getCerramientoscubiertasOtrasfachadasacabadosrevestidos();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "cerramientoscubiertasOtrasfachadasacabadosrevestidos", theCerramientoscubiertasOtrasfachadasacabadosrevestidos), currentHashCode, theCerramientoscubiertasOtrasfachadasacabadosrevestidos);
		}
		{
			CerramientoscubiertasCarpinteriavidriocarpinteriaspredominantesType theCerramientoscubiertasCarpinteriavidriocarpinteriaspredominantes;
			theCerramientoscubiertasCarpinteriavidriocarpinteriaspredominantes = this.getCerramientoscubiertasCarpinteriavidriocarpinteriaspredominantes();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "cerramientoscubiertasCarpinteriavidriocarpinteriaspredominantes", theCerramientoscubiertasCarpinteriavidriocarpinteriaspredominantes), currentHashCode, theCerramientoscubiertasCarpinteriavidriocarpinteriaspredominantes);
		}
		{
			CerramientoscubiertasCarpinteriavidriovidriospredominantesType theCerramientoscubiertasCarpinteriavidriovidriospredominantes;
			theCerramientoscubiertasCarpinteriavidriovidriospredominantes = this.getCerramientoscubiertasCarpinteriavidriovidriospredominantes();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "cerramientoscubiertasCarpinteriavidriovidriospredominantes", theCerramientoscubiertasCarpinteriavidriovidriospredominantes), currentHashCode, theCerramientoscubiertasCarpinteriavidriovidriospredominantes);
		}
		{
			CerramientoscubiertasCubiertaplanatransitablesType theCerramientoscubiertasCubiertaplanatransitables;
			theCerramientoscubiertasCubiertaplanatransitables = this.getCerramientoscubiertasCubiertaplanatransitables();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "cerramientoscubiertasCubiertaplanatransitables", theCerramientoscubiertasCubiertaplanatransitables), currentHashCode, theCerramientoscubiertasCubiertaplanatransitables);
		}
		{
			CerramientoscubiertasCubiertainclinadacoberturasType theCerramientoscubiertasCubiertainclinadacoberturas;
			theCerramientoscubiertasCubiertainclinadacoberturas = this.getCerramientoscubiertasCubiertainclinadacoberturas();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "cerramientoscubiertasCubiertainclinadacoberturas", theCerramientoscubiertasCubiertainclinadacoberturas), currentHashCode, theCerramientoscubiertasCubiertainclinadacoberturas);
		}
		return currentHashCode;
	}

	public int hashCode() {
		final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
		return this.hashCode(null, strategy);
	}

}
