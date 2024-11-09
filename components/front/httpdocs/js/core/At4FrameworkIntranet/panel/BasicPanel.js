// Namespace de At4FrameworkIntranet
Ext.namespace('At4FrameworkIntranet');


/**
 * @class At4FrameworkIntranet.BasicPanel
 * Clase base de paneles de subformularios de At4Framework
 * @extends-ext Ext.Panel
 * @author agarcia
 * @constructor
 *
 * @param {At4FrameworkIntranet.BasicForm} parentFormPanel Formulario contenedor
 * @param {Object} config
 */
//At4FrameworkIntranet.BasicPanel =  function(parentFormPanel, config){
Ext.define("At4FrameworkIntranet.BasicPanel", {
    extend: "Ext.panel.Panel",

    disabled: true,
    addEnabled: true,
    editEnabled: true,
    modifyEnabled: true,
    deleteEnabled: true,
    extraPanel: {hidden:true},
    extraButtons: [],

    constructor: function(parentFormPanel, config) {
        //console.log("Se esta creando un BasicPanel");
        this.listeners = {
            /* NOTA: queremos que por defecto estén desactivados los paneles multiform, sin embargo
             * hacerlo con disabled:true, hace que no se renderizen correctamente, por lo que añadimos
             * el evento afterlayout para que se desactiven automáticamente tras renderizarse.
             */
            // TODO: garrom:   Al tener deferredload, con disabled: true va bien, ya que no se renderizan si no estan activadas,
            //                 por lo cual cuando se renderizan lo hacen bien
            /*'afterlayout': {
                fn: function(p) {
                    //TODO: Fix
                    p.disable();
                },
                single: true // important, as many layouts can occur
            },*/

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
        };
        Ext.apply(this.listeners, config.listeners);
        delete config.listeners;
        Ext.apply(this, config);

        this.parentFormPanel = parentFormPanel;
        if (this.deferredLoad) {
            this.dataLoaded = false;
        } else {
            this.dataLoaded = true;
        }

        this.isActiveTab = false;


        /*
         * Acceso a la barra de estado. Usamos la barra de estado general de la aplicación
         */
        this.statusBar = Ext.getCmp('At4Framework-status');

        var modelName = "At4FrameworkPanel" + this.id + "Model";
        var fields = [];
        //this.dataRecord.idProperty = "oid";

        this.reader = Ext.create("Ext.data.reader.Json", {
            type: "json",
            totalProperty: "totalNumRecords",
            rootProperty: "resultados",
            model: this.dataRecord
        });


        var storeConfig = {
            remoteSort: true,
            model: this.dataRecord
        };
        Ext.apply(storeConfig, this.extraStoreCfg);

        this.store = Ext.create("Ext.data.Store", storeConfig);
        if (this.editForm) {

            this.editForm.id = this.editForm.id + "-SubForm";
            this.formWindow = Ext.create({
                xtype: "at4window",
                title: this.editarTxt,
                closable: true,
                modal: true,
                closeAction: 'hide',
                width: this.windowWidth,
                height: this.windowHeight,
                deferredRender: false,
                //border:false,
                plain: true,
                layout: 'fit',
                items: this.editForm
            });
            this.editForm.setParentPanel(this);
        }

        //Nota: si viene un orderField, va a utilizar este campo como campo para ordenar con modo drag n drop (si existe)
        var dataViewConfig = {
            id: this.getId() + '-dataview',
            itemSelector: this.itemSelector,
            store: this.store,
            tpl: this.tpl,
            listeners: {
                selectionchange: {
                    fn: function(dataView, selections) {
                        if (selections.length > 0) {
                            this.enableRecordEdit();
                        } else {
                            this.disableRecordEdit();
                        }
                    },
                    scope: this
                },
                itemdblclick: {
                    fn: function(dataView, record, item, index, e, eOpts) {
                        this.doEditRecord(record);
                    },
                    scope: this
                },
                viewready: {
                    fn: this.onRenderDragZoneFunction,
                    scope: this
                },
                recordsOrdered: {
                    fn: this.onRecordsOrdered,
                    scope: this
                }
            }
        };
        Ext.apply(dataViewConfig, this.dataViewDefaultConfig);
        this.dataView = Ext.create("Ext.view.View", dataViewConfig);

        this.newButton = new Ext.Button({
            id: this.getId() + '-newButton',
            text: this.nuevoTxt,
            iconCls: At4util.icons.add,
            scope: this,
            disabled: !this.addEnabled,
            hidden: false,
            style: 'margin: 0px 5px 0px 10px;',
            handler: function() {
                this.doNewRecord();
            }
        });

        this.editButton = new Ext.Button({
            id: this.getId() + '-editButton',
            text: this.editarTxt,
            iconCls: At4util.icons.editar,
            scope: this,
            disabled: !this.modifyEnabled,
            hidden: false,
            style: 'margin: 0px 5px 0px 10px;',
            handler: function() {
                //var records = this.dataView.getSelectedRecords();
                var node = this.dataView.getSelectedNodes()[0];
                var record = this.dataView.getRecord(node);
                this.doEditRecord(record);
            }
        });

        this.deleteButton = new Ext.Button({
            id: this.getId() + '-deleteButton',
            text: this.borrarTxt,
            iconCls: At4util.icons.remove,
            scope: this,
            disabled: !this.deleteEnabled,
            hidden: false,
            style: 'margin: 0px 5px 0px 10px;',
            handler: function() {

                Ext.Msg.show({
                    title: this.borrarRegistroTxt,
                    msg: this.seguroTxt,
                    icon: Ext.Msg.QUESTION,
                    buttons: Ext.Msg.YESNO,
                    scope: this,
                    fn: function(response) {
                        if ('yes' !== response) {
                            return;
                        }
                        //var records = this.dataView.getSelectedRecords();
                        var record = this.dataView.getRecord(this.dataView.getSelectedNodes()[0])
                        var dataId = record.data.oid;

                        if (this.parentFormPanel.formName != null) {
                            serverDatabaseActions.runAction(
                                FormDataService.deleteSubForm, [
                                    this.parentFormPanel.formName,
                                    this.parentFormPanel.dataId,
                                    this.editForm.subFormName,
                                    dataId
                                ],
                                this.afterDeleteForm,
                                serverDatabaseActions.exceptionHandler,
                                this
                            )
                        } else { //es tracta d'un subform anidat
                            serverDatabaseActions.runAction(
                                FormDataService.deleteSubForm, [
                                    this.parentFormPanel.subFormName,
                                    this.parentFormPanel.dataId,
                                    this.editForm.subFormName,
                                    dataId
                                ],
                                this.afterDeleteForm,
                                serverDatabaseActions.exceptionHandler,
                                this
                            )
                        }
                    }
                });

            }
        });

        var buttons = [];

        if (this.showNewButton) {
            buttons.push(this.newButton);
        }
        if (this.showEditButton) {
            buttons.push(this.editButton);
        }
        if (this.showDeleteButton) {
            buttons.push(this.deleteButton);
        }

        if (this.orderField) {
            this.acceptChanges = new Ext.Button({
                id: this.getId() + '-acceptChanges',
                text: this.aplicarReorden,
                iconCls: At4util.icons.order,
                scope: this,
                hidden: true,
                style: 'margin: 0px 5px 0px 10px;',
                handler: function() {
                    this.sendUpdatedFields();
                }
            });
            this.rejectChanges = new Ext.Button({
                id: this.getId() + '-rejectChanges',
                text: this.cancelarReorden,
                iconCls: At4util.icons.close,
                scope: this,
                hidden: true,
                style: 'margin: 0px 5px 0px 10px;',
                handler: function() {
                    this.cancelUpdatedFields();
                }
            });
            buttons.push(this.acceptChanges);
            buttons.push(this.rejectChanges);
        }

        if(this.extraButtons && this.extraButtons.length>0){
            Ext.each(this.extraButtons, function(bt){
                buttons.push(bt);
            }.bind(this));
        }


        this.callParent([{
            deferredRender: false,
            tbar: {
                xtype: 'toolbar',
                id: this.getId() + '-toolbar',
                hidden: false,
                items: buttons
            },
            listeners: {
                /* NOTA: queremos que por defecto estén desactivados los paneles multiform, sin embargo
                 * hacerlo con disabled:true, hace que no se renderizen correctamente, por lo que añadimos
                 * el evento afterlayout para que se desactiven automáticamente tras renderizarse.
                 */
                // TODO: garrom:   Al tener deferredload, con disabled: true va bien, ya que no se renderizan si no estan activadas,
                //                 por lo cual cuando se renderizan lo hacen bien
                /*'afterlayout': {
                    fn: function(p) {
                        //TODO: Fix
                        p.disable();
                    },
                    single: true // important, as many layouts can occur
                },*/

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
            items: [this.extraPanel, this.dataView]
        }]);
    },

    updateRecordCallback: function(records, resultadoActualizacion) {

        if (resultadoActualizacion.correcto) {

            var statusText = '';

            var len = records.length;
            for (var i = 0; i < len; i++) {
                records[i].commit();
            }
            if (len > 0) {
                if (len > 1) {
                    statusText += Ext.String.format(
                        this.modificadosElementosText, len);
                } else {
                    statusText += this.modificadoElementoText;
                }
            }

            this.statusBar.setStatus({
                text: statusText,
                clear: true
                    // auto-clear after a set interval
            });

        } else {
            var message = resultadoActualizacion.message;
            Ext.Msg.alert('Error:', message);
        }
        this.checkUpdatedFelds();
    },

    dataViewDefaultConfig: {
        //emptyText: '##################EMPTY##################',
        bodyStyle: 'padding: 0px 0px 0px 0px',
        width: "99%",
        autoHeight: true,
        autoScroll: true,
        layout: 'fit',
        multiSelect: false,
        singleSelect: true,
        //overCls: 'x-view-container-over',
        overItemCls: 'x-view-over',
        selectedItemCls: 'x-view-selected',

    },

    showNewButton: true,
    showEditButton: true,
    showDeleteButton: true,

    /** garrom:
     * Da la posibilidad al panel de tener scroll por si el view es muy grande
     */
    scrollable: "x",
    /** garrom:
     * Con esto el panel ocupara el 100% ,de lo ancho (deberia hacerlo siempre)
     */
    layout: "fit",
    width: "100%",


    /** Etiqueta de texto
     * @type {String}
     */
    nuevoTxt: 'Nuevo',

    /** Etiqueta de texto
     * @type {String}
     */
    borrarTxt: 'Borrar',

    /** Etiqueta de texto
     * @type {String}
     */
    editarTxt: 'Editar',

    /** Etiqueta de texto
     * @type {String}
     */
    eliminadoTxt: 'Eliminado 1 elemento',

    /** Etiqueta de texto
     * @type {String}
     */
    ejecutandoTxt: 'Ejecutando...',

    /** Etiqueta de texto
     * @type {String}
     */
    espereTxt: 'espere...',

    /** Etiqueta de texto
     * @type {String}
     */
    borrarRegistroTxt: '¿Borrar registro?',

    /** Etiqueta de texto
     * @type {String}
     */
    seguroTxt: '¿está seguro?<br/>Esta acción no se puede deshacer.',

    /** Etiqueta de texto
     * @type {String}
     */
    eliminadoTxt: 'Eliminado 1 elemento',

    /** Ancho de la ventana. Por defecto, 400
     * @type {Number}
     */
    windowWidth: 750,

    /** Alto de la ventana. Por defecto, 400
     * @type {Number}
     */
    windowHeight: 400,

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
    itemSelector: 'tr.filaListadoPanel',

    /**
     * Ext.data.Record que define los datos del panel
     * @type {Ext.data.Record}
     */
    dataRecord: null,

    /**
     * Formulario para editar los registros
     * @type {At4FrameworkIntranet.BasicSubForm}
     */
    editForm: null,

    /**
     * Carga el contenido del panel
     * @param {Array} data Vector de registros a cargar
     */
    setValues: function(data) {
        this.store.removeAll();
        /*for (i in data) {
            if (typeof(data[i]) != "function") {
                if (typeof(data[i].primaryKey) === "object") {
                    data[i].primaryKey.toString = function() {
                        return this.asString;
                    }
                }
            }
        }*/
        var resultado = this.reader.readRecords({
            'resultados': data,
            'totalNumRecords': data.length
        });
        this.store.loadRecords(resultado.records);
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
        this.deleteButton.disable();
    },

    /**
     * Activa las acciones de edición del registro
     */
    enableRecordEdit: function() {
        if (this.editable) {
            this.editButton.enable();
            this.deleteButton.enable();
        }
    },

    /**
     * Cierra la ventana del formulario
     */
    closeForm: function() {
        this.formWindow.hide();
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
        this.store.loadRecords(resultado.records, {
            addRecords: true
        });

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

    //private
    afterDeleteForm: function(response) {

        if (response.success) {
            //Notificamos a la aplicación de la eliminación del registro
            //var records = this.dataView.getSelectedRecords();
            var record = this.dataView.getRecord(this.dataView.getSelectedNodes()[0]);
            this.store.remove(record);
            //notificamos en barra de estado
            this.statusBar.setStatus({
                text: this.eliminadoTxt,
                clear: true // auto-clear after a set interval
            });
            this.updateParent();
        } else {
            Ext.Msg.alert('Error:', response.message);
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
        this.newButton.setVisible(editable && this.addEnabled);
        this.editButton.setVisible(editable);
        this.deleteButton.setVisible(editable);
        if (this.editForm) {
            this.editForm.setEditable(editable);
        }
    },
    doNewRecord: function() {
        if(!this.addEnabled){
            return;
        }
        this.formWindow.show();
        this.editForm.emptyForm();
    },
    doEditRecord: function(record) {
        if(!this.editEnabled){
            return;
        }
        this.formWindow.show();
        this.editForm.loadData(record);
    },
    checkUpdatedFelds: function() {
        console.log("Checking if records...");
        var hasChanged = this.store.getModifiedRecords().length > 0;
        var bt1 = this.acceptChanges;
        var bt2 = this.rejectChanges;
        if (bt1 && bt2) {
            if (hasChanged) {
                bt1.show();
                bt2.show();
            } else {
                bt1.hide();
                bt2.hide();
            }
        }

    },
    sendUpdatedFields: function() {
        console.log("Records sent!");
        var formName = this.editForm.application.formName;
        var formId = this.editForm.application.dataId;
        var subFormName = this.editForm.subFormName;
        var items = this.store.getModifiedRecords();
        var subFormRecords = items;
        serverDatabaseActions.updateSubFormList(formName, subFormName, formId, subFormRecords, this.updateRecordCallback, this);
    },
    cancelUpdatedFields: function() {
        console.log("Records changes rejected.");
        this.store.rejectChanges();
        this.checkUpdatedFelds();
    },
    onRenderDragZoneFunction: function(view, eopts) {
        //Activamos dragNdrop para los records que tengan el campo orden
        if (this.orderField && this.store.getModel().getField(this.orderField)) {
            this.dragZone = new Ext.view.DragZone({
                view: view,
                ddGroup: 'reorder',
                dragText: this.reorderTxt // texto que aparece debajo del raton cuando empiezas a arrastrar
            });

            this.dropZone = new Ext.view.DropZone({
                view: view,
                ddGroup: 'reorder',
                handleNodeDrop: function(data, record, position) {
                    var view = this.view;
                    var store = view.getStore();
                    var index;
                    var records;
                    var i;
                    var len;
                    if (data.copy) {
                        records = data.records;
                        data.records = [];
                        for (i = 0, len = records.length; i < len; i++) {
                            data.records.push(records[i].copy(records[i].getId()));
                        }
                    } else {
                        data.view.store.remove(data.records, data.view === view);
                    }
                    index = store.indexOf(record);
                    if (position !== 'before') {
                        index++;
                    }
                    store.insert(index, data.records);
                    view.getSelectionModel().select(data.records);
                    view.fireEvent("recordsOrdered", view, data);
                }
            });
        }
    },
    onRecordsOrdered: function(view, data) {
        var items = view.store.getData().items;
        for (i in items) {
            if (items.hasOwnProperty(i)) {
                var suorden = (parseInt(i) + 1)
                var record = items[i];
                if (items[i].data[this.orderField] != suorden) {
                    record.set(this.orderField, suorden);
                }
            }
        }
        this.checkUpdatedFelds();
    }
});
