package es.caib.avaedi.at4forms.common.search;

import java.util.List;

/**
 * Resultado para una exportación a formato texto (xls, csv, ...)
 * 
 * @author agarcia
 * 
 */
public class ResultadoExportacion extends DatosExportacion {

	/**
	 *
	 */
	private static final long serialVersionUID = -6028072045917607916L;

	public ResultadoExportacion() {
	}

	public ResultadoExportacion(DatosExportacion datos) {
		this.setCabeceras(datos.getCabeceras());
		this.setTiposCampo(datos.getTiposCampo());
		this.setCampos(datos.getCampos());
	}

	/**
	 * Resultados de la búsqueda
	 */
	private List<List<String>> resultados;

	/**
	 * Devuelve la lista de registros
	 * 
	 * @return la lista de registros
	 */
	public List<List<String>> getResultados() {
		return this.resultados;
	}

	/**
	 * Fija la lista de registros
	 * 
	 * @param resultados
	 *            la lista de registros
	 */
	public void setResultados(List<List<String>> resultados) {
		this.resultados = resultados;
	}

}
