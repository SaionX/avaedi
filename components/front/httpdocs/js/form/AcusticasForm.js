//Namespace de  At4FrameworkIntranet
Ext.namespace('At4FrameworkIntranet');

/**
 * @class At4FrameworkIntranet.AcusticasForm
 * Contiene la configuración del formulario: Acusticas
 * @author garrom
 * @constructor
 * @extends At4FrameworkIntranet.BasicForm
 * @param {Object} application La aplicación que contiene el formulario, normalmente será {@link At4FrameworkIntranet.app}
 * @param {String} formName Nombre del formulario
 * @param {Object} gridMetaData Configuración gridMetadata
 * @param {Object} config Configuración para Ext.form.FormPanel
 */

Ext.define("At4FrameworkIntranet.AcusticasForm", {
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
				width: At4FrameworkIntranet.FormDefaults.size(2, 2, 12),
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
			width: At4FrameworkIntranet.FormDefaults.size(6, 2, 12),
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
			width: At4FrameworkIntranet.FormDefaults.size(3, 2, 8),
			border: true,
			application: application,
			relatedIconCls: "",
			relatedForm: 'inspeccion'
		})
		fields.tecnico = new Ext.form.TextField({
			name: 'tecnico',
			fieldLabel: this.tecnicoHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(8, 0, 8),
			maxLength: 255
		})
		fields.titulacion = new Ext.form.TextField({
			name: 'titulacion',
			fieldLabel: this.titulacionHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(8, 0, 8),
			maxLength: 255
		})

		var esTecnicoInspeccionStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'esTecnicoInspeccion') {
				esTecnicoInspeccionStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var esTecnicoInspeccionStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: esTecnicoInspeccionStoreValues
		});

		fields.esTecnicoInspeccion = Ext.create('Ext.form.ComboBox', {
			name: 'esTecnicoInspeccion',
			fieldLabel: this.esTecnicoInspeccionHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 2, 8),
			store: esTecnicoInspeccionStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var incluirInformeAcusticaStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'incluirInformeAcustica') {
				incluirInformeAcusticaStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var incluirInformeAcusticaStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: incluirInformeAcusticaStoreValues
		});

		fields.incluirInformeAcustica = Ext.create('Ext.form.ComboBox', {
			name: 'incluirInformeAcustica',
			fieldLabel: this.incluirInformeAcusticaHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 2, 8),
			store: incluirInformeAcusticaStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		fields.nif = new Ext.form.TextField({
			name: 'nif',
			fieldLabel: this.nifHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 2, 8),
			maxLength: 255
		})
		fields.observaciones = new Ext.form.TextArea({
			name: 'observaciones',
			fieldLabel: this.observacionesHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(8, 0, 8),
			maxLength: 255
		})

		this.fields = fields;
		var items = [{
			xtype: 'At4Framework-fieldmainpanel',
			items: [
				At4FrameworkIntranet.FormDefaults.rows([
					[fields.claveInforme, fields.edificio, fields.inspeccionId],
					[fields.tecnico],
					[fields.titulacion],
					[fields.esTecnicoInspeccion, fields.incluirInformeAcustica, fields.nif],
					[fields.observaciones],
					[At4FrameworkIntranet.FormDefaults.resumenAuditoria()]
				])
			]
		}];



		this.maxTabIndex = tabHelper.getNext();
		this.callParent([application, formName, gridMetaData, items, config]);
	}
});
