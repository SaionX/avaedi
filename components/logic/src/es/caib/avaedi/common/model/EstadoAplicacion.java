package es.caib.avaedi.common.model;

// Generated 12-sep-2016 10:10:37

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import es.caib.avaedi.at4forms.common.basedao.BaseModel;

/**
 * Almacena atributos de estado de la aplicación (filtros activos, columnas,
 * etc) por usuario
 */
@Entity
@Table(name = "aed_estado_aplicacion")
public class EstadoAplicacion extends BaseModel implements java.io.Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	private EstadoAplicacionId id;
	private String valor;

	public EstadoAplicacion() {
	}

	public EstadoAplicacion(EstadoAplicacionId id) {
		this.id = id;
	}

	public EstadoAplicacion(EstadoAplicacionId id, String valor) {
		this.id = id;
		this.valor = valor;
	}

	@EmbeddedId
	@AttributeOverrides({ @AttributeOverride(name = "username", column = @Column(name = "username", nullable = false, length = 32)), @AttributeOverride(name = "nombre", column = @Column(name = "nombre", nullable = false)) })
	public EstadoAplicacionId getId() {
		return this.id;
	}

	public void setId(EstadoAplicacionId id) {
		this.id = id;
	}

	@Column(name = "valor")
	public String getValor() {
		return this.valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	/**
	 * toString
	 * 
	 * @return String
	 */
	public String toString() {
		StringBuffer buffer = new StringBuffer();

		buffer.append(getClass().getName()).append("@").append(Integer.toHexString(hashCode())).append(" [");
		buffer.append("id").append("='").append(getId()).append("' ");
		buffer.append("]");

		return buffer.toString();
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof EstadoAplicacion))
			return false;
		EstadoAplicacion castOther = (EstadoAplicacion) other;

		return ((this.getId() == castOther.getId()) || (this.getId() != null && castOther.getId() != null && this.getId().equals(castOther.getId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());

		return result;
	}

}
