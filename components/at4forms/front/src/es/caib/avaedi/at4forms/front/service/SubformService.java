package es.caib.avaedi.at4forms.front.service;

import java.util.Collection;
import java.util.Locale;
import java.util.Map;

import es.caib.avaedi.at4forms.common.exception.GenericBusinessException;
import es.caib.avaedi.at4forms.common.realm.BaseFrontPrincipal;
import es.caib.avaedi.at4forms.common.search.FilterConfig;
import es.caib.avaedi.at4forms.common.search.PagingConfig;
import es.caib.avaedi.at4forms.common.search.ResultadoActualizacion;
import es.caib.avaedi.at4forms.common.search.ResultadoBusqueda;
import es.caib.avaedi.at4forms.common.search.ResultadoExportacion;
import es.caib.avaedi.at4forms.front.items.FormItem;
import es.caib.avaedi.at4forms.front.service.items.ContenidoFormulario;
import es.caib.avaedi.at4forms.front.service.items.GridMetaData;
import es.caib.avaedi.at4forms.logic.bo.BaseBO;
import es.caib.avaedi.at4forms.logic.vo.FormVO;
import es.caib.avaedi.at4forms.logic.vo.ListadoVO;
import es.caib.avaedi.front.service.general.BaseService;


/**
 * Tipo de FormService auxiliar que no tiene formulario principal, sino que se usa sólo para subformularios
 * @author agarcia
 *
 */
public abstract class SubformService< BO extends BaseBO<LO, FO>, LO extends ListadoVO, FO extends FormVO> extends BaseService<BO, LO, FO> {

	@Override
	public ContenidoFormulario<FO> load(String id, BaseFrontPrincipal usuari,
			Locale locale) throws GenericBusinessException {

		throw new GenericBusinessException("load no está disponible en este formulario");

	}

	public ResultadoActualizacion add(Map<String, ?> formData,
			BaseFrontPrincipal usuari, Locale locale)
			throws GenericBusinessException {

		throw new GenericBusinessException("add no está disponible en este formulario");

	}

	public ResultadoActualizacion delete(String id, BaseFrontPrincipal usuari,
			Locale locale) throws GenericBusinessException {

		throw new GenericBusinessException("delete no está disponible en este formulario");

	}

	public ResultadoExportacion getExportacion(
			Collection<FilterConfig> filters, PagingConfig pagingConfig,
			BaseFrontPrincipal usuari, Locale locale)
			throws GenericBusinessException {

		throw new GenericBusinessException("getExportacion no está disponible en este formulario");

	}

	public GridMetaData getListMetadata(FormItem formItem,
			BaseFrontPrincipal usuari, Locale locale) {

		return null;

	}

	public ResultadoBusqueda<LO> getListado(Collection<FilterConfig> filters,
			PagingConfig pagingConfig, BaseFrontPrincipal usuari, Locale locale)
			throws GenericBusinessException {

		throw new GenericBusinessException("getListado no está disponible en este formulario");

	}

	public ResultadoActualizacion update(String id, Map<String, ?> formData,
			BaseFrontPrincipal usuari, Locale locale)
			throws GenericBusinessException {

		throw new GenericBusinessException("update no está disponible en este formulario");

	}


}
