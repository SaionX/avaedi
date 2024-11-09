package es.caib.avaedi.common.model;

// Generated 12-sep-2016 10:10:37

import static javax.persistence.GenerationType.SEQUENCE;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import es.caib.avaedi.at4forms.common.basedao.BaseModel;

/**
 * Arxius binaris
 */
@Entity
@Table(name = "aed_archivo")
public class Blob extends BaseModel implements java.io.Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	/**
	 * Codi de arxiu
	 */
	private long clave;
    /**
     * Nombre del archivo en el filesystem
    */
    private String path;

	public Blob() {
	}

	public Blob(String path) {
	       this.path = path;
	}

	/**
	 * * Codi de arxiu
	 */
	@SequenceGenerator(name = "generator", sequenceName = "AED_ARCHIVO_SEQ", allocationSize = 1)
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "generator")
	@Column(name = "clave", unique = true, nullable = false)
	public long getClave() {
		return this.clave;
	}

	public void setClave(long clave) {
		this.clave = clave;
	}

    /**       
     *      * Nombre del archivo en el filesystem
     */
    
    @Column(name="PATH")
    public String getPath() {
        return this.path;
    }
    
    public void setPath(String path) {
        this.path = path;
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
		if (!(other instanceof Blob))
			return false;
		Blob castOther = (Blob) other;

		return (this.getClave() == castOther.getClave());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getClave();

		return result;
	}

}
