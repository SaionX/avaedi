package es.caib.avaedi.common.model;

// Generated 21-sep-2016 17:21:16

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import es.caib.avaedi.at4forms.common.basedao.BaseModel;

/**
 * CerramientosCubiertas generated by hbm2java
 */
@Entity
@Table(name = "aed_cerrami_cubier")
public class CerramientosCubiertas extends BaseModel implements java.io.Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	private int claveInforme;
	private Inspeccion inspeccion;
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

	public CerramientosCubiertas() {
	}

	public CerramientosCubiertas(Inspeccion inspeccion) {
		this.inspeccion = inspeccion;
	}

	public CerramientosCubiertas(Inspeccion inspeccion, String carpinteriaVidrioPorcentaje, String carpinteriaVidrioSuperficie, String carpinteriavidrioCarpinteriapredominanteTexto, String carpinteriavidrioVidriopredominanteTexto, String cubiertaInclinadaPorcentaje, String cubiertaInclinadaSuperficie, String cubiertaPlanaPorcentaje, String cubiertaPlanaSuperficie, Integer cubiertainclinadaAislamientotermicoTipoId, Integer cubiertaplanaAislamientotermicoTipoId, Integer cubiertaplanaLaminaimpermeabilizanteTipoId, String fachadaPrincipalPorcentaje, BigDecimal fachadaPrincipalSuperficie, String fachadaprincipalAcabadorevestidoPorcentaje, String fachadaprincipalAcabadorevestidoTexto, String fachadaprincipalAcabadovistoPorcentaje, String fachadaprincipalAcabadovistoTexto, Integer fachadaprincipalAislamientotermicoTipoId, Integer fachadaprincipalCamaraaireTipoId, String observaciones, String otrasFachadasPorcentaje, String otrasFachadasSuperficie, String otrasfachadasAcabadorevestidoPorcentaje, String otrasfachadasAcabadorevestidoTexto, String otrasfachadasAcabadovistoPorcentaje, String otrasfachadasAcabadovistoTexto, Integer otrasfachadasAislamientotermicoTipoId, Integer otrasfachadasCamaraaireTipoId) {
		this.inspeccion = inspeccion;
		this.carpinteriaVidrioPorcentaje = carpinteriaVidrioPorcentaje;
		this.carpinteriaVidrioSuperficie = carpinteriaVidrioSuperficie;
		this.carpinteriavidrioCarpinteriapredominanteTexto = carpinteriavidrioCarpinteriapredominanteTexto;
		this.carpinteriavidrioVidriopredominanteTexto = carpinteriavidrioVidriopredominanteTexto;
		this.cubiertaInclinadaPorcentaje = cubiertaInclinadaPorcentaje;
		this.cubiertaInclinadaSuperficie = cubiertaInclinadaSuperficie;
		this.cubiertaPlanaPorcentaje = cubiertaPlanaPorcentaje;
		this.cubiertaPlanaSuperficie = cubiertaPlanaSuperficie;
		this.cubiertainclinadaAislamientotermicoTipoId = cubiertainclinadaAislamientotermicoTipoId;
		this.cubiertaplanaAislamientotermicoTipoId = cubiertaplanaAislamientotermicoTipoId;
		this.cubiertaplanaLaminaimpermeabilizanteTipoId = cubiertaplanaLaminaimpermeabilizanteTipoId;
		this.fachadaPrincipalPorcentaje = fachadaPrincipalPorcentaje;
		this.fachadaPrincipalSuperficie = fachadaPrincipalSuperficie;
		this.fachadaprincipalAcabadorevestidoPorcentaje = fachadaprincipalAcabadorevestidoPorcentaje;
		this.fachadaprincipalAcabadorevestidoTexto = fachadaprincipalAcabadorevestidoTexto;
		this.fachadaprincipalAcabadovistoPorcentaje = fachadaprincipalAcabadovistoPorcentaje;
		this.fachadaprincipalAcabadovistoTexto = fachadaprincipalAcabadovistoTexto;
		this.fachadaprincipalAislamientotermicoTipoId = fachadaprincipalAislamientotermicoTipoId;
		this.fachadaprincipalCamaraaireTipoId = fachadaprincipalCamaraaireTipoId;
		this.observaciones = observaciones;
		this.otrasFachadasPorcentaje = otrasFachadasPorcentaje;
		this.otrasFachadasSuperficie = otrasFachadasSuperficie;
		this.otrasfachadasAcabadorevestidoPorcentaje = otrasfachadasAcabadorevestidoPorcentaje;
		this.otrasfachadasAcabadorevestidoTexto = otrasfachadasAcabadorevestidoTexto;
		this.otrasfachadasAcabadovistoPorcentaje = otrasfachadasAcabadovistoPorcentaje;
		this.otrasfachadasAcabadovistoTexto = otrasfachadasAcabadovistoTexto;
		this.otrasfachadasAislamientotermicoTipoId = otrasfachadasAislamientotermicoTipoId;
		this.otrasfachadasCamaraaireTipoId = otrasfachadasCamaraaireTipoId;
	}

	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "inspeccion"))
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "clave_informe", unique = true, nullable = false)
	public int getClaveInforme() {
		return this.claveInforme;
	}

	public void setClaveInforme(int claveInforme) {
		this.claveInforme = claveInforme;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "clave_informe", unique = true, nullable = false)
	public Inspeccion getInspeccion() {
		return this.inspeccion;
	}

	public void setInspeccion(Inspeccion inspeccion) {
		this.inspeccion = inspeccion;
	}

	@Column(name = "carpinteria_vidrio_porcentaje")
	public String getCarpinteriaVidrioPorcentaje() {
		return this.carpinteriaVidrioPorcentaje;
	}

	public void setCarpinteriaVidrioPorcentaje(String carpinteriaVidrioPorcentaje) {
		this.carpinteriaVidrioPorcentaje = carpinteriaVidrioPorcentaje;
	}

	@Column(name = "carpinteria_vidrio_superficie")
	public String getCarpinteriaVidrioSuperficie() {
		return this.carpinteriaVidrioSuperficie;
	}

	public void setCarpinteriaVidrioSuperficie(String carpinteriaVidrioSuperficie) {
		this.carpinteriaVidrioSuperficie = carpinteriaVidrioSuperficie;
	}

	/**
	 * * (carpinteriavidrio_carpinteriapredominante_texto)
	 */

	@Column(name = "carp_vid_carppred_texto")
	public String getCarpinteriavidrioCarpinteriapredominanteTexto() {
		return this.carpinteriavidrioCarpinteriapredominanteTexto;
	}

	public void setCarpinteriavidrioCarpinteriapredominanteTexto(String carpinteriavidrioCarpinteriapredominanteTexto) {
		this.carpinteriavidrioCarpinteriapredominanteTexto = carpinteriavidrioCarpinteriapredominanteTexto;
	}

	/**
	 * * (carpinteriavidrio_vidriopredominante_texto)
	 */

	@Column(name = "carp_vid_vidriopred_texto")
	public String getCarpinteriavidrioVidriopredominanteTexto() {
		return this.carpinteriavidrioVidriopredominanteTexto;
	}

	public void setCarpinteriavidrioVidriopredominanteTexto(String carpinteriavidrioVidriopredominanteTexto) {
		this.carpinteriavidrioVidriopredominanteTexto = carpinteriavidrioVidriopredominanteTexto;
	}

	@Column(name = "cubierta_inclinada_porcentaje")
	public String getCubiertaInclinadaPorcentaje() {
		return this.cubiertaInclinadaPorcentaje;
	}

	public void setCubiertaInclinadaPorcentaje(String cubiertaInclinadaPorcentaje) {
		this.cubiertaInclinadaPorcentaje = cubiertaInclinadaPorcentaje;
	}

	@Column(name = "cubierta_inclinada_superficie")
	public String getCubiertaInclinadaSuperficie() {
		return this.cubiertaInclinadaSuperficie;
	}

	public void setCubiertaInclinadaSuperficie(String cubiertaInclinadaSuperficie) {
		this.cubiertaInclinadaSuperficie = cubiertaInclinadaSuperficie;
	}

	@Column(name = "cubierta_plana_porcentaje")
	public String getCubiertaPlanaPorcentaje() {
		return this.cubiertaPlanaPorcentaje;
	}

	public void setCubiertaPlanaPorcentaje(String cubiertaPlanaPorcentaje) {
		this.cubiertaPlanaPorcentaje = cubiertaPlanaPorcentaje;
	}

	@Column(name = "cubierta_plana_superficie")
	public String getCubiertaPlanaSuperficie() {
		return this.cubiertaPlanaSuperficie;
	}

	public void setCubiertaPlanaSuperficie(String cubiertaPlanaSuperficie) {
		this.cubiertaPlanaSuperficie = cubiertaPlanaSuperficie;
	}

	/**
	 * * (cubiertainclinada_aislamientotermico_tipo_id)
	 */

	@Column(name = "cub_inclinada_ais_ter_tipo_id")
	public Integer getCubiertainclinadaAislamientotermicoTipoId() {
		return this.cubiertainclinadaAislamientotermicoTipoId;
	}

	public void setCubiertainclinadaAislamientotermicoTipoId(Integer cubiertainclinadaAislamientotermicoTipoId) {
		this.cubiertainclinadaAislamientotermicoTipoId = cubiertainclinadaAislamientotermicoTipoId;
	}

	/**
	 * * (cubiertaplana_aislamientotermico_tipo_id)
	 */

	@Column(name = "cub_plana_ais_ter_tipo_id")
	public Integer getCubiertaplanaAislamientotermicoTipoId() {
		return this.cubiertaplanaAislamientotermicoTipoId;
	}

	public void setCubiertaplanaAislamientotermicoTipoId(Integer cubiertaplanaAislamientotermicoTipoId) {
		this.cubiertaplanaAislamientotermicoTipoId = cubiertaplanaAislamientotermicoTipoId;
	}

	/**
	 * * (cubiertaplana_laminaimpermeabilizante_tipo_id)
	 */

	@Column(name = "cub_plana_lam_imper_tipo_id")
	public Integer getCubiertaplanaLaminaimpermeabilizanteTipoId() {
		return this.cubiertaplanaLaminaimpermeabilizanteTipoId;
	}

	public void setCubiertaplanaLaminaimpermeabilizanteTipoId(Integer cubiertaplanaLaminaimpermeabilizanteTipoId) {
		this.cubiertaplanaLaminaimpermeabilizanteTipoId = cubiertaplanaLaminaimpermeabilizanteTipoId;
	}

	@Column(name = "fachada_principal_porcentaje")
	public String getFachadaPrincipalPorcentaje() {
		return this.fachadaPrincipalPorcentaje;
	}

	public void setFachadaPrincipalPorcentaje(String fachadaPrincipalPorcentaje) {
		this.fachadaPrincipalPorcentaje = fachadaPrincipalPorcentaje;
	}

	@Column(name = "fachada_principal_superficie", precision = 20, scale = 10)
	public BigDecimal getFachadaPrincipalSuperficie() {
		return this.fachadaPrincipalSuperficie;
	}

	public void setFachadaPrincipalSuperficie(BigDecimal fachadaPrincipalSuperficie) {
		this.fachadaPrincipalSuperficie = fachadaPrincipalSuperficie;
	}

	/**
	 * * (fachadaprincipal_acabadorevestido_porcentaje)
	 */

	@Column(name = "facprin_acab_revest_porcen")
	public String getFachadaprincipalAcabadorevestidoPorcentaje() {
		return this.fachadaprincipalAcabadorevestidoPorcentaje;
	}

	public void setFachadaprincipalAcabadorevestidoPorcentaje(String fachadaprincipalAcabadorevestidoPorcentaje) {
		this.fachadaprincipalAcabadorevestidoPorcentaje = fachadaprincipalAcabadorevestidoPorcentaje;
	}

	/**
	 * * (fachadaprincipal_acabadorevestido_texto)
	 */

	@Column(name = "facprin_acabadorevestido_texto")
	public String getFachadaprincipalAcabadorevestidoTexto() {
		return this.fachadaprincipalAcabadorevestidoTexto;
	}

	public void setFachadaprincipalAcabadorevestidoTexto(String fachadaprincipalAcabadorevestidoTexto) {
		this.fachadaprincipalAcabadorevestidoTexto = fachadaprincipalAcabadorevestidoTexto;
	}

	/**
	 * * (fachadaprincipal_acabadovisto_porcentaje)
	 */

	@Column(name = "facprin_acabadovisto_porcen")
	public String getFachadaprincipalAcabadovistoPorcentaje() {
		return this.fachadaprincipalAcabadovistoPorcentaje;
	}

	public void setFachadaprincipalAcabadovistoPorcentaje(String fachadaprincipalAcabadovistoPorcentaje) {
		this.fachadaprincipalAcabadovistoPorcentaje = fachadaprincipalAcabadovistoPorcentaje;
	}

	/**
	 * * (fachadaprincipal_acabadovisto_texto)
	 */

	@Column(name = "facprin_acabadovisto_texto")
	public String getFachadaprincipalAcabadovistoTexto() {
		return this.fachadaprincipalAcabadovistoTexto;
	}

	public void setFachadaprincipalAcabadovistoTexto(String fachadaprincipalAcabadovistoTexto) {
		this.fachadaprincipalAcabadovistoTexto = fachadaprincipalAcabadovistoTexto;
	}

	/**
	 * * (fachadaprincipal_aislamientotermico_tipo_id)
	 */

	@Column(name = "facprin_ais_ter_tipo_id")
	public Integer getFachadaprincipalAislamientotermicoTipoId() {
		return this.fachadaprincipalAislamientotermicoTipoId;
	}

	public void setFachadaprincipalAislamientotermicoTipoId(Integer fachadaprincipalAislamientotermicoTipoId) {
		this.fachadaprincipalAislamientotermicoTipoId = fachadaprincipalAislamientotermicoTipoId;
	}

	/**
	 * * (fachadaprincipal_camaraaire_tipo_id)
	 */

	@Column(name = "facprin_camaraaire_tipo_id")
	public Integer getFachadaprincipalCamaraaireTipoId() {
		return this.fachadaprincipalCamaraaireTipoId;
	}

	public void setFachadaprincipalCamaraaireTipoId(Integer fachadaprincipalCamaraaireTipoId) {
		this.fachadaprincipalCamaraaireTipoId = fachadaprincipalCamaraaireTipoId;
	}

	@Column(name = "observaciones")
	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	@Column(name = "otras_fachadas_porcentaje")
	public String getOtrasFachadasPorcentaje() {
		return this.otrasFachadasPorcentaje;
	}

	public void setOtrasFachadasPorcentaje(String otrasFachadasPorcentaje) {
		this.otrasFachadasPorcentaje = otrasFachadasPorcentaje;
	}

	@Column(name = "otras_fachadas_superficie")
	public String getOtrasFachadasSuperficie() {
		return this.otrasFachadasSuperficie;
	}

	public void setOtrasFachadasSuperficie(String otrasFachadasSuperficie) {
		this.otrasFachadasSuperficie = otrasFachadasSuperficie;
	}

	/**
	 * * (otrasfachadas_acabadorevestido_porcentaje)
	 */

	@Column(name = "otrfac_acabadorevestido_porcen")
	public String getOtrasfachadasAcabadorevestidoPorcentaje() {
		return this.otrasfachadasAcabadorevestidoPorcentaje;
	}

	public void setOtrasfachadasAcabadorevestidoPorcentaje(String otrasfachadasAcabadorevestidoPorcentaje) {
		this.otrasfachadasAcabadorevestidoPorcentaje = otrasfachadasAcabadorevestidoPorcentaje;
	}

	/**
	 * * (otrasfachadas_acabadorevestido_texto)
	 */

	@Column(name = "otrfac_acabadorevestido_texto")
	public String getOtrasfachadasAcabadorevestidoTexto() {
		return this.otrasfachadasAcabadorevestidoTexto;
	}

	public void setOtrasfachadasAcabadorevestidoTexto(String otrasfachadasAcabadorevestidoTexto) {
		this.otrasfachadasAcabadorevestidoTexto = otrasfachadasAcabadorevestidoTexto;
	}

	/**
	 * * (otrasfachadas_acabadovisto_porcentaje)
	 */

	@Column(name = "otrfac_acabadovisto_porcentaje")
	public String getOtrasfachadasAcabadovistoPorcentaje() {
		return this.otrasfachadasAcabadovistoPorcentaje;
	}

	public void setOtrasfachadasAcabadovistoPorcentaje(String otrasfachadasAcabadovistoPorcentaje) {
		this.otrasfachadasAcabadovistoPorcentaje = otrasfachadasAcabadovistoPorcentaje;
	}

	/**
	 * * (otrasfachadas_acabadovisto_texto)
	 */

	@Column(name = "otrfachadas_acabadovisto_texto")
	public String getOtrasfachadasAcabadovistoTexto() {
		return this.otrasfachadasAcabadovistoTexto;
	}

	public void setOtrasfachadasAcabadovistoTexto(String otrasfachadasAcabadovistoTexto) {
		this.otrasfachadasAcabadovistoTexto = otrasfachadasAcabadovistoTexto;
	}

	/**
	 * * (otrasfachadas_aislamientotermico_tipo_id)
	 */

	@Column(name = "otrfac_ais_ter_tipo_id")
	public Integer getOtrasfachadasAislamientotermicoTipoId() {
		return this.otrasfachadasAislamientotermicoTipoId;
	}

	public void setOtrasfachadasAislamientotermicoTipoId(Integer otrasfachadasAislamientotermicoTipoId) {
		this.otrasfachadasAislamientotermicoTipoId = otrasfachadasAislamientotermicoTipoId;
	}

	/**
	 * * (otrasfachadas_camaraaire_tipo_id)
	 */

	@Column(name = "otrfachadas_camaraaire_tipo_id")
	public Integer getOtrasfachadasCamaraaireTipoId() {
		return this.otrasfachadasCamaraaireTipoId;
	}

	public void setOtrasfachadasCamaraaireTipoId(Integer otrasfachadasCamaraaireTipoId) {
		this.otrasfachadasCamaraaireTipoId = otrasfachadasCamaraaireTipoId;
	}

	/**
	 * toString
	 * 
	 * @return String
	 */
	public String toString() {
		StringBuffer buffer = new StringBuffer();

		buffer.append(getClass().getName()).append("@").append(Integer.toHexString(hashCode())).append(" [");
		buffer.append("claveInforme").append("='").append(getClaveInforme()).append("' ");
		buffer.append("inspeccion").append("='").append(getInspeccion()).append("' ");
		buffer.append("]");

		return buffer.toString();
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CerramientosCubiertas))
			return false;
		CerramientosCubiertas castOther = (CerramientosCubiertas) other;

		return (this.getClaveInforme() == castOther.getClaveInforme()) && ((this.getInspeccion() == castOther.getInspeccion()) || (this.getInspeccion() != null && castOther.getInspeccion() != null && this.getInspeccion().equals(castOther.getInspeccion())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getClaveInforme();
		result = 37 * result + (getInspeccion() == null ? 0 : this.getInspeccion().hashCode());

		return result;
	}

}