//Namespace de  At4FrameworkIntranet
Ext.namespace('At4FrameworkIntranet');

/**
 * @class At4FrameworkIntranet.EficienciasEnergeticasForm
 * Contiene la configuración del formulario: EficienciasEnergeticas
 * @author garrom
 * @constructor
 * @extends At4FrameworkIntranet.BasicForm
 * @param {Object} application La aplicación que contiene el formulario, normalmente será {@link At4FrameworkIntranet.app}
 * @param {String} formName Nombre del formulario
 * @param {Object} gridMetaData Configuración gridMetadata
 * @param {Object} config Configuración para Ext.form.FormPanel
 */

Ext.define("At4FrameworkIntranet.EficienciasEnergeticasForm", {
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
			width: At4FrameworkIntranet.FormDefaults.size(2, 2, 7),
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
		    width: At4FrameworkIntranet.FormDefaults.size(3, 2, 7),
		    allowBlank: false,
		    store: At4FrameworkIntranet.FormDefaults.getStore('Inspeccion'),
		    recordPK: 'id',
		    relatedForm: 'inspeccion'
		})*/


		fields.inspeccionId = Ext.create("Ext.ux.at4.OneToOneField", {
			name: 'inspeccionId',
			fieldLabel: this.inspeccionHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 2, 7),
			border: true,
			application: application,
			relatedIconCls: "",
			relatedForm: 'inspeccion'
		})
		fields.ambitoAplicacion = new Ext.form.NumberField({
			name: 'ambitoAplicacion',
			fieldLabel: this.ambitoAplicacionHeaderLabel,
			tabIndex: tabHelper.getNext(),
			//labelStyle: 'white-space: nowrap',
			width: At4FrameworkIntranet.FormDefaults.size(10, 0, 10),
			allowDecimals: false,
			maxValue: 2147483647
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
			width: At4FrameworkIntranet.FormDefaults.size(2, 3, 11),
			store: esTecnicoInspeccionStore,
			queryMode: 'local',
			labelStyle: 'white-space: nowrap',
			valueField: 'ID',
			displayField: 'DISPLAY',
			listeners: {
				change: {
					scope: this,
					fn: function (el, newValue, oldValue, eOpts) {
						if (newValue === "0") {
							fields.tecnico.show();
							fields.titulacion.show();
							fields.nif.show();
						} else if (newValue === "1") {
							fields.tecnico.hide();
							fields.titulacion.hide();
							fields.nif.hide();
						}
					}
				}
			}
		})

		fields.tecnico = new Ext.form.TextField({
			name: 'tecnico',
			fieldLabel: this.tecnicoHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(4, 3, 10),
			maxLength: 255
		})
		fields.titulacion = new Ext.form.TextField({
			name: 'titulacion',
			fieldLabel: this.titulacionHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(4, 3, 10),
			maxLength: 255
		})
		fields.nif = new Ext.form.TextField({
			name: 'nif',
			fieldLabel: this.nifHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 3, 10),
			maxLength: 255
		})
		fields.indicadorGlobalEmisiones = new Ext.form.TextField({
			name: 'indicadorGlobalEmisiones',
			fieldLabel: this.indicadorGlobalEmisionesHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 3, 12),
			maxLength: 255
		})

		var indicadorGlobalCalificacionTipoIdStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'indicadorGlobalCalificacionTipoId') {
				indicadorGlobalCalificacionTipoIdStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var indicadorGlobalCalificacionTipoIdStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: indicadorGlobalCalificacionTipoIdStoreValues
		});

		fields.indicadorGlobalCalificacionTipoId = Ext.create('Ext.form.ComboBox', {
			name: 'indicadorGlobalCalificacionTipoId',
			fieldLabel: this.indicadorGlobalCalificacionTipoIdHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.indicadorGlobalCalificacionTipoIdDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(4, 3, 12),
			store: indicadorGlobalCalificacionTipoIdStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})
		fields.indicadorParcialEmisionesCalefaccion = new Ext.form.TextField({
			name: 'indicadorParcialEmisionesCalefaccion',
			fieldLabel: this.indicadorParcialEmisionesCalefaccionHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.indicadorParcialEmisionesCalefaccionDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 2, 8),
			maxLength: 255
		})
		fields.indicadorParcialEmisionesRefrigeracion = new Ext.form.TextField({
			name: 'indicadorParcialEmisionesRefrigeracion',
			fieldLabel: this.indicadorParcialEmisionesRefrigeracionHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.indicadorParcialEmisionesRefrigeracionDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 2, 8),
			maxLength: 255
		})
		fields.indicadorParcialEmisionesAcs = new Ext.form.TextField({
			name: 'indicadorParcialEmisionesAcs',
			fieldLabel: this.indicadorParcialEmisionesAcsHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.indicadorParcialEmisionesAcsDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 2, 8),
			maxLength: 255
		})
		fields.demandaGlobalCalefaccion = new Ext.form.TextField({
			name: 'demandaGlobalCalefaccion',
			fieldLabel: this.demandaGlobalCalefaccionHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(4, 1, 8),
			maxLength: 255
		})
		var demandaGlobalCalefaccionCalificacionTipoIdStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'demandaGlobalCalefaccionCalificacionTipoId') {
				demandaGlobalCalefaccionCalificacionTipoIdStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var demandaGlobalCalefaccionCalificacionTipoIdStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: demandaGlobalCalefaccionCalificacionTipoIdStoreValues
		});

		fields.demandaGlobalCalefaccionCalificacionTipoId = Ext.create('Ext.form.ComboBox', {
			name: 'demandaGlobalCalefaccionCalificacionTipoId',
			fieldLabel: this.demandaGlobalCalefaccionCalificacionTipoIdHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.demandaGlobalCalefaccionCalificacionTipoIdDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(4, 1, 8),
			store: demandaGlobalCalefaccionCalificacionTipoIdStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})
		fields.demandaGlobalRefrigeracion = new Ext.form.TextField({
			name: 'demandaGlobalRefrigeracion',
			fieldLabel: this.demandaGlobalRefrigeracionHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(4, 1, 8),
			maxLength: 255
		})

		var demandaGlobalRefrigeracionCalificacionTipoIdStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'demandaGlobalRefrigeracionCalificacionTipoId') {
				demandaGlobalRefrigeracionCalificacionTipoIdStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var demandaGlobalRefrigeracionCalificacionTipoIdStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: demandaGlobalRefrigeracionCalificacionTipoIdStoreValues
		});

		fields.demandaGlobalRefrigeracionCalificacionTipoId = Ext.create('Ext.form.ComboBox', {
			name: 'demandaGlobalRefrigeracionCalificacionTipoId',
			fieldLabel: this.demandaGlobalRefrigeracionCalificacionTipoIdHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.demandaGlobalRefrigeracionCalificacionTipoIdDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(4, 1, 8),
			store: demandaGlobalRefrigeracionCalificacionTipoIdStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		fields.indicadorGlobalPrimariaConsumo = new Ext.form.TextField({
			name: 'indicadorGlobalPrimariaConsumo',
			fieldLabel: this.indicadorGlobalPrimariaConsumoHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.indicadorGlobalPrimariaConsumoDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(4, 1, 8),
			maxLength: 255
		})
		var indicadorGlobalPrimariaCalificacionTipoIdStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'indicadorGlobalPrimariaCalificacionTipoId') {
				indicadorGlobalPrimariaCalificacionTipoIdStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var indicadorGlobalPrimariaCalificacionTipoIdStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: indicadorGlobalPrimariaCalificacionTipoIdStoreValues
		});

		fields.indicadorGlobalPrimariaCalificacionTipoId = Ext.create('Ext.form.ComboBox', {
			name: 'indicadorGlobalPrimariaCalificacionTipoId',
			fieldLabel: this.indicadorGlobalPrimariaCalificacionTipoIdHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.otrasfachadasCamaraaireTipoIdDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(4, 1, 8),
			store: indicadorGlobalPrimariaCalificacionTipoIdStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})
		fields.indicadorParcialPrimariaCalefaccion = new Ext.form.TextField({
			name: 'indicadorParcialPrimariaCalefaccion',
			fieldLabel: this.indicadorParcialPrimariaCalefaccionHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.indicadorParcialPrimariaCalefaccionDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 2, 8),
			maxLength: 255
		})
		fields.indicadorParcialPrimariaRefrigeracion = new Ext.form.TextField({
			name: 'indicadorParcialPrimariaRefrigeracion',
			fieldLabel: this.indicadorParcialPrimariaRefrigeracionHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.indicadorParcialPrimariaRefrigeracionDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 2, 8),
			maxLength: 255
		})
		fields.indicadorParcialPrimariaAcs = new Ext.form.TextField({
			name: 'indicadorParcialPrimariaAcs',
			fieldLabel: this.indicadorParcialPrimariaAcsHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 2, 8),
			maxLength: 255
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
					[fields.ambitoAplicacion],
					[fields.esTecnicoInspeccion],
					[fields.tecnico, fields.titulacion, fields.nif],
					[{

						xtype: 'fieldset',
						border: true,
						title: this.calificacionEnergeticaEdificioTitleLabel,
						items: [{
							xtype: "At4Framework-rowContainer",
							minWidth: false,
							items: [fields.indicadorGlobalEmisiones, fields.indicadorGlobalCalificacionTipoId]
						}, {
							xtype: "At4Framework-rowContainer",
							minWidth: false,
							items: [fields.indicadorParcialEmisionesCalefaccion, fields.indicadorParcialEmisionesRefrigeracion, fields.indicadorParcialEmisionesAcs]
						}]
					}],
					[{

						xtype: 'fieldset',
						border: true,
						title: this.calificacionDemandaEnergeticaCalefaccionRefrigeracionTitleLabel,
						items: [{
							xtype: "At4Framework-rowContainer",
							minWidth: false,
							items: [fields.demandaGlobalCalefaccion, fields.demandaGlobalCalefaccionCalificacionTipoId]
						}, {
							xtype: "At4Framework-rowContainer",
							minWidth: false,
							items: [fields.demandaGlobalRefrigeracion, fields.demandaGlobalRefrigeracionCalificacionTipoId]
						}]

					}],
					[{

						xtype: 'fieldset',
						border: true,
						title: this.calificacionParcialEnergiaPrimariaTitleLabel,
						items: [{
							xtype: "At4Framework-rowContainer",
							minWidth: false,
							items: [fields.indicadorGlobalPrimariaConsumo, fields.indicadorGlobalPrimariaCalificacionTipoId]
						}, {
							xtype: "At4Framework-rowContainer",
							minWidth: false,
							items: [fields.indicadorParcialPrimariaCalefaccion, fields.indicadorParcialPrimariaRefrigeracion, fields.indicadorParcialPrimariaAcs]

						}]

					}],
					[fields.observaciones],
					[At4FrameworkIntranet.FormDefaults.resumenAuditoria()]
				])
			]
		}];



		this.maxTabIndex = tabHelper.getNext();
		this.callParent([application, formName, gridMetaData, items, config]);
	}
});
