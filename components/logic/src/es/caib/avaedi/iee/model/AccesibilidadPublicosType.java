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
 * Clase Java para accesibilidad_publicosType complex type.
 * 
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que
 * haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="accesibilidad_publicosType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="exterior_edificioitinerarioaccesible_viapublica" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="exterior_edificioitinerarioaccesible_zonascomunes" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="exterior_observaciones" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="entreplantas_accesible" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="entreplantas_accesible_ascensororampaaccesible" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="entreplantas_accesible_ascensornoaccesible" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="entreplantas_accesible_ascensornoaccesible_dimensiones" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="entreplantas_accesible_rampaascensornoaccesible" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="entreplantas_noaccesible" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="entreplantas_noaccesible_ascensororampaaccesible" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="entreplantas_noaccesible_ascensornoaccesible" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="entreplantas_noaccesible_ascensornoaccesible_dimensiones" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="entreplantas_noaccesible_rampaascensornoaccesible" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="entreplantas_elementosaccesibles" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="entreplantas_elementosaccesibles_ascensororampaaccesible" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="entreplantas_elementosaccesibles_ascensornoaccesible" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="entreplantas_elementosaccesibles_ascensornoaccesible_dimensiones" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="entreplantas_elementosaccesibles_rampaascensornoaccesible" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="entreplantas_zonasusopublico" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="entreplantas_zonasusopublico_ascensororampaaccesible" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="entreplantas_zonasusopublico_ascensornoaccesible" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="entreplantas_zonasusopublico_ascensornoaccesible_dimensiones" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="entreplantas_zonasusopublico_rampaascensornoaccesible" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="entreplantas_observaciones" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="plantas_itinerarioaccesible_entresi" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="plantas_itinerarioaccesible_zonasusopublico" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="plantas_itinerarioaccesible_elementosaccesibles" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="plantas_itinerarioaccesible_zonasusoprivado" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="plantas_itinerarioaccesible_observaciones" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="alojamientosaccesibles_minimo1" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="alojamientosaccesibles_minimo2" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="alojamientosaccesibles_minimo4" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="alojamientosaccesibles_minimo6" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="alojamientosaccesibles_minimo8" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="alojamientosaccesibles_1porcada50" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="alojamientosaccesibles_observaciones" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="aparcamiento_residencialpublico_poralojamiento" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="aparcamiento_comercial_porfraccion" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="aparcamiento_otrosusos_minimoaparcamientos_unaporfraccion" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="aparcamiento_otrosusos_minimoaparcamientos_unamasporfraccion" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="aparcamiento_sillaruedas" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="aparcamiento_observaciones" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="plazasreservadas_sillaruedas" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="plazasreservadas_discapacidadauditiva" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="plazasreservadas_zonaespera_sillaruedas" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="plazasreservadas_observaciones" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="piscinas_entradaaccesible" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="piscinas_observaciones" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="servicioshigienicos_aseoaccesible" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="servicioshigienicos_cabinaduchaaccesibles" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="servicioshigienicos_observaciones" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="mobiliariofijo_puntoaccesible" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="mobiliariofijo_observaciones" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="mecanismos_accesibles" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="mecanismos_observaciones" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="informacionsenalizacion_privado_sia_entradas" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="informacionsenalizacion_privado_sia_itinerarios" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="informacionsenalizacion_privado_sia_ascensores" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="informacionsenalizacion_privado_sia_aparcamiento" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="informacionsenalizacion_privado_sia_plazasreservadas" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="informacionsenalizacion_publico_sia_entradas" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="informacionsenalizacion_publico_sia_ascensores" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="informacionsenalizacion_publico_sia_itinerarios" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="informacionsenalizacion_publico_sia_aparcamiento" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="informacionsenalizacion_publico_sia_plazasreservadas" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="informacionsenalizacion_publico_sia_servicioshigienicos" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="informacionsenalizacion_publico_sia_puntosatencion" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="informacionsenalizacion_servicioshigienicossenalizados" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="informacionsenalizacion_observaciones" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="informacionsenalizacion_ascensores" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="informacionsenalizacion_ascensores_brailearabigo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="informacionsenalizacion_ascensores_numeroplanta" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="informacionsenalizacion_buclemagnetico" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="informacionsenalizacion_buclemagnetico_senalizado" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="informacionsenalizacion_bandasvisualestactiles" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="informacionsenalizacion_bandasvisualestactiles_colorcontrastado" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="informacionsenalizacion_bandasvisualestactiles_relieveinterior" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="informacionsenalizacion_bandasvisualestactiles_relieveexterior" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="informacionsenalizacion_bandasvisualestactiles_arranqueescaleras" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="informacionsenalizacion_bandasvisualestactiles_itinerarioaccesib" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="informacionsenalizacion_sianorma" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="informacionsenalizacion_todosusos_observaciones" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="es_tecnico_inspeccion" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="tecnico" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="nif" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="titulacion" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "accesibilidad_publicosType", propOrder = { "exteriorEdificioitinerarioaccesibleViapublica", "exteriorEdificioitinerarioaccesibleZonascomunes", "exteriorObservaciones", "entreplantasAccesible", "entreplantasAccesibleAscensororampaaccesible", "entreplantasAccesibleAscensornoaccesible", "entreplantasAccesibleAscensornoaccesibleDimensiones", "entreplantasAccesibleRampaascensornoaccesible", "entreplantasNoaccesible", "entreplantasNoaccesibleAscensororampaaccesible", "entreplantasNoaccesibleAscensornoaccesible", "entreplantasNoaccesibleAscensornoaccesibleDimensiones", "entreplantasNoaccesibleRampaascensornoaccesible", "entreplantasElementosaccesibles", "entreplantasElementosaccesiblesAscensororampaaccesible", "entreplantasElementosaccesiblesAscensornoaccesible", "entreplantasElementosaccesiblesAscensornoaccesibleDimensiones", "entreplantasElementosaccesiblesRampaascensornoaccesible", "entreplantasZonasusopublico", "entreplantasZonasusopublicoAscensororampaaccesible", "entreplantasZonasusopublicoAscensornoaccesible", "entreplantasZonasusopublicoAscensornoaccesibleDimensiones", "entreplantasZonasusopublicoRampaascensornoaccesible", "entreplantasObservaciones", "plantasItinerarioaccesibleEntresi", "plantasItinerarioaccesibleZonasusopublico", "plantasItinerarioaccesibleElementosaccesibles", "plantasItinerarioaccesibleZonasusoprivado", "plantasItinerarioaccesibleObservaciones", "alojamientosaccesiblesMinimo1", "alojamientosaccesiblesMinimo2", "alojamientosaccesiblesMinimo4", "alojamientosaccesiblesMinimo6", "alojamientosaccesiblesMinimo8", "alojamientosaccesibles1Porcada50", "alojamientosaccesiblesObservaciones", "aparcamientoResidencialpublicoPoralojamiento", "aparcamientoComercialPorfraccion", "aparcamientoOtrosusosMinimoaparcamientosUnaporfraccion", "aparcamientoOtrosusosMinimoaparcamientosUnamasporfraccion", "aparcamientoSillaruedas", "aparcamientoObservaciones", "plazasreservadasSillaruedas", "plazasreservadasDiscapacidadauditiva", "plazasreservadasZonaesperaSillaruedas", "plazasreservadasObservaciones", "piscinasEntradaaccesible", "piscinasObservaciones", "servicioshigienicosAseoaccesible", "servicioshigienicosCabinaduchaaccesibles", "servicioshigienicosObservaciones", "mobiliariofijoPuntoaccesible", "mobiliariofijoObservaciones", "mecanismosAccesibles", "mecanismosObservaciones", "informacionsenalizacionPrivadoSiaEntradas", "informacionsenalizacionPrivadoSiaItinerarios", "informacionsenalizacionPrivadoSiaAscensores", "informacionsenalizacionPrivadoSiaAparcamiento", "informacionsenalizacionPrivadoSiaPlazasreservadas", "informacionsenalizacionPublicoSiaEntradas", "informacionsenalizacionPublicoSiaAscensores", "informacionsenalizacionPublicoSiaItinerarios", "informacionsenalizacionPublicoSiaAparcamiento", "informacionsenalizacionPublicoSiaPlazasreservadas", "informacionsenalizacionPublicoSiaServicioshigienicos", "informacionsenalizacionPublicoSiaPuntosatencion", "informacionsenalizacionServicioshigienicossenalizados", "informacionsenalizacionObservaciones", "informacionsenalizacionAscensores", "informacionsenalizacionAscensoresBrailearabigo", "informacionsenalizacionAscensoresNumeroplanta", "informacionsenalizacionBuclemagnetico", "informacionsenalizacionBuclemagneticoSenalizado", "informacionsenalizacionBandasvisualestactiles", "informacionsenalizacionBandasvisualestactilesColorcontrastado", "informacionsenalizacionBandasvisualestactilesRelieveinterior", "informacionsenalizacionBandasvisualestactilesRelieveexterior", "informacionsenalizacionBandasvisualestactilesArranqueescaleras", "informacionsenalizacionBandasvisualestactilesItinerarioaccesib", "informacionsenalizacionSianorma", "informacionsenalizacionTodosusosObservaciones", "esTecnicoInspeccion", "tecnico", "nif", "titulacion" })
@Entity(name = "AccesibilidadPublicosType")
@Table(name = "AED_ACC_PUBLICOS")
@Inheritance(strategy = InheritanceType.JOINED)
public class AccesibilidadPublicosType implements Serializable, Equals, HashCode {

	@XmlElement(name = "exterior_edificioitinerarioaccesible_viapublica")
	protected int exteriorEdificioitinerarioaccesibleViapublica;
	@XmlElement(name = "exterior_edificioitinerarioaccesible_zonascomunes")
	protected int exteriorEdificioitinerarioaccesibleZonascomunes;
	@XmlElement(name = "exterior_observaciones", required = true)
	protected String exteriorObservaciones;
	@XmlElement(name = "entreplantas_accesible")
	protected int entreplantasAccesible;
	@XmlElement(name = "entreplantas_accesible_ascensororampaaccesible", required = true)
	protected String entreplantasAccesibleAscensororampaaccesible;
	@XmlElement(name = "entreplantas_accesible_ascensornoaccesible", required = true)
	protected String entreplantasAccesibleAscensornoaccesible;
	@XmlElement(name = "entreplantas_accesible_ascensornoaccesible_dimensiones", required = true)
	protected String entreplantasAccesibleAscensornoaccesibleDimensiones;
	@XmlElement(name = "entreplantas_accesible_rampaascensornoaccesible", required = true)
	protected String entreplantasAccesibleRampaascensornoaccesible;
	@XmlElement(name = "entreplantas_noaccesible")
	protected int entreplantasNoaccesible;
	@XmlElement(name = "entreplantas_noaccesible_ascensororampaaccesible", required = true)
	protected String entreplantasNoaccesibleAscensororampaaccesible;
	@XmlElement(name = "entreplantas_noaccesible_ascensornoaccesible", required = true)
	protected String entreplantasNoaccesibleAscensornoaccesible;
	@XmlElement(name = "entreplantas_noaccesible_ascensornoaccesible_dimensiones", required = true)
	protected String entreplantasNoaccesibleAscensornoaccesibleDimensiones;
	@XmlElement(name = "entreplantas_noaccesible_rampaascensornoaccesible", required = true)
	protected String entreplantasNoaccesibleRampaascensornoaccesible;
	@XmlElement(name = "entreplantas_elementosaccesibles")
	protected int entreplantasElementosaccesibles;
	@XmlElement(name = "entreplantas_elementosaccesibles_ascensororampaaccesible", required = true)
	protected String entreplantasElementosaccesiblesAscensororampaaccesible;
	@XmlElement(name = "entreplantas_elementosaccesibles_ascensornoaccesible", required = true)
	protected String entreplantasElementosaccesiblesAscensornoaccesible;
	@XmlElement(name = "entreplantas_elementosaccesibles_ascensornoaccesible_dimensiones", required = true)
	protected String entreplantasElementosaccesiblesAscensornoaccesibleDimensiones;
	@XmlElement(name = "entreplantas_elementosaccesibles_rampaascensornoaccesible", required = true)
	protected String entreplantasElementosaccesiblesRampaascensornoaccesible;
	@XmlElement(name = "entreplantas_zonasusopublico")
	protected int entreplantasZonasusopublico;
	@XmlElement(name = "entreplantas_zonasusopublico_ascensororampaaccesible", required = true)
	protected String entreplantasZonasusopublicoAscensororampaaccesible;
	@XmlElement(name = "entreplantas_zonasusopublico_ascensornoaccesible", required = true)
	protected String entreplantasZonasusopublicoAscensornoaccesible;
	@XmlElement(name = "entreplantas_zonasusopublico_ascensornoaccesible_dimensiones", required = true)
	protected String entreplantasZonasusopublicoAscensornoaccesibleDimensiones;
	@XmlElement(name = "entreplantas_zonasusopublico_rampaascensornoaccesible", required = true)
	protected String entreplantasZonasusopublicoRampaascensornoaccesible;
	@XmlElement(name = "entreplantas_observaciones", required = true)
	protected String entreplantasObservaciones;
	@XmlElement(name = "plantas_itinerarioaccesible_entresi")
	protected int plantasItinerarioaccesibleEntresi;
	@XmlElement(name = "plantas_itinerarioaccesible_zonasusopublico")
	protected int plantasItinerarioaccesibleZonasusopublico;
	@XmlElement(name = "plantas_itinerarioaccesible_elementosaccesibles")
	protected int plantasItinerarioaccesibleElementosaccesibles;
	@XmlElement(name = "plantas_itinerarioaccesible_zonasusoprivado")
	protected int plantasItinerarioaccesibleZonasusoprivado;
	@XmlElement(name = "plantas_itinerarioaccesible_observaciones", required = true)
	protected String plantasItinerarioaccesibleObservaciones;
	@XmlElement(name = "alojamientosaccesibles_minimo1", required = true)
	protected String alojamientosaccesiblesMinimo1;
	@XmlElement(name = "alojamientosaccesibles_minimo2", required = true)
	protected String alojamientosaccesiblesMinimo2;
	@XmlElement(name = "alojamientosaccesibles_minimo4", required = true)
	protected String alojamientosaccesiblesMinimo4;
	@XmlElement(name = "alojamientosaccesibles_minimo6", required = true)
	protected String alojamientosaccesiblesMinimo6;
	@XmlElement(name = "alojamientosaccesibles_minimo8", required = true)
	protected String alojamientosaccesiblesMinimo8;
	@XmlElement(name = "alojamientosaccesibles_1porcada50", required = true)
	protected String alojamientosaccesibles1Porcada50;
	@XmlElement(name = "alojamientosaccesibles_observaciones", required = true)
	protected String alojamientosaccesiblesObservaciones;
	@XmlElement(name = "aparcamiento_residencialpublico_poralojamiento", required = true)
	protected String aparcamientoResidencialpublicoPoralojamiento;
	@XmlElement(name = "aparcamiento_comercial_porfraccion", required = true)
	protected String aparcamientoComercialPorfraccion;
	@XmlElement(name = "aparcamiento_otrosusos_minimoaparcamientos_unaporfraccion", required = true)
	protected String aparcamientoOtrosusosMinimoaparcamientosUnaporfraccion;
	@XmlElement(name = "aparcamiento_otrosusos_minimoaparcamientos_unamasporfraccion", required = true)
	protected String aparcamientoOtrosusosMinimoaparcamientosUnamasporfraccion;
	@XmlElement(name = "aparcamiento_sillaruedas", required = true)
	protected String aparcamientoSillaruedas;
	@XmlElement(name = "aparcamiento_observaciones", required = true)
	protected String aparcamientoObservaciones;
	@XmlElement(name = "plazasreservadas_sillaruedas", required = true)
	protected String plazasreservadasSillaruedas;
	@XmlElement(name = "plazasreservadas_discapacidadauditiva", required = true)
	protected String plazasreservadasDiscapacidadauditiva;
	@XmlElement(name = "plazasreservadas_zonaespera_sillaruedas", required = true)
	protected String plazasreservadasZonaesperaSillaruedas;
	@XmlElement(name = "plazasreservadas_observaciones", required = true)
	protected String plazasreservadasObservaciones;
	@XmlElement(name = "piscinas_entradaaccesible", required = true)
	protected String piscinasEntradaaccesible;
	@XmlElement(name = "piscinas_observaciones", required = true)
	protected String piscinasObservaciones;
	@XmlElement(name = "servicioshigienicos_aseoaccesible", required = true)
	protected String servicioshigienicosAseoaccesible;
	@XmlElement(name = "servicioshigienicos_cabinaduchaaccesibles", required = true)
	protected String servicioshigienicosCabinaduchaaccesibles;
	@XmlElement(name = "servicioshigienicos_observaciones", required = true)
	protected String servicioshigienicosObservaciones;
	@XmlElement(name = "mobiliariofijo_puntoaccesible", required = true)
	protected String mobiliariofijoPuntoaccesible;
	@XmlElement(name = "mobiliariofijo_observaciones", required = true)
	protected String mobiliariofijoObservaciones;
	@XmlElement(name = "mecanismos_accesibles", required = true)
	protected String mecanismosAccesibles;
	@XmlElement(name = "mecanismos_observaciones", required = true)
	protected String mecanismosObservaciones;
	@XmlElement(name = "informacionsenalizacion_privado_sia_entradas", required = true)
	protected String informacionsenalizacionPrivadoSiaEntradas;
	@XmlElement(name = "informacionsenalizacion_privado_sia_itinerarios", required = true)
	protected String informacionsenalizacionPrivadoSiaItinerarios;
	@XmlElement(name = "informacionsenalizacion_privado_sia_ascensores", required = true)
	protected String informacionsenalizacionPrivadoSiaAscensores;
	@XmlElement(name = "informacionsenalizacion_privado_sia_aparcamiento", required = true)
	protected String informacionsenalizacionPrivadoSiaAparcamiento;
	@XmlElement(name = "informacionsenalizacion_privado_sia_plazasreservadas", required = true)
	protected String informacionsenalizacionPrivadoSiaPlazasreservadas;
	@XmlElement(name = "informacionsenalizacion_publico_sia_entradas", required = true)
	protected String informacionsenalizacionPublicoSiaEntradas;
	@XmlElement(name = "informacionsenalizacion_publico_sia_ascensores", required = true)
	protected String informacionsenalizacionPublicoSiaAscensores;
	@XmlElement(name = "informacionsenalizacion_publico_sia_itinerarios", required = true)
	protected String informacionsenalizacionPublicoSiaItinerarios;
	@XmlElement(name = "informacionsenalizacion_publico_sia_aparcamiento", required = true)
	protected String informacionsenalizacionPublicoSiaAparcamiento;
	@XmlElement(name = "informacionsenalizacion_publico_sia_plazasreservadas", required = true)
	protected String informacionsenalizacionPublicoSiaPlazasreservadas;
	@XmlElement(name = "informacionsenalizacion_publico_sia_servicioshigienicos", required = true)
	protected String informacionsenalizacionPublicoSiaServicioshigienicos;
	@XmlElement(name = "informacionsenalizacion_publico_sia_puntosatencion", required = true)
	protected String informacionsenalizacionPublicoSiaPuntosatencion;
	@XmlElement(name = "informacionsenalizacion_servicioshigienicossenalizados", required = true)
	protected String informacionsenalizacionServicioshigienicossenalizados;
	@XmlElement(name = "informacionsenalizacion_observaciones", required = true)
	protected String informacionsenalizacionObservaciones;
	@XmlElement(name = "informacionsenalizacion_ascensores", required = true)
	protected String informacionsenalizacionAscensores;
	@XmlElement(name = "informacionsenalizacion_ascensores_brailearabigo", required = true)
	protected String informacionsenalizacionAscensoresBrailearabigo;
	@XmlElement(name = "informacionsenalizacion_ascensores_numeroplanta", required = true)
	protected String informacionsenalizacionAscensoresNumeroplanta;
	@XmlElement(name = "informacionsenalizacion_buclemagnetico", required = true)
	protected String informacionsenalizacionBuclemagnetico;
	@XmlElement(name = "informacionsenalizacion_buclemagnetico_senalizado", required = true)
	protected String informacionsenalizacionBuclemagneticoSenalizado;
	@XmlElement(name = "informacionsenalizacion_bandasvisualestactiles", required = true)
	protected String informacionsenalizacionBandasvisualestactiles;
	@XmlElement(name = "informacionsenalizacion_bandasvisualestactiles_colorcontrastado", required = true)
	protected String informacionsenalizacionBandasvisualestactilesColorcontrastado;
	@XmlElement(name = "informacionsenalizacion_bandasvisualestactiles_relieveinterior", required = true)
	protected String informacionsenalizacionBandasvisualestactilesRelieveinterior;
	@XmlElement(name = "informacionsenalizacion_bandasvisualestactiles_relieveexterior", required = true)
	protected String informacionsenalizacionBandasvisualestactilesRelieveexterior;
	@XmlElement(name = "informacionsenalizacion_bandasvisualestactiles_arranqueescaleras", required = true)
	protected String informacionsenalizacionBandasvisualestactilesArranqueescaleras;
	@XmlElement(name = "informacionsenalizacion_bandasvisualestactiles_itinerarioaccesib", required = true)
	protected String informacionsenalizacionBandasvisualestactilesItinerarioaccesib;
	@XmlElement(name = "informacionsenalizacion_sianorma", required = true)
	protected String informacionsenalizacionSianorma;
	@XmlElement(name = "informacionsenalizacion_todosusos_observaciones", required = true)
	protected String informacionsenalizacionTodosusosObservaciones;
	@XmlElement(name = "es_tecnico_inspeccion")
	protected int esTecnicoInspeccion;
	@XmlElement(required = true)
	protected String tecnico;
	@XmlElement(required = true)
	protected String nif;
	@XmlElement(required = true)
	protected String titulacion;
	@XmlAttribute(name = "Hjid")
	protected Long hjid;

	/**
	 * Obtiene el valor de la propiedad
	 * exteriorEdificioitinerarioaccesibleViapublica.
	 * 
	 */
	@Basic
	@Column(name = "EXTERIOR_EDIFICIOITINERARIOACCESIBLE_VIAPUBLICA", precision = 10, scale = 0)
	public int getExteriorEdificioitinerarioaccesibleViapublica() {
		return exteriorEdificioitinerarioaccesibleViapublica;
	}

	/**
	 * Define el valor de la propiedad
	 * exteriorEdificioitinerarioaccesibleViapublica.
	 * 
	 */
	public void setExteriorEdificioitinerarioaccesibleViapublica(int value) {
		this.exteriorEdificioitinerarioaccesibleViapublica = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * exteriorEdificioitinerarioaccesibleZonascomunes.
	 * 
	 */
	@Basic
	@Column(name = "EXTERIOR_EDIFICIOITINERARIOACCESIBLE_ZONASCOMUNES", precision = 10, scale = 0)
	public int getExteriorEdificioitinerarioaccesibleZonascomunes() {
		return exteriorEdificioitinerarioaccesibleZonascomunes;
	}

	/**
	 * Define el valor de la propiedad
	 * exteriorEdificioitinerarioaccesibleZonascomunes.
	 * 
	 */
	public void setExteriorEdificioitinerarioaccesibleZonascomunes(int value) {
		this.exteriorEdificioitinerarioaccesibleZonascomunes = value;
	}

	/**
	 * Obtiene el valor de la propiedad exteriorObservaciones.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "EXTERIOR_OBSERVACIONES", length = 255)
	public String getExteriorObservaciones() {
		return exteriorObservaciones;
	}

	/**
	 * Define el valor de la propiedad exteriorObservaciones.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setExteriorObservaciones(String value) {
		this.exteriorObservaciones = value;
	}

	/**
	 * Obtiene el valor de la propiedad entreplantasAccesible.
	 * 
	 */
	@Basic
	@Column(name = "ENTREPLANTAS_ACCESIBLE", precision = 10, scale = 0)
	public int getEntreplantasAccesible() {
		return entreplantasAccesible;
	}

	/**
	 * Define el valor de la propiedad entreplantasAccesible.
	 * 
	 */
	public void setEntreplantasAccesible(int value) {
		this.entreplantasAccesible = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * entreplantasAccesibleAscensororampaaccesible.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "ENTREPLANTAS_ACCESIBLE_ASCENSORORAMPAACCESIBLE", length = 255)
	public String getEntreplantasAccesibleAscensororampaaccesible() {
		return entreplantasAccesibleAscensororampaaccesible;
	}

	/**
	 * Define el valor de la propiedad
	 * entreplantasAccesibleAscensororampaaccesible.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setEntreplantasAccesibleAscensororampaaccesible(String value) {
		this.entreplantasAccesibleAscensororampaaccesible = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * entreplantasAccesibleAscensornoaccesible.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "ENTREPLANTAS_ACCESIBLE_ASCENSORNOACCESIBLE", length = 255)
	public String getEntreplantasAccesibleAscensornoaccesible() {
		return entreplantasAccesibleAscensornoaccesible;
	}

	/**
	 * Define el valor de la propiedad entreplantasAccesibleAscensornoaccesible.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setEntreplantasAccesibleAscensornoaccesible(String value) {
		this.entreplantasAccesibleAscensornoaccesible = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * entreplantasAccesibleAscensornoaccesibleDimensiones.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "ENTREPLANTAS_ACCESIBLE_ASCENSORNOACCESIBLE_DIMENSIONES", length = 255)
	public String getEntreplantasAccesibleAscensornoaccesibleDimensiones() {
		return entreplantasAccesibleAscensornoaccesibleDimensiones;
	}

	/**
	 * Define el valor de la propiedad
	 * entreplantasAccesibleAscensornoaccesibleDimensiones.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setEntreplantasAccesibleAscensornoaccesibleDimensiones(String value) {
		this.entreplantasAccesibleAscensornoaccesibleDimensiones = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * entreplantasAccesibleRampaascensornoaccesible.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "ENTREPLANTAS_ACCESIBLE_RAMPAASCENSORNOACCESIBLE", length = 255)
	public String getEntreplantasAccesibleRampaascensornoaccesible() {
		return entreplantasAccesibleRampaascensornoaccesible;
	}

	/**
	 * Define el valor de la propiedad
	 * entreplantasAccesibleRampaascensornoaccesible.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setEntreplantasAccesibleRampaascensornoaccesible(String value) {
		this.entreplantasAccesibleRampaascensornoaccesible = value;
	}

	/**
	 * Obtiene el valor de la propiedad entreplantasNoaccesible.
	 * 
	 */
	@Basic
	@Column(name = "ENTREPLANTAS_NOACCESIBLE", precision = 10, scale = 0)
	public int getEntreplantasNoaccesible() {
		return entreplantasNoaccesible;
	}

	/**
	 * Define el valor de la propiedad entreplantasNoaccesible.
	 * 
	 */
	public void setEntreplantasNoaccesible(int value) {
		this.entreplantasNoaccesible = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * entreplantasNoaccesibleAscensororampaaccesible.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "ENTREPLANTAS_NOACCESIBLE_ASCENSORORAMPAACCESIBLE", length = 255)
	public String getEntreplantasNoaccesibleAscensororampaaccesible() {
		return entreplantasNoaccesibleAscensororampaaccesible;
	}

	/**
	 * Define el valor de la propiedad
	 * entreplantasNoaccesibleAscensororampaaccesible.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setEntreplantasNoaccesibleAscensororampaaccesible(String value) {
		this.entreplantasNoaccesibleAscensororampaaccesible = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * entreplantasNoaccesibleAscensornoaccesible.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "ENTREPLANTAS_NOACCESIBLE_ASCENSORNOACCESIBLE", length = 255)
	public String getEntreplantasNoaccesibleAscensornoaccesible() {
		return entreplantasNoaccesibleAscensornoaccesible;
	}

	/**
	 * Define el valor de la propiedad
	 * entreplantasNoaccesibleAscensornoaccesible.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setEntreplantasNoaccesibleAscensornoaccesible(String value) {
		this.entreplantasNoaccesibleAscensornoaccesible = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * entreplantasNoaccesibleAscensornoaccesibleDimensiones.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "ENTREPLANTAS_NOACCESIBLE_ASCENSORNOACCESIBLE_DIMENSIONES", length = 255)
	public String getEntreplantasNoaccesibleAscensornoaccesibleDimensiones() {
		return entreplantasNoaccesibleAscensornoaccesibleDimensiones;
	}

	/**
	 * Define el valor de la propiedad
	 * entreplantasNoaccesibleAscensornoaccesibleDimensiones.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setEntreplantasNoaccesibleAscensornoaccesibleDimensiones(String value) {
		this.entreplantasNoaccesibleAscensornoaccesibleDimensiones = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * entreplantasNoaccesibleRampaascensornoaccesible.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "ENTREPLANTAS_NOACCESIBLE_RAMPAASCENSORNOACCESIBLE", length = 255)
	public String getEntreplantasNoaccesibleRampaascensornoaccesible() {
		return entreplantasNoaccesibleRampaascensornoaccesible;
	}

	/**
	 * Define el valor de la propiedad
	 * entreplantasNoaccesibleRampaascensornoaccesible.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setEntreplantasNoaccesibleRampaascensornoaccesible(String value) {
		this.entreplantasNoaccesibleRampaascensornoaccesible = value;
	}

	/**
	 * Obtiene el valor de la propiedad entreplantasElementosaccesibles.
	 * 
	 */
	@Basic
	@Column(name = "ENTREPLANTAS_ELEMENTOSACCESIBLES", precision = 10, scale = 0)
	public int getEntreplantasElementosaccesibles() {
		return entreplantasElementosaccesibles;
	}

	/**
	 * Define el valor de la propiedad entreplantasElementosaccesibles.
	 * 
	 */
	public void setEntreplantasElementosaccesibles(int value) {
		this.entreplantasElementosaccesibles = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * entreplantasElementosaccesiblesAscensororampaaccesible.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "ENTREPLANTAS_ELEMENTOSACCESIBLES_ASCENSORORAMPAACCESIBLE", length = 255)
	public String getEntreplantasElementosaccesiblesAscensororampaaccesible() {
		return entreplantasElementosaccesiblesAscensororampaaccesible;
	}

	/**
	 * Define el valor de la propiedad
	 * entreplantasElementosaccesiblesAscensororampaaccesible.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setEntreplantasElementosaccesiblesAscensororampaaccesible(String value) {
		this.entreplantasElementosaccesiblesAscensororampaaccesible = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * entreplantasElementosaccesiblesAscensornoaccesible.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "ENTREPLANTAS_ELEMENTOSACCESIBLES_ASCENSORNOACCESIBLE", length = 255)
	public String getEntreplantasElementosaccesiblesAscensornoaccesible() {
		return entreplantasElementosaccesiblesAscensornoaccesible;
	}

	/**
	 * Define el valor de la propiedad
	 * entreplantasElementosaccesiblesAscensornoaccesible.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setEntreplantasElementosaccesiblesAscensornoaccesible(String value) {
		this.entreplantasElementosaccesiblesAscensornoaccesible = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * entreplantasElementosaccesiblesAscensornoaccesibleDimensiones.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "ENTREPLANTAS_ELEMENTOSACCESIBLES_ASCENSORNOACCESIBLE_DIMENSIONES", length = 255)
	public String getEntreplantasElementosaccesiblesAscensornoaccesibleDimensiones() {
		return entreplantasElementosaccesiblesAscensornoaccesibleDimensiones;
	}

	/**
	 * Define el valor de la propiedad
	 * entreplantasElementosaccesiblesAscensornoaccesibleDimensiones.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setEntreplantasElementosaccesiblesAscensornoaccesibleDimensiones(String value) {
		this.entreplantasElementosaccesiblesAscensornoaccesibleDimensiones = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * entreplantasElementosaccesiblesRampaascensornoaccesible.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "ENTREPLANTAS_ELEMENTOSACCESIBLES_RAMPAASCENSORNOACCESIBLE", length = 255)
	public String getEntreplantasElementosaccesiblesRampaascensornoaccesible() {
		return entreplantasElementosaccesiblesRampaascensornoaccesible;
	}

	/**
	 * Define el valor de la propiedad
	 * entreplantasElementosaccesiblesRampaascensornoaccesible.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setEntreplantasElementosaccesiblesRampaascensornoaccesible(String value) {
		this.entreplantasElementosaccesiblesRampaascensornoaccesible = value;
	}

	/**
	 * Obtiene el valor de la propiedad entreplantasZonasusopublico.
	 * 
	 */
	@Basic
	@Column(name = "ENTREPLANTAS_ZONASUSOPUBLICO", precision = 10, scale = 0)
	public int getEntreplantasZonasusopublico() {
		return entreplantasZonasusopublico;
	}

	/**
	 * Define el valor de la propiedad entreplantasZonasusopublico.
	 * 
	 */
	public void setEntreplantasZonasusopublico(int value) {
		this.entreplantasZonasusopublico = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * entreplantasZonasusopublicoAscensororampaaccesible.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "ENTREPLANTAS_ZONASUSOPUBLICO_ASCENSORORAMPAACCESIBLE", length = 255)
	public String getEntreplantasZonasusopublicoAscensororampaaccesible() {
		return entreplantasZonasusopublicoAscensororampaaccesible;
	}

	/**
	 * Define el valor de la propiedad
	 * entreplantasZonasusopublicoAscensororampaaccesible.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setEntreplantasZonasusopublicoAscensororampaaccesible(String value) {
		this.entreplantasZonasusopublicoAscensororampaaccesible = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * entreplantasZonasusopublicoAscensornoaccesible.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "ENTREPLANTAS_ZONASUSOPUBLICO_ASCENSORNOACCESIBLE", length = 255)
	public String getEntreplantasZonasusopublicoAscensornoaccesible() {
		return entreplantasZonasusopublicoAscensornoaccesible;
	}

	/**
	 * Define el valor de la propiedad
	 * entreplantasZonasusopublicoAscensornoaccesible.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setEntreplantasZonasusopublicoAscensornoaccesible(String value) {
		this.entreplantasZonasusopublicoAscensornoaccesible = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * entreplantasZonasusopublicoAscensornoaccesibleDimensiones.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "ENTREPLANTAS_ZONASUSOPUBLICO_ASCENSORNOACCESIBLE_DIMENSIONES", length = 255)
	public String getEntreplantasZonasusopublicoAscensornoaccesibleDimensiones() {
		return entreplantasZonasusopublicoAscensornoaccesibleDimensiones;
	}

	/**
	 * Define el valor de la propiedad
	 * entreplantasZonasusopublicoAscensornoaccesibleDimensiones.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setEntreplantasZonasusopublicoAscensornoaccesibleDimensiones(String value) {
		this.entreplantasZonasusopublicoAscensornoaccesibleDimensiones = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * entreplantasZonasusopublicoRampaascensornoaccesible.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "ENTREPLANTAS_ZONASUSOPUBLICO_RAMPAASCENSORNOACCESIBLE", length = 255)
	public String getEntreplantasZonasusopublicoRampaascensornoaccesible() {
		return entreplantasZonasusopublicoRampaascensornoaccesible;
	}

	/**
	 * Define el valor de la propiedad
	 * entreplantasZonasusopublicoRampaascensornoaccesible.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setEntreplantasZonasusopublicoRampaascensornoaccesible(String value) {
		this.entreplantasZonasusopublicoRampaascensornoaccesible = value;
	}

	/**
	 * Obtiene el valor de la propiedad entreplantasObservaciones.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "ENTREPLANTAS_OBSERVACIONES", length = 255)
	public String getEntreplantasObservaciones() {
		return entreplantasObservaciones;
	}

	/**
	 * Define el valor de la propiedad entreplantasObservaciones.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setEntreplantasObservaciones(String value) {
		this.entreplantasObservaciones = value;
	}

	/**
	 * Obtiene el valor de la propiedad plantasItinerarioaccesibleEntresi.
	 * 
	 */
	@Basic
	@Column(name = "PLANTAS_ITINERARIOACCESIBLE_ENTRESI", precision = 10, scale = 0)
	public int getPlantasItinerarioaccesibleEntresi() {
		return plantasItinerarioaccesibleEntresi;
	}

	/**
	 * Define el valor de la propiedad plantasItinerarioaccesibleEntresi.
	 * 
	 */
	public void setPlantasItinerarioaccesibleEntresi(int value) {
		this.plantasItinerarioaccesibleEntresi = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * plantasItinerarioaccesibleZonasusopublico.
	 * 
	 */
	@Basic
	@Column(name = "PLANTAS_ITINERARIOACCESIBLE_ZONASUSOPUBLICO", precision = 10, scale = 0)
	public int getPlantasItinerarioaccesibleZonasusopublico() {
		return plantasItinerarioaccesibleZonasusopublico;
	}

	/**
	 * Define el valor de la propiedad
	 * plantasItinerarioaccesibleZonasusopublico.
	 * 
	 */
	public void setPlantasItinerarioaccesibleZonasusopublico(int value) {
		this.plantasItinerarioaccesibleZonasusopublico = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * plantasItinerarioaccesibleElementosaccesibles.
	 * 
	 */
	@Basic
	@Column(name = "PLANTAS_ITINERARIOACCESIBLE_ELEMENTOSACCESIBLES", precision = 10, scale = 0)
	public int getPlantasItinerarioaccesibleElementosaccesibles() {
		return plantasItinerarioaccesibleElementosaccesibles;
	}

	/**
	 * Define el valor de la propiedad
	 * plantasItinerarioaccesibleElementosaccesibles.
	 * 
	 */
	public void setPlantasItinerarioaccesibleElementosaccesibles(int value) {
		this.plantasItinerarioaccesibleElementosaccesibles = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * plantasItinerarioaccesibleZonasusoprivado.
	 * 
	 */
	@Basic
	@Column(name = "PLANTAS_ITINERARIOACCESIBLE_ZONASUSOPRIVADO", precision = 10, scale = 0)
	public int getPlantasItinerarioaccesibleZonasusoprivado() {
		return plantasItinerarioaccesibleZonasusoprivado;
	}

	/**
	 * Define el valor de la propiedad
	 * plantasItinerarioaccesibleZonasusoprivado.
	 * 
	 */
	public void setPlantasItinerarioaccesibleZonasusoprivado(int value) {
		this.plantasItinerarioaccesibleZonasusoprivado = value;
	}

	/**
	 * Obtiene el valor de la propiedad plantasItinerarioaccesibleObservaciones.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "PLANTAS_ITINERARIOACCESIBLE_OBSERVACIONES", length = 255)
	public String getPlantasItinerarioaccesibleObservaciones() {
		return plantasItinerarioaccesibleObservaciones;
	}

	/**
	 * Define el valor de la propiedad plantasItinerarioaccesibleObservaciones.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPlantasItinerarioaccesibleObservaciones(String value) {
		this.plantasItinerarioaccesibleObservaciones = value;
	}

	/**
	 * Obtiene el valor de la propiedad alojamientosaccesiblesMinimo1.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "ALOJAMIENTOSACCESIBLES_MINIMO_1", length = 255)
	public String getAlojamientosaccesiblesMinimo1() {
		return alojamientosaccesiblesMinimo1;
	}

	/**
	 * Define el valor de la propiedad alojamientosaccesiblesMinimo1.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setAlojamientosaccesiblesMinimo1(String value) {
		this.alojamientosaccesiblesMinimo1 = value;
	}

	/**
	 * Obtiene el valor de la propiedad alojamientosaccesiblesMinimo2.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "ALOJAMIENTOSACCESIBLES_MINIMO_2", length = 255)
	public String getAlojamientosaccesiblesMinimo2() {
		return alojamientosaccesiblesMinimo2;
	}

	/**
	 * Define el valor de la propiedad alojamientosaccesiblesMinimo2.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setAlojamientosaccesiblesMinimo2(String value) {
		this.alojamientosaccesiblesMinimo2 = value;
	}

	/**
	 * Obtiene el valor de la propiedad alojamientosaccesiblesMinimo4.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "ALOJAMIENTOSACCESIBLES_MINIMO_4", length = 255)
	public String getAlojamientosaccesiblesMinimo4() {
		return alojamientosaccesiblesMinimo4;
	}

	/**
	 * Define el valor de la propiedad alojamientosaccesiblesMinimo4.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setAlojamientosaccesiblesMinimo4(String value) {
		this.alojamientosaccesiblesMinimo4 = value;
	}

	/**
	 * Obtiene el valor de la propiedad alojamientosaccesiblesMinimo6.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "ALOJAMIENTOSACCESIBLES_MINIMO_6", length = 255)
	public String getAlojamientosaccesiblesMinimo6() {
		return alojamientosaccesiblesMinimo6;
	}

	/**
	 * Define el valor de la propiedad alojamientosaccesiblesMinimo6.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setAlojamientosaccesiblesMinimo6(String value) {
		this.alojamientosaccesiblesMinimo6 = value;
	}

	/**
	 * Obtiene el valor de la propiedad alojamientosaccesiblesMinimo8.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "ALOJAMIENTOSACCESIBLES_MINIMO_8", length = 255)
	public String getAlojamientosaccesiblesMinimo8() {
		return alojamientosaccesiblesMinimo8;
	}

	/**
	 * Define el valor de la propiedad alojamientosaccesiblesMinimo8.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setAlojamientosaccesiblesMinimo8(String value) {
		this.alojamientosaccesiblesMinimo8 = value;
	}

	/**
	 * Obtiene el valor de la propiedad alojamientosaccesibles1Porcada50.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "ALOJAMIENTOSACCESIBLES_1PORCADA_50", length = 255)
	public String getAlojamientosaccesibles1Porcada50() {
		return alojamientosaccesibles1Porcada50;
	}

	/**
	 * Define el valor de la propiedad alojamientosaccesibles1Porcada50.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setAlojamientosaccesibles1Porcada50(String value) {
		this.alojamientosaccesibles1Porcada50 = value;
	}

	/**
	 * Obtiene el valor de la propiedad alojamientosaccesiblesObservaciones.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "ALOJAMIENTOSACCESIBLES_OBSERVACIONES", length = 255)
	public String getAlojamientosaccesiblesObservaciones() {
		return alojamientosaccesiblesObservaciones;
	}

	/**
	 * Define el valor de la propiedad alojamientosaccesiblesObservaciones.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setAlojamientosaccesiblesObservaciones(String value) {
		this.alojamientosaccesiblesObservaciones = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * aparcamientoResidencialpublicoPoralojamiento.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "APARCAMIENTO_RESIDENCIALPUBLICO_PORALOJAMIENTO", length = 255)
	public String getAparcamientoResidencialpublicoPoralojamiento() {
		return aparcamientoResidencialpublicoPoralojamiento;
	}

	/**
	 * Define el valor de la propiedad
	 * aparcamientoResidencialpublicoPoralojamiento.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setAparcamientoResidencialpublicoPoralojamiento(String value) {
		this.aparcamientoResidencialpublicoPoralojamiento = value;
	}

	/**
	 * Obtiene el valor de la propiedad aparcamientoComercialPorfraccion.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "APARCAMIENTO_COMERCIAL_PORFRACCION", length = 255)
	public String getAparcamientoComercialPorfraccion() {
		return aparcamientoComercialPorfraccion;
	}

	/**
	 * Define el valor de la propiedad aparcamientoComercialPorfraccion.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setAparcamientoComercialPorfraccion(String value) {
		this.aparcamientoComercialPorfraccion = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * aparcamientoOtrosusosMinimoaparcamientosUnaporfraccion.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "APARCAMIENTO_OTROSUSOS_MINIMOAPARCAMIENTOS_UNAPORFRACCION", length = 255)
	public String getAparcamientoOtrosusosMinimoaparcamientosUnaporfraccion() {
		return aparcamientoOtrosusosMinimoaparcamientosUnaporfraccion;
	}

	/**
	 * Define el valor de la propiedad
	 * aparcamientoOtrosusosMinimoaparcamientosUnaporfraccion.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setAparcamientoOtrosusosMinimoaparcamientosUnaporfraccion(String value) {
		this.aparcamientoOtrosusosMinimoaparcamientosUnaporfraccion = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * aparcamientoOtrosusosMinimoaparcamientosUnamasporfraccion.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "APARCAMIENTO_OTROSUSOS_MINIMOAPARCAMIENTOS_UNAMASPORFRACCION", length = 255)
	public String getAparcamientoOtrosusosMinimoaparcamientosUnamasporfraccion() {
		return aparcamientoOtrosusosMinimoaparcamientosUnamasporfraccion;
	}

	/**
	 * Define el valor de la propiedad
	 * aparcamientoOtrosusosMinimoaparcamientosUnamasporfraccion.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setAparcamientoOtrosusosMinimoaparcamientosUnamasporfraccion(String value) {
		this.aparcamientoOtrosusosMinimoaparcamientosUnamasporfraccion = value;
	}

	/**
	 * Obtiene el valor de la propiedad aparcamientoSillaruedas.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "APARCAMIENTO_SILLARUEDAS", length = 255)
	public String getAparcamientoSillaruedas() {
		return aparcamientoSillaruedas;
	}

	/**
	 * Define el valor de la propiedad aparcamientoSillaruedas.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setAparcamientoSillaruedas(String value) {
		this.aparcamientoSillaruedas = value;
	}

	/**
	 * Obtiene el valor de la propiedad aparcamientoObservaciones.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "APARCAMIENTO_OBSERVACIONES", length = 255)
	public String getAparcamientoObservaciones() {
		return aparcamientoObservaciones;
	}

	/**
	 * Define el valor de la propiedad aparcamientoObservaciones.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setAparcamientoObservaciones(String value) {
		this.aparcamientoObservaciones = value;
	}

	/**
	 * Obtiene el valor de la propiedad plazasreservadasSillaruedas.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "PLAZASRESERVADAS_SILLARUEDAS", length = 255)
	public String getPlazasreservadasSillaruedas() {
		return plazasreservadasSillaruedas;
	}

	/**
	 * Define el valor de la propiedad plazasreservadasSillaruedas.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPlazasreservadasSillaruedas(String value) {
		this.plazasreservadasSillaruedas = value;
	}

	/**
	 * Obtiene el valor de la propiedad plazasreservadasDiscapacidadauditiva.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "PLAZASRESERVADAS_DISCAPACIDADAUDITIVA", length = 255)
	public String getPlazasreservadasDiscapacidadauditiva() {
		return plazasreservadasDiscapacidadauditiva;
	}

	/**
	 * Define el valor de la propiedad plazasreservadasDiscapacidadauditiva.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPlazasreservadasDiscapacidadauditiva(String value) {
		this.plazasreservadasDiscapacidadauditiva = value;
	}

	/**
	 * Obtiene el valor de la propiedad plazasreservadasZonaesperaSillaruedas.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "PLAZASRESERVADAS_ZONAESPERA_SILLARUEDAS", length = 255)
	public String getPlazasreservadasZonaesperaSillaruedas() {
		return plazasreservadasZonaesperaSillaruedas;
	}

	/**
	 * Define el valor de la propiedad plazasreservadasZonaesperaSillaruedas.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPlazasreservadasZonaesperaSillaruedas(String value) {
		this.plazasreservadasZonaesperaSillaruedas = value;
	}

	/**
	 * Obtiene el valor de la propiedad plazasreservadasObservaciones.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "PLAZASRESERVADAS_OBSERVACIONES", length = 255)
	public String getPlazasreservadasObservaciones() {
		return plazasreservadasObservaciones;
	}

	/**
	 * Define el valor de la propiedad plazasreservadasObservaciones.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPlazasreservadasObservaciones(String value) {
		this.plazasreservadasObservaciones = value;
	}

	/**
	 * Obtiene el valor de la propiedad piscinasEntradaaccesible.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "PISCINAS_ENTRADAACCESIBLE", length = 255)
	public String getPiscinasEntradaaccesible() {
		return piscinasEntradaaccesible;
	}

	/**
	 * Define el valor de la propiedad piscinasEntradaaccesible.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPiscinasEntradaaccesible(String value) {
		this.piscinasEntradaaccesible = value;
	}

	/**
	 * Obtiene el valor de la propiedad piscinasObservaciones.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "PISCINAS_OBSERVACIONES", length = 255)
	public String getPiscinasObservaciones() {
		return piscinasObservaciones;
	}

	/**
	 * Define el valor de la propiedad piscinasObservaciones.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPiscinasObservaciones(String value) {
		this.piscinasObservaciones = value;
	}

	/**
	 * Obtiene el valor de la propiedad servicioshigienicosAseoaccesible.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "SERVICIOSHIGIENICOS_ASEOACCESIBLE", length = 255)
	public String getServicioshigienicosAseoaccesible() {
		return servicioshigienicosAseoaccesible;
	}

	/**
	 * Define el valor de la propiedad servicioshigienicosAseoaccesible.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setServicioshigienicosAseoaccesible(String value) {
		this.servicioshigienicosAseoaccesible = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * servicioshigienicosCabinaduchaaccesibles.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "SERVICIOSHIGIENICOS_CABINADUCHAACCESIBLES", length = 255)
	public String getServicioshigienicosCabinaduchaaccesibles() {
		return servicioshigienicosCabinaduchaaccesibles;
	}

	/**
	 * Define el valor de la propiedad servicioshigienicosCabinaduchaaccesibles.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setServicioshigienicosCabinaduchaaccesibles(String value) {
		this.servicioshigienicosCabinaduchaaccesibles = value;
	}

	/**
	 * Obtiene el valor de la propiedad servicioshigienicosObservaciones.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "SERVICIOSHIGIENICOS_OBSERVACIONES", length = 255)
	public String getServicioshigienicosObservaciones() {
		return servicioshigienicosObservaciones;
	}

	/**
	 * Define el valor de la propiedad servicioshigienicosObservaciones.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setServicioshigienicosObservaciones(String value) {
		this.servicioshigienicosObservaciones = value;
	}

	/**
	 * Obtiene el valor de la propiedad mobiliariofijoPuntoaccesible.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "MOBILIARIOFIJO_PUNTOACCESIBLE", length = 255)
	public String getMobiliariofijoPuntoaccesible() {
		return mobiliariofijoPuntoaccesible;
	}

	/**
	 * Define el valor de la propiedad mobiliariofijoPuntoaccesible.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setMobiliariofijoPuntoaccesible(String value) {
		this.mobiliariofijoPuntoaccesible = value;
	}

	/**
	 * Obtiene el valor de la propiedad mobiliariofijoObservaciones.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "MOBILIARIOFIJO_OBSERVACIONES", length = 255)
	public String getMobiliariofijoObservaciones() {
		return mobiliariofijoObservaciones;
	}

	/**
	 * Define el valor de la propiedad mobiliariofijoObservaciones.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setMobiliariofijoObservaciones(String value) {
		this.mobiliariofijoObservaciones = value;
	}

	/**
	 * Obtiene el valor de la propiedad mecanismosAccesibles.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "MECANISMOS_ACCESIBLES", length = 255)
	public String getMecanismosAccesibles() {
		return mecanismosAccesibles;
	}

	/**
	 * Define el valor de la propiedad mecanismosAccesibles.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setMecanismosAccesibles(String value) {
		this.mecanismosAccesibles = value;
	}

	/**
	 * Obtiene el valor de la propiedad mecanismosObservaciones.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "MECANISMOS_OBSERVACIONES", length = 255)
	public String getMecanismosObservaciones() {
		return mecanismosObservaciones;
	}

	/**
	 * Define el valor de la propiedad mecanismosObservaciones.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setMecanismosObservaciones(String value) {
		this.mecanismosObservaciones = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * informacionsenalizacionPrivadoSiaEntradas.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "INFORMACIONSENALIZACION_PRIVADO_SIA_ENTRADAS", length = 255)
	public String getInformacionsenalizacionPrivadoSiaEntradas() {
		return informacionsenalizacionPrivadoSiaEntradas;
	}

	/**
	 * Define el valor de la propiedad
	 * informacionsenalizacionPrivadoSiaEntradas.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setInformacionsenalizacionPrivadoSiaEntradas(String value) {
		this.informacionsenalizacionPrivadoSiaEntradas = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * informacionsenalizacionPrivadoSiaItinerarios.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "INFORMACIONSENALIZACION_PRIVADO_SIA_ITINERARIOS", length = 255)
	public String getInformacionsenalizacionPrivadoSiaItinerarios() {
		return informacionsenalizacionPrivadoSiaItinerarios;
	}

	/**
	 * Define el valor de la propiedad
	 * informacionsenalizacionPrivadoSiaItinerarios.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setInformacionsenalizacionPrivadoSiaItinerarios(String value) {
		this.informacionsenalizacionPrivadoSiaItinerarios = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * informacionsenalizacionPrivadoSiaAscensores.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "INFORMACIONSENALIZACION_PRIVADO_SIA_ASCENSORES", length = 255)
	public String getInformacionsenalizacionPrivadoSiaAscensores() {
		return informacionsenalizacionPrivadoSiaAscensores;
	}

	/**
	 * Define el valor de la propiedad
	 * informacionsenalizacionPrivadoSiaAscensores.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setInformacionsenalizacionPrivadoSiaAscensores(String value) {
		this.informacionsenalizacionPrivadoSiaAscensores = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * informacionsenalizacionPrivadoSiaAparcamiento.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "INFORMACIONSENALIZACION_PRIVADO_SIA_APARCAMIENTO", length = 255)
	public String getInformacionsenalizacionPrivadoSiaAparcamiento() {
		return informacionsenalizacionPrivadoSiaAparcamiento;
	}

	/**
	 * Define el valor de la propiedad
	 * informacionsenalizacionPrivadoSiaAparcamiento.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setInformacionsenalizacionPrivadoSiaAparcamiento(String value) {
		this.informacionsenalizacionPrivadoSiaAparcamiento = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * informacionsenalizacionPrivadoSiaPlazasreservadas.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "INFORMACIONSENALIZACION_PRIVADO_SIA_PLAZASRESERVADAS", length = 255)
	public String getInformacionsenalizacionPrivadoSiaPlazasreservadas() {
		return informacionsenalizacionPrivadoSiaPlazasreservadas;
	}

	/**
	 * Define el valor de la propiedad
	 * informacionsenalizacionPrivadoSiaPlazasreservadas.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setInformacionsenalizacionPrivadoSiaPlazasreservadas(String value) {
		this.informacionsenalizacionPrivadoSiaPlazasreservadas = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * informacionsenalizacionPublicoSiaEntradas.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "INFORMACIONSENALIZACION_PUBLICO_SIA_ENTRADAS", length = 255)
	public String getInformacionsenalizacionPublicoSiaEntradas() {
		return informacionsenalizacionPublicoSiaEntradas;
	}

	/**
	 * Define el valor de la propiedad
	 * informacionsenalizacionPublicoSiaEntradas.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setInformacionsenalizacionPublicoSiaEntradas(String value) {
		this.informacionsenalizacionPublicoSiaEntradas = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * informacionsenalizacionPublicoSiaAscensores.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "INFORMACIONSENALIZACION_PUBLICO_SIA_ASCENSORES", length = 255)
	public String getInformacionsenalizacionPublicoSiaAscensores() {
		return informacionsenalizacionPublicoSiaAscensores;
	}

	/**
	 * Define el valor de la propiedad
	 * informacionsenalizacionPublicoSiaAscensores.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setInformacionsenalizacionPublicoSiaAscensores(String value) {
		this.informacionsenalizacionPublicoSiaAscensores = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * informacionsenalizacionPublicoSiaItinerarios.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "INFORMACIONSENALIZACION_PUBLICO_SIA_ITINERARIOS", length = 255)
	public String getInformacionsenalizacionPublicoSiaItinerarios() {
		return informacionsenalizacionPublicoSiaItinerarios;
	}

	/**
	 * Define el valor de la propiedad
	 * informacionsenalizacionPublicoSiaItinerarios.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setInformacionsenalizacionPublicoSiaItinerarios(String value) {
		this.informacionsenalizacionPublicoSiaItinerarios = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * informacionsenalizacionPublicoSiaAparcamiento.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "INFORMACIONSENALIZACION_PUBLICO_SIA_APARCAMIENTO", length = 255)
	public String getInformacionsenalizacionPublicoSiaAparcamiento() {
		return informacionsenalizacionPublicoSiaAparcamiento;
	}

	/**
	 * Define el valor de la propiedad
	 * informacionsenalizacionPublicoSiaAparcamiento.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setInformacionsenalizacionPublicoSiaAparcamiento(String value) {
		this.informacionsenalizacionPublicoSiaAparcamiento = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * informacionsenalizacionPublicoSiaPlazasreservadas.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "INFORMACIONSENALIZACION_PUBLICO_SIA_PLAZASRESERVADAS", length = 255)
	public String getInformacionsenalizacionPublicoSiaPlazasreservadas() {
		return informacionsenalizacionPublicoSiaPlazasreservadas;
	}

	/**
	 * Define el valor de la propiedad
	 * informacionsenalizacionPublicoSiaPlazasreservadas.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setInformacionsenalizacionPublicoSiaPlazasreservadas(String value) {
		this.informacionsenalizacionPublicoSiaPlazasreservadas = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * informacionsenalizacionPublicoSiaServicioshigienicos.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "INFORMACIONSENALIZACION_PUBLICO_SIA_SERVICIOSHIGIENICOS", length = 255)
	public String getInformacionsenalizacionPublicoSiaServicioshigienicos() {
		return informacionsenalizacionPublicoSiaServicioshigienicos;
	}

	/**
	 * Define el valor de la propiedad
	 * informacionsenalizacionPublicoSiaServicioshigienicos.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setInformacionsenalizacionPublicoSiaServicioshigienicos(String value) {
		this.informacionsenalizacionPublicoSiaServicioshigienicos = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * informacionsenalizacionPublicoSiaPuntosatencion.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "INFORMACIONSENALIZACION_PUBLICO_SIA_PUNTOSATENCION", length = 255)
	public String getInformacionsenalizacionPublicoSiaPuntosatencion() {
		return informacionsenalizacionPublicoSiaPuntosatencion;
	}

	/**
	 * Define el valor de la propiedad
	 * informacionsenalizacionPublicoSiaPuntosatencion.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setInformacionsenalizacionPublicoSiaPuntosatencion(String value) {
		this.informacionsenalizacionPublicoSiaPuntosatencion = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * informacionsenalizacionServicioshigienicossenalizados.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "INFORMACIONSENALIZACION_SERVICIOSHIGIENICOSSENALIZADOS", length = 255)
	public String getInformacionsenalizacionServicioshigienicossenalizados() {
		return informacionsenalizacionServicioshigienicossenalizados;
	}

	/**
	 * Define el valor de la propiedad
	 * informacionsenalizacionServicioshigienicossenalizados.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setInformacionsenalizacionServicioshigienicossenalizados(String value) {
		this.informacionsenalizacionServicioshigienicossenalizados = value;
	}

	/**
	 * Obtiene el valor de la propiedad informacionsenalizacionObservaciones.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "INFORMACIONSENALIZACION_OBSERVACIONES", length = 255)
	public String getInformacionsenalizacionObservaciones() {
		return informacionsenalizacionObservaciones;
	}

	/**
	 * Define el valor de la propiedad informacionsenalizacionObservaciones.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setInformacionsenalizacionObservaciones(String value) {
		this.informacionsenalizacionObservaciones = value;
	}

	/**
	 * Obtiene el valor de la propiedad informacionsenalizacionAscensores.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "INFORMACIONSENALIZACION_ASCENSORES", length = 255)
	public String getInformacionsenalizacionAscensores() {
		return informacionsenalizacionAscensores;
	}

	/**
	 * Define el valor de la propiedad informacionsenalizacionAscensores.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setInformacionsenalizacionAscensores(String value) {
		this.informacionsenalizacionAscensores = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * informacionsenalizacionAscensoresBrailearabigo.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "INFORMACIONSENALIZACION_ASCENSORES_BRAILEARABIGO", length = 255)
	public String getInformacionsenalizacionAscensoresBrailearabigo() {
		return informacionsenalizacionAscensoresBrailearabigo;
	}

	/**
	 * Define el valor de la propiedad
	 * informacionsenalizacionAscensoresBrailearabigo.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setInformacionsenalizacionAscensoresBrailearabigo(String value) {
		this.informacionsenalizacionAscensoresBrailearabigo = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * informacionsenalizacionAscensoresNumeroplanta.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "INFORMACIONSENALIZACION_ASCENSORES_NUMEROPLANTA", length = 255)
	public String getInformacionsenalizacionAscensoresNumeroplanta() {
		return informacionsenalizacionAscensoresNumeroplanta;
	}

	/**
	 * Define el valor de la propiedad
	 * informacionsenalizacionAscensoresNumeroplanta.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setInformacionsenalizacionAscensoresNumeroplanta(String value) {
		this.informacionsenalizacionAscensoresNumeroplanta = value;
	}

	/**
	 * Obtiene el valor de la propiedad informacionsenalizacionBuclemagnetico.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "INFORMACIONSENALIZACION_BUCLEMAGNETICO", length = 255)
	public String getInformacionsenalizacionBuclemagnetico() {
		return informacionsenalizacionBuclemagnetico;
	}

	/**
	 * Define el valor de la propiedad informacionsenalizacionBuclemagnetico.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setInformacionsenalizacionBuclemagnetico(String value) {
		this.informacionsenalizacionBuclemagnetico = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * informacionsenalizacionBuclemagneticoSenalizado.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "INFORMACIONSENALIZACION_BUCLEMAGNETICO_SENALIZADO", length = 255)
	public String getInformacionsenalizacionBuclemagneticoSenalizado() {
		return informacionsenalizacionBuclemagneticoSenalizado;
	}

	/**
	 * Define el valor de la propiedad
	 * informacionsenalizacionBuclemagneticoSenalizado.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setInformacionsenalizacionBuclemagneticoSenalizado(String value) {
		this.informacionsenalizacionBuclemagneticoSenalizado = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * informacionsenalizacionBandasvisualestactiles.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "INFORMACIONSENALIZACION_BANDASVISUALESTACTILES", length = 255)
	public String getInformacionsenalizacionBandasvisualestactiles() {
		return informacionsenalizacionBandasvisualestactiles;
	}

	/**
	 * Define el valor de la propiedad
	 * informacionsenalizacionBandasvisualestactiles.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setInformacionsenalizacionBandasvisualestactiles(String value) {
		this.informacionsenalizacionBandasvisualestactiles = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * informacionsenalizacionBandasvisualestactilesColorcontrastado.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "INFORMACIONSENALIZACION_BANDASVISUALESTACTILES_COLORCONTRASTADO", length = 255)
	public String getInformacionsenalizacionBandasvisualestactilesColorcontrastado() {
		return informacionsenalizacionBandasvisualestactilesColorcontrastado;
	}

	/**
	 * Define el valor de la propiedad
	 * informacionsenalizacionBandasvisualestactilesColorcontrastado.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setInformacionsenalizacionBandasvisualestactilesColorcontrastado(String value) {
		this.informacionsenalizacionBandasvisualestactilesColorcontrastado = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * informacionsenalizacionBandasvisualestactilesRelieveinterior.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "INFORMACIONSENALIZACION_BANDASVISUALESTACTILES_RELIEVEINTERIOR", length = 255)
	public String getInformacionsenalizacionBandasvisualestactilesRelieveinterior() {
		return informacionsenalizacionBandasvisualestactilesRelieveinterior;
	}

	/**
	 * Define el valor de la propiedad
	 * informacionsenalizacionBandasvisualestactilesRelieveinterior.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setInformacionsenalizacionBandasvisualestactilesRelieveinterior(String value) {
		this.informacionsenalizacionBandasvisualestactilesRelieveinterior = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * informacionsenalizacionBandasvisualestactilesRelieveexterior.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "INFORMACIONSENALIZACION_BANDASVISUALESTACTILES_RELIEVEEXTERIOR", length = 255)
	public String getInformacionsenalizacionBandasvisualestactilesRelieveexterior() {
		return informacionsenalizacionBandasvisualestactilesRelieveexterior;
	}

	/**
	 * Define el valor de la propiedad
	 * informacionsenalizacionBandasvisualestactilesRelieveexterior.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setInformacionsenalizacionBandasvisualestactilesRelieveexterior(String value) {
		this.informacionsenalizacionBandasvisualestactilesRelieveexterior = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * informacionsenalizacionBandasvisualestactilesArranqueescaleras.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "INFORMACIONSENALIZACION_BANDASVISUALESTACTILES_ARRANQUEESCALERAS", length = 255)
	public String getInformacionsenalizacionBandasvisualestactilesArranqueescaleras() {
		return informacionsenalizacionBandasvisualestactilesArranqueescaleras;
	}

	/**
	 * Define el valor de la propiedad
	 * informacionsenalizacionBandasvisualestactilesArranqueescaleras.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setInformacionsenalizacionBandasvisualestactilesArranqueescaleras(String value) {
		this.informacionsenalizacionBandasvisualestactilesArranqueescaleras = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * informacionsenalizacionBandasvisualestactilesItinerarioaccesib.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "INFORMACIONSENALIZACION_BANDASVISUALESTACTILES_ITINERARIOACCESIB", length = 255)
	public String getInformacionsenalizacionBandasvisualestactilesItinerarioaccesib() {
		return informacionsenalizacionBandasvisualestactilesItinerarioaccesib;
	}

	/**
	 * Define el valor de la propiedad
	 * informacionsenalizacionBandasvisualestactilesItinerarioaccesib.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setInformacionsenalizacionBandasvisualestactilesItinerarioaccesib(String value) {
		this.informacionsenalizacionBandasvisualestactilesItinerarioaccesib = value;
	}

	/**
	 * Obtiene el valor de la propiedad informacionsenalizacionSianorma.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "INFORMACIONSENALIZACION_SIANORMA", length = 255)
	public String getInformacionsenalizacionSianorma() {
		return informacionsenalizacionSianorma;
	}

	/**
	 * Define el valor de la propiedad informacionsenalizacionSianorma.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setInformacionsenalizacionSianorma(String value) {
		this.informacionsenalizacionSianorma = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * informacionsenalizacionTodosusosObservaciones.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "INFORMACIONSENALIZACION_TODOSUSOS_OBSERVACIONES", length = 255)
	public String getInformacionsenalizacionTodosusosObservaciones() {
		return informacionsenalizacionTodosusosObservaciones;
	}

	/**
	 * Define el valor de la propiedad
	 * informacionsenalizacionTodosusosObservaciones.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setInformacionsenalizacionTodosusosObservaciones(String value) {
		this.informacionsenalizacionTodosusosObservaciones = value;
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
		final AccesibilidadPublicosType that = ((AccesibilidadPublicosType) object);
		{
			int lhsExteriorEdificioitinerarioaccesibleViapublica;
			lhsExteriorEdificioitinerarioaccesibleViapublica = this.getExteriorEdificioitinerarioaccesibleViapublica();
			int rhsExteriorEdificioitinerarioaccesibleViapublica;
			rhsExteriorEdificioitinerarioaccesibleViapublica = that.getExteriorEdificioitinerarioaccesibleViapublica();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "exteriorEdificioitinerarioaccesibleViapublica", lhsExteriorEdificioitinerarioaccesibleViapublica), LocatorUtils.property(thatLocator, "exteriorEdificioitinerarioaccesibleViapublica", rhsExteriorEdificioitinerarioaccesibleViapublica), lhsExteriorEdificioitinerarioaccesibleViapublica, rhsExteriorEdificioitinerarioaccesibleViapublica)) {
				return false;
			}
		}
		{
			int lhsExteriorEdificioitinerarioaccesibleZonascomunes;
			lhsExteriorEdificioitinerarioaccesibleZonascomunes = this.getExteriorEdificioitinerarioaccesibleZonascomunes();
			int rhsExteriorEdificioitinerarioaccesibleZonascomunes;
			rhsExteriorEdificioitinerarioaccesibleZonascomunes = that.getExteriorEdificioitinerarioaccesibleZonascomunes();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "exteriorEdificioitinerarioaccesibleZonascomunes", lhsExteriorEdificioitinerarioaccesibleZonascomunes), LocatorUtils.property(thatLocator, "exteriorEdificioitinerarioaccesibleZonascomunes", rhsExteriorEdificioitinerarioaccesibleZonascomunes), lhsExteriorEdificioitinerarioaccesibleZonascomunes, rhsExteriorEdificioitinerarioaccesibleZonascomunes)) {
				return false;
			}
		}
		{
			String lhsExteriorObservaciones;
			lhsExteriorObservaciones = this.getExteriorObservaciones();
			String rhsExteriorObservaciones;
			rhsExteriorObservaciones = that.getExteriorObservaciones();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "exteriorObservaciones", lhsExteriorObservaciones), LocatorUtils.property(thatLocator, "exteriorObservaciones", rhsExteriorObservaciones), lhsExteriorObservaciones, rhsExteriorObservaciones)) {
				return false;
			}
		}
		{
			int lhsEntreplantasAccesible;
			lhsEntreplantasAccesible = this.getEntreplantasAccesible();
			int rhsEntreplantasAccesible;
			rhsEntreplantasAccesible = that.getEntreplantasAccesible();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "entreplantasAccesible", lhsEntreplantasAccesible), LocatorUtils.property(thatLocator, "entreplantasAccesible", rhsEntreplantasAccesible), lhsEntreplantasAccesible, rhsEntreplantasAccesible)) {
				return false;
			}
		}
		{
			String lhsEntreplantasAccesibleAscensororampaaccesible;
			lhsEntreplantasAccesibleAscensororampaaccesible = this.getEntreplantasAccesibleAscensororampaaccesible();
			String rhsEntreplantasAccesibleAscensororampaaccesible;
			rhsEntreplantasAccesibleAscensororampaaccesible = that.getEntreplantasAccesibleAscensororampaaccesible();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "entreplantasAccesibleAscensororampaaccesible", lhsEntreplantasAccesibleAscensororampaaccesible), LocatorUtils.property(thatLocator, "entreplantasAccesibleAscensororampaaccesible", rhsEntreplantasAccesibleAscensororampaaccesible), lhsEntreplantasAccesibleAscensororampaaccesible, rhsEntreplantasAccesibleAscensororampaaccesible)) {
				return false;
			}
		}
		{
			String lhsEntreplantasAccesibleAscensornoaccesible;
			lhsEntreplantasAccesibleAscensornoaccesible = this.getEntreplantasAccesibleAscensornoaccesible();
			String rhsEntreplantasAccesibleAscensornoaccesible;
			rhsEntreplantasAccesibleAscensornoaccesible = that.getEntreplantasAccesibleAscensornoaccesible();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "entreplantasAccesibleAscensornoaccesible", lhsEntreplantasAccesibleAscensornoaccesible), LocatorUtils.property(thatLocator, "entreplantasAccesibleAscensornoaccesible", rhsEntreplantasAccesibleAscensornoaccesible), lhsEntreplantasAccesibleAscensornoaccesible, rhsEntreplantasAccesibleAscensornoaccesible)) {
				return false;
			}
		}
		{
			String lhsEntreplantasAccesibleAscensornoaccesibleDimensiones;
			lhsEntreplantasAccesibleAscensornoaccesibleDimensiones = this.getEntreplantasAccesibleAscensornoaccesibleDimensiones();
			String rhsEntreplantasAccesibleAscensornoaccesibleDimensiones;
			rhsEntreplantasAccesibleAscensornoaccesibleDimensiones = that.getEntreplantasAccesibleAscensornoaccesibleDimensiones();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "entreplantasAccesibleAscensornoaccesibleDimensiones", lhsEntreplantasAccesibleAscensornoaccesibleDimensiones), LocatorUtils.property(thatLocator, "entreplantasAccesibleAscensornoaccesibleDimensiones", rhsEntreplantasAccesibleAscensornoaccesibleDimensiones), lhsEntreplantasAccesibleAscensornoaccesibleDimensiones, rhsEntreplantasAccesibleAscensornoaccesibleDimensiones)) {
				return false;
			}
		}
		{
			String lhsEntreplantasAccesibleRampaascensornoaccesible;
			lhsEntreplantasAccesibleRampaascensornoaccesible = this.getEntreplantasAccesibleRampaascensornoaccesible();
			String rhsEntreplantasAccesibleRampaascensornoaccesible;
			rhsEntreplantasAccesibleRampaascensornoaccesible = that.getEntreplantasAccesibleRampaascensornoaccesible();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "entreplantasAccesibleRampaascensornoaccesible", lhsEntreplantasAccesibleRampaascensornoaccesible), LocatorUtils.property(thatLocator, "entreplantasAccesibleRampaascensornoaccesible", rhsEntreplantasAccesibleRampaascensornoaccesible), lhsEntreplantasAccesibleRampaascensornoaccesible, rhsEntreplantasAccesibleRampaascensornoaccesible)) {
				return false;
			}
		}
		{
			int lhsEntreplantasNoaccesible;
			lhsEntreplantasNoaccesible = this.getEntreplantasNoaccesible();
			int rhsEntreplantasNoaccesible;
			rhsEntreplantasNoaccesible = that.getEntreplantasNoaccesible();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "entreplantasNoaccesible", lhsEntreplantasNoaccesible), LocatorUtils.property(thatLocator, "entreplantasNoaccesible", rhsEntreplantasNoaccesible), lhsEntreplantasNoaccesible, rhsEntreplantasNoaccesible)) {
				return false;
			}
		}
		{
			String lhsEntreplantasNoaccesibleAscensororampaaccesible;
			lhsEntreplantasNoaccesibleAscensororampaaccesible = this.getEntreplantasNoaccesibleAscensororampaaccesible();
			String rhsEntreplantasNoaccesibleAscensororampaaccesible;
			rhsEntreplantasNoaccesibleAscensororampaaccesible = that.getEntreplantasNoaccesibleAscensororampaaccesible();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "entreplantasNoaccesibleAscensororampaaccesible", lhsEntreplantasNoaccesibleAscensororampaaccesible), LocatorUtils.property(thatLocator, "entreplantasNoaccesibleAscensororampaaccesible", rhsEntreplantasNoaccesibleAscensororampaaccesible), lhsEntreplantasNoaccesibleAscensororampaaccesible, rhsEntreplantasNoaccesibleAscensororampaaccesible)) {
				return false;
			}
		}
		{
			String lhsEntreplantasNoaccesibleAscensornoaccesible;
			lhsEntreplantasNoaccesibleAscensornoaccesible = this.getEntreplantasNoaccesibleAscensornoaccesible();
			String rhsEntreplantasNoaccesibleAscensornoaccesible;
			rhsEntreplantasNoaccesibleAscensornoaccesible = that.getEntreplantasNoaccesibleAscensornoaccesible();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "entreplantasNoaccesibleAscensornoaccesible", lhsEntreplantasNoaccesibleAscensornoaccesible), LocatorUtils.property(thatLocator, "entreplantasNoaccesibleAscensornoaccesible", rhsEntreplantasNoaccesibleAscensornoaccesible), lhsEntreplantasNoaccesibleAscensornoaccesible, rhsEntreplantasNoaccesibleAscensornoaccesible)) {
				return false;
			}
		}
		{
			String lhsEntreplantasNoaccesibleAscensornoaccesibleDimensiones;
			lhsEntreplantasNoaccesibleAscensornoaccesibleDimensiones = this.getEntreplantasNoaccesibleAscensornoaccesibleDimensiones();
			String rhsEntreplantasNoaccesibleAscensornoaccesibleDimensiones;
			rhsEntreplantasNoaccesibleAscensornoaccesibleDimensiones = that.getEntreplantasNoaccesibleAscensornoaccesibleDimensiones();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "entreplantasNoaccesibleAscensornoaccesibleDimensiones", lhsEntreplantasNoaccesibleAscensornoaccesibleDimensiones), LocatorUtils.property(thatLocator, "entreplantasNoaccesibleAscensornoaccesibleDimensiones", rhsEntreplantasNoaccesibleAscensornoaccesibleDimensiones), lhsEntreplantasNoaccesibleAscensornoaccesibleDimensiones, rhsEntreplantasNoaccesibleAscensornoaccesibleDimensiones)) {
				return false;
			}
		}
		{
			String lhsEntreplantasNoaccesibleRampaascensornoaccesible;
			lhsEntreplantasNoaccesibleRampaascensornoaccesible = this.getEntreplantasNoaccesibleRampaascensornoaccesible();
			String rhsEntreplantasNoaccesibleRampaascensornoaccesible;
			rhsEntreplantasNoaccesibleRampaascensornoaccesible = that.getEntreplantasNoaccesibleRampaascensornoaccesible();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "entreplantasNoaccesibleRampaascensornoaccesible", lhsEntreplantasNoaccesibleRampaascensornoaccesible), LocatorUtils.property(thatLocator, "entreplantasNoaccesibleRampaascensornoaccesible", rhsEntreplantasNoaccesibleRampaascensornoaccesible), lhsEntreplantasNoaccesibleRampaascensornoaccesible, rhsEntreplantasNoaccesibleRampaascensornoaccesible)) {
				return false;
			}
		}
		{
			int lhsEntreplantasElementosaccesibles;
			lhsEntreplantasElementosaccesibles = this.getEntreplantasElementosaccesibles();
			int rhsEntreplantasElementosaccesibles;
			rhsEntreplantasElementosaccesibles = that.getEntreplantasElementosaccesibles();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "entreplantasElementosaccesibles", lhsEntreplantasElementosaccesibles), LocatorUtils.property(thatLocator, "entreplantasElementosaccesibles", rhsEntreplantasElementosaccesibles), lhsEntreplantasElementosaccesibles, rhsEntreplantasElementosaccesibles)) {
				return false;
			}
		}
		{
			String lhsEntreplantasElementosaccesiblesAscensororampaaccesible;
			lhsEntreplantasElementosaccesiblesAscensororampaaccesible = this.getEntreplantasElementosaccesiblesAscensororampaaccesible();
			String rhsEntreplantasElementosaccesiblesAscensororampaaccesible;
			rhsEntreplantasElementosaccesiblesAscensororampaaccesible = that.getEntreplantasElementosaccesiblesAscensororampaaccesible();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "entreplantasElementosaccesiblesAscensororampaaccesible", lhsEntreplantasElementosaccesiblesAscensororampaaccesible), LocatorUtils.property(thatLocator, "entreplantasElementosaccesiblesAscensororampaaccesible", rhsEntreplantasElementosaccesiblesAscensororampaaccesible), lhsEntreplantasElementosaccesiblesAscensororampaaccesible, rhsEntreplantasElementosaccesiblesAscensororampaaccesible)) {
				return false;
			}
		}
		{
			String lhsEntreplantasElementosaccesiblesAscensornoaccesible;
			lhsEntreplantasElementosaccesiblesAscensornoaccesible = this.getEntreplantasElementosaccesiblesAscensornoaccesible();
			String rhsEntreplantasElementosaccesiblesAscensornoaccesible;
			rhsEntreplantasElementosaccesiblesAscensornoaccesible = that.getEntreplantasElementosaccesiblesAscensornoaccesible();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "entreplantasElementosaccesiblesAscensornoaccesible", lhsEntreplantasElementosaccesiblesAscensornoaccesible), LocatorUtils.property(thatLocator, "entreplantasElementosaccesiblesAscensornoaccesible", rhsEntreplantasElementosaccesiblesAscensornoaccesible), lhsEntreplantasElementosaccesiblesAscensornoaccesible, rhsEntreplantasElementosaccesiblesAscensornoaccesible)) {
				return false;
			}
		}
		{
			String lhsEntreplantasElementosaccesiblesAscensornoaccesibleDimensiones;
			lhsEntreplantasElementosaccesiblesAscensornoaccesibleDimensiones = this.getEntreplantasElementosaccesiblesAscensornoaccesibleDimensiones();
			String rhsEntreplantasElementosaccesiblesAscensornoaccesibleDimensiones;
			rhsEntreplantasElementosaccesiblesAscensornoaccesibleDimensiones = that.getEntreplantasElementosaccesiblesAscensornoaccesibleDimensiones();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "entreplantasElementosaccesiblesAscensornoaccesibleDimensiones", lhsEntreplantasElementosaccesiblesAscensornoaccesibleDimensiones), LocatorUtils.property(thatLocator, "entreplantasElementosaccesiblesAscensornoaccesibleDimensiones", rhsEntreplantasElementosaccesiblesAscensornoaccesibleDimensiones), lhsEntreplantasElementosaccesiblesAscensornoaccesibleDimensiones, rhsEntreplantasElementosaccesiblesAscensornoaccesibleDimensiones)) {
				return false;
			}
		}
		{
			String lhsEntreplantasElementosaccesiblesRampaascensornoaccesible;
			lhsEntreplantasElementosaccesiblesRampaascensornoaccesible = this.getEntreplantasElementosaccesiblesRampaascensornoaccesible();
			String rhsEntreplantasElementosaccesiblesRampaascensornoaccesible;
			rhsEntreplantasElementosaccesiblesRampaascensornoaccesible = that.getEntreplantasElementosaccesiblesRampaascensornoaccesible();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "entreplantasElementosaccesiblesRampaascensornoaccesible", lhsEntreplantasElementosaccesiblesRampaascensornoaccesible), LocatorUtils.property(thatLocator, "entreplantasElementosaccesiblesRampaascensornoaccesible", rhsEntreplantasElementosaccesiblesRampaascensornoaccesible), lhsEntreplantasElementosaccesiblesRampaascensornoaccesible, rhsEntreplantasElementosaccesiblesRampaascensornoaccesible)) {
				return false;
			}
		}
		{
			int lhsEntreplantasZonasusopublico;
			lhsEntreplantasZonasusopublico = this.getEntreplantasZonasusopublico();
			int rhsEntreplantasZonasusopublico;
			rhsEntreplantasZonasusopublico = that.getEntreplantasZonasusopublico();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "entreplantasZonasusopublico", lhsEntreplantasZonasusopublico), LocatorUtils.property(thatLocator, "entreplantasZonasusopublico", rhsEntreplantasZonasusopublico), lhsEntreplantasZonasusopublico, rhsEntreplantasZonasusopublico)) {
				return false;
			}
		}
		{
			String lhsEntreplantasZonasusopublicoAscensororampaaccesible;
			lhsEntreplantasZonasusopublicoAscensororampaaccesible = this.getEntreplantasZonasusopublicoAscensororampaaccesible();
			String rhsEntreplantasZonasusopublicoAscensororampaaccesible;
			rhsEntreplantasZonasusopublicoAscensororampaaccesible = that.getEntreplantasZonasusopublicoAscensororampaaccesible();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "entreplantasZonasusopublicoAscensororampaaccesible", lhsEntreplantasZonasusopublicoAscensororampaaccesible), LocatorUtils.property(thatLocator, "entreplantasZonasusopublicoAscensororampaaccesible", rhsEntreplantasZonasusopublicoAscensororampaaccesible), lhsEntreplantasZonasusopublicoAscensororampaaccesible, rhsEntreplantasZonasusopublicoAscensororampaaccesible)) {
				return false;
			}
		}
		{
			String lhsEntreplantasZonasusopublicoAscensornoaccesible;
			lhsEntreplantasZonasusopublicoAscensornoaccesible = this.getEntreplantasZonasusopublicoAscensornoaccesible();
			String rhsEntreplantasZonasusopublicoAscensornoaccesible;
			rhsEntreplantasZonasusopublicoAscensornoaccesible = that.getEntreplantasZonasusopublicoAscensornoaccesible();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "entreplantasZonasusopublicoAscensornoaccesible", lhsEntreplantasZonasusopublicoAscensornoaccesible), LocatorUtils.property(thatLocator, "entreplantasZonasusopublicoAscensornoaccesible", rhsEntreplantasZonasusopublicoAscensornoaccesible), lhsEntreplantasZonasusopublicoAscensornoaccesible, rhsEntreplantasZonasusopublicoAscensornoaccesible)) {
				return false;
			}
		}
		{
			String lhsEntreplantasZonasusopublicoAscensornoaccesibleDimensiones;
			lhsEntreplantasZonasusopublicoAscensornoaccesibleDimensiones = this.getEntreplantasZonasusopublicoAscensornoaccesibleDimensiones();
			String rhsEntreplantasZonasusopublicoAscensornoaccesibleDimensiones;
			rhsEntreplantasZonasusopublicoAscensornoaccesibleDimensiones = that.getEntreplantasZonasusopublicoAscensornoaccesibleDimensiones();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "entreplantasZonasusopublicoAscensornoaccesibleDimensiones", lhsEntreplantasZonasusopublicoAscensornoaccesibleDimensiones), LocatorUtils.property(thatLocator, "entreplantasZonasusopublicoAscensornoaccesibleDimensiones", rhsEntreplantasZonasusopublicoAscensornoaccesibleDimensiones), lhsEntreplantasZonasusopublicoAscensornoaccesibleDimensiones, rhsEntreplantasZonasusopublicoAscensornoaccesibleDimensiones)) {
				return false;
			}
		}
		{
			String lhsEntreplantasZonasusopublicoRampaascensornoaccesible;
			lhsEntreplantasZonasusopublicoRampaascensornoaccesible = this.getEntreplantasZonasusopublicoRampaascensornoaccesible();
			String rhsEntreplantasZonasusopublicoRampaascensornoaccesible;
			rhsEntreplantasZonasusopublicoRampaascensornoaccesible = that.getEntreplantasZonasusopublicoRampaascensornoaccesible();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "entreplantasZonasusopublicoRampaascensornoaccesible", lhsEntreplantasZonasusopublicoRampaascensornoaccesible), LocatorUtils.property(thatLocator, "entreplantasZonasusopublicoRampaascensornoaccesible", rhsEntreplantasZonasusopublicoRampaascensornoaccesible), lhsEntreplantasZonasusopublicoRampaascensornoaccesible, rhsEntreplantasZonasusopublicoRampaascensornoaccesible)) {
				return false;
			}
		}
		{
			String lhsEntreplantasObservaciones;
			lhsEntreplantasObservaciones = this.getEntreplantasObservaciones();
			String rhsEntreplantasObservaciones;
			rhsEntreplantasObservaciones = that.getEntreplantasObservaciones();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "entreplantasObservaciones", lhsEntreplantasObservaciones), LocatorUtils.property(thatLocator, "entreplantasObservaciones", rhsEntreplantasObservaciones), lhsEntreplantasObservaciones, rhsEntreplantasObservaciones)) {
				return false;
			}
		}
		{
			int lhsPlantasItinerarioaccesibleEntresi;
			lhsPlantasItinerarioaccesibleEntresi = this.getPlantasItinerarioaccesibleEntresi();
			int rhsPlantasItinerarioaccesibleEntresi;
			rhsPlantasItinerarioaccesibleEntresi = that.getPlantasItinerarioaccesibleEntresi();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "plantasItinerarioaccesibleEntresi", lhsPlantasItinerarioaccesibleEntresi), LocatorUtils.property(thatLocator, "plantasItinerarioaccesibleEntresi", rhsPlantasItinerarioaccesibleEntresi), lhsPlantasItinerarioaccesibleEntresi, rhsPlantasItinerarioaccesibleEntresi)) {
				return false;
			}
		}
		{
			int lhsPlantasItinerarioaccesibleZonasusopublico;
			lhsPlantasItinerarioaccesibleZonasusopublico = this.getPlantasItinerarioaccesibleZonasusopublico();
			int rhsPlantasItinerarioaccesibleZonasusopublico;
			rhsPlantasItinerarioaccesibleZonasusopublico = that.getPlantasItinerarioaccesibleZonasusopublico();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "plantasItinerarioaccesibleZonasusopublico", lhsPlantasItinerarioaccesibleZonasusopublico), LocatorUtils.property(thatLocator, "plantasItinerarioaccesibleZonasusopublico", rhsPlantasItinerarioaccesibleZonasusopublico), lhsPlantasItinerarioaccesibleZonasusopublico, rhsPlantasItinerarioaccesibleZonasusopublico)) {
				return false;
			}
		}
		{
			int lhsPlantasItinerarioaccesibleElementosaccesibles;
			lhsPlantasItinerarioaccesibleElementosaccesibles = this.getPlantasItinerarioaccesibleElementosaccesibles();
			int rhsPlantasItinerarioaccesibleElementosaccesibles;
			rhsPlantasItinerarioaccesibleElementosaccesibles = that.getPlantasItinerarioaccesibleElementosaccesibles();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "plantasItinerarioaccesibleElementosaccesibles", lhsPlantasItinerarioaccesibleElementosaccesibles), LocatorUtils.property(thatLocator, "plantasItinerarioaccesibleElementosaccesibles", rhsPlantasItinerarioaccesibleElementosaccesibles), lhsPlantasItinerarioaccesibleElementosaccesibles, rhsPlantasItinerarioaccesibleElementosaccesibles)) {
				return false;
			}
		}
		{
			int lhsPlantasItinerarioaccesibleZonasusoprivado;
			lhsPlantasItinerarioaccesibleZonasusoprivado = this.getPlantasItinerarioaccesibleZonasusoprivado();
			int rhsPlantasItinerarioaccesibleZonasusoprivado;
			rhsPlantasItinerarioaccesibleZonasusoprivado = that.getPlantasItinerarioaccesibleZonasusoprivado();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "plantasItinerarioaccesibleZonasusoprivado", lhsPlantasItinerarioaccesibleZonasusoprivado), LocatorUtils.property(thatLocator, "plantasItinerarioaccesibleZonasusoprivado", rhsPlantasItinerarioaccesibleZonasusoprivado), lhsPlantasItinerarioaccesibleZonasusoprivado, rhsPlantasItinerarioaccesibleZonasusoprivado)) {
				return false;
			}
		}
		{
			String lhsPlantasItinerarioaccesibleObservaciones;
			lhsPlantasItinerarioaccesibleObservaciones = this.getPlantasItinerarioaccesibleObservaciones();
			String rhsPlantasItinerarioaccesibleObservaciones;
			rhsPlantasItinerarioaccesibleObservaciones = that.getPlantasItinerarioaccesibleObservaciones();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "plantasItinerarioaccesibleObservaciones", lhsPlantasItinerarioaccesibleObservaciones), LocatorUtils.property(thatLocator, "plantasItinerarioaccesibleObservaciones", rhsPlantasItinerarioaccesibleObservaciones), lhsPlantasItinerarioaccesibleObservaciones, rhsPlantasItinerarioaccesibleObservaciones)) {
				return false;
			}
		}
		{
			String lhsAlojamientosaccesiblesMinimo1;
			lhsAlojamientosaccesiblesMinimo1 = this.getAlojamientosaccesiblesMinimo1();
			String rhsAlojamientosaccesiblesMinimo1;
			rhsAlojamientosaccesiblesMinimo1 = that.getAlojamientosaccesiblesMinimo1();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "alojamientosaccesiblesMinimo1", lhsAlojamientosaccesiblesMinimo1), LocatorUtils.property(thatLocator, "alojamientosaccesiblesMinimo1", rhsAlojamientosaccesiblesMinimo1), lhsAlojamientosaccesiblesMinimo1, rhsAlojamientosaccesiblesMinimo1)) {
				return false;
			}
		}
		{
			String lhsAlojamientosaccesiblesMinimo2;
			lhsAlojamientosaccesiblesMinimo2 = this.getAlojamientosaccesiblesMinimo2();
			String rhsAlojamientosaccesiblesMinimo2;
			rhsAlojamientosaccesiblesMinimo2 = that.getAlojamientosaccesiblesMinimo2();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "alojamientosaccesiblesMinimo2", lhsAlojamientosaccesiblesMinimo2), LocatorUtils.property(thatLocator, "alojamientosaccesiblesMinimo2", rhsAlojamientosaccesiblesMinimo2), lhsAlojamientosaccesiblesMinimo2, rhsAlojamientosaccesiblesMinimo2)) {
				return false;
			}
		}
		{
			String lhsAlojamientosaccesiblesMinimo4;
			lhsAlojamientosaccesiblesMinimo4 = this.getAlojamientosaccesiblesMinimo4();
			String rhsAlojamientosaccesiblesMinimo4;
			rhsAlojamientosaccesiblesMinimo4 = that.getAlojamientosaccesiblesMinimo4();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "alojamientosaccesiblesMinimo4", lhsAlojamientosaccesiblesMinimo4), LocatorUtils.property(thatLocator, "alojamientosaccesiblesMinimo4", rhsAlojamientosaccesiblesMinimo4), lhsAlojamientosaccesiblesMinimo4, rhsAlojamientosaccesiblesMinimo4)) {
				return false;
			}
		}
		{
			String lhsAlojamientosaccesiblesMinimo6;
			lhsAlojamientosaccesiblesMinimo6 = this.getAlojamientosaccesiblesMinimo6();
			String rhsAlojamientosaccesiblesMinimo6;
			rhsAlojamientosaccesiblesMinimo6 = that.getAlojamientosaccesiblesMinimo6();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "alojamientosaccesiblesMinimo6", lhsAlojamientosaccesiblesMinimo6), LocatorUtils.property(thatLocator, "alojamientosaccesiblesMinimo6", rhsAlojamientosaccesiblesMinimo6), lhsAlojamientosaccesiblesMinimo6, rhsAlojamientosaccesiblesMinimo6)) {
				return false;
			}
		}
		{
			String lhsAlojamientosaccesiblesMinimo8;
			lhsAlojamientosaccesiblesMinimo8 = this.getAlojamientosaccesiblesMinimo8();
			String rhsAlojamientosaccesiblesMinimo8;
			rhsAlojamientosaccesiblesMinimo8 = that.getAlojamientosaccesiblesMinimo8();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "alojamientosaccesiblesMinimo8", lhsAlojamientosaccesiblesMinimo8), LocatorUtils.property(thatLocator, "alojamientosaccesiblesMinimo8", rhsAlojamientosaccesiblesMinimo8), lhsAlojamientosaccesiblesMinimo8, rhsAlojamientosaccesiblesMinimo8)) {
				return false;
			}
		}
		{
			String lhsAlojamientosaccesibles1Porcada50;
			lhsAlojamientosaccesibles1Porcada50 = this.getAlojamientosaccesibles1Porcada50();
			String rhsAlojamientosaccesibles1Porcada50;
			rhsAlojamientosaccesibles1Porcada50 = that.getAlojamientosaccesibles1Porcada50();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "alojamientosaccesibles1Porcada50", lhsAlojamientosaccesibles1Porcada50), LocatorUtils.property(thatLocator, "alojamientosaccesibles1Porcada50", rhsAlojamientosaccesibles1Porcada50), lhsAlojamientosaccesibles1Porcada50, rhsAlojamientosaccesibles1Porcada50)) {
				return false;
			}
		}
		{
			String lhsAlojamientosaccesiblesObservaciones;
			lhsAlojamientosaccesiblesObservaciones = this.getAlojamientosaccesiblesObservaciones();
			String rhsAlojamientosaccesiblesObservaciones;
			rhsAlojamientosaccesiblesObservaciones = that.getAlojamientosaccesiblesObservaciones();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "alojamientosaccesiblesObservaciones", lhsAlojamientosaccesiblesObservaciones), LocatorUtils.property(thatLocator, "alojamientosaccesiblesObservaciones", rhsAlojamientosaccesiblesObservaciones), lhsAlojamientosaccesiblesObservaciones, rhsAlojamientosaccesiblesObservaciones)) {
				return false;
			}
		}
		{
			String lhsAparcamientoResidencialpublicoPoralojamiento;
			lhsAparcamientoResidencialpublicoPoralojamiento = this.getAparcamientoResidencialpublicoPoralojamiento();
			String rhsAparcamientoResidencialpublicoPoralojamiento;
			rhsAparcamientoResidencialpublicoPoralojamiento = that.getAparcamientoResidencialpublicoPoralojamiento();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "aparcamientoResidencialpublicoPoralojamiento", lhsAparcamientoResidencialpublicoPoralojamiento), LocatorUtils.property(thatLocator, "aparcamientoResidencialpublicoPoralojamiento", rhsAparcamientoResidencialpublicoPoralojamiento), lhsAparcamientoResidencialpublicoPoralojamiento, rhsAparcamientoResidencialpublicoPoralojamiento)) {
				return false;
			}
		}
		{
			String lhsAparcamientoComercialPorfraccion;
			lhsAparcamientoComercialPorfraccion = this.getAparcamientoComercialPorfraccion();
			String rhsAparcamientoComercialPorfraccion;
			rhsAparcamientoComercialPorfraccion = that.getAparcamientoComercialPorfraccion();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "aparcamientoComercialPorfraccion", lhsAparcamientoComercialPorfraccion), LocatorUtils.property(thatLocator, "aparcamientoComercialPorfraccion", rhsAparcamientoComercialPorfraccion), lhsAparcamientoComercialPorfraccion, rhsAparcamientoComercialPorfraccion)) {
				return false;
			}
		}
		{
			String lhsAparcamientoOtrosusosMinimoaparcamientosUnaporfraccion;
			lhsAparcamientoOtrosusosMinimoaparcamientosUnaporfraccion = this.getAparcamientoOtrosusosMinimoaparcamientosUnaporfraccion();
			String rhsAparcamientoOtrosusosMinimoaparcamientosUnaporfraccion;
			rhsAparcamientoOtrosusosMinimoaparcamientosUnaporfraccion = that.getAparcamientoOtrosusosMinimoaparcamientosUnaporfraccion();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "aparcamientoOtrosusosMinimoaparcamientosUnaporfraccion", lhsAparcamientoOtrosusosMinimoaparcamientosUnaporfraccion), LocatorUtils.property(thatLocator, "aparcamientoOtrosusosMinimoaparcamientosUnaporfraccion", rhsAparcamientoOtrosusosMinimoaparcamientosUnaporfraccion), lhsAparcamientoOtrosusosMinimoaparcamientosUnaporfraccion, rhsAparcamientoOtrosusosMinimoaparcamientosUnaporfraccion)) {
				return false;
			}
		}
		{
			String lhsAparcamientoOtrosusosMinimoaparcamientosUnamasporfraccion;
			lhsAparcamientoOtrosusosMinimoaparcamientosUnamasporfraccion = this.getAparcamientoOtrosusosMinimoaparcamientosUnamasporfraccion();
			String rhsAparcamientoOtrosusosMinimoaparcamientosUnamasporfraccion;
			rhsAparcamientoOtrosusosMinimoaparcamientosUnamasporfraccion = that.getAparcamientoOtrosusosMinimoaparcamientosUnamasporfraccion();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "aparcamientoOtrosusosMinimoaparcamientosUnamasporfraccion", lhsAparcamientoOtrosusosMinimoaparcamientosUnamasporfraccion), LocatorUtils.property(thatLocator, "aparcamientoOtrosusosMinimoaparcamientosUnamasporfraccion", rhsAparcamientoOtrosusosMinimoaparcamientosUnamasporfraccion), lhsAparcamientoOtrosusosMinimoaparcamientosUnamasporfraccion, rhsAparcamientoOtrosusosMinimoaparcamientosUnamasporfraccion)) {
				return false;
			}
		}
		{
			String lhsAparcamientoSillaruedas;
			lhsAparcamientoSillaruedas = this.getAparcamientoSillaruedas();
			String rhsAparcamientoSillaruedas;
			rhsAparcamientoSillaruedas = that.getAparcamientoSillaruedas();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "aparcamientoSillaruedas", lhsAparcamientoSillaruedas), LocatorUtils.property(thatLocator, "aparcamientoSillaruedas", rhsAparcamientoSillaruedas), lhsAparcamientoSillaruedas, rhsAparcamientoSillaruedas)) {
				return false;
			}
		}
		{
			String lhsAparcamientoObservaciones;
			lhsAparcamientoObservaciones = this.getAparcamientoObservaciones();
			String rhsAparcamientoObservaciones;
			rhsAparcamientoObservaciones = that.getAparcamientoObservaciones();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "aparcamientoObservaciones", lhsAparcamientoObservaciones), LocatorUtils.property(thatLocator, "aparcamientoObservaciones", rhsAparcamientoObservaciones), lhsAparcamientoObservaciones, rhsAparcamientoObservaciones)) {
				return false;
			}
		}
		{
			String lhsPlazasreservadasSillaruedas;
			lhsPlazasreservadasSillaruedas = this.getPlazasreservadasSillaruedas();
			String rhsPlazasreservadasSillaruedas;
			rhsPlazasreservadasSillaruedas = that.getPlazasreservadasSillaruedas();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "plazasreservadasSillaruedas", lhsPlazasreservadasSillaruedas), LocatorUtils.property(thatLocator, "plazasreservadasSillaruedas", rhsPlazasreservadasSillaruedas), lhsPlazasreservadasSillaruedas, rhsPlazasreservadasSillaruedas)) {
				return false;
			}
		}
		{
			String lhsPlazasreservadasDiscapacidadauditiva;
			lhsPlazasreservadasDiscapacidadauditiva = this.getPlazasreservadasDiscapacidadauditiva();
			String rhsPlazasreservadasDiscapacidadauditiva;
			rhsPlazasreservadasDiscapacidadauditiva = that.getPlazasreservadasDiscapacidadauditiva();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "plazasreservadasDiscapacidadauditiva", lhsPlazasreservadasDiscapacidadauditiva), LocatorUtils.property(thatLocator, "plazasreservadasDiscapacidadauditiva", rhsPlazasreservadasDiscapacidadauditiva), lhsPlazasreservadasDiscapacidadauditiva, rhsPlazasreservadasDiscapacidadauditiva)) {
				return false;
			}
		}
		{
			String lhsPlazasreservadasZonaesperaSillaruedas;
			lhsPlazasreservadasZonaesperaSillaruedas = this.getPlazasreservadasZonaesperaSillaruedas();
			String rhsPlazasreservadasZonaesperaSillaruedas;
			rhsPlazasreservadasZonaesperaSillaruedas = that.getPlazasreservadasZonaesperaSillaruedas();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "plazasreservadasZonaesperaSillaruedas", lhsPlazasreservadasZonaesperaSillaruedas), LocatorUtils.property(thatLocator, "plazasreservadasZonaesperaSillaruedas", rhsPlazasreservadasZonaesperaSillaruedas), lhsPlazasreservadasZonaesperaSillaruedas, rhsPlazasreservadasZonaesperaSillaruedas)) {
				return false;
			}
		}
		{
			String lhsPlazasreservadasObservaciones;
			lhsPlazasreservadasObservaciones = this.getPlazasreservadasObservaciones();
			String rhsPlazasreservadasObservaciones;
			rhsPlazasreservadasObservaciones = that.getPlazasreservadasObservaciones();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "plazasreservadasObservaciones", lhsPlazasreservadasObservaciones), LocatorUtils.property(thatLocator, "plazasreservadasObservaciones", rhsPlazasreservadasObservaciones), lhsPlazasreservadasObservaciones, rhsPlazasreservadasObservaciones)) {
				return false;
			}
		}
		{
			String lhsPiscinasEntradaaccesible;
			lhsPiscinasEntradaaccesible = this.getPiscinasEntradaaccesible();
			String rhsPiscinasEntradaaccesible;
			rhsPiscinasEntradaaccesible = that.getPiscinasEntradaaccesible();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "piscinasEntradaaccesible", lhsPiscinasEntradaaccesible), LocatorUtils.property(thatLocator, "piscinasEntradaaccesible", rhsPiscinasEntradaaccesible), lhsPiscinasEntradaaccesible, rhsPiscinasEntradaaccesible)) {
				return false;
			}
		}
		{
			String lhsPiscinasObservaciones;
			lhsPiscinasObservaciones = this.getPiscinasObservaciones();
			String rhsPiscinasObservaciones;
			rhsPiscinasObservaciones = that.getPiscinasObservaciones();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "piscinasObservaciones", lhsPiscinasObservaciones), LocatorUtils.property(thatLocator, "piscinasObservaciones", rhsPiscinasObservaciones), lhsPiscinasObservaciones, rhsPiscinasObservaciones)) {
				return false;
			}
		}
		{
			String lhsServicioshigienicosAseoaccesible;
			lhsServicioshigienicosAseoaccesible = this.getServicioshigienicosAseoaccesible();
			String rhsServicioshigienicosAseoaccesible;
			rhsServicioshigienicosAseoaccesible = that.getServicioshigienicosAseoaccesible();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "servicioshigienicosAseoaccesible", lhsServicioshigienicosAseoaccesible), LocatorUtils.property(thatLocator, "servicioshigienicosAseoaccesible", rhsServicioshigienicosAseoaccesible), lhsServicioshigienicosAseoaccesible, rhsServicioshigienicosAseoaccesible)) {
				return false;
			}
		}
		{
			String lhsServicioshigienicosCabinaduchaaccesibles;
			lhsServicioshigienicosCabinaduchaaccesibles = this.getServicioshigienicosCabinaduchaaccesibles();
			String rhsServicioshigienicosCabinaduchaaccesibles;
			rhsServicioshigienicosCabinaduchaaccesibles = that.getServicioshigienicosCabinaduchaaccesibles();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "servicioshigienicosCabinaduchaaccesibles", lhsServicioshigienicosCabinaduchaaccesibles), LocatorUtils.property(thatLocator, "servicioshigienicosCabinaduchaaccesibles", rhsServicioshigienicosCabinaduchaaccesibles), lhsServicioshigienicosCabinaduchaaccesibles, rhsServicioshigienicosCabinaduchaaccesibles)) {
				return false;
			}
		}
		{
			String lhsServicioshigienicosObservaciones;
			lhsServicioshigienicosObservaciones = this.getServicioshigienicosObservaciones();
			String rhsServicioshigienicosObservaciones;
			rhsServicioshigienicosObservaciones = that.getServicioshigienicosObservaciones();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "servicioshigienicosObservaciones", lhsServicioshigienicosObservaciones), LocatorUtils.property(thatLocator, "servicioshigienicosObservaciones", rhsServicioshigienicosObservaciones), lhsServicioshigienicosObservaciones, rhsServicioshigienicosObservaciones)) {
				return false;
			}
		}
		{
			String lhsMobiliariofijoPuntoaccesible;
			lhsMobiliariofijoPuntoaccesible = this.getMobiliariofijoPuntoaccesible();
			String rhsMobiliariofijoPuntoaccesible;
			rhsMobiliariofijoPuntoaccesible = that.getMobiliariofijoPuntoaccesible();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "mobiliariofijoPuntoaccesible", lhsMobiliariofijoPuntoaccesible), LocatorUtils.property(thatLocator, "mobiliariofijoPuntoaccesible", rhsMobiliariofijoPuntoaccesible), lhsMobiliariofijoPuntoaccesible, rhsMobiliariofijoPuntoaccesible)) {
				return false;
			}
		}
		{
			String lhsMobiliariofijoObservaciones;
			lhsMobiliariofijoObservaciones = this.getMobiliariofijoObservaciones();
			String rhsMobiliariofijoObservaciones;
			rhsMobiliariofijoObservaciones = that.getMobiliariofijoObservaciones();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "mobiliariofijoObservaciones", lhsMobiliariofijoObservaciones), LocatorUtils.property(thatLocator, "mobiliariofijoObservaciones", rhsMobiliariofijoObservaciones), lhsMobiliariofijoObservaciones, rhsMobiliariofijoObservaciones)) {
				return false;
			}
		}
		{
			String lhsMecanismosAccesibles;
			lhsMecanismosAccesibles = this.getMecanismosAccesibles();
			String rhsMecanismosAccesibles;
			rhsMecanismosAccesibles = that.getMecanismosAccesibles();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "mecanismosAccesibles", lhsMecanismosAccesibles), LocatorUtils.property(thatLocator, "mecanismosAccesibles", rhsMecanismosAccesibles), lhsMecanismosAccesibles, rhsMecanismosAccesibles)) {
				return false;
			}
		}
		{
			String lhsMecanismosObservaciones;
			lhsMecanismosObservaciones = this.getMecanismosObservaciones();
			String rhsMecanismosObservaciones;
			rhsMecanismosObservaciones = that.getMecanismosObservaciones();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "mecanismosObservaciones", lhsMecanismosObservaciones), LocatorUtils.property(thatLocator, "mecanismosObservaciones", rhsMecanismosObservaciones), lhsMecanismosObservaciones, rhsMecanismosObservaciones)) {
				return false;
			}
		}
		{
			String lhsInformacionsenalizacionPrivadoSiaEntradas;
			lhsInformacionsenalizacionPrivadoSiaEntradas = this.getInformacionsenalizacionPrivadoSiaEntradas();
			String rhsInformacionsenalizacionPrivadoSiaEntradas;
			rhsInformacionsenalizacionPrivadoSiaEntradas = that.getInformacionsenalizacionPrivadoSiaEntradas();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "informacionsenalizacionPrivadoSiaEntradas", lhsInformacionsenalizacionPrivadoSiaEntradas), LocatorUtils.property(thatLocator, "informacionsenalizacionPrivadoSiaEntradas", rhsInformacionsenalizacionPrivadoSiaEntradas), lhsInformacionsenalizacionPrivadoSiaEntradas, rhsInformacionsenalizacionPrivadoSiaEntradas)) {
				return false;
			}
		}
		{
			String lhsInformacionsenalizacionPrivadoSiaItinerarios;
			lhsInformacionsenalizacionPrivadoSiaItinerarios = this.getInformacionsenalizacionPrivadoSiaItinerarios();
			String rhsInformacionsenalizacionPrivadoSiaItinerarios;
			rhsInformacionsenalizacionPrivadoSiaItinerarios = that.getInformacionsenalizacionPrivadoSiaItinerarios();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "informacionsenalizacionPrivadoSiaItinerarios", lhsInformacionsenalizacionPrivadoSiaItinerarios), LocatorUtils.property(thatLocator, "informacionsenalizacionPrivadoSiaItinerarios", rhsInformacionsenalizacionPrivadoSiaItinerarios), lhsInformacionsenalizacionPrivadoSiaItinerarios, rhsInformacionsenalizacionPrivadoSiaItinerarios)) {
				return false;
			}
		}
		{
			String lhsInformacionsenalizacionPrivadoSiaAscensores;
			lhsInformacionsenalizacionPrivadoSiaAscensores = this.getInformacionsenalizacionPrivadoSiaAscensores();
			String rhsInformacionsenalizacionPrivadoSiaAscensores;
			rhsInformacionsenalizacionPrivadoSiaAscensores = that.getInformacionsenalizacionPrivadoSiaAscensores();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "informacionsenalizacionPrivadoSiaAscensores", lhsInformacionsenalizacionPrivadoSiaAscensores), LocatorUtils.property(thatLocator, "informacionsenalizacionPrivadoSiaAscensores", rhsInformacionsenalizacionPrivadoSiaAscensores), lhsInformacionsenalizacionPrivadoSiaAscensores, rhsInformacionsenalizacionPrivadoSiaAscensores)) {
				return false;
			}
		}
		{
			String lhsInformacionsenalizacionPrivadoSiaAparcamiento;
			lhsInformacionsenalizacionPrivadoSiaAparcamiento = this.getInformacionsenalizacionPrivadoSiaAparcamiento();
			String rhsInformacionsenalizacionPrivadoSiaAparcamiento;
			rhsInformacionsenalizacionPrivadoSiaAparcamiento = that.getInformacionsenalizacionPrivadoSiaAparcamiento();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "informacionsenalizacionPrivadoSiaAparcamiento", lhsInformacionsenalizacionPrivadoSiaAparcamiento), LocatorUtils.property(thatLocator, "informacionsenalizacionPrivadoSiaAparcamiento", rhsInformacionsenalizacionPrivadoSiaAparcamiento), lhsInformacionsenalizacionPrivadoSiaAparcamiento, rhsInformacionsenalizacionPrivadoSiaAparcamiento)) {
				return false;
			}
		}
		{
			String lhsInformacionsenalizacionPrivadoSiaPlazasreservadas;
			lhsInformacionsenalizacionPrivadoSiaPlazasreservadas = this.getInformacionsenalizacionPrivadoSiaPlazasreservadas();
			String rhsInformacionsenalizacionPrivadoSiaPlazasreservadas;
			rhsInformacionsenalizacionPrivadoSiaPlazasreservadas = that.getInformacionsenalizacionPrivadoSiaPlazasreservadas();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "informacionsenalizacionPrivadoSiaPlazasreservadas", lhsInformacionsenalizacionPrivadoSiaPlazasreservadas), LocatorUtils.property(thatLocator, "informacionsenalizacionPrivadoSiaPlazasreservadas", rhsInformacionsenalizacionPrivadoSiaPlazasreservadas), lhsInformacionsenalizacionPrivadoSiaPlazasreservadas, rhsInformacionsenalizacionPrivadoSiaPlazasreservadas)) {
				return false;
			}
		}
		{
			String lhsInformacionsenalizacionPublicoSiaEntradas;
			lhsInformacionsenalizacionPublicoSiaEntradas = this.getInformacionsenalizacionPublicoSiaEntradas();
			String rhsInformacionsenalizacionPublicoSiaEntradas;
			rhsInformacionsenalizacionPublicoSiaEntradas = that.getInformacionsenalizacionPublicoSiaEntradas();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "informacionsenalizacionPublicoSiaEntradas", lhsInformacionsenalizacionPublicoSiaEntradas), LocatorUtils.property(thatLocator, "informacionsenalizacionPublicoSiaEntradas", rhsInformacionsenalizacionPublicoSiaEntradas), lhsInformacionsenalizacionPublicoSiaEntradas, rhsInformacionsenalizacionPublicoSiaEntradas)) {
				return false;
			}
		}
		{
			String lhsInformacionsenalizacionPublicoSiaAscensores;
			lhsInformacionsenalizacionPublicoSiaAscensores = this.getInformacionsenalizacionPublicoSiaAscensores();
			String rhsInformacionsenalizacionPublicoSiaAscensores;
			rhsInformacionsenalizacionPublicoSiaAscensores = that.getInformacionsenalizacionPublicoSiaAscensores();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "informacionsenalizacionPublicoSiaAscensores", lhsInformacionsenalizacionPublicoSiaAscensores), LocatorUtils.property(thatLocator, "informacionsenalizacionPublicoSiaAscensores", rhsInformacionsenalizacionPublicoSiaAscensores), lhsInformacionsenalizacionPublicoSiaAscensores, rhsInformacionsenalizacionPublicoSiaAscensores)) {
				return false;
			}
		}
		{
			String lhsInformacionsenalizacionPublicoSiaItinerarios;
			lhsInformacionsenalizacionPublicoSiaItinerarios = this.getInformacionsenalizacionPublicoSiaItinerarios();
			String rhsInformacionsenalizacionPublicoSiaItinerarios;
			rhsInformacionsenalizacionPublicoSiaItinerarios = that.getInformacionsenalizacionPublicoSiaItinerarios();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "informacionsenalizacionPublicoSiaItinerarios", lhsInformacionsenalizacionPublicoSiaItinerarios), LocatorUtils.property(thatLocator, "informacionsenalizacionPublicoSiaItinerarios", rhsInformacionsenalizacionPublicoSiaItinerarios), lhsInformacionsenalizacionPublicoSiaItinerarios, rhsInformacionsenalizacionPublicoSiaItinerarios)) {
				return false;
			}
		}
		{
			String lhsInformacionsenalizacionPublicoSiaAparcamiento;
			lhsInformacionsenalizacionPublicoSiaAparcamiento = this.getInformacionsenalizacionPublicoSiaAparcamiento();
			String rhsInformacionsenalizacionPublicoSiaAparcamiento;
			rhsInformacionsenalizacionPublicoSiaAparcamiento = that.getInformacionsenalizacionPublicoSiaAparcamiento();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "informacionsenalizacionPublicoSiaAparcamiento", lhsInformacionsenalizacionPublicoSiaAparcamiento), LocatorUtils.property(thatLocator, "informacionsenalizacionPublicoSiaAparcamiento", rhsInformacionsenalizacionPublicoSiaAparcamiento), lhsInformacionsenalizacionPublicoSiaAparcamiento, rhsInformacionsenalizacionPublicoSiaAparcamiento)) {
				return false;
			}
		}
		{
			String lhsInformacionsenalizacionPublicoSiaPlazasreservadas;
			lhsInformacionsenalizacionPublicoSiaPlazasreservadas = this.getInformacionsenalizacionPublicoSiaPlazasreservadas();
			String rhsInformacionsenalizacionPublicoSiaPlazasreservadas;
			rhsInformacionsenalizacionPublicoSiaPlazasreservadas = that.getInformacionsenalizacionPublicoSiaPlazasreservadas();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "informacionsenalizacionPublicoSiaPlazasreservadas", lhsInformacionsenalizacionPublicoSiaPlazasreservadas), LocatorUtils.property(thatLocator, "informacionsenalizacionPublicoSiaPlazasreservadas", rhsInformacionsenalizacionPublicoSiaPlazasreservadas), lhsInformacionsenalizacionPublicoSiaPlazasreservadas, rhsInformacionsenalizacionPublicoSiaPlazasreservadas)) {
				return false;
			}
		}
		{
			String lhsInformacionsenalizacionPublicoSiaServicioshigienicos;
			lhsInformacionsenalizacionPublicoSiaServicioshigienicos = this.getInformacionsenalizacionPublicoSiaServicioshigienicos();
			String rhsInformacionsenalizacionPublicoSiaServicioshigienicos;
			rhsInformacionsenalizacionPublicoSiaServicioshigienicos = that.getInformacionsenalizacionPublicoSiaServicioshigienicos();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "informacionsenalizacionPublicoSiaServicioshigienicos", lhsInformacionsenalizacionPublicoSiaServicioshigienicos), LocatorUtils.property(thatLocator, "informacionsenalizacionPublicoSiaServicioshigienicos", rhsInformacionsenalizacionPublicoSiaServicioshigienicos), lhsInformacionsenalizacionPublicoSiaServicioshigienicos, rhsInformacionsenalizacionPublicoSiaServicioshigienicos)) {
				return false;
			}
		}
		{
			String lhsInformacionsenalizacionPublicoSiaPuntosatencion;
			lhsInformacionsenalizacionPublicoSiaPuntosatencion = this.getInformacionsenalizacionPublicoSiaPuntosatencion();
			String rhsInformacionsenalizacionPublicoSiaPuntosatencion;
			rhsInformacionsenalizacionPublicoSiaPuntosatencion = that.getInformacionsenalizacionPublicoSiaPuntosatencion();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "informacionsenalizacionPublicoSiaPuntosatencion", lhsInformacionsenalizacionPublicoSiaPuntosatencion), LocatorUtils.property(thatLocator, "informacionsenalizacionPublicoSiaPuntosatencion", rhsInformacionsenalizacionPublicoSiaPuntosatencion), lhsInformacionsenalizacionPublicoSiaPuntosatencion, rhsInformacionsenalizacionPublicoSiaPuntosatencion)) {
				return false;
			}
		}
		{
			String lhsInformacionsenalizacionServicioshigienicossenalizados;
			lhsInformacionsenalizacionServicioshigienicossenalizados = this.getInformacionsenalizacionServicioshigienicossenalizados();
			String rhsInformacionsenalizacionServicioshigienicossenalizados;
			rhsInformacionsenalizacionServicioshigienicossenalizados = that.getInformacionsenalizacionServicioshigienicossenalizados();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "informacionsenalizacionServicioshigienicossenalizados", lhsInformacionsenalizacionServicioshigienicossenalizados), LocatorUtils.property(thatLocator, "informacionsenalizacionServicioshigienicossenalizados", rhsInformacionsenalizacionServicioshigienicossenalizados), lhsInformacionsenalizacionServicioshigienicossenalizados, rhsInformacionsenalizacionServicioshigienicossenalizados)) {
				return false;
			}
		}
		{
			String lhsInformacionsenalizacionObservaciones;
			lhsInformacionsenalizacionObservaciones = this.getInformacionsenalizacionObservaciones();
			String rhsInformacionsenalizacionObservaciones;
			rhsInformacionsenalizacionObservaciones = that.getInformacionsenalizacionObservaciones();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "informacionsenalizacionObservaciones", lhsInformacionsenalizacionObservaciones), LocatorUtils.property(thatLocator, "informacionsenalizacionObservaciones", rhsInformacionsenalizacionObservaciones), lhsInformacionsenalizacionObservaciones, rhsInformacionsenalizacionObservaciones)) {
				return false;
			}
		}
		{
			String lhsInformacionsenalizacionAscensores;
			lhsInformacionsenalizacionAscensores = this.getInformacionsenalizacionAscensores();
			String rhsInformacionsenalizacionAscensores;
			rhsInformacionsenalizacionAscensores = that.getInformacionsenalizacionAscensores();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "informacionsenalizacionAscensores", lhsInformacionsenalizacionAscensores), LocatorUtils.property(thatLocator, "informacionsenalizacionAscensores", rhsInformacionsenalizacionAscensores), lhsInformacionsenalizacionAscensores, rhsInformacionsenalizacionAscensores)) {
				return false;
			}
		}
		{
			String lhsInformacionsenalizacionAscensoresBrailearabigo;
			lhsInformacionsenalizacionAscensoresBrailearabigo = this.getInformacionsenalizacionAscensoresBrailearabigo();
			String rhsInformacionsenalizacionAscensoresBrailearabigo;
			rhsInformacionsenalizacionAscensoresBrailearabigo = that.getInformacionsenalizacionAscensoresBrailearabigo();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "informacionsenalizacionAscensoresBrailearabigo", lhsInformacionsenalizacionAscensoresBrailearabigo), LocatorUtils.property(thatLocator, "informacionsenalizacionAscensoresBrailearabigo", rhsInformacionsenalizacionAscensoresBrailearabigo), lhsInformacionsenalizacionAscensoresBrailearabigo, rhsInformacionsenalizacionAscensoresBrailearabigo)) {
				return false;
			}
		}
		{
			String lhsInformacionsenalizacionAscensoresNumeroplanta;
			lhsInformacionsenalizacionAscensoresNumeroplanta = this.getInformacionsenalizacionAscensoresNumeroplanta();
			String rhsInformacionsenalizacionAscensoresNumeroplanta;
			rhsInformacionsenalizacionAscensoresNumeroplanta = that.getInformacionsenalizacionAscensoresNumeroplanta();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "informacionsenalizacionAscensoresNumeroplanta", lhsInformacionsenalizacionAscensoresNumeroplanta), LocatorUtils.property(thatLocator, "informacionsenalizacionAscensoresNumeroplanta", rhsInformacionsenalizacionAscensoresNumeroplanta), lhsInformacionsenalizacionAscensoresNumeroplanta, rhsInformacionsenalizacionAscensoresNumeroplanta)) {
				return false;
			}
		}
		{
			String lhsInformacionsenalizacionBuclemagnetico;
			lhsInformacionsenalizacionBuclemagnetico = this.getInformacionsenalizacionBuclemagnetico();
			String rhsInformacionsenalizacionBuclemagnetico;
			rhsInformacionsenalizacionBuclemagnetico = that.getInformacionsenalizacionBuclemagnetico();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "informacionsenalizacionBuclemagnetico", lhsInformacionsenalizacionBuclemagnetico), LocatorUtils.property(thatLocator, "informacionsenalizacionBuclemagnetico", rhsInformacionsenalizacionBuclemagnetico), lhsInformacionsenalizacionBuclemagnetico, rhsInformacionsenalizacionBuclemagnetico)) {
				return false;
			}
		}
		{
			String lhsInformacionsenalizacionBuclemagneticoSenalizado;
			lhsInformacionsenalizacionBuclemagneticoSenalizado = this.getInformacionsenalizacionBuclemagneticoSenalizado();
			String rhsInformacionsenalizacionBuclemagneticoSenalizado;
			rhsInformacionsenalizacionBuclemagneticoSenalizado = that.getInformacionsenalizacionBuclemagneticoSenalizado();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "informacionsenalizacionBuclemagneticoSenalizado", lhsInformacionsenalizacionBuclemagneticoSenalizado), LocatorUtils.property(thatLocator, "informacionsenalizacionBuclemagneticoSenalizado", rhsInformacionsenalizacionBuclemagneticoSenalizado), lhsInformacionsenalizacionBuclemagneticoSenalizado, rhsInformacionsenalizacionBuclemagneticoSenalizado)) {
				return false;
			}
		}
		{
			String lhsInformacionsenalizacionBandasvisualestactiles;
			lhsInformacionsenalizacionBandasvisualestactiles = this.getInformacionsenalizacionBandasvisualestactiles();
			String rhsInformacionsenalizacionBandasvisualestactiles;
			rhsInformacionsenalizacionBandasvisualestactiles = that.getInformacionsenalizacionBandasvisualestactiles();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "informacionsenalizacionBandasvisualestactiles", lhsInformacionsenalizacionBandasvisualestactiles), LocatorUtils.property(thatLocator, "informacionsenalizacionBandasvisualestactiles", rhsInformacionsenalizacionBandasvisualestactiles), lhsInformacionsenalizacionBandasvisualestactiles, rhsInformacionsenalizacionBandasvisualestactiles)) {
				return false;
			}
		}
		{
			String lhsInformacionsenalizacionBandasvisualestactilesColorcontrastado;
			lhsInformacionsenalizacionBandasvisualestactilesColorcontrastado = this.getInformacionsenalizacionBandasvisualestactilesColorcontrastado();
			String rhsInformacionsenalizacionBandasvisualestactilesColorcontrastado;
			rhsInformacionsenalizacionBandasvisualestactilesColorcontrastado = that.getInformacionsenalizacionBandasvisualestactilesColorcontrastado();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "informacionsenalizacionBandasvisualestactilesColorcontrastado", lhsInformacionsenalizacionBandasvisualestactilesColorcontrastado), LocatorUtils.property(thatLocator, "informacionsenalizacionBandasvisualestactilesColorcontrastado", rhsInformacionsenalizacionBandasvisualestactilesColorcontrastado), lhsInformacionsenalizacionBandasvisualestactilesColorcontrastado, rhsInformacionsenalizacionBandasvisualestactilesColorcontrastado)) {
				return false;
			}
		}
		{
			String lhsInformacionsenalizacionBandasvisualestactilesRelieveinterior;
			lhsInformacionsenalizacionBandasvisualestactilesRelieveinterior = this.getInformacionsenalizacionBandasvisualestactilesRelieveinterior();
			String rhsInformacionsenalizacionBandasvisualestactilesRelieveinterior;
			rhsInformacionsenalizacionBandasvisualestactilesRelieveinterior = that.getInformacionsenalizacionBandasvisualestactilesRelieveinterior();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "informacionsenalizacionBandasvisualestactilesRelieveinterior", lhsInformacionsenalizacionBandasvisualestactilesRelieveinterior), LocatorUtils.property(thatLocator, "informacionsenalizacionBandasvisualestactilesRelieveinterior", rhsInformacionsenalizacionBandasvisualestactilesRelieveinterior), lhsInformacionsenalizacionBandasvisualestactilesRelieveinterior, rhsInformacionsenalizacionBandasvisualestactilesRelieveinterior)) {
				return false;
			}
		}
		{
			String lhsInformacionsenalizacionBandasvisualestactilesRelieveexterior;
			lhsInformacionsenalizacionBandasvisualestactilesRelieveexterior = this.getInformacionsenalizacionBandasvisualestactilesRelieveexterior();
			String rhsInformacionsenalizacionBandasvisualestactilesRelieveexterior;
			rhsInformacionsenalizacionBandasvisualestactilesRelieveexterior = that.getInformacionsenalizacionBandasvisualestactilesRelieveexterior();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "informacionsenalizacionBandasvisualestactilesRelieveexterior", lhsInformacionsenalizacionBandasvisualestactilesRelieveexterior), LocatorUtils.property(thatLocator, "informacionsenalizacionBandasvisualestactilesRelieveexterior", rhsInformacionsenalizacionBandasvisualestactilesRelieveexterior), lhsInformacionsenalizacionBandasvisualestactilesRelieveexterior, rhsInformacionsenalizacionBandasvisualestactilesRelieveexterior)) {
				return false;
			}
		}
		{
			String lhsInformacionsenalizacionBandasvisualestactilesArranqueescaleras;
			lhsInformacionsenalizacionBandasvisualestactilesArranqueescaleras = this.getInformacionsenalizacionBandasvisualestactilesArranqueescaleras();
			String rhsInformacionsenalizacionBandasvisualestactilesArranqueescaleras;
			rhsInformacionsenalizacionBandasvisualestactilesArranqueescaleras = that.getInformacionsenalizacionBandasvisualestactilesArranqueescaleras();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "informacionsenalizacionBandasvisualestactilesArranqueescaleras", lhsInformacionsenalizacionBandasvisualestactilesArranqueescaleras), LocatorUtils.property(thatLocator, "informacionsenalizacionBandasvisualestactilesArranqueescaleras", rhsInformacionsenalizacionBandasvisualestactilesArranqueescaleras), lhsInformacionsenalizacionBandasvisualestactilesArranqueescaleras, rhsInformacionsenalizacionBandasvisualestactilesArranqueescaleras)) {
				return false;
			}
		}
		{
			String lhsInformacionsenalizacionBandasvisualestactilesItinerarioaccesib;
			lhsInformacionsenalizacionBandasvisualestactilesItinerarioaccesib = this.getInformacionsenalizacionBandasvisualestactilesItinerarioaccesib();
			String rhsInformacionsenalizacionBandasvisualestactilesItinerarioaccesib;
			rhsInformacionsenalizacionBandasvisualestactilesItinerarioaccesib = that.getInformacionsenalizacionBandasvisualestactilesItinerarioaccesib();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "informacionsenalizacionBandasvisualestactilesItinerarioaccesib", lhsInformacionsenalizacionBandasvisualestactilesItinerarioaccesib), LocatorUtils.property(thatLocator, "informacionsenalizacionBandasvisualestactilesItinerarioaccesib", rhsInformacionsenalizacionBandasvisualestactilesItinerarioaccesib), lhsInformacionsenalizacionBandasvisualestactilesItinerarioaccesib, rhsInformacionsenalizacionBandasvisualestactilesItinerarioaccesib)) {
				return false;
			}
		}
		{
			String lhsInformacionsenalizacionSianorma;
			lhsInformacionsenalizacionSianorma = this.getInformacionsenalizacionSianorma();
			String rhsInformacionsenalizacionSianorma;
			rhsInformacionsenalizacionSianorma = that.getInformacionsenalizacionSianorma();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "informacionsenalizacionSianorma", lhsInformacionsenalizacionSianorma), LocatorUtils.property(thatLocator, "informacionsenalizacionSianorma", rhsInformacionsenalizacionSianorma), lhsInformacionsenalizacionSianorma, rhsInformacionsenalizacionSianorma)) {
				return false;
			}
		}
		{
			String lhsInformacionsenalizacionTodosusosObservaciones;
			lhsInformacionsenalizacionTodosusosObservaciones = this.getInformacionsenalizacionTodosusosObservaciones();
			String rhsInformacionsenalizacionTodosusosObservaciones;
			rhsInformacionsenalizacionTodosusosObservaciones = that.getInformacionsenalizacionTodosusosObservaciones();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "informacionsenalizacionTodosusosObservaciones", lhsInformacionsenalizacionTodosusosObservaciones), LocatorUtils.property(thatLocator, "informacionsenalizacionTodosusosObservaciones", rhsInformacionsenalizacionTodosusosObservaciones), lhsInformacionsenalizacionTodosusosObservaciones, rhsInformacionsenalizacionTodosusosObservaciones)) {
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
		return true;
	}

	public boolean equals(Object object) {
		final EqualsStrategy strategy = JAXBEqualsStrategy.INSTANCE;
		return equals(null, null, object, strategy);
	}

	public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
		int currentHashCode = 1;
		{
			int theExteriorEdificioitinerarioaccesibleViapublica;
			theExteriorEdificioitinerarioaccesibleViapublica = this.getExteriorEdificioitinerarioaccesibleViapublica();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "exteriorEdificioitinerarioaccesibleViapublica", theExteriorEdificioitinerarioaccesibleViapublica), currentHashCode, theExteriorEdificioitinerarioaccesibleViapublica);
		}
		{
			int theExteriorEdificioitinerarioaccesibleZonascomunes;
			theExteriorEdificioitinerarioaccesibleZonascomunes = this.getExteriorEdificioitinerarioaccesibleZonascomunes();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "exteriorEdificioitinerarioaccesibleZonascomunes", theExteriorEdificioitinerarioaccesibleZonascomunes), currentHashCode, theExteriorEdificioitinerarioaccesibleZonascomunes);
		}
		{
			String theExteriorObservaciones;
			theExteriorObservaciones = this.getExteriorObservaciones();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "exteriorObservaciones", theExteriorObservaciones), currentHashCode, theExteriorObservaciones);
		}
		{
			int theEntreplantasAccesible;
			theEntreplantasAccesible = this.getEntreplantasAccesible();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "entreplantasAccesible", theEntreplantasAccesible), currentHashCode, theEntreplantasAccesible);
		}
		{
			String theEntreplantasAccesibleAscensororampaaccesible;
			theEntreplantasAccesibleAscensororampaaccesible = this.getEntreplantasAccesibleAscensororampaaccesible();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "entreplantasAccesibleAscensororampaaccesible", theEntreplantasAccesibleAscensororampaaccesible), currentHashCode, theEntreplantasAccesibleAscensororampaaccesible);
		}
		{
			String theEntreplantasAccesibleAscensornoaccesible;
			theEntreplantasAccesibleAscensornoaccesible = this.getEntreplantasAccesibleAscensornoaccesible();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "entreplantasAccesibleAscensornoaccesible", theEntreplantasAccesibleAscensornoaccesible), currentHashCode, theEntreplantasAccesibleAscensornoaccesible);
		}
		{
			String theEntreplantasAccesibleAscensornoaccesibleDimensiones;
			theEntreplantasAccesibleAscensornoaccesibleDimensiones = this.getEntreplantasAccesibleAscensornoaccesibleDimensiones();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "entreplantasAccesibleAscensornoaccesibleDimensiones", theEntreplantasAccesibleAscensornoaccesibleDimensiones), currentHashCode, theEntreplantasAccesibleAscensornoaccesibleDimensiones);
		}
		{
			String theEntreplantasAccesibleRampaascensornoaccesible;
			theEntreplantasAccesibleRampaascensornoaccesible = this.getEntreplantasAccesibleRampaascensornoaccesible();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "entreplantasAccesibleRampaascensornoaccesible", theEntreplantasAccesibleRampaascensornoaccesible), currentHashCode, theEntreplantasAccesibleRampaascensornoaccesible);
		}
		{
			int theEntreplantasNoaccesible;
			theEntreplantasNoaccesible = this.getEntreplantasNoaccesible();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "entreplantasNoaccesible", theEntreplantasNoaccesible), currentHashCode, theEntreplantasNoaccesible);
		}
		{
			String theEntreplantasNoaccesibleAscensororampaaccesible;
			theEntreplantasNoaccesibleAscensororampaaccesible = this.getEntreplantasNoaccesibleAscensororampaaccesible();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "entreplantasNoaccesibleAscensororampaaccesible", theEntreplantasNoaccesibleAscensororampaaccesible), currentHashCode, theEntreplantasNoaccesibleAscensororampaaccesible);
		}
		{
			String theEntreplantasNoaccesibleAscensornoaccesible;
			theEntreplantasNoaccesibleAscensornoaccesible = this.getEntreplantasNoaccesibleAscensornoaccesible();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "entreplantasNoaccesibleAscensornoaccesible", theEntreplantasNoaccesibleAscensornoaccesible), currentHashCode, theEntreplantasNoaccesibleAscensornoaccesible);
		}
		{
			String theEntreplantasNoaccesibleAscensornoaccesibleDimensiones;
			theEntreplantasNoaccesibleAscensornoaccesibleDimensiones = this.getEntreplantasNoaccesibleAscensornoaccesibleDimensiones();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "entreplantasNoaccesibleAscensornoaccesibleDimensiones", theEntreplantasNoaccesibleAscensornoaccesibleDimensiones), currentHashCode, theEntreplantasNoaccesibleAscensornoaccesibleDimensiones);
		}
		{
			String theEntreplantasNoaccesibleRampaascensornoaccesible;
			theEntreplantasNoaccesibleRampaascensornoaccesible = this.getEntreplantasNoaccesibleRampaascensornoaccesible();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "entreplantasNoaccesibleRampaascensornoaccesible", theEntreplantasNoaccesibleRampaascensornoaccesible), currentHashCode, theEntreplantasNoaccesibleRampaascensornoaccesible);
		}
		{
			int theEntreplantasElementosaccesibles;
			theEntreplantasElementosaccesibles = this.getEntreplantasElementosaccesibles();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "entreplantasElementosaccesibles", theEntreplantasElementosaccesibles), currentHashCode, theEntreplantasElementosaccesibles);
		}
		{
			String theEntreplantasElementosaccesiblesAscensororampaaccesible;
			theEntreplantasElementosaccesiblesAscensororampaaccesible = this.getEntreplantasElementosaccesiblesAscensororampaaccesible();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "entreplantasElementosaccesiblesAscensororampaaccesible", theEntreplantasElementosaccesiblesAscensororampaaccesible), currentHashCode, theEntreplantasElementosaccesiblesAscensororampaaccesible);
		}
		{
			String theEntreplantasElementosaccesiblesAscensornoaccesible;
			theEntreplantasElementosaccesiblesAscensornoaccesible = this.getEntreplantasElementosaccesiblesAscensornoaccesible();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "entreplantasElementosaccesiblesAscensornoaccesible", theEntreplantasElementosaccesiblesAscensornoaccesible), currentHashCode, theEntreplantasElementosaccesiblesAscensornoaccesible);
		}
		{
			String theEntreplantasElementosaccesiblesAscensornoaccesibleDimensiones;
			theEntreplantasElementosaccesiblesAscensornoaccesibleDimensiones = this.getEntreplantasElementosaccesiblesAscensornoaccesibleDimensiones();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "entreplantasElementosaccesiblesAscensornoaccesibleDimensiones", theEntreplantasElementosaccesiblesAscensornoaccesibleDimensiones), currentHashCode, theEntreplantasElementosaccesiblesAscensornoaccesibleDimensiones);
		}
		{
			String theEntreplantasElementosaccesiblesRampaascensornoaccesible;
			theEntreplantasElementosaccesiblesRampaascensornoaccesible = this.getEntreplantasElementosaccesiblesRampaascensornoaccesible();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "entreplantasElementosaccesiblesRampaascensornoaccesible", theEntreplantasElementosaccesiblesRampaascensornoaccesible), currentHashCode, theEntreplantasElementosaccesiblesRampaascensornoaccesible);
		}
		{
			int theEntreplantasZonasusopublico;
			theEntreplantasZonasusopublico = this.getEntreplantasZonasusopublico();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "entreplantasZonasusopublico", theEntreplantasZonasusopublico), currentHashCode, theEntreplantasZonasusopublico);
		}
		{
			String theEntreplantasZonasusopublicoAscensororampaaccesible;
			theEntreplantasZonasusopublicoAscensororampaaccesible = this.getEntreplantasZonasusopublicoAscensororampaaccesible();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "entreplantasZonasusopublicoAscensororampaaccesible", theEntreplantasZonasusopublicoAscensororampaaccesible), currentHashCode, theEntreplantasZonasusopublicoAscensororampaaccesible);
		}
		{
			String theEntreplantasZonasusopublicoAscensornoaccesible;
			theEntreplantasZonasusopublicoAscensornoaccesible = this.getEntreplantasZonasusopublicoAscensornoaccesible();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "entreplantasZonasusopublicoAscensornoaccesible", theEntreplantasZonasusopublicoAscensornoaccesible), currentHashCode, theEntreplantasZonasusopublicoAscensornoaccesible);
		}
		{
			String theEntreplantasZonasusopublicoAscensornoaccesibleDimensiones;
			theEntreplantasZonasusopublicoAscensornoaccesibleDimensiones = this.getEntreplantasZonasusopublicoAscensornoaccesibleDimensiones();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "entreplantasZonasusopublicoAscensornoaccesibleDimensiones", theEntreplantasZonasusopublicoAscensornoaccesibleDimensiones), currentHashCode, theEntreplantasZonasusopublicoAscensornoaccesibleDimensiones);
		}
		{
			String theEntreplantasZonasusopublicoRampaascensornoaccesible;
			theEntreplantasZonasusopublicoRampaascensornoaccesible = this.getEntreplantasZonasusopublicoRampaascensornoaccesible();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "entreplantasZonasusopublicoRampaascensornoaccesible", theEntreplantasZonasusopublicoRampaascensornoaccesible), currentHashCode, theEntreplantasZonasusopublicoRampaascensornoaccesible);
		}
		{
			String theEntreplantasObservaciones;
			theEntreplantasObservaciones = this.getEntreplantasObservaciones();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "entreplantasObservaciones", theEntreplantasObservaciones), currentHashCode, theEntreplantasObservaciones);
		}
		{
			int thePlantasItinerarioaccesibleEntresi;
			thePlantasItinerarioaccesibleEntresi = this.getPlantasItinerarioaccesibleEntresi();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "plantasItinerarioaccesibleEntresi", thePlantasItinerarioaccesibleEntresi), currentHashCode, thePlantasItinerarioaccesibleEntresi);
		}
		{
			int thePlantasItinerarioaccesibleZonasusopublico;
			thePlantasItinerarioaccesibleZonasusopublico = this.getPlantasItinerarioaccesibleZonasusopublico();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "plantasItinerarioaccesibleZonasusopublico", thePlantasItinerarioaccesibleZonasusopublico), currentHashCode, thePlantasItinerarioaccesibleZonasusopublico);
		}
		{
			int thePlantasItinerarioaccesibleElementosaccesibles;
			thePlantasItinerarioaccesibleElementosaccesibles = this.getPlantasItinerarioaccesibleElementosaccesibles();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "plantasItinerarioaccesibleElementosaccesibles", thePlantasItinerarioaccesibleElementosaccesibles), currentHashCode, thePlantasItinerarioaccesibleElementosaccesibles);
		}
		{
			int thePlantasItinerarioaccesibleZonasusoprivado;
			thePlantasItinerarioaccesibleZonasusoprivado = this.getPlantasItinerarioaccesibleZonasusoprivado();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "plantasItinerarioaccesibleZonasusoprivado", thePlantasItinerarioaccesibleZonasusoprivado), currentHashCode, thePlantasItinerarioaccesibleZonasusoprivado);
		}
		{
			String thePlantasItinerarioaccesibleObservaciones;
			thePlantasItinerarioaccesibleObservaciones = this.getPlantasItinerarioaccesibleObservaciones();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "plantasItinerarioaccesibleObservaciones", thePlantasItinerarioaccesibleObservaciones), currentHashCode, thePlantasItinerarioaccesibleObservaciones);
		}
		{
			String theAlojamientosaccesiblesMinimo1;
			theAlojamientosaccesiblesMinimo1 = this.getAlojamientosaccesiblesMinimo1();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "alojamientosaccesiblesMinimo1", theAlojamientosaccesiblesMinimo1), currentHashCode, theAlojamientosaccesiblesMinimo1);
		}
		{
			String theAlojamientosaccesiblesMinimo2;
			theAlojamientosaccesiblesMinimo2 = this.getAlojamientosaccesiblesMinimo2();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "alojamientosaccesiblesMinimo2", theAlojamientosaccesiblesMinimo2), currentHashCode, theAlojamientosaccesiblesMinimo2);
		}
		{
			String theAlojamientosaccesiblesMinimo4;
			theAlojamientosaccesiblesMinimo4 = this.getAlojamientosaccesiblesMinimo4();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "alojamientosaccesiblesMinimo4", theAlojamientosaccesiblesMinimo4), currentHashCode, theAlojamientosaccesiblesMinimo4);
		}
		{
			String theAlojamientosaccesiblesMinimo6;
			theAlojamientosaccesiblesMinimo6 = this.getAlojamientosaccesiblesMinimo6();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "alojamientosaccesiblesMinimo6", theAlojamientosaccesiblesMinimo6), currentHashCode, theAlojamientosaccesiblesMinimo6);
		}
		{
			String theAlojamientosaccesiblesMinimo8;
			theAlojamientosaccesiblesMinimo8 = this.getAlojamientosaccesiblesMinimo8();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "alojamientosaccesiblesMinimo8", theAlojamientosaccesiblesMinimo8), currentHashCode, theAlojamientosaccesiblesMinimo8);
		}
		{
			String theAlojamientosaccesibles1Porcada50;
			theAlojamientosaccesibles1Porcada50 = this.getAlojamientosaccesibles1Porcada50();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "alojamientosaccesibles1Porcada50", theAlojamientosaccesibles1Porcada50), currentHashCode, theAlojamientosaccesibles1Porcada50);
		}
		{
			String theAlojamientosaccesiblesObservaciones;
			theAlojamientosaccesiblesObservaciones = this.getAlojamientosaccesiblesObservaciones();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "alojamientosaccesiblesObservaciones", theAlojamientosaccesiblesObservaciones), currentHashCode, theAlojamientosaccesiblesObservaciones);
		}
		{
			String theAparcamientoResidencialpublicoPoralojamiento;
			theAparcamientoResidencialpublicoPoralojamiento = this.getAparcamientoResidencialpublicoPoralojamiento();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "aparcamientoResidencialpublicoPoralojamiento", theAparcamientoResidencialpublicoPoralojamiento), currentHashCode, theAparcamientoResidencialpublicoPoralojamiento);
		}
		{
			String theAparcamientoComercialPorfraccion;
			theAparcamientoComercialPorfraccion = this.getAparcamientoComercialPorfraccion();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "aparcamientoComercialPorfraccion", theAparcamientoComercialPorfraccion), currentHashCode, theAparcamientoComercialPorfraccion);
		}
		{
			String theAparcamientoOtrosusosMinimoaparcamientosUnaporfraccion;
			theAparcamientoOtrosusosMinimoaparcamientosUnaporfraccion = this.getAparcamientoOtrosusosMinimoaparcamientosUnaporfraccion();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "aparcamientoOtrosusosMinimoaparcamientosUnaporfraccion", theAparcamientoOtrosusosMinimoaparcamientosUnaporfraccion), currentHashCode, theAparcamientoOtrosusosMinimoaparcamientosUnaporfraccion);
		}
		{
			String theAparcamientoOtrosusosMinimoaparcamientosUnamasporfraccion;
			theAparcamientoOtrosusosMinimoaparcamientosUnamasporfraccion = this.getAparcamientoOtrosusosMinimoaparcamientosUnamasporfraccion();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "aparcamientoOtrosusosMinimoaparcamientosUnamasporfraccion", theAparcamientoOtrosusosMinimoaparcamientosUnamasporfraccion), currentHashCode, theAparcamientoOtrosusosMinimoaparcamientosUnamasporfraccion);
		}
		{
			String theAparcamientoSillaruedas;
			theAparcamientoSillaruedas = this.getAparcamientoSillaruedas();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "aparcamientoSillaruedas", theAparcamientoSillaruedas), currentHashCode, theAparcamientoSillaruedas);
		}
		{
			String theAparcamientoObservaciones;
			theAparcamientoObservaciones = this.getAparcamientoObservaciones();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "aparcamientoObservaciones", theAparcamientoObservaciones), currentHashCode, theAparcamientoObservaciones);
		}
		{
			String thePlazasreservadasSillaruedas;
			thePlazasreservadasSillaruedas = this.getPlazasreservadasSillaruedas();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "plazasreservadasSillaruedas", thePlazasreservadasSillaruedas), currentHashCode, thePlazasreservadasSillaruedas);
		}
		{
			String thePlazasreservadasDiscapacidadauditiva;
			thePlazasreservadasDiscapacidadauditiva = this.getPlazasreservadasDiscapacidadauditiva();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "plazasreservadasDiscapacidadauditiva", thePlazasreservadasDiscapacidadauditiva), currentHashCode, thePlazasreservadasDiscapacidadauditiva);
		}
		{
			String thePlazasreservadasZonaesperaSillaruedas;
			thePlazasreservadasZonaesperaSillaruedas = this.getPlazasreservadasZonaesperaSillaruedas();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "plazasreservadasZonaesperaSillaruedas", thePlazasreservadasZonaesperaSillaruedas), currentHashCode, thePlazasreservadasZonaesperaSillaruedas);
		}
		{
			String thePlazasreservadasObservaciones;
			thePlazasreservadasObservaciones = this.getPlazasreservadasObservaciones();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "plazasreservadasObservaciones", thePlazasreservadasObservaciones), currentHashCode, thePlazasreservadasObservaciones);
		}
		{
			String thePiscinasEntradaaccesible;
			thePiscinasEntradaaccesible = this.getPiscinasEntradaaccesible();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "piscinasEntradaaccesible", thePiscinasEntradaaccesible), currentHashCode, thePiscinasEntradaaccesible);
		}
		{
			String thePiscinasObservaciones;
			thePiscinasObservaciones = this.getPiscinasObservaciones();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "piscinasObservaciones", thePiscinasObservaciones), currentHashCode, thePiscinasObservaciones);
		}
		{
			String theServicioshigienicosAseoaccesible;
			theServicioshigienicosAseoaccesible = this.getServicioshigienicosAseoaccesible();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "servicioshigienicosAseoaccesible", theServicioshigienicosAseoaccesible), currentHashCode, theServicioshigienicosAseoaccesible);
		}
		{
			String theServicioshigienicosCabinaduchaaccesibles;
			theServicioshigienicosCabinaduchaaccesibles = this.getServicioshigienicosCabinaduchaaccesibles();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "servicioshigienicosCabinaduchaaccesibles", theServicioshigienicosCabinaduchaaccesibles), currentHashCode, theServicioshigienicosCabinaduchaaccesibles);
		}
		{
			String theServicioshigienicosObservaciones;
			theServicioshigienicosObservaciones = this.getServicioshigienicosObservaciones();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "servicioshigienicosObservaciones", theServicioshigienicosObservaciones), currentHashCode, theServicioshigienicosObservaciones);
		}
		{
			String theMobiliariofijoPuntoaccesible;
			theMobiliariofijoPuntoaccesible = this.getMobiliariofijoPuntoaccesible();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "mobiliariofijoPuntoaccesible", theMobiliariofijoPuntoaccesible), currentHashCode, theMobiliariofijoPuntoaccesible);
		}
		{
			String theMobiliariofijoObservaciones;
			theMobiliariofijoObservaciones = this.getMobiliariofijoObservaciones();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "mobiliariofijoObservaciones", theMobiliariofijoObservaciones), currentHashCode, theMobiliariofijoObservaciones);
		}
		{
			String theMecanismosAccesibles;
			theMecanismosAccesibles = this.getMecanismosAccesibles();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "mecanismosAccesibles", theMecanismosAccesibles), currentHashCode, theMecanismosAccesibles);
		}
		{
			String theMecanismosObservaciones;
			theMecanismosObservaciones = this.getMecanismosObservaciones();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "mecanismosObservaciones", theMecanismosObservaciones), currentHashCode, theMecanismosObservaciones);
		}
		{
			String theInformacionsenalizacionPrivadoSiaEntradas;
			theInformacionsenalizacionPrivadoSiaEntradas = this.getInformacionsenalizacionPrivadoSiaEntradas();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "informacionsenalizacionPrivadoSiaEntradas", theInformacionsenalizacionPrivadoSiaEntradas), currentHashCode, theInformacionsenalizacionPrivadoSiaEntradas);
		}
		{
			String theInformacionsenalizacionPrivadoSiaItinerarios;
			theInformacionsenalizacionPrivadoSiaItinerarios = this.getInformacionsenalizacionPrivadoSiaItinerarios();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "informacionsenalizacionPrivadoSiaItinerarios", theInformacionsenalizacionPrivadoSiaItinerarios), currentHashCode, theInformacionsenalizacionPrivadoSiaItinerarios);
		}
		{
			String theInformacionsenalizacionPrivadoSiaAscensores;
			theInformacionsenalizacionPrivadoSiaAscensores = this.getInformacionsenalizacionPrivadoSiaAscensores();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "informacionsenalizacionPrivadoSiaAscensores", theInformacionsenalizacionPrivadoSiaAscensores), currentHashCode, theInformacionsenalizacionPrivadoSiaAscensores);
		}
		{
			String theInformacionsenalizacionPrivadoSiaAparcamiento;
			theInformacionsenalizacionPrivadoSiaAparcamiento = this.getInformacionsenalizacionPrivadoSiaAparcamiento();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "informacionsenalizacionPrivadoSiaAparcamiento", theInformacionsenalizacionPrivadoSiaAparcamiento), currentHashCode, theInformacionsenalizacionPrivadoSiaAparcamiento);
		}
		{
			String theInformacionsenalizacionPrivadoSiaPlazasreservadas;
			theInformacionsenalizacionPrivadoSiaPlazasreservadas = this.getInformacionsenalizacionPrivadoSiaPlazasreservadas();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "informacionsenalizacionPrivadoSiaPlazasreservadas", theInformacionsenalizacionPrivadoSiaPlazasreservadas), currentHashCode, theInformacionsenalizacionPrivadoSiaPlazasreservadas);
		}
		{
			String theInformacionsenalizacionPublicoSiaEntradas;
			theInformacionsenalizacionPublicoSiaEntradas = this.getInformacionsenalizacionPublicoSiaEntradas();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "informacionsenalizacionPublicoSiaEntradas", theInformacionsenalizacionPublicoSiaEntradas), currentHashCode, theInformacionsenalizacionPublicoSiaEntradas);
		}
		{
			String theInformacionsenalizacionPublicoSiaAscensores;
			theInformacionsenalizacionPublicoSiaAscensores = this.getInformacionsenalizacionPublicoSiaAscensores();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "informacionsenalizacionPublicoSiaAscensores", theInformacionsenalizacionPublicoSiaAscensores), currentHashCode, theInformacionsenalizacionPublicoSiaAscensores);
		}
		{
			String theInformacionsenalizacionPublicoSiaItinerarios;
			theInformacionsenalizacionPublicoSiaItinerarios = this.getInformacionsenalizacionPublicoSiaItinerarios();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "informacionsenalizacionPublicoSiaItinerarios", theInformacionsenalizacionPublicoSiaItinerarios), currentHashCode, theInformacionsenalizacionPublicoSiaItinerarios);
		}
		{
			String theInformacionsenalizacionPublicoSiaAparcamiento;
			theInformacionsenalizacionPublicoSiaAparcamiento = this.getInformacionsenalizacionPublicoSiaAparcamiento();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "informacionsenalizacionPublicoSiaAparcamiento", theInformacionsenalizacionPublicoSiaAparcamiento), currentHashCode, theInformacionsenalizacionPublicoSiaAparcamiento);
		}
		{
			String theInformacionsenalizacionPublicoSiaPlazasreservadas;
			theInformacionsenalizacionPublicoSiaPlazasreservadas = this.getInformacionsenalizacionPublicoSiaPlazasreservadas();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "informacionsenalizacionPublicoSiaPlazasreservadas", theInformacionsenalizacionPublicoSiaPlazasreservadas), currentHashCode, theInformacionsenalizacionPublicoSiaPlazasreservadas);
		}
		{
			String theInformacionsenalizacionPublicoSiaServicioshigienicos;
			theInformacionsenalizacionPublicoSiaServicioshigienicos = this.getInformacionsenalizacionPublicoSiaServicioshigienicos();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "informacionsenalizacionPublicoSiaServicioshigienicos", theInformacionsenalizacionPublicoSiaServicioshigienicos), currentHashCode, theInformacionsenalizacionPublicoSiaServicioshigienicos);
		}
		{
			String theInformacionsenalizacionPublicoSiaPuntosatencion;
			theInformacionsenalizacionPublicoSiaPuntosatencion = this.getInformacionsenalizacionPublicoSiaPuntosatencion();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "informacionsenalizacionPublicoSiaPuntosatencion", theInformacionsenalizacionPublicoSiaPuntosatencion), currentHashCode, theInformacionsenalizacionPublicoSiaPuntosatencion);
		}
		{
			String theInformacionsenalizacionServicioshigienicossenalizados;
			theInformacionsenalizacionServicioshigienicossenalizados = this.getInformacionsenalizacionServicioshigienicossenalizados();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "informacionsenalizacionServicioshigienicossenalizados", theInformacionsenalizacionServicioshigienicossenalizados), currentHashCode, theInformacionsenalizacionServicioshigienicossenalizados);
		}
		{
			String theInformacionsenalizacionObservaciones;
			theInformacionsenalizacionObservaciones = this.getInformacionsenalizacionObservaciones();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "informacionsenalizacionObservaciones", theInformacionsenalizacionObservaciones), currentHashCode, theInformacionsenalizacionObservaciones);
		}
		{
			String theInformacionsenalizacionAscensores;
			theInformacionsenalizacionAscensores = this.getInformacionsenalizacionAscensores();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "informacionsenalizacionAscensores", theInformacionsenalizacionAscensores), currentHashCode, theInformacionsenalizacionAscensores);
		}
		{
			String theInformacionsenalizacionAscensoresBrailearabigo;
			theInformacionsenalizacionAscensoresBrailearabigo = this.getInformacionsenalizacionAscensoresBrailearabigo();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "informacionsenalizacionAscensoresBrailearabigo", theInformacionsenalizacionAscensoresBrailearabigo), currentHashCode, theInformacionsenalizacionAscensoresBrailearabigo);
		}
		{
			String theInformacionsenalizacionAscensoresNumeroplanta;
			theInformacionsenalizacionAscensoresNumeroplanta = this.getInformacionsenalizacionAscensoresNumeroplanta();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "informacionsenalizacionAscensoresNumeroplanta", theInformacionsenalizacionAscensoresNumeroplanta), currentHashCode, theInformacionsenalizacionAscensoresNumeroplanta);
		}
		{
			String theInformacionsenalizacionBuclemagnetico;
			theInformacionsenalizacionBuclemagnetico = this.getInformacionsenalizacionBuclemagnetico();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "informacionsenalizacionBuclemagnetico", theInformacionsenalizacionBuclemagnetico), currentHashCode, theInformacionsenalizacionBuclemagnetico);
		}
		{
			String theInformacionsenalizacionBuclemagneticoSenalizado;
			theInformacionsenalizacionBuclemagneticoSenalizado = this.getInformacionsenalizacionBuclemagneticoSenalizado();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "informacionsenalizacionBuclemagneticoSenalizado", theInformacionsenalizacionBuclemagneticoSenalizado), currentHashCode, theInformacionsenalizacionBuclemagneticoSenalizado);
		}
		{
			String theInformacionsenalizacionBandasvisualestactiles;
			theInformacionsenalizacionBandasvisualestactiles = this.getInformacionsenalizacionBandasvisualestactiles();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "informacionsenalizacionBandasvisualestactiles", theInformacionsenalizacionBandasvisualestactiles), currentHashCode, theInformacionsenalizacionBandasvisualestactiles);
		}
		{
			String theInformacionsenalizacionBandasvisualestactilesColorcontrastado;
			theInformacionsenalizacionBandasvisualestactilesColorcontrastado = this.getInformacionsenalizacionBandasvisualestactilesColorcontrastado();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "informacionsenalizacionBandasvisualestactilesColorcontrastado", theInformacionsenalizacionBandasvisualestactilesColorcontrastado), currentHashCode, theInformacionsenalizacionBandasvisualestactilesColorcontrastado);
		}
		{
			String theInformacionsenalizacionBandasvisualestactilesRelieveinterior;
			theInformacionsenalizacionBandasvisualestactilesRelieveinterior = this.getInformacionsenalizacionBandasvisualestactilesRelieveinterior();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "informacionsenalizacionBandasvisualestactilesRelieveinterior", theInformacionsenalizacionBandasvisualestactilesRelieveinterior), currentHashCode, theInformacionsenalizacionBandasvisualestactilesRelieveinterior);
		}
		{
			String theInformacionsenalizacionBandasvisualestactilesRelieveexterior;
			theInformacionsenalizacionBandasvisualestactilesRelieveexterior = this.getInformacionsenalizacionBandasvisualestactilesRelieveexterior();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "informacionsenalizacionBandasvisualestactilesRelieveexterior", theInformacionsenalizacionBandasvisualestactilesRelieveexterior), currentHashCode, theInformacionsenalizacionBandasvisualestactilesRelieveexterior);
		}
		{
			String theInformacionsenalizacionBandasvisualestactilesArranqueescaleras;
			theInformacionsenalizacionBandasvisualestactilesArranqueescaleras = this.getInformacionsenalizacionBandasvisualestactilesArranqueescaleras();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "informacionsenalizacionBandasvisualestactilesArranqueescaleras", theInformacionsenalizacionBandasvisualestactilesArranqueescaleras), currentHashCode, theInformacionsenalizacionBandasvisualestactilesArranqueescaleras);
		}
		{
			String theInformacionsenalizacionBandasvisualestactilesItinerarioaccesib;
			theInformacionsenalizacionBandasvisualestactilesItinerarioaccesib = this.getInformacionsenalizacionBandasvisualestactilesItinerarioaccesib();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "informacionsenalizacionBandasvisualestactilesItinerarioaccesib", theInformacionsenalizacionBandasvisualestactilesItinerarioaccesib), currentHashCode, theInformacionsenalizacionBandasvisualestactilesItinerarioaccesib);
		}
		{
			String theInformacionsenalizacionSianorma;
			theInformacionsenalizacionSianorma = this.getInformacionsenalizacionSianorma();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "informacionsenalizacionSianorma", theInformacionsenalizacionSianorma), currentHashCode, theInformacionsenalizacionSianorma);
		}
		{
			String theInformacionsenalizacionTodosusosObservaciones;
			theInformacionsenalizacionTodosusosObservaciones = this.getInformacionsenalizacionTodosusosObservaciones();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "informacionsenalizacionTodosusosObservaciones", theInformacionsenalizacionTodosusosObservaciones), currentHashCode, theInformacionsenalizacionTodosusosObservaciones);
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
		return currentHashCode;
	}

	public int hashCode() {
		final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
		return this.hashCode(null, strategy);
	}

}
