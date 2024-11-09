/**
 * @class ServerDatabaseActions
 * Implementación DWR del interfaz DatabaseActions: acceso a acciones de base de datos.<br/>
 * Basado en "javascript singleton pattern" {@link http://www.dhtmlkitchen.com/learn/js/singleton/}
 * @singleton
 * @author agarcia
 */
serverDatabaseActions = new function ServerDatabaseActions() {

    /**
     * Etiqueta de texto
     * @type {String}
     */
    this.ejecutandoTxt = 'Ejecutando...';

    /**
     * Etiqueta de texto
     * @type {String}
     */
    this.espereTxt = 'espere...';

    /** Crea el proxy para obtener los datos de relationpopup
     *
     * @param {String} formName
     * @param {String} fieldName
     */
    this.createRelationPopupProxy = function(formName, modelName, reader, dwrfunction) {
        if (!reader) {
            reader = {
                type: "json",
                totalProperty: "totalNumRecords",
                rootProperty: "resultados",
                model: modelName
            }
        }

        var dwrFunction = dwrfunction || FormDataService.getRelationPopupData;

        var proxy = {
            type: "dwr",
            dwrFunction: dwrFunction,
            //dwrParams: [formName, fieldName],
            listeners: {
                'beforeload': function(dataProxy, config) {
                    var params = config.params ? config.params : [];
                    config[dataProxy.loadArgsKey] = [
                        formName,
                        params['query'] ? (typeof(params['query']) != "function" ? params['query'] : null) : null,
                        config.filters ? (typeof(config.filters) != "function" ? dataProxy.encodeFilters(config.filters) : null) : null
                    ];
                },
                'loadexception': function(dataProxy, message, loadCallback, exception) {
                    Ext.Msg.alert('Error:', message);
                }
            }
            ,reader: reader
        }

        return proxy;

    }

    /**
     * Manejador genérico de excepciones; simplemente alerta del error.
     * @param {Object} message
     * @param {Object} exception
     */
    this.exceptionHandler = function(message, exception) {
            var strMsg = message;
            if (!strMsg) {
                strMsg = exception.javaClassName;
            }
            Ext.Msg.alert('Error:', strMsg);
        },

        /**
         * Manejador genérico de excepciones; simplemente alerta del error.
         * @param {Object} message
         * @param {Object} exception
         */
        this.genericFormFailureHandler = function(form, action) {
            if (action.failureType === Ext.form.Action.CONNECT_FAILURE) {
                Ext.Msg.alert('Error', action.response.statusText ? action.response.statusText : action.response);
            } else if (action.failureType === Ext.form.Action.SERVER_INVALID) {
                // server responded with success = false
                if (action.result.errormsg) {
                    Ext.Msg.alert('Invalid', action.result.errormsg);
                } else if (action.result.message) {
                    Ext.Msg.alert('Invalid', action.result.message);
                } else {
                    Ext.Msg.alert('Invalid', action.result);
                }
            } else {
                Ext.Msg.alert('Invalid', "Error no reconocido");
            }

        },

        /** Crea el proxy para obtener los datos de listado
         *
         * @param {String} formName
         */
        this.createListadoProxy = function(formName, extraFilters, grid) {

            return Ext.create("Ext.ux.DwrProxy", {
                dwrFunction: FormDataService.getListado,
                dwrParams: [formName],
                //TODO: Fix
                listeners: {
                    beforeload: function(dataProxy, params) {
                        filters = params.filter;
                        if (extraFilters) {
                            filters = extraFilters.concat(filters);
                        }
                        params[dataProxy.loadArgsKey] = [
                            formName,
                            filters, {
                                start: params.start ? params.start : 0,
                                limit: params.limit ? params.limit : 30,
                                sort: params.sort,
                                direction: params.dir,
                                groupBy: params.groupBy ? params.groupBy : null
                            }
                        ];
                    },
                    loadexception: function(dataProxy, message, loadCallback, exception) {
                        Ext.Msg.alert('Error:', message);
                    },

                    load: function(dataProxy, response, loadCallback) {
                        if (response.aggregates) {
                            var dataIndex, msg = "";
                            for (var i = 0; i < this.colModel.getColumnCount(); i++) {
                                dataIndex = this.gridMetaData.columns[i].dataIndex;
                                if (response.aggregates[dataIndex]) {
                                    msg += " " + this.gridMetaData.columns[i].header + ": " + this.gridMetaData.columns[i].renderer(response.aggregates[dataIndex]);
                                }
                            }
                            Ext.fly(this.displaySummaryItem.getEl()).update(msg);

                        }
                    }.bind(grid)
                }
            });

        }

    /** Actualiza un registro
     *
     * @param {String} form formulario
     * @param {int} id registro a borrar
     * @param {Object} formData Datos del record
     * @param {Function} callbackFunction Función a la cuál llamar
     * @param {Object} source objeto (scope) en el que ejecutar la función
     */
    this.updateRecord = function(form, id, formData, callbackFunction, source) {

        FormDataService.updateForm(form, id, formData, {
            callback: function(dataFromServer) {
                callbackFunction.call(source, dataFromServer);
            }
        });

    }

    /**
     * Clone Function
     * TODO: mover a utilidades
     */
    this.clone = function(o) {
        if (!o || 'object' !== typeof o) {
            return o;
        }
        var c = '[object Array]' === Object.prototype.toString.call(o) ? [] : {};
        var p, v;
        for (p in o) {
            if (o.hasOwnProperty(p)) {
                v = o[p];
                if (v && 'object' === typeof v) {
                    if (v.clone && typeof v.clone == 'function') {
                        //Si el objeto tiene el método clone
                        c[p] = v.clone();
                    } else {
                        c[p] = this.clone(v);
                    }
                } else {
                    c[p] = v;
                }
            }
        }
        return c;
    }; // eo function clone

    /** Actualiza múltiples registros
     *
     * @param {String} form formulario
     * @param {Array} ids registros a borrar
     * @param {Array} Records Datos de los records
     * @param {Function} callbackFunction Función a la cuál llamar
     * @param {Object} source objeto (scope) en el que ejecutar la función
     */
    this.updateGrid = function(form, ids, records, callbackFunction, source) {

        var formsData = new Array();
        var recordData;
        for (var i = 0; i < records.length; i++) {
            //recordData = this.clone(records[i].data);
            recordData = Ext.clone(records[i].data)
                //Conversiones para campos de tipos que así lo necesitan
            for (var j in recordData) {
                if (recordData[j]) {
                    if ((typeof(recordData[j]) === 'date') ? true : (typeof(recordData[j]) === 'object') ? recordData[j].constructor.toString().match(/date/i) !== null : false) {
                        //recordData[j] = recordData[j].format('d-m-Y');
                        var tester = /hora/;
                        if (j.match(tester)) {
                            recordData[j] = Ext.Date.format(recordData[j], 'H:i')
                        } else {
                            recordData[j] = Ext.Date.format(recordData[j], 'd-m-Y')
                        }
                    } else if (typeof(recordData[j]) == 'object' && recordData[j].asString) {
                        recordData[j] = recordData[j].asString;
                    }else if (recordData[j] instanceof Array) {
                        var cache = "";
                        var cacheidx = 0;
                        for(var jObjIdx in recordData[j]){
                            var jObj = recordData[j][jObjIdx];
                            if(!recordData[j].hasOwnProperty(jObjIdx)){
                                continue;
                            }
                            if(cacheidx > 0){
                                cache += ",";
                            }
                            cacheidx++;
                            cache +=  jObj.primaryKey;
                        }
                        recordData[j] = cache;
                    }
                }
            }
            formsData.push(recordData);
        }

        FormDataService.updateGrid(form, ids, formsData, {
            callback: function(dataFromServer) {
                callbackFunction.call(source, records, dataFromServer);
            }
        });

    }


    /** Actualiza múltiples registros
     *
     * @param {String} form formulario
     * @param {Array} ids registros a borrar
     * @param {Array} Records Datos de los records
     * @param {Function} callbackFunction Función a la cuál llamar
     * @param {Object} source objeto (scope) en el que ejecutar la función
     */
    this.updateSubFormList = function(formName, subFormName, formId, records, callbackFunction, source) {

        var formsData = new Array();
        var subIds = new Array();
        var recordData;
        for (var i = 0; i < records.length; i++) {
            //recordData = this.clone(records[i].data);
            recordData = Ext.clone(records[i].data)
                //Conversiones para campos de tipos que así lo necesitan
            for (var j in recordData) {
                if (recordData[j]) {
                    if ((typeof(recordData[j]) === 'date') ? true : (typeof(recordData[j]) === 'object') ? recordData[j].constructor.toString().match(/date/i) !== null : false) {
                        //recordData[j] = recordData[j].format('d-m-Y');
                        recordData[j] = Ext.Date.format(recordData[j], 'd-m-Y')
                    } else if (typeof(recordData[j]) == 'object' && recordData[j].asString) {
                        recordData[j] = recordData[j].asString;
                    }
                }
            }
            subIds.push(recordData.oid);
            formsData.push(recordData);
        }

        FormDataService.updateSubFormList(formName, subFormName, formId, subIds, formsData, {
            callback: function(dataFromServer) {
                callbackFunction.call(source, records, dataFromServer);
            }
        });

    }


    /** Elimina un registro
     *
     * @param {String} form formulario
     * @param {int} id registro a borrar
     * @param {Function} callbackFunction Función a la cuál llamar
     * @param {Object} source objeto (scope) en el que ejecutar la función
     */
    this.deleteForm = function(form, id, callbackFunction, source) {
        FormDataService.deleteForm(form, id, {
            callback: function(dataFromServer) {
                callbackFunction.call(source, id, dataFromServer);
            }
        });
    }


    /** Ejecuta una acción en el servidor
     *
     * @param {function} action método a ejecutar
     * @param {array} arg Argumentos para la acción
     * @param {function} callback Función a la cuál retornar
     * @param {Function} exceptionHandler Función a la cuál llamar en caso de error
     * @param {Object} scope objeto en el que ejecutar las funciones callback y exceptionHandler
     */
    this.runAction = function(action, arg, callback, exceptionHandler, scope) {
        Ext.MessageBox.wait(this.ejecutandoTxt, this.espereTxt);

        var dwrFunctionArgs = [];
        for (var i = 0; i < arg.length; i++) {
            dwrFunctionArgs.push(arg[i]);
        }
        dwrFunctionArgs.push({
            callback: function(dataFromServer) {
                Ext.MessageBox.updateProgress(1);
                Ext.MessageBox.hide();
                callback.call(scope, dataFromServer);
            },
            exceptionHandler: function(message, exception) {
                Ext.MessageBox.updateProgress(1);
                Ext.MessageBox.hide();
                exceptionHandler.call(scope, message, exception);
            }
        });
        action.apply(Object, dwrFunctionArgs);

    }

    /** Ejecuta una acción en el servidor
     *
     * @param {function} action método a ejecutar
     * @param {array} arg Argumentos para la acción
     * @param {function} callback Función a la cuál retornar
     * @param {Function} exceptionHandler Función a la cuál llamar en caso de error
     * @param {Object} scope objeto en el que ejecutar las funciones callback y exceptionHandler
     */
    this.runSilentAction = function(action, arg, callback, exceptionHandler, scope) {
        //Ext.MessageBox.wait(this.ejecutandoTxt, this.espereTxt);

        var dwrFunctionArgs = [];
        for (var i = 0; i < arg.length; i++) {
            dwrFunctionArgs.push(arg[i]);
        }
        dwrFunctionArgs.push({
            callback: function(dataFromServer) {
                // Ext.MessageBox.updateProgress(1);
                //Ext.MessageBox.hide();
                callback.call(scope, dataFromServer);
            },
            exceptionHandler: function(message, exception) {
                //Ext.MessageBox.updateProgress(1);
                //Ext.MessageBox.hide();
                exceptionHandler.call(scope, message, exception);
            }
        });
        action.apply(Object, dwrFunctionArgs);

    }

    /**
     * Funcion para cambiar la posicion del elemento en la lista
     * @param {String} form formulario
     * @param {int} id registro a mover
     * @params {action } acción a realizar
     * @param {Function} callbackFunction Función a la cuál llamar
     * @param {Object} source objeto (scope) en el que ejecutar la función
     */
    this.actualizarPosicion = function(form, id, action, callbackFunction, source) {
        FormDataService.actualizarPosicion(form, id, action, {
            callback: function(dataFromServer) {
                callbackFunction.call(source, dataFromServer);
            }
        });
    }

    /**
     * Función para encontrar un elemento por su código de barras
     */
    this.getExpedientPerCodiCorreos = function(codigo, callbackFunction, source) {
        FormDataService.getExpedientPerCodiCorreos(codigo, {
            callback: function(dataFromServer) {
                callbackFunction.call(source, dataFromServer);
            }
        });
    }


    /**
     * Función para eliminar los datos de Auditoria depués de su exportación a csv
     */
    this.deleteAuditedValues = function(callbackFunction, source) {
        FormDataService.deleteAuditedValues({
            callback: function(dataFromServer) {
                callbackFunction.call(source, dataFromServer);
            }
        });
    }


    /**
     * Función para generar una nueva inspección
     *  @param {Array} expedientlist,  lista de id's de expedientes seleccionados para sorteo (de inspecciones)
     *  @param {Long} convocatoriaId
     *  @param {String} tipusInspeccio (c, abans concessió o p, després de pagament)
     *  @param {Function} callbackFunction Función a la cuál llamar
     *  @param {Object} source objeto (scope) en el que ejecutar la función
     */
    this.generateInspection = function(expedientlist, convocatoriaId, tipusInspeccio, callbackFunction, source) {
        FormDataService.generateInspection(expedientlist, convocatoriaId, tipusInspeccio, {
            callback: function(dataFromServer) {
                callbackFunction.call(source, dataFromServer);
            }
        });
    }


}
