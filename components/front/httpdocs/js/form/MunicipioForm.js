
//Namespace de  At4FrameworkIntranet
Ext.namespace('At4FrameworkIntranet');

/**
 * @class At4FrameworkIntranet.MunicipioForm
 * Contiene la configuración del formulario: Municipio
 * @author garrom
 * @constructor
 * @extends At4FrameworkIntranet.BasicForm
 * @param {Object} application La aplicación que contiene el formulario, normalmente será {@link At4FrameworkIntranet.app}
 * @param {String} formName Nombre del formulario
 * @param {Object} gridMetaData Configuración gridMetadata
 * @param {Object} config Configuración para Ext.form.FormPanel
 */

 Ext.define("At4FrameworkIntranet.MunicipioForm",{
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
        width: At4FrameworkIntranet.FormDefaults.size(1, 3, 12),
        disableUpdates: true,
        disabled: true,
        hideTrigger: true,
        allowBlank: false,
        allowDecimals: false,
        maxValue: 2147483647
    })

    if(GwcAccess.municipio){
        fields.isla = new At4FrameworkIntranet.RelatedBox({
            name: 'islaId',
            fieldLabel: this.islaHeaderLabel,
            labelAttrTpl: " data-qtip='" + this.islaDescriptionLabel + "'",
            tabIndex: tabHelper.getNext(),
            width: At4FrameworkIntranet.FormDefaults.size(5, 3, 12),
            relatedIconCls: "glyphicons glyphicons-globe",
            relatedForm: 'isla'
        })
    }else{
        fields.isla = new At4FrameworkIntranet.ComboBox({
            name: 'islaId',
            fieldLabel: this.islaHeaderLabel,
            labelAttrTpl: " data-qtip='" + this.islaDescriptionLabel + "'",
            tabIndex: tabHelper.getNext(),
            allowBlank: false,
            width: At4FrameworkIntranet.FormDefaults.size(5, 3, 12),
            store: At4FrameworkIntranet.FormDefaults.getStore('Isla'),
            recordPK: 'id',
            relatedIconCls: "glyphicons glyphicons-globe",
            relatedForm: 'isla'
        })
    }


    fields.codigoIne = new Ext.form.NumberField({
        name: 'codigoIne',
        fieldLabel: this.codigoIneHeaderLabel,
        tabIndex: tabHelper.getNext(),
        disableUpdates: true,
        disabled: true,
        allowBlank: false,
        allowDecimals: false,
        width: At4FrameworkIntranet.FormDefaults.size(3, 3, 12),
        maxValue: 2147483647
    })
    fields.codigoCatastro = new Ext.form.NumberField({
        name: 'codigoCatastro',
        fieldLabel: this.codigoCatastroHeaderLabel,
        tabIndex: tabHelper.getNext(),
        disableUpdates: true,
        disabled: true,
        allowBlank: false,
        allowDecimals: false,
        width: At4FrameworkIntranet.FormDefaults.size(3, 3, 12),
        maxValue: 2147483647
    })


    fields.nombre = new Ext.form.TextField({
        name: 'nombre',
        fieldLabel: this.nombreHeaderLabel,
        tabIndex: tabHelper.getNext(),
        allowBlank: false,
        disabled: GwcAccess.municipio,
        width: At4FrameworkIntranet.FormDefaults.size(5, 1, 12),
        maxLength: 255
    })
    fields.url = new Ext.form.TextField({
        name: 'url',
        fieldLabel: this.urlHeaderLabel,
        tabIndex: tabHelper.getNext(),
        width: At4FrameworkIntranet.FormDefaults.size(7, 1, 12),
        maxLength: 255
    })


    fields.organismoContacto = new Ext.form.TextArea({
        name: 'organismoContacto',
        fieldLabel: this.organismoContactoHeaderLabel,
        tabIndex: tabHelper.getNext(),
        width: At4FrameworkIntranet.FormDefaults.size(12,0,12),
        maxLength: 255
    })


    fields.direccion = new Ext.form.TextField({
        name: 'direccion',
        fieldLabel: this.direccionHeaderLabel,
        tabIndex: tabHelper.getNext(),
        width: At4FrameworkIntranet.FormDefaults.size(4, 2, 12),
        maxLength: 255
    })
    fields.telefono = new Ext.form.TextField({
        name: 'telefono',
        fieldLabel: this.telefonoHeaderLabel,
        tabIndex: tabHelper.getNext(),
        width: At4FrameworkIntranet.FormDefaults.size(4, 2, 12),
        maxLength: 12
    })
    fields.email = new Ext.form.TextField({
        name: 'email',
        fieldLabel: this.emailHeaderLabel,
        vtype: "email",
        tabIndex: tabHelper.getNext(),
        width: At4FrameworkIntranet.FormDefaults.size(4, 2, 12),
        maxLength: 255
    })
this.fields = fields;


        var items = [
            {
                xtype: 'At4Framework-fieldmainpanel',
                items: [
                    At4FrameworkIntranet.FormDefaults.rows(
                        [
                            [fields.clave, fields.isla, fields.codigoIne, fields.codigoCatastro],
                            [fields.nombre, fields.url],
                            [fields.organismoContacto],
                            [fields.direccion, fields.telefono, fields.email],
                            At4FrameworkIntranet.FormDefaults.resumenAuditoria()
                        ]
                    )
                ]
            }
        ];



		this.maxTabIndex = tabHelper.getNext();
		this.callParent([application, formName, gridMetaData, items, config]);
	}
});
