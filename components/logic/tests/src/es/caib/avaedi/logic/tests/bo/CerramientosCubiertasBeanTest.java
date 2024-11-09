package es.caib.avaedi.logic.tests.bo;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import es.caib.avaedi.logic.bo.*;
import es.caib.avaedi.logic.vo.*;
import es.caib.avaedi.at4forms.common.exception.GenericBusinessException;
import es.caib.avaedi.at4forms.common.search.PagingConfig;
import es.caib.avaedi.at4forms.tests.BaseBeanTests;
import es.caib.avaedi.at4forms.tests.TestUtil;
import es.caib.avaedi.common.model.*;

import java.util.*;

import org.junit.Test;


/**
 * Tests para el Bean: CerramientosCubiertas
 * @author agarcia@at4.net
 *
 */
public class CerramientosCubiertasBeanTest extends InspeccionBaseBeanTests<CerramientosCubiertasFormVO, CerramientosCubiertasBO> {

	/**
	 * Bean para acceder a los métodos de negocio: CerramientosCubiertas
	 */
	@Autowired @Qualifier("CerramientosCubiertasBean")
	protected CerramientosCubiertasBO mainBean;

	/** Bean para acceder a los métodos de negocio: CerramientosCubiertas
	 */
	protected CerramientosCubiertasBO getMainBean() {
		return this.mainBean;
	}


	/**
	*Bean para acceder a los metodos de negocio: Inspeccion
	*/
 @Autowired @Qualifier("InspeccionBean")
	private InspeccionBO inspeccionBO;
	
	/** Bean para acceder a los metodos de negocio: Inspeccion
	* @param bean the bean to set
	*/
	public void setInspeccionBO(InspeccionBO bean) {
		this.inspeccionBO = bean;
	}
	


/*
	Finders para relaciones
*/
	  
	@Test
	public void  findByInspeccionTest() throws GenericBusinessException {
		int inspeccionId = TestUtil.newInteger();
		//¿assert?
		this.getMainBean().findByInspeccion(inspeccionId);
	}





	/**
	 * Rellena una instancia de CerramientosCubiertas aleatoriamente
	 */
	protected CerramientosCubiertasFormVO fillRandomRecord(CerramientosCubiertasFormVO record, boolean forUpdate) throws GenericBusinessException  {

  
		if (!forUpdate) {
			//Damos de alta una inspeccion
			InspeccionFormVO inspeccion = fillNewRecord(new InspeccionFormVO());
			inspeccion = this.inspeccionBO.add(inspeccion);
			record.setInspeccionId(inspeccion.getInformeId());
		}

  
		record.setCarpinteriaVidrioPorcentaje( TestUtil.newString(255) );
  
		record.setCarpinteriaVidrioSuperficie( TestUtil.newString(255) );
  
		record.setCarpinteriavidrioCarpinteriapredominanteTexto( TestUtil.newString(255) );
  
		record.setCarpinteriavidrioVidriopredominanteTexto( TestUtil.newString(255) );
  
		record.setCubiertaInclinadaPorcentaje( TestUtil.newString(255) );
  
		record.setCubiertaInclinadaSuperficie( TestUtil.newString(255) );
  
		record.setCubiertaPlanaPorcentaje( TestUtil.newString(255) );
  
		record.setCubiertaPlanaSuperficie( TestUtil.newString(255) );
  
		record.setCubiertainclinadaAislamientotermicoTipoId( TestUtil.newInteger() );
  
		record.setCubiertaplanaAislamientotermicoTipoId( TestUtil.newInteger() );
  
		record.setCubiertaplanaLaminaimpermeabilizanteTipoId( TestUtil.newInteger() );
  
		record.setFachadaPrincipalPorcentaje( TestUtil.newString(255) );
  
		record.setFachadaPrincipalSuperficie( null /* TODO; tipo no soportado java.math.BigDecimal */ );
  
		record.setFachadaprincipalAcabadorevestidoPorcentaje( TestUtil.newString(255) );
  
		record.setFachadaprincipalAcabadorevestidoTexto( TestUtil.newString(255) );
  
		record.setFachadaprincipalAcabadovistoPorcentaje( TestUtil.newString(255) );
  
		record.setFachadaprincipalAcabadovistoTexto( TestUtil.newString(255) );
  
		record.setFachadaprincipalAislamientotermicoTipoId( TestUtil.newInteger() );
  
		record.setFachadaprincipalCamaraaireTipoId( TestUtil.newInteger() );
  
		record.setObservaciones( TestUtil.newString(255) );
  
		record.setOtrasFachadasPorcentaje( TestUtil.newString(255) );
  
		record.setOtrasFachadasSuperficie( TestUtil.newString(255) );
  
		record.setOtrasfachadasAcabadorevestidoPorcentaje( TestUtil.newString(255) );
  
		record.setOtrasfachadasAcabadorevestidoTexto( TestUtil.newString(255) );
  
		record.setOtrasfachadasAcabadovistoPorcentaje( TestUtil.newString(255) );
  
		record.setOtrasfachadasAcabadovistoTexto( TestUtil.newString(255) );
  
		record.setOtrasfachadasAislamientotermicoTipoId( TestUtil.newInteger() );
  
		record.setOtrasfachadasCamaraaireTipoId( TestUtil.newInteger() );

	return record;
	}

}


