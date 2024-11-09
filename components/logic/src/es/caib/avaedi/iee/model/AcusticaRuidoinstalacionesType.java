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
 * Clase Java para acustica_ruidoinstalacionesType complex type.
 * 
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que
 * haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="acustica_ruidoinstalacionesType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="recintos_actividad_tiene" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="recintos_actividad_tipo_localizacion" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="recintos_actividad_revestido" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="recintos_actividad_tratamiento_absorvente" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="recintos_actividad_trasdosados" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="recintos_actividad_trasdosados_amortiguadores" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="recintos_actividad_suelo_flotante" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="recintos_actividad_techo_suspendido" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="recintos_actividad_techo_suspendido_amortiguadores" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="recintos_actividad_techo_suspendido_absorvente" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="recintos_actividad_ruido_molesto" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="recintos_actividad_ruido_molesto_tipo_localizacion" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="equipos_instalaciones_colindantes" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="equipos_instalaciones_zonas_exteriores" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="equipos_instalaciones_zonas_exteriores_pantallas" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="equipos_instalaciones_sistema_amortiguante" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="equipos_instalaciones_conectores_flexibles" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="equipos_instalaciones_conductos_anclados" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="equipos_instalaciones_holguras_selladas" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="equipos_instalaciones_ruido_molesto" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="equipos_instalaciones_ruido_molesto_tipo_localizacion" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="redes_saneamiento_codo_bajante" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="redes_saneamiento_bajantes_revestidas" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="redes_saneamiento_bajantes_forradas" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="redes_saneamiento_bajantes_abrazaderas" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="redes_saneamiento_ruido_molesto" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="redes_saneamiento_ruido_molesto_tipo_localizacion" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="redes_suministro_agua_tuberias_forradas" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="redes_suministro_agua_ruido_golpe_ariete" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="redes_suministro_agua_ruido_molesto" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="redes_agua_ruido_molesto_tipo_localizacion" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="redes_aire_acondicionado_ruido_molesto" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="redes_aire_acondicionado_falso_techo" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="redes_ventilacion_conductos_shunt" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="redes_ventilacion_ruido_viviendas_colindantes" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="redes_ventilacion_conducto_individual" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="otras_ascensores_colindantes" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="otras_ascensores_cuarto_maquinas" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="otras_ascensores_sistema_amortiguante" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="otras_ascensores_trasdosado" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="otras_ascensores_cuadro_maniobras" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="otras_ascensores_ruido_molesto" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="otras_ascensores_ruido_molesto_tipo_localizacion" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="otras_cuartos_humedos_saneamiento" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="otras_cuartos_humedos_saneamiento_lana_mineral" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="otras_cuartos_humedos_saneamiento_techo_sellado" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="otras_cuartos_humedos_saneamiento_material_elastico" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="otras_cuartos_humedos_saneamiento_conectores_flexibles" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="otras_cuartos_humedos_aire_acondicionado" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="otras_cuartos_humedos_luminarias_empotradas" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="otras_cuartos_humedos_ruido_molesto" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="otras_cuartos_humedos_ruido_molesto_tipo_localizacion" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="otras_puertas_garaje_ancladas" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="otras_puertas_garaje_ancladas_motores_amortiguadores" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="otras_puertas_garaje_ancladas_marco_amortiguadores" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="otras_puertas_garaje_ancladas_ruido_puerta" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
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
@XmlType(name = "acustica_ruidoinstalacionesType", propOrder = { "recintosActividadTiene", "recintosActividadTipoLocalizacion", "recintosActividadRevestido", "recintosActividadTratamientoAbsorvente", "recintosActividadTrasdosados", "recintosActividadTrasdosadosAmortiguadores", "recintosActividadSueloFlotante", "recintosActividadTechoSuspendido", "recintosActividadTechoSuspendidoAmortiguadores", "recintosActividadTechoSuspendidoAbsorvente", "recintosActividadRuidoMolesto", "recintosActividadRuidoMolestoTipoLocalizacion", "equiposInstalacionesColindantes", "equiposInstalacionesZonasExteriores", "equiposInstalacionesZonasExterioresPantallas", "equiposInstalacionesSistemaAmortiguante", "equiposInstalacionesConectoresFlexibles", "equiposInstalacionesConductosAnclados", "equiposInstalacionesHolgurasSelladas", "equiposInstalacionesRuidoMolesto", "equiposInstalacionesRuidoMolestoTipoLocalizacion", "redesSaneamientoCodoBajante", "redesSaneamientoBajantesRevestidas", "redesSaneamientoBajantesForradas", "redesSaneamientoBajantesAbrazaderas", "redesSaneamientoRuidoMolesto", "redesSaneamientoRuidoMolestoTipoLocalizacion", "redesSuministroAguaTuberiasForradas", "redesSuministroAguaRuidoGolpeAriete", "redesSuministroAguaRuidoMolesto", "redesAguaRuidoMolestoTipoLocalizacion", "redesAireAcondicionadoRuidoMolesto", "redesAireAcondicionadoFalsoTecho", "redesVentilacionConductosShunt", "redesVentilacionRuidoViviendasColindantes", "redesVentilacionConductoIndividual", "otrasAscensoresColindantes", "otrasAscensoresCuartoMaquinas", "otrasAscensoresSistemaAmortiguante", "otrasAscensoresTrasdosado", "otrasAscensoresCuadroManiobras", "otrasAscensoresRuidoMolesto", "otrasAscensoresRuidoMolestoTipoLocalizacion", "otrasCuartosHumedosSaneamiento", "otrasCuartosHumedosSaneamientoLanaMineral", "otrasCuartosHumedosSaneamientoTechoSellado", "otrasCuartosHumedosSaneamientoMaterialElastico", "otrasCuartosHumedosSaneamientoConectoresFlexibles", "otrasCuartosHumedosAireAcondicionado", "otrasCuartosHumedosLuminariasEmpotradas", "otrasCuartosHumedosRuidoMolesto", "otrasCuartosHumedosRuidoMolestoTipoLocalizacion", "otrasPuertasGarajeAncladas", "otrasPuertasGarajeAncladasMotoresAmortiguadores", "otrasPuertasGarajeAncladasMarcoAmortiguadores", "otrasPuertasGarajeAncladasRuidoPuerta", "observaciones" })
@Entity(name = "AcusticaRuidoinstalacionesType")
@Table(name = "AED_ACU_RUIDOINSTALACIONES")
@Inheritance(strategy = InheritanceType.JOINED)
public class AcusticaRuidoinstalacionesType implements Serializable, Equals, HashCode {

	@XmlElement(name = "recintos_actividad_tiene")
	protected int recintosActividadTiene;
	@XmlElement(name = "recintos_actividad_tipo_localizacion", required = true)
	protected String recintosActividadTipoLocalizacion;
	@XmlElement(name = "recintos_actividad_revestido")
	protected int recintosActividadRevestido;
	@XmlElement(name = "recintos_actividad_tratamiento_absorvente")
	protected int recintosActividadTratamientoAbsorvente;
	@XmlElement(name = "recintos_actividad_trasdosados")
	protected int recintosActividadTrasdosados;
	@XmlElement(name = "recintos_actividad_trasdosados_amortiguadores")
	protected int recintosActividadTrasdosadosAmortiguadores;
	@XmlElement(name = "recintos_actividad_suelo_flotante")
	protected int recintosActividadSueloFlotante;
	@XmlElement(name = "recintos_actividad_techo_suspendido")
	protected int recintosActividadTechoSuspendido;
	@XmlElement(name = "recintos_actividad_techo_suspendido_amortiguadores")
	protected int recintosActividadTechoSuspendidoAmortiguadores;
	@XmlElement(name = "recintos_actividad_techo_suspendido_absorvente")
	protected int recintosActividadTechoSuspendidoAbsorvente;
	@XmlElement(name = "recintos_actividad_ruido_molesto")
	protected int recintosActividadRuidoMolesto;
	@XmlElement(name = "recintos_actividad_ruido_molesto_tipo_localizacion", required = true)
	protected String recintosActividadRuidoMolestoTipoLocalizacion;
	@XmlElement(name = "equipos_instalaciones_colindantes")
	protected int equiposInstalacionesColindantes;
	@XmlElement(name = "equipos_instalaciones_zonas_exteriores")
	protected int equiposInstalacionesZonasExteriores;
	@XmlElement(name = "equipos_instalaciones_zonas_exteriores_pantallas")
	protected int equiposInstalacionesZonasExterioresPantallas;
	@XmlElement(name = "equipos_instalaciones_sistema_amortiguante")
	protected int equiposInstalacionesSistemaAmortiguante;
	@XmlElement(name = "equipos_instalaciones_conectores_flexibles")
	protected int equiposInstalacionesConectoresFlexibles;
	@XmlElement(name = "equipos_instalaciones_conductos_anclados")
	protected int equiposInstalacionesConductosAnclados;
	@XmlElement(name = "equipos_instalaciones_holguras_selladas")
	protected int equiposInstalacionesHolgurasSelladas;
	@XmlElement(name = "equipos_instalaciones_ruido_molesto")
	protected int equiposInstalacionesRuidoMolesto;
	@XmlElement(name = "equipos_instalaciones_ruido_molesto_tipo_localizacion", required = true)
	protected String equiposInstalacionesRuidoMolestoTipoLocalizacion;
	@XmlElement(name = "redes_saneamiento_codo_bajante")
	protected int redesSaneamientoCodoBajante;
	@XmlElement(name = "redes_saneamiento_bajantes_revestidas")
	protected int redesSaneamientoBajantesRevestidas;
	@XmlElement(name = "redes_saneamiento_bajantes_forradas")
	protected int redesSaneamientoBajantesForradas;
	@XmlElement(name = "redes_saneamiento_bajantes_abrazaderas")
	protected int redesSaneamientoBajantesAbrazaderas;
	@XmlElement(name = "redes_saneamiento_ruido_molesto")
	protected int redesSaneamientoRuidoMolesto;
	@XmlElement(name = "redes_saneamiento_ruido_molesto_tipo_localizacion", required = true)
	protected String redesSaneamientoRuidoMolestoTipoLocalizacion;
	@XmlElement(name = "redes_suministro_agua_tuberias_forradas")
	protected int redesSuministroAguaTuberiasForradas;
	@XmlElement(name = "redes_suministro_agua_ruido_golpe_ariete")
	protected int redesSuministroAguaRuidoGolpeAriete;
	@XmlElement(name = "redes_suministro_agua_ruido_molesto")
	protected int redesSuministroAguaRuidoMolesto;
	@XmlElement(name = "redes_agua_ruido_molesto_tipo_localizacion", required = true)
	protected String redesAguaRuidoMolestoTipoLocalizacion;
	@XmlElement(name = "redes_aire_acondicionado_ruido_molesto")
	protected int redesAireAcondicionadoRuidoMolesto;
	@XmlElement(name = "redes_aire_acondicionado_falso_techo")
	protected int redesAireAcondicionadoFalsoTecho;
	@XmlElement(name = "redes_ventilacion_conductos_shunt")
	protected int redesVentilacionConductosShunt;
	@XmlElement(name = "redes_ventilacion_ruido_viviendas_colindantes")
	protected int redesVentilacionRuidoViviendasColindantes;
	@XmlElement(name = "redes_ventilacion_conducto_individual")
	protected int redesVentilacionConductoIndividual;
	@XmlElement(name = "otras_ascensores_colindantes")
	protected int otrasAscensoresColindantes;
	@XmlElement(name = "otras_ascensores_cuarto_maquinas")
	protected int otrasAscensoresCuartoMaquinas;
	@XmlElement(name = "otras_ascensores_sistema_amortiguante")
	protected int otrasAscensoresSistemaAmortiguante;
	@XmlElement(name = "otras_ascensores_trasdosado")
	protected int otrasAscensoresTrasdosado;
	@XmlElement(name = "otras_ascensores_cuadro_maniobras")
	protected int otrasAscensoresCuadroManiobras;
	@XmlElement(name = "otras_ascensores_ruido_molesto")
	protected int otrasAscensoresRuidoMolesto;
	@XmlElement(name = "otras_ascensores_ruido_molesto_tipo_localizacion", required = true)
	protected String otrasAscensoresRuidoMolestoTipoLocalizacion;
	@XmlElement(name = "otras_cuartos_humedos_saneamiento")
	protected int otrasCuartosHumedosSaneamiento;
	@XmlElement(name = "otras_cuartos_humedos_saneamiento_lana_mineral")
	protected int otrasCuartosHumedosSaneamientoLanaMineral;
	@XmlElement(name = "otras_cuartos_humedos_saneamiento_techo_sellado")
	protected int otrasCuartosHumedosSaneamientoTechoSellado;
	@XmlElement(name = "otras_cuartos_humedos_saneamiento_material_elastico")
	protected int otrasCuartosHumedosSaneamientoMaterialElastico;
	@XmlElement(name = "otras_cuartos_humedos_saneamiento_conectores_flexibles")
	protected int otrasCuartosHumedosSaneamientoConectoresFlexibles;
	@XmlElement(name = "otras_cuartos_humedos_aire_acondicionado")
	protected int otrasCuartosHumedosAireAcondicionado;
	@XmlElement(name = "otras_cuartos_humedos_luminarias_empotradas")
	protected int otrasCuartosHumedosLuminariasEmpotradas;
	@XmlElement(name = "otras_cuartos_humedos_ruido_molesto")
	protected int otrasCuartosHumedosRuidoMolesto;
	@XmlElement(name = "otras_cuartos_humedos_ruido_molesto_tipo_localizacion", required = true)
	protected String otrasCuartosHumedosRuidoMolestoTipoLocalizacion;
	@XmlElement(name = "otras_puertas_garaje_ancladas")
	protected int otrasPuertasGarajeAncladas;
	@XmlElement(name = "otras_puertas_garaje_ancladas_motores_amortiguadores")
	protected int otrasPuertasGarajeAncladasMotoresAmortiguadores;
	@XmlElement(name = "otras_puertas_garaje_ancladas_marco_amortiguadores")
	protected int otrasPuertasGarajeAncladasMarcoAmortiguadores;
	@XmlElement(name = "otras_puertas_garaje_ancladas_ruido_puerta")
	protected int otrasPuertasGarajeAncladasRuidoPuerta;
	@XmlElement(required = true)
	protected String observaciones;
	@XmlAttribute(name = "Hjid")
	protected Long hjid;

	/**
	 * Obtiene el valor de la propiedad recintosActividadTiene.
	 * 
	 */
	@Basic
	@Column(name = "RECINTOS_ACTIVIDAD_TIENE", precision = 10, scale = 0)
	public int getRecintosActividadTiene() {
		return recintosActividadTiene;
	}

	/**
	 * Define el valor de la propiedad recintosActividadTiene.
	 * 
	 */
	public void setRecintosActividadTiene(int value) {
		this.recintosActividadTiene = value;
	}

	/**
	 * Obtiene el valor de la propiedad recintosActividadTipoLocalizacion.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "RECINTOS_ACTIVIDAD_TIPO_LOCALIZACION", length = 255)
	public String getRecintosActividadTipoLocalizacion() {
		return recintosActividadTipoLocalizacion;
	}

	/**
	 * Define el valor de la propiedad recintosActividadTipoLocalizacion.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRecintosActividadTipoLocalizacion(String value) {
		this.recintosActividadTipoLocalizacion = value;
	}

	/**
	 * Obtiene el valor de la propiedad recintosActividadRevestido.
	 * 
	 */
	@Basic
	@Column(name = "RECINTOS_ACTIVIDAD_REVESTIDO", precision = 10, scale = 0)
	public int getRecintosActividadRevestido() {
		return recintosActividadRevestido;
	}

	/**
	 * Define el valor de la propiedad recintosActividadRevestido.
	 * 
	 */
	public void setRecintosActividadRevestido(int value) {
		this.recintosActividadRevestido = value;
	}

	/**
	 * Obtiene el valor de la propiedad recintosActividadTratamientoAbsorvente.
	 * 
	 */
	@Basic
	@Column(name = "RECINTOS_ACTIVIDAD_TRATAMIENTO_ABSORVENTE", precision = 10, scale = 0)
	public int getRecintosActividadTratamientoAbsorvente() {
		return recintosActividadTratamientoAbsorvente;
	}

	/**
	 * Define el valor de la propiedad recintosActividadTratamientoAbsorvente.
	 * 
	 */
	public void setRecintosActividadTratamientoAbsorvente(int value) {
		this.recintosActividadTratamientoAbsorvente = value;
	}

	/**
	 * Obtiene el valor de la propiedad recintosActividadTrasdosados.
	 * 
	 */
	@Basic
	@Column(name = "RECINTOS_ACTIVIDAD_TRASDOSADOS", precision = 10, scale = 0)
	public int getRecintosActividadTrasdosados() {
		return recintosActividadTrasdosados;
	}

	/**
	 * Define el valor de la propiedad recintosActividadTrasdosados.
	 * 
	 */
	public void setRecintosActividadTrasdosados(int value) {
		this.recintosActividadTrasdosados = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * recintosActividadTrasdosadosAmortiguadores.
	 * 
	 */
	@Basic
	@Column(name = "RECINTOS_ACTIVIDAD_TRASDOSADOS_AMORTIGUADORES", precision = 10, scale = 0)
	public int getRecintosActividadTrasdosadosAmortiguadores() {
		return recintosActividadTrasdosadosAmortiguadores;
	}

	/**
	 * Define el valor de la propiedad
	 * recintosActividadTrasdosadosAmortiguadores.
	 * 
	 */
	public void setRecintosActividadTrasdosadosAmortiguadores(int value) {
		this.recintosActividadTrasdosadosAmortiguadores = value;
	}

	/**
	 * Obtiene el valor de la propiedad recintosActividadSueloFlotante.
	 * 
	 */
	@Basic
	@Column(name = "RECINTOS_ACTIVIDAD_SUELO_FLOTANTE", precision = 10, scale = 0)
	public int getRecintosActividadSueloFlotante() {
		return recintosActividadSueloFlotante;
	}

	/**
	 * Define el valor de la propiedad recintosActividadSueloFlotante.
	 * 
	 */
	public void setRecintosActividadSueloFlotante(int value) {
		this.recintosActividadSueloFlotante = value;
	}

	/**
	 * Obtiene el valor de la propiedad recintosActividadTechoSuspendido.
	 * 
	 */
	@Basic
	@Column(name = "RECINTOS_ACTIVIDAD_TECHO_SUSPENDIDO", precision = 10, scale = 0)
	public int getRecintosActividadTechoSuspendido() {
		return recintosActividadTechoSuspendido;
	}

	/**
	 * Define el valor de la propiedad recintosActividadTechoSuspendido.
	 * 
	 */
	public void setRecintosActividadTechoSuspendido(int value) {
		this.recintosActividadTechoSuspendido = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * recintosActividadTechoSuspendidoAmortiguadores.
	 * 
	 */
	@Basic
	@Column(name = "RECINTOS_ACTIVIDAD_TECHO_SUSPENDIDO_AMORTIGUADORES", precision = 10, scale = 0)
	public int getRecintosActividadTechoSuspendidoAmortiguadores() {
		return recintosActividadTechoSuspendidoAmortiguadores;
	}

	/**
	 * Define el valor de la propiedad
	 * recintosActividadTechoSuspendidoAmortiguadores.
	 * 
	 */
	public void setRecintosActividadTechoSuspendidoAmortiguadores(int value) {
		this.recintosActividadTechoSuspendidoAmortiguadores = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * recintosActividadTechoSuspendidoAbsorvente.
	 * 
	 */
	@Basic
	@Column(name = "RECINTOS_ACTIVIDAD_TECHO_SUSPENDIDO_ABSORVENTE", precision = 10, scale = 0)
	public int getRecintosActividadTechoSuspendidoAbsorvente() {
		return recintosActividadTechoSuspendidoAbsorvente;
	}

	/**
	 * Define el valor de la propiedad
	 * recintosActividadTechoSuspendidoAbsorvente.
	 * 
	 */
	public void setRecintosActividadTechoSuspendidoAbsorvente(int value) {
		this.recintosActividadTechoSuspendidoAbsorvente = value;
	}

	/**
	 * Obtiene el valor de la propiedad recintosActividadRuidoMolesto.
	 * 
	 */
	@Basic
	@Column(name = "RECINTOS_ACTIVIDAD_RUIDO_MOLESTO", precision = 10, scale = 0)
	public int getRecintosActividadRuidoMolesto() {
		return recintosActividadRuidoMolesto;
	}

	/**
	 * Define el valor de la propiedad recintosActividadRuidoMolesto.
	 * 
	 */
	public void setRecintosActividadRuidoMolesto(int value) {
		this.recintosActividadRuidoMolesto = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * recintosActividadRuidoMolestoTipoLocalizacion.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "RECINTOS_ACTIVIDAD_RUIDO_MOLESTO_TIPO_LOCALIZACION", length = 255)
	public String getRecintosActividadRuidoMolestoTipoLocalizacion() {
		return recintosActividadRuidoMolestoTipoLocalizacion;
	}

	/**
	 * Define el valor de la propiedad
	 * recintosActividadRuidoMolestoTipoLocalizacion.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRecintosActividadRuidoMolestoTipoLocalizacion(String value) {
		this.recintosActividadRuidoMolestoTipoLocalizacion = value;
	}

	/**
	 * Obtiene el valor de la propiedad equiposInstalacionesColindantes.
	 * 
	 */
	@Basic
	@Column(name = "EQUIPOS_INSTALACIONES_COLINDANTES", precision = 10, scale = 0)
	public int getEquiposInstalacionesColindantes() {
		return equiposInstalacionesColindantes;
	}

	/**
	 * Define el valor de la propiedad equiposInstalacionesColindantes.
	 * 
	 */
	public void setEquiposInstalacionesColindantes(int value) {
		this.equiposInstalacionesColindantes = value;
	}

	/**
	 * Obtiene el valor de la propiedad equiposInstalacionesZonasExteriores.
	 * 
	 */
	@Basic
	@Column(name = "EQUIPOS_INSTALACIONES_ZONAS_EXTERIORES", precision = 10, scale = 0)
	public int getEquiposInstalacionesZonasExteriores() {
		return equiposInstalacionesZonasExteriores;
	}

	/**
	 * Define el valor de la propiedad equiposInstalacionesZonasExteriores.
	 * 
	 */
	public void setEquiposInstalacionesZonasExteriores(int value) {
		this.equiposInstalacionesZonasExteriores = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * equiposInstalacionesZonasExterioresPantallas.
	 * 
	 */
	@Basic
	@Column(name = "EQUIPOS_INSTALACIONES_ZONAS_EXTERIORES_PANTALLAS", precision = 10, scale = 0)
	public int getEquiposInstalacionesZonasExterioresPantallas() {
		return equiposInstalacionesZonasExterioresPantallas;
	}

	/**
	 * Define el valor de la propiedad
	 * equiposInstalacionesZonasExterioresPantallas.
	 * 
	 */
	public void setEquiposInstalacionesZonasExterioresPantallas(int value) {
		this.equiposInstalacionesZonasExterioresPantallas = value;
	}

	/**
	 * Obtiene el valor de la propiedad equiposInstalacionesSistemaAmortiguante.
	 * 
	 */
	@Basic
	@Column(name = "EQUIPOS_INSTALACIONES_SISTEMA_AMORTIGUANTE", precision = 10, scale = 0)
	public int getEquiposInstalacionesSistemaAmortiguante() {
		return equiposInstalacionesSistemaAmortiguante;
	}

	/**
	 * Define el valor de la propiedad equiposInstalacionesSistemaAmortiguante.
	 * 
	 */
	public void setEquiposInstalacionesSistemaAmortiguante(int value) {
		this.equiposInstalacionesSistemaAmortiguante = value;
	}

	/**
	 * Obtiene el valor de la propiedad equiposInstalacionesConectoresFlexibles.
	 * 
	 */
	@Basic
	@Column(name = "EQUIPOS_INSTALACIONES_CONECTORES_FLEXIBLES", precision = 10, scale = 0)
	public int getEquiposInstalacionesConectoresFlexibles() {
		return equiposInstalacionesConectoresFlexibles;
	}

	/**
	 * Define el valor de la propiedad equiposInstalacionesConectoresFlexibles.
	 * 
	 */
	public void setEquiposInstalacionesConectoresFlexibles(int value) {
		this.equiposInstalacionesConectoresFlexibles = value;
	}

	/**
	 * Obtiene el valor de la propiedad equiposInstalacionesConductosAnclados.
	 * 
	 */
	@Basic
	@Column(name = "EQUIPOS_INSTALACIONES_CONDUCTOS_ANCLADOS", precision = 10, scale = 0)
	public int getEquiposInstalacionesConductosAnclados() {
		return equiposInstalacionesConductosAnclados;
	}

	/**
	 * Define el valor de la propiedad equiposInstalacionesConductosAnclados.
	 * 
	 */
	public void setEquiposInstalacionesConductosAnclados(int value) {
		this.equiposInstalacionesConductosAnclados = value;
	}

	/**
	 * Obtiene el valor de la propiedad equiposInstalacionesHolgurasSelladas.
	 * 
	 */
	@Basic
	@Column(name = "EQUIPOS_INSTALACIONES_HOLGURAS_SELLADAS", precision = 10, scale = 0)
	public int getEquiposInstalacionesHolgurasSelladas() {
		return equiposInstalacionesHolgurasSelladas;
	}

	/**
	 * Define el valor de la propiedad equiposInstalacionesHolgurasSelladas.
	 * 
	 */
	public void setEquiposInstalacionesHolgurasSelladas(int value) {
		this.equiposInstalacionesHolgurasSelladas = value;
	}

	/**
	 * Obtiene el valor de la propiedad equiposInstalacionesRuidoMolesto.
	 * 
	 */
	@Basic
	@Column(name = "EQUIPOS_INSTALACIONES_RUIDO_MOLESTO", precision = 10, scale = 0)
	public int getEquiposInstalacionesRuidoMolesto() {
		return equiposInstalacionesRuidoMolesto;
	}

	/**
	 * Define el valor de la propiedad equiposInstalacionesRuidoMolesto.
	 * 
	 */
	public void setEquiposInstalacionesRuidoMolesto(int value) {
		this.equiposInstalacionesRuidoMolesto = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * equiposInstalacionesRuidoMolestoTipoLocalizacion.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "EQUIPOS_INSTALACIONES_RUIDO_MOLESTO_TIPO_LOCALIZACION", length = 255)
	public String getEquiposInstalacionesRuidoMolestoTipoLocalizacion() {
		return equiposInstalacionesRuidoMolestoTipoLocalizacion;
	}

	/**
	 * Define el valor de la propiedad
	 * equiposInstalacionesRuidoMolestoTipoLocalizacion.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setEquiposInstalacionesRuidoMolestoTipoLocalizacion(String value) {
		this.equiposInstalacionesRuidoMolestoTipoLocalizacion = value;
	}

	/**
	 * Obtiene el valor de la propiedad redesSaneamientoCodoBajante.
	 * 
	 */
	@Basic
	@Column(name = "REDES_SANEAMIENTO_CODO_BAJANTE", precision = 10, scale = 0)
	public int getRedesSaneamientoCodoBajante() {
		return redesSaneamientoCodoBajante;
	}

	/**
	 * Define el valor de la propiedad redesSaneamientoCodoBajante.
	 * 
	 */
	public void setRedesSaneamientoCodoBajante(int value) {
		this.redesSaneamientoCodoBajante = value;
	}

	/**
	 * Obtiene el valor de la propiedad redesSaneamientoBajantesRevestidas.
	 * 
	 */
	@Basic
	@Column(name = "REDES_SANEAMIENTO_BAJANTES_REVESTIDAS", precision = 10, scale = 0)
	public int getRedesSaneamientoBajantesRevestidas() {
		return redesSaneamientoBajantesRevestidas;
	}

	/**
	 * Define el valor de la propiedad redesSaneamientoBajantesRevestidas.
	 * 
	 */
	public void setRedesSaneamientoBajantesRevestidas(int value) {
		this.redesSaneamientoBajantesRevestidas = value;
	}

	/**
	 * Obtiene el valor de la propiedad redesSaneamientoBajantesForradas.
	 * 
	 */
	@Basic
	@Column(name = "REDES_SANEAMIENTO_BAJANTES_FORRADAS", precision = 10, scale = 0)
	public int getRedesSaneamientoBajantesForradas() {
		return redesSaneamientoBajantesForradas;
	}

	/**
	 * Define el valor de la propiedad redesSaneamientoBajantesForradas.
	 * 
	 */
	public void setRedesSaneamientoBajantesForradas(int value) {
		this.redesSaneamientoBajantesForradas = value;
	}

	/**
	 * Obtiene el valor de la propiedad redesSaneamientoBajantesAbrazaderas.
	 * 
	 */
	@Basic
	@Column(name = "REDES_SANEAMIENTO_BAJANTES_ABRAZADERAS", precision = 10, scale = 0)
	public int getRedesSaneamientoBajantesAbrazaderas() {
		return redesSaneamientoBajantesAbrazaderas;
	}

	/**
	 * Define el valor de la propiedad redesSaneamientoBajantesAbrazaderas.
	 * 
	 */
	public void setRedesSaneamientoBajantesAbrazaderas(int value) {
		this.redesSaneamientoBajantesAbrazaderas = value;
	}

	/**
	 * Obtiene el valor de la propiedad redesSaneamientoRuidoMolesto.
	 * 
	 */
	@Basic
	@Column(name = "REDES_SANEAMIENTO_RUIDO_MOLESTO", precision = 10, scale = 0)
	public int getRedesSaneamientoRuidoMolesto() {
		return redesSaneamientoRuidoMolesto;
	}

	/**
	 * Define el valor de la propiedad redesSaneamientoRuidoMolesto.
	 * 
	 */
	public void setRedesSaneamientoRuidoMolesto(int value) {
		this.redesSaneamientoRuidoMolesto = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * redesSaneamientoRuidoMolestoTipoLocalizacion.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "REDES_SANEAMIENTO_RUIDO_MOLESTO_TIPO_LOCALIZACION", length = 255)
	public String getRedesSaneamientoRuidoMolestoTipoLocalizacion() {
		return redesSaneamientoRuidoMolestoTipoLocalizacion;
	}

	/**
	 * Define el valor de la propiedad
	 * redesSaneamientoRuidoMolestoTipoLocalizacion.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRedesSaneamientoRuidoMolestoTipoLocalizacion(String value) {
		this.redesSaneamientoRuidoMolestoTipoLocalizacion = value;
	}

	/**
	 * Obtiene el valor de la propiedad redesSuministroAguaTuberiasForradas.
	 * 
	 */
	@Basic
	@Column(name = "REDES_SUMINISTRO_AGUA_TUBERIAS_FORRADAS", precision = 10, scale = 0)
	public int getRedesSuministroAguaTuberiasForradas() {
		return redesSuministroAguaTuberiasForradas;
	}

	/**
	 * Define el valor de la propiedad redesSuministroAguaTuberiasForradas.
	 * 
	 */
	public void setRedesSuministroAguaTuberiasForradas(int value) {
		this.redesSuministroAguaTuberiasForradas = value;
	}

	/**
	 * Obtiene el valor de la propiedad redesSuministroAguaRuidoGolpeAriete.
	 * 
	 */
	@Basic
	@Column(name = "REDES_SUMINISTRO_AGUA_RUIDO_GOLPE_ARIETE", precision = 10, scale = 0)
	public int getRedesSuministroAguaRuidoGolpeAriete() {
		return redesSuministroAguaRuidoGolpeAriete;
	}

	/**
	 * Define el valor de la propiedad redesSuministroAguaRuidoGolpeAriete.
	 * 
	 */
	public void setRedesSuministroAguaRuidoGolpeAriete(int value) {
		this.redesSuministroAguaRuidoGolpeAriete = value;
	}

	/**
	 * Obtiene el valor de la propiedad redesSuministroAguaRuidoMolesto.
	 * 
	 */
	@Basic
	@Column(name = "REDES_SUMINISTRO_AGUA_RUIDO_MOLESTO", precision = 10, scale = 0)
	public int getRedesSuministroAguaRuidoMolesto() {
		return redesSuministroAguaRuidoMolesto;
	}

	/**
	 * Define el valor de la propiedad redesSuministroAguaRuidoMolesto.
	 * 
	 */
	public void setRedesSuministroAguaRuidoMolesto(int value) {
		this.redesSuministroAguaRuidoMolesto = value;
	}

	/**
	 * Obtiene el valor de la propiedad redesAguaRuidoMolestoTipoLocalizacion.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "REDES_AGUA_RUIDO_MOLESTO_TIPO_LOCALIZACION", length = 255)
	public String getRedesAguaRuidoMolestoTipoLocalizacion() {
		return redesAguaRuidoMolestoTipoLocalizacion;
	}

	/**
	 * Define el valor de la propiedad redesAguaRuidoMolestoTipoLocalizacion.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRedesAguaRuidoMolestoTipoLocalizacion(String value) {
		this.redesAguaRuidoMolestoTipoLocalizacion = value;
	}

	/**
	 * Obtiene el valor de la propiedad redesAireAcondicionadoRuidoMolesto.
	 * 
	 */
	@Basic
	@Column(name = "REDES_AIRE_ACONDICIONADO_RUIDO_MOLESTO", precision = 10, scale = 0)
	public int getRedesAireAcondicionadoRuidoMolesto() {
		return redesAireAcondicionadoRuidoMolesto;
	}

	/**
	 * Define el valor de la propiedad redesAireAcondicionadoRuidoMolesto.
	 * 
	 */
	public void setRedesAireAcondicionadoRuidoMolesto(int value) {
		this.redesAireAcondicionadoRuidoMolesto = value;
	}

	/**
	 * Obtiene el valor de la propiedad redesAireAcondicionadoFalsoTecho.
	 * 
	 */
	@Basic
	@Column(name = "REDES_AIRE_ACONDICIONADO_FALSO_TECHO", precision = 10, scale = 0)
	public int getRedesAireAcondicionadoFalsoTecho() {
		return redesAireAcondicionadoFalsoTecho;
	}

	/**
	 * Define el valor de la propiedad redesAireAcondicionadoFalsoTecho.
	 * 
	 */
	public void setRedesAireAcondicionadoFalsoTecho(int value) {
		this.redesAireAcondicionadoFalsoTecho = value;
	}

	/**
	 * Obtiene el valor de la propiedad redesVentilacionConductosShunt.
	 * 
	 */
	@Basic
	@Column(name = "REDES_VENTILACION_CONDUCTOS_SHUNT", precision = 10, scale = 0)
	public int getRedesVentilacionConductosShunt() {
		return redesVentilacionConductosShunt;
	}

	/**
	 * Define el valor de la propiedad redesVentilacionConductosShunt.
	 * 
	 */
	public void setRedesVentilacionConductosShunt(int value) {
		this.redesVentilacionConductosShunt = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * redesVentilacionRuidoViviendasColindantes.
	 * 
	 */
	@Basic
	@Column(name = "REDES_VENTILACION_RUIDO_VIVIENDAS_COLINDANTES", precision = 10, scale = 0)
	public int getRedesVentilacionRuidoViviendasColindantes() {
		return redesVentilacionRuidoViviendasColindantes;
	}

	/**
	 * Define el valor de la propiedad
	 * redesVentilacionRuidoViviendasColindantes.
	 * 
	 */
	public void setRedesVentilacionRuidoViviendasColindantes(int value) {
		this.redesVentilacionRuidoViviendasColindantes = value;
	}

	/**
	 * Obtiene el valor de la propiedad redesVentilacionConductoIndividual.
	 * 
	 */
	@Basic
	@Column(name = "REDES_VENTILACION_CONDUCTO_INDIVIDUAL", precision = 10, scale = 0)
	public int getRedesVentilacionConductoIndividual() {
		return redesVentilacionConductoIndividual;
	}

	/**
	 * Define el valor de la propiedad redesVentilacionConductoIndividual.
	 * 
	 */
	public void setRedesVentilacionConductoIndividual(int value) {
		this.redesVentilacionConductoIndividual = value;
	}

	/**
	 * Obtiene el valor de la propiedad otrasAscensoresColindantes.
	 * 
	 */
	@Basic
	@Column(name = "OTRAS_ASCENSORES_COLINDANTES", precision = 10, scale = 0)
	public int getOtrasAscensoresColindantes() {
		return otrasAscensoresColindantes;
	}

	/**
	 * Define el valor de la propiedad otrasAscensoresColindantes.
	 * 
	 */
	public void setOtrasAscensoresColindantes(int value) {
		this.otrasAscensoresColindantes = value;
	}

	/**
	 * Obtiene el valor de la propiedad otrasAscensoresCuartoMaquinas.
	 * 
	 */
	@Basic
	@Column(name = "OTRAS_ASCENSORES_CUARTO_MAQUINAS", precision = 10, scale = 0)
	public int getOtrasAscensoresCuartoMaquinas() {
		return otrasAscensoresCuartoMaquinas;
	}

	/**
	 * Define el valor de la propiedad otrasAscensoresCuartoMaquinas.
	 * 
	 */
	public void setOtrasAscensoresCuartoMaquinas(int value) {
		this.otrasAscensoresCuartoMaquinas = value;
	}

	/**
	 * Obtiene el valor de la propiedad otrasAscensoresSistemaAmortiguante.
	 * 
	 */
	@Basic
	@Column(name = "OTRAS_ASCENSORES_SISTEMA_AMORTIGUANTE", precision = 10, scale = 0)
	public int getOtrasAscensoresSistemaAmortiguante() {
		return otrasAscensoresSistemaAmortiguante;
	}

	/**
	 * Define el valor de la propiedad otrasAscensoresSistemaAmortiguante.
	 * 
	 */
	public void setOtrasAscensoresSistemaAmortiguante(int value) {
		this.otrasAscensoresSistemaAmortiguante = value;
	}

	/**
	 * Obtiene el valor de la propiedad otrasAscensoresTrasdosado.
	 * 
	 */
	@Basic
	@Column(name = "OTRAS_ASCENSORES_TRASDOSADO", precision = 10, scale = 0)
	public int getOtrasAscensoresTrasdosado() {
		return otrasAscensoresTrasdosado;
	}

	/**
	 * Define el valor de la propiedad otrasAscensoresTrasdosado.
	 * 
	 */
	public void setOtrasAscensoresTrasdosado(int value) {
		this.otrasAscensoresTrasdosado = value;
	}

	/**
	 * Obtiene el valor de la propiedad otrasAscensoresCuadroManiobras.
	 * 
	 */
	@Basic
	@Column(name = "OTRAS_ASCENSORES_CUADRO_MANIOBRAS", precision = 10, scale = 0)
	public int getOtrasAscensoresCuadroManiobras() {
		return otrasAscensoresCuadroManiobras;
	}

	/**
	 * Define el valor de la propiedad otrasAscensoresCuadroManiobras.
	 * 
	 */
	public void setOtrasAscensoresCuadroManiobras(int value) {
		this.otrasAscensoresCuadroManiobras = value;
	}

	/**
	 * Obtiene el valor de la propiedad otrasAscensoresRuidoMolesto.
	 * 
	 */
	@Basic
	@Column(name = "OTRAS_ASCENSORES_RUIDO_MOLESTO", precision = 10, scale = 0)
	public int getOtrasAscensoresRuidoMolesto() {
		return otrasAscensoresRuidoMolesto;
	}

	/**
	 * Define el valor de la propiedad otrasAscensoresRuidoMolesto.
	 * 
	 */
	public void setOtrasAscensoresRuidoMolesto(int value) {
		this.otrasAscensoresRuidoMolesto = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * otrasAscensoresRuidoMolestoTipoLocalizacion.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "OTRAS_ASCENSORES_RUIDO_MOLESTO_TIPO_LOCALIZACION", length = 255)
	public String getOtrasAscensoresRuidoMolestoTipoLocalizacion() {
		return otrasAscensoresRuidoMolestoTipoLocalizacion;
	}

	/**
	 * Define el valor de la propiedad
	 * otrasAscensoresRuidoMolestoTipoLocalizacion.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setOtrasAscensoresRuidoMolestoTipoLocalizacion(String value) {
		this.otrasAscensoresRuidoMolestoTipoLocalizacion = value;
	}

	/**
	 * Obtiene el valor de la propiedad otrasCuartosHumedosSaneamiento.
	 * 
	 */
	@Basic
	@Column(name = "OTRAS_CUARTOS_HUMEDOS_SANEAMIENTO", precision = 10, scale = 0)
	public int getOtrasCuartosHumedosSaneamiento() {
		return otrasCuartosHumedosSaneamiento;
	}

	/**
	 * Define el valor de la propiedad otrasCuartosHumedosSaneamiento.
	 * 
	 */
	public void setOtrasCuartosHumedosSaneamiento(int value) {
		this.otrasCuartosHumedosSaneamiento = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * otrasCuartosHumedosSaneamientoLanaMineral.
	 * 
	 */
	@Basic
	@Column(name = "OTRAS_CUARTOS_HUMEDOS_SANEAMIENTO_LANA_MINERAL", precision = 10, scale = 0)
	public int getOtrasCuartosHumedosSaneamientoLanaMineral() {
		return otrasCuartosHumedosSaneamientoLanaMineral;
	}

	/**
	 * Define el valor de la propiedad
	 * otrasCuartosHumedosSaneamientoLanaMineral.
	 * 
	 */
	public void setOtrasCuartosHumedosSaneamientoLanaMineral(int value) {
		this.otrasCuartosHumedosSaneamientoLanaMineral = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * otrasCuartosHumedosSaneamientoTechoSellado.
	 * 
	 */
	@Basic
	@Column(name = "OTRAS_CUARTOS_HUMEDOS_SANEAMIENTO_TECHO_SELLADO", precision = 10, scale = 0)
	public int getOtrasCuartosHumedosSaneamientoTechoSellado() {
		return otrasCuartosHumedosSaneamientoTechoSellado;
	}

	/**
	 * Define el valor de la propiedad
	 * otrasCuartosHumedosSaneamientoTechoSellado.
	 * 
	 */
	public void setOtrasCuartosHumedosSaneamientoTechoSellado(int value) {
		this.otrasCuartosHumedosSaneamientoTechoSellado = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * otrasCuartosHumedosSaneamientoMaterialElastico.
	 * 
	 */
	@Basic
	@Column(name = "OTRAS_CUARTOS_HUMEDOS_SANEAMIENTO_MATERIAL_ELASTICO", precision = 10, scale = 0)
	public int getOtrasCuartosHumedosSaneamientoMaterialElastico() {
		return otrasCuartosHumedosSaneamientoMaterialElastico;
	}

	/**
	 * Define el valor de la propiedad
	 * otrasCuartosHumedosSaneamientoMaterialElastico.
	 * 
	 */
	public void setOtrasCuartosHumedosSaneamientoMaterialElastico(int value) {
		this.otrasCuartosHumedosSaneamientoMaterialElastico = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * otrasCuartosHumedosSaneamientoConectoresFlexibles.
	 * 
	 */
	@Basic
	@Column(name = "OTRAS_CUARTOS_HUMEDOS_SANEAMIENTO_CONECTORES_FLEXIBLES", precision = 10, scale = 0)
	public int getOtrasCuartosHumedosSaneamientoConectoresFlexibles() {
		return otrasCuartosHumedosSaneamientoConectoresFlexibles;
	}

	/**
	 * Define el valor de la propiedad
	 * otrasCuartosHumedosSaneamientoConectoresFlexibles.
	 * 
	 */
	public void setOtrasCuartosHumedosSaneamientoConectoresFlexibles(int value) {
		this.otrasCuartosHumedosSaneamientoConectoresFlexibles = value;
	}

	/**
	 * Obtiene el valor de la propiedad otrasCuartosHumedosAireAcondicionado.
	 * 
	 */
	@Basic
	@Column(name = "OTRAS_CUARTOS_HUMEDOS_AIRE_ACONDICIONADO", precision = 10, scale = 0)
	public int getOtrasCuartosHumedosAireAcondicionado() {
		return otrasCuartosHumedosAireAcondicionado;
	}

	/**
	 * Define el valor de la propiedad otrasCuartosHumedosAireAcondicionado.
	 * 
	 */
	public void setOtrasCuartosHumedosAireAcondicionado(int value) {
		this.otrasCuartosHumedosAireAcondicionado = value;
	}

	/**
	 * Obtiene el valor de la propiedad otrasCuartosHumedosLuminariasEmpotradas.
	 * 
	 */
	@Basic
	@Column(name = "OTRAS_CUARTOS_HUMEDOS_LUMINARIAS_EMPOTRADAS", precision = 10, scale = 0)
	public int getOtrasCuartosHumedosLuminariasEmpotradas() {
		return otrasCuartosHumedosLuminariasEmpotradas;
	}

	/**
	 * Define el valor de la propiedad otrasCuartosHumedosLuminariasEmpotradas.
	 * 
	 */
	public void setOtrasCuartosHumedosLuminariasEmpotradas(int value) {
		this.otrasCuartosHumedosLuminariasEmpotradas = value;
	}

	/**
	 * Obtiene el valor de la propiedad otrasCuartosHumedosRuidoMolesto.
	 * 
	 */
	@Basic
	@Column(name = "OTRAS_CUARTOS_HUMEDOS_RUIDO_MOLESTO", precision = 10, scale = 0)
	public int getOtrasCuartosHumedosRuidoMolesto() {
		return otrasCuartosHumedosRuidoMolesto;
	}

	/**
	 * Define el valor de la propiedad otrasCuartosHumedosRuidoMolesto.
	 * 
	 */
	public void setOtrasCuartosHumedosRuidoMolesto(int value) {
		this.otrasCuartosHumedosRuidoMolesto = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * otrasCuartosHumedosRuidoMolestoTipoLocalizacion.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "OTRAS_CUARTOS_HUMEDOS_RUIDO_MOLESTO_TIPO_LOCALIZACION", length = 255)
	public String getOtrasCuartosHumedosRuidoMolestoTipoLocalizacion() {
		return otrasCuartosHumedosRuidoMolestoTipoLocalizacion;
	}

	/**
	 * Define el valor de la propiedad
	 * otrasCuartosHumedosRuidoMolestoTipoLocalizacion.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setOtrasCuartosHumedosRuidoMolestoTipoLocalizacion(String value) {
		this.otrasCuartosHumedosRuidoMolestoTipoLocalizacion = value;
	}

	/**
	 * Obtiene el valor de la propiedad otrasPuertasGarajeAncladas.
	 * 
	 */
	@Basic
	@Column(name = "OTRAS_PUERTAS_GARAJE_ANCLADAS", precision = 10, scale = 0)
	public int getOtrasPuertasGarajeAncladas() {
		return otrasPuertasGarajeAncladas;
	}

	/**
	 * Define el valor de la propiedad otrasPuertasGarajeAncladas.
	 * 
	 */
	public void setOtrasPuertasGarajeAncladas(int value) {
		this.otrasPuertasGarajeAncladas = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * otrasPuertasGarajeAncladasMotoresAmortiguadores.
	 * 
	 */
	@Basic
	@Column(name = "OTRAS_PUERTAS_GARAJE_ANCLADAS_MOTORES_AMORTIGUADORES", precision = 10, scale = 0)
	public int getOtrasPuertasGarajeAncladasMotoresAmortiguadores() {
		return otrasPuertasGarajeAncladasMotoresAmortiguadores;
	}

	/**
	 * Define el valor de la propiedad
	 * otrasPuertasGarajeAncladasMotoresAmortiguadores.
	 * 
	 */
	public void setOtrasPuertasGarajeAncladasMotoresAmortiguadores(int value) {
		this.otrasPuertasGarajeAncladasMotoresAmortiguadores = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * otrasPuertasGarajeAncladasMarcoAmortiguadores.
	 * 
	 */
	@Basic
	@Column(name = "OTRAS_PUERTAS_GARAJE_ANCLADAS_MARCO_AMORTIGUADORES", precision = 10, scale = 0)
	public int getOtrasPuertasGarajeAncladasMarcoAmortiguadores() {
		return otrasPuertasGarajeAncladasMarcoAmortiguadores;
	}

	/**
	 * Define el valor de la propiedad
	 * otrasPuertasGarajeAncladasMarcoAmortiguadores.
	 * 
	 */
	public void setOtrasPuertasGarajeAncladasMarcoAmortiguadores(int value) {
		this.otrasPuertasGarajeAncladasMarcoAmortiguadores = value;
	}

	/**
	 * Obtiene el valor de la propiedad otrasPuertasGarajeAncladasRuidoPuerta.
	 * 
	 */
	@Basic
	@Column(name = "OTRAS_PUERTAS_GARAJE_ANCLADAS_RUIDO_PUERTA", precision = 10, scale = 0)
	public int getOtrasPuertasGarajeAncladasRuidoPuerta() {
		return otrasPuertasGarajeAncladasRuidoPuerta;
	}

	/**
	 * Define el valor de la propiedad otrasPuertasGarajeAncladasRuidoPuerta.
	 * 
	 */
	public void setOtrasPuertasGarajeAncladasRuidoPuerta(int value) {
		this.otrasPuertasGarajeAncladasRuidoPuerta = value;
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
		final AcusticaRuidoinstalacionesType that = ((AcusticaRuidoinstalacionesType) object);
		{
			int lhsRecintosActividadTiene;
			lhsRecintosActividadTiene = this.getRecintosActividadTiene();
			int rhsRecintosActividadTiene;
			rhsRecintosActividadTiene = that.getRecintosActividadTiene();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "recintosActividadTiene", lhsRecintosActividadTiene), LocatorUtils.property(thatLocator, "recintosActividadTiene", rhsRecintosActividadTiene), lhsRecintosActividadTiene, rhsRecintosActividadTiene)) {
				return false;
			}
		}
		{
			String lhsRecintosActividadTipoLocalizacion;
			lhsRecintosActividadTipoLocalizacion = this.getRecintosActividadTipoLocalizacion();
			String rhsRecintosActividadTipoLocalizacion;
			rhsRecintosActividadTipoLocalizacion = that.getRecintosActividadTipoLocalizacion();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "recintosActividadTipoLocalizacion", lhsRecintosActividadTipoLocalizacion), LocatorUtils.property(thatLocator, "recintosActividadTipoLocalizacion", rhsRecintosActividadTipoLocalizacion), lhsRecintosActividadTipoLocalizacion, rhsRecintosActividadTipoLocalizacion)) {
				return false;
			}
		}
		{
			int lhsRecintosActividadRevestido;
			lhsRecintosActividadRevestido = this.getRecintosActividadRevestido();
			int rhsRecintosActividadRevestido;
			rhsRecintosActividadRevestido = that.getRecintosActividadRevestido();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "recintosActividadRevestido", lhsRecintosActividadRevestido), LocatorUtils.property(thatLocator, "recintosActividadRevestido", rhsRecintosActividadRevestido), lhsRecintosActividadRevestido, rhsRecintosActividadRevestido)) {
				return false;
			}
		}
		{
			int lhsRecintosActividadTratamientoAbsorvente;
			lhsRecintosActividadTratamientoAbsorvente = this.getRecintosActividadTratamientoAbsorvente();
			int rhsRecintosActividadTratamientoAbsorvente;
			rhsRecintosActividadTratamientoAbsorvente = that.getRecintosActividadTratamientoAbsorvente();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "recintosActividadTratamientoAbsorvente", lhsRecintosActividadTratamientoAbsorvente), LocatorUtils.property(thatLocator, "recintosActividadTratamientoAbsorvente", rhsRecintosActividadTratamientoAbsorvente), lhsRecintosActividadTratamientoAbsorvente, rhsRecintosActividadTratamientoAbsorvente)) {
				return false;
			}
		}
		{
			int lhsRecintosActividadTrasdosados;
			lhsRecintosActividadTrasdosados = this.getRecintosActividadTrasdosados();
			int rhsRecintosActividadTrasdosados;
			rhsRecintosActividadTrasdosados = that.getRecintosActividadTrasdosados();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "recintosActividadTrasdosados", lhsRecintosActividadTrasdosados), LocatorUtils.property(thatLocator, "recintosActividadTrasdosados", rhsRecintosActividadTrasdosados), lhsRecintosActividadTrasdosados, rhsRecintosActividadTrasdosados)) {
				return false;
			}
		}
		{
			int lhsRecintosActividadTrasdosadosAmortiguadores;
			lhsRecintosActividadTrasdosadosAmortiguadores = this.getRecintosActividadTrasdosadosAmortiguadores();
			int rhsRecintosActividadTrasdosadosAmortiguadores;
			rhsRecintosActividadTrasdosadosAmortiguadores = that.getRecintosActividadTrasdosadosAmortiguadores();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "recintosActividadTrasdosadosAmortiguadores", lhsRecintosActividadTrasdosadosAmortiguadores), LocatorUtils.property(thatLocator, "recintosActividadTrasdosadosAmortiguadores", rhsRecintosActividadTrasdosadosAmortiguadores), lhsRecintosActividadTrasdosadosAmortiguadores, rhsRecintosActividadTrasdosadosAmortiguadores)) {
				return false;
			}
		}
		{
			int lhsRecintosActividadSueloFlotante;
			lhsRecintosActividadSueloFlotante = this.getRecintosActividadSueloFlotante();
			int rhsRecintosActividadSueloFlotante;
			rhsRecintosActividadSueloFlotante = that.getRecintosActividadSueloFlotante();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "recintosActividadSueloFlotante", lhsRecintosActividadSueloFlotante), LocatorUtils.property(thatLocator, "recintosActividadSueloFlotante", rhsRecintosActividadSueloFlotante), lhsRecintosActividadSueloFlotante, rhsRecintosActividadSueloFlotante)) {
				return false;
			}
		}
		{
			int lhsRecintosActividadTechoSuspendido;
			lhsRecintosActividadTechoSuspendido = this.getRecintosActividadTechoSuspendido();
			int rhsRecintosActividadTechoSuspendido;
			rhsRecintosActividadTechoSuspendido = that.getRecintosActividadTechoSuspendido();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "recintosActividadTechoSuspendido", lhsRecintosActividadTechoSuspendido), LocatorUtils.property(thatLocator, "recintosActividadTechoSuspendido", rhsRecintosActividadTechoSuspendido), lhsRecintosActividadTechoSuspendido, rhsRecintosActividadTechoSuspendido)) {
				return false;
			}
		}
		{
			int lhsRecintosActividadTechoSuspendidoAmortiguadores;
			lhsRecintosActividadTechoSuspendidoAmortiguadores = this.getRecintosActividadTechoSuspendidoAmortiguadores();
			int rhsRecintosActividadTechoSuspendidoAmortiguadores;
			rhsRecintosActividadTechoSuspendidoAmortiguadores = that.getRecintosActividadTechoSuspendidoAmortiguadores();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "recintosActividadTechoSuspendidoAmortiguadores", lhsRecintosActividadTechoSuspendidoAmortiguadores), LocatorUtils.property(thatLocator, "recintosActividadTechoSuspendidoAmortiguadores", rhsRecintosActividadTechoSuspendidoAmortiguadores), lhsRecintosActividadTechoSuspendidoAmortiguadores, rhsRecintosActividadTechoSuspendidoAmortiguadores)) {
				return false;
			}
		}
		{
			int lhsRecintosActividadTechoSuspendidoAbsorvente;
			lhsRecintosActividadTechoSuspendidoAbsorvente = this.getRecintosActividadTechoSuspendidoAbsorvente();
			int rhsRecintosActividadTechoSuspendidoAbsorvente;
			rhsRecintosActividadTechoSuspendidoAbsorvente = that.getRecintosActividadTechoSuspendidoAbsorvente();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "recintosActividadTechoSuspendidoAbsorvente", lhsRecintosActividadTechoSuspendidoAbsorvente), LocatorUtils.property(thatLocator, "recintosActividadTechoSuspendidoAbsorvente", rhsRecintosActividadTechoSuspendidoAbsorvente), lhsRecintosActividadTechoSuspendidoAbsorvente, rhsRecintosActividadTechoSuspendidoAbsorvente)) {
				return false;
			}
		}
		{
			int lhsRecintosActividadRuidoMolesto;
			lhsRecintosActividadRuidoMolesto = this.getRecintosActividadRuidoMolesto();
			int rhsRecintosActividadRuidoMolesto;
			rhsRecintosActividadRuidoMolesto = that.getRecintosActividadRuidoMolesto();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "recintosActividadRuidoMolesto", lhsRecintosActividadRuidoMolesto), LocatorUtils.property(thatLocator, "recintosActividadRuidoMolesto", rhsRecintosActividadRuidoMolesto), lhsRecintosActividadRuidoMolesto, rhsRecintosActividadRuidoMolesto)) {
				return false;
			}
		}
		{
			String lhsRecintosActividadRuidoMolestoTipoLocalizacion;
			lhsRecintosActividadRuidoMolestoTipoLocalizacion = this.getRecintosActividadRuidoMolestoTipoLocalizacion();
			String rhsRecintosActividadRuidoMolestoTipoLocalizacion;
			rhsRecintosActividadRuidoMolestoTipoLocalizacion = that.getRecintosActividadRuidoMolestoTipoLocalizacion();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "recintosActividadRuidoMolestoTipoLocalizacion", lhsRecintosActividadRuidoMolestoTipoLocalizacion), LocatorUtils.property(thatLocator, "recintosActividadRuidoMolestoTipoLocalizacion", rhsRecintosActividadRuidoMolestoTipoLocalizacion), lhsRecintosActividadRuidoMolestoTipoLocalizacion, rhsRecintosActividadRuidoMolestoTipoLocalizacion)) {
				return false;
			}
		}
		{
			int lhsEquiposInstalacionesColindantes;
			lhsEquiposInstalacionesColindantes = this.getEquiposInstalacionesColindantes();
			int rhsEquiposInstalacionesColindantes;
			rhsEquiposInstalacionesColindantes = that.getEquiposInstalacionesColindantes();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "equiposInstalacionesColindantes", lhsEquiposInstalacionesColindantes), LocatorUtils.property(thatLocator, "equiposInstalacionesColindantes", rhsEquiposInstalacionesColindantes), lhsEquiposInstalacionesColindantes, rhsEquiposInstalacionesColindantes)) {
				return false;
			}
		}
		{
			int lhsEquiposInstalacionesZonasExteriores;
			lhsEquiposInstalacionesZonasExteriores = this.getEquiposInstalacionesZonasExteriores();
			int rhsEquiposInstalacionesZonasExteriores;
			rhsEquiposInstalacionesZonasExteriores = that.getEquiposInstalacionesZonasExteriores();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "equiposInstalacionesZonasExteriores", lhsEquiposInstalacionesZonasExteriores), LocatorUtils.property(thatLocator, "equiposInstalacionesZonasExteriores", rhsEquiposInstalacionesZonasExteriores), lhsEquiposInstalacionesZonasExteriores, rhsEquiposInstalacionesZonasExteriores)) {
				return false;
			}
		}
		{
			int lhsEquiposInstalacionesZonasExterioresPantallas;
			lhsEquiposInstalacionesZonasExterioresPantallas = this.getEquiposInstalacionesZonasExterioresPantallas();
			int rhsEquiposInstalacionesZonasExterioresPantallas;
			rhsEquiposInstalacionesZonasExterioresPantallas = that.getEquiposInstalacionesZonasExterioresPantallas();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "equiposInstalacionesZonasExterioresPantallas", lhsEquiposInstalacionesZonasExterioresPantallas), LocatorUtils.property(thatLocator, "equiposInstalacionesZonasExterioresPantallas", rhsEquiposInstalacionesZonasExterioresPantallas), lhsEquiposInstalacionesZonasExterioresPantallas, rhsEquiposInstalacionesZonasExterioresPantallas)) {
				return false;
			}
		}
		{
			int lhsEquiposInstalacionesSistemaAmortiguante;
			lhsEquiposInstalacionesSistemaAmortiguante = this.getEquiposInstalacionesSistemaAmortiguante();
			int rhsEquiposInstalacionesSistemaAmortiguante;
			rhsEquiposInstalacionesSistemaAmortiguante = that.getEquiposInstalacionesSistemaAmortiguante();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "equiposInstalacionesSistemaAmortiguante", lhsEquiposInstalacionesSistemaAmortiguante), LocatorUtils.property(thatLocator, "equiposInstalacionesSistemaAmortiguante", rhsEquiposInstalacionesSistemaAmortiguante), lhsEquiposInstalacionesSistemaAmortiguante, rhsEquiposInstalacionesSistemaAmortiguante)) {
				return false;
			}
		}
		{
			int lhsEquiposInstalacionesConectoresFlexibles;
			lhsEquiposInstalacionesConectoresFlexibles = this.getEquiposInstalacionesConectoresFlexibles();
			int rhsEquiposInstalacionesConectoresFlexibles;
			rhsEquiposInstalacionesConectoresFlexibles = that.getEquiposInstalacionesConectoresFlexibles();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "equiposInstalacionesConectoresFlexibles", lhsEquiposInstalacionesConectoresFlexibles), LocatorUtils.property(thatLocator, "equiposInstalacionesConectoresFlexibles", rhsEquiposInstalacionesConectoresFlexibles), lhsEquiposInstalacionesConectoresFlexibles, rhsEquiposInstalacionesConectoresFlexibles)) {
				return false;
			}
		}
		{
			int lhsEquiposInstalacionesConductosAnclados;
			lhsEquiposInstalacionesConductosAnclados = this.getEquiposInstalacionesConductosAnclados();
			int rhsEquiposInstalacionesConductosAnclados;
			rhsEquiposInstalacionesConductosAnclados = that.getEquiposInstalacionesConductosAnclados();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "equiposInstalacionesConductosAnclados", lhsEquiposInstalacionesConductosAnclados), LocatorUtils.property(thatLocator, "equiposInstalacionesConductosAnclados", rhsEquiposInstalacionesConductosAnclados), lhsEquiposInstalacionesConductosAnclados, rhsEquiposInstalacionesConductosAnclados)) {
				return false;
			}
		}
		{
			int lhsEquiposInstalacionesHolgurasSelladas;
			lhsEquiposInstalacionesHolgurasSelladas = this.getEquiposInstalacionesHolgurasSelladas();
			int rhsEquiposInstalacionesHolgurasSelladas;
			rhsEquiposInstalacionesHolgurasSelladas = that.getEquiposInstalacionesHolgurasSelladas();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "equiposInstalacionesHolgurasSelladas", lhsEquiposInstalacionesHolgurasSelladas), LocatorUtils.property(thatLocator, "equiposInstalacionesHolgurasSelladas", rhsEquiposInstalacionesHolgurasSelladas), lhsEquiposInstalacionesHolgurasSelladas, rhsEquiposInstalacionesHolgurasSelladas)) {
				return false;
			}
		}
		{
			int lhsEquiposInstalacionesRuidoMolesto;
			lhsEquiposInstalacionesRuidoMolesto = this.getEquiposInstalacionesRuidoMolesto();
			int rhsEquiposInstalacionesRuidoMolesto;
			rhsEquiposInstalacionesRuidoMolesto = that.getEquiposInstalacionesRuidoMolesto();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "equiposInstalacionesRuidoMolesto", lhsEquiposInstalacionesRuidoMolesto), LocatorUtils.property(thatLocator, "equiposInstalacionesRuidoMolesto", rhsEquiposInstalacionesRuidoMolesto), lhsEquiposInstalacionesRuidoMolesto, rhsEquiposInstalacionesRuidoMolesto)) {
				return false;
			}
		}
		{
			String lhsEquiposInstalacionesRuidoMolestoTipoLocalizacion;
			lhsEquiposInstalacionesRuidoMolestoTipoLocalizacion = this.getEquiposInstalacionesRuidoMolestoTipoLocalizacion();
			String rhsEquiposInstalacionesRuidoMolestoTipoLocalizacion;
			rhsEquiposInstalacionesRuidoMolestoTipoLocalizacion = that.getEquiposInstalacionesRuidoMolestoTipoLocalizacion();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "equiposInstalacionesRuidoMolestoTipoLocalizacion", lhsEquiposInstalacionesRuidoMolestoTipoLocalizacion), LocatorUtils.property(thatLocator, "equiposInstalacionesRuidoMolestoTipoLocalizacion", rhsEquiposInstalacionesRuidoMolestoTipoLocalizacion), lhsEquiposInstalacionesRuidoMolestoTipoLocalizacion, rhsEquiposInstalacionesRuidoMolestoTipoLocalizacion)) {
				return false;
			}
		}
		{
			int lhsRedesSaneamientoCodoBajante;
			lhsRedesSaneamientoCodoBajante = this.getRedesSaneamientoCodoBajante();
			int rhsRedesSaneamientoCodoBajante;
			rhsRedesSaneamientoCodoBajante = that.getRedesSaneamientoCodoBajante();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "redesSaneamientoCodoBajante", lhsRedesSaneamientoCodoBajante), LocatorUtils.property(thatLocator, "redesSaneamientoCodoBajante", rhsRedesSaneamientoCodoBajante), lhsRedesSaneamientoCodoBajante, rhsRedesSaneamientoCodoBajante)) {
				return false;
			}
		}
		{
			int lhsRedesSaneamientoBajantesRevestidas;
			lhsRedesSaneamientoBajantesRevestidas = this.getRedesSaneamientoBajantesRevestidas();
			int rhsRedesSaneamientoBajantesRevestidas;
			rhsRedesSaneamientoBajantesRevestidas = that.getRedesSaneamientoBajantesRevestidas();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "redesSaneamientoBajantesRevestidas", lhsRedesSaneamientoBajantesRevestidas), LocatorUtils.property(thatLocator, "redesSaneamientoBajantesRevestidas", rhsRedesSaneamientoBajantesRevestidas), lhsRedesSaneamientoBajantesRevestidas, rhsRedesSaneamientoBajantesRevestidas)) {
				return false;
			}
		}
		{
			int lhsRedesSaneamientoBajantesForradas;
			lhsRedesSaneamientoBajantesForradas = this.getRedesSaneamientoBajantesForradas();
			int rhsRedesSaneamientoBajantesForradas;
			rhsRedesSaneamientoBajantesForradas = that.getRedesSaneamientoBajantesForradas();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "redesSaneamientoBajantesForradas", lhsRedesSaneamientoBajantesForradas), LocatorUtils.property(thatLocator, "redesSaneamientoBajantesForradas", rhsRedesSaneamientoBajantesForradas), lhsRedesSaneamientoBajantesForradas, rhsRedesSaneamientoBajantesForradas)) {
				return false;
			}
		}
		{
			int lhsRedesSaneamientoBajantesAbrazaderas;
			lhsRedesSaneamientoBajantesAbrazaderas = this.getRedesSaneamientoBajantesAbrazaderas();
			int rhsRedesSaneamientoBajantesAbrazaderas;
			rhsRedesSaneamientoBajantesAbrazaderas = that.getRedesSaneamientoBajantesAbrazaderas();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "redesSaneamientoBajantesAbrazaderas", lhsRedesSaneamientoBajantesAbrazaderas), LocatorUtils.property(thatLocator, "redesSaneamientoBajantesAbrazaderas", rhsRedesSaneamientoBajantesAbrazaderas), lhsRedesSaneamientoBajantesAbrazaderas, rhsRedesSaneamientoBajantesAbrazaderas)) {
				return false;
			}
		}
		{
			int lhsRedesSaneamientoRuidoMolesto;
			lhsRedesSaneamientoRuidoMolesto = this.getRedesSaneamientoRuidoMolesto();
			int rhsRedesSaneamientoRuidoMolesto;
			rhsRedesSaneamientoRuidoMolesto = that.getRedesSaneamientoRuidoMolesto();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "redesSaneamientoRuidoMolesto", lhsRedesSaneamientoRuidoMolesto), LocatorUtils.property(thatLocator, "redesSaneamientoRuidoMolesto", rhsRedesSaneamientoRuidoMolesto), lhsRedesSaneamientoRuidoMolesto, rhsRedesSaneamientoRuidoMolesto)) {
				return false;
			}
		}
		{
			String lhsRedesSaneamientoRuidoMolestoTipoLocalizacion;
			lhsRedesSaneamientoRuidoMolestoTipoLocalizacion = this.getRedesSaneamientoRuidoMolestoTipoLocalizacion();
			String rhsRedesSaneamientoRuidoMolestoTipoLocalizacion;
			rhsRedesSaneamientoRuidoMolestoTipoLocalizacion = that.getRedesSaneamientoRuidoMolestoTipoLocalizacion();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "redesSaneamientoRuidoMolestoTipoLocalizacion", lhsRedesSaneamientoRuidoMolestoTipoLocalizacion), LocatorUtils.property(thatLocator, "redesSaneamientoRuidoMolestoTipoLocalizacion", rhsRedesSaneamientoRuidoMolestoTipoLocalizacion), lhsRedesSaneamientoRuidoMolestoTipoLocalizacion, rhsRedesSaneamientoRuidoMolestoTipoLocalizacion)) {
				return false;
			}
		}
		{
			int lhsRedesSuministroAguaTuberiasForradas;
			lhsRedesSuministroAguaTuberiasForradas = this.getRedesSuministroAguaTuberiasForradas();
			int rhsRedesSuministroAguaTuberiasForradas;
			rhsRedesSuministroAguaTuberiasForradas = that.getRedesSuministroAguaTuberiasForradas();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "redesSuministroAguaTuberiasForradas", lhsRedesSuministroAguaTuberiasForradas), LocatorUtils.property(thatLocator, "redesSuministroAguaTuberiasForradas", rhsRedesSuministroAguaTuberiasForradas), lhsRedesSuministroAguaTuberiasForradas, rhsRedesSuministroAguaTuberiasForradas)) {
				return false;
			}
		}
		{
			int lhsRedesSuministroAguaRuidoGolpeAriete;
			lhsRedesSuministroAguaRuidoGolpeAriete = this.getRedesSuministroAguaRuidoGolpeAriete();
			int rhsRedesSuministroAguaRuidoGolpeAriete;
			rhsRedesSuministroAguaRuidoGolpeAriete = that.getRedesSuministroAguaRuidoGolpeAriete();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "redesSuministroAguaRuidoGolpeAriete", lhsRedesSuministroAguaRuidoGolpeAriete), LocatorUtils.property(thatLocator, "redesSuministroAguaRuidoGolpeAriete", rhsRedesSuministroAguaRuidoGolpeAriete), lhsRedesSuministroAguaRuidoGolpeAriete, rhsRedesSuministroAguaRuidoGolpeAriete)) {
				return false;
			}
		}
		{
			int lhsRedesSuministroAguaRuidoMolesto;
			lhsRedesSuministroAguaRuidoMolesto = this.getRedesSuministroAguaRuidoMolesto();
			int rhsRedesSuministroAguaRuidoMolesto;
			rhsRedesSuministroAguaRuidoMolesto = that.getRedesSuministroAguaRuidoMolesto();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "redesSuministroAguaRuidoMolesto", lhsRedesSuministroAguaRuidoMolesto), LocatorUtils.property(thatLocator, "redesSuministroAguaRuidoMolesto", rhsRedesSuministroAguaRuidoMolesto), lhsRedesSuministroAguaRuidoMolesto, rhsRedesSuministroAguaRuidoMolesto)) {
				return false;
			}
		}
		{
			String lhsRedesAguaRuidoMolestoTipoLocalizacion;
			lhsRedesAguaRuidoMolestoTipoLocalizacion = this.getRedesAguaRuidoMolestoTipoLocalizacion();
			String rhsRedesAguaRuidoMolestoTipoLocalizacion;
			rhsRedesAguaRuidoMolestoTipoLocalizacion = that.getRedesAguaRuidoMolestoTipoLocalizacion();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "redesAguaRuidoMolestoTipoLocalizacion", lhsRedesAguaRuidoMolestoTipoLocalizacion), LocatorUtils.property(thatLocator, "redesAguaRuidoMolestoTipoLocalizacion", rhsRedesAguaRuidoMolestoTipoLocalizacion), lhsRedesAguaRuidoMolestoTipoLocalizacion, rhsRedesAguaRuidoMolestoTipoLocalizacion)) {
				return false;
			}
		}
		{
			int lhsRedesAireAcondicionadoRuidoMolesto;
			lhsRedesAireAcondicionadoRuidoMolesto = this.getRedesAireAcondicionadoRuidoMolesto();
			int rhsRedesAireAcondicionadoRuidoMolesto;
			rhsRedesAireAcondicionadoRuidoMolesto = that.getRedesAireAcondicionadoRuidoMolesto();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "redesAireAcondicionadoRuidoMolesto", lhsRedesAireAcondicionadoRuidoMolesto), LocatorUtils.property(thatLocator, "redesAireAcondicionadoRuidoMolesto", rhsRedesAireAcondicionadoRuidoMolesto), lhsRedesAireAcondicionadoRuidoMolesto, rhsRedesAireAcondicionadoRuidoMolesto)) {
				return false;
			}
		}
		{
			int lhsRedesAireAcondicionadoFalsoTecho;
			lhsRedesAireAcondicionadoFalsoTecho = this.getRedesAireAcondicionadoFalsoTecho();
			int rhsRedesAireAcondicionadoFalsoTecho;
			rhsRedesAireAcondicionadoFalsoTecho = that.getRedesAireAcondicionadoFalsoTecho();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "redesAireAcondicionadoFalsoTecho", lhsRedesAireAcondicionadoFalsoTecho), LocatorUtils.property(thatLocator, "redesAireAcondicionadoFalsoTecho", rhsRedesAireAcondicionadoFalsoTecho), lhsRedesAireAcondicionadoFalsoTecho, rhsRedesAireAcondicionadoFalsoTecho)) {
				return false;
			}
		}
		{
			int lhsRedesVentilacionConductosShunt;
			lhsRedesVentilacionConductosShunt = this.getRedesVentilacionConductosShunt();
			int rhsRedesVentilacionConductosShunt;
			rhsRedesVentilacionConductosShunt = that.getRedesVentilacionConductosShunt();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "redesVentilacionConductosShunt", lhsRedesVentilacionConductosShunt), LocatorUtils.property(thatLocator, "redesVentilacionConductosShunt", rhsRedesVentilacionConductosShunt), lhsRedesVentilacionConductosShunt, rhsRedesVentilacionConductosShunt)) {
				return false;
			}
		}
		{
			int lhsRedesVentilacionRuidoViviendasColindantes;
			lhsRedesVentilacionRuidoViviendasColindantes = this.getRedesVentilacionRuidoViviendasColindantes();
			int rhsRedesVentilacionRuidoViviendasColindantes;
			rhsRedesVentilacionRuidoViviendasColindantes = that.getRedesVentilacionRuidoViviendasColindantes();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "redesVentilacionRuidoViviendasColindantes", lhsRedesVentilacionRuidoViviendasColindantes), LocatorUtils.property(thatLocator, "redesVentilacionRuidoViviendasColindantes", rhsRedesVentilacionRuidoViviendasColindantes), lhsRedesVentilacionRuidoViviendasColindantes, rhsRedesVentilacionRuidoViviendasColindantes)) {
				return false;
			}
		}
		{
			int lhsRedesVentilacionConductoIndividual;
			lhsRedesVentilacionConductoIndividual = this.getRedesVentilacionConductoIndividual();
			int rhsRedesVentilacionConductoIndividual;
			rhsRedesVentilacionConductoIndividual = that.getRedesVentilacionConductoIndividual();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "redesVentilacionConductoIndividual", lhsRedesVentilacionConductoIndividual), LocatorUtils.property(thatLocator, "redesVentilacionConductoIndividual", rhsRedesVentilacionConductoIndividual), lhsRedesVentilacionConductoIndividual, rhsRedesVentilacionConductoIndividual)) {
				return false;
			}
		}
		{
			int lhsOtrasAscensoresColindantes;
			lhsOtrasAscensoresColindantes = this.getOtrasAscensoresColindantes();
			int rhsOtrasAscensoresColindantes;
			rhsOtrasAscensoresColindantes = that.getOtrasAscensoresColindantes();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "otrasAscensoresColindantes", lhsOtrasAscensoresColindantes), LocatorUtils.property(thatLocator, "otrasAscensoresColindantes", rhsOtrasAscensoresColindantes), lhsOtrasAscensoresColindantes, rhsOtrasAscensoresColindantes)) {
				return false;
			}
		}
		{
			int lhsOtrasAscensoresCuartoMaquinas;
			lhsOtrasAscensoresCuartoMaquinas = this.getOtrasAscensoresCuartoMaquinas();
			int rhsOtrasAscensoresCuartoMaquinas;
			rhsOtrasAscensoresCuartoMaquinas = that.getOtrasAscensoresCuartoMaquinas();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "otrasAscensoresCuartoMaquinas", lhsOtrasAscensoresCuartoMaquinas), LocatorUtils.property(thatLocator, "otrasAscensoresCuartoMaquinas", rhsOtrasAscensoresCuartoMaquinas), lhsOtrasAscensoresCuartoMaquinas, rhsOtrasAscensoresCuartoMaquinas)) {
				return false;
			}
		}
		{
			int lhsOtrasAscensoresSistemaAmortiguante;
			lhsOtrasAscensoresSistemaAmortiguante = this.getOtrasAscensoresSistemaAmortiguante();
			int rhsOtrasAscensoresSistemaAmortiguante;
			rhsOtrasAscensoresSistemaAmortiguante = that.getOtrasAscensoresSistemaAmortiguante();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "otrasAscensoresSistemaAmortiguante", lhsOtrasAscensoresSistemaAmortiguante), LocatorUtils.property(thatLocator, "otrasAscensoresSistemaAmortiguante", rhsOtrasAscensoresSistemaAmortiguante), lhsOtrasAscensoresSistemaAmortiguante, rhsOtrasAscensoresSistemaAmortiguante)) {
				return false;
			}
		}
		{
			int lhsOtrasAscensoresTrasdosado;
			lhsOtrasAscensoresTrasdosado = this.getOtrasAscensoresTrasdosado();
			int rhsOtrasAscensoresTrasdosado;
			rhsOtrasAscensoresTrasdosado = that.getOtrasAscensoresTrasdosado();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "otrasAscensoresTrasdosado", lhsOtrasAscensoresTrasdosado), LocatorUtils.property(thatLocator, "otrasAscensoresTrasdosado", rhsOtrasAscensoresTrasdosado), lhsOtrasAscensoresTrasdosado, rhsOtrasAscensoresTrasdosado)) {
				return false;
			}
		}
		{
			int lhsOtrasAscensoresCuadroManiobras;
			lhsOtrasAscensoresCuadroManiobras = this.getOtrasAscensoresCuadroManiobras();
			int rhsOtrasAscensoresCuadroManiobras;
			rhsOtrasAscensoresCuadroManiobras = that.getOtrasAscensoresCuadroManiobras();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "otrasAscensoresCuadroManiobras", lhsOtrasAscensoresCuadroManiobras), LocatorUtils.property(thatLocator, "otrasAscensoresCuadroManiobras", rhsOtrasAscensoresCuadroManiobras), lhsOtrasAscensoresCuadroManiobras, rhsOtrasAscensoresCuadroManiobras)) {
				return false;
			}
		}
		{
			int lhsOtrasAscensoresRuidoMolesto;
			lhsOtrasAscensoresRuidoMolesto = this.getOtrasAscensoresRuidoMolesto();
			int rhsOtrasAscensoresRuidoMolesto;
			rhsOtrasAscensoresRuidoMolesto = that.getOtrasAscensoresRuidoMolesto();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "otrasAscensoresRuidoMolesto", lhsOtrasAscensoresRuidoMolesto), LocatorUtils.property(thatLocator, "otrasAscensoresRuidoMolesto", rhsOtrasAscensoresRuidoMolesto), lhsOtrasAscensoresRuidoMolesto, rhsOtrasAscensoresRuidoMolesto)) {
				return false;
			}
		}
		{
			String lhsOtrasAscensoresRuidoMolestoTipoLocalizacion;
			lhsOtrasAscensoresRuidoMolestoTipoLocalizacion = this.getOtrasAscensoresRuidoMolestoTipoLocalizacion();
			String rhsOtrasAscensoresRuidoMolestoTipoLocalizacion;
			rhsOtrasAscensoresRuidoMolestoTipoLocalizacion = that.getOtrasAscensoresRuidoMolestoTipoLocalizacion();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "otrasAscensoresRuidoMolestoTipoLocalizacion", lhsOtrasAscensoresRuidoMolestoTipoLocalizacion), LocatorUtils.property(thatLocator, "otrasAscensoresRuidoMolestoTipoLocalizacion", rhsOtrasAscensoresRuidoMolestoTipoLocalizacion), lhsOtrasAscensoresRuidoMolestoTipoLocalizacion, rhsOtrasAscensoresRuidoMolestoTipoLocalizacion)) {
				return false;
			}
		}
		{
			int lhsOtrasCuartosHumedosSaneamiento;
			lhsOtrasCuartosHumedosSaneamiento = this.getOtrasCuartosHumedosSaneamiento();
			int rhsOtrasCuartosHumedosSaneamiento;
			rhsOtrasCuartosHumedosSaneamiento = that.getOtrasCuartosHumedosSaneamiento();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "otrasCuartosHumedosSaneamiento", lhsOtrasCuartosHumedosSaneamiento), LocatorUtils.property(thatLocator, "otrasCuartosHumedosSaneamiento", rhsOtrasCuartosHumedosSaneamiento), lhsOtrasCuartosHumedosSaneamiento, rhsOtrasCuartosHumedosSaneamiento)) {
				return false;
			}
		}
		{
			int lhsOtrasCuartosHumedosSaneamientoLanaMineral;
			lhsOtrasCuartosHumedosSaneamientoLanaMineral = this.getOtrasCuartosHumedosSaneamientoLanaMineral();
			int rhsOtrasCuartosHumedosSaneamientoLanaMineral;
			rhsOtrasCuartosHumedosSaneamientoLanaMineral = that.getOtrasCuartosHumedosSaneamientoLanaMineral();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "otrasCuartosHumedosSaneamientoLanaMineral", lhsOtrasCuartosHumedosSaneamientoLanaMineral), LocatorUtils.property(thatLocator, "otrasCuartosHumedosSaneamientoLanaMineral", rhsOtrasCuartosHumedosSaneamientoLanaMineral), lhsOtrasCuartosHumedosSaneamientoLanaMineral, rhsOtrasCuartosHumedosSaneamientoLanaMineral)) {
				return false;
			}
		}
		{
			int lhsOtrasCuartosHumedosSaneamientoTechoSellado;
			lhsOtrasCuartosHumedosSaneamientoTechoSellado = this.getOtrasCuartosHumedosSaneamientoTechoSellado();
			int rhsOtrasCuartosHumedosSaneamientoTechoSellado;
			rhsOtrasCuartosHumedosSaneamientoTechoSellado = that.getOtrasCuartosHumedosSaneamientoTechoSellado();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "otrasCuartosHumedosSaneamientoTechoSellado", lhsOtrasCuartosHumedosSaneamientoTechoSellado), LocatorUtils.property(thatLocator, "otrasCuartosHumedosSaneamientoTechoSellado", rhsOtrasCuartosHumedosSaneamientoTechoSellado), lhsOtrasCuartosHumedosSaneamientoTechoSellado, rhsOtrasCuartosHumedosSaneamientoTechoSellado)) {
				return false;
			}
		}
		{
			int lhsOtrasCuartosHumedosSaneamientoMaterialElastico;
			lhsOtrasCuartosHumedosSaneamientoMaterialElastico = this.getOtrasCuartosHumedosSaneamientoMaterialElastico();
			int rhsOtrasCuartosHumedosSaneamientoMaterialElastico;
			rhsOtrasCuartosHumedosSaneamientoMaterialElastico = that.getOtrasCuartosHumedosSaneamientoMaterialElastico();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "otrasCuartosHumedosSaneamientoMaterialElastico", lhsOtrasCuartosHumedosSaneamientoMaterialElastico), LocatorUtils.property(thatLocator, "otrasCuartosHumedosSaneamientoMaterialElastico", rhsOtrasCuartosHumedosSaneamientoMaterialElastico), lhsOtrasCuartosHumedosSaneamientoMaterialElastico, rhsOtrasCuartosHumedosSaneamientoMaterialElastico)) {
				return false;
			}
		}
		{
			int lhsOtrasCuartosHumedosSaneamientoConectoresFlexibles;
			lhsOtrasCuartosHumedosSaneamientoConectoresFlexibles = this.getOtrasCuartosHumedosSaneamientoConectoresFlexibles();
			int rhsOtrasCuartosHumedosSaneamientoConectoresFlexibles;
			rhsOtrasCuartosHumedosSaneamientoConectoresFlexibles = that.getOtrasCuartosHumedosSaneamientoConectoresFlexibles();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "otrasCuartosHumedosSaneamientoConectoresFlexibles", lhsOtrasCuartosHumedosSaneamientoConectoresFlexibles), LocatorUtils.property(thatLocator, "otrasCuartosHumedosSaneamientoConectoresFlexibles", rhsOtrasCuartosHumedosSaneamientoConectoresFlexibles), lhsOtrasCuartosHumedosSaneamientoConectoresFlexibles, rhsOtrasCuartosHumedosSaneamientoConectoresFlexibles)) {
				return false;
			}
		}
		{
			int lhsOtrasCuartosHumedosAireAcondicionado;
			lhsOtrasCuartosHumedosAireAcondicionado = this.getOtrasCuartosHumedosAireAcondicionado();
			int rhsOtrasCuartosHumedosAireAcondicionado;
			rhsOtrasCuartosHumedosAireAcondicionado = that.getOtrasCuartosHumedosAireAcondicionado();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "otrasCuartosHumedosAireAcondicionado", lhsOtrasCuartosHumedosAireAcondicionado), LocatorUtils.property(thatLocator, "otrasCuartosHumedosAireAcondicionado", rhsOtrasCuartosHumedosAireAcondicionado), lhsOtrasCuartosHumedosAireAcondicionado, rhsOtrasCuartosHumedosAireAcondicionado)) {
				return false;
			}
		}
		{
			int lhsOtrasCuartosHumedosLuminariasEmpotradas;
			lhsOtrasCuartosHumedosLuminariasEmpotradas = this.getOtrasCuartosHumedosLuminariasEmpotradas();
			int rhsOtrasCuartosHumedosLuminariasEmpotradas;
			rhsOtrasCuartosHumedosLuminariasEmpotradas = that.getOtrasCuartosHumedosLuminariasEmpotradas();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "otrasCuartosHumedosLuminariasEmpotradas", lhsOtrasCuartosHumedosLuminariasEmpotradas), LocatorUtils.property(thatLocator, "otrasCuartosHumedosLuminariasEmpotradas", rhsOtrasCuartosHumedosLuminariasEmpotradas), lhsOtrasCuartosHumedosLuminariasEmpotradas, rhsOtrasCuartosHumedosLuminariasEmpotradas)) {
				return false;
			}
		}
		{
			int lhsOtrasCuartosHumedosRuidoMolesto;
			lhsOtrasCuartosHumedosRuidoMolesto = this.getOtrasCuartosHumedosRuidoMolesto();
			int rhsOtrasCuartosHumedosRuidoMolesto;
			rhsOtrasCuartosHumedosRuidoMolesto = that.getOtrasCuartosHumedosRuidoMolesto();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "otrasCuartosHumedosRuidoMolesto", lhsOtrasCuartosHumedosRuidoMolesto), LocatorUtils.property(thatLocator, "otrasCuartosHumedosRuidoMolesto", rhsOtrasCuartosHumedosRuidoMolesto), lhsOtrasCuartosHumedosRuidoMolesto, rhsOtrasCuartosHumedosRuidoMolesto)) {
				return false;
			}
		}
		{
			String lhsOtrasCuartosHumedosRuidoMolestoTipoLocalizacion;
			lhsOtrasCuartosHumedosRuidoMolestoTipoLocalizacion = this.getOtrasCuartosHumedosRuidoMolestoTipoLocalizacion();
			String rhsOtrasCuartosHumedosRuidoMolestoTipoLocalizacion;
			rhsOtrasCuartosHumedosRuidoMolestoTipoLocalizacion = that.getOtrasCuartosHumedosRuidoMolestoTipoLocalizacion();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "otrasCuartosHumedosRuidoMolestoTipoLocalizacion", lhsOtrasCuartosHumedosRuidoMolestoTipoLocalizacion), LocatorUtils.property(thatLocator, "otrasCuartosHumedosRuidoMolestoTipoLocalizacion", rhsOtrasCuartosHumedosRuidoMolestoTipoLocalizacion), lhsOtrasCuartosHumedosRuidoMolestoTipoLocalizacion, rhsOtrasCuartosHumedosRuidoMolestoTipoLocalizacion)) {
				return false;
			}
		}
		{
			int lhsOtrasPuertasGarajeAncladas;
			lhsOtrasPuertasGarajeAncladas = this.getOtrasPuertasGarajeAncladas();
			int rhsOtrasPuertasGarajeAncladas;
			rhsOtrasPuertasGarajeAncladas = that.getOtrasPuertasGarajeAncladas();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "otrasPuertasGarajeAncladas", lhsOtrasPuertasGarajeAncladas), LocatorUtils.property(thatLocator, "otrasPuertasGarajeAncladas", rhsOtrasPuertasGarajeAncladas), lhsOtrasPuertasGarajeAncladas, rhsOtrasPuertasGarajeAncladas)) {
				return false;
			}
		}
		{
			int lhsOtrasPuertasGarajeAncladasMotoresAmortiguadores;
			lhsOtrasPuertasGarajeAncladasMotoresAmortiguadores = this.getOtrasPuertasGarajeAncladasMotoresAmortiguadores();
			int rhsOtrasPuertasGarajeAncladasMotoresAmortiguadores;
			rhsOtrasPuertasGarajeAncladasMotoresAmortiguadores = that.getOtrasPuertasGarajeAncladasMotoresAmortiguadores();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "otrasPuertasGarajeAncladasMotoresAmortiguadores", lhsOtrasPuertasGarajeAncladasMotoresAmortiguadores), LocatorUtils.property(thatLocator, "otrasPuertasGarajeAncladasMotoresAmortiguadores", rhsOtrasPuertasGarajeAncladasMotoresAmortiguadores), lhsOtrasPuertasGarajeAncladasMotoresAmortiguadores, rhsOtrasPuertasGarajeAncladasMotoresAmortiguadores)) {
				return false;
			}
		}
		{
			int lhsOtrasPuertasGarajeAncladasMarcoAmortiguadores;
			lhsOtrasPuertasGarajeAncladasMarcoAmortiguadores = this.getOtrasPuertasGarajeAncladasMarcoAmortiguadores();
			int rhsOtrasPuertasGarajeAncladasMarcoAmortiguadores;
			rhsOtrasPuertasGarajeAncladasMarcoAmortiguadores = that.getOtrasPuertasGarajeAncladasMarcoAmortiguadores();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "otrasPuertasGarajeAncladasMarcoAmortiguadores", lhsOtrasPuertasGarajeAncladasMarcoAmortiguadores), LocatorUtils.property(thatLocator, "otrasPuertasGarajeAncladasMarcoAmortiguadores", rhsOtrasPuertasGarajeAncladasMarcoAmortiguadores), lhsOtrasPuertasGarajeAncladasMarcoAmortiguadores, rhsOtrasPuertasGarajeAncladasMarcoAmortiguadores)) {
				return false;
			}
		}
		{
			int lhsOtrasPuertasGarajeAncladasRuidoPuerta;
			lhsOtrasPuertasGarajeAncladasRuidoPuerta = this.getOtrasPuertasGarajeAncladasRuidoPuerta();
			int rhsOtrasPuertasGarajeAncladasRuidoPuerta;
			rhsOtrasPuertasGarajeAncladasRuidoPuerta = that.getOtrasPuertasGarajeAncladasRuidoPuerta();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "otrasPuertasGarajeAncladasRuidoPuerta", lhsOtrasPuertasGarajeAncladasRuidoPuerta), LocatorUtils.property(thatLocator, "otrasPuertasGarajeAncladasRuidoPuerta", rhsOtrasPuertasGarajeAncladasRuidoPuerta), lhsOtrasPuertasGarajeAncladasRuidoPuerta, rhsOtrasPuertasGarajeAncladasRuidoPuerta)) {
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
			int theRecintosActividadTiene;
			theRecintosActividadTiene = this.getRecintosActividadTiene();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "recintosActividadTiene", theRecintosActividadTiene), currentHashCode, theRecintosActividadTiene);
		}
		{
			String theRecintosActividadTipoLocalizacion;
			theRecintosActividadTipoLocalizacion = this.getRecintosActividadTipoLocalizacion();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "recintosActividadTipoLocalizacion", theRecintosActividadTipoLocalizacion), currentHashCode, theRecintosActividadTipoLocalizacion);
		}
		{
			int theRecintosActividadRevestido;
			theRecintosActividadRevestido = this.getRecintosActividadRevestido();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "recintosActividadRevestido", theRecintosActividadRevestido), currentHashCode, theRecintosActividadRevestido);
		}
		{
			int theRecintosActividadTratamientoAbsorvente;
			theRecintosActividadTratamientoAbsorvente = this.getRecintosActividadTratamientoAbsorvente();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "recintosActividadTratamientoAbsorvente", theRecintosActividadTratamientoAbsorvente), currentHashCode, theRecintosActividadTratamientoAbsorvente);
		}
		{
			int theRecintosActividadTrasdosados;
			theRecintosActividadTrasdosados = this.getRecintosActividadTrasdosados();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "recintosActividadTrasdosados", theRecintosActividadTrasdosados), currentHashCode, theRecintosActividadTrasdosados);
		}
		{
			int theRecintosActividadTrasdosadosAmortiguadores;
			theRecintosActividadTrasdosadosAmortiguadores = this.getRecintosActividadTrasdosadosAmortiguadores();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "recintosActividadTrasdosadosAmortiguadores", theRecintosActividadTrasdosadosAmortiguadores), currentHashCode, theRecintosActividadTrasdosadosAmortiguadores);
		}
		{
			int theRecintosActividadSueloFlotante;
			theRecintosActividadSueloFlotante = this.getRecintosActividadSueloFlotante();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "recintosActividadSueloFlotante", theRecintosActividadSueloFlotante), currentHashCode, theRecintosActividadSueloFlotante);
		}
		{
			int theRecintosActividadTechoSuspendido;
			theRecintosActividadTechoSuspendido = this.getRecintosActividadTechoSuspendido();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "recintosActividadTechoSuspendido", theRecintosActividadTechoSuspendido), currentHashCode, theRecintosActividadTechoSuspendido);
		}
		{
			int theRecintosActividadTechoSuspendidoAmortiguadores;
			theRecintosActividadTechoSuspendidoAmortiguadores = this.getRecintosActividadTechoSuspendidoAmortiguadores();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "recintosActividadTechoSuspendidoAmortiguadores", theRecintosActividadTechoSuspendidoAmortiguadores), currentHashCode, theRecintosActividadTechoSuspendidoAmortiguadores);
		}
		{
			int theRecintosActividadTechoSuspendidoAbsorvente;
			theRecintosActividadTechoSuspendidoAbsorvente = this.getRecintosActividadTechoSuspendidoAbsorvente();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "recintosActividadTechoSuspendidoAbsorvente", theRecintosActividadTechoSuspendidoAbsorvente), currentHashCode, theRecintosActividadTechoSuspendidoAbsorvente);
		}
		{
			int theRecintosActividadRuidoMolesto;
			theRecintosActividadRuidoMolesto = this.getRecintosActividadRuidoMolesto();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "recintosActividadRuidoMolesto", theRecintosActividadRuidoMolesto), currentHashCode, theRecintosActividadRuidoMolesto);
		}
		{
			String theRecintosActividadRuidoMolestoTipoLocalizacion;
			theRecintosActividadRuidoMolestoTipoLocalizacion = this.getRecintosActividadRuidoMolestoTipoLocalizacion();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "recintosActividadRuidoMolestoTipoLocalizacion", theRecintosActividadRuidoMolestoTipoLocalizacion), currentHashCode, theRecintosActividadRuidoMolestoTipoLocalizacion);
		}
		{
			int theEquiposInstalacionesColindantes;
			theEquiposInstalacionesColindantes = this.getEquiposInstalacionesColindantes();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "equiposInstalacionesColindantes", theEquiposInstalacionesColindantes), currentHashCode, theEquiposInstalacionesColindantes);
		}
		{
			int theEquiposInstalacionesZonasExteriores;
			theEquiposInstalacionesZonasExteriores = this.getEquiposInstalacionesZonasExteriores();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "equiposInstalacionesZonasExteriores", theEquiposInstalacionesZonasExteriores), currentHashCode, theEquiposInstalacionesZonasExteriores);
		}
		{
			int theEquiposInstalacionesZonasExterioresPantallas;
			theEquiposInstalacionesZonasExterioresPantallas = this.getEquiposInstalacionesZonasExterioresPantallas();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "equiposInstalacionesZonasExterioresPantallas", theEquiposInstalacionesZonasExterioresPantallas), currentHashCode, theEquiposInstalacionesZonasExterioresPantallas);
		}
		{
			int theEquiposInstalacionesSistemaAmortiguante;
			theEquiposInstalacionesSistemaAmortiguante = this.getEquiposInstalacionesSistemaAmortiguante();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "equiposInstalacionesSistemaAmortiguante", theEquiposInstalacionesSistemaAmortiguante), currentHashCode, theEquiposInstalacionesSistemaAmortiguante);
		}
		{
			int theEquiposInstalacionesConectoresFlexibles;
			theEquiposInstalacionesConectoresFlexibles = this.getEquiposInstalacionesConectoresFlexibles();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "equiposInstalacionesConectoresFlexibles", theEquiposInstalacionesConectoresFlexibles), currentHashCode, theEquiposInstalacionesConectoresFlexibles);
		}
		{
			int theEquiposInstalacionesConductosAnclados;
			theEquiposInstalacionesConductosAnclados = this.getEquiposInstalacionesConductosAnclados();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "equiposInstalacionesConductosAnclados", theEquiposInstalacionesConductosAnclados), currentHashCode, theEquiposInstalacionesConductosAnclados);
		}
		{
			int theEquiposInstalacionesHolgurasSelladas;
			theEquiposInstalacionesHolgurasSelladas = this.getEquiposInstalacionesHolgurasSelladas();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "equiposInstalacionesHolgurasSelladas", theEquiposInstalacionesHolgurasSelladas), currentHashCode, theEquiposInstalacionesHolgurasSelladas);
		}
		{
			int theEquiposInstalacionesRuidoMolesto;
			theEquiposInstalacionesRuidoMolesto = this.getEquiposInstalacionesRuidoMolesto();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "equiposInstalacionesRuidoMolesto", theEquiposInstalacionesRuidoMolesto), currentHashCode, theEquiposInstalacionesRuidoMolesto);
		}
		{
			String theEquiposInstalacionesRuidoMolestoTipoLocalizacion;
			theEquiposInstalacionesRuidoMolestoTipoLocalizacion = this.getEquiposInstalacionesRuidoMolestoTipoLocalizacion();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "equiposInstalacionesRuidoMolestoTipoLocalizacion", theEquiposInstalacionesRuidoMolestoTipoLocalizacion), currentHashCode, theEquiposInstalacionesRuidoMolestoTipoLocalizacion);
		}
		{
			int theRedesSaneamientoCodoBajante;
			theRedesSaneamientoCodoBajante = this.getRedesSaneamientoCodoBajante();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "redesSaneamientoCodoBajante", theRedesSaneamientoCodoBajante), currentHashCode, theRedesSaneamientoCodoBajante);
		}
		{
			int theRedesSaneamientoBajantesRevestidas;
			theRedesSaneamientoBajantesRevestidas = this.getRedesSaneamientoBajantesRevestidas();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "redesSaneamientoBajantesRevestidas", theRedesSaneamientoBajantesRevestidas), currentHashCode, theRedesSaneamientoBajantesRevestidas);
		}
		{
			int theRedesSaneamientoBajantesForradas;
			theRedesSaneamientoBajantesForradas = this.getRedesSaneamientoBajantesForradas();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "redesSaneamientoBajantesForradas", theRedesSaneamientoBajantesForradas), currentHashCode, theRedesSaneamientoBajantesForradas);
		}
		{
			int theRedesSaneamientoBajantesAbrazaderas;
			theRedesSaneamientoBajantesAbrazaderas = this.getRedesSaneamientoBajantesAbrazaderas();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "redesSaneamientoBajantesAbrazaderas", theRedesSaneamientoBajantesAbrazaderas), currentHashCode, theRedesSaneamientoBajantesAbrazaderas);
		}
		{
			int theRedesSaneamientoRuidoMolesto;
			theRedesSaneamientoRuidoMolesto = this.getRedesSaneamientoRuidoMolesto();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "redesSaneamientoRuidoMolesto", theRedesSaneamientoRuidoMolesto), currentHashCode, theRedesSaneamientoRuidoMolesto);
		}
		{
			String theRedesSaneamientoRuidoMolestoTipoLocalizacion;
			theRedesSaneamientoRuidoMolestoTipoLocalizacion = this.getRedesSaneamientoRuidoMolestoTipoLocalizacion();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "redesSaneamientoRuidoMolestoTipoLocalizacion", theRedesSaneamientoRuidoMolestoTipoLocalizacion), currentHashCode, theRedesSaneamientoRuidoMolestoTipoLocalizacion);
		}
		{
			int theRedesSuministroAguaTuberiasForradas;
			theRedesSuministroAguaTuberiasForradas = this.getRedesSuministroAguaTuberiasForradas();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "redesSuministroAguaTuberiasForradas", theRedesSuministroAguaTuberiasForradas), currentHashCode, theRedesSuministroAguaTuberiasForradas);
		}
		{
			int theRedesSuministroAguaRuidoGolpeAriete;
			theRedesSuministroAguaRuidoGolpeAriete = this.getRedesSuministroAguaRuidoGolpeAriete();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "redesSuministroAguaRuidoGolpeAriete", theRedesSuministroAguaRuidoGolpeAriete), currentHashCode, theRedesSuministroAguaRuidoGolpeAriete);
		}
		{
			int theRedesSuministroAguaRuidoMolesto;
			theRedesSuministroAguaRuidoMolesto = this.getRedesSuministroAguaRuidoMolesto();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "redesSuministroAguaRuidoMolesto", theRedesSuministroAguaRuidoMolesto), currentHashCode, theRedesSuministroAguaRuidoMolesto);
		}
		{
			String theRedesAguaRuidoMolestoTipoLocalizacion;
			theRedesAguaRuidoMolestoTipoLocalizacion = this.getRedesAguaRuidoMolestoTipoLocalizacion();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "redesAguaRuidoMolestoTipoLocalizacion", theRedesAguaRuidoMolestoTipoLocalizacion), currentHashCode, theRedesAguaRuidoMolestoTipoLocalizacion);
		}
		{
			int theRedesAireAcondicionadoRuidoMolesto;
			theRedesAireAcondicionadoRuidoMolesto = this.getRedesAireAcondicionadoRuidoMolesto();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "redesAireAcondicionadoRuidoMolesto", theRedesAireAcondicionadoRuidoMolesto), currentHashCode, theRedesAireAcondicionadoRuidoMolesto);
		}
		{
			int theRedesAireAcondicionadoFalsoTecho;
			theRedesAireAcondicionadoFalsoTecho = this.getRedesAireAcondicionadoFalsoTecho();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "redesAireAcondicionadoFalsoTecho", theRedesAireAcondicionadoFalsoTecho), currentHashCode, theRedesAireAcondicionadoFalsoTecho);
		}
		{
			int theRedesVentilacionConductosShunt;
			theRedesVentilacionConductosShunt = this.getRedesVentilacionConductosShunt();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "redesVentilacionConductosShunt", theRedesVentilacionConductosShunt), currentHashCode, theRedesVentilacionConductosShunt);
		}
		{
			int theRedesVentilacionRuidoViviendasColindantes;
			theRedesVentilacionRuidoViviendasColindantes = this.getRedesVentilacionRuidoViviendasColindantes();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "redesVentilacionRuidoViviendasColindantes", theRedesVentilacionRuidoViviendasColindantes), currentHashCode, theRedesVentilacionRuidoViviendasColindantes);
		}
		{
			int theRedesVentilacionConductoIndividual;
			theRedesVentilacionConductoIndividual = this.getRedesVentilacionConductoIndividual();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "redesVentilacionConductoIndividual", theRedesVentilacionConductoIndividual), currentHashCode, theRedesVentilacionConductoIndividual);
		}
		{
			int theOtrasAscensoresColindantes;
			theOtrasAscensoresColindantes = this.getOtrasAscensoresColindantes();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "otrasAscensoresColindantes", theOtrasAscensoresColindantes), currentHashCode, theOtrasAscensoresColindantes);
		}
		{
			int theOtrasAscensoresCuartoMaquinas;
			theOtrasAscensoresCuartoMaquinas = this.getOtrasAscensoresCuartoMaquinas();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "otrasAscensoresCuartoMaquinas", theOtrasAscensoresCuartoMaquinas), currentHashCode, theOtrasAscensoresCuartoMaquinas);
		}
		{
			int theOtrasAscensoresSistemaAmortiguante;
			theOtrasAscensoresSistemaAmortiguante = this.getOtrasAscensoresSistemaAmortiguante();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "otrasAscensoresSistemaAmortiguante", theOtrasAscensoresSistemaAmortiguante), currentHashCode, theOtrasAscensoresSistemaAmortiguante);
		}
		{
			int theOtrasAscensoresTrasdosado;
			theOtrasAscensoresTrasdosado = this.getOtrasAscensoresTrasdosado();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "otrasAscensoresTrasdosado", theOtrasAscensoresTrasdosado), currentHashCode, theOtrasAscensoresTrasdosado);
		}
		{
			int theOtrasAscensoresCuadroManiobras;
			theOtrasAscensoresCuadroManiobras = this.getOtrasAscensoresCuadroManiobras();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "otrasAscensoresCuadroManiobras", theOtrasAscensoresCuadroManiobras), currentHashCode, theOtrasAscensoresCuadroManiobras);
		}
		{
			int theOtrasAscensoresRuidoMolesto;
			theOtrasAscensoresRuidoMolesto = this.getOtrasAscensoresRuidoMolesto();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "otrasAscensoresRuidoMolesto", theOtrasAscensoresRuidoMolesto), currentHashCode, theOtrasAscensoresRuidoMolesto);
		}
		{
			String theOtrasAscensoresRuidoMolestoTipoLocalizacion;
			theOtrasAscensoresRuidoMolestoTipoLocalizacion = this.getOtrasAscensoresRuidoMolestoTipoLocalizacion();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "otrasAscensoresRuidoMolestoTipoLocalizacion", theOtrasAscensoresRuidoMolestoTipoLocalizacion), currentHashCode, theOtrasAscensoresRuidoMolestoTipoLocalizacion);
		}
		{
			int theOtrasCuartosHumedosSaneamiento;
			theOtrasCuartosHumedosSaneamiento = this.getOtrasCuartosHumedosSaneamiento();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "otrasCuartosHumedosSaneamiento", theOtrasCuartosHumedosSaneamiento), currentHashCode, theOtrasCuartosHumedosSaneamiento);
		}
		{
			int theOtrasCuartosHumedosSaneamientoLanaMineral;
			theOtrasCuartosHumedosSaneamientoLanaMineral = this.getOtrasCuartosHumedosSaneamientoLanaMineral();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "otrasCuartosHumedosSaneamientoLanaMineral", theOtrasCuartosHumedosSaneamientoLanaMineral), currentHashCode, theOtrasCuartosHumedosSaneamientoLanaMineral);
		}
		{
			int theOtrasCuartosHumedosSaneamientoTechoSellado;
			theOtrasCuartosHumedosSaneamientoTechoSellado = this.getOtrasCuartosHumedosSaneamientoTechoSellado();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "otrasCuartosHumedosSaneamientoTechoSellado", theOtrasCuartosHumedosSaneamientoTechoSellado), currentHashCode, theOtrasCuartosHumedosSaneamientoTechoSellado);
		}
		{
			int theOtrasCuartosHumedosSaneamientoMaterialElastico;
			theOtrasCuartosHumedosSaneamientoMaterialElastico = this.getOtrasCuartosHumedosSaneamientoMaterialElastico();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "otrasCuartosHumedosSaneamientoMaterialElastico", theOtrasCuartosHumedosSaneamientoMaterialElastico), currentHashCode, theOtrasCuartosHumedosSaneamientoMaterialElastico);
		}
		{
			int theOtrasCuartosHumedosSaneamientoConectoresFlexibles;
			theOtrasCuartosHumedosSaneamientoConectoresFlexibles = this.getOtrasCuartosHumedosSaneamientoConectoresFlexibles();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "otrasCuartosHumedosSaneamientoConectoresFlexibles", theOtrasCuartosHumedosSaneamientoConectoresFlexibles), currentHashCode, theOtrasCuartosHumedosSaneamientoConectoresFlexibles);
		}
		{
			int theOtrasCuartosHumedosAireAcondicionado;
			theOtrasCuartosHumedosAireAcondicionado = this.getOtrasCuartosHumedosAireAcondicionado();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "otrasCuartosHumedosAireAcondicionado", theOtrasCuartosHumedosAireAcondicionado), currentHashCode, theOtrasCuartosHumedosAireAcondicionado);
		}
		{
			int theOtrasCuartosHumedosLuminariasEmpotradas;
			theOtrasCuartosHumedosLuminariasEmpotradas = this.getOtrasCuartosHumedosLuminariasEmpotradas();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "otrasCuartosHumedosLuminariasEmpotradas", theOtrasCuartosHumedosLuminariasEmpotradas), currentHashCode, theOtrasCuartosHumedosLuminariasEmpotradas);
		}
		{
			int theOtrasCuartosHumedosRuidoMolesto;
			theOtrasCuartosHumedosRuidoMolesto = this.getOtrasCuartosHumedosRuidoMolesto();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "otrasCuartosHumedosRuidoMolesto", theOtrasCuartosHumedosRuidoMolesto), currentHashCode, theOtrasCuartosHumedosRuidoMolesto);
		}
		{
			String theOtrasCuartosHumedosRuidoMolestoTipoLocalizacion;
			theOtrasCuartosHumedosRuidoMolestoTipoLocalizacion = this.getOtrasCuartosHumedosRuidoMolestoTipoLocalizacion();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "otrasCuartosHumedosRuidoMolestoTipoLocalizacion", theOtrasCuartosHumedosRuidoMolestoTipoLocalizacion), currentHashCode, theOtrasCuartosHumedosRuidoMolestoTipoLocalizacion);
		}
		{
			int theOtrasPuertasGarajeAncladas;
			theOtrasPuertasGarajeAncladas = this.getOtrasPuertasGarajeAncladas();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "otrasPuertasGarajeAncladas", theOtrasPuertasGarajeAncladas), currentHashCode, theOtrasPuertasGarajeAncladas);
		}
		{
			int theOtrasPuertasGarajeAncladasMotoresAmortiguadores;
			theOtrasPuertasGarajeAncladasMotoresAmortiguadores = this.getOtrasPuertasGarajeAncladasMotoresAmortiguadores();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "otrasPuertasGarajeAncladasMotoresAmortiguadores", theOtrasPuertasGarajeAncladasMotoresAmortiguadores), currentHashCode, theOtrasPuertasGarajeAncladasMotoresAmortiguadores);
		}
		{
			int theOtrasPuertasGarajeAncladasMarcoAmortiguadores;
			theOtrasPuertasGarajeAncladasMarcoAmortiguadores = this.getOtrasPuertasGarajeAncladasMarcoAmortiguadores();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "otrasPuertasGarajeAncladasMarcoAmortiguadores", theOtrasPuertasGarajeAncladasMarcoAmortiguadores), currentHashCode, theOtrasPuertasGarajeAncladasMarcoAmortiguadores);
		}
		{
			int theOtrasPuertasGarajeAncladasRuidoPuerta;
			theOtrasPuertasGarajeAncladasRuidoPuerta = this.getOtrasPuertasGarajeAncladasRuidoPuerta();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "otrasPuertasGarajeAncladasRuidoPuerta", theOtrasPuertasGarajeAncladasRuidoPuerta), currentHashCode, theOtrasPuertasGarajeAncladasRuidoPuerta);
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
