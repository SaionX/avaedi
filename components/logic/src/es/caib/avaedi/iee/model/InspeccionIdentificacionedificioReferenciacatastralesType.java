//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.11 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2016.09.08 a las 10:32:16 PM CEST 
//

package es.caib.avaedi.iee.model;

import java.io.Serializable;

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
 * Clase Java para inspeccion_identificacionedificio_referenciacatastralesType
 * complex type.
 * 
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que
 * haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="inspeccion_identificacionedificio_referenciacatastralesType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="referencia" type="{}referenciaType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "inspeccion_identificacionedificio_referenciacatastralesType", propOrder = { "referencia" })
@Embeddable
public class InspeccionIdentificacionedificioReferenciacatastralesType implements Serializable, Equals, HashCode {

	@XmlElement(required = true)
	protected ReferenciaType referencia;

	/**
	 * Obtiene el valor de la propiedad referencia.
	 * 
	 * @return possible object is {@link ReferenciaType }
	 * 
	 */
	public ReferenciaType getReferencia() {
		return referencia;
	}

	/**
	 * Define el valor de la propiedad referencia.
	 * 
	 * @param value
	 *            allowed object is {@link ReferenciaType }
	 * 
	 */
	public void setReferencia(ReferenciaType value) {
		this.referencia = value;
	}

	public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
		if ((object == null) || (this.getClass() != object.getClass())) {
			return false;
		}
		if (this == object) {
			return true;
		}
		final InspeccionIdentificacionedificioReferenciacatastralesType that = ((InspeccionIdentificacionedificioReferenciacatastralesType) object);
		{
			ReferenciaType lhsReferencia;
			lhsReferencia = this.getReferencia();
			ReferenciaType rhsReferencia;
			rhsReferencia = that.getReferencia();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "referencia", lhsReferencia), LocatorUtils.property(thatLocator, "referencia", rhsReferencia), lhsReferencia, rhsReferencia)) {
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
			ReferenciaType theReferencia;
			theReferencia = this.getReferencia();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "referencia", theReferencia), currentHashCode, theReferencia);
		}
		return currentHashCode;
	}

	public int hashCode() {
		final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
		return this.hashCode(null, strategy);
	}

}
