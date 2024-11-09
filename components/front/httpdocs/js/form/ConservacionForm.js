//Namespace de  At4FrameworkIntranet
Ext.namespace('At4FrameworkIntranet');

/**
 * @class At4FrameworkIntranet.ConservacionForm
 * Contiene la configuración del formulario: Conservacion
 * @author garrom
 * @constructor
 * @extends At4FrameworkIntranet.BasicForm
 * @param {Object} application La aplicación que contiene el formulario, normalmente será {@link At4FrameworkIntranet.app}
 * @param {String} formName Nombre del formulario
 * @param {Object} gridMetaData Configuración gridMetadata
 * @param {Object} config Configuración para Ext.form.FormPanel
 */

Ext.define("At4FrameworkIntranet.ConservacionForm", {
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
			width: At4FrameworkIntranet.FormDefaults.size(3, 1, 5),
			border: true,
			application: application,
			relatedIconCls: "",
			relatedForm: 'inspeccion'
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
			width: At4FrameworkIntranet.FormDefaults.size(2, 3, 12),
			store: esTecnicoInspeccionStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		fields.tecnico = new Ext.form.TextField({
			name: 'tecnico',
			fieldLabel: this.tecnicoHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 3, 12),
			maxLength: 255
		})
		fields.titulacion = new Ext.form.TextField({
			name: 'titulacion',
			fieldLabel: this.titulacionHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(4, 3, 12),
			maxLength: 255
		})
		fields.nif = new Ext.form.TextField({
			name: 'nif',
			fieldLabel: this.nifHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 3, 12),
			maxLength: 255
		})

		var conservacionValoracionesTipoIdStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'conservacionValoracionesTipoId') {
				conservacionValoracionesTipoIdStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var conservacionValoracionesTipoIdStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: conservacionValoracionesTipoIdStoreValues
		});

		fields.conservacionValoracionesTipoId = Ext.create('Ext.form.ComboBox', {
			name: 'conservacionValoracionesTipoId',
			fieldLabel: this.conservacionValoracionesTipoIdHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.conservacionValoracionesTipoIdDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(4, 2, 12),
			store: conservacionValoracionesTipoIdStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		fields.fechaEmisionInformeValoracion = new Ext.form.TextField({
			name: 'fechaEmisionInformeValoracion',
			fieldLabel: this.fechaEmisionInformeValoracionHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.fechaEmisionInformeValoracionDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 2, 12),
			maxLength: 255
		})
		fields.impedimentosVisita = new Ext.form.TextField({
			name: 'impedimentosVisita',
			fieldLabel: this.impedimentosVisitaHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(5, 2, 12),
			maxLength: 255
		})
		fields.medidasSeguridadVisita = new Ext.form.TextArea({
			name: 'medidasSeguridadVisita',
			fieldLabel: this.medidasSeguridadVisitaHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(12, 0, 12),
			maxLength: 255
		})
		fields.mediosInspeccion = new Ext.form.TextArea({
			name: 'mediosInspeccion',
			fieldLabel: this.mediosInspeccionHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(12, 0, 12),
			maxLength: 255
		})
		fields.pruebasRealizadas = new Ext.form.TextArea({
			name: 'pruebasRealizadas',
			fieldLabel: this.pruebasRealizadasHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(12, 0, 12),
			maxLength: 255
		})
		fields.numLocalesInspeccionados = new Ext.form.NumberField({
			name: 'numLocalesInspeccionados',
			fieldLabel: this.numLocalesInspeccionadosHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 3, 12),
			allowDecimals: false,
			maxValue: 2147483647
		})
		fields.numViviendasInspeccionadas = new Ext.form.NumberField({
			name: 'numViviendasInspeccionadas',
			fieldLabel: this.numViviendasInspeccionadasHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 3, 12),
			allowDecimals: false,
			maxValue: 2147483647
		})

		var existePeligroInminenteStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'existePeligroInminente') {
				existePeligroInminenteStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var existePeligroInminenteStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: existePeligroInminenteStoreValues
		});

		fields.existePeligroInminente = Ext.create('Ext.form.ComboBox', {
			name: 'existePeligroInminente',
			fieldLabel: this.existePeligroInminenteHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 3, 12),
			store: existePeligroInminenteStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})
		fields.fechaLimiteActuacion = new Ext.form.TextField({
			name: 'fechaLimiteActuacion',
			fieldLabel: this.fechaLimiteActuacionHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 3, 12),
			maxLength: 255
		})
		fields.medidas = new Ext.form.TextArea({
			name: 'medidas',
			fieldLabel: this.medidasHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(12, 0, 12),
			maxLength: 255
		})
		fields.descripcionPeligroInminente = new Ext.form.TextArea({
			name: 'descripcionPeligroInminente',
			fieldLabel: this.descripcionPeligroInminenteHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(12, 0, 12),
			maxLength: 255
		})
		fields.observaciones = new Ext.form.TextArea({
			name: 'observaciones',
			fieldLabel: this.observacionesHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(12, 0, 12),
			maxLength: 255
		})

		this.fields = fields;
		var items = [{
			xtype: 'At4Framework-fieldmainpanel',
			items: [
				At4FrameworkIntranet.FormDefaults.rows([
					[fields.claveInforme, fields.edificio, fields.inspeccionId],
					[fields.esTecnicoInspeccion, fields.tecnico, fields.titulacion, fields.nif],
					[fields.conservacionValoracionesTipoId, fields.fechaEmisionInformeValoracion, fields.impedimentosVisita],
					[fields.medidasSeguridadVisita], [fields.mediosInspeccion], [fields.pruebasRealizadas],
					[fields.numLocalesInspeccionados, fields.numViviendasInspeccionadas, fields.existePeligroInminente, fields.fechaLimiteActuacion],
					[fields.medidas], [fields.descripcionPeligroInminente], [fields.observaciones],
					[At4FrameworkIntranet.FormDefaults.resumenAuditoria()]
				])
			]
		}];



		this.maxTabIndex = tabHelper.getNext();
		this.callParent([application, formName, gridMetaData, items, config]);
	}
});
