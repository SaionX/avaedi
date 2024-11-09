// Namespace de At4FrameworkIntranet
Ext.namespace('At4FrameworkIntranet');


/**
 * @class At4FrameworkIntranet.BasicSubForm
 * @extends At4FrameworkIntranet.BaseForm
 * Clase base de subformularios de At4Framework
 * @author agarcia
 * @constructor
 *
 * @param {Object} application La aplicación que contiene el formulario, normalmente será un {@link At4FrameworkIntranet.BasicForm}
 * @param {Mixed} items ver Ext.form.FormPanel#items
 * @param {Object} config Configuración para Ext.form.FormPanel
 */


//Ext.extend(At4FrameworkIntranet.BasicSubForm, At4FrameworkIntranet.BaseForm, {
Ext.define("At4FrameworkIntranet.BasicSubForm", {
    extend: "At4FrameworkIntranet.BaseForm",
    constructor: function(application, items, config) {
        //console.log("Se esta creando un BasicSubForm");
        this.application = application;
        Ext.apply(this, config);
        var actualizarID = this.getId() + '-ActualizarSubFormButton';
        // if (Ext.ClassManager.isCreated(actualizarID)) {
        //     this.actualizarButton = Ext.ClassManager.get(actualizarID);
        // } else {
        //}

        // if (this.viewOnly) {
        //     Ext.each(items, function(objeto, index, array) {
        //         objeto.editable = false;
        //     })
        //
        //
        // } else {
        if(!this.viewOnly){
            this.actualizarButton = Ext.create("Ext.button.Button", {
                text: this.actualizarTxt,
                id: actualizarID,
                iconCls: At4util.icons.update,
                name: '_dwrstore',
                scope: this,
                cls: "at4-update",
                //formBind: true,
                disabled: false,
                hidden: false,
                style: 'margin: 0px 5px 0px 5px;',
                handler: this.updateForm
            });
        }

        this.callParent([{

            trackResetOnLoad: false, //debemos hacer que reset inicialice el formulario
            //autoDestroy: false,
            defaultType: 'textfield',
            labelWidth: 90,
            deferredRender: false,
            autoHeight: false,
            closable: false,
            //autoScroll: true,
            overflowY: "auto",
            overflowX: "hidden",
            header: false,
            border: false,
            labelAlign: "top",
            items: items,
            monitorValid: true,
            buttonAlign: 'right',
            buttons: [
                this.actualizarButton, {
                    text: this.cerrarTxt,
                    id: this.getId() + 'CerrarButton',
                    iconCls: At4util.icons.close,
                    scope: this,
                    formBind: false,
                    disabled: false,
                    cls: "at4-delete",
                    hidden: false,
                    style: 'margin: 0px 5px 0px 5px',
                    handler: function() {

                        this.parentPanel.closeForm();
                    }
                },
                At4FrameworkIntranet.FormDefaults.debugButton(this)
            ]
        }]);
    },


    currentRecord: null,

    //bodyStyle: "padding:15px 0px 15px 15px; border-bottom: 1px solid #D6D3D6",
    bodyStyle: "border-bottom: 1px solid #D6D3D6",

    parentPanel: null,
    /**
     * Indica si el formulario es editable
     */
    editable: true,

    actionBusy: false,
    actionPile: [],

    /**
     * Nombre del subformulario
     * @type {String}
     */
    subFormName: null,

    /**
     * Carga el registro en el formulario
     * @param {Ext.data.Record} record
     * @return boolean
     */
    loadData: function(record) {
        this.emptyForm();
        this.currentRecord = record;
        this.dataId = record.data.oid;
        this.setValues(record.data);
        //Activamos los paneles multiForm anidados
        for (var multiform in this.multiForms) {
            if (typeof this.multiForms[multiform] != 'function') {
                this.multiForms[multiform].enable();
                this.multiForms[multiform].setEditable(this.editable);
            }
        }
        //Desactivamos los campos que no se pueden actualizar
        if (this.fields) {
            for (var field in this.fields) {
                if (this.fields[field].disableUpdates) {
                    this.fields[field].disable();
                }
            }
        }


        return this.fireEvent('afterload', {}, record);
    },

    setEditable: function(editable) {
        this.editable = editable;
        if (this.actualizarButton) {
            this.actualizarButton.setVisible(editable);
        }
        //Pasamos la acción a los paneles multiForm anidados
        for (var multiform in this.multiForms) {
            if (typeof this.multiForms[multiform] != 'function') {
                //this.multiForms[multiform].enable();
                this.multiForms[multiform].setEditable(editable);
            }
        }
    },

    updateForm: function(clientValidation) {
        var action = {};
        if (this.dataId) {
            //Actualizacion de registro
            if (this.application.formName != null) {
                action = Ext.create("Ext.form.Action.DWRSubmit", this, {
                    dwrArgs: [this.application.formName, this.application.dataId, this.subFormName, this.dataId],
                    dwrFunction: FormDataService.updateSubForm,
                    waitMsg: this.ejecutandoTxt,
                    waitTitle: this.espereTxt,
                    success: this.afterUpdateForm,
                    failure: this.afterUpdateError,
                    clientValidation: clientValidation,
                    scope: this
                });
            } else {
                //es tracta d'un subform anidat
                action = Ext.create("Ext.form.Action.DWRSubmit", this, {
                    dwrArgs: [this.application.subFormName, this.application.dataId, this.subFormName, this.dataId],
                    dwrFunction: FormDataService.updateSubForm,
                    waitMsg: this.ejecutandoTxt,
                    waitTitle: this.espereTxt,
                    clientValidation: clientValidation,
                    success: this.afterUpdateForm,
                    failure: this.afterUpdateError,
                    scope: this
                });
            }

        } else {
            //Alta de un nuevo registro
            if (this.application.formName != null) {
                action = Ext.create("Ext.form.Action.DWRSubmit", this, {
                    dwrArgs: [this.application.formName, this.application.dataId, this.subFormName],
                    dwrFunction: FormDataService.addSubForm,
                    waitMsg: this.ejecutandoTxt,
                    waitTitle: this.espereTxt,
                    clientValidation: clientValidation,
                    success: this.afterInsertForm,
                    failure: this.afterInsertFailureForm,
                    scope: this
                });

            } else {
                //es tracta d'un subform anidat
                action = Ext.create("Ext.form.Action.DWRSubmit", this, {
                    dwrArgs: [this.application.subFormName, this.application.dataId, this.subFormName],
                    dwrFunction: FormDataService.addSubForm,
                    waitMsg: this.ejecutandoTxt,
                    clientValidation: clientValidation,
                    waitTitle: this.espereTxt,
                    success: this.afterInsertForm,
                    failure: this.afterInsertFailureForm,
                    scope: this
                });

            }
        }
        this.getForm().doAction(action);
    },
    /**
     * Vacía el formulario
     * @return boolean
     */
    emptyForm: function() {
        this.currentRecord = null;
        this.dataId = null;
        this.loadedValues = {};

        //Vaciamos los paneles multiForm anidados
        for (var multiform in this.multiForms) {
            if (typeof this.multiForms[multiform] != 'function') {
                this.multiForms[multiform].disable();
                this.multiForms[multiform].setEditable(false);
                this.multiForms[multiform].setValues([]);
            }
        }
        //Desactivamos los campos que no se pueden actualizar
        if (this.fields) {
            for (var field in this.fields) {
                if (this.fields[field].disableUpdates) {
                    this.fields[field].disable();
                }
            }
        }

        //Reactivamos los campos que no se pueden actualizar
        if (this.fields) {
            for (var field in this.fields) {
                if (this.fields[field].disableUpdates) {
                    this.fields[field].enable();

                }
                if (this.fields[field].xtype == "At4Framework-combobox") {
                    var field = this.fields[field]
                    if (!field.noReload) {
                        field.clearValue();
                    }
                }
            }
        }

        this.form.reset();
        return this.fireEvent('afteremptyform');
    },

    /**
     * Fija el panel padre
     * @param {At4FrameworkIntranet.BasicPanel} pan
     */
    setParentPanel: function(pan) {
        this.parentPanel = pan;
    },

    /**
     * @private
     * @param {Object} form
     * @param {Object} action
     */
    afterInsertForm: function(form, action) {
        //Cargamos los datos recién insertados
        var rowid = action.result.addedElementKeys[0];
        //Notificamos a la aplicación de la inserción del nuevo registro
        var record = this.parentPanel.onNewRecordDone(this, action.result.updatedElement);
        //notificamos en barra de estado
        this.statusBar.setStatus({
            text: this.anyadidoTxt,
            clear: true // auto-clear after a set interval
        });
        //this.parentPanel.closeForm();
        //Mejor que cerrar el formulario, simplemente actualizamos su contenido
        this.loadData(record);
    },

    afterInsertFailureForm: function(form, data) {
        if (data.result != null && data.result.correcto) {
            Ext.Msg.alert('<spring:message code="forms.general.success" javaScriptEscape="true"/>', data.result.message);
        } else if (data.result != null) {
            Ext.Msg.alert('<spring:message code="forms.general.error" javaScriptEscape="true"/>', data.result.message);
        }
    },

    /**
     * @private
     * @param {Object} form
     * @param {Object} action
     */
    afterUpdateForm: function(form, action) {
        this.actionBusy = false;
        if (this.actionPile.length > 0) {
            this.submitRawRecord(this.actionPile.splice(0, 1)[0]);
        } else {

            var record = this.parentPanel.onUpdateRecordDone(this, action.result.updatedElement, this.currentRecord);

            //notificamos en barra de estado
            this.statusBar.setStatus({
                text: this.actualizadoTxt,
                clear: true // auto-clear after a set interval
            });
            //this.parentPanel.closeForm();
            //Mejor que cerrar el formulario, simplemente actualizamos su contenido
            this.loadData(record);
        }

    },
    afterUpdateError: function(form, data) {

        if (data && data.result && data.result.correcto) {
            Ext.Msg.alert('<spring:message code="forms.general.success" javaScriptEscape="true"/>', data.result.message);
        } else {
            Ext.Msg.alert('<spring:message code="forms.general.error" javaScriptEscape="true"/>', data.result.message);
        }
    },
    submitRawRecord: function(record) {
        if (!this.actionBusy) {
            this.actionBusy = true;
            this.loadData(record);
            this.updateForm(false);
        } else {
            this.actionPile.push(record);
        }

    }

});
