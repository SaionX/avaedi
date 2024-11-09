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
