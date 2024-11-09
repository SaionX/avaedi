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
