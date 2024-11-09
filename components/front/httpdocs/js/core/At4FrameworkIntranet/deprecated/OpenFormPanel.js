// Namespace de At4FrameworkIntranet
Ext.namespace('At4FrameworkIntranet');

//Ext.extend(At4FrameworkIntranet.OpenFormPanel, Ext.Panel, {
Ext.define("At4FrameworkIntranet.OpenFormPanel", {
    extend: "Ext.grid.Panel",
    /**
     * @class At4FrameworkIntranet.OpenFormPanel
     * Un panel que abre un formulario completo
     * @extends-ext Ext.Panel 
     * @author agarcia
     * @constructor
     * 
     * @param {At4FrameworkIntranet.app} application Aplicación padre
     * @param {At4FrameworkIntranet.BasicForm} parentFormPanel Formulario contenedor
     * @param {Object} config
     */
    constructor: function(application, parentFormPanel, config) {
        console.log("Se esta creando un OpenFormPanel");
        Ext.apply(this, config);
        this.application = application;

        this.parentFormPanel = parentFormPanel;
        if (this.deferredLoad) {
            this.dataLoaded = false;
        } else {
            this.dataLoaded = true;
        }

        this.isActiveTab = false;

        /*Acceso a la barra de estado. Usamos la barra de estado general de la aplicación
         */
        this.statusBar = Ext.getCmp('At4Framework-status');

        this.reader = new Ext.data.JsonReader({
            totalProperty: "totalNumRecords",
            rootProperty: "resultados"
        }, this.dataRecord);


        var storeConfig = {
            remoteSort: true,
            reader: this.reader
        };

        this.store = new Ext.data.Store(storeConfig);
        //this.store.load();

        this.dataView = new Ext.DataView({
            id: this.getId() + '-dataview',
            store: this.store,
            tpl: this.tpl,
            autoHeight: true,
            autoScroll: true,
            layout: 'fit',
            multiSelect: false,
            singleSelect: true,
            overClass: 'x-view-over',
            selectedClass: 'x-view-selected',
            itemSelector: this.itemSelector,
            emptyText: '',
            bodyStyle: 'padding: 0px 0px 0px 0px',

            listeners: {
                'selectionchange': {
                    fn: function(dataView, selections) {
                        if (selections.length > 0) {
                            this.enableRecordEdit();
                        } else {
                            this.disableRecordEdit();
                        }
                    },
                    scope: this
                },
                'dblclick': {
                    fn: function(dataView) {
                        var records = dataView.getSelectedRecords();
                        this.openRecord(records[0]);
                    },
                    scope: this
                }
            }
        });

        this.newButton = new Ext.Button({
            id: this.getId() + '-newButton',
            text: this.nuevoTxt,
            iconCls: At4util.icons.add,
            scope: this,
            disabled: !this.addEnabled,
            hidden: false,
            style: 'margin: 0px 5px 0px 10px;',
            handler: function() {
                this.newRecord();
            }
        });

        this.editButton = new Ext.Button({
            id: this.getId() + '-editButton',
            text: this.editarTxt,
            iconCls: At4util.icons.editar,
            scope: this,
            disabled: true,
            hidden: false,
            style: 'margin: 0px 5px 0px 10px;',
            handler: function() {
                var records = this.dataView.getSelectedRecords();
                this.openRecord(records[0]);
            }
        });


        //At4FrameworkIntranet.OpenFormPanel.superclass.constructor.call(this, {
        this.callParent(this, {
            deferredRender: false,
            tbar: new Ext.Toolbar({
                id: this.getId() + '-toolbar',
                hidden: false,
                items: [
                    this.newButton,
                    this.editButton
                ]
            }),
            listeners: {
                /* NOTA: queremos que por defecto estén desactivados los paneles multiform, sin embargo
                 * hacerlo con disabled:true, hace que no se renderizen correctamente, por lo que añadimos
                 * el evento afterlayout para que se desactiven automáticamente tras renderizarse.
                 */
                'afterlayout': {
                    fn: function(p) {
                        p.disable();
                    },
                    single: true // important, as many layouts can occur
                },

                /*
                 * En paneles con modo de carga de datos 'deferred', ésta se ejecutará cuando
                 * se active el panel. 
                 */
                'activate': {
                    fn: function(p) {
                        p.isActiveTab = true;
                        if (p.parentFormPanel.dataId && p.deferredLoad && !p.dataLoaded) {
                            //Hay registro cargado en el form principal y el panel tiene carga diferida
                            p.parentFormPanel.loadSubpanelData(p.parentFormPanel.dataId, p.name);
                            p.dataLoaded = true;
                        }

                    }
                },
                'deactivate': {
                    fn: function(p) {
                        p.isActiveTab = false;
                    }
                }
            },

            items: this.dataView
        });
    },
    /**
     * Nombre del formulario relacionado
     * 
     * @type {String}
     */
    relatedFormName: null,

    /** Etiqueta de texto
     * @type {String}
     */
    nuevoTxt: 'Nuevo',

    /** Etiqueta de texto
     * @type {String}
     */
    editarTxt: 'Editar',

    /** Etiqueta de texto
     * @type {String}
     */
    ejecutandoTxt: 'Ejecutando...',

    /** Etiqueta de texto
     * @type {String}
     */
    espereTxt: 'espere...',

    //private        
    editable: false,

    /** Indica que la carga de los datos se hace en el momento de necesitarse (cuando se activa el panel)
     * IMPORTANTE: esto sólo funciona para paneles incluidos en un TabPanel de un formulario principal 
     * @type {boolean}
     */
    deferredLoad: false,

    /**
     * Cuando el panel está dentro de un tabPanel, indica si es el tab activo 
     */
    isActiveTab: false,


    /**
     * Plantilla Ext.XTemplate para los registros del panel 
     * @type {Ext.XTemplate}
     */
    tpl: null,

    /**
     * itemSelector para el DataView 
     * Descripción de DataView.itemSelector: "This is a required setting. A simple CSS selector 
     * (e.g. div.some-class or span:first-child) that will be used to determine what nodes this
     *  DataView will be working with.
     *  @type {String}
     */
    itemSelector: null,

    /**
     * Ext.data.Record que define los datos del panel
     * @type {Ext.data.Record}
     */
    dataRecord: null,

    addEnabled: true,

    /**
     * Carga el contenido del panel
     * @param {Array} data Vector de registros a cargar
     */
    setValues: function(data) {
        this.store.removeAll();
        var resultado = this.reader.readRecords({
            'resultados': data,
            'totalNumRecords': data.length
        });
        this.store.add(resultado.records);
    },

    /**
     * Devuelve el número de subitems en el panel
     * @return {Number}
     */
    getTotalCount: function() {
        /* This value is not updated when changing the contents of the Store locally.
        return this.store.getTotalCount();  
        */
        return this.store.getCount();
    },

    /**
     * Desactiva las acciones de edición del registro
     */
    disableRecordEdit: function() {
        this.editButton.disable();
    },

    /**
     * Activa las acciones de edición del registro
     */
    enableRecordEdit: function() {
        if (this.editable) {
            this.editButton.enable();
        }
    },

    /**
     * Se llama a este método tras añadir un nuevo registro desde la ventana de subformulario
     * @param {At4FrameworkIntranet.BasicSubForm} form subformulario
     * @param {Object} newRecord registro añadido
     * @return {Ext.data.Record} El newRecord leido para incluir en el store
     */
    onNewRecordDone: function(form, newRecord) {

        var resultado = this.reader.readRecords({
            'resultados': [newRecord],
            'totalNumRecords': 1
        });
        this.store.add(resultado.records);

        this.updateParent();

        return resultado.records[0];

    },

    /**
     * Elimina la carga de los datos
     */
    unload: function() {
        this.store.removeAll();
        this.dataLoaded = false;
    },

    updateParent: function() {
        if (this.parentFormPanel.parentPanel != null) { //Se trata de un panel anidado
            var parentData = Ext.ux.util.clone(this.parentFormPanel.currentRecord.data);
            parentData[this.name] = [];
            for (var i = 0; i < this.store.getCount(); i++) {
                parentData[this.name][i] = this.store.getAt(i).data;
            }
            this.parentFormPanel.parentPanel.onUpdateRecordDone(this.parentFormPanel, parentData, this.parentFormPanel.currentRecord);
        }

    },

    /**
     * Se llama a este método tras modificar un registro desde la ventana de subformulario
     * @param {At4FrameworkIntranet.BasicSubForm} form subformulario
     * @param {Object} newRecord Registro modificado
     * @param {Ext.data.Record} oldRecord Registro antiguo
     * @return {Ext.data.Record} El newRecord leido para incluir en el store
     */
    onUpdateRecordDone: function(form, newRecord, oldRecord) {

        var resultado = this.reader.readRecords({
            'resultados': [newRecord],
            'totalNumRecords': 1
        });
        var index = this.store.indexOf(oldRecord);
        this.store.remove(oldRecord);
        this.store.insert(index, resultado.records);
        form.currentRecord = this.store.getAt(index);

        this.updateParent();

        return resultado.records[0];

    },

    /**
     * Activa/desactiva la edición del panel mostrando los botones de añadir/borrar/editar 
     * @param {boolean} editable
     */
    setEditable: function(editable) {
        this.editable = editable;
        /* Esto provoca errores de visualización
        this.getTopToolbar().setVisible(editable);
        */
        this.newButton.setVisible(editable);
        this.editButton.setVisible(editable);
        if (this.editForm) {
            this.editForm.setEditable(editable);
        }

    },

    /**
     * Abre el formulario del registro  
     * @param {Ext.data.Record} record
     */
    openRecord: function(record) {
        this.application.openRecordForm({
            form: this.relatedFormName
        }, record.data);
    },

    /**
     * Abre el formulario en blanco
     */
    newRecord: function() {
        this.application.openNewRecordForm({
            form: this.relatedFormName
        });
    }
});