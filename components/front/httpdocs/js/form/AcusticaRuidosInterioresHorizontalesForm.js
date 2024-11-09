//Namespace de  At4FrameworkIntranet
Ext.namespace('At4FrameworkIntranet');

/**
 * @class At4FrameworkIntranet.AcusticaRuidosInterioresHorizontalesForm
 * Contiene la configuración del formulario: AcusticaRuidosInterioresHorizontales
 * @author garrom
 * @constructor
 * @extends At4FrameworkIntranet.BasicForm
 * @param {Object} application La aplicación que contiene el formulario, normalmente será {@link At4FrameworkIntranet.app}
 * @param {String} formName Nombre del formulario
 * @param {Object} gridMetaData Configuración gridMetadata
 * @param {Object} config Configuración para Ext.form.FormPanel
 */

Ext.define("At4FrameworkIntranet.AcusticaRuidosInterioresHorizontalesForm", {
	extend: "At4FrameworkIntranet.InspeccionBaseForm",
	constructor: function (application, formName, gridMetaData, config) {
		Ext.apply(this, config);
		var tabHelper = new At4util.tabIndexHelper(this.tabIndex);

		var columnDefaults = At4FrameworkIntranet.FormDefaults.COLUMN_DEFAULTS;
		var fieldDefaults = At4FrameworkIntranet.FormDefaults.FIELD_DEFAULTS;


		var fields = {}

		fields.claveInforme = new Ext.form.NumberField({
			name: 'claveInforme',
			fieldLabel: this.claveInformeHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 2, 10),
			disableUpdates: true,
			disabled: true,
			hideTrigger: true,
			allowBlank: false,
			allowDecimals: false,
			maxValue: 2147483647
		})

		fields.edificio = new At4FrameworkIntranet.RelatedBox({
			name: 'edificioId',
			fieldLabel: this.edificioHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(6, 2, 10),
			relatedIconCls: "glyphicons glyphicons-building",
			relatedForm: 'edificio'
		})

		/*fields.inspeccion = new At4FrameworkIntranet.ComboBox({
		    name: 'inspeccionId',
		    fieldLabel: this.inspeccionHeaderLabel,
		    tabIndex: tabHelper.getNext(),
		    width: At4FrameworkIntranet.FormDefaults.size(3, 3, 15),
		    allowBlank: false,
		    store: At4FrameworkIntranet.FormDefaults.getStore('Inspeccion'),
		    recordPK: 'id',
		    relatedForm: 'inspeccion'
		})*/


		fields.inspeccionId = Ext.create("Ext.ux.at4.OneToOneField", {
			name: 'inspeccionId',
			fieldLabel: this.inspeccionHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 2, 10),
			border: true,
			application: application,
			relatedIconCls: "",
			relatedForm: 'inspeccion'
		})
		fields.plantatipoCantoForjado = new Ext.form.TextField({
			name: 'plantatipoCantoForjado',
			fieldLabel: this.plantatipoCantoForjadoHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(10, 0, 10),
			maxLength: 255
		})
		fields.forjadoPlantatipoOtro = new Ext.form.TextField({
			name: 'forjadoPlantatipoOtro',
			fieldLabel: this.forjadoPlantatipoOtroHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(10, 0, 10),
			maxLength: 255
		})
		fields.plantagarajeCantoForjado = new Ext.form.TextField({
			name: 'plantagarajeCantoForjado',
			fieldLabel: this.plantagarajeCantoForjadoHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(10, 0, 10),
			maxLength: 255
		})

		fields.forjadoPlantagarajeOtro = new Ext.form.TextField({
			name: 'forjadoPlantagarajeOtro',
			fieldLabel: this.forjadoPlantagarajeOtroHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(10, 0, 10),
			maxLength: 255
		})

		var sueloFlotanteTieneStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'sueloFlotanteTiene') {
				sueloFlotanteTieneStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var sueloFlotanteTieneStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: sueloFlotanteTieneStoreValues
		});

		fields.sueloFlotanteTiene = Ext.create('Ext.form.ComboBox', {
			name: 'sueloFlotanteTiene',
			fieldLabel: this.sueloFlotanteTieneHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(1, 0, 10),
			store: sueloFlotanteTieneStore,
			queryMode: 'local',
			labelStyle: 'white-space: nowrap',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var techoSuspendidoTieneStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'techoSuspendidoTiene') {
				techoSuspendidoTieneStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var techoSuspendidoTieneStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: techoSuspendidoTieneStoreValues
		});

		fields.techoSuspendidoTiene = Ext.create('Ext.form.ComboBox', {
			name: 'techoSuspendidoTiene',
			fieldLabel: this.techoSuspendidoTieneHeaderLabel,
			tabIndex: tabHelper.getNext(),
			labelStyle: 'white-space: nowrap',
			width: At4FrameworkIntranet.FormDefaults.size(1, 0, 10),
			store: techoSuspendidoTieneStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var estadoBuenoStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'estadoBueno') {
				estadoBuenoStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var estadoBuenoStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: estadoBuenoStoreValues
		});

		fields.estadoBueno = Ext.create('Ext.form.ComboBox', {
			name: 'estadoBueno',
			fieldLabel: this.estadoBuenoHeaderLabel,
			tabIndex: tabHelper.getNext(),
			labelStyle: 'white-space: nowrap',
			width: At4FrameworkIntranet.FormDefaults.size(1, 0, 10),
			store: estadoBuenoStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		fields.deficienciasObservaciones = new Ext.form.TextArea({
			name: 'deficienciasObservaciones',
			fieldLabel: this.deficienciasObservacionesHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(10, 0, 10),
			maxLength: 255
		})

		var caracteristicasSueloFlotanteRevestidasStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'caracteristicasSueloFlotanteRevestidas') {
				caracteristicasSueloFlotanteRevestidasStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var caracteristicasSueloFlotanteRevestidasStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: caracteristicasSueloFlotanteRevestidasStoreValues
		});

		fields.caracteristicasSueloFlotanteRevestidas = Ext.create('Ext.form.ComboBox', {
			name: 'caracteristicasSueloFlotanteRevestidas',
			fieldLabel: this.caracteristicasSueloFlotanteRevestidasHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.caracteristicasSueloFlotanteRevestidasDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			labelStyle: 'white-space: nowrap',
			width: At4FrameworkIntranet.FormDefaults.size(1, 0, 10),
			margin: "0, "+At4FrameworkIntranet.FormDefaults.size(4, 1, 10)+", 0, 11",
			store: caracteristicasSueloFlotanteRevestidasStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var caracteristicasSueloFlotanteContactoDirectoStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'caracteristicasSueloFlotanteContactoDirecto') {
				caracteristicasSueloFlotanteContactoDirectoStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var caracteristicasSueloFlotanteContactoDirectoStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: caracteristicasSueloFlotanteContactoDirectoStoreValues
		});

		fields.caracteristicasSueloFlotanteContactoDirecto = Ext.create('Ext.form.ComboBox', {
			name: 'caracteristicasSueloFlotanteContactoDirecto',
			fieldLabel: this.caracteristicasSueloFlotanteContactoDirectoHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.caracteristicasSueloFlotanteContactoDirectoDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			labelStyle: 'white-space: nowrap',
			width: At4FrameworkIntranet.FormDefaults.size(1, 0, 10),
			margin: "0, "+At4FrameworkIntranet.FormDefaults.size(4, 1, 10)+", 0, 11",
			store: caracteristicasSueloFlotanteContactoDirectoStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})
		var caracteristicasCamaraAireContinuaStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'caracteristicasCamaraAireContinua') {
				caracteristicasCamaraAireContinuaStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var caracteristicasCamaraAireContinuaStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: caracteristicasCamaraAireContinuaStoreValues
		});

		fields.caracteristicasCamaraAireContinua = Ext.create('Ext.form.ComboBox', {
			name: 'caracteristicasCamaraAireContinua',
			fieldLabel: this.caracteristicasCamaraAireContinuaHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.caracteristicasCamaraAireContinuaDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			labelStyle: 'white-space: nowrap',
			width: At4FrameworkIntranet.FormDefaults.size(1, 0, 10),
			margin: "0, "+At4FrameworkIntranet.FormDefaults.size(4, 1, 10)+", 0, 11",
			store: caracteristicasCamaraAireContinuaStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var caracteristicasLuminariasEmpotradasSelladasStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'caracteristicasLuminariasEmpotradasSelladas') {
				caracteristicasLuminariasEmpotradasSelladasStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var caracteristicasLuminariasEmpotradasSelladasStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: caracteristicasLuminariasEmpotradasSelladasStoreValues
		});

		fields.caracteristicasLuminariasEmpotradasSelladas = Ext.create('Ext.form.ComboBox', {
			name: 'caracteristicasLuminariasEmpotradasSelladas',
			fieldLabel: this.caracteristicasLuminariasEmpotradasSelladasHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.caracteristicasLuminariasEmpotradasSelladasDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			labelStyle: 'white-space: nowrap',
			width: At4FrameworkIntranet.FormDefaults.size(1, 0, 10),
			margin: "0, "+At4FrameworkIntranet.FormDefaults.size(4, 1, 10)+", 0, 11",
			store: caracteristicasLuminariasEmpotradasSelladasStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})
		fields.observaciones = new Ext.form.TextArea({
			name: 'observaciones',
			fieldLabel: this.observacionesHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(10, 0, 10),
			maxLength: 255
		})

		this.fields = fields;
		var items = [{
			xtype: 'At4Framework-fieldmainpanel',
			items: [
				At4FrameworkIntranet.FormDefaults.rows([
					[fields.claveInforme, fields.edificio, fields.inspeccionId],



					[fields.plantatipoCantoForjado],
					[fields.forjadoPlantatipoOtro],

					[fields.plantagarajeCantoForjado],
					[fields.forjadoPlantagarajeOtro],
					[fields.sueloFlotanteTiene],
					[fields.techoSuspendidoTiene],
					[fields.estadoBueno],
					[fields.deficienciasObservaciones],
					[{

						xtype: 'fieldset',
						border: true,
						title: "Características",
						items: [{
							xtype: "At4Framework-rowContainer",
							minWidth: false,
							items: [fields.caracteristicasSueloFlotanteRevestidas, fields.caracteristicasSueloFlotanteContactoDirecto]

						}, {
							xtype: "At4Framework-rowContainer",
							minWidth: false,
							items: [fields.caracteristicasCamaraAireContinua, fields.caracteristicasLuminariasEmpotradasSelladas]

						}]

					}],



					[],
					[fields.observaciones],
					[At4FrameworkIntranet.FormDefaults.resumenAuditoria()]
				])
			]
		}];



		this.maxTabIndex = tabHelper.getNext();
		this.callParent([application, formName, gridMetaData, items, config]);
	}
});
