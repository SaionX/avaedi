// Namespace de Ext.form.Action
Ext.namespace('Ext.form.Action');

Ext.define('Ext.form.Action.DWRLoad', {
	extend: 'Ext.form.Action',
	// Ext.extend(Ext.form.Action.DWRLoad, Ext.form.Action, {
	// private
	type: 'load',

	/**
	 * Etiqueta de texto
	 *
	 * @type {String}
	 */
	waitMsg: 'cargando...',

	/**
	 * @cfg {Function} setValuesFunction Función a la que llamar para fijar los
	 *      valores Por defecto es this.form.setValues
	 */
	setValuesFunction: null,

	/**
	 * Ejecuta la acción
	 *
	 * @method run
	 */
	run: function() {
		var dwrFunctionArgs = [];
		var loadArgs = this.dwrArgs || [];
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
		dwrFunctionArgs.push({
			// callback: this.success.createDelegate(this, this.createCallback(), 1),
			//exceptionHandler: this.failure.createDelegate(this, this.createCallback(), 1)

			callback: Ext.bind(this.dwrsuccess, this, this.createCallback(), 1),
			exceptionHandler: Ext.bind(this.dwrfailure, this, this.createCallback(), 1)
		});
		this.dwrFunction.apply(Object, dwrFunctionArgs);
	},
	dwrfailure: function(form, action) {
		if (action.failureType === Ext.form.action.Action.CONNECT_FAILURE) {
			Ext.Msg.alert('Error',
				'Status:' + action.response.status + ': ' +
				action.response.statusText);
				return;
		}
		if (action.failureType === Ext.form.action.Action.SERVER_INVALID) {
			// server responded with success = false
			Ext.Msg.alert('Invalid', action.result.errormsg);
			return;
		}
		if(action.javaClassName && action.message){
			Ext.Msg.alert('Error genérico', action.message);
			return;
		}
	},

	dwrsuccess: function(response) {
		var result = this.handleResponse(response);
		if (result === true || !result.success || !result.data) {
			this.failureType = Ext.form.Action.LOAD_FAILURE;
			this.form.form.afterAction(this, false);
			return;
		}
		this.form.form.clearInvalid();

		/*
		 * agarcia: Extender BasicForm es complicado puesto que se instancia
		 * embebido en FormPanel. Por ello, mejor personalizamos aquí setValues.
		 */
		if (this.setValuesFunction) {
			this.setValuesFunction(result.data);
		} else {
			this.form.form.setValues(result.data);
		}
		this.form.form.afterAction(this, true);
	},

	handleResponse: function(response) {
		if (this.form.reader) {
			var rs = this.form.reader.readRecords([response]);
			var data = rs.records && rs.records[0] ? rs.records[0].data : null;
			this.result = {
				success: rs.success,
				data: data
			};
			return this.result;
		}
		this.result = response;
		return this.result;
	},
	/**
	 * @class Ext.form.Action.DWRLoad Load data from DWR function<br/>
	 *        Modificado por agarcia para que cargue correctamente los
	 *        diferentes tipos de formularios de At4Framework<br/> options:
	 *        dwrFunction, dwrArgs
	 * @extends-ext Ext.form.Action
	 * @constructor
	 * @param {Object}
	 *            form
	 * @param {Object}
	 *            options
	 */
	// Ext.form.Action.DWRLoad = function(form, options){
	constructor: function(form, options) {
		//console.log("Se esta creando un DwrLoad");
		this.setValuesFunction = options.setValuesFunction;
		//Ext.apply(this, form);
		//this.options = options;
		this.form = form;
		//this.options = options;
		this.callParent([options]);
		//Ext.form.Action.DWRLoad.superclass.constructor.call(this, form, options);
	}
});
Ext.form.action.Action.dwrload = Ext.form.Action.DWRLoad;
