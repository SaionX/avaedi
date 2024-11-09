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
 * Clase Java para documentacion_otroType complex type.
 * 
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que
 * haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="documentacion_otroType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="documentacion_instalaciones_grupo_id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="texto" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "documentacion_otroType", propOrder = { "documentacionInstalacionesGrupoId", "texto" })
@Entity(name = "DocumentacionOtroType")
@Table(name = "AED_DOC_OTRO")
@Inheritance(strategy = InheritanceType.JOINED)
public class DocumentacionOtroType implements Serializable, Equals, HashCode {

	@XmlElement(name = "documentacion_instalaciones_grupo_id")
	protected int documentacionInstalacionesGrupoId;
	@XmlElement(required = true)
	protected String texto;
	@XmlAttribute(name = "Hjid")
	protected Long hjid;

	/**
	 * Obtiene el valor de la propiedad documentacionInstalacionesGrupoId.
	 * 
	 */
	@Basic
	@Column(name = "DOCUMENTACION_INSTALACIONES_GRUPO_ID", precision = 10, scale = 0)
	public int getDocumentacionInstalacionesGrupoId() {
		return documentacionInstalacionesGrupoId;
	}

	/**
	 * Define el valor de la propiedad documentacionInstalacionesGrupoId.
	 * 
	 */
	public void setDocumentacionInstalacionesGrupoId(int value) {
		this.documentacionInstalacionesGrupoId = value;
	}

	/**
	 * Obtiene el valor de la propiedad texto.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "TEXTO", length = 255)
	public String getTexto() {
		return texto;
	}

	/**
	 * Define el valor de la propiedad texto.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTexto(String value) {
		this.texto = value;
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
		final DocumentacionOtroType that = ((DocumentacionOtroType) object);
		{
			int lhsDocumentacionInstalacionesGrupoId;
			lhsDocumentacionInstalacionesGrupoId = this.getDocumentacionInstalacionesGrupoId();
			int rhsDocumentacionInstalacionesGrupoId;
			rhsDocumentacionInstalacionesGrupoId = that.getDocumentacionInstalacionesGrupoId();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "documentacionInstalacionesGrupoId", lhsDocumentacionInstalacionesGrupoId), LocatorUtils.property(thatLocator, "documentacionInstalacionesGrupoId", rhsDocumentacionInstalacionesGrupoId), lhsDocumentacionInstalacionesGrupoId, rhsDocumentacionInstalacionesGrupoId)) {
				return false;
			}
		}
		{
			String lhsTexto;
			lhsTexto = this.getTexto();
			String rhsTexto;
			rhsTexto = that.getTexto();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "texto", lhsTexto), LocatorUtils.property(thatLocator, "texto", rhsTexto), lhsTexto, rhsTexto)) {
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
			int theDocumentacionInstalacionesGrupoId;
			theDocumentacionInstalacionesGrupoId = this.getDocumentacionInstalacionesGrupoId();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "documentacionInstalacionesGrupoId", theDocumentacionInstalacionesGrupoId), currentHashCode, theDocumentacionInstalacionesGrupoId);
		}
		{
			String theTexto;
			theTexto = this.getTexto();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "texto", theTexto), currentHashCode, theTexto);
		}
		return currentHashCode;
	}

	public int hashCode() {
		final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
		return this.hashCode(null, strategy);
	}

}
