package es.caib.avaedi.common.model;

// Generated 12-sep-2016 10:10:37

import static javax.persistence.GenerationType.SEQUENCE;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import es.caib.avaedi.at4forms.common.basedao.BaseModel;

/**
 * Estado del informe
 */
@Entity
@Table(name = "aed_estado_informe", uniqueConstraints = @UniqueConstraint(columnNames = "nombre_es"))
public class EstadoInforme extends BaseModel implements java.io.Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	private int clave;
	private String nombreEs;
	private String nombreCa;

	public EstadoInforme() {
	}

	public EstadoInforme(String nombreEs) {
		this.nombreEs = nombreEs;
	}

	public EstadoInforme(String nombreEs, String nombreCa) {
		this.nombreEs = nombreEs;
		this.nombreCa = nombreCa;
	}

	@SequenceGenerator(name = "generator", sequenceName = "AED_ESTADO_INFORME_SEQ", allocationSize = 1)
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "generator")
	@Column(name = "clave", unique = true, nullable = false)
	public int getClave() {
		return this.clave;
	}

	public void setClave(int clave) {
		this.clave = clave;
	}

	@Column(name = "nombre_es", unique = true, nullable = false, length = 64)
	public String getNombreEs() {
		return this.nombreEs;
	}

	public void setNombreEs(String nombreEs) {
		this.nombreEs = nombreEs;
	}

	@Column(name = "nombre_ca", length = 64)
	public String getNombreCa() {
		return this.nombreCa;
	}

	public void setNombreCa(String nombreCa) {
		this.nombreCa = nombreCa;
	}

	/**
	 * toString
	 * 
	 * @return String
	 */
	public String toString() {
		StringBuffer buffer = new StringBuffer();

		buffer.append(getClass().getName()).append("@").append(Integer.toHexString(hashCode())).append(" [");
		buffer.append("clave").append("='").append(getClave()).append("' ");
		buffer.append("]");

		return buffer.toString();
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof EstadoInforme))
			return false;
		EstadoInforme castOther = (EstadoInforme) other;

		return (this.getClave() == castOther.getClave());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getClave();

		return result;
	}

}
