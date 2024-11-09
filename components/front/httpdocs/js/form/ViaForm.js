//Namespace de  At4FrameworkIntranet
Ext.namespace('At4FrameworkIntranet');

/**
 * @class At4FrameworkIntranet.ViaForm
 * Contiene la configuración del formulario: Via
 * @author garrom
 * @constructor
 * @extends At4FrameworkIntranet.BasicForm
 * @param {Object} application La aplicación que contiene el formulario, normalmente será {@link At4FrameworkIntranet.app}
 * @param {String} formName Nombre del formulario
 * @param {Object} gridMetaData Configuración gridMetadata
 * @param {Object} config Configuración para Ext.form.FormPanel
 */

Ext.define("At4FrameworkIntranet.ViaForm", {
	extend: "At4FrameworkIntranet.BasicForm",
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
			width: At4FrameworkIntranet.FormDefaults.size(2, 2, 12),
			disableUpdates: true,
			disabled: true,
			hideTrigger: true,
			allowBlank: false,
			allowDecimals: false,
			maxValue: 2147483647
		})
		//fields.tipoVia = new At4FrameworkIntranet.ComboBox({
		fields.tipoVia = new At4FrameworkIntranet.RelatedBox({
			name: 'tipoViaId',
			fieldLabel: this.tipoViaHeaderLabel,
			tabIndex: tabHelper.getNext(),
			//disableUpdates: true,
			//disabled: true,
			allowBlank: false,
			//store: At4FrameworkIntranet.FormDefaults.getStore('TipoVia'),
			recordPK: 'clave',
			relatedIconCls: "glyphicons glyphicons-transport",
			relatedForm: 'tipovia',
			width: At4FrameworkIntranet.FormDefaults.size(4, 2, 12)
		})
		fields.nombre = new Ext.form.TextField({
			name: 'nombre',
			fieldLabel: this.nombreHeaderLabel,
			tabIndex: tabHelper.getNext(),
			allowBlank: false,
			maxLength: 255,
			width: At4FrameworkIntranet.FormDefaults.size(6, 2, 12)
		})
		//fields.municipio = new At4FrameworkIntranet.ComboBox({
		fields.municipio = new At4FrameworkIntranet.RelatedBox({
			name: 'municipioId',
			fieldLabel: this.municipioHeaderLabel,
			tabIndex: tabHelper.getNext(),
			//disableUpdates: true,
			//disabled: true,
			allowBlank: false,
			//store: At4FrameworkIntranet.FormDefaults.getStore('Municipio'),
			recordPK: 'clave',
			relatedIconCls: "glyphicons glyphicons-map",
			relatedForm: 'municipio',
			width: At4FrameworkIntranet.FormDefaults.size(4, 1, 10)
		})
		fields.codigoCatastro = new Ext.form.NumberField({
			name: 'codigoCatastro',
			fieldLabel: this.codigoCatastroHeaderLabel,
			tabIndex: tabHelper.getNext(),
			disableUpdates: true,
			disabled: true,
			allowBlank: false,
			allowDecimals: false,
			maxValue: 2147483647,
			width: At4FrameworkIntranet.FormDefaults.size(4, 1, 10)
		})

		this.fields = fields;
		var items = [{
			xtype: 'At4Framework-fieldmainpanel',
			items: [
				At4FrameworkIntranet.FormDefaults.rows(
					[
						[fields.clave, fields.tipoVia, fields.nombre],
						[fields.municipio, fields.codigoCatastro],
						[At4FrameworkIntranet.FormDefaults.resumenAuditoria()]
					]
				)
			]
		}];



		this.maxTabIndex = tabHelper.getNext();
		this.callParent([application, formName, gridMetaData, items, config]);
	}
});
