package es.caib.avaedi.front.service.general;

import java.util.Collection;
import java.util.Locale;

import es.caib.avaedi.at4forms.common.exception.GenericBusinessException;
import es.caib.avaedi.at4forms.common.realm.BaseFrontPrincipal;
import es.caib.avaedi.at4forms.common.search.FilterConfig;
import es.caib.avaedi.at4forms.common.search.PagingConfig;
import es.caib.avaedi.at4forms.common.search.ResultadoBusqueda;
import es.caib.avaedi.at4forms.common.util.StringUtils;
import es.caib.avaedi.at4forms.front.items.FormItem;
import es.caib.avaedi.at4forms.front.service.items.GridColumnFilter;
import es.caib.avaedi.at4forms.front.service.items.GridColumnMetaData;
import es.caib.avaedi.at4forms.front.service.items.GridMetaData;
import es.caib.avaedi.at4forms.front.service.items.GridRecordFieldMetaData;
import es.caib.avaedi.at4forms.logic.bo.BaseBO;
import es.caib.avaedi.common.realm.Constants;
import es.caib.avaedi.front.config.AuthUtils;
import es.caib.avaedi.logic.vo.InspeccionBaseFormVO;
import es.caib.avaedi.logic.vo.InspeccionBaseVO;

/**
 * Clase base sobre la que construir servicios de front. En particular,
 * formularios (FormService)
 * 
 * @author agarcia
 * 
 */
public abstract class InspeccionBaseService<BO extends BaseBO<LO, FO>, LO extends InspeccionBaseVO, FO extends InspeccionBaseFormVO> extends BaseService<BO, LO, FO> {

	@Override
	protected boolean hasPerms(BaseFrontPrincipal usuari, String action, FO instance) {

		if (instance != null) {
			//Estamos actuando sobre una instancia en concreto, aquí comprobamos que el usuario tenga acceso al municipio 
			if (!AuthUtils.hasAccess(usuari, instance.getMunicipioId())) {
				return false;
			}
		}

		if (action.equals(PERMS_LIST) || action.equals(PERMS_EXPORT)) {
			return usuari.isInAnyRole(Constants.ADMIN, Constants.OPERADOR, Constants.CONSULTA, Constants.MUNICIPI);
		}

		return false;
	}

	@Override
	public ResultadoBusqueda<LO> getListado(Collection<FilterConfig> filters, PagingConfig pagingConfig, BaseFrontPrincipal usuari, Locale locale) throws GenericBusinessException {
		this.addMunicipioFilter(filters, usuari);
		return super.getListado(filters, pagingConfig, usuari, locale);
	}

	private void addMunicipioFilter(Collection<FilterConfig> filters, BaseFrontPrincipal usuari) {
		String municipioId = AuthUtils.municipioId(usuari);
		if (!StringUtils.isEmpty(municipioId)) {

			//Añadimos el filtro de tipos de contrato
			filters.add(new FilterConfig(FilterConfig.TYPE_AUTO, "inspeccion.informe.edificio.via.municipio.clave", municipioId));

		}

	}

	protected GridMetaData getBaseMetaData(FormItem formItem, Locale locale) {
		GridMetaData metaData = new GridMetaData(formItem);

		//Añadimos el campo de oid al registro (el campo oid es el "object identifier")
		metaData.addRecordField(new GridRecordFieldMetaData("oid", "claveInforme", GridRecordFieldMetaData.INT_TYPE));

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("claveInforme", GridRecordFieldMetaData.INT_TYPE));

		// Creamos la columna
		metaData.addColumn(new GridColumnMetaData("claveInforme", this.getMessage("forms.conservacion.columns.claveInforme.header", locale)));
		metaData.getColumn("claveInforme").setGroupable(false);
		metaData.getColumn("claveInforme").setSortable(true);
		metaData.getColumn("claveInforme").setSofaFilter(GridColumnFilter.TYPE_NUMERIC);

		metaData.addRecordField(new GridRecordFieldMetaData("edificioId", GridRecordFieldMetaData.INT_TYPE));
		metaData.addRecordField(new GridRecordFieldMetaData("edificioLabel", GridRecordFieldMetaData.STRING_TYPE));
		metaData.addRecordField(new GridRecordFieldMetaData("edificio", "edificioLabel", GridRecordFieldMetaData.STRING_TYPE));

		// Creamos la columna
		
		//this.getMessage("forms.baseinspeccion.edificio.title", locale) 
		metaData.addColumn(new GridColumnMetaData("edificio", this.getMessage("forms.baseinspeccion.edificio.title", locale) ));
		metaData.getColumn("edificio").setGroupable(true);
		metaData.getColumn("edificio").setSortable(true);
		metaData.getColumn("edificio").setSofaFilter(GridColumnFilter.TYPE_MULTICOMBO);
		metaData.getColumn("edificio").setRelatedForm("Edificio");

		metaData.getColumn("edificio").setEditable(false);
		metaData.addRecordField(new GridRecordFieldMetaData("municipioId", GridRecordFieldMetaData.INT_TYPE));
		metaData.addRecordField(new GridRecordFieldMetaData("municipioLabel", GridRecordFieldMetaData.STRING_TYPE));
		metaData.addRecordField(new GridRecordFieldMetaData("municipio", "municipioLabel", GridRecordFieldMetaData.STRING_TYPE));

		// Creamos la columna
		//this.getMessage("forms.conservacion.columns.inspeccion.header", locale) 
		metaData.addColumn(new GridColumnMetaData("municipio", this.getMessage("forms.baseinspeccion.municipio.title", locale) ));
		metaData.getColumn("municipio").setGroupable(true);
		metaData.getColumn("municipio").setSortable(true);
		metaData.getColumn("municipio").setSofaFilter(GridColumnFilter.TYPE_MULTICOMBO);
		metaData.getColumn("municipio").setRelatedForm("Municipio");

		metaData.getColumn("municipio").setEditable(false);

		return metaData;

	}

}
