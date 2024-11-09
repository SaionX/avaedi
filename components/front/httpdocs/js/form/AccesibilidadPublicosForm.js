//Namespace de  At4FrameworkIntranet
Ext.namespace('At4FrameworkIntranet');

/**
 * @class At4FrameworkIntranet.AccesibilidadPublicosForm
 * Contiene la configuración del formulario: AccesibilidadPublicos
 * @author garrom
 * @constructor
 * @extends At4FrameworkIntranet.BasicForm
 * @param {Object} application La aplicación que contiene el formulario, normalmente será {@link At4FrameworkIntranet.app}
 * @param {String} formName Nombre del formulario
 * @param {Object} gridMetaData Configuración gridMetadata
 * @param {Object} config Configuración para Ext.form.FormPanel
 */

Ext.define("At4FrameworkIntranet.AccesibilidadPublicosForm", {
	extend: "At4FrameworkIntranet.InspeccionBaseForm",
	constructor: function (application, formName, gridMetaData, config) {
		Ext.apply(this, config);
		var tabHelper = new At4util.tabIndexHelper(this.tabIndex);

		var columnDefaults = At4FrameworkIntranet.FormDefaults.COLUMN_DEFAULTS;
		var fieldDefaults = At4FrameworkIntranet.FormDefaults.FIELD_DEFAULTS;


		var fields = {}

		//------Campos cabecera------
		fields.claveInforme = new Ext.form.NumberField({
			name: 'claveInforme',
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
			width: At4FrameworkIntranet.FormDefaults.size(3, 3, 16),
			allowBlank: false,
			store: At4FrameworkIntranet.FormDefaults.getStore('Inspeccion'),
			recordPK: 'id',
			relatedForm: 'inspeccion'
		})*/


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

		//----------------------------------
		//----Alojamientos accesibles-------
		var alojamientosaccesibles1porcada50StoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'alojamientosaccesibles1porcada50') {
				alojamientosaccesibles1porcada50StoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var alojamientosaccesibles1porcada50Store = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: alojamientosaccesibles1porcada50StoreValues
		});

		fields.alojamientosaccesibles1porcada50 = Ext.create('Ext.form.ComboBox', {
			name: 'alojamientosaccesibles1porcada50',
			fieldLabel: this.alojamientosaccesibles1porcada50HeaderLabel,
			labelAttrTpl: " data-qtip='" + this.alojamientosaccesibles1porcada50DescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 5, 12),
			store: alojamientosaccesibles1porcada50Store,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var alojamientosaccesiblesMinimo1StoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'alojamientosaccesiblesMinimo1') {
				alojamientosaccesiblesMinimo1StoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var alojamientosaccesiblesMinimo1Store = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: alojamientosaccesiblesMinimo1StoreValues
		});

		fields.alojamientosaccesiblesMinimo1 = Ext.create('Ext.form.ComboBox', {
			name: 'alojamientosaccesiblesMinimo1',
			fieldLabel: this.alojamientosaccesiblesMinimo1HeaderLabel,
			labelAttrTpl: " data-qtip='" + this.alojamientosaccesiblesMinimo1DescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 5, 12),
			store: alojamientosaccesiblesMinimo1Store,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var alojamientosaccesiblesMinimo2StoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'alojamientosaccesiblesMinimo2') {
				alojamientosaccesiblesMinimo2StoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var alojamientosaccesiblesMinimo2Store = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: alojamientosaccesiblesMinimo2StoreValues
		});

		fields.alojamientosaccesiblesMinimo2 = Ext.create('Ext.form.ComboBox', {
			name: 'alojamientosaccesiblesMinimo2',
			fieldLabel: this.alojamientosaccesiblesMinimo2HeaderLabel,
			labelAttrTpl: " data-qtip='" + this.alojamientosaccesiblesMinimo2DescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 5, 12),
			store: alojamientosaccesiblesMinimo2Store,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		varalojamientosaccesiblesMinimo4StoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'alojamientosaccesiblesMinimo4') {
				varalojamientosaccesiblesMinimo4StoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var varalojamientosaccesiblesMinimo4Store = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: varalojamientosaccesiblesMinimo4StoreValues
		});

		fields.alojamientosaccesiblesMinimo4 = Ext.create('Ext.form.ComboBox', {
			name: 'alojamientosaccesiblesMinimo4',
			fieldLabel: this.alojamientosaccesiblesMinimo4HeaderLabel,
			labelAttrTpl: " data-qtip='" + this.alojamientosaccesiblesMinimo4DescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 5, 12),
			store: varalojamientosaccesiblesMinimo4Store,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var alojamientosaccesiblesMinimo6StoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'alojamientosaccesiblesMinimo6') {
				alojamientosaccesiblesMinimo6StoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var alojamientosaccesiblesMinimo6Store = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: alojamientosaccesiblesMinimo6StoreValues
		});

		fields.alojamientosaccesiblesMinimo6 = Ext.create('Ext.form.ComboBox', {
			name: 'alojamientosaccesiblesMinimo6',
			fieldLabel: this.alojamientosaccesiblesMinimo6HeaderLabel,
			labelAttrTpl: " data-qtip='" + this.alojamientosaccesiblesMinimo6DescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 5, 12),
			store: alojamientosaccesiblesMinimo6Store,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var alojamientosaccesiblesMinimo8StoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'alojamientosaccesiblesMinimo8') {
				alojamientosaccesiblesMinimo8StoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var alojamientosaccesiblesMinimo8Store = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: alojamientosaccesiblesMinimo8StoreValues
		});

		fields.alojamientosaccesiblesMinimo8 = Ext.create('Ext.form.ComboBox', {
			name: 'alojamientosaccesiblesMinimo8',
			fieldLabel: this.alojamientosaccesiblesMinimo8HeaderLabel,
			labelAttrTpl: " data-qtip='" + this.alojamientosaccesiblesMinimo8DescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 5, 12),
			store: alojamientosaccesiblesMinimo8Store,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		fields.alojamientosaccesiblesObservaciones = new Ext.form.TextArea({
			name: 'alojamientosaccesiblesObservaciones',
			fieldLabel: this.alojamientosaccesiblesObservacionesHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.alojamientosaccesiblesObservacionesDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(12, 0, 12),
			maxLength: 255
		})

		var aparcamientoComercialPorfraccionStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'aparcamientoComercialPorfraccion') {
				aparcamientoComercialPorfraccionStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var aparcamientoComercialPorfraccionStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: aparcamientoComercialPorfraccionStoreValues
		});

		fields.aparcamientoComercialPorfraccion = Ext.create('Ext.form.ComboBox', {
			name: 'aparcamientoComercialPorfraccion',
			fieldLabel: this.aparcamientoComercialPorfraccionHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.aparcamientoComercialPorfraccionDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(6, 1, 12),
			store: aparcamientoComercialPorfraccionStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var aparcamientoOtrosusosMinimoaparcamientosUnamasporfraccionStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'aparcamientoOtrosusosMinimoaparcamientosUnamasporfraccion') {
				aparcamientoOtrosusosMinimoaparcamientosUnamasporfraccionStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var aparcamientoOtrosusosMinimoaparcamientosUnamasporfraccionStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: aparcamientoOtrosusosMinimoaparcamientosUnamasporfraccionStoreValues
		});

		fields.aparcamientoOtrosusosMinimoaparcamientosUnamasporfraccion = Ext.create('Ext.form.ComboBox', {
			name: 'aparcamientoOtrosusosMinimoaparcamientosUnamasporfraccion',
			fieldLabel: this.aparcamientoOtrosusosMinimoaparcamientosUnamasporfraccionHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.aparcamientoOtrosusosMinimoaparcamientosUnamasporfraccionDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(6, 1, 12),
			store: aparcamientoOtrosusosMinimoaparcamientosUnamasporfraccionStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var aparcamientoOtrosusosMinimoaparcamientosUnaporfraccionStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'aparcamientoOtrosusosMinimoaparcamientosUnaporfraccion') {
				aparcamientoOtrosusosMinimoaparcamientosUnaporfraccionStore = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var aparcamientoOtrosusosMinimoaparcamientosUnaporfraccionStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: aparcamientoOtrosusosMinimoaparcamientosUnaporfraccionStore
		});

		fields.aparcamientoOtrosusosMinimoaparcamientosUnaporfraccion = Ext.create('Ext.form.ComboBox', {
			name: 'aparcamientoOtrosusosMinimoaparcamientosUnaporfraccion',
			fieldLabel: this.aparcamientoOtrosusosMinimoaparcamientosUnaporfraccionHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.aparcamientoOtrosusosMinimoaparcamientosUnaporfraccionDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(5, 2, 12),
			store: aparcamientoOtrosusosMinimoaparcamientosUnaporfraccionStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var aparcamientoResidencialpublicoPoralojamientoStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'aparcamientoResidencialpublicoPoralojamiento') {
				aparcamientoResidencialpublicoPoralojamientoStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var aparcamientoResidencialpublicoPoralojamientoStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: aparcamientoResidencialpublicoPoralojamientoStoreValues
		});

		fields.aparcamientoResidencialpublicoPoralojamiento = Ext.create('Ext.form.ComboBox', {
			name: 'aparcamientoResidencialpublicoPoralojamiento',
			fieldLabel: this.aparcamientoResidencialpublicoPoralojamientoHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.aparcamientoResidencialpublicoPoralojamientoDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(5, 2, 12),
			store: aparcamientoResidencialpublicoPoralojamientoStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var aparcamientoSillaruedasStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'aparcamientoSillaruedas') {
				aparcamientoSillaruedasStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var aparcamientoSillaruedasStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: aparcamientoSillaruedasStoreValues
		});

		fields.aparcamientoSillaruedas = Ext.create('Ext.form.ComboBox', {
			name: 'aparcamientoSillaruedas',
			fieldLabel: this.aparcamientoSillaruedasHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 2, 12),
			store: aparcamientoSillaruedasStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		fields.aparcamientoObservaciones = new Ext.form.TextArea({
			name: 'aparcamientoObservaciones',
			fieldLabel: this.aparcamientoObservacionesHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(12, 0, 12),
			maxLength: 255
		})

		//-------------------------------------
		//-------Entre Plantas----
		var entreplantasAccesibleStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'entreplantasAccesible') {
				entreplantasAccesibleStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var entreplantasAccesibleStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: entreplantasAccesibleStoreValues
		});

		fields.entreplantasAccesible = Ext.create('Ext.form.ComboBox', {
			name: 'entreplantasAccesible',
			fieldLabel: this.entreplantasAccesibleHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 2, 10),
			store: entreplantasAccesibleStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var entreplantasAccesibleAscensornoaccesibleStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'entreplantasAccesibleAscensornoaccesible') {
				entreplantasAccesibleAscensornoaccesibleStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var entreplantasAccesibleAscensornoaccesibleStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: entreplantasAccesibleAscensornoaccesibleStoreValues
		});
		fields.entreplantasAccesibleAscensornoaccesible = Ext.create('Ext.form.ComboBox', {
			name: 'entreplantasAccesibleAscensornoaccesible',
			fieldLabel: this.entreplantasAccesibleAscensornoaccesibleHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.entreplantasAccesibleAscensornoaccesibleDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 2, 10),
			store: entreplantasAccesibleAscensornoaccesibleStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		fields.entreplantasAccesibleAscensornoaccesibleDimensiones = new Ext.form.TextField({
			name: 'entreplantasAccesibleAscensornoaccesibleDimensiones',
			fieldLabel: this.entreplantasAccesibleAscensornoaccesibleDimensionesHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.entreplantasAccesibleAscensornoaccesibleDimensionesDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(4, 2, 10),
			maxLength: 255
		})

		var entreplantasAccesibleAscensororampaaccesibleStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'entreplantasAccesibleAscensororampaaccesible') {
				entreplantasAccesibleAscensororampaaccesibleStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var entreplantasAccesibleAscensororampaaccesibleStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: entreplantasAccesibleAscensororampaaccesibleStoreValues
		});
		fields.entreplantasAccesibleAscensororampaaccesible = Ext.create('Ext.form.ComboBox', {
			name: 'entreplantasAccesibleAscensororampaaccesible',
			fieldLabel: this.entreplantasAccesibleAscensororampaaccesibleHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.entreplantasAccesibleAscensororampaaccesibleDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 1, 6),
			store: entreplantasAccesibleAscensororampaaccesibleStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var entreplantasAccesibleRampaascensornoaccesibleStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'entreplantasAccesibleRampaascensornoaccesible') {
				entreplantasAccesibleRampaascensornoaccesibleStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var entreplantasAccesibleRampaascensornoaccesibleStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: entreplantasAccesibleRampaascensornoaccesibleStoreValues
		});

		fields.entreplantasAccesibleRampaascensornoaccesible = Ext.create('Ext.form.ComboBox', {
			name: 'entreplantasAccesibleRampaascensornoaccesible',
			fieldLabel: this.entreplantasAccesibleRampaascensornoaccesibleHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.entreplantasAccesibleRampaascensornoaccesibleDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 1, 6),
			store: entreplantasAccesibleRampaascensornoaccesibleStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var entreplantasElementosaccesiblesStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'entreplantasElementosaccesibles') {
				entreplantasElementosaccesiblesStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var entreplantasElementosaccesiblesStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: entreplantasElementosaccesiblesStoreValues
		});

		fields.entreplantasElementosaccesibles = Ext.create('Ext.form.ComboBox', {
			name: 'entreplantasElementosaccesibles',
			fieldLabel: this.entreplantasElementosaccesiblesHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.entreplantasElementosaccesiblesDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 2, 10),
			store: entreplantasElementosaccesiblesStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var entreplantasElementosaccesiblesAscensornoaccesibleStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'entreplantasElementosaccesiblesAscensornoaccesible') {
				entreplantasElementosaccesiblesAscensornoaccesibleStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var entreplantasElementosaccesiblesAscensornoaccesibleStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: entreplantasElementosaccesiblesAscensornoaccesibleStoreValues
		});

		fields.entreplantasElementosaccesiblesAscensornoaccesible = Ext.create('Ext.form.ComboBox', {
			name: 'entreplantasElementosaccesiblesAscensornoaccesible',
			fieldLabel: this.entreplantasElementosaccesiblesAscensornoaccesibleHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.entreplantasElementosaccesiblesAscensornoaccesibleDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 2, 10),
			store: entreplantasElementosaccesiblesAscensornoaccesibleStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		fields.entreplantasElementosaccesiblesAscensornoaccesibleDimensione = new Ext.form.TextField({
			name: 'entreplantasElementosaccesiblesAscensornoaccesibleDimensione',
			fieldLabel: this.entreplantasElementosaccesiblesAscensornoaccesibleDimensioneHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.entreplantasElementosaccesiblesAscensornoaccesibleDimensioneDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(4, 2, 10),
			maxLength: 255
		})

		var entreplantasElementosaccesiblesAscensororampaaccesibleStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'entreplantasElementosaccesiblesAscensororampaaccesible') {
				entreplantasElementosaccesiblesAscensororampaaccesibleStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var entreplantasElementosaccesiblesAscensororampaaccesibleStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: entreplantasElementosaccesiblesAscensororampaaccesibleStoreValues
		});

		fields.entreplantasElementosaccesiblesAscensororampaaccesible = Ext.create('Ext.form.ComboBox', {
			name: 'entreplantasElementosaccesiblesAscensororampaaccesible',
			fieldLabel: this.entreplantasElementosaccesiblesAscensororampaaccesibleHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.entreplantasElementosaccesiblesAscensororampaaccesibleDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 1, 6),
			store: entreplantasElementosaccesiblesAscensororampaaccesibleStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var entreplantasElementosaccesiblesRampaascensornoaccesibleStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'entreplantasElementosaccesiblesRampaascensornoaccesible') {
				entreplantasElementosaccesiblesRampaascensornoaccesibleStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var entreplantasElementosaccesiblesRampaascensornoaccesibleStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: entreplantasElementosaccesiblesRampaascensornoaccesibleStoreValues
		});

		fields.entreplantasElementosaccesiblesRampaascensornoaccesible = Ext.create('Ext.form.ComboBox', {
			name: 'entreplantasElementosaccesiblesRampaascensornoaccesible',
			fieldLabel: this.entreplantasElementosaccesiblesRampaascensornoaccesibleHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.entreplantasElementosaccesiblesRampaascensornoaccesibleDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 1, 6),
			store: entreplantasElementosaccesiblesRampaascensornoaccesibleStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var entreplantasNoaccesibleStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'entreplantasNoaccesible') {
				entreplantasNoaccesibleStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var entreplantasNoaccesibleStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: entreplantasNoaccesibleStoreValues
		});

		fields.entreplantasNoaccesible = Ext.create('Ext.form.ComboBox', {
			name: 'entreplantasNoaccesible',
			fieldLabel: this.entreplantasNoaccesibleHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.entreplantasNoaccesibleDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 2, 10),
			store: entreplantasNoaccesibleStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var entreplantasNoaccesibleAscensornoaccesibleStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'entreplantasNoaccesibleAscensornoaccesible') {
				entreplantasNoaccesibleAscensornoaccesibleStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var entreplantasNoaccesibleAscensornoaccesibleStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: entreplantasNoaccesibleAscensornoaccesibleStoreValues
		});

		fields.entreplantasNoaccesibleAscensornoaccesible = Ext.create('Ext.form.ComboBox', {
			name: 'entreplantasNoaccesibleAscensornoaccesible',
			fieldLabel: this.entreplantasNoaccesibleAscensornoaccesibleHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.entreplantasNoaccesibleAscensornoaccesibleDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 2, 10),
			store: entreplantasNoaccesibleAscensornoaccesibleStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		fields.entreplantasNoaccesibleAscensornoaccesibleDimensiones = new Ext.form.TextField({
			name: 'entreplantasNoaccesibleAscensornoaccesibleDimensiones',
			fieldLabel: this.entreplantasNoaccesibleAscensornoaccesibleDimensionesHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.entreplantasNoaccesibleAscensornoaccesibleDimensionesDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(4, 2, 10),
			maxLength: 255
		})

		var entreplantasNoaccesibleAscensororampaaccesibleStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'entreplantasNoaccesibleAscensororampaaccesible') {
				entreplantasNoaccesibleAscensororampaaccesibleStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var entreplantasNoaccesibleAscensororampaaccesibleStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: entreplantasNoaccesibleAscensororampaaccesibleStoreValues
		});

		fields.entreplantasNoaccesibleAscensororampaaccesible = Ext.create('Ext.form.ComboBox', {
			name: 'entreplantasNoaccesibleAscensororampaaccesible',
			fieldLabel: this.entreplantasNoaccesibleAscensororampaaccesibleHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.entreplantasNoaccesibleAscensororampaaccesibleDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 1, 6),
			store: entreplantasNoaccesibleAscensororampaaccesibleStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var entreplantasNoaccesibleRampaascensornoaccesibleStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'entreplantasNoaccesibleRampaascensornoaccesible') {
				entreplantasNoaccesibleRampaascensornoaccesibleStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var entreplantasNoaccesibleRampaascensornoaccesibleStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: entreplantasNoaccesibleRampaascensornoaccesibleStoreValues
		});

		fields.entreplantasNoaccesibleRampaascensornoaccesible = Ext.create('Ext.form.ComboBox', {
			name: 'entreplantasNoaccesibleRampaascensornoaccesible',
			fieldLabel: this.entreplantasNoaccesibleRampaascensornoaccesibleHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.entreplantasNoaccesibleRampaascensornoaccesibleDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 1, 6),
			store: entreplantasNoaccesibleRampaascensornoaccesibleStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var entreplantasZonasusopublicoStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'entreplantasZonasusopublico') {
				entreplantasZonasusopublicoStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var entreplantasZonasusopublicoStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: entreplantasZonasusopublicoStoreValues
		});

		fields.entreplantasZonasusopublico = Ext.create('Ext.form.ComboBox', {
			name: 'entreplantasZonasusopublico',
			fieldLabel: this.entreplantasZonasusopublicoHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 2, 10),
			store: entreplantasZonasusopublicoStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var entreplantasZonasusopublicoAscensornoaccesibleStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'entreplantasZonasusopublicoAscensornoaccesible') {
				entreplantasZonasusopublicoAscensornoaccesibleStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var entreplantasZonasusopublicoAscensornoaccesibleStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: entreplantasZonasusopublicoAscensornoaccesibleStoreValues
		});

		fields.entreplantasZonasusopublicoAscensornoaccesible = Ext.create('Ext.form.ComboBox', {
			name: 'entreplantasZonasusopublicoAscensornoaccesible',
			fieldLabel: this.entreplantasZonasusopublicoAscensornoaccesibleHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.entreplantasZonasusopublicoAscensornoaccesibleDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 2, 10),
			store: entreplantasZonasusopublicoAscensornoaccesibleStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		fields.entreplantasZonasusopublicoAscensornoaccesibleDimensiones = new Ext.form.TextField({
			name: 'entreplantasZonasusopublicoAscensornoaccesibleDimensiones',
			fieldLabel: this.entreplantasZonasusopublicoAscensornoaccesibleDimensionesHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.entreplantasZonasusopublicoAscensornoaccesibleDimensionesDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(4, 2, 10),
			maxLength: 255
		})

		var entreplantasZonasusopublicoAscensororampaaccesibleStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'entreplantasZonasusopublicoAscensororampaaccesible') {
				entreplantasZonasusopublicoAscensororampaaccesibleStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var entreplantasZonasusopublicoAscensororampaaccesibleStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: entreplantasZonasusopublicoAscensororampaaccesibleStoreValues
		});

		fields.entreplantasZonasusopublicoAscensororampaaccesible = Ext.create('Ext.form.ComboBox', {
			name: 'entreplantasZonasusopublicoAscensororampaaccesible',
			fieldLabel: this.entreplantasZonasusopublicoAscensororampaaccesibleHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.entreplantasZonasusopublicoAscensororampaaccesibleDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 1, 6),
			store: entreplantasZonasusopublicoAscensororampaaccesibleStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var entreplantasZonasusopublicoRampaascensornoaccesibleStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'entreplantasZonasusopublicoRampaascensornoaccesible') {
				entreplantasZonasusopublicoRampaascensornoaccesibleStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var entreplantasZonasusopublicoRampaascensornoaccesibleStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: entreplantasZonasusopublicoRampaascensornoaccesibleStoreValues
		});

		fields.entreplantasZonasusopublicoRampaascensornoaccesible = Ext.create('Ext.form.ComboBox', {
			name: 'entreplantasZonasusopublicoRampaascensornoaccesible',
			fieldLabel: this.entreplantasZonasusopublicoRampaascensornoaccesibleHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.entreplantasZonasusopublicoRampaascensornoaccesibleDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 1, 6),
			store: entreplantasZonasusopublicoRampaascensornoaccesibleStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		fields.entreplantasObservaciones = new Ext.form.TextArea({
			name: 'entreplantasObservaciones',
			fieldLabel: this.entreplantasObservacionesHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(10.65, 0, 10.65),
			maxLength: 255
		})

		//--------------------------------------
		//-----Información Señalización---------
		var informacionsenalizacionAscensoresStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'informacionsenalizacionAscensores') {
				informacionsenalizacionAscensoresStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var informacionsenalizacionAscensoresStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: informacionsenalizacionAscensoresStoreValues
		});

		fields.informacionsenalizacionAscensores = Ext.create('Ext.form.ComboBox', {
			name: 'informacionsenalizacionAscensores',
			fieldLabel: this.informacionsenalizacionAscensoresHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.informacionsenalizacionAscensoresDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 2, 6),
			store: informacionsenalizacionAscensoresStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var informacionsenalizacionAscensoresBrailearabigoStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'informacionsenalizacionAscensoresBrailearabigo') {
				informacionsenalizacionAscensoresBrailearabigoStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var informacionsenalizacionAscensoresBrailearabigoStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: informacionsenalizacionAscensoresBrailearabigoStoreValues
		});

		fields.informacionsenalizacionAscensoresBrailearabigo = Ext.create('Ext.form.ComboBox', {
			name: 'informacionsenalizacionAscensoresBrailearabigo',
			fieldLabel: this.informacionsenalizacionAscensoresBrailearabigoHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.informacionsenalizacionAscensoresBrailearabigoDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 2, 6),
			store: informacionsenalizacionAscensoresBrailearabigoStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var informacionsenalizacionAscensoresNumeroplantaStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'informacionsenalizacionAscensoresNumeroplanta') {
				informacionsenalizacionAscensoresNumeroplantaStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var informacionsenalizacionAscensoresNumeroplantaStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: informacionsenalizacionAscensoresNumeroplantaStoreValues
		});

		fields.informacionsenalizacionAscensoresNumeroplanta = Ext.create('Ext.form.ComboBox', {
			name: 'informacionsenalizacionAscensoresNumeroplanta',
			fieldLabel: this.informacionsenalizacionAscensoresNumeroplantaHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.informacionsenalizacionAscensoresNumeroplantaDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 2, 6),
			store: informacionsenalizacionAscensoresNumeroplantaStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var informacionsenalizacionBandasvisualestactilesStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'informacionsenalizacionBandasvisualestactiles') {
				informacionsenalizacionBandasvisualestactilesStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var informacionsenalizacionBandasvisualestactilesStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: informacionsenalizacionBandasvisualestactilesStoreValues
		});

		fields.informacionsenalizacionBandasvisualestactiles = Ext.create('Ext.form.ComboBox', {
			name: 'informacionsenalizacionBandasvisualestactiles',
			fieldLabel: this.informacionsenalizacionBandasvisualestactilesHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.informacionsenalizacionBandasvisualestactilesDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 3, 10),
			store: informacionsenalizacionBandasvisualestactilesStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var informacionsenalizacionBandasvisualestactilesArranqueescaleraStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'informacionsenalizacionBandasvisualestactilesArranqueescalera') {
				informacionsenalizacionBandasvisualestactilesArranqueescaleraStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var informacionsenalizacionBandasvisualestactilesArranqueescaleraStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: informacionsenalizacionBandasvisualestactilesArranqueescaleraStoreValues
		});

		fields.informacionsenalizacionBandasvisualestactilesArranqueescalera = Ext.create('Ext.form.ComboBox', {
			name: 'informacionsenalizacionBandasvisualestactilesArranqueescalera',
			fieldLabel: this.informacionsenalizacionBandasvisualestactilesArranqueescaleraHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.informacionsenalizacionBandasvisualestactilesArranqueescaleraDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 3, 10),
			store: informacionsenalizacionBandasvisualestactilesArranqueescaleraStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var informacionsenalizacionBandasvisualestactilesColorcontrastadoStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'informacionsenalizacionBandasvisualestactilesColorcontrastado') {
				informacionsenalizacionBandasvisualestactilesColorcontrastadoStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var informacionsenalizacionBandasvisualestactilesColorcontrastadoStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: informacionsenalizacionBandasvisualestactilesColorcontrastadoStoreValues
		});

		fields.informacionsenalizacionBandasvisualestactilesColorcontrastado = Ext.create('Ext.form.ComboBox', {
			name: 'informacionsenalizacionBandasvisualestactilesColorcontrastado',
			fieldLabel: this.informacionsenalizacionBandasvisualestactilesColorcontrastadoHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.informacionsenalizacionBandasvisualestactilesColorcontrastadoDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 3, 10),
			store: informacionsenalizacionBandasvisualestactilesColorcontrastadoStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var informacionsenalizacionBandasvisualestactilesItinerarioaccesiStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'informacionsenalizacionBandasvisualestactilesItinerarioaccesi') {
				informacionsenalizacionBandasvisualestactilesItinerarioaccesiStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var informacionsenalizacionBandasvisualestactilesItinerarioaccesiStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: informacionsenalizacionBandasvisualestactilesItinerarioaccesiStoreValues
		});

		fields.informacionsenalizacionBandasvisualestactilesItinerarioaccesi = Ext.create('Ext.form.ComboBox', {
			name: 'informacionsenalizacionBandasvisualestactilesItinerarioaccesi',
			fieldLabel: this.informacionsenalizacionBandasvisualestactilesItinerarioaccesiHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.informacionsenalizacionBandasvisualestactilesItinerarioaccesiDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 3, 10),
			store: informacionsenalizacionBandasvisualestactilesItinerarioaccesiStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var informacionsenalizacionBandasvisualestactilesRelieveexteriorStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'informacionsenalizacionBandasvisualestactilesRelieveexterior') {
				informacionsenalizacionBandasvisualestactilesRelieveexteriorStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var informacionsenalizacionBandasvisualestactilesRelieveexteriorStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: informacionsenalizacionBandasvisualestactilesRelieveexteriorStoreValues
		});

		fields.informacionsenalizacionBandasvisualestactilesRelieveexterior = Ext.create('Ext.form.ComboBox', {
			name: 'informacionsenalizacionBandasvisualestactilesRelieveexterior',
			fieldLabel: this.informacionsenalizacionBandasvisualestactilesRelieveexteriorHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.informacionsenalizacionBandasvisualestactilesRelieveexteriorDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 2, 4),
			store: informacionsenalizacionBandasvisualestactilesRelieveexteriorStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var informacionsenalizacionBandasvisualestactilesRelieveinteriorStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'informacionsenalizacionBandasvisualestactilesRelieveinterior') {
				informacionsenalizacionBandasvisualestactilesRelieveinteriorStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var informacionsenalizacionBandasvisualestactilesRelieveinteriorStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: informacionsenalizacionBandasvisualestactilesRelieveinteriorStoreValues
		});

		fields.informacionsenalizacionBandasvisualestactilesRelieveinterior = Ext.create('Ext.form.ComboBox', {
			name: 'informacionsenalizacionBandasvisualestactilesRelieveinterior',
			fieldLabel: this.informacionsenalizacionBandasvisualestactilesRelieveinteriorHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.informacionsenalizacionBandasvisualestactilesRelieveinteriorDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 2, 4),
			store: informacionsenalizacionBandasvisualestactilesRelieveinteriorStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var informacionsenalizacionPrivadoSiaAparcamientoStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'informacionsenalizacionPrivadoSiaAparcamiento') {
				informacionsenalizacionPrivadoSiaAparcamientoStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var informacionsenalizacionPrivadoSiaAparcamientoStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: informacionsenalizacionPrivadoSiaAparcamientoStoreValues
		});

		fields.informacionsenalizacionPrivadoSiaAparcamiento = Ext.create('Ext.form.ComboBox', {
			name: 'informacionsenalizacionPrivadoSiaAparcamiento',
			fieldLabel: this.informacionsenalizacionPrivadoSiaAparcamientoHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.informacionsenalizacionPrivadoSiaAparcamientoDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 4, 10),
			store: informacionsenalizacionPrivadoSiaAparcamientoStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var informacionsenalizacionPrivadoSiaAscensoresStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'informacionsenalizacionPrivadoSiaAscensores') {
				informacionsenalizacionPrivadoSiaAscensoresStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var informacionsenalizacionPrivadoSiaAscensoresStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: informacionsenalizacionPrivadoSiaAscensoresStoreValues
		});

		fields.informacionsenalizacionPrivadoSiaAscensores = Ext.create('Ext.form.ComboBox', {
			name: 'informacionsenalizacionPrivadoSiaAscensores',
			fieldLabel: this.informacionsenalizacionPrivadoSiaAscensoresHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.informacionsenalizacionPrivadoSiaAscensoresDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 4, 10),
			store: informacionsenalizacionPrivadoSiaAscensoresStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var informacionsenalizacionPrivadoSiaEntradasStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'informacionsenalizacionPrivadoSiaEntradas') {
				informacionsenalizacionPrivadoSiaEntradasStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var informacionsenalizacionPrivadoSiaEntradasStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: informacionsenalizacionPrivadoSiaEntradasStoreValues
		});

		fields.informacionsenalizacionPrivadoSiaEntradas = Ext.create('Ext.form.ComboBox', {
			name: 'informacionsenalizacionPrivadoSiaEntradas',
			fieldLabel: this.informacionsenalizacionPrivadoSiaEntradasHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.informacionsenalizacionPrivadoSiaEntradasDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 4, 10),
			store: informacionsenalizacionPrivadoSiaEntradasStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var informacionsenalizacionPrivadoSiaItinerariosStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'informacionsenalizacionPrivadoSiaItinerarios') {
				informacionsenalizacionPrivadoSiaItinerariosStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var informacionsenalizacionPrivadoSiaItinerariosStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: informacionsenalizacionPrivadoSiaItinerariosStoreValues
		});

		fields.informacionsenalizacionPrivadoSiaItinerarios = Ext.create('Ext.form.ComboBox', {
			name: 'informacionsenalizacionPrivadoSiaItinerarios',
			fieldLabel: this.informacionsenalizacionPrivadoSiaItinerariosHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.informacionsenalizacionPrivadoSiaItinerariosDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 4, 10),
			store: informacionsenalizacionPrivadoSiaItinerariosStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var informacionsenalizacionPrivadoSiaPlazasreservadasStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'informacionsenalizacionPrivadoSiaPlazasreservadas') {
				informacionsenalizacionPrivadoSiaPlazasreservadasStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var informacionsenalizacionPrivadoSiaPlazasreservadasStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: informacionsenalizacionPrivadoSiaPlazasreservadasStoreValues
		});

		fields.informacionsenalizacionPrivadoSiaPlazasreservadas = Ext.create('Ext.form.ComboBox', {
			name: 'informacionsenalizacionPrivadoSiaPlazasreservadas',
			fieldLabel: this.informacionsenalizacionPrivadoSiaPlazasreservadasHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.informacionsenalizacionPrivadoSiaPlazasreservadasDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 4, 10),
			store: informacionsenalizacionPrivadoSiaPlazasreservadasStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var informacionsenalizacionPublicoSiaAparcamientoStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'informacionsenalizacionPublicoSiaAparcamiento') {
				informacionsenalizacionPublicoSiaAparcamientoStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var informacionsenalizacionPublicoSiaAparcamientoStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: informacionsenalizacionPublicoSiaAparcamientoStoreValues
		});

		fields.informacionsenalizacionPublicoSiaAparcamiento = Ext.create('Ext.form.ComboBox', {
			name: 'informacionsenalizacionPublicoSiaAparcamiento',
			fieldLabel: this.informacionsenalizacionPublicoSiaAparcamientoHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.informacionsenalizacionPublicoSiaAparcamientoDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 4, 10),
			store: informacionsenalizacionPublicoSiaAparcamientoStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var informacionsenalizacionPublicoSiaAscensoresStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'informacionsenalizacionPublicoSiaAscensores') {
				informacionsenalizacionPublicoSiaAscensoresStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var informacionsenalizacionPublicoSiaAscensoresStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: informacionsenalizacionPublicoSiaAscensoresStoreValues
		});

		fields.informacionsenalizacionPublicoSiaAscensores = Ext.create('Ext.form.ComboBox', {
			name: 'informacionsenalizacionPublicoSiaAscensores',
			fieldLabel: this.informacionsenalizacionPublicoSiaAscensoresHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.informacionsenalizacionPublicoSiaAscensoresDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 4, 10),
			store: informacionsenalizacionPublicoSiaAscensoresStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var informacionsenalizacionPublicoSiaEntradasStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'informacionsenalizacionPublicoSiaEntradas') {
				informacionsenalizacionPublicoSiaEntradasStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var informacionsenalizacionPublicoSiaEntradasStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: informacionsenalizacionPublicoSiaEntradasStoreValues
		});

		fields.informacionsenalizacionPublicoSiaEntradas = Ext.create('Ext.form.ComboBox', {
			name: 'informacionsenalizacionPublicoSiaEntradas',
			fieldLabel: this.informacionsenalizacionPublicoSiaEntradasHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.informacionsenalizacionPublicoSiaEntradasDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 4, 10),
			store: informacionsenalizacionPublicoSiaEntradasStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var informacionsenalizacionPublicoSiaItinerariosStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'informacionsenalizacionPublicoSiaItinerarios') {
				informacionsenalizacionPublicoSiaItinerariosStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var informacionsenalizacionPublicoSiaItinerariosStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: informacionsenalizacionPublicoSiaItinerariosStoreValues
		});

		fields.informacionsenalizacionPublicoSiaItinerarios = Ext.create('Ext.form.ComboBox', {
			name: 'informacionsenalizacionPublicoSiaItinerarios',
			fieldLabel: this.informacionsenalizacionPublicoSiaItinerariosHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.informacionsenalizacionPublicoSiaItinerariosDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 4, 10),
			store: informacionsenalizacionPublicoSiaItinerariosStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var informacionsenalizacionPublicoSiaPlazasreservadasStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'informacionsenalizacionPublicoSiaPlazasreservadas') {
				informacionsenalizacionPublicoSiaPlazasreservadasStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var informacionsenalizacionPublicoSiaPlazasreservadasStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: informacionsenalizacionPublicoSiaPlazasreservadasStoreValues
		});

		fields.informacionsenalizacionPublicoSiaPlazasreservadas = Ext.create('Ext.form.ComboBox', {
			name: 'informacionsenalizacionPublicoSiaPlazasreservadas',
			fieldLabel: this.informacionsenalizacionPublicoSiaPlazasreservadasHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.informacionsenalizacionPublicoSiaPlazasreservadasDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 4, 10),
			store: informacionsenalizacionPublicoSiaPlazasreservadasStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var informacionsenalizacionPublicoSiaPuntosatencionStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'informacionsenalizacionPublicoSiaPuntosatencion') {
				informacionsenalizacionPublicoSiaPuntosatencionStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var informacionsenalizacionPublicoSiaPuntosatencionStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: informacionsenalizacionPublicoSiaPuntosatencionStoreValues
		});

		fields.informacionsenalizacionPublicoSiaPuntosatencion = Ext.create('Ext.form.ComboBox', {
			name: 'informacionsenalizacionPublicoSiaPuntosatencion',
			fieldLabel: this.informacionsenalizacionPublicoSiaPuntosatencionHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.informacionsenalizacionPublicoSiaPuntosatencionDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 1, 4),
			store: informacionsenalizacionPublicoSiaPuntosatencionStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var informacionsenalizacionPublicoSiaServicioshigienicosStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'informacionsenalizacionPublicoSiaServicioshigienicos') {
				informacionsenalizacionPublicoSiaServicioshigienicosStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var informacionsenalizacionPublicoSiaServicioshigienicosStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: informacionsenalizacionPublicoSiaServicioshigienicosStoreValues
		});

		fields.informacionsenalizacionPublicoSiaServicioshigienicos = Ext.create('Ext.form.ComboBox', {
			name: 'informacionsenalizacionPublicoSiaServicioshigienicos',
			fieldLabel: this.informacionsenalizacionPublicoSiaServicioshigienicosHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.informacionsenalizacionPublicoSiaServicioshigienicosDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 1, 4),
			store: informacionsenalizacionPublicoSiaServicioshigienicosStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var informacionsenalizacionBuclemagneticoStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'informacionsenalizacionBuclemagnetico') {
				informacionsenalizacionBuclemagneticoStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var informacionsenalizacionBuclemagneticoStor = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: informacionsenalizacionBuclemagneticoStoreValues
		});

		fields.informacionsenalizacionBuclemagnetico = Ext.create('Ext.form.ComboBox', {
			name: 'informacionsenalizacionBuclemagnetico',
			fieldLabel: this.informacionsenalizacionBuclemagneticoHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.informacionsenalizacionBuclemagneticoDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 3, 10.6),
			store: informacionsenalizacionBuclemagneticoStor,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var informacionsenalizacionBuclemagneticoSenalizadoStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'informacionsenalizacionBuclemagneticoSenalizado') {
				informacionsenalizacionBuclemagneticoSenalizadoStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var informacionsenalizacionBuclemagneticoSenalizadoStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: informacionsenalizacionBuclemagneticoSenalizadoStoreValues
		});

		fields.informacionsenalizacionBuclemagneticoSenalizado = Ext.create('Ext.form.ComboBox', {
			name: 'informacionsenalizacionBuclemagneticoSenalizado',
			fieldLabel: this.informacionsenalizacionBuclemagneticoSenalizadoHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.informacionsenalizacionBuclemagneticoSenalizadoDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 3, 10.6),
			store: informacionsenalizacionBuclemagneticoSenalizadoStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var informacionsenalizacionServicioshigienicossenalizadosStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'informacionsenalizacionServicioshigienicossenalizados') {
				informacionsenalizacionServicioshigienicossenalizadosStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var informacionsenalizacionServicioshigienicossenalizadosStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: informacionsenalizacionServicioshigienicossenalizadosStoreValues
		});

		fields.informacionsenalizacionServicioshigienicossenalizados = Ext.create('Ext.form.ComboBox', {
			name: 'informacionsenalizacionServicioshigienicossenalizados',
			fieldLabel: this.informacionsenalizacionServicioshigienicossenalizadosHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.informacionsenalizacionServicioshigienicossenalizadosDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3.6, 3, 10.6),
			store: informacionsenalizacionServicioshigienicossenalizadosStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var informacionsenalizacionSianormaStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'informacionsenalizacionSianorma') {
				informacionsenalizacionSianormaStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var informacionsenalizacionSianormaStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: informacionsenalizacionSianormaStoreValues
		});

		fields.informacionsenalizacionSianorma = Ext.create('Ext.form.ComboBox', {
			name: 'informacionsenalizacionSianorma',
			fieldLabel: this.informacionsenalizacionSianormaHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.informacionsenalizacionSianormaDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 3, 10.6),
			store: informacionsenalizacionSianormaStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		fields.informacionsenalizacionTodosusosObservaciones = new Ext.form.TextArea({
			name: 'informacionsenalizacionTodosusosObservaciones',
			fieldLabel: this.informacionsenalizacionTodosusosObservacionesHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.informacionsenalizacionTodosusosObservacionesDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(10.6, 0, 10.6),
			maxLength: 255
		})
		fields.informacionsenalizacionObservaciones = new Ext.form.TextArea({
			name: 'informacionsenalizacionObservaciones',
			fieldLabel: this.informacionsenalizacionObservacionesHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.informacionsenalizacionObservacionesDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(10.6, 0, 10.6),
			maxLength: 255
		})

		//-----------------------------------------------------------
		//Técnico y otros datos
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
			width: At4FrameworkIntranet.FormDefaults.size(3, 1, 9),
			store: esTecnicoInspeccionStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		fields.nif = new Ext.form.TextField({
			name: 'nif',
			fieldLabel: this.nifHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 1, 9),
			maxLength: 255
		})
		fields.tecnico = new Ext.form.TextField({
			name: 'tecnico',
			fieldLabel: this.tecnicoHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(5, 1, 9),
			maxLength: 255
		})
		fields.titulacion = new Ext.form.TextField({
			name: 'titulacion',
			fieldLabel: this.titulacionHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(4, 1, 9),
			maxLength: 255
		})

		var exteriorEdificioitinerarioaccesibleViapublicaStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'exteriorEdificioitinerarioaccesibleViapublica') {
				exteriorEdificioitinerarioaccesibleViapublicaStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var exteriorEdificioitinerarioaccesibleViapublicaStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: exteriorEdificioitinerarioaccesibleViapublicaStoreValues
		});

		fields.exteriorEdificioitinerarioaccesibleViapublica = Ext.create('Ext.form.ComboBox', {
			name: 'exteriorEdificioitinerarioaccesibleViapublica',
			fieldLabel: this.exteriorEdificioitinerarioaccesibleViapublicaHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.exteriorEdificioitinerarioaccesibleViapublicaDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 1, 9),
			store: exteriorEdificioitinerarioaccesibleViapublicaStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var exteriorEdificioitinerarioaccesibleZonascomunesStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'exteriorEdificioitinerarioaccesibleZonascomunes') {
				exteriorEdificioitinerarioaccesibleZonascomunesStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var exteriorEdificioitinerarioaccesibleZonascomunesStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: exteriorEdificioitinerarioaccesibleZonascomunesStoreValues
		});

		fields.exteriorEdificioitinerarioaccesibleZonascomunes = Ext.create('Ext.form.ComboBox', {
			name: 'exteriorEdificioitinerarioaccesibleZonascomunes',
			fieldLabel: this.exteriorEdificioitinerarioaccesibleZonascomunesHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.exteriorEdificioitinerarioaccesibleZonascomunesDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 1, 9),
			store: exteriorEdificioitinerarioaccesibleZonascomunesStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		fields.exteriorObservaciones = new Ext.form.TextArea({
			name: 'exteriorObservaciones',
			fieldLabel: this.exteriorObservacionesHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(9, 0, 9),
			maxLength: 255
		})

		var plantasItinerarioaccesibleElementosaccesiblesStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'plantasItinerarioaccesibleElementosaccesibles') {
				plantasItinerarioaccesibleElementosaccesiblesStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var plantasItinerarioaccesibleElementosaccesiblesStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: plantasItinerarioaccesibleElementosaccesiblesStoreValues
		});

		fields.plantasItinerarioaccesibleElementosaccesibles = Ext.create('Ext.form.ComboBox', {
			name: 'plantasItinerarioaccesibleElementosaccesibles',
			fieldLabel: this.plantasItinerarioaccesibleElementosaccesiblesHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.plantasItinerarioaccesibleElementosaccesiblesDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 3, 9),
			store: plantasItinerarioaccesibleElementosaccesiblesStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var plantasItinerarioaccesibleEntresiStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'plantasItinerarioaccesibleEntresi') {
				plantasItinerarioaccesibleEntresiStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var plantasItinerarioaccesibleEntresiStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: plantasItinerarioaccesibleEntresiStoreValues
		});

		fields.plantasItinerarioaccesibleEntresi = Ext.create('Ext.form.ComboBox', {
			name: 'plantasItinerarioaccesibleEntresi',
			fieldLabel: this.plantasItinerarioaccesibleEntresiHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.plantasItinerarioaccesibleEntresiDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 3, 9),
			store: plantasItinerarioaccesibleEntresiStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var plantasItinerarioaccesibleZonasusoprivadoStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'plantasItinerarioaccesibleZonasusoprivado') {
				plantasItinerarioaccesibleZonasusoprivadoStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var plantasItinerarioaccesibleZonasusoprivadoStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: plantasItinerarioaccesibleZonasusoprivadoStoreValues
		});

		fields.plantasItinerarioaccesibleZonasusoprivado = Ext.create('Ext.form.ComboBox', {
			name: 'plantasItinerarioaccesibleZonasusoprivado',
			fieldLabel: this.plantasItinerarioaccesibleZonasusoprivadoHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.plantasItinerarioaccesibleZonasusoprivadoDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 3, 9),
			store: plantasItinerarioaccesibleZonasusoprivadoStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var plantasItinerarioaccesibleZonasusopublicoStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'plantasItinerarioaccesibleZonasusopublico') {
				plantasItinerarioaccesibleZonasusopublicoStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var plantasItinerarioaccesibleZonasusopublicoStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: plantasItinerarioaccesibleZonasusopublicoStoreValues
		});

		fields.plantasItinerarioaccesibleZonasusopublico = Ext.create('Ext.form.ComboBox', {
			name: 'plantasItinerarioaccesibleZonasusopublico',
			fieldLabel: this.plantasItinerarioaccesibleZonasusopublicoHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.plantasItinerarioaccesibleZonasusopublicoDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 3, 9),
			store: plantasItinerarioaccesibleZonasusopublicoStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		fields.plantasItinerarioaccesibleObservaciones = new Ext.form.TextArea({
			name: 'plantasItinerarioaccesibleObservaciones',
			fieldLabel: this.plantasItinerarioaccesibleObservacionesHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.plantasItinerarioaccesibleObservacionesDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(9, 0, 9),
			maxLength: 255
		})

		var plazasreservadasDiscapacidadauditivaStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'plazasreservadasDiscapacidadauditiva') {
				plazasreservadasDiscapacidadauditivaStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var plazasreservadasDiscapacidadauditivaStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: plazasreservadasDiscapacidadauditivaStoreValues
		});

		fields.plazasreservadasDiscapacidadauditiva = Ext.create('Ext.form.ComboBox', {
			name: 'plazasreservadasDiscapacidadauditiva',
			fieldLabel: this.plazasreservadasDiscapacidadauditivaHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.plazasreservadasDiscapacidadauditivaDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 2, 9),
			store: plazasreservadasDiscapacidadauditivaStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var plazasreservadasSillaruedasStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'plazasreservadasSillaruedas') {
				plazasreservadasSillaruedasStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var plazasreservadasSillaruedasStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: plazasreservadasSillaruedasStoreValues
		});

		fields.plazasreservadasSillaruedas = Ext.create('Ext.form.ComboBox', {
			name: 'plazasreservadasSillaruedas',
			fieldLabel: this.plazasreservadasSillaruedasHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 2, 9),
			store: plazasreservadasSillaruedasStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var plazasreservadasZonaesperaSillaruedasStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'plazasreservadasZonaesperaSillaruedas') {
				plazasreservadasZonaesperaSillaruedasStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var plazasreservadasZonaesperaSillaruedasStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: plazasreservadasZonaesperaSillaruedasStoreValues
		});

		fields.plazasreservadasZonaesperaSillaruedas = Ext.create('Ext.form.ComboBox', {
			name: 'plazasreservadasZonaesperaSillaruedas',
			fieldLabel: this.plazasreservadasZonaesperaSillaruedasHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.plazasreservadasZonaesperaSillaruedasDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 2, 9),
			store: plazasreservadasZonaesperaSillaruedasStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		fields.plazasreservadasObservaciones = new Ext.form.TextArea({
			name: 'plazasreservadasObservaciones',
			fieldLabel: this.plazasreservadasObservacionesHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.plazasreservadasObservacionesDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(9, 0, 9),
			maxLength: 255
		})

		var servicioshigienicosAseoaccesibleStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'servicioshigienicosAseoaccesible') {
				servicioshigienicosAseoaccesibleStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var servicioshigienicosAseoaccesibleStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: servicioshigienicosAseoaccesibleStoreValues
		});

		fields.servicioshigienicosAseoaccesible = Ext.create('Ext.form.ComboBox', {
			name: 'servicioshigienicosAseoaccesible',
			fieldLabel: this.servicioshigienicosAseoaccesibleHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.servicioshigienicosAseoaccesibleDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 1, 9),
			store: servicioshigienicosAseoaccesibleStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var servicioshigienicosCabinaduchaaccesiblesStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'servicioshigienicosCabinaduchaaccesibles') {
				servicioshigienicosCabinaduchaaccesiblesStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var servicioshigienicosCabinaduchaaccesiblesStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: servicioshigienicosCabinaduchaaccesiblesStoreValues
		});

		fields.servicioshigienicosCabinaduchaaccesibles = Ext.create('Ext.form.ComboBox', {
			name: 'servicioshigienicosCabinaduchaaccesibles',
			fieldLabel: this.servicioshigienicosCabinaduchaaccesiblesHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.servicioshigienicosCabinaduchaaccesiblesDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 1, 9),
			store: servicioshigienicosCabinaduchaaccesiblesStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		fields.servicioshigienicosObservaciones = new Ext.form.TextArea({
			name: 'servicioshigienicosObservaciones',
			fieldLabel: this.servicioshigienicosObservacionesHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.servicioshigienicosObservacionesDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(9, 0, 9),
			maxLength: 255
		})

		var mecanismosAccesiblesStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'mecanismosAccesibles') {
				mecanismosAccesiblesStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var mecanismosAccesiblesStor = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: mecanismosAccesiblesStoreValues
		});

		fields.mecanismosAccesibles = Ext.create('Ext.form.ComboBox', {
			name: 'mecanismosAccesibles',
			fieldLabel: this.mecanismosAccesiblesHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(10, 1.5, 10),
			store: mecanismosAccesiblesStor,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		fields.mecanismosObservaciones = new Ext.form.TextArea({
			name: 'mecanismosObservaciones',
			fieldLabel: this.mecanismosObservacionesHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(10, 1.5, 10),
			maxLength: 255
		})

		var mobiliariofijoPuntoaccesibleStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'mobiliariofijoPuntoaccesible') {
				mobiliariofijoPuntoaccesibleStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var mobiliariofijoPuntoaccesibleStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: mobiliariofijoPuntoaccesibleStoreValues
		});

		fields.mobiliariofijoPuntoaccesible = Ext.create('Ext.form.ComboBox', {
			name: 'mobiliariofijoPuntoaccesible',
			fieldLabel: this.mobiliariofijoPuntoaccesibleHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(10, 1.5, 10),
			store: mobiliariofijoPuntoaccesibleStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		fields.mobiliariofijoObservaciones = new Ext.form.TextArea({
			name: 'mobiliariofijoObservaciones',
			fieldLabel: this.mobiliariofijoObservacionesHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(10, 1.5, 10),
			maxLength: 255
		})

		var piscinasEntradaaccesibleStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'piscinasEntradaaccesible') {
				piscinasEntradaaccesibleStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var piscinasEntradaaccesibleStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: piscinasEntradaaccesibleStoreValues
		});

		fields.piscinasEntradaaccesible = Ext.create('Ext.form.ComboBox', {
			name: 'piscinasEntradaaccesible',
			fieldLabel: this.piscinasEntradaaccesibleHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(10, 1.5, 10),
			store: piscinasEntradaaccesibleStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		fields.piscinasObservaciones = new Ext.form.TextArea({
			name: 'piscinasObservaciones',
			fieldLabel: this.piscinasObservacionesHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(10, 1.5, 10),
			maxLength: 255
		})

		this.fields = fields;
		var items = [
			At4FrameworkIntranet.FormDefaults.rows([
				[fields.claveInforme, fields.edificio, fields.inspeccionId]
			]), {
				xtype: 'At4Framework-formtabpanel',
				id: 'panelTabs-' + this.id,
				items: [{
					xtype: 'At4Framework-fieldmainpanel',
					title: this.datosGeneralesTitleLabel,
					items: [
						At4FrameworkIntranet.FormDefaults.rows([
							//alojamientos accesibles
							[{

								xtype: 'fieldset',
								border: true,
								title: this.alojamientosAccesiblesTitleLabel,
								items: [{
									xtype: "At4Framework-rowContainer",
									minWidth: false,
									items: At4FrameworkIntranet.FormDefaults.rows([
										[fields.alojamientosaccesibles1porcada50, fields.alojamientosaccesiblesMinimo1, fields.alojamientosaccesiblesMinimo2, fields.alojamientosaccesiblesMinimo4, fields.alojamientosaccesiblesMinimo6, fields.alojamientosaccesiblesMinimo8],
										[fields.alojamientosaccesiblesObservaciones]
									])
								}]

							}],
							//aparcamientos
							[{

								xtype: 'fieldset',
								border: true,
								title: this.aparcamientosTitleLabel,
								items: [{
									xtype: "At4Framework-rowContainer",
									minWidth: false,
									items: At4FrameworkIntranet.FormDefaults.rows([
										[fields.aparcamientoComercialPorfraccion, fields.aparcamientoOtrosusosMinimoaparcamientosUnamasporfraccion],
										[fields.aparcamientoOtrosusosMinimoaparcamientosUnaporfraccion, fields.aparcamientoResidencialpublicoPoralojamiento, fields.aparcamientoSillaruedas],
										[fields.aparcamientoObservaciones]
									])
								}]

							}],
						]),
					]
				}, {
					xtype: 'At4Framework-fieldmainpanel',
					title: this.entreplantasTitleLabel,
					items: [
						At4FrameworkIntranet.FormDefaults.rows([
							//accesible
							[{

								xtype: 'fieldset',
								border: true,
								title: this.accesibleTitleLabel,
								items: [{
									xtype: "At4Framework-rowContainer",
									minWidth: false,
									items: [fields.entreplantasAccesible, fields.entreplantasAccesibleAscensornoaccesible, fields.entreplantasAccesibleAscensornoaccesibleDimensiones]

								}, {
									xtype: "At4Framework-rowContainer",
									minWidth: false,
									items: [fields.entreplantasAccesibleAscensororampaaccesible, fields.entreplantasAccesibleRampaascensornoaccesible]

								}]

							}],
							//elementos accesibles
							[{

								xtype: 'fieldset',
								border: true,
								title: this.elementosAccesiblesTitleLabel,
								items: [{
									xtype: "At4Framework-rowContainer",
									minWidth: false,
									items: [fields.entreplantasElementosaccesibles, fields.entreplantasElementosaccesiblesAscensornoaccesible, fields.entreplantasElementosaccesiblesAscensornoaccesibleDimensione]
								}, {
									xtype: "At4Framework-rowContainer",
									minWidth: false,
									items: [fields.entreplantasElementosaccesiblesAscensororampaaccesible, fields.entreplantasElementosaccesiblesRampaascensornoaccesible]

								}]

							}],
							//NO accesible
							[{
								xtype: 'fieldset',
								border: true,
								title: this.noAccesibleTitleLabel,
								items: [{
									xtype: "At4Framework-rowContainer",
									minWidth: false,
									items: [fields.entreplantasNoaccesible, fields.entreplantasNoaccesibleAscensornoaccesible, fields.entreplantasNoaccesibleAscensornoaccesibleDimensiones]
								}, {
									xtype: "At4Framework-rowContainer",
									minWidth: false,
									items: [fields.entreplantasNoaccesibleAscensororampaaccesible, fields.entreplantasNoaccesibleRampaascensornoaccesible]

								}]

							}],
							//Zona uso publico
							[{
								xtype: 'fieldset',
								border: true,
								title: this.zonaUsoPublicoTitleLabel,
								items: [{
									xtype: "At4Framework-rowContainer",
									minWidth: false,
									items: [fields.entreplantasZonasusopublico, fields.entreplantasZonasusopublicoAscensornoaccesible, fields.entreplantasZonasusopublicoAscensornoaccesibleDimensiones]

								}, {
									xtype: "At4Framework-rowContainer",
									minWidth: false,
									items: [fields.entreplantasZonasusopublicoAscensororampaaccesible, fields.entreplantasZonasusopublicoRampaascensornoaccesible]

								}]

							}],
							[fields.entreplantasObservaciones]
						]),
					]
				}, {
					xtype: 'At4Framework-fieldmainpanel',
					title: this.informacionSenalizacionTitleLabel,
					items: [
						At4FrameworkIntranet.FormDefaults.rows([
							//ascensores
							[{
								xtype: 'fieldset',
								border: true,
								title: this.ascensorTitleLabel,
								items: [{
									xtype: "At4Framework-rowContainer",
									minWidth: false,
									items: [fields.informacionsenalizacionAscensores, fields.informacionsenalizacionAscensoresBrailearabigo, fields.informacionsenalizacionAscensoresNumeroplanta]


								}]

							}],
							//Bandas Visuales Tactiles
							[{
								xtype: 'fieldset',
								border: true,
								title: this.bandasVisualesTactilesTitleLabel,
								items: [{
									xtype: "At4Framework-rowContainer",
									minWidth: false,
									items: [fields.informacionsenalizacionBandasvisualestactiles, fields.informacionsenalizacionBandasvisualestactilesArranqueescalera, fields.informacionsenalizacionBandasvisualestactilesColorcontrastado, fields.informacionsenalizacionBandasvisualestactilesItinerarioaccesi]


								}, {
									xtype: "At4Framework-rowContainer",
									minWidth: false,
									items: [fields.informacionsenalizacionBandasvisualestactilesRelieveexterior, fields.informacionsenalizacionBandasvisualestactilesRelieveinterior]
								}]

							}],
							//Privado Sia
							[{
								xtype: 'fieldset',
								border: true,
								title: this.privadoSiaTitleLabel,
								items: [{
									xtype: "At4Framework-rowContainer",
									minWidth: false,
									items: [fields.informacionsenalizacionPrivadoSiaAparcamiento, fields.informacionsenalizacionPrivadoSiaAscensores, fields.informacionsenalizacionPrivadoSiaEntradas, fields.informacionsenalizacionPrivadoSiaItinerarios, fields.informacionsenalizacionPrivadoSiaPlazasreservadas]
								}]

							}],
							//Público Sia
							[{
								xtype: 'fieldset',
								border: true,
								title: this.publicoSiaTitleLabel,
								items: [{
									xtype: "At4Framework-rowContainer",
									minWidth: false,
									items: [fields.informacionsenalizacionPublicoSiaAparcamiento, fields.informacionsenalizacionPublicoSiaAscensores, fields.informacionsenalizacionPublicoSiaEntradas, fields.informacionsenalizacionPublicoSiaItinerarios, fields.informacionsenalizacionPublicoSiaPlazasreservadas]
								}, {
									xtype: "At4Framework-rowContainer",
									minWidth: false,
									items: [fields.informacionsenalizacionPublicoSiaPuntosatencion, fields.informacionsenalizacionPublicoSiaServicioshigienicos]
								}]

							}],
							[fields.informacionsenalizacionBuclemagnetico, fields.informacionsenalizacionBuclemagneticoSenalizado, fields.informacionsenalizacionServicioshigienicossenalizados, fields.informacionsenalizacionSianorma],
							[fields.informacionsenalizacionTodosusosObservaciones],
							[fields.informacionsenalizacionObservaciones]
						]),
					]
				}, {
					xtype: 'At4Framework-fieldmainpanel',
					title: this.tecnicoyOtrosDatos,
					items: [
						At4FrameworkIntranet.FormDefaults.rows([
							//Técnico
							[{
								xtype: 'fieldset',
								border: true,
								title: this.tecnicoTitleLabel,
								items: [{
									xtype: "At4Framework-rowContainer",
									minWidth: false,
									items: [fields.esTecnicoInspeccion, fields.nif]

								},{
									xtype: "At4Framework-rowContainer",
									minWidth: false,
									items: [fields.tecnico, fields.titulacion]

								}]

							}],
							//Exterior Edificio Itinerario Accesible
							[{
								xtype: 'fieldset',
								border: true,
								title: this.exteriorEdificioItinerarioAccesibleTitleLabel,
								items: [{
									xtype: "At4Framework-rowContainer",
									minWidth: false,
									items: [fields.exteriorEdificioitinerarioaccesibleViapublica, fields.exteriorEdificioitinerarioaccesibleZonascomunes]

								},{
									xtype: "At4Framework-rowContainer",
									minWidth: false,
									items: [fields.exteriorObservaciones]

								}]
							}],
							//Plantas Itinerario Accesible
							[{
								xtype: 'fieldset',
								border: true,
								title: this.plantasItinerarioAccesibleTitleLabel,
								items: [{
									xtype: "At4Framework-rowContainer",
									minWidth: false,
									items: [fields.plantasItinerarioaccesibleElementosaccesibles, fields.plantasItinerarioaccesibleEntresi, fields.plantasItinerarioaccesibleZonasusoprivado, fields.plantasItinerarioaccesibleZonasusopublico]
								}, {
									xtype: "At4Framework-rowContainer",
									minWidth: false,
									items: [fields.plantasItinerarioaccesibleObservaciones]
								}]

							}],
							//Plazas Reservadas
							[{
								xtype: 'fieldset',
								border: true,
								title: this.plazasReservadasTitleLabel,
								items: [{
									xtype: "At4Framework-rowContainer",
									minWidth: false,
									items: [fields.plazasreservadasDiscapacidadauditiva, fields.plazasreservadasSillaruedas, fields.plazasreservadasZonaesperaSillaruedas]
								}, {
									xtype: "At4Framework-rowContainer",
									minWidth: false,
									items: [fields.plazasreservadasObservaciones]
								}]

							}],
							//Servicios Higienicos
							[{
								xtype: 'fieldset',
								border: true,
								title: this.serviciosHigienicosTitleLabel,
								items: [{
									xtype: "At4Framework-rowContainer",
									minWidth: false,
									items: [fields.servicioshigienicosAseoaccesible, fields.servicioshigienicosCabinaduchaaccesibles]
								}, {
									xtype: "At4Framework-rowContainer",
									minWidth: false,
									items: [fields.servicioshigienicosObservaciones]
								}]

							}],
							[fields.mecanismosAccesibles], [fields.mecanismosObservaciones],
							[fields.mobiliariofijoPuntoaccesible], [fields.mobiliariofijoObservaciones],
							[fields.piscinasEntradaaccesible], [fields.piscinasObservaciones]
						]),
					]
				}, ]
			},
			At4FrameworkIntranet.FormDefaults.rows([
				[At4FrameworkIntranet.FormDefaults.resumenAuditoria()]
			])
		];



		this.maxTabIndex = tabHelper.getNext();
		this.callParent([application, formName, gridMetaData, items, config]);
	}
});
