package es.caib.avaedi.common.model;

// Generated 21-sep-2016 17:21:16

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import es.caib.avaedi.at4forms.common.basedao.BaseModel;

/**
 * Caracteristica generated by hbm2java
 */
@Entity
@Table(name = "aed_caracteristica")
public class Caracteristica extends BaseModel implements java.io.Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	private String caracteristica;
	private GrupoCaracteristicas grupoCaracteristicas;
	private String nombreEs;
	private String nombreCa;
	private Set<Valor> valores = new HashSet<Valor>(0);

	public Caracteristica() {
	}

	public Caracteristica(String caracteristica, GrupoCaracteristicas grupoCaracteristicas, String nombreEs) {
		this.caracteristica = caracteristica;
		this.grupoCaracteristicas = grupoCaracteristicas;
		this.nombreEs = nombreEs;
	}

	public Caracteristica(String caracteristica, GrupoCaracteristicas grupoCaracteristicas, String nombreEs, String nombreCa, Set<Valor> valores) {
		this.caracteristica = caracteristica;
		this.grupoCaracteristicas = grupoCaracteristicas;
		this.nombreEs = nombreEs;
		this.nombreCa = nombreCa;
		this.valores = valores;
	}

	@Id
	@Column(name = "caracteristica", unique = true, nullable = false)
	public String getCaracteristica() {
		return this.caracteristica;
	}

	public void setCaracteristica(String caracteristica) {
		this.caracteristica = caracteristica;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_g_caracteristicas", nullable = false)
	public GrupoCaracteristicas getGrupoCaracteristicas() {
		return this.grupoCaracteristicas;
	}

	public void setGrupoCaracteristicas(GrupoCaracteristicas grupoCaracteristicas) {
		this.grupoCaracteristicas = grupoCaracteristicas;
	}

	@Column(name = "nombre_es", nullable = false)
	public String getNombreEs() {
		return this.nombreEs;
	}

	public void setNombreEs(String nombreEs) {
		this.nombreEs = nombreEs;
	}

	@Column(name = "nombre_ca")
	public String getNombreCa() {
		return this.nombreCa;
	}

	public void setNombreCa(String nombreCa) {
		this.nombreCa = nombreCa;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "caracteristica")
	public Set<Valor> getValores() {
		return this.valores;
	}

	public void setValores(Set<Valor> valores) {
		this.valores = valores;
	}

	/**
	 * toString
	 * 
	 * @return String
	 */
	public String toString() {
		StringBuffer buffer = new StringBuffer();

		buffer.append(getClass().getName()).append("@").append(Integer.toHexString(hashCode())).append(" [");
		buffer.append("caracteristica").append("='").append(getCaracteristica()).append("' ");
		buffer.append("]");

		return buffer.toString();
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof Caracteristica))
			return false;
		Caracteristica castOther = (Caracteristica) other;

		return ((this.getCaracteristica() == castOther.getCaracteristica()) || (this.getCaracteristica() != null && castOther.getCaracteristica() != null && this.getCaracteristica().equals(castOther.getCaracteristica())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getCaracteristica() == null ? 0 : this.getCaracteristica().hashCode());

		return result;
	}

}