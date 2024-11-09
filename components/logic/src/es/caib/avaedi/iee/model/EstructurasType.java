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
 * Clase Java para estructurasType complex type.
 * 
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que
 * haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="estructurasType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="cubierta_forjadoinclinado_texto" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="cubierta_otros_texto" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="horizontalplantatipo_otros_texto" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="horizontalsuelo_otros_texto" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="vertical_otros_texto" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="observaciones" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="estructuras_verticalmuroscargas" type="{}estructuras_verticalmuroscargasType"/&gt;
 *         &lt;element name="estructuras_verticalpilares" type="{}estructuras_verticalpilaresType"/&gt;
 *         &lt;element name="estructuras_verticalotros" type="{}estructuras_verticalotrosType"/&gt;
 *         &lt;element name="estructuras_horizontalplantatipoestructurasprincipales" type="{}estructuras_horizontalplantatipoestructurasprincipalesType"/&gt;
 *         &lt;element name="estructuras_horizontalplantatipoforjadossecundarios" type="{}estructuras_horizontalplantatipoforjadossecundariosType"/&gt;
 *         &lt;element name="estructuras_horizontalplantatipoforjadosentrevigados" type="{}estructuras_horizontalplantatipoforjadosentrevigadosType"/&gt;
 *         &lt;element name="estructuras_horizontalplantatipootros" type="{}estructuras_horizontalplantatipootrosType"/&gt;
 *         &lt;element name="estructuras_horizontalsueloforjados" type="{}estructuras_horizontalsueloforjadosType"/&gt;
 *         &lt;element name="estructuras_horizontalsueloforjadossanitarios" type="{}estructuras_horizontalsueloforjadossanitariosType"/&gt;
 *         &lt;element name="estructuras_horizontalsuelootros" type="{}estructuras_horizontalsuelootrosType"/&gt;
 *         &lt;element name="estructuras_cubiertaforjadoshorizontales" type="{}estructuras_cubiertaforjadoshorizontalesType"/&gt;
 *         &lt;element name="estructuras_cubiertaforjadosinclinados" type="{}estructuras_cubiertaforjadosinclinadosType"/&gt;
 *         &lt;element name="estructuras_cubiertacerchasporticos" type="{}estructuras_cubiertacerchasporticosType"/&gt;
 *         &lt;element name="estructuras_cubiertaotros" type="{}estructuras_cubiertaotrosType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "estructurasType", propOrder = { "cubiertaForjadoinclinadoTexto", "cubiertaOtrosTexto", "horizontalplantatipoOtrosTexto", "horizontalsueloOtrosTexto", "verticalOtrosTexto", "observaciones", "estructurasVerticalmuroscargas", "estructurasVerticalpilares", "estructurasVerticalotros", "estructurasHorizontalplantatipoestructurasprincipales", "estructurasHorizontalplantatipoforjadossecundarios", "estructurasHorizontalplantatipoforjadosentrevigados", "estructurasHorizontalplantatipootros", "estructurasHorizontalsueloforjados", "estructurasHorizontalsueloforjadossanitarios", "estructurasHorizontalsuelootros", "estructurasCubiertaforjadoshorizontales", "estructurasCubiertaforjadosinclinados", "estructurasCubiertacerchasporticos", "estructurasCubiertaotros" })
@Entity(name = "EstructurasType")
@Table(name = "AED_ESTS")
@Inheritance(strategy = InheritanceType.JOINED)
public class EstructurasType implements Serializable, Equals, HashCode {

	@XmlElement(name = "cubierta_forjadoinclinado_texto", required = true)
	protected String cubiertaForjadoinclinadoTexto;
	@XmlElement(name = "cubierta_otros_texto", required = true)
	protected String cubiertaOtrosTexto;
	@XmlElement(name = "horizontalplantatipo_otros_texto", required = true)
	protected String horizontalplantatipoOtrosTexto;
	@XmlElement(name = "horizontalsuelo_otros_texto", required = true)
	protected String horizontalsueloOtrosTexto;
	@XmlElement(name = "vertical_otros_texto", required = true)
	protected String verticalOtrosTexto;
	@XmlElement(required = true)
	protected String observaciones;
	@XmlElement(name = "estructuras_verticalmuroscargas", required = true)
	protected EstructurasVerticalmuroscargasType estructurasVerticalmuroscargas;
	@XmlElement(name = "estructuras_verticalpilares", required = true)
	protected EstructurasVerticalpilaresType estructurasVerticalpilares;
	@XmlElement(name = "estructuras_verticalotros", required = true)
	protected EstructurasVerticalotrosType estructurasVerticalotros;
	@XmlElement(name = "estructuras_horizontalplantatipoestructurasprincipales", required = true)
	protected EstructurasHorizontalplantatipoestructurasprincipalesType estructurasHorizontalplantatipoestructurasprincipales;
	@XmlElement(name = "estructuras_horizontalplantatipoforjadossecundarios", required = true)
	protected EstructurasHorizontalplantatipoforjadossecundariosType estructurasHorizontalplantatipoforjadossecundarios;
	@XmlElement(name = "estructuras_horizontalplantatipoforjadosentrevigados", required = true)
	protected EstructurasHorizontalplantatipoforjadosentrevigadosType estructurasHorizontalplantatipoforjadosentrevigados;
	@XmlElement(name = "estructuras_horizontalplantatipootros", required = true)
	protected EstructurasHorizontalplantatipootrosType estructurasHorizontalplantatipootros;
	@XmlElement(name = "estructuras_horizontalsueloforjados", required = true)
	protected EstructurasHorizontalsueloforjadosType estructurasHorizontalsueloforjados;
	@XmlElement(name = "estructuras_horizontalsueloforjadossanitarios", required = true)
	protected EstructurasHorizontalsueloforjadossanitariosType estructurasHorizontalsueloforjadossanitarios;
	@XmlElement(name = "estructuras_horizontalsuelootros", required = true)
	protected EstructurasHorizontalsuelootrosType estructurasHorizontalsuelootros;
	@XmlElement(name = "estructuras_cubiertaforjadoshorizontales", required = true)
	protected EstructurasCubiertaforjadoshorizontalesType estructurasCubiertaforjadoshorizontales;
	@XmlElement(name = "estructuras_cubiertaforjadosinclinados", required = true)
	protected EstructurasCubiertaforjadosinclinadosType estructurasCubiertaforjadosinclinados;
	@XmlElement(name = "estructuras_cubiertacerchasporticos", required = true)
	protected EstructurasCubiertacerchasporticosType estructurasCubiertacerchasporticos;
	@XmlElement(name = "estructuras_cubiertaotros", required = true)
	protected EstructurasCubiertaotrosType estructurasCubiertaotros;
	@XmlAttribute(name = "Hjid")
	protected Long hjid;

	/**
	 * Obtiene el valor de la propiedad cubiertaForjadoinclinadoTexto.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "CUBIERTA_FORJADOINCLINADO_TEXTO", length = 255)
	public String getCubiertaForjadoinclinadoTexto() {
		return cubiertaForjadoinclinadoTexto;
	}

	/**
	 * Define el valor de la propiedad cubiertaForjadoinclinadoTexto.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCubiertaForjadoinclinadoTexto(String value) {
		this.cubiertaForjadoinclinadoTexto = value;
	}

	/**
	 * Obtiene el valor de la propiedad cubiertaOtrosTexto.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "CUBIERTA_OTROS_TEXTO", length = 255)
	public String getCubiertaOtrosTexto() {
		return cubiertaOtrosTexto;
	}

	/**
	 * Define el valor de la propiedad cubiertaOtrosTexto.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCubiertaOtrosTexto(String value) {
		this.cubiertaOtrosTexto = value;
	}

	/**
	 * Obtiene el valor de la propiedad horizontalplantatipoOtrosTexto.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "HORIZONTALPLANTATIPO_OTROS_TEXTO", length = 255)
	public String getHorizontalplantatipoOtrosTexto() {
		return horizontalplantatipoOtrosTexto;
	}

	/**
	 * Define el valor de la propiedad horizontalplantatipoOtrosTexto.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setHorizontalplantatipoOtrosTexto(String value) {
		this.horizontalplantatipoOtrosTexto = value;
	}

	/**
	 * Obtiene el valor de la propiedad horizontalsueloOtrosTexto.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "HORIZONTALSUELO_OTROS_TEXTO", length = 255)
	public String getHorizontalsueloOtrosTexto() {
		return horizontalsueloOtrosTexto;
	}

	/**
	 * Define el valor de la propiedad horizontalsueloOtrosTexto.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setHorizontalsueloOtrosTexto(String value) {
		this.horizontalsueloOtrosTexto = value;
	}

	/**
	 * Obtiene el valor de la propiedad verticalOtrosTexto.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "VERTICAL_OTROS_TEXTO", length = 255)
	public String getVerticalOtrosTexto() {
		return verticalOtrosTexto;
	}

	/**
	 * Define el valor de la propiedad verticalOtrosTexto.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setVerticalOtrosTexto(String value) {
		this.verticalOtrosTexto = value;
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
	 * Obtiene el valor de la propiedad estructurasVerticalmuroscargas.
	 * 
	 * @return possible object is {@link EstructurasVerticalmuroscargasType }
	 * 
	 */
	@ManyToOne(targetEntity = EstructurasVerticalmuroscargasType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "ESTRUCTURAS_VERTICALMUROSCARGAS_AED_ESTS_HJID")
	public EstructurasVerticalmuroscargasType getEstructurasVerticalmuroscargas() {
		return estructurasVerticalmuroscargas;
	}

	/**
	 * Define el valor de la propiedad estructurasVerticalmuroscargas.
	 * 
	 * @param value
	 *            allowed object is {@link EstructurasVerticalmuroscargasType }
	 * 
	 */
	public void setEstructurasVerticalmuroscargas(EstructurasVerticalmuroscargasType value) {
		this.estructurasVerticalmuroscargas = value;
	}

	/**
	 * Obtiene el valor de la propiedad estructurasVerticalpilares.
	 * 
	 * @return possible object is {@link EstructurasVerticalpilaresType }
	 * 
	 */
	@ManyToOne(targetEntity = EstructurasVerticalpilaresType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "ESTRUCTURAS_VERTICALPILARES_AED_ESTS_HJID")
	public EstructurasVerticalpilaresType getEstructurasVerticalpilares() {
		return estructurasVerticalpilares;
	}

	/**
	 * Define el valor de la propiedad estructurasVerticalpilares.
	 * 
	 * @param value
	 *            allowed object is {@link EstructurasVerticalpilaresType }
	 * 
	 */
	public void setEstructurasVerticalpilares(EstructurasVerticalpilaresType value) {
		this.estructurasVerticalpilares = value;
	}

	/**
	 * Obtiene el valor de la propiedad estructurasVerticalotros.
	 * 
	 * @return possible object is {@link EstructurasVerticalotrosType }
	 * 
	 */
	@ManyToOne(targetEntity = EstructurasVerticalotrosType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "ESTRUCTURAS_VERTICALOTROS_AED_ESTS_HJID")
	public EstructurasVerticalotrosType getEstructurasVerticalotros() {
		return estructurasVerticalotros;
	}

	/**
	 * Define el valor de la propiedad estructurasVerticalotros.
	 * 
	 * @param value
	 *            allowed object is {@link EstructurasVerticalotrosType }
	 * 
	 */
	public void setEstructurasVerticalotros(EstructurasVerticalotrosType value) {
		this.estructurasVerticalotros = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * estructurasHorizontalplantatipoestructurasprincipales.
	 * 
	 * @return possible object is
	 *         {@link EstructurasHorizontalplantatipoestructurasprincipalesType }
	 * 
	 */
	@ManyToOne(targetEntity = EstructurasHorizontalplantatipoestructurasprincipalesType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "ESTRUCTURAS_HORIZONTALPLANTATIPOESTRUCTURASPRINCIPALES_AED_ESTS_HJID")
	public EstructurasHorizontalplantatipoestructurasprincipalesType getEstructurasHorizontalplantatipoestructurasprincipales() {
		return estructurasHorizontalplantatipoestructurasprincipales;
	}

	/**
	 * Define el valor de la propiedad
	 * estructurasHorizontalplantatipoestructurasprincipales.
	 * 
	 * @param value
	 *            allowed object is
	 *            {@link EstructurasHorizontalplantatipoestructurasprincipalesType }
	 * 
	 */
	public void setEstructurasHorizontalplantatipoestructurasprincipales(EstructurasHorizontalplantatipoestructurasprincipalesType value) {
		this.estructurasHorizontalplantatipoestructurasprincipales = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * estructurasHorizontalplantatipoforjadossecundarios.
	 * 
	 * @return possible object is
	 *         {@link EstructurasHorizontalplantatipoforjadossecundariosType }
	 * 
	 */
	@ManyToOne(targetEntity = EstructurasHorizontalplantatipoforjadossecundariosType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "ESTRUCTURAS_HORIZONTALPLANTATIPOFORJADOSSECUNDARIOS_AED_ESTS_HJID")
	public EstructurasHorizontalplantatipoforjadossecundariosType getEstructurasHorizontalplantatipoforjadossecundarios() {
		return estructurasHorizontalplantatipoforjadossecundarios;
	}

	/**
	 * Define el valor de la propiedad
	 * estructurasHorizontalplantatipoforjadossecundarios.
	 * 
	 * @param value
	 *            allowed object is
	 *            {@link EstructurasHorizontalplantatipoforjadossecundariosType }
	 * 
	 */
	public void setEstructurasHorizontalplantatipoforjadossecundarios(EstructurasHorizontalplantatipoforjadossecundariosType value) {
		this.estructurasHorizontalplantatipoforjadossecundarios = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * estructurasHorizontalplantatipoforjadosentrevigados.
	 * 
	 * @return possible object is
	 *         {@link EstructurasHorizontalplantatipoforjadosentrevigadosType }
	 * 
	 */
	@ManyToOne(targetEntity = EstructurasHorizontalplantatipoforjadosentrevigadosType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "ESTRUCTURAS_HORIZONTALPLANTATIPOFORJADOSENTREVIGADOS_AED_ESTS_HJID")
	public EstructurasHorizontalplantatipoforjadosentrevigadosType getEstructurasHorizontalplantatipoforjadosentrevigados() {
		return estructurasHorizontalplantatipoforjadosentrevigados;
	}

	/**
	 * Define el valor de la propiedad
	 * estructurasHorizontalplantatipoforjadosentrevigados.
	 * 
	 * @param value
	 *            allowed object is
	 *            {@link EstructurasHorizontalplantatipoforjadosentrevigadosType }
	 * 
	 */
	public void setEstructurasHorizontalplantatipoforjadosentrevigados(EstructurasHorizontalplantatipoforjadosentrevigadosType value) {
		this.estructurasHorizontalplantatipoforjadosentrevigados = value;
	}

	/**
	 * Obtiene el valor de la propiedad estructurasHorizontalplantatipootros.
	 * 
	 * @return possible object is
	 *         {@link EstructurasHorizontalplantatipootrosType }
	 * 
	 */
	@ManyToOne(targetEntity = EstructurasHorizontalplantatipootrosType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "ESTRUCTURAS_HORIZONTALPLANTATIPOOTROS_AED_ESTS_HJID")
	public EstructurasHorizontalplantatipootrosType getEstructurasHorizontalplantatipootros() {
		return estructurasHorizontalplantatipootros;
	}

	/**
	 * Define el valor de la propiedad estructurasHorizontalplantatipootros.
	 * 
	 * @param value
	 *            allowed object is
	 *            {@link EstructurasHorizontalplantatipootrosType }
	 * 
	 */
	public void setEstructurasHorizontalplantatipootros(EstructurasHorizontalplantatipootrosType value) {
		this.estructurasHorizontalplantatipootros = value;
	}

	/**
	 * Obtiene el valor de la propiedad estructurasHorizontalsueloforjados.
	 * 
	 * @return possible object is {@link EstructurasHorizontalsueloforjadosType }
	 * 
	 */
	@ManyToOne(targetEntity = EstructurasHorizontalsueloforjadosType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "ESTRUCTURAS_HORIZONTALSUELOFORJADOS_AED_ESTS_HJID")
	public EstructurasHorizontalsueloforjadosType getEstructurasHorizontalsueloforjados() {
		return estructurasHorizontalsueloforjados;
	}

	/**
	 * Define el valor de la propiedad estructurasHorizontalsueloforjados.
	 * 
	 * @param value
	 *            allowed object is
	 *            {@link EstructurasHorizontalsueloforjadosType }
	 * 
	 */
	public void setEstructurasHorizontalsueloforjados(EstructurasHorizontalsueloforjadosType value) {
		this.estructurasHorizontalsueloforjados = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * estructurasHorizontalsueloforjadossanitarios.
	 * 
	 * @return possible object is
	 *         {@link EstructurasHorizontalsueloforjadossanitariosType }
	 * 
	 */
	@ManyToOne(targetEntity = EstructurasHorizontalsueloforjadossanitariosType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "ESTRUCTURAS_HORIZONTALSUELOFORJADOSSANITARIOS_AED_ESTS_HJID")
	public EstructurasHorizontalsueloforjadossanitariosType getEstructurasHorizontalsueloforjadossanitarios() {
		return estructurasHorizontalsueloforjadossanitarios;
	}

	/**
	 * Define el valor de la propiedad
	 * estructurasHorizontalsueloforjadossanitarios.
	 * 
	 * @param value
	 *            allowed object is
	 *            {@link EstructurasHorizontalsueloforjadossanitariosType }
	 * 
	 */
	public void setEstructurasHorizontalsueloforjadossanitarios(EstructurasHorizontalsueloforjadossanitariosType value) {
		this.estructurasHorizontalsueloforjadossanitarios = value;
	}

	/**
	 * Obtiene el valor de la propiedad estructurasHorizontalsuelootros.
	 * 
	 * @return possible object is {@link EstructurasHorizontalsuelootrosType }
	 * 
	 */
	@ManyToOne(targetEntity = EstructurasHorizontalsuelootrosType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "ESTRUCTURAS_HORIZONTALSUELOOTROS_AED_ESTS_HJID")
	public EstructurasHorizontalsuelootrosType getEstructurasHorizontalsuelootros() {
		return estructurasHorizontalsuelootros;
	}

	/**
	 * Define el valor de la propiedad estructurasHorizontalsuelootros.
	 * 
	 * @param value
	 *            allowed object is {@link EstructurasHorizontalsuelootrosType }
	 * 
	 */
	public void setEstructurasHorizontalsuelootros(EstructurasHorizontalsuelootrosType value) {
		this.estructurasHorizontalsuelootros = value;
	}

	/**
	 * Obtiene el valor de la propiedad estructurasCubiertaforjadoshorizontales.
	 * 
	 * @return possible object is
	 *         {@link EstructurasCubiertaforjadoshorizontalesType }
	 * 
	 */
	@ManyToOne(targetEntity = EstructurasCubiertaforjadoshorizontalesType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "ESTRUCTURAS_CUBIERTAFORJADOSHORIZONTALES_AED_ESTS_HJID")
	public EstructurasCubiertaforjadoshorizontalesType getEstructurasCubiertaforjadoshorizontales() {
		return estructurasCubiertaforjadoshorizontales;
	}

	/**
	 * Define el valor de la propiedad estructurasCubiertaforjadoshorizontales.
	 * 
	 * @param value
	 *            allowed object is
	 *            {@link EstructurasCubiertaforjadoshorizontalesType }
	 * 
	 */
	public void setEstructurasCubiertaforjadoshorizontales(EstructurasCubiertaforjadoshorizontalesType value) {
		this.estructurasCubiertaforjadoshorizontales = value;
	}

	/**
	 * Obtiene el valor de la propiedad estructurasCubiertaforjadosinclinados.
	 * 
	 * @return possible object is
	 *         {@link EstructurasCubiertaforjadosinclinadosType }
	 * 
	 */
	@ManyToOne(targetEntity = EstructurasCubiertaforjadosinclinadosType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "ESTRUCTURAS_CUBIERTAFORJADOSINCLINADOS_AED_ESTS_HJID")
	public EstructurasCubiertaforjadosinclinadosType getEstructurasCubiertaforjadosinclinados() {
		return estructurasCubiertaforjadosinclinados;
	}

	/**
	 * Define el valor de la propiedad estructurasCubiertaforjadosinclinados.
	 * 
	 * @param value
	 *            allowed object is
	 *            {@link EstructurasCubiertaforjadosinclinadosType }
	 * 
	 */
	public void setEstructurasCubiertaforjadosinclinados(EstructurasCubiertaforjadosinclinadosType value) {
		this.estructurasCubiertaforjadosinclinados = value;
	}

	/**
	 * Obtiene el valor de la propiedad estructurasCubiertacerchasporticos.
	 * 
	 * @return possible object is {@link EstructurasCubiertacerchasporticosType }
	 * 
	 */
	@ManyToOne(targetEntity = EstructurasCubiertacerchasporticosType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "ESTRUCTURAS_CUBIERTACERCHASPORTICOS_AED_ESTS_HJID")
	public EstructurasCubiertacerchasporticosType getEstructurasCubiertacerchasporticos() {
		return estructurasCubiertacerchasporticos;
	}

	/**
	 * Define el valor de la propiedad estructurasCubiertacerchasporticos.
	 * 
	 * @param value
	 *            allowed object is
	 *            {@link EstructurasCubiertacerchasporticosType }
	 * 
	 */
	public void setEstructurasCubiertacerchasporticos(EstructurasCubiertacerchasporticosType value) {
		this.estructurasCubiertacerchasporticos = value;
	}

	/**
	 * Obtiene el valor de la propiedad estructurasCubiertaotros.
	 * 
	 * @return possible object is {@link EstructurasCubiertaotrosType }
	 * 
	 */
	@ManyToOne(targetEntity = EstructurasCubiertaotrosType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "ESTRUCTURAS_CUBIERTAOTROS_AED_ESTS_HJID")
	public EstructurasCubiertaotrosType getEstructurasCubiertaotros() {
		return estructurasCubiertaotros;
	}

	/**
	 * Define el valor de la propiedad estructurasCubiertaotros.
	 * 
	 * @param value
	 *            allowed object is {@link EstructurasCubiertaotrosType }
	 * 
	 */
	public void setEstructurasCubiertaotros(EstructurasCubiertaotrosType value) {
		this.estructurasCubiertaotros = value;
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
		final EstructurasType that = ((EstructurasType) object);
		{
			String lhsCubiertaForjadoinclinadoTexto;
			lhsCubiertaForjadoinclinadoTexto = this.getCubiertaForjadoinclinadoTexto();
			String rhsCubiertaForjadoinclinadoTexto;
			rhsCubiertaForjadoinclinadoTexto = that.getCubiertaForjadoinclinadoTexto();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "cubiertaForjadoinclinadoTexto", lhsCubiertaForjadoinclinadoTexto), LocatorUtils.property(thatLocator, "cubiertaForjadoinclinadoTexto", rhsCubiertaForjadoinclinadoTexto), lhsCubiertaForjadoinclinadoTexto, rhsCubiertaForjadoinclinadoTexto)) {
				return false;
			}
		}
		{
			String lhsCubiertaOtrosTexto;
			lhsCubiertaOtrosTexto = this.getCubiertaOtrosTexto();
			String rhsCubiertaOtrosTexto;
			rhsCubiertaOtrosTexto = that.getCubiertaOtrosTexto();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "cubiertaOtrosTexto", lhsCubiertaOtrosTexto), LocatorUtils.property(thatLocator, "cubiertaOtrosTexto", rhsCubiertaOtrosTexto), lhsCubiertaOtrosTexto, rhsCubiertaOtrosTexto)) {
				return false;
			}
		}
		{
			String lhsHorizontalplantatipoOtrosTexto;
			lhsHorizontalplantatipoOtrosTexto = this.getHorizontalplantatipoOtrosTexto();
			String rhsHorizontalplantatipoOtrosTexto;
			rhsHorizontalplantatipoOtrosTexto = that.getHorizontalplantatipoOtrosTexto();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "horizontalplantatipoOtrosTexto", lhsHorizontalplantatipoOtrosTexto), LocatorUtils.property(thatLocator, "horizontalplantatipoOtrosTexto", rhsHorizontalplantatipoOtrosTexto), lhsHorizontalplantatipoOtrosTexto, rhsHorizontalplantatipoOtrosTexto)) {
				return false;
			}
		}
		{
			String lhsHorizontalsueloOtrosTexto;
			lhsHorizontalsueloOtrosTexto = this.getHorizontalsueloOtrosTexto();
			String rhsHorizontalsueloOtrosTexto;
			rhsHorizontalsueloOtrosTexto = that.getHorizontalsueloOtrosTexto();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "horizontalsueloOtrosTexto", lhsHorizontalsueloOtrosTexto), LocatorUtils.property(thatLocator, "horizontalsueloOtrosTexto", rhsHorizontalsueloOtrosTexto), lhsHorizontalsueloOtrosTexto, rhsHorizontalsueloOtrosTexto)) {
				return false;
			}
		}
		{
			String lhsVerticalOtrosTexto;
			lhsVerticalOtrosTexto = this.getVerticalOtrosTexto();
			String rhsVerticalOtrosTexto;
			rhsVerticalOtrosTexto = that.getVerticalOtrosTexto();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "verticalOtrosTexto", lhsVerticalOtrosTexto), LocatorUtils.property(thatLocator, "verticalOtrosTexto", rhsVerticalOtrosTexto), lhsVerticalOtrosTexto, rhsVerticalOtrosTexto)) {
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
			EstructurasVerticalmuroscargasType lhsEstructurasVerticalmuroscargas;
			lhsEstructurasVerticalmuroscargas = this.getEstructurasVerticalmuroscargas();
			EstructurasVerticalmuroscargasType rhsEstructurasVerticalmuroscargas;
			rhsEstructurasVerticalmuroscargas = that.getEstructurasVerticalmuroscargas();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "estructurasVerticalmuroscargas", lhsEstructurasVerticalmuroscargas), LocatorUtils.property(thatLocator, "estructurasVerticalmuroscargas", rhsEstructurasVerticalmuroscargas), lhsEstructurasVerticalmuroscargas, rhsEstructurasVerticalmuroscargas)) {
				return false;
			}
		}
		{
			EstructurasVerticalpilaresType lhsEstructurasVerticalpilares;
			lhsEstructurasVerticalpilares = this.getEstructurasVerticalpilares();
			EstructurasVerticalpilaresType rhsEstructurasVerticalpilares;
			rhsEstructurasVerticalpilares = that.getEstructurasVerticalpilares();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "estructurasVerticalpilares", lhsEstructurasVerticalpilares), LocatorUtils.property(thatLocator, "estructurasVerticalpilares", rhsEstructurasVerticalpilares), lhsEstructurasVerticalpilares, rhsEstructurasVerticalpilares)) {
				return false;
			}
		}
		{
			EstructurasVerticalotrosType lhsEstructurasVerticalotros;
			lhsEstructurasVerticalotros = this.getEstructurasVerticalotros();
			EstructurasVerticalotrosType rhsEstructurasVerticalotros;
			rhsEstructurasVerticalotros = that.getEstructurasVerticalotros();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "estructurasVerticalotros", lhsEstructurasVerticalotros), LocatorUtils.property(thatLocator, "estructurasVerticalotros", rhsEstructurasVerticalotros), lhsEstructurasVerticalotros, rhsEstructurasVerticalotros)) {
				return false;
			}
		}
		{
			EstructurasHorizontalplantatipoestructurasprincipalesType lhsEstructurasHorizontalplantatipoestructurasprincipales;
			lhsEstructurasHorizontalplantatipoestructurasprincipales = this.getEstructurasHorizontalplantatipoestructurasprincipales();
			EstructurasHorizontalplantatipoestructurasprincipalesType rhsEstructurasHorizontalplantatipoestructurasprincipales;
			rhsEstructurasHorizontalplantatipoestructurasprincipales = that.getEstructurasHorizontalplantatipoestructurasprincipales();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "estructurasHorizontalplantatipoestructurasprincipales", lhsEstructurasHorizontalplantatipoestructurasprincipales), LocatorUtils.property(thatLocator, "estructurasHorizontalplantatipoestructurasprincipales", rhsEstructurasHorizontalplantatipoestructurasprincipales), lhsEstructurasHorizontalplantatipoestructurasprincipales, rhsEstructurasHorizontalplantatipoestructurasprincipales)) {
				return false;
			}
		}
		{
			EstructurasHorizontalplantatipoforjadossecundariosType lhsEstructurasHorizontalplantatipoforjadossecundarios;
			lhsEstructurasHorizontalplantatipoforjadossecundarios = this.getEstructurasHorizontalplantatipoforjadossecundarios();
			EstructurasHorizontalplantatipoforjadossecundariosType rhsEstructurasHorizontalplantatipoforjadossecundarios;
			rhsEstructurasHorizontalplantatipoforjadossecundarios = that.getEstructurasHorizontalplantatipoforjadossecundarios();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "estructurasHorizontalplantatipoforjadossecundarios", lhsEstructurasHorizontalplantatipoforjadossecundarios), LocatorUtils.property(thatLocator, "estructurasHorizontalplantatipoforjadossecundarios", rhsEstructurasHorizontalplantatipoforjadossecundarios), lhsEstructurasHorizontalplantatipoforjadossecundarios, rhsEstructurasHorizontalplantatipoforjadossecundarios)) {
				return false;
			}
		}
		{
			EstructurasHorizontalplantatipoforjadosentrevigadosType lhsEstructurasHorizontalplantatipoforjadosentrevigados;
			lhsEstructurasHorizontalplantatipoforjadosentrevigados = this.getEstructurasHorizontalplantatipoforjadosentrevigados();
			EstructurasHorizontalplantatipoforjadosentrevigadosType rhsEstructurasHorizontalplantatipoforjadosentrevigados;
			rhsEstructurasHorizontalplantatipoforjadosentrevigados = that.getEstructurasHorizontalplantatipoforjadosentrevigados();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "estructurasHorizontalplantatipoforjadosentrevigados", lhsEstructurasHorizontalplantatipoforjadosentrevigados), LocatorUtils.property(thatLocator, "estructurasHorizontalplantatipoforjadosentrevigados", rhsEstructurasHorizontalplantatipoforjadosentrevigados), lhsEstructurasHorizontalplantatipoforjadosentrevigados, rhsEstructurasHorizontalplantatipoforjadosentrevigados)) {
				return false;
			}
		}
		{
			EstructurasHorizontalplantatipootrosType lhsEstructurasHorizontalplantatipootros;
			lhsEstructurasHorizontalplantatipootros = this.getEstructurasHorizontalplantatipootros();
			EstructurasHorizontalplantatipootrosType rhsEstructurasHorizontalplantatipootros;
			rhsEstructurasHorizontalplantatipootros = that.getEstructurasHorizontalplantatipootros();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "estructurasHorizontalplantatipootros", lhsEstructurasHorizontalplantatipootros), LocatorUtils.property(thatLocator, "estructurasHorizontalplantatipootros", rhsEstructurasHorizontalplantatipootros), lhsEstructurasHorizontalplantatipootros, rhsEstructurasHorizontalplantatipootros)) {
				return false;
			}
		}
		{
			EstructurasHorizontalsueloforjadosType lhsEstructurasHorizontalsueloforjados;
			lhsEstructurasHorizontalsueloforjados = this.getEstructurasHorizontalsueloforjados();
			EstructurasHorizontalsueloforjadosType rhsEstructurasHorizontalsueloforjados;
			rhsEstructurasHorizontalsueloforjados = that.getEstructurasHorizontalsueloforjados();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "estructurasHorizontalsueloforjados", lhsEstructurasHorizontalsueloforjados), LocatorUtils.property(thatLocator, "estructurasHorizontalsueloforjados", rhsEstructurasHorizontalsueloforjados), lhsEstructurasHorizontalsueloforjados, rhsEstructurasHorizontalsueloforjados)) {
				return false;
			}
		}
		{
			EstructurasHorizontalsueloforjadossanitariosType lhsEstructurasHorizontalsueloforjadossanitarios;
			lhsEstructurasHorizontalsueloforjadossanitarios = this.getEstructurasHorizontalsueloforjadossanitarios();
			EstructurasHorizontalsueloforjadossanitariosType rhsEstructurasHorizontalsueloforjadossanitarios;
			rhsEstructurasHorizontalsueloforjadossanitarios = that.getEstructurasHorizontalsueloforjadossanitarios();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "estructurasHorizontalsueloforjadossanitarios", lhsEstructurasHorizontalsueloforjadossanitarios), LocatorUtils.property(thatLocator, "estructurasHorizontalsueloforjadossanitarios", rhsEstructurasHorizontalsueloforjadossanitarios), lhsEstructurasHorizontalsueloforjadossanitarios, rhsEstructurasHorizontalsueloforjadossanitarios)) {
				return false;
			}
		}
		{
			EstructurasHorizontalsuelootrosType lhsEstructurasHorizontalsuelootros;
			lhsEstructurasHorizontalsuelootros = this.getEstructurasHorizontalsuelootros();
			EstructurasHorizontalsuelootrosType rhsEstructurasHorizontalsuelootros;
			rhsEstructurasHorizontalsuelootros = that.getEstructurasHorizontalsuelootros();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "estructurasHorizontalsuelootros", lhsEstructurasHorizontalsuelootros), LocatorUtils.property(thatLocator, "estructurasHorizontalsuelootros", rhsEstructurasHorizontalsuelootros), lhsEstructurasHorizontalsuelootros, rhsEstructurasHorizontalsuelootros)) {
				return false;
			}
		}
		{
			EstructurasCubiertaforjadoshorizontalesType lhsEstructurasCubiertaforjadoshorizontales;
			lhsEstructurasCubiertaforjadoshorizontales = this.getEstructurasCubiertaforjadoshorizontales();
			EstructurasCubiertaforjadoshorizontalesType rhsEstructurasCubiertaforjadoshorizontales;
			rhsEstructurasCubiertaforjadoshorizontales = that.getEstructurasCubiertaforjadoshorizontales();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "estructurasCubiertaforjadoshorizontales", lhsEstructurasCubiertaforjadoshorizontales), LocatorUtils.property(thatLocator, "estructurasCubiertaforjadoshorizontales", rhsEstructurasCubiertaforjadoshorizontales), lhsEstructurasCubiertaforjadoshorizontales, rhsEstructurasCubiertaforjadoshorizontales)) {
				return false;
			}
		}
		{
			EstructurasCubiertaforjadosinclinadosType lhsEstructurasCubiertaforjadosinclinados;
			lhsEstructurasCubiertaforjadosinclinados = this.getEstructurasCubiertaforjadosinclinados();
			EstructurasCubiertaforjadosinclinadosType rhsEstructurasCubiertaforjadosinclinados;
			rhsEstructurasCubiertaforjadosinclinados = that.getEstructurasCubiertaforjadosinclinados();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "estructurasCubiertaforjadosinclinados", lhsEstructurasCubiertaforjadosinclinados), LocatorUtils.property(thatLocator, "estructurasCubiertaforjadosinclinados", rhsEstructurasCubiertaforjadosinclinados), lhsEstructurasCubiertaforjadosinclinados, rhsEstructurasCubiertaforjadosinclinados)) {
				return false;
			}
		}
		{
			EstructurasCubiertacerchasporticosType lhsEstructurasCubiertacerchasporticos;
			lhsEstructurasCubiertacerchasporticos = this.getEstructurasCubiertacerchasporticos();
			EstructurasCubiertacerchasporticosType rhsEstructurasCubiertacerchasporticos;
			rhsEstructurasCubiertacerchasporticos = that.getEstructurasCubiertacerchasporticos();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "estructurasCubiertacerchasporticos", lhsEstructurasCubiertacerchasporticos), LocatorUtils.property(thatLocator, "estructurasCubiertacerchasporticos", rhsEstructurasCubiertacerchasporticos), lhsEstructurasCubiertacerchasporticos, rhsEstructurasCubiertacerchasporticos)) {
				return false;
			}
		}
		{
			EstructurasCubiertaotrosType lhsEstructurasCubiertaotros;
			lhsEstructurasCubiertaotros = this.getEstructurasCubiertaotros();
			EstructurasCubiertaotrosType rhsEstructurasCubiertaotros;
			rhsEstructurasCubiertaotros = that.getEstructurasCubiertaotros();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "estructurasCubiertaotros", lhsEstructurasCubiertaotros), LocatorUtils.property(thatLocator, "estructurasCubiertaotros", rhsEstructurasCubiertaotros), lhsEstructurasCubiertaotros, rhsEstructurasCubiertaotros)) {
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
			String theCubiertaForjadoinclinadoTexto;
			theCubiertaForjadoinclinadoTexto = this.getCubiertaForjadoinclinadoTexto();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "cubiertaForjadoinclinadoTexto", theCubiertaForjadoinclinadoTexto), currentHashCode, theCubiertaForjadoinclinadoTexto);
		}
		{
			String theCubiertaOtrosTexto;
			theCubiertaOtrosTexto = this.getCubiertaOtrosTexto();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "cubiertaOtrosTexto", theCubiertaOtrosTexto), currentHashCode, theCubiertaOtrosTexto);
		}
		{
			String theHorizontalplantatipoOtrosTexto;
			theHorizontalplantatipoOtrosTexto = this.getHorizontalplantatipoOtrosTexto();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "horizontalplantatipoOtrosTexto", theHorizontalplantatipoOtrosTexto), currentHashCode, theHorizontalplantatipoOtrosTexto);
		}
		{
			String theHorizontalsueloOtrosTexto;
			theHorizontalsueloOtrosTexto = this.getHorizontalsueloOtrosTexto();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "horizontalsueloOtrosTexto", theHorizontalsueloOtrosTexto), currentHashCode, theHorizontalsueloOtrosTexto);
		}
		{
			String theVerticalOtrosTexto;
			theVerticalOtrosTexto = this.getVerticalOtrosTexto();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "verticalOtrosTexto", theVerticalOtrosTexto), currentHashCode, theVerticalOtrosTexto);
		}
		{
			String theObservaciones;
			theObservaciones = this.getObservaciones();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "observaciones", theObservaciones), currentHashCode, theObservaciones);
		}
		{
			EstructurasVerticalmuroscargasType theEstructurasVerticalmuroscargas;
			theEstructurasVerticalmuroscargas = this.getEstructurasVerticalmuroscargas();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "estructurasVerticalmuroscargas", theEstructurasVerticalmuroscargas), currentHashCode, theEstructurasVerticalmuroscargas);
		}
		{
			EstructurasVerticalpilaresType theEstructurasVerticalpilares;
			theEstructurasVerticalpilares = this.getEstructurasVerticalpilares();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "estructurasVerticalpilares", theEstructurasVerticalpilares), currentHashCode, theEstructurasVerticalpilares);
		}
		{
			EstructurasVerticalotrosType theEstructurasVerticalotros;
			theEstructurasVerticalotros = this.getEstructurasVerticalotros();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "estructurasVerticalotros", theEstructurasVerticalotros), currentHashCode, theEstructurasVerticalotros);
		}
		{
			EstructurasHorizontalplantatipoestructurasprincipalesType theEstructurasHorizontalplantatipoestructurasprincipales;
			theEstructurasHorizontalplantatipoestructurasprincipales = this.getEstructurasHorizontalplantatipoestructurasprincipales();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "estructurasHorizontalplantatipoestructurasprincipales", theEstructurasHorizontalplantatipoestructurasprincipales), currentHashCode, theEstructurasHorizontalplantatipoestructurasprincipales);
		}
		{
			EstructurasHorizontalplantatipoforjadossecundariosType theEstructurasHorizontalplantatipoforjadossecundarios;
			theEstructurasHorizontalplantatipoforjadossecundarios = this.getEstructurasHorizontalplantatipoforjadossecundarios();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "estructurasHorizontalplantatipoforjadossecundarios", theEstructurasHorizontalplantatipoforjadossecundarios), currentHashCode, theEstructurasHorizontalplantatipoforjadossecundarios);
		}
		{
			EstructurasHorizontalplantatipoforjadosentrevigadosType theEstructurasHorizontalplantatipoforjadosentrevigados;
			theEstructurasHorizontalplantatipoforjadosentrevigados = this.getEstructurasHorizontalplantatipoforjadosentrevigados();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "estructurasHorizontalplantatipoforjadosentrevigados", theEstructurasHorizontalplantatipoforjadosentrevigados), currentHashCode, theEstructurasHorizontalplantatipoforjadosentrevigados);
		}
		{
			EstructurasHorizontalplantatipootrosType theEstructurasHorizontalplantatipootros;
			theEstructurasHorizontalplantatipootros = this.getEstructurasHorizontalplantatipootros();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "estructurasHorizontalplantatipootros", theEstructurasHorizontalplantatipootros), currentHashCode, theEstructurasHorizontalplantatipootros);
		}
		{
			EstructurasHorizontalsueloforjadosType theEstructurasHorizontalsueloforjados;
			theEstructurasHorizontalsueloforjados = this.getEstructurasHorizontalsueloforjados();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "estructurasHorizontalsueloforjados", theEstructurasHorizontalsueloforjados), currentHashCode, theEstructurasHorizontalsueloforjados);
		}
		{
			EstructurasHorizontalsueloforjadossanitariosType theEstructurasHorizontalsueloforjadossanitarios;
			theEstructurasHorizontalsueloforjadossanitarios = this.getEstructurasHorizontalsueloforjadossanitarios();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "estructurasHorizontalsueloforjadossanitarios", theEstructurasHorizontalsueloforjadossanitarios), currentHashCode, theEstructurasHorizontalsueloforjadossanitarios);
		}
		{
			EstructurasHorizontalsuelootrosType theEstructurasHorizontalsuelootros;
			theEstructurasHorizontalsuelootros = this.getEstructurasHorizontalsuelootros();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "estructurasHorizontalsuelootros", theEstructurasHorizontalsuelootros), currentHashCode, theEstructurasHorizontalsuelootros);
		}
		{
			EstructurasCubiertaforjadoshorizontalesType theEstructurasCubiertaforjadoshorizontales;
			theEstructurasCubiertaforjadoshorizontales = this.getEstructurasCubiertaforjadoshorizontales();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "estructurasCubiertaforjadoshorizontales", theEstructurasCubiertaforjadoshorizontales), currentHashCode, theEstructurasCubiertaforjadoshorizontales);
		}
		{
			EstructurasCubiertaforjadosinclinadosType theEstructurasCubiertaforjadosinclinados;
			theEstructurasCubiertaforjadosinclinados = this.getEstructurasCubiertaforjadosinclinados();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "estructurasCubiertaforjadosinclinados", theEstructurasCubiertaforjadosinclinados), currentHashCode, theEstructurasCubiertaforjadosinclinados);
		}
		{
			EstructurasCubiertacerchasporticosType theEstructurasCubiertacerchasporticos;
			theEstructurasCubiertacerchasporticos = this.getEstructurasCubiertacerchasporticos();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "estructurasCubiertacerchasporticos", theEstructurasCubiertacerchasporticos), currentHashCode, theEstructurasCubiertacerchasporticos);
		}
		{
			EstructurasCubiertaotrosType theEstructurasCubiertaotros;
			theEstructurasCubiertaotros = this.getEstructurasCubiertaotros();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "estructurasCubiertaotros", theEstructurasCubiertaotros), currentHashCode, theEstructurasCubiertaotros);
		}
		return currentHashCode;
	}

	public int hashCode() {
		final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
		return this.hashCode(null, strategy);
	}

}
