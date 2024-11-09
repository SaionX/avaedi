package es.caib.avaedi.at4forms.front.audit;

import java.io.Serializable;
import java.util.*;

import es.caib.avaedi.at4forms.common.audit.AuditConstants;
import es.caib.avaedi.at4forms.common.audit.AuditOperationBO;
import es.caib.avaedi.at4forms.common.audit.AuditOperationFormVO;
import es.caib.avaedi.at4forms.common.audit.AuditOperationListadoVO;
import es.caib.avaedi.at4forms.common.exception.GenericBusinessException;
import es.caib.avaedi.at4forms.common.realm.BaseFrontPrincipal;
import es.caib.avaedi.at4forms.common.search.DatosExportacion;
import es.caib.avaedi.at4forms.common.search.FilterConfig;
import es.caib.avaedi.at4forms.common.search.PagingConfig;
import es.caib.avaedi.at4forms.common.search.ResultadoExportacion;
import es.caib.avaedi.at4forms.common.search.TipoCampoExportacion;
import es.caib.avaedi.at4forms.common.util.FormData2Java;
import es.caib.avaedi.at4forms.common.util.log.LogService;
import es.caib.avaedi.at4forms.front.items.FormItem;
import es.caib.avaedi.at4forms.front.service.items.GridColumnFilter;
import es.caib.avaedi.at4forms.front.service.items.GridColumnMetaData;
import es.caib.avaedi.at4forms.front.service.items.GridMetaData;
import es.caib.avaedi.at4forms.front.service.items.GridRecordFieldMetaData;
import es.caib.avaedi.at4forms.logic.vo.ListadoVO;
import es.caib.avaedi.front.service.general.BaseService;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


/**
 * Servicio para tratar el formulario: AuditOperation
 * @author agarcia@at4.net
 *
 */
@Service("auditoperation")
public class AuditOperationService extends BaseService<AuditOperationBO, AuditOperationListadoVO, AuditOperationFormVO> {

	/**
	 * The logger object.
	 */
	private static Logger log = LogService.getLogger(AuditOperationService.class);

	/**
	 * Bean para acceder a los métodos de negocio: AuditOperation
	 */
	@Autowired @Qualifier("AuditOperationBean")
	protected AuditOperationBO mainBO;

	/** Bean para acceder a los métodos de negocio: AuditOperation
	 * @param bean the bean to set
	 */
	protected AuditOperationBO getMainBO() {
		return this.mainBO;
	}



	/**
	 * TODO: esto es específico de aplicación
	 */
	@Override
	protected boolean hasPerms(BaseFrontPrincipal usuari, String action, AuditOperationFormVO instance) {

		/*if (action.equals(PERMS_LIST) || action.equals(PERMS_EXPORT)) {
			return usuari.isInAnyRole(Constants.INFRACCION_ADMIN);
		}		*/

		return false;
	}
	/* ************************** Métodos del interfaz FormService ************************************ */


	/* (non-Javadoc)
	 * @see es.caib.avaedi.front.service.FormService#getListMetadata(es.caib.avaedi.front.items.FormItem, es.caib.avaedi.common.realm.BaseFrontPrincipal, java.util.Locale)
	 */
	public GridMetaData getListMetadata(FormItem formItem, BaseFrontPrincipal usuari, Locale locale) {

		if ((formItem.getText() == null) || formItem.getText().equals("")) {
			formItem.setText( this.getMessage("forms.auditoperation.title", locale) );
		}

		GridMetaData metaData = new GridMetaData(formItem);

		//Nombre de la clase js de formulario
		metaData.setFormClassName("AuditOperationForm");
		
		//Nombre de la clase js de listado
		metaData.setListClassName("ListadoGrid");

		//Configurar las acciones posibles según los permisos
		metaData.setShowNewButton( this.hasPerms(usuari, PERMS_ADD) );
		metaData.setShowDeleteButton( this.hasPerms(usuari, PERMS_DELETE) );
		metaData.setShowUpdateButton( this.hasPerms(usuari, PERMS_UPDATE) );
		metaData.setShowExportControls( this.hasPerms(usuari, PERMS_EXPORT) );

		//Añadimos el campo de oid al registro (el campo oid es el "object identifier")
		metaData.addRecordField(new GridRecordFieldMetaData("oid", "id", GridRecordFieldMetaData.INT_TYPE));

		//Creamos el registro para el record
   		metaData.addRecordField(new GridRecordFieldMetaData("id", GridRecordFieldMetaData.INT_TYPE));
   	
		/** Creamos la columna */
		metaData.addColumn( new GridColumnMetaData( "id", this.getMessage("forms.auditoperation.columns.id.header", locale) ) );
		metaData.getColumn("id").setGroupable( false );
		metaData.getColumn("id").setSortable( true );
		metaData.getColumn("id").setSofaFilter( GridColumnFilter.TYPE_NUMERIC );
		
		

		//Creamos el registro para el record
   		metaData.addRecordField(new GridRecordFieldMetaData("transactionId", GridRecordFieldMetaData.INT_TYPE));
   	
		/** Creamos la columna */
		metaData.addColumn( new GridColumnMetaData( "transactionId", this.getMessage("forms.auditoperation.columns.transactionId.header", locale) ) );
		metaData.getColumn("transactionId").setGroupable( false );
		metaData.getColumn("transactionId").setSortable( false );
		//metaData.getColumn("transactionId").setSofaFilter( GridColumnFilter.TYPE_NUMERIC );
		
		//Creamos el registro para el record
   		metaData.addRecordField(new GridRecordFieldMetaData("transactionTimeStamp", GridRecordFieldMetaData.DATE_TYPE));
   	
		/** Creamos la columna */
		metaData.addColumn( new GridColumnMetaData( "transactionTimeStamp", this.getMessage("forms.auditoperation.columns.transactionTimeStamp.header", locale) ) );
		metaData.getColumn("transactionTimeStamp").setGroupable( true );
		metaData.getColumn("transactionTimeStamp").setSortable( true );
		metaData.getColumn("transactionTimeStamp").setSofaFilter( GridColumnFilter.TYPE_DATE );
		
		metaData.getRecordField("transactionTimeStamp").setDateFormat(this.getDateFormat());
		metaData.getColumn("transactionTimeStamp").setSofaRenderer( GridColumnMetaData.RENDERER_DATETIME );

		//Creamos el registro para el record
   		metaData.addRecordField(new GridRecordFieldMetaData("operationTimeStamp", GridRecordFieldMetaData.DATE_TYPE));
   	
		/** Creamos la columna */
		metaData.addColumn( new GridColumnMetaData( "operationTimeStamp", this.getMessage("forms.auditoperation.columns.operationTimeStamp.header", locale) ) );
		metaData.getColumn("operationTimeStamp").setGroupable( true );
		metaData.getColumn("operationTimeStamp").setSortable( true );
		metaData.getColumn("operationTimeStamp").setSofaFilter( GridColumnFilter.TYPE_DATE );
		
		metaData.getRecordField("operationTimeStamp").setDateFormat(this.getDateFormat());
		metaData.getColumn("operationTimeStamp").setSofaRenderer( GridColumnMetaData.RENDERER_DATETIME );
		metaData.getColumn("operationTimeStamp").setHidden(true);

		/*
		//Creamos el registro para el record
   		metaData.addRecordField(new GridRecordFieldMetaData("dbUser", GridRecordFieldMetaData.STRING_TYPE));
   	
		metaData.addColumn( new GridColumnMetaData( "dbUser", this.getMessage("forms.auditoperation.columns.dbUser.header", locale) ) );
		metaData.getColumn("dbUser").setGroupable( false );
		metaData.getColumn("dbUser").setSortable( true );
		metaData.getColumn("dbUser").setSofaFilter( GridColumnFilter.TYPE_STRING );
		
		metaData.getColumn("dbUser").setSofaRenderer( GridColumnMetaData.RENDERER_LARGETEXT );
		*/

		//Creamos el registro para el record
   		metaData.addRecordField(new GridRecordFieldMetaData("action", GridRecordFieldMetaData.STRING_TYPE));
   	
		/** Creamos la columna */
		metaData.addColumn( new GridColumnMetaData( "action", this.getMessage("forms.auditoperation.columns.action.header", locale) ) );
		metaData.getColumn("action").setGroupable( false );
		metaData.getColumn("action").setSortable( true );
		metaData.getColumn("action").setSofaFilter(GridColumnFilter.TYPE_LIST);
		metaData.getColumn("action").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);

		//TODO: esto debe ser configurable por aplicación 
		String[][] actionStoreValues = new String[][]{
				{ String.valueOf(AuditConstants.OPERATION_TYPE_INSERT), this.getMessage("forms.auditoperation.columns.action." + AuditConstants.OPERATION_TYPE_INSERT, locale)},
				{ String.valueOf(AuditConstants.OPERATION_TYPE_DELETE), this.getMessage("forms.auditoperation.columns.action." + AuditConstants.OPERATION_TYPE_DELETE, locale)},
				{String.valueOf(AuditConstants.OPERATION_TYPE_UPDATE), this.getMessage("forms.auditoperation.columns.action." + AuditConstants.OPERATION_TYPE_UPDATE, locale)}
		};
		metaData.getColumn("action").setSofaStoreValues(actionStoreValues);
		
		
		//Creamos el registro para el record
   		metaData.addRecordField(new GridRecordFieldMetaData("table", GridRecordFieldMetaData.STRING_TYPE));
   	
		/** Creamos la columna */
		metaData.addColumn( new GridColumnMetaData( "table", this.getMessage("forms.auditoperation.columns.table.header", locale) ) );
		metaData.getColumn("table").setGroupable( true );
		metaData.getColumn("table").setSortable( true );
		metaData.getColumn("table").setSofaFilter(GridColumnFilter.TYPE_LIST);
		metaData.getColumn("table").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);

		//TODO: esto debe ser configurable por aplicación 
		String[][] tableStoreValues = new String[][]{
				{"aci_infraccion", this.getMessage("forms.infraccion.title", locale)},
				{"aci_foto", this.getMessage("forms.foto.title", locale)}
		};
		metaData.getColumn("table").setSofaStoreValues(tableStoreValues);

		//Creamos el registro para el record
   		metaData.addRecordField(new GridRecordFieldMetaData("primaryKey", "newRecord.primaryKey", GridRecordFieldMetaData.STRING_TYPE));
		metaData.addColumn( new GridColumnMetaData( "primaryKey", this.getMessage("forms.auditoperation.columns.primaryKey.header", locale) ) );
		metaData.getColumn("primaryKey").setGroupable( false );
		metaData.getColumn("primaryKey").setSortable( false );
		metaData.getColumn("primaryKey").setSofaRenderer( GridColumnMetaData.RENDERER_LARGETEXT );

		//Creamos el registro para el record
   		metaData.addRecordField(new GridRecordFieldMetaData("primaryLabel", "newRecord.primaryLabel", GridRecordFieldMetaData.STRING_TYPE));
		metaData.addColumn( new GridColumnMetaData( "primaryLabel", this.getMessage("forms.auditoperation.columns.primaryLabel.header", locale) ) );
		metaData.getColumn("primaryLabel").setGroupable( false );
		metaData.getColumn("primaryLabel").setSortable( false );
		metaData.getColumn("primaryLabel").setSofaRenderer( GridColumnMetaData.RENDERER_LARGETEXT );

		/*
		//Creamos el registro para el record
   		metaData.addRecordField(new GridRecordFieldMetaData("creatorUser", "newRecord.creatorUser", GridRecordFieldMetaData.STRING_TYPE));
		metaData.addColumn( new GridColumnMetaData( "creatorUser", this.getMessage("forms.general.columns.creatorUser.header", locale) ) );
		metaData.getColumn("creatorUser").setGroupable( false );
		metaData.getColumn("creatorUser").setSortable( false );
		metaData.getColumn("creatorUser").setSofaRenderer( GridColumnMetaData.RENDERER_LARGETEXT );
		*/

		//Creamos el registro para el record
   		metaData.addRecordField(new GridRecordFieldMetaData("modUser", "newRecord.modUser", GridRecordFieldMetaData.STRING_TYPE));
		metaData.addColumn( new GridColumnMetaData( "modUser", this.getMessage("forms.general.columns.modUser.header", locale) ) );
		metaData.getColumn("modUser").setGroupable( false );
		metaData.getColumn("modUser").setSortable( false );
		metaData.getColumn("modUser").setSofaRenderer( GridColumnMetaData.RENDERER_LARGETEXT );
		
		
		//Creamos el registro para el record
   		metaData.addRecordField(new GridRecordFieldMetaData("objectId", GridRecordFieldMetaData.INT_TYPE));

   		
   		
		/** Creamos la columna 
		metaData.addColumn( new GridColumnMetaData( "objectId", this.getMessage("forms.auditoperation.columns.objectId.header", locale) ) );
		metaData.getColumn("objectId").setGroupable( false );
		metaData.getColumn("objectId").setSortable( true );
		metaData.getColumn("objectId").setSofaFilter( GridColumnFilter.TYPE_NUMERIC );
		*/
		
		return metaData;
	}

	/**
	 * Devuelve los datos disponibles para la exportación
	 * @param locale 
	 * @return
	 * @throws GenericBusinessException
	 */
	public DatosExportacion getDatosExportacion(Locale locale) throws GenericBusinessException  {

		DatosExportacion datosExportacion = new DatosExportacion();

			/* Configuramos el header */
			/* Informamos de los tipos de campo */

			datosExportacion.add( "id", this.getMessage("forms.auditoperation.columns.id.header", locale), TipoCampoExportacion.NUMBER );
			datosExportacion.add( "transactionId", this.getMessage("forms.auditoperation.columns.transactionId.header", locale), TipoCampoExportacion.NUMBER );
			datosExportacion.add( "transactionTimeStamp", this.getMessage("forms.auditoperation.columns.transactionTimeStamp.header", locale), TipoCampoExportacion.DATE );
			datosExportacion.add( "operationTimeStamp", this.getMessage("forms.auditoperation.columns.operationTimeStamp.header", locale), TipoCampoExportacion.DATE );
			//datosExportacion.add( "dbUser", this.getMessage("forms.auditoperation.columns.dbUser.header", locale), TipoCampoExportacion.STRING );
			datosExportacion.add( "action", this.getMessage("forms.auditoperation.columns.action.header", locale), TipoCampoExportacion.STRING );
			datosExportacion.add( "table", this.getMessage("forms.auditoperation.columns.table.header", locale), TipoCampoExportacion.STRING );
			//datosExportacion.add( "objectId", this.getMessage("forms.auditoperation.columns.objectId.header", locale), TipoCampoExportacion.NUMBER );
			datosExportacion.add( "primaryKey", this.getMessage("forms.auditoperation.columns.primaryKey.header", locale), TipoCampoExportacion.STRING );
			datosExportacion.add( "primaryLabel", this.getMessage("forms.auditoperation.columns.primaryLabel.header", locale), TipoCampoExportacion.STRING );
			datosExportacion.add( "modUser", this.getMessage("forms.general.columns.modUser.header", locale), TipoCampoExportacion.STRING );
			
		return datosExportacion;
	}
	

	/**
	 * Convierte a un registro de exportación
	 **/
	@Override
	public List<String> listadoToExportRow(ListadoVO rawInstance, Locale locale) {
		AuditOperationListadoVO instance = (AuditOperationListadoVO) rawInstance;

		List<String> excelRow = new ArrayList<String>();
		excelRow.add( FormData2Java.toString(instance.getId()) );
		excelRow.add( FormData2Java.toString(instance.getTransactionId()) );
		excelRow.add( FormData2Java.dateTimeToString(instance.getTransactionTimeStamp()) );
		excelRow.add( FormData2Java.dateTimeToString(instance.getOperationTimeStamp()) );
		//excelRow.add( instance.getDbUser() );
		excelRow.add( this.getMessage("forms.auditoperation.columns.action." + instance.getAction(), locale) );
		
		//TODO: esto quita el aci_ al nombre de tabla. Mejorar.
		String tableId = instance.getTable().substring(4);
		excelRow.add( this.getMessage("forms." + tableId + ".title", locale) );
		//excelRow.add( FormData2Java.toString(instance.getObjectId()) );
		excelRow.add( instance.getNewRecord().getPrimaryKey().toString() );
		excelRow.add( instance.getNewRecord().getPrimaryLabel());
		excelRow.add( instance.getNewRecord().getModUser());

		return excelRow;
	}


	@Override
	public Serializable toSerializableId(String id) {
		
		return FormData2Java.toLong(id);
		
	}

	@Override
	public String fromSerializableId(Serializable id) {
		
		return FormData2Java.toString(id);
		
	}

	/**
	 * Rellena una instancia de AuditOperationFormVO con el contenido de un formulario recibido en formato Map<String, ?>
	 */
	protected void setFormData(AuditOperationFormVO record, Map<String, ?> formData) throws GenericBusinessException  {
		throw new GenericBusinessException("setFormData no implementado para AuditOperation");
	}



	@Override
	public ResultadoExportacion getExportacion(Collection<FilterConfig> filters, PagingConfig pagingConfig, List<String> camposAexportar, BaseFrontPrincipal usuari, Locale locale) throws GenericBusinessException {
		// TODO Auto-generated method stub
		return null;
	}




}


