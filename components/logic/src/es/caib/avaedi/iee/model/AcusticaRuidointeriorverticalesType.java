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
 * Clase Java para acustica_ruidointeriorverticalesType complex type.
 * 
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que
 * haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="acustica_ruidointeriorverticalesType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="separacion_fabrica" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="acustica_ruidointeriorverticales_separacion_tipo_texto" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="separacion_fabrica_revestido" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="separacion_entramado_autoportante" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="separacion_entramado_autoportante_unahoja" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="separacion_entramado_autoportante_unahoja_espesor" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="separacion_entramado_autoportante_doshojas" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="separacion_entramado_autoportante_doshojas_espesor" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="separacion_entramado_autoportante_absorbente" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="separacion_entramado_madera" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="separacion_entramado_madera_espesor" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="separacion_entramado_madera_revestido" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="separacion_otros" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="separacion_otros_texto" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="estado_separacion_bueno" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="deficiencias_observaciones" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="caracteristicas_pilares_conectan_recintos" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="caracteristicas_pilares_conectan_recintos_revestidos" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="caracteristicas_instalaciones_conectan_recintos" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="caracteristicas_instalaciones_atraviesan_recintos" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="caracteristicas_huecos_adosados" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="caracteristicas_huecos_adosados_ruido_molesto" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="caracteristicas_huecos_adosados_revestidos" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="caracteristicas_tuberias_ancladas" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="tabiques_fabrica" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="acustica_ruidointeriorverticales_tabiques_tipo_texto" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="tabiques_entramado_autoportante_metalico" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="tabiques_entramado_autoportante_metalico_espesor" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="tabiques_entramado_madera_relleno" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="tabiques_entramado_madera_relleno_espesor" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="zona_comun_puertas_acusticamente_favorables" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="zona_comun_hall_puerta" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="observaciones" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="acustica_ruidointeriorverticales_separacion_tipos" type="{}acustica_ruidointeriorverticales_separacion_tiposType"/&gt;
 *         &lt;element name="acustica_ruidointeriorverticales_separacion_grupos" type="{}acustica_ruidointeriorverticales_separacion_gruposType"/&gt;
 *         &lt;element name="acustica_ruidointeriorverticales_separacion_subgrupos" type="{}acustica_ruidointeriorverticales_separacion_subgruposType"/&gt;
 *         &lt;element name="acustica_ruidointeriorverticales_separacion_elementos" type="{}acustica_ruidointeriorverticales_separacion_elementosType"/&gt;
 *         &lt;element name="acustica_ruidointeriorverticales_tabiques" type="{}acustica_ruidointeriorverticales_tabiquesType"/&gt;
 *         &lt;element name="acustica_ruidointeriorverticales_tabiques_caracteristicas" type="{}acustica_ruidointeriorverticales_tabiques_caracteristicasType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "acustica_ruidointeriorverticalesType", propOrder = { "separacionFabrica", "acusticaRuidointeriorverticalesSeparacionTipoTexto", "separacionFabricaRevestido", "separacionEntramadoAutoportante", "separacionEntramadoAutoportanteUnahoja", "separacionEntramadoAutoportanteUnahojaEspesor", "separacionEntramadoAutoportanteDoshojas", "separacionEntramadoAutoportanteDoshojasEspesor", "separacionEntramadoAutoportanteAbsorbente", "separacionEntramadoMadera", "separacionEntramadoMaderaEspesor", "separacionEntramadoMaderaRevestido", "separacionOtros", "separacionOtrosTexto", "estadoSeparacionBueno", "deficienciasObservaciones", "caracteristicasPilaresConectanRecintos", "caracteristicasPilaresConectanRecintosRevestidos", "caracteristicasInstalacionesConectanRecintos", "caracteristicasInstalacionesAtraviesanRecintos", "caracteristicasHuecosAdosados", "caracteristicasHuecosAdosadosRuidoMolesto", "caracteristicasHuecosAdosadosRevestidos", "caracteristicasTuberiasAncladas", "tabiquesFabrica", "acusticaRuidointeriorverticalesTabiquesTipoTexto", "tabiquesEntramadoAutoportanteMetalico", "tabiquesEntramadoAutoportanteMetalicoEspesor", "tabiquesEntramadoMaderaRelleno", "tabiquesEntramadoMaderaRellenoEspesor", "zonaComunPuertasAcusticamenteFavorables", "zonaComunHallPuerta", "observaciones", "acusticaRuidointeriorverticalesSeparacionTipos", "acusticaRuidointeriorverticalesSeparacionGrupos", "acusticaRuidointeriorverticalesSeparacionSubgrupos", "acusticaRuidointeriorverticalesSeparacionElementos", "acusticaRuidointeriorverticalesTabiques", "acusticaRuidointeriorverticalesTabiquesCaracteristicas" })
@Entity(name = "AcusticaRuidointeriorverticalesType")
@Table(name = "AED_ACU_RUIINTVERT")
@Inheritance(strategy = InheritanceType.JOINED)
public class AcusticaRuidointeriorverticalesType implements Serializable, Equals, HashCode {

	@XmlElement(name = "separacion_fabrica")
	protected int separacionFabrica;
	@XmlElement(name = "acustica_ruidointeriorverticales_separacion_tipo_texto", required = true)
	protected String acusticaRuidointeriorverticalesSeparacionTipoTexto;
	@XmlElement(name = "separacion_fabrica_revestido")
	protected int separacionFabricaRevestido;
	@XmlElement(name = "separacion_entramado_autoportante")
	protected int separacionEntramadoAutoportante;
	@XmlElement(name = "separacion_entramado_autoportante_unahoja")
	protected int separacionEntramadoAutoportanteUnahoja;
	@XmlElement(name = "separacion_entramado_autoportante_unahoja_espesor", required = true)
	protected String separacionEntramadoAutoportanteUnahojaEspesor;
	@XmlElement(name = "separacion_entramado_autoportante_doshojas")
	protected int separacionEntramadoAutoportanteDoshojas;
	@XmlElement(name = "separacion_entramado_autoportante_doshojas_espesor", required = true)
	protected String separacionEntramadoAutoportanteDoshojasEspesor;
	@XmlElement(name = "separacion_entramado_autoportante_absorbente")
	protected int separacionEntramadoAutoportanteAbsorbente;
	@XmlElement(name = "separacion_entramado_madera")
	protected int separacionEntramadoMadera;
	@XmlElement(name = "separacion_entramado_madera_espesor")
	protected int separacionEntramadoMaderaEspesor;
	@XmlElement(name = "separacion_entramado_madera_revestido")
	protected int separacionEntramadoMaderaRevestido;
	@XmlElement(name = "separacion_otros")
	protected int separacionOtros;
	@XmlElement(name = "separacion_otros_texto", required = true)
	protected String separacionOtrosTexto;
	@XmlElement(name = "estado_separacion_bueno")
	protected int estadoSeparacionBueno;
	@XmlElement(name = "deficiencias_observaciones", required = true)
	protected String deficienciasObservaciones;
	@XmlElement(name = "caracteristicas_pilares_conectan_recintos")
	protected int caracteristicasPilaresConectanRecintos;
	@XmlElement(name = "caracteristicas_pilares_conectan_recintos_revestidos")
	protected int caracteristicasPilaresConectanRecintosRevestidos;
	@XmlElement(name = "caracteristicas_instalaciones_conectan_recintos")
	protected int caracteristicasInstalacionesConectanRecintos;
	@XmlElement(name = "caracteristicas_instalaciones_atraviesan_recintos")
	protected int caracteristicasInstalacionesAtraviesanRecintos;
	@XmlElement(name = "caracteristicas_huecos_adosados")
	protected int caracteristicasHuecosAdosados;
	@XmlElement(name = "caracteristicas_huecos_adosados_ruido_molesto")
	protected int caracteristicasHuecosAdosadosRuidoMolesto;
	@XmlElement(name = "caracteristicas_huecos_adosados_revestidos")
	protected int caracteristicasHuecosAdosadosRevestidos;
	@XmlElement(name = "caracteristicas_tuberias_ancladas")
	protected int caracteristicasTuberiasAncladas;
	@XmlElement(name = "tabiques_fabrica")
	protected int tabiquesFabrica;
	@XmlElement(name = "acustica_ruidointeriorverticales_tabiques_tipo_texto", required = true)
	protected String acusticaRuidointeriorverticalesTabiquesTipoTexto;
	@XmlElement(name = "tabiques_entramado_autoportante_metalico")
	protected int tabiquesEntramadoAutoportanteMetalico;
	@XmlElement(name = "tabiques_entramado_autoportante_metalico_espesor", required = true)
	protected String tabiquesEntramadoAutoportanteMetalicoEspesor;
	@XmlElement(name = "tabiques_entramado_madera_relleno")
	protected int tabiquesEntramadoMaderaRelleno;
	@XmlElement(name = "tabiques_entramado_madera_relleno_espesor", required = true)
	protected String tabiquesEntramadoMaderaRellenoEspesor;
	@XmlElement(name = "zona_comun_puertas_acusticamente_favorables")
	protected int zonaComunPuertasAcusticamenteFavorables;
	@XmlElement(name = "zona_comun_hall_puerta")
	protected int zonaComunHallPuerta;
	@XmlElement(required = true)
	protected String observaciones;
	@XmlElement(name = "acustica_ruidointeriorverticales_separacion_tipos", required = true)
	protected AcusticaRuidointeriorverticalesSeparacionTiposType acusticaRuidointeriorverticalesSeparacionTipos;
	@XmlElement(name = "acustica_ruidointeriorverticales_separacion_grupos", required = true)
	protected AcusticaRuidointeriorverticalesSeparacionGruposType acusticaRuidointeriorverticalesSeparacionGrupos;
	@XmlElement(name = "acustica_ruidointeriorverticales_separacion_subgrupos", required = true)
	protected AcusticaRuidointeriorverticalesSeparacionSubgruposType acusticaRuidointeriorverticalesSeparacionSubgrupos;
	@XmlElement(name = "acustica_ruidointeriorverticales_separacion_elementos", required = true)
	protected AcusticaRuidointeriorverticalesSeparacionElementosType acusticaRuidointeriorverticalesSeparacionElementos;
	@XmlElement(name = "acustica_ruidointeriorverticales_tabiques", required = true)
	protected AcusticaRuidointeriorverticalesTabiquesType acusticaRuidointeriorverticalesTabiques;
	@XmlElement(name = "acustica_ruidointeriorverticales_tabiques_caracteristicas", required = true)
	protected AcusticaRuidointeriorverticalesTabiquesCaracteristicasType acusticaRuidointeriorverticalesTabiquesCaracteristicas;
	@XmlAttribute(name = "Hjid")
	protected Long hjid;

	/**
	 * Obtiene el valor de la propiedad separacionFabrica.
	 * 
	 */
	@Basic
	@Column(name = "SEPARACION_FABRICA", precision = 10, scale = 0)
	public int getSeparacionFabrica() {
		return separacionFabrica;
	}

	/**
	 * Define el valor de la propiedad separacionFabrica.
	 * 
	 */
	public void setSeparacionFabrica(int value) {
		this.separacionFabrica = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * acusticaRuidointeriorverticalesSeparacionTipoTexto.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "ACUSTICA_RUIDOINTERIORVERTICALES_SEPARACION_TIPO_TEXTO", length = 255)
	public String getAcusticaRuidointeriorverticalesSeparacionTipoTexto() {
		return acusticaRuidointeriorverticalesSeparacionTipoTexto;
	}

	/**
	 * Define el valor de la propiedad
	 * acusticaRuidointeriorverticalesSeparacionTipoTexto.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setAcusticaRuidointeriorverticalesSeparacionTipoTexto(String value) {
		this.acusticaRuidointeriorverticalesSeparacionTipoTexto = value;
	}

	/**
	 * Obtiene el valor de la propiedad separacionFabricaRevestido.
	 * 
	 */
	@Basic
	@Column(name = "SEPARACION_FABRICA_REVESTIDO", precision = 10, scale = 0)
	public int getSeparacionFabricaRevestido() {
		return separacionFabricaRevestido;
	}

	/**
	 * Define el valor de la propiedad separacionFabricaRevestido.
	 * 
	 */
	public void setSeparacionFabricaRevestido(int value) {
		this.separacionFabricaRevestido = value;
	}

	/**
	 * Obtiene el valor de la propiedad separacionEntramadoAutoportante.
	 * 
	 */
	@Basic
	@Column(name = "SEPARACION_ENTRAMADO_AUTOPORTANTE", precision = 10, scale = 0)
	public int getSeparacionEntramadoAutoportante() {
		return separacionEntramadoAutoportante;
	}

	/**
	 * Define el valor de la propiedad separacionEntramadoAutoportante.
	 * 
	 */
	public void setSeparacionEntramadoAutoportante(int value) {
		this.separacionEntramadoAutoportante = value;
	}

	/**
	 * Obtiene el valor de la propiedad separacionEntramadoAutoportanteUnahoja.
	 * 
	 */
	@Basic
	@Column(name = "SEPARACION_ENTRAMADO_AUTOPORTANTE_UNAHOJA", precision = 10, scale = 0)
	public int getSeparacionEntramadoAutoportanteUnahoja() {
		return separacionEntramadoAutoportanteUnahoja;
	}

	/**
	 * Define el valor de la propiedad separacionEntramadoAutoportanteUnahoja.
	 * 
	 */
	public void setSeparacionEntramadoAutoportanteUnahoja(int value) {
		this.separacionEntramadoAutoportanteUnahoja = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * separacionEntramadoAutoportanteUnahojaEspesor.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "SEPARACION_ENTRAMADO_AUTOPORTANTE_UNAHOJA_ESPESOR", length = 255)
	public String getSeparacionEntramadoAutoportanteUnahojaEspesor() {
		return separacionEntramadoAutoportanteUnahojaEspesor;
	}

	/**
	 * Define el valor de la propiedad
	 * separacionEntramadoAutoportanteUnahojaEspesor.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSeparacionEntramadoAutoportanteUnahojaEspesor(String value) {
		this.separacionEntramadoAutoportanteUnahojaEspesor = value;
	}

	/**
	 * Obtiene el valor de la propiedad separacionEntramadoAutoportanteDoshojas.
	 * 
	 */
	@Basic
	@Column(name = "SEPARACION_ENTRAMADO_AUTOPORTANTE_DOSHOJAS", precision = 10, scale = 0)
	public int getSeparacionEntramadoAutoportanteDoshojas() {
		return separacionEntramadoAutoportanteDoshojas;
	}

	/**
	 * Define el valor de la propiedad separacionEntramadoAutoportanteDoshojas.
	 * 
	 */
	public void setSeparacionEntramadoAutoportanteDoshojas(int value) {
		this.separacionEntramadoAutoportanteDoshojas = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * separacionEntramadoAutoportanteDoshojasEspesor.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "SEPARACION_ENTRAMADO_AUTOPORTANTE_DOSHOJAS_ESPESOR", length = 255)
	public String getSeparacionEntramadoAutoportanteDoshojasEspesor() {
		return separacionEntramadoAutoportanteDoshojasEspesor;
	}

	/**
	 * Define el valor de la propiedad
	 * separacionEntramadoAutoportanteDoshojasEspesor.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSeparacionEntramadoAutoportanteDoshojasEspesor(String value) {
		this.separacionEntramadoAutoportanteDoshojasEspesor = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * separacionEntramadoAutoportanteAbsorbente.
	 * 
	 */
	@Basic
	@Column(name = "SEPARACION_ENTRAMADO_AUTOPORTANTE_ABSORBENTE", precision = 10, scale = 0)
	public int getSeparacionEntramadoAutoportanteAbsorbente() {
		return separacionEntramadoAutoportanteAbsorbente;
	}

	/**
	 * Define el valor de la propiedad
	 * separacionEntramadoAutoportanteAbsorbente.
	 * 
	 */
	public void setSeparacionEntramadoAutoportanteAbsorbente(int value) {
		this.separacionEntramadoAutoportanteAbsorbente = value;
	}

	/**
	 * Obtiene el valor de la propiedad separacionEntramadoMadera.
	 * 
	 */
	@Basic
	@Column(name = "SEPARACION_ENTRAMADO_MADERA", precision = 10, scale = 0)
	public int getSeparacionEntramadoMadera() {
		return separacionEntramadoMadera;
	}

	/**
	 * Define el valor de la propiedad separacionEntramadoMadera.
	 * 
	 */
	public void setSeparacionEntramadoMadera(int value) {
		this.separacionEntramadoMadera = value;
	}

	/**
	 * Obtiene el valor de la propiedad separacionEntramadoMaderaEspesor.
	 * 
	 */
	@Basic
	@Column(name = "SEPARACION_ENTRAMADO_MADERA_ESPESOR", precision = 10, scale = 0)
	public int getSeparacionEntramadoMaderaEspesor() {
		return separacionEntramadoMaderaEspesor;
	}

	/**
	 * Define el valor de la propiedad separacionEntramadoMaderaEspesor.
	 * 
	 */
	public void setSeparacionEntramadoMaderaEspesor(int value) {
		this.separacionEntramadoMaderaEspesor = value;
	}

	/**
	 * Obtiene el valor de la propiedad separacionEntramadoMaderaRevestido.
	 * 
	 */
	@Basic
	@Column(name = "SEPARACION_ENTRAMADO_MADERA_REVESTIDO", precision = 10, scale = 0)
	public int getSeparacionEntramadoMaderaRevestido() {
		return separacionEntramadoMaderaRevestido;
	}

	/**
	 * Define el valor de la propiedad separacionEntramadoMaderaRevestido.
	 * 
	 */
	public void setSeparacionEntramadoMaderaRevestido(int value) {
		this.separacionEntramadoMaderaRevestido = value;
	}

	/**
	 * Obtiene el valor de la propiedad separacionOtros.
	 * 
	 */
	@Basic
	@Column(name = "SEPARACION_OTROS", precision = 10, scale = 0)
	public int getSeparacionOtros() {
		return separacionOtros;
	}

	/**
	 * Define el valor de la propiedad separacionOtros.
	 * 
	 */
	public void setSeparacionOtros(int value) {
		this.separacionOtros = value;
	}

	/**
	 * Obtiene el valor de la propiedad separacionOtrosTexto.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "SEPARACION_OTROS_TEXTO", length = 255)
	public String getSeparacionOtrosTexto() {
		return separacionOtrosTexto;
	}

	/**
	 * Define el valor de la propiedad separacionOtrosTexto.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSeparacionOtrosTexto(String value) {
		this.separacionOtrosTexto = value;
	}

	/**
	 * Obtiene el valor de la propiedad estadoSeparacionBueno.
	 * 
	 */
	@Basic
	@Column(name = "ESTADO_SEPARACION_BUENO", precision = 10, scale = 0)
	public int getEstadoSeparacionBueno() {
		return estadoSeparacionBueno;
	}

	/**
	 * Define el valor de la propiedad estadoSeparacionBueno.
	 * 
	 */
	public void setEstadoSeparacionBueno(int value) {
		this.estadoSeparacionBueno = value;
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
	 * Obtiene el valor de la propiedad caracteristicasPilaresConectanRecintos.
	 * 
	 */
	@Basic
	@Column(name = "CARACTERISTICAS_PILARES_CONECTAN_RECINTOS", precision = 10, scale = 0)
	public int getCaracteristicasPilaresConectanRecintos() {
		return caracteristicasPilaresConectanRecintos;
	}

	/**
	 * Define el valor de la propiedad caracteristicasPilaresConectanRecintos.
	 * 
	 */
	public void setCaracteristicasPilaresConectanRecintos(int value) {
		this.caracteristicasPilaresConectanRecintos = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * caracteristicasPilaresConectanRecintosRevestidos.
	 * 
	 */
	@Basic
	@Column(name = "CARACTERISTICAS_PILARES_CONECTAN_RECINTOS_REVESTIDOS", precision = 10, scale = 0)
	public int getCaracteristicasPilaresConectanRecintosRevestidos() {
		return caracteristicasPilaresConectanRecintosRevestidos;
	}

	/**
	 * Define el valor de la propiedad
	 * caracteristicasPilaresConectanRecintosRevestidos.
	 * 
	 */
	public void setCaracteristicasPilaresConectanRecintosRevestidos(int value) {
		this.caracteristicasPilaresConectanRecintosRevestidos = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * caracteristicasInstalacionesConectanRecintos.
	 * 
	 */
	@Basic
	@Column(name = "CARACTERISTICAS_INSTALACIONES_CONECTAN_RECINTOS", precision = 10, scale = 0)
	public int getCaracteristicasInstalacionesConectanRecintos() {
		return caracteristicasInstalacionesConectanRecintos;
	}

	/**
	 * Define el valor de la propiedad
	 * caracteristicasInstalacionesConectanRecintos.
	 * 
	 */
	public void setCaracteristicasInstalacionesConectanRecintos(int value) {
		this.caracteristicasInstalacionesConectanRecintos = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * caracteristicasInstalacionesAtraviesanRecintos.
	 * 
	 */
	@Basic
	@Column(name = "CARACTERISTICAS_INSTALACIONES_ATRAVIESAN_RECINTOS", precision = 10, scale = 0)
	public int getCaracteristicasInstalacionesAtraviesanRecintos() {
		return caracteristicasInstalacionesAtraviesanRecintos;
	}

	/**
	 * Define el valor de la propiedad
	 * caracteristicasInstalacionesAtraviesanRecintos.
	 * 
	 */
	public void setCaracteristicasInstalacionesAtraviesanRecintos(int value) {
		this.caracteristicasInstalacionesAtraviesanRecintos = value;
	}

	/**
	 * Obtiene el valor de la propiedad caracteristicasHuecosAdosados.
	 * 
	 */
	@Basic
	@Column(name = "CARACTERISTICAS_HUECOS_ADOSADOS", precision = 10, scale = 0)
	public int getCaracteristicasHuecosAdosados() {
		return caracteristicasHuecosAdosados;
	}

	/**
	 * Define el valor de la propiedad caracteristicasHuecosAdosados.
	 * 
	 */
	public void setCaracteristicasHuecosAdosados(int value) {
		this.caracteristicasHuecosAdosados = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * caracteristicasHuecosAdosadosRuidoMolesto.
	 * 
	 */
	@Basic
	@Column(name = "CARACTERISTICAS_HUECOS_ADOSADOS_RUIDO_MOLESTO", precision = 10, scale = 0)
	public int getCaracteristicasHuecosAdosadosRuidoMolesto() {
		return caracteristicasHuecosAdosadosRuidoMolesto;
	}

	/**
	 * Define el valor de la propiedad
	 * caracteristicasHuecosAdosadosRuidoMolesto.
	 * 
	 */
	public void setCaracteristicasHuecosAdosadosRuidoMolesto(int value) {
		this.caracteristicasHuecosAdosadosRuidoMolesto = value;
	}

	/**
	 * Obtiene el valor de la propiedad caracteristicasHuecosAdosadosRevestidos.
	 * 
	 */
	@Basic
	@Column(name = "CARACTERISTICAS_HUECOS_ADOSADOS_REVESTIDOS", precision = 10, scale = 0)
	public int getCaracteristicasHuecosAdosadosRevestidos() {
		return caracteristicasHuecosAdosadosRevestidos;
	}

	/**
	 * Define el valor de la propiedad caracteristicasHuecosAdosadosRevestidos.
	 * 
	 */
	public void setCaracteristicasHuecosAdosadosRevestidos(int value) {
		this.caracteristicasHuecosAdosadosRevestidos = value;
	}

	/**
	 * Obtiene el valor de la propiedad caracteristicasTuberiasAncladas.
	 * 
	 */
	@Basic
	@Column(name = "CARACTERISTICAS_TUBERIAS_ANCLADAS", precision = 10, scale = 0)
	public int getCaracteristicasTuberiasAncladas() {
		return caracteristicasTuberiasAncladas;
	}

	/**
	 * Define el valor de la propiedad caracteristicasTuberiasAncladas.
	 * 
	 */
	public void setCaracteristicasTuberiasAncladas(int value) {
		this.caracteristicasTuberiasAncladas = value;
	}

	/**
	 * Obtiene el valor de la propiedad tabiquesFabrica.
	 * 
	 */
	@Basic
	@Column(name = "TABIQUES_FABRICA", precision = 10, scale = 0)
	public int getTabiquesFabrica() {
		return tabiquesFabrica;
	}

	/**
	 * Define el valor de la propiedad tabiquesFabrica.
	 * 
	 */
	public void setTabiquesFabrica(int value) {
		this.tabiquesFabrica = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * acusticaRuidointeriorverticalesTabiquesTipoTexto.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "ACUSTICA_RUIDOINTERIORVERTICALES_TABIQUES_TIPO_TEXTO", length = 255)
	public String getAcusticaRuidointeriorverticalesTabiquesTipoTexto() {
		return acusticaRuidointeriorverticalesTabiquesTipoTexto;
	}

	/**
	 * Define el valor de la propiedad
	 * acusticaRuidointeriorverticalesTabiquesTipoTexto.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setAcusticaRuidointeriorverticalesTabiquesTipoTexto(String value) {
		this.acusticaRuidointeriorverticalesTabiquesTipoTexto = value;
	}

	/**
	 * Obtiene el valor de la propiedad tabiquesEntramadoAutoportanteMetalico.
	 * 
	 */
	@Basic
	@Column(name = "TABIQUES_ENTRAMADO_AUTOPORTANTE_METALICO", precision = 10, scale = 0)
	public int getTabiquesEntramadoAutoportanteMetalico() {
		return tabiquesEntramadoAutoportanteMetalico;
	}

	/**
	 * Define el valor de la propiedad tabiquesEntramadoAutoportanteMetalico.
	 * 
	 */
	public void setTabiquesEntramadoAutoportanteMetalico(int value) {
		this.tabiquesEntramadoAutoportanteMetalico = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * tabiquesEntramadoAutoportanteMetalicoEspesor.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "TABIQUES_ENTRAMADO_AUTOPORTANTE_METALICO_ESPESOR", length = 255)
	public String getTabiquesEntramadoAutoportanteMetalicoEspesor() {
		return tabiquesEntramadoAutoportanteMetalicoEspesor;
	}

	/**
	 * Define el valor de la propiedad
	 * tabiquesEntramadoAutoportanteMetalicoEspesor.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTabiquesEntramadoAutoportanteMetalicoEspesor(String value) {
		this.tabiquesEntramadoAutoportanteMetalicoEspesor = value;
	}

	/**
	 * Obtiene el valor de la propiedad tabiquesEntramadoMaderaRelleno.
	 * 
	 */
	@Basic
	@Column(name = "TABIQUES_ENTRAMADO_MADERA_RELLENO", precision = 10, scale = 0)
	public int getTabiquesEntramadoMaderaRelleno() {
		return tabiquesEntramadoMaderaRelleno;
	}

	/**
	 * Define el valor de la propiedad tabiquesEntramadoMaderaRelleno.
	 * 
	 */
	public void setTabiquesEntramadoMaderaRelleno(int value) {
		this.tabiquesEntramadoMaderaRelleno = value;
	}

	/**
	 * Obtiene el valor de la propiedad tabiquesEntramadoMaderaRellenoEspesor.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "TABIQUES_ENTRAMADO_MADERA_RELLENO_ESPESOR", length = 255)
	public String getTabiquesEntramadoMaderaRellenoEspesor() {
		return tabiquesEntramadoMaderaRellenoEspesor;
	}

	/**
	 * Define el valor de la propiedad tabiquesEntramadoMaderaRellenoEspesor.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTabiquesEntramadoMaderaRellenoEspesor(String value) {
		this.tabiquesEntramadoMaderaRellenoEspesor = value;
	}

	/**
	 * Obtiene el valor de la propiedad zonaComunPuertasAcusticamenteFavorables.
	 * 
	 */
	@Basic
	@Column(name = "ZONA_COMUN_PUERTAS_ACUSTICAMENTE_FAVORABLES", precision = 10, scale = 0)
	public int getZonaComunPuertasAcusticamenteFavorables() {
		return zonaComunPuertasAcusticamenteFavorables;
	}

	/**
	 * Define el valor de la propiedad zonaComunPuertasAcusticamenteFavorables.
	 * 
	 */
	public void setZonaComunPuertasAcusticamenteFavorables(int value) {
		this.zonaComunPuertasAcusticamenteFavorables = value;
	}

	/**
	 * Obtiene el valor de la propiedad zonaComunHallPuerta.
	 * 
	 */
	@Basic
	@Column(name = "ZONA_COMUN_HALL_PUERTA", precision = 10, scale = 0)
	public int getZonaComunHallPuerta() {
		return zonaComunHallPuerta;
	}

	/**
	 * Define el valor de la propiedad zonaComunHallPuerta.
	 * 
	 */
	public void setZonaComunHallPuerta(int value) {
		this.zonaComunHallPuerta = value;
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
	 * acusticaRuidointeriorverticalesSeparacionTipos.
	 * 
	 * @return possible object is
	 *         {@link AcusticaRuidointeriorverticalesSeparacionTiposType }
	 * 
	 */
	@ManyToOne(targetEntity = AcusticaRuidointeriorverticalesSeparacionTiposType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "ACUSTICA_RUIDOINTERIORVERTICALES_SEPARACION_TIPOS_AED_ACU_RUIINTVERT_HJID")
	public AcusticaRuidointeriorverticalesSeparacionTiposType getAcusticaRuidointeriorverticalesSeparacionTipos() {
		return acusticaRuidointeriorverticalesSeparacionTipos;
	}

	/**
	 * Define el valor de la propiedad
	 * acusticaRuidointeriorverticalesSeparacionTipos.
	 * 
	 * @param value
	 *            allowed object is
	 *            {@link AcusticaRuidointeriorverticalesSeparacionTiposType }
	 * 
	 */
	public void setAcusticaRuidointeriorverticalesSeparacionTipos(AcusticaRuidointeriorverticalesSeparacionTiposType value) {
		this.acusticaRuidointeriorverticalesSeparacionTipos = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * acusticaRuidointeriorverticalesSeparacionGrupos.
	 * 
	 * @return possible object is
	 *         {@link AcusticaRuidointeriorverticalesSeparacionGruposType }
	 * 
	 */
	@ManyToOne(targetEntity = AcusticaRuidointeriorverticalesSeparacionGruposType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "ACUSTICA_RUIDOINTERIORVERTICALES_SEPARACION_GRUPOS_AED_ACU_RUIINTVERT_HJID")
	public AcusticaRuidointeriorverticalesSeparacionGruposType getAcusticaRuidointeriorverticalesSeparacionGrupos() {
		return acusticaRuidointeriorverticalesSeparacionGrupos;
	}

	/**
	 * Define el valor de la propiedad
	 * acusticaRuidointeriorverticalesSeparacionGrupos.
	 * 
	 * @param value
	 *            allowed object is
	 *            {@link AcusticaRuidointeriorverticalesSeparacionGruposType }
	 * 
	 */
	public void setAcusticaRuidointeriorverticalesSeparacionGrupos(AcusticaRuidointeriorverticalesSeparacionGruposType value) {
		this.acusticaRuidointeriorverticalesSeparacionGrupos = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * acusticaRuidointeriorverticalesSeparacionSubgrupos.
	 * 
	 * @return possible object is
	 *         {@link AcusticaRuidointeriorverticalesSeparacionSubgruposType }
	 * 
	 */
	@ManyToOne(targetEntity = AcusticaRuidointeriorverticalesSeparacionSubgruposType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "ACUSTICA_RUIDOINTERIORVERTICALES_SEPARACION_SUBGRUPOS_AED_ACU_RUIINTVERT_HJID")
	public AcusticaRuidointeriorverticalesSeparacionSubgruposType getAcusticaRuidointeriorverticalesSeparacionSubgrupos() {
		return acusticaRuidointeriorverticalesSeparacionSubgrupos;
	}

	/**
	 * Define el valor de la propiedad
	 * acusticaRuidointeriorverticalesSeparacionSubgrupos.
	 * 
	 * @param value
	 *            allowed object is
	 *            {@link AcusticaRuidointeriorverticalesSeparacionSubgruposType }
	 * 
	 */
	public void setAcusticaRuidointeriorverticalesSeparacionSubgrupos(AcusticaRuidointeriorverticalesSeparacionSubgruposType value) {
		this.acusticaRuidointeriorverticalesSeparacionSubgrupos = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * acusticaRuidointeriorverticalesSeparacionElementos.
	 * 
	 * @return possible object is
	 *         {@link AcusticaRuidointeriorverticalesSeparacionElementosType }
	 * 
	 */
	@ManyToOne(targetEntity = AcusticaRuidointeriorverticalesSeparacionElementosType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "ACUSTICA_RUIDOINTERIORVERTICALES_SEPARACION_ELEMENTOS_AED_ACU_RUIINTVERT_HJID")
	public AcusticaRuidointeriorverticalesSeparacionElementosType getAcusticaRuidointeriorverticalesSeparacionElementos() {
		return acusticaRuidointeriorverticalesSeparacionElementos;
	}

	/**
	 * Define el valor de la propiedad
	 * acusticaRuidointeriorverticalesSeparacionElementos.
	 * 
	 * @param value
	 *            allowed object is
	 *            {@link AcusticaRuidointeriorverticalesSeparacionElementosType }
	 * 
	 */
	public void setAcusticaRuidointeriorverticalesSeparacionElementos(AcusticaRuidointeriorverticalesSeparacionElementosType value) {
		this.acusticaRuidointeriorverticalesSeparacionElementos = value;
	}

	/**
	 * Obtiene el valor de la propiedad acusticaRuidointeriorverticalesTabiques.
	 * 
	 * @return possible object is
	 *         {@link AcusticaRuidointeriorverticalesTabiquesType }
	 * 
	 */
	@ManyToOne(targetEntity = AcusticaRuidointeriorverticalesTabiquesType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "ACUSTICA_RUIDOINTERIORVERTICALES_TABIQUES_AED_ACU_RUIINTVERT_HJID")
	public AcusticaRuidointeriorverticalesTabiquesType getAcusticaRuidointeriorverticalesTabiques() {
		return acusticaRuidointeriorverticalesTabiques;
	}

	/**
	 * Define el valor de la propiedad acusticaRuidointeriorverticalesTabiques.
	 * 
	 * @param value
	 *            allowed object is
	 *            {@link AcusticaRuidointeriorverticalesTabiquesType }
	 * 
	 */
	public void setAcusticaRuidointeriorverticalesTabiques(AcusticaRuidointeriorverticalesTabiquesType value) {
		this.acusticaRuidointeriorverticalesTabiques = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * acusticaRuidointeriorverticalesTabiquesCaracteristicas.
	 * 
	 * @return possible object is
	 *         {@link AcusticaRuidointeriorverticalesTabiquesCaracteristicasType }
	 * 
	 */
	@ManyToOne(targetEntity = AcusticaRuidointeriorverticalesTabiquesCaracteristicasType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "ACUSTICA_RUIDOINTERIORVERTICALES_TABIQUES_CARACTERISTICAS_AED_ACU_RUIINTVERT_HJID")
	public AcusticaRuidointeriorverticalesTabiquesCaracteristicasType getAcusticaRuidointeriorverticalesTabiquesCaracteristicas() {
		return acusticaRuidointeriorverticalesTabiquesCaracteristicas;
	}

	/**
	 * Define el valor de la propiedad
	 * acusticaRuidointeriorverticalesTabiquesCaracteristicas.
	 * 
	 * @param value
	 *            allowed object is
	 *            {@link AcusticaRuidointeriorverticalesTabiquesCaracteristicasType }
	 * 
	 */
	public void setAcusticaRuidointeriorverticalesTabiquesCaracteristicas(AcusticaRuidointeriorverticalesTabiquesCaracteristicasType value) {
		this.acusticaRuidointeriorverticalesTabiquesCaracteristicas = value;
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
		final AcusticaRuidointeriorverticalesType that = ((AcusticaRuidointeriorverticalesType) object);
		{
			int lhsSeparacionFabrica;
			lhsSeparacionFabrica = this.getSeparacionFabrica();
			int rhsSeparacionFabrica;
			rhsSeparacionFabrica = that.getSeparacionFabrica();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "separacionFabrica", lhsSeparacionFabrica), LocatorUtils.property(thatLocator, "separacionFabrica", rhsSeparacionFabrica), lhsSeparacionFabrica, rhsSeparacionFabrica)) {
				return false;
			}
		}
		{
			String lhsAcusticaRuidointeriorverticalesSeparacionTipoTexto;
			lhsAcusticaRuidointeriorverticalesSeparacionTipoTexto = this.getAcusticaRuidointeriorverticalesSeparacionTipoTexto();
			String rhsAcusticaRuidointeriorverticalesSeparacionTipoTexto;
			rhsAcusticaRuidointeriorverticalesSeparacionTipoTexto = that.getAcusticaRuidointeriorverticalesSeparacionTipoTexto();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "acusticaRuidointeriorverticalesSeparacionTipoTexto", lhsAcusticaRuidointeriorverticalesSeparacionTipoTexto), LocatorUtils.property(thatLocator, "acusticaRuidointeriorverticalesSeparacionTipoTexto", rhsAcusticaRuidointeriorverticalesSeparacionTipoTexto), lhsAcusticaRuidointeriorverticalesSeparacionTipoTexto, rhsAcusticaRuidointeriorverticalesSeparacionTipoTexto)) {
				return false;
			}
		}
		{
			int lhsSeparacionFabricaRevestido;
			lhsSeparacionFabricaRevestido = this.getSeparacionFabricaRevestido();
			int rhsSeparacionFabricaRevestido;
			rhsSeparacionFabricaRevestido = that.getSeparacionFabricaRevestido();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "separacionFabricaRevestido", lhsSeparacionFabricaRevestido), LocatorUtils.property(thatLocator, "separacionFabricaRevestido", rhsSeparacionFabricaRevestido), lhsSeparacionFabricaRevestido, rhsSeparacionFabricaRevestido)) {
				return false;
			}
		}
		{
			int lhsSeparacionEntramadoAutoportante;
			lhsSeparacionEntramadoAutoportante = this.getSeparacionEntramadoAutoportante();
			int rhsSeparacionEntramadoAutoportante;
			rhsSeparacionEntramadoAutoportante = that.getSeparacionEntramadoAutoportante();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "separacionEntramadoAutoportante", lhsSeparacionEntramadoAutoportante), LocatorUtils.property(thatLocator, "separacionEntramadoAutoportante", rhsSeparacionEntramadoAutoportante), lhsSeparacionEntramadoAutoportante, rhsSeparacionEntramadoAutoportante)) {
				return false;
			}
		}
		{
			int lhsSeparacionEntramadoAutoportanteUnahoja;
			lhsSeparacionEntramadoAutoportanteUnahoja = this.getSeparacionEntramadoAutoportanteUnahoja();
			int rhsSeparacionEntramadoAutoportanteUnahoja;
			rhsSeparacionEntramadoAutoportanteUnahoja = that.getSeparacionEntramadoAutoportanteUnahoja();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "separacionEntramadoAutoportanteUnahoja", lhsSeparacionEntramadoAutoportanteUnahoja), LocatorUtils.property(thatLocator, "separacionEntramadoAutoportanteUnahoja", rhsSeparacionEntramadoAutoportanteUnahoja), lhsSeparacionEntramadoAutoportanteUnahoja, rhsSeparacionEntramadoAutoportanteUnahoja)) {
				return false;
			}
		}
		{
			String lhsSeparacionEntramadoAutoportanteUnahojaEspesor;
			lhsSeparacionEntramadoAutoportanteUnahojaEspesor = this.getSeparacionEntramadoAutoportanteUnahojaEspesor();
			String rhsSeparacionEntramadoAutoportanteUnahojaEspesor;
			rhsSeparacionEntramadoAutoportanteUnahojaEspesor = that.getSeparacionEntramadoAutoportanteUnahojaEspesor();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "separacionEntramadoAutoportanteUnahojaEspesor", lhsSeparacionEntramadoAutoportanteUnahojaEspesor), LocatorUtils.property(thatLocator, "separacionEntramadoAutoportanteUnahojaEspesor", rhsSeparacionEntramadoAutoportanteUnahojaEspesor), lhsSeparacionEntramadoAutoportanteUnahojaEspesor, rhsSeparacionEntramadoAutoportanteUnahojaEspesor)) {
				return false;
			}
		}
		{
			int lhsSeparacionEntramadoAutoportanteDoshojas;
			lhsSeparacionEntramadoAutoportanteDoshojas = this.getSeparacionEntramadoAutoportanteDoshojas();
			int rhsSeparacionEntramadoAutoportanteDoshojas;
			rhsSeparacionEntramadoAutoportanteDoshojas = that.getSeparacionEntramadoAutoportanteDoshojas();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "separacionEntramadoAutoportanteDoshojas", lhsSeparacionEntramadoAutoportanteDoshojas), LocatorUtils.property(thatLocator, "separacionEntramadoAutoportanteDoshojas", rhsSeparacionEntramadoAutoportanteDoshojas), lhsSeparacionEntramadoAutoportanteDoshojas, rhsSeparacionEntramadoAutoportanteDoshojas)) {
				return false;
			}
		}
		{
			String lhsSeparacionEntramadoAutoportanteDoshojasEspesor;
			lhsSeparacionEntramadoAutoportanteDoshojasEspesor = this.getSeparacionEntramadoAutoportanteDoshojasEspesor();
			String rhsSeparacionEntramadoAutoportanteDoshojasEspesor;
			rhsSeparacionEntramadoAutoportanteDoshojasEspesor = that.getSeparacionEntramadoAutoportanteDoshojasEspesor();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "separacionEntramadoAutoportanteDoshojasEspesor", lhsSeparacionEntramadoAutoportanteDoshojasEspesor), LocatorUtils.property(thatLocator, "separacionEntramadoAutoportanteDoshojasEspesor", rhsSeparacionEntramadoAutoportanteDoshojasEspesor), lhsSeparacionEntramadoAutoportanteDoshojasEspesor, rhsSeparacionEntramadoAutoportanteDoshojasEspesor)) {
				return false;
			}
		}
		{
			int lhsSeparacionEntramadoAutoportanteAbsorbente;
			lhsSeparacionEntramadoAutoportanteAbsorbente = this.getSeparacionEntramadoAutoportanteAbsorbente();
			int rhsSeparacionEntramadoAutoportanteAbsorbente;
			rhsSeparacionEntramadoAutoportanteAbsorbente = that.getSeparacionEntramadoAutoportanteAbsorbente();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "separacionEntramadoAutoportanteAbsorbente", lhsSeparacionEntramadoAutoportanteAbsorbente), LocatorUtils.property(thatLocator, "separacionEntramadoAutoportanteAbsorbente", rhsSeparacionEntramadoAutoportanteAbsorbente), lhsSeparacionEntramadoAutoportanteAbsorbente, rhsSeparacionEntramadoAutoportanteAbsorbente)) {
				return false;
			}
		}
		{
			int lhsSeparacionEntramadoMadera;
			lhsSeparacionEntramadoMadera = this.getSeparacionEntramadoMadera();
			int rhsSeparacionEntramadoMadera;
			rhsSeparacionEntramadoMadera = that.getSeparacionEntramadoMadera();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "separacionEntramadoMadera", lhsSeparacionEntramadoMadera), LocatorUtils.property(thatLocator, "separacionEntramadoMadera", rhsSeparacionEntramadoMadera), lhsSeparacionEntramadoMadera, rhsSeparacionEntramadoMadera)) {
				return false;
			}
		}
		{
			int lhsSeparacionEntramadoMaderaEspesor;
			lhsSeparacionEntramadoMaderaEspesor = this.getSeparacionEntramadoMaderaEspesor();
			int rhsSeparacionEntramadoMaderaEspesor;
			rhsSeparacionEntramadoMaderaEspesor = that.getSeparacionEntramadoMaderaEspesor();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "separacionEntramadoMaderaEspesor", lhsSeparacionEntramadoMaderaEspesor), LocatorUtils.property(thatLocator, "separacionEntramadoMaderaEspesor", rhsSeparacionEntramadoMaderaEspesor), lhsSeparacionEntramadoMaderaEspesor, rhsSeparacionEntramadoMaderaEspesor)) {
				return false;
			}
		}
		{
			int lhsSeparacionEntramadoMaderaRevestido;
			lhsSeparacionEntramadoMaderaRevestido = this.getSeparacionEntramadoMaderaRevestido();
			int rhsSeparacionEntramadoMaderaRevestido;
			rhsSeparacionEntramadoMaderaRevestido = that.getSeparacionEntramadoMaderaRevestido();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "separacionEntramadoMaderaRevestido", lhsSeparacionEntramadoMaderaRevestido), LocatorUtils.property(thatLocator, "separacionEntramadoMaderaRevestido", rhsSeparacionEntramadoMaderaRevestido), lhsSeparacionEntramadoMaderaRevestido, rhsSeparacionEntramadoMaderaRevestido)) {
				return false;
			}
		}
		{
			int lhsSeparacionOtros;
			lhsSeparacionOtros = this.getSeparacionOtros();
			int rhsSeparacionOtros;
			rhsSeparacionOtros = that.getSeparacionOtros();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "separacionOtros", lhsSeparacionOtros), LocatorUtils.property(thatLocator, "separacionOtros", rhsSeparacionOtros), lhsSeparacionOtros, rhsSeparacionOtros)) {
				return false;
			}
		}
		{
			String lhsSeparacionOtrosTexto;
			lhsSeparacionOtrosTexto = this.getSeparacionOtrosTexto();
			String rhsSeparacionOtrosTexto;
			rhsSeparacionOtrosTexto = that.getSeparacionOtrosTexto();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "separacionOtrosTexto", lhsSeparacionOtrosTexto), LocatorUtils.property(thatLocator, "separacionOtrosTexto", rhsSeparacionOtrosTexto), lhsSeparacionOtrosTexto, rhsSeparacionOtrosTexto)) {
				return false;
			}
		}
		{
			int lhsEstadoSeparacionBueno;
			lhsEstadoSeparacionBueno = this.getEstadoSeparacionBueno();
			int rhsEstadoSeparacionBueno;
			rhsEstadoSeparacionBueno = that.getEstadoSeparacionBueno();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "estadoSeparacionBueno", lhsEstadoSeparacionBueno), LocatorUtils.property(thatLocator, "estadoSeparacionBueno", rhsEstadoSeparacionBueno), lhsEstadoSeparacionBueno, rhsEstadoSeparacionBueno)) {
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
			int lhsCaracteristicasPilaresConectanRecintos;
			lhsCaracteristicasPilaresConectanRecintos = this.getCaracteristicasPilaresConectanRecintos();
			int rhsCaracteristicasPilaresConectanRecintos;
			rhsCaracteristicasPilaresConectanRecintos = that.getCaracteristicasPilaresConectanRecintos();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "caracteristicasPilaresConectanRecintos", lhsCaracteristicasPilaresConectanRecintos), LocatorUtils.property(thatLocator, "caracteristicasPilaresConectanRecintos", rhsCaracteristicasPilaresConectanRecintos), lhsCaracteristicasPilaresConectanRecintos, rhsCaracteristicasPilaresConectanRecintos)) {
				return false;
			}
		}
		{
			int lhsCaracteristicasPilaresConectanRecintosRevestidos;
			lhsCaracteristicasPilaresConectanRecintosRevestidos = this.getCaracteristicasPilaresConectanRecintosRevestidos();
			int rhsCaracteristicasPilaresConectanRecintosRevestidos;
			rhsCaracteristicasPilaresConectanRecintosRevestidos = that.getCaracteristicasPilaresConectanRecintosRevestidos();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "caracteristicasPilaresConectanRecintosRevestidos", lhsCaracteristicasPilaresConectanRecintosRevestidos), LocatorUtils.property(thatLocator, "caracteristicasPilaresConectanRecintosRevestidos", rhsCaracteristicasPilaresConectanRecintosRevestidos), lhsCaracteristicasPilaresConectanRecintosRevestidos, rhsCaracteristicasPilaresConectanRecintosRevestidos)) {
				return false;
			}
		}
		{
			int lhsCaracteristicasInstalacionesConectanRecintos;
			lhsCaracteristicasInstalacionesConectanRecintos = this.getCaracteristicasInstalacionesConectanRecintos();
			int rhsCaracteristicasInstalacionesConectanRecintos;
			rhsCaracteristicasInstalacionesConectanRecintos = that.getCaracteristicasInstalacionesConectanRecintos();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "caracteristicasInstalacionesConectanRecintos", lhsCaracteristicasInstalacionesConectanRecintos), LocatorUtils.property(thatLocator, "caracteristicasInstalacionesConectanRecintos", rhsCaracteristicasInstalacionesConectanRecintos), lhsCaracteristicasInstalacionesConectanRecintos, rhsCaracteristicasInstalacionesConectanRecintos)) {
				return false;
			}
		}
		{
			int lhsCaracteristicasInstalacionesAtraviesanRecintos;
			lhsCaracteristicasInstalacionesAtraviesanRecintos = this.getCaracteristicasInstalacionesAtraviesanRecintos();
			int rhsCaracteristicasInstalacionesAtraviesanRecintos;
			rhsCaracteristicasInstalacionesAtraviesanRecintos = that.getCaracteristicasInstalacionesAtraviesanRecintos();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "caracteristicasInstalacionesAtraviesanRecintos", lhsCaracteristicasInstalacionesAtraviesanRecintos), LocatorUtils.property(thatLocator, "caracteristicasInstalacionesAtraviesanRecintos", rhsCaracteristicasInstalacionesAtraviesanRecintos), lhsCaracteristicasInstalacionesAtraviesanRecintos, rhsCaracteristicasInstalacionesAtraviesanRecintos)) {
				return false;
			}
		}
		{
			int lhsCaracteristicasHuecosAdosados;
			lhsCaracteristicasHuecosAdosados = this.getCaracteristicasHuecosAdosados();
			int rhsCaracteristicasHuecosAdosados;
			rhsCaracteristicasHuecosAdosados = that.getCaracteristicasHuecosAdosados();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "caracteristicasHuecosAdosados", lhsCaracteristicasHuecosAdosados), LocatorUtils.property(thatLocator, "caracteristicasHuecosAdosados", rhsCaracteristicasHuecosAdosados), lhsCaracteristicasHuecosAdosados, rhsCaracteristicasHuecosAdosados)) {
				return false;
			}
		}
		{
			int lhsCaracteristicasHuecosAdosadosRuidoMolesto;
			lhsCaracteristicasHuecosAdosadosRuidoMolesto = this.getCaracteristicasHuecosAdosadosRuidoMolesto();
			int rhsCaracteristicasHuecosAdosadosRuidoMolesto;
			rhsCaracteristicasHuecosAdosadosRuidoMolesto = that.getCaracteristicasHuecosAdosadosRuidoMolesto();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "caracteristicasHuecosAdosadosRuidoMolesto", lhsCaracteristicasHuecosAdosadosRuidoMolesto), LocatorUtils.property(thatLocator, "caracteristicasHuecosAdosadosRuidoMolesto", rhsCaracteristicasHuecosAdosadosRuidoMolesto), lhsCaracteristicasHuecosAdosadosRuidoMolesto, rhsCaracteristicasHuecosAdosadosRuidoMolesto)) {
				return false;
			}
		}
		{
			int lhsCaracteristicasHuecosAdosadosRevestidos;
			lhsCaracteristicasHuecosAdosadosRevestidos = this.getCaracteristicasHuecosAdosadosRevestidos();
			int rhsCaracteristicasHuecosAdosadosRevestidos;
			rhsCaracteristicasHuecosAdosadosRevestidos = that.getCaracteristicasHuecosAdosadosRevestidos();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "caracteristicasHuecosAdosadosRevestidos", lhsCaracteristicasHuecosAdosadosRevestidos), LocatorUtils.property(thatLocator, "caracteristicasHuecosAdosadosRevestidos", rhsCaracteristicasHuecosAdosadosRevestidos), lhsCaracteristicasHuecosAdosadosRevestidos, rhsCaracteristicasHuecosAdosadosRevestidos)) {
				return false;
			}
		}
		{
			int lhsCaracteristicasTuberiasAncladas;
			lhsCaracteristicasTuberiasAncladas = this.getCaracteristicasTuberiasAncladas();
			int rhsCaracteristicasTuberiasAncladas;
			rhsCaracteristicasTuberiasAncladas = that.getCaracteristicasTuberiasAncladas();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "caracteristicasTuberiasAncladas", lhsCaracteristicasTuberiasAncladas), LocatorUtils.property(thatLocator, "caracteristicasTuberiasAncladas", rhsCaracteristicasTuberiasAncladas), lhsCaracteristicasTuberiasAncladas, rhsCaracteristicasTuberiasAncladas)) {
				return false;
			}
		}
		{
			int lhsTabiquesFabrica;
			lhsTabiquesFabrica = this.getTabiquesFabrica();
			int rhsTabiquesFabrica;
			rhsTabiquesFabrica = that.getTabiquesFabrica();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "tabiquesFabrica", lhsTabiquesFabrica), LocatorUtils.property(thatLocator, "tabiquesFabrica", rhsTabiquesFabrica), lhsTabiquesFabrica, rhsTabiquesFabrica)) {
				return false;
			}
		}
		{
			String lhsAcusticaRuidointeriorverticalesTabiquesTipoTexto;
			lhsAcusticaRuidointeriorverticalesTabiquesTipoTexto = this.getAcusticaRuidointeriorverticalesTabiquesTipoTexto();
			String rhsAcusticaRuidointeriorverticalesTabiquesTipoTexto;
			rhsAcusticaRuidointeriorverticalesTabiquesTipoTexto = that.getAcusticaRuidointeriorverticalesTabiquesTipoTexto();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "acusticaRuidointeriorverticalesTabiquesTipoTexto", lhsAcusticaRuidointeriorverticalesTabiquesTipoTexto), LocatorUtils.property(thatLocator, "acusticaRuidointeriorverticalesTabiquesTipoTexto", rhsAcusticaRuidointeriorverticalesTabiquesTipoTexto), lhsAcusticaRuidointeriorverticalesTabiquesTipoTexto, rhsAcusticaRuidointeriorverticalesTabiquesTipoTexto)) {
				return false;
			}
		}
		{
			int lhsTabiquesEntramadoAutoportanteMetalico;
			lhsTabiquesEntramadoAutoportanteMetalico = this.getTabiquesEntramadoAutoportanteMetalico();
			int rhsTabiquesEntramadoAutoportanteMetalico;
			rhsTabiquesEntramadoAutoportanteMetalico = that.getTabiquesEntramadoAutoportanteMetalico();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "tabiquesEntramadoAutoportanteMetalico", lhsTabiquesEntramadoAutoportanteMetalico), LocatorUtils.property(thatLocator, "tabiquesEntramadoAutoportanteMetalico", rhsTabiquesEntramadoAutoportanteMetalico), lhsTabiquesEntramadoAutoportanteMetalico, rhsTabiquesEntramadoAutoportanteMetalico)) {
				return false;
			}
		}
		{
			String lhsTabiquesEntramadoAutoportanteMetalicoEspesor;
			lhsTabiquesEntramadoAutoportanteMetalicoEspesor = this.getTabiquesEntramadoAutoportanteMetalicoEspesor();
			String rhsTabiquesEntramadoAutoportanteMetalicoEspesor;
			rhsTabiquesEntramadoAutoportanteMetalicoEspesor = that.getTabiquesEntramadoAutoportanteMetalicoEspesor();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "tabiquesEntramadoAutoportanteMetalicoEspesor", lhsTabiquesEntramadoAutoportanteMetalicoEspesor), LocatorUtils.property(thatLocator, "tabiquesEntramadoAutoportanteMetalicoEspesor", rhsTabiquesEntramadoAutoportanteMetalicoEspesor), lhsTabiquesEntramadoAutoportanteMetalicoEspesor, rhsTabiquesEntramadoAutoportanteMetalicoEspesor)) {
				return false;
			}
		}
		{
			int lhsTabiquesEntramadoMaderaRelleno;
			lhsTabiquesEntramadoMaderaRelleno = this.getTabiquesEntramadoMaderaRelleno();
			int rhsTabiquesEntramadoMaderaRelleno;
			rhsTabiquesEntramadoMaderaRelleno = that.getTabiquesEntramadoMaderaRelleno();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "tabiquesEntramadoMaderaRelleno", lhsTabiquesEntramadoMaderaRelleno), LocatorUtils.property(thatLocator, "tabiquesEntramadoMaderaRelleno", rhsTabiquesEntramadoMaderaRelleno), lhsTabiquesEntramadoMaderaRelleno, rhsTabiquesEntramadoMaderaRelleno)) {
				return false;
			}
		}
		{
			String lhsTabiquesEntramadoMaderaRellenoEspesor;
			lhsTabiquesEntramadoMaderaRellenoEspesor = this.getTabiquesEntramadoMaderaRellenoEspesor();
			String rhsTabiquesEntramadoMaderaRellenoEspesor;
			rhsTabiquesEntramadoMaderaRellenoEspesor = that.getTabiquesEntramadoMaderaRellenoEspesor();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "tabiquesEntramadoMaderaRellenoEspesor", lhsTabiquesEntramadoMaderaRellenoEspesor), LocatorUtils.property(thatLocator, "tabiquesEntramadoMaderaRellenoEspesor", rhsTabiquesEntramadoMaderaRellenoEspesor), lhsTabiquesEntramadoMaderaRellenoEspesor, rhsTabiquesEntramadoMaderaRellenoEspesor)) {
				return false;
			}
		}
		{
			int lhsZonaComunPuertasAcusticamenteFavorables;
			lhsZonaComunPuertasAcusticamenteFavorables = this.getZonaComunPuertasAcusticamenteFavorables();
			int rhsZonaComunPuertasAcusticamenteFavorables;
			rhsZonaComunPuertasAcusticamenteFavorables = that.getZonaComunPuertasAcusticamenteFavorables();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "zonaComunPuertasAcusticamenteFavorables", lhsZonaComunPuertasAcusticamenteFavorables), LocatorUtils.property(thatLocator, "zonaComunPuertasAcusticamenteFavorables", rhsZonaComunPuertasAcusticamenteFavorables), lhsZonaComunPuertasAcusticamenteFavorables, rhsZonaComunPuertasAcusticamenteFavorables)) {
				return false;
			}
		}
		{
			int lhsZonaComunHallPuerta;
			lhsZonaComunHallPuerta = this.getZonaComunHallPuerta();
			int rhsZonaComunHallPuerta;
			rhsZonaComunHallPuerta = that.getZonaComunHallPuerta();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "zonaComunHallPuerta", lhsZonaComunHallPuerta), LocatorUtils.property(thatLocator, "zonaComunHallPuerta", rhsZonaComunHallPuerta), lhsZonaComunHallPuerta, rhsZonaComunHallPuerta)) {
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
			AcusticaRuidointeriorverticalesSeparacionTiposType lhsAcusticaRuidointeriorverticalesSeparacionTipos;
			lhsAcusticaRuidointeriorverticalesSeparacionTipos = this.getAcusticaRuidointeriorverticalesSeparacionTipos();
			AcusticaRuidointeriorverticalesSeparacionTiposType rhsAcusticaRuidointeriorverticalesSeparacionTipos;
			rhsAcusticaRuidointeriorverticalesSeparacionTipos = that.getAcusticaRuidointeriorverticalesSeparacionTipos();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "acusticaRuidointeriorverticalesSeparacionTipos", lhsAcusticaRuidointeriorverticalesSeparacionTipos), LocatorUtils.property(thatLocator, "acusticaRuidointeriorverticalesSeparacionTipos", rhsAcusticaRuidointeriorverticalesSeparacionTipos), lhsAcusticaRuidointeriorverticalesSeparacionTipos, rhsAcusticaRuidointeriorverticalesSeparacionTipos)) {
				return false;
			}
		}
		{
			AcusticaRuidointeriorverticalesSeparacionGruposType lhsAcusticaRuidointeriorverticalesSeparacionGrupos;
			lhsAcusticaRuidointeriorverticalesSeparacionGrupos = this.getAcusticaRuidointeriorverticalesSeparacionGrupos();
			AcusticaRuidointeriorverticalesSeparacionGruposType rhsAcusticaRuidointeriorverticalesSeparacionGrupos;
			rhsAcusticaRuidointeriorverticalesSeparacionGrupos = that.getAcusticaRuidointeriorverticalesSeparacionGrupos();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "acusticaRuidointeriorverticalesSeparacionGrupos", lhsAcusticaRuidointeriorverticalesSeparacionGrupos), LocatorUtils.property(thatLocator, "acusticaRuidointeriorverticalesSeparacionGrupos", rhsAcusticaRuidointeriorverticalesSeparacionGrupos), lhsAcusticaRuidointeriorverticalesSeparacionGrupos, rhsAcusticaRuidointeriorverticalesSeparacionGrupos)) {
				return false;
			}
		}
		{
			AcusticaRuidointeriorverticalesSeparacionSubgruposType lhsAcusticaRuidointeriorverticalesSeparacionSubgrupos;
			lhsAcusticaRuidointeriorverticalesSeparacionSubgrupos = this.getAcusticaRuidointeriorverticalesSeparacionSubgrupos();
			AcusticaRuidointeriorverticalesSeparacionSubgruposType rhsAcusticaRuidointeriorverticalesSeparacionSubgrupos;
			rhsAcusticaRuidointeriorverticalesSeparacionSubgrupos = that.getAcusticaRuidointeriorverticalesSeparacionSubgrupos();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "acusticaRuidointeriorverticalesSeparacionSubgrupos", lhsAcusticaRuidointeriorverticalesSeparacionSubgrupos), LocatorUtils.property(thatLocator, "acusticaRuidointeriorverticalesSeparacionSubgrupos", rhsAcusticaRuidointeriorverticalesSeparacionSubgrupos), lhsAcusticaRuidointeriorverticalesSeparacionSubgrupos, rhsAcusticaRuidointeriorverticalesSeparacionSubgrupos)) {
				return false;
			}
		}
		{
			AcusticaRuidointeriorverticalesSeparacionElementosType lhsAcusticaRuidointeriorverticalesSeparacionElementos;
			lhsAcusticaRuidointeriorverticalesSeparacionElementos = this.getAcusticaRuidointeriorverticalesSeparacionElementos();
			AcusticaRuidointeriorverticalesSeparacionElementosType rhsAcusticaRuidointeriorverticalesSeparacionElementos;
			rhsAcusticaRuidointeriorverticalesSeparacionElementos = that.getAcusticaRuidointeriorverticalesSeparacionElementos();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "acusticaRuidointeriorverticalesSeparacionElementos", lhsAcusticaRuidointeriorverticalesSeparacionElementos), LocatorUtils.property(thatLocator, "acusticaRuidointeriorverticalesSeparacionElementos", rhsAcusticaRuidointeriorverticalesSeparacionElementos), lhsAcusticaRuidointeriorverticalesSeparacionElementos, rhsAcusticaRuidointeriorverticalesSeparacionElementos)) {
				return false;
			}
		}
		{
			AcusticaRuidointeriorverticalesTabiquesType lhsAcusticaRuidointeriorverticalesTabiques;
			lhsAcusticaRuidointeriorverticalesTabiques = this.getAcusticaRuidointeriorverticalesTabiques();
			AcusticaRuidointeriorverticalesTabiquesType rhsAcusticaRuidointeriorverticalesTabiques;
			rhsAcusticaRuidointeriorverticalesTabiques = that.getAcusticaRuidointeriorverticalesTabiques();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "acusticaRuidointeriorverticalesTabiques", lhsAcusticaRuidointeriorverticalesTabiques), LocatorUtils.property(thatLocator, "acusticaRuidointeriorverticalesTabiques", rhsAcusticaRuidointeriorverticalesTabiques), lhsAcusticaRuidointeriorverticalesTabiques, rhsAcusticaRuidointeriorverticalesTabiques)) {
				return false;
			}
		}
		{
			AcusticaRuidointeriorverticalesTabiquesCaracteristicasType lhsAcusticaRuidointeriorverticalesTabiquesCaracteristicas;
			lhsAcusticaRuidointeriorverticalesTabiquesCaracteristicas = this.getAcusticaRuidointeriorverticalesTabiquesCaracteristicas();
			AcusticaRuidointeriorverticalesTabiquesCaracteristicasType rhsAcusticaRuidointeriorverticalesTabiquesCaracteristicas;
			rhsAcusticaRuidointeriorverticalesTabiquesCaracteristicas = that.getAcusticaRuidointeriorverticalesTabiquesCaracteristicas();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "acusticaRuidointeriorverticalesTabiquesCaracteristicas", lhsAcusticaRuidointeriorverticalesTabiquesCaracteristicas), LocatorUtils.property(thatLocator, "acusticaRuidointeriorverticalesTabiquesCaracteristicas", rhsAcusticaRuidointeriorverticalesTabiquesCaracteristicas), lhsAcusticaRuidointeriorverticalesTabiquesCaracteristicas, rhsAcusticaRuidointeriorverticalesTabiquesCaracteristicas)) {
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
			int theSeparacionFabrica;
			theSeparacionFabrica = this.getSeparacionFabrica();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "separacionFabrica", theSeparacionFabrica), currentHashCode, theSeparacionFabrica);
		}
		{
			String theAcusticaRuidointeriorverticalesSeparacionTipoTexto;
			theAcusticaRuidointeriorverticalesSeparacionTipoTexto = this.getAcusticaRuidointeriorverticalesSeparacionTipoTexto();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "acusticaRuidointeriorverticalesSeparacionTipoTexto", theAcusticaRuidointeriorverticalesSeparacionTipoTexto), currentHashCode, theAcusticaRuidointeriorverticalesSeparacionTipoTexto);
		}
		{
			int theSeparacionFabricaRevestido;
			theSeparacionFabricaRevestido = this.getSeparacionFabricaRevestido();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "separacionFabricaRevestido", theSeparacionFabricaRevestido), currentHashCode, theSeparacionFabricaRevestido);
		}
		{
			int theSeparacionEntramadoAutoportante;
			theSeparacionEntramadoAutoportante = this.getSeparacionEntramadoAutoportante();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "separacionEntramadoAutoportante", theSeparacionEntramadoAutoportante), currentHashCode, theSeparacionEntramadoAutoportante);
		}
		{
			int theSeparacionEntramadoAutoportanteUnahoja;
			theSeparacionEntramadoAutoportanteUnahoja = this.getSeparacionEntramadoAutoportanteUnahoja();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "separacionEntramadoAutoportanteUnahoja", theSeparacionEntramadoAutoportanteUnahoja), currentHashCode, theSeparacionEntramadoAutoportanteUnahoja);
		}
		{
			String theSeparacionEntramadoAutoportanteUnahojaEspesor;
			theSeparacionEntramadoAutoportanteUnahojaEspesor = this.getSeparacionEntramadoAutoportanteUnahojaEspesor();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "separacionEntramadoAutoportanteUnahojaEspesor", theSeparacionEntramadoAutoportanteUnahojaEspesor), currentHashCode, theSeparacionEntramadoAutoportanteUnahojaEspesor);
		}
		{
			int theSeparacionEntramadoAutoportanteDoshojas;
			theSeparacionEntramadoAutoportanteDoshojas = this.getSeparacionEntramadoAutoportanteDoshojas();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "separacionEntramadoAutoportanteDoshojas", theSeparacionEntramadoAutoportanteDoshojas), currentHashCode, theSeparacionEntramadoAutoportanteDoshojas);
		}
		{
			String theSeparacionEntramadoAutoportanteDoshojasEspesor;
			theSeparacionEntramadoAutoportanteDoshojasEspesor = this.getSeparacionEntramadoAutoportanteDoshojasEspesor();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "separacionEntramadoAutoportanteDoshojasEspesor", theSeparacionEntramadoAutoportanteDoshojasEspesor), currentHashCode, theSeparacionEntramadoAutoportanteDoshojasEspesor);
		}
		{
			int theSeparacionEntramadoAutoportanteAbsorbente;
			theSeparacionEntramadoAutoportanteAbsorbente = this.getSeparacionEntramadoAutoportanteAbsorbente();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "separacionEntramadoAutoportanteAbsorbente", theSeparacionEntramadoAutoportanteAbsorbente), currentHashCode, theSeparacionEntramadoAutoportanteAbsorbente);
		}
		{
			int theSeparacionEntramadoMadera;
			theSeparacionEntramadoMadera = this.getSeparacionEntramadoMadera();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "separacionEntramadoMadera", theSeparacionEntramadoMadera), currentHashCode, theSeparacionEntramadoMadera);
		}
		{
			int theSeparacionEntramadoMaderaEspesor;
			theSeparacionEntramadoMaderaEspesor = this.getSeparacionEntramadoMaderaEspesor();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "separacionEntramadoMaderaEspesor", theSeparacionEntramadoMaderaEspesor), currentHashCode, theSeparacionEntramadoMaderaEspesor);
		}
		{
			int theSeparacionEntramadoMaderaRevestido;
			theSeparacionEntramadoMaderaRevestido = this.getSeparacionEntramadoMaderaRevestido();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "separacionEntramadoMaderaRevestido", theSeparacionEntramadoMaderaRevestido), currentHashCode, theSeparacionEntramadoMaderaRevestido);
		}
		{
			int theSeparacionOtros;
			theSeparacionOtros = this.getSeparacionOtros();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "separacionOtros", theSeparacionOtros), currentHashCode, theSeparacionOtros);
		}
		{
			String theSeparacionOtrosTexto;
			theSeparacionOtrosTexto = this.getSeparacionOtrosTexto();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "separacionOtrosTexto", theSeparacionOtrosTexto), currentHashCode, theSeparacionOtrosTexto);
		}
		{
			int theEstadoSeparacionBueno;
			theEstadoSeparacionBueno = this.getEstadoSeparacionBueno();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "estadoSeparacionBueno", theEstadoSeparacionBueno), currentHashCode, theEstadoSeparacionBueno);
		}
		{
			String theDeficienciasObservaciones;
			theDeficienciasObservaciones = this.getDeficienciasObservaciones();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "deficienciasObservaciones", theDeficienciasObservaciones), currentHashCode, theDeficienciasObservaciones);
		}
		{
			int theCaracteristicasPilaresConectanRecintos;
			theCaracteristicasPilaresConectanRecintos = this.getCaracteristicasPilaresConectanRecintos();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "caracteristicasPilaresConectanRecintos", theCaracteristicasPilaresConectanRecintos), currentHashCode, theCaracteristicasPilaresConectanRecintos);
		}
		{
			int theCaracteristicasPilaresConectanRecintosRevestidos;
			theCaracteristicasPilaresConectanRecintosRevestidos = this.getCaracteristicasPilaresConectanRecintosRevestidos();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "caracteristicasPilaresConectanRecintosRevestidos", theCaracteristicasPilaresConectanRecintosRevestidos), currentHashCode, theCaracteristicasPilaresConectanRecintosRevestidos);
		}
		{
			int theCaracteristicasInstalacionesConectanRecintos;
			theCaracteristicasInstalacionesConectanRecintos = this.getCaracteristicasInstalacionesConectanRecintos();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "caracteristicasInstalacionesConectanRecintos", theCaracteristicasInstalacionesConectanRecintos), currentHashCode, theCaracteristicasInstalacionesConectanRecintos);
		}
		{
			int theCaracteristicasInstalacionesAtraviesanRecintos;
			theCaracteristicasInstalacionesAtraviesanRecintos = this.getCaracteristicasInstalacionesAtraviesanRecintos();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "caracteristicasInstalacionesAtraviesanRecintos", theCaracteristicasInstalacionesAtraviesanRecintos), currentHashCode, theCaracteristicasInstalacionesAtraviesanRecintos);
		}
		{
			int theCaracteristicasHuecosAdosados;
			theCaracteristicasHuecosAdosados = this.getCaracteristicasHuecosAdosados();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "caracteristicasHuecosAdosados", theCaracteristicasHuecosAdosados), currentHashCode, theCaracteristicasHuecosAdosados);
		}
		{
			int theCaracteristicasHuecosAdosadosRuidoMolesto;
			theCaracteristicasHuecosAdosadosRuidoMolesto = this.getCaracteristicasHuecosAdosadosRuidoMolesto();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "caracteristicasHuecosAdosadosRuidoMolesto", theCaracteristicasHuecosAdosadosRuidoMolesto), currentHashCode, theCaracteristicasHuecosAdosadosRuidoMolesto);
		}
		{
			int theCaracteristicasHuecosAdosadosRevestidos;
			theCaracteristicasHuecosAdosadosRevestidos = this.getCaracteristicasHuecosAdosadosRevestidos();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "caracteristicasHuecosAdosadosRevestidos", theCaracteristicasHuecosAdosadosRevestidos), currentHashCode, theCaracteristicasHuecosAdosadosRevestidos);
		}
		{
			int theCaracteristicasTuberiasAncladas;
			theCaracteristicasTuberiasAncladas = this.getCaracteristicasTuberiasAncladas();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "caracteristicasTuberiasAncladas", theCaracteristicasTuberiasAncladas), currentHashCode, theCaracteristicasTuberiasAncladas);
		}
		{
			int theTabiquesFabrica;
			theTabiquesFabrica = this.getTabiquesFabrica();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "tabiquesFabrica", theTabiquesFabrica), currentHashCode, theTabiquesFabrica);
		}
		{
			String theAcusticaRuidointeriorverticalesTabiquesTipoTexto;
			theAcusticaRuidointeriorverticalesTabiquesTipoTexto = this.getAcusticaRuidointeriorverticalesTabiquesTipoTexto();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "acusticaRuidointeriorverticalesTabiquesTipoTexto", theAcusticaRuidointeriorverticalesTabiquesTipoTexto), currentHashCode, theAcusticaRuidointeriorverticalesTabiquesTipoTexto);
		}
		{
			int theTabiquesEntramadoAutoportanteMetalico;
			theTabiquesEntramadoAutoportanteMetalico = this.getTabiquesEntramadoAutoportanteMetalico();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "tabiquesEntramadoAutoportanteMetalico", theTabiquesEntramadoAutoportanteMetalico), currentHashCode, theTabiquesEntramadoAutoportanteMetalico);
		}
		{
			String theTabiquesEntramadoAutoportanteMetalicoEspesor;
			theTabiquesEntramadoAutoportanteMetalicoEspesor = this.getTabiquesEntramadoAutoportanteMetalicoEspesor();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "tabiquesEntramadoAutoportanteMetalicoEspesor", theTabiquesEntramadoAutoportanteMetalicoEspesor), currentHashCode, theTabiquesEntramadoAutoportanteMetalicoEspesor);
		}
		{
			int theTabiquesEntramadoMaderaRelleno;
			theTabiquesEntramadoMaderaRelleno = this.getTabiquesEntramadoMaderaRelleno();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "tabiquesEntramadoMaderaRelleno", theTabiquesEntramadoMaderaRelleno), currentHashCode, theTabiquesEntramadoMaderaRelleno);
		}
		{
			String theTabiquesEntramadoMaderaRellenoEspesor;
			theTabiquesEntramadoMaderaRellenoEspesor = this.getTabiquesEntramadoMaderaRellenoEspesor();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "tabiquesEntramadoMaderaRellenoEspesor", theTabiquesEntramadoMaderaRellenoEspesor), currentHashCode, theTabiquesEntramadoMaderaRellenoEspesor);
		}
		{
			int theZonaComunPuertasAcusticamenteFavorables;
			theZonaComunPuertasAcusticamenteFavorables = this.getZonaComunPuertasAcusticamenteFavorables();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "zonaComunPuertasAcusticamenteFavorables", theZonaComunPuertasAcusticamenteFavorables), currentHashCode, theZonaComunPuertasAcusticamenteFavorables);
		}
		{
			int theZonaComunHallPuerta;
			theZonaComunHallPuerta = this.getZonaComunHallPuerta();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "zonaComunHallPuerta", theZonaComunHallPuerta), currentHashCode, theZonaComunHallPuerta);
		}
		{
			String theObservaciones;
			theObservaciones = this.getObservaciones();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "observaciones", theObservaciones), currentHashCode, theObservaciones);
		}
		{
			AcusticaRuidointeriorverticalesSeparacionTiposType theAcusticaRuidointeriorverticalesSeparacionTipos;
			theAcusticaRuidointeriorverticalesSeparacionTipos = this.getAcusticaRuidointeriorverticalesSeparacionTipos();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "acusticaRuidointeriorverticalesSeparacionTipos", theAcusticaRuidointeriorverticalesSeparacionTipos), currentHashCode, theAcusticaRuidointeriorverticalesSeparacionTipos);
		}
		{
			AcusticaRuidointeriorverticalesSeparacionGruposType theAcusticaRuidointeriorverticalesSeparacionGrupos;
			theAcusticaRuidointeriorverticalesSeparacionGrupos = this.getAcusticaRuidointeriorverticalesSeparacionGrupos();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "acusticaRuidointeriorverticalesSeparacionGrupos", theAcusticaRuidointeriorverticalesSeparacionGrupos), currentHashCode, theAcusticaRuidointeriorverticalesSeparacionGrupos);
		}
		{
			AcusticaRuidointeriorverticalesSeparacionSubgruposType theAcusticaRuidointeriorverticalesSeparacionSubgrupos;
			theAcusticaRuidointeriorverticalesSeparacionSubgrupos = this.getAcusticaRuidointeriorverticalesSeparacionSubgrupos();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "acusticaRuidointeriorverticalesSeparacionSubgrupos", theAcusticaRuidointeriorverticalesSeparacionSubgrupos), currentHashCode, theAcusticaRuidointeriorverticalesSeparacionSubgrupos);
		}
		{
			AcusticaRuidointeriorverticalesSeparacionElementosType theAcusticaRuidointeriorverticalesSeparacionElementos;
			theAcusticaRuidointeriorverticalesSeparacionElementos = this.getAcusticaRuidointeriorverticalesSeparacionElementos();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "acusticaRuidointeriorverticalesSeparacionElementos", theAcusticaRuidointeriorverticalesSeparacionElementos), currentHashCode, theAcusticaRuidointeriorverticalesSeparacionElementos);
		}
		{
			AcusticaRuidointeriorverticalesTabiquesType theAcusticaRuidointeriorverticalesTabiques;
			theAcusticaRuidointeriorverticalesTabiques = this.getAcusticaRuidointeriorverticalesTabiques();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "acusticaRuidointeriorverticalesTabiques", theAcusticaRuidointeriorverticalesTabiques), currentHashCode, theAcusticaRuidointeriorverticalesTabiques);
		}
		{
			AcusticaRuidointeriorverticalesTabiquesCaracteristicasType theAcusticaRuidointeriorverticalesTabiquesCaracteristicas;
			theAcusticaRuidointeriorverticalesTabiquesCaracteristicas = this.getAcusticaRuidointeriorverticalesTabiquesCaracteristicas();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "acusticaRuidointeriorverticalesTabiquesCaracteristicas", theAcusticaRuidointeriorverticalesTabiquesCaracteristicas), currentHashCode, theAcusticaRuidointeriorverticalesTabiquesCaracteristicas);
		}
		return currentHashCode;
	}

	public int hashCode() {
		final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
		return this.hashCode(null, strategy);
	}

}
