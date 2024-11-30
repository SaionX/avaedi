package es.caib.avaedi.logic.vo;

import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import es.caib.avaedi.at4forms.common.util.Constants;
import es.caib.avaedi.logic.bo.TipusIee;
import org.directwebremoting.annotations.DataTransferObject;

import es.caib.avaedi.at4forms.logic.vo.FormVO;

/**
 * TransferObject para el formulario Edificio
 */
@DataTransferObject
public class EdificioFormVO extends EdificioListadoVO implements FormVO {

	private static final long serialVersionUID = 1L;

	private Set<InformeListadoVO> informes;

	public EdificioFormVO() {
	}

	public Set<InformeListadoVO> getInformes() {
		return this.informes;
	}

	public void setInformes(Set<InformeListadoVO> informes) {
		this.informes = informes;
	}

	public Integer getAnyUltimInformeFavorable() {
		Date ultimInformeFavorable = getUltimInformeFavorable();
		if (ultimInformeFavorable == null) {
			return getAntiguedad();
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(ultimInformeFavorable);
		return calendar.get(Calendar.YEAR);
	}

	private Date getUltimInformeFavorable() {
		if (this.informes == null || this.informes.size() == 0) {
			return null;
		}

		Date dataRecent = null;

		for (InformeListadoVO informe : this.informes) {
			if (informe.getEstadoInformeId() == Constants.ESTADO_INFORME_FAVORABLE) {
				Date dataInforme = informe.getFechaInforme();
				if (dataRecent == null || (dataInforme != null && dataInforme.after(dataRecent))) {
					dataRecent = dataInforme;
				}
			}
		}

		return dataRecent;
	}

	public Integer getEstatUltimInforme() {
		if (this.informes == null || this.informes.size() == 0) {
			return null;
		}

		Date dataRecent = null;
		Integer estatRecent = null;

		for (InformeListadoVO informe : this.informes) {
			Date dataInforme = informe.getFechaInforme();
			if (dataRecent == null || (dataInforme != null && dataInforme.after(dataRecent))) {
				dataRecent = dataInforme;
				estatRecent = informe.getEstadoInformeId();
			}
		}

		return estatRecent;
	}

	public TipusIee getTipusIeeUltimInforme() {
		if (this.informes == null || this.informes.size() == 0) {
			return null;
		}

		InformeListadoVO ultimInforme = getUltimInforme();
		return ultimInforme.getTipusIee();
	}

	public InformeListadoVO getUltimInforme() {
		if (this.informes == null || this.informes.size() == 0) {
			return null;
		}

		InformeListadoVO ultimInforme = null;
		for (InformeListadoVO informe : this.informes) {
			if (ultimInforme == null || informe.getFechaInforme().after(ultimInforme.getFechaInforme())) {
				ultimInforme = informe;
			}
		}

		return ultimInforme;
	}

}
