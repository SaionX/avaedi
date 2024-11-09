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
 * Clase Java para inspeccion_representantesType complex type.
 * 
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que
 * haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="inspeccion_representantesType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="condicion" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="nif" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="direccion" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="codigo_postal" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="poblacion" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="provincia" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="telefono_fijo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="telefono_movil" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "inspeccion_representantesType", propOrder = { "nombre", "condicion", "nif", "direccion", "codigoPostal", "poblacion", "provincia", "telefonoFijo", "telefonoMovil", "email" })
@Embeddable
public class InspeccionRepresentantesType implements Serializable, Equals, HashCode {

	@XmlElement(required = true)
	protected String nombre;
	@XmlElement(required = true)
	protected String condicion;
	@XmlElement(required = true)
	protected String nif;
	@XmlElement(required = true)
	protected String direccion;
	@XmlElement(name = "codigo_postal", required = true)
	protected String codigoPostal;
	@XmlElement(required = true)
	protected String poblacion;
	@XmlElement(required = true)
	protected String provincia;
	@XmlElement(name = "telefono_fijo", required = true)
	protected String telefonoFijo;
	@XmlElement(name = "telefono_movil", required = true)
	protected String telefonoMovil;
	@XmlElement(required = true)
	protected String email;

	/**
	 * Obtiene el valor de la propiedad nombre.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "NOMBRE", length = 255)
	public String getNombre() {
		return nombre;
	}

	/**
	 * Define el valor de la propiedad nombre.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setNombre(String value) {
		this.nombre = value;
	}

	/**
	 * Obtiene el valor de la propiedad condicion.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "CONDICION", length = 255)
	public String getCondicion() {
		return condicion;
	}

	/**
	 * Define el valor de la propiedad condicion.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCondicion(String value) {
		this.condicion = value;
	}

	/**
	 * Obtiene el valor de la propiedad nif.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "NIF", length = 255)
	public String getNif() {
		return nif;
	}

	/**
	 * Define el valor de la propiedad nif.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setNif(String value) {
		this.nif = value;
	}

	/**
	 * Obtiene el valor de la propiedad direccion.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "DIRECCION", length = 255)
	public String getDireccion() {
		return direccion;
	}

	/**
	 * Define el valor de la propiedad direccion.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDireccion(String value) {
		this.direccion = value;
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
	 * Obtiene el valor de la propiedad telefonoFijo.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "TELEFONO_FIJO", length = 255)
	public String getTelefonoFijo() {
		return telefonoFijo;
	}

	/**
	 * Define el valor de la propiedad telefonoFijo.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTelefonoFijo(String value) {
		this.telefonoFijo = value;
	}

	/**
	 * Obtiene el valor de la propiedad telefonoMovil.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "TELEFONO_MOVIL", length = 255)
	public String getTelefonoMovil() {
		return telefonoMovil;
	}

	/**
	 * Define el valor de la propiedad telefonoMovil.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTelefonoMovil(String value) {
		this.telefonoMovil = value;
	}

	/**
	 * Obtiene el valor de la propiedad email.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "EMAIL", length = 255)
	public String getEmail() {
		return email;
	}

	/**
	 * Define el valor de la propiedad email.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setEmail(String value) {
		this.email = value;
	}

	public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
		if ((object == null) || (this.getClass() != object.getClass())) {
			return false;
		}
		if (this == object) {
			return true;
		}
		final InspeccionRepresentantesType that = ((InspeccionRepresentantesType) object);
		{
			String lhsNombre;
			lhsNombre = this.getNombre();
			String rhsNombre;
			rhsNombre = that.getNombre();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "nombre", lhsNombre), LocatorUtils.property(thatLocator, "nombre", rhsNombre), lhsNombre, rhsNombre)) {
				return false;
			}
		}
		{
			String lhsCondicion;
			lhsCondicion = this.getCondicion();
			String rhsCondicion;
			rhsCondicion = that.getCondicion();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "condicion", lhsCondicion), LocatorUtils.property(thatLocator, "condicion", rhsCondicion), lhsCondicion, rhsCondicion)) {
				return false;
			}
		}
		{
			String lhsNif;
			lhsNif = this.getNif();
			String rhsNif;
			rhsNif = that.getNif();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "nif", lhsNif), LocatorUtils.property(thatLocator, "nif", rhsNif), lhsNif, rhsNif)) {
				return false;
			}
		}
		{
			String lhsDireccion;
			lhsDireccion = this.getDireccion();
			String rhsDireccion;
			rhsDireccion = that.getDireccion();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "direccion", lhsDireccion), LocatorUtils.property(thatLocator, "direccion", rhsDireccion), lhsDireccion, rhsDireccion)) {
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
			String lhsTelefonoFijo;
			lhsTelefonoFijo = this.getTelefonoFijo();
			String rhsTelefonoFijo;
			rhsTelefonoFijo = that.getTelefonoFijo();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "telefonoFijo", lhsTelefonoFijo), LocatorUtils.property(thatLocator, "telefonoFijo", rhsTelefonoFijo), lhsTelefonoFijo, rhsTelefonoFijo)) {
				return false;
			}
		}
		{
			String lhsTelefonoMovil;
			lhsTelefonoMovil = this.getTelefonoMovil();
			String rhsTelefonoMovil;
			rhsTelefonoMovil = that.getTelefonoMovil();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "telefonoMovil", lhsTelefonoMovil), LocatorUtils.property(thatLocator, "telefonoMovil", rhsTelefonoMovil), lhsTelefonoMovil, rhsTelefonoMovil)) {
				return false;
			}
		}
		{
			String lhsEmail;
			lhsEmail = this.getEmail();
			String rhsEmail;
			rhsEmail = that.getEmail();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "email", lhsEmail), LocatorUtils.property(thatLocator, "email", rhsEmail), lhsEmail, rhsEmail)) {
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
			String theNombre;
			theNombre = this.getNombre();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "nombre", theNombre), currentHashCode, theNombre);
		}
		{
			String theCondicion;
			theCondicion = this.getCondicion();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "condicion", theCondicion), currentHashCode, theCondicion);
		}
		{
			String theNif;
			theNif = this.getNif();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "nif", theNif), currentHashCode, theNif);
		}
		{
			String theDireccion;
			theDireccion = this.getDireccion();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "direccion", theDireccion), currentHashCode, theDireccion);
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
			String theTelefonoFijo;
			theTelefonoFijo = this.getTelefonoFijo();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "telefonoFijo", theTelefonoFijo), currentHashCode, theTelefonoFijo);
		}
		{
			String theTelefonoMovil;
			theTelefonoMovil = this.getTelefonoMovil();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "telefonoMovil", theTelefonoMovil), currentHashCode, theTelefonoMovil);
		}
		{
			String theEmail;
			theEmail = this.getEmail();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "email", theEmail), currentHashCode, theEmail);
		}
		return currentHashCode;
	}

	public int hashCode() {
		final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
		return this.hashCode(null, strategy);
	}

}
