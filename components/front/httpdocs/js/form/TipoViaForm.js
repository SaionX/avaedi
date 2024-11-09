
//Namespace de  At4FrameworkIntranet
Ext.namespace('At4FrameworkIntranet');

/**
 * @class At4FrameworkIntranet.TipoViaForm
 * Contiene la configuración del formulario: TipoVia
 * @author garrom
 * @constructor
 * @extends At4FrameworkIntranet.BasicForm
 * @param {Object} application La aplicación que contiene el formulario, normalmente será {@link At4FrameworkIntranet.app}
 * @param {String} formName Nombre del formulario
 * @param {Object} gridMetaData Configuración gridMetadata
 * @param {Object} config Configuración para Ext.form.FormPanel
 */
 
 Ext.define("At4FrameworkIntranet.TipoViaForm",{
 	extend: "At4FrameworkIntranet.BasicForm",
   constructor: function(application, formName, gridMetaData, config){
       Ext.apply(this, config);
       var tabHelper = new At4util.tabIndexHelper(this.tabIndex);

       var columnDefaults = At4FrameworkIntranet.FormDefaults.COLUMN_DEFAULTS;
       var fieldDefaults = At4FrameworkIntranet.FormDefaults.FIELD_DEFAULTS;


       var fields = {}

       fields.clave = new Ext.form.NumberField({
        name: 'clave',
        fieldLabel: this.claveHeaderLabel,
        tabIndex: tabHelper.getNext(),
        width: At4FrameworkIntranet.FormDefaults.size(2, 2, 10),
        disableUpdates: true,
        disabled: true,
        hideTrigger: true,
        allowBlank: false,
        allowDecimals: false,
        maxValue: 2147483647
    })
       fields.codigoCatastro = new Ext.form.TextField({
        name: 'codigoCatastro',
        fieldLabel: this.codigoCatastroHeaderLabel,
        tabIndex: tabHelper.getNext(),
        width: At4FrameworkIntranet.FormDefaults.size(2, 2, 10),
        disableUpdates: true,
        disabled: true,
        maxLength: 2
    })
       fields.nombre = new At4FrameworkIntranet.MultilangText({
         name: 'nombre',
         fieldLabel: this.nombreEsHeaderLabel,
         tabIndex: tabHelper.getNext(),
         allowBlank: false,
         width: At4FrameworkIntranet.FormDefaults.size(6, 2, 10),
         maxLength: 64
     }

     )


       this.fields = fields;
       var items = [
       {
         xtype: 'At4Framework-fieldmainpanel'
         ,items: [ 
         At4FrameworkIntranet.FormDefaults.rows([
            [fields.clave, fields.codigoCatastro, fields.nombre],
            [At4FrameworkIntranet.FormDefaults.resumenAuditoria()]])

         ]
     }
    ];



    this.maxTabIndex = tabHelper.getNext();
    this.callParent([application, formName, gridMetaData, items, config]);
}
});
