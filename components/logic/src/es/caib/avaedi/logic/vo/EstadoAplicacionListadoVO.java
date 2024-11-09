package es.caib.avaedi.logic.vo;

import java.io.Serializable;

import org.directwebremoting.annotations.DataTransferObject;

import es.caib.avaedi.at4forms.logic.vo.BaseVO;
import es.caib.avaedi.common.model.EstadoAplicacionId;

/**
 * TransferObject para la implementacion del listado EstadoAplicacion
 */
@DataTransferObject
public class EstadoAplicacionListadoVO extends BaseVO implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public Serializable getPrimaryKey() {
		return this.getId();
	}

	@Override
	public String getPrimaryLabel() {
		return this.getId().toString();
	}

	private EstadoAplicacionId id;
	private String valor;

	public EstadoAplicacionListadoVO() {
	}

	public EstadoAplicacionId getId() {
		return this.id;
	}

	public void setId(EstadoAplicacionId id) {
		this.id = id;
	}

	public String getValor() {
		return this.valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

}
