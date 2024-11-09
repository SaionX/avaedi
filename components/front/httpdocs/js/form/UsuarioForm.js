//Namespace de  At4FrameworkIntranet
Ext.namespace('At4FrameworkIntranet');

/**
 * @class At4FrameworkIntranet.UsuarioForm
 * Contiene la configuración del formulario: Usuario
 * @author garrom
 * @constructor
 * @extends At4FrameworkIntranet.BasicForm
 * @param {Object} application La aplicación que contiene el formulario, normalmente será {@link At4FrameworkIntranet.app}
 * @param {String} formName Nombre del formulario
 * @param {Object} gridMetaData Configuración gridMetadata
 * @param {Object} config Configuración para Ext.form.FormPanel
 */

Ext.define("At4FrameworkIntranet.UsuarioForm", {
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
		fields.municipio = new At4FrameworkIntranet.ComboBox({
			name: 'municipioId',
			fieldLabel: this.municipioHeaderLabel,
			tabIndex: tabHelper.getNext(),
			store: At4FrameworkIntranet.FormDefaults.getStore('Municipio'),
			recordPK: 'clave',
			relatedForm: 'municipio',
			width: At4FrameworkIntranet.FormDefaults.size(5, 2, 12)
		})
		fields.username = new Ext.form.TextField({
			name: 'username',
			fieldLabel: this.usernameHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.usernameDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			allowBlank: false,
			width: At4FrameworkIntranet.FormDefaults.size(5, 2, 12),
			maxLength: 16
		})
		fields.nombre = new Ext.form.TextField({
			name: 'nombre',
			fieldLabel: this.nombreHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.nombreDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(4, 2, 12),
			maxLength: 50
		})
		fields.apellidos = new Ext.form.TextField({
				name: 'apellidos',
				fieldLabel: this.apellidosHeaderLabel,
				labelAttrTpl: " data-qtip='" + this.apellidosDescriptionLabel + "'",
				tabIndex: tabHelper.getNext(),
				width: At4FrameworkIntranet.FormDefaults.size(4, 2, 12),
				maxLength: 255
			})
			/*fields.idioma = new Ext.form.TextField({
			    name: 'idioma',
			    fieldLabel: this.idiomaHeaderLabel,
			    labelAttrTpl: " data-qtip='" + this.idiomaDescriptionLabel + "'",
			    tabIndex: tabHelper.getNext(),
			    width: At4FrameworkIntranet.FormDefaults.size(4, 2, 12),
			    maxLength: 2
			})*/

		this.fields = fields;
		var items = [{
			xtype: 'At4Framework-fieldmainpanel',
			items: [
				At4FrameworkIntranet.FormDefaults.rows([
					[fields.clave, fields.municipio, fields.username],
					[fields.nombre, fields.apellidos /*, fields.idioma*/ ],
					[At4FrameworkIntranet.FormDefaults.resumenAuditoria()]
				])
			]
		}];



		this.maxTabIndex = tabHelper.getNext();
		this.callParent([application, formName, gridMetaData, items, config]);
	}
});
