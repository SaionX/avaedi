/**
 *
 */
package es.caib.avaedi.at4forms.common.search;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Transformer;
import org.directwebremoting.annotations.DataTransferObject;

/** Transfer Object que contendrá el resultado de una búsqueda paginada
 * @author agarcia
 */
@DataTransferObject
public class ResultadoBusqueda<T> implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -5582328230300652139L;

    /**
     * El número total de registros
     */
    private long totalNumRecords = 0;

    /**
     * indica si se ha producido un error
     */
    private boolean error = false;

    /** Identificador del error
     */
    private int errorId;

    /**
     * Mensaje de error
     */
    private String msg;

    private Map<String, Object> aggregates = new HashMap<String, Object>();

	public ResultadoBusqueda() {}

	/**
	 * Construye un resultado a partir de otro, usando un transformer para los resultados
	 * @param <D>
	 * @param daoResult
	 * @param transformer
	 */
	public <D> ResultadoBusqueda(ResultadoBusqueda<D> daoResult, Transformer<D, T> transformer) {
		this.resultados = CollectionUtils.collect(daoResult.getResultados(), transformer );
		this.setErrorId(daoResult.getErrorId());
		this.setMsg(daoResult.getMsg());
		this.setTotalNumRecords(daoResult.getTotalNumRecords());
		this.setAggregates(daoResult.getAggregates());
	}
	

	/**
	 * Construye un resultado a una lista, usando un transformer para los resultados
	 * @param <D>
	 * @param daoResult
	 * @param transformer
	 */
	public <D> ResultadoBusqueda(List<D> datos, Transformer<D, T> transformer) {
		this.setResultados(CollectionUtils.collect(datos, transformer));
		this.setTotalNumRecords(datos.size());
	}
	
	
	public ResultadoBusqueda(List<T> datos, int size) {
		this.setResultados(datos);
		this.setTotalNumRecords(size);
	}

	public ResultadoBusqueda(List<T> datos) {
		if (datos != null) {
			this.setResultados(datos);
			this.setTotalNumRecords(datos.size());
		}
	}


	/**
	 * Resultados de la búsqueda. Contendrá una sola página de resultados.
	 */
    private Collection<T> resultados;

	public long getTotalNumRecords() {
		return this.totalNumRecords;
	}

	/** Fija totalNumRecords
	 * @param totalNumRecords
	 */
	public void setTotalNumRecords(long totalNumRecords) {
		this.totalNumRecords = totalNumRecords;
	}

	public boolean isError() {
		return this.error;
	}

	/** Fija error
	 * @param error
	 */
	public void setError(boolean error) {
		this.error = error;
	}

	public int getErrorId() {
		return this.errorId;
	}

	/** Fija errorId
	 * @param errorId
	 */
	public void setErrorId(int errorId) {
		this.errorId = errorId;
	}

	public String getMsg() {
		return this.msg;
	}

	/** Fija el mensaje de error
	 * @param msg el mensaje de error
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Collection<T> getResultados() {
		return this.resultados;
	}

	/** Fija los resultados
	 * @param resultados los resultados
	 */
	public void setResultados(Collection<T> resultados) {
		this.resultados = resultados;
	}

	public void addAggregate(String field, Object object) {
		this.aggregates.put(field, object);
		
	}
	
	public Map<String, Object> getAggregates() {
		return this.aggregates;
	}

	public void setAggregates(Map<String, Object> aggregates) {
		this.aggregates = aggregates;
	}

}
