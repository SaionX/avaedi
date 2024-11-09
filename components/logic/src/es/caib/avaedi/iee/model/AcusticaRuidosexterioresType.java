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
 * Clase Java para acustica_ruidosexterioresType complex type.
 * 
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que
 * haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="acustica_ruidosexterioresType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="fachadas_ligeras" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="fachadas_pesadas" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="cubiertas_ligeras" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="cubiertas_ligeras_techo" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="cubiertas_pesadas" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="ventanas_localizacion_tipos_ventanas" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="capialzados_tiene" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="capialzados_no_prefabricados" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="capialzados_aislamiento_acustico" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="aireadores_tiene" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="aireadores_asilamiento_acustico" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="ruido_molesto_exterior" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="estado_fachadas_bueno" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="estado_cubiertas_bueno" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="estado_ventanas_bueno" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="estado_capialzados_bueno" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="deficiencias_observaciones" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="observaciones" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="acustica_ruidoexterior_ventanas" type="{}acustica_ruidoexterior_ventanasType"/&gt;
 *         &lt;element name="acustica_ruidoexterior_ventana_vidrios" type="{}acustica_ruidoexterior_ventana_vidriosType"/&gt;
 *         &lt;element name="acustica_ruidoexterior_ventana_aperturas" type="{}acustica_ruidoexterior_ventana_aperturasType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "acustica_ruidosexterioresType", propOrder = { "fachadasLigeras", "fachadasPesadas", "cubiertasLigeras", "cubiertasLigerasTecho", "cubiertasPesadas", "ventanasLocalizacionTiposVentanas", "capialzadosTiene", "capialzadosNoPrefabricados", "capialzadosAislamientoAcustico", "aireadoresTiene", "aireadoresAsilamientoAcustico", "ruidoMolestoExterior", "estadoFachadasBueno", "estadoCubiertasBueno", "estadoVentanasBueno", "estadoCapialzadosBueno", "deficienciasObservaciones", "observaciones", "acusticaRuidoexteriorVentanas", "acusticaRuidoexteriorVentanaVidrios", "acusticaRuidoexteriorVentanaAperturas" })
@Entity(name = "AcusticaRuidosexterioresType")
@Table(name = "AED_ACU_RUIDOSEXTERIORES")
@Inheritance(strategy = InheritanceType.JOINED)
public class AcusticaRuidosexterioresType implements Serializable, Equals, HashCode {

	@XmlElement(name = "fachadas_ligeras")
	protected int fachadasLigeras;
	@XmlElement(name = "fachadas_pesadas")
	protected int fachadasPesadas;
	@XmlElement(name = "cubiertas_ligeras")
	protected int cubiertasLigeras;
	@XmlElement(name = "cubiertas_ligeras_techo")
	protected int cubiertasLigerasTecho;
	@XmlElement(name = "cubiertas_pesadas")
	protected int cubiertasPesadas;
	@XmlElement(name = "ventanas_localizacion_tipos_ventanas", required = true)
	protected String ventanasLocalizacionTiposVentanas;
	@XmlElement(name = "capialzados_tiene")
	protected int capialzadosTiene;
	@XmlElement(name = "capialzados_no_prefabricados")
	protected int capialzadosNoPrefabricados;
	@XmlElement(name = "capialzados_aislamiento_acustico")
	protected int capialzadosAislamientoAcustico;
	@XmlElement(name = "aireadores_tiene")
	protected int aireadoresTiene;
	@XmlElement(name = "aireadores_asilamiento_acustico", required = true)
	protected String aireadoresAsilamientoAcustico;
	@XmlElement(name = "ruido_molesto_exterior")
	protected int ruidoMolestoExterior;
	@XmlElement(name = "estado_fachadas_bueno")
	protected int estadoFachadasBueno;
	@XmlElement(name = "estado_cubiertas_bueno")
	protected int estadoCubiertasBueno;
	@XmlElement(name = "estado_ventanas_bueno")
	protected int estadoVentanasBueno;
	@XmlElement(name = "estado_capialzados_bueno")
	protected int estadoCapialzadosBueno;
	@XmlElement(name = "deficiencias_observaciones", required = true)
	protected String deficienciasObservaciones;
	@XmlElement(required = true)
	protected String observaciones;
	@XmlElement(name = "acustica_ruidoexterior_ventanas", required = true)
	protected AcusticaRuidoexteriorVentanasType acusticaRuidoexteriorVentanas;
	@XmlElement(name = "acustica_ruidoexterior_ventana_vidrios", required = true)
	protected AcusticaRuidoexteriorVentanaVidriosType acusticaRuidoexteriorVentanaVidrios;
	@XmlElement(name = "acustica_ruidoexterior_ventana_aperturas", required = true)
	protected AcusticaRuidoexteriorVentanaAperturasType acusticaRuidoexteriorVentanaAperturas;
	@XmlAttribute(name = "Hjid")
	protected Long hjid;

	/**
	 * Obtiene el valor de la propiedad fachadasLigeras.
	 * 
	 */
	@Basic
	@Column(name = "FACHADAS_LIGERAS", precision = 10, scale = 0)
	public int getFachadasLigeras() {
		return fachadasLigeras;
	}

	/**
	 * Define el valor de la propiedad fachadasLigeras.
	 * 
	 */
	public void setFachadasLigeras(int value) {
		this.fachadasLigeras = value;
	}

	/**
	 * Obtiene el valor de la propiedad fachadasPesadas.
	 * 
	 */
	@Basic
	@Column(name = "FACHADAS_PESADAS", precision = 10, scale = 0)
	public int getFachadasPesadas() {
		return fachadasPesadas;
	}

	/**
	 * Define el valor de la propiedad fachadasPesadas.
	 * 
	 */
	public void setFachadasPesadas(int value) {
		this.fachadasPesadas = value;
	}

	/**
	 * Obtiene el valor de la propiedad cubiertasLigeras.
	 * 
	 */
	@Basic
	@Column(name = "CUBIERTAS_LIGERAS", precision = 10, scale = 0)
	public int getCubiertasLigeras() {
		return cubiertasLigeras;
	}

	/**
	 * Define el valor de la propiedad cubiertasLigeras.
	 * 
	 */
	public void setCubiertasLigeras(int value) {
		this.cubiertasLigeras = value;
	}

	/**
	 * Obtiene el valor de la propiedad cubiertasLigerasTecho.
	 * 
	 */
	@Basic
	@Column(name = "CUBIERTAS_LIGERAS_TECHO", precision = 10, scale = 0)
	public int getCubiertasLigerasTecho() {
		return cubiertasLigerasTecho;
	}

	/**
	 * Define el valor de la propiedad cubiertasLigerasTecho.
	 * 
	 */
	public void setCubiertasLigerasTecho(int value) {
		this.cubiertasLigerasTecho = value;
	}

	/**
	 * Obtiene el valor de la propiedad cubiertasPesadas.
	 * 
	 */
	@Basic
	@Column(name = "CUBIERTAS_PESADAS", precision = 10, scale = 0)
	public int getCubiertasPesadas() {
		return cubiertasPesadas;
	}

	/**
	 * Define el valor de la propiedad cubiertasPesadas.
	 * 
	 */
	public void setCubiertasPesadas(int value) {
		this.cubiertasPesadas = value;
	}

	/**
	 * Obtiene el valor de la propiedad ventanasLocalizacionTiposVentanas.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "VENTANAS_LOCALIZACION_TIPOS_VENTANAS", length = 255)
	public String getVentanasLocalizacionTiposVentanas() {
		return ventanasLocalizacionTiposVentanas;
	}

	/**
	 * Define el valor de la propiedad ventanasLocalizacionTiposVentanas.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setVentanasLocalizacionTiposVentanas(String value) {
		this.ventanasLocalizacionTiposVentanas = value;
	}

	/**
	 * Obtiene el valor de la propiedad capialzadosTiene.
	 * 
	 */
	@Basic
	@Column(name = "CAPIALZADOS_TIENE", precision = 10, scale = 0)
	public int getCapialzadosTiene() {
		return capialzadosTiene;
	}

	/**
	 * Define el valor de la propiedad capialzadosTiene.
	 * 
	 */
	public void setCapialzadosTiene(int value) {
		this.capialzadosTiene = value;
	}

	/**
	 * Obtiene el valor de la propiedad capialzadosNoPrefabricados.
	 * 
	 */
	@Basic
	@Column(name = "CAPIALZADOS_NO_PREFABRICADOS", precision = 10, scale = 0)
	public int getCapialzadosNoPrefabricados() {
		return capialzadosNoPrefabricados;
	}

	/**
	 * Define el valor de la propiedad capialzadosNoPrefabricados.
	 * 
	 */
	public void setCapialzadosNoPrefabricados(int value) {
		this.capialzadosNoPrefabricados = value;
	}

	/**
	 * Obtiene el valor de la propiedad capialzadosAislamientoAcustico.
	 * 
	 */
	@Basic
	@Column(name = "CAPIALZADOS_AISLAMIENTO_ACUSTICO", precision = 10, scale = 0)
	public int getCapialzadosAislamientoAcustico() {
		return capialzadosAislamientoAcustico;
	}

	/**
	 * Define el valor de la propiedad capialzadosAislamientoAcustico.
	 * 
	 */
	public void setCapialzadosAislamientoAcustico(int value) {
		this.capialzadosAislamientoAcustico = value;
	}

	/**
	 * Obtiene el valor de la propiedad aireadoresTiene.
	 * 
	 */
	@Basic
	@Column(name = "AIREADORES_TIENE", precision = 10, scale = 0)
	public int getAireadoresTiene() {
		return aireadoresTiene;
	}

	/**
	 * Define el valor de la propiedad aireadoresTiene.
	 * 
	 */
	public void setAireadoresTiene(int value) {
		this.aireadoresTiene = value;
	}

	/**
	 * Obtiene el valor de la propiedad aireadoresAsilamientoAcustico.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "AIREADORES_ASILAMIENTO_ACUSTICO", length = 255)
	public String getAireadoresAsilamientoAcustico() {
		return aireadoresAsilamientoAcustico;
	}

	/**
	 * Define el valor de la propiedad aireadoresAsilamientoAcustico.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setAireadoresAsilamientoAcustico(String value) {
		this.aireadoresAsilamientoAcustico = value;
	}

	/**
	 * Obtiene el valor de la propiedad ruidoMolestoExterior.
	 * 
	 */
	@Basic
	@Column(name = "RUIDO_MOLESTO_EXTERIOR", precision = 10, scale = 0)
	public int getRuidoMolestoExterior() {
		return ruidoMolestoExterior;
	}

	/**
	 * Define el valor de la propiedad ruidoMolestoExterior.
	 * 
	 */
	public void setRuidoMolestoExterior(int value) {
		this.ruidoMolestoExterior = value;
	}

	/**
	 * Obtiene el valor de la propiedad estadoFachadasBueno.
	 * 
	 */
	@Basic
	@Column(name = "ESTADO_FACHADAS_BUENO", precision = 10, scale = 0)
	public int getEstadoFachadasBueno() {
		return estadoFachadasBueno;
	}

	/**
	 * Define el valor de la propiedad estadoFachadasBueno.
	 * 
	 */
	public void setEstadoFachadasBueno(int value) {
		this.estadoFachadasBueno = value;
	}

	/**
	 * Obtiene el valor de la propiedad estadoCubiertasBueno.
	 * 
	 */
	@Basic
	@Column(name = "ESTADO_CUBIERTAS_BUENO", precision = 10, scale = 0)
	public int getEstadoCubiertasBueno() {
		return estadoCubiertasBueno;
	}

	/**
	 * Define el valor de la propiedad estadoCubiertasBueno.
	 * 
	 */
	public void setEstadoCubiertasBueno(int value) {
		this.estadoCubiertasBueno = value;
	}

	/**
	 * Obtiene el valor de la propiedad estadoVentanasBueno.
	 * 
	 */
	@Basic
	@Column(name = "ESTADO_VENTANAS_BUENO", precision = 10, scale = 0)
	public int getEstadoVentanasBueno() {
		return estadoVentanasBueno;
	}

	/**
	 * Define el valor de la propiedad estadoVentanasBueno.
	 * 
	 */
	public void setEstadoVentanasBueno(int value) {
		this.estadoVentanasBueno = value;
	}

	/**
	 * Obtiene el valor de la propiedad estadoCapialzadosBueno.
	 * 
	 */
	@Basic
	@Column(name = "ESTADO_CAPIALZADOS_BUENO", precision = 10, scale = 0)
	public int getEstadoCapialzadosBueno() {
		return estadoCapialzadosBueno;
	}

	/**
	 * Define el valor de la propiedad estadoCapialzadosBueno.
	 * 
	 */
	public void setEstadoCapialzadosBueno(int value) {
		this.estadoCapialzadosBueno = value;
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
	 * Obtiene el valor de la propiedad acusticaRuidoexteriorVentanas.
	 * 
	 * @return possible object is {@link AcusticaRuidoexteriorVentanasType }
	 * 
	 */
	@ManyToOne(targetEntity = AcusticaRuidoexteriorVentanasType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "ACUSTICA_RUIDOEXTERIOR_VENTANAS_AED_ACU_RUIDOSEXTERIORES_HJID")
	public AcusticaRuidoexteriorVentanasType getAcusticaRuidoexteriorVentanas() {
		return acusticaRuidoexteriorVentanas;
	}

	/**
	 * Define el valor de la propiedad acusticaRuidoexteriorVentanas.
	 * 
	 * @param value
	 *            allowed object is {@link AcusticaRuidoexteriorVentanasType }
	 * 
	 */
	public void setAcusticaRuidoexteriorVentanas(AcusticaRuidoexteriorVentanasType value) {
		this.acusticaRuidoexteriorVentanas = value;
	}

	/**
	 * Obtiene el valor de la propiedad acusticaRuidoexteriorVentanaVidrios.
	 * 
	 * @return possible object is
	 *         {@link AcusticaRuidoexteriorVentanaVidriosType }
	 * 
	 */
	@ManyToOne(targetEntity = AcusticaRuidoexteriorVentanaVidriosType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "ACUSTICA_RUIDOEXTERIOR_VENTANA_VIDRIOS_AED_ACU_RUIDOSEXTERIORES_HJID")
	public AcusticaRuidoexteriorVentanaVidriosType getAcusticaRuidoexteriorVentanaVidrios() {
		return acusticaRuidoexteriorVentanaVidrios;
	}

	/**
	 * Define el valor de la propiedad acusticaRuidoexteriorVentanaVidrios.
	 * 
	 * @param value
	 *            allowed object is
	 *            {@link AcusticaRuidoexteriorVentanaVidriosType }
	 * 
	 */
	public void setAcusticaRuidoexteriorVentanaVidrios(AcusticaRuidoexteriorVentanaVidriosType value) {
		this.acusticaRuidoexteriorVentanaVidrios = value;
	}

	/**
	 * Obtiene el valor de la propiedad acusticaRuidoexteriorVentanaAperturas.
	 * 
	 * @return possible object is
	 *         {@link AcusticaRuidoexteriorVentanaAperturasType }
	 * 
	 */
	@ManyToOne(targetEntity = AcusticaRuidoexteriorVentanaAperturasType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "ACUSTICA_RUIDOEXTERIOR_VENTANA_APERTURAS_AED_ACU_RUIDOSEXTERIORES_HJID")
	public AcusticaRuidoexteriorVentanaAperturasType getAcusticaRuidoexteriorVentanaAperturas() {
		return acusticaRuidoexteriorVentanaAperturas;
	}

	/**
	 * Define el valor de la propiedad acusticaRuidoexteriorVentanaAperturas.
	 * 
	 * @param value
	 *            allowed object is
	 *            {@link AcusticaRuidoexteriorVentanaAperturasType }
	 * 
	 */
	public void setAcusticaRuidoexteriorVentanaAperturas(AcusticaRuidoexteriorVentanaAperturasType value) {
		this.acusticaRuidoexteriorVentanaAperturas = value;
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
		final AcusticaRuidosexterioresType that = ((AcusticaRuidosexterioresType) object);
		{
			int lhsFachadasLigeras;
			lhsFachadasLigeras = this.getFachadasLigeras();
			int rhsFachadasLigeras;
			rhsFachadasLigeras = that.getFachadasLigeras();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "fachadasLigeras", lhsFachadasLigeras), LocatorUtils.property(thatLocator, "fachadasLigeras", rhsFachadasLigeras), lhsFachadasLigeras, rhsFachadasLigeras)) {
				return false;
			}
		}
		{
			int lhsFachadasPesadas;
			lhsFachadasPesadas = this.getFachadasPesadas();
			int rhsFachadasPesadas;
			rhsFachadasPesadas = that.getFachadasPesadas();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "fachadasPesadas", lhsFachadasPesadas), LocatorUtils.property(thatLocator, "fachadasPesadas", rhsFachadasPesadas), lhsFachadasPesadas, rhsFachadasPesadas)) {
				return false;
			}
		}
		{
			int lhsCubiertasLigeras;
			lhsCubiertasLigeras = this.getCubiertasLigeras();
			int rhsCubiertasLigeras;
			rhsCubiertasLigeras = that.getCubiertasLigeras();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "cubiertasLigeras", lhsCubiertasLigeras), LocatorUtils.property(thatLocator, "cubiertasLigeras", rhsCubiertasLigeras), lhsCubiertasLigeras, rhsCubiertasLigeras)) {
				return false;
			}
		}
		{
			int lhsCubiertasLigerasTecho;
			lhsCubiertasLigerasTecho = this.getCubiertasLigerasTecho();
			int rhsCubiertasLigerasTecho;
			rhsCubiertasLigerasTecho = that.getCubiertasLigerasTecho();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "cubiertasLigerasTecho", lhsCubiertasLigerasTecho), LocatorUtils.property(thatLocator, "cubiertasLigerasTecho", rhsCubiertasLigerasTecho), lhsCubiertasLigerasTecho, rhsCubiertasLigerasTecho)) {
				return false;
			}
		}
		{
			int lhsCubiertasPesadas;
			lhsCubiertasPesadas = this.getCubiertasPesadas();
			int rhsCubiertasPesadas;
			rhsCubiertasPesadas = that.getCubiertasPesadas();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "cubiertasPesadas", lhsCubiertasPesadas), LocatorUtils.property(thatLocator, "cubiertasPesadas", rhsCubiertasPesadas), lhsCubiertasPesadas, rhsCubiertasPesadas)) {
				return false;
			}
		}
		{
			String lhsVentanasLocalizacionTiposVentanas;
			lhsVentanasLocalizacionTiposVentanas = this.getVentanasLocalizacionTiposVentanas();
			String rhsVentanasLocalizacionTiposVentanas;
			rhsVentanasLocalizacionTiposVentanas = that.getVentanasLocalizacionTiposVentanas();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "ventanasLocalizacionTiposVentanas", lhsVentanasLocalizacionTiposVentanas), LocatorUtils.property(thatLocator, "ventanasLocalizacionTiposVentanas", rhsVentanasLocalizacionTiposVentanas), lhsVentanasLocalizacionTiposVentanas, rhsVentanasLocalizacionTiposVentanas)) {
				return false;
			}
		}
		{
			int lhsCapialzadosTiene;
			lhsCapialzadosTiene = this.getCapialzadosTiene();
			int rhsCapialzadosTiene;
			rhsCapialzadosTiene = that.getCapialzadosTiene();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "capialzadosTiene", lhsCapialzadosTiene), LocatorUtils.property(thatLocator, "capialzadosTiene", rhsCapialzadosTiene), lhsCapialzadosTiene, rhsCapialzadosTiene)) {
				return false;
			}
		}
		{
			int lhsCapialzadosNoPrefabricados;
			lhsCapialzadosNoPrefabricados = this.getCapialzadosNoPrefabricados();
			int rhsCapialzadosNoPrefabricados;
			rhsCapialzadosNoPrefabricados = that.getCapialzadosNoPrefabricados();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "capialzadosNoPrefabricados", lhsCapialzadosNoPrefabricados), LocatorUtils.property(thatLocator, "capialzadosNoPrefabricados", rhsCapialzadosNoPrefabricados), lhsCapialzadosNoPrefabricados, rhsCapialzadosNoPrefabricados)) {
				return false;
			}
		}
		{
			int lhsCapialzadosAislamientoAcustico;
			lhsCapialzadosAislamientoAcustico = this.getCapialzadosAislamientoAcustico();
			int rhsCapialzadosAislamientoAcustico;
			rhsCapialzadosAislamientoAcustico = that.getCapialzadosAislamientoAcustico();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "capialzadosAislamientoAcustico", lhsCapialzadosAislamientoAcustico), LocatorUtils.property(thatLocator, "capialzadosAislamientoAcustico", rhsCapialzadosAislamientoAcustico), lhsCapialzadosAislamientoAcustico, rhsCapialzadosAislamientoAcustico)) {
				return false;
			}
		}
		{
			int lhsAireadoresTiene;
			lhsAireadoresTiene = this.getAireadoresTiene();
			int rhsAireadoresTiene;
			rhsAireadoresTiene = that.getAireadoresTiene();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "aireadoresTiene", lhsAireadoresTiene), LocatorUtils.property(thatLocator, "aireadoresTiene", rhsAireadoresTiene), lhsAireadoresTiene, rhsAireadoresTiene)) {
				return false;
			}
		}
		{
			String lhsAireadoresAsilamientoAcustico;
			lhsAireadoresAsilamientoAcustico = this.getAireadoresAsilamientoAcustico();
			String rhsAireadoresAsilamientoAcustico;
			rhsAireadoresAsilamientoAcustico = that.getAireadoresAsilamientoAcustico();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "aireadoresAsilamientoAcustico", lhsAireadoresAsilamientoAcustico), LocatorUtils.property(thatLocator, "aireadoresAsilamientoAcustico", rhsAireadoresAsilamientoAcustico), lhsAireadoresAsilamientoAcustico, rhsAireadoresAsilamientoAcustico)) {
				return false;
			}
		}
		{
			int lhsRuidoMolestoExterior;
			lhsRuidoMolestoExterior = this.getRuidoMolestoExterior();
			int rhsRuidoMolestoExterior;
			rhsRuidoMolestoExterior = that.getRuidoMolestoExterior();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "ruidoMolestoExterior", lhsRuidoMolestoExterior), LocatorUtils.property(thatLocator, "ruidoMolestoExterior", rhsRuidoMolestoExterior), lhsRuidoMolestoExterior, rhsRuidoMolestoExterior)) {
				return false;
			}
		}
		{
			int lhsEstadoFachadasBueno;
			lhsEstadoFachadasBueno = this.getEstadoFachadasBueno();
			int rhsEstadoFachadasBueno;
			rhsEstadoFachadasBueno = that.getEstadoFachadasBueno();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "estadoFachadasBueno", lhsEstadoFachadasBueno), LocatorUtils.property(thatLocator, "estadoFachadasBueno", rhsEstadoFachadasBueno), lhsEstadoFachadasBueno, rhsEstadoFachadasBueno)) {
				return false;
			}
		}
		{
			int lhsEstadoCubiertasBueno;
			lhsEstadoCubiertasBueno = this.getEstadoCubiertasBueno();
			int rhsEstadoCubiertasBueno;
			rhsEstadoCubiertasBueno = that.getEstadoCubiertasBueno();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "estadoCubiertasBueno", lhsEstadoCubiertasBueno), LocatorUtils.property(thatLocator, "estadoCubiertasBueno", rhsEstadoCubiertasBueno), lhsEstadoCubiertasBueno, rhsEstadoCubiertasBueno)) {
				return false;
			}
		}
		{
			int lhsEstadoVentanasBueno;
			lhsEstadoVentanasBueno = this.getEstadoVentanasBueno();
			int rhsEstadoVentanasBueno;
			rhsEstadoVentanasBueno = that.getEstadoVentanasBueno();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "estadoVentanasBueno", lhsEstadoVentanasBueno), LocatorUtils.property(thatLocator, "estadoVentanasBueno", rhsEstadoVentanasBueno), lhsEstadoVentanasBueno, rhsEstadoVentanasBueno)) {
				return false;
			}
		}
		{
			int lhsEstadoCapialzadosBueno;
			lhsEstadoCapialzadosBueno = this.getEstadoCapialzadosBueno();
			int rhsEstadoCapialzadosBueno;
			rhsEstadoCapialzadosBueno = that.getEstadoCapialzadosBueno();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "estadoCapialzadosBueno", lhsEstadoCapialzadosBueno), LocatorUtils.property(thatLocator, "estadoCapialzadosBueno", rhsEstadoCapialzadosBueno), lhsEstadoCapialzadosBueno, rhsEstadoCapialzadosBueno)) {
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
			String lhsObservaciones;
			lhsObservaciones = this.getObservaciones();
			String rhsObservaciones;
			rhsObservaciones = that.getObservaciones();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "observaciones", lhsObservaciones), LocatorUtils.property(thatLocator, "observaciones", rhsObservaciones), lhsObservaciones, rhsObservaciones)) {
				return false;
			}
		}
		{
			AcusticaRuidoexteriorVentanasType lhsAcusticaRuidoexteriorVentanas;
			lhsAcusticaRuidoexteriorVentanas = this.getAcusticaRuidoexteriorVentanas();
			AcusticaRuidoexteriorVentanasType rhsAcusticaRuidoexteriorVentanas;
			rhsAcusticaRuidoexteriorVentanas = that.getAcusticaRuidoexteriorVentanas();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "acusticaRuidoexteriorVentanas", lhsAcusticaRuidoexteriorVentanas), LocatorUtils.property(thatLocator, "acusticaRuidoexteriorVentanas", rhsAcusticaRuidoexteriorVentanas), lhsAcusticaRuidoexteriorVentanas, rhsAcusticaRuidoexteriorVentanas)) {
				return false;
			}
		}
		{
			AcusticaRuidoexteriorVentanaVidriosType lhsAcusticaRuidoexteriorVentanaVidrios;
			lhsAcusticaRuidoexteriorVentanaVidrios = this.getAcusticaRuidoexteriorVentanaVidrios();
			AcusticaRuidoexteriorVentanaVidriosType rhsAcusticaRuidoexteriorVentanaVidrios;
			rhsAcusticaRuidoexteriorVentanaVidrios = that.getAcusticaRuidoexteriorVentanaVidrios();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "acusticaRuidoexteriorVentanaVidrios", lhsAcusticaRuidoexteriorVentanaVidrios), LocatorUtils.property(thatLocator, "acusticaRuidoexteriorVentanaVidrios", rhsAcusticaRuidoexteriorVentanaVidrios), lhsAcusticaRuidoexteriorVentanaVidrios, rhsAcusticaRuidoexteriorVentanaVidrios)) {
				return false;
			}
		}
		{
			AcusticaRuidoexteriorVentanaAperturasType lhsAcusticaRuidoexteriorVentanaAperturas;
			lhsAcusticaRuidoexteriorVentanaAperturas = this.getAcusticaRuidoexteriorVentanaAperturas();
			AcusticaRuidoexteriorVentanaAperturasType rhsAcusticaRuidoexteriorVentanaAperturas;
			rhsAcusticaRuidoexteriorVentanaAperturas = that.getAcusticaRuidoexteriorVentanaAperturas();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "acusticaRuidoexteriorVentanaAperturas", lhsAcusticaRuidoexteriorVentanaAperturas), LocatorUtils.property(thatLocator, "acusticaRuidoexteriorVentanaAperturas", rhsAcusticaRuidoexteriorVentanaAperturas), lhsAcusticaRuidoexteriorVentanaAperturas, rhsAcusticaRuidoexteriorVentanaAperturas)) {
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
			int theFachadasLigeras;
			theFachadasLigeras = this.getFachadasLigeras();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "fachadasLigeras", theFachadasLigeras), currentHashCode, theFachadasLigeras);
		}
		{
			int theFachadasPesadas;
			theFachadasPesadas = this.getFachadasPesadas();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "fachadasPesadas", theFachadasPesadas), currentHashCode, theFachadasPesadas);
		}
		{
			int theCubiertasLigeras;
			theCubiertasLigeras = this.getCubiertasLigeras();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "cubiertasLigeras", theCubiertasLigeras), currentHashCode, theCubiertasLigeras);
		}
		{
			int theCubiertasLigerasTecho;
			theCubiertasLigerasTecho = this.getCubiertasLigerasTecho();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "cubiertasLigerasTecho", theCubiertasLigerasTecho), currentHashCode, theCubiertasLigerasTecho);
		}
		{
			int theCubiertasPesadas;
			theCubiertasPesadas = this.getCubiertasPesadas();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "cubiertasPesadas", theCubiertasPesadas), currentHashCode, theCubiertasPesadas);
		}
		{
			String theVentanasLocalizacionTiposVentanas;
			theVentanasLocalizacionTiposVentanas = this.getVentanasLocalizacionTiposVentanas();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "ventanasLocalizacionTiposVentanas", theVentanasLocalizacionTiposVentanas), currentHashCode, theVentanasLocalizacionTiposVentanas);
		}
		{
			int theCapialzadosTiene;
			theCapialzadosTiene = this.getCapialzadosTiene();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "capialzadosTiene", theCapialzadosTiene), currentHashCode, theCapialzadosTiene);
		}
		{
			int theCapialzadosNoPrefabricados;
			theCapialzadosNoPrefabricados = this.getCapialzadosNoPrefabricados();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "capialzadosNoPrefabricados", theCapialzadosNoPrefabricados), currentHashCode, theCapialzadosNoPrefabricados);
		}
		{
			int theCapialzadosAislamientoAcustico;
			theCapialzadosAislamientoAcustico = this.getCapialzadosAislamientoAcustico();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "capialzadosAislamientoAcustico", theCapialzadosAislamientoAcustico), currentHashCode, theCapialzadosAislamientoAcustico);
		}
		{
			int theAireadoresTiene;
			theAireadoresTiene = this.getAireadoresTiene();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "aireadoresTiene", theAireadoresTiene), currentHashCode, theAireadoresTiene);
		}
		{
			String theAireadoresAsilamientoAcustico;
			theAireadoresAsilamientoAcustico = this.getAireadoresAsilamientoAcustico();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "aireadoresAsilamientoAcustico", theAireadoresAsilamientoAcustico), currentHashCode, theAireadoresAsilamientoAcustico);
		}
		{
			int theRuidoMolestoExterior;
			theRuidoMolestoExterior = this.getRuidoMolestoExterior();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "ruidoMolestoExterior", theRuidoMolestoExterior), currentHashCode, theRuidoMolestoExterior);
		}
		{
			int theEstadoFachadasBueno;
			theEstadoFachadasBueno = this.getEstadoFachadasBueno();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "estadoFachadasBueno", theEstadoFachadasBueno), currentHashCode, theEstadoFachadasBueno);
		}
		{
			int theEstadoCubiertasBueno;
			theEstadoCubiertasBueno = this.getEstadoCubiertasBueno();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "estadoCubiertasBueno", theEstadoCubiertasBueno), currentHashCode, theEstadoCubiertasBueno);
		}
		{
			int theEstadoVentanasBueno;
			theEstadoVentanasBueno = this.getEstadoVentanasBueno();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "estadoVentanasBueno", theEstadoVentanasBueno), currentHashCode, theEstadoVentanasBueno);
		}
		{
			int theEstadoCapialzadosBueno;
			theEstadoCapialzadosBueno = this.getEstadoCapialzadosBueno();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "estadoCapialzadosBueno", theEstadoCapialzadosBueno), currentHashCode, theEstadoCapialzadosBueno);
		}
		{
			String theDeficienciasObservaciones;
			theDeficienciasObservaciones = this.getDeficienciasObservaciones();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "deficienciasObservaciones", theDeficienciasObservaciones), currentHashCode, theDeficienciasObservaciones);
		}
		{
			String theObservaciones;
			theObservaciones = this.getObservaciones();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "observaciones", theObservaciones), currentHashCode, theObservaciones);
		}
		{
			AcusticaRuidoexteriorVentanasType theAcusticaRuidoexteriorVentanas;
			theAcusticaRuidoexteriorVentanas = this.getAcusticaRuidoexteriorVentanas();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "acusticaRuidoexteriorVentanas", theAcusticaRuidoexteriorVentanas), currentHashCode, theAcusticaRuidoexteriorVentanas);
		}
		{
			AcusticaRuidoexteriorVentanaVidriosType theAcusticaRuidoexteriorVentanaVidrios;
			theAcusticaRuidoexteriorVentanaVidrios = this.getAcusticaRuidoexteriorVentanaVidrios();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "acusticaRuidoexteriorVentanaVidrios", theAcusticaRuidoexteriorVentanaVidrios), currentHashCode, theAcusticaRuidoexteriorVentanaVidrios);
		}
		{
			AcusticaRuidoexteriorVentanaAperturasType theAcusticaRuidoexteriorVentanaAperturas;
			theAcusticaRuidoexteriorVentanaAperturas = this.getAcusticaRuidoexteriorVentanaAperturas();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "acusticaRuidoexteriorVentanaAperturas", theAcusticaRuidoexteriorVentanaAperturas), currentHashCode, theAcusticaRuidoexteriorVentanaAperturas);
		}
		return currentHashCode;
	}

	public int hashCode() {
		final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
		return this.hashCode(null, strategy);
	}

}
