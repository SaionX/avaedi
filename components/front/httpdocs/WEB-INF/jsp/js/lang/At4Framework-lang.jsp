<%@page pageEncoding="UTF-8" contentType="application/javascript; charset=UTF-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
/**
 * Localización para At4Framework
 * @author agarcia
 */

if(serverDatabaseActions){

    serverDatabaseActions.ejecutandoTxt		= '<spring:message code="At4FrameworkIntranet.BaseForm.ejecutandoTxt" javaScriptEscape="true"/>';
    serverDatabaseActions.espereTxt 		= '<spring:message code="At4FrameworkIntranet.BaseForm.espereTxt" javaScriptEscape="true"/>';

}


if(At4FrameworkIntranet.ApplicationBasic){
	Ext.override(At4FrameworkIntranet.ApplicationBasic,{
		idioma: '<c:out value='${rc.locale.language}'/>',
		contextPath: '<c:out value='${rc.contextPath}'/>',
		
		statusBarDefaultTxt: '<spring:message code="At4FrameworkIntranet.app.statusBarDefaultTxt" javaScriptEscape="true"/>',
		cargandoMenuTxt: '<spring:message code="At4FrameworkIntranet.app.cargandoMenuTxt" javaScriptEscape="true"/>',
		registerTabTitle: '<spring:message code="At4FrameworkIntranet.app.registerTabTitle" javaScriptEscape="true"/>',
		newRegisterTabTitle: '<spring:message code="At4FrameworkIntranet.app.newRegisterTabTitle" javaScriptEscape="true"/>',
		startTabTitle: '<spring:message code="At4FrameworkIntranet.app.startTabTitle" javaScriptEscape="true"/>',
		sessionExpiredTitle: '<spring:message code="At4FrameworkIntranet.app.sessionExpiredTitle" javaScriptEscape="true"/>',
		sessionExpiredMsg: '<spring:message code="At4FrameworkIntranet.app.sessionExpiredMsg" javaScriptEscape="true"/>',
		
		menuSearchPlaceholder: '<spring:message code="At4FrameworkIntranet.app.menuSearchPlaceholder" javaScriptEscape="true"/>',
		salirTxt: '<spring:message code="At4FrameworkIntranet.app.salir" javaScriptEscape="true"/>',
		temaTxt: '<spring:message code="At4FrameworkIntranet.app.tema" javaScriptEscape="true"/>',
		olvidarEstadosTexto  	: '<spring:message code="At4FrameworkIntranet.app.olvidarEstadosTxt" javaScriptEscape="true"/>',
		borrarestadAplicacion   : '<spring:message code="At4FrameworkIntranet.app.borrarestadAplicacionTxt" javaScriptEscape="true"/>',
		mensajeReset			: '<spring:message code="At4FrameworkIntranet.app.mensajeResetTxt" javaScriptEscape="true"/>',
		//TODO: Especificos
		
		windowExpiredSesiontitle: '<spring:message code="At4FrameworkIntranet.app.sesionExpired.title" javaScriptEscape="true"/>',
		filterText: '<spring:message code="At4FrameworkIntranet.multiselectFilter.filterText" text="Introduzca un texto para filtrar..." javaScriptEscape="true"/>',
		error: '<spring:message code="At4FrameworkIntranet.app.error" javaScriptEscape="true"/>'
	});
}

if(At4FrameworkIntranet.ComboBox) {
  	Ext.apply(At4FrameworkIntranet.ComboBox.prototype, {
    	loadingText          : '<spring:message code="At4FrameworkIntranet.ComboBox.loadingText" javaScriptEscape="true"/>',
    	cifIncorrectoTexto   : '<spring:message code="At4FrameworkIntranet.ComboBox.cifIncorrectoTexto" javaScriptEscape="true"/>'
    	
  	});
}

if(At4FrameworkIntranet.ItemSelector) {
  	Ext.apply(At4FrameworkIntranet.ItemSelector.prototype, {
    	toLegend          	: '<spring:message code="At4FrameworkIntranet.ItemSelector.toLegend" javaScriptEscape="true"/>',
    	fromLegend          : '<spring:message code="At4FrameworkIntranet.ItemSelector.fromLegend" javaScriptEscape="true"/>'
  	});
}

if(At4FrameworkIntranet.BaseForm) {
  	Ext.apply(At4FrameworkIntranet.BaseForm.prototype, {
    	eliminarTxt          	: '<spring:message code="At4FrameworkIntranet.BaseForm.eliminarTxt" javaScriptEscape="true"/>',
    	actualizarTxt          	: '<spring:message code="At4FrameworkIntranet.BaseForm.actualizarTxt" javaScriptEscape="true"/>',
    	cerrarTxt            	: '<spring:message code="At4FrameworkIntranet.BaseForm.cerrarTxt" javaScriptEscape="true"/>',
        ejecutandoTxt			: '<spring:message code="At4FrameworkIntranet.BaseForm.ejecutandoTxt" javaScriptEscape="true"/>',
        espereTxt 				: '<spring:message code="At4FrameworkIntranet.BaseForm.espereTxt" javaScriptEscape="true"/>',
        borrarRegistroTxt		: '<spring:message code="At4FrameworkIntranet.BaseForm.borrarRegistroTxt" javaScriptEscape="true"/>',
        seguroTxt				: '<spring:message code="At4FrameworkIntranet.BaseForm.seguroTxt" javaScriptEscape="true"/>',
        anyadidoTxt				: '<spring:message code="At4FrameworkIntranet.BaseForm.anyadidoTxt" javaScriptEscape="true"/>',
        actualizadoTxt			: '<spring:message code="At4FrameworkIntranet.BaseForm.actualizadoTxt" javaScriptEscape="true"/>',
        eliminadoTxt			: '<spring:message code="At4FrameworkIntranet.BaseForm.eliminadoTxt" javaScriptEscape="true"/>',
        actualizarRegistroTxt      : '<spring:message code="At4FrameworkIntranet.BaseForm.actualizarRegistroTxt" javaScriptEscape="true"/>',
        camposObligatoriosTxt      : '<spring:message code="At4FrameworkIntranet.BaseForm.camposObligatoriosTxt" javaScriptEscape="true"/>'
  	});
}

if(At4FrameworkIntranet.BasicPanel) {
  	Ext.apply(At4FrameworkIntranet.BasicPanel.prototype, {
        nuevoTxt				: '<spring:message code="At4FrameworkIntranet.BasicPanel.nuevoTxt" javaScriptEscape="true"/>',
        borrarTxt				: '<spring:message code="At4FrameworkIntranet.BasicPanel.borrarTxt" javaScriptEscape="true"/>',
        editarTxt				: '<spring:message code="At4FrameworkIntranet.BasicPanel.editarTxt" javaScriptEscape="true"/>',
        eliminadoTxt			: '<spring:message code="At4FrameworkIntranet.BaseForm.eliminadoTxt" javaScriptEscape="true"/>',
        ejecutandoTxt			: '<spring:message code="At4FrameworkIntranet.BaseForm.ejecutandoTxt" javaScriptEscape="true"/>',
        espereTxt 				: '<spring:message code="At4FrameworkIntranet.BaseForm.espereTxt" javaScriptEscape="true"/>',
        borrarRegistroTxt		: '<spring:message code="At4FrameworkIntranet.BaseForm.borrarRegistroTxt" javaScriptEscape="true"/>',
        seguroTxt				: '<spring:message code="At4FrameworkIntranet.BaseForm.seguroTxt" javaScriptEscape="true"/>',
        cambiarTamanoTexto		: '<spring:message code="At4FrameworkIntranet.BasicPanel.cambiarTamanoTexto" javaScriptEscape="true"/>',
        reorderTxt		        : '<spring:message code="At4FrameworkIntranet.BasicPanel.reorderTxt" javaScriptEscape="true"/>',
        
        
        //TODO: específicos
        desasociarTxt			: '<spring:message code="At4FrameworkIntranet.BasicPanel.desasociarTxt" javaScriptEscape="true"/>',
        desasociadoTxt			: '<spring:message code="At4FrameworkIntranet.BaseForm.desasociadoTxt" javaScriptEscape="true"/>',
        desasociarRegistroTxt	: '<spring:message code="At4FrameworkIntranet.BaseForm.desasociarRegistroTxt" javaScriptEscape="true"/>',
        
        //garrom: Strings que deberian estar pero no estan
    	modificadosElementosText : '<spring:message code="At4FrameworkIntranet.BasicPanel.modificadosElementosText" javaScriptEscape="true"/>',
     	modificadoElementoText : '<spring:message code="At4FrameworkIntranet.BasicPanel.modificadoElementoText" javaScriptEscape="true"/>',
     	
     	
     	aplicarReorden : '<spring:message code="At4FrameworkIntranet.BasicPanel.aplicarReorden" javaScriptEscape="true"/>',
     	cancelarReorden : '<spring:message code="At4FrameworkIntranet.BasicPanel.cancelarReorden" javaScriptEscape="true"/>'

  	});
}

if(At4FrameworkIntranet.FilePanel) {
  	Ext.override(At4FrameworkIntranet.FilePanel, {
        descargarArchivoTxt: '<spring:message code="forms.general.columns.descarregarArxiu" javaScriptEscape="true"/>'
        ,eliminarArchivoTxt: '<spring:message code="forms.general.columns.eliminarArxiu" javaScriptEscape="true"/>'
		,eliminarArchivoInformacionTxt: '<spring:message code="forms.general.columns.eliminarArxiu.informacio" javaScriptEscape="true"/>'
		,eliminarArchivoConfirmacionTxt: '<spring:message code="forms.general.columns.eliminarArxiu.confirmacio" javaScriptEscape="true"/>'
		,eliminarArchivoCorrectoTxt: '<spring:message code="forms.general.columns.eliminarArxiu.correcte" javaScriptEscape="true"/>'
		,eliminarArchivoErrorTxt:'<spring:message code="forms.general.columns.eliminarArxiu.error" javaScriptEscape="true"/>'
		,subirArchivoTxt:'<spring:message code="forms.general.columns.afegirArxiu.afegir" javaScriptEscape="true"/>'
		,subirArchivoInformacionTxt:'<spring:message code="forms.general.columns.afegirArxiu.informacio" javaScriptEscape="true"/>'
		,subirArchivoCorrectoTxt:'<spring:message code="forms.general.columns.afegirArxiu.correcte" javaScriptEscape="true"/>'
		,subirArchivoErrorTxt:'<spring:message code="forms.general.columns.afegirArxiu.error" javaScriptEscape="true"/>'
		,comprobarConstrainsTxt:'<spring:message code="forms.general.columns.imageConstrains.buttonTitle" javaScriptEscape="true"/>'
		,cargandoConstrainsTxt:'<spring:message code="forms.general.columns.imageConstrains.cargando" javaScriptEscape="true"/>'
		,errorConstrainsTxt:'<spring:message code="forms.general.columns.imageConstrains.error" javaScriptEscape="true"/>'
						
  		
  	});
}

if(At4FrameworkIntranet.ListadoGrid) {
    Ext.override(At4FrameworkIntranet.ListadoGrid, {
		yesText					: "<spring:message code="Ext.grid.filter.Boolean.yesText" text="Si" javaScriptEscape="true"/>",
		noText					: "<spring:message code="Ext.grid.filter.Boolean.noText" text="No" javaScriptEscape="true"/>",
	    abrirText				: '<spring:message code="At4FrameworkIntranet.ListadoGrid.abrirText" javaScriptEscape="true"/>',
	    accionesText			: '<spring:message code="At4FrameworkIntranet.ListadoGrid.accionesText" javaScriptEscape="true"/>',
	    eliminarText			: '<spring:message code="At4FrameworkIntranet.ListadoGrid.eliminarText" javaScriptEscape="true"/>',
	    limpiarFiltrosText		: '<spring:message code="At4FrameworkIntranet.ListadoGrid.limpiarFiltrosText" javaScriptEscape="true"/>',
	    limpiarFiltrosTipText	: '<spring:message code="At4FrameworkIntranet.ListadoGrid.limpiarFiltrosTipText" javaScriptEscape="true"/>', 
		nuevoText				: '<spring:message code="At4FrameworkIntranet.ListadoGrid.nuevoText" javaScriptEscape="true"/>',
		nuevoTipText			: '<spring:message code="At4FrameworkIntranet.ListadoGrid.nuevoTipText" javaScriptEscape="true"/>',
	    exportarText			: '<spring:message code="At4FrameworkIntranet.ListadoGrid.exportarText" javaScriptEscape="true"/>',
	    exportarTipText			: '<spring:message code="At4FrameworkIntranet.ListadoGrid.exportarTipText" javaScriptEscape="true"/>',
	    cargandoText			: '<spring:message code="At4FrameworkIntranet.ListadoGrid.cargandoText" javaScriptEscape="true"/>',
	    noPuedeMoverColumnaText	: '<spring:message code="At4FrameworkIntranet.ListadoGrid.noPuedeMoverColumnaText" javaScriptEscape="true"/>',
	    borrarRegistroTxt		: '<spring:message code="At4FrameworkIntranet.ListadoGrid.borrarRegistroTxt" javaScriptEscape="true"/>',
    	borrarSeguroTxt			: '<spring:message code="At4FrameworkIntranet.ListadoGrid.borrarSeguroTxt" javaScriptEscape="true"/>',
    	olvidarEstadoTexto		: '<spring:message code="At4FrameworkIntranet.ListadoGrid.olvidarEstadoTexto" javaScriptEscape="true"/>',
    	borrarEstadoListado		: '<spring:message code="At4FrameworkIntranet.ListadoGrid.borrarEstadoListado" javaScriptEscape="true"/>',
    	mensajeEstado			: '<spring:message code="At4FrameworkIntranet.ListadoGrid.mensajeEstado" javaScriptEscape="true"/>',
    	resetListadoTexto		: '<spring:message code="At4FrameworkIntranet.ListadoGrid.resetListadoTexto" javaScriptEscape="true"/>',
		
				
		configMenuAvanzadoHeaderLabel   : '<spring:message code="At4FrameworkIntranet.ListadoGrid.avanzado" javaScriptEscape="true"/>',
		herramientasText    			: '<spring:message code="At4FrameworkIntranet.ListadoGrid.herramientas" javaScriptEscape="true"/>',
		configExportWindowTitle   		: '<spring:message code="At4FrameworkIntranet.ListadoGrid.exportWindowTitle" javaScriptEscape="true"/>',
		configMenuGuardarHeaderLabel   	: '<spring:message code="At4FrameworkIntranet.ListadoGrid.configGuardar" javaScriptEscape="true"/>',
		configMenuAplicarHeaderLabel   	: '<spring:message code="At4FrameworkIntranet.ListadoGrid.configAplicar" javaScriptEscape="true"/>',
		configMenuReiniciarHeaderLabel 	: '<spring:message code="At4FrameworkIntranet.ListadoGrid.configReiniciar" javaScriptEscape="true"/>',
		groupByTextLabel   				: '<spring:message code="At4FrameworkIntranet.ListadoGrid.groupByLabel" javaScriptEscape="true"/>',
		showGroupsTextLabel   			: '<spring:message code="At4FrameworkIntranet.ListadoGrid.showGroupsLabel" javaScriptEscape="true"/>'
	
    });
}

if(At4FrameworkIntranet.RepeatPasswordField){
    Ext.apply(At4FrameworkIntranet.RepeatPasswordField, {
       passwordText : '<spring:message code="At4FrameworkIntranet.RepeatPasswordField.passwordText" javaScriptEscape="true"/>'
    });
}

if(Ext.form.field.File) {
    Ext.override(Ext.form.field.File, {

	    buttonText: '<spring:message code="forms.uploadfileform.browse" javaScriptEscape="true"/>'

    });
}

if(Ext.enableDWRUploadFile){
    Ext.apply(Ext.enableDWRUploadFile.prototype, {
       	buttonIcon		: '<spring:message code="forms.uploadfileform.opendialogbutton.icon" javaScriptEscape="true"/>',
       	buttonText		: '<spring:message code="forms.uploadfileform.opendialogbutton.text" javaScriptEscape="true"/>', 
       	fieldLabel		: '<spring:message code="forms.uploadfileform.newproject" javaScriptEscape="true"/>',
        windowTitle		: '<spring:message code="forms.uploadfileform.window.title" javaScriptEscape="true"/>',
        uploadButtonText: '<spring:message code="forms.uploadfileform.uploadbutton.text" javaScriptEscape="true"/>',
        uploadButtonIcon: '<spring:message code="forms.uploadfileform.uploadbutton.icon" javaScriptEscape="true"/>',
        closeButtonText : '<spring:message code="forms.uploadfileform.closedialogbutton.text" javaScriptEscape="true"/>',
        closeButtonIcon : '<spring:message code="forms.uploadfileform.closedialogbutton.icon" javaScriptEscape="true"/>'
    });
}



if(Ext.grid.header.Container) {
    Ext.override(Ext.grid.header.Container, {
    sortAscText: '<spring:message code="Ext.grid.header.Container.sortDescText" text="Sort asc" javaScriptEscape="true"/>',

    sortDescText: '<spring:message code="Ext.grid.header.Container.sortAscText" text="Sort desc" javaScriptEscape="true"/>',

    sortClearText: '<spring:message code="Ext.grid.header.Container.sortClearText" text="sort clear" javaScriptEscape="true"/>',

    columnsText: '<spring:message code="Ext.grid.header.Container.columnsText" text="Columns text" javaScriptEscape="true"/>',    
    })
}



if(Ext.grid.filters.filter.Boolean) {
    Ext.apply(Ext.grid.filters.filter.Boolean.prototype, {
		yesText: "<spring:message code="Ext.grid.filter.Boolean.yesText" text="Si" javaScriptEscape="true"/>",
		noText:  "<spring:message code="Ext.grid.filter.Boolean.noText" text="No" javaScriptEscape="true"/>"
    });
}

if(Ext.grid.filters.filter.Date) {
    Ext.override(Ext.grid.filters.filter.Date, {
	    config:{
	    	fields: {
		    	lt: { text: '<spring:message code="Ext.grid.filter.Date.beforeText" text="Antes" javaScriptEscape="true"/>'},
		    	gt: { text: '<spring:message code="Ext.grid.filter.Date.afterText" text="Después" javaScriptEscape="true"/>'},
		    	eq: { text: '<spring:message code="Ext.grid.filter.Date.onText" text="En" javaScriptEscape="true"/>'}
	    	},
		    pickerDefaults: {
	            xtype: 'datepicker',
	            border: 0
	        },
	        updateBuffer: 0,
	        dateFormat: undefined
	    }
    });
}


if(At4FrameworkIntranet.MultiList){
    Ext.override(At4FrameworkIntranet.MultiList, {
    	filterText: '<spring:message code="At4FrameworkIntranet.multiselectFilter.filterText" javaScriptEscape="true"/>',
    	elemSelec: '<spring:message code="At4FrameworkIntranet.multiselectFilter.elemSelec" javaScriptEscape="true"/>'
    })
}

if(Ext.grid.filters.filter.String) {
    Ext.override(Ext.grid.filters.filter.String, {
    	emptyText: '<spring:message code="Ext.grid.filter.String.emptyText" text="Introduzca un texto para filtrar..." javaScriptEscape="true"/>'
    })
}

if(Ext.grid.filters.filter.Number) {
    Ext.override(Ext.grid.filters.filter.Number, {
    	emptyText: '<spring:message code="Ext.grid.filter.Number.emptyText" text="Introduzca un valor" javaScriptEscape="true"/>'
    })
}

if(At4FrameworkIntranet.FormDefaults){
	Ext.override(At4FrameworkIntranet.FormDefaults,{
		resumenAuditoriaTitleText: '<spring:message code="forms.resumenAuditoria.header" javaScriptEscape="true"/>',
	
		resumenAuditoriaModUserTextLabel:'<spring:message code="forms.resumenAuditoria.usuarioModificacion.title" javaScriptEscape="true"/>',
		resumenAuditoriaModUserTextQtip: '<spring:message code="forms.resumenAuditoria.usuarioModificacion.description" javaScriptEscape="true"/>',
		resumenAuditoriaCreatorUserTextLabel: '<spring:message code="forms.resumenAuditoria.usuarioCreacion.title" javaScriptEscape="true"/>',
		resumenAuditoriaCreatorUserTextQtip: '<spring:message code="forms.resumenAuditoria.usuarioCreacion.description" javaScriptEscape="true"/>',
	
		resumenAuditoriaModDateTextLabel: '<spring:message code="forms.resumenAuditoria.fechaModificacion.title" javaScriptEscape="true"/>',
		resumenAuditoriaModDateTextQtip: '<spring:message code="forms.resumenAuditoria.fechaModificacion.description" javaScriptEscape="true"/>',
		resumenAuditoriaCreatorDateTextLabel: '<spring:message code="forms.resumenAuditoria.fechaCreacion.title" javaScriptEscape="true"/>',
		resumenAuditoriaCreatorDateTextQtip: '<spring:message code="forms.resumenAuditoria.fechaCreacion.description" javaScriptEscape="true"/>',
	});
}



if(At4FrameworkIntranet.ExportWindow){
    Ext.override(At4FrameworkIntranet.ExportWindow, {
		title			: '<spring:message code="At4FrameworkIntranet.ExportWindow.title" javaScriptEscape="true"/>',
		cargarTxt		: '<spring:message code="At4FrameworkIntranet.ExportWindow.cargarTxt" javaScriptEscape="true"/>',
		seleccionarTxt	: '<spring:message code="At4FrameworkIntranet.ExportWindow.seleccionarTxt" javaScriptEscape="true"/>',
		borrarTxt		: '<spring:message code="At4FrameworkIntranet.ExportWindow.borrarTxt" javaScriptEscape="true"/>',
    });
}

if(At4FrameworkIntranet.ExportForm){
    Ext.override(At4FrameworkIntranet.ExportForm, {
		formatoTxt			: '<spring:message code="At4FrameworkIntranet.ExportForm.formatoTxt" javaScriptEscape="true"/>',
		columnasTxt			: '<spring:message code="At4FrameworkIntranet.ExportForm.columnasTxt" javaScriptEscape="true"/>',
		configuracionTxt	: '<spring:message code="At4FrameworkIntranet.ExportForm.configuracionTxt" javaScriptEscape="true"/>',
		cargarTxt			: '<spring:message code="At4FrameworkIntranet.ExportForm.cargarTxt" javaScriptEscape="true"/>',
		guardarTxt			: '<spring:message code="At4FrameworkIntranet.ExportForm.guardarTxt" javaScriptEscape="true"/>',
		reiniciarTxt		: '<spring:message code="At4FrameworkIntranet.ExportForm.reiniciarTxt" javaScriptEscape="true"/>',
		borrarTxt			: '<spring:message code="At4FrameworkIntranet.ExportForm.borrarTxt" javaScriptEscape="true"/>',
		cerrarTxt			: '<spring:message code="At4FrameworkIntranet.ExportForm.cerrarTxt" javaScriptEscape="true"/>',
		exportarTxt			: '<spring:message code="At4FrameworkIntranet.ExportForm.exprotarTxt" javaScriptEscape="true"/>',
    });
}

if(At4FrameworkIntranet.ExportBasePrompt){
    Ext.override(At4FrameworkIntranet.ExportBasePrompt, {
		inputLabelTxt					: '<spring:message code="At4FrameworkIntranet.ExportBasePrompt.inputLabelTxt" javaScriptEscape="true"/>',
		sobrescribirLabelTxt			: '<spring:message code="At4FrameworkIntranet.ExportBasePrompt.sobrescribirLabelTxt" javaScriptEscape="true"/>',
		configuracionPrivadaLabelTxt	: '<spring:message code="At4FrameworkIntranet.ExportBasePrompt.configuracionPrivadaLabelTxt" javaScriptEscape="true"/>',
		guardarLabel					: '<spring:message code="At4FrameworkIntranet.ExportBasePrompt.guardarLabel" javaScriptEscape="true"/>',
		cancelarLabel					: '<spring:message code="At4FrameworkIntranet.ExportBasePrompt.cancelarLabel" javaScriptEscape="true"/>',
		stateSaveSuccessTxt				: '<spring:message code="At4FrameworkIntranet.ExportBasePrompt.stateSaveSuccessTxt" javaScriptEscape="true"/>',
		stateSaveErrorTxt				: '<spring:message code="At4FrameworkIntranet.ExportBasePrompt.stateSaveErrorTxt" javaScriptEscape="true"/>',
		expcfgSaveSuccessTxt			: '<spring:message code="At4FrameworkIntranet.ExportBasePrompt.expcfgSaveSuccessTxt" javaScriptEscape="true"/>',
		expcfgSaveErrorTxt				: '<spring:message code="At4FrameworkIntranet.ExportBasePrompt.expcfgSaveErrorTxt" javaScriptEscape="true"/>',

		borrarMsgTitle					: '<spring:message code="At4FrameworkIntranet.ExportBasePrompt.borrarMsgTitle" javaScriptEscape="true"/>',
		borrarMsgMessage				: '<spring:message code="At4FrameworkIntranet.ExportBasePrompt.borrarMsgMessage" javaScriptEscape="true"/>',
		borrarMsgOkTitle				: '<spring:message code="At4FrameworkIntranet.ExportBasePrompt.borrarMsgOkTitle" javaScriptEscape="true"/>',
		borrarMsgOk						: '<spring:message code="At4FrameworkIntranet.ExportBasePrompt.borrarMsgOk" javaScriptEscape="true"/>',
		borrarMsgKoTitle				: '<spring:message code="At4FrameworkIntranet.ExportBasePrompt.borrarMsgKoTitle" javaScriptEscape="true"/>',
		borrarMsgKo						: '<spring:message code="At4FrameworkIntranet.ExportBasePrompt.borrarMsgKo" javaScriptEscape="true"/>',
    });
}




