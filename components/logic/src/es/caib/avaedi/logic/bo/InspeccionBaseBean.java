package es.caib.avaedi.logic.bo;

import java.io.Serializable;
import java.util.HashMap;

import javax.annotation.security.RolesAllowed;

import es.caib.avaedi.at4forms.common.basedao.Model;
import es.caib.avaedi.at4forms.common.exception.GenericBusinessException;
import es.caib.avaedi.at4forms.common.util.FormData2Java;
import es.caib.avaedi.at4forms.logic.bo.BaseBean;
import es.caib.avaedi.at4forms.logic.vo.FormVO;
import es.caib.avaedi.at4forms.logic.vo.ListadoVO;
import es.caib.avaedi.common.model.Edificio;
import es.caib.avaedi.common.model.Inspeccion;
import es.caib.avaedi.common.realm.Constants;
import es.caib.avaedi.logic.vo.InspeccionBaseVO;

/**
 * Clase base sobre la que construir los beans de negocio.
 * 
 * @author agarcia
 * 
 */
public abstract class InspeccionBaseBean<T extends Model, LO extends ListadoVO, FO extends FormVO> extends BaseBean<T, LO, FO> {

	public InspeccionBaseBean(Class<T> modelClass, Class<LO> lvoClass, Class<FO> fvoClass) {
		super(modelClass, lvoClass, fvoClass);
	}

	protected void setDatosInspeccion(InspeccionBaseVO ret, Inspeccion inspeccion) {

		if (inspeccion != null) {
			Edificio edificio = inspeccion.getInforme().getEdificio();
			ret.setInspeccionId(inspeccion.getId());
			ret.setInspeccionLabel(FormData2Java.toString(inspeccion.getId()));
			ret.setEdificioId(edificio.getClave());
			String edificioLabel = EdificioBean.composeLabel(edificio);
			ret.setEdificioLabel(edificioLabel);
			ret.setMunicipioId(edificio.getVia().getMunicipio().getClave());
			ret.setMunicipioLabel(edificio.getVia().getMunicipio().getNombre());
		}

	}

	protected HashMap<String, String> getBaseFilters() {
		HashMap<String, String> filterAssigments = new HashMap<String, String>();

		filterAssigments.put("inspeccion", "inspeccion.id");
		filterAssigments.put("edificio", "inspeccion.informe.edificio.id");
		filterAssigments.put("municipio", "inspeccion.informe.edificio.via.municipio.id");

		return filterAssigments;
	}

	protected HashMap<String, String> getBaseOrders() {
		HashMap<String, String> orderAssigments = new HashMap<String, String>();

		orderAssigments.put("inspeccion", "inspeccion.id");
		orderAssigments.put("edificio", "inspeccion.informe.edificio.via.nombre");
		orderAssigments.put("municipio", "inspeccion.informe.edificio.via.municipio.nombre");

		return orderAssigments;
	}

	/*
	 * ************************** Permisos ************************************
	 */
	
	@Override
	@RolesAllowed(Constants.ADMIN + "," + Constants.OPERADOR + "," + Constants.MUNICIPI)
	public FO add(FO formData) throws GenericBusinessException {
		return super.add(formData);
	}

	@Override
	@RolesAllowed(Constants.ADMIN + "," + Constants.OPERADOR + "," + Constants.MUNICIPI)
	public FO update(Serializable id, FO formData) throws GenericBusinessException {
		return super.update(id, formData);
	}

	@Override
	@RolesAllowed(Constants.ADMIN + "," + Constants.OPERADOR + "," + Constants.MUNICIPI)
	public boolean delete(Serializable id) throws GenericBusinessException {
		return super.delete(id);
	}
	
	
	
	
	

}
