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
