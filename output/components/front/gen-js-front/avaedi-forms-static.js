//Namespace de  At4FrameworkIntranet
Ext.namespace('At4FrameworkIntranet');

/**
 * @class At4FrameworkIntranet.AccesibilidadAjustesRazonablesForm
 * Contiene la configuración del formulario: AccesibilidadAjustesRazonables
 * @author garrom
 * @constructor
 * @extends At4FrameworkIntranet.BasicForm
 * @param {Object} application La aplicación que contiene el formulario, normalmente será {@link At4FrameworkIntranet.app}
 * @param {String} formName Nombre del formulario
 * @param {Object} gridMetaData Configuración gridMetadata
 * @param {Object} config Configuración para Ext.form.FormPanel
 */

Ext.define("At4FrameworkIntranet.AccesibilidadAjustesRazonablesForm", {
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
			width: At4FrameworkIntranet.FormDefaults.size(2, 3, 12),
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
		fields.ajustesrazonablesCoste = new Ext.form.TextField({
			name: 'ajustesrazonablesCoste',
			fieldLabel: this.ajustesrazonablesCosteHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 3, 12),
			maxLength: 255
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
			width: At4FrameworkIntranet.FormDefaults.size(2, 0, 12),
			border: true,
			application: application,
			relatedIconCls: "",
			relatedForm: 'inspeccion'
		})

		var edificionosusceptibleajustesStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'edificionosusceptibleajustes') {
				edificionosusceptibleajustesStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var edificionosusceptibleajustesStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: edificionosusceptibleajustesStoreValues
		});

		fields.edificionosusceptibleajustes = Ext.create('Ext.form.ComboBox', {
			name: 'edificionosusceptibleajustes',
			fieldLabel: this.edificionosusceptibleajustesHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(4, 3, 16),
			store: edificionosusceptibleajustesStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var edificiosusceptibleajustesTotalStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'edificiosusceptibleajustesTotal') {
				edificiosusceptibleajustesTotalStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var edificiosusceptibleajustesTotalStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: edificiosusceptibleajustesTotalStoreValues
		});

		fields.edificiosusceptibleajustesTotal = Ext.create('Ext.form.ComboBox', {
			name: 'edificiosusceptibleajustesTotal',
			fieldLabel: this.edificiosusceptibleajustesTotalHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.edificiosusceptibleajustesTotalDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(4, 3, 16),
			store: edificiosusceptibleajustesTotalStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})
		
		fields.personasdiscapacitadasomayores = new Ext.form.TextField({
			name: 'personasdiscapacitadasomayores',
			fieldLabel: this.personasdiscapacitadasomayoresHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(4, 3, 16),
			maxLength: 255
		})
		fields.viviendasnoitinerarioaccesible = new Ext.form.TextField({
			name: 'viviendasnoitinerarioaccesible',
			fieldLabel: this.viviendasnoitinerarioaccesibleHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.viviendasnoitinerarioaccesibleDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(4, 3, 16),
			maxLength: 255
		})
		fields.financiacionayuda = new Ext.form.TextField({
			name: 'financiacionayuda',
			fieldLabel: this.financiacionayudaHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(4, 3, 16),
			maxLength: 255
		})
		fields.importegastoscomunes = new Ext.form.TextField({
			name: 'importegastoscomunes',
			fieldLabel: this.importegastoscomunesHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(4, 3, 16),
			maxLength: 255
		})
		fields.observacionesAnalisisNoMedidas = new Ext.form.TextField({
			name: 'observacionesAnalisisNoMedidas',
			fieldLabel: this.observacionesAnalisisNoMedidasHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.observacionesAnalisisNoMedidasDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(4, 3, 16),
			maxLength: 255
		})
		fields.observacionesCargaeconomica = new Ext.form.TextField({
			name: 'observacionesCargaeconomica',
			fieldLabel: this.observacionesCargaeconomicaHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(4, 3, 16),
			maxLength: 255
		})
		fields.observacionesConsideracionesinmueble = new Ext.form.TextField({
			name: 'observacionesConsideracionesinmueble',
			fieldLabel: this.observacionesConsideracionesinmuebleHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.observacionesConsideracionesinmuebleDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(4, 3, 16),
			maxLength: 255
		})
		fields.ajustesrazonablesDescripcion = new Ext.form.TextArea({
			name: 'ajustesrazonablesDescripcion',
			fieldLabel: this.ajustesrazonablesDescripcionHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(12, 0, 12),
			maxLength: 255
		})

		this.fields = fields;
		var items = [{
			xtype: 'At4Framework-fieldmainpanel',
			items: [
				At4FrameworkIntranet.FormDefaults.rows([
					[fields.claveInforme, fields.edificio, fields.ajustesrazonablesCoste, fields.inspeccionId],
					[fields.edificionosusceptibleajustes, fields.edificiosusceptibleajustesTotal, fields.personasdiscapacitadasomayores],
					[fields.viviendasnoitinerarioaccesible, fields.financiacionayuda, fields.importegastoscomunes],
					[fields.ajustesrazonablesDescripcion],
					At4FrameworkIntranet.FormDefaults.resumenAuditoria()
				]),
			]
		}];



		this.maxTabIndex = tabHelper.getNext();
		this.callParent([application, formName, gridMetaData, items, config]);
	}
});
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
//Namespace de  At4FrameworkIntranet
Ext.namespace('At4FrameworkIntranet');

/**
 * @class At4FrameworkIntranet.AccesibilidadValoracionFinalesForm
 * Contiene la configuración del formulario: AccesibilidadValoracionFinales
 * @author garrom
 * @constructor
 * @extends At4FrameworkIntranet.BasicForm
 * @param {Object} application La aplicación que contiene el formulario, normalmente será {@link At4FrameworkIntranet.app}
 * @param {String} formName Nombre del formulario
 * @param {Object} gridMetaData Configuración gridMetadata
 * @param {Object} config Configuración para Ext.form.FormPanel
 */

Ext.define("At4FrameworkIntranet.AccesibilidadValoracionFinalesForm", {
	extend: "At4FrameworkIntranet.InspeccionBaseForm",
	constructor: function (application, formName, gridMetaData, config) {
		Ext.apply(this, config);
		var tabHelper = new At4util.tabIndexHelper(this.tabIndex);

		var columnDefaults = At4FrameworkIntranet.FormDefaults.COLUMN_DEFAULTS;
		var fieldDefaults = At4FrameworkIntranet.FormDefaults.FIELD_DEFAULTS;

		var fields = {}


		var deficienciasViviendaInformacionsenalizacionStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'deficienciasViviendaInformacionsenalizacion') {
				deficienciasViviendaInformacionsenalizacionStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var deficienciasViviendaInformacionsenalizacionStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: deficienciasViviendaInformacionsenalizacionStoreValues
		});
		var deficienciasPublicoAlojamientosaccesiblesStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'deficienciasPublicoAlojamientosaccesibles') {
				deficienciasPublicoAlojamientosaccesiblesStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var deficienciasPublicoAlojamientosaccesiblesStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: deficienciasPublicoAlojamientosaccesiblesStoreValues
		});
		var deficienciasPublicoAparcamientoStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'deficienciasPublicoAparcamiento') {
				deficienciasPublicoAparcamientoStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var deficienciasPublicoAparcamientoStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: deficienciasPublicoAparcamientoStoreValues
		});
		var deficienciasPublicoEntreplantasStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'deficienciasPublicoEntreplantas') {
				deficienciasPublicoEntreplantasStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var deficienciasPublicoEntreplantasStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: deficienciasPublicoEntreplantasStoreValues
		});
		var deficienciasPublicoPiscinasStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'deficienciasPublicoPiscinas') {
				deficienciasPublicoPiscinasStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var deficienciasPublicoPiscinasStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: deficienciasPublicoPiscinasStoreValues
		});
		var deficienciasPublicoMecanismosStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'deficienciasPublicoMecanismos') {
				deficienciasPublicoMecanismosStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var deficienciasPublicoMecanismosStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: deficienciasPublicoMecanismosStoreValues
		});

		var deficienciasPublicoPlazasreservadasStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'deficienciasPublicoPlazasreservadas') {
				deficienciasPublicoPlazasreservadasStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var deficienciasPublicoPlazasreservadasStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: deficienciasPublicoPlazasreservadasStoreValues
		});

		var deficienciasPublicoPlantasStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'deficienciasPublicoPlantas') {
				deficienciasPublicoPlantasStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var deficienciasPublicoPlantasStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: deficienciasPublicoPlantasStoreValues
		});

		var deficienciasPublicoExteriorStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'deficienciasPublicoExterior') {
				deficienciasPublicoExteriorStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var deficienciasPublicoExteriorStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: deficienciasPublicoExteriorStoreValues
		});

		var deficienciasPublicoMobiliariofijoStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'deficienciasPublicoMobiliariofijo') {
				deficienciasPublicoMobiliariofijoStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var deficienciasPublicoMobiliariofijoStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: deficienciasPublicoMobiliariofijoStoreValues
		});

		var deficienciasPublicoServicioshigienicosStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'deficienciasPublicoServicioshigienicos') {
				deficienciasPublicoServicioshigienicosStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var deficienciasPublicoServicioshigienicosStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: deficienciasPublicoServicioshigienicosStoreValues
		});

		var deficienciasPublicoInformacionsenalizacionStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'deficienciasPublicoInformacionsenalizacion') {
				deficienciasPublicoInformacionsenalizacionStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var deficienciasPublicoInformacionsenalizacionStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: deficienciasPublicoInformacionsenalizacionStoreValues
		});

		var deficienciasViviendaPlantasStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'deficienciasViviendaPlantas') {
				deficienciasViviendaPlantasStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var deficienciasViviendaPlantasStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: deficienciasViviendaPlantasStoreValues
		});

		var deficienciasViviendaPiscinasStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'deficienciasViviendaPiscinas') {
				deficienciasViviendaPiscinasStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var deficienciasViviendaPiscinasStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: deficienciasViviendaPiscinasStoreValues
		});

		var deficienciasViviendaEntreplantasStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'deficienciasViviendaEntreplantas') {
				deficienciasViviendaEntreplantasStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var deficienciasViviendaEntreplantasStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: deficienciasViviendaEntreplantasStoreValues
		});

		var deficienciasViviendaMecanismosStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'deficienciasViviendaMecanismos') {
				deficienciasViviendaMecanismosStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var deficienciasViviendaMecanismosStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: deficienciasViviendaMecanismosStoreValues
		});

		var deficienciasViviendaAparcamientoStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'deficienciasViviendaAparcamiento') {
				deficienciasViviendaAparcamientoStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var deficienciasViviendaAparcamientoStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: deficienciasViviendaAparcamientoStoreValues
		});
		var deficienciasViviendaExteriorStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'deficienciasViviendaExterior') {
				deficienciasViviendaExteriorStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var deficienciasViviendaExteriorStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: deficienciasViviendaExteriorStoreValues
		});

		var deficienciasViviendaServicioshigienicosStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'deficienciasViviendaServicioshigienicos') {
				deficienciasViviendaServicioshigienicosStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var deficienciasViviendaServicioshigienicosStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: deficienciasViviendaServicioshigienicosStoreValues
		});

		var satisfaceCondicionesBasicasStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'satisfaceCondicionesBasicas') {
				satisfaceCondicionesBasicasStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var satisfaceCondicionesBasicasStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: satisfaceCondicionesBasicasStoreValues
		});


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
			width: At4FrameworkIntranet.FormDefaults.size(3, 2, 12),
			border: true,
			application: application,
			relatedIconCls: "",
			relatedForm: 'inspeccion'
		})

		fields.satisfaceCondicionesBasicas = Ext.create('Ext.form.ComboBox', {
			name: 'satisfaceCondicionesBasicas',
			fieldLabel: this.satisfaceCondicionesBasicasHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(4.166, 0, 12),
			store: satisfaceCondicionesBasicasStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})
		fields.deficienciasPublicoExterior = Ext.create('Ext.form.ComboBox', {
			name: 'deficienciasPublicoExterior',
			fieldLabel: this.deficienciasPublicoExteriorHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 2, 12),
			store: deficienciasPublicoExteriorStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})
		fields.deficienciasPublicoEntreplantas = Ext.create('Ext.form.ComboBox', {
			name: 'deficienciasPublicoEntreplantas',
			fieldLabel: this.deficienciasPublicoEntreplantasHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.deficienciasPublicoEntreplantasDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 2, 12),
			store: deficienciasPublicoEntreplantasStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})
		fields.deficienciasPublicoPlantas = Ext.create('Ext.form.ComboBox', {
			name: 'deficienciasPublicoPlantas',
			fieldLabel: this.deficienciasPublicoPlantasHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 2, 12),
			store: deficienciasPublicoPlantasStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})
		fields.deficienciasPublicoAlojamientosaccesibles = Ext.create('Ext.form.ComboBox', {
			name: 'deficienciasPublicoAlojamientosaccesibles',
			fieldLabel: this.deficienciasPublicoAlojamientosaccesiblesHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.deficienciasPublicoAlojamientosaccesiblesDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 2, 12),
			store: deficienciasPublicoAlojamientosaccesiblesStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})
		fields.deficienciasPublicoAparcamiento = Ext.create('Ext.form.ComboBox', {
			name: 'deficienciasPublicoAparcamiento',
			fieldLabel: this.deficienciasPublicoAparcamientoHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.deficienciasPublicoAparcamientoDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 2, 12),
			store: deficienciasPublicoAparcamientoStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})
		fields.deficienciasPublicoPlazasreservadas = Ext.create('Ext.form.ComboBox', {
			name: 'deficienciasPublicoPlazasreservadas',
			fieldLabel: this.deficienciasPublicoPlazasreservadasHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.deficienciasPublicoPlazasreservadasDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 2, 12),
			store: deficienciasPublicoPlazasreservadasStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})
		fields.deficienciasPublicoPiscinas = Ext.create('Ext.form.ComboBox', {
			name: 'deficienciasPublicoPiscinas',
			fieldLabel: this.deficienciasPublicoPiscinasHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 2, 12),
			store: deficienciasPublicoPiscinasStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})
		fields.deficienciasPublicoMobiliariofijo = Ext.create('Ext.form.ComboBox', {
			name: 'deficienciasPublicoMobiliariofijo',
			fieldLabel: this.deficienciasPublicoMobiliariofijoHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.deficienciasPublicoMobiliariofijoDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 2, 12),
			store: deficienciasPublicoMobiliariofijoStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		fields.deficienciasPublicoServicioshigienicos = Ext.create('Ext.form.ComboBox', {
			name: 'deficienciasPublicoServicioshigienicos',
			fieldLabel: this.deficienciasPublicoServicioshigienicosHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.deficienciasPublicoServicioshigienicosDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 2, 12),
			store: deficienciasPublicoServicioshigienicosStore,
			queryMode: 'local',
			labelStyle: 'white-space: nowrap',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})









		fields.deficienciasPublicoMecanismos = Ext.create('Ext.form.ComboBox', {
			name: 'deficienciasPublicoMecanismos',
			fieldLabel: this.deficienciasPublicoMecanismosHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.deficienciasPublicoMecanismosDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 2, 12),
			store: deficienciasPublicoMecanismosStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})
		fields.deficienciasViviendaInformacionsenalizacion = Ext.create('Ext.form.ComboBox', {
			name: 'deficienciasViviendaInformacionsenalizacion',
			fieldLabel: this.deficienciasViviendaInformacionsenalizacionHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.deficienciasViviendaInformacionsenalizacionDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(4.166, 0, 12),
			store: deficienciasViviendaInformacionsenalizacionStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})
		fields.deficienciasPublicoInformacionsenalizacion = Ext.create('Ext.form.ComboBox', {
			name: 'deficienciasPublicoInformacionsenalizacion',
			fieldLabel: this.deficienciasPublicoInformacionsenalizacionHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.deficienciasPublicoInformacionsenalizacionDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(5, 2, 12),
			store: deficienciasPublicoInformacionsenalizacionStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})









		fields.deficienciasViviendaPlantas = Ext.create('Ext.form.ComboBox', {
			name: 'deficienciasViviendaPlantas',
			fieldLabel: this.deficienciasViviendaPlantasHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 2, 12),
			store: deficienciasViviendaPlantasStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})
		fields.deficienciasViviendaEntreplantas = Ext.create('Ext.form.ComboBox', {
			name: 'deficienciasViviendaEntreplantas',
			fieldLabel: this.deficienciasViviendaEntreplantasHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.deficienciasViviendaEntreplantasDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 2, 12),
			store: deficienciasViviendaEntreplantasStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})






		fields.deficienciasViviendaMecanismos = Ext.create('Ext.form.ComboBox', {
			name: 'deficienciasViviendaMecanismos',
			fieldLabel: this.deficienciasViviendaMecanismosHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.deficienciasViviendaMecanismosDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 2, 12),
			store: deficienciasViviendaMecanismosStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})


		fields.deficienciasViviendaAparcamiento = Ext.create('Ext.form.ComboBox', {
			name: 'deficienciasViviendaAparcamiento',
			fieldLabel: this.deficienciasViviendaAparcamientoHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.deficienciasViviendaAparcamientoDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 2, 12),
			store: deficienciasViviendaAparcamientoStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})


		fields.deficienciasViviendaExterior = Ext.create('Ext.form.ComboBox', {
			name: 'deficienciasViviendaExterior',
			fieldLabel: this.deficienciasViviendaExteriorHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.deficienciasViviendaExteriorDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 2, 12),
			store: deficienciasViviendaExteriorStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})


		fields.deficienciasViviendaServicioshigienicos = Ext.create('Ext.form.ComboBox', {
			name: 'deficienciasViviendaServicioshigienicos',
			fieldLabel: this.deficienciasViviendaServicioshigienicosHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.deficienciasViviendaServicioshigienicosDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 2, 12),
			store: deficienciasViviendaServicioshigienicosStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})


		fields.deficienciasViviendaPiscinas = Ext.create('Ext.form.ComboBox', {
			name: 'deficienciasViviendaPiscinas',
			fieldLabel: this.deficienciasViviendaPiscinasHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.deficienciasViviendaPiscinasDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 2, 12),
			store: deficienciasViviendaPiscinasStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})


		this.fields = fields;
		var items = [{
			xtype: 'At4Framework-fieldmainpanel',
			items: [
				At4FrameworkIntranet.FormDefaults.rows([
					[fields.claveInforme, fields.edificio, fields.inspeccionId],
					[fields.satisfaceCondicionesBasicas],
					[{

						xtype: 'fieldset',
						border: true,
						title: this.deficienciasCondicionesFuncionalesTitleLabel,
						items: [{
							xtype: "At4Framework-rowContainer",
							minWidth: false,
							items: [fields.deficienciasPublicoExterior, fields.deficienciasPublicoEntreplantas, fields.deficienciasPublicoPlantas]

						}]
					}],
					[{

						xtype: 'fieldset',
						border: true,
						title: this.deficienciasEnDotacionDeElementosAccesiblesTitleLabel,
						items: [{
							xtype: "At4Framework-rowContainer",
							minWidth: false,
							items: [fields.deficienciasPublicoAlojamientosaccesibles, fields.deficienciasPublicoAparcamiento, fields.deficienciasPublicoPlazasreservadas]
						}, {
							xtype: "At4Framework-rowContainer",
							minWidth: false,
							items: [fields.deficienciasPublicoPiscinas, fields.deficienciasPublicoMobiliariofijo, fields.deficienciasPublicoServicioshigienicos]
						}, {
							xtype: "At4Framework-rowContainer",
							minWidth: false,
							items: [fields.deficienciasPublicoMecanismos]
						}]
					}],
					[{

						xtype: 'fieldset',
						border: true,
						title: this.deficienciasEnDotacionCaracterizacionSenalización,
						items: [{
							xtype: "At4Framework-rowContainer",
							minWidth: false,
							items: [fields.deficienciasViviendaInformacionsenalizacion, fields.deficienciasPublicoInformacionsenalizacion]
						}]
					}],
					[{

						xtype: 'fieldset',
						border: true,
						title: this.deficienciasGeneralesTitleLabel,
						items: [{
							xtype: "At4Framework-rowContainer",
							minWidth: false,
							items: [fields.deficienciasViviendaPlantas, fields.deficienciasViviendaEntreplantas, fields.deficienciasViviendaMecanismos]
						}, {
							xtype: "At4Framework-rowContainer",
							minWidth: false,
							items: [fields.deficienciasViviendaAparcamiento, fields.deficienciasViviendaExterior, fields.deficienciasViviendaServicioshigienicos]
						}, {
							xtype: "At4Framework-rowContainer",
							minWidth: false,
							items: [fields.deficienciasViviendaPiscinas]
						}, ]
					}],
					[At4FrameworkIntranet.FormDefaults.resumenAuditoria()]
				])
			]
		}];



		this.maxTabIndex = tabHelper.getNext();
		this.callParent([application, formName, gridMetaData, items, config]);
	}
});

//Namespace de  At4FrameworkIntranet
Ext.namespace('At4FrameworkIntranet');

/**
 * @class At4FrameworkIntranet.AcusticaComprobacionesForm
 * Contiene la configuración del formulario: AcusticaComprobaciones
 * @author garrom
 * @constructor
 * @extends At4FrameworkIntranet.BasicForm
 * @param {Object} application La aplicación que contiene el formulario, normalmente será {@link At4FrameworkIntranet.app}
 * @param {String} formName Nombre del formulario
 * @param {Object} gridMetaData Configuración gridMetadata
 * @param {Object} config Configuración para Ext.form.FormPanel
 */

 Ext.define("At4FrameworkIntranet.AcusticaComprobacionesForm",{
 	extend: "At4FrameworkIntranet.InspeccionBaseForm",
   constructor: function(application, formName, gridMetaData, config){
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

    var calasCatasElementosConstructivosStoreValues = [];
        //Buscamos la  columna para obtener los valores del store
        for (var i = 0; i < gridMetaData.columns.length; i++) {
            if (gridMetaData.columns[i].dataIndex == 'calasCatasElementosConstructivos') {
                calasCatasElementosConstructivosStoreValues = gridMetaData.columns[i].sofaStoreValues;
            }
        }
        var calasCatasElementosConstructivosStore = Ext.create('Ext.data.Store', {
            fields: ['ID', 'DISPLAY'],
            idProperty: "ID",
            data: calasCatasElementosConstructivosStoreValues
        });

        fields.calasCatasElementosConstructivos = Ext.create('Ext.form.ComboBox', {
            name: 'calasCatasElementosConstructivos',
            fieldLabel: this.calasCatasElementosConstructivosHeaderLabel,
            labelAttrTpl: " data-qtip='" + this.calasCatasElementosConstructivosDescriptionLabel + "'",
            tabIndex: tabHelper.getNext(),
            width: At4FrameworkIntranet.FormDefaults.size(1, 0, 12),
			labelStyle: 'white-space: nowrap',
            margin: "0, " + At4FrameworkIntranet.FormDefaults.size(4, 0, 12) + ", 0, 11",
            store: calasCatasElementosConstructivosStore,
            queryMode: 'local',
            valueField: 'ID',
            displayField: 'DISPLAY',
        })

        var cuestionariosConfortAcusticoStoreValues = [];
        //Buscamos la  columna para obtener los valores del store
        for (var i = 0; i < gridMetaData.columns.length; i++) {
            if (gridMetaData.columns[i].dataIndex == 'cuestionariosConfortAcustico') {
                cuestionariosConfortAcusticoStoreValues = gridMetaData.columns[i].sofaStoreValues;
            }
        }
        var cuestionariosConfortAcusticoStore = Ext.create('Ext.data.Store', {
            fields: ['ID', 'DISPLAY'],
            idProperty: "ID",
            data: cuestionariosConfortAcusticoStoreValues
        });

        fields.cuestionariosConfortAcustico = Ext.create('Ext.form.ComboBox', {
            name: 'cuestionariosConfortAcustico',
            fieldLabel: this.cuestionariosConfortAcusticoHeaderLabel,
            tabIndex: tabHelper.getNext(),
            width: At4FrameworkIntranet.FormDefaults.size(1, 0, 12),
			labelStyle: 'white-space: nowrap',
            store: cuestionariosConfortAcusticoStore,
            queryMode: 'local',
            valueField: 'ID',
            displayField: 'DISPLAY',
        })

        var medicionesAislamientoAcusticoStoreValues = [];
        //Buscamos la  columna para obtener los valores del store
        for (var i = 0; i < gridMetaData.columns.length; i++) {
            if (gridMetaData.columns[i].dataIndex == 'medicionesAislamientoAcustico') {
                medicionesAislamientoAcusticoStoreValues = gridMetaData.columns[i].sofaStoreValues;
            }
        }
        var medicionesAislamientoAcusticoStore = Ext.create('Ext.data.Store', {
            fields: ['ID', 'DISPLAY'],
            idProperty: "ID",
            data: medicionesAislamientoAcusticoStoreValues
        });

        fields.medicionesAislamientoAcustico = Ext.create('Ext.form.ComboBox', {
            name: 'medicionesAislamientoAcustico',
            fieldLabel: this.medicionesAislamientoAcusticoHeaderLabel,
            labelAttrTpl: " data-qtip='" + this.medicionesAislamientoAcusticoDescriptionLabel + "'",
            tabIndex: tabHelper.getNext(),
            width: At4FrameworkIntranet.FormDefaults.size(1, 0, 12),
			labelStyle: 'white-space: nowrap',
            store: medicionesAislamientoAcusticoStore,
            queryMode: 'local',
            valueField: 'ID',
            displayField: 'DISPLAY',
        })

        var otrasStoreValues = [];
        //Buscamos la  columna para obtener los valores del store
        for (var i = 0; i < gridMetaData.columns.length; i++) {
            if (gridMetaData.columns[i].dataIndex == 'otras') {
                otrasStoreValues = gridMetaData.columns[i].sofaStoreValues;
            }
        }
        var otrasStore = Ext.create('Ext.data.Store', {
            fields: ['ID', 'DISPLAY'],
            idProperty: "ID",
            data: otrasStoreValues
        });

        fields.otras = Ext.create('Ext.form.ComboBox', {
            name: 'otras',
            fieldLabel: this.otrasHeaderLabel,
            tabIndex: tabHelper.getNext(),
            width: At4FrameworkIntranet.FormDefaults.size(1, 0, 12),
			labelStyle: 'white-space: nowrap',
            store: otrasStore,
            queryMode: 'local',
            valueField: 'ID',
            displayField: 'DISPLAY',
        })

        fields.otrasTexto = new Ext.form.TextField({
            name: 'otrasTexto',
            fieldLabel: this.otrasTextoHeaderLabel,
            tabIndex: tabHelper.getNext(),
            width: At4FrameworkIntranet.FormDefaults.size(10, 0, 10),
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
        var items = [
        {
         xtype: 'At4Framework-fieldmainpanel'
         ,items: [
         At4FrameworkIntranet.FormDefaults.rows([
            [fields.claveInforme, fields.edificio, fields.inspeccionId],
            [fields.calasCatasElementosConstructivos, fields.cuestionariosConfortAcustico], [fields.medicionesAislamientoAcustico], [fields.otras],
            [fields.otrasTexto],
            [fields.observaciones],
            [At4FrameworkIntranet.FormDefaults.resumenAuditoria()]
            ])
         ]
     }
     ];



     this.maxTabIndex = tabHelper.getNext();
     this.callParent([application, formName, gridMetaData, items, config]);
 }
});
//Namespace de  At4FrameworkIntranet
Ext.namespace('At4FrameworkIntranet');

/**
 * @class At4FrameworkIntranet.AcusticaDatosGeneralesForm
 * Contiene la configuración del formulario: AcusticaDatosGenerales
 * @author garrom
 * @constructor
 * @extends At4FrameworkIntranet.BasicForm
 * @param {Object} application La aplicación que contiene el formulario, normalmente será {@link At4FrameworkIntranet.app}
 * @param {String} formName Nombre del formulario
 * @param {Object} gridMetaData Configuración gridMetadata
 * @param {Object} config Configuración para Ext.form.FormPanel
 */

Ext.define("At4FrameworkIntranet.AcusticaDatosGeneralesForm", {
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
			width: At4FrameworkIntranet.FormDefaults.size(4, 2, 12),
			border: true,
			application: application,
			relatedIconCls: "",
			relatedForm: 'inspeccion'
		})
		fields.tipoAreaAcustica = new Ext.form.TextField({
			name: 'tipoAreaAcustica',
			fieldLabel: this.tipoAreaAcusticaHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 3, 12),
			maxLength: 255
		})
		fields.indiceRuidoDia = new Ext.form.NumberField({
			name: 'indiceRuidoDia',
			fieldLabel: this.indiceRuidoDiaHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 3, 12),
			allowDecimals: false,
			maxValue: 2147483647
		})
		fields.objetivoCalidadAcustica = new Ext.form.NumberField({
			name: 'objetivoCalidadAcustica',
			fieldLabel: this.objetivoCalidadAcusticaHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 3, 12),
			allowDecimals: false,
			maxValue: 2147483647
		})
		fields.estudioEspecifico = new Ext.form.NumberField({
			name: 'estudioEspecifico',
			fieldLabel: this.estudioEspecificoHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 2, 12),
			allowDecimals: false,
			maxValue: 2147483647
		})
		fields.zonaRuidoAeronaves = Ext.create("Ext.ux.at4.ynncField", {
			name: 'zonaRuidoAeronaves',
			fieldLabel: this.zonaRuidoAeronavesHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(4, 2, 12),
			allowDecimals: false,
			maxValue: 2147483647
		})
		fields.fachadasNoExpuestasRuido = Ext.create("Ext.ux.at4.ynncField", {
			name: 'fachadasNoExpuestasRuido',
			fieldLabel: this.fachadasNoExpuestasRuidoHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(4, 2, 12),
			allowDecimals: false,
			maxValue: 2147483647
		})
		fields.recintosInstalacionesRecintosHabitables = new Ext.form.TextField({
			name: 'recintosInstalacionesRecintosHabitables',
			fieldLabel: this.recintosInstalacionesRecintosHabitablesHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.recintosInstalacionesRecintosHabitablesDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(6, 2, 12),
			maxLength: 255
		})
		fields.recintosInstalacionesZonasComunes = new Ext.form.TextField({
			name: 'recintosInstalacionesZonasComunes',
			fieldLabel: this.recintosInstalacionesZonasComunesHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.recintosInstalacionesZonasComunesDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(6, 2, 12),
			maxLength: 255
		})





        fields.recintosProtegidosAscensor = Ext.create("Ext.ux.at4.ynncField", {
            name: 'recintosProtegidosAscensor',
            fieldLabel: this.recintosProtegidosAscensorHeaderLabel,
            tabIndex: tabHelper.getNext(),
            width: At4FrameworkIntranet.FormDefaults.size(4, 2, 12),
            allowDecimals: false,
            maxValue: 2147483647
        })
		fields.recintosProtegidosZonaComun = Ext.create("Ext.ux.at4.ynncField", {
			name: 'recintosProtegidosZonaComun',
			fieldLabel: this.recintosProtegidosZonaComunHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(4, 2, 12),
			allowDecimals: false,
			maxValue: 2147483647
		})
		fields.recintosProtegidosRecintosInstalaciones = Ext.create("Ext.ux.at4.ynncField", {
			name: 'recintosProtegidosRecintosInstalaciones',
			fieldLabel: this.recintosProtegidosRecintosInstalacionesHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.recintosProtegidosRecintosInstalacionesDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(4, 2, 12),
			allowDecimals: false,
			maxValue: 2147483647
		})
		fields.recintosProtegidosRecintosProtegidos = Ext.create("Ext.ux.at4.ynncField", {
			name: 'recintosProtegidosRecintosProtegidos',
			fieldLabel: this.recintosProtegidosRecintosProtegidosHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.recintosProtegidosRecintosProtegidosDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(4, 2, 12),
			allowDecimals: false,
			maxValue: 2147483647
		})
		fields.recintosProtegidosRecintosHabitables = Ext.create("Ext.ux.at4.ynncField", {
			name: 'recintosProtegidosRecintosHabitables',
			fieldLabel: this.recintosProtegidosRecintosHabitablesHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.recintosProtegidosRecintosHabitablesDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(4, 2, 12),
			allowDecimals: false,
			maxValue: 2147483647
		})
		fields.existenRecintosInstalaciones = new Ext.form.TextField({
			name: 'existenRecintosInstalaciones',
			fieldLabel: this.existenRecintosInstalacionesHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.existenRecintosInstalacionesDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(4, 0, 12),
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
					[fields.tipoAreaAcustica, fields.indiceRuidoDia, fields.objetivoCalidadAcustica, fields.estudioEspecifico],
					[fields.zonaRuidoAeronaves, fields.fachadasNoExpuestasRuido],
					[fields.recintosInstalacionesRecintosHabitables, fields.recintosInstalacionesZonasComunes],
					[{

						xtype: 'fieldset',
						border: true,
						title: this.recintosProtegidosEnElEdificioTitleLabel,
						items: [{
							xtype: "At4Framework-rowContainer",
							minWidth: false,
							items: [fields.recintosProtegidosAscensor, fields.recintosProtegidosZonaComun]

						}, {
							xtype: "At4Framework-rowContainer",
							minWidth: false,
							items: [fields.recintosProtegidosRecintosInstalaciones, fields.recintosProtegidosRecintosProtegidos, fields.recintosProtegidosRecintosHabitables]

						}]

					}],
					[fields.existenRecintosInstalaciones],
					[fields.observaciones],
					[At4FrameworkIntranet.FormDefaults.resumenAuditoria()]
				])
			]
		}];



		this.maxTabIndex = tabHelper.getNext();
		this.callParent([application, formName, gridMetaData, items, config]);
	}
});
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
//Namespace de  At4FrameworkIntranet
Ext.namespace('At4FrameworkIntranet');

/**
 * @class At4FrameworkIntranet.AcusticaRuidoInstalacionesForm
 * Contiene la configuración del formulario: AcusticaRuidoInstalaciones
 * @author garrom
 * @constructor
 * @extends At4FrameworkIntranet.BasicForm
 * @param {Object} application La aplicación que contiene el formulario, normalmente será {@link At4FrameworkIntranet.app}
 * @param {String} formName Nombre del formulario
 * @param {Object} gridMetaData Configuración gridMetadata
 * @param {Object} config Configuración para Ext.form.FormPanel
 */

Ext.define("At4FrameworkIntranet.AcusticaRuidoInstalacionesForm", {
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
			width: At4FrameworkIntranet.FormDefaults.size(3, 3, 16),
			border: true,
			application: application,
			relatedIconCls: "",
			relatedForm: 'inspeccion'
		})


		//------------------------
		//------Recintos de instalaciones / actividades colindantes con  viviendas-----

		var recintosActividadTieneStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'recintosActividadTiene') {
				recintosActividadTieneStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var recintosActividadTieneStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: recintosActividadTieneStoreValues
		});

		fields.recintosActividadTiene = Ext.create('Ext.form.ComboBox', {
			name: 'recintosActividadTiene',
			fieldLabel: this.recintosActividadTieneHeaderLabel,
			tabIndex: tabHelper.getNext(),
			labelStyle: 'white-space: nowrap',
			width: At4FrameworkIntranet.FormDefaults.size(2, 0, 10),
			store: recintosActividadTieneStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		fields.recintosActividadTipoLocalizacion = new Ext.form.TextField({
			name: 'recintosActividadTipoLocalizacion',
			fieldLabel: this.recintosActividadTipoLocalizacionHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.recintosActividadTipoLocalizacionDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(10, 0, 10),
			maxLength: 255
		})
		var recintosActividadRevestidoStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'recintosActividadRevestido') {
				recintosActividadRevestidoStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var recintosActividadRevestidoStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: recintosActividadRevestidoStoreValues
		});

		fields.recintosActividadRevestido = Ext.create('Ext.form.ComboBox', {
			name: 'recintosActividadRevestido',
			fieldLabel: this.recintosActividadRevestidoHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 1, 10),
			store: recintosActividadRevestidoStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var recintosActividadTratamientoAbsorventeStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'recintosActividadTratamientoAbsorvente') {
				recintosActividadTratamientoAbsorventeStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var recintosActividadTratamientoAbsorventeStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: recintosActividadTratamientoAbsorventeStoreValues
		});

		fields.recintosActividadTratamientoAbsorvente = Ext.create('Ext.form.ComboBox', {
			name: 'recintosActividadTratamientoAbsorvente',
			fieldLabel: this.recintosActividadTratamientoAbsorventeHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.recintosActividadTratamientoAbsorventeDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			labelStyle: 'white-space: nowrap',
			width: At4FrameworkIntranet.FormDefaults.size(2, 1, 10),
			store: recintosActividadTratamientoAbsorventeStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var recintosActividadTrasdosadosStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'recintosActividadTrasdosados') {
				recintosActividadTrasdosadosStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var recintosActividadTrasdosadosStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: recintosActividadTrasdosadosStoreValues
		});

		fields.recintosActividadTrasdosados = Ext.create('Ext.form.ComboBox', {
			name: 'recintosActividadTrasdosados',
			fieldLabel: this.recintosActividadTrasdosadosHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 2, 10),
			store: recintosActividadTrasdosadosStore,
			labelStyle: 'white-space: nowrap',
			margin: "0, "+At4FrameworkIntranet.FormDefaults.size(2, -2, 10)+", 0, 11",
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var recintosActividadTrasdosadosAmortiguadoresStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'recintosActividadTrasdosadosAmortiguadores') {
				recintosActividadTrasdosadosAmortiguadoresStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var recintosActividadTrasdosadosAmortiguadoresStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: recintosActividadTrasdosadosAmortiguadoresStoreValues
		});

		fields.recintosActividadTrasdosadosAmortiguadores = Ext.create('Ext.form.ComboBox', {
			name: 'recintosActividadTrasdosadosAmortiguadores',
			fieldLabel: this.recintosActividadTrasdosadosAmortiguadoresHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.recintosActividadTrasdosadosAmortiguadoresDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			labelStyle: 'white-space: nowrap',
			width: At4FrameworkIntranet.FormDefaults.size(2, 2, 10),
			store: recintosActividadTrasdosadosAmortiguadoresStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var recintosActividadSueloFlotanteStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'recintosActividadSueloFlotante') {
				recintosActividadSueloFlotanteStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var recintosActividadSueloFlotanteStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: recintosActividadSueloFlotanteStoreValues
		});

		fields.recintosActividadSueloFlotante = Ext.create('Ext.form.ComboBox', {
			name: 'recintosActividadSueloFlotante',
			fieldLabel: this.recintosActividadSueloFlotanteHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.recintosActividadSueloFlotanteDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			labelStyle: 'white-space: nowrap',
			width: At4FrameworkIntranet.FormDefaults.size(2, 0, 10),
			store: recintosActividadSueloFlotanteStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var recintosActividadTechoSuspendidoStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'recintosActividadTechoSuspendido') {
				recintosActividadTechoSuspendidoStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var recintosActividadTechoSuspendidoStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: recintosActividadTechoSuspendidoStoreValues
		});

		fields.recintosActividadTechoSuspendido = Ext.create('Ext.form.ComboBox', {
			name: 'recintosActividadTechoSuspendido',
			fieldLabel: this.recintosActividadTechoSuspendidoHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.recintosActividadTechoSuspendidoDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			labelStyle: 'white-space: nowrap',
			width: At4FrameworkIntranet.FormDefaults.size(2, 0, 10),
			margin: "0, "+At4FrameworkIntranet.FormDefaults.size(2, -2, 10)+", 0, 11",
			store: recintosActividadTechoSuspendidoStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var recintosActividadTechoSuspendidoAmortiguadoresStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'recintosActividadTechoSuspendidoAmortiguadores') {
				recintosActividadTechoSuspendidoAmortiguadoresStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var recintosActividadTechoSuspendidoAmortiguadoresStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: recintosActividadTechoSuspendidoAmortiguadoresStoreValues
		});

		fields.recintosActividadTechoSuspendidoAmortiguadores = Ext.create('Ext.form.ComboBox', {
			name: 'recintosActividadTechoSuspendidoAmortiguadores',
			fieldLabel: this.recintosActividadTechoSuspendidoAmortiguadoresHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.recintosActividadTechoSuspendidoAmortiguadoresDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			labelStyle: 'white-space: nowrap',
			margin: "0, "+At4FrameworkIntranet.FormDefaults.size(2, -2, 10)+", 0, 11",
			width: At4FrameworkIntranet.FormDefaults.size(2, 2, 10),
			store: recintosActividadTechoSuspendidoAmortiguadoresStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var recintosActividadTechoSuspendidoAbsorventeStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'recintosActividadTechoSuspendidoAbsorvente') {
				recintosActividadTechoSuspendidoAbsorventeStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var recintosActividadTechoSuspendidoAbsorventeStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: recintosActividadTechoSuspendidoAbsorventeStoreValues
		});

		fields.recintosActividadTechoSuspendidoAbsorvente = Ext.create('Ext.form.ComboBox', {
			name: 'recintosActividadTechoSuspendidoAbsorvente',
			fieldLabel: this.recintosActividadTechoSuspendidoAbsorventeHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.recintosActividadTechoSuspendidoAbsorventeDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			labelStyle: 'white-space: nowrap',
			width: At4FrameworkIntranet.FormDefaults.size(2, 2, 10),
			store: recintosActividadTechoSuspendidoAbsorventeStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var recintosActividadRuidoMolestoStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'recintosActividadRuidoMolesto') {
				recintosActividadRuidoMolestoStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var recintosActividadRuidoMolestoStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: recintosActividadRuidoMolestoStoreValues
		});

		fields.recintosActividadRuidoMolesto = Ext.create('Ext.form.ComboBox', {
			name: 'recintosActividadRuidoMolesto',
			fieldLabel: this.recintosActividadRuidoMolestoHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.recintosActividadRuidoMolestoDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 2, 10),
			labelStyle: 'white-space: nowrap',
			store: recintosActividadRuidoMolestoStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		fields.recintosActividadRuidoMolestoTipoLocalizacion = new Ext.form.TextField({
			name: 'recintosActividadRuidoMolestoTipoLocalizacion',
			fieldLabel: this.recintosActividadRuidoMolestoTipoLocalizacionHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.recintosActividadRuidoMolestoTipoLocalizacionDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(10, 0, 10),
			maxLength: 255
		})

		//------------------------
		//------Equipos de instalaciones-----

		var equiposInstalacionesColindantesStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'equiposInstalacionesColindantes') {
				equiposInstalacionesColindantesStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var equiposInstalacionesColindantesStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: equiposInstalacionesColindantesStoreValues
		});

		fields.equiposInstalacionesColindantes = Ext.create('Ext.form.ComboBox', {
			name: 'equiposInstalacionesColindantes',
			fieldLabel: this.equiposInstalacionesColindantesHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.equiposInstalacionesColindantesDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 2, 10),
			labelStyle: 'white-space: nowrap',
			store: equiposInstalacionesColindantesStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var equiposInstalacionesZonasExterioresStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'equiposInstalacionesZonasExteriores') {
				equiposInstalacionesZonasExterioresStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var equiposInstalacionesZonasExterioresStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: equiposInstalacionesZonasExterioresStoreValues
		});

		fields.equiposInstalacionesZonasExteriores = Ext.create('Ext.form.ComboBox', {
			name: 'equiposInstalacionesZonasExteriores',
			fieldLabel: this.equiposInstalacionesZonasExterioresHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.equiposInstalacionesZonasExterioresDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 2, 10),
			labelStyle: 'white-space: nowrap',
			store: equiposInstalacionesZonasExterioresStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var equiposInstalacionesZonasExterioresPantallasStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'equiposInstalacionesZonasExterioresPantallas') {
				equiposInstalacionesZonasExterioresPantallasStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var equiposInstalacionesZonasExterioresPantallasStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: equiposInstalacionesZonasExterioresPantallasStoreValues
		});

		fields.equiposInstalacionesZonasExterioresPantallas = Ext.create('Ext.form.ComboBox', {
			name: 'equiposInstalacionesZonasExterioresPantallas',
			fieldLabel: this.equiposInstalacionesZonasExterioresPantallasHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.equiposInstalacionesZonasExterioresPantallasDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 2, 10),
			labelStyle: 'white-space: nowrap',
			store: equiposInstalacionesZonasExterioresPantallasStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var equiposInstalacionesSistemaAmortiguanteStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'equiposInstalacionesSistemaAmortiguante') {
				equiposInstalacionesSistemaAmortiguanteStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var equiposInstalacionesSistemaAmortiguanteStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: equiposInstalacionesSistemaAmortiguanteStoreValues
		});

		fields.equiposInstalacionesSistemaAmortiguante = Ext.create('Ext.form.ComboBox', {
			name: 'equiposInstalacionesSistemaAmortiguante',
			fieldLabel: this.equiposInstalacionesSistemaAmortiguanteHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.equiposInstalacionesSistemaAmortiguanteDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 2, 10),
			labelStyle: 'white-space: nowrap',
			margin: "0, "+At4FrameworkIntranet.FormDefaults.size(1, 2, 12)+", 0, 11",
			store: equiposInstalacionesSistemaAmortiguanteStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var equiposInstalacionesConectoresFlexiblesStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'equiposInstalacionesConectoresFlexibles') {
				equiposInstalacionesConectoresFlexiblesStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var equiposInstalacionesConectoresFlexiblesStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: equiposInstalacionesConectoresFlexiblesStoreValues
		});

		fields.equiposInstalacionesConectoresFlexibles = Ext.create('Ext.form.ComboBox', {
			name: 'equiposInstalacionesConectoresFlexibles',
			fieldLabel: this.equiposInstalacionesConectoresFlexiblesHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.equiposInstalacionesConectoresFlexiblesDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 2, 10),
			labelStyle: 'white-space: nowrap',
			margin: "0, "+At4FrameworkIntranet.FormDefaults.size(1, 2, 12)+", 0, 11",
			store: equiposInstalacionesConectoresFlexiblesStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})
		var equiposInstalacionesConductosAncladosStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'equiposInstalacionesConductosAnclados') {
				equiposInstalacionesConductosAncladosStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var equiposInstalacionesConductosAncladosStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: equiposInstalacionesConductosAncladosStoreValues
		});

		fields.equiposInstalacionesConductosAnclados = Ext.create('Ext.form.ComboBox', {
			name: 'equiposInstalacionesConductosAnclados',
			fieldLabel: this.equiposInstalacionesConductosAncladosHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.equiposInstalacionesConductosAncladosDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 2, 10),
			labelStyle: 'white-space: nowrap',
			margin: "0, "+At4FrameworkIntranet.FormDefaults.size(2, 1, 12)+", 0, 11",
			store: equiposInstalacionesConductosAncladosStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var equiposInstalacionesHolgurasSelladasStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'equiposInstalacionesHolgurasSelladas') {
				equiposInstalacionesHolgurasSelladasStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var equiposInstalacionesHolgurasSelladasStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: equiposInstalacionesHolgurasSelladasStoreValues
		});

		fields.equiposInstalacionesHolgurasSelladas = Ext.create('Ext.form.ComboBox', {
			name: 'equiposInstalacionesHolgurasSelladas',
			fieldLabel: this.equiposInstalacionesHolgurasSelladasHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.equiposInstalacionesHolgurasSelladasDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 2, 10),
			labelStyle: 'white-space: nowrap',
			margin: "0, "+At4FrameworkIntranet.FormDefaults.size(2, 1, 12)+", 0, 11",
			store: equiposInstalacionesHolgurasSelladasStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var equiposInstalacionesRuidoMolestoStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'equiposInstalacionesRuidoMolesto') {
				equiposInstalacionesRuidoMolestoStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var equiposInstalacionesRuidoMolestoStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: equiposInstalacionesRuidoMolestoStoreValues
		});

		fields.equiposInstalacionesRuidoMolesto = Ext.create('Ext.form.ComboBox', {
			name: 'equiposInstalacionesRuidoMolesto',
			fieldLabel: this.equiposInstalacionesRuidoMolestoHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.equiposInstalacionesRuidoMolestoDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 2, 10),
			labelStyle: 'white-space: nowrap',
			store: equiposInstalacionesRuidoMolestoStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		fields.equiposInstalacionesRuidoMolestoTipoLocalizacion = new Ext.form.TextField({
			name: 'equiposInstalacionesRuidoMolestoTipoLocalizacion',
			fieldLabel: this.equiposInstalacionesRuidoMolestoTipoLocalizacionHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.equiposInstalacionesRuidoMolestoTipoLocalizacionDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(10, 0, 10),
			maxLength: 255
		})

		//------------------------
		//------Red de saneamiento-----


		var redesSaneamientoCodoBajanteStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'redesSaneamientoCodoBajante') {
				redesSaneamientoCodoBajanteStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var redesSaneamientoCodoBajanteStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: redesSaneamientoCodoBajanteStoreValues
		});

		fields.redesSaneamientoCodoBajante = Ext.create('Ext.form.ComboBox', {
			name: 'redesSaneamientoCodoBajante',
			fieldLabel: this.redesSaneamientoCodoBajanteHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 2, 7),
			store: redesSaneamientoCodoBajanteStore,
			queryMode: 'local',
			width: At4FrameworkIntranet.FormDefaults.size(2, 2, 10),
			labelStyle: 'white-space: nowrap',
			margin: "0, "+At4FrameworkIntranet.FormDefaults.size(2, 1, 12)+", 0, 11",
			valueField: 'ID',
			displayField: 'DISPLAY',
		})
		var redesSaneamientoBajantesRevestidasStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'redesSaneamientoBajantesRevestidas') {
				redesSaneamientoBajantesRevestidasStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var redesSaneamientoBajantesRevestidasStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: redesSaneamientoBajantesRevestidasStoreValues
		});

		fields.redesSaneamientoBajantesRevestidas = Ext.create('Ext.form.ComboBox', {
			name: 'redesSaneamientoBajantesRevestidas',
			fieldLabel: this.redesSaneamientoBajantesRevestidasHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.redesSaneamientoBajantesRevestidasDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 2, 7),
			store: redesSaneamientoBajantesRevestidasStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var redesSaneamientoBajantesForradasStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'redesSaneamientoBajantesForradas') {
				redesSaneamientoBajantesForradasStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var redesSaneamientoBajantesForradasStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: redesSaneamientoBajantesForradasStoreValues
		});

		fields.redesSaneamientoBajantesForradas = Ext.create('Ext.form.ComboBox', {
			name: 'redesSaneamientoBajantesForradas',
			fieldLabel: this.redesSaneamientoBajantesForradasHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.redesSaneamientoBajantesForradasDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 2, 7),
			store: redesSaneamientoBajantesForradasStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var redesSaneamientoBajantesAbrazaderasStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'redesSaneamientoBajantesAbrazaderas') {
				redesSaneamientoBajantesAbrazaderasStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var redesSaneamientoBajantesAbrazaderasStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: redesSaneamientoBajantesAbrazaderasStoreValues
		});

		fields.redesSaneamientoBajantesAbrazaderas = Ext.create('Ext.form.ComboBox', {
			name: 'redesSaneamientoBajantesAbrazaderas',
			fieldLabel: this.redesSaneamientoBajantesAbrazaderasHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.redesSaneamientoBajantesAbrazaderasDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 2, 10),
			labelStyle: 'white-space: nowrap',
			// margin: "0, "+At4FrameworkIntranet.FormDefaults.size(2, 1, 12)+", 0, 11",
			store: redesSaneamientoBajantesAbrazaderasStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})


		var redesSaneamientoRuidoMolestoStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'redesSaneamientoRuidoMolesto') {
				redesSaneamientoRuidoMolestoStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var redesSaneamientoRuidoMolestoStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: redesSaneamientoRuidoMolestoStoreValues
		});

		fields.redesSaneamientoRuidoMolesto = Ext.create('Ext.form.ComboBox', {
			name: 'redesSaneamientoRuidoMolesto',
			fieldLabel: this.redesSaneamientoRuidoMolestoHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.redesSaneamientoRuidoMolestoDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 0, 10),
			labelStyle: 'white-space: nowrap',
			store: redesSaneamientoRuidoMolestoStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		fields.redesSaneamientoRuidoMolestoTipoLocalizacion = new Ext.form.TextField({
			name: 'redesSaneamientoRuidoMolestoTipoLocalizacion',
			fieldLabel: this.redesSaneamientoRuidoMolestoTipoLocalizacionHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.redesSaneamientoRuidoMolestoTipoLocalizacionDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(10, 0, 10),
			maxLength: 255
		})

		var redesSuministroAguaTuberiasForradasStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'redesSuministroAguaTuberiasForradas') {
				redesSuministroAguaTuberiasForradasStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var redesSuministroAguaTuberiasForradasStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: redesSuministroAguaTuberiasForradasStoreValues
		});

		fields.redesSuministroAguaTuberiasForradas = Ext.create('Ext.form.ComboBox', {
			name: 'redesSuministroAguaTuberiasForradas',
			fieldLabel: this.redesSuministroAguaTuberiasForradasHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.redesSuministroAguaTuberiasForradasDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 2, 10),
			labelStyle: 'white-space: nowrap',
			margin: "0, "+At4FrameworkIntranet.FormDefaults.size(2, 1, 12)+", 0, 11",
			store: redesSuministroAguaTuberiasForradasStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var redesSuministroAguaRuidoGolpeArieteStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'redesSuministroAguaRuidoGolpeAriete') {
				redesSuministroAguaRuidoGolpeArieteStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var redesSuministroAguaRuidoGolpeArieteStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: redesSuministroAguaRuidoGolpeArieteStoreValues
		});

		fields.redesSuministroAguaRuidoGolpeAriete = Ext.create('Ext.form.ComboBox', {
			name: 'redesSuministroAguaRuidoGolpeAriete',
			fieldLabel: this.redesSuministroAguaRuidoGolpeArieteHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.redesSuministroAguaRuidoGolpeArieteDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 2, 10),
			labelStyle: 'white-space: nowrap',
			store: redesSuministroAguaRuidoGolpeArieteStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var redesSuministroAguaRuidoMolestoStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'redesSuministroAguaRuidoMolesto') {
				redesSuministroAguaRuidoMolestoStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var redesSuministroAguaRuidoMolestoStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: redesSuministroAguaRuidoMolestoStoreValues
		});

		fields.redesSuministroAguaRuidoMolesto = Ext.create('Ext.form.ComboBox', {
			name: 'redesSuministroAguaRuidoMolesto',
			fieldLabel: this.redesSuministroAguaRuidoMolestoHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.redesSuministroAguaRuidoMolestoDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 2, 10),
			labelStyle: 'white-space: nowrap',
			// margin: "0, "+At4FrameworkIntranet.FormDefaults.size(2, 1, 12)+", 0, 11",
			store: redesSuministroAguaRuidoMolestoStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})
		fields.redesAguaRuidoMolestoTipoLocalizacion = new Ext.form.TextField({
			name: 'redesAguaRuidoMolestoTipoLocalizacion',
			fieldLabel: this.redesAguaRuidoMolestoTipoLocalizacionHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.redesAguaRuidoMolestoTipoLocalizacionDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(10, 0, 10),
			maxLength: 255
		})

		var redesAireAcondicionadoRuidoMolestoStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'redesAireAcondicionadoRuidoMolesto') {
				redesAireAcondicionadoRuidoMolestoStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var redesAireAcondicionadoRuidoMolestoStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: redesAireAcondicionadoRuidoMolestoStoreValues
		});

		fields.redesAireAcondicionadoRuidoMolesto = Ext.create('Ext.form.ComboBox', {
			name: 'redesAireAcondicionadoRuidoMolesto',
			fieldLabel: this.redesAireAcondicionadoRuidoMolestoHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.redesAireAcondicionadoRuidoMolestoDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 2, 10),
			labelStyle: 'white-space: nowrap',
			margin: "0, "+At4FrameworkIntranet.FormDefaults.size(2, 1, 12)+", 0, 11",
			store: redesAireAcondicionadoRuidoMolestoStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var redesAireAcondicionadoFalsoTechoStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'redesAireAcondicionadoFalsoTecho') {
				redesAireAcondicionadoFalsoTechoStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var redesAireAcondicionadoFalsoTechoStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: redesAireAcondicionadoFalsoTechoStoreValues
		});

		fields.redesAireAcondicionadoFalsoTecho = Ext.create('Ext.form.ComboBox', {
			name: 'redesAireAcondicionadoFalsoTecho',
			fieldLabel: this.redesAireAcondicionadoFalsoTechoHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.redesAireAcondicionadoFalsoTechoDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 2, 10),
			labelStyle: 'white-space: nowrap',
			// margin: "0, "+At4FrameworkIntranet.FormDefaults.size(2, 1, 12)+", 0, 11",
			store: redesAireAcondicionadoFalsoTechoStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var redesVentilacionConductosShuntStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'redesVentilacionConductosShunt') {
				redesVentilacionConductosShuntStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var redesVentilacionConductosShuntStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: redesVentilacionConductosShuntStoreValues
		});

		fields.redesVentilacionConductosShunt = Ext.create('Ext.form.ComboBox', {
			name: 'redesVentilacionConductosShunt',
			fieldLabel: this.redesVentilacionConductosShuntHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.redesVentilacionConductosShuntDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 2, 10),
			store: redesVentilacionConductosShuntStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var redesVentilacionConductoIndividualStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'redesVentilacionConductoIndividual') {
				redesVentilacionConductoIndividualStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var redesVentilacionConductoIndividualStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: redesVentilacionConductoIndividualStoreValues
		});

		fields.redesVentilacionConductoIndividual = Ext.create('Ext.form.ComboBox', {
			name: 'redesVentilacionConductoIndividual',
			fieldLabel: this.redesVentilacionConductoIndividualHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.redesVentilacionConductoIndividualDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 2, 10),
			store: redesVentilacionConductoIndividualStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		//------------------------
		//------Otras instalaciones y puntos singulares-----

		var otrasAscensoresColindantesStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'otrasAscensoresColindantes') {
				otrasAscensoresColindantesStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var otrasAscensoresColindantesStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: otrasAscensoresColindantesStoreValues
		});

		fields.otrasAscensoresColindantes = Ext.create('Ext.form.ComboBox', {
			name: 'otrasAscensoresColindantes',
			fieldLabel: this.otrasAscensoresColindantesHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 2, 10),
			store: otrasAscensoresColindantesStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var otrasAscensoresCuartoMaquinasStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'otrasAscensoresCuartoMaquinas') {
				otrasAscensoresCuartoMaquinasStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var otrasAscensoresCuartoMaquinasStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: otrasAscensoresCuartoMaquinasStoreValues
		});

		fields.otrasAscensoresCuartoMaquinas = Ext.create('Ext.form.ComboBox', {
			name: 'otrasAscensoresCuartoMaquinas',
			fieldLabel: this.otrasAscensoresCuartoMaquinasHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.otrasAscensoresCuartoMaquinasDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 2, 10),
			store: otrasAscensoresCuartoMaquinasStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var otrasAscensoresSistemaAmortiguanteStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'otrasAscensoresSistemaAmortiguante') {
				otrasAscensoresSistemaAmortiguanteStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var otrasAscensoresSistemaAmortiguanteStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: otrasAscensoresSistemaAmortiguanteStoreValues
		});

		fields.otrasAscensoresSistemaAmortiguante = Ext.create('Ext.form.ComboBox', {
			name: 'otrasAscensoresSistemaAmortiguante',
			fieldLabel: this.otrasAscensoresSistemaAmortiguanteHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.otrasAscensoresSistemaAmortiguanteDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 2, 10),
			labelStyle: 'white-space: nowrap',
			store: otrasAscensoresSistemaAmortiguanteStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var otrasAscensoresTrasdosadoStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'otrasAscensoresTrasdosado') {
				otrasAscensoresTrasdosadoStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var otrasAscensoresTrasdosadoStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: otrasAscensoresTrasdosadoStoreValues
		});

		fields.otrasAscensoresTrasdosado = Ext.create('Ext.form.ComboBox', {
			name: 'otrasAscensoresTrasdosado',
			fieldLabel: this.otrasAscensoresTrasdosadoHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 2, 10),
			store: otrasAscensoresTrasdosadoStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var otrasAscensoresCuadroManiobrasStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'otrasAscensoresCuadroManiobras') {
				otrasAscensoresCuadroManiobrasStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var otrasAscensoresCuadroManiobrasStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: otrasAscensoresCuadroManiobrasStoreValues
		});

		fields.otrasAscensoresCuadroManiobras = Ext.create('Ext.form.ComboBox', {
			name: 'otrasAscensoresCuadroManiobras',
			fieldLabel: this.otrasAscensoresCuadroManiobrasHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.otrasAscensoresCuadroManiobrasDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 2, 10),
			store: otrasAscensoresCuadroManiobrasStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var otrasAscensoresRuidoMolestoStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'otrasAscensoresRuidoMolesto') {
				otrasAscensoresRuidoMolestoStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var otrasAscensoresRuidoMolestoStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: otrasAscensoresRuidoMolestoStoreValues
		});

		fields.otrasAscensoresRuidoMolesto = Ext.create('Ext.form.ComboBox', {
			name: 'otrasAscensoresRuidoMolesto',
			fieldLabel: this.otrasAscensoresRuidoMolestoHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 2, 10),
			store: otrasAscensoresRuidoMolestoStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		fields.otrasAscensoresRuidoMolestoTipoLocalizacion = new Ext.form.TextField({
			name: 'otrasAscensoresRuidoMolestoTipoLocalizacion',
			fieldLabel: this.otrasAscensoresRuidoMolestoTipoLocalizacionHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.otrasAscensoresRuidoMolestoTipoLocalizacionDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(10, 0, 10),
			maxLength: 255
		})

		var otrasCuartosHumedosSaneamientoStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'otrasCuartosHumedosSaneamiento') {
				otrasCuartosHumedosSaneamientoStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var otrasCuartosHumedosSaneamientoStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: otrasCuartosHumedosSaneamientoStoreValues
		});

		fields.otrasCuartosHumedosSaneamiento = Ext.create('Ext.form.ComboBox', {
			name: 'otrasCuartosHumedosSaneamiento',
			fieldLabel: this.otrasCuartosHumedosSaneamientoHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.otrasCuartosHumedosSaneamientoDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 2, 10),
			store: otrasCuartosHumedosSaneamientoStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var otrasCuartosHumedosSaneamientoLanaMineralStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'otrasCuartosHumedosSaneamientoLanaMineral') {
				otrasCuartosHumedosSaneamientoLanaMineralStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var otrasCuartosHumedosSaneamientoLanaMineralStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: otrasCuartosHumedosSaneamientoLanaMineralStoreValues
		});

		fields.otrasCuartosHumedosSaneamientoLanaMineral = Ext.create('Ext.form.ComboBox', {
			name: 'otrasCuartosHumedosSaneamientoLanaMineral',
			fieldLabel: this.otrasCuartosHumedosSaneamientoLanaMineralHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.otrasCuartosHumedosSaneamientoLanaMineralDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 2, 10),
			labelStyle: 'white-space: nowrap',
			margin: "0, "+At4FrameworkIntranet.FormDefaults.size(1, -2, 12)+", 0, 11",
			store: otrasCuartosHumedosSaneamientoLanaMineralStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var otrasCuartosHumedosSaneamientoMaterialElasticoStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'otrasCuartosHumedosSaneamientoMaterialElastico') {
				otrasCuartosHumedosSaneamientoMaterialElasticoStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var otrasCuartosHumedosSaneamientoMaterialElasticoStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: otrasCuartosHumedosSaneamientoMaterialElasticoStoreValues
		});

		fields.otrasCuartosHumedosSaneamientoMaterialElastico = Ext.create('Ext.form.ComboBox', {
			name: 'otrasCuartosHumedosSaneamientoMaterialElastico',
			fieldLabel: this.otrasCuartosHumedosSaneamientoMaterialElasticoHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.otrasCuartosHumedosSaneamientoMaterialElasticoDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 2, 10),
			labelStyle: 'white-space: nowrap',
			margin: "0, "+At4FrameworkIntranet.FormDefaults.size(1, -2, 12)+", 0, 11",
			store: otrasCuartosHumedosSaneamientoMaterialElasticoStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var otrasCuartosHumedosSaneamientoConectoresFlexiblesStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'otrasCuartosHumedosSaneamientoConectoresFlexibles') {
				otrasCuartosHumedosSaneamientoConectoresFlexiblesStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var otrasCuartosHumedosSaneamientoConectoresFlexiblesStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: otrasCuartosHumedosSaneamientoConectoresFlexiblesStoreValues
		});

		fields.otrasCuartosHumedosSaneamientoConectoresFlexibles = Ext.create('Ext.form.ComboBox', {
			name: 'otrasCuartosHumedosSaneamientoConectoresFlexibles',
			fieldLabel: this.otrasCuartosHumedosSaneamientoConectoresFlexiblesHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.otrasCuartosHumedosSaneamientoConectoresFlexiblesDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 2, 10),
			labelStyle: 'white-space: nowrap',
			margin: "0, "+At4FrameworkIntranet.FormDefaults.size(1, -2, 12)+", 0, 11",
			store: otrasCuartosHumedosSaneamientoConectoresFlexiblesStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var otrasCuartosHumedosSaneamientoTechoSelladoStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'otrasCuartosHumedosSaneamientoTechoSellado') {
				otrasCuartosHumedosSaneamientoTechoSelladoStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var otrasCuartosHumedosSaneamientoTechoSelladoStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: otrasCuartosHumedosSaneamientoTechoSelladoStoreValues
		});

		fields.otrasCuartosHumedosSaneamientoTechoSellado = Ext.create('Ext.form.ComboBox', {
			name: 'otrasCuartosHumedosSaneamientoTechoSellado',
			fieldLabel: this.otrasCuartosHumedosSaneamientoTechoSelladoHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.otrasCuartosHumedosSaneamientoTechoSelladoDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 2, 10),
			labelStyle: 'white-space: nowrap',
			margin: "0, "+At4FrameworkIntranet.FormDefaults.size(1, -2, 12)+", 0, 11",
			store: otrasCuartosHumedosSaneamientoTechoSelladoStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var otrasCuartosHumedosAireAcondicionadoStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'otrasCuartosHumedosAireAcondicionado') {
				otrasCuartosHumedosAireAcondicionadoStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var otrasCuartosHumedosAireAcondicionadoStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: otrasCuartosHumedosAireAcondicionadoStoreValues
		});

		fields.otrasCuartosHumedosAireAcondicionado = Ext.create('Ext.form.ComboBox', {
			name: 'otrasCuartosHumedosAireAcondicionado',
			fieldLabel: this.otrasCuartosHumedosAireAcondicionadoHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.otrasCuartosHumedosAireAcondicionadoDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 2, 10),
			// labelStyle: 'white-space: nowrap',
			// margin: "0, "+At4FrameworkIntranet.FormDefaults.size(2, -2, 12)+", 0, 11",
			store: otrasCuartosHumedosAireAcondicionadoStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var otrasCuartosHumedosLuminariasEmpotradasStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'otrasCuartosHumedosLuminariasEmpotradas') {
				otrasCuartosHumedosLuminariasEmpotradasStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var otrasCuartosHumedosLuminariasEmpotradasStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: otrasCuartosHumedosLuminariasEmpotradasStoreValues
		});

		fields.otrasCuartosHumedosLuminariasEmpotradas = Ext.create('Ext.form.ComboBox', {
			name: 'otrasCuartosHumedosLuminariasEmpotradas',
			fieldLabel: this.otrasCuartosHumedosLuminariasEmpotradasHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.otrasCuartosHumedosLuminariasEmpotradasDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 2, 10),
			labelStyle: 'white-space: nowrap',
			// margin: "0, "+At4FrameworkIntranet.FormDefaults.size(2, -2, 12)+", 0, 11",
			store: otrasCuartosHumedosLuminariasEmpotradasStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var otrasCuartosHumedosRuidoMolestoStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'otrasCuartosHumedosRuidoMolesto') {
				otrasCuartosHumedosRuidoMolestoStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var otrasCuartosHumedosRuidoMolestoStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: otrasCuartosHumedosRuidoMolestoStoreValues
		});

		fields.otrasCuartosHumedosRuidoMolesto = Ext.create('Ext.form.ComboBox', {
			name: 'otrasCuartosHumedosRuidoMolesto',
			fieldLabel: this.otrasCuartosHumedosRuidoMolestoHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.otrasCuartosHumedosRuidoMolestoDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 2, 10),
			// labelStyle: 'white-space: nowrap',
			// margin: "0, "+At4FrameworkIntranet.FormDefaults.size(2, -2, 12)+", 0, 11",
			store: otrasCuartosHumedosRuidoMolestoStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		fields.otrasCuartosHumedosRuidoMolestoTipoLocalizacion = new Ext.form.TextField({
			name: 'otrasCuartosHumedosRuidoMolestoTipoLocalizacion',
			fieldLabel: this.otrasCuartosHumedosRuidoMolestoTipoLocalizacionHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.otrasCuartosHumedosRuidoMolestoTipoLocalizacionDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(10, 0, 10),
			maxLength: 255
		})

		var otrasPuertasGarajeAncladasStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'otrasPuertasGarajeAncladas') {
				otrasPuertasGarajeAncladasStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var otrasPuertasGarajeAncladasStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: otrasPuertasGarajeAncladasStoreValues
		});

		fields.otrasPuertasGarajeAncladas = Ext.create('Ext.form.ComboBox', {
			name: 'otrasPuertasGarajeAncladas',
			fieldLabel: this.otrasPuertasGarajeAncladasHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 0, 10),
			store: otrasPuertasGarajeAncladasStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var otrasPuertasGarajeAncladasMotoresAmortiguadoresStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'otrasPuertasGarajeAncladasMotoresAmortiguadores') {
				otrasPuertasGarajeAncladasMotoresAmortiguadoresStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var otrasPuertasGarajeAncladasMotoresAmortiguadoresStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: otrasPuertasGarajeAncladasMotoresAmortiguadoresStoreValues
		});

		fields.otrasPuertasGarajeAncladasMotoresAmortiguadores = Ext.create('Ext.form.ComboBox', {
			name: 'otrasPuertasGarajeAncladasMotoresAmortiguadores',
			fieldLabel: this.otrasPuertasGarajeAncladasMotoresAmortiguadoresHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.otrasPuertasGarajeAncladasMotoresAmortiguadoresDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(4, 3, 12),
			store: otrasPuertasGarajeAncladasMotoresAmortiguadoresStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var otrasPuertasGarajeAncladasMarcoAmortiguadoresStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'otrasPuertasGarajeAncladasMarcoAmortiguadores') {
				otrasPuertasGarajeAncladasMarcoAmortiguadoresStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var otrasPuertasGarajeAncladasMarcoAmortiguadoresStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: otrasPuertasGarajeAncladasMarcoAmortiguadoresStoreValues
		});

		fields.otrasPuertasGarajeAncladasMarcoAmortiguadores = Ext.create('Ext.form.ComboBox', {
			name: 'otrasPuertasGarajeAncladasMarcoAmortiguadores',
			fieldLabel: this.otrasPuertasGarajeAncladasMarcoAmortiguadoresHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.otrasPuertasGarajeAncladasMarcoAmortiguadoresDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 3, 12),
			store: otrasPuertasGarajeAncladasMarcoAmortiguadoresStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var otrasPuertasGarajeAncladasRuidoPuertaStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'otrasPuertasGarajeAncladasRuidoPuerta') {
				otrasPuertasGarajeAncladasRuidoPuertaStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var otrasPuertasGarajeAncladasRuidoPuertaStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: otrasPuertasGarajeAncladasRuidoPuertaStoreValues
		});

		fields.otrasPuertasGarajeAncladasRuidoPuerta = Ext.create('Ext.form.ComboBox', {
			name: 'otrasPuertasGarajeAncladasRuidoPuerta',
			fieldLabel: this.otrasPuertasGarajeAncladasRuidoPuertaHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.otrasPuertasGarajeAncladasRuidoPuertaDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 3, 12),
			store: otrasPuertasGarajeAncladasRuidoPuertaStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})









		fields.observaciones = new Ext.form.TextArea({
			name: 'observaciones',
			fieldLabel: this.observacionesHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(11, 0, 11),
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
					title: this.recintoDeInstalacionesTitleLabel,
					items: [
						At4FrameworkIntranet.FormDefaults.rows([
							[fields.recintosActividadTiene],
							[fields.recintosActividadTipoLocalizacion],
							[fields.recintosActividadRevestido, fields.recintosActividadTratamientoAbsorvente],
							[fields.recintosActividadTrasdosados, fields.recintosActividadTrasdosadosAmortiguadores],
							[fields.recintosActividadSueloFlotante],
							[fields.recintosActividadTechoSuspendido, fields.recintosActividadTechoSuspendidoAmortiguadores, fields.recintosActividadTechoSuspendidoAbsorvente],
							[fields.recintosActividadRuidoMolesto],
							[fields.recintosActividadRuidoMolestoTipoLocalizacion]
						])
					]
				}, {
					xtype: 'At4Framework-fieldmainpanel',
					title: this.equipoDeInstalacionesTitleLabel,
					items: [At4FrameworkIntranet.FormDefaults.rows([
						[fields.equiposInstalacionesColindantes],
						[fields.equiposInstalacionesZonasExteriores],
						[fields.equiposInstalacionesZonasExterioresPantallas],
						[fields.equiposInstalacionesSistemaAmortiguante, fields.equiposInstalacionesConectoresFlexibles, fields.equiposInstalacionesConductosAnclados, fields.equiposInstalacionesHolgurasSelladas],
						[fields.equiposInstalacionesRuidoMolesto],
						[fields.equiposInstalacionesRuidoMolestoTipoLocalizacion]

					])]
				}, {
					xtype: 'At4Framework-fieldmainpanel',
					title: this.redDeSaneamientoTitleLabel,
					items: [At4FrameworkIntranet.FormDefaults.rows([
						//red de saneamiento
						[fields.redesSaneamientoCodoBajante, fields.redesSaneamientoBajantesRevestidas, fields.redesSaneamientoBajantesForradas, fields.redesSaneamientoBajantesAbrazaderas],
						[fields.redesSaneamientoRuidoMolesto],
						[fields.redesSaneamientoRuidoMolestoTipoLocalizacion],
						//red de suministro de agua
						[fields.redesSuministroAguaTuberiasForradas, fields.redesSuministroAguaRuidoGolpeAriete, fields.redesSuministroAguaRuidoMolesto],
						[fields.redesAguaRuidoMolestoTipoLocalizacion],
						//red de conductos de aire acondicionado
						[fields.redesAireAcondicionadoRuidoMolesto, fields.redesAireAcondicionadoFalsoTecho],
						//red de conductos de ventilación
						[fields.redesVentilacionConductosShunt, fields.redesVentilacionRuidoViviendasColindantes, fields.redesVentilacionConductoIndividual]
					])]
				}, {
					xtype: 'At4Framework-fieldmainpanel',
					title: this.otrasInstalacionesYPuntosSingularesTitleLabel,
					items: [At4FrameworkIntranet.FormDefaults.rows([
						//Ascensores y montacargas
						[fields.otrasAscensoresColindantes, fields.otrasAscensoresCuartoMaquinas, fields.otrasAscensoresSistemaAmortiguante],
						[fields.otrasAscensoresTrasdosado, fields.otrasAscensoresCuadroManiobras],
						[fields.otrasAscensoresRuidoMolesto],
						[fields.otrasAscensoresRuidoMolestoTipoLocalizacion],
						//cuartos húmedos
						[fields.otrasCuartosHumedosSaneamiento],
						[fields.otrasCuartosHumedosSaneamientoLanaMineral, fields.otrasCuartosHumedosSaneamientoMaterialElastico, fields.otrasCuartosHumedosSaneamientoConectoresFlexibles, fields.otrasCuartosHumedosSaneamientoTechoSellado],
						[fields.otrasCuartosHumedosAireAcondicionado, fields.otrasCuartosHumedosLuminariasEmpotradas],
						[fields.otrasCuartosHumedosRuidoMolesto],
						[fields.otrasCuartosHumedosRuidoMolestoTipoLocalizacion],
						//puertas de garaje
						[fields.otrasPuertasGarajeAncladas],
						[fields.otrasPuertasGarajeAncladasMotoresAmortiguadores, fields.otrasPuertasGarajeAncladasMarcoAmortiguadores, fields.otrasPuertasGarajeAncladasRuidoPuerta]
						//observaciones
						[fields.observaciones]
					])]
				}]
			},
			At4FrameworkIntranet.FormDefaults.rows([
				[At4FrameworkIntranet.FormDefaults.resumenAuditoria()]
			])
		];



		this.maxTabIndex = tabHelper.getNext();
		this.callParent([application, formName, gridMetaData, items, config]);
	}
});


/*

{
	xtype: 'At4Framework-fieldmainpanel',
	title: "Características y RuiiIntVert",
	items: []
} {
	xtype: 'fieldset',
	border: true,
	title: "Separación",
	items: []
} {
	xtype: "At4Framework-rowContainer",
	minWidth: false,
	items: []
}

width: At4FrameworkIntranet.FormDefaults.size(2, 2, 10),
labelStyle: 'white-space: nowrap',
margin: "0, "+At4FrameworkIntranet.FormDefaults.size(2, 1, 12)+", 0, 11",
margin: "0, 70, 0, 11",
*/
//Namespace de  At4FrameworkIntranet
Ext.namespace('At4FrameworkIntranet');

/**
 * @class At4FrameworkIntranet.AcusticaRuidosExterioresForm
 * Contiene la configuración del formulario: AcusticaRuidosExteriores
 * @author garrom
 * @constructor
 * @extends At4FrameworkIntranet.BasicForm
 * @param {Object} application La aplicación que contiene el formulario, normalmente será {@link At4FrameworkIntranet.app}
 * @param {String} formName Nombre del formulario
 * @param {Object} gridMetaData Configuración gridMetadata
 * @param {Object} config Configuración para Ext.form.FormPanel
 */

Ext.define("At4FrameworkIntranet.AcusticaRuidosExterioresForm", {
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
			width: At4FrameworkIntranet.FormDefaults.size(2, 2, 10),
			border: true,
			application: application,
			relatedIconCls: "",
			relatedForm: 'inspeccion'
		})



		var fachadasLigerasStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'fachadasLigeras') {
				fachadasLigerasStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var fachadasLigerasStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: fachadasLigerasStoreValues
		});

		fields.fachadasLigeras = Ext.create('Ext.form.ComboBox', {
			name: 'fachadasLigeras',
			fieldLabel: this.fachadasLigerasHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2.5, 3, 10),
			store: fachadasLigerasStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var fachadasPesadasStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'fachadasPesadas') {
				fachadasPesadasStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var fachadasPesadasStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: fachadasPesadasStoreValues
		});

		fields.fachadasPesadas = Ext.create('Ext.form.ComboBox', {
			name: 'fachadasPesadas',
			fieldLabel: this.fachadasPesadasHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2.5, 3, 10),
			store: fachadasPesadasStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})
		var cubiertasLigerasStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'cubiertasLigeras') {
				cubiertasLigerasStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var cubiertasLigerasStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: cubiertasLigerasStoreValues
		});

		fields.cubiertasLigeras = Ext.create('Ext.form.ComboBox', {
			name: 'cubiertasLigeras',
			fieldLabel: this.cubiertasLigerasHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2.5, 3, 10),
			store: cubiertasLigerasStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var cubiertasPesadasStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'cubiertasPesadas') {
				cubiertasPesadasStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var cubiertasPesadasStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: cubiertasPesadasStoreValues
		});

		fields.cubiertasPesadas = Ext.create('Ext.form.ComboBox', {
			name: 'cubiertasPesadas',
			fieldLabel: this.cubiertasPesadasHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2.5, 3, 10),
			store: cubiertasPesadasStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var cubiertasLigerasTechoStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'cubiertasLigerasTecho') {
				cubiertasLigerasTechoStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var cubiertasLigerasTechoStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: cubiertasLigerasTechoStoreValues
		});

		fields.cubiertasLigerasTecho = Ext.create('Ext.form.ComboBox', {
			name: 'cubiertasLigerasTecho',
			fieldLabel: this.cubiertasLigerasTechoHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2.5, 3, 10),
			store: cubiertasLigerasTechoStore,
			labelStyle: 'white-space: nowrap',
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		fields.ventanasLocalizacionTiposVentanas = new Ext.form.TextField({
			name: 'ventanasLocalizacionTiposVentanas',
			fieldLabel: this.ventanasLocalizacionTiposVentanasHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.ventanasLocalizacionTiposVentanasDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(10, 0, 10),
			maxLength: 255
		})

		var capialzadosTieneStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'capialzadosTiene') {
				capialzadosTieneStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var capialzadosTieneStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: capialzadosTieneStoreValues
		});

		fields.capialzadosTiene = Ext.create('Ext.form.ComboBox', {
			name: 'capialzadosTiene',
			fieldLabel: this.capialzadosTieneHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.capialzadosTieneDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2.5, 3, 10),
			store: capialzadosTieneStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})
		var capialzadosNoPrefabricadosStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'capialzadosNoPrefabricados') {
				capialzadosNoPrefabricadosStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var capialzadosNoPrefabricadosStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: capialzadosNoPrefabricadosStoreValues
		});

		fields.capialzadosNoPrefabricados = Ext.create('Ext.form.ComboBox', {
			name: 'capialzadosNoPrefabricados',
			fieldLabel: this.capialzadosNoPrefabricadosHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(5, 3, 10),
			store: capialzadosNoPrefabricadosStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var capialzadosAislamientoAcusticoStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'capialzadosAislamientoAcustico') {
				capialzadosAislamientoAcusticoStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var capialzadosAislamientoAcusticoStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: capialzadosAislamientoAcusticoStoreValues
		});

		fields.capialzadosAislamientoAcustico = Ext.create('Ext.form.ComboBox', {
			name: 'capialzadosAislamientoAcustico',
			fieldLabel: this.capialzadosAislamientoAcusticoHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.capialzadosAislamientoAcusticoDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2.5, 3, 10),
			store: capialzadosAislamientoAcusticoStore,
			labelStyle: 'white-space: nowrap',
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var aireadoresTieneStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'aireadoresTiene') {
				aireadoresTieneStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var aireadoresTieneStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: aireadoresTieneStoreValues
		});

		fields.aireadoresTiene = Ext.create('Ext.form.ComboBox', {
			name: 'aireadoresTiene',
			fieldLabel: this.aireadoresTieneHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2.5, 3, 10),
			store: aireadoresTieneStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var aireadoresAsilamientoAcusticoStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'aireadoresAsilamientoAcustico') {
				aireadoresAsilamientoAcusticoStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var aireadoresAsilamientoAcusticoStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: aireadoresAsilamientoAcusticoStoreValues
		});

		fields.aireadoresAsilamientoAcustico = Ext.create('Ext.form.ComboBox', {
			name: 'aireadoresAsilamientoAcustico',
			fieldLabel: this.aireadoresAsilamientoAcusticoHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.aireadoresAsilamientoAcusticoDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(5, 3, 10),
			store: aireadoresAsilamientoAcusticoStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var ruidoMolestoExteriorStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'ruidoMolestoExterior') {
				ruidoMolestoExteriorStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var ruidoMolestoExteriorStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: ruidoMolestoExteriorStoreValues
		});

		fields.ruidoMolestoExterior = Ext.create('Ext.form.ComboBox', {
			name: 'ruidoMolestoExterior',
			fieldLabel: this.ruidoMolestoExteriorHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2.5, 3, 10),
			store: ruidoMolestoExteriorStore,
			queryMode: 'local',
			labelStyle: 'white-space: nowrap',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})
		var estadoFachadasBuenoStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'estadoFachadasBueno') {
				estadoFachadasBuenoStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var estadoFachadasBuenoStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: estadoFachadasBuenoStoreValues
		});

		fields.estadoFachadasBueno = Ext.create('Ext.form.ComboBox', {
			name: 'estadoFachadasBueno',
			fieldLabel: this.estadoFachadasBuenoHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2.5, 3, 10),
			store: estadoFachadasBuenoStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})
		var estadoCubiertasBuenoStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'estadoCubiertasBueno') {
				estadoCubiertasBuenoStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var estadoCubiertasBuenoStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: estadoCubiertasBuenoStoreValues
		});

		fields.estadoCubiertasBueno = Ext.create('Ext.form.ComboBox', {
			name: 'estadoCubiertasBueno',
			fieldLabel: this.estadoCubiertasBuenoHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2.5, 3, 10),
			store: estadoCubiertasBuenoStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var estadoVentanasBuenoStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'estadoVentanasBueno') {
				estadoVentanasBuenoStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var estadoVentanasBuenoStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: estadoVentanasBuenoStoreValues
		});

		fields.estadoVentanasBueno = Ext.create('Ext.form.ComboBox', {
			name: 'estadoVentanasBueno',
			fieldLabel: this.estadoVentanasBuenoHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2.5, 3, 10),
			store: estadoVentanasBuenoStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var estadoCapialzadosBuenoStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'estadoCapialzadosBueno') {
				estadoCapialzadosBuenoStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var estadoCapialzadosBuenoStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: estadoCapialzadosBuenoStoreValues
		});

		fields.estadoCapialzadosBueno = Ext.create('Ext.form.ComboBox', {
			name: 'estadoCapialzadosBueno',
			fieldLabel: this.estadoCapialzadosBuenoHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2.5, 3, 10),
			store: estadoCapialzadosBuenoStore,
			queryMode: 'local',
			valueField: 'ID',
			labelStyle: 'white-space: nowrap',
			displayField: 'DISPLAY',
		})


		fields.deficienciasObservaciones = new Ext.form.TextArea({
			name: 'deficienciasObservaciones',
			fieldLabel: this.deficienciasObservacionesHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(10, 0, 10),
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
					[fields.fachadasLigeras, fields.fachadasPesadas],
					[fields.cubiertasLigeras, fields.cubiertasPesadas, fields.cubiertasLigerasTecho],
					[fields.ventanasLocalizacionTiposVentanas],
					[fields.capialzadosTiene, fields.capialzadosNoPrefabricados, fields.capialzadosAislamientoAcustico],
					[fields.aireadoresTiene, fields.aireadoresAsilamientoAcustico],
					[fields.ruidoMolestoExterior],
					[fields.estadoFachadasBueno, fields.estadoCubiertasBueno, fields.estadoVentanasBueno, fields.estadoCapialzadosBueno],
					[fields.deficienciasObservaciones],
					[fields.observaciones],
					[At4FrameworkIntranet.FormDefaults.resumenAuditoria()]
				])
			]
		}];
		this.maxTabIndex = tabHelper.getNext();
		this.callParent([application, formName, gridMetaData, items, config]);
	}
});
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
//Namespace de  At4FrameworkIntranet
Ext.namespace('At4FrameworkIntranet');

/**
 * @class At4FrameworkIntranet.AcusticaRuidosInterioresUnionesForm
 * Contiene la configuración del formulario: AcusticaRuidosInterioresUniones
 * @author garrom
 * @constructor
 * @extends At4FrameworkIntranet.BasicForm
 * @param {Object} application La aplicación que contiene el formulario, normalmente será {@link At4FrameworkIntranet.app}
 * @param {String} formName Nombre del formulario
 * @param {Object} gridMetaData Configuración gridMetadata
 * @param {Object} config Configuración para Ext.form.FormPanel
 */

Ext.define("At4FrameworkIntranet.AcusticaRuidosInterioresUnionesForm", {
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

		var materialAislanteElasticoStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'materialAislanteElastico') {
				materialAislanteElasticoStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var materialAislanteElasticoStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: materialAislanteElasticoStoreValues
		});

		fields.materialAislanteElastico = Ext.create('Ext.form.ComboBox', {
			name: 'materialAislanteElastico',
			fieldLabel: this.materialAislanteElasticoHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 1, 6),
			store: materialAislanteElasticoStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var hojaInteriorFachadaContinuaStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'hojaInteriorFachadaContinua') {
				hojaInteriorFachadaContinuaStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var hojaInteriorFachadaContinuaStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: hojaInteriorFachadaContinuaStoreValues
		});

		fields.hojaInteriorFachadaContinua = Ext.create('Ext.form.ComboBox', {
			name: 'hojaInteriorFachadaContinua',
			fieldLabel: this.hojaInteriorFachadaContinuaHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 2, 6),
			store: hojaInteriorFachadaContinuaStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var elementoSeparacionVerticalForjadoTechoSuspendidoStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'elementoSeparacionVerticalForjadoTechoSuspendido') {
				elementoSeparacionVerticalForjadoTechoSuspendidoStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var elementoSeparacionVerticalForjadoTechoSuspendidoStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: elementoSeparacionVerticalForjadoTechoSuspendidoStoreValues
		});

		fields.elementoSeparacionVerticalForjadoTechoSuspendido = Ext.create('Ext.form.ComboBox', {
			name: 'elementoSeparacionVerticalForjadoTechoSuspendido',
			fieldLabel: this.elementoSeparacionVerticalForjadoTechoSuspendidoHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.elementoSeparacionVerticalForjadoTechoSuspendidoDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2.5, 3, 10),
			store: elementoSeparacionVerticalForjadoTechoSuspendidoStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var elementoSeparacionVerticalForjadoSueloFlotanteStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'elementoSeparacionVerticalForjadoSueloFlotante') {
				elementoSeparacionVerticalForjadoSueloFlotanteStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var elementoSeparacionVerticalForjadoSueloFlotanteStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: elementoSeparacionVerticalForjadoSueloFlotanteStoreValues
		});

		fields.elementoSeparacionVerticalForjadoSueloFlotante = Ext.create('Ext.form.ComboBox', {
			name: 'elementoSeparacionVerticalForjadoSueloFlotante',
			fieldLabel: this.elementoSeparacionVerticalForjadoSueloFlotanteHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.elementoSeparacionVerticalForjadoSueloFlotanteDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2.5, 3, 10),
			store: elementoSeparacionVerticalForjadoSueloFlotanteStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var elementoSeparacionVerticalForjadoMorteroStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'elementoSeparacionVerticalForjadoMortero') {
				elementoSeparacionVerticalForjadoMorteroStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var elementoSeparacionVerticalForjadoMorteroStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: elementoSeparacionVerticalForjadoMorteroStoreValues
		});

		fields.elementoSeparacionVerticalForjadoMortero = Ext.create('Ext.form.ComboBox', {
			name: 'elementoSeparacionVerticalForjadoMortero',
			fieldLabel: this.elementoSeparacionVerticalForjadoMorteroHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.elementoSeparacionVerticalForjadoMorteroDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2.5, 3, 10),
			store: elementoSeparacionVerticalForjadoMorteroStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})
		var elementoSeparacionVerticalForjadoConexionRigidaStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'elementoSeparacionVerticalForjadoConexionRigida') {
				elementoSeparacionVerticalForjadoConexionRigidaStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var elementoSeparacionVerticalForjadoConexionRigidaStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: elementoSeparacionVerticalForjadoConexionRigidaStoreValues
		});

		fields.elementoSeparacionVerticalForjadoConexionRigida = Ext.create('Ext.form.ComboBox', {
			name: 'elementoSeparacionVerticalForjadoConexionRigida',
			fieldLabel: this.elementoSeparacionVerticalForjadoConexionRigidaHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.elementoSeparacionVerticalForjadoConexionRigidaDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2.5, 3, 10),
			store: elementoSeparacionVerticalForjadoConexionRigidaStore,
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
					[fields.materialAislanteElastico, fields.hojaInteriorFachadaContinua],
					[{
						xtype: 'fieldset',
						border: true,
						title: this.elementosSeparacionVerticalTitleLabel,
						items: [{
							xtype: "At4Framework-rowContainer",
							minWidth: false,
							items: [fields.elementoSeparacionVerticalForjadoTechoSuspendido, fields.elementoSeparacionVerticalForjadoSueloFlotante, fields.elementoSeparacionVerticalForjadoMortero ,fields.elementoSeparacionVerticalForjadoConexionRigida]
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
//Namespace de  At4FrameworkIntranet
Ext.namespace('At4FrameworkIntranet');

/**
 * @class At4FrameworkIntranet.AcusticaRuidosInterioresVerticalesForm
 * Contiene la configuración del formulario: AcusticaRuidosInterioresVerticales
 * @author garrom
 * @constructor
 * @extends At4FrameworkIntranet.BasicForm
 * @param {Object} application La aplicación que contiene el formulario, normalmente será {@link At4FrameworkIntranet.app}
 * @param {String} formName Nombre del formulario
 * @param {Object} gridMetaData Configuración gridMetadata
 * @param {Object} config Configuración para Ext.form.FormPanel
 */

Ext.define("At4FrameworkIntranet.AcusticaRuidosInterioresVerticalesForm", {
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
			width: At4FrameworkIntranet.FormDefaults.size(6, 3, 10),
			relatedIconCls: "glyphicons glyphicons-building",
			relatedForm: 'edificio'
		})

		/*fields.inspeccion = new At4FrameworkIntranet.ComboBox({
		    name: 'inspeccionId',
		    fieldLabel: this.inspeccionHeaderLabel,
		    tabIndex: tabHelper.getNext(),
		    width: At4FrameworkIntranet.FormDefaults.size(4, 3, 15),
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



		//-------------------------
		//--------Elementos de separacion entre viviendas (ESV)------

		var separacionFabricaStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'separacionFabrica') {
				separacionFabricaStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var separacionFabricaStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: separacionFabricaStoreValues
		});

		fields.separacionFabrica = Ext.create('Ext.form.ComboBox', {
			name: 'separacionFabrica',
			fieldLabel: this.separacionFabricaHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 1, 10),
			store: separacionFabricaStore,
			queryMode: 'local',
			labelStyle: 'white-space: nowrap',
			margin: "0, "+At4FrameworkIntranet.FormDefaults.size(2, 1, 12)+", 0, 11",
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var separacionFabricaRevestidoStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'separacionFabricaRevestido') {
				separacionFabricaRevestidoStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var separacionFabricaRevestidoStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: separacionFabricaRevestidoStoreValues
		});

		fields.separacionFabricaRevestido = Ext.create('Ext.form.ComboBox', {
			name: 'separacionFabricaRevestido',
			fieldLabel: this.separacionFabricaRevestidoHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 1, 10),
			store: separacionFabricaRevestidoStore,
			queryMode: 'local',
			labelStyle: 'white-space: nowrap',
			//margin: "0, 70, 0, 20",
			valueField: 'ID',
			displayField: 'DISPLAY',
		})
		fields.ruiiIntVertSepTipoTex = new Ext.form.TextField({
			name: 'ruiiIntVertSepTipoTex',
			fieldLabel: this.ruiiIntVertSepTipoTexHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.ruiiIntVertSepTipoTexDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(10, 0, 10),
			maxLength: 255
		})
		var separacionEntramadoAutoportanteStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'separacionEntramadoAutoportante') {
				separacionEntramadoAutoportanteStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var separacionEntramadoAutoportanteStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: separacionEntramadoAutoportanteStoreValues
		});

		fields.separacionEntramadoAutoportante = Ext.create('Ext.form.ComboBox', {
			name: 'separacionEntramadoAutoportante',
			fieldLabel: this.separacionEntramadoAutoportanteHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.separacionEntramadoAutoportanteDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 1, 10),
			store: separacionEntramadoAutoportanteStore,
			queryMode: 'local',
			valueField: 'ID',
			labelStyle: 'white-space: nowrap',
			margin: "0, "+At4FrameworkIntranet.FormDefaults.size(2, 1, 12)+", 0, 11",
			displayField: 'DISPLAY',
		})

		var separacionEntramadoAutoportanteUnahojaStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'separacionEntramadoAutoportanteUnahoja') {
				separacionEntramadoAutoportanteUnahojaStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var separacionEntramadoAutoportanteUnahojaStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: separacionEntramadoAutoportanteUnahojaStoreValues
		});

		fields.separacionEntramadoAutoportanteUnahoja = Ext.create('Ext.form.ComboBox', {
			name: 'separacionEntramadoAutoportanteUnahoja',
			fieldLabel: this.separacionEntramadoAutoportanteUnahojaHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.separacionEntramadoAutoportanteUnahojaDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 1, 10),
			store: separacionEntramadoAutoportanteUnahojaStore,
			queryMode: 'local',
			valueField: 'ID',
			labelStyle: 'white-space: nowrap',
			margin: "0, "+At4FrameworkIntranet.FormDefaults.size(2, 1, 12)+", 0, 11",
			displayField: 'DISPLAY',
		})
		var separacionEntramadoAutoportanteDoshojasStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'separacionEntramadoAutoportanteDoshojas') {
				separacionEntramadoAutoportanteDoshojasStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var separacionEntramadoAutoportanteDoshojasStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: separacionEntramadoAutoportanteDoshojasStoreValues
		});

		fields.separacionEntramadoAutoportanteDoshojas = Ext.create('Ext.form.ComboBox', {
			name: 'separacionEntramadoAutoportanteDoshojas',
			fieldLabel: this.separacionEntramadoAutoportanteDoshojasHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.separacionEntramadoAutoportanteDoshojasDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 1, 10),
			store: separacionEntramadoAutoportanteDoshojasStore,
			queryMode: 'local',
			labelStyle: 'white-space: nowrap',
			margin: "0, "+At4FrameworkIntranet.FormDefaults.size(1, 1, 12)+", 0, 11",
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		fields.separacionEntramadoAutoportanteUnahojaEspesor = new Ext.form.TextField({
			name: 'separacionEntramadoAutoportanteUnahojaEspesor',
			fieldLabel: this.separacionEntramadoAutoportanteUnahojaEspesorHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.separacionEntramadoAutoportanteUnahojaEspesorDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(4, 3, 13),
			maxLength: 255
		})


		fields.separacionEntramadoAutoportanteDoshojasEspesor = new Ext.form.TextField({
			name: 'separacionEntramadoAutoportanteDoshojasEspesor',
			fieldLabel: this.separacionEntramadoAutoportanteDoshojasEspesorHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.separacionEntramadoAutoportanteDoshojasEspesorDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(4, 2, 15),
			maxLength: 255
		})
		var separacionEntramadoAutoportanteAbsorbenteStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'separacionEntramadoAutoportanteAbsorbente') {
				separacionEntramadoAutoportanteAbsorbenteStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var separacionEntramadoAutoportanteAbsorbenteStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: separacionEntramadoAutoportanteAbsorbenteStoreValues
		});

		fields.separacionEntramadoAutoportanteAbsorbente = Ext.create('Ext.form.ComboBox', {
			name: 'separacionEntramadoAutoportanteAbsorbente',
			fieldLabel: this.separacionEntramadoAutoportanteAbsorbenteHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.separacionEntramadoAutoportanteAbsorbenteDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 1, 10),
			store: separacionEntramadoAutoportanteAbsorbenteStore,
			labelStyle: 'white-space: nowrap',
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})
		var separacionEntramadoMaderaStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'separacionEntramadoMadera') {
				separacionEntramadoMaderaStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var separacionEntramadoMaderaStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: separacionEntramadoMaderaStoreValues
		});

		fields.separacionEntramadoMadera = Ext.create('Ext.form.ComboBox', {
			name: 'separacionEntramadoMadera',
			fieldLabel: this.separacionEntramadoMaderaHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 1, 10),
			store: separacionEntramadoMaderaStore,
			labelStyle: 'white-space: nowrap',
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})
		fields.separacionEntramadoMaderaEspesor = new Ext.form.NumberField({
			name: 'separacionEntramadoMaderaEspesor',
			fieldLabel: this.separacionEntramadoMaderaEspesorHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.separacionEntramadoMaderaEspesorDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 1, 10),
			labelStyle: 'white-space: nowrap',
			allowDecimals: false,
			maxValue: 2147483647
		})
		var separacionEntramadoMaderaRevestidoStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'separacionEntramadoMaderaRevestido') {
				separacionEntramadoMaderaRevestidoStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var separacionEntramadoMaderaRevestidoStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: separacionEntramadoMaderaRevestidoStoreValues
		});

		fields.separacionEntramadoMaderaRevestido = Ext.create('Ext.form.ComboBox', {
			name: 'separacionEntramadoMaderaRevestido',
			fieldLabel: this.separacionEntramadoMaderaRevestidoHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.separacionEntramadoMaderaRevestidoDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 1, 10),
			labelStyle: 'white-space: nowrap',
			store: separacionEntramadoMaderaRevestidoStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})
		var separacionOtrosStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'separacionOtros') {
				separacionOtrosStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var separacionOtrosStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: separacionOtrosStoreValues
		});

		fields.separacionOtros = Ext.create('Ext.form.ComboBox', {
			name: 'separacionOtros',
			fieldLabel: this.separacionOtrosHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 1, 10),
			store: separacionOtrosStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		fields.separacionOtrosTexto = new Ext.form.TextField({
			name: 'separacionOtrosTexto',
			fieldLabel: this.separacionOtrosTextoHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(10, 0 , 10),
			maxLength: 255
		})

		//-------------------------
		//--------Conservación, deficiencias y caracteristicas adicionales------

		var estadoSeparacionBuenoStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'estadoSeparacionBueno') {
				estadoSeparacionBuenoStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var estadoSeparacionBuenoStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: estadoSeparacionBuenoStoreValues
		});

		fields.estadoSeparacionBueno = Ext.create('Ext.form.ComboBox', {
			name: 'estadoSeparacionBueno',
			fieldLabel: this.estadoSeparacionBuenoHeaderLabel,
			tabIndex: tabHelper.getNext(),
			store: estadoSeparacionBuenoStore,
			width: At4FrameworkIntranet.FormDefaults.size(2, 1, 12),
			labelStyle: 'white-space: nowrap',
			margin: "0, "+At4FrameworkIntranet.FormDefaults.size(2, 1, 12)+", 0, 11",
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var caracteristicasPilaresConectanRecintosStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'caracteristicasPilaresConectanRecintos') {
				caracteristicasPilaresConectanRecintosStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var caracteristicasPilaresConectanRecintosStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: caracteristicasPilaresConectanRecintosStoreValues
		});

		fields.caracteristicasPilaresConectanRecintos = Ext.create('Ext.form.ComboBox', {
			name: 'caracteristicasPilaresConectanRecintos',
			fieldLabel: this.caracteristicasPilaresConectanRecintosHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.caracteristicasPilaresConectanRecintosDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 1, 12),
			labelStyle: 'white-space: nowrap',
			margin: "0, "+At4FrameworkIntranet.FormDefaults.size(4, 1, 12)+", 0, 11",
			store: caracteristicasPilaresConectanRecintosStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var caracteristicasPilaresConectanRecintosRevestidosStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'caracteristicasPilaresConectanRecintosRevestidos') {
				caracteristicasPilaresConectanRecintosRevestidosStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var caracteristicasPilaresConectanRecintosRevestidosStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: caracteristicasPilaresConectanRecintosRevestidosStoreValues
		});

		fields.caracteristicasPilaresConectanRecintosRevestidos = Ext.create('Ext.form.ComboBox', {
			name: 'caracteristicasPilaresConectanRecintosRevestidos',
			fieldLabel: this.caracteristicasPilaresConectanRecintosRevestidosHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.caracteristicasPilaresConectanRecintosRevestidosDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 1, 12),
			labelStyle: 'white-space: nowrap',
			margin: "0, "+At4FrameworkIntranet.FormDefaults.size(2, 1, 12)+", 0, 11",
			store: caracteristicasPilaresConectanRecintosRevestidosStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var caracteristicasInstalacionesConectanRecintosStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'caracteristicasInstalacionesConectanRecintos') {
				caracteristicasInstalacionesConectanRecintosStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var caracteristicasInstalacionesConectanRecintosStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: caracteristicasInstalacionesConectanRecintosStoreValues
		});

		fields.caracteristicasInstalacionesConectanRecintos = Ext.create('Ext.form.ComboBox', {
			name: 'caracteristicasInstalacionesConectanRecintos',
			fieldLabel: this.caracteristicasInstalacionesConectanRecintosHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.caracteristicasInstalacionesConectanRecintosDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 1, 12),
			labelStyle: 'white-space: nowrap',
			margin: "0, "+At4FrameworkIntranet.FormDefaults.size(4, 1, 12)+", 0, 11",
			store: caracteristicasInstalacionesConectanRecintosStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var caracteristicasInstalacionesAtraviesanRecintosStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'caracteristicasInstalacionesAtraviesanRecintos') {
				caracteristicasInstalacionesAtraviesanRecintosStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var caracteristicasInstalacionesAtraviesanRecintosStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: caracteristicasInstalacionesAtraviesanRecintosStoreValues
		});

		fields.caracteristicasInstalacionesAtraviesanRecintos = Ext.create('Ext.form.ComboBox', {
			name: 'caracteristicasInstalacionesAtraviesanRecintos',
			fieldLabel: this.caracteristicasInstalacionesAtraviesanRecintosHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.caracteristicasInstalacionesAtraviesanRecintosDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 1, 12),
			labelStyle: 'white-space: nowrap',
			margin: "0, "+At4FrameworkIntranet.FormDefaults.size(2, 1, 12)+", 0, 11",
			store: caracteristicasInstalacionesAtraviesanRecintosStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})
		var caracteristicasHuecosAdosadosStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'caracteristicasHuecosAdosados') {
				caracteristicasHuecosAdosadosStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var caracteristicasHuecosAdosadosStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: caracteristicasHuecosAdosadosStoreValues
		});

		fields.caracteristicasHuecosAdosados = Ext.create('Ext.form.ComboBox', {
			name: 'caracteristicasHuecosAdosados',
			fieldLabel: this.caracteristicasHuecosAdosadosHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.caracteristicasHuecosAdosadosDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 1, 12),
			labelStyle: 'white-space: nowrap',
			margin: "0, "+At4FrameworkIntranet.FormDefaults.size(4, 1, 12)+", 0, 11",
			store: caracteristicasHuecosAdosadosStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})
		var caracteristicasHuecosAdosadosRuidoMolestoStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'caracteristicasHuecosAdosadosRuidoMolesto') {
				caracteristicasHuecosAdosadosRuidoMolestoStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var caracteristicasHuecosAdosadosRuidoMolestoStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: caracteristicasHuecosAdosadosRuidoMolestoStoreValues
		});

		fields.caracteristicasHuecosAdosadosRuidoMolesto = Ext.create('Ext.form.ComboBox', {
			name: 'caracteristicasHuecosAdosadosRuidoMolesto',
			fieldLabel: this.caracteristicasHuecosAdosadosRuidoMolestoHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.caracteristicasHuecosAdosadosRuidoMolestoDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 1, 12),
			labelStyle: 'white-space: nowrap',
			margin: "0, "+At4FrameworkIntranet.FormDefaults.size(4, 1, 12)+", 0, 11",
			store: caracteristicasHuecosAdosadosRuidoMolestoStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})
		var caracteristicasHuecosAdosadosRevestidosStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'caracteristicasHuecosAdosadosRevestidos') {
				caracteristicasHuecosAdosadosRevestidosStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var caracteristicasHuecosAdosadosRevestidosStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: caracteristicasHuecosAdosadosRevestidosStoreValues
		});

		fields.caracteristicasHuecosAdosadosRevestidos = Ext.create('Ext.form.ComboBox', {
			name: 'caracteristicasHuecosAdosadosRevestidos',
			fieldLabel: this.caracteristicasHuecosAdosadosRevestidosHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.caracteristicasHuecosAdosadosRevestidosDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 1, 12),
			labelStyle: 'white-space: nowrap',
			margin: "0, "+At4FrameworkIntranet.FormDefaults.size(2, 1, 12)+", 0, 11",
			store: caracteristicasHuecosAdosadosRevestidosStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})
		var caracteristicasTuberiasAncladasStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'caracteristicasTuberiasAncladas') {
				caracteristicasTuberiasAncladasStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var caracteristicasTuberiasAncladasStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: caracteristicasTuberiasAncladasStoreValues
		});

		fields.caracteristicasTuberiasAncladas = Ext.create('Ext.form.ComboBox', {
			name: 'caracteristicasTuberiasAncladas',
			fieldLabel: this.caracteristicasTuberiasAncladasHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.caracteristicasTuberiasAncladasDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 1, 12),
			labelStyle: 'white-space: nowrap',
			margin: "0, "+At4FrameworkIntranet.FormDefaults.size(4, 1, 12)+", 0, 11",
			store: caracteristicasTuberiasAncladasStore,
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

		var tabiquesFabricaStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'tabiquesFabrica') {
				tabiquesFabricaStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var tabiquesFabricaStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: tabiquesFabricaStoreValues
		});

		fields.tabiquesFabrica = Ext.create('Ext.form.ComboBox', {
			name: 'tabiquesFabrica',
			fieldLabel: this.tabiquesFabricaHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 1, 12),
			labelStyle: 'white-space: nowrap',
			margin: "0, "+At4FrameworkIntranet.FormDefaults.size(4, 1, 12)+", 0, 11",
			store: tabiquesFabricaStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})
		fields.ruiIntVertTabTipoTex = new Ext.form.TextField({
			name: 'ruiIntVertTabTipoTex',
			fieldLabel: this.ruiIntVertTabTipoTexHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.ruiIntVertTabTipoTexDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(10, 0, 10),
			maxLength: 255
		})
		var tabiquesEntramadoAutoportanteMetalicoStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'tabiquesEntramadoAutoportanteMetalico') {
				tabiquesEntramadoAutoportanteMetalicoStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var tabiquesEntramadoAutoportanteMetalicoStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: tabiquesEntramadoAutoportanteMetalicoStoreValues
		});

		fields.tabiquesEntramadoAutoportanteMetalico = Ext.create('Ext.form.ComboBox', {
			name: 'tabiquesEntramadoAutoportanteMetalico',
			fieldLabel: this.tabiquesEntramadoAutoportanteMetalicoHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.tabiquesEntramadoAutoportanteMetalicoDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 1, 12),
			labelStyle: 'white-space: nowrap',
			margin: "0, "+At4FrameworkIntranet.FormDefaults.size(4, 1, 12)+", 0, 11",
			store: tabiquesEntramadoAutoportanteMetalicoStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})









		var tabiquesEntramadoMaderaRellenoStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'tabiquesEntramadoMaderaRelleno') {
				tabiquesEntramadoMaderaRellenoStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var tabiquesEntramadoMaderaRellenoStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: tabiquesEntramadoMaderaRellenoStoreValues
		});

		fields.tabiquesEntramadoMaderaRelleno = Ext.create('Ext.form.ComboBox', {
			name: 'tabiquesEntramadoMaderaRelleno',
			fieldLabel: this.tabiquesEntramadoMaderaRellenoHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.tabiquesEntramadoMaderaRellenoDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 1, 12),
			labelStyle: 'white-space: nowrap',
			margin: "0, "+At4FrameworkIntranet.FormDefaults.size(4, 1, 12)+", 0, 11",
			store: tabiquesEntramadoMaderaRellenoStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		fields.tabiquesEntramadoAutoportanteMetalicoEspesor = new Ext.form.TextField({
			name: 'tabiquesEntramadoAutoportanteMetalicoEspesor',
			fieldLabel: this.tabiquesEntramadoAutoportanteMetalicoEspesorHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.tabiquesEntramadoAutoportanteMetalicoEspesorDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(5, 1, 10),
			maxLength: 255
		})

		fields.tabiquesEntramadoMaderaRellenoEspesor = new Ext.form.TextField({
			name: 'tabiquesEntramadoMaderaRellenoEspesor',
			fieldLabel: this.tabiquesEntramadoMaderaRellenoEspesorHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.tabiquesEntramadoMaderaRellenoEspesorDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(5, 1, 10),
			maxLength: 255
		})
		var zonaComunPuertasAcusticamenteFavorablesStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'zonaComunPuertasAcusticamenteFavorables') {
				zonaComunPuertasAcusticamenteFavorablesStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var zonaComunPuertasAcusticamenteFavorablesStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: zonaComunPuertasAcusticamenteFavorablesStoreValues
		});

		fields.zonaComunPuertasAcusticamenteFavorables = Ext.create('Ext.form.ComboBox', {
			name: 'zonaComunPuertasAcusticamenteFavorables',
			fieldLabel: this.zonaComunPuertasAcusticamenteFavorablesHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.zonaComunPuertasAcusticamenteFavorablesDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 1, 12),
			labelStyle: 'white-space: nowrap',
			margin: "0, "+At4FrameworkIntranet.FormDefaults.size(4, 1, 12)+", 0, 11",
			store: zonaComunPuertasAcusticamenteFavorablesStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})
		var zonaComunHallPuertaStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'zonaComunHallPuerta') {
				zonaComunHallPuertaStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var zonaComunHallPuertaStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: zonaComunHallPuertaStoreValues
		});

		fields.zonaComunHallPuerta = Ext.create('Ext.form.ComboBox', {
			name: 'zonaComunHallPuerta',
			fieldLabel: this.zonaComunHallPuertaHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 1, 12),
			labelStyle: 'white-space: nowrap',
			margin: "0, "+At4FrameworkIntranet.FormDefaults.size(4, 1, 12)+", 0, 11",
			store: zonaComunHallPuertaStore,
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
		var items = [
			At4FrameworkIntranet.FormDefaults.rows([
				[fields.claveInforme, fields.edificio, fields.inspeccionId]
			]), {
				xtype: 'At4Framework-formtabpanel',
				id: 'panelTabs-' + this.id,
				items: [{
					xtype: 'At4Framework-fieldmainpanel',
					title: this.elementosDeSeparacionEntreViviendasTitleLabel,
					items: [
						At4FrameworkIntranet.FormDefaults.rows([
							[fields.separacionFabrica, fields.separacionFabricaRevestido],
							[fields.ruiiIntVertSepTipoTex],
							[fields.separacionEntramadoAutoportante],
							[fields.separacionEntramadoAutoportanteUnahoja, fields.separacionEntramadoAutoportanteDoshojas],
							[fields.separacionEntramadoAutoportanteUnahojaEspesor, fields.separacionEntramadoAutoportanteDoshojasEspesor],
							[fields.separacionEntramadoAutoportanteAbsorbente],
							[fields.separacionEntramadoMadera],
							[fields.separacionEntramadoMaderaEspesor],
							[fields.separacionEntramadoMaderaRevestido],
							[fields.separacionOtros],
							[fields.separacionOtrosTexto]
						])

					]
				}, {
					xtype: 'At4Framework-fieldmainpanel',
					title: this.conservacionDeficienciasCaracteristicasAdicionalesTitleLabel,
					items: [
						At4FrameworkIntranet.FormDefaults.rows([
							[fields.estadoSeparacionBueno],
							[{
								xtype: 'fieldset',
								border: true,
								title: this.caracteristicasAdicionalesTitleLabel,
								items: [{
									xtype: "At4Framework-rowContainer",
									minWidth: false,
									items: [fields.caracteristicasPilaresConectanRecintos, fields.caracteristicasPilaresConectanRecintosRevestidos]
								}, {
									xtype: "At4Framework-rowContainer",
									minWidth: false,
									items: [fields.caracteristicasInstalacionesConectanRecintos, fields.caracteristicasInstalacionesAtraviesanRecintos]
								}, {
									xtype: "At4Framework-rowContainer",
									minWidth: false,
									items: [fields.caracteristicasHuecosAdosados]
								}, {
									xtype: "At4Framework-rowContainer",
									minWidth: false,
									items: [fields.caracteristicasHuecosAdosadosRuidoMolesto, fields.caracteristicasHuecosAdosadosRevestidos]
								}, {
									xtype: "At4Framework-rowContainer",
									minWidth: false,
									items: [fields.caracteristicasTuberiasAncladas]
								}]
							}],
							[fields.deficienciasObservaciones]
						])
					]
				}, {
					xtype: 'At4Framework-fieldmainpanel',
					title: this.tabiquesZonasComunesObservacionesTitleLabel,
					items: [
						At4FrameworkIntranet.FormDefaults.rows([
							[fields.tabiquesFabrica],
							[fields.ruiIntVertTabTipoTex],
							[fields.tabiquesEntramadoAutoportanteMetalico, fields.tabiquesEntramadoMaderaRelleno],
							[fields.tabiquesEntramadoAutoportanteMetalicoEspesor, fields.tabiquesEntramadoMaderaRellenoEspesor],


							[fields.zonaComunPuertasAcusticamenteFavorables, fields.zonaComunHallPuerta],
							[fields.observaciones]
						])
					]
				}]
			},
			At4FrameworkIntranet.FormDefaults.rows([
				[At4FrameworkIntranet.FormDefaults.resumenAuditoria()]
			])
		];


		this.maxTabIndex = tabHelper.getNext();
		this.callParent([application, formName, gridMetaData, items, config]);
	}
});
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
//Namespace de  At4FrameworkIntranet
Ext.namespace('At4FrameworkIntranet');

/**
 * @class At4FrameworkIntranet.CerramientosCubiertasForm
 * Contiene la configuración del formulario: CerramientosCubiertas
 * @author garrom
 * @constructor
 * @extends At4FrameworkIntranet.BasicForm
 * @param {Object} application La aplicación que contiene el formulario, normalmente será {@link At4FrameworkIntranet.app}
 * @param {String} formName Nombre del formulario
 * @param {Object} gridMetaData Configuración gridMetadata
 * @param {Object} config Configuración para Ext.form.FormPanel
 */

Ext.define("At4FrameworkIntranet.CerramientosCubiertasForm", {
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
			width: At4FrameworkIntranet.FormDefaults.size(3, 3, 15),
			border: true,
			application: application,
			relatedIconCls: "",
			relatedForm: 'inspeccion'
		})

		fields.fachadaPrincipalSuperficie = new Ext.form.TextField({
			name: 'fachadaPrincipalSuperficie',
			fieldLabel: this.fachadaPrincipalSuperficieHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 3, 12),
			maxLength: 255
		})

		fields.fachadaPrincipalPorcentaje = new Ext.form.TextField({
			name: 'fachadaPrincipalPorcentaje',
			fieldLabel: this.fachadaPrincipalPorcentajeHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 3, 12),
			maxLength: 255
		})

		var fachadaPrincipalCamaAireStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'fachadaprincipalCamaraaireTipoId') {
				fachadaPrincipalCamaAireStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var fachadaPrincipalCamaAireStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: fachadaPrincipalCamaAireStoreValues
		});

		fields.fachadaprincipalCamaraaireTipoId = Ext.create('Ext.form.ComboBox', {
			name: 'fachadaprincipalCamaraaireTipoId',
			fieldLabel: this.fachadaprincipalCamaraaireTipoIdHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.fachadaprincipalCamaraaireTipoIdDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 3, 12),
			store: fachadaPrincipalCamaAireStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var fachadaPrincipalAislamientoTermicoStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'fachadaprincipalAislamientotermicoTipoId') {
				fachadaPrincipalAislamientoTermicoStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var fachadaPrincipalAislamientoTermicoStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: fachadaPrincipalAislamientoTermicoStoreValues
		});

		fields.fachadaprincipalAislamientotermicoTipoId = Ext.create('Ext.form.ComboBox', {
			name: 'fachadaprincipalAislamientotermicoTipoId',
			fieldLabel: this.fachadaprincipalAislamientotermicoTipoIdHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.fachadaprincipalAislamientotermicoTipoIdDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 3, 12),
			store: fachadaPrincipalAislamientoTermicoStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})
		fields.fachadaprincipalAcabadovistoPorcentaje = new Ext.form.TextField({
			name: 'fachadaprincipalAcabadovistoPorcentaje',
			fieldLabel: this.fachadaprincipalAcabadovistoPorcentajeHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.fachadaprincipalAcabadovistoPorcentajeDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 3, 12),
			maxLength: 255
		})
		fields.fachadaprincipalAcabadorevestidoPorcentaje = new Ext.form.TextField({
			name: 'fachadaprincipalAcabadorevestidoPorcentaje',
			fieldLabel: this.fachadaprincipalAcabadorevestidoPorcentajeHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.fachadaprincipalAcabadorevestidoPorcentajeDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			labelStyle: 'white-space: nowrap',
			width: At4FrameworkIntranet.FormDefaults.size(3, 3, 12),
			maxLength: 255
		})
		fields.fachadaprincipalAcabadovistoTexto = new Ext.form.TextField({
			name: 'fachadaprincipalAcabadovistoTexto',
			fieldLabel: this.fachadaprincipalAcabadovistoTextoHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.fachadaprincipalAcabadovistoTextoDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(5, 3, 12),
			maxLength: 255
		})
		fields.fachadaprincipalAcabadorevestidoTexto = new Ext.form.TextField({
			name: 'fachadaprincipalAcabadorevestidoTexto',
			fieldLabel: this.fachadaprincipalAcabadorevestidoTextoHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.fachadaprincipalAcabadorevestidoTextoDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(5, 3, 12),
			maxLength: 255
		})
		fields.otrasFachadasSuperficie = new Ext.form.TextField({
			name: 'otrasFachadasSuperficie',
			fieldLabel: this.otrasFachadasSuperficieHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 3, 12),
			maxLength: 255
		})
		fields.otrasFachadasPorcentaje = new Ext.form.TextField({
			name: 'otrasFachadasPorcentaje',
			fieldLabel: this.otrasFachadasPorcentajeHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 3, 12),
			maxLength: 255
		})

		var otrasFachadasCamaraAireStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'otrasfachadasCamaraaireTipoId') {
				otrasFachadasCamaraAireStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var otrasFachadasCamaraAireStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: otrasFachadasCamaraAireStoreValues
		});

		fields.otrasfachadasCamaraaireTipoId = Ext.create('Ext.form.ComboBox', {
			name: 'otrasfachadasCamaraaireTipoId',
			fieldLabel: this.otrasfachadasCamaraaireTipoIdHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.otrasfachadasCamaraaireTipoIdDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 3, 12),
			store: otrasFachadasCamaraAireStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})
		var otrasFachadasAislamientoTermicoStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'otrasfachadasAislamientotermicoTipoId') {
				otrasFachadasAislamientoTermicoStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var otrasFachadasAislamientoTermicoStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: otrasFachadasAislamientoTermicoStoreValues
		});

		fields.otrasfachadasAislamientotermicoTipoId = Ext.create('Ext.form.ComboBox', {
			name: 'otrasfachadasAislamientotermicoTipoId',
			fieldLabel: this.otrasfachadasAislamientotermicoTipoIdHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.otrasfachadasAislamientotermicoTipoIdDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 3, 12),
			store: otrasFachadasAislamientoTermicoStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})
		fields.otrasfachadasAcabadovistoPorcentaje = new Ext.form.TextField({
			name: 'otrasfachadasAcabadovistoPorcentaje',
			fieldLabel: this.otrasfachadasAcabadovistoPorcentajeHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.otrasfachadasAcabadovistoPorcentajeDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 3, 12),
			maxLength: 255
		})
		fields.otrasfachadasAcabadorevestidoPorcentaje = new Ext.form.TextField({
			name: 'otrasfachadasAcabadorevestidoPorcentaje',
			fieldLabel: this.otrasfachadasAcabadorevestidoPorcentajeHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.otrasfachadasAcabadorevestidoPorcentajeDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			labelStyle: 'white-space: nowrap',
			width: At4FrameworkIntranet.FormDefaults.size(3, 3, 12),
			maxLength: 255
		})
		fields.otrasfachadasAcabadovistoTexto = new Ext.form.TextField({
			name: 'otrasfachadasAcabadovistoTexto',
			fieldLabel: this.otrasfachadasAcabadovistoTextoHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.otrasfachadasAcabadovistoTextoDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(5, 3, 12),
			maxLength: 255
		})
		fields.otrasfachadasAcabadorevestidoTexto = new Ext.form.TextField({
			name: 'otrasfachadasAcabadorevestidoTexto',
			fieldLabel: this.otrasfachadasAcabadorevestidoTextoHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.otrasfachadasAcabadorevestidoTextoDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(5, 3, 12),
			maxLength: 255
		})
		fields.carpinteriaVidrioSuperficie = new Ext.form.TextField({
			name: 'carpinteriaVidrioSuperficie',
			fieldLabel: this.carpinteriaVidrioSuperficieHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 3, 12),
			maxLength: 255
		})
		fields.carpinteriaVidrioPorcentaje = new Ext.form.TextField({
			name: 'carpinteriaVidrioPorcentaje',
			fieldLabel: this.carpinteriaVidrioPorcentajeHeaderLabel,
			tabIndex: tabHelper.getNext(),
			labelStyle: 'white-space: nowrap',
			width: At4FrameworkIntranet.FormDefaults.size(2, 3, 12),
			maxLength: 255
		})
		fields.carpinteriavidrioCarpinteriapredominanteTexto = new Ext.form.TextField({
			name: 'carpinteriavidrioCarpinteriapredominanteTexto',
			fieldLabel: this.carpinteriavidrioCarpinteriapredominanteTextoHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.carpinteriavidrioCarpinteriapredominanteTextoDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(12, 0, 12),
			maxLength: 255
		})
		fields.carpinteriavidrioVidriopredominanteTexto = new Ext.form.TextField({
			name: 'carpinteriavidrioVidriopredominanteTexto',
			fieldLabel: this.carpinteriavidrioVidriopredominanteTextoHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.carpinteriavidrioVidriopredominanteTextoDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(12, 0, 12),
			maxLength: 255
		})
		fields.cubiertaPlanaSuperficie = new Ext.form.TextField({
			name: 'cubiertaPlanaSuperficie',
			fieldLabel: this.cubiertaPlanaSuperficieHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 3, 12),
			maxLength: 255
		})
		fields.cubiertaPlanaPorcentaje = new Ext.form.TextField({
			name: 'cubiertaPlanaPorcentaje',
			fieldLabel: this.cubiertaPlanaPorcentajeHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 3, 12),
			maxLength: 255
		})

		var planaAislamientotermicoStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'cubiertaplanaAislamientotermicoTipoId') {
				planaAislamientotermicoStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var planaAislamientotermicoStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: planaAislamientotermicoStoreValues
		});

		fields.cubiertaplanaAislamientotermicoTipoId = Ext.create('Ext.form.ComboBox', {
			name: 'cubiertaplanaAislamientotermicoTipoId',
			fieldLabel: this.cubiertaplanaAislamientotermicoTipoIdHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.cubiertaplanaAislamientotermicoTipoIdDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(4, 3, 12),
			store: planaAislamientotermicoStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var planaLaminaimpermeabilizanteStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'cubiertaplanaLaminaimpermeabilizanteTipoId') {
				planaLaminaimpermeabilizanteStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var planaLaminaimpermeabilizanteStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: planaLaminaimpermeabilizanteStoreValues
		});

		fields.cubiertaplanaLaminaimpermeabilizanteTipoId = Ext.create('Ext.form.ComboBox', {
			name: 'cubiertaplanaLaminaimpermeabilizanteTipoId',
			fieldLabel: this.cubiertaplanaLaminaimpermeabilizanteTipoIdHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.cubiertaplanaLaminaimpermeabilizanteTipoIdDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(4, 3, 12),
			store: planaLaminaimpermeabilizanteStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})
		fields.cubiertaInclinadaSuperficie = new Ext.form.TextField({
			name: 'cubiertaInclinadaSuperficie',
			fieldLabel: this.cubiertaInclinadaSuperficieHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 3, 12),
			maxLength: 255
		})
		fields.cubiertaInclinadaPorcentaje = new Ext.form.TextField({
			name: 'cubiertaInclinadaPorcentaje',
			fieldLabel: this.cubiertaInclinadaPorcentajeHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 3, 12),
			maxLength: 255
		})

		var inclinadaAislamientotermicoStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'cubiertainclinadaAislamientotermicoTipoId') {
				inclinadaAislamientotermicoStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var inclinadaAislamientotermicoStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: inclinadaAislamientotermicoStoreValues
		});

		fields.cubiertainclinadaAislamientotermicoTipoId = Ext.create('Ext.form.ComboBox', {
			name: 'cubiertainclinadaAislamientotermicoTipoId',
			fieldLabel: this.cubiertainclinadaAislamientotermicoTipoIdHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.cubiertainclinadaAislamientotermicoTipoIdDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(4, 3, 12),
			store: inclinadaAislamientotermicoStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		fields.observaciones = new Ext.form.TextArea({
			name: 'observaciones',
			fieldLabel: this.observacionesHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(12, 0, 12),
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
					title: this.fachadasTitleLabel,
					items: At4FrameworkIntranet.FormDefaults.rows([
						[{
							xtype: 'fieldset',
							border: true,
							title: "Fachada principal",
							items: [{
								xtype: "At4Framework-rowContainer",
								minWidth: false,
								items: [fields.fachadaPrincipalSuperficie, fields.fachadaPrincipalPorcentaje, ]

							}, {
								xtype: "At4Framework-rowContainer",
								minWidth: false,
								items: [fields.fachadaprincipalCamaraaireTipoId, fields.fachadaprincipalAislamientotermicoTipoId]

							}, {
								xtype: "At4Framework-rowContainer",
								minWidth: false,
								items: [fields.fachadaprincipalAcabadovistoPorcentaje, fields.fachadaprincipalAcabadorevestidoPorcentaje]

							}, {
								xtype: "At4Framework-rowContainer",
								minWidth: false,
								items: [fields.fachadaprincipalAcabadovistoTexto, fields.fachadaprincipalAcabadorevestidoTexto]

							}]

						}],
						[{
							xtype: 'fieldset',
							border: true,
							title: this.otrasFachadasTitleLabel,
							items: [{
								xtype: "At4Framework-rowContainer",
								minWidth: false,
								items: [fields.otrasFachadasSuperficie, fields.otrasFachadasPorcentaje]

							}, {
								xtype: "At4Framework-rowContainer",
								minWidth: false,
								items: [fields.otrasfachadasCamaraaireTipoId, fields.otrasfachadasAislamientotermicoTipoId]

							}, {
								xtype: "At4Framework-rowContainer",
								minWidth: false,
								items: [fields.otrasfachadasAcabadovistoPorcentaje, fields.otrasfachadasAcabadorevestidoPorcentaje]

							}, {
								xtype: "At4Framework-rowContainer",
								minWidth: false,
								items: [fields.otrasfachadasAcabadovistoTexto, fields.otrasfachadasAcabadorevestidoTexto]

							}]

						}]
					])
				}, {
					xtype: 'At4Framework-fieldmainpanel',
					title: this.carpinteriaVidrioTitleLabel,
					items: At4FrameworkIntranet.FormDefaults.rows([
						//[fields.redesAguaRuidoMolestoTipoLocalizacion, fields.redesAireAcondicionadoFalsoTecho, fields.redesAireAcondicionadoRuidoMolesto],
						[fields.carpinteriaVidrioSuperficie, fields.carpinteriaVidrioPorcentaje],
						[fields.carpinteriavidrioCarpinteriapredominanteTexto],
						[fields.carpinteriavidrioVidriopredominanteTexto]
					])
				}, {
					xtype: 'At4Framework-fieldmainpanel',
					title: this.azoteaCubiertasObservacionesTitleLabel,
					items: At4FrameworkIntranet.FormDefaults.rows([
						[fields.cubiertaPlanaSuperficie, fields.cubiertaPlanaPorcentaje],
						[fields.cubiertaplanaAislamientotermicoTipoId, fields.cubiertaplanaLaminaimpermeabilizanteTipoId],
						[fields.cubiertaInclinadaSuperficie, fields.cubiertaInclinadaPorcentaje],
						[fields.cubiertainclinadaAislamientotermicoTipoId],
						[fields.observaciones]
					])
				}]
			},
			At4FrameworkIntranet.FormDefaults.rows([
				[At4FrameworkIntranet.FormDefaults.resumenAuditoria()]
			])
		];

		this.maxTabIndex = tabHelper.getNext();
		this.callParent([application, formName, gridMetaData, items, config]);
	}
});
//Namespace de  At4FrameworkIntranet
Ext.namespace('At4FrameworkIntranet');

/**
 * @class At4FrameworkIntranet.CimentacionesForm
 * Contiene la configuración del formulario: Cimentaciones
 * @author garrom
 * @constructor
 * @extends At4FrameworkIntranet.BasicForm
 * @param {Object} application La aplicación que contiene el formulario, normalmente será {@link At4FrameworkIntranet.app}
 * @param {String} formName Nombre del formulario
 * @param {Object} gridMetaData Configuración gridMetadata
 * @param {Object} config Configuración para Ext.form.FormPanel
 */

Ext.define("At4FrameworkIntranet.CimentacionesForm", {
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
		fields.cimentacionprofundaTexto = new Ext.form.TextField({
			name: 'cimentacionprofundaTexto',
			fieldLabel: this.cimentacionprofundaTextoHeaderLabel,
			tabIndex: tabHelper.getNext(),
			allowBlank: false,
			width: At4FrameworkIntranet.FormDefaults.size(4, 2, 12),
			maxLength: 255
		})
		fields.cimentacionsuperficialTexto = new Ext.form.TextField({
			name: 'cimentacionsuperficialTexto',
			fieldLabel: this.cimentacionsuperficialTextoHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(4, 2, 12),
			maxLength: 255
		})
		fields.sistemascontencionTexto = new Ext.form.TextField({
			name: 'sistemascontencionTexto',
			fieldLabel: this.sistemascontencionTextoHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(4, 2, 12),
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
					[fields.claveInforme, fields.edificio,  fields.inspeccionId],
					[fields.cimentacionprofundaTexto, fields.cimentacionsuperficialTexto, fields.sistemascontencionTexto],
					[fields.observaciones],
					[At4FrameworkIntranet.FormDefaults.resumenAuditoria()]
				])
			]
		}];



		this.maxTabIndex = tabHelper.getNext();
		this.callParent([application, formName, gridMetaData, items, config]);
	}
});
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
//Namespace de  At4FrameworkIntranet
Ext.namespace('At4FrameworkIntranet');

/**
 * @class At4FrameworkIntranet.EdificioForm
 * Contiene la configuración del formulario: Edificio
 * @author garrom
 * @constructor
 * @extends At4FrameworkIntranet.BasicForm
 * @param {Object} application La aplicación que contiene el formulario, normalmente será {@link At4FrameworkIntranet.app}
 * @param {String} formName Nombre del formulario
 * @param {Object} gridMetaData Configuración gridMetadata
 * @param {Object} config Configuración para Ext.form.FormPanel
 */

Ext.define("At4FrameworkIntranet.EdificioForm", {
	extend: "At4FrameworkIntranet.InspeccionBaseForm",
	constructor: function (application, formName, gridMetaData, config) {
		Ext.apply(this, config);
		var tabHelper = new At4util.tabIndexHelper(this.tabIndex);

		var columnDefaults = At4FrameworkIntranet.FormDefaults.COLUMN_DEFAULTS;
		var fieldDefaults = At4FrameworkIntranet.FormDefaults.FIELD_DEFAULTS;


		var fields = {}

		fields.clave = new Ext.form.NumberField({
			name: 'clave',
			fieldLabel: this.claveHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 4, 14),
			disableUpdates: true,
			disabled: true,
			hideTrigger: true,
			allowBlank: false,
			allowDecimals: false,
			maxValue: 2147483647
		})
		fields.municipio = new At4FrameworkIntranet.RelatedBox({
			name: 'municipioId',
			fieldLabel: this.municipioHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 4, 14),
			relatedIconCls: "glyphicons glyphicons-map",
			relatedForm: 'municipio'
		})
		fields.via = new At4FrameworkIntranet.RelatedBox({
			name: 'viaId',
			fieldLabel: this.viaHeaderLabel,
			tabIndex: tabHelper.getNext(),
			relatedIconCls: "glyphicons glyphicons-road",
			relatedForm: 'via',
			width: At4FrameworkIntranet.FormDefaults.size(3, 4, 14)
		})
		fields.numeroCatastro = new Ext.form.TextField({
			name: 'numeroCatastro',
			fieldLabel: this.numeroCatastroHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.numeroCatastroDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 4, 14),
			disableUpdates: true,
			disabled: true,
			maxLength: 64
		})
		fields.numeroExtra = new Ext.form.TextField({
			name: 'numeroExtra',
			fieldLabel: this.numeroExtraHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.numeroExtraDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 4, 14),
			maxLength: 64
		})
		fields.referenciaCatastral = new Ext.form.TextField({
			name: 'referenciaCatastral',
			fieldLabel: this.referenciaCatastralHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.referenciaCatastralDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			allowBlank: false,
			width: At4FrameworkIntranet.FormDefaults.size(3, 3, 12),
			disableUpdates: true,
			disabled: true,
			maxLength: 14
		})
		fields.antiguedad = new Ext.form.NumberField({
			name: 'antiguedad',
			fieldLabel: this.antiguedadHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.antiguedadDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			allowDecimals: false,
			maxValue: 2147483647,
			width: At4FrameworkIntranet.FormDefaults.size(3, 3, 12)
		})
		fields.centroX = new Ext.form.NumberField({
			name: 'centroX',
			fieldLabel: this.centroXHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.centroXDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			decimalSeparator: ',',
			allowDecimals: true,
			decimalPrecision: 4,
			maxValue: 9.99999999999E7, //1
			width: At4FrameworkIntranet.FormDefaults.size(3, 3, 12)
		})
		fields.centroY = new Ext.form.NumberField({
			name: 'centroY',
			fieldLabel: this.centroYHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.centroYDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			decimalSeparator: ',',
			allowDecimals: true,
			decimalPrecision: 4,
			maxValue: 9.99999999999E7, //1
			width: At4FrameworkIntranet.FormDefaults.size(3, 3, 12)
		})


		var informesForm = {
			form: "informe",
			iconCls: "glyphicons glyphicons-newspaper",
			text: this.informesHeaderLabel
		};

		fields.informes = new At4FrameworkIntranet.BasicPanel(this, {
			id: this.getId() + '-informes',
			name: 'informes',
			title: this.informesHeaderLabel,
			editForm: new At4FrameworkIntranet.InformeSubForm(this, formName),
			windowWidth: 750,
            deleteEnabled: false,
            addEnabled: false,
			windowHeight: 400,
			doEditRecord: function(record) {
				//console.log("editingRecord");
				this.parentFormPanel.application.openRecordForm(informesForm, record, this.informesHeaderLabel, {
					nestedParent: this
				});

			},
			tpl: At4FrameworkIntranet.InformeSubForm.PANEL_TPL,
			dataRecord: At4FrameworkIntranet.InformeSubForm.RECORD,
			deferredLoad: false
		})

		this.fields = fields;
		this.multiForms = {
			informes: fields.informes
		};
		var items = [
			At4FrameworkIntranet.FormDefaults.rows([
				[fields.clave,fields.municipio, fields.via, fields.numeroCatastro, fields.numeroExtra]
			]), {
				xtype: 'At4Framework-formtabpanel',
				id: 'panelTabs-' + this.id,
				items: [{
						xtype: 'At4Framework-fieldmainpanel',
						title: this.titleLabel,
						items: [
							At4FrameworkIntranet.FormDefaults.rows([
								[fields.referenciaCatastral, fields.antiguedad, fields.centroX, fields.centroY],
								[At4FrameworkIntranet.FormDefaults.resumenAuditoria()]
							])
						]
					}

					,
					fields.informes
				]
			}
		];



		this.maxTabIndex = tabHelper.getNext();
		this.callParent([application, formName, gridMetaData, items, config]);
	}
});
/**
 * @class At4FrameworkIntranet.InformeSubForm
 * Contiene la configuración del subformulario: Informe
 * @author  agarcia@at4.net
 * @constructor
 * @extends At4FrameworkIntranet.BasicSubForm
 * @param {Object} application La aplicación que contiene el formulario, normalmente será {@link At4FrameworkIntranet.app}
 * @param {Object} config Configuración para Ext.form.FormPanel
 */
Ext.define("At4FrameworkIntranet.InformeSubForm", {
	extend: "At4FrameworkIntranet.BasicSubForm",
	constructor: function (application, formName, gridMetaData, config) {
		Ext.apply(this, config);
		var tabHelper = new At4util.tabIndexHelper(this.tabIndex);
		this.subFormName = 'informes';
		//TODO: Para extjs4 esto era antes this.getId()
		this.id = application.getId() + "-" + this.subFormName + "SubForm";
		this.columnDefaults = At4FrameworkIntranet.FormDefaults.COLUMN_DEFAULTS;
		this.fieldDefaults = At4FrameworkIntranet.FormDefaults.FIELD_DEFAULTS;

		var fields = {}

		fields.clave = new Ext.form.NumberField({
			name: 'clave',
			fieldLabel: this.claveHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 1, 6),
			disableUpdates: true,
			disabled: true,
			hideTrigger: true,
			allowBlank: false,
			allowDecimals: false,
			maxValue: 2147483647
		})
		fields.estadoInforme = new At4FrameworkIntranet.ComboBox({
			name: 'estadoInformeId',
			fieldLabel: this.estadoInformeHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.estadoInformeDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			allowBlank: false,
			store: At4FrameworkIntranet.FormDefaults.getStore('EstadoInforme'),
			recordPK: 'clave',
			relatedForm: 'estadoinforme',
			width: At4FrameworkIntranet.FormDefaults.size(4, 1, 12)
		})

		fields.fechaInforme = new Ext.form.DateField({
			name: 'fechaInforme',
			fieldLabel: this.fechaInformeHeaderLabel,
			tabIndex: tabHelper.getNext(),
			allowBlank: false,
			format: 'd-m-Y',
			width: At4FrameworkIntranet.FormDefaults.size(3, 1, 6)
		})
		fields.fechaAlta = new Ext.form.DateField({
			name: 'fechaAlta',
			fieldLabel: this.fechaAltaHeaderLabel,
			tabIndex: tabHelper.getNext(),
			allowBlank: false,
			format: 'd-m-Y',
			width: At4FrameworkIntranet.FormDefaults.size(3, 1, 6)
		})
		this.ieeArxiuPanel = new At4FrameworkIntranet.FilePanel(this, {
				titleTxt: this.ieeArxiuHeaderLabel,
				fieldName: 'ieeArxiu',
				docname: 'informe-ieeArxiu',
				isImage: false,
				width: 400
			}

		)
		this.pdfArxiuPanel = new At4FrameworkIntranet.FilePanel(this, {
				titleTxt: this.pdfArxiuHeaderLabel,
				fieldName: 'pdfArxiu',
				docname: 'informe-pdfArxiu',
				isImage: false,
				width: 400
			}

		)

		this.maxTabIndex = tabHelper.getNext();
		this.fields = fields;
		var items = [{
				xtype: 'At4Framework-fieldmainpanel',
				items: [
					At4FrameworkIntranet.FormDefaults.rows([
						[fields.clave, fields.estadoInforme],
						[fields.fechaInforme, fields.fechaAlta]
					]),
					At4FrameworkIntranet.FormDefaults.rows([
						[this.ieeArxiuPanel, this.pdfArxiuPanel]
					])
				]
			}

			, {
				xtype: "At4Framework-rowContainer",
				items: [At4FrameworkIntranet.FormDefaults.resumenAuditoria()]
			}
		];



		this.callParent([application, items, config]);
	}

	/**
	 * Template para el panel
	 * TODO: en ext4, migrar a static
	 */
	//At4FrameworkIntranet.InformeSubForm.PANEL_TPL = new Ext.XTemplate(
	,
	statics: {
		PANEL_TPL: new Ext.XTemplate(
			'<table class="listadoPanel">',
			'<tbody>',
			'<tr>',

			'<th>{[this.getLabel("clave")]}</th>',
			'<th>{[this.getLabel("estadoInforme")]}</th>',
			'<th>{[this.getLabel("fechaInforme")]}</th>',
			'<th>{[this.getLabel("fechaAlta")]}</th>',
			'</tr>',
			'<tpl for=".">',
			'<tr class="filaListadoPanel">',

			'<td>{clave}</td>',
			'<td>{estadoInformeLabel}</td>',
			'<td>{fechaInforme:date("d/m/Y H:i")}</td>',
			'<td>{fechaAlta:date("d/m/Y H:i")}</td>',
			'</tr>',
			'</tpl>',
			'</tbody>',
			'</table>', {
				getLabel: function (name) {
					return At4FrameworkIntranet.FormDefaults.getFieldLabel("InformeSubForm", name);
				}
			}
		)


		/**
		 * Record para el subform
		 * TODO: en ext4, migrar a static
		 */
		//At4FrameworkIntranet.InformeSubForm.RECORD = Ext.data.Record.create(
		,
		MODEL: Ext.define('At4FrameworkIntranet.EdificioInformemodel', {
			extend: 'Ext.data.Model',
			idProperty: "oid",
			fields: [
				//Añadimos el campo de oid al registro (el campo oid es el "object identifier")
				{
					name: "oid",
					mapping: "clave",
					type: "int"
				}

				, {
					name: "clave",
					type: "int"
				}, {
					name: "estadoInformeId",
					type: "int"
				}, {
					name: "estadoInformeLabel",
					type: "auto"
				}, {
					name: "estadoInforme",
					mapping: "estadoInformeLabel",
					type: "auto"
				}, {
					name: "fechaInforme",
					type: "date"
				}, {
					name: "fechaAlta",
					type: "date"
				}, {
					name: "ieeArxiu",
					type: "int"
				}, {
					name: "pdfArxiu",
					type: "int"
				}
			]
		}),
		RECORD: 'At4FrameworkIntranet.EdificioInformemodel'
	}

});
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
//Namespace de  At4FrameworkIntranet
Ext.namespace('At4FrameworkIntranet');

/**
 * @class At4FrameworkIntranet.EstructuraForm
 * Contiene la configuración del formulario: Estructura
 * @author garrom
 * @constructor
 * @extends At4FrameworkIntranet.BasicForm
 * @param {Object} application La aplicación que contiene el formulario, normalmente será {@link At4FrameworkIntranet.app}
 * @param {String} formName Nombre del formulario
 * @param {Object} gridMetaData Configuración gridMetadata
 * @param {Object} config Configuración para Ext.form.FormPanel
 */

Ext.define("At4FrameworkIntranet.EstructuraForm", {
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
		fields.cubiertaForjadoinclinadoTexto = new Ext.form.TextField({
			name: 'cubiertaForjadoinclinadoTexto',
			fieldLabel: this.cubiertaForjadoinclinadoTextoHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.cubiertaForjadoinclinadoTextoDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(5, 1, 10),
			maxLength: 255
		})
		fields.cubiertaOtrosTexto = new Ext.form.TextField({
			name: 'cubiertaOtrosTexto',
			fieldLabel: this.cubiertaOtrosTextoHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(5, 1, 10),
			maxLength: 255
		})
		fields.horizontalplantatipoOtrosTexto = new Ext.form.TextField({
			name: 'horizontalplantatipoOtrosTexto',
			fieldLabel: this.horizontalplantatipoOtrosTextoHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.horizontalplantatipoOtrosTextoDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(5, 1, 10),
			maxLength: 255
		})
		fields.horizontalsueloOtrosTexto = new Ext.form.TextField({
			name: 'horizontalsueloOtrosTexto',
			fieldLabel: this.horizontalsueloOtrosTextoHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(5, 1, 10),
			maxLength: 255
		})
		fields.verticalOtros = new Ext.form.TextField({
			name: 'verticalOtros',
			fieldLabel: this.verticalOtrosHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(5, 1, 10),
			maxLength: 1
		})
		fields.verticalOtrosTexto = new Ext.form.TextField({
			name: 'verticalOtrosTexto',
			fieldLabel: this.verticalOtrosTextoHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(5, 1, 10),
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
					[fields.cubiertaForjadoinclinadoTexto, fields.cubiertaOtrosTexto],
					[fields.horizontalplantatipoOtrosTexto, fields.horizontalsueloOtrosTexto],
					[fields.verticalOtros],
					[fields.observaciones],
					[At4FrameworkIntranet.FormDefaults.resumenAuditoria()]
				]),
			]
		}];



		this.maxTabIndex = tabHelper.getNext();
		this.callParent([application, formName, gridMetaData, items, config]);
	}
});
//Namespace de  At4FrameworkIntranet
Ext.namespace('At4FrameworkIntranet');

/**
 * @class At4FrameworkIntranet.InformeForm
 * Contiene la configuración del formulario: Informe
 * @author garrom
 * @constructor
 * @extends At4FrameworkIntranet.BasicForm
 * @param {Object} application La aplicación que contiene el formulario, normalmente será {@link At4FrameworkIntranet.app}
 * @param {String} formName Nombre del formulario
 * @param {Object} gridMetaData Configuración gridMetadata
 * @param {Object} config Configuración para Ext.form.FormPanel
 */

Ext.define("At4FrameworkIntranet.InformeForm", {
	extend: "At4FrameworkIntranet.InspeccionBaseForm",
	constructor: function (application, formName, gridMetaData, config) {
		Ext.apply(this, config);
		var tabHelper = new At4util.tabIndexHelper(this.tabIndex);

		var columnDefaults = At4FrameworkIntranet.FormDefaults.COLUMN_DEFAULTS;
		var fieldDefaults = At4FrameworkIntranet.FormDefaults.FIELD_DEFAULTS;

		var fields = {}
		var fechaInformeDisbled = true;

		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'fechaInforme') {
				fechaInformeDisbled = !gridMetaData.columns[i].editable;
			}
		}

		console.log("FechaInforme diaabled:", fechaInformeDisbled);

		fields.clave = new Ext.form.NumberField({
			name: 'clave',
			fieldLabel: this.claveHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 3, 12),
			disableUpdates: true,
			disabled: true,
			hideTrigger: true,
			allowBlank: false,
			allowDecimals: false,
			maxValue: 2147483647
		})

		fields.estadoInforme = new At4FrameworkIntranet.ComboBox({
			name: 'estadoInformeId',
			fieldLabel: this.estadoInformeHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.estadoInformeDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 3, 12),
			allowBlank: false,
			store: At4FrameworkIntranet.FormDefaults.getStore('EstadoInforme'),
			recordPK: 'clave',
			showRelated: false,
			relatedForm: 'estadoinforme'
		})

		fields.edificio = new At4FrameworkIntranet.RelatedBox({
			name: 'edificioId',
			fieldLabel: this.edificioHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(6, 3, 12),
			relatedIconCls: "glyphicons glyphicons-building",
			relatedForm: 'edificio'
		})
		fields.municipio = new At4FrameworkIntranet.RelatedBox({
			name: 'municipioId',
			fieldLabel: this.municipioHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 4, 14),
			relatedIconCls: "glyphicons glyphicons-map",
			relatedForm: 'municipio'
		})

		fields.inspeccionId = Ext.create("Ext.ux.at4.OneToOneField", {
			name: 'inspeccionId',
			fieldLabel: this.inspeccionHeaderLabel,
			tabIndex: tabHelper.getNext(),
			border: true,
			application: application,
			relatedIconCls: "",
			relatedForm: 'inspeccion'
		})

		fields.fechaInforme = new Ext.form.DateField({
			name: 'fechaInforme',
			fieldLabel: this.fechaInformeHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 1, 12),
			disableUpdates: fechaInformeDisbled,
			disabled: fechaInformeDisbled,
			allowBlank: false,
			format: 'd-m-Y'
		})

		fields.fechaAlta = new Ext.form.DateField({
			name: 'fechaAlta',
			fieldLabel: this.fechaAltaHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 1, 12),
			disableUpdates: true,
			disabled: true,
			allowBlank: false,
			format: 'd-m-Y'
		})

		this.ieeArxiuPanel = new At4FrameworkIntranet.FilePanel(this, {
			titleTxt: this.ieeArxiuHeaderLabel,
			fieldName: 'ieeArxiu',
			docname: 'informe-ieeArxiu',
			isImage: false,
			width: 400,
			disableUpdates: true,
			disableDelete: true,
			disableUpload: true,
			disableConstrains: true,
			//disabled: true
		})

		this.pdfArxiuPanel = new At4FrameworkIntranet.FilePanel(this, {
			titleTxt: this.pdfArxiuHeaderLabel,
			fieldName: 'pdfArxiu',
			docname: 'informe-pdfArxiu',
			isImage: false,
			width: 400,
			disableUpdates: true,
			disableDelete: true,
			disableUpload: true,
			disableConstrains: true,
			//disabled: true
		})

		this.fields = fields;
		var items = [{
				xtype: 'At4Framework-fieldmainpanel',
				items: [
					At4FrameworkIntranet.FormDefaults.rows([
						[fields.clave, fields.estadoInforme, fields.edificio, fields.municipio, fields.inspeccionId],
						[fields.fechaInforme, fields.fechaAlta]
					]),
					At4FrameworkIntranet.FormDefaults.rows([
						[this.ieeArxiuPanel, this.pdfArxiuPanel]
					])
				]
			}

			, {
				xtype: "At4Framework-rowContainer",
				items: [At4FrameworkIntranet.FormDefaults.resumenAuditoria()]
			}
		];



		this.maxTabIndex = tabHelper.getNext();
		this.callParent([application, formName, gridMetaData, items, config]);
	}
});
//Namespace de  At4FrameworkIntranet
Ext.namespace('At4FrameworkIntranet');

/**
 * @class At4FrameworkIntranet.InspeccionForm
 * Contiene la configuración del formulario: Inspeccion
 * @author garrom
 * @constructor
 * @extends At4FrameworkIntranet.BasicForm
 * @param {Object} application La aplicación que contiene el formulario, normalmente será {@link At4FrameworkIntranet.app}
 * @param {String} formName Nombre del formulario
 * @param {Object} gridMetaData Configuración gridMetadata
 * @param {Object} config Configuración para Ext.form.FormPanel
 */

Ext.define("At4FrameworkIntranet.InspeccionForm", {
	extend: "At4FrameworkIntranet.InspeccionBaseForm",
	constructor: function (application, formName, gridMetaData, config) {
		Ext.apply(this, config);
		var tabHelper = new At4util.tabIndexHelper(this.tabIndex);

		var columnDefaults = At4FrameworkIntranet.FormDefaults.COLUMN_DEFAULTS;
		var fieldDefaults = At4FrameworkIntranet.FormDefaults.FIELD_DEFAULTS;


		var fields = {}
		//------Campos cabecera------
		fields.id = new Ext.form.NumberField({
			cls: 'tiny-text',
			name: 'id',
			fieldLabel: this.idHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 1, 15),
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

		// fields.informe = new At4FrameworkIntranet.ComboBox({
		// 		name: 'informeId',
		// 		fieldLabel: this.informeHeaderLabel,
		// 		tabIndex: tabHelper.getNext(),
		// 		width: At4FrameworkIntranet.FormDefaults.size(3, 1, 15),
		// 		allowBlank: false,
		// 		store: At4FrameworkIntranet.FormDefaults.getStore('Informe'),
		// 		recordPK: 'clave',
		// 		relatedForm: 'informe'
		// 	})

		fields.informeId = Ext.create("Ext.ux.at4.OneToOneField", {
			name: 'informeId',
			fieldLabel: this.informeHeaderLabel,
			tabIndex: tabHelper.getNext(),
			border: true,
			application: application,
			relatedIconCls: "glyphicons glyphicons-newspaper",
			relatedForm: 'informe'
		})

		fields.principal = new Ext.ux.form.XCheckbox({
			name: 'principal',
			margin: "24 0 0 10 ",
			boxLabel: this.principalHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 5, 13),
		})
		//----------------------------
		//--------Datos generales-----
		fields.accesibilidadAjustesrazonablesCostes = new Ext.form.TextField({
			name: 'accesibilidadAjustesrazonablesCostes',
			fieldLabel: this.accesibilidadAjustesrazonablesCostesHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.accesibilidadAjustesrazonablesCostesDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(5, 2, 16),
			maxLength: 255
		})
		fields.conservacionDatosgeneralesArchivos = new Ext.form.TextField({
			name: 'conservacionDatosgeneralesArchivos',
			fieldLabel: this.conservacionDatosgeneralesArchivosHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.conservacionDatosgeneralesArchivosDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(5, 2, 16),
			maxLength: 255
		})

		/**fields.ieeCompleta = new Ext.form.NumberField({
			cls: 'tiny-text',
			name: 'ieeCompleta',
			fieldLabel: this.ieeCompletaHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 2, 16),
			allowDecimals: false,
			maxValue: 2147483647
		})**/


		var ieeStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'ieeCompleta') {
				ieeStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var ieeStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: ieeStoreValues
		});

		fields.ieeCompleta = Ext.create('Ext.form.ComboBox', {
			name: 'ieeCompleta',
			fieldLabel: this.ieeCompletaHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 2, 16),
			store: ieeStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})



		fields.alturaSobreRasante = new Ext.form.NumberField({
			cls: 'tiny-text',
			name: 'alturaSobreRasante',
			fieldLabel: this.alturaSobreRasanteHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 5, 16),
			decimalSeparator: ',',
			allowDecimals: true,
			decimalPrecision: 10,
			maxValue: 1.0E10 //1
		})
		fields.mediaViviendasPorPlanta = new Ext.form.NumberField({
			cls: 'tiny-text',
			name: 'mediaViviendasPorPlanta',
			fieldLabel: this.mediaViviendasPorPlantaHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 5, 16),
			allowDecimals: false,
			maxValue: 2147483647
		})
		fields.numAparcamientos = new Ext.form.NumberField({
			cls: 'tiny-text',
			name: 'numAparcamientos',
			fieldLabel: this.numAparcamientosHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 5, 16),
			allowDecimals: false,
			maxValue: 2147483647
		})
		fields.numLocales = new Ext.form.NumberField({
			cls: 'tiny-text',
			name: 'numLocales',
			fieldLabel: this.numLocalesHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 5, 16),
			allowDecimals: false,
			maxValue: 2147483647
		})
		fields.numTrasteros = new Ext.form.NumberField({
			cls: 'tiny-text',
			name: 'numTrasteros',
			fieldLabel: this.numTrasterosHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 5, 16),
			allowDecimals: false,
			maxValue: 2147483647
		})
		fields.numViviendas = new Ext.form.NumberField({
			cls: 'tiny-text',
			name: 'numViviendas',
			fieldLabel: this.numViviendasHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 5, 16),
			allowDecimals: false,
			maxValue: 2147483647
		})
		fields.anoConstruccion = new Ext.form.NumberField({
			cls: 'tiny-text',
			name: 'anoConstruccion',
			fieldLabel: this.anoConstruccionHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 5, 16),
			allowDecimals: false,
			maxValue: 2147483647
		})
		fields.anoConstruccionReferencia = new Ext.form.TextField({
			name: 'anoConstruccionReferencia',
			fieldLabel: this.anoConstruccionReferenciaHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(4, 5, 16),
			maxLength: 255
		})
		fields.anoRehabilitacion = new Ext.form.NumberField({
			cls: 'tiny-text',
			name: 'anoRehabilitacion',
			fieldLabel: this.anoRehabilitacionHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 5, 16),
			allowDecimals: false,
			maxValue: 2147483647
		})
		fields.anoRehabilitacionReferencia = new Ext.form.TextField({
			name: 'anoRehabilitacionReferencia',
			fieldLabel: this.anoRehabilitacionReferenciaHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(4, 5, 16),
			maxLength: 255
		})

		var nucleosEscalerasTipoIdStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'inspeccionDatosedificioNucleosescalerasTipoId') {
				nucleosEscalerasTipoIdStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var nucleosEscalerasTipoIdStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: nucleosEscalerasTipoIdStoreValues
		});

		fields.inspeccionDatosedificioNucleosescalerasTipoId = Ext.create('Ext.form.ComboBox', {
			name: 'inspeccionDatosedificioNucleosescalerasTipoId',
			fieldLabel: this.inspeccionDatosedificioNucleosescalerasTipoIdHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.inspeccionDatosedificioNucleosescalerasTipoIdDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 3, 12),
			store: nucleosEscalerasTipoIdStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var parcelaTipoIdStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'inspeccionDatosedificioParcelaTipoId') {
				parcelaTipoIdStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var parcelaIdStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: parcelaTipoIdStoreValues
		});

		fields.inspeccionDatosedificioParcelaTipoId = Ext.create('Ext.form.ComboBox', {
			name: 'inspeccionDatosedificioParcelaTipoId',
			fieldLabel: this.inspeccionDatosedificioParcelaTipoIdHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.inspeccionDatosedificioParcelaTipoIdDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(4, 3, 12),
			store: parcelaIdStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var unnucleosEscalerasTipoIdStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'inspeccionDatosedificioUnnucleoescalerasTipoId') {
				unnucleosEscalerasTipoIdStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var unnucleosEscalerasTipoIdStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: unnucleosEscalerasTipoIdStoreValues
		});

		fields.inspeccionDatosedificioUnnucleoescalerasTipoId = Ext.create('Ext.form.ComboBox', {
			name: 'inspeccionDatosedificioUnnucleoescalerasTipoId',
			fieldLabel: this.inspeccionDatosedificioUnnucleoescalerasTipoIdHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.inspeccionDatosedificioUnnucleoescalerasTipoIdDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 3, 12),
			store: unnucleosEscalerasTipoIdStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var usoTipoIdStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'inspeccionDatosedificioUsoTipoId') {
				usoTipoIdStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var usoTipoIdStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: usoTipoIdStoreValues
		});

		fields.inspeccionDatosedificioUsoTipoId = Ext.create('Ext.form.ComboBox', {
			name: 'inspeccionDatosedificioUsoTipoId',
			fieldLabel: this.inspeccionDatosedificioUsoTipoIdHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.inspeccionDatosedificioUsoTipoIdDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 3, 12),
			store: usoTipoIdStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		fields.plantasBajoRasanteUsoPrincipal = new Ext.form.NumberField({
			cls: 'tiny-text',
			name: 'plantasBajoRasanteUsoPrincipal',
			fieldLabel: this.plantasBajoRasanteUsoPrincipalHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.plantasBajoRasanteUsoPrincipalDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 2, 7),
			allowDecimals: false,
			maxValue: 2147483647
		})
		fields.plantasBajoRasanteUsosSecundarios = new Ext.form.NumberField({
			cls: 'tiny-text',
			name: 'plantasBajoRasanteUsosSecundarios',
			fieldLabel: this.plantasBajoRasanteUsosSecundariosHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.plantasBajoRasanteUsosSecundariosDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 2, 7),
			allowDecimals: false,
			maxValue: 2147483647
		})
		fields.plantasBajoRasanteUsosSecundariosTipo = new Ext.form.TextField({
			name: 'plantasBajoRasanteUsosSecundariosTipo',
			fieldLabel: this.plantasBajoRasanteUsosSecundariosTipoHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.plantasBajoRasanteUsosSecundariosTipoDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 2, 7),
			maxLength: 255
		})
		fields.plantasSobreRasanteUsoPrincipal = new Ext.form.NumberField({
			cls: 'tiny-text',
			name: 'plantasSobreRasanteUsoPrincipal',
			fieldLabel: this.plantasSobreRasanteUsoPrincipalHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.plantasSobreRasanteUsoPrincipalDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 2, 7),
			allowDecimals: false,
			maxValue: 2147483647
		})
		fields.plantasSobreRasanteUsosSecundarios = new Ext.form.NumberField({
			cls: 'tiny-text',
			name: 'plantasSobreRasanteUsosSecundarios',
			fieldLabel: this.plantasSobreRasanteUsosSecundariosHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.plantasSobreRasanteUsosSecundariosDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 2, 7),
			allowDecimals: false,
			maxValue: 2147483647
		})
		fields.plantasSobreRasanteUsosSecundariosTipo = new Ext.form.TextField({
			name: 'plantasSobreRasanteUsosSecundariosTipo',
			fieldLabel: this.plantasSobreRasanteUsosSecundariosTipoHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.plantasSobreRasanteUsosSecundariosTipoDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 2, 7),
			maxLength: 255
		})
		//------------------------------------
		//--------Superficies-----------------



		fields.totalAscensores = new Ext.form.TextField({
			name: 'totalAscensores',
			fieldLabel: this.totalAscensoresHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2.5, 3, 15),
			maxLength: 255
		})
		fields.totalEscaleras = new Ext.form.TextField({
			name: 'totalEscaleras',
			fieldLabel: this.totalEscalerasHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2.5, 3, 15),
			maxLength: 255
		})
		fields.totalViviendasConAccesoVariosNucleos = new Ext.form.TextField({
			name: 'totalViviendasConAccesoVariosNucleos',
			fieldLabel: this.totalViviendasConAccesoVariosNucleosHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.totalViviendasConAccesoVariosNucleosDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(5, 3, 15),
			maxLength: 255
		})
		fields.totalViviendasSinAccesoAscensor = new Ext.form.TextField({
			name: 'totalViviendasSinAccesoAscensor',
			fieldLabel: this.totalViviendasSinAccesoAscensorHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.totalViviendasSinAccesoAscensorDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(5, 3, 15),
			maxLength: 255
		})
		fields.usoTexto = new Ext.form.TextField({
			name: 'usoTexto',
			fieldLabel: this.usoTextoHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(5.5, 4, 15),
			maxLength: 255
		})
		fields.numero = new Ext.form.NumberField({
			cls: 'tiny-text',
			name: 'numero',
			fieldLabel: this.numeroHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(1.5, 4, 15),
			allowDecimals: false,
			maxValue: 2147483647
		})
		fields.tipoVia = new Ext.form.TextField({
			name: 'tipoVia',
			fieldLabel: this.tipoViaHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 4, 15),
			maxLength: 255
		})
		fields.via = new Ext.form.TextField({
			name: 'via',
			fieldLabel: this.viaHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 4, 15),
			maxLength: 255
		})
		fields.referenciaCatastral = new Ext.form.TextField({
			name: 'referenciaCatastral',
			fieldLabel: this.referenciaCatastralHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(4, 4, 15),
			maxLength: 255
		})
		fields.superficieConstruida = new Ext.form.NumberField({
			name: 'superficieConstruida',
			fieldLabel: this.superficieConstruidaHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2.5, 5, 12),
			decimalSeparator: ',',
			allowDecimals: true,
			decimalPrecision: 10,
			maxValue: 1.0E10 //1
		})
		fields.superficieMediaAparcamientos = new Ext.form.NumberField({
			name: 'superficieMediaAparcamientos',
			fieldLabel: this.superficieMediaAparcamientosHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2.5, 5, 11),
			decimalSeparator: ',',
			allowDecimals: true,
			decimalPrecision: 10,
			maxValue: 1.0E10 //1
		})
		fields.superficieMediaLocales = new Ext.form.NumberField({
			name: 'superficieMediaLocales',
			fieldLabel: this.superficieMediaLocalesHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2.5, 5, 12),
			decimalSeparator: ',',
			allowDecimals: true,
			decimalPrecision: 10,
			maxValue: 1.0E10 //1
		})
		fields.superficieMediaTrasteros = new Ext.form.NumberField({
			name: 'superficieMediaTrasteros',
			fieldLabel: this.superficieMediaTrasterosHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2.5, 5, 12),
			decimalSeparator: ',',
			allowDecimals: true,
			decimalPrecision: 10,
			maxValue: 1.0E10 //1
		})
		fields.superficieMediaViviendas = new Ext.form.NumberField({
			name: 'superficieMediaViviendas',
			fieldLabel: this.superficieMediaViviendasHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2.5, 2, 12),
			decimalSeparator: ',',
			allowDecimals: true,
			decimalPrecision: 10,
			maxValue: 1.0E10 //1
		})
		fields.superficieParcela = new Ext.form.NumberField({
			name: 'superficieParcela',
			fieldLabel: this.superficieParcelaHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2.5, 5, 12),
			decimalSeparator: ',',
			allowDecimals: true,
			decimalPrecision: 10,
			maxValue: 1.0E10 //1
		})

		//----------------------
		//-----Edificio-----
		fields.edificioCodigoPostal = new Ext.form.TextField({
			name: 'edificioCodigoPostal',
			fieldLabel: this.edificioCodigoPostalHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 3, 10),
			maxLength: 255
		})
		fields.edificioComunTexto = new Ext.form.TextField({
			name: 'edificioComunTexto',
			fieldLabel: this.edificioComunTextoHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 3, 10),
			maxLength: 255
		})
		fields.edificioNumeroManual = new Ext.form.TextField({
			name: 'edificioNumeroManual',
			fieldLabel: this.edificioNumeroManualHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 3, 10),
			maxLength: 255
		})
		fields.edificioObjetoTexto = new Ext.form.TextField({
			name: 'edificioObjetoTexto',
			fieldLabel: this.edificioObjetoTextoHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 3, 10),
			maxLength: 255
		})
		fields.edificioPisoLetra = new Ext.form.TextField({
			name: 'edificioPisoLetra',
			fieldLabel: this.edificioPisoLetraHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 2, 10),
			maxLength: 255
		})
		fields.edificioPoblacion = new Ext.form.TextField({
			name: 'edificioPoblacion',
			fieldLabel: this.edificioPoblacionHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(4, 2, 10),
			maxLength: 255
		})
		fields.edificioProvincia = new Ext.form.TextField({
			name: 'edificioProvincia',
			fieldLabel: this.edificioProvinciaHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(4, 2, 10),
			maxLength: 255
		})
		fields.edificioProvinciaId = new Ext.form.NumberField({
			cls: 'tiny-text',
			name: 'edificioProvinciaId',
			fieldLabel: this.edificioProvinciaIdHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 3, 10),
			allowDecimals: false,
			maxValue: 2147483647
		})
		fields.edificioRegimenTexto = new Ext.form.TextField({
			name: 'edificioRegimenTexto',
			fieldLabel: this.edificioRegimenTextoHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 3, 10),
			maxLength: 255
		})
		fields.edificioTipoViaManual = new Ext.form.TextField({
			name: 'edificioTipoViaManual',
			fieldLabel: this.edificioTipoViaManualHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 3, 10),
			maxLength: 255
		})
		fields.edificioViaManual = new Ext.form.TextField({
			name: 'edificioViaManual',
			fieldLabel: this.edificioViaManualHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 3, 10),
			maxLength: 255
		})
		fields.edificioObservaciones = new Ext.form.TextArea({
			name: 'edificioObservaciones',
			fieldLabel: this.edificioObservacionesHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(10, 0, 10),
			maxLength: 255
		})

		var edificioComunesTipoIdStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'edificioInspeccionIdentificacionedificioComunesTipoId') {
				edificioComunesTipoIdStore = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var edificioComunesTipoIdStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: edificioComunesTipoIdStore
		});

		fields.edificioInspeccionIdentificacionedificioComunesTipoId = Ext.create('Ext.form.ComboBox', {
			name: 'edificioInspeccionIdentificacionedificioComunesTipoId',
			fieldLabel: this.edificioInspeccionIdentificacionedificioComunesTipoIdHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.edificioInspeccionIdentificacionedificioComunesTipoIdDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 2, 10),
			store: edificioComunesTipoIdStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var edificioObjetoIdStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'edificioInspeccionIdentificacionedificioObjetoTipoId') {
				edificioObjetoIdStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var edificioObjetoIdStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: edificioObjetoIdStoreValues
		});

		fields.edificioInspeccionIdentificacionedificioObjetoTipoId = Ext.create('Ext.form.ComboBox', {
			name: 'edificioInspeccionIdentificacionedificioObjetoTipoId',
			fieldLabel: this.edificioInspeccionIdentificacionedificioObjetoTipoIdHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.edificioInspeccionIdentificacionedificioObjetoTipoIdDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(5, 2, 10),
			store: edificioObjetoIdStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var propiedadRegimenIdStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'edificioInspeccionPropiedadRegimenTipoId') {
				propiedadRegimenIdStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var propiedadRegimenIdStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: propiedadRegimenIdStoreValues
		});

		fields.edificioInspeccionPropiedadRegimenTipoId = Ext.create('Ext.form.ComboBox', {
			name: 'edificioInspeccionPropiedadRegimenTipoId',
			fieldLabel: this.edificioInspeccionPropiedadRegimenTipoIdHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.edificioInspeccionPropiedadRegimenTipoIdDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 2, 10),
			store: propiedadRegimenIdStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})
		//----------------------
		//------Técnico, Titular y representante------
		fields.tecnicoNif = new Ext.form.TextField({
			name: 'tecnicoNif',
			fieldLabel: this.tecnicoNifHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 2, 12),
			maxLength: 255
		})
		fields.tecnicoTecnico = new Ext.form.TextField({
			name: 'tecnicoTecnico',
			fieldLabel: this.tecnicoTecnicoHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(4.5, 2, 12),
			maxLength: 255
		})
		fields.tecnicoTitulacion = new Ext.form.TextField({
			name: 'tecnicoTitulacion',
			fieldLabel: this.tecnicoTitulacionHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(6, 2, 12),
			maxLength: 255
		})
		fields.propiedadNif = new Ext.form.TextField({
			name: 'propiedadNif',
			fieldLabel: this.propiedadNifHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 1, 10),
			maxLength: 255
		})
		fields.propiedadTitular = new Ext.form.TextField({
			name: 'propiedadTitular',
			fieldLabel: this.propiedadTitularHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(8, 1, 10),
			maxLength: 255
		})
		fields.representanteCodigoPostal = new Ext.form.TextField({
			name: 'representanteCodigoPostal',
			fieldLabel: this.representanteCodigoPostalHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 4, 12),
			maxLength: 255
		})
		fields.representanteCondicion = new Ext.form.TextField({
			name: 'representanteCondicion',
			fieldLabel: this.representanteCondicionHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 4, 12),
			maxLength: 255
		})
		fields.representanteDireccion = new Ext.form.TextField({
			name: 'representanteDireccion',
			fieldLabel: this.representanteDireccionHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 4, 12),
			maxLength: 255
		})
		fields.representanteEmail = new Ext.form.TextField({
			name: 'representanteEmail',
			fieldLabel: this.representanteEmailHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 4, 12),
			maxLength: 255
		})
		fields.representanteNif = new Ext.form.TextField({
			name: 'representanteNif',
			fieldLabel: this.representanteNifHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 4, 12),
			maxLength: 255
		})
		fields.representanteNombre = new Ext.form.TextField({
			name: 'representanteNombre',
			fieldLabel: this.representanteNombreHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 4, 12),
			maxLength: 255
		})
		fields.representantePoblacion = new Ext.form.TextField({
			name: 'representantePoblacion',
			fieldLabel: this.representantePoblacionHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 4, 12),
			maxLength: 255
		})
		fields.representanteProvincia = new Ext.form.TextField({
			name: 'representanteProvincia',
			fieldLabel: this.representanteProvinciaHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 4, 12),
			maxLength: 255
		})
		fields.representanteTelefonoFijo = new Ext.form.TextField({
			name: 'representanteTelefonoFijo',
			fieldLabel: this.representanteTelefonoFijoHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 4, 12),
			maxLength: 255
		})
		fields.representanteTelefonoMovil = new Ext.form.TextField({
			name: 'representanteTelefonoMovil',
			fieldLabel: this.representanteTelefonoMovilHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 4, 12),
			maxLength: 255
		})
		//---------------------------------------
		//---------Otros datos---------

		fields.accesibilidadPublicosId = Ext.create("Ext.ux.at4.OneToOneField", {
			application: application,
			name: 'accesibilidadPublicosId',
			fieldLabel: this.accesibilidadPublicosHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 2, 12),
			allowBlank: false,
			//store: At4FrameworkIntranet.FormDefaults.getStore('AccesibilidadPublicos'),
			recordPK: 'claveInforme',
			relatedForm: 'accesibilidadpublicos'
		})
		fields.accesibilidadValoracionFinalesId = Ext.create("Ext.ux.at4.OneToOneField", {
			application: application,
			name: 'accesibilidadValoracionFinalesId',
			fieldLabel: this.accesibilidadValoracionFinalesHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 2, 12),
			allowBlank: false,
			//store: At4FrameworkIntranet.FormDefaults.getStore('AccesibilidadValoracionFinales'),
			recordPK: 'claveInforme',
			relatedForm: 'accesibilidadvaloracionfinales'
		})
		fields.accesibilidadAjustesRazonablesId = Ext.create("Ext.ux.at4.OneToOneField", {
			application: application,
			name: 'accesibilidadAjustesRazonablesId',
			fieldLabel: this.accesibilidadAjustesRazonablesHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 2, 12),
			allowBlank: false,
			//store: At4FrameworkIntranet.FormDefaults.getStore('AccesibilidadAjustesRazonables'),
			recordPK: 'claveInforme',
			relatedForm: 'accesibilidadajustesrazonables'
		})
		fields.acusticasId = Ext.create("Ext.ux.at4.OneToOneField", {
			application: application,
			name: 'acusticasId',
			fieldLabel: this.acusticasHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2.5, 4, 12),
			allowBlank: false,
			//store: At4FrameworkIntranet.FormDefaults.getStore('Acusticas'),
			recordPK: 'claveInforme',
			relatedForm: 'acusticas'
		})
		fields.acusticaDatosGeneralesId = Ext.create("Ext.ux.at4.OneToOneField", {
			application: application,
			name: 'acusticaDatosGeneralesId',
			fieldLabel: this.acusticaDatosGeneralesHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2.5, 4, 12),
			allowBlank: false,
			//store: At4FrameworkIntranet.FormDefaults.getStore('AcusticaDatosGenerales'),
			recordPK: 'claveInforme',
			relatedForm: 'acusticadatosgenerales'
		})
		fields.acusticaValoracionFinalId = Ext.create("Ext.ux.at4.OneToOneField", {
			application: application,
			name: 'acusticaValoracionFinalId',
			fieldLabel: this.acusticaValoracionFinalHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2.5, 4, 12),
			allowBlank: false,
			//store: At4FrameworkIntranet.FormDefaults.getStore('AcusticaValoracionFinal'),
			recordPK: 'claveInforme',
			relatedForm: 'acusticavaloracionfinal'
		})
		fields.acusticaComprobacionesId = Ext.create("Ext.ux.at4.OneToOneField", {
			application: application,
			name: 'acusticaComprobacionesId',
			fieldLabel: this.acusticaComprobacionesHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2.5, 4, 12),
			allowBlank: false,
			//store: At4FrameworkIntranet.FormDefaults.getStore('AcusticaComprobaciones'),
			recordPK: 'claveInforme',
			relatedForm: 'acusticacomprobaciones'
		})

		/*
		fields.acusticaMejorasAcusticasId = Ext.create("Ext.ux.at4.OneToOneField", {
			application: application,
			name: 'acusticaMejorasAcusticasId',
			fieldLabel: this.acusticaMejorasAcusticasHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2.5, 4, 12),
			allowBlank: false,
			//store: At4FrameworkIntranet.FormDefaults.getStore('AcusticaMejorasAcusticas'),
			recordPK: 'claveInforme',
			relatedForm: 'acusticamejorasacusticas'
		})
		*/


		this.openAcusticaMejorasAcusticas = new Ext.Button({
			text: this.acusticaMejorasAcusticasHeaderLabel,
			margin: "10px 0 0 10px",
			border: true,
			handler: function (button, event) {
				var form = {
					form: 'acusticamejorasacusticas',
					text: this.acusticaMejorasAcusticasHeaderLabel + ": " + this.dataId,
					id: "ama" + this.dataId,
					iconCls: "glyphicons glyphicons-blog"
				}
				var customConfig = {
					extraFilters: [{
						field: 'inspeccion',
						data: {
							type: 'numeric',
							comparison: 'eq',
							value: this.dataId
						}
					}]
				}
				this.application.openCustomListGrid('acusticamejorasacusticas' + this.dataId, form, customConfig);
			},
			scope: this
		});


		fields.acusticaRuidoInstalacionesId = Ext.create("Ext.ux.at4.OneToOneField", {
			application: application,
			name: 'acusticaRuidoInstalacionesId',
			fieldLabel: this.acusticaRuidoInstalacionesHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2.5, 4, 12),
			allowBlank: false,
			//store: At4FrameworkIntranet.FormDefaults.getStore('AcusticaRuidoInstalaciones'),
			recordPK: 'claveInforme',
			relatedForm: 'acusticaruidoinstalaciones'
		})
		fields.acusticaRuidosExterioresId = Ext.create("Ext.ux.at4.OneToOneField", {
			application: application,
			name: 'acusticaRuidosExterioresId',
			fieldLabel: this.acusticaRuidosExterioresHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2.5, 4, 12),
			allowBlank: false,
			//store: At4FrameworkIntranet.FormDefaults.getStore('AcusticaRuidosExteriores'),
			recordPK: 'claveInforme',
			relatedForm: 'acusticaruidosexteriores'
		})


		fields.acusticaRuidosInterioresHorizontalesId = Ext.create("Ext.ux.at4.OneToOneField", {
			application: application,
			name: 'acusticaRuidosInterioresHorizontalesId',
			fieldLabel: this.acusticaRuidosInterioresHorizontalesHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2.5, 4, 12),
			allowBlank: false,
			//store: At4FrameworkIntranet.FormDefaults.getStore('AcusticaRuidosInterioresHorizontales'),
			recordPK: 'claveInforme',
			relatedForm: 'acusticaruidosinterioreshorizontales'
		})
		fields.acusticaRuidosInterioresVerticalesId = Ext.create("Ext.ux.at4.OneToOneField", {
			application: application,
			name: 'acusticaRuidosInterioresVerticalesId',
			fieldLabel: this.acusticaRuidosInterioresVerticalesHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2.5, 4, 12),
			allowBlank: false,
			//	store: At4FrameworkIntranet.FormDefaults.getStore('AcusticaRuidosInterioresVerticales'),
			recordPK: 'claveInforme',
			relatedForm: 'acusticaruidosinterioresverticales'
		})
		fields.acusticaRuidosInterioresUnionesId = Ext.create("Ext.ux.at4.OneToOneField", {
			application: application,
			name: 'acusticaRuidosInterioresUnionesId',
			fieldLabel: this.acusticaRuidosInterioresUnionesHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2.5, 4, 12),
			allowBlank: false,
			//store: At4FrameworkIntranet.FormDefaults.getStore('AcusticaRuidosInterioresUniones'),
			recordPK: 'claveInforme',
			relatedForm: 'acusticaruidosinterioresuniones'
		})


		fields.cerramientosCubiertasId = Ext.create("Ext.ux.at4.OneToOneField", {
			application: application,
			name: 'cerramientosCubiertasId',
			fieldLabel: this.cerramientosCubiertasHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 2, 7),
			allowBlank: false,
			//store: At4FrameworkIntranet.FormDefaults.getStore('CerramientosCubiertas'),
			recordPK: 'claveInforme',
			relatedForm: 'cerramientoscubiertas'
		})
		fields.instalacionesId = Ext.create("Ext.ux.at4.OneToOneField", {
			application: application,
			name: 'instalacionesId',
			fieldLabel: this.instalacionesHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 2, 7),
			allowBlank: false,
			//store: At4FrameworkIntranet.FormDefaults.getStore('Instalaciones'),
			recordPK: 'claveInforme',
			relatedForm: 'instalaciones'
		})
		fields.estructuraId = Ext.create("Ext.ux.at4.OneToOneField", {
			application: application,
			name: 'estructuraId',
			fieldLabel: this.estructuraHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 2, 7),
			allowBlank: false,
			//store: At4FrameworkIntranet.FormDefaults.getStore('Estructura'),
			recordPK: 'claveInforme',
			relatedForm: 'estructura'
		})
		fields.eficienciasEnergeticasId = Ext.create("Ext.ux.at4.OneToOneField", {
			application: application,
			name: 'eficienciasEnergeticasId',
			fieldLabel: this.eficienciasEnergeticasHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 2, 7),
			allowBlank: false,
			//store: At4FrameworkIntranet.FormDefaults.getStore('EficienciasEnergeticas'),
			recordPK: 'claveInforme',
			relatedForm: 'eficienciasenergeticas'
		})
		fields.cimentacionesId = Ext.create("Ext.ux.at4.OneToOneField", {
			application: application,
			name: 'cimentacionesId',
			fieldLabel: this.cimentacionesHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 2, 7),
			allowBlank: false,
			//store: At4FrameworkIntranet.FormDefaults.getStore('Cimentaciones'),
			recordPK: 'claveInforme',
			relatedForm: 'cimentaciones'
		})
		fields.conservacionId = Ext.create("Ext.ux.at4.OneToOneField", {
			application: application,
			name: 'conservacionId',
			fieldLabel: this.conservacionHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 2, 7),
			allowBlank: false,
			//store: At4FrameworkIntranet.FormDefaults.getStore('Conservacion'),
			recordPK: 'claveInforme',
			relatedForm: 'conservacion'
		})
		fields.fechasVisitas = new At4FrameworkIntranet.BasicPanel(this, {
			id: this.getId() + '-fechasVisitas',
			name: 'fechasVisitas',
			title: this.fechasVisitasHeaderLabel,
			editForm: new At4FrameworkIntranet.FechaVisitaSubForm(this, formName),
			windowWidth: 750,
			windowHeight: 400,
			tpl: At4FrameworkIntranet.FechaVisitaSubForm.PANEL_TPL,
			dataRecord: At4FrameworkIntranet.FechaVisitaSubForm.RECORD,
			deferredLoad: false
		})
		fields.valoracionesParciales = new At4FrameworkIntranet.BasicPanel(this, {
			id: this.getId() + '-valoracionesParciales',
			name: 'valoracionesParciales',
			title: this.valoracionesParcialesHeaderLabel,
			editForm: new At4FrameworkIntranet.ValoracionParcialSubForm(this, formName),
			windowWidth: 750,
			windowHeight: 400,
			tpl: At4FrameworkIntranet.ValoracionParcialSubForm.PANEL_TPL,
			dataRecord: At4FrameworkIntranet.ValoracionParcialSubForm.RECORD,
			deferredLoad: false
		})
		fields.documentacionOtros = new At4FrameworkIntranet.BasicPanel(this, {
			id: this.getId() + '-documentacionOtros',
			name: 'documentacionOtros',
			title: this.documentacionOtrosHeaderLabel,
			editForm: new At4FrameworkIntranet.DocumentacionOtroSubForm(this, formName),
			windowWidth: 750,
			windowHeight: 400,
			tpl: At4FrameworkIntranet.DocumentacionOtroSubForm.PANEL_TPL,
			dataRecord: At4FrameworkIntranet.DocumentacionOtroSubForm.RECORD,
			deferredLoad: false
		})
		fields.deficiencias = new At4FrameworkIntranet.BasicPanel(this, {
			id: this.getId() + '-deficiencias',
			name: 'deficiencias',
			title: this.deficienciasHeaderLabel,
			editForm: new At4FrameworkIntranet.DeficienciaSubForm(this, formName),
			windowWidth: 750,
			windowHeight: 400,
			tpl: At4FrameworkIntranet.DeficienciaSubForm.PANEL_TPL,
			dataRecord: At4FrameworkIntranet.DeficienciaSubForm.RECORD,
			deferredLoad: false
		})
		fields.valores = new At4FrameworkIntranet.ItemSelector({
			name: 'valores',
			//fieldLabel: this.valoresHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(14, 0, 14),
			height: 500,
			showOnlySelected: true,
			toTitle: null,
			fromTitle: null,
			fromStore: At4FrameworkIntranet.FormDefaults.getStore('Valor'),
			recordPK: 'id',
			relatedForm: 'valor'
		})
		fields.historicos = new At4FrameworkIntranet.BasicPanel(this, {
			id: this.getId() + '-historicos',
			name: 'historicos',
			title: this.historicosHeaderLabel,
			editForm: new At4FrameworkIntranet.HistoricoSubForm(this, formName),
			windowWidth: 750,
			windowHeight: 400,
			tpl: At4FrameworkIntranet.HistoricoSubForm.PANEL_TPL,
			dataRecord: At4FrameworkIntranet.HistoricoSubForm.RECORD,
			deferredLoad: false
		})

		this.fields = fields;
		this.multiForms = {
			fechasVisitas: fields.fechasVisitas,
			valoracionesParciales: fields.valoracionesParciales,
			documentacionOtros: fields.documentacionOtros,
			deficiencias: fields.deficiencias,
			historicos: fields.historicos
		};

		var items = [
			At4FrameworkIntranet.FormDefaults.rows([
				[fields.id, fields.edificio, fields.informeId, fields.principal]
			]), {
				xtype: 'At4Framework-formtabpanel',
				id: 'panelTabs-' + this.id,
				items: [{
					xtype: 'At4Framework-fieldmainpanel',
					//title: "Datos Generales",
					title: this.datosGeneralesTitleLabel,
					items: [
						At4FrameworkIntranet.FormDefaults.rows([
							[fields.accesibilidadAjustesrazonablesCostes, fields.conservacionDatosgeneralesArchivos, fields.ieeCompleta],
							[fields.alturaSobreRasante, fields.mediaViviendasPorPlanta, fields.numAparcamientos, fields.numLocales, fields.numTrasteros, fields.numViviendas],
							[fields.anoConstruccion, fields.anoConstruccionReferencia, fields.anoRehabilitacion, fields.anoRehabilitacionReferencia],
							//inspeccion
							[{

								xtype: 'fieldset',
								border: true,
								title: this.inspeccionDatosEdificioTitleLabel,
								items: [{
									xtype: "At4Framework-rowContainer",
									minWidth: false,
									items: [fields.inspeccionDatosedificioNucleosescalerasTipoId, fields.inspeccionDatosedificioParcelaTipoId, fields.inspeccionDatosedificioUnnucleoescalerasTipoId, fields.inspeccionDatosedificioUsoTipoId]
								}]

							}],
							[{

								xtype: 'fieldset',
								border: true,
								title: this.plantasBajoRasanteTitleLabel,
								items: [{
									xtype: "At4Framework-rowContainer",
									minWidth: false,
									items: [fields.plantasBajoRasanteUsoPrincipal, fields.plantasBajoRasanteUsosSecundarios, fields.plantasBajoRasanteUsosSecundariosTipo]
								}]

							}],
							[{

								xtype: 'fieldset',
								border: true,
								title: this.plantasSobreRasanteTitleLabel,
								items: [{
									xtype: "At4Framework-rowContainer",
									minWidth: false,
									items: [fields.plantasSobreRasanteUsoPrincipal, fields.plantasSobreRasanteUsosSecundarios, fields.plantasSobreRasanteUsosSecundariosTipo]
								}]

							}],


						]),
					]
				}, {
					xtype: 'At4Framework-fieldmainpanel',
					title: this.superficiesTitleLabel,
					items: [
						At4FrameworkIntranet.FormDefaults.rows([
							//superficies
							[fields.totalAscensores, fields.totalEscaleras, fields.totalViviendasConAccesoVariosNucleos, fields.totalViviendasSinAccesoAscensor],
							[fields.usoTexto, fields.numero, fields.tipoVia, fields.via, fields.referenciaCatastral],
							[{
								xtype: 'fieldset',
								border: true,
								margin: "25 0 0 0",
								title: this.inspecciónIdentificacionesTitleLabel,
								items: At4FrameworkIntranet.FormDefaults.rows([
									[fields.superficieConstruida, fields.superficieMediaAparcamientos, fields.superficieMediaLocales, fields.superficieMediaTrasteros, fields.superficieMediaViviendas, fields.superficieParcela]
								])

							}],
						]),

					]
				}, {
					xtype: 'At4Framework-fieldmainpanel',
					title: this.edificioTitleLabel,
					items: [
						At4FrameworkIntranet.FormDefaults.rows([
							//edifico
							[fields.edificioCodigoPostal, fields.edificioComunTexto, fields.edificioNumeroManual, fields.edificioObjetoTexto],
							[fields.edificioPisoLetra, fields.edificioPoblacion, fields.edificioProvincia],
							[fields.edificioProvinciaId, fields.edificioRegimenTexto, fields.edificioTipoViaManual, fields.edificioViaManual],
							[fields.edificioObservaciones],
							[{
								xtype: 'fieldset',
								border: true,
								title: this.inspecciónIdentificacionesTitleLabel,
								items: [{
									xtype: "At4Framework-rowContainer",
									minWidth: false,
									items: [fields.edificioInspeccionIdentificacionedificioComunesTipoId, fields.edificioInspeccionIdentificacionedificioObjetoTipoId, fields.edificioInspeccionPropiedadRegimenTipoId]
								}]

							}],
						]),

					]
				}, {
					xtype: 'At4Framework-fieldmainpanel',
					title: this.tecnicoTitularRepresentanteTitleLabel,
					items: [
						At4FrameworkIntranet.FormDefaults.rows([
							//titular y representante
							[fields.tecnicoNif, fields.tecnicoTecnico, fields.tecnicoTitulacion],
							[fields.propiedadNif, fields.propiedadTitular],
							[{
								xtype: 'fieldset',
								border: true,
								title: this.representanteTitleLabel,
								items: At4FrameworkIntranet.FormDefaults.rows([
									[fields.representanteCodigoPostal, fields.representanteCondicion, fields.representanteDireccion, fields.representanteEmail, fields.representanteNif],
									[fields.representanteNombre, fields.representantePoblacion, fields.representanteProvincia, fields.representanteTelefonoFijo, fields.representanteTelefonoMovil]
								])

							}],

						]),


					]
				}, {
					xtype: 'At4Framework-fieldmainpanel',
					title: this.otrosDatosTitleLabel,
					items: [
						At4FrameworkIntranet.FormDefaults.rows([
							//otros datos
							//accesibilidad
							[{
								xtype: 'fieldset',
								border: true,
								title: this.accesibilidadTitleLabel,
								items: [{
									xtype: "At4Framework-rowContainer",
									minWidth: false,
									items: [fields.accesibilidadPublicosId, fields.accesibilidadValoracionFinalesId, fields.accesibilidadAjustesRazonablesId]
								}]
							}],

							//acustica
							[{
								xtype: 'fieldset',
								border: true,
								title: this.acusticaTitleLabel,
								items: [{
									xtype: "At4Framework-rowContainer",
									minWidth: false,
									items: [fields.acusticasId, fields.acusticaDatosGeneralesId, fields.acusticaValoracionFinalId, fields.acusticaComprobacionesId],
								}]
							}],
							[{
								xtype: 'fieldset',
								border: true,
								title: this.acusticaRuidoTitleLabel,
								items: [{
									xtype: "At4Framework-rowContainer",
									minWidth: false,
									items: [fields.acusticaRuidoInstalacionesId, fields.acusticaRuidosExterioresId, fields.acusticaRuidosInterioresHorizontalesId, fields.acusticaRuidosInterioresVerticalesId, fields.acusticaRuidosInterioresUnionesId]
								}]
							}],
							[this.openAcusticaMejorasAcusticas],
							[fields.cerramientosCubiertasId, fields.instalacionesId, fields.estructuraId],
							[fields.eficienciasEnergeticasId, fields.cimentacionesId, fields.conservacionId]
						]),

					]
				}, {
					xtype: 'At4Framework-fieldmainpanel',
					title: this.valoresSeleccionadosTitleLabel,
					items: [
						At4FrameworkIntranet.FormDefaults.rows([
							[fields.valores]
						])
					]
				}, fields.fechasVisitas, fields.valoracionesParciales, fields.documentacionOtros, fields.deficiencias, fields.historicos]
			},
			At4FrameworkIntranet.FormDefaults.rows([
				[At4FrameworkIntranet.FormDefaults.resumenAuditoria()]
			])
		];



		this.maxTabIndex = tabHelper.getNext();
		this.callParent([application, formName, gridMetaData, items, config]);
	}
});
/**
 * @class At4FrameworkIntranet.FechaVisitaSubForm
 * Contiene la configuración del subformulario: FechaVisita
 * @author  agarcia@at4.net
 * @constructor
 * @extends At4FrameworkIntranet.BasicSubForm
 * @param {Object} application La aplicación que contiene el formulario, normalmente será {@link At4FrameworkIntranet.app}
 * @param {Object} config Configuración para Ext.form.FormPanel
 */
Ext.define("At4FrameworkIntranet.FechaVisitaSubForm", {
	extend: "At4FrameworkIntranet.BasicSubForm",
	constructor: function (application, formName, gridMetaData, config) {
			Ext.apply(this, config);
			var tabHelper = new At4util.tabIndexHelper(this.tabIndex);
			this.subFormName = 'fechasVisitas';
			//TODO: Para extjs4 esto era antes this.getId()
			this.id = application.getId() + "-" + this.subFormName + "SubForm";
			this.columnDefaults = At4FrameworkIntranet.FormDefaults.COLUMN_DEFAULTS;
			this.fieldDefaults = At4FrameworkIntranet.FormDefaults.FIELD_DEFAULTS;

			var fields = {}

			fields.id = new Ext.form.NumberField({
				cls: 'tiny-text',
				name: 'id',
				fieldLabel: this.idHeaderLabel,
				tabIndex: tabHelper.getNext(),
				width: At4FrameworkIntranet.FormDefaults.size(3, 1, 7),
				disableUpdates: true,
				disabled: true,
				hideTrigger: true,
				allowBlank: false,
				allowDecimals: false,
				maxValue: 9223372036854775807
			})

			fields.fecha = new Ext.form.TextField({
				name: 'fecha',
				fieldLabel: this.fechaHeaderLabel,
				tabIndex: tabHelper.getNext(),
				width: At4FrameworkIntranet.FormDefaults.size(4, 1, 7),
				maxLength: 255
			})

			this.maxTabIndex = tabHelper.getNext();
			this.fields = fields;
			var items = [{
				xtype: 'At4Framework-fieldmainpanel',
				title: this.titleLabel,
				items: [
					At4FrameworkIntranet.FormDefaults.rows([
						[fields.id, fields.fecha],
						[At4FrameworkIntranet.FormDefaults.resumenAuditoria()]
					]),
				]
			}];



			this.callParent([application, items, config]);
		}

		/**
		 * Template para el panel
		 * TODO: en ext4, migrar a static
		 */
		//At4FrameworkIntranet.FechaVisitaSubForm.PANEL_TPL = new Ext.XTemplate(
		,
	statics: {
		PANEL_TPL: new Ext.XTemplate(
				'<table class="listadoPanel">',
				'<tbody>',
				'<tr>',

				'<th>{[this.getLabel("id")]}</th>',
				'<th>{[this.getLabel("fecha")]}</th>',
				'</tr>',
				'<tpl for=".">',
				'<tr class="filaListadoPanel">',

				'<td>{id}</td>',
				'<td>{fecha}</td>',
				'</tr>',
				'</tpl>',
				'</tbody>',
				'</table>', {
					getLabel: function (name) {
						return At4FrameworkIntranet.FormDefaults.getFieldLabel("FechaVisitaSubForm", name);
					}
				}
			)


			/**
			 * Record para el subform
			 * TODO: en ext4, migrar a static
			 */
			//At4FrameworkIntranet.FechaVisitaSubForm.RECORD = Ext.data.Record.create(
			,
		MODEL: Ext.define('At4FrameworkIntranet.InspeccionFechaVisitamodel', {
			extend: 'Ext.data.Model',
			idProperty: "oid",
			fields: [
				//Añadimos el campo de oid al registro (el campo oid es el "object identifier")
				{
					name: "oid",
					mapping: "id",
					type: "int"
				}

				, {
					name: "id",
					type: "int"
				}, {
					name: "fecha",
					type: "string"
				}
			]
		}),
		RECORD: 'At4FrameworkIntranet.InspeccionFechaVisitamodel'
	}

});

/**
 * @class At4FrameworkIntranet.ValoracionParcialSubForm
 * Contiene la configuración del subformulario: ValoracionParcial
 * @author  agarcia@at4.net
 * @constructor
 * @extends At4FrameworkIntranet.BasicSubForm
 * @param {Object} application La aplicación que contiene el formulario, normalmente será {@link At4FrameworkIntranet.app}
 * @param {Object} config Configuración para Ext.form.FormPanel
 */
Ext.define("At4FrameworkIntranet.ValoracionParcialSubForm", {
	extend: "At4FrameworkIntranet.BasicSubForm",
	constructor: function (application, formName, gridMetaData, config) {
			Ext.apply(this, config);
			var tabHelper = new At4util.tabIndexHelper(this.tabIndex);
			this.subFormName = 'valoracionesParciales';
			//TODO: Para extjs4 esto era antes this.getId()
			this.id = application.getId() + "-" + this.subFormName + "SubForm";
			this.columnDefaults = At4FrameworkIntranet.FormDefaults.COLUMN_DEFAULTS;
			this.fieldDefaults = At4FrameworkIntranet.FormDefaults.FIELD_DEFAULTS;

			var fields = {}

			fields.id = new Ext.form.NumberField({
				cls: 'tiny-text',
				name: 'id',
				fieldLabel: this.idHeaderLabel,
				tabIndex: tabHelper.getNext(),
				width: At4FrameworkIntranet.FormDefaults.size(2, 2, 10),
				disableUpdates: true,
				disabled: true,
				hideTrigger: true,
				allowBlank: false,
				allowDecimals: false,
				maxValue: 9223372036854775807
			})

			fields.conservacionSistemasconstructivosTipoId = new Ext.form.NumberField({
				cls: 'tiny-text',
				name: 'conservacionSistemasconstructivosTipoId',
				fieldLabel: this.conservacionSistemasconstructivosTipoIdHeaderLabel,
				labelAttrTpl: " data-qtip='" + this.conservacionSistemasconstructivosTipoIdDescriptionLabel + "'",
				tabIndex: tabHelper.getNext(),
				width: At4FrameworkIntranet.FormDefaults.size(4, 2, 10),
				allowDecimals: false,
				maxValue: 2147483647
			})
			fields.conservacionValoracionesTipoId = new Ext.form.NumberField({
				cls: 'tiny-text',
				name: 'conservacionValoracionesTipoId',
				fieldLabel: this.conservacionValoracionesTipoIdHeaderLabel,
				labelAttrTpl: " data-qtip='" + this.conservacionValoracionesTipoIdDescriptionLabel + "'",
				tabIndex: tabHelper.getNext(),
				width: At4FrameworkIntranet.FormDefaults.size(4, 2, 10),
				allowDecimals: false,
				maxValue: 2147483647
			})
			fields.plazoFinObras = new Ext.form.TextField({
				name: 'plazoFinObras',
				fieldLabel: this.plazoFinObrasHeaderLabel,
				tabIndex: tabHelper.getNext(),
				width: At4FrameworkIntranet.FormDefaults.size(5, 1, 10),
				maxLength: 255
			})
			fields.plazoInicioObras = new Ext.form.TextField({
				name: 'plazoInicioObras',
				fieldLabel: this.plazoInicioObrasHeaderLabel,
				tabIndex: tabHelper.getNext(),
				width: At4FrameworkIntranet.FormDefaults.size(5, 1, 10),
				maxLength: 255
			})

			this.maxTabIndex = tabHelper.getNext();
			this.fields = fields;
			var items = [{
				xtype: 'At4Framework-fieldmainpanel',
				title: this.titleLabel,
				items: [
					At4FrameworkIntranet.FormDefaults.rows([
						[fields.id, fields.conservacionSistemasconstructivosTipoId, fields.conservacionValoracionesTipoId],
						[fields.plazoFinObras, fields.plazoInicioObras],
						[At4FrameworkIntranet.FormDefaults.resumenAuditoria()]
					]),
				]
			}];



			this.callParent([application, items, config]);
		}

		/**
		 * Template para el panel
		 * TODO: en ext4, migrar a static
		 */
		//At4FrameworkIntranet.ValoracionParcialSubForm.PANEL_TPL = new Ext.XTemplate(
		,
	statics: {
		PANEL_TPL: new Ext.XTemplate(
				'<table class="listadoPanel">',
				'<tbody>',
				'<tr>',

				'<th>{[this.getLabel("id")]}</th>',
				'<th>{[this.getLabel("conservacionSistemasconstructivosTipoId")]}</th>',
				'<th>{[this.getLabel("conservacionValoracionesTipoId")]}</th>',
				'<th>{[this.getLabel("plazoFinObras")]}</th>',
				'<th>{[this.getLabel("plazoInicioObras")]}</th>',
				'</tr>',
				'<tpl for=".">',
				'<tr class="filaListadoPanel">',

				'<td>{id}</td>',
				'<td>{conservacionSistemasconstructivosTipoId}</td>',
				'<td>{conservacionValoracionesTipoId}</td>',
				'<td>{plazoFinObras}</td>',
				'<td>{plazoInicioObras}</td>',
				'</tr>',
				'</tpl>',
				'</tbody>',
				'</table>', {
					getLabel: function (name) {
						return At4FrameworkIntranet.FormDefaults.getFieldLabel("ValoracionParcialSubForm", name);
					}
				}
			)


			/**
			 * Record para el subform
			 * TODO: en ext4, migrar a static
			 */
			//At4FrameworkIntranet.ValoracionParcialSubForm.RECORD = Ext.data.Record.create(
			,
		MODEL: Ext.define('At4FrameworkIntranet.InspeccionValoracionParcialmodel', {
			extend: 'Ext.data.Model',
			idProperty: "oid",
			fields: [
				//Añadimos el campo de oid al registro (el campo oid es el "object identifier")
				{
					name: "oid",
					mapping: "id",
					type: "int"
				}

				, {
					name: "id",
					type: "int"
				}, {
					name: "conservacionSistemasconstructivosTipoId",
					type: "int"
				}, {
					name: "conservacionValoracionesTipoId",
					type: "int"
				}, {
					name: "plazoFinObras",
					type: "string"
				}, {
					name: "plazoInicioObras",
					type: "string"
				}
			]
		}),
		RECORD: 'At4FrameworkIntranet.InspeccionValoracionParcialmodel'
	}

});

/**
 * @class At4FrameworkIntranet.DocumentacionOtroSubForm
 * Contiene la configuración del subformulario: DocumentacionOtro
 * @author  agarcia@at4.net
 * @constructor
 * @extends At4FrameworkIntranet.BasicSubForm
 * @param {Object} application La aplicación que contiene el formulario, normalmente será {@link At4FrameworkIntranet.app}
 * @param {Object} config Configuración para Ext.form.FormPanel
 */
Ext.define("At4FrameworkIntranet.DocumentacionOtroSubForm", {
	extend: "At4FrameworkIntranet.BasicSubForm",
	constructor: function (application, formName, gridMetaData, config) {
			Ext.apply(this, config);
			var tabHelper = new At4util.tabIndexHelper(this.tabIndex);
			this.subFormName = 'documentacionOtros';
			//TODO: Para extjs4 esto era antes this.getId()
			this.id = application.getId() + "-" + this.subFormName + "SubForm";
			this.columnDefaults = At4FrameworkIntranet.FormDefaults.COLUMN_DEFAULTS;
			this.fieldDefaults = At4FrameworkIntranet.FormDefaults.FIELD_DEFAULTS;

			var fields = {}

			fields.id = new Ext.form.NumberField({
				cls: 'tiny-text',
				name: 'id',
				fieldLabel: this.idHeaderLabel,
				tabIndex: tabHelper.getNext(),
				width: At4FrameworkIntranet.FormDefaults.size(2, 1, 10),
				disableUpdates: true,
				disabled: true,
				hideTrigger: true,
				allowBlank: false,
				allowDecimals: false,
				maxValue: 9223372036854775807
			})

			fields.texto = new Ext.form.TextField({
				name: 'texto',
				fieldLabel: this.textoHeaderLabel,
				tabIndex: tabHelper.getNext(),
				width: At4FrameworkIntranet.FormDefaults.size(8, 1, 10),
				maxLength: 255
			})

			this.maxTabIndex = tabHelper.getNext();
			this.fields = fields;
			var items = [{
				xtype: 'At4Framework-fieldmainpanel',
				title: this.titleLabel,
				items: [
					At4FrameworkIntranet.FormDefaults.rows([
						[fields.id, fields.texto],
						[At4FrameworkIntranet.FormDefaults.resumenAuditoria()]
					]),
				]
			}];



			this.callParent([application, items, config]);
		}

		/**
		 * Template para el panel
		 * TODO: en ext4, migrar a static
		 */
		//At4FrameworkIntranet.DocumentacionOtroSubForm.PANEL_TPL = new Ext.XTemplate(
		,
	statics: {
		PANEL_TPL: new Ext.XTemplate(
				'<table class="listadoPanel">',
				'<tbody>',
				'<tr>',

				'<th>{[this.getLabel("id")]}</th>',
				'<th>{[this.getLabel("texto")]}</th>',
				'</tr>',
				'<tpl for=".">',
				'<tr class="filaListadoPanel">',

				'<td>{id}</td>',
				'<td>{texto}</td>',
				'</tr>',
				'</tpl>',
				'</tbody>',
				'</table>', {
					getLabel: function (name) {
						return At4FrameworkIntranet.FormDefaults.getFieldLabel("DocumentacionOtroSubForm", name);
					}
				}
			)


			/**
			 * Record para el subform
			 * TODO: en ext4, migrar a static
			 */
			//At4FrameworkIntranet.DocumentacionOtroSubForm.RECORD = Ext.data.Record.create(
			,
		MODEL: Ext.define('At4FrameworkIntranet.InspeccionDocumentacionOtromodel', {
			extend: 'Ext.data.Model',
			idProperty: "oid",
			fields: [
				//Añadimos el campo de oid al registro (el campo oid es el "object identifier")
				{
					name: "oid",
					mapping: "id",
					type: "int"
				}

				, {
					name: "id",
					type: "int"
				}, {
					name: "texto",
					type: "string"
				}
			]
		}),
		RECORD: 'At4FrameworkIntranet.InspeccionDocumentacionOtromodel'
	}

});

/**
 * @class At4FrameworkIntranet.DeficienciaSubForm
 * Contiene la configuración del subformulario: Deficiencia
 * @author  agarcia@at4.net
 * @constructor
 * @extends At4FrameworkIntranet.BasicSubForm
 * @param {Object} application La aplicación que contiene el formulario, normalmente será {@link At4FrameworkIntranet.app}
 * @param {Object} config Configuración para Ext.form.FormPanel
 */
Ext.define("At4FrameworkIntranet.DeficienciaSubForm", {
	extend: "At4FrameworkIntranet.BasicSubForm",
	constructor: function (application, formName, gridMetaData, config) {
			Ext.apply(this, config);
			var tabHelper = new At4util.tabIndexHelper(this.tabIndex);
			this.subFormName = 'deficiencias';
			//TODO: Para extjs4 esto era antes this.getId()
			this.id = application.getId() + "-" + this.subFormName + "SubForm";
			this.columnDefaults = At4FrameworkIntranet.FormDefaults.COLUMN_DEFAULTS;
			this.fieldDefaults = At4FrameworkIntranet.FormDefaults.FIELD_DEFAULTS;

			var fields = {}

			fields.id = new Ext.form.NumberField({
				cls: 'tiny-text',
				name: 'id',
				fieldLabel: this.idHeaderLabel,
				tabIndex: tabHelper.getNext(),
				width: At4FrameworkIntranet.FormDefaults.size(2, 2, 10),
				disableUpdates: true,
				disabled: true,
				hideTrigger: true,
				allowBlank: false,
				allowDecimals: false,
				maxValue: 9223372036854775807
			})
			fields.deficienciaTipo = new At4FrameworkIntranet.ComboBox({
				name: 'deficienciaTipoId',
				fieldLabel: this.deficienciaTipoHeaderLabel,
				tabIndex: tabHelper.getNext(),
				width: At4FrameworkIntranet.FormDefaults.size(3, 2, 10),
				allowBlank: false,
				store: At4FrameworkIntranet.FormDefaults.getStore('DeficienciaTipo'),
				recordPK: 'id',
				relatedForm: 'deficienciatipo'
			})

			fields.conservacionSistemasconstructivosTipoId = new Ext.form.NumberField({
				cls: 'tiny-text',
				name: 'conservacionSistemasconstructivosTipoId',
				fieldLabel: this.conservacionSistemasconstructivosTipoIdHeaderLabel,
				labelAttrTpl: " data-qtip='" + this.conservacionSistemasconstructivosTipoIdDescriptionLabel + "'",
				tabIndex: tabHelper.getNext(),
				width: At4FrameworkIntranet.FormDefaults.size(5, 2, 10),
				allowDecimals: false,
				maxValue: 2147483647
			})
			fields.descripcionDeficiencia = new Ext.form.TextField({
				name: 'descripcionDeficiencia',
				fieldLabel: this.descripcionDeficienciaHeaderLabel,
				tabIndex: tabHelper.getNext(),
				width: At4FrameworkIntranet.FormDefaults.size(3, 2, 10),
				maxLength: 255
			})
			fields.esGrave = new Ext.form.NumberField({
				cls: 'tiny-text',
				name: 'esGrave',
				fieldLabel: this.esGraveHeaderLabel,
				tabIndex: tabHelper.getNext(),
				width: At4FrameworkIntranet.FormDefaults.size(3, 2, 10),
				allowDecimals: false,
				maxValue: 2147483647
			})
			fields.localizacionDeficiencia = new Ext.form.TextField({
				name: 'localizacionDeficiencia',
				fieldLabel: this.localizacionDeficienciaHeaderLabel,
				tabIndex: tabHelper.getNext(),
				width: At4FrameworkIntranet.FormDefaults.size(4, 2, 10),
				maxLength: 255
			})
			fields.nombreDeficiencia = new Ext.form.TextField({
				name: 'nombreDeficiencia',
				fieldLabel: this.nombreDeficienciaHeaderLabel,
				tabIndex: tabHelper.getNext(),
				width: At4FrameworkIntranet.FormDefaults.size(5, 1, 10),
				maxLength: 255
			})
			fields.pruebasEnsayosRealizados = new Ext.form.TextField({
				name: 'pruebasEnsayosRealizados',
				fieldLabel: this.pruebasEnsayosRealizadosHeaderLabel,
				tabIndex: tabHelper.getNext(),
				width: At4FrameworkIntranet.FormDefaults.size(5, 1, 10),
				maxLength: 255
			})
			fields.observaciones = new Ext.form.TextArea({
				name: 'observaciones',
				fieldLabel: this.observacionesHeaderLabel,
				tabIndex: tabHelper.getNext(),
				width: At4FrameworkIntranet.FormDefaults.size(10, 0, 10),
				maxLength: 255
			})

			this.maxTabIndex = tabHelper.getNext();
			this.fields = fields;
			var items = [{
				xtype: 'At4Framework-fieldmainpanel',
				items: [
					At4FrameworkIntranet.FormDefaults.rows([
						[fields.id, fields.deficienciaTipo, fields.conservacionSistemasconstructivosTipoId],
						[fields.descripcionDeficiencia, fields.esGrave, fields.localizacionDeficiencia],
						[fields.nombreDeficiencia, fields.pruebasEnsayosRealizados],
						[fields.observaciones],
						[At4FrameworkIntranet.FormDefaults.resumenAuditoria()]
					]),
				]
			}];



			this.callParent([application, items, config]);
		}

		/**
		 * Template para el panel
		 * TODO: en ext4, migrar a static
		 */
		//At4FrameworkIntranet.DeficienciaSubForm.PANEL_TPL = new Ext.XTemplate(
		,
	statics: {
		PANEL_TPL: new Ext.XTemplate(
				'<table class="listadoPanel">',
				'<tbody>',
				'<tr>',

				'<th>{[this.getLabel("id")]}</th>',
				'<th>{[this.getLabel("deficienciaTipo")]}</th>',
				'<th>{[this.getLabel("conservacionSistemasconstructivosTipoId")]}</th>',
				'<th>{[this.getLabel("descripcionDeficiencia")]}</th>',
				'<th>{[this.getLabel("esGrave")]}</th>',
				'<th>{[this.getLabel("localizacionDeficiencia")]}</th>',
				'<th>{[this.getLabel("nombreDeficiencia")]}</th>',
				'<th>{[this.getLabel("observaciones")]}</th>',
				'<th>{[this.getLabel("pruebasEnsayosRealizados")]}</th>',
				'</tr>',
				'<tpl for=".">',
				'<tr class="filaListadoPanel">',

				'<td>{id}</td>',
				'<td>{deficienciaTipoLabel}</td>',
				'<td>{conservacionSistemasconstructivosTipoId}</td>',
				'<td>{descripcionDeficiencia}</td>',
				'<td>{esGrave}</td>',
				'<td>{localizacionDeficiencia}</td>',
				'<td>{nombreDeficiencia}</td>',
				'<td>{observaciones}</td>',
				'<td>{pruebasEnsayosRealizados}</td>',
				'</tr>',
				'</tpl>',
				'</tbody>',
				'</table>', {
					getLabel: function (name) {
						return At4FrameworkIntranet.FormDefaults.getFieldLabel("DeficienciaSubForm", name);
					}
				}
			)


			/**
			 * Record para el subform
			 * TODO: en ext4, migrar a static
			 */
			//At4FrameworkIntranet.DeficienciaSubForm.RECORD = Ext.data.Record.create(
			,
		MODEL: Ext.define('At4FrameworkIntranet.InspeccionDeficienciamodel', {
			extend: 'Ext.data.Model',
			idProperty: "oid",
			fields: [
				//Añadimos el campo de oid al registro (el campo oid es el "object identifier")
				{
					name: "oid",
					mapping: "id",
					type: "int"
				}

				, {
					name: "id",
					type: "int"
				}, {
					name: "deficienciaTipoId",
					type: "int"
				}, {
					name: "deficienciaTipoLabel",
					type: "auto"
				}, {
					name: "deficienciaTipo",
					mapping: "deficienciaTipoLabel",
					type: "auto"
				}, {
					name: "conservacionSistemasconstructivosTipoId",
					type: "int"
				}, {
					name: "descripcionDeficiencia",
					type: "string"
				}, {
					name: "esGrave",
					type: "int"
				}, {
					name: "localizacionDeficiencia",
					type: "string"
				}, {
					name: "nombreDeficiencia",
					type: "string"
				}, {
					name: "observaciones",
					type: "string"
				}, {
					name: "pruebasEnsayosRealizados",
					type: "string"
				}
			]
		}),
		RECORD: 'At4FrameworkIntranet.InspeccionDeficienciamodel'
	}

});

/**
 * @class At4FrameworkIntranet.HistoricoSubForm
 * Contiene la configuración del subformulario: Historico
 * @author  agarcia@at4.net
 * @constructor
 * @extends At4FrameworkIntranet.BasicSubForm
 * @param {Object} application La aplicación que contiene el formulario, normalmente será {@link At4FrameworkIntranet.app}
 * @param {Object} config Configuración para Ext.form.FormPanel
 */
Ext.define("At4FrameworkIntranet.HistoricoSubForm", {
	extend: "At4FrameworkIntranet.BasicSubForm",
	constructor: function (application, formName, gridMetaData, config) {
			Ext.apply(this, config);
			var tabHelper = new At4util.tabIndexHelper(this.tabIndex);
			this.subFormName = 'historicos';
			//TODO: Para extjs4 esto era antes this.getId()
			this.id = application.getId() + "-" + this.subFormName + "SubForm";
			this.columnDefaults = At4FrameworkIntranet.FormDefaults.COLUMN_DEFAULTS;
			this.fieldDefaults = At4FrameworkIntranet.FormDefaults.FIELD_DEFAULTS;

			var fields = {}

			fields.id = new Ext.form.NumberField({
				cls: 'tiny-text',
				name: 'id',
				fieldLabel: this.idHeaderLabel,
				tabIndex: tabHelper.getNext(),
				width: At4FrameworkIntranet.FormDefaults.size(2, 2, 10),
				disableUpdates: true,
				disabled: true,
				hideTrigger: true,
				allowBlank: false,
				allowDecimals: false,
				maxValue: 9223372036854775807
			})

			fields.fechaInspeccion = new Ext.form.TextField({
				name: 'fechaInspeccion',
				fieldLabel: this.fechaInspeccionHeaderLabel,
				tabIndex: tabHelper.getNext(),
				width: At4FrameworkIntranet.FormDefaults.size(4, 2, 10),
				maxLength: 255
			})
			fields.gradoEjecucionEfectividadObras = new Ext.form.TextField({
				name: 'gradoEjecucionEfectividadObras',
				fieldLabel: this.gradoEjecucionEfectividadObrasHeaderLabel,
				labelAttrTpl: " data-qtip='" + this.gradoEjecucionEfectividadObrasDescriptionLabel + "'",
				tabIndex: tabHelper.getNext(),
				width: At4FrameworkIntranet.FormDefaults.size(4, 2, 10),
				maxLength: 255
			})
			fields.resultado = new Ext.form.TextField({
				name: 'resultado',
				fieldLabel: this.resultadoHeaderLabel,
				tabIndex: tabHelper.getNext(),
				width: At4FrameworkIntranet.FormDefaults.size(5, 1, 10),
				maxLength: 255
			})
			fields.tecnico = new Ext.form.TextField({
				name: 'tecnico',
				fieldLabel: this.tecnicoHeaderLabel,
				tabIndex: tabHelper.getNext(),
				width: At4FrameworkIntranet.FormDefaults.size(5, 1, 10),
				maxLength: 255
			})
			fields.observaciones = new Ext.form.TextArea({
				name: 'observaciones',
				fieldLabel: this.observacionesHeaderLabel,
				tabIndex: tabHelper.getNext(),
				width: At4FrameworkIntranet.FormDefaults.size(10, 0, 10),
				maxLength: 255
			})

			this.maxTabIndex = tabHelper.getNext();
			this.fields = fields;
			var items = [{
				xtype: 'At4Framework-fieldmainpanel',
				items: [
					At4FrameworkIntranet.FormDefaults.rows([
						[fields.id, fields.fechaInspeccion, fields.gradoEjecucionEfectividadObras],
						[fields.resultado, fields.tecnico],
						[fields.observaciones],
						[At4FrameworkIntranet.FormDefaults.resumenAuditoria()]
					])
				]
			}];



			this.callParent([application, items, config]);
		}

		/**
		 * Template para el panel
		 * TODO: en ext4, migrar a static
		 */
		//At4FrameworkIntranet.HistoricoSubForm.PANEL_TPL = new Ext.XTemplate(
		,
	statics: {
		PANEL_TPL: new Ext.XTemplate(
				'<table class="listadoPanel">',
				'<tbody>',
				'<tr>',

				'<th>{[this.getLabel("id")]}</th>',
				'<th>{[this.getLabel("fechaInspeccion")]}</th>',
				'<th>{[this.getLabel("gradoEjecucionEfectividadObras")]}</th>',
				'<th>{[this.getLabel("observaciones")]}</th>',
				'<th>{[this.getLabel("resultado")]}</th>',
				'<th>{[this.getLabel("tecnico")]}</th>',
				'</tr>',
				'<tpl for=".">',
				'<tr class="filaListadoPanel">',

				'<td>{id}</td>',
				'<td>{fechaInspeccion}</td>',
				'<td>{gradoEjecucionEfectividadObras}</td>',
				'<td>{observaciones}</td>',
				'<td>{resultado}</td>',
				'<td>{tecnico}</td>',
				'</tr>',
				'</tpl>',
				'</tbody>',
				'</table>', {
					getLabel: function (name) {
						return At4FrameworkIntranet.FormDefaults.getFieldLabel("HistoricoSubForm", name);
					}
				}
			)


			/**
			 * Record para el subform
			 * TODO: en ext4, migrar a static
			 */
			//At4FrameworkIntranet.HistoricoSubForm.RECORD = Ext.data.Record.create(
			,
		MODEL: Ext.define('At4FrameworkIntranet.InspeccionHistoricomodel', {
			extend: 'Ext.data.Model',
			idProperty: "oid",
			fields: [
				//Añadimos el campo de oid al registro (el campo oid es el "object identifier")
				{
					name: "oid",
					mapping: "id",
					type: "int"
				}

				, {
					name: "id",
					type: "int"
				}, {
					name: "fechaInspeccion",
					type: "string"
				}, {
					name: "gradoEjecucionEfectividadObras",
					type: "string"
				}, {
					name: "observaciones",
					type: "string"
				}, {
					name: "resultado",
					type: "string"
				}, {
					name: "tecnico",
					type: "string"
				}
			]
		}),
		RECORD: 'At4FrameworkIntranet.InspeccionHistoricomodel'
	}

});
//Namespace de  At4FrameworkIntranet
Ext.namespace('At4FrameworkIntranet');

/**
 * @class At4FrameworkIntranet.InstalacionesForm
 * Contiene la configuración del formulario: Instalaciones
 * @author garrom
 * @constructor
 * @extends At4FrameworkIntranet.BasicForm
 * @param {Object} application La aplicación que contiene el formulario, normalmente será {@link At4FrameworkIntranet.app}
 * @param {String} formName Nombre del formulario
 * @param {Object} gridMetaData Configuración gridMetadata
 * @param {Object} config Configuración para Ext.form.FormPanel
 */

Ext.define("At4FrameworkIntranet.InstalacionesForm", {
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
		var acsTieneStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'acsTiene') {
				acsTieneStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var acsTieneStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: acsTieneStoreValues
		});

		fields.acsTiene = Ext.create('Ext.form.ComboBox', {
			name: 'acsTiene',
			fieldLabel: this.acsTieneHeaderLabel,
			tabIndex: tabHelper.getNext(),
			labelStyle: 'white-space: nowrap',
			margin: "0, 70, 0, 20",
			width: At4FrameworkIntranet.FormDefaults.size(1, 3, 12),
			store: acsTieneStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})
		var acsCentralTieneStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'acsCentralTiene') {
				acsCentralTieneStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var acsCentralTieneStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: acsCentralTieneStoreValues
		});

		fields.acsCentralTiene = Ext.create('Ext.form.ComboBox', {
			name: 'acsCentralTiene',
			fieldLabel: this.acsCentralTieneHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.acsCentralTieneDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			labelStyle: 'white-space: nowrap',
			margin: "0, 70, 0, 20",
			width: At4FrameworkIntranet.FormDefaults.size(1, 3, 12),
			store: acsCentralTieneStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		fields.acsCaptadoressolares = new Ext.form.NumberField({
			name: 'acsCaptadoressolares',
			fieldLabel: this.acsCaptadoressolaresHeaderLabel,
			tabIndex: tabHelper.getNext(),
			labelStyle: 'white-space: nowrap',
			width: At4FrameworkIntranet.FormDefaults.size(3, 3, 12),
			allowDecimals: false,
			maxValue: 2147483647
		})

		fields.instalacionesAcsnocentralgascanalizados = new Ext.form.TextField({
			name: 'instalacionesAcsnocentralgascanalizados',
			fieldLabel: this.instalacionesAcsnocentralgascanalizadosHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.instalacionesAcsnocentralgascanalizadosDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(6, 1, 12),
			maxLength: 255
		})
		fields.instalacionesAcsnocentralgasembotellados = new Ext.form.TextField({
			name: 'instalacionesAcsnocentralgasembotellados',
			fieldLabel: this.instalacionesAcsnocentralgasembotelladosHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.instalacionesAcsnocentralgasembotelladosDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(6, 1, 12),
			maxLength: 255
		})
		fields.acsNocentralGascanalizadoporcentaje = new Ext.form.TextField({
			name: 'acsNocentralGascanalizadoporcentaje',
			cls: "little-text",
			fieldLabel: this.acsNocentralGascanalizadoporcentajeHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.acsNocentralGascanalizadoporcentajeDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(6, 1, 12),
			maxLength: 255
		})
		fields.acsNocentralGasembotelladoporcentaje = new Ext.form.TextField({
			name: 'acsNocentralGasembotelladoporcentaje',
			cls: "little-text",
			fieldLabel: this.acsNocentralGasembotelladoporcentajeHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.acsNocentralGasembotelladoporcentajeDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(6, 1, 12),
			maxLength: 255
		})
		fields.acsNocentralCalentadoreselectricosporcentaje = new Ext.form.TextField({
			name: 'acsNocentralCalentadoreselectricosporcentaje',
			cls: "little-text",
			fieldLabel: this.acsNocentralCalentadoreselectricosporcentajeHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.acsNocentralCalentadoreselectricosporcentajeDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(6, 1, 12),
			maxLength: 255
		})
		fields.acsNocentralIndividualporcentaje = new Ext.form.TextField({
			name: 'acsNocentralIndividualporcentaje',
			cls: "little-text",
			fieldLabel: this.acsNocentralIndividualporcentajeHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.acsNocentralIndividualporcentajeDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(6, 1, 12),
			maxLength: 255
		})
		fields.acsNocentralOtrosporcentaje = new Ext.form.TextField({
			name: 'acsNocentralOtrosporcentaje',
			cls: "little-text",
			fieldLabel: this.acsNocentralOtrosporcentajeHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(6, 1, 12),
			maxLength: 255
		})


		fields.acsCentralCombustibleTexto = new Ext.form.TextField({
			name: 'acsCentralCombustibleTexto',
			fieldLabel: this.acsCentralCombustibleTextoHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(12, 0, 12),
			maxLength: 255
		})







		var calefaccionTieneStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'calefaccionTiene') {
				calefaccionTieneStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var calefaccionTieneStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: calefaccionTieneStoreValues
		});

		fields.calefaccionTiene = Ext.create('Ext.form.ComboBox', {
			name: 'calefaccionTiene',
			fieldLabel: this.calefaccionTieneHeaderLabel,
			tabIndex: tabHelper.getNext(),
			labelStyle: 'white-space: nowrap',
			margin: "0, 50, 0, 20",
			width: At4FrameworkIntranet.FormDefaults.size(1, 2, 10),
			store: calefaccionTieneStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})
		var calefaccionCentralTieneStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'calefaccionCentralTiene') {
				calefaccionCentralTieneStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var calefaccionCentralTieneStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: calefaccionCentralTieneStoreValues
		});

		fields.calefaccionCentralTiene = Ext.create('Ext.form.ComboBox', {
			name: 'calefaccionCentralTiene',
			fieldLabel: this.calefaccionCentralTieneHeaderLabel,
			tabIndex: tabHelper.getNext(),
			labelStyle: 'white-space: nowrap',
			margin: "0, 50, 0, 20",
			width: At4FrameworkIntranet.FormDefaults.size(1, 2, 10),
			store: calefaccionCentralTieneStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})
		fields.calefaccionCentralTexto = new Ext.form.TextField({
			name: 'calefaccionCentralTexto',
			fieldLabel: this.calefaccionCentralTextoHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(12, 0, 12),
			maxLength: 255
		})
		fields.calefaccionNocentralIndividualporcentaje = new Ext.form.TextField({
			name: 'calefaccionNocentralIndividualporcentaje',
			fieldLabel: this.calefaccionNocentralIndividualporcentajeHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.calefaccionNocentralIndividualporcentajeDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			cls: "little-text",
			width: At4FrameworkIntranet.FormDefaults.size(6, 1, 12),
			maxLength: 255
		})
		fields.calefaccionNocentralCalefaccionelectricaporcentaje = new Ext.form.TextField({
			name: 'calefaccionNocentralCalefaccionelectricaporcentaje',
			fieldLabel: this.calefaccionNocentralCalefaccionelectricaporcentajeHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.calefaccionNocentralCalefaccionelectricaporcentajeDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			cls: "little-text",
			width: At4FrameworkIntranet.FormDefaults.size(6, 1, 12),
			maxLength: 255
		})
		fields.calefaccionNocentralCalderagasoleoporcentaje = new Ext.form.TextField({
			name: 'calefaccionNocentralCalderagasoleoporcentaje',
			fieldLabel: this.calefaccionNocentralCalderagasoleoporcentajeHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.calefaccionNocentralCalderagasoleoporcentajeDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			cls: "little-text",
			width: At4FrameworkIntranet.FormDefaults.size(6, 1, 12),
			maxLength: 255
		})
		fields.calefaccionNocentralGascanalizadoporcentaje = new Ext.form.TextField({
			name: 'calefaccionNocentralGascanalizadoporcentaje',
			fieldLabel: this.calefaccionNocentralGascanalizadoporcentajeHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.calefaccionNocentralGascanalizadoporcentajeDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			cls: "little-text",
			width: At4FrameworkIntranet.FormDefaults.size(6, 1, 12),
			maxLength: 255
		})
		fields.calefaccionNocentralOtrosporcentaje = new Ext.form.TextField({
			name: 'calefaccionNocentralOtrosporcentaje',
			fieldLabel: this.calefaccionNocentralOtrosporcentajeHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.calefaccionNocentralOtrosporcentajeDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			cls: "little-text",
			width: At4FrameworkIntranet.FormDefaults.size(6, 1, 12),
			maxLength: 255
		})
		fields.calefaccionCentralCombustibleTexto = new Ext.form.TextField({
			name: 'calefaccionCentralCombustibleTexto',
			fieldLabel: this.calefaccionCentralCombustibleTextoHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.calefaccionCentralCombustibleTextoDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(12, 0, 12),
			maxLength: 255
		})

		fields.instalacionesCalefaccionnocentralcalefaccionelectricas = new Ext.form.TextField({
			name: 'instalacionesCalefaccionnocentralcalefaccionelectricas',
			fieldLabel: this.instalacionesCalefaccionnocentralcalefaccionelectricasHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.instalacionesCalefaccionnocentralcalefaccionelectricasDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(6, 1, 12),
			maxLength: 255
		})
		fields.instalacionesCalefaccionnocentralgascanalizados = new Ext.form.TextField({
			name: 'instalacionesCalefaccionnocentralgascanalizados',
			fieldLabel: this.instalacionesCalefaccionnocentralgascanalizadosHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.instalacionesCalefaccionnocentralgascanalizadosDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(6, 1, 12),
			maxLength: 255
		})
		fields.observaciones = new Ext.form.TextArea({
			name: 'observaciones',
			fieldLabel: this.observacionesHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(12, 0, 12),
			maxLength: 255
		})
		var refrigeracionTieneStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'refrigeracionTiene') {
				refrigeracionTieneStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var refrigeracionTieneStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: refrigeracionTieneStoreValues
		});

		fields.refrigeracionTiene = Ext.create('Ext.form.ComboBox', {
			name: 'refrigeracionTiene',
			fieldLabel: this.refrigeracionTieneHeaderLabel,
			tabIndex: tabHelper.getNext(),
			labelStyle: 'white-space: nowrap',
			width: At4FrameworkIntranet.FormDefaults.size(1, 3, 12),
			store: refrigeracionTieneStore,
			queryMode: 'local',

			margin: "0, 70, 0, 20",
			valueField: 'ID',
			displayField: 'DISPLAY',
		})
		var refrigeracionColectivoTieneStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'refrigeracionColectivoTiene') {
				refrigeracionColectivoTieneStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var refrigeracionColectivoTieneStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: refrigeracionColectivoTieneStoreValues
		});

		fields.refrigeracionColectivoTiene = Ext.create('Ext.form.ComboBox', {
			name: 'refrigeracionColectivoTiene',
			fieldLabel: this.refrigeracionColectivoTieneHeaderLabel,
			tabIndex: tabHelper.getNext(),
			labelStyle: 'white-space: nowrap',
			width: At4FrameworkIntranet.FormDefaults.size(1, 3, 12),
			store: refrigeracionColectivoTieneStore,
			queryMode: 'local',

			margin: "0, 70, 0, 20",
			valueField: 'ID',
			displayField: 'DISPLAY',
		})




		fields.refrigeracionNocolectivoAparatosenfachadas = new Ext.form.TextField({
			name: 'refrigeracionNocolectivoAparatosenfachadas',
			fieldLabel: this.refrigeracionNocolectivoAparatosenfachadasHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.refrigeracionNocolectivoAparatosenfachadasDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(6, 1, 12),
			maxLength: 255
		})
		fields.refrigeracionNocolectivoIndividualporcentaje = new Ext.form.TextField({
			name: 'refrigeracionNocolectivoIndividualporcentaje',
			fieldLabel: this.refrigeracionNocolectivoIndividualporcentajeHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.refrigeracionNocolectivoIndividualporcentajeDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(6, 1, 12),
			maxLength: 255
		})

		var ventilacionTieneStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'ventilacionTiene') {
				ventilacionTieneStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var ventilacionTieneStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: ventilacionTieneStoreValues
		});

		fields.ventilacionTiene = Ext.create('Ext.form.ComboBox', {
			name: 'ventilacionTiene',
			fieldLabel: this.ventilacionTieneHeaderLabel,
			tabIndex: tabHelper.getNext(),
			labelStyle: 'white-space: nowrap',
			width: At4FrameworkIntranet.FormDefaults.size(1, 2, 12),
			store: ventilacionTieneStore,
			queryMode: 'local',
			valueField: 'ID',
			margin: "0, 70, 0, 20",
			labelStyle: 'white-space: nowrap',
			displayField: 'DISPLAY',
		})
		var ventilacionCuartoshumedosSinventilacionStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'ventilacionCuartoshumedosSinventilacion') {
				ventilacionCuartoshumedosSinventilacionStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var ventilacionCuartoshumedosSinventilacionStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: ventilacionCuartoshumedosSinventilacionStoreValues
		});

		fields.ventilacionCuartoshumedosSinventilacion = Ext.create('Ext.form.ComboBox', {
			name: 'ventilacionCuartoshumedosSinventilacion',
			fieldLabel: this.ventilacionCuartoshumedosSinventilacionHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.ventilacionCuartoshumedosSinventilacionDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			labelStyle: 'white-space: nowrap',
			width: At4FrameworkIntranet.FormDefaults.size(1, 2, 12),
			store: ventilacionCuartoshumedosSinventilacionStore,
			queryMode: 'local',
			valueField: 'ID',
			labelStyle: 'white-space: nowrap',
			margin: "0, 70, 0, 20",
			displayField: 'DISPLAY',
		})
		fields.ventilacionCuartoshumedosTexto = new Ext.form.TextField({
			name: 'ventilacionCuartoshumedosTexto',
			fieldLabel: this.ventilacionCuartoshumedosTextoHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.ventilacionCuartoshumedosTextoDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(12, 0, 12),
			maxLength: 255
		})
		var contraincendiosTieneStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'contraincendiosTiene') {
				contraincendiosTieneStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var contraincendiosTieneStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: contraincendiosTieneStoreValues
		});

		fields.contraincendiosTiene = Ext.create('Ext.form.ComboBox', {
			name: 'contraincendiosTiene',
			fieldLabel: this.contraincendiosTieneHeaderLabel,
			tabIndex: tabHelper.getNext(),
			labelStyle: 'white-space: nowrap',
			width: At4FrameworkIntranet.FormDefaults.size(1, 0, 1),
			store: contraincendiosTieneStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})





		var contrarayoTieneStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'contrarayoTiene') {
				contrarayoTieneStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var contrarayoTieneStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: contrarayoTieneStoreValues
		});

		fields.contrarayoTiene = Ext.create('Ext.form.ComboBox', {
			name: 'contrarayoTiene',
			fieldLabel: this.contrarayoTieneHeaderLabel,
			tabIndex: tabHelper.getNext(),
			labelStyle: 'white-space: nowrap',
			width: At4FrameworkIntranet.FormDefaults.size(1, 2, 10),
			store: contrarayoTieneStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		fields.contrarayoTexto = new Ext.form.TextField({
			name: 'contrarayoTexto',
			fieldLabel: this.contrarayoTextoHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(12, 0, 12),
			maxLength: 255
		})
		var comunicacionesictTieneStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'comunicacionesictTiene') {
				comunicacionesictTieneStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var comunicacionesictTieneStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: comunicacionesictTieneStoreValues
		});

		fields.comunicacionesictTiene = Ext.create('Ext.form.ComboBox', {
			name: 'comunicacionesictTiene',
			fieldLabel: this.comunicacionesictTieneHeaderLabel,
			tabIndex: tabHelper.getNext(),
			labelStyle: 'white-space: nowrap',
			width: At4FrameworkIntranet.FormDefaults.size(1, 1, 12),
			store: comunicacionesictTieneStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})
		fields.comunicacionesictTexto = new Ext.form.TextField({
			name: 'comunicacionesictTexto',
			fieldLabel: this.comunicacionesictTextoHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(12, 0, 12),
			maxLength: 255
		})

		fields.electricaTexto = new Ext.form.TextField({
			name: 'electricaTexto',
			fieldLabel: this.electricaTextoHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(12, 0, 12),
			maxLength: 255
		})
		fields.saneamientoBajantesTexto = new Ext.form.TextField({
			name: 'saneamientoBajantesTexto',
			fieldLabel: this.saneamientoBajantesTextoHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(6, 1, 12),
			maxLength: 255
		})
		fields.saneamientoColectoresTexto = new Ext.form.TextField({
			name: 'saneamientoColectoresTexto',
			fieldLabel: this.saneamientoColectoresTextoHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(6, 1, 12),
			maxLength: 255
		})

		var gascanalizadoTieneStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'gascanalizadoTiene') {
				gascanalizadoTieneStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var gascanalizadoTieneStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: gascanalizadoTieneStoreValues
		});

		fields.gascanalizadoTiene = Ext.create('Ext.form.ComboBox', {
			name: 'gascanalizadoTiene',
			fieldLabel: this.gascanalizadoTieneHeaderLabel,
			tabIndex: tabHelper.getNext(),
			labelStyle: 'white-space: nowrap',
			width: At4FrameworkIntranet.FormDefaults.size(1, 2, 10),
			store: gascanalizadoTieneStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		fields.gascanalizadoPorcentaje = new Ext.form.TextField({
			name: 'gascanalizadoPorcentaje',
			fieldLabel: this.gascanalizadoPorcentajeHeaderLabel,
			tabIndex: tabHelper.getNext(),
			cls: "little-text",
			width: At4FrameworkIntranet.FormDefaults.size(6, 0, 6),
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
					title: this.acsCalefaccionInstalacionesTitleLabel,
					items: [
						At4FrameworkIntranet.FormDefaults.rows([
							[{

								xtype: 'fieldset',
								border: true,
								title: "Agua caliente sanitaria ACS",
								items: [{
									xtype: "At4Framework-rowContainer",
									minWidth: false,
									items: [fields.acsTiene, fields.acsCentralTiene, fields.acsCaptadoressolares]

								}, {
									xtype: "At4Framework-rowContainer",
									minWidth: false,
									items: [fields.instalacionesAcsnocentralgascanalizados, fields.instalacionesAcsnocentralgasembotellados]

								}, {
									xtype: "At4Framework-rowContainer",
									minWidth: false,
									items: [fields.acsNocentralGascanalizadoporcentaje, fields.acsNocentralGasembotelladoporcentaje]

								}, {
									xtype: "At4Framework-rowContainer",
									minWidth: false,
									items: [fields.acsNocentralCalentadoreselectricosporcentaje, fields.acsNocentralIndividualporcentaje]

								}, {
									xtype: "At4Framework-rowContainer",
									minWidth: false,
									items: [fields.acsNocentralOtrosporcentaje]

								}, {
									xtype: "At4Framework-rowContainer",
									minWidth: false,
									items: [fields.acsCentralCombustibleTexto]
								}]

							}],
							[{

								xtype: 'fieldset',
								border: true,
								title: this.calefaccionTitleLabel,
								items: [{
									xtype: "At4Framework-rowContainer",
									minWidth: false,
									items: [fields.calefaccionTiene, fields.calefaccionCentralTiene]

								}, {
									xtype: "At4Framework-rowContainer",
									minWidth: false,
									items: [fields.calefaccionCentralTexto]

								}, {
									xtype: "At4Framework-rowContainer",
									minWidth: false,
									items: [fields.calefaccionNocentralIndividualporcentaje, fields.calefaccionNocentralCalefaccionelectricaporcentaje]

								}, {
									xtype: "At4Framework-rowContainer",
									minWidth: false,
									items: [fields.calefaccionNocentralCalderagasoleoporcentaje, fields.calefaccionNocentralGascanalizadoporcentaje]

								}, {
									xtype: "At4Framework-rowContainer",
									minWidth: false,
									items: [fields.calefaccionNocentralOtrosporcentaje]

								}, {
									xtype: "At4Framework-rowContainer",
									minWidth: false,
									items: [fields.calefaccionCentralCombustibleTexto],

								}, {
									xtype: "At4Framework-rowContainer",
									minWidth: false,
									items: [fields.instalacionesCalefaccionnocentralcalefaccionelectricas, fields.instalacionesCalefaccionnocentralgascanalizados]

								}]

							}],
							[fields.observaciones]

						]),
					]
				}, {
					xtype: 'At4Framework-fieldmainpanel',
					title: this.refrigeracionVentilacionOtrosTitleLabel,
					items: [
						At4FrameworkIntranet.FormDefaults.rows([
							[{

								xtype: 'fieldset',
								border: true,
								title: this.refrigeracionTitleLabel,
								items: [{
									xtype: "At4Framework-rowContainer",
									minWidth: false,
									items: At4FrameworkIntranet.FormDefaults.rows([
										[fields.refrigeracionTiene, fields.refrigeracionColectivoTiene],
										[fields.refrigeracionNocolectivoAparatosenfachadas, fields.refrigeracionNocolectivoIndividualporcentaje]
									])

								}],

							}],
							[{

								xtype: 'fieldset',
								border: true,
								title: this.ventilacionRenovacionAireTitleLabel,
								items: [{
									xtype: "At4Framework-rowContainer",
									minWidth: false,
									items: At4FrameworkIntranet.FormDefaults.rows([
										[fields.ventilacionTiene, fields.ventilacionCuartoshumedosSinventilacion],
										[fields.ventilacionCuartoshumedosTexto]
									])

								}]

							}],
							[fields.contraincendiosTiene],
							[fields.contrarayoTiene],
							[fields.contrarayoTexto],

							[fields.comunicacionesictTiene],
							[fields.comunicacionesictTexto],
							[fields.electricaTexto],
							[fields.saneamientoBajantesTexto, fields.saneamientoColectoresTexto],
							[fields.gascanalizadoTiene],
							[fields.gascanalizadoPorcentaje]

						]),
					]
				}]
			},
			At4FrameworkIntranet.FormDefaults.rows([
				[At4FrameworkIntranet.FormDefaults.resumenAuditoria()]
			])
		];
		/*var items = [
			At4FrameworkIntranet.FormDefaults.rows([
				[fields.claveInforme, fields.edificio, fields.inspeccionId]
			]), {
				xtype: 'At4Framework-formtabpanel',
				id: 'panelTabs-' + this.id,
				items: [{
					xtype: 'At4Framework-fieldmainpanel',
					title: "Acs, Calefacción e Instalaciones",
					items: [
						At4FrameworkIntranet.FormDefaults.rows([
							[{

								xtype: 'fieldset',
								border: true,
								title: "ACS",
								items: [{
									xtype: "At4Framework-rowContainer",
									minWidth: false,
									items: [fields.acsCaptadoressolares,fields.acsTiene,  fields.acsCentralTiene]

								}, {
									xtype: "At4Framework-rowContainer",
									minWidth: false,
									items: [fields.acsNocentralIndividualporcentaje, fields.acsCentralCombustibleTexto, fields.acsNocentralGasembotelladoporcentaje, fields.acsNocentralGascanalizadoporcentaje, fields.acsNocentralCalentadoreselectricosporcentaje]

								}, {
									xtype: "At4Framework-rowContainer",
									minWidth: false,
									items: [fields.acsNocentralOtrosporcentaje]

								}]

							}],
							[{

								xtype: 'fieldset',
								border: true,
								title: "Calefacción",
								items: [{
									xtype: "At4Framework-rowContainer",
									minWidth: false,
									items: [fields.calefaccionCentralCombustibleTexto, fields.calefaccionCentralTexto, fields.calefaccionCentralTiene]

								}, {
									xtype: "At4Framework-rowContainer",
									minWidth: false,
									items: [fields.calefaccionNocentralIndividualporcentaje, fields.calefaccionNocentralOtrosporcentaje, fields.calefaccionNocentralCalefaccionelectricaporcentaje]

								}, {
									xtype: "At4Framework-rowContainer",
									minWidth: false,
									items: [fields.calefaccionNocentralCalderagasoleoporcentaje, fields.calefaccionNocentralGascanalizadoporcentaje, fields.calefaccionTiene]

								}]

							}],
							[{

								xtype: 'fieldset',
								border: true,
								title: "Instalaciones",
								items: [{
									xtype: "At4Framework-rowContainer",
									minWidth: false,
									items: [fields.instalacionesAcsnocentralgascanalizados, fields.instalacionesAcsnocentralgasembotellados]

								}, {
									xtype: "At4Framework-rowContainer",
									minWidth: false,
									items: [fields.instalacionesCalefaccionnocentralcalefaccionelectricas, fields.instalacionesCalefaccionnocentralgascanalizados]

								}, {
									xtype: "At4Framework-rowContainer",
									minWidth: false,
									items: [fields.observaciones]

								}]

							}]
						]),
					]
				}, {
					xtype: 'At4Framework-fieldmainpanel',
					title: "Refrigeración y Otros",
					items: [
						At4FrameworkIntranet.FormDefaults.rows([
							[{

								xtype: 'fieldset',
								border: true,
								title: "Refrigeración",
								items: [{
									xtype: "At4Framework-rowContainer",
									minWidth: false,
									items: [fields.refrigeracionColectivoTiene, fields.refrigeracionNocolectivoAparatosenfachadas, fields.refrigeracionNocolectivoIndividualporcentaje, fields.refrigeracionTiene]

								}]

							}],
							[{

								xtype: 'fieldset',
								border: true,
								title: "Ventilación",
								items: [{
									xtype: "At4Framework-rowContainer",
									minWidth: false,
									items: [fields.ventilacionCuartoshumedosSinventilacion, fields.ventilacionCuartoshumedosTexto, fields.ventilacionTiene]

								}]

							}],
							[fields.comunicacionesictTexto, fields.comunicacionesictTiene], [fields.contraincendiosTiene],
							[fields.contrarayoTexto, fields.contrarayoTiene, fields.electricaTexto],
							[fields.saneamientoBajantesTexto, fields.gascanalizadoTiene, fields.saneamientoColectoresTexto],
							[fields.gascanalizadoPorcentaje]

						]),
					]
				}]
			},
			At4FrameworkIntranet.FormDefaults.rows([
				[At4FrameworkIntranet.FormDefaults.resumenAuditoria()]
			])
		];*/
		/*var items = [
			At4FrameworkIntranet.FormDefaults.rows([
				[fields.claveInforme, fields.edificio, fields.inspeccionId]
			]), {
				xtype: 'At4Framework-formtabpanel',
				id: 'panelTabs-' + this.id,
				items: [{
					xtype: 'At4Framework-fieldmainpanel',
					title: "Acs, Calefacción e Instalaciones",
					items: [
						At4FrameworkIntranet.FormDefaults.rows([
							[fields.acsCaptadoressolares, fields.acsTiene, fields.acsCentralTiene, fields.calefaccionTiene, fields.calefaccionCentralTiene],
							[fields.acsCentralCombustibleTexto],
							[fields.calefaccionCentralCombustibleTexto],

							[fields.acsNocentralIndividualporcentaje, fields.acsNocentralGascanalizadoporcentaje, fields.acsNocentralGasembotelladoporcentaje],
							[fields.acsNocentralCalentadoreselectricosporcentaje, fields.acsNocentralOtrosporcentaje],

							[fields.calefaccionCentralTexto],

							[fields.calefaccionNocentralIndividualporcentaje,fields.calefaccionNocentralCalefaccionelectricaporcentaje],
							[fields.calefaccionNocentralCalderagasoleoporcentaje, fields.calefaccionNocentralGascanalizadoporcentaje],
							[fields.calefaccionNocentralOtrosporcentaje],
							[fields.instalacionesAcsnocentralgascanalizados, fields.instalacionesAcsnocentralgasembotellados],
							[fields.instalacionesCalefaccionnocentralcalefaccionelectricas, fields.instalacionesCalefaccionnocentralgascanalizados],
							[fields.observaciones]


						])
					]
				}, {
					xtype: 'At4Framework-fieldmainpanel',
					title: "Refrigeración y Otros",
					items: [
						At4FrameworkIntranet.FormDefaults.rows([

							[fields.refrigeracionTiene, fields.refrigeracionColectivoTiene, ]
							[, fields.refrigeracionNocolectivoAparatosenfachadas, fields.refrigeracionNocolectivoIndividualporcentaje, ],
							[fields.ventilacionCuartoshumedosSinventilacion, fields.ventilacionCuartoshumedosTexto, fields.ventilacionTiene],
							[fields.comunicacionesictTexto, fields.comunicacionesictTiene],
							[fields.contraincendiosTiene],
							[fields.contrarayoTexto, fields.contrarayoTiene, fields.electricaTexto],
							[fields.saneamientoBajantesTexto, fields.gascanalizadoTiene, fields.saneamientoColectoresTexto],
							[fields.gascanalizadoPorcentaje]
						])
					]
				}]
			}

		];*/


		this.maxTabIndex = tabHelper.getNext();
		this.callParent([application, formName, gridMetaData, items, config]);
	}
});
/*var items = [
{
			xtype: 'At4Framework-fieldmainpanel'
			,items: [
    At4FrameworkIntranet.FormDefaults.rows([
        ,

        ,

        ,





        ,

        ,
        [At4FrameworkIntranet.FormDefaults.resumenAuditoria()]
        ])
 ]
}
];



		this.maxTabIndex = tabHelper.getNext();
		this.callParent([application, formName, gridMetaData, items, config]);
	}
});
*/

//Namespace de  At4FrameworkIntranet
Ext.namespace('At4FrameworkIntranet');

/**
 * @class At4FrameworkIntranet.IslaForm
 * Contiene la configuración del formulario: Isla
 * @author garrom
 * @constructor
 * @extends At4FrameworkIntranet.BasicForm
 * @param {Object} application La aplicación que contiene el formulario, normalmente será {@link At4FrameworkIntranet.app}
 * @param {String} formName Nombre del formulario
 * @param {Object} gridMetaData Configuración gridMetadata
 * @param {Object} config Configuración para Ext.form.FormPanel
 */
 
 Ext.define("At4FrameworkIntranet.IslaForm",{
 	extend: "At4FrameworkIntranet.BasicForm",
	constructor: function(application, formName, gridMetaData, config){
    	Ext.apply(this, config);
		var tabHelper = new At4util.tabIndexHelper(this.tabIndex);

		var columnDefaults = At4FrameworkIntranet.FormDefaults.COLUMN_DEFAULTS;
		var fieldDefaults = At4FrameworkIntranet.FormDefaults.FIELD_DEFAULTS;


    var fields = {}

    fields.id = new Ext.form.NumberField({
        name: 'id',
        fieldLabel: this.idHeaderLabel,
        tabIndex: tabHelper.getNext(),
        width: At4FrameworkIntranet.FormDefaults.size(2, 1, 8),
        disableUpdates: true,
        allowBlank: false,
        allowDecimals: false,
        maxValue: 2147483647
    })
    fields.nombre = new Ext.form.TextField({
        name: 'nombre',
        fieldLabel: this.nombreHeaderLabel,
        tabIndex: tabHelper.getNext(),
        allowBlank: false,
        width: At4FrameworkIntranet.FormDefaults.size(6, 1, 8),
        maxLength: 255
    })

this.fields = fields;
var items = [
{
			xtype: 'At4Framework-fieldmainpanel'
			,items: [ 
            At4FrameworkIntranet.FormDefaults.rows([
                    [fields.id, fields.nombre],
                    [At4FrameworkIntranet.FormDefaults.resumenAuditoria()]])
            ]
}
];
 

		
		this.maxTabIndex = tabHelper.getNext();
		this.callParent([application, formName, gridMetaData, items, config]);
	}
});

//Namespace de  At4FrameworkIntranet
Ext.namespace('At4FrameworkIntranet');

/**
 * @class At4FrameworkIntranet.MunicipioForm
 * Contiene la configuración del formulario: Municipio
 * @author garrom
 * @constructor
 * @extends At4FrameworkIntranet.BasicForm
 * @param {Object} application La aplicación que contiene el formulario, normalmente será {@link At4FrameworkIntranet.app}
 * @param {String} formName Nombre del formulario
 * @param {Object} gridMetaData Configuración gridMetadata
 * @param {Object} config Configuración para Ext.form.FormPanel
 */

 Ext.define("At4FrameworkIntranet.MunicipioForm",{
 	extend: "At4FrameworkIntranet.BasicForm",
	constructor: function(application, formName, gridMetaData, config){
    	Ext.apply(this, config);
		var tabHelper = new At4util.tabIndexHelper(this.tabIndex);

		var columnDefaults = At4FrameworkIntranet.FormDefaults.COLUMN_DEFAULTS;
		var fieldDefaults = At4FrameworkIntranet.FormDefaults.FIELD_DEFAULTS;


    var fields = {}

    fields.clave = new Ext.form.NumberField({
        name: 'clave',
        fieldLabel: this.claveHeaderLabel,
        tabIndex: tabHelper.getNext(),
        width: At4FrameworkIntranet.FormDefaults.size(1, 3, 12),
        disableUpdates: true,
        disabled: true,
        hideTrigger: true,
        allowBlank: false,
        allowDecimals: false,
        maxValue: 2147483647
    })

    if(GwcAccess.municipio){
        fields.isla = new At4FrameworkIntranet.RelatedBox({
            name: 'islaId',
            fieldLabel: this.islaHeaderLabel,
            labelAttrTpl: " data-qtip='" + this.islaDescriptionLabel + "'",
            tabIndex: tabHelper.getNext(),
            width: At4FrameworkIntranet.FormDefaults.size(5, 3, 12),
            relatedIconCls: "glyphicons glyphicons-globe",
            relatedForm: 'isla'
        })
    }else{
        fields.isla = new At4FrameworkIntranet.ComboBox({
            name: 'islaId',
            fieldLabel: this.islaHeaderLabel,
            labelAttrTpl: " data-qtip='" + this.islaDescriptionLabel + "'",
            tabIndex: tabHelper.getNext(),
            allowBlank: false,
            width: At4FrameworkIntranet.FormDefaults.size(5, 3, 12),
            store: At4FrameworkIntranet.FormDefaults.getStore('Isla'),
            recordPK: 'id',
            relatedIconCls: "glyphicons glyphicons-globe",
            relatedForm: 'isla'
        })
    }


    fields.codigoIne = new Ext.form.NumberField({
        name: 'codigoIne',
        fieldLabel: this.codigoIneHeaderLabel,
        tabIndex: tabHelper.getNext(),
        disableUpdates: true,
        disabled: true,
        allowBlank: false,
        allowDecimals: false,
        width: At4FrameworkIntranet.FormDefaults.size(3, 3, 12),
        maxValue: 2147483647
    })
    fields.codigoCatastro = new Ext.form.NumberField({
        name: 'codigoCatastro',
        fieldLabel: this.codigoCatastroHeaderLabel,
        tabIndex: tabHelper.getNext(),
        disableUpdates: true,
        disabled: true,
        allowBlank: false,
        allowDecimals: false,
        width: At4FrameworkIntranet.FormDefaults.size(3, 3, 12),
        maxValue: 2147483647
    })


    fields.nombre = new Ext.form.TextField({
        name: 'nombre',
        fieldLabel: this.nombreHeaderLabel,
        tabIndex: tabHelper.getNext(),
        allowBlank: false,
        disabled: GwcAccess.municipio,
        width: At4FrameworkIntranet.FormDefaults.size(5, 1, 12),
        maxLength: 255
    })
    fields.url = new Ext.form.TextField({
        name: 'url',
        fieldLabel: this.urlHeaderLabel,
        tabIndex: tabHelper.getNext(),
        width: At4FrameworkIntranet.FormDefaults.size(7, 1, 12),
        maxLength: 255
    })


    fields.organismoContacto = new Ext.form.TextArea({
        name: 'organismoContacto',
        fieldLabel: this.organismoContactoHeaderLabel,
        tabIndex: tabHelper.getNext(),
        width: At4FrameworkIntranet.FormDefaults.size(12,0,12),
        maxLength: 255
    })


    fields.direccion = new Ext.form.TextField({
        name: 'direccion',
        fieldLabel: this.direccionHeaderLabel,
        tabIndex: tabHelper.getNext(),
        width: At4FrameworkIntranet.FormDefaults.size(4, 2, 12),
        maxLength: 255
    })
    fields.telefono = new Ext.form.TextField({
        name: 'telefono',
        fieldLabel: this.telefonoHeaderLabel,
        tabIndex: tabHelper.getNext(),
        width: At4FrameworkIntranet.FormDefaults.size(4, 2, 12),
        maxLength: 12
    })
    fields.email = new Ext.form.TextField({
        name: 'email',
        fieldLabel: this.emailHeaderLabel,
        vtype: "email",
        tabIndex: tabHelper.getNext(),
        width: At4FrameworkIntranet.FormDefaults.size(4, 2, 12),
        maxLength: 255
    })
this.fields = fields;


        var items = [
            {
                xtype: 'At4Framework-fieldmainpanel',
                items: [
                    At4FrameworkIntranet.FormDefaults.rows(
                        [
                            [fields.clave, fields.isla, fields.codigoIne, fields.codigoCatastro],
                            [fields.nombre, fields.url],
                            [fields.organismoContacto],
                            [fields.direccion, fields.telefono, fields.email],
                            At4FrameworkIntranet.FormDefaults.resumenAuditoria()
                        ]
                    )
                ]
            }
        ];



		this.maxTabIndex = tabHelper.getNext();
		this.callParent([application, formName, gridMetaData, items, config]);
	}
});

//Namespace de  At4FrameworkIntranet
Ext.namespace('At4FrameworkIntranet');

/**
 * @class At4FrameworkIntranet.TipoViaForm
 * Contiene la configuración del formulario: TipoVia
 * @author garrom
 * @constructor
 * @extends At4FrameworkIntranet.BasicForm
 * @param {Object} application La aplicación que contiene el formulario, normalmente será {@link At4FrameworkIntranet.app}
 * @param {String} formName Nombre del formulario
 * @param {Object} gridMetaData Configuración gridMetadata
 * @param {Object} config Configuración para Ext.form.FormPanel
 */
 
 Ext.define("At4FrameworkIntranet.TipoViaForm",{
 	extend: "At4FrameworkIntranet.BasicForm",
   constructor: function(application, formName, gridMetaData, config){
       Ext.apply(this, config);
       var tabHelper = new At4util.tabIndexHelper(this.tabIndex);

       var columnDefaults = At4FrameworkIntranet.FormDefaults.COLUMN_DEFAULTS;
       var fieldDefaults = At4FrameworkIntranet.FormDefaults.FIELD_DEFAULTS;


       var fields = {}

       fields.clave = new Ext.form.NumberField({
        name: 'clave',
        fieldLabel: this.claveHeaderLabel,
        tabIndex: tabHelper.getNext(),
        width: At4FrameworkIntranet.FormDefaults.size(2, 2, 10),
        disableUpdates: true,
        disabled: true,
        hideTrigger: true,
        allowBlank: false,
        allowDecimals: false,
        maxValue: 2147483647
    })
       fields.codigoCatastro = new Ext.form.TextField({
        name: 'codigoCatastro',
        fieldLabel: this.codigoCatastroHeaderLabel,
        tabIndex: tabHelper.getNext(),
        width: At4FrameworkIntranet.FormDefaults.size(2, 2, 10),
        disableUpdates: true,
        disabled: true,
        maxLength: 2
    })
       fields.nombre = new At4FrameworkIntranet.MultilangText({
         name: 'nombre',
         fieldLabel: this.nombreEsHeaderLabel,
         tabIndex: tabHelper.getNext(),
         allowBlank: false,
         width: At4FrameworkIntranet.FormDefaults.size(6, 2, 10),
         maxLength: 64
     }

     )


       this.fields = fields;
       var items = [
       {
         xtype: 'At4Framework-fieldmainpanel'
         ,items: [ 
         At4FrameworkIntranet.FormDefaults.rows([
            [fields.clave, fields.codigoCatastro, fields.nombre],
            [At4FrameworkIntranet.FormDefaults.resumenAuditoria()]])

         ]
     }
    ];



    this.maxTabIndex = tabHelper.getNext();
    this.callParent([application, formName, gridMetaData, items, config]);
}
});
//Namespace de  At4FrameworkIntranet
Ext.namespace('At4FrameworkIntranet');

/**
 * @class At4FrameworkIntranet.UsuarioForm
 * Contiene la configuración del formulario: Usuario
 * @author garrom
 * @constructor
 * @extends At4FrameworkIntranet.BasicForm
 * @param {Object} application La aplicación que contiene el formulario, normalmente será {@link At4FrameworkIntranet.app}
 * @param {String} formName Nombre del formulario
 * @param {Object} gridMetaData Configuración gridMetadata
 * @param {Object} config Configuración para Ext.form.FormPanel
 */

Ext.define("At4FrameworkIntranet.UsuarioForm", {
	extend: "At4FrameworkIntranet.BasicForm",
	constructor: function (application, formName, gridMetaData, config) {
		Ext.apply(this, config);
		var tabHelper = new At4util.tabIndexHelper(this.tabIndex);

		var columnDefaults = At4FrameworkIntranet.FormDefaults.COLUMN_DEFAULTS;
		var fieldDefaults = At4FrameworkIntranet.FormDefaults.FIELD_DEFAULTS;


		var fields = {}

		fields.clave = new Ext.form.NumberField({
			name: 'clave',
			fieldLabel: this.claveHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 2, 12),
			disableUpdates: true,
			disabled: true,
			hideTrigger: true,
			allowBlank: false,
			allowDecimals: false,
			maxValue: 2147483647
		})
		fields.municipio = new At4FrameworkIntranet.ComboBox({
			name: 'municipioId',
			fieldLabel: this.municipioHeaderLabel,
			tabIndex: tabHelper.getNext(),
			store: At4FrameworkIntranet.FormDefaults.getStore('Municipio'),
			recordPK: 'clave',
			relatedForm: 'municipio',
			width: At4FrameworkIntranet.FormDefaults.size(5, 2, 12)
		})
		fields.username = new Ext.form.TextField({
			name: 'username',
			fieldLabel: this.usernameHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.usernameDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			allowBlank: false,
			width: At4FrameworkIntranet.FormDefaults.size(5, 2, 12),
			maxLength: 16
		})
		fields.nombre = new Ext.form.TextField({
			name: 'nombre',
			fieldLabel: this.nombreHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.nombreDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(4, 2, 12),
			maxLength: 50
		})
		fields.apellidos = new Ext.form.TextField({
				name: 'apellidos',
				fieldLabel: this.apellidosHeaderLabel,
				labelAttrTpl: " data-qtip='" + this.apellidosDescriptionLabel + "'",
				tabIndex: tabHelper.getNext(),
				width: At4FrameworkIntranet.FormDefaults.size(4, 2, 12),
				maxLength: 255
			})
			/*fields.idioma = new Ext.form.TextField({
			    name: 'idioma',
			    fieldLabel: this.idiomaHeaderLabel,
			    labelAttrTpl: " data-qtip='" + this.idiomaDescriptionLabel + "'",
			    tabIndex: tabHelper.getNext(),
			    width: At4FrameworkIntranet.FormDefaults.size(4, 2, 12),
			    maxLength: 2
			})*/

		this.fields = fields;
		var items = [{
			xtype: 'At4Framework-fieldmainpanel',
			items: [
				At4FrameworkIntranet.FormDefaults.rows([
					[fields.clave, fields.municipio, fields.username],
					[fields.nombre, fields.apellidos /*, fields.idioma*/ ],
					[At4FrameworkIntranet.FormDefaults.resumenAuditoria()]
				])
			]
		}];



		this.maxTabIndex = tabHelper.getNext();
		this.callParent([application, formName, gridMetaData, items, config]);
	}
});
//Namespace de  At4FrameworkIntranet
Ext.namespace('At4FrameworkIntranet');

/**
 * @class At4FrameworkIntranet.ViaForm
 * Contiene la configuración del formulario: Via
 * @author garrom
 * @constructor
 * @extends At4FrameworkIntranet.BasicForm
 * @param {Object} application La aplicación que contiene el formulario, normalmente será {@link At4FrameworkIntranet.app}
 * @param {String} formName Nombre del formulario
 * @param {Object} gridMetaData Configuración gridMetadata
 * @param {Object} config Configuración para Ext.form.FormPanel
 */

Ext.define("At4FrameworkIntranet.ViaForm", {
	extend: "At4FrameworkIntranet.BasicForm",
	constructor: function (application, formName, gridMetaData, config) {
		Ext.apply(this, config);
		var tabHelper = new At4util.tabIndexHelper(this.tabIndex);

		var columnDefaults = At4FrameworkIntranet.FormDefaults.COLUMN_DEFAULTS;
		var fieldDefaults = At4FrameworkIntranet.FormDefaults.FIELD_DEFAULTS;


		var fields = {}

		fields.clave = new Ext.form.NumberField({
			name: 'clave',
			fieldLabel: this.claveHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 2, 12),
			disableUpdates: true,
			disabled: true,
			hideTrigger: true,
			allowBlank: false,
			allowDecimals: false,
			maxValue: 2147483647
		})
		//fields.tipoVia = new At4FrameworkIntranet.ComboBox({
		fields.tipoVia = new At4FrameworkIntranet.RelatedBox({
			name: 'tipoViaId',
			fieldLabel: this.tipoViaHeaderLabel,
			tabIndex: tabHelper.getNext(),
			//disableUpdates: true,
			//disabled: true,
			allowBlank: false,
			//store: At4FrameworkIntranet.FormDefaults.getStore('TipoVia'),
			recordPK: 'clave',
			relatedIconCls: "glyphicons glyphicons-transport",
			relatedForm: 'tipovia',
			width: At4FrameworkIntranet.FormDefaults.size(4, 2, 12)
		})
		fields.nombre = new Ext.form.TextField({
			name: 'nombre',
			fieldLabel: this.nombreHeaderLabel,
			tabIndex: tabHelper.getNext(),
			allowBlank: false,
			maxLength: 255,
			width: At4FrameworkIntranet.FormDefaults.size(6, 2, 12)
		})
		//fields.municipio = new At4FrameworkIntranet.ComboBox({
		fields.municipio = new At4FrameworkIntranet.RelatedBox({
			name: 'municipioId',
			fieldLabel: this.municipioHeaderLabel,
			tabIndex: tabHelper.getNext(),
			//disableUpdates: true,
			//disabled: true,
			allowBlank: false,
			//store: At4FrameworkIntranet.FormDefaults.getStore('Municipio'),
			recordPK: 'clave',
			relatedIconCls: "glyphicons glyphicons-map",
			relatedForm: 'municipio',
			width: At4FrameworkIntranet.FormDefaults.size(4, 1, 10)
		})
		fields.codigoCatastro = new Ext.form.NumberField({
			name: 'codigoCatastro',
			fieldLabel: this.codigoCatastroHeaderLabel,
			tabIndex: tabHelper.getNext(),
			disableUpdates: true,
			disabled: true,
			allowBlank: false,
			allowDecimals: false,
			maxValue: 2147483647,
			width: At4FrameworkIntranet.FormDefaults.size(4, 1, 10)
		})

		this.fields = fields;
		var items = [{
			xtype: 'At4Framework-fieldmainpanel',
			items: [
				At4FrameworkIntranet.FormDefaults.rows(
					[
						[fields.clave, fields.tipoVia, fields.nombre],
						[fields.municipio, fields.codigoCatastro],
						[At4FrameworkIntranet.FormDefaults.resumenAuditoria()]
					]
				)
			]
		}];



		this.maxTabIndex = tabHelper.getNext();
		this.callParent([application, formName, gridMetaData, items, config]);
	}
});
