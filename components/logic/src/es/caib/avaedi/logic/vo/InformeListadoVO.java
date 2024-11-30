package es.caib.avaedi.logic.vo;

import java.io.Serializable;
import java.util.Date;

import es.caib.avaedi.logic.bo.TipusIee;
import org.directwebremoting.annotations.DataTransferObject;

import es.caib.avaedi.at4forms.common.util.FormData2Java;
import es.caib.avaedi.at4forms.logic.vo.BaseVO;

/**
 * TransferObject para la implementacion del listado Informe
 */
@DataTransferObject
public class InformeListadoVO extends BaseVO implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public Serializable getPrimaryKey() {
		return this.getClave();
	}

	@Override
	public String getPrimaryLabel() {
		return FormData2Java.toString(this.getClave());
	}

	private int clave;
	private String estadoInformeLabel;
	private int estadoInformeId;
	private String edificioLabel;
	private int edificioId;
	private Date fechaInforme;
	private Date fechaAlta;
	/**
	 * Codi de arxiu del document
	 */
	private Long ieeArxiu;
	/**
	 * Mime del document
	 */
	private String ieeArxiuMime;
	/**
	 * Codi de arxiu del document
	 */
	private Long pdfArxiu;
	/**
	 * Mime del document
	 */
	private String pdfArxiuMime;
	private String inspeccionLabel;
	private int inspeccionId;

	public InformeListadoVO() {
	}

	public int getClave() {
		return this.clave;
	}

	public void setClave(int clave) {
		this.clave = clave;
	}

	public String getEstadoInformeLabel() {
		return this.estadoInformeLabel;
	}

	public void setEstadoInformeLabel(String estadoInformeLabel) {
		this.estadoInformeLabel = estadoInformeLabel;
	}

	public int getEstadoInformeId() {
		return this.estadoInformeId;
	}

	public void setEstadoInformeId(int estadoInformeId) {
		this.estadoInformeId = estadoInformeId;
	}

	public String getEdificioLabel() {
		return this.edificioLabel;
	}

	public void setEdificioLabel(String edificioLabel) {
		this.edificioLabel = edificioLabel;
	}

	public int getEdificioId() {
		return this.edificioId;
	}

	public void setEdificioId(int edificioId) {
		this.edificioId = edificioId;
	}

	public Date getFechaInforme() {
		return this.fechaInforme;
	}

	public void setFechaInforme(Date fechaInforme) {
		this.fechaInforme = fechaInforme;
	}

	public Date getFechaAlta() {
		return this.fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	/**
	 * * Codi de arxiu del document
	 */
	public Long getIeeArxiu() {
		return this.ieeArxiu;
	}

	public void setIeeArxiu(Long ieeArxiu) {
		this.ieeArxiu = ieeArxiu;
	}

	/**
	 * * Mime del document
	 */
	public String getIeeArxiuMime() {
		return this.ieeArxiuMime;
	}

	public void setIeeArxiuMime(String ieeArxiuMime) {
		this.ieeArxiuMime = ieeArxiuMime;
	}

	/**
	 * * Codi de arxiu del document
	 */
	public Long getPdfArxiu() {
		return this.pdfArxiu;
	}

	public void setPdfArxiu(Long pdfArxiu) {
		this.pdfArxiu = pdfArxiu;
	}

	/**
	 * * Mime del document
	 */
	public String getPdfArxiuMime() {
		return this.pdfArxiuMime;
	}

	public void setPdfArxiuMime(String pdfArxiuMime) {
		this.pdfArxiuMime = pdfArxiuMime;
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

	//Campos extra
	private String municipioLabel;
	private int municipioId;

	public String getMunicipioLabel() {
		return this.municipioLabel;
	}

	public void setMunicipioLabel(String municipioLabel) {
		this.municipioLabel = municipioLabel;
	}

	public int getMunicipioId() {
		return this.municipioId;
	}

	public void setMunicipioId(int municipioId) {
		this.municipioId = municipioId;
	}


	private String ieeArxiuMimeType;
	private TipusIee tipusIee;
	private Boolean renovacio;
	private Boolean subsana;

	public String getIeeArxiuMimeType() {
		return this.ieeArxiuMimeType;
	}
	public void setIeeArxiuMimeType(String ieeArxiuMimeType) {
		this.ieeArxiuMimeType = ieeArxiuMimeType;
	}

	public TipusIee getTipusIee() {
		return tipusIee;
	}
	public void setTipusIee(TipusIee tipusIee) {
		this.tipusIee = tipusIee;
	}

	public void setTipusIee(String tipusIee) {
		this.tipusIee = TipusIee.fromString(tipusIee);
	}
	public Boolean getRenovacio() {
		return renovacio;
	}

	public void setRenovacio(Boolean renovacio) {
		this.renovacio = renovacio;
	}
	public Boolean getSubsana() {
		return subsana;
	}

	public void setSubsana(Boolean subsana) {
		this.subsana = subsana;
	}
}
