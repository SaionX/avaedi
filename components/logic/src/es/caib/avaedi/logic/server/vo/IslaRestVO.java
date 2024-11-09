package es.caib.avaedi.logic.server.vo;

import java.io.Serializable;

import es.caib.avaedi.logic.vo.IslaFormVO;
import es.caib.avaedi.logic.vo.IslaListadoVO;

public class IslaRestVO extends RestBaseVO {
	private int id;
	private String nombre;

	public IslaRestVO(IslaFormVO islaraw) {
		super();
		this.id = islaraw.getId();
		this.nombre = islaraw.getNombre();
		this.lastModified = islaraw.getLastModified();
	}

	public IslaRestVO(IslaListadoVO islaraw) {
		super();
		this.id = islaraw.getId();
		this.nombre = islaraw.getNombre();
		this.lastModified = islaraw.getLastModified();
	}

	public IslaRestVO() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public Serializable getPrimaryKey() {
		return this.getId();
	}

}
