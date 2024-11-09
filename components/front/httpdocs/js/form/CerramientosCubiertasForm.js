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
