// Namespace de Ext.form.Action
Ext.namespace('Ext.form.Action');

//Ext.extend(Ext.form.Action.DWRSubmit, Ext.form.Action, {
Ext.define('Ext.form.Action.DWRSubmit', {
    extend: 'Ext.form.Action',
    type: 'submit',
    /**
     * @class Ext.form.Action.DWRSubmit
     * Submit data through DWR function
     * options: dwrFunction
     * @extends-ext Ext.form.Action
     * @constructor
     * @param {Object} form
     * @param {Object} options
     */
    // Ext.form.Action.DWRSubmit = function(form, options){
    constructor: function(form, options) {
        //console.log("Se esta creando un DWRSubmit");
        //this.setValuesFunction = options.setValuesFunction;
        //Ext.apply(this, options);
        //this.options = options;
        this.form = form.getForm();
        //this.options = options;
        this.callParent([options]);
        //this.callParent([this, form, options]);
        //Ext.form.Action.Submit.superclass.constructor.call(this, form, options);
    },
    /**
     * Ejecuta la acción
     * @method run
     */
    run: function() {
        var o = this;
        if (o.clientValidation === false || this.form.isValid()) {
            var dwrFunctionArgs = [];
            var loadArgs = o.dwrArgs || [];
            if (loadArgs instanceof Array) {
                // Note: can't do a foreach loop over arrays because Ext added the "remove" method to Array's prototype.
                // This "remove" method gets added as an argument unless we explictly use numeric indexes.
                for (var i = 0; i < loadArgs.length; i++) {
                    dwrFunctionArgs.push(loadArgs[i]);
                }
            } else { // loadArgs should be an Object
                for (var loadArgName in loadArgs) {
                    dwrFunctionArgs.push(loadArgs[loadArgName]);
                }
            }
            /* agarcia: Extender BasicForm es complicado puesto que se 
             * instancia embebido en FormPanel. Por ello, mejor personalizamos aquí getValues. 
             *   dwrFunctionArgs.push(this.form.getValues());
             */
            dwrFunctionArgs.push(this.getValues());
            dwrFunctionArgs.push({
                //  callback: this.success.createDelegate(this, this.createCallback(), 1),
                // exceptionHandler: this.exceptionHandler.createDelegate(this, this.createCallback(), 1)

                //callback: Ext.bind(this.success, this, this.createCallback(), 1),
                //exceptionHandler: Ext.bind(this.exceptionHandler, this, this.createCallback(), 1)
                callback: Ext.bind(this.dwrsuccess, this, this.createCallback(), 1),
                exceptionHandler: Ext.bind(this.dwrexceptionHandler, this, this.createCallback(), 1)
               // callback: Ext.bind(this.success, o.scope),
               // exceptionHandler: Ext.bind(this.exceptionHandler, o.scope)
            });
            o.dwrFunction.apply(Object, dwrFunctionArgs);
        } else if (o.clientValidation !== false) { // client validation failed
            this.failureType = Ext.form.Action.CLIENT_INVALID;
            this.form.afterAction(this, false);
        }
    },


    // private
    dwrsuccess: function(response) {
        var result = this.dwrhandleResponse(response);
        if (result === true || result.success) {
            this.form.afterAction(this, true);
            return;
        }
        if (result.errors) {
            this.form.markInvalid(result.errors);
            this.failureType = Ext.form.Action.SERVER_INVALID;
        }
        this.form.afterAction(this, false);
    },

    // private
    dwrhandleResponse: function(response) {
        if (this.form.errorReader) {
            var rs = this.form.errorReader.read([response]);
            var errors = [];
            if (rs.records) {
                for (var i = 0, len = rs.records.length; i < len; i++) {
                    var r = rs.records[i];
                    errors[i] = r.data;
                }
            }
            if (errors.length < 1) {
                errors = null;
            }
            this.result = {
                success: rs.success,
                errors: errors
            };
            return this.result;
        }
        this.result = response;
        return this.result;
    },

    /**
     * Obtiene los valores del formulario.
     * @param {Object} 
     */
    getValues: function() {
        var values = this.form.getValues();
        // object hash
        var field, id;
        var retValues = {};
        for (id in values) {
            if (typeof values[id] != 'function' && (field = this.form.findField(id))) {

                if (field.xtype == 'At4Framework-combobox') {
                    //Obtenemos el valor y no la etiqueta como hace form.getValues
                    retValues[id] = field.getValue();
                } else {
                    retValues[id] = values[id];
                }

            }
        }
        return retValues;
        //return values;
    },

    /**
     * Manejador genérico de excepción
     * @param {String} message
     * @param {Object} exception
     */
    dwrexceptionHandler: function(message, exception) {
        serverDatabaseActions.exceptionHandler(message, exception);
    }

});
Ext.form.action.Action.dwrsubmit = Ext.form.Action.DWRSubmit;