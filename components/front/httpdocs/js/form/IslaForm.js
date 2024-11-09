
//Namespace de  At4FrameworkIntranet
Ext.namespace('At4FrameworkIntranet');

/**
 * @class At4FrameworkIntranet.IslaForm
 * Contiene la configuración del formulario: Isla
 * @author garrom
 * @constructor
 * @extends At4FrameworkIntranet.BasicForm
 * @param {Object} application La aplicación que contiene el formulario, normalmente será {@link At4FrameworkIntranet.app}
 * @param {String} formName Nombre del formulario
 * @param {Object} gridMetaData Configuración gridMetadata
 * @param {Object} config Configuración para Ext.form.FormPanel
 */
 
 Ext.define("At4FrameworkIntranet.IslaForm",{
 	extend: "At4FrameworkIntranet.BasicForm",
	constructor: function(application, formName, gridMetaData, config){
    	Ext.apply(this, config);
		var tabHelper = new At4util.tabIndexHelper(this.tabIndex);

		var columnDefaults = At4FrameworkIntranet.FormDefaults.COLUMN_DEFAULTS;
		var fieldDefaults = At4FrameworkIntranet.FormDefaults.FIELD_DEFAULTS;


    var fields = {}

    fields.id = new Ext.form.NumberField({
        name: 'id',
        fieldLabel: this.idHeaderLabel,
        tabIndex: tabHelper.getNext(),
        width: At4FrameworkIntranet.FormDefaults.size(2, 1, 8),
        disableUpdates: true,
        allowBlank: false,
        allowDecimals: false,
        maxValue: 2147483647
    })
    fields.nombre = new Ext.form.TextField({
        name: 'nombre',
        fieldLabel: this.nombreHeaderLabel,
        tabIndex: tabHelper.getNext(),
        allowBlank: false,
        width: At4FrameworkIntranet.FormDefaults.size(6, 1, 8),
        maxLength: 255
    })

this.fields = fields;
var items = [
{
			xtype: 'At4Framework-fieldmainpanel'
			,items: [ 
            At4FrameworkIntranet.FormDefaults.rows([
                    [fields.id, fields.nombre],
                    [At4FrameworkIntranet.FormDefaults.resumenAuditoria()]])
            ]
}
];
 

		
		this.maxTabIndex = tabHelper.getNext();
		this.callParent([application, formName, gridMetaData, items, config]);
	}
});
