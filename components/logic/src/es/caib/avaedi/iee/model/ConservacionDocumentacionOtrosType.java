//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.11 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2016.09.08 a las 10:32:16 PM CEST 
//

package es.caib.avaedi.iee.model;

import java.io.Serializable;

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
 * Clase Java para conservacion_documentacion_otrosType complex type.
 * 
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que
 * haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="conservacion_documentacion_otrosType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="documentacion_otro" type="{}documentacion_otroType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "conservacion_documentacion_otrosType", propOrder = { "documentacionOtro" })
@Entity(name = "ConservacionDocumentacionOtrosType")
@Table(name = "AED_CONS_DOC_OTROS")
@Inheritance(strategy = InheritanceType.JOINED)
public class ConservacionDocumentacionOtrosType implements Serializable, Equals, HashCode {

	@XmlElement(name = "documentacion_otro", required = true)
	protected DocumentacionOtroType documentacionOtro;
	@XmlAttribute(name = "Hjid")
	protected Long hjid;

	/**
	 * Obtiene el valor de la propiedad documentacionOtro.
	 * 
	 * @return possible object is {@link DocumentacionOtroType }
	 * 
	 */
	@ManyToOne(targetEntity = DocumentacionOtroType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "DOCUMENTACION_OTRO_AED_CONS_DOC_OTROS_HJID")
	public DocumentacionOtroType getDocumentacionOtro() {
		return documentacionOtro;
	}

	/**
	 * Define el valor de la propiedad documentacionOtro.
	 * 
	 * @param value
	 *            allowed object is {@link DocumentacionOtroType }
	 * 
	 */
	public void setDocumentacionOtro(DocumentacionOtroType value) {
		this.documentacionOtro = value;
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
		final ConservacionDocumentacionOtrosType that = ((ConservacionDocumentacionOtrosType) object);
		{
			DocumentacionOtroType lhsDocumentacionOtro;
			lhsDocumentacionOtro = this.getDocumentacionOtro();
			DocumentacionOtroType rhsDocumentacionOtro;
			rhsDocumentacionOtro = that.getDocumentacionOtro();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "documentacionOtro", lhsDocumentacionOtro), LocatorUtils.property(thatLocator, "documentacionOtro", rhsDocumentacionOtro), lhsDocumentacionOtro, rhsDocumentacionOtro)) {
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
			DocumentacionOtroType theDocumentacionOtro;
			theDocumentacionOtro = this.getDocumentacionOtro();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "documentacionOtro", theDocumentacionOtro), currentHashCode, theDocumentacionOtro);
		}
		return currentHashCode;
	}

	public int hashCode() {
		final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
		return this.hashCode(null, strategy);
	}

}
