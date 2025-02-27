package es.caib.avaedi.common.model;
// Generated 16-dic-2016 12:11:55

import es.caib.avaedi.at4forms.common.basedao.BaseModel;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * AcusticaMejorasAcusticas generated by hbm2java
 */
@Entity
@Table(name="AED_ACU_MEJORASACUSTICAS"    ,schema="AVAEDI")
public class AcusticaMejorasAcusticas extends BaseModel implements java.io.Serializable {

	/** serialVersionUID */ 
	private static final long serialVersionUID = 1L;


     private AcusticaMejorasAcusticasId id;
     private Inspeccion inspeccion;
     /**
      * (proteccion_ruido_exterior_tipo_id)
     */
     private Integer proteccionRuidoExteriorTipoId;
     private String mejorasAnalisisTecnico;
     /**
      * (proteccion_ruido_instalaciones_tipo_id)
     */
     private Integer proteccionRuidoInstalacionesTipoId;
     private String mejorasDescripcion;
     /**
      * (proteccion_ruido_interior_aereo_tipo_id)
     */
     private Integer proteccionRuidoInteriorAereoTipoId;
     private String mejorasObservaciones;
     /**
      * (proteccion_ruido_interior_impactos_tipo_id)
     */
     private Integer proteccionRuidoInteriorImpactosTipoId;
     private String mejorasValoracionEconomica;
     private String potencialObservaciones;
     private String incidenciaObservaciones;
     private String incidenciaTexto;

    public AcusticaMejorasAcusticas() {
    }

	
    public AcusticaMejorasAcusticas(AcusticaMejorasAcusticasId id, Inspeccion inspeccion) {
        this.id = id;
        this.inspeccion = inspeccion;
    }
    public AcusticaMejorasAcusticas(AcusticaMejorasAcusticasId id, Inspeccion inspeccion, Integer proteccionRuidoExteriorTipoId, String mejorasAnalisisTecnico, Integer proteccionRuidoInstalacionesTipoId, String mejorasDescripcion, Integer proteccionRuidoInteriorAereoTipoId, String mejorasObservaciones, Integer proteccionRuidoInteriorImpactosTipoId, String mejorasValoracionEconomica, String potencialObservaciones, String incidenciaObservaciones, String incidenciaTexto) {
       this.id = id;
       this.inspeccion = inspeccion;
       this.proteccionRuidoExteriorTipoId = proteccionRuidoExteriorTipoId;
       this.mejorasAnalisisTecnico = mejorasAnalisisTecnico;
       this.proteccionRuidoInstalacionesTipoId = proteccionRuidoInstalacionesTipoId;
       this.mejorasDescripcion = mejorasDescripcion;
       this.proteccionRuidoInteriorAereoTipoId = proteccionRuidoInteriorAereoTipoId;
       this.mejorasObservaciones = mejorasObservaciones;
       this.proteccionRuidoInteriorImpactosTipoId = proteccionRuidoInteriorImpactosTipoId;
       this.mejorasValoracionEconomica = mejorasValoracionEconomica;
       this.potencialObservaciones = potencialObservaciones;
       this.incidenciaObservaciones = incidenciaObservaciones;
       this.incidenciaTexto = incidenciaTexto;
    }
   
     @EmbeddedId
    
    @AttributeOverrides( {
        @AttributeOverride(name="claveInforme", column=@Column(name="CLAVE_INFORME", nullable=false, precision=22, scale=0) ), 
        @AttributeOverride(name="mejorasOrden", column=@Column(name="MEJORAS_ORDEN", nullable=false, precision=22, scale=0) ) } )
    public AcusticaMejorasAcusticasId getId() {
        return this.id;
    }
    
    public void setId(AcusticaMejorasAcusticasId id) {
        this.id = id;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="CLAVE_INFORME", nullable=false, insertable=false, updatable=false)
    public Inspeccion getInspeccion() {
        return this.inspeccion;
    }
    
    public void setInspeccion(Inspeccion inspeccion) {
        this.inspeccion = inspeccion;
    }
    /**       
     *      * (proteccion_ruido_exterior_tipo_id)
     */
    
    @Column(name="PROT_RUI_EXT_TIPO_ID", precision=22, scale=0)
    public Integer getProteccionRuidoExteriorTipoId() {
        return this.proteccionRuidoExteriorTipoId;
    }
    
    public void setProteccionRuidoExteriorTipoId(Integer proteccionRuidoExteriorTipoId) {
        this.proteccionRuidoExteriorTipoId = proteccionRuidoExteriorTipoId;
    }
    
    @Column(name="MEJORAS_ANALISIS_TECNICO", length=4000)
    public String getMejorasAnalisisTecnico() {
        return this.mejorasAnalisisTecnico;
    }
    
    public void setMejorasAnalisisTecnico(String mejorasAnalisisTecnico) {
        this.mejorasAnalisisTecnico = mejorasAnalisisTecnico;
    }
    /**       
     *      * (proteccion_ruido_instalaciones_tipo_id)
     */
    
    @Column(name="PROT_RUI_INSTAL_TIPO_ID", precision=22, scale=0)
    public Integer getProteccionRuidoInstalacionesTipoId() {
        return this.proteccionRuidoInstalacionesTipoId;
    }
    
    public void setProteccionRuidoInstalacionesTipoId(Integer proteccionRuidoInstalacionesTipoId) {
        this.proteccionRuidoInstalacionesTipoId = proteccionRuidoInstalacionesTipoId;
    }
    
    @Column(name="MEJORAS_DESCRIPCION", length=4000)
    public String getMejorasDescripcion() {
        return this.mejorasDescripcion;
    }
    
    public void setMejorasDescripcion(String mejorasDescripcion) {
        this.mejorasDescripcion = mejorasDescripcion;
    }
    /**       
     *      * (proteccion_ruido_interior_aereo_tipo_id)
     */
    
    @Column(name="PROT_RUI_INT_AER_TIPO_ID", precision=22, scale=0)
    public Integer getProteccionRuidoInteriorAereoTipoId() {
        return this.proteccionRuidoInteriorAereoTipoId;
    }
    
    public void setProteccionRuidoInteriorAereoTipoId(Integer proteccionRuidoInteriorAereoTipoId) {
        this.proteccionRuidoInteriorAereoTipoId = proteccionRuidoInteriorAereoTipoId;
    }
    
    @Column(name="MEJORAS_OBSERVACIONES", length=4000)
    public String getMejorasObservaciones() {
        return this.mejorasObservaciones;
    }
    
    public void setMejorasObservaciones(String mejorasObservaciones) {
        this.mejorasObservaciones = mejorasObservaciones;
    }
    /**       
     *      * (proteccion_ruido_interior_impactos_tipo_id)
     */
    
    @Column(name="PROT_RUI_INT_IMPACTOS_TIPO_ID", precision=22, scale=0)
    public Integer getProteccionRuidoInteriorImpactosTipoId() {
        return this.proteccionRuidoInteriorImpactosTipoId;
    }
    
    public void setProteccionRuidoInteriorImpactosTipoId(Integer proteccionRuidoInteriorImpactosTipoId) {
        this.proteccionRuidoInteriorImpactosTipoId = proteccionRuidoInteriorImpactosTipoId;
    }
    
    @Column(name="MEJORAS_VALORACION_ECONOMICA", length=4000)
    public String getMejorasValoracionEconomica() {
        return this.mejorasValoracionEconomica;
    }
    
    public void setMejorasValoracionEconomica(String mejorasValoracionEconomica) {
        this.mejorasValoracionEconomica = mejorasValoracionEconomica;
    }
    
    @Column(name="POTENCIAL_OBSERVACIONES", length=4000)
    public String getPotencialObservaciones() {
        return this.potencialObservaciones;
    }
    
    public void setPotencialObservaciones(String potencialObservaciones) {
        this.potencialObservaciones = potencialObservaciones;
    }
    
    @Column(name="INCIDENCIA_OBSERVACIONES", length=4000)
    public String getIncidenciaObservaciones() {
        return this.incidenciaObservaciones;
    }
    
    public void setIncidenciaObservaciones(String incidenciaObservaciones) {
        this.incidenciaObservaciones = incidenciaObservaciones;
    }
    
    @Column(name="INCIDENCIA_TEXTO", length=4000)
    public String getIncidenciaTexto() {
        return this.incidenciaTexto;
    }
    
    public void setIncidenciaTexto(String incidenciaTexto) {
        this.incidenciaTexto = incidenciaTexto;
    }

    /**
     * toString
     * @return String
     */
     public String toString() {
	  StringBuffer buffer = new StringBuffer();

      buffer.append(getClass().getName()).append("@").append(Integer.toHexString(hashCode())).append(" [");
      buffer.append("id").append("='").append(getId()).append("' ");			
      buffer.append("inspeccion").append("='").append(getInspeccion()).append("' ");			
      buffer.append("]");
      
      return buffer.toString();
     }

   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof AcusticaMejorasAcusticas) ) return false;
		 AcusticaMejorasAcusticas castOther = ( AcusticaMejorasAcusticas ) other; 
         
		 return ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) )
 && ( (this.getInspeccion()==castOther.getInspeccion()) || ( this.getInspeccion()!=null && castOther.getInspeccion()!=null && this.getInspeccion().equals(castOther.getInspeccion()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getId() == null ? 0 : this.getId().hashCode() );
         result = 37 * result + ( getInspeccion() == null ? 0 : this.getInspeccion().hashCode() );
         
         
         
         
         
         
         
         
         
         
         
         return result;
   }   


}


