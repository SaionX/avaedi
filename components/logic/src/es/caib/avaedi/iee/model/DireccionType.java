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
 * Clase Java para direccionType complex type.
 * 
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que
 * haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="direccionType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="tipo_via" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="via" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="numero" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "direccionType", propOrder = { "tipoVia", "via", "numero" })
@Embeddable
public class DireccionType implements Serializable, Equals, HashCode {

	@XmlElement(name = "tipo_via", required = true)
	protected String tipoVia;
	@XmlElement(required = true)
	protected String via;
	protected int numero;

	/**
	 * Obtiene el valor de la propiedad tipoVia.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "TIPO_VIA", length = 255)
	public String getTipoVia() {
		return tipoVia;
	}

	/**
	 * Define el valor de la propiedad tipoVia.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTipoVia(String value) {
		this.tipoVia = value;
	}

	/**
	 * Obtiene el valor de la propiedad via.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "VIA", length = 255)
	public String getVia() {
		return via;
	}

	/**
	 * Define el valor de la propiedad via.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setVia(String value) {
		this.via = value;
	}

	/**
	 * Obtiene el valor de la propiedad numero.
	 * 
	 */
	@Basic
	@Column(name = "NUMERO", precision = 10, scale = 0)
	public int getNumero() {
		return numero;
	}

	/**
	 * Define el valor de la propiedad numero.
	 * 
	 */
	public void setNumero(int value) {
		this.numero = value;
	}

	public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
		if ((object == null) || (this.getClass() != object.getClass())) {
			return false;
		}
		if (this == object) {
			return true;
		}
		final DireccionType that = ((DireccionType) object);
		{
			String lhsTipoVia;
			lhsTipoVia = this.getTipoVia();
			String rhsTipoVia;
			rhsTipoVia = that.getTipoVia();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "tipoVia", lhsTipoVia), LocatorUtils.property(thatLocator, "tipoVia", rhsTipoVia), lhsTipoVia, rhsTipoVia)) {
				return false;
			}
		}
		{
			String lhsVia;
			lhsVia = this.getVia();
			String rhsVia;
			rhsVia = that.getVia();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "via", lhsVia), LocatorUtils.property(thatLocator, "via", rhsVia), lhsVia, rhsVia)) {
				return false;
			}
		}
		{
			int lhsNumero;
			lhsNumero = this.getNumero();
			int rhsNumero;
			rhsNumero = that.getNumero();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "numero", lhsNumero), LocatorUtils.property(thatLocator, "numero", rhsNumero), lhsNumero, rhsNumero)) {
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
			String theTipoVia;
			theTipoVia = this.getTipoVia();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "tipoVia", theTipoVia), currentHashCode, theTipoVia);
		}
		{
			String theVia;
			theVia = this.getVia();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "via", theVia), currentHashCode, theVia);
		}
		{
			int theNumero;
			theNumero = this.getNumero();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "numero", theNumero), currentHashCode, theNumero);
		}
		return currentHashCode;
	}

	public int hashCode() {
		final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
		return this.hashCode(null, strategy);
	}

}
