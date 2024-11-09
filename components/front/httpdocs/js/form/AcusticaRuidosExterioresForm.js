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
