package es.caib.avaedi.at4forms.common.search;

import java.util.ArrayList;
import java.util.List;

public class DatosExportacion {

	private List<String> campos = new ArrayList<String>();
	private List<String> cabeceras = new ArrayList<String>();
	private List<TipoCampoExportacion> tiposCampo = new ArrayList<TipoCampoExportacion>();

	public void add(String campo, String cabecera, TipoCampoExportacion tipoCampo) {
		
		this.campos.add(campo);
		this.cabeceras.add(cabecera);
		this.tiposCampo.add(tipoCampo);
		
	}
	
	/**
	 * Devuelve la lista de cabeceras
	 * 
	 * @return la lista de cabeceras
	 */
	public List<String> getCabeceras() {
		return this.cabeceras;
	}

	/**
	 * Fija la lista de cabeceras
	 * 
	 * @param cabeceras
	 *            la lista de cabeceras
	 */
	public void setCabeceras(List<String> cabeceras) {
		this.cabeceras = cabeceras;
	}

	/**
	 * Devuelve los tipos de campo
	 * 
	 * @return los tipos de campo
	 */
	public List<TipoCampoExportacion> getTiposCampo() {
		return this.tiposCampo;
	}

	/**
	 * Fija los tipos de campo
	 * 
	 * @param tiposCampo
	 *            los tipos de campo
	 */
	public void setTiposCampo(List<TipoCampoExportacion> tiposCampo) {
		this.tiposCampo = tiposCampo;
	}


	public void setCampos(List<String> campos) {
		this.campos = campos;
	}

	public List<String> getCampos() {
		return campos;
	}

}
