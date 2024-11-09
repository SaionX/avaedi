/**
 * @class At4FrameworkIntranet.FormDefaultsBase
 * Clase de utilidad para formularios At4Framework
 * @author agarcia
 * @modified garrom: Este singleton ahora esta gestionado por EXTJS, asi se pueden hacer override de idiomas y demas.
 * @singleton
 *
 * @param {Object} config
 */

Ext.define('At4FrameworkIntranet.FormDefaults', {
	singleton: true,
	//LOCALE START
	resumenAuditoriaTitleText: "Resumen de auditoría",

	resumenAuditoriaModUserTextLabel: "Usuario modificación",
	resumenAuditoriaModUserTextQtip: "Usuario que modificó el registro por última vez",
	resumenAuditoriaCreatorUserTextLabel: "Usuario creación",
	resumenAuditoriaCreatorUserTextQtip: "Usuario que dio de alta el registro",

	resumenAuditoriaModDateTextLabel: "Fecha modificación",
	resumenAuditoriaModDateTextQtip: "Fecha en que se modificó el registro por última vez",
	resumenAuditoriaCreatorDateTextLabel: "Fecha creación",
	resumenAuditoriaCreatorDateTextQtip: "Fecha en que se dio de alta el registro",


	//LOCALE END

	/** Ancho por defecto de los campos numéricos
	 * @type Number
	 */
	NUMBER_FIELD_WIDTH: 50,

	/** Ancho por defecto de los campos de texto
	 * @type Number
	 */
	TEXT_FIELD_WIDTH: 400,
	TEXT_FIELD_WIDTH_200: 200,
	COLOR_FIELD_WIDTH: 205,
	DOBLE_TEXT_FIELD_WIDTH: 660,
	YMEDIO_TEXT_FIELD_WIDTH: 490,

	/** Mitad del ancho por defecto de los campos de texto
	 * @type Number
	 */
	HALF_TEXT_FIELD_WIDTH: 150,
	THIRD_TEXT_FIELD_WIDTH: 265,

	THIRD_TEXT_FIELD_LABEL_WIDTH: 170,

	/** Cuarto del ancho por defecto de los campos de texto
	 * @type Number
	 */
	QUARTER_TEXT_FIELD_WIDTH: 90,

	TINY_TEXT_FIELD_WIDTH: 65,

	/** Ancho por defecto de los campos de textarea
	 * @type Number
	 */
	TEXTAREA_FIELD_WIDTH: 410,

	/** Alto por defecto de los campos de texto
	 * @type Number
	 */
	TEXTAREA_FIELD_HEIGHT: 180,

	/** Alto por defecto de los campos de texto
	 * @type Number
	 */
	TEXTAREA_FIELD_HEIGHT_250: 250,
	TEXTAREA_FIELD_HEIGHT_150: 150,

	/** Separador decimal
	 * @type String
	 */
	DECIMAL_SEPARATOR: '.',

	/** Configuración por defecto para las columnas de formularios
	 * @type Object
	 */
	COLUMN_DEFAULTS: {
		//width: 200,
		msgTarget: 'under',
		validationEvent: true,
		border: false,
		labelAlign: "top",
		autoHeight: true,
		autoWidth: true,
		collapsible: false,
		//bodyStyle: 'padding: 0 15px 0 0',
		//margin: '5 10 5 10'
	},

	/** Configuración por defecto para los campos de formulario
	 * @type Object
	 */
	FIELD_DEFAULTS: {
		msgTarget: 'under',
		border: false,
		labelAlign: "top"
	},

	/**
	 * Regex que testeara a los nombres de usuario
	 */
	USER_REGEX: /^([A-Za-z0-9\_\-]+)$/,

	/** Crea el store para un RelationPopup. En los registros, habrá por defecto los campos {name: "ID"}, {name: "DISPLAY"}
         * Se pueden indicar campos extra en extraFields.
         * Aparte de la configuración extra para el store que se indique en conf, se admite la configuración liveFiltersFn para
         * crear filtros extra en tiempo de ejecución:

              var liveFiltersFn =  function () {
    	  		return [
		          {
		        	  property: 'congreso',
		        	  value: application.dataId
		          }
		          ];
  				}
  				var store = At4FrameworkIntranet.FormDefaults.getStore('GrupoProductos', {}, { liveFiltersFn: liveFiltersFn	} );


         * TODO: crear una clase específica que exitenda Ext.data.Store
         * @return Ext.data.Store
         * @param {String} formName Nombre del formulario
         * @param {Array} extraFields Permite añadir más campos al registro del store
         * @param {Object} conf
         */
	getStore: function(formName, extraFields, conf, dwrfunction) {
		var campos = [{
			name: "ID"
		}, {
			name: "DISPLAY"
		}];

		if (extraFields) {
			if(extraFields instanceof Array){
				for(i in extraFields){
					var field = extraFields[i];
					campos = campos.concat(field);
				}
			}else{
				campos = campos.concat(extraFields);
			}
		}
		if (!conf) {
			conf = {}
		}

		var modelName = "At4FrameworkIntranet.generic-" + formName + "dataModel";
		var model = "";
		if (Ext.ClassManager.isCreated(modelName)) {
			model = Ext.ClassManager.get(modelName);
		} else {
			model = Ext.define(modelName, {
				extend: 'Ext.data.Model',
				proxy: serverDatabaseActions.createRelationPopupProxy(formName, modelName, conf.reader, dwrfunction),
				fields: campos
			});
		}

		if (!conf.hasOwnProperty("remoteSort")) {
			conf.remoteSort = true;
		}
		if (!conf.hasOwnProperty("remoteFilter")) {
			conf.remoteFilter = true;
		}

		conf.model = modelName;
		var store = Ext.create("Ext.data.Store", conf);

		if (conf.liveFiltersFn) {
			store.addListener("beforeload", function(store, operation) {
				//Añade los  filtros dinámicos
				var filters = conf.liveFiltersFn();

				if (filters && filters.length > 0) {
					var opFilters = operation.getConfig("filters");
					if (!opFilters) {
						opFilters = [];
					}
					operation.setConfig("filters", opFilters.concat(filters));
				}

			});

		}

		return store;
	},

	/** Obtiene la etiqueta para un campo. Usado para obtener cadenas de locale en tiempo de ejecución.
	 * @param {String} formName Nombre del formulario
	 * @param {String} fieldName Nombre del campo
	 */
	getFieldLabel: function(formName, fieldName) {
		return At4FrameworkIntranet[formName].prototype[fieldName + 'HeaderLabel'];
	},


	resumenAuditoria: function() {

		var fields = [];

		fields.dateCreation = new Ext.form.DateField({
			name: 'dateCreation',
			//fieldLabel: 'Alta',
			fieldLabel: this.resumenAuditoriaCreatorDateTextLabel,
			labelAlign: "top",
			//qtip: 'Fecha en que se dio de alta el registro',
			labelAttrTpl: " data-qtip='" + this.resumenAuditoriaCreatorDateTextQtip + "'",
			disabled: true,
			width: At4FrameworkIntranet.FormDefaults.HALF_TEXT_FIELD_WIDTH,
			format: 'd-m-Y'
		})
		fields.lastModified = new Ext.form.DateField({
			name: 'lastModified',
			//fieldLabel: 'Modificación',
			fieldLabel: this.resumenAuditoriaModDateTextLabel,
			labelAlign: "top",
			//qtip: 'Fecha en que se modificó el registro por última vez',
			labelAttrTpl: " data-qtip='" + this.resumenAuditoriaModDateTextQtip + "'",
			disabled: true,
			width: At4FrameworkIntranet.FormDefaults.HALF_TEXT_FIELD_WIDTH,
			format: 'd-m-Y'
		})
		fields.creatorUser = new Ext.form.TextField({
			name: 'creatorUser',
			//fieldLabel: 'Usuario',
			fieldLabel: this.resumenAuditoriaCreatorUserTextLabel,
			labelAlign: "top",
			//qtip: 'Usuario que dio de alta el registro',
			labelAttrTpl: " data-qtip='" + this.resumenAuditoriaCreatorUserTextQtip + "'",
			disabled: true,
			width: At4FrameworkIntranet.FormDefaults.HALF_TEXT_FIELD_WIDTH,
			maxLength: 32
		})
		fields.modUser = new Ext.form.TextField({
			name: 'modUser',
			//fieldLabel: 'Usuario',
			fieldLabel: this.resumenAuditoriaModUserTextLabel,
			labelAlign: "top",
			//qtip: 'Usuario que modificó el registro por última vez',
			labelAttrTpl: " data-qtip='" + this.resumenAuditoriaModUserTextQtip + "'",
			disabled: true,
			width: At4FrameworkIntranet.FormDefaults.HALF_TEXT_FIELD_WIDTH,
			maxLength: 32
		})


		return {
			xtype: 'fieldset',
			layout: {
				type: 'table',
				columns: 2
			},
			defaults: {
				columnWidth: 200,
				msgTarget: 'under',
				validationEvent: true,
				border: false,
				labelAlign: "top",
				autoHeight: true,
				autoWidth: true,
				collapsible: false,
				bodyStyle: 'padding: 0 15px 0 0'
			},
			border: true,
			labelAlign: "top",
			autoHeight: true,
			autoWidth: false,
			width: 500,
			animCollapse: true,
			collapsed: true,
			collapsible: true,
			//title: 'Resumen de auditoría',
			title: this.resumenAuditoriaTitleText,
			style: 'margin-top: 20px',
			items: [{
				xtype: 'fieldset',
				items: [fields.dateCreation]
			}, {
				xtype: 'fieldset',
				items: [fields.creatorUser]
			}, {
				xtype: 'fieldset',
				items: [fields.lastModified]
			}, {
				xtype: 'fieldset',
				items: [fields.modUser]
			}]

		}
	},

	columns: function(rowFields, config) {

		/*
        	 rowFields es un array bidimensional de filas y campos
        	 config es un objeto que puede incluir:
        	 	tabIndex: primer tabindex a usar
        	 */

		var columnDefaults = At4FrameworkIntranet.FormDefaults.COLUMN_DEFAULTS;
		var fieldDefaults = At4FrameworkIntranet.FormDefaults.FIELD_DEFAULTS;

		var rowNum = rowFields.length;

		//Determinamos el número de columnas y el tabIndex
		var colNum = rowFields[0].length;

		var firstTabIndex = -1;
		if (config && config.tabIndex) {
			firstTabIndex = config.tabIndex;
		}
		for (var i = 0; i < rowNum; i++) {
			if (rowFields[i].length > colNum) {
				colNum = rowFields[i].length;
			}
			if (firstTabIndex == -1) {
				for (var j = 0; j < rowFields[i].length; j++) {
					if (rowFields[i][j].tabIndex) {
						firstTabIndex = rowFields[i][j].tabIndex;
						break;
					}
				}
			}
		}

		var items = [];
		for (var i = 0; i < colNum; i++) {

			items[i] = {
				// defaults: fieldDefaults,
				xtype: 'fieldset',
				cls: "at4-fieldset",
				defaults: {
					//style: "padding: 0",
					labelAlign: "top",
					padding: 0,
					//margin: "5 0 20 0"
				},
				items: []
			}
			for (var j = 0; j < rowNum; j++) {
				if (rowFields[j][i]) {
					items[i].items[j] = rowFields[j][i];
					items[i].items[j].parentSubFormItem = items[i];
					if (firstTabIndex != -1) {
						//Calculamos el tabIndex
						// items[i].items[j].tabIndex = firstTabIndex + (j * colNum) + i;
					}

				}
			}

		}

		return {
			xtype: 'container',
			layout: 'column',
			defaults: columnDefaults,
			border: false,
			labelAlign: "top",
			style: "padding: 0",
			autoHeight: true,
			//autoWidth: true,
			width: "100%",
			collapsible: false,
			items: items
		};
	},

	rows: function(rowFields, config, rowconfig) {
		var mainItems = [];
		Ext.each(rowFields, function(rowItem, rowIndex, rowArray) {
			var rowItems = [];
			Ext.each(rowItem, function(colItem, colIndex, colArray) {
				rowItems.push(colItem);
			});
			mainItems.push(Ext.apply({
				xtype: "At4Framework-rowContainer",
				items: rowItems
			}, rowconfig))
		});
		var toReturn = Ext.apply({
			xtype: "At4Framework-fieldmainpanel",
			items: mainItems
		}, config)
		return toReturn;
	},

	debugButton: function(scope) {
		return {
			text: "debug",
			hidden: !window.At4Framework_modoDesarrollo,
			scope: scope,
			handler: function() {
				var values = scope.getForm().getValues();
				console.log(values);
				var pretify = function(values) {
					var toreturn = "<table><tr><td>Field</td><td>Value</td></tr>";
					for (i in values) {
						var value = values[i] ? values[i] : "undefined";
						toreturn += "<tr><td>" + i + "</td><td>" + value + "</td></tr>";
					}
					toreturn += "</table>";
					return toreturn;
				}
				Ext.create("Ext.window.Window", {
					title: "debug",
					resizable: true,
					autoScroll: true,
					width: 500,
					height: 400,
					html: pretify(values)
				}).show()
			}
		};
	},

	tabIndexer: function(fields, firstTabIndex) {
		if (!firstTabIndex) {
			firstTabIndex = 0;
			for (i in fields) {
				if (fields.hasOwnProperty(i) && fields[i].tabindex) {
					firstTabIndex = Math.max(firstTabIndex, fields[i].tabindex);
				}
			}
		}
		var tabindex = firstTabIndex
		for (i in fields) {
			if (fields.hasOwnProperty(i)) {
				fields[i].tabIndex = tabindex++;
			}
		}
		return fields;
	},
	radioMaker: function(items, config) {
		var radioItems = [];
		Ext.each(items, function(item, itemIndex, items) {
			radioItems.push({


			});
		});

	},
	size: function(multiplier, separaciones, totalcount){
		//var size =this.BASE_SIZE * (multiplier*2);
		//var total = this.BASE_SIZE * totalcount;
		var separacionsSize = 20 * separaciones;

		return (((totalcount * this.BASE_SIZE) - separacionsSize) / totalcount) * multiplier



/*
		if(separacionesIncl){
			size = size + (this.BASE_SIZE*separacionesIncl);
		}
		if(separacionesExcl){
			size = size - (this.BASE_SIZE*separacionesExcl);
		}
		return size;*/
	},
	BASE_SIZE: 70,
});
