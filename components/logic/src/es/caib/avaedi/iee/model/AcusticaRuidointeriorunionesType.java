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
 * Clase Java para acustica_ruidointeriorunionesType complex type.
 * 
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que
 * haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="acustica_ruidointeriorunionesType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="material_aislante_elastico" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="hoja_interior_fachada_continua" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="elemento_separacion_vertical_forjado_techo_suspendido" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="elemento_separacion_vertical_forjado_suelo_flotante" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="elemento_separacion_vertical_forjado_mortero" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="elemento_separacion_vertical_forjado_conexion_rigida" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
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
@XmlType(name = "acustica_ruidointeriorunionesType", propOrder = { "materialAislanteElastico", "hojaInteriorFachadaContinua", "elementoSeparacionVerticalForjadoTechoSuspendido", "elementoSeparacionVerticalForjadoSueloFlotante", "elementoSeparacionVerticalForjadoMortero", "elementoSeparacionVerticalForjadoConexionRigida", "observaciones" })
@Entity(name = "AcusticaRuidointeriorunionesType")
@Table(name = "AED_ACU_RUIINTUNIONES")
@Inheritance(strategy = InheritanceType.JOINED)
public class AcusticaRuidointeriorunionesType implements Serializable, Equals, HashCode {

	@XmlElement(name = "material_aislante_elastico")
	protected int materialAislanteElastico;
	@XmlElement(name = "hoja_interior_fachada_continua")
	protected int hojaInteriorFachadaContinua;
	@XmlElement(name = "elemento_separacion_vertical_forjado_techo_suspendido")
	protected int elementoSeparacionVerticalForjadoTechoSuspendido;
	@XmlElement(name = "elemento_separacion_vertical_forjado_suelo_flotante")
	protected int elementoSeparacionVerticalForjadoSueloFlotante;
	@XmlElement(name = "elemento_separacion_vertical_forjado_mortero")
	protected int elementoSeparacionVerticalForjadoMortero;
	@XmlElement(name = "elemento_separacion_vertical_forjado_conexion_rigida")
	protected int elementoSeparacionVerticalForjadoConexionRigida;
	@XmlElement(required = true)
	protected String observaciones;
	@XmlAttribute(name = "Hjid")
	protected Long hjid;

	/**
	 * Obtiene el valor de la propiedad materialAislanteElastico.
	 * 
	 */
	@Basic
	@Column(name = "MATERIAL_AISLANTE_ELASTICO", precision = 10, scale = 0)
	public int getMaterialAislanteElastico() {
		return materialAislanteElastico;
	}

	/**
	 * Define el valor de la propiedad materialAislanteElastico.
	 * 
	 */
	public void setMaterialAislanteElastico(int value) {
		this.materialAislanteElastico = value;
	}

	/**
	 * Obtiene el valor de la propiedad hojaInteriorFachadaContinua.
	 * 
	 */
	@Basic
	@Column(name = "HOJA_INTERIOR_FACHADA_CONTINUA", precision = 10, scale = 0)
	public int getHojaInteriorFachadaContinua() {
		return hojaInteriorFachadaContinua;
	}

	/**
	 * Define el valor de la propiedad hojaInteriorFachadaContinua.
	 * 
	 */
	public void setHojaInteriorFachadaContinua(int value) {
		this.hojaInteriorFachadaContinua = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * elementoSeparacionVerticalForjadoTechoSuspendido.
	 * 
	 */
	@Basic
	@Column(name = "ELEMENTO_SEPARACION_VERTICAL_FORJADO_TECHO_SUSPENDIDO", precision = 10, scale = 0)
	public int getElementoSeparacionVerticalForjadoTechoSuspendido() {
		return elementoSeparacionVerticalForjadoTechoSuspendido;
	}

	/**
	 * Define el valor de la propiedad
	 * elementoSeparacionVerticalForjadoTechoSuspendido.
	 * 
	 */
	public void setElementoSeparacionVerticalForjadoTechoSuspendido(int value) {
		this.elementoSeparacionVerticalForjadoTechoSuspendido = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * elementoSeparacionVerticalForjadoSueloFlotante.
	 * 
	 */
	@Basic
	@Column(name = "ELEMENTO_SEPARACION_VERTICAL_FORJADO_SUELO_FLOTANTE", precision = 10, scale = 0)
	public int getElementoSeparacionVerticalForjadoSueloFlotante() {
		return elementoSeparacionVerticalForjadoSueloFlotante;
	}

	/**
	 * Define el valor de la propiedad
	 * elementoSeparacionVerticalForjadoSueloFlotante.
	 * 
	 */
	public void setElementoSeparacionVerticalForjadoSueloFlotante(int value) {
		this.elementoSeparacionVerticalForjadoSueloFlotante = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * elementoSeparacionVerticalForjadoMortero.
	 * 
	 */
	@Basic
	@Column(name = "ELEMENTO_SEPARACION_VERTICAL_FORJADO_MORTERO", precision = 10, scale = 0)
	public int getElementoSeparacionVerticalForjadoMortero() {
		return elementoSeparacionVerticalForjadoMortero;
	}

	/**
	 * Define el valor de la propiedad elementoSeparacionVerticalForjadoMortero.
	 * 
	 */
	public void setElementoSeparacionVerticalForjadoMortero(int value) {
		this.elementoSeparacionVerticalForjadoMortero = value;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * elementoSeparacionVerticalForjadoConexionRigida.
	 * 
	 */
	@Basic
	@Column(name = "ELEMENTO_SEPARACION_VERTICAL_FORJADO_CONEXION_RIGIDA", precision = 10, scale = 0)
	public int getElementoSeparacionVerticalForjadoConexionRigida() {
		return elementoSeparacionVerticalForjadoConexionRigida;
	}

	/**
	 * Define el valor de la propiedad
	 * elementoSeparacionVerticalForjadoConexionRigida.
	 * 
	 */
	public void setElementoSeparacionVerticalForjadoConexionRigida(int value) {
		this.elementoSeparacionVerticalForjadoConexionRigida = value;
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
		final AcusticaRuidointeriorunionesType that = ((AcusticaRuidointeriorunionesType) object);
		{
			int lhsMaterialAislanteElastico;
			lhsMaterialAislanteElastico = this.getMaterialAislanteElastico();
			int rhsMaterialAislanteElastico;
			rhsMaterialAislanteElastico = that.getMaterialAislanteElastico();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "materialAislanteElastico", lhsMaterialAislanteElastico), LocatorUtils.property(thatLocator, "materialAislanteElastico", rhsMaterialAislanteElastico), lhsMaterialAislanteElastico, rhsMaterialAislanteElastico)) {
				return false;
			}
		}
		{
			int lhsHojaInteriorFachadaContinua;
			lhsHojaInteriorFachadaContinua = this.getHojaInteriorFachadaContinua();
			int rhsHojaInteriorFachadaContinua;
			rhsHojaInteriorFachadaContinua = that.getHojaInteriorFachadaContinua();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "hojaInteriorFachadaContinua", lhsHojaInteriorFachadaContinua), LocatorUtils.property(thatLocator, "hojaInteriorFachadaContinua", rhsHojaInteriorFachadaContinua), lhsHojaInteriorFachadaContinua, rhsHojaInteriorFachadaContinua)) {
				return false;
			}
		}
		{
			int lhsElementoSeparacionVerticalForjadoTechoSuspendido;
			lhsElementoSeparacionVerticalForjadoTechoSuspendido = this.getElementoSeparacionVerticalForjadoTechoSuspendido();
			int rhsElementoSeparacionVerticalForjadoTechoSuspendido;
			rhsElementoSeparacionVerticalForjadoTechoSuspendido = that.getElementoSeparacionVerticalForjadoTechoSuspendido();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "elementoSeparacionVerticalForjadoTechoSuspendido", lhsElementoSeparacionVerticalForjadoTechoSuspendido), LocatorUtils.property(thatLocator, "elementoSeparacionVerticalForjadoTechoSuspendido", rhsElementoSeparacionVerticalForjadoTechoSuspendido), lhsElementoSeparacionVerticalForjadoTechoSuspendido, rhsElementoSeparacionVerticalForjadoTechoSuspendido)) {
				return false;
			}
		}
		{
			int lhsElementoSeparacionVerticalForjadoSueloFlotante;
			lhsElementoSeparacionVerticalForjadoSueloFlotante = this.getElementoSeparacionVerticalForjadoSueloFlotante();
			int rhsElementoSeparacionVerticalForjadoSueloFlotante;
			rhsElementoSeparacionVerticalForjadoSueloFlotante = that.getElementoSeparacionVerticalForjadoSueloFlotante();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "elementoSeparacionVerticalForjadoSueloFlotante", lhsElementoSeparacionVerticalForjadoSueloFlotante), LocatorUtils.property(thatLocator, "elementoSeparacionVerticalForjadoSueloFlotante", rhsElementoSeparacionVerticalForjadoSueloFlotante), lhsElementoSeparacionVerticalForjadoSueloFlotante, rhsElementoSeparacionVerticalForjadoSueloFlotante)) {
				return false;
			}
		}
		{
			int lhsElementoSeparacionVerticalForjadoMortero;
			lhsElementoSeparacionVerticalForjadoMortero = this.getElementoSeparacionVerticalForjadoMortero();
			int rhsElementoSeparacionVerticalForjadoMortero;
			rhsElementoSeparacionVerticalForjadoMortero = that.getElementoSeparacionVerticalForjadoMortero();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "elementoSeparacionVerticalForjadoMortero", lhsElementoSeparacionVerticalForjadoMortero), LocatorUtils.property(thatLocator, "elementoSeparacionVerticalForjadoMortero", rhsElementoSeparacionVerticalForjadoMortero), lhsElementoSeparacionVerticalForjadoMortero, rhsElementoSeparacionVerticalForjadoMortero)) {
				return false;
			}
		}
		{
			int lhsElementoSeparacionVerticalForjadoConexionRigida;
			lhsElementoSeparacionVerticalForjadoConexionRigida = this.getElementoSeparacionVerticalForjadoConexionRigida();
			int rhsElementoSeparacionVerticalForjadoConexionRigida;
			rhsElementoSeparacionVerticalForjadoConexionRigida = that.getElementoSeparacionVerticalForjadoConexionRigida();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "elementoSeparacionVerticalForjadoConexionRigida", lhsElementoSeparacionVerticalForjadoConexionRigida), LocatorUtils.property(thatLocator, "elementoSeparacionVerticalForjadoConexionRigida", rhsElementoSeparacionVerticalForjadoConexionRigida), lhsElementoSeparacionVerticalForjadoConexionRigida, rhsElementoSeparacionVerticalForjadoConexionRigida)) {
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
			int theMaterialAislanteElastico;
			theMaterialAislanteElastico = this.getMaterialAislanteElastico();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "materialAislanteElastico", theMaterialAislanteElastico), currentHashCode, theMaterialAislanteElastico);
		}
		{
			int theHojaInteriorFachadaContinua;
			theHojaInteriorFachadaContinua = this.getHojaInteriorFachadaContinua();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "hojaInteriorFachadaContinua", theHojaInteriorFachadaContinua), currentHashCode, theHojaInteriorFachadaContinua);
		}
		{
			int theElementoSeparacionVerticalForjadoTechoSuspendido;
			theElementoSeparacionVerticalForjadoTechoSuspendido = this.getElementoSeparacionVerticalForjadoTechoSuspendido();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "elementoSeparacionVerticalForjadoTechoSuspendido", theElementoSeparacionVerticalForjadoTechoSuspendido), currentHashCode, theElementoSeparacionVerticalForjadoTechoSuspendido);
		}
		{
			int theElementoSeparacionVerticalForjadoSueloFlotante;
			theElementoSeparacionVerticalForjadoSueloFlotante = this.getElementoSeparacionVerticalForjadoSueloFlotante();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "elementoSeparacionVerticalForjadoSueloFlotante", theElementoSeparacionVerticalForjadoSueloFlotante), currentHashCode, theElementoSeparacionVerticalForjadoSueloFlotante);
		}
		{
			int theElementoSeparacionVerticalForjadoMortero;
			theElementoSeparacionVerticalForjadoMortero = this.getElementoSeparacionVerticalForjadoMortero();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "elementoSeparacionVerticalForjadoMortero", theElementoSeparacionVerticalForjadoMortero), currentHashCode, theElementoSeparacionVerticalForjadoMortero);
		}
		{
			int theElementoSeparacionVerticalForjadoConexionRigida;
			theElementoSeparacionVerticalForjadoConexionRigida = this.getElementoSeparacionVerticalForjadoConexionRigida();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "elementoSeparacionVerticalForjadoConexionRigida", theElementoSeparacionVerticalForjadoConexionRigida), currentHashCode, theElementoSeparacionVerticalForjadoConexionRigida);
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
