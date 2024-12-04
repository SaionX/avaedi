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
			// '<th>{[this.getLabel("tipusIee)]}</th>',
			'<th>Tipo Iee</th>',
			'<th>Subsana</th>',
			'<th>{[this.getLabel("fechaInforme")]}</th>',
			'<th>{[this.getLabel("fechaAlta")]}</th>',
			'</tr>',
			'<tpl for=".">',
			'<tr class="filaListadoPanel">',

			'<td>{clave}</td>',
			'<td>{estadoInformeLabel}</td>',
			'<td>{tipusIeeLabel}</td>',
			'<td>{[this.renderSubsana(values.subsana)]}</td>',
			'<td>{fechaInforme:date("d/m/Y H:i")}</td>',
			'<td>{fechaAlta:date("d/m/Y H:i")}</td>',
			'</tr>',
			'</tpl>',
			'</tbody>',
			'</table>', {
				getLabel: function (name) {
					return At4FrameworkIntranet.FormDefaults.getFieldLabel("InformeSubForm", name);
				},
				renderSubsana: function(subsana) {
					return subsana ? "SI" : "NO";
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
