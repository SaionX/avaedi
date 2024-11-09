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
 * Clase Java para instalacionesType complex type.
 * 
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que
 * haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="instalacionesType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="saneamiento_bajantes_texto" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="saneamiento_colectores_texto" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="electrica_texto" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="calefaccion_tiene" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="calefaccion_central_tiene" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="calefaccion_central_texto" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="calefaccion_central_combustible_texto" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="calefaccion_nocentral_individualporcentaje" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="calefaccion_nocentral_gascanalizadoporcentaje" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="calefaccion_nocentral_calderagasoleoporcentaje" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="calefaccion_nocentral_calefaccionelectricaporcentaje" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="calefaccion_nocentral_otrosporcentaje" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="acs_tiene" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="acs_central_tiene" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="acs_central_combustible_texto" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="acs_nocentral_individualporcentaje" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="acs_nocentral_gascanalizadoporcentaje" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="acs_nocentral_gasembotelladoporcentaje" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="acs_nocentral_calentadoreselectricosporcentaje" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="acs_nocentral_otrosporcentaje" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="acs_captadoressolares" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="gascanalizado_tiene" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="gascanalizado_porcentaje" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="refrigeracion_tiene" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="refrigeracion_colectivo_tiene" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="refrigeracion_nocolectivo_individualporcentaje" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="refrigeracion_nocolectivo_aparatosenfachadas" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="ventilacion_tiene" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="ventilacion_cuartoshumedos_texto" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="ventilacion_cuartoshumedos_sinventilacion" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="contraincendios_tiene" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="contrarayo_tiene" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="contrarayo_texto" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="comunicacionesict_tiene" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="comunicacionesict_texto" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="observaciones" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="instalaciones_saneamientos" type="{}instalaciones_saneamientosType"/&gt;
 *         &lt;element name="instalaciones_saneamientobajantes" type="{}instalaciones_saneamientobajantesType"/&gt;
 *         &lt;element name="instalaciones_saneamientocolectores" type="{}instalaciones_saneamientocolectoresType"/&gt;
 *         &lt;element name="instalaciones_abastecimientos" type="{}instalaciones_abastecimientosType"/&gt;
 *         &lt;element name="instalaciones_abastecimientocontadores" type="{}instalaciones_abastecimientocontadoresType"/&gt;
 *         &lt;element name="instalaciones_electricas" type="{}instalaciones_electricasType"/&gt;
 *         &lt;element name="instalaciones_electricacontadores" type="{}instalaciones_electricacontadoresType"/&gt;
 *         &lt;element name="instalaciones_calefaccioncentrales" type="{}instalaciones_calefaccioncentralesType"/&gt;
 *         &lt;element name="instalaciones_calefaccioncentralcombustibles" type="{}instalaciones_calefaccioncentralcombustiblesType"/&gt;
 *         &lt;element name="instalaciones_calefaccionnocentralgascanalizados" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="instalaciones_calefaccionnocentralcalefaccionelectricas" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="instalaciones_acscentralcombustibles" type="{}instalaciones_acscentralcombustiblesType"/&gt;
 *         &lt;element name="instalaciones_acsnocentralgascanalizados" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="instalaciones_acsnocentralgasembotellados" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="instalaciones_gascanalizadocombustibles" type="{}instalaciones_gascanalizadocombustiblesType"/&gt;
 *         &lt;element name="instalaciones_gascanalizadocontadores" type="{}instalaciones_gascanalizadocontadoresType"/&gt;
 *         &lt;element name="instalaciones_refrigeracioncolectivotorres" type="{}instalaciones_refrigeracioncolectivotorresType"/&gt;
 *         &lt;element name="instalaciones_ventilacioncuartoshumedos" type="{}instalaciones_ventilacioncuartoshumedosType"/&gt;
 *         &lt;element name="instalaciones_ventilacionaparcamientos" type="{}instalaciones_ventilacionaparcamientosType"/&gt;
 *         &lt;element name="instalaciones_contraincendios" type="{}instalaciones_contraincendiosType"/&gt;
 *         &lt;element name="instalaciones_contrarayos" type="{}instalaciones_contrarayosType"/&gt;
 *         &lt;element name="instalaciones_comunicacionesicts" type="{}instalaciones_comunicacionesictsType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "instalacionesType", propOrder = { "saneamientoBajantesTexto", "saneamientoColectoresTexto", "electricaTexto", "calefaccionTiene", "calefaccionCentralTiene", "calefaccionCentralTexto", "calefaccionCentralCombustibleTexto", "calefaccionNocentralIndividualporcentaje", "calefaccionNocentralGascanalizadoporcentaje", "calefaccionNocentralCalderagasoleoporcentaje", "calefaccionNocentralCalefaccionelectricaporcentaje", "calefaccionNocentralOtrosporcentaje", "acsTiene", "acsCentralTiene", "acsCentralCombustibleTexto", "acsNocentralIndividualporcentaje", "acsNocentralGascanalizadoporcentaje", "acsNocentralGasembotelladoporcentaje", "acsNocentralCalentadoreselectricosporcentaje", "acsNocentralOtrosporcentaje", "acsCaptadoressolares", "gascanalizadoTiene", "gascanalizadoPorcentaje", "refrigeracionTiene", "refrigeracionColectivoTiene", "refrigeracionNocolectivoIndividualporcentaje", "refrigeracionNocolectivoAparatosenfachadas", "ventilacionTiene", "ventilacionCuartoshumedosTexto", "ventilacionCuartoshumedosSinventilacion", "contraincendiosTiene", "contrarayoTiene", "contrarayoTexto", "comunicacionesictTiene", "comunicacionesictTexto", "observaciones", "instalacionesSaneamientos", "instalacionesSaneamientobajantes", "instalacionesSaneamientocolectores", "instalacionesAbastecimientos", "instalacionesAbastecimientocontadores", "instalacionesElectricas", "instalacionesElectricacontadores", "instalacionesCalefaccioncentrales", "instalacionesCalefaccioncentralcombustibles", "instalacionesCalefaccionnocentralgascanalizados", "instalacionesCalefaccionnocentralcalefaccionelectricas", "instalacionesAcscentralcombustibles", "instalacionesAcsnocentralgascanalizados", "instalacionesAcsnocentralgasembotellados", "instalacionesGascanalizadocombustibles", "instalacionesGascanalizadocontadores", "instalacionesRefrigeracioncolectivotorres", "instalacionesVentilacioncuartoshumedos", "instalacionesVentilacionaparcamientos", "instalacionesContraincendios", "instalacionesContrarayos", "instalacionesComunicacionesicts" })
@Entity(name = "InstalacionesType")
@Table(name = "AED_INSTALACIONES")
@Inheritance(strategy = InheritanceType.JOINED)
public class InstalacionesType implements Serializable, Equals, HashCode {

	@XmlElement(name = "saneamiento_bajantes_texto", required = true)
	protected String saneamientoBajantesTexto;
	@XmlElement(name = "saneamiento_colectores_texto", required = true)
	protected String saneamientoColectoresTexto;
	@XmlElement(name = "electrica_texto", required = true)
	protected String electricaTexto;
	@XmlElement(name = "calefaccion_tiene")
	protected int calefaccionTiene;
	@XmlElement(name = "calefaccion_central_tiene")
	protected int calefaccionCentralTiene;
	@XmlElement(name = "calefaccion_central_texto", required = true)
	protected String calefaccionCentralTexto;
	@XmlElement(name = "calefaccion_central_combustible_texto", required = true)
	protected String calefaccionCentralCombustibleTexto;
	@XmlElement(name = "calefaccion_nocentral_individualporcentaje", required = true)
	protected String calefaccionNocentralIndividualporcentaje;
	@XmlElement(name = "calefaccion_nocentral_gascanalizadoporcentaje", required = true)
	protected String calefaccionNocentralGascanalizadoporcentaje;
	@XmlElement(name = "calefaccion_nocentral_calderagasoleoporcentaje", required = true)
	protected String calefaccionNocentralCalderagasoleoporcentaje;
	@XmlElement(name = "calefaccion_nocentral_calefaccionelectricaporcentaje", required = true)
	protected String calefaccionNocentralCalefaccionelectricaporcentaje;
	@XmlElement(name = "calefaccion_nocentral_otrosporcentaje", required = true)
	protected String calefaccionNocentralOtrosporcentaje;
	@XmlElement(name = "acs_tiene")
	protected int acsTiene;
	@XmlElement(name = "acs_central_tiene")
	protected int acsCentralTiene;
	@XmlElement(name = "acs_central_combustible_texto", required = true)
	protected String acsCentralCombustibleTexto;
	@XmlElement(name = "acs_nocentral_individualporcentaje", required = true)
	protected String acsNocentralIndividualporcentaje;
	@XmlElement(name = "acs_nocentral_gascanalizadoporcentaje", required = true)
	protected String acsNocentralGascanalizadoporcentaje;
	@XmlElement(name = "acs_nocentral_gasembotelladoporcentaje", required = true)
	protected String acsNocentralGasembotelladoporcentaje;
	@XmlElement(name = "acs_nocentral_calentadoreselectricosporcentaje", required = true)
	protected String acsNocentralCalentadoreselectricosporcentaje;
	@XmlElement(name = "acs_nocentral_otrosporcentaje", required = true)
	protected String acsNocentralOtrosporcentaje;
	@XmlElement(name = "acs_captadoressolares")
	protected int acsCaptadoressolares;
	@XmlElement(name = "gascanalizado_tiene")
	protected int gascanalizadoTiene;
	@XmlElement(name = "gascanalizado_porcentaje", required = true)
	protected String gascanalizadoPorcentaje;
	@XmlElement(name = "refrigeracion_tiene")
	protected int refrigeracionTiene;
	@XmlElement(name = "refrigeracion_colectivo_tiene")
	protected int refrigeracionColectivoTiene;
	@XmlElement(name = "refrigeracion_nocolectivo_individualporcentaje", required = true)
	protected String refrigeracionNocolectivoIndividualporcentaje;
	@XmlElement(name = "refrigeracion_nocolectivo_aparatosenfachadas", required = true)
	protected String refrigeracionNocolectivoAparatosenfachadas;
	@XmlElement(name = "ventilacion_tiene")
	protected int ventilacionTiene;
	@XmlElement(name = "ventilacion_cuartoshumedos_texto", required = true)
	protected String ventilacionCuartoshumedosTexto;
	@XmlElement(name = "ventilacion_cuartoshumedos_sinventilacion")
	protected int ventilacionCuartoshumedosSinventilacion;
	@XmlElement(name = "contraincendios_tiene")
	protected int contraincendiosTiene;
	@XmlElement(name = "contrarayo_tiene")
	protected int contrarayoTiene;
	@XmlElement(name = "contrarayo_texto", required = true)
	protected String contrarayoTexto;
	@XmlElement(name = "comunicacionesict_tiene")
	protected int comunicacionesictTiene;
	@XmlElement(name = "comunicacionesict_texto", required = true)
	protected String comunicacionesictTexto;
	@XmlElement(required = true)
	protected String observaciones;
	@XmlElement(name = "instalaciones_saneamientos", required = true)
	protected InstalacionesSaneamientosType instalacionesSaneamientos;
	@XmlElement(name = "instalaciones_saneamientobajantes", required = true)
	protected InstalacionesSaneamientobajantesType instalacionesSaneamientobajantes;
	@XmlElement(name = "instalaciones_saneamientocolectores", required = true)
	protected InstalacionesSaneamientocolectoresType instalacionesSaneamientocolectores;
	@XmlElement(name = "instalaciones_abastecimientos", required = true)
	protected InstalacionesAbastecimientosType instalacionesAbastecimientos;
	@XmlElement(name = "instalaciones_abastecimientocontadores", required = true)
	protected InstalacionesAbastecimientocontadoresType instalacionesAbastecimientocontadores;
	@XmlElement(name = "instalaciones_electricas", required = true)
	protected InstalacionesElectricasType instalacionesElectricas;
	@XmlElement(name = "instalaciones_electricacontadores", required = true)
	protected InstalacionesElectricacontadoresType instalacionesElectricacontadores;
	@XmlElement(name = "instalaciones_calefaccioncentrales", required = true)
	protected InstalacionesCalefaccioncentralesType instalacionesCalefaccioncentrales;
	@XmlElement(name = "instalaciones_calefaccioncentralcombustibles", required = true)
	protected InstalacionesCalefaccioncentralcombustiblesType instalacionesCalefaccioncentralcombustibles;
	@XmlElement(name = "instalaciones_calefaccionnocentralgascanalizados", required = true)
	protected String instalacionesCalefaccionnocentralgascanalizados;
	@XmlElement(name = "instalaciones_calefaccionnocentralcalefaccionelectricas", required = true)
	protected String instalacionesCalefaccionnocentralcalefaccionelectricas;
	@XmlElement(name = "instalaciones_acscentralcombustibles", required = true)
	protected InstalacionesAcscentralcombustiblesType instalacionesAcscentralcombustibles;
	@XmlElement(name = "instalaciones_acsnocentralgascanalizados", required = true)
	protected String instalacionesAcsnocentralgascanalizados;
	@XmlElement(name = "instalaciones_acsnocentralgasembotellados", required = true)
	protected String instalacionesAcsnocentralgasembotellados;
	@XmlElement(name = "instalaciones_gascanalizadocombustibles", required = true)
	protected InstalacionesGascanalizadocombustiblesType instalacionesGascanalizadocombustibles;
	@XmlElement(name = "instalaciones_gascanalizadocontadores", required = true)
	protected InstalacionesGascanalizadocontadoresType instalacionesGascanalizadocontadores;
	@XmlElement(name = "instalaciones_refrigeracioncolectivotorres", required = true)
	protected InstalacionesRefrigeracioncolectivotorresType instalacionesRefrigeracioncolectivotorres;
	@XmlElement(name = "instalaciones_ventilacioncuartoshumedos", required = true)
	protected InstalacionesVentilacioncuartoshumedosType instalacionesVentilacioncuartoshumedos;
	@XmlElement(name = "instalaciones_ventilacionaparcamientos", required = true)
	protected InstalacionesVentilacionaparcamientosType instalacionesVentilacionaparcamientos;
	@XmlElement(name = "instalaciones_contraincendios", required = true)
	protected InstalacionesContraincendiosType instalacionesContraincendios;
	@XmlElement(name = "instalaciones_contrarayos", required = true)
	protected InstalacionesContrarayosType instalacionesContrarayos;
	@XmlElement(name = "instalaciones_comunicacionesicts", required = true)
	protected InstalacionesComunicacionesictsType instalacionesComunicacionesicts;
	@XmlAttribute(name = "Hjid")
	protected Long hjid;

	/**
	 * Obtiene el valor de la propiedad saneamientoBajantesTexto.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "SANEAMIENTO_BAJANTES_TEXTO", length = 255)
	public String getSaneamientoBajantesTexto() {
		return saneamientoBajantesTexto;
	}

	/**
	 * Define el valor de la propiedad saneamientoBajantesTexto.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSaneamientoBajantesTexto(String value) {
		this.saneamientoBajantesTexto = value;
	}

	/**
	 * Obtiene el valor de la propiedad saneamientoColectoresTexto.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "SANEAMIENTO_COLECTORES_TEXTO", length = 255)
	public String getSaneamientoColectoresTexto() {
		return saneamientoColectoresTexto;
	}

	/**
	 * Define el valor de la propiedad saneamientoColectoresTexto.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSaneamientoColectoresTexto(String value) {
		this.saneamientoColectoresTexto = value;
	}

	/**
	 * Obtiene el valor de la propiedad electricaTexto.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "ELECTRICA_TEXTO", length = 255)
	public String getElectricaTexto() {
		return electricaTexto;
	}

	/**
	 * Define el valor de la propiedad electricaTexto.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setElectricaTexto(String value) {
		this.electricaTexto = value;
	}

	/**
	 * Obtiene el valor de la propiedad calefaccionTiene.
	 * 
	 */
	@Basic
	@Column(name = "CALEFACCION_TIENE", precision = 10, scale = 0)
	public int getCalefaccionTiene() {
		return calefaccionTiene;
	}

	/**
	 * Define el valor de la propiedad calefaccionTiene.
	 * 
	 */
	public void setCalefaccionTiene(int value) {
		this.calefaccionTiene = value;
	}

	/**
	 * Obtiene el valor de la propiedad calefaccionCentralTiene.
	 * 
	 */
	@Basic
	@Column(name = "CALEFACCION_CENTRAL_TIENE", precision = 10, scale = 0)
	public int getCalefaccionCentralTiene() {
		return calefaccionCentralTiene;
	}

	/**
	 * Define el valor de la propiedad calefaccionCentralTiene.
	 * 
	 */
	public void setCalefaccionCentralTiene(int value) {
		this.calefaccionCentralTiene = value;
	}

	/**
	 * Obtiene el valor de la propiedad calefaccionCentralTexto.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "CALEFACCION_CENTRAL_TEXTO", length = 255)
	public String getCalefaccionCentralTexto() {
		return calefaccionCentralTexto;
	}

	/**
	 * Define el valor de la propiedad calefaccionCentralTexto.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCalefaccionCentralTexto(String value) {
		this.calefaccionCentralTexto = value;
	}

	/**
	 * Obtiene el valor de la propiedad calefaccionCentralCombustibleTexto.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "CALEFACCION_CENTRAL_COMBUSTIBLE_TEXTO", length = 255)
	public String getCalefaccionCentralCombustibleTexto() {
		return calefaccionCentralCombustibleTexto;
	}

	/**
	 * Define el valor de la propiedad calefaccionCentralCombustibleTexto.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCalefaccionCentralCombustibleTexto(String value) {
		this.calefaccionCentralCombustibleTexto = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * calefaccionNocentralIndividualporcentaje.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "CALEFACCION_NOCENTRAL_INDIVIDUALPORCENTAJE", length = 255)
	public String getCalefaccionNocentralIndividualporcentaje() {
		return calefaccionNocentralIndividualporcentaje;
	}

	/**
	 * Define el valor de la propiedad calefaccionNocentralIndividualporcentaje.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCalefaccionNocentralIndividualporcentaje(String value) {
		this.calefaccionNocentralIndividualporcentaje = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * calefaccionNocentralGascanalizadoporcentaje.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "CALEFACCION_NOCENTRAL_GASCANALIZADOPORCENTAJE", length = 255)
	public String getCalefaccionNocentralGascanalizadoporcentaje() {
		return calefaccionNocentralGascanalizadoporcentaje;
	}

	/**
	 * Define el valor de la propiedad
	 * calefaccionNocentralGascanalizadoporcentaje.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCalefaccionNocentralGascanalizadoporcentaje(String value) {
		this.calefaccionNocentralGascanalizadoporcentaje = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * calefaccionNocentralCalderagasoleoporcentaje.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "CALEFACCION_NOCENTRAL_CALDERAGASOLEOPORCENTAJE", length = 255)
	public String getCalefaccionNocentralCalderagasoleoporcentaje() {
		return calefaccionNocentralCalderagasoleoporcentaje;
	}

	/**
	 * Define el valor de la propiedad
	 * calefaccionNocentralCalderagasoleoporcentaje.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCalefaccionNocentralCalderagasoleoporcentaje(String value) {
		this.calefaccionNocentralCalderagasoleoporcentaje = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * calefaccionNocentralCalefaccionelectricaporcentaje.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "CALEFACCION_NOCENTRAL_CALEFACCIONELECTRICAPORCENTAJE", length = 255)
	public String getCalefaccionNocentralCalefaccionelectricaporcentaje() {
		return calefaccionNocentralCalefaccionelectricaporcentaje;
	}

	/**
	 * Define el valor de la propiedad
	 * calefaccionNocentralCalefaccionelectricaporcentaje.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCalefaccionNocentralCalefaccionelectricaporcentaje(String value) {
		this.calefaccionNocentralCalefaccionelectricaporcentaje = value;
	}

	/**
	 * Obtiene el valor de la propiedad calefaccionNocentralOtrosporcentaje.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "CALEFACCION_NOCENTRAL_OTROSPORCENTAJE", length = 255)
	public String getCalefaccionNocentralOtrosporcentaje() {
		return calefaccionNocentralOtrosporcentaje;
	}

	/**
	 * Define el valor de la propiedad calefaccionNocentralOtrosporcentaje.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCalefaccionNocentralOtrosporcentaje(String value) {
		this.calefaccionNocentralOtrosporcentaje = value;
	}

	/**
	 * Obtiene el valor de la propiedad acsTiene.
	 * 
	 */
	@Basic
	@Column(name = "ACS_TIENE", precision = 10, scale = 0)
	public int getAcsTiene() {
		return acsTiene;
	}

	/**
	 * Define el valor de la propiedad acsTiene.
	 * 
	 */
	public void setAcsTiene(int value) {
		this.acsTiene = value;
	}

	/**
	 * Obtiene el valor de la propiedad acsCentralTiene.
	 * 
	 */
	@Basic
	@Column(name = "ACS_CENTRAL_TIENE", precision = 10, scale = 0)
	public int getAcsCentralTiene() {
		return acsCentralTiene;
	}

	/**
	 * Define el valor de la propiedad acsCentralTiene.
	 * 
	 */
	public void setAcsCentralTiene(int value) {
		this.acsCentralTiene = value;
	}

	/**
	 * Obtiene el valor de la propiedad acsCentralCombustibleTexto.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "ACS_CENTRAL_COMBUSTIBLE_TEXTO", length = 255)
	public String getAcsCentralCombustibleTexto() {
		return acsCentralCombustibleTexto;
	}

	/**
	 * Define el valor de la propiedad acsCentralCombustibleTexto.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setAcsCentralCombustibleTexto(String value) {
		this.acsCentralCombustibleTexto = value;
	}

	/**
	 * Obtiene el valor de la propiedad acsNocentralIndividualporcentaje.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "ACS_NOCENTRAL_INDIVIDUALPORCENTAJE", length = 255)
	public String getAcsNocentralIndividualporcentaje() {
		return acsNocentralIndividualporcentaje;
	}

	/**
	 * Define el valor de la propiedad acsNocentralIndividualporcentaje.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setAcsNocentralIndividualporcentaje(String value) {
		this.acsNocentralIndividualporcentaje = value;
	}

	/**
	 * Obtiene el valor de la propiedad acsNocentralGascanalizadoporcentaje.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "ACS_NOCENTRAL_GASCANALIZADOPORCENTAJE", length = 255)
	public String getAcsNocentralGascanalizadoporcentaje() {
		return acsNocentralGascanalizadoporcentaje;
	}

	/**
	 * Define el valor de la propiedad acsNocentralGascanalizadoporcentaje.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setAcsNocentralGascanalizadoporcentaje(String value) {
		this.acsNocentralGascanalizadoporcentaje = value;
	}

	/**
	 * Obtiene el valor de la propiedad acsNocentralGasembotelladoporcentaje.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "ACS_NOCENTRAL_GASEMBOTELLADOPORCENTAJE", length = 255)
	public String getAcsNocentralGasembotelladoporcentaje() {
		return acsNocentralGasembotelladoporcentaje;
	}

	/**
	 * Define el valor de la propiedad acsNocentralGasembotelladoporcentaje.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setAcsNocentralGasembotelladoporcentaje(String value) {
		this.acsNocentralGasembotelladoporcentaje = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * acsNocentralCalentadoreselectricosporcentaje.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "ACS_NOCENTRAL_CALENTADORESELECTRICOSPORCENTAJE", length = 255)
	public String getAcsNocentralCalentadoreselectricosporcentaje() {
		return acsNocentralCalentadoreselectricosporcentaje;
	}

	/**
	 * Define el valor de la propiedad
	 * acsNocentralCalentadoreselectricosporcentaje.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setAcsNocentralCalentadoreselectricosporcentaje(String value) {
		this.acsNocentralCalentadoreselectricosporcentaje = value;
	}

	/**
	 * Obtiene el valor de la propiedad acsNocentralOtrosporcentaje.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "ACS_NOCENTRAL_OTROSPORCENTAJE", length = 255)
	public String getAcsNocentralOtrosporcentaje() {
		return acsNocentralOtrosporcentaje;
	}

	/**
	 * Define el valor de la propiedad acsNocentralOtrosporcentaje.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setAcsNocentralOtrosporcentaje(String value) {
		this.acsNocentralOtrosporcentaje = value;
	}

	/**
	 * Obtiene el valor de la propiedad acsCaptadoressolares.
	 * 
	 */
	@Basic
	@Column(name = "ACS_CAPTADORESSOLARES", precision = 10, scale = 0)
	public int getAcsCaptadoressolares() {
		return acsCaptadoressolares;
	}

	/**
	 * Define el valor de la propiedad acsCaptadoressolares.
	 * 
	 */
	public void setAcsCaptadoressolares(int value) {
		this.acsCaptadoressolares = value;
	}

	/**
	 * Obtiene el valor de la propiedad gascanalizadoTiene.
	 * 
	 */
	@Basic
	@Column(name = "GASCANALIZADO_TIENE", precision = 10, scale = 0)
	public int getGascanalizadoTiene() {
		return gascanalizadoTiene;
	}

	/**
	 * Define el valor de la propiedad gascanalizadoTiene.
	 * 
	 */
	public void setGascanalizadoTiene(int value) {
		this.gascanalizadoTiene = value;
	}

	/**
	 * Obtiene el valor de la propiedad gascanalizadoPorcentaje.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "GASCANALIZADO_PORCENTAJE", length = 255)
	public String getGascanalizadoPorcentaje() {
		return gascanalizadoPorcentaje;
	}

	/**
	 * Define el valor de la propiedad gascanalizadoPorcentaje.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setGascanalizadoPorcentaje(String value) {
		this.gascanalizadoPorcentaje = value;
	}

	/**
	 * Obtiene el valor de la propiedad refrigeracionTiene.
	 * 
	 */
	@Basic
	@Column(name = "REFRIGERACION_TIENE", precision = 10, scale = 0)
	public int getRefrigeracionTiene() {
		return refrigeracionTiene;
	}

	/**
	 * Define el valor de la propiedad refrigeracionTiene.
	 * 
	 */
	public void setRefrigeracionTiene(int value) {
		this.refrigeracionTiene = value;
	}

	/**
	 * Obtiene el valor de la propiedad refrigeracionColectivoTiene.
	 * 
	 */
	@Basic
	@Column(name = "REFRIGERACION_COLECTIVO_TIENE", precision = 10, scale = 0)
	public int getRefrigeracionColectivoTiene() {
		return refrigeracionColectivoTiene;
	}

	/**
	 * Define el valor de la propiedad refrigeracionColectivoTiene.
	 * 
	 */
	public void setRefrigeracionColectivoTiene(int value) {
		this.refrigeracionColectivoTiene = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * refrigeracionNocolectivoIndividualporcentaje.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "REFRIGERACION_NOCOLECTIVO_INDIVIDUALPORCENTAJE", length = 255)
	public String getRefrigeracionNocolectivoIndividualporcentaje() {
		return refrigeracionNocolectivoIndividualporcentaje;
	}

	/**
	 * Define el valor de la propiedad
	 * refrigeracionNocolectivoIndividualporcentaje.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRefrigeracionNocolectivoIndividualporcentaje(String value) {
		this.refrigeracionNocolectivoIndividualporcentaje = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * refrigeracionNocolectivoAparatosenfachadas.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "REFRIGERACION_NOCOLECTIVO_APARATOSENFACHADAS", length = 255)
	public String getRefrigeracionNocolectivoAparatosenfachadas() {
		return refrigeracionNocolectivoAparatosenfachadas;
	}

	/**
	 * Define el valor de la propiedad
	 * refrigeracionNocolectivoAparatosenfachadas.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRefrigeracionNocolectivoAparatosenfachadas(String value) {
		this.refrigeracionNocolectivoAparatosenfachadas = value;
	}

	/**
	 * Obtiene el valor de la propiedad ventilacionTiene.
	 * 
	 */
	@Basic
	@Column(name = "VENTILACION_TIENE", precision = 10, scale = 0)
	public int getVentilacionTiene() {
		return ventilacionTiene;
	}

	/**
	 * Define el valor de la propiedad ventilacionTiene.
	 * 
	 */
	public void setVentilacionTiene(int value) {
		this.ventilacionTiene = value;
	}

	/**
	 * Obtiene el valor de la propiedad ventilacionCuartoshumedosTexto.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "VENTILACION_CUARTOSHUMEDOS_TEXTO", length = 255)
	public String getVentilacionCuartoshumedosTexto() {
		return ventilacionCuartoshumedosTexto;
	}

	/**
	 * Define el valor de la propiedad ventilacionCuartoshumedosTexto.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setVentilacionCuartoshumedosTexto(String value) {
		this.ventilacionCuartoshumedosTexto = value;
	}

	/**
	 * Obtiene el valor de la propiedad ventilacionCuartoshumedosSinventilacion.
	 * 
	 */
	@Basic
	@Column(name = "VENTILACION_CUARTOSHUMEDOS_SINVENTILACION", precision = 10, scale = 0)
	public int getVentilacionCuartoshumedosSinventilacion() {
		return ventilacionCuartoshumedosSinventilacion;
	}

	/**
	 * Define el valor de la propiedad ventilacionCuartoshumedosSinventilacion.
	 * 
	 */
	public void setVentilacionCuartoshumedosSinventilacion(int value) {
		this.ventilacionCuartoshumedosSinventilacion = value;
	}

	/**
	 * Obtiene el valor de la propiedad contraincendiosTiene.
	 * 
	 */
	@Basic
	@Column(name = "CONTRAINCENDIOS_TIENE", precision = 10, scale = 0)
	public int getContraincendiosTiene() {
		return contraincendiosTiene;
	}

	/**
	 * Define el valor de la propiedad contraincendiosTiene.
	 * 
	 */
	public void setContraincendiosTiene(int value) {
		this.contraincendiosTiene = value;
	}

	/**
	 * Obtiene el valor de la propiedad contrarayoTiene.
	 * 
	 */
	@Basic
	@Column(name = "CONTRARAYO_TIENE", precision = 10, scale = 0)
	public int getContrarayoTiene() {
		return contrarayoTiene;
	}

	/**
	 * Define el valor de la propiedad contrarayoTiene.
	 * 
	 */
	public void setContrarayoTiene(int value) {
		this.contrarayoTiene = value;
	}

	/**
	 * Obtiene el valor de la propiedad contrarayoTexto.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "CONTRARAYO_TEXTO", length = 255)
	public String getContrarayoTexto() {
		return contrarayoTexto;
	}

	/**
	 * Define el valor de la propiedad contrarayoTexto.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setContrarayoTexto(String value) {
		this.contrarayoTexto = value;
	}

	/**
	 * Obtiene el valor de la propiedad comunicacionesictTiene.
	 * 
	 */
	@Basic
	@Column(name = "COMUNICACIONESICT_TIENE", precision = 10, scale = 0)
	public int getComunicacionesictTiene() {
		return comunicacionesictTiene;
	}

	/**
	 * Define el valor de la propiedad comunicacionesictTiene.
	 * 
	 */
	public void setComunicacionesictTiene(int value) {
		this.comunicacionesictTiene = value;
	}

	/**
	 * Obtiene el valor de la propiedad comunicacionesictTexto.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "COMUNICACIONESICT_TEXTO", length = 255)
	public String getComunicacionesictTexto() {
		return comunicacionesictTexto;
	}

	/**
	 * Define el valor de la propiedad comunicacionesictTexto.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setComunicacionesictTexto(String value) {
		this.comunicacionesictTexto = value;
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
	 * Obtiene el valor de la propiedad instalacionesSaneamientos.
	 * 
	 * @return possible object is {@link InstalacionesSaneamientosType }
	 * 
	 */
	@ManyToOne(targetEntity = InstalacionesSaneamientosType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "INSTALACIONES_SANEAMIENTOS_AED_INSTALACIONES_HJID")
	public InstalacionesSaneamientosType getInstalacionesSaneamientos() {
		return instalacionesSaneamientos;
	}

	/**
	 * Define el valor de la propiedad instalacionesSaneamientos.
	 * 
	 * @param value
	 *            allowed object is {@link InstalacionesSaneamientosType }
	 * 
	 */
	public void setInstalacionesSaneamientos(InstalacionesSaneamientosType value) {
		this.instalacionesSaneamientos = value;
	}

	/**
	 * Obtiene el valor de la propiedad instalacionesSaneamientobajantes.
	 * 
	 * @return possible object is {@link InstalacionesSaneamientobajantesType }
	 * 
	 */
	@ManyToOne(targetEntity = InstalacionesSaneamientobajantesType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "INSTALACIONES_SANEAMIENTOBAJANTES_AED_INSTALACIONES_HJID")
	public InstalacionesSaneamientobajantesType getInstalacionesSaneamientobajantes() {
		return instalacionesSaneamientobajantes;
	}

	/**
	 * Define el valor de la propiedad instalacionesSaneamientobajantes.
	 * 
	 * @param value
	 *            allowed object is {@link InstalacionesSaneamientobajantesType }
	 * 
	 */
	public void setInstalacionesSaneamientobajantes(InstalacionesSaneamientobajantesType value) {
		this.instalacionesSaneamientobajantes = value;
	}

	/**
	 * Obtiene el valor de la propiedad instalacionesSaneamientocolectores.
	 * 
	 * @return possible object is {@link InstalacionesSaneamientocolectoresType }
	 * 
	 */
	@ManyToOne(targetEntity = InstalacionesSaneamientocolectoresType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "INSTALACIONES_SANEAMIENTOCOLECTORES_AED_INSTALACIONES_HJID")
	public InstalacionesSaneamientocolectoresType getInstalacionesSaneamientocolectores() {
		return instalacionesSaneamientocolectores;
	}

	/**
	 * Define el valor de la propiedad instalacionesSaneamientocolectores.
	 * 
	 * @param value
	 *            allowed object is
	 *            {@link InstalacionesSaneamientocolectoresType }
	 * 
	 */
	public void setInstalacionesSaneamientocolectores(InstalacionesSaneamientocolectoresType value) {
		this.instalacionesSaneamientocolectores = value;
	}

	/**
	 * Obtiene el valor de la propiedad instalacionesAbastecimientos.
	 * 
	 * @return possible object is {@link InstalacionesAbastecimientosType }
	 * 
	 */
	@ManyToOne(targetEntity = InstalacionesAbastecimientosType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "INSTALACIONES_ABASTECIMIENTOS_AED_INSTALACIONES_HJID")
	public InstalacionesAbastecimientosType getInstalacionesAbastecimientos() {
		return instalacionesAbastecimientos;
	}

	/**
	 * Define el valor de la propiedad instalacionesAbastecimientos.
	 * 
	 * @param value
	 *            allowed object is {@link InstalacionesAbastecimientosType }
	 * 
	 */
	public void setInstalacionesAbastecimientos(InstalacionesAbastecimientosType value) {
		this.instalacionesAbastecimientos = value;
	}

	/**
	 * Obtiene el valor de la propiedad instalacionesAbastecimientocontadores.
	 * 
	 * @return possible object is
	 *         {@link InstalacionesAbastecimientocontadoresType }
	 * 
	 */
	@ManyToOne(targetEntity = InstalacionesAbastecimientocontadoresType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "INSTALACIONES_ABASTECIMIENTOCONTADORES_AED_INSTALACIONES_HJID")
	public InstalacionesAbastecimientocontadoresType getInstalacionesAbastecimientocontadores() {
		return instalacionesAbastecimientocontadores;
	}

	/**
	 * Define el valor de la propiedad instalacionesAbastecimientocontadores.
	 * 
	 * @param value
	 *            allowed object is
	 *            {@link InstalacionesAbastecimientocontadoresType }
	 * 
	 */
	public void setInstalacionesAbastecimientocontadores(InstalacionesAbastecimientocontadoresType value) {
		this.instalacionesAbastecimientocontadores = value;
	}

	/**
	 * Obtiene el valor de la propiedad instalacionesElectricas.
	 * 
	 * @return possible object is {@link InstalacionesElectricasType }
	 * 
	 */
	@ManyToOne(targetEntity = InstalacionesElectricasType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "INSTALACIONES_ELECTRICAS_AED_INSTALACIONES_HJID")
	public InstalacionesElectricasType getInstalacionesElectricas() {
		return instalacionesElectricas;
	}

	/**
	 * Define el valor de la propiedad instalacionesElectricas.
	 * 
	 * @param value
	 *            allowed object is {@link InstalacionesElectricasType }
	 * 
	 */
	public void setInstalacionesElectricas(InstalacionesElectricasType value) {
		this.instalacionesElectricas = value;
	}

	/**
	 * Obtiene el valor de la propiedad instalacionesElectricacontadores.
	 * 
	 * @return possible object is {@link InstalacionesElectricacontadoresType }
	 * 
	 */
	@ManyToOne(targetEntity = InstalacionesElectricacontadoresType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "INSTALACIONES_ELECTRICACONTADORES_AED_INSTALACIONES_HJID")
	public InstalacionesElectricacontadoresType getInstalacionesElectricacontadores() {
		return instalacionesElectricacontadores;
	}

	/**
	 * Define el valor de la propiedad instalacionesElectricacontadores.
	 * 
	 * @param value
	 *            allowed object is {@link InstalacionesElectricacontadoresType }
	 * 
	 */
	public void setInstalacionesElectricacontadores(InstalacionesElectricacontadoresType value) {
		this.instalacionesElectricacontadores = value;
	}

	/**
	 * Obtiene el valor de la propiedad instalacionesCalefaccioncentrales.
	 * 
	 * @return possible object is {@link InstalacionesCalefaccioncentralesType }
	 * 
	 */
	@ManyToOne(targetEntity = InstalacionesCalefaccioncentralesType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "INSTALACIONES_CALEFACCIONCENTRALES_AED_INSTALACIONES_HJID")
	public InstalacionesCalefaccioncentralesType getInstalacionesCalefaccioncentrales() {
		return instalacionesCalefaccioncentrales;
	}

	/**
	 * Define el valor de la propiedad instalacionesCalefaccioncentrales.
	 * 
	 * @param value
	 *            allowed object is
	 *            {@link InstalacionesCalefaccioncentralesType }
	 * 
	 */
	public void setInstalacionesCalefaccioncentrales(InstalacionesCalefaccioncentralesType value) {
		this.instalacionesCalefaccioncentrales = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * instalacionesCalefaccioncentralcombustibles.
	 * 
	 * @return possible object is
	 *         {@link InstalacionesCalefaccioncentralcombustiblesType }
	 * 
	 */
	@ManyToOne(targetEntity = InstalacionesCalefaccioncentralcombustiblesType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "INSTALACIONES_CALEFACCIONCENTRALCOMBUSTIBLES_AED_INSTALACIONES_HJID")
	public InstalacionesCalefaccioncentralcombustiblesType getInstalacionesCalefaccioncentralcombustibles() {
		return instalacionesCalefaccioncentralcombustibles;
	}

	/**
	 * Define el valor de la propiedad
	 * instalacionesCalefaccioncentralcombustibles.
	 * 
	 * @param value
	 *            allowed object is
	 *            {@link InstalacionesCalefaccioncentralcombustiblesType }
	 * 
	 */
	public void setInstalacionesCalefaccioncentralcombustibles(InstalacionesCalefaccioncentralcombustiblesType value) {
		this.instalacionesCalefaccioncentralcombustibles = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * instalacionesCalefaccionnocentralgascanalizados.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "INSTALACIONES_CALEFACCIONNOCENTRALGASCANALIZADOS", length = 255)
	public String getInstalacionesCalefaccionnocentralgascanalizados() {
		return instalacionesCalefaccionnocentralgascanalizados;
	}

	/**
	 * Define el valor de la propiedad
	 * instalacionesCalefaccionnocentralgascanalizados.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setInstalacionesCalefaccionnocentralgascanalizados(String value) {
		this.instalacionesCalefaccionnocentralgascanalizados = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * instalacionesCalefaccionnocentralcalefaccionelectricas.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "INSTALACIONES_CALEFACCIONNOCENTRALCALEFACCIONELECTRICAS", length = 255)
	public String getInstalacionesCalefaccionnocentralcalefaccionelectricas() {
		return instalacionesCalefaccionnocentralcalefaccionelectricas;
	}

	/**
	 * Define el valor de la propiedad
	 * instalacionesCalefaccionnocentralcalefaccionelectricas.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setInstalacionesCalefaccionnocentralcalefaccionelectricas(String value) {
		this.instalacionesCalefaccionnocentralcalefaccionelectricas = value;
	}

	/**
	 * Obtiene el valor de la propiedad instalacionesAcscentralcombustibles.
	 * 
	 * @return possible object is
	 *         {@link InstalacionesAcscentralcombustiblesType }
	 * 
	 */
	@ManyToOne(targetEntity = InstalacionesAcscentralcombustiblesType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "INSTALACIONES_ACSCENTRALCOMBUSTIBLES_AED_INSTALACIONES_HJID")
	public InstalacionesAcscentralcombustiblesType getInstalacionesAcscentralcombustibles() {
		return instalacionesAcscentralcombustibles;
	}

	/**
	 * Define el valor de la propiedad instalacionesAcscentralcombustibles.
	 * 
	 * @param value
	 *            allowed object is
	 *            {@link InstalacionesAcscentralcombustiblesType }
	 * 
	 */
	public void setInstalacionesAcscentralcombustibles(InstalacionesAcscentralcombustiblesType value) {
		this.instalacionesAcscentralcombustibles = value;
	}

	/**
	 * Obtiene el valor de la propiedad instalacionesAcsnocentralgascanalizados.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "INSTALACIONES_ACSNOCENTRALGASCANALIZADOS", length = 255)
	public String getInstalacionesAcsnocentralgascanalizados() {
		return instalacionesAcsnocentralgascanalizados;
	}

	/**
	 * Define el valor de la propiedad instalacionesAcsnocentralgascanalizados.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setInstalacionesAcsnocentralgascanalizados(String value) {
		this.instalacionesAcsnocentralgascanalizados = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * instalacionesAcsnocentralgasembotellados.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "INSTALACIONES_ACSNOCENTRALGASEMBOTELLADOS", length = 255)
	public String getInstalacionesAcsnocentralgasembotellados() {
		return instalacionesAcsnocentralgasembotellados;
	}

	/**
	 * Define el valor de la propiedad instalacionesAcsnocentralgasembotellados.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setInstalacionesAcsnocentralgasembotellados(String value) {
		this.instalacionesAcsnocentralgasembotellados = value;
	}

	/**
	 * Obtiene el valor de la propiedad instalacionesGascanalizadocombustibles.
	 * 
	 * @return possible object is
	 *         {@link InstalacionesGascanalizadocombustiblesType }
	 * 
	 */
	@ManyToOne(targetEntity = InstalacionesGascanalizadocombustiblesType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "INSTALACIONES_GASCANALIZADOCOMBUSTIBLES_AED_INSTALACIONES_HJID")
	public InstalacionesGascanalizadocombustiblesType getInstalacionesGascanalizadocombustibles() {
		return instalacionesGascanalizadocombustibles;
	}

	/**
	 * Define el valor de la propiedad instalacionesGascanalizadocombustibles.
	 * 
	 * @param value
	 *            allowed object is
	 *            {@link InstalacionesGascanalizadocombustiblesType }
	 * 
	 */
	public void setInstalacionesGascanalizadocombustibles(InstalacionesGascanalizadocombustiblesType value) {
		this.instalacionesGascanalizadocombustibles = value;
	}

	/**
	 * Obtiene el valor de la propiedad instalacionesGascanalizadocontadores.
	 * 
	 * @return possible object is
	 *         {@link InstalacionesGascanalizadocontadoresType }
	 * 
	 */
	@ManyToOne(targetEntity = InstalacionesGascanalizadocontadoresType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "INSTALACIONES_GASCANALIZADOCONTADORES_AED_INSTALACIONES_HJID")
	public InstalacionesGascanalizadocontadoresType getInstalacionesGascanalizadocontadores() {
		return instalacionesGascanalizadocontadores;
	}

	/**
	 * Define el valor de la propiedad instalacionesGascanalizadocontadores.
	 * 
	 * @param value
	 *            allowed object is
	 *            {@link InstalacionesGascanalizadocontadoresType }
	 * 
	 */
	public void setInstalacionesGascanalizadocontadores(InstalacionesGascanalizadocontadoresType value) {
		this.instalacionesGascanalizadocontadores = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * instalacionesRefrigeracioncolectivotorres.
	 * 
	 * @return possible object is
	 *         {@link InstalacionesRefrigeracioncolectivotorresType }
	 * 
	 */
	@ManyToOne(targetEntity = InstalacionesRefrigeracioncolectivotorresType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "INSTALACIONES_REFRIGERACIONCOLECTIVOTORRES_AED_INSTALACIONES_HJID")
	public InstalacionesRefrigeracioncolectivotorresType getInstalacionesRefrigeracioncolectivotorres() {
		return instalacionesRefrigeracioncolectivotorres;
	}

	/**
	 * Define el valor de la propiedad
	 * instalacionesRefrigeracioncolectivotorres.
	 * 
	 * @param value
	 *            allowed object is
	 *            {@link InstalacionesRefrigeracioncolectivotorresType }
	 * 
	 */
	public void setInstalacionesRefrigeracioncolectivotorres(InstalacionesRefrigeracioncolectivotorresType value) {
		this.instalacionesRefrigeracioncolectivotorres = value;
	}

	/**
	 * Obtiene el valor de la propiedad instalacionesVentilacioncuartoshumedos.
	 * 
	 * @return possible object is
	 *         {@link InstalacionesVentilacioncuartoshumedosType }
	 * 
	 */
	@ManyToOne(targetEntity = InstalacionesVentilacioncuartoshumedosType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "INSTALACIONES_VENTILACIONCUARTOSHUMEDOS_AED_INSTALACIONES_HJID")
	public InstalacionesVentilacioncuartoshumedosType getInstalacionesVentilacioncuartoshumedos() {
		return instalacionesVentilacioncuartoshumedos;
	}

	/**
	 * Define el valor de la propiedad instalacionesVentilacioncuartoshumedos.
	 * 
	 * @param value
	 *            allowed object is
	 *            {@link InstalacionesVentilacioncuartoshumedosType }
	 * 
	 */
	public void setInstalacionesVentilacioncuartoshumedos(InstalacionesVentilacioncuartoshumedosType value) {
		this.instalacionesVentilacioncuartoshumedos = value;
	}

	/**
	 * Obtiene el valor de la propiedad instalacionesVentilacionaparcamientos.
	 * 
	 * @return possible object is
	 *         {@link InstalacionesVentilacionaparcamientosType }
	 * 
	 */
	@ManyToOne(targetEntity = InstalacionesVentilacionaparcamientosType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "INSTALACIONES_VENTILACIONAPARCAMIENTOS_AED_INSTALACIONES_HJID")
	public InstalacionesVentilacionaparcamientosType getInstalacionesVentilacionaparcamientos() {
		return instalacionesVentilacionaparcamientos;
	}

	/**
	 * Define el valor de la propiedad instalacionesVentilacionaparcamientos.
	 * 
	 * @param value
	 *            allowed object is
	 *            {@link InstalacionesVentilacionaparcamientosType }
	 * 
	 */
	public void setInstalacionesVentilacionaparcamientos(InstalacionesVentilacionaparcamientosType value) {
		this.instalacionesVentilacionaparcamientos = value;
	}

	/**
	 * Obtiene el valor de la propiedad instalacionesContraincendios.
	 * 
	 * @return possible object is {@link InstalacionesContraincendiosType }
	 * 
	 */
	@ManyToOne(targetEntity = InstalacionesContraincendiosType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "INSTALACIONES_CONTRAINCENDIOS_AED_INSTALACIONES_HJID")
	public InstalacionesContraincendiosType getInstalacionesContraincendios() {
		return instalacionesContraincendios;
	}

	/**
	 * Define el valor de la propiedad instalacionesContraincendios.
	 * 
	 * @param value
	 *            allowed object is {@link InstalacionesContraincendiosType }
	 * 
	 */
	public void setInstalacionesContraincendios(InstalacionesContraincendiosType value) {
		this.instalacionesContraincendios = value;
	}

	/**
	 * Obtiene el valor de la propiedad instalacionesContrarayos.
	 * 
	 * @return possible object is {@link InstalacionesContrarayosType }
	 * 
	 */
	@ManyToOne(targetEntity = InstalacionesContrarayosType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "INSTALACIONES_CONTRARAYOS_AED_INSTALACIONES_HJID")
	public InstalacionesContrarayosType getInstalacionesContrarayos() {
		return instalacionesContrarayos;
	}

	/**
	 * Define el valor de la propiedad instalacionesContrarayos.
	 * 
	 * @param value
	 *            allowed object is {@link InstalacionesContrarayosType }
	 * 
	 */
	public void setInstalacionesContrarayos(InstalacionesContrarayosType value) {
		this.instalacionesContrarayos = value;
	}

	/**
	 * Obtiene el valor de la propiedad instalacionesComunicacionesicts.
	 * 
	 * @return possible object is {@link InstalacionesComunicacionesictsType }
	 * 
	 */
	@ManyToOne(targetEntity = InstalacionesComunicacionesictsType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "INSTALACIONES_COMUNICACIONESICTS_AED_INSTALACIONES_HJID")
	public InstalacionesComunicacionesictsType getInstalacionesComunicacionesicts() {
		return instalacionesComunicacionesicts;
	}

	/**
	 * Define el valor de la propiedad instalacionesComunicacionesicts.
	 * 
	 * @param value
	 *            allowed object is {@link InstalacionesComunicacionesictsType }
	 * 
	 */
	public void setInstalacionesComunicacionesicts(InstalacionesComunicacionesictsType value) {
		this.instalacionesComunicacionesicts = value;
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
		final InstalacionesType that = ((InstalacionesType) object);
		{
			String lhsSaneamientoBajantesTexto;
			lhsSaneamientoBajantesTexto = this.getSaneamientoBajantesTexto();
			String rhsSaneamientoBajantesTexto;
			rhsSaneamientoBajantesTexto = that.getSaneamientoBajantesTexto();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "saneamientoBajantesTexto", lhsSaneamientoBajantesTexto), LocatorUtils.property(thatLocator, "saneamientoBajantesTexto", rhsSaneamientoBajantesTexto), lhsSaneamientoBajantesTexto, rhsSaneamientoBajantesTexto)) {
				return false;
			}
		}
		{
			String lhsSaneamientoColectoresTexto;
			lhsSaneamientoColectoresTexto = this.getSaneamientoColectoresTexto();
			String rhsSaneamientoColectoresTexto;
			rhsSaneamientoColectoresTexto = that.getSaneamientoColectoresTexto();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "saneamientoColectoresTexto", lhsSaneamientoColectoresTexto), LocatorUtils.property(thatLocator, "saneamientoColectoresTexto", rhsSaneamientoColectoresTexto), lhsSaneamientoColectoresTexto, rhsSaneamientoColectoresTexto)) {
				return false;
			}
		}
		{
			String lhsElectricaTexto;
			lhsElectricaTexto = this.getElectricaTexto();
			String rhsElectricaTexto;
			rhsElectricaTexto = that.getElectricaTexto();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "electricaTexto", lhsElectricaTexto), LocatorUtils.property(thatLocator, "electricaTexto", rhsElectricaTexto), lhsElectricaTexto, rhsElectricaTexto)) {
				return false;
			}
		}
		{
			int lhsCalefaccionTiene;
			lhsCalefaccionTiene = this.getCalefaccionTiene();
			int rhsCalefaccionTiene;
			rhsCalefaccionTiene = that.getCalefaccionTiene();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "calefaccionTiene", lhsCalefaccionTiene), LocatorUtils.property(thatLocator, "calefaccionTiene", rhsCalefaccionTiene), lhsCalefaccionTiene, rhsCalefaccionTiene)) {
				return false;
			}
		}
		{
			int lhsCalefaccionCentralTiene;
			lhsCalefaccionCentralTiene = this.getCalefaccionCentralTiene();
			int rhsCalefaccionCentralTiene;
			rhsCalefaccionCentralTiene = that.getCalefaccionCentralTiene();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "calefaccionCentralTiene", lhsCalefaccionCentralTiene), LocatorUtils.property(thatLocator, "calefaccionCentralTiene", rhsCalefaccionCentralTiene), lhsCalefaccionCentralTiene, rhsCalefaccionCentralTiene)) {
				return false;
			}
		}
		{
			String lhsCalefaccionCentralTexto;
			lhsCalefaccionCentralTexto = this.getCalefaccionCentralTexto();
			String rhsCalefaccionCentralTexto;
			rhsCalefaccionCentralTexto = that.getCalefaccionCentralTexto();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "calefaccionCentralTexto", lhsCalefaccionCentralTexto), LocatorUtils.property(thatLocator, "calefaccionCentralTexto", rhsCalefaccionCentralTexto), lhsCalefaccionCentralTexto, rhsCalefaccionCentralTexto)) {
				return false;
			}
		}
		{
			String lhsCalefaccionCentralCombustibleTexto;
			lhsCalefaccionCentralCombustibleTexto = this.getCalefaccionCentralCombustibleTexto();
			String rhsCalefaccionCentralCombustibleTexto;
			rhsCalefaccionCentralCombustibleTexto = that.getCalefaccionCentralCombustibleTexto();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "calefaccionCentralCombustibleTexto", lhsCalefaccionCentralCombustibleTexto), LocatorUtils.property(thatLocator, "calefaccionCentralCombustibleTexto", rhsCalefaccionCentralCombustibleTexto), lhsCalefaccionCentralCombustibleTexto, rhsCalefaccionCentralCombustibleTexto)) {
				return false;
			}
		}
		{
			String lhsCalefaccionNocentralIndividualporcentaje;
			lhsCalefaccionNocentralIndividualporcentaje = this.getCalefaccionNocentralIndividualporcentaje();
			String rhsCalefaccionNocentralIndividualporcentaje;
			rhsCalefaccionNocentralIndividualporcentaje = that.getCalefaccionNocentralIndividualporcentaje();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "calefaccionNocentralIndividualporcentaje", lhsCalefaccionNocentralIndividualporcentaje), LocatorUtils.property(thatLocator, "calefaccionNocentralIndividualporcentaje", rhsCalefaccionNocentralIndividualporcentaje), lhsCalefaccionNocentralIndividualporcentaje, rhsCalefaccionNocentralIndividualporcentaje)) {
				return false;
			}
		}
		{
			String lhsCalefaccionNocentralGascanalizadoporcentaje;
			lhsCalefaccionNocentralGascanalizadoporcentaje = this.getCalefaccionNocentralGascanalizadoporcentaje();
			String rhsCalefaccionNocentralGascanalizadoporcentaje;
			rhsCalefaccionNocentralGascanalizadoporcentaje = that.getCalefaccionNocentralGascanalizadoporcentaje();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "calefaccionNocentralGascanalizadoporcentaje", lhsCalefaccionNocentralGascanalizadoporcentaje), LocatorUtils.property(thatLocator, "calefaccionNocentralGascanalizadoporcentaje", rhsCalefaccionNocentralGascanalizadoporcentaje), lhsCalefaccionNocentralGascanalizadoporcentaje, rhsCalefaccionNocentralGascanalizadoporcentaje)) {
				return false;
			}
		}
		{
			String lhsCalefaccionNocentralCalderagasoleoporcentaje;
			lhsCalefaccionNocentralCalderagasoleoporcentaje = this.getCalefaccionNocentralCalderagasoleoporcentaje();
			String rhsCalefaccionNocentralCalderagasoleoporcentaje;
			rhsCalefaccionNocentralCalderagasoleoporcentaje = that.getCalefaccionNocentralCalderagasoleoporcentaje();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "calefaccionNocentralCalderagasoleoporcentaje", lhsCalefaccionNocentralCalderagasoleoporcentaje), LocatorUtils.property(thatLocator, "calefaccionNocentralCalderagasoleoporcentaje", rhsCalefaccionNocentralCalderagasoleoporcentaje), lhsCalefaccionNocentralCalderagasoleoporcentaje, rhsCalefaccionNocentralCalderagasoleoporcentaje)) {
				return false;
			}
		}
		{
			String lhsCalefaccionNocentralCalefaccionelectricaporcentaje;
			lhsCalefaccionNocentralCalefaccionelectricaporcentaje = this.getCalefaccionNocentralCalefaccionelectricaporcentaje();
			String rhsCalefaccionNocentralCalefaccionelectricaporcentaje;
			rhsCalefaccionNocentralCalefaccionelectricaporcentaje = that.getCalefaccionNocentralCalefaccionelectricaporcentaje();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "calefaccionNocentralCalefaccionelectricaporcentaje", lhsCalefaccionNocentralCalefaccionelectricaporcentaje), LocatorUtils.property(thatLocator, "calefaccionNocentralCalefaccionelectricaporcentaje", rhsCalefaccionNocentralCalefaccionelectricaporcentaje), lhsCalefaccionNocentralCalefaccionelectricaporcentaje, rhsCalefaccionNocentralCalefaccionelectricaporcentaje)) {
				return false;
			}
		}
		{
			String lhsCalefaccionNocentralOtrosporcentaje;
			lhsCalefaccionNocentralOtrosporcentaje = this.getCalefaccionNocentralOtrosporcentaje();
			String rhsCalefaccionNocentralOtrosporcentaje;
			rhsCalefaccionNocentralOtrosporcentaje = that.getCalefaccionNocentralOtrosporcentaje();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "calefaccionNocentralOtrosporcentaje", lhsCalefaccionNocentralOtrosporcentaje), LocatorUtils.property(thatLocator, "calefaccionNocentralOtrosporcentaje", rhsCalefaccionNocentralOtrosporcentaje), lhsCalefaccionNocentralOtrosporcentaje, rhsCalefaccionNocentralOtrosporcentaje)) {
				return false;
			}
		}
		{
			int lhsAcsTiene;
			lhsAcsTiene = this.getAcsTiene();
			int rhsAcsTiene;
			rhsAcsTiene = that.getAcsTiene();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "acsTiene", lhsAcsTiene), LocatorUtils.property(thatLocator, "acsTiene", rhsAcsTiene), lhsAcsTiene, rhsAcsTiene)) {
				return false;
			}
		}
		{
			int lhsAcsCentralTiene;
			lhsAcsCentralTiene = this.getAcsCentralTiene();
			int rhsAcsCentralTiene;
			rhsAcsCentralTiene = that.getAcsCentralTiene();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "acsCentralTiene", lhsAcsCentralTiene), LocatorUtils.property(thatLocator, "acsCentralTiene", rhsAcsCentralTiene), lhsAcsCentralTiene, rhsAcsCentralTiene)) {
				return false;
			}
		}
		{
			String lhsAcsCentralCombustibleTexto;
			lhsAcsCentralCombustibleTexto = this.getAcsCentralCombustibleTexto();
			String rhsAcsCentralCombustibleTexto;
			rhsAcsCentralCombustibleTexto = that.getAcsCentralCombustibleTexto();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "acsCentralCombustibleTexto", lhsAcsCentralCombustibleTexto), LocatorUtils.property(thatLocator, "acsCentralCombustibleTexto", rhsAcsCentralCombustibleTexto), lhsAcsCentralCombustibleTexto, rhsAcsCentralCombustibleTexto)) {
				return false;
			}
		}
		{
			String lhsAcsNocentralIndividualporcentaje;
			lhsAcsNocentralIndividualporcentaje = this.getAcsNocentralIndividualporcentaje();
			String rhsAcsNocentralIndividualporcentaje;
			rhsAcsNocentralIndividualporcentaje = that.getAcsNocentralIndividualporcentaje();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "acsNocentralIndividualporcentaje", lhsAcsNocentralIndividualporcentaje), LocatorUtils.property(thatLocator, "acsNocentralIndividualporcentaje", rhsAcsNocentralIndividualporcentaje), lhsAcsNocentralIndividualporcentaje, rhsAcsNocentralIndividualporcentaje)) {
				return false;
			}
		}
		{
			String lhsAcsNocentralGascanalizadoporcentaje;
			lhsAcsNocentralGascanalizadoporcentaje = this.getAcsNocentralGascanalizadoporcentaje();
			String rhsAcsNocentralGascanalizadoporcentaje;
			rhsAcsNocentralGascanalizadoporcentaje = that.getAcsNocentralGascanalizadoporcentaje();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "acsNocentralGascanalizadoporcentaje", lhsAcsNocentralGascanalizadoporcentaje), LocatorUtils.property(thatLocator, "acsNocentralGascanalizadoporcentaje", rhsAcsNocentralGascanalizadoporcentaje), lhsAcsNocentralGascanalizadoporcentaje, rhsAcsNocentralGascanalizadoporcentaje)) {
				return false;
			}
		}
		{
			String lhsAcsNocentralGasembotelladoporcentaje;
			lhsAcsNocentralGasembotelladoporcentaje = this.getAcsNocentralGasembotelladoporcentaje();
			String rhsAcsNocentralGasembotelladoporcentaje;
			rhsAcsNocentralGasembotelladoporcentaje = that.getAcsNocentralGasembotelladoporcentaje();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "acsNocentralGasembotelladoporcentaje", lhsAcsNocentralGasembotelladoporcentaje), LocatorUtils.property(thatLocator, "acsNocentralGasembotelladoporcentaje", rhsAcsNocentralGasembotelladoporcentaje), lhsAcsNocentralGasembotelladoporcentaje, rhsAcsNocentralGasembotelladoporcentaje)) {
				return false;
			}
		}
		{
			String lhsAcsNocentralCalentadoreselectricosporcentaje;
			lhsAcsNocentralCalentadoreselectricosporcentaje = this.getAcsNocentralCalentadoreselectricosporcentaje();
			String rhsAcsNocentralCalentadoreselectricosporcentaje;
			rhsAcsNocentralCalentadoreselectricosporcentaje = that.getAcsNocentralCalentadoreselectricosporcentaje();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "acsNocentralCalentadoreselectricosporcentaje", lhsAcsNocentralCalentadoreselectricosporcentaje), LocatorUtils.property(thatLocator, "acsNocentralCalentadoreselectricosporcentaje", rhsAcsNocentralCalentadoreselectricosporcentaje), lhsAcsNocentralCalentadoreselectricosporcentaje, rhsAcsNocentralCalentadoreselectricosporcentaje)) {
				return false;
			}
		}
		{
			String lhsAcsNocentralOtrosporcentaje;
			lhsAcsNocentralOtrosporcentaje = this.getAcsNocentralOtrosporcentaje();
			String rhsAcsNocentralOtrosporcentaje;
			rhsAcsNocentralOtrosporcentaje = that.getAcsNocentralOtrosporcentaje();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "acsNocentralOtrosporcentaje", lhsAcsNocentralOtrosporcentaje), LocatorUtils.property(thatLocator, "acsNocentralOtrosporcentaje", rhsAcsNocentralOtrosporcentaje), lhsAcsNocentralOtrosporcentaje, rhsAcsNocentralOtrosporcentaje)) {
				return false;
			}
		}
		{
			int lhsAcsCaptadoressolares;
			lhsAcsCaptadoressolares = this.getAcsCaptadoressolares();
			int rhsAcsCaptadoressolares;
			rhsAcsCaptadoressolares = that.getAcsCaptadoressolares();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "acsCaptadoressolares", lhsAcsCaptadoressolares), LocatorUtils.property(thatLocator, "acsCaptadoressolares", rhsAcsCaptadoressolares), lhsAcsCaptadoressolares, rhsAcsCaptadoressolares)) {
				return false;
			}
		}
		{
			int lhsGascanalizadoTiene;
			lhsGascanalizadoTiene = this.getGascanalizadoTiene();
			int rhsGascanalizadoTiene;
			rhsGascanalizadoTiene = that.getGascanalizadoTiene();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "gascanalizadoTiene", lhsGascanalizadoTiene), LocatorUtils.property(thatLocator, "gascanalizadoTiene", rhsGascanalizadoTiene), lhsGascanalizadoTiene, rhsGascanalizadoTiene)) {
				return false;
			}
		}
		{
			String lhsGascanalizadoPorcentaje;
			lhsGascanalizadoPorcentaje = this.getGascanalizadoPorcentaje();
			String rhsGascanalizadoPorcentaje;
			rhsGascanalizadoPorcentaje = that.getGascanalizadoPorcentaje();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "gascanalizadoPorcentaje", lhsGascanalizadoPorcentaje), LocatorUtils.property(thatLocator, "gascanalizadoPorcentaje", rhsGascanalizadoPorcentaje), lhsGascanalizadoPorcentaje, rhsGascanalizadoPorcentaje)) {
				return false;
			}
		}
		{
			int lhsRefrigeracionTiene;
			lhsRefrigeracionTiene = this.getRefrigeracionTiene();
			int rhsRefrigeracionTiene;
			rhsRefrigeracionTiene = that.getRefrigeracionTiene();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "refrigeracionTiene", lhsRefrigeracionTiene), LocatorUtils.property(thatLocator, "refrigeracionTiene", rhsRefrigeracionTiene), lhsRefrigeracionTiene, rhsRefrigeracionTiene)) {
				return false;
			}
		}
		{
			int lhsRefrigeracionColectivoTiene;
			lhsRefrigeracionColectivoTiene = this.getRefrigeracionColectivoTiene();
			int rhsRefrigeracionColectivoTiene;
			rhsRefrigeracionColectivoTiene = that.getRefrigeracionColectivoTiene();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "refrigeracionColectivoTiene", lhsRefrigeracionColectivoTiene), LocatorUtils.property(thatLocator, "refrigeracionColectivoTiene", rhsRefrigeracionColectivoTiene), lhsRefrigeracionColectivoTiene, rhsRefrigeracionColectivoTiene)) {
				return false;
			}
		}
		{
			String lhsRefrigeracionNocolectivoIndividualporcentaje;
			lhsRefrigeracionNocolectivoIndividualporcentaje = this.getRefrigeracionNocolectivoIndividualporcentaje();
			String rhsRefrigeracionNocolectivoIndividualporcentaje;
			rhsRefrigeracionNocolectivoIndividualporcentaje = that.getRefrigeracionNocolectivoIndividualporcentaje();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "refrigeracionNocolectivoIndividualporcentaje", lhsRefrigeracionNocolectivoIndividualporcentaje), LocatorUtils.property(thatLocator, "refrigeracionNocolectivoIndividualporcentaje", rhsRefrigeracionNocolectivoIndividualporcentaje), lhsRefrigeracionNocolectivoIndividualporcentaje, rhsRefrigeracionNocolectivoIndividualporcentaje)) {
				return false;
			}
		}
		{
			String lhsRefrigeracionNocolectivoAparatosenfachadas;
			lhsRefrigeracionNocolectivoAparatosenfachadas = this.getRefrigeracionNocolectivoAparatosenfachadas();
			String rhsRefrigeracionNocolectivoAparatosenfachadas;
			rhsRefrigeracionNocolectivoAparatosenfachadas = that.getRefrigeracionNocolectivoAparatosenfachadas();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "refrigeracionNocolectivoAparatosenfachadas", lhsRefrigeracionNocolectivoAparatosenfachadas), LocatorUtils.property(thatLocator, "refrigeracionNocolectivoAparatosenfachadas", rhsRefrigeracionNocolectivoAparatosenfachadas), lhsRefrigeracionNocolectivoAparatosenfachadas, rhsRefrigeracionNocolectivoAparatosenfachadas)) {
				return false;
			}
		}
		{
			int lhsVentilacionTiene;
			lhsVentilacionTiene = this.getVentilacionTiene();
			int rhsVentilacionTiene;
			rhsVentilacionTiene = that.getVentilacionTiene();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "ventilacionTiene", lhsVentilacionTiene), LocatorUtils.property(thatLocator, "ventilacionTiene", rhsVentilacionTiene), lhsVentilacionTiene, rhsVentilacionTiene)) {
				return false;
			}
		}
		{
			String lhsVentilacionCuartoshumedosTexto;
			lhsVentilacionCuartoshumedosTexto = this.getVentilacionCuartoshumedosTexto();
			String rhsVentilacionCuartoshumedosTexto;
			rhsVentilacionCuartoshumedosTexto = that.getVentilacionCuartoshumedosTexto();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "ventilacionCuartoshumedosTexto", lhsVentilacionCuartoshumedosTexto), LocatorUtils.property(thatLocator, "ventilacionCuartoshumedosTexto", rhsVentilacionCuartoshumedosTexto), lhsVentilacionCuartoshumedosTexto, rhsVentilacionCuartoshumedosTexto)) {
				return false;
			}
		}
		{
			int lhsVentilacionCuartoshumedosSinventilacion;
			lhsVentilacionCuartoshumedosSinventilacion = this.getVentilacionCuartoshumedosSinventilacion();
			int rhsVentilacionCuartoshumedosSinventilacion;
			rhsVentilacionCuartoshumedosSinventilacion = that.getVentilacionCuartoshumedosSinventilacion();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "ventilacionCuartoshumedosSinventilacion", lhsVentilacionCuartoshumedosSinventilacion), LocatorUtils.property(thatLocator, "ventilacionCuartoshumedosSinventilacion", rhsVentilacionCuartoshumedosSinventilacion), lhsVentilacionCuartoshumedosSinventilacion, rhsVentilacionCuartoshumedosSinventilacion)) {
				return false;
			}
		}
		{
			int lhsContraincendiosTiene;
			lhsContraincendiosTiene = this.getContraincendiosTiene();
			int rhsContraincendiosTiene;
			rhsContraincendiosTiene = that.getContraincendiosTiene();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "contraincendiosTiene", lhsContraincendiosTiene), LocatorUtils.property(thatLocator, "contraincendiosTiene", rhsContraincendiosTiene), lhsContraincendiosTiene, rhsContraincendiosTiene)) {
				return false;
			}
		}
		{
			int lhsContrarayoTiene;
			lhsContrarayoTiene = this.getContrarayoTiene();
			int rhsContrarayoTiene;
			rhsContrarayoTiene = that.getContrarayoTiene();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "contrarayoTiene", lhsContrarayoTiene), LocatorUtils.property(thatLocator, "contrarayoTiene", rhsContrarayoTiene), lhsContrarayoTiene, rhsContrarayoTiene)) {
				return false;
			}
		}
		{
			String lhsContrarayoTexto;
			lhsContrarayoTexto = this.getContrarayoTexto();
			String rhsContrarayoTexto;
			rhsContrarayoTexto = that.getContrarayoTexto();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "contrarayoTexto", lhsContrarayoTexto), LocatorUtils.property(thatLocator, "contrarayoTexto", rhsContrarayoTexto), lhsContrarayoTexto, rhsContrarayoTexto)) {
				return false;
			}
		}
		{
			int lhsComunicacionesictTiene;
			lhsComunicacionesictTiene = this.getComunicacionesictTiene();
			int rhsComunicacionesictTiene;
			rhsComunicacionesictTiene = that.getComunicacionesictTiene();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "comunicacionesictTiene", lhsComunicacionesictTiene), LocatorUtils.property(thatLocator, "comunicacionesictTiene", rhsComunicacionesictTiene), lhsComunicacionesictTiene, rhsComunicacionesictTiene)) {
				return false;
			}
		}
		{
			String lhsComunicacionesictTexto;
			lhsComunicacionesictTexto = this.getComunicacionesictTexto();
			String rhsComunicacionesictTexto;
			rhsComunicacionesictTexto = that.getComunicacionesictTexto();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "comunicacionesictTexto", lhsComunicacionesictTexto), LocatorUtils.property(thatLocator, "comunicacionesictTexto", rhsComunicacionesictTexto), lhsComunicacionesictTexto, rhsComunicacionesictTexto)) {
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
			InstalacionesSaneamientosType lhsInstalacionesSaneamientos;
			lhsInstalacionesSaneamientos = this.getInstalacionesSaneamientos();
			InstalacionesSaneamientosType rhsInstalacionesSaneamientos;
			rhsInstalacionesSaneamientos = that.getInstalacionesSaneamientos();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "instalacionesSaneamientos", lhsInstalacionesSaneamientos), LocatorUtils.property(thatLocator, "instalacionesSaneamientos", rhsInstalacionesSaneamientos), lhsInstalacionesSaneamientos, rhsInstalacionesSaneamientos)) {
				return false;
			}
		}
		{
			InstalacionesSaneamientobajantesType lhsInstalacionesSaneamientobajantes;
			lhsInstalacionesSaneamientobajantes = this.getInstalacionesSaneamientobajantes();
			InstalacionesSaneamientobajantesType rhsInstalacionesSaneamientobajantes;
			rhsInstalacionesSaneamientobajantes = that.getInstalacionesSaneamientobajantes();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "instalacionesSaneamientobajantes", lhsInstalacionesSaneamientobajantes), LocatorUtils.property(thatLocator, "instalacionesSaneamientobajantes", rhsInstalacionesSaneamientobajantes), lhsInstalacionesSaneamientobajantes, rhsInstalacionesSaneamientobajantes)) {
				return false;
			}
		}
		{
			InstalacionesSaneamientocolectoresType lhsInstalacionesSaneamientocolectores;
			lhsInstalacionesSaneamientocolectores = this.getInstalacionesSaneamientocolectores();
			InstalacionesSaneamientocolectoresType rhsInstalacionesSaneamientocolectores;
			rhsInstalacionesSaneamientocolectores = that.getInstalacionesSaneamientocolectores();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "instalacionesSaneamientocolectores", lhsInstalacionesSaneamientocolectores), LocatorUtils.property(thatLocator, "instalacionesSaneamientocolectores", rhsInstalacionesSaneamientocolectores), lhsInstalacionesSaneamientocolectores, rhsInstalacionesSaneamientocolectores)) {
				return false;
			}
		}
		{
			InstalacionesAbastecimientosType lhsInstalacionesAbastecimientos;
			lhsInstalacionesAbastecimientos = this.getInstalacionesAbastecimientos();
			InstalacionesAbastecimientosType rhsInstalacionesAbastecimientos;
			rhsInstalacionesAbastecimientos = that.getInstalacionesAbastecimientos();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "instalacionesAbastecimientos", lhsInstalacionesAbastecimientos), LocatorUtils.property(thatLocator, "instalacionesAbastecimientos", rhsInstalacionesAbastecimientos), lhsInstalacionesAbastecimientos, rhsInstalacionesAbastecimientos)) {
				return false;
			}
		}
		{
			InstalacionesAbastecimientocontadoresType lhsInstalacionesAbastecimientocontadores;
			lhsInstalacionesAbastecimientocontadores = this.getInstalacionesAbastecimientocontadores();
			InstalacionesAbastecimientocontadoresType rhsInstalacionesAbastecimientocontadores;
			rhsInstalacionesAbastecimientocontadores = that.getInstalacionesAbastecimientocontadores();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "instalacionesAbastecimientocontadores", lhsInstalacionesAbastecimientocontadores), LocatorUtils.property(thatLocator, "instalacionesAbastecimientocontadores", rhsInstalacionesAbastecimientocontadores), lhsInstalacionesAbastecimientocontadores, rhsInstalacionesAbastecimientocontadores)) {
				return false;
			}
		}
		{
			InstalacionesElectricasType lhsInstalacionesElectricas;
			lhsInstalacionesElectricas = this.getInstalacionesElectricas();
			InstalacionesElectricasType rhsInstalacionesElectricas;
			rhsInstalacionesElectricas = that.getInstalacionesElectricas();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "instalacionesElectricas", lhsInstalacionesElectricas), LocatorUtils.property(thatLocator, "instalacionesElectricas", rhsInstalacionesElectricas), lhsInstalacionesElectricas, rhsInstalacionesElectricas)) {
				return false;
			}
		}
		{
			InstalacionesElectricacontadoresType lhsInstalacionesElectricacontadores;
			lhsInstalacionesElectricacontadores = this.getInstalacionesElectricacontadores();
			InstalacionesElectricacontadoresType rhsInstalacionesElectricacontadores;
			rhsInstalacionesElectricacontadores = that.getInstalacionesElectricacontadores();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "instalacionesElectricacontadores", lhsInstalacionesElectricacontadores), LocatorUtils.property(thatLocator, "instalacionesElectricacontadores", rhsInstalacionesElectricacontadores), lhsInstalacionesElectricacontadores, rhsInstalacionesElectricacontadores)) {
				return false;
			}
		}
		{
			InstalacionesCalefaccioncentralesType lhsInstalacionesCalefaccioncentrales;
			lhsInstalacionesCalefaccioncentrales = this.getInstalacionesCalefaccioncentrales();
			InstalacionesCalefaccioncentralesType rhsInstalacionesCalefaccioncentrales;
			rhsInstalacionesCalefaccioncentrales = that.getInstalacionesCalefaccioncentrales();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "instalacionesCalefaccioncentrales", lhsInstalacionesCalefaccioncentrales), LocatorUtils.property(thatLocator, "instalacionesCalefaccioncentrales", rhsInstalacionesCalefaccioncentrales), lhsInstalacionesCalefaccioncentrales, rhsInstalacionesCalefaccioncentrales)) {
				return false;
			}
		}
		{
			InstalacionesCalefaccioncentralcombustiblesType lhsInstalacionesCalefaccioncentralcombustibles;
			lhsInstalacionesCalefaccioncentralcombustibles = this.getInstalacionesCalefaccioncentralcombustibles();
			InstalacionesCalefaccioncentralcombustiblesType rhsInstalacionesCalefaccioncentralcombustibles;
			rhsInstalacionesCalefaccioncentralcombustibles = that.getInstalacionesCalefaccioncentralcombustibles();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "instalacionesCalefaccioncentralcombustibles", lhsInstalacionesCalefaccioncentralcombustibles), LocatorUtils.property(thatLocator, "instalacionesCalefaccioncentralcombustibles", rhsInstalacionesCalefaccioncentralcombustibles), lhsInstalacionesCalefaccioncentralcombustibles, rhsInstalacionesCalefaccioncentralcombustibles)) {
				return false;
			}
		}
		{
			String lhsInstalacionesCalefaccionnocentralgascanalizados;
			lhsInstalacionesCalefaccionnocentralgascanalizados = this.getInstalacionesCalefaccionnocentralgascanalizados();
			String rhsInstalacionesCalefaccionnocentralgascanalizados;
			rhsInstalacionesCalefaccionnocentralgascanalizados = that.getInstalacionesCalefaccionnocentralgascanalizados();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "instalacionesCalefaccionnocentralgascanalizados", lhsInstalacionesCalefaccionnocentralgascanalizados), LocatorUtils.property(thatLocator, "instalacionesCalefaccionnocentralgascanalizados", rhsInstalacionesCalefaccionnocentralgascanalizados), lhsInstalacionesCalefaccionnocentralgascanalizados, rhsInstalacionesCalefaccionnocentralgascanalizados)) {
				return false;
			}
		}
		{
			String lhsInstalacionesCalefaccionnocentralcalefaccionelectricas;
			lhsInstalacionesCalefaccionnocentralcalefaccionelectricas = this.getInstalacionesCalefaccionnocentralcalefaccionelectricas();
			String rhsInstalacionesCalefaccionnocentralcalefaccionelectricas;
			rhsInstalacionesCalefaccionnocentralcalefaccionelectricas = that.getInstalacionesCalefaccionnocentralcalefaccionelectricas();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "instalacionesCalefaccionnocentralcalefaccionelectricas", lhsInstalacionesCalefaccionnocentralcalefaccionelectricas), LocatorUtils.property(thatLocator, "instalacionesCalefaccionnocentralcalefaccionelectricas", rhsInstalacionesCalefaccionnocentralcalefaccionelectricas), lhsInstalacionesCalefaccionnocentralcalefaccionelectricas, rhsInstalacionesCalefaccionnocentralcalefaccionelectricas)) {
				return false;
			}
		}
		{
			InstalacionesAcscentralcombustiblesType lhsInstalacionesAcscentralcombustibles;
			lhsInstalacionesAcscentralcombustibles = this.getInstalacionesAcscentralcombustibles();
			InstalacionesAcscentralcombustiblesType rhsInstalacionesAcscentralcombustibles;
			rhsInstalacionesAcscentralcombustibles = that.getInstalacionesAcscentralcombustibles();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "instalacionesAcscentralcombustibles", lhsInstalacionesAcscentralcombustibles), LocatorUtils.property(thatLocator, "instalacionesAcscentralcombustibles", rhsInstalacionesAcscentralcombustibles), lhsInstalacionesAcscentralcombustibles, rhsInstalacionesAcscentralcombustibles)) {
				return false;
			}
		}
		{
			String lhsInstalacionesAcsnocentralgascanalizados;
			lhsInstalacionesAcsnocentralgascanalizados = this.getInstalacionesAcsnocentralgascanalizados();
			String rhsInstalacionesAcsnocentralgascanalizados;
			rhsInstalacionesAcsnocentralgascanalizados = that.getInstalacionesAcsnocentralgascanalizados();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "instalacionesAcsnocentralgascanalizados", lhsInstalacionesAcsnocentralgascanalizados), LocatorUtils.property(thatLocator, "instalacionesAcsnocentralgascanalizados", rhsInstalacionesAcsnocentralgascanalizados), lhsInstalacionesAcsnocentralgascanalizados, rhsInstalacionesAcsnocentralgascanalizados)) {
				return false;
			}
		}
		{
			String lhsInstalacionesAcsnocentralgasembotellados;
			lhsInstalacionesAcsnocentralgasembotellados = this.getInstalacionesAcsnocentralgasembotellados();
			String rhsInstalacionesAcsnocentralgasembotellados;
			rhsInstalacionesAcsnocentralgasembotellados = that.getInstalacionesAcsnocentralgasembotellados();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "instalacionesAcsnocentralgasembotellados", lhsInstalacionesAcsnocentralgasembotellados), LocatorUtils.property(thatLocator, "instalacionesAcsnocentralgasembotellados", rhsInstalacionesAcsnocentralgasembotellados), lhsInstalacionesAcsnocentralgasembotellados, rhsInstalacionesAcsnocentralgasembotellados)) {
				return false;
			}
		}
		{
			InstalacionesGascanalizadocombustiblesType lhsInstalacionesGascanalizadocombustibles;
			lhsInstalacionesGascanalizadocombustibles = this.getInstalacionesGascanalizadocombustibles();
			InstalacionesGascanalizadocombustiblesType rhsInstalacionesGascanalizadocombustibles;
			rhsInstalacionesGascanalizadocombustibles = that.getInstalacionesGascanalizadocombustibles();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "instalacionesGascanalizadocombustibles", lhsInstalacionesGascanalizadocombustibles), LocatorUtils.property(thatLocator, "instalacionesGascanalizadocombustibles", rhsInstalacionesGascanalizadocombustibles), lhsInstalacionesGascanalizadocombustibles, rhsInstalacionesGascanalizadocombustibles)) {
				return false;
			}
		}
		{
			InstalacionesGascanalizadocontadoresType lhsInstalacionesGascanalizadocontadores;
			lhsInstalacionesGascanalizadocontadores = this.getInstalacionesGascanalizadocontadores();
			InstalacionesGascanalizadocontadoresType rhsInstalacionesGascanalizadocontadores;
			rhsInstalacionesGascanalizadocontadores = that.getInstalacionesGascanalizadocontadores();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "instalacionesGascanalizadocontadores", lhsInstalacionesGascanalizadocontadores), LocatorUtils.property(thatLocator, "instalacionesGascanalizadocontadores", rhsInstalacionesGascanalizadocontadores), lhsInstalacionesGascanalizadocontadores, rhsInstalacionesGascanalizadocontadores)) {
				return false;
			}
		}
		{
			InstalacionesRefrigeracioncolectivotorresType lhsInstalacionesRefrigeracioncolectivotorres;
			lhsInstalacionesRefrigeracioncolectivotorres = this.getInstalacionesRefrigeracioncolectivotorres();
			InstalacionesRefrigeracioncolectivotorresType rhsInstalacionesRefrigeracioncolectivotorres;
			rhsInstalacionesRefrigeracioncolectivotorres = that.getInstalacionesRefrigeracioncolectivotorres();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "instalacionesRefrigeracioncolectivotorres", lhsInstalacionesRefrigeracioncolectivotorres), LocatorUtils.property(thatLocator, "instalacionesRefrigeracioncolectivotorres", rhsInstalacionesRefrigeracioncolectivotorres), lhsInstalacionesRefrigeracioncolectivotorres, rhsInstalacionesRefrigeracioncolectivotorres)) {
				return false;
			}
		}
		{
			InstalacionesVentilacioncuartoshumedosType lhsInstalacionesVentilacioncuartoshumedos;
			lhsInstalacionesVentilacioncuartoshumedos = this.getInstalacionesVentilacioncuartoshumedos();
			InstalacionesVentilacioncuartoshumedosType rhsInstalacionesVentilacioncuartoshumedos;
			rhsInstalacionesVentilacioncuartoshumedos = that.getInstalacionesVentilacioncuartoshumedos();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "instalacionesVentilacioncuartoshumedos", lhsInstalacionesVentilacioncuartoshumedos), LocatorUtils.property(thatLocator, "instalacionesVentilacioncuartoshumedos", rhsInstalacionesVentilacioncuartoshumedos), lhsInstalacionesVentilacioncuartoshumedos, rhsInstalacionesVentilacioncuartoshumedos)) {
				return false;
			}
		}
		{
			InstalacionesVentilacionaparcamientosType lhsInstalacionesVentilacionaparcamientos;
			lhsInstalacionesVentilacionaparcamientos = this.getInstalacionesVentilacionaparcamientos();
			InstalacionesVentilacionaparcamientosType rhsInstalacionesVentilacionaparcamientos;
			rhsInstalacionesVentilacionaparcamientos = that.getInstalacionesVentilacionaparcamientos();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "instalacionesVentilacionaparcamientos", lhsInstalacionesVentilacionaparcamientos), LocatorUtils.property(thatLocator, "instalacionesVentilacionaparcamientos", rhsInstalacionesVentilacionaparcamientos), lhsInstalacionesVentilacionaparcamientos, rhsInstalacionesVentilacionaparcamientos)) {
				return false;
			}
		}
		{
			InstalacionesContraincendiosType lhsInstalacionesContraincendios;
			lhsInstalacionesContraincendios = this.getInstalacionesContraincendios();
			InstalacionesContraincendiosType rhsInstalacionesContraincendios;
			rhsInstalacionesContraincendios = that.getInstalacionesContraincendios();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "instalacionesContraincendios", lhsInstalacionesContraincendios), LocatorUtils.property(thatLocator, "instalacionesContraincendios", rhsInstalacionesContraincendios), lhsInstalacionesContraincendios, rhsInstalacionesContraincendios)) {
				return false;
			}
		}
		{
			InstalacionesContrarayosType lhsInstalacionesContrarayos;
			lhsInstalacionesContrarayos = this.getInstalacionesContrarayos();
			InstalacionesContrarayosType rhsInstalacionesContrarayos;
			rhsInstalacionesContrarayos = that.getInstalacionesContrarayos();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "instalacionesContrarayos", lhsInstalacionesContrarayos), LocatorUtils.property(thatLocator, "instalacionesContrarayos", rhsInstalacionesContrarayos), lhsInstalacionesContrarayos, rhsInstalacionesContrarayos)) {
				return false;
			}
		}
		{
			InstalacionesComunicacionesictsType lhsInstalacionesComunicacionesicts;
			lhsInstalacionesComunicacionesicts = this.getInstalacionesComunicacionesicts();
			InstalacionesComunicacionesictsType rhsInstalacionesComunicacionesicts;
			rhsInstalacionesComunicacionesicts = that.getInstalacionesComunicacionesicts();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "instalacionesComunicacionesicts", lhsInstalacionesComunicacionesicts), LocatorUtils.property(thatLocator, "instalacionesComunicacionesicts", rhsInstalacionesComunicacionesicts), lhsInstalacionesComunicacionesicts, rhsInstalacionesComunicacionesicts)) {
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
			String theSaneamientoBajantesTexto;
			theSaneamientoBajantesTexto = this.getSaneamientoBajantesTexto();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "saneamientoBajantesTexto", theSaneamientoBajantesTexto), currentHashCode, theSaneamientoBajantesTexto);
		}
		{
			String theSaneamientoColectoresTexto;
			theSaneamientoColectoresTexto = this.getSaneamientoColectoresTexto();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "saneamientoColectoresTexto", theSaneamientoColectoresTexto), currentHashCode, theSaneamientoColectoresTexto);
		}
		{
			String theElectricaTexto;
			theElectricaTexto = this.getElectricaTexto();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "electricaTexto", theElectricaTexto), currentHashCode, theElectricaTexto);
		}
		{
			int theCalefaccionTiene;
			theCalefaccionTiene = this.getCalefaccionTiene();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "calefaccionTiene", theCalefaccionTiene), currentHashCode, theCalefaccionTiene);
		}
		{
			int theCalefaccionCentralTiene;
			theCalefaccionCentralTiene = this.getCalefaccionCentralTiene();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "calefaccionCentralTiene", theCalefaccionCentralTiene), currentHashCode, theCalefaccionCentralTiene);
		}
		{
			String theCalefaccionCentralTexto;
			theCalefaccionCentralTexto = this.getCalefaccionCentralTexto();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "calefaccionCentralTexto", theCalefaccionCentralTexto), currentHashCode, theCalefaccionCentralTexto);
		}
		{
			String theCalefaccionCentralCombustibleTexto;
			theCalefaccionCentralCombustibleTexto = this.getCalefaccionCentralCombustibleTexto();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "calefaccionCentralCombustibleTexto", theCalefaccionCentralCombustibleTexto), currentHashCode, theCalefaccionCentralCombustibleTexto);
		}
		{
			String theCalefaccionNocentralIndividualporcentaje;
			theCalefaccionNocentralIndividualporcentaje = this.getCalefaccionNocentralIndividualporcentaje();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "calefaccionNocentralIndividualporcentaje", theCalefaccionNocentralIndividualporcentaje), currentHashCode, theCalefaccionNocentralIndividualporcentaje);
		}
		{
			String theCalefaccionNocentralGascanalizadoporcentaje;
			theCalefaccionNocentralGascanalizadoporcentaje = this.getCalefaccionNocentralGascanalizadoporcentaje();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "calefaccionNocentralGascanalizadoporcentaje", theCalefaccionNocentralGascanalizadoporcentaje), currentHashCode, theCalefaccionNocentralGascanalizadoporcentaje);
		}
		{
			String theCalefaccionNocentralCalderagasoleoporcentaje;
			theCalefaccionNocentralCalderagasoleoporcentaje = this.getCalefaccionNocentralCalderagasoleoporcentaje();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "calefaccionNocentralCalderagasoleoporcentaje", theCalefaccionNocentralCalderagasoleoporcentaje), currentHashCode, theCalefaccionNocentralCalderagasoleoporcentaje);
		}
		{
			String theCalefaccionNocentralCalefaccionelectricaporcentaje;
			theCalefaccionNocentralCalefaccionelectricaporcentaje = this.getCalefaccionNocentralCalefaccionelectricaporcentaje();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "calefaccionNocentralCalefaccionelectricaporcentaje", theCalefaccionNocentralCalefaccionelectricaporcentaje), currentHashCode, theCalefaccionNocentralCalefaccionelectricaporcentaje);
		}
		{
			String theCalefaccionNocentralOtrosporcentaje;
			theCalefaccionNocentralOtrosporcentaje = this.getCalefaccionNocentralOtrosporcentaje();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "calefaccionNocentralOtrosporcentaje", theCalefaccionNocentralOtrosporcentaje), currentHashCode, theCalefaccionNocentralOtrosporcentaje);
		}
		{
			int theAcsTiene;
			theAcsTiene = this.getAcsTiene();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "acsTiene", theAcsTiene), currentHashCode, theAcsTiene);
		}
		{
			int theAcsCentralTiene;
			theAcsCentralTiene = this.getAcsCentralTiene();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "acsCentralTiene", theAcsCentralTiene), currentHashCode, theAcsCentralTiene);
		}
		{
			String theAcsCentralCombustibleTexto;
			theAcsCentralCombustibleTexto = this.getAcsCentralCombustibleTexto();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "acsCentralCombustibleTexto", theAcsCentralCombustibleTexto), currentHashCode, theAcsCentralCombustibleTexto);
		}
		{
			String theAcsNocentralIndividualporcentaje;
			theAcsNocentralIndividualporcentaje = this.getAcsNocentralIndividualporcentaje();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "acsNocentralIndividualporcentaje", theAcsNocentralIndividualporcentaje), currentHashCode, theAcsNocentralIndividualporcentaje);
		}
		{
			String theAcsNocentralGascanalizadoporcentaje;
			theAcsNocentralGascanalizadoporcentaje = this.getAcsNocentralGascanalizadoporcentaje();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "acsNocentralGascanalizadoporcentaje", theAcsNocentralGascanalizadoporcentaje), currentHashCode, theAcsNocentralGascanalizadoporcentaje);
		}
		{
			String theAcsNocentralGasembotelladoporcentaje;
			theAcsNocentralGasembotelladoporcentaje = this.getAcsNocentralGasembotelladoporcentaje();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "acsNocentralGasembotelladoporcentaje", theAcsNocentralGasembotelladoporcentaje), currentHashCode, theAcsNocentralGasembotelladoporcentaje);
		}
		{
			String theAcsNocentralCalentadoreselectricosporcentaje;
			theAcsNocentralCalentadoreselectricosporcentaje = this.getAcsNocentralCalentadoreselectricosporcentaje();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "acsNocentralCalentadoreselectricosporcentaje", theAcsNocentralCalentadoreselectricosporcentaje), currentHashCode, theAcsNocentralCalentadoreselectricosporcentaje);
		}
		{
			String theAcsNocentralOtrosporcentaje;
			theAcsNocentralOtrosporcentaje = this.getAcsNocentralOtrosporcentaje();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "acsNocentralOtrosporcentaje", theAcsNocentralOtrosporcentaje), currentHashCode, theAcsNocentralOtrosporcentaje);
		}
		{
			int theAcsCaptadoressolares;
			theAcsCaptadoressolares = this.getAcsCaptadoressolares();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "acsCaptadoressolares", theAcsCaptadoressolares), currentHashCode, theAcsCaptadoressolares);
		}
		{
			int theGascanalizadoTiene;
			theGascanalizadoTiene = this.getGascanalizadoTiene();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "gascanalizadoTiene", theGascanalizadoTiene), currentHashCode, theGascanalizadoTiene);
		}
		{
			String theGascanalizadoPorcentaje;
			theGascanalizadoPorcentaje = this.getGascanalizadoPorcentaje();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "gascanalizadoPorcentaje", theGascanalizadoPorcentaje), currentHashCode, theGascanalizadoPorcentaje);
		}
		{
			int theRefrigeracionTiene;
			theRefrigeracionTiene = this.getRefrigeracionTiene();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "refrigeracionTiene", theRefrigeracionTiene), currentHashCode, theRefrigeracionTiene);
		}
		{
			int theRefrigeracionColectivoTiene;
			theRefrigeracionColectivoTiene = this.getRefrigeracionColectivoTiene();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "refrigeracionColectivoTiene", theRefrigeracionColectivoTiene), currentHashCode, theRefrigeracionColectivoTiene);
		}
		{
			String theRefrigeracionNocolectivoIndividualporcentaje;
			theRefrigeracionNocolectivoIndividualporcentaje = this.getRefrigeracionNocolectivoIndividualporcentaje();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "refrigeracionNocolectivoIndividualporcentaje", theRefrigeracionNocolectivoIndividualporcentaje), currentHashCode, theRefrigeracionNocolectivoIndividualporcentaje);
		}
		{
			String theRefrigeracionNocolectivoAparatosenfachadas;
			theRefrigeracionNocolectivoAparatosenfachadas = this.getRefrigeracionNocolectivoAparatosenfachadas();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "refrigeracionNocolectivoAparatosenfachadas", theRefrigeracionNocolectivoAparatosenfachadas), currentHashCode, theRefrigeracionNocolectivoAparatosenfachadas);
		}
		{
			int theVentilacionTiene;
			theVentilacionTiene = this.getVentilacionTiene();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "ventilacionTiene", theVentilacionTiene), currentHashCode, theVentilacionTiene);
		}
		{
			String theVentilacionCuartoshumedosTexto;
			theVentilacionCuartoshumedosTexto = this.getVentilacionCuartoshumedosTexto();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "ventilacionCuartoshumedosTexto", theVentilacionCuartoshumedosTexto), currentHashCode, theVentilacionCuartoshumedosTexto);
		}
		{
			int theVentilacionCuartoshumedosSinventilacion;
			theVentilacionCuartoshumedosSinventilacion = this.getVentilacionCuartoshumedosSinventilacion();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "ventilacionCuartoshumedosSinventilacion", theVentilacionCuartoshumedosSinventilacion), currentHashCode, theVentilacionCuartoshumedosSinventilacion);
		}
		{
			int theContraincendiosTiene;
			theContraincendiosTiene = this.getContraincendiosTiene();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "contraincendiosTiene", theContraincendiosTiene), currentHashCode, theContraincendiosTiene);
		}
		{
			int theContrarayoTiene;
			theContrarayoTiene = this.getContrarayoTiene();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "contrarayoTiene", theContrarayoTiene), currentHashCode, theContrarayoTiene);
		}
		{
			String theContrarayoTexto;
			theContrarayoTexto = this.getContrarayoTexto();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "contrarayoTexto", theContrarayoTexto), currentHashCode, theContrarayoTexto);
		}
		{
			int theComunicacionesictTiene;
			theComunicacionesictTiene = this.getComunicacionesictTiene();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "comunicacionesictTiene", theComunicacionesictTiene), currentHashCode, theComunicacionesictTiene);
		}
		{
			String theComunicacionesictTexto;
			theComunicacionesictTexto = this.getComunicacionesictTexto();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "comunicacionesictTexto", theComunicacionesictTexto), currentHashCode, theComunicacionesictTexto);
		}
		{
			String theObservaciones;
			theObservaciones = this.getObservaciones();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "observaciones", theObservaciones), currentHashCode, theObservaciones);
		}
		{
			InstalacionesSaneamientosType theInstalacionesSaneamientos;
			theInstalacionesSaneamientos = this.getInstalacionesSaneamientos();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "instalacionesSaneamientos", theInstalacionesSaneamientos), currentHashCode, theInstalacionesSaneamientos);
		}
		{
			InstalacionesSaneamientobajantesType theInstalacionesSaneamientobajantes;
			theInstalacionesSaneamientobajantes = this.getInstalacionesSaneamientobajantes();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "instalacionesSaneamientobajantes", theInstalacionesSaneamientobajantes), currentHashCode, theInstalacionesSaneamientobajantes);
		}
		{
			InstalacionesSaneamientocolectoresType theInstalacionesSaneamientocolectores;
			theInstalacionesSaneamientocolectores = this.getInstalacionesSaneamientocolectores();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "instalacionesSaneamientocolectores", theInstalacionesSaneamientocolectores), currentHashCode, theInstalacionesSaneamientocolectores);
		}
		{
			InstalacionesAbastecimientosType theInstalacionesAbastecimientos;
			theInstalacionesAbastecimientos = this.getInstalacionesAbastecimientos();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "instalacionesAbastecimientos", theInstalacionesAbastecimientos), currentHashCode, theInstalacionesAbastecimientos);
		}
		{
			InstalacionesAbastecimientocontadoresType theInstalacionesAbastecimientocontadores;
			theInstalacionesAbastecimientocontadores = this.getInstalacionesAbastecimientocontadores();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "instalacionesAbastecimientocontadores", theInstalacionesAbastecimientocontadores), currentHashCode, theInstalacionesAbastecimientocontadores);
		}
		{
			InstalacionesElectricasType theInstalacionesElectricas;
			theInstalacionesElectricas = this.getInstalacionesElectricas();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "instalacionesElectricas", theInstalacionesElectricas), currentHashCode, theInstalacionesElectricas);
		}
		{
			InstalacionesElectricacontadoresType theInstalacionesElectricacontadores;
			theInstalacionesElectricacontadores = this.getInstalacionesElectricacontadores();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "instalacionesElectricacontadores", theInstalacionesElectricacontadores), currentHashCode, theInstalacionesElectricacontadores);
		}
		{
			InstalacionesCalefaccioncentralesType theInstalacionesCalefaccioncentrales;
			theInstalacionesCalefaccioncentrales = this.getInstalacionesCalefaccioncentrales();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "instalacionesCalefaccioncentrales", theInstalacionesCalefaccioncentrales), currentHashCode, theInstalacionesCalefaccioncentrales);
		}
		{
			InstalacionesCalefaccioncentralcombustiblesType theInstalacionesCalefaccioncentralcombustibles;
			theInstalacionesCalefaccioncentralcombustibles = this.getInstalacionesCalefaccioncentralcombustibles();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "instalacionesCalefaccioncentralcombustibles", theInstalacionesCalefaccioncentralcombustibles), currentHashCode, theInstalacionesCalefaccioncentralcombustibles);
		}
		{
			String theInstalacionesCalefaccionnocentralgascanalizados;
			theInstalacionesCalefaccionnocentralgascanalizados = this.getInstalacionesCalefaccionnocentralgascanalizados();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "instalacionesCalefaccionnocentralgascanalizados", theInstalacionesCalefaccionnocentralgascanalizados), currentHashCode, theInstalacionesCalefaccionnocentralgascanalizados);
		}
		{
			String theInstalacionesCalefaccionnocentralcalefaccionelectricas;
			theInstalacionesCalefaccionnocentralcalefaccionelectricas = this.getInstalacionesCalefaccionnocentralcalefaccionelectricas();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "instalacionesCalefaccionnocentralcalefaccionelectricas", theInstalacionesCalefaccionnocentralcalefaccionelectricas), currentHashCode, theInstalacionesCalefaccionnocentralcalefaccionelectricas);
		}
		{
			InstalacionesAcscentralcombustiblesType theInstalacionesAcscentralcombustibles;
			theInstalacionesAcscentralcombustibles = this.getInstalacionesAcscentralcombustibles();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "instalacionesAcscentralcombustibles", theInstalacionesAcscentralcombustibles), currentHashCode, theInstalacionesAcscentralcombustibles);
		}
		{
			String theInstalacionesAcsnocentralgascanalizados;
			theInstalacionesAcsnocentralgascanalizados = this.getInstalacionesAcsnocentralgascanalizados();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "instalacionesAcsnocentralgascanalizados", theInstalacionesAcsnocentralgascanalizados), currentHashCode, theInstalacionesAcsnocentralgascanalizados);
		}
		{
			String theInstalacionesAcsnocentralgasembotellados;
			theInstalacionesAcsnocentralgasembotellados = this.getInstalacionesAcsnocentralgasembotellados();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "instalacionesAcsnocentralgasembotellados", theInstalacionesAcsnocentralgasembotellados), currentHashCode, theInstalacionesAcsnocentralgasembotellados);
		}
		{
			InstalacionesGascanalizadocombustiblesType theInstalacionesGascanalizadocombustibles;
			theInstalacionesGascanalizadocombustibles = this.getInstalacionesGascanalizadocombustibles();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "instalacionesGascanalizadocombustibles", theInstalacionesGascanalizadocombustibles), currentHashCode, theInstalacionesGascanalizadocombustibles);
		}
		{
			InstalacionesGascanalizadocontadoresType theInstalacionesGascanalizadocontadores;
			theInstalacionesGascanalizadocontadores = this.getInstalacionesGascanalizadocontadores();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "instalacionesGascanalizadocontadores", theInstalacionesGascanalizadocontadores), currentHashCode, theInstalacionesGascanalizadocontadores);
		}
		{
			InstalacionesRefrigeracioncolectivotorresType theInstalacionesRefrigeracioncolectivotorres;
			theInstalacionesRefrigeracioncolectivotorres = this.getInstalacionesRefrigeracioncolectivotorres();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "instalacionesRefrigeracioncolectivotorres", theInstalacionesRefrigeracioncolectivotorres), currentHashCode, theInstalacionesRefrigeracioncolectivotorres);
		}
		{
			InstalacionesVentilacioncuartoshumedosType theInstalacionesVentilacioncuartoshumedos;
			theInstalacionesVentilacioncuartoshumedos = this.getInstalacionesVentilacioncuartoshumedos();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "instalacionesVentilacioncuartoshumedos", theInstalacionesVentilacioncuartoshumedos), currentHashCode, theInstalacionesVentilacioncuartoshumedos);
		}
		{
			InstalacionesVentilacionaparcamientosType theInstalacionesVentilacionaparcamientos;
			theInstalacionesVentilacionaparcamientos = this.getInstalacionesVentilacionaparcamientos();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "instalacionesVentilacionaparcamientos", theInstalacionesVentilacionaparcamientos), currentHashCode, theInstalacionesVentilacionaparcamientos);
		}
		{
			InstalacionesContraincendiosType theInstalacionesContraincendios;
			theInstalacionesContraincendios = this.getInstalacionesContraincendios();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "instalacionesContraincendios", theInstalacionesContraincendios), currentHashCode, theInstalacionesContraincendios);
		}
		{
			InstalacionesContrarayosType theInstalacionesContrarayos;
			theInstalacionesContrarayos = this.getInstalacionesContrarayos();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "instalacionesContrarayos", theInstalacionesContrarayos), currentHashCode, theInstalacionesContrarayos);
		}
		{
			InstalacionesComunicacionesictsType theInstalacionesComunicacionesicts;
			theInstalacionesComunicacionesicts = this.getInstalacionesComunicacionesicts();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "instalacionesComunicacionesicts", theInstalacionesComunicacionesicts), currentHashCode, theInstalacionesComunicacionesicts);
		}
		return currentHashCode;
	}

	public int hashCode() {
		final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
		return this.hashCode(null, strategy);
	}

}
