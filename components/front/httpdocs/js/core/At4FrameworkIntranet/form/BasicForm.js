// Namespace de At4FrameworkIntranet
Ext.namespace('At4FrameworkIntranet');

/**
 * @class At4FrameworkIntranet.BasicForm
 * @extends At4FrameworkIntranet.BaseForm Clase base de formularios básicos de
 *          At4Framework
 * @author agarcia
 * @constructor
 *
 * @param {Object}
 *            application La aplicación que contiene el formulario, normalmente
 *            será {@link At4FrameworkIntranet.app}
 * @param {String}
 *            formName Nombre del formulario
 * @param {Object}
 *            gridMetaData Configuración gridMetadata
 * @param {Mixed}
 *            items ver Ext.form.FormPanel#items
 * @param {Object}
 *            config Configuración para Ext.form.FormPanel
 */
Ext.define("At4FrameworkIntranet.BasicForm", {
    extend: "At4FrameworkIntranet.BaseForm",
    //multilangRE: /^.+(Es|Ca|Ct|En|Xx)$/,
    multilangRE: /^.+(Es|Ca|Ct|En|De)$/,
    loadDataFailFn: function() {
        console.log("hubo error oculto");
        console.log(arguments);
        this.close()
    },

    constructor: function(application, formName, gridMetaData, items, config) {
        //console.log("Se esta creando un BasicForm");
        this.application = application;
        this.formName = formName;
        this.gridMetaData = gridMetaData;

        Ext.apply(this, config);

        var addEnabled = this.gridMetaData.showNewButton;
        var fieldDefaults = Ext.apply(this.fieldDefaults, {
            labelAlign: "top"
        })

        // Llamamos al constructor de baseform
        this.callParent([{
            defaultType: 'textfield',
            labelWidth: 90,
            defaults: this.fieldDefaults,
            deferredRender: false,
            //bodyStyle: "padding:15px 15px 15px 15px; border-bottom: 1px solid #D6D3D6",
            bodyStyle: "border-bottom: 1px solid #D6D3D6",
            autoHeight: false,
            autoScroll: true,
            border: false,

            items: items,

            monitorValid: addEnabled,
            buttonAlign: 'left',
            dockedItems: [{
                xtype: 'toolbar',
                dock: 'bottom',
                ui: 'footer',
                tabIndex: this.maxTabIndex + 1,
                activeChildTabIndex: this.maxTabIndex + 2,
                items: [{
                    text: this.actualizarTxt,
                    id: this.getId() + 'actualizarButton',
                    iconCls: At4util.icons.update,
                    name: '_dwrstore',
                    scope: this,
                    // formBind: true,
                    disabled: !addEnabled,
                    cls: "at4-update",
                    hidden: false,
                    style: 'margin: 0px 5px 0px 10px;',
                    handler: this.submitActualizar
                }, {
                    text: this.eliminarTxt,
                    id: this.getId() + 'eliminarButton',
                    iconCls: At4util.icons.remove,
                    name: '_dwrstore',
                    scope: this,
                    cls: "at4-delete",
                    formBind: false,
                    disabled: true,
                    hidden: false,
                    //style: 'margin: 0px 5px 0px 10px; padding: 0px 0px 0px 0px',
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
                                Ext.MessageBox.wait(this.ejecutandoTxt, this.espereTxt);
                                FormDataService.deleteForm(this.formName, this.dataId, this.afterDeleteForm.bind(this));
                            }
                        });
                    }
                }, At4FrameworkIntranet.FormDefaults.debugButton(this)]
            }]
        }]);
        this.fireEvent('formprepared', this);
    },
    /**
     * Devuelve el nombre del formulario
     *
     * @return {String}
     */
    getFormName: function() {
        return this.formName;
    },

    //waitMsgTarget: true,

    getFieldEditor: function(fieldName, previouslyLoaded) {
        if (this.fields) {

            var obj = this.fields[fieldName];
            var canUpdate = false;
            if (obj) {

                /* agarcia TODO: ¿por qué hacía esta precarga? y ¿porqué marca queryMode local?
                   if(obj.xtype == "At4Framework-combobox" && !previouslyLoaded){
                       obj.store.load()
                       obj.firstLoad = false;
                       obj.queryMode = "local";
                       obj.storeLoaded = true;
                   }
                   */
                if (obj.xtype == "at4-radiogroup") {
                    //return obj.gridEditor;
                    obj = obj.gridEditor;
                } else if(obj.xtype == "At4Framework-combobox"){ //Se ocultan los QuickEdit/Insert en editable grid
                    obj.showAddRelated = false;
                    obj.showRelated = false;
                    obj.hideRelatedButtons();
                }
                //return obj;
                canUpdate = !obj.disableUpdates;
            } else {
                //Comprobamos si está en un multilang
                var re = this.multilangRE;
                if (re.test(fieldName)) {
                    var subfieldName = fieldName.substring(fieldName.length - 2);
                    fieldName = fieldName.substring(0, fieldName.length - 2);
                    var langField = this.fields[fieldName];
                    canUpdate = !langField.disableUpdates;
                    if (langField) {
                        obj = langField.inputs[subfieldName];

                        //return obj;
                    }
                }

            }
            if (canUpdate) {
                if (obj.hidden) {
                    //Si en el form por alguna razon esta oculto, puede buguear el app
                    obj.show();
                }
                //Si tiene valores por defecto de margin, los quitamos que sino descuadra
                obj.setMargin(0);
                return obj;
            } else {
                return null;
            }
        } else {
            //alert('No se puede acceder a los campos de edicion');
            Ext.Msg.alert("Alert", 'No se puede acceder a los campos de edicion');
        }
    },

    /**
     * Carga los datos del registro con identificador dataId
     *
     * @param {Mixed}
     *            dataId identificador del item a cargar
     *
     */
    loadData: function(dataId) {
        this.dataId = dataId;
        this.loadedValues = {};
        var load = Ext.create("Ext.form.Action.DWRLoad", this, {
            dwrFunction: FormDataService.loadFormData,
            dwrArgs: [this.formName, dataId],
            waitMsg: this.ejecutandoTxt,
            waitTitle: this.espereTxt,
            setValuesFunction: Ext.bind(this.setValues, this),
            scope: this,
            failure: this.isStateLoaded ? this.loadDataFailFn : serverDatabaseActions.genericFormFailureHandler,
            success: function(form, action) {
                //this = form;
                // Activamos los paneles multiForm
                for (var multiform in this.multiForms) {
                    if (typeof this.multiForms[multiform] != 'function') {
                        this.multiForms[multiform].enable();
                        if (this.multiForms[multiform].deferredLoad) {
                            // Para los paneles con carga diferida, debemos inhabilitar su contenido
                            this.multiForms[multiform].unload();
                            if (this.multiForms[multiform].isActiveTab) {
                                this.multiForms[multiform].fireEvent('activate', this.multiForms[multiform]);
                            }
                        }
                    }
                }
                // Activamos/desactivamos botones
                //var updateButton = this.buttons[0];
                //var deleteButton = this.buttons[1];
                var updateButton = this.getDockedItems()[0].items.getAt(0);
                var deleteButton = this.getDockedItems()[0].items.getAt(1);
                this.isStateLoaded = false;


                if (action.result.canUpdate) {
                    updateButton.setVisible(true);
                    updateButton.enable();

                    for (var multiform in this.multiForms) {
                        if (typeof this.multiForms[multiform] != 'function' && this.multiForms[multiform].xtype == "panel") {
                            this.multiForms[multiform].setEditable(true);
                        }
                    }
                    // this.startMonitoring();
                } else {
                    updateButton.setVisible(false);
                    updateButton.disable();

                    for (var multiform in this.multiForms) {
                        if (typeof this.multiForms[multiform] != 'function') {
                            this.multiForms[multiform].setEditable(false);
                        }
                    }

                    //this.stopMonitoring();
                }

                if (action.result.canDelete) {
                    deleteButton.setVisible(true);
                    deleteButton.enable();
                } else {
                    deleteButton.setVisible(false);
                }

                //Desactivamos los campos que no se pueden actualizar
                if (this.fields) {
                    for (var field in this.fields) {
                        if (this.fields[field].disableUpdates) {
                            this.fields[field].disable();
                        }
                    }
                }
                return this.fireEvent('afterload', dataId, action.result);
            }
        });
        this.getForm().doAction(load);
    },
    // private
    afterInsertForm: function(form, action) {
        // Cargamos los datos recién insertados
        //var rowid = form.addedElementKeys[0];
        var rowid = action.result.addedElementKeys[0];
        // Cargamos el registro recién insertado
        this.loadData(rowid);
        // Notificamos a la aplicación de la inserción del nuevo registro
        if (this.nestedParent) {
            var record = this.nestedParent.onNewRecordDone(this, action.result.updatedElement);
        } else {
            this.application.onNewRecordDone(this, {
                rowid: rowid,
                formName: this.formName
            });
        }
        this.isNewForm = false;
        Ext.each(this.allowAfterNew, function(el){
            // console.log(el);
            el.allowBlank = true;
        })
        // notificamos en barra de estado
        this.statusBar.setStatus({
            text: this.anyadidoTxt,
            clear: true
                // auto-clear after a set interval
        });
    },
    // private
    afterUpdateForm: function(form, action) {
        // recargamos el registro recién actualizado
        this.loadData(this.dataId);
        // Notificamos a la aplicación de la eliminación del registro
        if (this.nestedParent) {
            var record = this.nestedParent.onUpdateRecordDone(this, action.result.updatedElement, this.currentRecord);
        } else {
            this.application.onUpdateRecordDone({
                rowid: this.dataId,
                formName: this.formName,
                nestedParent: this.nestedParent
            });
        }
        // notificamos en barra de estado
        this.statusBar.setStatus({
            text: this.actualizadoTxt,
            clear: true
                // auto-clear after a set interval
        });
    },

    // private
    afterDeleteForm: function(response) {
        Ext.MessageBox.updateProgress(1);
        Ext.MessageBox.hide();

        if (response.success) {
            // Notificamos a la aplicación de la eliminación del registro
            this.application.onDeleteRecordDone(this, {
                rowid: this.dataId,
                formName: this.formName
            });
            // notificamos en barra de estado
            this.statusBar.setStatus({
                text: this.eliminadoTxt,
                clear: true
                    // auto-clear after a set interval
            });
        } else {
            Ext.Msg.alert('Error:', response.message);
        }
    },
    afterInsertFailureForm: function(form, data) {
        if (data.result != null && data.result.correcto) {
            Ext.Msg.alert(
                '<spring:message code="forms.general.success" javaScriptEscape="true"/>',
                data.result.message);
        } else if (data.result != null) {
            Ext.Msg.alert(
                '<spring:message code="forms.general.error" javaScriptEscape="true"/>',
                data.result.message);
        }
    },

    /**
     * Carga los datos de un subpanel (multiform) del formulario
     *
     * @param {Mixed}
     *            dataId identificador del item a cargar
     * @param {String}
     *            multiFormName identificador del item a cargar
     *
     */
    loadSubpanelData: function(dataId, multiFormName) {

        var load = Ext.create("Ext.form.Action.DWRLoad", this, {
            dwrFunction: FormDataService.loadSubPanelFormData,
            dwrArgs: [this.formName, dataId, multiFormName],
            waitMsg: this.ejecutandoTxt,
            waitTitle: this.espereTxt,
            setValuesFunction: Ext.bind(this.setValues, this),
            scope: this,
            failure: serverDatabaseActions.genericFormFailureHandler,
            success: function(form, action) {
                // No hace falta hacer nada nuevo
                return true;
            },
        });
        this.getForm().doAction(load);
    },


    qtipEnabler: function(obj) {
        Ext.tip.QuickTipManager.register({
            target: obj.getId(), // Target button's ID
            text: obj.qtip, // Tip content
            trackMouse: false
        });
    },

    submitActualizar: function() {
        if (!this.getForm().isValid()) {
            Ext.Msg.show({
                title: this.actualizarRegistroTxt,
                msg: this.camposObligatoriosTxt,
                icon: Ext.Msg.WARNING,
                buttons: Ext.Msg.OK,
                scope: this
            });
        } else {
            var action = null;
            if (this.dataId) {
                action = Ext.create("Ext.form.Action.DWRSubmit", this, {
                    dwrArgs: [this.formName,
                        this.dataId
                    ],
                    dwrFunction: FormDataService.updateForm,
                    waitMsg: this.ejecutandoTxt,
                    waitTitle: this.espereTxt,
                    success: this.afterUpdateForm,
                    failure: serverDatabaseActions.genericFormFailureHandler,
                    scope: this
                });
            } else {
                action = Ext.create("Ext.form.Action.DWRSubmit", this, {
                    dwrArgs: [this.formName],
                    dwrFunction: FormDataService.addForm,
                    waitMsg: this.ejecutandoTxt,
                    waitTitle: this.espereTxt,
                    success: this.afterInsertForm,
                    failure: this.afterInsertFailureForm,
                    scope: this
                });
            }
            this.getForm().doAction(action);
        }
    }
});
