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
