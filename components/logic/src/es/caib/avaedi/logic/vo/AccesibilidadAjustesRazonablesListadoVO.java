package es.caib.avaedi.logic.vo;

import java.io.Serializable;

import org.directwebremoting.annotations.DataTransferObject;

import es.caib.avaedi.at4forms.common.util.FormData2Java;

/**
 * TransferObject para la implementacion del listado
 * AccesibilidadAjustesRazonables
 */
@DataTransferObject
public class AccesibilidadAjustesRazonablesListadoVO extends InspeccionBaseVO implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public Serializable getPrimaryKey() {
		return this.getClaveInforme();
	}

	@Override
	public String getPrimaryLabel() {
		return FormData2Java.toString(this.getClaveInforme());
	}

	private int claveInforme;
	private String inspeccionLabel;
	private int inspeccionId;
	private String ajustesrazonablesCoste;
	private String ajustesrazonablesDescripcion;
	private Integer edificionosusceptibleajustes;
	/**
	 * edificiosusceptibleajustes_total
	 */
	private Integer edificiosusceptibleajustesTotal;
	private String financiacionayuda;
	private String importegastoscomunes;
	/**
	 * observaciones_analisis_no_medidas
	 */
	private String observacionesAnalisisNoMedidas;
	private String observacionesCargaeconomica;
	/**
	 * observaciones_consideracionesinmueble
	 */
	private String observacionesConsideracionesinmueble;
	private String personasdiscapacitadasomayores;
	/**
	 * viviendasnoitinerarioaccesible
	 */
	private String viviendasnoitinerarioaccesible;

	public AccesibilidadAjustesRazonablesListadoVO() {
	}

	public int getClaveInforme() {
		return this.claveInforme;
	}

	public void setClaveInforme(int claveInforme) {
		this.claveInforme = claveInforme;
	}

	public String getInspeccionLabel() {
		return this.inspeccionLabel;
	}

	public void setInspeccionLabel(String inspeccionLabel) {
		this.inspeccionLabel = inspeccionLabel;
	}

	public int getInspeccionId() {
		return this.inspeccionId;
	}

	public void setInspeccionId(int inspeccionId) {
		this.inspeccionId = inspeccionId;
	}

	public String getAjustesrazonablesCoste() {
		return this.ajustesrazonablesCoste;
	}

	public void setAjustesrazonablesCoste(String ajustesrazonablesCoste) {
		this.ajustesrazonablesCoste = ajustesrazonablesCoste;
	}

	public String getAjustesrazonablesDescripcion() {
		return this.ajustesrazonablesDescripcion;
	}

	public void setAjustesrazonablesDescripcion(String ajustesrazonablesDescripcion) {
		this.ajustesrazonablesDescripcion = ajustesrazonablesDescripcion;
	}

	public Integer getEdificionosusceptibleajustes() {
		return this.edificionosusceptibleajustes;
	}

	public void setEdificionosusceptibleajustes(Integer edificionosusceptibleajustes) {
		this.edificionosusceptibleajustes = edificionosusceptibleajustes;
	}

	/**
	 * * edificiosusceptibleajustes_total
	 */
	public Integer getEdificiosusceptibleajustesTotal() {
		return this.edificiosusceptibleajustesTotal;
	}

	public void setEdificiosusceptibleajustesTotal(Integer edificiosusceptibleajustesTotal) {
		this.edificiosusceptibleajustesTotal = edificiosusceptibleajustesTotal;
	}

	public String getFinanciacionayuda() {
		return this.financiacionayuda;
	}

	public void setFinanciacionayuda(String financiacionayuda) {
		this.financiacionayuda = financiacionayuda;
	}

	public String getImportegastoscomunes() {
		return this.importegastoscomunes;
	}

	public void setImportegastoscomunes(String importegastoscomunes) {
		this.importegastoscomunes = importegastoscomunes;
	}

	/**
	 * * observaciones_analisis_no_medidas
	 */
	public String getObservacionesAnalisisNoMedidas() {
		return this.observacionesAnalisisNoMedidas;
	}

	public void setObservacionesAnalisisNoMedidas(String observacionesAnalisisNoMedidas) {
		this.observacionesAnalisisNoMedidas = observacionesAnalisisNoMedidas;
	}

	public String getObservacionesCargaeconomica() {
		return this.observacionesCargaeconomica;
	}

	public void setObservacionesCargaeconomica(String observacionesCargaeconomica) {
		this.observacionesCargaeconomica = observacionesCargaeconomica;
	}

	/**
	 * * observaciones_consideracionesinmueble
	 */
	public String getObservacionesConsideracionesinmueble() {
		return this.observacionesConsideracionesinmueble;
	}

	public void setObservacionesConsideracionesinmueble(String observacionesConsideracionesinmueble) {
		this.observacionesConsideracionesinmueble = observacionesConsideracionesinmueble;
	}

	public String getPersonasdiscapacitadasomayores() {
		return this.personasdiscapacitadasomayores;
	}

	public void setPersonasdiscapacitadasomayores(String personasdiscapacitadasomayores) {
		this.personasdiscapacitadasomayores = personasdiscapacitadasomayores;
	}

	/**
	 * * viviendasnoitinerarioaccesible
	 */
	public String getViviendasnoitinerarioaccesible() {
		return this.viviendasnoitinerarioaccesible;
	}

	public void setViviendasnoitinerarioaccesible(String viviendasnoitinerarioaccesible) {
		this.viviendasnoitinerarioaccesible = viviendasnoitinerarioaccesible;
	}

}
