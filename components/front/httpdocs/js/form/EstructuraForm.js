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
