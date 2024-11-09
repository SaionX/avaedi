package es.caib.avaedi.logic.vo;

import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;

import org.apache.commons.lang3.StringEscapeUtils;

import es.caib.avaedi.at4forms.logic.vo.BaseVO;

public class ResultadoImportacionListadoVO extends BaseVO implements java.io.Serializable {

	private static final long serialVersionUID = 3207596504127343362L;


	//private int viaId;
	//private String viaLabel;
	//private String numeroCatastro;
	private int estadoInformeId;
	private String estadoInformeLabel;
	private int claveInforme;
	//private String numeroExtra;
	//private InformeFormVO informe;
	
	private boolean edificioExistia = false;
	private boolean correcto = false;
	private String errorMsg = null;
	private String errorHtml = null;


	private EdificioFormVO[] edificiosDisponibles;
	private EstadoInformeFormVO[] estadoInformeDisponibles;


	public ResultadoImportacionListadoVO(){
		
	}
	
	/*public ResultadoImportacionListadoVO(int viaId, String viaLabel, String numeroCatastro, int estadoInformeId, String estadoInformeLabel, int claveInforme, String numeroExtra, boolean edificioExistia) {
		super();
		this.viaId = viaId;
		this.viaLabel = viaLabel;
		this.numeroCatastro = numeroCatastro;
		this.estadoInformeId = estadoInformeId;
		this.estadoInformeLabel = estadoInformeLabel;
		this.claveInforme = claveInforme;
		this.numeroExtra = numeroExtra;
		this.edificioExistia = edificioExistia;
		this.correcto = true;
		this.errorMsg = null;
	}*/

	
	public ResultadoImportacionListadoVO(EdificioFormVO[] edificioResult, EstadoInformeFormVO[] estadoInformes, InformeFormVO informe, boolean edificioExistia) {
		super();
		this.setEdificiosDisponibles(edificioResult);
		this.setEstadoInformeDisponibles(estadoInformes);
		this.estadoInformeId = informe.getEstadoInformeId();
		this.estadoInformeLabel = informe.getEstadoInformeLabel();
		this.claveInforme = informe.getClave();
		this.edificioExistia = edificioExistia;
	}
	
	public void addException(Exception ex){
		StringWriter errors = new StringWriter();
		ex.printStackTrace(new PrintWriter(errors));
		this.setErrorHtml(StringEscapeUtils.escapeHtml4(errors.toString()));
	}

	public boolean isEdificioExistia() {
		return edificioExistia;
	}

	public void setEdificioExistia(boolean edificioExistia) {
		this.edificioExistia = edificioExistia;
	}

	@Override
	public Serializable getPrimaryKey() {
		return this.getClaveInforme();
	}

	@Override
	public String getPrimaryLabel() {
		return this.getEstadoInformeLabel();
	}

	public void setCorrecto(boolean correcto) {
		this.correcto = correcto;
	}

	public boolean isCorrecto() {
		return correcto;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

/*	public int getViaId() {
		return viaId;
	}

	public void setViaId(int viaId) {
		this.viaId = viaId;
	}

	public String getViaLabel() {
		return viaLabel;
	}

	public void setViaLabel(String viaLabel) {
		this.viaLabel = viaLabel;
	}

	public String getNumeroCatastro() {
		return numeroCatastro;
	}

	public void setNumeroCatastro(String numeroCatastro) {
		this.numeroCatastro = numeroCatastro;
	}
	
	
	public void setNumeroExtra(String numeroExtra) {
		this.numeroExtra = numeroExtra;
	}

	public String getNumeroExtra() {
		return numeroExtra;
	}
*/
	public int getEstadoInformeId() {
		return estadoInformeId;
	}

	public void setEstadoInformeId(int estadoInformeId) {
		this.estadoInformeId = estadoInformeId;
	}

	public String getEstadoInformeLabel() {
		return estadoInformeLabel;
	}

	public void setEstadoInformeLabel(String estadoInformeLabel) {
		this.estadoInformeLabel = estadoInformeLabel;
	}

	public int getClaveInforme() {
		return claveInforme;
	}

	public void setClaveInforme(int claveInforme) {
		this.claveInforme = claveInforme;
	}

	public void setErrorHtml(String errorHtml) {
		this.errorHtml = errorHtml;
	}

	public String getErrorHtml() {
		return errorHtml;
	}

	public EstadoInformeFormVO[] getEstadoInformeDisponibles() {
		return estadoInformeDisponibles;
	}

	public void setEstadoInformeDisponibles(EstadoInformeFormVO[] estadoInformeDisponibles) {
		this.estadoInformeDisponibles = estadoInformeDisponibles;
	}

	public EdificioFormVO[] getEdificiosDisponibles() {
		return edificiosDisponibles;
	}

	public void setEdificiosDisponibles(EdificioFormVO[] edificiosDisponibles) {
		this.edificiosDisponibles = edificiosDisponibles;
	}


}
