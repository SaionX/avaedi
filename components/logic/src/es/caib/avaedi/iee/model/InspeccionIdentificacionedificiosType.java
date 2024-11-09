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
import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 * Clase Java para inspeccion_identificacionedificiosType complex type.
 * 
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que
 * haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="inspeccion_identificacionedificiosType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="piso_letra" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="codigo_postal" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="poblacion" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="provincia" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="provincia_id"&gt;
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
 *               &lt;enumeration value="9"/&gt;
 *               &lt;enumeration value="10"/&gt;
 *               &lt;enumeration value="11"/&gt;
 *               &lt;enumeration value="12"/&gt;
 *               &lt;enumeration value="13"/&gt;
 *               &lt;enumeration value="14"/&gt;
 *               &lt;enumeration value="15"/&gt;
 *               &lt;enumeration value="16"/&gt;
 *               &lt;enumeration value="17"/&gt;
 *               &lt;enumeration value="18"/&gt;
 *               &lt;enumeration value="19"/&gt;
 *               &lt;enumeration value="20"/&gt;
 *               &lt;enumeration value="21"/&gt;
 *               &lt;enumeration value="22"/&gt;
 *               &lt;enumeration value="23"/&gt;
 *               &lt;enumeration value="24"/&gt;
 *               &lt;enumeration value="25"/&gt;
 *               &lt;enumeration value="26"/&gt;
 *               &lt;enumeration value="27"/&gt;
 *               &lt;enumeration value="28"/&gt;
 *               &lt;enumeration value="29"/&gt;
 *               &lt;enumeration value="30"/&gt;
 *               &lt;enumeration value="31"/&gt;
 *               &lt;enumeration value="32"/&gt;
 *               &lt;enumeration value="33"/&gt;
 *               &lt;enumeration value="34"/&gt;
 *               &lt;enumeration value="35"/&gt;
 *               &lt;enumeration value="36"/&gt;
 *               &lt;enumeration value="37"/&gt;
 *               &lt;enumeration value="38"/&gt;
 *               &lt;enumeration value="39"/&gt;
 *               &lt;enumeration value="40"/&gt;
 *               &lt;enumeration value="41"/&gt;
 *               &lt;enumeration value="42"/&gt;
 *               &lt;enumeration value="43"/&gt;
 *               &lt;enumeration value="44"/&gt;
 *               &lt;enumeration value="45"/&gt;
 *               &lt;enumeration value="46"/&gt;
 *               &lt;enumeration value="47"/&gt;
 *               &lt;enumeration value="48"/&gt;
 *               &lt;enumeration value="49"/&gt;
 *               &lt;enumeration value="50"/&gt;
 *               &lt;enumeration value="51"/&gt;
 *               &lt;enumeration value="52"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="tipo_via_manual" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="via_manual" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="numero_manual" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="inspeccion_identificacionedificio_objeto_tipo_id"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int"&gt;
 *               &lt;enumeration value="1"/&gt;
 *               &lt;enumeration value="2"/&gt;
 *               &lt;enumeration value="3"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="objeto_texto" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="inspeccion_identificacionedificio_comunes_tipo_id"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int"&gt;
 *               &lt;enumeration value="1"/&gt;
 *               &lt;enumeration value="2"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="comun_texto" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="observaciones" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="inspeccion_propiedad_regimen_tipo_id"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int"&gt;
 *               &lt;enumeration value="1"/&gt;
 *               &lt;enumeration value="2"/&gt;
 *               &lt;enumeration value="3"/&gt;
 *               &lt;enumeration value="4"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="regimen_texto" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "inspeccion_identificacionedificiosType", propOrder = { "pisoLetra", "codigoPostal", "poblacion", "provincia", "provinciaId", "tipoViaManual", "viaManual", "numeroManual", "inspeccionIdentificacionedificioObjetoTipoId", "objetoTexto", "inspeccionIdentificacionedificioComunesTipoId", "comunTexto", "observaciones", "inspeccionPropiedadRegimenTipoId", "regimenTexto" })
@Embeddable
public class InspeccionIdentificacionedificiosType implements Serializable, Equals, HashCode {

	@XmlElement(name = "piso_letra", required = true)
	protected String pisoLetra;
	@XmlElement(name = "codigo_postal", required = true)
	protected String codigoPostal;
	@XmlElement(required = true)
	protected String poblacion;
	@XmlElement(required = true)
	protected String provincia;
	@XmlElement(name = "provincia_id")
	protected int provinciaId;
	@XmlElement(name = "tipo_via_manual", required = true)
	protected String tipoViaManual;
	@XmlElement(name = "via_manual", required = true)
	protected String viaManual;
	@XmlElement(name = "numero_manual", required = true)
	protected String numeroManual;
	@XmlElement(name = "inspeccion_identificacionedificio_objeto_tipo_id")
	protected int inspeccionIdentificacionedificioObjetoTipoId;
	@XmlElement(name = "objeto_texto", required = true)
	protected String objetoTexto;
	@XmlElement(name = "inspeccion_identificacionedificio_comunes_tipo_id")
	protected int inspeccionIdentificacionedificioComunesTipoId;
	@XmlElement(name = "comun_texto", required = true)
	protected String comunTexto;
	@XmlElement(required = true)
	protected String observaciones;
	@XmlElement(name = "inspeccion_propiedad_regimen_tipo_id")
	protected int inspeccionPropiedadRegimenTipoId;
	@XmlElement(name = "regimen_texto", required = true)
	protected String regimenTexto;

	/**
	 * Obtiene el valor de la propiedad pisoLetra.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "PISO_LETRA", length = 255)
	public String getPisoLetra() {
		return pisoLetra;
	}

	/**
	 * Define el valor de la propiedad pisoLetra.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPisoLetra(String value) {
		this.pisoLetra = value;
	}

	/**
	 * Obtiene el valor de la propiedad codigoPostal.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "CODIGO_POSTAL", length = 255)
	public String getCodigoPostal() {
		return codigoPostal;
	}

	/**
	 * Define el valor de la propiedad codigoPostal.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCodigoPostal(String value) {
		this.codigoPostal = value;
	}

	/**
	 * Obtiene el valor de la propiedad poblacion.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "POBLACION", length = 255)
	public String getPoblacion() {
		return poblacion;
	}

	/**
	 * Define el valor de la propiedad poblacion.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPoblacion(String value) {
		this.poblacion = value;
	}

	/**
	 * Obtiene el valor de la propiedad provincia.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "PROVINCIA", length = 255)
	public String getProvincia() {
		return provincia;
	}

	/**
	 * Define el valor de la propiedad provincia.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setProvincia(String value) {
		this.provincia = value;
	}

	/**
	 * Obtiene el valor de la propiedad provinciaId.
	 * 
	 */
	@Basic
	@Column(name = "PROVINCIA_ID")
	public int getProvinciaId() {
		return provinciaId;
	}

	/**
	 * Define el valor de la propiedad provinciaId.
	 * 
	 */
	public void setProvinciaId(int value) {
		this.provinciaId = value;
	}

	/**
	 * Obtiene el valor de la propiedad tipoViaManual.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "TIPO_VIA_MANUAL", length = 255)
	public String getTipoViaManual() {
		return tipoViaManual;
	}

	/**
	 * Define el valor de la propiedad tipoViaManual.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTipoViaManual(String value) {
		this.tipoViaManual = value;
	}

	/**
	 * Obtiene el valor de la propiedad viaManual.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "VIA_MANUAL", length = 255)
	public String getViaManual() {
		return viaManual;
	}

	/**
	 * Define el valor de la propiedad viaManual.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setViaManual(String value) {
		this.viaManual = value;
	}

	/**
	 * Obtiene el valor de la propiedad numeroManual.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "NUMERO_MANUAL", length = 255)
	public String getNumeroManual() {
		return numeroManual;
	}

	/**
	 * Define el valor de la propiedad numeroManual.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setNumeroManual(String value) {
		this.numeroManual = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * inspeccionIdentificacionedificioObjetoTipoId.
	 * 
	 */
	@Basic
	@Column(name = "INSPECCION_IDENTIFICACIONEDIFICIO_OBJETO_TIPO_ID")
	public int getInspeccionIdentificacionedificioObjetoTipoId() {
		return inspeccionIdentificacionedificioObjetoTipoId;
	}

	/**
	 * Define el valor de la propiedad
	 * inspeccionIdentificacionedificioObjetoTipoId.
	 * 
	 */
	public void setInspeccionIdentificacionedificioObjetoTipoId(int value) {
		this.inspeccionIdentificacionedificioObjetoTipoId = value;
	}

	/**
	 * Obtiene el valor de la propiedad objetoTexto.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "OBJETO_TEXTO", length = 255)
	public String getObjetoTexto() {
		return objetoTexto;
	}

	/**
	 * Define el valor de la propiedad objetoTexto.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setObjetoTexto(String value) {
		this.objetoTexto = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * inspeccionIdentificacionedificioComunesTipoId.
	 * 
	 */
	@Basic
	@Column(name = "INSPECCION_IDENTIFICACIONEDIFICIO_COMUNES_TIPO_ID")
	public int getInspeccionIdentificacionedificioComunesTipoId() {
		return inspeccionIdentificacionedificioComunesTipoId;
	}

	/**
	 * Define el valor de la propiedad
	 * inspeccionIdentificacionedificioComunesTipoId.
	 * 
	 */
	public void setInspeccionIdentificacionedificioComunesTipoId(int value) {
		this.inspeccionIdentificacionedificioComunesTipoId = value;
	}

	/**
	 * Obtiene el valor de la propiedad comunTexto.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "COMUN_TEXTO", length = 255)
	public String getComunTexto() {
		return comunTexto;
	}

	/**
	 * Define el valor de la propiedad comunTexto.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setComunTexto(String value) {
		this.comunTexto = value;
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
	 * Obtiene el valor de la propiedad inspeccionPropiedadRegimenTipoId.
	 * 
	 */
	@Basic
	@Column(name = "INSPECCION_PROPIEDAD_REGIMEN_TIPO_ID")
	public int getInspeccionPropiedadRegimenTipoId() {
		return inspeccionPropiedadRegimenTipoId;
	}

	/**
	 * Define el valor de la propiedad inspeccionPropiedadRegimenTipoId.
	 * 
	 */
	public void setInspeccionPropiedadRegimenTipoId(int value) {
		this.inspeccionPropiedadRegimenTipoId = value;
	}

	/**
	 * Obtiene el valor de la propiedad regimenTexto.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "REGIMEN_TEXTO", length = 255)
	public String getRegimenTexto() {
		return regimenTexto;
	}

	/**
	 * Define el valor de la propiedad regimenTexto.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRegimenTexto(String value) {
		this.regimenTexto = value;
	}

	public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
		if ((object == null) || (this.getClass() != object.getClass())) {
			return false;
		}
		if (this == object) {
			return true;
		}
		final InspeccionIdentificacionedificiosType that = ((InspeccionIdentificacionedificiosType) object);
		{
			String lhsPisoLetra;
			lhsPisoLetra = this.getPisoLetra();
			String rhsPisoLetra;
			rhsPisoLetra = that.getPisoLetra();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "pisoLetra", lhsPisoLetra), LocatorUtils.property(thatLocator, "pisoLetra", rhsPisoLetra), lhsPisoLetra, rhsPisoLetra)) {
				return false;
			}
		}
		{
			String lhsCodigoPostal;
			lhsCodigoPostal = this.getCodigoPostal();
			String rhsCodigoPostal;
			rhsCodigoPostal = that.getCodigoPostal();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "codigoPostal", lhsCodigoPostal), LocatorUtils.property(thatLocator, "codigoPostal", rhsCodigoPostal), lhsCodigoPostal, rhsCodigoPostal)) {
				return false;
			}
		}
		{
			String lhsPoblacion;
			lhsPoblacion = this.getPoblacion();
			String rhsPoblacion;
			rhsPoblacion = that.getPoblacion();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "poblacion", lhsPoblacion), LocatorUtils.property(thatLocator, "poblacion", rhsPoblacion), lhsPoblacion, rhsPoblacion)) {
				return false;
			}
		}
		{
			String lhsProvincia;
			lhsProvincia = this.getProvincia();
			String rhsProvincia;
			rhsProvincia = that.getProvincia();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "provincia", lhsProvincia), LocatorUtils.property(thatLocator, "provincia", rhsProvincia), lhsProvincia, rhsProvincia)) {
				return false;
			}
		}
		{
			int lhsProvinciaId;
			lhsProvinciaId = this.getProvinciaId();
			int rhsProvinciaId;
			rhsProvinciaId = that.getProvinciaId();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "provinciaId", lhsProvinciaId), LocatorUtils.property(thatLocator, "provinciaId", rhsProvinciaId), lhsProvinciaId, rhsProvinciaId)) {
				return false;
			}
		}
		{
			String lhsTipoViaManual;
			lhsTipoViaManual = this.getTipoViaManual();
			String rhsTipoViaManual;
			rhsTipoViaManual = that.getTipoViaManual();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "tipoViaManual", lhsTipoViaManual), LocatorUtils.property(thatLocator, "tipoViaManual", rhsTipoViaManual), lhsTipoViaManual, rhsTipoViaManual)) {
				return false;
			}
		}
		{
			String lhsViaManual;
			lhsViaManual = this.getViaManual();
			String rhsViaManual;
			rhsViaManual = that.getViaManual();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "viaManual", lhsViaManual), LocatorUtils.property(thatLocator, "viaManual", rhsViaManual), lhsViaManual, rhsViaManual)) {
				return false;
			}
		}
		{
			String lhsNumeroManual;
			lhsNumeroManual = this.getNumeroManual();
			String rhsNumeroManual;
			rhsNumeroManual = that.getNumeroManual();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "numeroManual", lhsNumeroManual), LocatorUtils.property(thatLocator, "numeroManual", rhsNumeroManual), lhsNumeroManual, rhsNumeroManual)) {
				return false;
			}
		}
		{
			int lhsInspeccionIdentificacionedificioObjetoTipoId;
			lhsInspeccionIdentificacionedificioObjetoTipoId = this.getInspeccionIdentificacionedificioObjetoTipoId();
			int rhsInspeccionIdentificacionedificioObjetoTipoId;
			rhsInspeccionIdentificacionedificioObjetoTipoId = that.getInspeccionIdentificacionedificioObjetoTipoId();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "inspeccionIdentificacionedificioObjetoTipoId", lhsInspeccionIdentificacionedificioObjetoTipoId), LocatorUtils.property(thatLocator, "inspeccionIdentificacionedificioObjetoTipoId", rhsInspeccionIdentificacionedificioObjetoTipoId), lhsInspeccionIdentificacionedificioObjetoTipoId, rhsInspeccionIdentificacionedificioObjetoTipoId)) {
				return false;
			}
		}
		{
			String lhsObjetoTexto;
			lhsObjetoTexto = this.getObjetoTexto();
			String rhsObjetoTexto;
			rhsObjetoTexto = that.getObjetoTexto();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "objetoTexto", lhsObjetoTexto), LocatorUtils.property(thatLocator, "objetoTexto", rhsObjetoTexto), lhsObjetoTexto, rhsObjetoTexto)) {
				return false;
			}
		}
		{
			int lhsInspeccionIdentificacionedificioComunesTipoId;
			lhsInspeccionIdentificacionedificioComunesTipoId = this.getInspeccionIdentificacionedificioComunesTipoId();
			int rhsInspeccionIdentificacionedificioComunesTipoId;
			rhsInspeccionIdentificacionedificioComunesTipoId = that.getInspeccionIdentificacionedificioComunesTipoId();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "inspeccionIdentificacionedificioComunesTipoId", lhsInspeccionIdentificacionedificioComunesTipoId), LocatorUtils.property(thatLocator, "inspeccionIdentificacionedificioComunesTipoId", rhsInspeccionIdentificacionedificioComunesTipoId), lhsInspeccionIdentificacionedificioComunesTipoId, rhsInspeccionIdentificacionedificioComunesTipoId)) {
				return false;
			}
		}
		{
			String lhsComunTexto;
			lhsComunTexto = this.getComunTexto();
			String rhsComunTexto;
			rhsComunTexto = that.getComunTexto();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "comunTexto", lhsComunTexto), LocatorUtils.property(thatLocator, "comunTexto", rhsComunTexto), lhsComunTexto, rhsComunTexto)) {
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
			int lhsInspeccionPropiedadRegimenTipoId;
			lhsInspeccionPropiedadRegimenTipoId = this.getInspeccionPropiedadRegimenTipoId();
			int rhsInspeccionPropiedadRegimenTipoId;
			rhsInspeccionPropiedadRegimenTipoId = that.getInspeccionPropiedadRegimenTipoId();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "inspeccionPropiedadRegimenTipoId", lhsInspeccionPropiedadRegimenTipoId), LocatorUtils.property(thatLocator, "inspeccionPropiedadRegimenTipoId", rhsInspeccionPropiedadRegimenTipoId), lhsInspeccionPropiedadRegimenTipoId, rhsInspeccionPropiedadRegimenTipoId)) {
				return false;
			}
		}
		{
			String lhsRegimenTexto;
			lhsRegimenTexto = this.getRegimenTexto();
			String rhsRegimenTexto;
			rhsRegimenTexto = that.getRegimenTexto();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "regimenTexto", lhsRegimenTexto), LocatorUtils.property(thatLocator, "regimenTexto", rhsRegimenTexto), lhsRegimenTexto, rhsRegimenTexto)) {
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
			String thePisoLetra;
			thePisoLetra = this.getPisoLetra();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "pisoLetra", thePisoLetra), currentHashCode, thePisoLetra);
		}
		{
			String theCodigoPostal;
			theCodigoPostal = this.getCodigoPostal();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "codigoPostal", theCodigoPostal), currentHashCode, theCodigoPostal);
		}
		{
			String thePoblacion;
			thePoblacion = this.getPoblacion();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "poblacion", thePoblacion), currentHashCode, thePoblacion);
		}
		{
			String theProvincia;
			theProvincia = this.getProvincia();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "provincia", theProvincia), currentHashCode, theProvincia);
		}
		{
			int theProvinciaId;
			theProvinciaId = this.getProvinciaId();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "provinciaId", theProvinciaId), currentHashCode, theProvinciaId);
		}
		{
			String theTipoViaManual;
			theTipoViaManual = this.getTipoViaManual();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "tipoViaManual", theTipoViaManual), currentHashCode, theTipoViaManual);
		}
		{
			String theViaManual;
			theViaManual = this.getViaManual();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "viaManual", theViaManual), currentHashCode, theViaManual);
		}
		{
			String theNumeroManual;
			theNumeroManual = this.getNumeroManual();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "numeroManual", theNumeroManual), currentHashCode, theNumeroManual);
		}
		{
			int theInspeccionIdentificacionedificioObjetoTipoId;
			theInspeccionIdentificacionedificioObjetoTipoId = this.getInspeccionIdentificacionedificioObjetoTipoId();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "inspeccionIdentificacionedificioObjetoTipoId", theInspeccionIdentificacionedificioObjetoTipoId), currentHashCode, theInspeccionIdentificacionedificioObjetoTipoId);
		}
		{
			String theObjetoTexto;
			theObjetoTexto = this.getObjetoTexto();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "objetoTexto", theObjetoTexto), currentHashCode, theObjetoTexto);
		}
		{
			int theInspeccionIdentificacionedificioComunesTipoId;
			theInspeccionIdentificacionedificioComunesTipoId = this.getInspeccionIdentificacionedificioComunesTipoId();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "inspeccionIdentificacionedificioComunesTipoId", theInspeccionIdentificacionedificioComunesTipoId), currentHashCode, theInspeccionIdentificacionedificioComunesTipoId);
		}
		{
			String theComunTexto;
			theComunTexto = this.getComunTexto();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "comunTexto", theComunTexto), currentHashCode, theComunTexto);
		}
		{
			String theObservaciones;
			theObservaciones = this.getObservaciones();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "observaciones", theObservaciones), currentHashCode, theObservaciones);
		}
		{
			int theInspeccionPropiedadRegimenTipoId;
			theInspeccionPropiedadRegimenTipoId = this.getInspeccionPropiedadRegimenTipoId();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "inspeccionPropiedadRegimenTipoId", theInspeccionPropiedadRegimenTipoId), currentHashCode, theInspeccionPropiedadRegimenTipoId);
		}
		{
			String theRegimenTexto;
			theRegimenTexto = this.getRegimenTexto();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "regimenTexto", theRegimenTexto), currentHashCode, theRegimenTexto);
		}
		return currentHashCode;
	}

	public int hashCode() {
		final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
		return this.hashCode(null, strategy);
	}

}
