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
 * Clase Java para conservacion_datosgenerales_historicosType complex type.
 * 
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que
 * haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="conservacion_datosgenerales_historicosType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="historico" type="{}historicoType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "conservacion_datosgenerales_historicosType", propOrder = { "historico" })
@Entity(name = "ConservacionDatosgeneralesHistoricosType")
@Table(name = "AED_CONS_DATGEN_HISTORICOS")
@Inheritance(strategy = InheritanceType.JOINED)
public class ConservacionDatosgeneralesHistoricosType implements Serializable, Equals, HashCode {

	@XmlElement(required = true)
	protected HistoricoType historico;
	@XmlAttribute(name = "Hjid")
	protected Long hjid;

	/**
	 * Obtiene el valor de la propiedad historico.
	 * 
	 * @return possible object is {@link HistoricoType }
	 * 
	 */
	@ManyToOne(targetEntity = HistoricoType.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "HISTORICO_AED_CONS_DATGEN_HISTORICOS_HJID")
	public HistoricoType getHistorico() {
		return historico;
	}

	/**
	 * Define el valor de la propiedad historico.
	 * 
	 * @param value
	 *            allowed object is {@link HistoricoType }
	 * 
	 */
	public void setHistorico(HistoricoType value) {
		this.historico = value;
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
		final ConservacionDatosgeneralesHistoricosType that = ((ConservacionDatosgeneralesHistoricosType) object);
		{
			HistoricoType lhsHistorico;
			lhsHistorico = this.getHistorico();
			HistoricoType rhsHistorico;
			rhsHistorico = that.getHistorico();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "historico", lhsHistorico), LocatorUtils.property(thatLocator, "historico", rhsHistorico), lhsHistorico, rhsHistorico)) {
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
			HistoricoType theHistorico;
			theHistorico = this.getHistorico();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "historico", theHistorico), currentHashCode, theHistorico);
		}
		return currentHashCode;
	}

	public int hashCode() {
		final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
		return this.hashCode(null, strategy);
	}

}
