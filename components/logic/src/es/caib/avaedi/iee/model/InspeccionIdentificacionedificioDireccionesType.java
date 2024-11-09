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
 * Clase Java para inspeccion_identificacionedificio_direccionesType complex
 * type.
 * 
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que
 * haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="inspeccion_identificacionedificio_direccionesType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="direccion" type="{}direccionType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "inspeccion_identificacionedificio_direccionesType", propOrder = { "direccion" })
@Embeddable
public class InspeccionIdentificacionedificioDireccionesType implements Serializable, Equals, HashCode {

	@XmlElement(required = true)
	protected DireccionType direccion;

	/**
	 * Obtiene el valor de la propiedad direccion.
	 * 
	 * @return possible object is {@link DireccionType }
	 * 
	 */
	public DireccionType getDireccion() {
		return direccion;
	}

	/**
	 * Define el valor de la propiedad direccion.
	 * 
	 * @param value
	 *            allowed object is {@link DireccionType }
	 * 
	 */
	public void setDireccion(DireccionType value) {
		this.direccion = value;
	}

	public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
		if ((object == null) || (this.getClass() != object.getClass())) {
			return false;
		}
		if (this == object) {
			return true;
		}
		final InspeccionIdentificacionedificioDireccionesType that = ((InspeccionIdentificacionedificioDireccionesType) object);
		{
			DireccionType lhsDireccion;
			lhsDireccion = this.getDireccion();
			DireccionType rhsDireccion;
			rhsDireccion = that.getDireccion();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "direccion", lhsDireccion), LocatorUtils.property(thatLocator, "direccion", rhsDireccion), lhsDireccion, rhsDireccion)) {
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
			DireccionType theDireccion;
			theDireccion = this.getDireccion();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "direccion", theDireccion), currentHashCode, theDireccion);
		}
		return currentHashCode;
	}

	public int hashCode() {
		final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
		return this.hashCode(null, strategy);
	}

}
