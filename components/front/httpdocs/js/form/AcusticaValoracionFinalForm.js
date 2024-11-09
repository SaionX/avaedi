//Namespace de  At4FrameworkIntranet
Ext.namespace('At4FrameworkIntranet');

/**
 * @class At4FrameworkIntranet.AcusticaValoracionFinalForm
 * Contiene la configuración del formulario: AcusticaValoracionFinal
 * @author garrom
 * @constructor
 * @extends At4FrameworkIntranet.BasicForm
 * @param {Object} application La aplicación que contiene el formulario, normalmente será {@link At4FrameworkIntranet.app}
 * @param {String} formName Nombre del formulario
 * @param {Object} gridMetaData Configuración gridMetadata
 * @param {Object} config Configuración para Ext.form.FormPanel
 */

Ext.define("At4FrameworkIntranet.AcusticaValoracionFinalForm", {
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
			width: At4FrameworkIntranet.FormDefaults.size(2, 1, 5),
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
			width: At4FrameworkIntranet.FormDefaults.size(6, 3, 12),
			relatedIconCls: "glyphicons glyphicons-building",
			relatedForm: 'edificio'
		})

		/*fields.inspeccion = new At4FrameworkIntranet.ComboBox({
		    name: 'inspeccionId',
		    fieldLabel: this.inspeccionHeaderLabel,
		    tabIndex: tabHelper.getNext(),
		    width: At4FrameworkIntranet.FormDefaults.size(3, 1, 5),
		    allowBlank: false,
		    store: At4FrameworkIntranet.FormDefaults.getStore('Inspeccion'),
		    recordPK: 'id',
		    relatedForm: 'inspeccion'
		})*/


		fields.inspeccionId = Ext.create("Ext.ux.at4.OneToOneField", {
			name: 'inspeccionId',
			fieldLabel: this.inspeccionHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 3, 15),
			border: true,
			application: application,
			relatedIconCls: "",
			relatedForm: 'inspeccion'
		})

		var proteccionRuidoExteriorTipoIdStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'proteccionRuidoExteriorTipoId') {
				proteccionRuidoExteriorTipoIdStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var proteccionRuidoExteriorTipoIdStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: proteccionRuidoExteriorTipoIdStoreValues
		});

		fields.proteccionRuidoExteriorTipoId = Ext.create('Ext.form.ComboBox', {
			name: 'proteccionRuidoExteriorTipoId',
			fieldLabel: this.proteccionRuidoExteriorTipoIdHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.proteccionRuidoExteriorTipoIdDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 2, 9),
			store: proteccionRuidoExteriorTipoIdStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var proteccionRuidoInstalacionesTipoIdStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'proteccionRuidoInstalacionesTipoId') {
				proteccionRuidoInstalacionesTipoIdStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var proteccionRuidoInstalacionesTipoIdStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: proteccionRuidoInstalacionesTipoIdStoreValues
		});

		fields.proteccionRuidoInstalacionesTipoId = Ext.create('Ext.form.ComboBox', {
			name: 'proteccionRuidoInstalacionesTipoId',
			fieldLabel: this.proteccionRuidoInstalacionesTipoIdHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.proteccionRuidoInstalacionesTipoIdDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 2, 9),
			store: proteccionRuidoInstalacionesTipoIdStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var proteccionRuidoInteriorAereoHorizontalTipoIdStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'proteccionRuidoInteriorAereoHorizontalTipoId') {
				proteccionRuidoInteriorAereoHorizontalTipoIdStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var proteccionRuidoInteriorAereoHorizontalTipoIdStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: proteccionRuidoInteriorAereoHorizontalTipoIdStoreValues
		});

		fields.proteccionRuidoInteriorAereoHorizontalTipoId = Ext.create('Ext.form.ComboBox', {
			name: 'proteccionRuidoInteriorAereoHorizontalTipoId',
			fieldLabel: this.proteccionRuidoInteriorAereoHorizontalTipoIdHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.proteccionRuidoInteriorAereoHorizontalTipoIdDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 2, 9),
			store: proteccionRuidoInteriorAereoHorizontalTipoIdStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var proteccionRuidoInteriorAereoVerticalTipoIdStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'proteccionRuidoInteriorAereoVerticalTipoId') {
				proteccionRuidoInteriorAereoVerticalTipoIdStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var proteccionRuidoInteriorAereoVerticalTipoIdStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: proteccionRuidoInteriorAereoVerticalTipoIdStoreValues
		});

		fields.proteccionRuidoInteriorAereoVerticalTipoId = Ext.create('Ext.form.ComboBox', {
			name: 'proteccionRuidoInteriorAereoVerticalTipoId',
			fieldLabel: this.proteccionRuidoInteriorAereoVerticalTipoIdHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.proteccionRuidoInteriorAereoVerticalTipoIdDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 2, 9),
			store: proteccionRuidoInteriorAereoVerticalTipoIdStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var proteccionRuidoInteriorImpactosHorizontalTipoIdStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'proteccionRuidoInteriorImpactosHorizontalTipoId') {
				proteccionRuidoInteriorImpactosHorizontalTipoIdStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var proteccionRuidoInteriorImpactosHorizontalTipoIdStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: proteccionRuidoInteriorImpactosHorizontalTipoIdStoreValues
		});

		fields.proteccionRuidoInteriorImpactosHorizontalTipoId = Ext.create('Ext.form.ComboBox', {
			name: 'proteccionRuidoInteriorImpactosHorizontalTipoId',
			fieldLabel: this.proteccionRuidoInteriorImpactosHorizontalTipoIdHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.proteccionRuidoInteriorImpactosHorizontalTipoIdDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 2, 9),
			store: proteccionRuidoInteriorImpactosHorizontalTipoIdStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var proteccionRuidoInteriorImpactosVerticalTipoIdStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'proteccionRuidoInteriorImpactosVerticalTipoId') {
				proteccionRuidoInteriorImpactosVerticalTipoIdStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var proteccionRuidoInteriorImpactosVerticalTipoIdStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: proteccionRuidoInteriorImpactosVerticalTipoIdStoreValues
		});

		fields.proteccionRuidoInteriorImpactosVerticalTipoId = Ext.create('Ext.form.ComboBox', {
			name: 'proteccionRuidoInteriorImpactosVerticalTipoId',
			fieldLabel: this.proteccionRuidoInteriorImpactosVerticalTipoIdHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.proteccionRuidoInteriorImpactosVerticalTipoIdDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 2, 9),
			store: proteccionRuidoInteriorImpactosVerticalTipoIdStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})
		
		fields.observaciones = new Ext.form.TextArea({
			name: 'observaciones',
			fieldLabel: this.observacionesHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(9.6, 0, 9.6),
			maxLength: 255
		})

		this.fields = fields;
		var items = [{
			xtype: 'At4Framework-fieldmainpanel',
			items: [
				At4FrameworkIntranet.FormDefaults.rows([
					[fields.claveInforme, fields.edificio, fields.inspeccionId],
					[{

						xtype: 'fieldset',
						border: true,
						title: "Protección ruido",
						items: [{
							xtype: "At4Framework-rowContainer",
							minWidth: false,
							items: [fields.proteccionRuidoExteriorTipoId, fields.proteccionRuidoInstalacionesTipoId, fields.proteccionRuidoInteriorAereoHorizontalTipoId],

						}, {
							xtype: "At4Framework-rowContainer",
							minWidth: false,
							items: [fields.proteccionRuidoInteriorAereoVerticalTipoId, fields.proteccionRuidoInteriorImpactosHorizontalTipoId, fields.proteccionRuidoInteriorImpactosVerticalTipoId],

						}]

					}],
					[fields.observaciones],
					[At4FrameworkIntranet.FormDefaults.resumenAuditoria()]
				]),
			]
		}];



		this.maxTabIndex = tabHelper.getNext();
		this.callParent([application, formName, gridMetaData, items, config]);
	}
});
