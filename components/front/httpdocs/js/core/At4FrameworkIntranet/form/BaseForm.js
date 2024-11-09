// Namespace de At4FrameworkIntranet
Ext.namespace('At4FrameworkIntranet');


Ext.define("At4FrameworkIntranet.BaseForm", {
    extend: "Ext.form.Panel",
    //plugins: Ext.ux.AllowBlank,

    /**
     * @class At4FrameworkIntranet.BaseForm
     * Clase base de formularios de At4Framework
     * @extends-ext Ext.form.FormPanel
     * @constructor
     * @author agarcia
     *
     * @param {Object} config
     */
    constructor: function(config) {
        //console.log("Se esta creando un BaseForm");

        Ext.apply(this, config);
        if (At4Framework_modoDesarrollo) {
            //Ext.log.warn("Ojo, hay que quitar este warn");
            if (this.maxTabIndex == 1.25) {
                Ext.log.warn(this.id, "No tiene definido un tab index maximo")
            }
        }

        //Nos referenciamos para nuestros campos
        for(var index in this.fields) {
            var f = this.fields[index];
            f.form = this;
        }

        /* Acceso a la barra de estado. Usamos la barra de estado general de la aplicación.
         */
        this.statusBar = Ext.getCmp('At4Framework-status');
        this.callParent([{}]);

    },


    /** Etiqueta de texto
     * @type {String}
     */
    actualizarTxt: 'Actualizar',

    //layout: "column",

    destroy: function() {
        this.application.unRegisterTabId(this);
        //At4FrameworkIntranet.app.unRegisterTabId(this);
        this.callParent(arguments);
    },

    /** Etiqueta de texto
     * @type {String}
     */
    eliminarTxt: 'Eliminar',

    /** Etiqueta de texto
     * @type {String}
     */
    cerrarTxt: 'Cerrar',

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
    nuevoRegistroTxt: 'Añadir registro',

    /** Etiqueta de texto
     * @type {String}
     */
    camposObligatoriosVaciosTxt: '¡Hay campos obligatorios sin rellenar!',

    /** Etiqueta de texto
     * @type {String}
     */
    seguroTxt: '¿está seguro?<br/>Esta acción no se puede deshacer.',

    /** Etiqueta de texto
     * @type {String}
     */
    anyadidoTxt: 'Añadido 1 elemento',

    /** Etiqueta de texto
     * @type {String}
     */
    actualizadoTxt: 'Actualizado 1 elemento',

    /** Etiqueta de texto
     * @type {String}
     */
    eliminadoTxt: 'Eliminado 1 elemento',

    /** Campos (paneles) multiform indexados por su nombre. Es necesario declarar los campos
     *  para que {@link #setValues} pueda tratarlos correctamente
     * @type {Array}
     */
    multiForms: [],

    /**
     * Datos cargados inicialmente (en setValues)
     */
    loadedValues: {},

    statusBar: null,

    maxTabIndex: 1.25,

    /**
     * Fija los valores del formulario. Basado en setValues de Ext.form.BasicForm<br/>
     * Añade tratamiento especial para los tipos de campo At4Framework
     *
     * @param {Map(String,Mixed)} values Mapa de valores indexados por el nombre del campo
     */
    setValues: function(values) {
        // object hash
        Ext.apply(this.loadedValues, values); //Añadimos los valores cargados
        var field, id;
        for (id in values) {
            if (typeof values[id] != 'function') {

                //if (field = this.form.findField(id)) {

                field = this.form.findField(id);
                if(!field){
                    field =  this.fields[id];
                    if(this.multiForms[id]){
                        field = null;
                    }
                }


                if(field){
                    if (field.xtype == 'At4Framework-itemselector') {
                        if (values[id] == null) {
                            field.reset();
                        } else {
                            var fieldValues = [];
                            for (var i = 0; i < values[id].length; i++) {
                                fieldValues.push(values[id][i][field.recordPK]);
                            }
                            field.setValue(fieldValues);
                        }
                    } else
                    if (field.xtype == 'At4Framework-combobox' || field.xtype == "At4Framework-relatedbox") {
                        //field.doQuery('', true);
                        if (values[id] == null || values[id] == 0) {
                            field.reset();
                        } else {
                            field.setComboValue(id, values);
                            /*field.collapse();

                            if (values[id + '_id']) {
                                field.setValue(values[id + '_id']);
                            } else if (values[id + 'Id']) {
                                field.setValue(values[id + 'Id']);
                            } else {
                                field.setValue(values[id]['codi']);
                            }
                            */
                        }
                    } else if (field.xtype == 'At4Framework-password') {
                        field.setValue("");
                        if (field.rePassField) {
                            field.rePassField.setValue("");
                        }
                    } else if (field.xtype == 'colorfield') {

                        var value = values[id];
                        /*value = value ? value : "#000000";
                        field.setValue(value);*/
                        if (value) {
                            field.setValue(value);
                        }
                    } else {
                        field.setValue(values[id]);
                    }

                    if (this.form.trackResetOnLoad) {
                        field.originalValue = field.getValue();
                    }
                } else
                if (this.multiForms && (field = this.multiForms[id])) {
                    field.setValues(values[id]);
                    /* cambios tratamiento de claves compuestas */
                } else if (id == 'id' && typeof values[id] == 'object') {
                    //Puede tratarse de un id compuesto
                    //console.log(values[id]);
                    for (var prop in values[id]) {
                        if (values[id].hasOwnProperty(prop)) {
                            if (field = this.form.findField('id.' + prop)) {
                                field.setValue(values[id][prop]);
                                if (this.form.trackResetOnLoad) {
                                    field.originalValue = field.getValue();
                                }
                            }

                        }
                    }
                }
                /* fin cambios tratamiento de claves compuestas */
            }
        }
    }

    /* ¿no se usa?
      updateFailure: function (form, action) {
          //Falló una actualización
          var message = action.result.message;
    	  Ext.Msg.alert('Error:', message);
      },
  */

});
