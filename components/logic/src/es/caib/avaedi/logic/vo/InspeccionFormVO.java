package es.caib.avaedi.logic.vo;

import java.util.Set;

import org.directwebremoting.annotations.DataTransferObject;

import es.caib.avaedi.at4forms.logic.vo.FormVO;

/**
 * TransferObject para el formulario Inspeccion
 */
@DataTransferObject
public class InspeccionFormVO extends InspeccionListadoVO implements FormVO {

	private static final long serialVersionUID = 1L;

	private Set<DeficienciaListadoVO> deficiencias;
	private Set<ValorListadoVO> valores;
	private Set<FechaVisitaListadoVO> fechasVisitas;
  	private Set<AcusticaMejorasAcusticasListadoVO> acusticaMejorasAcusticas;
	private Set<ValoracionParcialListadoVO> valoracionesParciales;
	private Set<DocumentacionOtroListadoVO> documentacionOtros;
	private Set<HistoricoListadoVO> historicos;

	public InspeccionFormVO() {
	}

	public Set<FechaVisitaListadoVO> getFechasVisitas() {
		return this.fechasVisitas;
	}

	public void setFechasVisitas(Set<FechaVisitaListadoVO> fechasVisitas) {
		this.fechasVisitas = fechasVisitas;
	}

	public Set<ValoracionParcialListadoVO> getValoracionesParciales() {
		return this.valoracionesParciales;
	}

	public void setValoracionesParciales(Set<ValoracionParcialListadoVO> valoracionesParciales) {
		this.valoracionesParciales = valoracionesParciales;
	}

	public Set<DocumentacionOtroListadoVO> getDocumentacionOtros() {
		return this.documentacionOtros;
	}

	public void setDocumentacionOtros(Set<DocumentacionOtroListadoVO> documentacionOtros) {
		this.documentacionOtros = documentacionOtros;
	}

	public Set<DeficienciaListadoVO> getDeficiencias() {
		return this.deficiencias;
	}

	public void setDeficiencias(Set<DeficienciaListadoVO> deficiencias) {
		this.deficiencias = deficiencias;
	}

	public Set<ValorListadoVO> getValores() {
		return this.valores;
	}

	public void setValores(Set<ValorListadoVO> valores) {
		this.valores = valores;
	}

    public Set<AcusticaMejorasAcusticasListadoVO> getAcusticaMejorasAcusticas() {
        return this.acusticaMejorasAcusticas;
    }
    
    public void setAcusticaMejorasAcusticas(Set<AcusticaMejorasAcusticasListadoVO> acusticaMejorasAcusticas) {
        this.acusticaMejorasAcusticas = acusticaMejorasAcusticas;
    }

    public Set<HistoricoListadoVO> getHistoricos() {
		return this.historicos;
	}

	public void setHistoricos(Set<HistoricoListadoVO> historicos) {
		this.historicos = historicos;
	}

}
