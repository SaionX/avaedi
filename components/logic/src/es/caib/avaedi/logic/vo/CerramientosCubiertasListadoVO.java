package es.caib.avaedi.logic.vo;

import java.io.Serializable;
import java.math.BigDecimal;

import org.directwebremoting.annotations.DataTransferObject;

import es.caib.avaedi.at4forms.common.util.FormData2Java;

/**
 * TransferObject para la implementacion del listado CerramientosCubiertas
 */
@DataTransferObject
public class CerramientosCubiertasListadoVO extends InspeccionBaseVO implements java.io.Serializable {

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
	private String carpinteriaVidrioPorcentaje;
	private String carpinteriaVidrioSuperficie;
	/**
	 * (carpinteriavidrio_carpinteriapredominante_texto)
	 */
	private String carpinteriavidrioCarpinteriapredominanteTexto;
	/**
	 * (carpinteriavidrio_vidriopredominante_texto)
	 */
	private String carpinteriavidrioVidriopredominanteTexto;
	private String cubiertaInclinadaPorcentaje;
	private String cubiertaInclinadaSuperficie;
	private String cubiertaPlanaPorcentaje;
	private String cubiertaPlanaSuperficie;
	/**
	 * (cubiertainclinada_aislamientotermico_tipo_id)
	 */
	private Integer cubiertainclinadaAislamientotermicoTipoId;
	/**
	 * (cubiertaplana_aislamientotermico_tipo_id)
	 */
	private Integer cubiertaplanaAislamientotermicoTipoId;
	/**
	 * (cubiertaplana_laminaimpermeabilizante_tipo_id)
	 */
	private Integer cubiertaplanaLaminaimpermeabilizanteTipoId;
	private String fachadaPrincipalPorcentaje;
	private BigDecimal fachadaPrincipalSuperficie;
	/**
	 * (fachadaprincipal_acabadorevestido_porcentaje)
	 */
	private String fachadaprincipalAcabadorevestidoPorcentaje;
	/**
	 * (fachadaprincipal_acabadorevestido_texto)
	 */
	private String fachadaprincipalAcabadorevestidoTexto;
	/**
	 * (fachadaprincipal_acabadovisto_porcentaje)
	 */
	private String fachadaprincipalAcabadovistoPorcentaje;
	/**
	 * (fachadaprincipal_acabadovisto_texto)
	 */
	private String fachadaprincipalAcabadovistoTexto;
	/**
	 * (fachadaprincipal_aislamientotermico_tipo_id)
	 */
	private Integer fachadaprincipalAislamientotermicoTipoId;
	/**
	 * (fachadaprincipal_camaraaire_tipo_id)
	 */
	private Integer fachadaprincipalCamaraaireTipoId;
	private String observaciones;
	private String otrasFachadasPorcentaje;
	private String otrasFachadasSuperficie;
	/**
	 * (otrasfachadas_acabadorevestido_porcentaje)
	 */
	private String otrasfachadasAcabadorevestidoPorcentaje;
	/**
	 * (otrasfachadas_acabadorevestido_texto)
	 */
	private String otrasfachadasAcabadorevestidoTexto;
	/**
	 * (otrasfachadas_acabadovisto_porcentaje)
	 */
	private String otrasfachadasAcabadovistoPorcentaje;
	/**
	 * (otrasfachadas_acabadovisto_texto)
	 */
	private String otrasfachadasAcabadovistoTexto;
	/**
	 * (otrasfachadas_aislamientotermico_tipo_id)
	 */
	private Integer otrasfachadasAislamientotermicoTipoId;
	/**
	 * (otrasfachadas_camaraaire_tipo_id)
	 */
	private Integer otrasfachadasCamaraaireTipoId;

	public CerramientosCubiertasListadoVO() {
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

	public String getCarpinteriaVidrioPorcentaje() {
		return this.carpinteriaVidrioPorcentaje;
	}

	public void setCarpinteriaVidrioPorcentaje(String carpinteriaVidrioPorcentaje) {
		this.carpinteriaVidrioPorcentaje = carpinteriaVidrioPorcentaje;
	}

	public String getCarpinteriaVidrioSuperficie() {
		return this.carpinteriaVidrioSuperficie;
	}

	public void setCarpinteriaVidrioSuperficie(String carpinteriaVidrioSuperficie) {
		this.carpinteriaVidrioSuperficie = carpinteriaVidrioSuperficie;
	}

	/**
	 * * (carpinteriavidrio_carpinteriapredominante_texto)
	 */
	public String getCarpinteriavidrioCarpinteriapredominanteTexto() {
		return this.carpinteriavidrioCarpinteriapredominanteTexto;
	}

	public void setCarpinteriavidrioCarpinteriapredominanteTexto(String carpinteriavidrioCarpinteriapredominanteTexto) {
		this.carpinteriavidrioCarpinteriapredominanteTexto = carpinteriavidrioCarpinteriapredominanteTexto;
	}

	/**
	 * * (carpinteriavidrio_vidriopredominante_texto)
	 */
	public String getCarpinteriavidrioVidriopredominanteTexto() {
		return this.carpinteriavidrioVidriopredominanteTexto;
	}

	public void setCarpinteriavidrioVidriopredominanteTexto(String carpinteriavidrioVidriopredominanteTexto) {
		this.carpinteriavidrioVidriopredominanteTexto = carpinteriavidrioVidriopredominanteTexto;
	}

	public String getCubiertaInclinadaPorcentaje() {
		return this.cubiertaInclinadaPorcentaje;
	}

	public void setCubiertaInclinadaPorcentaje(String cubiertaInclinadaPorcentaje) {
		this.cubiertaInclinadaPorcentaje = cubiertaInclinadaPorcentaje;
	}

	public String getCubiertaInclinadaSuperficie() {
		return this.cubiertaInclinadaSuperficie;
	}

	public void setCubiertaInclinadaSuperficie(String cubiertaInclinadaSuperficie) {
		this.cubiertaInclinadaSuperficie = cubiertaInclinadaSuperficie;
	}

	public String getCubiertaPlanaPorcentaje() {
		return this.cubiertaPlanaPorcentaje;
	}

	public void setCubiertaPlanaPorcentaje(String cubiertaPlanaPorcentaje) {
		this.cubiertaPlanaPorcentaje = cubiertaPlanaPorcentaje;
	}

	public String getCubiertaPlanaSuperficie() {
		return this.cubiertaPlanaSuperficie;
	}

	public void setCubiertaPlanaSuperficie(String cubiertaPlanaSuperficie) {
		this.cubiertaPlanaSuperficie = cubiertaPlanaSuperficie;
	}

	/**
	 * * (cubiertainclinada_aislamientotermico_tipo_id)
	 */
	public Integer getCubiertainclinadaAislamientotermicoTipoId() {
		return this.cubiertainclinadaAislamientotermicoTipoId;
	}

	public void setCubiertainclinadaAislamientotermicoTipoId(Integer cubiertainclinadaAislamientotermicoTipoId) {
		this.cubiertainclinadaAislamientotermicoTipoId = cubiertainclinadaAislamientotermicoTipoId;
	}

	/**
	 * * (cubiertaplana_aislamientotermico_tipo_id)
	 */
	public Integer getCubiertaplanaAislamientotermicoTipoId() {
		return this.cubiertaplanaAislamientotermicoTipoId;
	}

	public void setCubiertaplanaAislamientotermicoTipoId(Integer cubiertaplanaAislamientotermicoTipoId) {
		this.cubiertaplanaAislamientotermicoTipoId = cubiertaplanaAislamientotermicoTipoId;
	}

	/**
	 * * (cubiertaplana_laminaimpermeabilizante_tipo_id)
	 */
	public Integer getCubiertaplanaLaminaimpermeabilizanteTipoId() {
		return this.cubiertaplanaLaminaimpermeabilizanteTipoId;
	}

	public void setCubiertaplanaLaminaimpermeabilizanteTipoId(Integer cubiertaplanaLaminaimpermeabilizanteTipoId) {
		this.cubiertaplanaLaminaimpermeabilizanteTipoId = cubiertaplanaLaminaimpermeabilizanteTipoId;
	}

	public String getFachadaPrincipalPorcentaje() {
		return this.fachadaPrincipalPorcentaje;
	}

	public void setFachadaPrincipalPorcentaje(String fachadaPrincipalPorcentaje) {
		this.fachadaPrincipalPorcentaje = fachadaPrincipalPorcentaje;
	}

	public BigDecimal getFachadaPrincipalSuperficie() {
		return this.fachadaPrincipalSuperficie;
	}

	public void setFachadaPrincipalSuperficie(BigDecimal fachadaPrincipalSuperficie) {
		this.fachadaPrincipalSuperficie = fachadaPrincipalSuperficie;
	}

	/**
	 * * (fachadaprincipal_acabadorevestido_porcentaje)
	 */
	public String getFachadaprincipalAcabadorevestidoPorcentaje() {
		return this.fachadaprincipalAcabadorevestidoPorcentaje;
	}

	public void setFachadaprincipalAcabadorevestidoPorcentaje(String fachadaprincipalAcabadorevestidoPorcentaje) {
		this.fachadaprincipalAcabadorevestidoPorcentaje = fachadaprincipalAcabadorevestidoPorcentaje;
	}

	/**
	 * * (fachadaprincipal_acabadorevestido_texto)
	 */
	public String getFachadaprincipalAcabadorevestidoTexto() {
		return this.fachadaprincipalAcabadorevestidoTexto;
	}

	public void setFachadaprincipalAcabadorevestidoTexto(String fachadaprincipalAcabadorevestidoTexto) {
		this.fachadaprincipalAcabadorevestidoTexto = fachadaprincipalAcabadorevestidoTexto;
	}

	/**
	 * * (fachadaprincipal_acabadovisto_porcentaje)
	 */
	public String getFachadaprincipalAcabadovistoPorcentaje() {
		return this.fachadaprincipalAcabadovistoPorcentaje;
	}

	public void setFachadaprincipalAcabadovistoPorcentaje(String fachadaprincipalAcabadovistoPorcentaje) {
		this.fachadaprincipalAcabadovistoPorcentaje = fachadaprincipalAcabadovistoPorcentaje;
	}

	/**
	 * * (fachadaprincipal_acabadovisto_texto)
	 */
	public String getFachadaprincipalAcabadovistoTexto() {
		return this.fachadaprincipalAcabadovistoTexto;
	}

	public void setFachadaprincipalAcabadovistoTexto(String fachadaprincipalAcabadovistoTexto) {
		this.fachadaprincipalAcabadovistoTexto = fachadaprincipalAcabadovistoTexto;
	}

	/**
	 * * (fachadaprincipal_aislamientotermico_tipo_id)
	 */
	public Integer getFachadaprincipalAislamientotermicoTipoId() {
		return this.fachadaprincipalAislamientotermicoTipoId;
	}

	public void setFachadaprincipalAislamientotermicoTipoId(Integer fachadaprincipalAislamientotermicoTipoId) {
		this.fachadaprincipalAislamientotermicoTipoId = fachadaprincipalAislamientotermicoTipoId;
	}

	/**
	 * * (fachadaprincipal_camaraaire_tipo_id)
	 */
	public Integer getFachadaprincipalCamaraaireTipoId() {
		return this.fachadaprincipalCamaraaireTipoId;
	}

	public void setFachadaprincipalCamaraaireTipoId(Integer fachadaprincipalCamaraaireTipoId) {
		this.fachadaprincipalCamaraaireTipoId = fachadaprincipalCamaraaireTipoId;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getOtrasFachadasPorcentaje() {
		return this.otrasFachadasPorcentaje;
	}

	public void setOtrasFachadasPorcentaje(String otrasFachadasPorcentaje) {
		this.otrasFachadasPorcentaje = otrasFachadasPorcentaje;
	}

	public String getOtrasFachadasSuperficie() {
		return this.otrasFachadasSuperficie;
	}

	public void setOtrasFachadasSuperficie(String otrasFachadasSuperficie) {
		this.otrasFachadasSuperficie = otrasFachadasSuperficie;
	}

	/**
	 * * (otrasfachadas_acabadorevestido_porcentaje)
	 */
	public String getOtrasfachadasAcabadorevestidoPorcentaje() {
		return this.otrasfachadasAcabadorevestidoPorcentaje;
	}

	public void setOtrasfachadasAcabadorevestidoPorcentaje(String otrasfachadasAcabadorevestidoPorcentaje) {
		this.otrasfachadasAcabadorevestidoPorcentaje = otrasfachadasAcabadorevestidoPorcentaje;
	}

	/**
	 * * (otrasfachadas_acabadorevestido_texto)
	 */
	public String getOtrasfachadasAcabadorevestidoTexto() {
		return this.otrasfachadasAcabadorevestidoTexto;
	}

	public void setOtrasfachadasAcabadorevestidoTexto(String otrasfachadasAcabadorevestidoTexto) {
		this.otrasfachadasAcabadorevestidoTexto = otrasfachadasAcabadorevestidoTexto;
	}

	/**
	 * * (otrasfachadas_acabadovisto_porcentaje)
	 */
	public String getOtrasfachadasAcabadovistoPorcentaje() {
		return this.otrasfachadasAcabadovistoPorcentaje;
	}

	public void setOtrasfachadasAcabadovistoPorcentaje(String otrasfachadasAcabadovistoPorcentaje) {
		this.otrasfachadasAcabadovistoPorcentaje = otrasfachadasAcabadovistoPorcentaje;
	}

	/**
	 * * (otrasfachadas_acabadovisto_texto)
	 */
	public String getOtrasfachadasAcabadovistoTexto() {
		return this.otrasfachadasAcabadovistoTexto;
	}

	public void setOtrasfachadasAcabadovistoTexto(String otrasfachadasAcabadovistoTexto) {
		this.otrasfachadasAcabadovistoTexto = otrasfachadasAcabadovistoTexto;
	}

	/**
	 * * (otrasfachadas_aislamientotermico_tipo_id)
	 */
	public Integer getOtrasfachadasAislamientotermicoTipoId() {
		return this.otrasfachadasAislamientotermicoTipoId;
	}

	public void setOtrasfachadasAislamientotermicoTipoId(Integer otrasfachadasAislamientotermicoTipoId) {
		this.otrasfachadasAislamientotermicoTipoId = otrasfachadasAislamientotermicoTipoId;
	}

	/**
	 * * (otrasfachadas_camaraaire_tipo_id)
	 */
	public Integer getOtrasfachadasCamaraaireTipoId() {
		return this.otrasfachadasCamaraaireTipoId;
	}

	public void setOtrasfachadasCamaraaireTipoId(Integer otrasfachadasCamaraaireTipoId) {
		this.otrasfachadasCamaraaireTipoId = otrasfachadasCamaraaireTipoId;
	}

}
