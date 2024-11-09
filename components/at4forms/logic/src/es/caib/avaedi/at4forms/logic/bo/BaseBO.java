package es.caib.avaedi.at4forms.logic.bo;

import java.io.Serializable;
import java.util.Collection;

import es.caib.avaedi.at4forms.common.exception.GenericBusinessException;
import es.caib.avaedi.at4forms.common.search.FilterConfig;
import es.caib.avaedi.at4forms.common.search.PagingConfig;
import es.caib.avaedi.at4forms.common.search.ResultadoBusqueda;
import es.caib.avaedi.at4forms.logic.vo.FormVO;
import es.caib.avaedi.at4forms.logic.vo.ListadoVO;

public interface BaseBO<LO extends ListadoVO, FO extends FormVO> {

	
	public ResultadoBusqueda<LO> getListado(Collection<FilterConfig> filters, PagingConfig pagingConfig) throws GenericBusinessException;

	public ResultadoBusqueda<LO> getListado() throws GenericBusinessException;

	public FO load(Serializable id) throws GenericBusinessException;

	public FO add(FO formData) throws GenericBusinessException;

	public FO update(Serializable id, FO formData)
			throws GenericBusinessException;

	public boolean delete(Serializable id) throws GenericBusinessException;
	
	public FO newModel() throws GenericBusinessException;

	
}
