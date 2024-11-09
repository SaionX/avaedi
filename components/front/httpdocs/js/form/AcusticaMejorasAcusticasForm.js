//Namespace de  At4FrameworkIntranet
Ext.namespace('At4FrameworkIntranet');

/**
 * @class At4FrameworkIntranet.AcusticaMejorasAcusticasForm
 * Contiene la configuración del formulario: AcusticaMejorasAcusticas
 * @author garrom
 * @constructor
 * @extends At4FrameworkIntranet.BasicForm
 * @param {Object} application La aplicación que contiene el formulario, normalmente será {@link At4FrameworkIntranet.app}
 * @param {String} formName Nombre del formulario
 * @param {Object} gridMetaData Configuración gridMetadata
 * @param {Object} config Configuración para Ext.form.FormPanel
 */

Ext.define("At4FrameworkIntranet.AcusticaMejorasAcusticasForm", {
	extend: "At4FrameworkIntranet.InspeccionBaseForm",
	constructor: function (application, formName, gridMetaData, config) {
		Ext.apply(this, config);
		var tabHelper = new At4util.tabIndexHelper(this.tabIndex);

		var columnDefaults = At4FrameworkIntranet.FormDefaults.COLUMN_DEFAULTS;
		var fieldDefaults = At4FrameworkIntranet.FormDefaults.FIELD_DEFAULTS;


		var fields = {}

		fields.claveInforme = new Ext.form.NumberField({
				name: 'id.claveInforme',
				fieldLabel: this.claveInformeHeaderLabel,
				tabIndex: tabHelper.getNext(),
				width: At4FrameworkIntranet.FormDefaults.size(2, 3, 15),
				disableUpdates: true,
				disabled: true,
				hideTrigger: true,
				allowBlank: false,
				allowDecimals: false,
				maxValue: 2147483647
			})
		fields.mejorasOrden = new Ext.form.NumberField({
			name: 'id.mejorasOrden',
			fieldLabel: this.mejorasOrdenHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 3, 12),
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


		fields.inspeccionId = Ext.create("Ext.ux.at4.OneToOneField", {
			name: 'inspeccionId',
			fieldLabel: this.inspeccionHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 3, 16),
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
			width: At4FrameworkIntranet.FormDefaults.size(3, 3, 12),
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
			width: At4FrameworkIntranet.FormDefaults.size(3, 3, 12),
			store: proteccionRuidoInstalacionesTipoIdStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var proteccionRuidoInteriorImpactosTipoIdStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'proteccionRuidoInteriorImpactosTipoId') {
				proteccionRuidoInteriorImpactosTipoIdStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var proteccionRuidoInteriorImpactosTipoIdStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: proteccionRuidoInteriorImpactosTipoIdStoreValues
		});

		fields.proteccionRuidoInteriorImpactosTipoId = Ext.create('Ext.form.ComboBox', {
			name: 'proteccionRuidoInteriorImpactosTipoId',
			fieldLabel: this.proteccionRuidoInteriorImpactosTipoIdHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.proteccionRuidoInteriorImpactosTipoIdDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 3, 12),
			store: proteccionRuidoInteriorImpactosTipoIdStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var proteccionRuidoInteriorAereoTipoIdStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'proteccionRuidoInteriorAereoTipoId') {
				proteccionRuidoInteriorAereoTipoIdStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var proteccionRuidoInteriorAereoTipoIdStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: proteccionRuidoInteriorAereoTipoIdStoreValues
		});

		fields.proteccionRuidoInteriorAereoTipoId = Ext.create('Ext.form.ComboBox', {
			name: 'proteccionRuidoInteriorAereoTipoId',
			fieldLabel: this.proteccionRuidoInteriorAereoTipoIdHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.proteccionRuidoInteriorAereoTipoIdDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 3, 12),
			store: proteccionRuidoInteriorAereoTipoIdStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})
		
		fields.mejorasAnalisisTecnico = new Ext.form.TextField({
			name: 'mejorasAnalisisTecnico',
			fieldLabel: this.mejorasAnalisisTecnicoHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 3, 12),
			maxLength: 255
		})
		
		fields.mejorasValoracionEconomica = new Ext.form.TextField({
			name: 'mejorasValoracionEconomica',
			fieldLabel: this.mejorasValoracionEconomicaHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 3, 12),
			maxLength: 255
		})
		fields.mejorasDescripcion = new Ext.form.TextField({
			name: 'mejorasDescripcion',
			fieldLabel: this.mejorasDescripcionHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(5, 3, 12),
			maxLength: 255
		})
		fields.mejorasObservaciones = new Ext.form.TextArea({
			name: 'mejorasObservaciones',
			fieldLabel: this.mejorasObservacionesHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(12, 0, 12),
			maxLength: 255
		})
		fields.potencialObservaciones = new Ext.form.TextArea({
			name: 'potencialObservaciones',
			fieldLabel: this.potencialObservacionesHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(4, 2, 12),
			maxLength: 255
		})
		fields.incidenciaTexto = new Ext.form.TextField({
			name: 'incidenciaTexto',
			fieldLabel: this.incidenciaTextoHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(4, 2, 12),
			maxLength: 255
		})
		fields.incidenciaObservaciones = new Ext.form.TextArea({
			name: 'incidenciaObservaciones',
			fieldLabel: this.incidenciaObservacionesHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(4, 2, 12),
			maxLength: 255
		})

		this.fields = fields;
		var items = [{
			xtype: 'At4Framework-fieldmainpanel',
			items: [
				At4FrameworkIntranet.FormDefaults.rows([
					[fields.claveInforme, fields.mejorasOrden, fields.edificio, fields.inspeccionId],
					[{

						xtype: 'fieldset',
						border: true,
						title: this.proteccionTitleLabel,
						items: [{
							xtype: "At4Framework-rowContainer",
							minWidth: false,
							items: [fields.proteccionRuidoExteriorTipoId, fields.proteccionRuidoInstalacionesTipoId, fields.proteccionRuidoInteriorImpactosTipoId, fields.proteccionRuidoInteriorAereoTipoId]

						}]

					}],
					[{

						xtype: 'fieldset',
						border: true,
						title: this.mejorasTitleLabel,
						items: [{
							xtype: "At4Framework-rowContainer",
							minWidth: false,
							items: [fields.mejorasAnalisisTecnico, fields.mejorasValoracionEconomica, fields.mejorasDescripcion]

						}, {
							xtype: "At4Framework-rowContainer",
							minWidth: false,
							items: [fields.mejorasObservaciones]

						}]

					}],
					[fields.potencialObservaciones, fields.incidenciaTexto, fields.incidenciaObservaciones],
					[At4FrameworkIntranet.FormDefaults.resumenAuditoria()]
				])
			]
		}];



		this.maxTabIndex = tabHelper.getNext();
		this.callParent([application, formName, gridMetaData, items, config]);
	}
});
