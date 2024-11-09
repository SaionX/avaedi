package es.caib.avaedi.logic.vo;

import java.io.Serializable;

import org.directwebremoting.annotations.DataTransferObject;

import es.caib.avaedi.at4forms.common.util.FormData2Java;
import es.caib.avaedi.at4forms.logic.vo.BaseVO;

/**
 * TransferObject para la implementacion del listado Blob
 */
@DataTransferObject
public class BlobListadoVO extends BaseVO implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public Serializable getPrimaryKey() {
		return this.getClave();
	}

	@Override
	public String getPrimaryLabel() {
		return FormData2Java.toString(this.getClave());
	}

	/**
	 * Codi de arxiu
	 */
	private long clave;
    /**
     * Nombre del archivo en el filesystem
    */
    private String path;

	public BlobListadoVO() {
	}

	/**
	 * * Codi de arxiu
	 */
	public long getClave() {
		return this.clave;
	}

	public void setClave(long clave) {
		this.clave = clave;
	}

    /**       
     *      * Nombre del archivo en el filesystem
     */
    public String getPath() {
        return this.path;
    }
    
    public void setPath(String path) {
        this.path = path;
    }

}
