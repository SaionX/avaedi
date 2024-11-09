//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.11 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2016.09.08 a las 10:32:16 PM CEST 
//

package es.caib.avaedi.iee.model;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
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
import javax.xml.bind.annotation.XmlRootElement;
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
 * Clase Java para inspeccionType complex type.
 * 
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que
 * haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="inspeccionType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="iee_completa"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int"&gt;
 *               &lt;enumeration value="1"/&gt;
 *               &lt;enumeration value="0"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="inspeccion_identificacionedificios" type="{}inspeccion_identificacionedificiosType"/&gt;
 *         &lt;element name="inspeccion_identificacionedificio_direcciones" type="{}inspeccion_identificacionedificio_direccionesType"/&gt;
 *         &lt;element name="inspeccion_identificacionedificio_referenciacatastrales" type="{}inspeccion_identificacionedificio_referenciacatastralesType"/&gt;
 *         &lt;element name="inspeccion_propiedades" type="{}inspeccion_propiedadesType"/&gt;
 *         &lt;element name="inspeccion_representantes" type="{}inspeccion_representantesType"/&gt;
 *         &lt;element name="inspeccion_tecnicos" type="{}inspeccion_tecnicosType"/&gt;
 *         &lt;element name="inspeccion_datosedificios" type="{}inspeccion_datosedificiosType"/&gt;
 *         &lt;element name="cimentaciones" type="{}cimentacionesType"/&gt;
 *         &lt;element name="estructuras" type="{}estructurasType"/&gt;
 *         &lt;element name="cerramientoscubiertas" type="{}cerramientoscubiertasType"/&gt;
 *         &lt;element name="instalaciones" type="{}instalacionesType"/&gt;
 *         &lt;element name="conservacion_datosgenerales" type="{}conservacion_datosgeneralesType"/&gt;
 *         &lt;element name="conservacion_datosgenerales_fechavisitas" type="{}conservacion_datosgenerales_fechavisitasType"/&gt;
 *         &lt;element name="conservaciones_documentaciones" type="{}conservaciones_documentacionesType"/&gt;
 *         &lt;element name="conservacion_documentacion_otros" type="{}conservacion_documentacion_otrosType"/&gt;
 *         &lt;element name="conservacion_datosgenerales_historicos" type="{}conservacion_datosgenerales_historicosType"/&gt;
 *         &lt;element name="conservacion_datosgenerales_archivos" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="conservacion_peligrosinminentes" type="{}conservacion_peligrosinminentesType"/&gt;
 *         &lt;element name="conservacion_valoraciones" type="{}conservacion_valoracionesType"/&gt;
 *         &lt;element name="conservacion_valoracionesfinales" type="{}conservacion_valoracionesfinalesType"/&gt;
 *         &lt;element name="conservacion_descripciones" type="{}conservacion_descripcionesType"/&gt;
 *         &lt;element name="accesibilidad_publicos" type="{}accesibilidad_publicosType"/&gt;
 *         &lt;element name="accesibilidad_valoracionfinales" type="{}accesibilidad_valoracionfinalesType"/&gt;
 *         &lt;element name="accesibilidad_ajustesrazonables" type="{}accesibilidad_ajustesrazonablesType"/&gt;
 *         &lt;element name="accesibilidad_ajustesrazonables_costes" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="eficienciasenergeticas" type="{}eficienciasenergeticasType"/&gt;
 *         &lt;element name="acustica_datosgenerales" type="{}acustica_datosgeneralesType"/&gt;
 *         &lt;element name="acustica_ruidosexteriores" type="{}acustica_ruidosexterioresType"/&gt;
 *         &lt;element name="acustica_ruidointeriorverticales" type="{}acustica_ruidointeriorverticalesType"/&gt;
 *         &lt;element name="acustica_ruidointeriorhorizontales" type="{}acustica_ruidointeriorhorizontalesType"/&gt;
 *         &lt;element name="acustica_ruidointerioruniones" type="{}acustica_ruidointeriorunionesType"/&gt;
 *         &lt;element name="acustica_ruidoinstalaciones" type="{}acustica_ruidoinstalacionesType"/&gt;
 *         &lt;element name="acustica_valoracionfinal" type="{}acustica_valoracionfinalType"/&gt;
 *         &lt;element name="acustica_mejorasacusticas" type="{}acustica_mejorasacusticasType"/&gt;
 *         &lt;element name="acustica_comprobaciones" type="{}acustica_comprobacionesType"/&gt;
 *         &lt;element name="acusticas" type="{}acusticasType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "inspeccionType", propOrder = { "ieeCompleta", "inspeccionIdentificacionedificios", "inspeccionIdentificacionedificioDirecciones", "inspeccionIdentificacionedificioReferenciacatastrales", "inspeccionPropiedades", "inspeccionRepresentantes", "inspeccionTecnicos", "inspeccionDatosedificios", "cimentaciones", "estructuras", "cerramientoscubiertas", "instalaciones", "conservacionDatosgenerales", "conservacionDatosgeneralesFechavisitas", "conservacionesDocumentaciones", "conservacionDocumentacionOtros", "conservacionDatosgeneralesHistoricos", "conservacionDatosgeneralesArchivos", "conservacionPeligrosinminentes", "conservacionValoraciones", "conservacionValoracionesfinales", "conservacionDescripciones", "accesibilidadPublicos", "accesibilidadValoracionfinales", "accesibilidadAjustesrazonables", "accesibilidadAjustesrazonablesCostes", "eficienciasenergeticas", "acusticaDatosgenerales", "acusticaRuidosexteriores", "acusticaRuidointeriorverticales", "acusticaRuidointeriorhorizontales", "acusticaRuidointerioruniones", "acusticaRuidoinstalaciones", "acusticaValoracionfinal", "acusticaMejorasacusticas", "acusticaComprobaciones", "acusticas" })
@Entity(name = "InspeccionType")
@Table(name = "AED_INSPECCION")
@Inheritance(strategy = InheritanceType.JOINED)
@XmlRootElement(name = "inspeccion")
public class InspeccionType implements Serializable, Equals, HashCode {

	@XmlElement(name = "iee_completa")
	protected int ieeCompleta;
	@XmlElement(name = "inspeccion_identificacionedificios", required = true)
	protected InspeccionIdentificacionedificiosType inspeccionIdentificacionedificios;
	@XmlElement(name = "inspeccion_identificacionedificio_direcciones", required = true)
	protected InspeccionIdentificacionedificioDireccionesType inspeccionIdentificacionedificioDirecciones;
	@XmlElement(name = "inspeccion_identificacionedificio_referenciacatastrales", required = true)
	protected InspeccionIdentificacionedificioReferenciacatastralesType inspeccionIdentificacionedificioReferenciacatastrales;
	@XmlElement(name = "inspeccion_propiedades", required = true)
	protected InspeccionPropiedadesType inspeccionPropiedades;
	@XmlElement(name = "inspeccion_representantes", required = true)
	protected InspeccionRepresentantesType inspeccionRepresentantes;
	@XmlElement(name = "inspeccion_tecnicos", required = true)
	protected InspeccionTecnicosType inspeccionTecnicos;
	@XmlElement(name = "inspeccion_datosedificios", required = true)
	protected InspeccionDatosedificiosType inspeccionDatosedificios;
	@XmlElement(required = true)
	protected CimentacionesType cimentaciones;
	@XmlElement(required = true)
	protected EstructurasType estructuras;
	@XmlElement(required = true)
	protected CerramientoscubiertasType cerramientoscubiertas;
	@XmlElement(required = true)
	protected InstalacionesType instalaciones;
	@XmlElement(name = "conservacion_datosgenerales", required = true)
	protected ConservacionDatosgeneralesType conservacionDatosgenerales;
	@XmlElement(name = "conservacion_datosgenerales_fechavisitas", required = true)
	protected ConservacionDatosgeneralesFechavisitasType conservacionDatosgeneralesFechavisitas;
	@XmlElement(name = "conservaciones_documentaciones", required = true)
	protected ConservacionesDocumentacionesType conservacionesDocumentaciones;
	@XmlElement(name = "conservacion_documentacion_otros", required = true)
	protected ConservacionDocumentacionOtrosType conservacionDocumentacionOtros;
	@XmlElement(name = "conservacion_datosgenerales_historicos", required = true)
	protected ConservacionDatosgeneralesHistoricosType conservacionDatosgeneralesHistoricos;
	@XmlElement(name = "conservacion_datosgenerales_archivos", required = true)
	protected String conservacionDatosgeneralesArchivos;
	@XmlElement(name = "conservacion_peligrosinminentes", required = true)
	protected ConservacionPeligrosinminentesType conservacionPeligrosinminentes;
	@XmlElement(name = "conservacion_valoraciones", required = true)
	protected ConservacionValoracionesType conservacionValoraciones;
	@XmlElement(name = "conservacion_valoracionesfinales", required = true)
	protected ConservacionValoracionesfinalesType conservacionValoracionesfinales;
	@XmlElement(name = "conservacion_descripciones", required = true)
	protected ConservacionDescripcionesType conservacionDescripciones;
	@XmlElement(name = "accesibilidad_publicos", required = true)
	protected AccesibilidadPublicosType accesibilidadPublicos;
	@XmlElement(name = "accesibilidad_valoracionfinales", required = true)
	protected AccesibilidadValoracionfinalesType accesibilidadValoracionfinales;
	@XmlElement(name = "accesibilidad_ajustesrazonables", required = true)
	protected AccesibilidadAjustesrazonablesType accesibilidadAjustesrazonables;
	@XmlElement(name = "accesibilidad_ajustesrazonables_costes", required = true)
	protected String accesibilidadAjustesrazonablesCostes;
	@XmlElement(required = true)
	protected EficienciasenergeticasType eficienciasenergeticas;
	@XmlElement(name = "acustica_datosgenerales", required = true)
	protected AcusticaDatosgeneralesType acusticaDatosgenerales;
	@XmlElement(name = "acustica_ruidosexteriores", required = true)
	protected AcusticaRuidosexterioresType acusticaRuidosexteriores;
	@XmlElement(name = "acustica_ruidointeriorverticales", required = true)
	protected AcusticaRuidointeriorverticalesType acusticaRuidointeriorverticales;
	@XmlElement(name = "acustica_ruidointeriorhorizontales", required = true)
	protected AcusticaRuidointeriorhorizontalesType acusticaRuidointeriorhorizontales;
	@XmlElement(name = "acustica_ruidointerioruniones", required = true)
	protected AcusticaRuidointeriorunionesType acusticaRuidointerioruniones;
	@XmlElement(name = "acustica_ruidoinstalaciones", required = true)
	protected AcusticaRuidoinstalacionesType acusticaRuidoinstalaciones;
	@XmlElement(name = "acustica_valoracionfinal", required = true)
	protected AcusticaValoracionfinalType acusticaValoracionfinal;
	@XmlElement(name = "acustica_mejorasacusticas", required = true)
	protected AcusticaMejorasacusticasType acusticaMejorasacusticas;
	@XmlElement(name = "acustica_comprobaciones", required = true)
	protected AcusticaComprobacionesType acusticaComprobaciones;
	@XmlElement(required = true)
	protected AcusticasType acusticas;
	@XmlAttribute(name = "Hjid")
	protected Long hjid;

	/**
	 * Obtiene el valor de la propiedad ieeCompleta.
	 * 
	 */
	@Basic
	@Column(name = "IEE_COMPLETA")
	public int getIeeCompleta() {
		return ieeCompleta;
	}

	/**
	 * Define el valor de la propiedad ieeCompleta.
	 * 
	 */
	public void setIeeCompleta(int value) {
		this.ieeCompleta = value;
	}

	/**
	 * Obtiene el valor de la propiedad inspeccionIdentificacionedificios.
	 * 
	 * @return possible object is {@link InspeccionIdentificacionedificiosType }
	 * 
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "pisoLetra", column = @Column(name = "edificio_PISO_LETRA", length = 255)), @AttributeOverride(name = "codigoPostal", column = @Column(name = "edificio_CODIGO_POSTAL", length = 255)), @AttributeOverride(name = "poblacion", column = @Column(name = "edificio_POBLACION", length = 255)), @AttributeOverride(name = "provincia", column = @Column(name = "edificio_PROVINCIA", length = 255)), @AttributeOverride(name = "provinciaId", column = @Column(name = "edificio_PROVINCIA_ID")), @AttributeOverride(name = "tipoViaManual", column = @Column(name = "edificio_TIPO_VIA_MANUAL", length = 255)), @AttributeOverride(name = "viaManual", column = @Column(name = "edificio_VIA_MANUAL", length = 255)), @AttributeOverride(name = "numeroManual", column = @Column(name = "edificio_NUMERO_MANUAL", length = 255)), @AttributeOverride(name = "inspeccionIdentificacionedificioObjetoTipoId", column = @Column(name = "edificio_INSPECCION_IDENTIFICACIONEDIFICIO_OBJETO_TIPO_ID")), @AttributeOverride(name = "objetoTexto", column = @Column(name = "edificio_OBJETO_TEXTO", length = 255)), @AttributeOverride(name = "inspeccionIdentificacionedificioComunesTipoId", column = @Column(name = "edificio_INSPECCION_IDENTIFICACIONEDIFICIO_COMUNES_TIPO_ID")), @AttributeOverride(name = "comunTexto", column = @Column(name = "edificio_COMUN_TEXTO", length = 255)), @AttributeOverride(name = "observaciones", column = @Column(name = "edificio_OBSERVACIONES", length = 255)), @AttributeOverride(name = "inspeccionPropiedadRegimenTipoId", column = @Column(name = "edificio_INSPECCION_PROPIEDAD_REGIMEN_TIPO_ID")), @AttributeOverride(name = "regimenTexto", column = @Column(name = "edificio_REGIMEN_TEXTO", length = 255)) })
	public InspeccionIdentificacionedificiosType getInspeccionIdentificacionedificios() {
		return inspeccionIdentificacionedificios;
	}

	/**
	 * Define el valor de la propiedad inspeccionIdentificacionedificios.
	 * 
	 * @param value
	 *            allowed object is
	 *            {@link InspeccionIdentificacionedificiosType }
	 * 
	 */
	public void setInspeccionIdentificacionedificios(InspeccionIdentificacionedificiosType value) {
		this.inspeccionIdentificacionedificios = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * inspeccionIdentificacionedificioDirecciones.
	 * 
	 * @return possible object is
	 *         {@link InspeccionIdentificacionedificioDireccionesType }
	 * 
	 */
	@Embedded
	public InspeccionIdentificacionedificioDireccionesType getInspeccionIdentificacionedificioDirecciones() {
		return inspeccionIdentificacionedificioDirecciones;
	}

	/**
	 * Define el valor de la propiedad
	 * inspeccionIdentificacionedificioDirecciones.
	 * 
	 * @param value
	 *            allowed object is
	 *            {@link InspeccionIdentificacionedificioDireccionesType }
	 * 
	 */
	public void setInspeccionIdentificacionedificioDirecciones(InspeccionIdentificacionedificioDireccionesType value) {
		this.inspeccionIdentificacionedificioDirecciones = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * inspeccionIdentificacionedificioReferenciacatastrales.
	 * 
	 * @return possible object is
	 *         {@link InspeccionIdentificacionedificioReferenciacatastralesType }
	 * 
	 */
	@Embedded
	public InspeccionIdentificacionedificioReferenciacatastralesType getInspeccionIdentificacionedificioReferenciacatastrales() {
		return inspeccionIdentificacionedificioReferenciacatastrales;
	}

	/**
	 * Define el valor de la propiedad
	 * inspeccionIdentificacionedificioReferenciacatastrales.
	 * 
	 * @param value
	 *            allowed object is
	 *            {@link InspeccionIdentificacionedificioReferenciacatastralesType }
	 * 
	 */
	public void setInspeccionIdentificacionedificioReferenciacatastrales(InspeccionIdentificacionedificioReferenciacatastralesType value) {
		this.inspeccionIdentificacionedificioReferenciacatastrales = value;
	}

	/**
	 * Obtiene el valor de la propiedad inspeccionPropiedades.
	 * 
	 * @return possible object is {@link InspeccionPropiedadesType }
	 * 
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "titular", column = @Column(name = "propiedad_TITULAR", length = 255)), @AttributeOverride(name = "nif", column = @Column(name = "propiedad_NIF", length = 255)) })
	public InspeccionPropiedadesType getInspeccionPropiedades() {
		return inspeccionPropiedades;
	}

	/**
	 * Define el valor de la propiedad inspeccionPropiedades.
	 * 
	 * @param value
	 *            allowed object is {@link InspeccionPropiedadesType }
	 * 
	 */
	public void setInspeccionPropiedades(InspeccionPropiedadesType value) {
		this.inspeccionPropiedades = value;
	}

	/**
	 * Obtiene el valor de la propiedad inspeccionRepresentantes.
	 * 
	 * @return possible object is {@link InspeccionRepresentantesType }
	 * 
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "nombre", column = @Column(name = "representante_NOMBRE", length = 255)), @AttributeOverride(name = "condicion", column = @Column(name = "representante_CONDICION", length = 255)), @AttributeOverride(name = "nif", column = @Column(name = "representante_NIF", length = 255)), @AttributeOverride(name = "direccion", column = @Column(name = "representante_DIRECCION", length = 255)), @AttributeOverride(name = "codigoPostal", column = @Column(name = "representante_CODIGO_POSTAL", length = 255)), @AttributeOverride(name = "poblacion", column = @Column(name = "representante_POBLACION", length = 255)), @AttributeOverride(name = "provincia", column = @Column(name = "representante_PROVINCIA", length = 255)), @AttributeOverride(name = "telefonoFijo", column = @Column(name = "representante_TELEFONO_FIJO", length = 255)), @AttributeOverride(name = "telefonoMovil", column = @Column(name = "representante_TELEFONO_MOVIL", length = 255)), @AttributeOverride(name = "email", column = @Column(name = "representante_EMAIL", length = 255)) })
	public InspeccionRepresentantesType getInspeccionRepresentantes() {
		return inspeccionRepresentantes;
	}

	/**
	 * Define el valor de la propiedad inspeccionRepresentantes.
	 * 
	 * @param value
	 *            allowed object is {@link InspeccionRepresentantesType }
	 * 
	 */
	public void setInspeccionRepresentantes(InspeccionRepresentantesType value) {
		this.inspeccionRepresentantes = value;
	}

	/**
	 * Obtiene el valor de la propiedad inspeccionTecnicos.
	 * 
	 * @return possible object is {@link InspeccionTecnicosType }
	 * 
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "tecnico", column = @Column(name = "tecnico_TECNICO", length = 255)), @AttributeOverride(name = "nif", column = @Column(name = "tecnico_NIF", length = 255)), @AttributeOverride(name = "titulacion", column = @Column(name = "tecnico_TITULACION", length = 255)) })
	public InspeccionTecnicosType getInspeccionTecnicos() {
		return inspeccionTecnicos;
	}

	/**
	 * Define el valor de la propiedad inspeccionTecnicos.
	 * 
	 * @param value
	 *            allowed object is {@link InspeccionTecnicosType }
	 * 
	 */
	public void setInspeccionTecnicos(InspeccionTecnicosType value) {
		this.inspeccionTecnicos = value;
	}

	/**
	 * Obtiene el valor de la propiedad inspeccionDatosedificios.
	 * 
	 * @return possible object is {@link InspeccionDatosedificiosType }
	 * 
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "inspeccionDatosedificioUsoTipoId", column = @Column(name = "INSPECCION_DATOSEDIFICIO_USO_TIPO_ID")), @AttributeOverride(name = "usoTexto", column = @Column(name = "USO_TEXTO", length = 255)), @AttributeOverride(name = "anoConstruccion", column = @Column(name = "ANO_CONSTRUCCION", precision = 5, scale = 0)), @AttributeOverride(name = "anoConstruccionReferencia", column = @Column(name = "ANO_CONSTRUCCION_REFERENCIA", length = 255)), @AttributeOverride(name = "anoRehabilitacion", column = @Column(name = "ANO_REHABILITACION", precision = 5, scale = 0)), @AttributeOverride(name = "anoRehabilitacionReferencia", column = @Column(name = "ANO_REHABILITACION_REFERENCIA", length = 255)), @AttributeOverride(name = "superficieParcela", column = @Column(name = "SUPERFICIE_PARCELA", precision = 20, scale = 10)), @AttributeOverride(name = "superficieConstruida", column = @Column(name = "SUPERFICIE_CONSTRUIDA", precision = 20, scale = 10)), @AttributeOverride(name = "alturaSobreRasante", column = @Column(name = "ALTURA_SOBRE_RASANTE", precision = 20, scale = 10)), @AttributeOverride(name = "plantasSobreRasanteUsoPrincipal", column = @Column(name = "PLANTAS_SOBRE_RASANTE_USO_PRINCIPAL", precision = 10, scale = 0)), @AttributeOverride(name = "plantasSobreRasanteUsosSecundarios", column = @Column(name = "PLANTAS_SOBRE_RASANTE_USOS_SECUNDARIOS", precision = 10, scale = 0)), @AttributeOverride(name = "plantasSobreRasanteUsosSecundariosTipo", column = @Column(name = "PLANTAS_SOBRE_RASANTE_USOS_SECUNDARIOS_TIPO", length = 255)), @AttributeOverride(name = "plantasBajoRasanteUsoPrincipal", column = @Column(name = "PLANTAS_BAJO_RASANTE_USO_PRINCIPAL", precision = 10, scale = 0)), @AttributeOverride(name = "plantasBajoRasanteUsosSecundarios", column = @Column(name = "PLANTAS_BAJO_RASANTE_USOS_SECUNDARIOS", precision = 10, scale = 0)), @AttributeOverride(name = "plantasBajoRasanteUsosSecundariosTipo", column = @Column(name = "PLANTAS_BAJO_RASANTE_USOS_SECUNDARIOS_TIPO", length = 255)), @AttributeOverride(name = "numViviendas", column = @Column(name = "NUM_VIVIENDAS", precision = 10, scale = 0)), @AttributeOverride(name = "superficieMediaViviendas", column = @Column(name = "SUPERFICIE_MEDIA_VIVIENDAS", precision = 20, scale = 10)), @AttributeOverride(name = "numLocales", column = @Column(name = "NUM_LOCALES", precision = 10, scale = 0)), @AttributeOverride(name = "superficieMediaLocales", column = @Column(name = "SUPERFICIE_MEDIA_LOCALES", precision = 20, scale = 10)), @AttributeOverride(name = "numAparcamientos", column = @Column(name = "NUM_APARCAMIENTOS", precision = 10, scale = 0)), @AttributeOverride(name = "superficieMediaAparcamientos", column = @Column(name = "SUPERFICIE_MEDIA_APARCAMIENTOS", precision = 20, scale = 10)), @AttributeOverride(name = "numTrasteros", column = @Column(name = "NUM_TRASTEROS", precision = 10, scale = 0)), @AttributeOverride(name = "superficieMediaTrasteros", column = @Column(name = "SUPERFICIE_MEDIA_TRASTEROS", precision = 20, scale = 10)), @AttributeOverride(name = "inspeccionDatosedificioParcelaTipoId", column = @Column(name = "INSPECCION_DATOSEDIFICIO_PARCELA_TIPO_ID")), @AttributeOverride(name = "inspeccionDatosedificioNucleosescalerasTipoId", column = @Column(name = "INSPECCION_DATOSEDIFICIO_NUCLEOSESCALERAS_TIPO_ID")), @AttributeOverride(name = "inspeccionDatosedificioUnnucleoescalerasTipoId", column = @Column(name = "INSPECCION_DATOSEDIFICIO_UNNUCLEOESCALERAS_TIPO_ID")), @AttributeOverride(name = "totalEscaleras", column = @Column(name = "TOTAL_ESCALERAS", length = 255)), @AttributeOverride(name = "totalAscensores", column = @Column(name = "TOTAL_ASCENSORES", length = 255)), @AttributeOverride(name = "totalViviendasConAccesoVariosNucleos", column = @Column(name = "TOTAL_VIVIENDAS_CON_ACCESO_VARIOS_NUCLEOS", length = 255)), @AttributeOverride(name = "totalViviendasSinAccesoAscensor", column = @Column(name = "TOTAL_VIVIENDAS_SIN_ACCESO_ASCENSOR", length = 255)), @AttributeOverride(name = "mediaViviendasPorPlanta", column = @Column(name = "MEDIA_VIVIENDAS_POR_PLANTA", precision = 10, scale = 0)) })
	public InspeccionDatosedificiosType getInspeccionDatosedificios() {
		return inspeccionDatosedificios;
	}

	/**
	 * Define el valor de la propiedad inspeccionDatosedificios.
	 * 
	 * @param value
	 *            allowed object is {@link InspeccionDatosedificiosType }
	 * 
	 */
	public void setInspeccionDatosedificios(InspeccionDatosedificiosType value) {
		this.inspeccionDatosedificios = value;
	}

	/**
	 * Obtiene el valor de la propiedad cimentaciones.
	 * 
	 * @return possible object is {@link CimentacionesType }
	 * 
	 */
	@ManyToOne(targetEntity = CimentacionesType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "CIMENTACIONES_AED_INSPECCION_HJID")
	public CimentacionesType getCimentaciones() {
		return cimentaciones;
	}

	/**
	 * Define el valor de la propiedad cimentaciones.
	 * 
	 * @param value
	 *            allowed object is {@link CimentacionesType }
	 * 
	 */
	public void setCimentaciones(CimentacionesType value) {
		this.cimentaciones = value;
	}

	/**
	 * Obtiene el valor de la propiedad estructuras.
	 * 
	 * @return possible object is {@link EstructurasType }
	 * 
	 */
	@ManyToOne(targetEntity = EstructurasType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "ESTRUCTURAS_AED_INSPECCION_HJID")
	public EstructurasType getEstructuras() {
		return estructuras;
	}

	/**
	 * Define el valor de la propiedad estructuras.
	 * 
	 * @param value
	 *            allowed object is {@link EstructurasType }
	 * 
	 */
	public void setEstructuras(EstructurasType value) {
		this.estructuras = value;
	}

	/**
	 * Obtiene el valor de la propiedad cerramientoscubiertas.
	 * 
	 * @return possible object is {@link CerramientoscubiertasType }
	 * 
	 */
	@ManyToOne(targetEntity = CerramientoscubiertasType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "CERRAMIENTOSCUBIERTAS_AED_INSPECCION_HJID")
	public CerramientoscubiertasType getCerramientoscubiertas() {
		return cerramientoscubiertas;
	}

	/**
	 * Define el valor de la propiedad cerramientoscubiertas.
	 * 
	 * @param value
	 *            allowed object is {@link CerramientoscubiertasType }
	 * 
	 */
	public void setCerramientoscubiertas(CerramientoscubiertasType value) {
		this.cerramientoscubiertas = value;
	}

	/**
	 * Obtiene el valor de la propiedad instalaciones.
	 * 
	 * @return possible object is {@link InstalacionesType }
	 * 
	 */
	@ManyToOne(targetEntity = InstalacionesType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "INSTALACIONES_AED_INSPECCION_HJID")
	public InstalacionesType getInstalaciones() {
		return instalaciones;
	}

	/**
	 * Define el valor de la propiedad instalaciones.
	 * 
	 * @param value
	 *            allowed object is {@link InstalacionesType }
	 * 
	 */
	public void setInstalaciones(InstalacionesType value) {
		this.instalaciones = value;
	}

	/**
	 * Obtiene el valor de la propiedad conservacionDatosgenerales.
	 * 
	 * @return possible object is {@link ConservacionDatosgeneralesType }
	 * 
	 */
	@ManyToOne(targetEntity = ConservacionDatosgeneralesType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "CONSERVACION_DATOSGENERALES_AED_INSPECCION_HJID")
	public ConservacionDatosgeneralesType getConservacionDatosgenerales() {
		return conservacionDatosgenerales;
	}

	/**
	 * Define el valor de la propiedad conservacionDatosgenerales.
	 * 
	 * @param value
	 *            allowed object is {@link ConservacionDatosgeneralesType }
	 * 
	 */
	public void setConservacionDatosgenerales(ConservacionDatosgeneralesType value) {
		this.conservacionDatosgenerales = value;
	}

	/**
	 * Obtiene el valor de la propiedad conservacionDatosgeneralesFechavisitas.
	 * 
	 * @return possible object is
	 *         {@link ConservacionDatosgeneralesFechavisitasType }
	 * 
	 */
	@ManyToOne(targetEntity = ConservacionDatosgeneralesFechavisitasType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "CONSERVACION_DATOSGENERALES_FECHAVISITAS_AED_INSPECCION_HJID")
	public ConservacionDatosgeneralesFechavisitasType getConservacionDatosgeneralesFechavisitas() {
		return conservacionDatosgeneralesFechavisitas;
	}

	/**
	 * Define el valor de la propiedad conservacionDatosgeneralesFechavisitas.
	 * 
	 * @param value
	 *            allowed object is
	 *            {@link ConservacionDatosgeneralesFechavisitasType }
	 * 
	 */
	public void setConservacionDatosgeneralesFechavisitas(ConservacionDatosgeneralesFechavisitasType value) {
		this.conservacionDatosgeneralesFechavisitas = value;
	}

	/**
	 * Obtiene el valor de la propiedad conservacionesDocumentaciones.
	 * 
	 * @return possible object is {@link ConservacionesDocumentacionesType }
	 * 
	 */
	@ManyToOne(targetEntity = ConservacionesDocumentacionesType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "CONSERVACIONES_DOCUMENTACIONES_AED_INSPECCION_HJID")
	public ConservacionesDocumentacionesType getConservacionesDocumentaciones() {
		return conservacionesDocumentaciones;
	}

	/**
	 * Define el valor de la propiedad conservacionesDocumentaciones.
	 * 
	 * @param value
	 *            allowed object is {@link ConservacionesDocumentacionesType }
	 * 
	 */
	public void setConservacionesDocumentaciones(ConservacionesDocumentacionesType value) {
		this.conservacionesDocumentaciones = value;
	}

	/**
	 * Obtiene el valor de la propiedad conservacionDocumentacionOtros.
	 * 
	 * @return possible object is {@link ConservacionDocumentacionOtrosType }
	 * 
	 */
	@ManyToOne(targetEntity = ConservacionDocumentacionOtrosType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "CONSERVACION_DOCUMENTACION_OTROS_AED_INSPECCION_HJID")
	public ConservacionDocumentacionOtrosType getConservacionDocumentacionOtros() {
		return conservacionDocumentacionOtros;
	}

	/**
	 * Define el valor de la propiedad conservacionDocumentacionOtros.
	 * 
	 * @param value
	 *            allowed object is {@link ConservacionDocumentacionOtrosType }
	 * 
	 */
	public void setConservacionDocumentacionOtros(ConservacionDocumentacionOtrosType value) {
		this.conservacionDocumentacionOtros = value;
	}

	/**
	 * Obtiene el valor de la propiedad conservacionDatosgeneralesHistoricos.
	 * 
	 * @return possible object is
	 *         {@link ConservacionDatosgeneralesHistoricosType }
	 * 
	 */
	@ManyToOne(targetEntity = ConservacionDatosgeneralesHistoricosType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "CONSERVACION_DATOSGENERALES_HISTORICOS_AED_INSPECCION_HJID")
	public ConservacionDatosgeneralesHistoricosType getConservacionDatosgeneralesHistoricos() {
		return conservacionDatosgeneralesHistoricos;
	}

	/**
	 * Define el valor de la propiedad conservacionDatosgeneralesHistoricos.
	 * 
	 * @param value
	 *            allowed object is
	 *            {@link ConservacionDatosgeneralesHistoricosType }
	 * 
	 */
	public void setConservacionDatosgeneralesHistoricos(ConservacionDatosgeneralesHistoricosType value) {
		this.conservacionDatosgeneralesHistoricos = value;
	}

	/**
	 * Obtiene el valor de la propiedad conservacionDatosgeneralesArchivos.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "CONSERVACION_DATOSGENERALES_ARCHIVOS", length = 255)
	public String getConservacionDatosgeneralesArchivos() {
		return conservacionDatosgeneralesArchivos;
	}

	/**
	 * Define el valor de la propiedad conservacionDatosgeneralesArchivos.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setConservacionDatosgeneralesArchivos(String value) {
		this.conservacionDatosgeneralesArchivos = value;
	}

	/**
	 * Obtiene el valor de la propiedad conservacionPeligrosinminentes.
	 * 
	 * @return possible object is {@link ConservacionPeligrosinminentesType }
	 * 
	 */
	@ManyToOne(targetEntity = ConservacionPeligrosinminentesType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "CONSERVACION_PELIGROSINMINENTES_AED_INSPECCION_HJID")
	public ConservacionPeligrosinminentesType getConservacionPeligrosinminentes() {
		return conservacionPeligrosinminentes;
	}

	/**
	 * Define el valor de la propiedad conservacionPeligrosinminentes.
	 * 
	 * @param value
	 *            allowed object is {@link ConservacionPeligrosinminentesType }
	 * 
	 */
	public void setConservacionPeligrosinminentes(ConservacionPeligrosinminentesType value) {
		this.conservacionPeligrosinminentes = value;
	}

	/**
	 * Obtiene el valor de la propiedad conservacionValoraciones.
	 * 
	 * @return possible object is {@link ConservacionValoracionesType }
	 * 
	 */
	@ManyToOne(targetEntity = ConservacionValoracionesType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "CONSERVACION_VALORACIONES_AED_INSPECCION_HJID")
	public ConservacionValoracionesType getConservacionValoraciones() {
		return conservacionValoraciones;
	}

	/**
	 * Define el valor de la propiedad conservacionValoraciones.
	 * 
	 * @param value
	 *            allowed object is {@link ConservacionValoracionesType }
	 * 
	 */
	public void setConservacionValoraciones(ConservacionValoracionesType value) {
		this.conservacionValoraciones = value;
	}

	/**
	 * Obtiene el valor de la propiedad conservacionValoracionesfinales.
	 * 
	 * @return possible object is {@link ConservacionValoracionesfinalesType }
	 * 
	 */
	@ManyToOne(targetEntity = ConservacionValoracionesfinalesType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "CONSERVACION_VALORACIONESFINALES_AED_INSPECCION_HJID")
	public ConservacionValoracionesfinalesType getConservacionValoracionesfinales() {
		return conservacionValoracionesfinales;
	}

	/**
	 * Define el valor de la propiedad conservacionValoracionesfinales.
	 * 
	 * @param value
	 *            allowed object is {@link ConservacionValoracionesfinalesType }
	 * 
	 */
	public void setConservacionValoracionesfinales(ConservacionValoracionesfinalesType value) {
		this.conservacionValoracionesfinales = value;
	}

	/**
	 * Obtiene el valor de la propiedad conservacionDescripciones.
	 * 
	 * @return possible object is {@link ConservacionDescripcionesType }
	 * 
	 */
	@ManyToOne(targetEntity = ConservacionDescripcionesType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "CONSERVACION_DESCRIPCIONES_AED_INSPECCION_HJID")
	public ConservacionDescripcionesType getConservacionDescripciones() {
		return conservacionDescripciones;
	}

	/**
	 * Define el valor de la propiedad conservacionDescripciones.
	 * 
	 * @param value
	 *            allowed object is {@link ConservacionDescripcionesType }
	 * 
	 */
	public void setConservacionDescripciones(ConservacionDescripcionesType value) {
		this.conservacionDescripciones = value;
	}

	/**
	 * Obtiene el valor de la propiedad accesibilidadPublicos.
	 * 
	 * @return possible object is {@link AccesibilidadPublicosType }
	 * 
	 */
	@ManyToOne(targetEntity = AccesibilidadPublicosType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "ACCESIBILIDAD_PUBLICOS_AED_INSPECCION_HJID")
	public AccesibilidadPublicosType getAccesibilidadPublicos() {
		return accesibilidadPublicos;
	}

	/**
	 * Define el valor de la propiedad accesibilidadPublicos.
	 * 
	 * @param value
	 *            allowed object is {@link AccesibilidadPublicosType }
	 * 
	 */
	public void setAccesibilidadPublicos(AccesibilidadPublicosType value) {
		this.accesibilidadPublicos = value;
	}

	/**
	 * Obtiene el valor de la propiedad accesibilidadValoracionfinales.
	 * 
	 * @return possible object is {@link AccesibilidadValoracionfinalesType }
	 * 
	 */
	@ManyToOne(targetEntity = AccesibilidadValoracionfinalesType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "ACCESIBILIDAD_VALORACIONFINALES_AED_INSPECCION_HJID")
	public AccesibilidadValoracionfinalesType getAccesibilidadValoracionfinales() {
		return accesibilidadValoracionfinales;
	}

	/**
	 * Define el valor de la propiedad accesibilidadValoracionfinales.
	 * 
	 * @param value
	 *            allowed object is {@link AccesibilidadValoracionfinalesType }
	 * 
	 */
	public void setAccesibilidadValoracionfinales(AccesibilidadValoracionfinalesType value) {
		this.accesibilidadValoracionfinales = value;
	}

	/**
	 * Obtiene el valor de la propiedad accesibilidadAjustesrazonables.
	 * 
	 * @return possible object is {@link AccesibilidadAjustesrazonablesType }
	 * 
	 */
	@ManyToOne(targetEntity = AccesibilidadAjustesrazonablesType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "ACCESIBILIDAD_AJUSTESRAZONABLES_AED_INSPECCION_HJID")
	public AccesibilidadAjustesrazonablesType getAccesibilidadAjustesrazonables() {
		return accesibilidadAjustesrazonables;
	}

	/**
	 * Define el valor de la propiedad accesibilidadAjustesrazonables.
	 * 
	 * @param value
	 *            allowed object is {@link AccesibilidadAjustesrazonablesType }
	 * 
	 */
	public void setAccesibilidadAjustesrazonables(AccesibilidadAjustesrazonablesType value) {
		this.accesibilidadAjustesrazonables = value;
	}

	/**
	 * Obtiene el valor de la propiedad accesibilidadAjustesrazonablesCostes.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "ACCESIBILIDAD_AJUSTESRAZONABLES_COSTES", length = 255)
	public String getAccesibilidadAjustesrazonablesCostes() {
		return accesibilidadAjustesrazonablesCostes;
	}

	/**
	 * Define el valor de la propiedad accesibilidadAjustesrazonablesCostes.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setAccesibilidadAjustesrazonablesCostes(String value) {
		this.accesibilidadAjustesrazonablesCostes = value;
	}

	/**
	 * Obtiene el valor de la propiedad eficienciasenergeticas.
	 * 
	 * @return possible object is {@link EficienciasenergeticasType }
	 * 
	 */
	@ManyToOne(targetEntity = EficienciasenergeticasType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "EFICIENCIASENERGETICAS_AED_INSPECCION_HJID")
	public EficienciasenergeticasType getEficienciasenergeticas() {
		return eficienciasenergeticas;
	}

	/**
	 * Define el valor de la propiedad eficienciasenergeticas.
	 * 
	 * @param value
	 *            allowed object is {@link EficienciasenergeticasType }
	 * 
	 */
	public void setEficienciasenergeticas(EficienciasenergeticasType value) {
		this.eficienciasenergeticas = value;
	}

	/**
	 * Obtiene el valor de la propiedad acusticaDatosgenerales.
	 * 
	 * @return possible object is {@link AcusticaDatosgeneralesType }
	 * 
	 */
	@ManyToOne(targetEntity = AcusticaDatosgeneralesType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "ACUSTICA_DATOSGENERALES_AED_INSPECCION_HJID")
	public AcusticaDatosgeneralesType getAcusticaDatosgenerales() {
		return acusticaDatosgenerales;
	}

	/**
	 * Define el valor de la propiedad acusticaDatosgenerales.
	 * 
	 * @param value
	 *            allowed object is {@link AcusticaDatosgeneralesType }
	 * 
	 */
	public void setAcusticaDatosgenerales(AcusticaDatosgeneralesType value) {
		this.acusticaDatosgenerales = value;
	}

	/**
	 * Obtiene el valor de la propiedad acusticaRuidosexteriores.
	 * 
	 * @return possible object is {@link AcusticaRuidosexterioresType }
	 * 
	 */
	@ManyToOne(targetEntity = AcusticaRuidosexterioresType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "ACUSTICA_RUIDOSEXTERIORES_AED_INSPECCION_HJID")
	public AcusticaRuidosexterioresType getAcusticaRuidosexteriores() {
		return acusticaRuidosexteriores;
	}

	/**
	 * Define el valor de la propiedad acusticaRuidosexteriores.
	 * 
	 * @param value
	 *            allowed object is {@link AcusticaRuidosexterioresType }
	 * 
	 */
	public void setAcusticaRuidosexteriores(AcusticaRuidosexterioresType value) {
		this.acusticaRuidosexteriores = value;
	}

	/**
	 * Obtiene el valor de la propiedad acusticaRuidointeriorverticales.
	 * 
	 * @return possible object is {@link AcusticaRuidointeriorverticalesType }
	 * 
	 */
	@ManyToOne(targetEntity = AcusticaRuidointeriorverticalesType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "ACUSTICA_RUIDOINTERIORVERTICALES_AED_INSPECCION_HJID")
	public AcusticaRuidointeriorverticalesType getAcusticaRuidointeriorverticales() {
		return acusticaRuidointeriorverticales;
	}

	/**
	 * Define el valor de la propiedad acusticaRuidointeriorverticales.
	 * 
	 * @param value
	 *            allowed object is {@link AcusticaRuidointeriorverticalesType }
	 * 
	 */
	public void setAcusticaRuidointeriorverticales(AcusticaRuidointeriorverticalesType value) {
		this.acusticaRuidointeriorverticales = value;
	}

	/**
	 * Obtiene el valor de la propiedad acusticaRuidointeriorhorizontales.
	 * 
	 * @return possible object is {@link AcusticaRuidointeriorhorizontalesType }
	 * 
	 */
	@ManyToOne(targetEntity = AcusticaRuidointeriorhorizontalesType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "ACUSTICA_RUIDOINTERIORHORIZONTALES_AED_INSPECCION_HJID")
	public AcusticaRuidointeriorhorizontalesType getAcusticaRuidointeriorhorizontales() {
		return acusticaRuidointeriorhorizontales;
	}

	/**
	 * Define el valor de la propiedad acusticaRuidointeriorhorizontales.
	 * 
	 * @param value
	 *            allowed object is
	 *            {@link AcusticaRuidointeriorhorizontalesType }
	 * 
	 */
	public void setAcusticaRuidointeriorhorizontales(AcusticaRuidointeriorhorizontalesType value) {
		this.acusticaRuidointeriorhorizontales = value;
	}

	/**
	 * Obtiene el valor de la propiedad acusticaRuidointerioruniones.
	 * 
	 * @return possible object is {@link AcusticaRuidointeriorunionesType }
	 * 
	 */
	@ManyToOne(targetEntity = AcusticaRuidointeriorunionesType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "ACUSTICA_RUIDOINTERIORUNIONES_AED_INSPECCION_HJID")
	public AcusticaRuidointeriorunionesType getAcusticaRuidointerioruniones() {
		return acusticaRuidointerioruniones;
	}

	/**
	 * Define el valor de la propiedad acusticaRuidointerioruniones.
	 * 
	 * @param value
	 *            allowed object is {@link AcusticaRuidointeriorunionesType }
	 * 
	 */
	public void setAcusticaRuidointerioruniones(AcusticaRuidointeriorunionesType value) {
		this.acusticaRuidointerioruniones = value;
	}

	/**
	 * Obtiene el valor de la propiedad acusticaRuidoinstalaciones.
	 * 
	 * @return possible object is {@link AcusticaRuidoinstalacionesType }
	 * 
	 */
	@ManyToOne(targetEntity = AcusticaRuidoinstalacionesType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "ACUSTICA_RUIDOINSTALACIONES_AED_INSPECCION_HJID")
	public AcusticaRuidoinstalacionesType getAcusticaRuidoinstalaciones() {
		return acusticaRuidoinstalaciones;
	}

	/**
	 * Define el valor de la propiedad acusticaRuidoinstalaciones.
	 * 
	 * @param value
	 *            allowed object is {@link AcusticaRuidoinstalacionesType }
	 * 
	 */
	public void setAcusticaRuidoinstalaciones(AcusticaRuidoinstalacionesType value) {
		this.acusticaRuidoinstalaciones = value;
	}

	/**
	 * Obtiene el valor de la propiedad acusticaValoracionfinal.
	 * 
	 * @return possible object is {@link AcusticaValoracionfinalType }
	 * 
	 */
	@ManyToOne(targetEntity = AcusticaValoracionfinalType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "ACUSTICA_VALORACIONFINAL_AED_INSPECCION_HJID")
	public AcusticaValoracionfinalType getAcusticaValoracionfinal() {
		return acusticaValoracionfinal;
	}

	/**
	 * Define el valor de la propiedad acusticaValoracionfinal.
	 * 
	 * @param value
	 *            allowed object is {@link AcusticaValoracionfinalType }
	 * 
	 */
	public void setAcusticaValoracionfinal(AcusticaValoracionfinalType value) {
		this.acusticaValoracionfinal = value;
	}

	/**
	 * Obtiene el valor de la propiedad acusticaMejorasacusticas.
	 * 
	 * @return possible object is {@link AcusticaMejorasacusticasType }
	 * 
	 */
	@ManyToOne(targetEntity = AcusticaMejorasacusticasType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "ACUSTICA_MEJORASACUSTICAS_AED_INSPECCION_HJID")
	public AcusticaMejorasacusticasType getAcusticaMejorasacusticas() {
		return acusticaMejorasacusticas;
	}

	/**
	 * Define el valor de la propiedad acusticaMejorasacusticas.
	 * 
	 * @param value
	 *            allowed object is {@link AcusticaMejorasacusticasType }
	 * 
	 */
	public void setAcusticaMejorasacusticas(AcusticaMejorasacusticasType value) {
		this.acusticaMejorasacusticas = value;
	}

	/**
	 * Obtiene el valor de la propiedad acusticaComprobaciones.
	 * 
	 * @return possible object is {@link AcusticaComprobacionesType }
	 * 
	 */
	@ManyToOne(targetEntity = AcusticaComprobacionesType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "ACUSTICA_COMPROBACIONES_AED_INSPECCION_HJID")
	public AcusticaComprobacionesType getAcusticaComprobaciones() {
		return acusticaComprobaciones;
	}

	/**
	 * Define el valor de la propiedad acusticaComprobaciones.
	 * 
	 * @param value
	 *            allowed object is {@link AcusticaComprobacionesType }
	 * 
	 */
	public void setAcusticaComprobaciones(AcusticaComprobacionesType value) {
		this.acusticaComprobaciones = value;
	}

	/**
	 * Obtiene el valor de la propiedad acusticas.
	 * 
	 * @return possible object is {@link AcusticasType }
	 * 
	 */
	@ManyToOne(targetEntity = AcusticasType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "ACUSTICAS_AED_INSPECCION_HJID")
	public AcusticasType getAcusticas() {
		return acusticas;
	}

	/**
	 * Define el valor de la propiedad acusticas.
	 * 
	 * @param value
	 *            allowed object is {@link AcusticasType }
	 * 
	 */
	public void setAcusticas(AcusticasType value) {
		this.acusticas = value;
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
		final InspeccionType that = ((InspeccionType) object);
		{
			int lhsIeeCompleta;
			lhsIeeCompleta = this.getIeeCompleta();
			int rhsIeeCompleta;
			rhsIeeCompleta = that.getIeeCompleta();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "ieeCompleta", lhsIeeCompleta), LocatorUtils.property(thatLocator, "ieeCompleta", rhsIeeCompleta), lhsIeeCompleta, rhsIeeCompleta)) {
				return false;
			}
		}
		{
			InspeccionIdentificacionedificiosType lhsInspeccionIdentificacionedificios;
			lhsInspeccionIdentificacionedificios = this.getInspeccionIdentificacionedificios();
			InspeccionIdentificacionedificiosType rhsInspeccionIdentificacionedificios;
			rhsInspeccionIdentificacionedificios = that.getInspeccionIdentificacionedificios();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "inspeccionIdentificacionedificios", lhsInspeccionIdentificacionedificios), LocatorUtils.property(thatLocator, "inspeccionIdentificacionedificios", rhsInspeccionIdentificacionedificios), lhsInspeccionIdentificacionedificios, rhsInspeccionIdentificacionedificios)) {
				return false;
			}
		}
		{
			InspeccionIdentificacionedificioDireccionesType lhsInspeccionIdentificacionedificioDirecciones;
			lhsInspeccionIdentificacionedificioDirecciones = this.getInspeccionIdentificacionedificioDirecciones();
			InspeccionIdentificacionedificioDireccionesType rhsInspeccionIdentificacionedificioDirecciones;
			rhsInspeccionIdentificacionedificioDirecciones = that.getInspeccionIdentificacionedificioDirecciones();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "inspeccionIdentificacionedificioDirecciones", lhsInspeccionIdentificacionedificioDirecciones), LocatorUtils.property(thatLocator, "inspeccionIdentificacionedificioDirecciones", rhsInspeccionIdentificacionedificioDirecciones), lhsInspeccionIdentificacionedificioDirecciones, rhsInspeccionIdentificacionedificioDirecciones)) {
				return false;
			}
		}
		{
			InspeccionIdentificacionedificioReferenciacatastralesType lhsInspeccionIdentificacionedificioReferenciacatastrales;
			lhsInspeccionIdentificacionedificioReferenciacatastrales = this.getInspeccionIdentificacionedificioReferenciacatastrales();
			InspeccionIdentificacionedificioReferenciacatastralesType rhsInspeccionIdentificacionedificioReferenciacatastrales;
			rhsInspeccionIdentificacionedificioReferenciacatastrales = that.getInspeccionIdentificacionedificioReferenciacatastrales();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "inspeccionIdentificacionedificioReferenciacatastrales", lhsInspeccionIdentificacionedificioReferenciacatastrales), LocatorUtils.property(thatLocator, "inspeccionIdentificacionedificioReferenciacatastrales", rhsInspeccionIdentificacionedificioReferenciacatastrales), lhsInspeccionIdentificacionedificioReferenciacatastrales, rhsInspeccionIdentificacionedificioReferenciacatastrales)) {
				return false;
			}
		}
		{
			InspeccionPropiedadesType lhsInspeccionPropiedades;
			lhsInspeccionPropiedades = this.getInspeccionPropiedades();
			InspeccionPropiedadesType rhsInspeccionPropiedades;
			rhsInspeccionPropiedades = that.getInspeccionPropiedades();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "inspeccionPropiedades", lhsInspeccionPropiedades), LocatorUtils.property(thatLocator, "inspeccionPropiedades", rhsInspeccionPropiedades), lhsInspeccionPropiedades, rhsInspeccionPropiedades)) {
				return false;
			}
		}
		{
			InspeccionRepresentantesType lhsInspeccionRepresentantes;
			lhsInspeccionRepresentantes = this.getInspeccionRepresentantes();
			InspeccionRepresentantesType rhsInspeccionRepresentantes;
			rhsInspeccionRepresentantes = that.getInspeccionRepresentantes();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "inspeccionRepresentantes", lhsInspeccionRepresentantes), LocatorUtils.property(thatLocator, "inspeccionRepresentantes", rhsInspeccionRepresentantes), lhsInspeccionRepresentantes, rhsInspeccionRepresentantes)) {
				return false;
			}
		}
		{
			InspeccionTecnicosType lhsInspeccionTecnicos;
			lhsInspeccionTecnicos = this.getInspeccionTecnicos();
			InspeccionTecnicosType rhsInspeccionTecnicos;
			rhsInspeccionTecnicos = that.getInspeccionTecnicos();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "inspeccionTecnicos", lhsInspeccionTecnicos), LocatorUtils.property(thatLocator, "inspeccionTecnicos", rhsInspeccionTecnicos), lhsInspeccionTecnicos, rhsInspeccionTecnicos)) {
				return false;
			}
		}
		{
			InspeccionDatosedificiosType lhsInspeccionDatosedificios;
			lhsInspeccionDatosedificios = this.getInspeccionDatosedificios();
			InspeccionDatosedificiosType rhsInspeccionDatosedificios;
			rhsInspeccionDatosedificios = that.getInspeccionDatosedificios();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "inspeccionDatosedificios", lhsInspeccionDatosedificios), LocatorUtils.property(thatLocator, "inspeccionDatosedificios", rhsInspeccionDatosedificios), lhsInspeccionDatosedificios, rhsInspeccionDatosedificios)) {
				return false;
			}
		}
		{
			CimentacionesType lhsCimentaciones;
			lhsCimentaciones = this.getCimentaciones();
			CimentacionesType rhsCimentaciones;
			rhsCimentaciones = that.getCimentaciones();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "cimentaciones", lhsCimentaciones), LocatorUtils.property(thatLocator, "cimentaciones", rhsCimentaciones), lhsCimentaciones, rhsCimentaciones)) {
				return false;
			}
		}
		{
			EstructurasType lhsEstructuras;
			lhsEstructuras = this.getEstructuras();
			EstructurasType rhsEstructuras;
			rhsEstructuras = that.getEstructuras();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "estructuras", lhsEstructuras), LocatorUtils.property(thatLocator, "estructuras", rhsEstructuras), lhsEstructuras, rhsEstructuras)) {
				return false;
			}
		}
		{
			CerramientoscubiertasType lhsCerramientoscubiertas;
			lhsCerramientoscubiertas = this.getCerramientoscubiertas();
			CerramientoscubiertasType rhsCerramientoscubiertas;
			rhsCerramientoscubiertas = that.getCerramientoscubiertas();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "cerramientoscubiertas", lhsCerramientoscubiertas), LocatorUtils.property(thatLocator, "cerramientoscubiertas", rhsCerramientoscubiertas), lhsCerramientoscubiertas, rhsCerramientoscubiertas)) {
				return false;
			}
		}
		{
			InstalacionesType lhsInstalaciones;
			lhsInstalaciones = this.getInstalaciones();
			InstalacionesType rhsInstalaciones;
			rhsInstalaciones = that.getInstalaciones();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "instalaciones", lhsInstalaciones), LocatorUtils.property(thatLocator, "instalaciones", rhsInstalaciones), lhsInstalaciones, rhsInstalaciones)) {
				return false;
			}
		}
		{
			ConservacionDatosgeneralesType lhsConservacionDatosgenerales;
			lhsConservacionDatosgenerales = this.getConservacionDatosgenerales();
			ConservacionDatosgeneralesType rhsConservacionDatosgenerales;
			rhsConservacionDatosgenerales = that.getConservacionDatosgenerales();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "conservacionDatosgenerales", lhsConservacionDatosgenerales), LocatorUtils.property(thatLocator, "conservacionDatosgenerales", rhsConservacionDatosgenerales), lhsConservacionDatosgenerales, rhsConservacionDatosgenerales)) {
				return false;
			}
		}
		{
			ConservacionDatosgeneralesFechavisitasType lhsConservacionDatosgeneralesFechavisitas;
			lhsConservacionDatosgeneralesFechavisitas = this.getConservacionDatosgeneralesFechavisitas();
			ConservacionDatosgeneralesFechavisitasType rhsConservacionDatosgeneralesFechavisitas;
			rhsConservacionDatosgeneralesFechavisitas = that.getConservacionDatosgeneralesFechavisitas();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "conservacionDatosgeneralesFechavisitas", lhsConservacionDatosgeneralesFechavisitas), LocatorUtils.property(thatLocator, "conservacionDatosgeneralesFechavisitas", rhsConservacionDatosgeneralesFechavisitas), lhsConservacionDatosgeneralesFechavisitas, rhsConservacionDatosgeneralesFechavisitas)) {
				return false;
			}
		}
		{
			ConservacionesDocumentacionesType lhsConservacionesDocumentaciones;
			lhsConservacionesDocumentaciones = this.getConservacionesDocumentaciones();
			ConservacionesDocumentacionesType rhsConservacionesDocumentaciones;
			rhsConservacionesDocumentaciones = that.getConservacionesDocumentaciones();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "conservacionesDocumentaciones", lhsConservacionesDocumentaciones), LocatorUtils.property(thatLocator, "conservacionesDocumentaciones", rhsConservacionesDocumentaciones), lhsConservacionesDocumentaciones, rhsConservacionesDocumentaciones)) {
				return false;
			}
		}
		{
			ConservacionDocumentacionOtrosType lhsConservacionDocumentacionOtros;
			lhsConservacionDocumentacionOtros = this.getConservacionDocumentacionOtros();
			ConservacionDocumentacionOtrosType rhsConservacionDocumentacionOtros;
			rhsConservacionDocumentacionOtros = that.getConservacionDocumentacionOtros();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "conservacionDocumentacionOtros", lhsConservacionDocumentacionOtros), LocatorUtils.property(thatLocator, "conservacionDocumentacionOtros", rhsConservacionDocumentacionOtros), lhsConservacionDocumentacionOtros, rhsConservacionDocumentacionOtros)) {
				return false;
			}
		}
		{
			ConservacionDatosgeneralesHistoricosType lhsConservacionDatosgeneralesHistoricos;
			lhsConservacionDatosgeneralesHistoricos = this.getConservacionDatosgeneralesHistoricos();
			ConservacionDatosgeneralesHistoricosType rhsConservacionDatosgeneralesHistoricos;
			rhsConservacionDatosgeneralesHistoricos = that.getConservacionDatosgeneralesHistoricos();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "conservacionDatosgeneralesHistoricos", lhsConservacionDatosgeneralesHistoricos), LocatorUtils.property(thatLocator, "conservacionDatosgeneralesHistoricos", rhsConservacionDatosgeneralesHistoricos), lhsConservacionDatosgeneralesHistoricos, rhsConservacionDatosgeneralesHistoricos)) {
				return false;
			}
		}
		{
			String lhsConservacionDatosgeneralesArchivos;
			lhsConservacionDatosgeneralesArchivos = this.getConservacionDatosgeneralesArchivos();
			String rhsConservacionDatosgeneralesArchivos;
			rhsConservacionDatosgeneralesArchivos = that.getConservacionDatosgeneralesArchivos();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "conservacionDatosgeneralesArchivos", lhsConservacionDatosgeneralesArchivos), LocatorUtils.property(thatLocator, "conservacionDatosgeneralesArchivos", rhsConservacionDatosgeneralesArchivos), lhsConservacionDatosgeneralesArchivos, rhsConservacionDatosgeneralesArchivos)) {
				return false;
			}
		}
		{
			ConservacionPeligrosinminentesType lhsConservacionPeligrosinminentes;
			lhsConservacionPeligrosinminentes = this.getConservacionPeligrosinminentes();
			ConservacionPeligrosinminentesType rhsConservacionPeligrosinminentes;
			rhsConservacionPeligrosinminentes = that.getConservacionPeligrosinminentes();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "conservacionPeligrosinminentes", lhsConservacionPeligrosinminentes), LocatorUtils.property(thatLocator, "conservacionPeligrosinminentes", rhsConservacionPeligrosinminentes), lhsConservacionPeligrosinminentes, rhsConservacionPeligrosinminentes)) {
				return false;
			}
		}
		{
			ConservacionValoracionesType lhsConservacionValoraciones;
			lhsConservacionValoraciones = this.getConservacionValoraciones();
			ConservacionValoracionesType rhsConservacionValoraciones;
			rhsConservacionValoraciones = that.getConservacionValoraciones();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "conservacionValoraciones", lhsConservacionValoraciones), LocatorUtils.property(thatLocator, "conservacionValoraciones", rhsConservacionValoraciones), lhsConservacionValoraciones, rhsConservacionValoraciones)) {
				return false;
			}
		}
		{
			ConservacionValoracionesfinalesType lhsConservacionValoracionesfinales;
			lhsConservacionValoracionesfinales = this.getConservacionValoracionesfinales();
			ConservacionValoracionesfinalesType rhsConservacionValoracionesfinales;
			rhsConservacionValoracionesfinales = that.getConservacionValoracionesfinales();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "conservacionValoracionesfinales", lhsConservacionValoracionesfinales), LocatorUtils.property(thatLocator, "conservacionValoracionesfinales", rhsConservacionValoracionesfinales), lhsConservacionValoracionesfinales, rhsConservacionValoracionesfinales)) {
				return false;
			}
		}
		{
			ConservacionDescripcionesType lhsConservacionDescripciones;
			lhsConservacionDescripciones = this.getConservacionDescripciones();
			ConservacionDescripcionesType rhsConservacionDescripciones;
			rhsConservacionDescripciones = that.getConservacionDescripciones();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "conservacionDescripciones", lhsConservacionDescripciones), LocatorUtils.property(thatLocator, "conservacionDescripciones", rhsConservacionDescripciones), lhsConservacionDescripciones, rhsConservacionDescripciones)) {
				return false;
			}
		}
		{
			AccesibilidadPublicosType lhsAccesibilidadPublicos;
			lhsAccesibilidadPublicos = this.getAccesibilidadPublicos();
			AccesibilidadPublicosType rhsAccesibilidadPublicos;
			rhsAccesibilidadPublicos = that.getAccesibilidadPublicos();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "accesibilidadPublicos", lhsAccesibilidadPublicos), LocatorUtils.property(thatLocator, "accesibilidadPublicos", rhsAccesibilidadPublicos), lhsAccesibilidadPublicos, rhsAccesibilidadPublicos)) {
				return false;
			}
		}
		{
			AccesibilidadValoracionfinalesType lhsAccesibilidadValoracionfinales;
			lhsAccesibilidadValoracionfinales = this.getAccesibilidadValoracionfinales();
			AccesibilidadValoracionfinalesType rhsAccesibilidadValoracionfinales;
			rhsAccesibilidadValoracionfinales = that.getAccesibilidadValoracionfinales();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "accesibilidadValoracionfinales", lhsAccesibilidadValoracionfinales), LocatorUtils.property(thatLocator, "accesibilidadValoracionfinales", rhsAccesibilidadValoracionfinales), lhsAccesibilidadValoracionfinales, rhsAccesibilidadValoracionfinales)) {
				return false;
			}
		}
		{
			AccesibilidadAjustesrazonablesType lhsAccesibilidadAjustesrazonables;
			lhsAccesibilidadAjustesrazonables = this.getAccesibilidadAjustesrazonables();
			AccesibilidadAjustesrazonablesType rhsAccesibilidadAjustesrazonables;
			rhsAccesibilidadAjustesrazonables = that.getAccesibilidadAjustesrazonables();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "accesibilidadAjustesrazonables", lhsAccesibilidadAjustesrazonables), LocatorUtils.property(thatLocator, "accesibilidadAjustesrazonables", rhsAccesibilidadAjustesrazonables), lhsAccesibilidadAjustesrazonables, rhsAccesibilidadAjustesrazonables)) {
				return false;
			}
		}
		{
			String lhsAccesibilidadAjustesrazonablesCostes;
			lhsAccesibilidadAjustesrazonablesCostes = this.getAccesibilidadAjustesrazonablesCostes();
			String rhsAccesibilidadAjustesrazonablesCostes;
			rhsAccesibilidadAjustesrazonablesCostes = that.getAccesibilidadAjustesrazonablesCostes();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "accesibilidadAjustesrazonablesCostes", lhsAccesibilidadAjustesrazonablesCostes), LocatorUtils.property(thatLocator, "accesibilidadAjustesrazonablesCostes", rhsAccesibilidadAjustesrazonablesCostes), lhsAccesibilidadAjustesrazonablesCostes, rhsAccesibilidadAjustesrazonablesCostes)) {
				return false;
			}
		}
		{
			EficienciasenergeticasType lhsEficienciasenergeticas;
			lhsEficienciasenergeticas = this.getEficienciasenergeticas();
			EficienciasenergeticasType rhsEficienciasenergeticas;
			rhsEficienciasenergeticas = that.getEficienciasenergeticas();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "eficienciasenergeticas", lhsEficienciasenergeticas), LocatorUtils.property(thatLocator, "eficienciasenergeticas", rhsEficienciasenergeticas), lhsEficienciasenergeticas, rhsEficienciasenergeticas)) {
				return false;
			}
		}
		{
			AcusticaDatosgeneralesType lhsAcusticaDatosgenerales;
			lhsAcusticaDatosgenerales = this.getAcusticaDatosgenerales();
			AcusticaDatosgeneralesType rhsAcusticaDatosgenerales;
			rhsAcusticaDatosgenerales = that.getAcusticaDatosgenerales();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "acusticaDatosgenerales", lhsAcusticaDatosgenerales), LocatorUtils.property(thatLocator, "acusticaDatosgenerales", rhsAcusticaDatosgenerales), lhsAcusticaDatosgenerales, rhsAcusticaDatosgenerales)) {
				return false;
			}
		}
		{
			AcusticaRuidosexterioresType lhsAcusticaRuidosexteriores;
			lhsAcusticaRuidosexteriores = this.getAcusticaRuidosexteriores();
			AcusticaRuidosexterioresType rhsAcusticaRuidosexteriores;
			rhsAcusticaRuidosexteriores = that.getAcusticaRuidosexteriores();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "acusticaRuidosexteriores", lhsAcusticaRuidosexteriores), LocatorUtils.property(thatLocator, "acusticaRuidosexteriores", rhsAcusticaRuidosexteriores), lhsAcusticaRuidosexteriores, rhsAcusticaRuidosexteriores)) {
				return false;
			}
		}
		{
			AcusticaRuidointeriorverticalesType lhsAcusticaRuidointeriorverticales;
			lhsAcusticaRuidointeriorverticales = this.getAcusticaRuidointeriorverticales();
			AcusticaRuidointeriorverticalesType rhsAcusticaRuidointeriorverticales;
			rhsAcusticaRuidointeriorverticales = that.getAcusticaRuidointeriorverticales();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "acusticaRuidointeriorverticales", lhsAcusticaRuidointeriorverticales), LocatorUtils.property(thatLocator, "acusticaRuidointeriorverticales", rhsAcusticaRuidointeriorverticales), lhsAcusticaRuidointeriorverticales, rhsAcusticaRuidointeriorverticales)) {
				return false;
			}
		}
		{
			AcusticaRuidointeriorhorizontalesType lhsAcusticaRuidointeriorhorizontales;
			lhsAcusticaRuidointeriorhorizontales = this.getAcusticaRuidointeriorhorizontales();
			AcusticaRuidointeriorhorizontalesType rhsAcusticaRuidointeriorhorizontales;
			rhsAcusticaRuidointeriorhorizontales = that.getAcusticaRuidointeriorhorizontales();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "acusticaRuidointeriorhorizontales", lhsAcusticaRuidointeriorhorizontales), LocatorUtils.property(thatLocator, "acusticaRuidointeriorhorizontales", rhsAcusticaRuidointeriorhorizontales), lhsAcusticaRuidointeriorhorizontales, rhsAcusticaRuidointeriorhorizontales)) {
				return false;
			}
		}
		{
			AcusticaRuidointeriorunionesType lhsAcusticaRuidointerioruniones;
			lhsAcusticaRuidointerioruniones = this.getAcusticaRuidointerioruniones();
			AcusticaRuidointeriorunionesType rhsAcusticaRuidointerioruniones;
			rhsAcusticaRuidointerioruniones = that.getAcusticaRuidointerioruniones();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "acusticaRuidointerioruniones", lhsAcusticaRuidointerioruniones), LocatorUtils.property(thatLocator, "acusticaRuidointerioruniones", rhsAcusticaRuidointerioruniones), lhsAcusticaRuidointerioruniones, rhsAcusticaRuidointerioruniones)) {
				return false;
			}
		}
		{
			AcusticaRuidoinstalacionesType lhsAcusticaRuidoinstalaciones;
			lhsAcusticaRuidoinstalaciones = this.getAcusticaRuidoinstalaciones();
			AcusticaRuidoinstalacionesType rhsAcusticaRuidoinstalaciones;
			rhsAcusticaRuidoinstalaciones = that.getAcusticaRuidoinstalaciones();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "acusticaRuidoinstalaciones", lhsAcusticaRuidoinstalaciones), LocatorUtils.property(thatLocator, "acusticaRuidoinstalaciones", rhsAcusticaRuidoinstalaciones), lhsAcusticaRuidoinstalaciones, rhsAcusticaRuidoinstalaciones)) {
				return false;
			}
		}
		{
			AcusticaValoracionfinalType lhsAcusticaValoracionfinal;
			lhsAcusticaValoracionfinal = this.getAcusticaValoracionfinal();
			AcusticaValoracionfinalType rhsAcusticaValoracionfinal;
			rhsAcusticaValoracionfinal = that.getAcusticaValoracionfinal();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "acusticaValoracionfinal", lhsAcusticaValoracionfinal), LocatorUtils.property(thatLocator, "acusticaValoracionfinal", rhsAcusticaValoracionfinal), lhsAcusticaValoracionfinal, rhsAcusticaValoracionfinal)) {
				return false;
			}
		}
		{
			AcusticaMejorasacusticasType lhsAcusticaMejorasacusticas;
			lhsAcusticaMejorasacusticas = this.getAcusticaMejorasacusticas();
			AcusticaMejorasacusticasType rhsAcusticaMejorasacusticas;
			rhsAcusticaMejorasacusticas = that.getAcusticaMejorasacusticas();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "acusticaMejorasacusticas", lhsAcusticaMejorasacusticas), LocatorUtils.property(thatLocator, "acusticaMejorasacusticas", rhsAcusticaMejorasacusticas), lhsAcusticaMejorasacusticas, rhsAcusticaMejorasacusticas)) {
				return false;
			}
		}
		{
			AcusticaComprobacionesType lhsAcusticaComprobaciones;
			lhsAcusticaComprobaciones = this.getAcusticaComprobaciones();
			AcusticaComprobacionesType rhsAcusticaComprobaciones;
			rhsAcusticaComprobaciones = that.getAcusticaComprobaciones();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "acusticaComprobaciones", lhsAcusticaComprobaciones), LocatorUtils.property(thatLocator, "acusticaComprobaciones", rhsAcusticaComprobaciones), lhsAcusticaComprobaciones, rhsAcusticaComprobaciones)) {
				return false;
			}
		}
		{
			AcusticasType lhsAcusticas;
			lhsAcusticas = this.getAcusticas();
			AcusticasType rhsAcusticas;
			rhsAcusticas = that.getAcusticas();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "acusticas", lhsAcusticas), LocatorUtils.property(thatLocator, "acusticas", rhsAcusticas), lhsAcusticas, rhsAcusticas)) {
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
			int theIeeCompleta;
			theIeeCompleta = this.getIeeCompleta();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "ieeCompleta", theIeeCompleta), currentHashCode, theIeeCompleta);
		}
		{
			InspeccionIdentificacionedificiosType theInspeccionIdentificacionedificios;
			theInspeccionIdentificacionedificios = this.getInspeccionIdentificacionedificios();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "inspeccionIdentificacionedificios", theInspeccionIdentificacionedificios), currentHashCode, theInspeccionIdentificacionedificios);
		}
		{
			InspeccionIdentificacionedificioDireccionesType theInspeccionIdentificacionedificioDirecciones;
			theInspeccionIdentificacionedificioDirecciones = this.getInspeccionIdentificacionedificioDirecciones();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "inspeccionIdentificacionedificioDirecciones", theInspeccionIdentificacionedificioDirecciones), currentHashCode, theInspeccionIdentificacionedificioDirecciones);
		}
		{
			InspeccionIdentificacionedificioReferenciacatastralesType theInspeccionIdentificacionedificioReferenciacatastrales;
			theInspeccionIdentificacionedificioReferenciacatastrales = this.getInspeccionIdentificacionedificioReferenciacatastrales();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "inspeccionIdentificacionedificioReferenciacatastrales", theInspeccionIdentificacionedificioReferenciacatastrales), currentHashCode, theInspeccionIdentificacionedificioReferenciacatastrales);
		}
		{
			InspeccionPropiedadesType theInspeccionPropiedades;
			theInspeccionPropiedades = this.getInspeccionPropiedades();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "inspeccionPropiedades", theInspeccionPropiedades), currentHashCode, theInspeccionPropiedades);
		}
		{
			InspeccionRepresentantesType theInspeccionRepresentantes;
			theInspeccionRepresentantes = this.getInspeccionRepresentantes();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "inspeccionRepresentantes", theInspeccionRepresentantes), currentHashCode, theInspeccionRepresentantes);
		}
		{
			InspeccionTecnicosType theInspeccionTecnicos;
			theInspeccionTecnicos = this.getInspeccionTecnicos();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "inspeccionTecnicos", theInspeccionTecnicos), currentHashCode, theInspeccionTecnicos);
		}
		{
			InspeccionDatosedificiosType theInspeccionDatosedificios;
			theInspeccionDatosedificios = this.getInspeccionDatosedificios();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "inspeccionDatosedificios", theInspeccionDatosedificios), currentHashCode, theInspeccionDatosedificios);
		}
		{
			CimentacionesType theCimentaciones;
			theCimentaciones = this.getCimentaciones();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "cimentaciones", theCimentaciones), currentHashCode, theCimentaciones);
		}
		{
			EstructurasType theEstructuras;
			theEstructuras = this.getEstructuras();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "estructuras", theEstructuras), currentHashCode, theEstructuras);
		}
		{
			CerramientoscubiertasType theCerramientoscubiertas;
			theCerramientoscubiertas = this.getCerramientoscubiertas();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "cerramientoscubiertas", theCerramientoscubiertas), currentHashCode, theCerramientoscubiertas);
		}
		{
			InstalacionesType theInstalaciones;
			theInstalaciones = this.getInstalaciones();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "instalaciones", theInstalaciones), currentHashCode, theInstalaciones);
		}
		{
			ConservacionDatosgeneralesType theConservacionDatosgenerales;
			theConservacionDatosgenerales = this.getConservacionDatosgenerales();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "conservacionDatosgenerales", theConservacionDatosgenerales), currentHashCode, theConservacionDatosgenerales);
		}
		{
			ConservacionDatosgeneralesFechavisitasType theConservacionDatosgeneralesFechavisitas;
			theConservacionDatosgeneralesFechavisitas = this.getConservacionDatosgeneralesFechavisitas();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "conservacionDatosgeneralesFechavisitas", theConservacionDatosgeneralesFechavisitas), currentHashCode, theConservacionDatosgeneralesFechavisitas);
		}
		{
			ConservacionesDocumentacionesType theConservacionesDocumentaciones;
			theConservacionesDocumentaciones = this.getConservacionesDocumentaciones();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "conservacionesDocumentaciones", theConservacionesDocumentaciones), currentHashCode, theConservacionesDocumentaciones);
		}
		{
			ConservacionDocumentacionOtrosType theConservacionDocumentacionOtros;
			theConservacionDocumentacionOtros = this.getConservacionDocumentacionOtros();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "conservacionDocumentacionOtros", theConservacionDocumentacionOtros), currentHashCode, theConservacionDocumentacionOtros);
		}
		{
			ConservacionDatosgeneralesHistoricosType theConservacionDatosgeneralesHistoricos;
			theConservacionDatosgeneralesHistoricos = this.getConservacionDatosgeneralesHistoricos();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "conservacionDatosgeneralesHistoricos", theConservacionDatosgeneralesHistoricos), currentHashCode, theConservacionDatosgeneralesHistoricos);
		}
		{
			String theConservacionDatosgeneralesArchivos;
			theConservacionDatosgeneralesArchivos = this.getConservacionDatosgeneralesArchivos();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "conservacionDatosgeneralesArchivos", theConservacionDatosgeneralesArchivos), currentHashCode, theConservacionDatosgeneralesArchivos);
		}
		{
			ConservacionPeligrosinminentesType theConservacionPeligrosinminentes;
			theConservacionPeligrosinminentes = this.getConservacionPeligrosinminentes();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "conservacionPeligrosinminentes", theConservacionPeligrosinminentes), currentHashCode, theConservacionPeligrosinminentes);
		}
		{
			ConservacionValoracionesType theConservacionValoraciones;
			theConservacionValoraciones = this.getConservacionValoraciones();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "conservacionValoraciones", theConservacionValoraciones), currentHashCode, theConservacionValoraciones);
		}
		{
			ConservacionValoracionesfinalesType theConservacionValoracionesfinales;
			theConservacionValoracionesfinales = this.getConservacionValoracionesfinales();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "conservacionValoracionesfinales", theConservacionValoracionesfinales), currentHashCode, theConservacionValoracionesfinales);
		}
		{
			ConservacionDescripcionesType theConservacionDescripciones;
			theConservacionDescripciones = this.getConservacionDescripciones();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "conservacionDescripciones", theConservacionDescripciones), currentHashCode, theConservacionDescripciones);
		}
		{
			AccesibilidadPublicosType theAccesibilidadPublicos;
			theAccesibilidadPublicos = this.getAccesibilidadPublicos();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "accesibilidadPublicos", theAccesibilidadPublicos), currentHashCode, theAccesibilidadPublicos);
		}
		{
			AccesibilidadValoracionfinalesType theAccesibilidadValoracionfinales;
			theAccesibilidadValoracionfinales = this.getAccesibilidadValoracionfinales();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "accesibilidadValoracionfinales", theAccesibilidadValoracionfinales), currentHashCode, theAccesibilidadValoracionfinales);
		}
		{
			AccesibilidadAjustesrazonablesType theAccesibilidadAjustesrazonables;
			theAccesibilidadAjustesrazonables = this.getAccesibilidadAjustesrazonables();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "accesibilidadAjustesrazonables", theAccesibilidadAjustesrazonables), currentHashCode, theAccesibilidadAjustesrazonables);
		}
		{
			String theAccesibilidadAjustesrazonablesCostes;
			theAccesibilidadAjustesrazonablesCostes = this.getAccesibilidadAjustesrazonablesCostes();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "accesibilidadAjustesrazonablesCostes", theAccesibilidadAjustesrazonablesCostes), currentHashCode, theAccesibilidadAjustesrazonablesCostes);
		}
		{
			EficienciasenergeticasType theEficienciasenergeticas;
			theEficienciasenergeticas = this.getEficienciasenergeticas();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "eficienciasenergeticas", theEficienciasenergeticas), currentHashCode, theEficienciasenergeticas);
		}
		{
			AcusticaDatosgeneralesType theAcusticaDatosgenerales;
			theAcusticaDatosgenerales = this.getAcusticaDatosgenerales();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "acusticaDatosgenerales", theAcusticaDatosgenerales), currentHashCode, theAcusticaDatosgenerales);
		}
		{
			AcusticaRuidosexterioresType theAcusticaRuidosexteriores;
			theAcusticaRuidosexteriores = this.getAcusticaRuidosexteriores();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "acusticaRuidosexteriores", theAcusticaRuidosexteriores), currentHashCode, theAcusticaRuidosexteriores);
		}
		{
			AcusticaRuidointeriorverticalesType theAcusticaRuidointeriorverticales;
			theAcusticaRuidointeriorverticales = this.getAcusticaRuidointeriorverticales();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "acusticaRuidointeriorverticales", theAcusticaRuidointeriorverticales), currentHashCode, theAcusticaRuidointeriorverticales);
		}
		{
			AcusticaRuidointeriorhorizontalesType theAcusticaRuidointeriorhorizontales;
			theAcusticaRuidointeriorhorizontales = this.getAcusticaRuidointeriorhorizontales();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "acusticaRuidointeriorhorizontales", theAcusticaRuidointeriorhorizontales), currentHashCode, theAcusticaRuidointeriorhorizontales);
		}
		{
			AcusticaRuidointeriorunionesType theAcusticaRuidointerioruniones;
			theAcusticaRuidointerioruniones = this.getAcusticaRuidointerioruniones();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "acusticaRuidointerioruniones", theAcusticaRuidointerioruniones), currentHashCode, theAcusticaRuidointerioruniones);
		}
		{
			AcusticaRuidoinstalacionesType theAcusticaRuidoinstalaciones;
			theAcusticaRuidoinstalaciones = this.getAcusticaRuidoinstalaciones();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "acusticaRuidoinstalaciones", theAcusticaRuidoinstalaciones), currentHashCode, theAcusticaRuidoinstalaciones);
		}
		{
			AcusticaValoracionfinalType theAcusticaValoracionfinal;
			theAcusticaValoracionfinal = this.getAcusticaValoracionfinal();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "acusticaValoracionfinal", theAcusticaValoracionfinal), currentHashCode, theAcusticaValoracionfinal);
		}
		{
			AcusticaMejorasacusticasType theAcusticaMejorasacusticas;
			theAcusticaMejorasacusticas = this.getAcusticaMejorasacusticas();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "acusticaMejorasacusticas", theAcusticaMejorasacusticas), currentHashCode, theAcusticaMejorasacusticas);
		}
		{
			AcusticaComprobacionesType theAcusticaComprobaciones;
			theAcusticaComprobaciones = this.getAcusticaComprobaciones();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "acusticaComprobaciones", theAcusticaComprobaciones), currentHashCode, theAcusticaComprobaciones);
		}
		{
			AcusticasType theAcusticas;
			theAcusticas = this.getAcusticas();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "acusticas", theAcusticas), currentHashCode, theAcusticas);
		}
		return currentHashCode;
	}

	public int hashCode() {
		final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
		return this.hashCode(null, strategy);
	}

}
