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
