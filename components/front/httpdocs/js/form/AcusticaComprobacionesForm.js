
//Namespace de  At4FrameworkIntranet
Ext.namespace('At4FrameworkIntranet');

/**
 * @class At4FrameworkIntranet.AcusticaComprobacionesForm
 * Contiene la configuración del formulario: AcusticaComprobaciones
 * @author garrom
 * @constructor
 * @extends At4FrameworkIntranet.BasicForm
 * @param {Object} application La aplicación que contiene el formulario, normalmente será {@link At4FrameworkIntranet.app}
 * @param {String} formName Nombre del formulario
 * @param {Object} gridMetaData Configuración gridMetadata
 * @param {Object} config Configuración para Ext.form.FormPanel
 */

 Ext.define("At4FrameworkIntranet.AcusticaComprobacionesForm",{
 	extend: "At4FrameworkIntranet.InspeccionBaseForm",
   constructor: function(application, formName, gridMetaData, config){
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

    var calasCatasElementosConstructivosStoreValues = [];
        //Buscamos la  columna para obtener los valores del store
        for (var i = 0; i < gridMetaData.columns.length; i++) {
            if (gridMetaData.columns[i].dataIndex == 'calasCatasElementosConstructivos') {
                calasCatasElementosConstructivosStoreValues = gridMetaData.columns[i].sofaStoreValues;
            }
        }
        var calasCatasElementosConstructivosStore = Ext.create('Ext.data.Store', {
            fields: ['ID', 'DISPLAY'],
            idProperty: "ID",
            data: calasCatasElementosConstructivosStoreValues
        });

        fields.calasCatasElementosConstructivos = Ext.create('Ext.form.ComboBox', {
            name: 'calasCatasElementosConstructivos',
            fieldLabel: this.calasCatasElementosConstructivosHeaderLabel,
            labelAttrTpl: " data-qtip='" + this.calasCatasElementosConstructivosDescriptionLabel + "'",
            tabIndex: tabHelper.getNext(),
            width: At4FrameworkIntranet.FormDefaults.size(1, 0, 12),
			labelStyle: 'white-space: nowrap',
            margin: "0, " + At4FrameworkIntranet.FormDefaults.size(4, 0, 12) + ", 0, 11",
            store: calasCatasElementosConstructivosStore,
            queryMode: 'local',
            valueField: 'ID',
            displayField: 'DISPLAY',
        })

        var cuestionariosConfortAcusticoStoreValues = [];
        //Buscamos la  columna para obtener los valores del store
        for (var i = 0; i < gridMetaData.columns.length; i++) {
            if (gridMetaData.columns[i].dataIndex == 'cuestionariosConfortAcustico') {
                cuestionariosConfortAcusticoStoreValues = gridMetaData.columns[i].sofaStoreValues;
            }
        }
        var cuestionariosConfortAcusticoStore = Ext.create('Ext.data.Store', {
            fields: ['ID', 'DISPLAY'],
            idProperty: "ID",
            data: cuestionariosConfortAcusticoStoreValues
        });

        fields.cuestionariosConfortAcustico = Ext.create('Ext.form.ComboBox', {
            name: 'cuestionariosConfortAcustico',
            fieldLabel: this.cuestionariosConfortAcusticoHeaderLabel,
            tabIndex: tabHelper.getNext(),
            width: At4FrameworkIntranet.FormDefaults.size(1, 0, 12),
			labelStyle: 'white-space: nowrap',
            store: cuestionariosConfortAcusticoStore,
            queryMode: 'local',
            valueField: 'ID',
            displayField: 'DISPLAY',
        })

        var medicionesAislamientoAcusticoStoreValues = [];
        //Buscamos la  columna para obtener los valores del store
        for (var i = 0; i < gridMetaData.columns.length; i++) {
            if (gridMetaData.columns[i].dataIndex == 'medicionesAislamientoAcustico') {
                medicionesAislamientoAcusticoStoreValues = gridMetaData.columns[i].sofaStoreValues;
            }
        }
        var medicionesAislamientoAcusticoStore = Ext.create('Ext.data.Store', {
            fields: ['ID', 'DISPLAY'],
            idProperty: "ID",
            data: medicionesAislamientoAcusticoStoreValues
        });

        fields.medicionesAislamientoAcustico = Ext.create('Ext.form.ComboBox', {
            name: 'medicionesAislamientoAcustico',
            fieldLabel: this.medicionesAislamientoAcusticoHeaderLabel,
            labelAttrTpl: " data-qtip='" + this.medicionesAislamientoAcusticoDescriptionLabel + "'",
            tabIndex: tabHelper.getNext(),
            width: At4FrameworkIntranet.FormDefaults.size(1, 0, 12),
			labelStyle: 'white-space: nowrap',
            store: medicionesAislamientoAcusticoStore,
            queryMode: 'local',
            valueField: 'ID',
            displayField: 'DISPLAY',
        })

        var otrasStoreValues = [];
        //Buscamos la  columna para obtener los valores del store
        for (var i = 0; i < gridMetaData.columns.length; i++) {
            if (gridMetaData.columns[i].dataIndex == 'otras') {
                otrasStoreValues = gridMetaData.columns[i].sofaStoreValues;
            }
        }
        var otrasStore = Ext.create('Ext.data.Store', {
            fields: ['ID', 'DISPLAY'],
            idProperty: "ID",
            data: otrasStoreValues
        });

        fields.otras = Ext.create('Ext.form.ComboBox', {
            name: 'otras',
            fieldLabel: this.otrasHeaderLabel,
            tabIndex: tabHelper.getNext(),
            width: At4FrameworkIntranet.FormDefaults.size(1, 0, 12),
			labelStyle: 'white-space: nowrap',
            store: otrasStore,
            queryMode: 'local',
            valueField: 'ID',
            displayField: 'DISPLAY',
        })

        fields.otrasTexto = new Ext.form.TextField({
            name: 'otrasTexto',
            fieldLabel: this.otrasTextoHeaderLabel,
            tabIndex: tabHelper.getNext(),
            width: At4FrameworkIntranet.FormDefaults.size(10, 0, 10),
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
        var items = [
        {
         xtype: 'At4Framework-fieldmainpanel'
         ,items: [
         At4FrameworkIntranet.FormDefaults.rows([
            [fields.claveInforme, fields.edificio, fields.inspeccionId],
            [fields.calasCatasElementosConstructivos, fields.cuestionariosConfortAcustico], [fields.medicionesAislamientoAcustico], [fields.otras],
            [fields.otrasTexto],
            [fields.observaciones],
            [At4FrameworkIntranet.FormDefaults.resumenAuditoria()]
            ])
         ]
     }
     ];



     this.maxTabIndex = tabHelper.getNext();
     this.callParent([application, formName, gridMetaData, items, config]);
 }
});
