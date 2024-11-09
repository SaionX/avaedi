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
 * Clase Java para valoracion_parcialType complex type.
 * 
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que
 * haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="valoracion_parcialType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="conservacion_sistemasconstructivos_tipo_id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="conservacion_valoraciones_tipo_id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="plazo_inicio_obras" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="plazo_fin_obras" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "valoracion_parcialType", propOrder = { "conservacionSistemasconstructivosTipoId", "conservacionValoracionesTipoId", "plazoInicioObras", "plazoFinObras" })
@Entity(name = "ValoracionParcialType")
@Table(name = "AED_VALORACION_PARCIAL")
@Inheritance(strategy = InheritanceType.JOINED)
public class ValoracionParcialType implements Serializable, Equals, HashCode {

	@XmlElement(name = "conservacion_sistemasconstructivos_tipo_id")
	protected int conservacionSistemasconstructivosTipoId;
	@XmlElement(name = "conservacion_valoraciones_tipo_id")
	protected int conservacionValoracionesTipoId;
	@XmlElement(name = "plazo_inicio_obras", required = true)
	protected String plazoInicioObras;
	@XmlElement(name = "plazo_fin_obras", required = true)
	protected String plazoFinObras;
	@XmlAttribute(name = "Hjid")
	protected Long hjid;

	/**
	 * Obtiene el valor de la propiedad conservacionSistemasconstructivosTipoId.
	 * 
	 */
	@Basic
	@Column(name = "CONSERVACION_SISTEMASCONSTRUCTIVOS_TIPO_ID", precision = 10, scale = 0)
	public int getConservacionSistemasconstructivosTipoId() {
		return conservacionSistemasconstructivosTipoId;
	}

	/**
	 * Define el valor de la propiedad conservacionSistemasconstructivosTipoId.
	 * 
	 */
	public void setConservacionSistemasconstructivosTipoId(int value) {
		this.conservacionSistemasconstructivosTipoId = value;
	}

	/**
	 * Obtiene el valor de la propiedad conservacionValoracionesTipoId.
	 * 
	 */
	@Basic
	@Column(name = "CONSERVACION_VALORACIONES_TIPO_ID", precision = 10, scale = 0)
	public int getConservacionValoracionesTipoId() {
		return conservacionValoracionesTipoId;
	}

	/**
	 * Define el valor de la propiedad conservacionValoracionesTipoId.
	 * 
	 */
	public void setConservacionValoracionesTipoId(int value) {
		this.conservacionValoracionesTipoId = value;
	}

	/**
	 * Obtiene el valor de la propiedad plazoInicioObras.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "PLAZO_INICIO_OBRAS", length = 255)
	public String getPlazoInicioObras() {
		return plazoInicioObras;
	}

	/**
	 * Define el valor de la propiedad plazoInicioObras.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPlazoInicioObras(String value) {
		this.plazoInicioObras = value;
	}

	/**
	 * Obtiene el valor de la propiedad plazoFinObras.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "PLAZO_FIN_OBRAS", length = 255)
	public String getPlazoFinObras() {
		return plazoFinObras;
	}

	/**
	 * Define el valor de la propiedad plazoFinObras.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPlazoFinObras(String value) {
		this.plazoFinObras = value;
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
		final ValoracionParcialType that = ((ValoracionParcialType) object);
		{
			int lhsConservacionSistemasconstructivosTipoId;
			lhsConservacionSistemasconstructivosTipoId = this.getConservacionSistemasconstructivosTipoId();
			int rhsConservacionSistemasconstructivosTipoId;
			rhsConservacionSistemasconstructivosTipoId = that.getConservacionSistemasconstructivosTipoId();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "conservacionSistemasconstructivosTipoId", lhsConservacionSistemasconstructivosTipoId), LocatorUtils.property(thatLocator, "conservacionSistemasconstructivosTipoId", rhsConservacionSistemasconstructivosTipoId), lhsConservacionSistemasconstructivosTipoId, rhsConservacionSistemasconstructivosTipoId)) {
				return false;
			}
		}
		{
			int lhsConservacionValoracionesTipoId;
			lhsConservacionValoracionesTipoId = this.getConservacionValoracionesTipoId();
			int rhsConservacionValoracionesTipoId;
			rhsConservacionValoracionesTipoId = that.getConservacionValoracionesTipoId();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "conservacionValoracionesTipoId", lhsConservacionValoracionesTipoId), LocatorUtils.property(thatLocator, "conservacionValoracionesTipoId", rhsConservacionValoracionesTipoId), lhsConservacionValoracionesTipoId, rhsConservacionValoracionesTipoId)) {
				return false;
			}
		}
		{
			String lhsPlazoInicioObras;
			lhsPlazoInicioObras = this.getPlazoInicioObras();
			String rhsPlazoInicioObras;
			rhsPlazoInicioObras = that.getPlazoInicioObras();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "plazoInicioObras", lhsPlazoInicioObras), LocatorUtils.property(thatLocator, "plazoInicioObras", rhsPlazoInicioObras), lhsPlazoInicioObras, rhsPlazoInicioObras)) {
				return false;
			}
		}
		{
			String lhsPlazoFinObras;
			lhsPlazoFinObras = this.getPlazoFinObras();
			String rhsPlazoFinObras;
			rhsPlazoFinObras = that.getPlazoFinObras();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "plazoFinObras", lhsPlazoFinObras), LocatorUtils.property(thatLocator, "plazoFinObras", rhsPlazoFinObras), lhsPlazoFinObras, rhsPlazoFinObras)) {
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
			int theConservacionSistemasconstructivosTipoId;
			theConservacionSistemasconstructivosTipoId = this.getConservacionSistemasconstructivosTipoId();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "conservacionSistemasconstructivosTipoId", theConservacionSistemasconstructivosTipoId), currentHashCode, theConservacionSistemasconstructivosTipoId);
		}
		{
			int theConservacionValoracionesTipoId;
			theConservacionValoracionesTipoId = this.getConservacionValoracionesTipoId();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "conservacionValoracionesTipoId", theConservacionValoracionesTipoId), currentHashCode, theConservacionValoracionesTipoId);
		}
		{
			String thePlazoInicioObras;
			thePlazoInicioObras = this.getPlazoInicioObras();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "plazoInicioObras", thePlazoInicioObras), currentHashCode, thePlazoInicioObras);
		}
		{
			String thePlazoFinObras;
			thePlazoFinObras = this.getPlazoFinObras();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "plazoFinObras", thePlazoFinObras), currentHashCode, thePlazoFinObras);
		}
		return currentHashCode;
	}

	public int hashCode() {
		final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
		return this.hashCode(null, strategy);
	}

}
