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

		fields.ieeArxiu = new Ext.form.NumberField({
			name: 'ieeArxiu',
			visibility: false
		})
		fields.subsana = new Ext.form.TextField({
			name: 'subsana',
			visibility: false
		})

		var tipus = Ext.create('Ext.data.Store', {
			fields: ['abbr', 'name'],
			data : [
				{"abbr":"T30", "name":"IEE 30"},
				{"abbr":"T40", "name":"Renov. IEE 30"},
				{"abbr":"T50", "name":"IEE 50"},
				{"abbr":"T50R", "name":"Renov. IEE 50"}
			]
		});
		fields.tipusIee = new Ext.form.ComboBox({
			allowBlank: false,
			xtype: "combobox",
			store: tipus,
			queryMode: 'local',
			displayField: 'name',
			valueField: 'abbr',
			autoSelect: true,
			disableUpdates: fechaInformeDisbled,
			disabled: fechaInformeDisbled,
			// editable: false,
			forceSelection: true,
			allowBlank: false,
			name: "tipusIee",
			fieldLabel: "Tipo IEE (30 o 50 años)",
			width: At4FrameworkIntranet.FormDefaults.size(3, 1, 6),
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
		})

		this.fields = fields;
		var items = [{
				xtype: 'At4Framework-fieldmainpanel',
				items: [
					At4FrameworkIntranet.FormDefaults.rows([
						[fields.clave, fields.estadoInforme, fields.edificio, fields.municipio, fields.inspeccionId],
						[fields.fechaInforme, fields.fechaAlta, fields.tipusIee, fields.arxiuIee]
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

		this.listeners = {
			afterload: {
				fn: function (clave, record) {
					// console.log(arguments);
					var data = record.data;
					if (data.clave) {
						var ieeArxiu = data.ieeArxiu;
						var subsana = data.subsana;
						if (!ieeArxiu) {
							this.ieeArxiuPanel.hide();
							if (subsana === true) {
								this.pdfArxiuPanel.setTitle(this.pdfArxiuSubsanaLabel);
							} else {
								this.pdfArxiuPanel.setTitle(this.pdfArxiuIteLabel);
							}
						}
						fields.tipusIee.setValue(data.tipusIeeCodi);
						// console.log(fields.tipusIee.getValue());
					}
				},
				scope: this
			}
		}
		this.maxTabIndex = tabHelper.getNext();
		this.callParent([application, formName, gridMetaData, items, config]);
	}
});
