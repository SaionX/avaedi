package es.caib.avaedi.logic.vo;

import org.directwebremoting.annotations.DataTransferObject;

import es.caib.avaedi.at4forms.logic.vo.FormVO;

/**
 * TransferObject para el formulario Blob
 */
@DataTransferObject
public class BlobFormVO extends BlobListadoVO implements FormVO {

	private static final long serialVersionUID = 1L;

	public BlobFormVO() {
	}

	private byte[] datos;

	public byte[] getDatos() {
		return datos;
	}




	public void setDatos(byte[] buffer) {
		this.datos = buffer;
		
	}

	
}
