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
 * Clase Java para referenciaType complex type.
 * 
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que
 * haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="referenciaType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="referencia_catastral" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="principal" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "referenciaType", propOrder = { "referenciaCatastral", "principal" })
@Embeddable
public class ReferenciaType implements Serializable, Equals, HashCode {

	@XmlElement(name = "referencia_catastral", required = true)
	protected String referenciaCatastral;
	protected boolean principal;

	/**
	 * Obtiene el valor de la propiedad referenciaCatastral.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "REFERENCIA_CATASTRAL", length = 255)
	public String getReferenciaCatastral() {
		return referenciaCatastral;
	}

	/**
	 * Define el valor de la propiedad referenciaCatastral.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setReferenciaCatastral(String value) {
		this.referenciaCatastral = value;
	}

	/**
	 * Obtiene el valor de la propiedad principal.
	 * 
	 */
	@Basic
	@Column(name = "PRINCIPAL")
	public boolean isPrincipal() {
		return principal;
	}

	/**
	 * Define el valor de la propiedad principal.
	 * 
	 */
	public void setPrincipal(boolean value) {
		this.principal = value;
	}

	public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
		if ((object == null) || (this.getClass() != object.getClass())) {
			return false;
		}
		if (this == object) {
			return true;
		}
		final ReferenciaType that = ((ReferenciaType) object);
		{
			String lhsReferenciaCatastral;
			lhsReferenciaCatastral = this.getReferenciaCatastral();
			String rhsReferenciaCatastral;
			rhsReferenciaCatastral = that.getReferenciaCatastral();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "referenciaCatastral", lhsReferenciaCatastral), LocatorUtils.property(thatLocator, "referenciaCatastral", rhsReferenciaCatastral), lhsReferenciaCatastral, rhsReferenciaCatastral)) {
				return false;
			}
		}
		{
			boolean lhsPrincipal;
			lhsPrincipal = this.isPrincipal();
			boolean rhsPrincipal;
			rhsPrincipal = that.isPrincipal();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "principal", lhsPrincipal), LocatorUtils.property(thatLocator, "principal", rhsPrincipal), lhsPrincipal, rhsPrincipal)) {
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
			String theReferenciaCatastral;
			theReferenciaCatastral = this.getReferenciaCatastral();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "referenciaCatastral", theReferenciaCatastral), currentHashCode, theReferenciaCatastral);
		}
		{
			boolean thePrincipal;
			thePrincipal = this.isPrincipal();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "principal", thePrincipal), currentHashCode, thePrincipal);
		}
		return currentHashCode;
	}

	public int hashCode() {
		final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
		return this.hashCode(null, strategy);
	}

}
