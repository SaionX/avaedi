// Namespace de At4FrameworkIntranet
Ext.namespace('At4FrameworkIntranet');



//Ext.extend(At4FrameworkIntranet.DwrStateProvider, Ext.ux.state.HttpProvider, {
Ext.define("At4FrameworkIntranet.DwrStateProvider", {
    extend: "Ext.ux.state.HttpProvider",
    /**
     * @class At4FrameworkIntranet.DwrStateProvider
     * Proveedor de estado que guarda y recibe información al/del servidor usando DWR
     * @extends Ext.ux.state.HttpProvider
     * @constructor
     * @author agarcia
     *
     * @param {Object} config
     */
    constructor: function(config) {
        //console.log("Se esta creando un DwrStateProvider");

        Ext.apply(this, config);
        /*config.listeners = {
            statechange(provider, key, value, eOpts) {
                console.log("state changed"),
                console.log(arguments);
            }
        }*/


        this.callParent([{}]);
        //At4FrameworkIntranet.DwrStateProvider.superclass.constructor.call(this, config);
    },
    /*
     * private, envía el estado al servidor usando métodos DWR
     */
    submitState: function() {

        if (!this.dirty) {
           // console.log("dirty submitState");
            this.dt.delay(this.delay);
            return;
        }
       // console.log("submitState");
        this.dt.cancel();

        var action = this.saveAction;
        //var queue = Ext.ux.util.clone(this.queue);
        var queue = Ext.clone(this.queue);

        // be optimistic
        this.dirty = false;

        var dwrFunctionArgs = [];
        dwrFunctionArgs.push(queue);
        dwrFunctionArgs.push({
            callback: function(response) {
                this.onSaveSuccess(response, queue)
            }.bind(this),
            exceptionHandler: this.onSaveFailure.bind(this)
        });
        //action.apply(Object, dwrFunctionArgs);
        action.apply(this, dwrFunctionArgs);

    },

    /*
     * Lee el estado guardado en el servidor usando métodos DWR
     */

    readState: function() {
        //console.log("readstate");
        var action = this.loadAction;
        var dwrFunctionArgs = [];
        dwrFunctionArgs.push({
            callback: this.onReadSuccess.bind(this),
            exceptionHandler: this.onReadFailure.bind(this)
        });
        //action.apply(Object, dwrFunctionArgs);
        action.apply(this, dwrFunctionArgs);


    },

    /*
     * private, save success callback
     */
    onSaveSuccess: function(stateData, queue) {
        //console.log("savesuccess");
        if (true !== stateData.success) {
            if (true === this.logFailure) {
                this.log(this.saveFailureText, queue, stateData);
            }
            this.dirty = true;
        } else {
            Ext.each(queue, function(item) {
                if (!item) {
                    return;
                }
                var name = item[this.paramNames.name];
                var value = this.decodeValue(item[this.paramNames.value]);

                if (undefined === value || null === value) {
                    Ext.ux.state.HttpProvider.superclass.clear.call(this, name);
                } else {
                    // parent sets value and fires event
                    Ext.ux.state.HttpProvider.superclass.set.call(this, name, value);
                }
            }, this);
            if (false === this.dirty) {
                this.queue = [];
            } else {
                var i, j, found;
                for (i = 0; i < queue.length; i++) {
                    found = false;
                    for (j = 0; j < this.queue.length; j++) {
                        if (queue[i].name === this.queue[j].name) {
                            found = true;
                            break;
                        }
                    }
                    if (true === found && this.encodeValue(queue[i].value) === this.encodeValue(this.queue[j].value)) {
                        Ext.Array.remove(this.queue, this.queue[j]);
                    }
                }
            }
            if (true === this.logSuccess) {
                this.log(this.saveSuccessText, queue, stateData);
            }
            this.fireEvent('savesuccess', this);
        }
    }, // eo function onSaveSuccess

    /*
     * private, read success callback
     */

    onReadSuccess: function(stateData) {
        //console.log("readsuccess");
        var data;
        if (true !== stateData.success) {
            if (true === this.logFailure) {
                this.log(this.readFailureText, stateData, stateData);
            }
        } else {
            data = stateData.data;
            if (!(data instanceof Array) && true === this.logFailure) {
                this.log(this.dataErrorText, data, stateData);
                return;
            }
            Ext.each(data, function(item) {
                this.state[item[this.paramNames.name]] = this.decodeValue(item[this.paramNames.value]);
            }, this);
            this.queue = [];
            this.dirty = false;
            if (true === this.logSuccess) {
                //this.log(this.readSuccessText, data, response);
                this.log(this.readSuccessText, data);
            }
            this.fireEvent('readsuccess', this);
        }
    }

});
