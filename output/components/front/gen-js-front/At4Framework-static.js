At4util = {};
At4util.formatConstrainsLegacy = function(data) {
	var xrec = data.XRecommended ? data.XRecommended : null;
	var yrec = data.YRecommended ? data.YRecommended : null;
	var xrec_pro = data.XRecommendedMandatory ? data.XRecommendedMandatory : null;
	var yrec_pro = data.YRecommendedMandatory ? data.YRecommendedMandatory : null;

	var xmax = data.XMax ? data.XMax : null;
	var ymax = data.YMax ? data.YMax : null;
	var xmax_pro = data.XMaxMandatory ? data.XMaxMandatory : null;
	var ymax_pro = data.YMaxMandatory ? data.YMaxMandatory : null;

	var xmin = data.XMin ? data.XMin : null;
	var ymin = data.YMin ? data.YMin : null;
	var xmin_pro = data.XMinMandatory ? data.XMinMandatory : null;
	var ymin_pro = data.YMinMandatory ? data.YMinMandatory : null;

	var donemax = false;
	var donemin = false;
	var html = "";
	if (yrec || xrec || xrec_pro || yrec_pro || xmax || ymax || ymax_pro || xmax_pro || ymin || xmin || ymin_pro || xmin_pro) {
		if (xrec_pro && xrec && yrec_pro && yrec) {
			html = "Tamaño <b> obligatorio </b>: " + xrec + "x" + yrec + " pixels<br>";
		} else {
			if (xrec && xrec_pro) {
				html += "Ancho <b>obligatorio</b>: " + xrec + "pixels<br>";
			}
			if (yrec && yrec_pro) {
				html += "Alto <b>obligatorio</b>: " + yrec + "pixels<br>";
			}
			if (xrec && yrec) {
				html += "Tamaño <b>recomendado</b>: " + xrec + "x" + yrec + " pixeles<br>";
			}
			if (xmax_pro && xmax && ymax_pro && ymax) {
				html += "Tamaño <b>maximo</b>: " + xmax + "x" + ymax + " pixeles<br>";
				donemax = true;
			}
			if (xmin_pro && xmin && ymin_pro && ymin) {
				html += "Tamaño <b>minimo</b>: " + xmin + "x" + ymin + " pixeles<br>";
				donemin = true;
			}
			if (!xmax_pro && xmax && !ymax_pro && ymax) {
				html += "Tamaño <b>maximo recomendado</b>: " + xmax + "x" + ymax + " pixeles<br>";
				donemax = true;
			}
			if (!xmin_pro && xmin && !ymin_pro && ymin) {
				html += "Tamaño <b>minimo recomendado</b>: " + xmin + "x" + ymin + " pixeles<br>";
				donemin = true;
			}
			if (!donemax) {
				if (xmax && xmax_pro) {
					html += "Ancho <b>maximo obligatorio</b>: " + xmax + "pixeles <br>";
				} else if (xmax) {
					html += "Ancho <b>maximo recomendado</b>: " + xmax + "pixeles <br>";

				}
			}
			if (ymax && ymax_pro) {
				html += "Alto <b>maximo obligatorio</b>: " + ymax + "pixeles <br>";
			} else if (ymax) {
				html += "Alto <b>maximo recomendado</b>: " + ymax + "pixeles <br>";

			}
			if (!donemin) {
				if (xmin && xmin_pro) {
					html += "Ancho <b>minimo obligatorio</b>: " + xmin + "pixeles <br>";
				} else if (ymin) {
					html += "Ancho <b>minimo recomendado</b>: " + xmin + "pixeles <br>";
				}
			}
			if (ymin && ymin_pro) {
				html += "Alto <b>minimo obligatorio</b>: " + ymin + "pixeles <br>";
			} else if (ymin) {
				html += "Alto <b>minimo recomendado</b>: " + ymin + "pixeles <br>";
			}

		}
	} else {
		html = "No hay restricciones para este archivo";
	}
	return html;
};

At4util.formatConstrainsLocale = function(data) {
	var xrec = data.XRecommended ? data.XRecommended : null;
	var yrec = data.YRecommended ? data.YRecommended : null;
	var xrec_pro = data.XRecommendedMandatory ? data.XRecommendedMandatory : null;
	var yrec_pro = data.YRecommendedMandatory ? data.YRecommendedMandatory : null;

	var xmax = data.XMax ? data.XMax : null;
	var ymax = data.YMax ? data.YMax : null;
	var xmax_pro = data.XMaxMandatory ? data.XMaxMandatory : null;
	var ymax_pro = data.YMaxMandatory ? data.YMaxMandatory : null;

	var xmin = data.XMin ? data.XMin : null;
	var ymin = data.YMin ? data.YMin : null;
	var xmin_pro = data.XMinMandatory ? data.XMinMandatory : null;
	var ymin_pro = data.YMinMandatory ? data.YMinMandatory : null;

	var donemax = false;
	var donemin = false;
	var html = "";
	var loc = At4util.constrainsLang;
	if (yrec || xrec || xrec_pro || yrec_pro || xmax || ymax || ymax_pro || xmax_pro || ymin || xmin || ymin_pro || xmin_pro) {
		if (xrec_pro && xrec && yrec_pro && yrec) {
			html = loc.tObligado + Ext.String.format(loc.dos, xrec, yrec) + loc.br;
		} else {
			if (xrec && xrec_pro) {
				html += loc.wObligado + Ext.String.format(loc.uno, xrec) + loc.br;
				//html += "Ancho <b>obligatorio</b>: " + xrec + "pixels<br>";
			}
			if (yrec && yrec_pro) {
				html += loc.hObligado + Ext.String.format(loc.uno, yrec) + loc.br;
				//html += "Alto <b>obligatorio</b>: " + yrec + "pixels<br>";
			}
			if (xrec && yrec) {
				html += loc.tRecomendado + Ext.String.format(loc.dos, xrec, yrec) + loc.br;
				//html += "Tamaño <b>recomendado</b>: " + xrec + "x" + yrec + " pixeles<br>";
			}
			if (xmax_pro && xmax && ymax_pro && ymax) {
				html += loc.tMax + Ext.String.format(loc.dos, xmax, ymax) + loc.br;
				//html += "Tamaño <b>maximo</b>: " + xmax + "x" + ymax + " pixeles<br>";
				donemax = true;
			}
			if (xmin_pro && xmin && ymin_pro && ymin) {
				html += loc.tMin + Ext.String.format(loc.dos, xmin, ymin) + loc.br;
				//html += "Tamaño <b>minimo</b>: " + xmin + "x" + ymin + " pixeles<br>";
				donemin = true;
			}
			if (!xmax_pro && xmax && !ymax_pro && ymax) {
				html += loc.tMaxRecomendado + Ext.String.format(loc.dos, xmax, ymax) + loc.br;
				//html += "Tamaño <b>maximo recomendado</b>: " + xmax + "x" + ymax + " pixeles<br>";
				donemax = true;
			}
			if (!xmin_pro && xmin && !ymin_pro && ymin) {
				html += loc.tMinRecomendado + Ext.String.format(loc.dos, xmin, ymin) + loc.br;
				//html += "Tamaño <b>minimo recomendado</b>: " + xmin + "x" + ymin + " pixeles<br>";
				donemin = true;
			}
			if (!donemax) {
				if (xmax && xmax_pro) {
					html += loc.wMaxObligado + Ext.String.format(loc.uno, xmax) + loc.br;
					//html += "Ancho <b>maximo obligatorio</b>: " + xmax + "pixeles <br>";
				} else if (xmax) {
					html += loc.wMaxRecomendado + Ext.String.format(loc.uno, xmax) + loc.br;
					//html += "Ancho <b>maximo recomendado</b>: " + xmax + "pixeles <br>";
				}
			}
			if (ymax && ymax_pro) {
				html += loc.hMaxObligado + Ext.String.format(loc.uno, ymax) + loc.br;
				//html += "Alto <b>maximo obligatorio</b>: " + ymax + "pixeles <br>";
			} else if (ymax) {
				html += loc.hMaxRecomendado + Ext.String.format(loc.uno, ymax) + loc.br;
				//html += "Alto <b>maximo recomendado</b>: " + ymax + "pixeles <br>";
			}
			if (!donemin) {
				if (xmin && xmin_pro) {
					html += loc.wMinObligado + Ext.String.format(loc.uno, xmin) + loc.br;
					//html += "Ancho <b>minimo obligatorio</b>: " + xmin + "pixeles <br>";
				} else if (ymin) {
					html += loc.wMinRecomendado + Ext.String.format(loc.uno, xmin) + loc.br;
					//html += "Ancho <b>minimo recomendado</b>: " + xmin + "pixeles <br>";
				}
			}
			if (ymin && ymin_pro) {
				html += loc.hMinObligado + Ext.String.format(loc.uno, ymin) + loc.br;
				//html += "Alto <b>minimo obligatorio</b>: " + ymin + "pixeles <br>";
			} else if (ymin) {
				html += loc.hMinRecomendado + Ext.String.format(loc.uno, ymin) + loc.br;
				//html += "Alto <b>minimo recomendado</b>: " + ymin + "pixeles <br>";
			}
		}
	} else {
		html = loc.noHay;
		//html = "No hay restricciones para este archivo";
	}
	return html;
};

At4util.formatConstrains = function(data) {
	var usarLocale = true;
	if (usarLocale) {
		return At4util.formatConstrainsLocale(data);
	}
	return At4util.formatConstrainsLegacy(data);
};

At4util.formatFileConstrainsString = function(data) {
	var loc = At4util.constrainsLang;
	var br = loc.br;
	var html = "";
	if (data.maxKb > 0) {
		html += loc.tMax + " " + data.maxKb + loc.kb + br;
	}
	//html += "Tamaño <b>maximo</b>: " + data.maxKb + "Kb." + br;
	html += br + loc.formatosAdmitidos + br;
	//html += br + "Formatos admitidos:" + br;
	var contador = 0;
	for (i in data.mimeTypes) {
		if (contador != 0) {
			html += ", ";
		}
		contador++;
		html += i;
	};
	if (contador == 0) {
		html += loc.todosFormatos;
		//html += "Todos los formatos estan admitidos.";
	}
	return html;
};

At4util.formatFileConstrainsTable = function(data) {
	var loc = At4util.constrainsLang;
	var br = loc.br;
	var html = "";
	if (data.maxKb > 0) {
		html += loc.tMax + " " + data.maxKb + loc.kb + br;
	}
	//html += "Tamaño <b>maximo</b>: " + data.maxKb + "Kb." + br;
	html += br + loc.formatosAdmitidos + br;
	//html += br + "Formatos admitidos:" + br;
	var length = Object.keys(data.mimeTypes).length;
	if (length > 0) {
		html += loc.table.start;
		//html += "<table><thead><tr><th>Formato</th><th>Mime</th></tr></thead><tbody>";
		for (i in data.mimeTypes) {
			html += Ext.String.format(loc.table.row, i, data.mimeTypes[i]);
			//html += "<tr><td>" + i + "</td><td>" + data.mimeTypes[i] + "</td></tr>";
		};
		html += loc.table.end;
		//html += "</tbody></table>";
	}
	if (length == 0) {
		html += loc.todosFormatos;
		//html += "Todos los formatos estan admitidos.";
	}
	return html;
};

At4util.formatFileConstrains = function(data) {
	var table = false;
	if (table) {
		return At4util.formatFileConstrainsTable(data);
	}
	return At4util.formatFileConstrainsString(data);
};


At4util.icons = {
	//Old: 'icon-plus',
	plus: "glyphicons glyphicons-plus-sign",
	//Old: 'icon-update'
	update: "glyphicons glyphicons-restart",
	//Old: 'icon-minus'
	remove: 'glyphicons glyphicons-bin',
	//Old: 'icon-open'
	editar: 'glyphicons glyphicons-edit',
	//Old: 'icon-add'
	add: 'glyphicons glyphicons-plus-sign',
	//Old: 'icon-export'
	exportar: 'glyphicons glyphicons-file-export',
	//Old: 'icon-close'
	close: 'glyphicons glyphicons-remove',
	//glyphicons glyphicons-floppy-disk
	order: 'glyphicons glyphicons-disk-saved',
	herramientas: 'glyphicons glyphicons-settings',
	avanzado: 'glyphicons glyphicons-more-windows',
	configure: "glyphicons glyphicons-cogwheel",

	save: "glyphicons glyphicons-floppy-disk",
	restart: "glyphicons glyphicons-restart",

	apply: "glyphicons glyphicons-download-alt",

	auditarForm: "glyphicons glyphicons-cardio",
	validarForm: "glyphicons glyphicons-eye-open",
	validar: "glyphicons glyphicons-ok-circle",
	rechazar: "glyphicons glyphicons-remove-circle",
	posponer: "glyphicons glyphicons-roundabout",
};

At4util.formatTitularLabel = function(formvals){
	var valNombre = formvals.nombre;
	var valApellidos = formvals.apellidos;
	var valApellidosRep = formvals.apellidosRepresentante;
	var valTitularLabel = "";
	if(valNombre!= null){
		valTitularLabel += valNombre + " - ";
	}
	valTitularLabel += valApellidos;
	if(valApellidosRep != null){
		valTitularLabel += " - " + valApellidosRep;
	}
	return valTitularLabel;
}


//Objeto que ayudara a generar los tabIndex de los formularios
At4util.tabIndexHelper = function(firstTabItem, tabsPerItem) {
	//constructor
	this.tabItem = firstTabItem ? firstTabItem : 1;
	//Por donde empezara el tabItem
	this.tabsPerItem = tabsPerItem ? tabsPerItem : 100;
	//Cantidad de "tabs" que avanzara por cada item.

};

At4util.tabIndexHelper.prototype.getNext = function() {
	this.tabItem = this.tabItem + this.tabsPerItem;
	return this.tabItem;
};
﻿/**
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
// Namespace de Ext.util
Ext.namespace('Ext.util');

/**
 * @class Ext.util.Format
 * Extensiones (overrides) a la clase de ext
 * @extends-ext Ext.util.Format
 * 
 */

/**
 * Formatea un número como moneda €
 * @method euroMoney
 * @param {Number/String} v El valor numérico a formatear
 * @return {String} La cadena monetaria formateada
 */
Ext.util.Format.euroMoney = function(v) {

	v = (Math.round((v - 0) * 100)) / 100;
	v = (v == Math.floor(v)) ? v + ".00" : ((v * 10 == Math.floor(v * 10)) ? v + "0" : v);
	v = String(v);
	var ps = v.split('.');
	var whole = ps[0];
	var sub = ps[1] ? ',' + ps[1] : ',00';
	var r = /(\d+)(\d{3})/;
	while (r.test(whole)) {
		whole = whole.replace(r, '$1' + '.' + '$2');
	}
	v = whole + sub;
	return v + " €";

};

Ext.util.Format.Doblers = function(v) {

	v = (Math.round((v - 0) * 100)) / 100;
	v = (v == Math.floor(v)) ? v + ".00" : ((v * 10 == Math.floor(v * 10)) ? v + "0" : v);
	v = String(v);
	var ps = v.split('.');
	var whole = ps[0];
	var sub = ps[1] ? ',' + ps[1] : ',00';
	var r = /(\d+)(\d{3})/;
	while (r.test(whole)) {
		whole = whole.replace(r, '$1' + '.' + '$2');
	}
	v = whole + sub;
	return v;

};


/**
 * Formatea un número según el locale 'ES': ###.###,##
 * @method esNumber
 * @param {Number/String} v El valor numérico a formatear
 * @return {String} La cadena formateada
 */
Ext.util.Format.esNumber = function(v) {

	v = String(v);

	var ps = v.split('.');
	var whole = ps[0];
	var sub = ps[1] ? ',' + ps[1] : '';
	var r = /(\d+)(\d{3})/;
	while (r.test(whole)) {
		whole = whole.replace(r, '$1' + '.' + '$2');
	}
	return whole + sub;

}

Ext.apply(Ext.util.Format, {
	numberFormat: {
		decimalSeparator: ',',
		decimalPrecision: 2,
		groupingSeparator: '.',
		groupingSize: 3,
		currencySymbol: '€'
	},

	/**
	 * Formatea un número según la configuración recibida en numberFormat
	 * @param {Object} value El valor numérico a formatear
	 * @param {Object} numberFormat Objeto conteniendo las propiedades: decimalSeparator, decimalPrecision, groupingSeparator, groupingSize, currencySymbol
	 */
	formatNumber: function(value, numberFormat) {
		var format = Ext.apply(Ext.apply({}, this.numberFormat), numberFormat);
		if (typeof value !== 'number') {
			value = String(value);
			if (format.currencySymbol) {
				value = value.replace(format.currencySymbol, '');
			}
			if (format.groupingSeparator) {
				value = value.replace(new RegExp(format.groupingSeparator, 'g'), '');
			}
			if (format.decimalSeparator !== '.') {
				value = value.replace(format.decimalSeparator, '.');
			}
			value = parseFloat(value);
		}
		var neg = value < 0;
		value = Math.abs(value).toFixed(format.decimalPrecision);
		var i = value.indexOf('.');
		if (i >= 0) {
			if (format.decimalSeparator !== '.') {
				value = value.slice(0, i) + format.decimalSeparator + value.slice(i + 1);
			}
		} else {
			i = value.length;
		}
		if (format.groupingSeparator) {
			while (i > format.groupingSize) {
				i -= format.groupingSize;
				value = value.slice(0, i) + format.groupingSeparator + value.slice(i);
			}
		}
		if (format.currencySymbol) {
			value = format.currencySymbol + value;
		}
		if (neg) {
			value = '-' + value;
		}
		return value;
	}
});

/*
This file is part of Ext JS 3.4

Copyright (c) 2011-2013 Sencha Inc

Contact:  http://www.sencha.com/contact

GNU General Public License Usage
This file may be used under the terms of the GNU General Public License version 3.0 as
published by the Free Software Foundation and appearing in the file LICENSE included in the
packaging of this file.

Please review the following information to ensure the GNU General Public License version 3.0
requirements will be met: http://www.gnu.org/copyleft/gpl.html.

If you are unsure which license is appropriate for your use, please contact the sales department
at http://www.sencha.com/contact.

Build date: 2013-04-03 15:07:25
*/
// Add the additional 'advanced' VTypes
Ext.apply(Ext.form.VTypes, {
    daterange : function(val, field) {
        var date = field.parseDate(val);

        if(!date){
            return false;
        }
        if (field.startDateField) {
            var start = Ext.getCmp(field.startDateField);
            if (!start.maxValue || (date.getTime() != start.maxValue.getTime())) {
                start.setMaxValue(date);
                start.validate();
            }
        }
        else if (field.endDateField) {
            var end = Ext.getCmp(field.endDateField);
            if (!end.minValue || (date.getTime() != end.minValue.getTime())) {
                end.setMinValue(date);
                end.validate();
            }
        }
        /*
         * Always return true since we're only using this vtype to set the
         * min/max allowed values (these are tested for after the vtype test)
         */
        return true;
    },

    password : function(val, field) {
        if (field.initialPassField) {
            var pwd = Ext.getCmp(field.initialPassField);
            return (val == pwd.getValue());
        }
        return true;
    },

    passwordText : 'Passwords do not match'
});

/*
Ext.onReady(function(){

    Ext.QuickTips.init();

    // turn on validation errors beside the field globally
    Ext.form.Field.prototype.msgTarget = 'side';

    var bd = Ext.getBody();

     //================  Date Range  =======================

    var dr = new Ext.FormPanel({
      labelWidth: 125,
      frame: true,
      title: 'Date Range',
      bodyStyle:'padding:5px 5px 0',
      width: 350,
      defaults: {width: 175},
      defaultType: 'datefield',
      items: [{
        fieldLabel: 'Start Date',
        name: 'startdt',
        id: 'startdt',
        vtype: 'daterange',
        endDateField: 'enddt' // id of the end date field
      },{
        fieldLabel: 'End Date',
        name: 'enddt',
        id: 'enddt',
        vtype: 'daterange',
        startDateField: 'startdt' // id of the start date field
      }]
    });

    dr.render('dr');

    //================  Password Verification =======================

    var pwd = new Ext.FormPanel({
      labelWidth: 125,
      frame: true,
      title: 'Password Verification',
      bodyStyle:'padding:5px 5px 0',
      width: 350,
      defaults: {
        width: 175,
        inputType: 'password'
      },
      defaultType: 'textfield',
      items: [{
        fieldLabel: 'Password',
        name: 'pass',
        id: 'pass'
      },{
        fieldLabel: 'Confirm Password',
        name: 'pass-cfrm',
        vtype: 'password',
        initialPassField: 'pass' // id of the initial password field
      }]
    });

    pwd.render('pw');
});
*/
Ext.define("At4FrameworkIntranet.ApplicationBasic", {
    extend: 'Ext.Mixin',

	// public properties, e.g. strings to translate

	/* * Cadenas de locale */

	/**
	 * Texto por defecto en la barra de estado
	 *
	 * @type {String}
	 */
	statusBarDefaultTxt: 'Listo',

	/**
	 * Mensaje loading mientras se carga el menu
	 *
	 * @type {String}
	 */
	cargandoMenuTxt: 'Cargando menú...',

	/**
	 * Titulo del tab de registro
	 *
	 * @type {String}
	 */
	registerTabTitle: '{0}: registro',

	/**
	 * Titulo del tab de nuevo registro
	 *
	 * @type {String}
	 */
	newRegisterTabTitle: '{0}: nuevo',

	/**
	 * Titulo del tab de registro de apertura directa
	 *
	 * @type {String}
	 */
	registerTabTitleAperturaDirecta: '{0}: ',

	/**
	 * Titulo del tab inicial
	 *
	 * @type {String}
	 */
	startTabTitle: 'Inicio',

	/**
	 * Titulo del mensaje de sesión expirada
	 *
	 * @type {String}
	 */
	sessionExpiredTitle: 'Sesión expirada',

	/**
	 * Texto del mensaje de sesión expirada
	 *
	 * @type {String}
	 */
	sessionExpiredMsg: 'Su sesión ha expirado, por favor, autentifíquese de nuevo.\nPara evitar esto en el futuro, marque la casilla "Recordar la contraseña"',

	/**
	 * Texto de la caja de insertar codigo de barras
	 *
	 * @type {String}
	 */
	introducir: 'Introducir:',

	/**
	 * Texto de la cabecera de mensaje de error
	 *
	 * @type {String}
	 */
	error: 'Error',

	/**
	 * Idioma actual
	 *
	 * @type {String}
	 */
	idioma: 'es',

	/**
	 * Tema actual
	 *
	 * @type {String}
	 */
	tema: At4Framework_activeTheme ? At4Framework_activeTheme : "at4",

	/**
	 * Contexto actual
	 *
	 * @type {String} TODO: generalizar
	 */
	contextPath: '/acireback',

	/**
	 * Panel con la barra de menús
	 *
	 * @type Ext.Toolbar
	 */
	toolbar: null,

	/**
	 * Panel de pestañas
	 *
	 * @type Ext.TabPanel
	 */
	tabPanel: null,

	/**
	 * barra de estado
	 *
	 * @type Ext.StatusBar
	 */
	statusBar: null,

	menuSearchPlaceholder: "Abrir...",

    //TODO: Localear
    afterRelogFormMsg: "Su sesión caducó al realizar su última acción y ésta fue rechazada, por favor vuelva a realizar dicha acción.",
    afterRelogFormTitle: "Advertencia!",
});
/**
 * @author: garrom
 * Mixin de simpleMultilang. Añade la posibilidad de multiIdioma a un campo.
 * Para ello solo se tiene que añadir los triggers con el boton y que llame a los metodos de este mixin
 * Ejemplo:
 *
 * Ext.define("xxx", {
 *     extend: "xxx",
 *     mixins: {
 *         multilang: 'At4Framework.mixin.simpleMultilang'
 *     },
 *     triggers: {
 *         selIdioma: {
 *             cls: "multilang-icon-Es",
 *             handler: function() {
 *                 this.mixin.multilangseleccionarIdioma.call(this, this.currentLang + 1);
 *             }
 *         }
 *     },
 *     (...)
 * });
 *
 */

Ext.define('At4FrameworkIntranet.mixin.simpleMultilang', {
    extend: 'Ext.Mixin',

    menuAll: null,
    flagSetValue: true,

    width: At4FrameworkIntranet.FormDefaults.TEXT_FIELD_WIDTH,

    langs: ['Es', 'Ca'],

    //Sobreescribible por instalación
    //langs: ['Es', 'En', 'Ca', 'De'],
    //OJO! Hay que editar tambien basicform multilangRE para que el getFieldEditor funcione bien


    //langs: ['Es', 'En', 'Ct'],


    /* constructor: function(config) {
         //this.initConfig(config);
         console.log("mixin constructor called");
     },*/

    /*initComponent: function() {
        var i;
        var lang;
        var name;
        this.inputs = {};
        //TODO: el idioma inicial
        this.currentLang = 0;
        for (i = 0; i < this.langs.length; i++) {
            lang = this.langs[i];
            name = this.name + lang;
            this.inputs[lang] = new Ext.form.field.Text({
                name: this.name + lang,
                multilang: this,
                lang: lang,
                hidden: true,
                setValue: function(v, reloaded) {
                    Ext.form.field.Text.superclass.setValue.call(this, v);
                    if (!reloaded) {
                        this.multilang.setLangValue(this.lang, v);
                    }
                }
            })
        }
    },*/
    initComponent: function(inputType) {
        //this.callParent();
        var i;
        var lang;
        var name;
        this.inputs = {};
        this.inputsArray = [];
        var inputType = inputType ? inputType : "Text";

        //TODO: el idioma inicial
        this.currentLang = 0;

        for (i = 0; i < this.langs.length; i++) {
            lang = this.langs[i];
            name = this.name + lang;
            var item = Ext.create("Ext.form.field." + inputType, {
                name: this.name + lang,
                multilang: this,
                lang: lang,
                style: "margin: 0px 3px 0px 3px; left: 0px; width: 100%",
                //label: "test"+lang,
                labelAlign: "left",
                hidden: true,
                triggers: {
                    selIdioma: {
                        cls: "multilang-icon-" + lang,
                        extraCls: "multilang-icon-static"
                    }
                },
                setValue: function(v) {

                    Ext.form.field[inputType].superclass.setValue.call(this, v);
                    this.multilang.setLangValue(this.lang, v);
                }
            });
            this.inputs[lang] = item;
            if (this.parentForm) {
                this.parentForm.hiddenFields.push(item);
            }
            this.inputsArray.push(item);
        }
        this.menuAll = Ext.create('Ext.menu.Menu', {
            cls: "multilang-menu",
            layout: 'vbox'
        });
    },

    seleccionarIdioma: function(numero) {
        this.inputs[this.langs[this.currentLang]].setValue(this.getValue());
        var prevLang = this.currentLang;

        this.currentLang = numero;
        if (this.currentLang >= this.langs.length) {
            this.currentLang = 0;
        }
        if (this.currentLang < 0) {
            this.currentLang = this.langs.length - 1;
        }
        this.setValue(this.inputs[this.langs[this.currentLang]].getValue());
        this.triggers.selIdioma.el.removeCls('multilang-icon-' + this.langs[prevLang]).addCls('multilang-icon-' + this.langs[this.currentLang]);
    },

    setLangValue: function(lang, v) {
        if (lang !== this.langs[this.currentLang]) {
            //console.log("LANG: El lang", lang, "no es el actual", this.langs[this.currentLang], "para valor", v);
            return;
        }
        if (!this.flagSetValue) {
            //console.log("LANG: El flagSetValue es falso", lang, v);
            this.flagSetValue = true;
            return;
        }
        //console.log("LANG: seteamos value", lang, v);
        this.setValue(v);
    },
    listeners: {
        render: function(el, eOpts) {
            var i, lang, name;
            for (i = 0; i < this.langs.length; i++) {
                lang = this.langs[i];
                name = this.name + lang;
                this.ownerCt.add(this.inputs[lang]);
            }

        },
        change: function() {
            var input = this.inputs[this.langs[this.currentLang]];
            var value = this.getValue();
            input.setValue(value, true);
            this.flagSetValue = false;
        }
    },

    /**
     * Sobreescribimos getErrors para poder desactivar validación para los idiomas secundarios
     * TODO: Cada idioma podría tener sus características de validación, pero por ahora sólo tenemos los del idioma principal
     */

    checkError: function(value) {
        /*
                if (this.currentLang == 0) {
                    //return At4FrameworkIntranet.MultilangText.superclass.getErrors.apply(this, arguments);
                    return this.callParent(arguments);
                } else {
                    return [];
                }*/
        return this.currentLang == 0;
    }

});


/**
 * @author: garrom
 * Extension del mixin: At4Framework.mixin.simpleMultilang
 * Mixin de MenuMultilang. Añade al multiidioma, un menu desplegable
 * Para ello solo hay que añadir al trigger existente uno nuevo
 * Ejemplo:
 *
 * Ext.define("xxx", {
 *     extend: "xxx",
 *     mixins: {
 *         multilang: 'At4Framework.mixin.MenuMultilang'
 *     },
 *     triggers: {
 *         selIdioma: {
 *             cls: "multilang-icon-Es",
 *             handler: function() {
 *                 this.mixin.multilangseleccionarIdioma.call(this, this.currentLang + 1);
 *             }
 *         },
 *         dropIdioma: {
 *            cls: "multilang-all",
 *            handler: function() {
 *                this.mixins.multilang.desplegarIdiomas.call(this);
 *           }
 *     },
 *     (...)
 * });
 *
 */
Ext.define('At4FrameworkIntranet.mixin.MenuMultilang', {
    extend: 'At4FrameworkIntranet.mixin.simpleMultilang',

    desplegarIdiomas: function() {
        if (!this.itemsAddedToMenu) {
            this.menuAll.add(this.menuItems);
            this.itemsAddedToMenu = true;
        }
        for (i = 0; i < this.menuAll.items.items.length; i++) {
            if (this.menuAll.items.items[i].lang == this.langs[this.currentLang]) {
                this.menuAll.items.items[i].hide();
            } else {
                this.menuAll.items.items[i].show();
            }
        }
        var xy = this.getXY();
        xy[1] = xy[1] + this.getHeight();
        this.menuAll.setWidth(this.getWidth());
        this.menuAll.showAt(xy);
    },

    initComponent: function() {
        this.callParent(arguments);
        this.menuItems = [];
        //Añade un editor al menu que lo que hara es cambiar el valor del field que debe.
        Ext.each(this.inputsArray, function(input, inputIndex, inputsArray) {
            var item = {
                xtype: "textfield",
                triggers: input.triggers,
                lang: input.lang,
                inputMainField: input,
                listeners: {
                    change: {
                        fn: function(obj, value) {
                            this.setValue(value);
                            //console.log("menu changed");
                        },
                        scope: input
                    },
                    render: {
                        fn: function(obj, opts) {
                            obj.setValue(obj.inputMainField.getValue());
                        }
                    }
                },
            };
            this.menuItems.push(item);
            var actualizarValueFn = function(obj, value) {
                if (obj.tempField) {
                    console.log("tempField changed");
                    obj.tempField.setValue(value);
                } else {
                    for (i in this.menuAll.items.items) {
                        if (this.menuAll.items.items.hasOwnProperty(i)) {
                            obj.tempField = this.menuAll.items.items[i];
                            if (obj.tempField.lang == obj.lang) {
                                obj.tempField.setValue(value);
                                break;
                            }
                        }
                    }
                }
            };
            input.addListener("change", actualizarValueFn, this);


        }, this);

    },

    menuItems: [],
    itemsAddedToMenu: false,

    listeners: {
        render: function(el, eOpts) {
            var i, lang, name;
            for (i = 0; i < this.langs.length; i++) {
                lang = this.langs[i];
                name = this.name + lang;
                this.ownerCt.add(this.inputs[lang]);
            }


        },
        keypress: function(comp, ev, eOpts) {
            var avanzar = true;
            switch (ev.keyCode) {
                case 13:
                    avanzar = true;
                    break;
                case 18:
                    avanzar = false;
                    break;
                default:
                    return;
            }
            avanzar = ev.shiftKey ? !avanzar : avanzar;
            if (avanzar) {
                this.seleccionarIdioma(this.currentLang + 1);
            } else {
                this.seleccionarIdioma(this.currentLang - 1);
            }
        },
        change: function() {
            this.inputs[this.langs[this.currentLang]].setValue(this.getValue(), true);
            //this.inputs[this.langs[this.currentLang]].inputMainField.setValue(this.getValue(), true);
        }
    },

    /*initComponent: function() {
        //this.callParent();
        var i;
        var lang;
        var name;
        this.inputs = {};
        this.inputsArray = [];

        //TODO: el idioma inicial
        this.currentLang = 0;

        for (i = 0; i < this.langs.length; i++) {
            lang = this.langs[i];
            name = this.name + lang;
            var item = Ext.create("Ext.form.field.Text", {
                name: this.name + lang,
                multilang: this,
                lang: lang,
                style: "margin: 0px 3px 0px 3px; left: 0px; width: 100%",
                //label: "test"+lang,
                labelAlign: "left",
                hidden: true,
                triggers: {
                    selIdioma: {
                        cls: "multilang-icon-" + lang,
                    }
                },
                setValue: function(v) {
                    Ext.form.field.Text.superclass.setValue.call(this, v);
                    this.multilang.setLangValue(this.lang, v);
                }
            });
            this.inputs[lang] = item;
            this.inputsArray.push(item);
        }
        this.menuAll = Ext.create('Ext.menu.Menu', {});
    }*/
});

Ext.define('At4FrameworkIntranet.mixin.DroppedMultilang', {
    extend: 'At4FrameworkIntranet.mixin.simpleMultilang'
});
///INICIO DE APP
Ext.define("At4FrameworkIntranet.At4FrameworkIntranet", {
	extend: "At4FrameworkIntranet.ApplicationBasic",
	/*mixins: {
		base: 'At4FrameworkIntranet.mixin.ApplicationBasic',
	},*/
	toolbarHeight: 45,
	headerImageWidth: 160,
	showUserLogoutButton: true,
	showTemaButton: true,
	showLangButton: true,
	availableLangs: ["ca", "es", "en"],
	constructor: function (options) {
		Ext.apply(this, options);
		dwr.engine.setTextHtmlHandler(this.openLogin.bind(this));
		//Garrom: Variable cache para añadir cosillas

		this.cache = {
			constrains: {}
		};
		this.util = {};

		this.toolbar = Ext.create('Ext.toolbar.Toolbar', {
			cls: 'top-toolbar',
			height: this.toolbarHeight,
			columnWidth: 1,
			flex: 1,
			width: "100%",
			border: false,
			// padding: 0,
			/*plugins: 'responsive',
			responsiveConfig: {
				'width < 1280': {
					region: 'south',
					hidden: true,
					margin: 0,
					layout: {
						type: 'box',
						vertical: true,
						align: "begin"
					}
				},

				'width >= 1280': {
					region: 'center',
					hidden: false,
					//margin: "4px 0 0 0",
					layout: {
						type: 'box',
						vertical: false,
						align: "middle"
					}
				}
			},*/
			items: [' '
				// Añdir aqui elementos al toolbar general
			]
		});

		var header = Ext.get('header');
		var headerPanelItems = [];
		if (header) {
			headerPanelItems.push({
				xtype: 'box',
				el: 'header',
				border: false
			});
		}
		var headerHeight = header ? header.getBottom() + this.toolbarHeight : this.toolbarHeight;
		/**
		 * garrom:
		 * Insertamos un elemento de imagen para que sea el logo de la aplicacion.
		 * Dicha imagen debe ser ~raiz/img/applogo.jpg
		 */
		this.headerHeight = headerHeight;
		var imageLogoWidth = 215;
		this.headerImageLogo = Ext.create("Ext.Img", {
			src: 'img/applogo.png',
			width: imageLogoWidth,
			height: headerHeight,
			imgCls: "logo",
			autoEl: {
				tag: 'a',
				href: '.',
				target: '_self',
				width: imageLogoWidth,
				height: headerHeight,

			},
			cls: "headerImage",
			region: "west",

		});
		/*this.menuButton = Ext.create({
			xtype: "button",
			// text: "| | |",
			region: "east",
			width: 75,
			cls: "responsive-menu",
			iconCls: "glyphicons glyphicons-menu-hamburger",
			scope: this,
			height: headerHeight,
			handler: function (element, event) {
				event.stopPropagation();
				window.setTimeout(function () {
					if (this.headerOpen) {
						this.headerOpen = false;
						this.headerPanel.setHeight(headerHeight);
						this.toolbar.hide();
					} else {
						this.headerOpen = true;
						var height = 300;
						this.toolbar.setHeight(height - headerHeight);
						this.headerPanel.setHeight(height);
						this.toolbar.show();
					}
				}.bind(this), 70);

			},

			plugins: 'responsive',
			responsiveConfig: {
				'width < 1280': {
					hidden: false
				},

				'width >= 1280': {
					hidden: true
				}
			}
		})*/

		//headerPanelItems.push(this.headerImageLogo);
		headerPanelItems.push(this.toolbar);
		//headerPanelItems.push(this.menuButton)

		this.headerPanel = Ext.create('Ext.Panel', {
			border: false,
			layout: 'hbox',
			region: 'north',
			height: headerHeight,
			items: headerPanelItems,
			cls: "header-panel",
			// collapsible: true,
			// hideCollapseTool: false,
			header: false,
			// collapsed: Ext.getBody().getWidth()<1280,
			// collapseMode: "mini",
			/*//plugins: 'responsive',
			responsiveConfig: {
				'width < 1280': {
					region: 'west',
					layout: {
						type: 'box',
						vertical: true,
					},
					height: headerHeight,
					collapsed: true
				},

				'width >= 1280': {
					region: 'north',
					height: headerHeight,
					layout: {
						type: 'box',
						vertical: false,
					},
					hidden: false,
					collapsed: false
				}
			}*/
		})

		this.statusBar = Ext.create('Ext.ux.StatusBar', {
			id: 'At4Framework-status',
			autoClear: 10000,
			defaultText: this.statusBarDefaultTxt
		});

		var mainPanel;

		// Main (Tabbed) Panel
		//TODO: Como el state va un poco chungo por ahora, solo se va a usar cuando modoDesarollo = false;
		var mainTabPanelClass = At4Framework_modoDesarrollo ? "At4FrameworkIntranet.MainTabPanel" : "Ext.tab.Panel";
		this.tabPanel = Ext.create(mainTabPanelClass, {
			region: 'center',
			layoutOnTabChange: true,
			stateful: true,
			stateId: "maintabpanel",
			// evita el bug:
			// http://extjs.com/forum/showthread.php?t=32630&highlight=layout%3A%27column%27
			deferredRender: false,
			autoScroll: true,
			enableTabScroll: true,
			margins: '0 4 4 0',
			activeTab: 0,
			bodyStyle: "overflow: hidden",
			cls: "at4-top-toolbar",
			width: 900,
			application: this,
			bbar: this.statusBar,
			items: [],
			plugins: [
				Ext.create('Ext.ux.TabCloseMenu', {})
			],
			/*
			listeners: {
			show: {
			fn: this.onTestShow,
			scope: this
		}
	}*/


			// Necessari si es vol recargar el tab cada pic que s'activa.
			// Necessari per quan es volen actualitzar les dades dinamicament
			// de dos forms que tenen elements relacionats.
			/*
			 * , listeners:{ beforetabchange :{ fn:function(tabpanel, newtab,
			 * curtab) { if (newtab.form != null){ if (newtab.tabcarregatabans !=
			 * null) { newtab.submitActualizar(); } else {
			 * newtab.tabcarregatabans = true; } } } } }
			 */
		});
		mainPanel = this.tabPanel;

		// aamengual - pie
		var footer = Ext.get('footer');
		if (footer) {
			//garrom: He cambiado esto de Ext.Panel a container para mejorar rendimiento
			var footerPanel = Ext.create('Ext.container.Container', {
				border: false,
				layout: 'fit',
				region: 'south',
				cls: 'alma-header',
				height: 31,
				items: [{
					el: footer
				}]
			});
		}

		// Configure viewport
		this.viewport = Ext.create('Ext.container.Viewport', {
			layout: 'border',
			border: false,
			padding: '48 0 0 0',
			items: [this.headerPanel, mainPanel, footerPanel]
		});

		this.updateToolbar(At4FrameworkIntranet.Bootstraper.menuPrincipal);

		/*******************************************************************
		 * Solo usado en desarrollo, para abrir de inicio un tab
		 * this.openRecordForm ( { form: 'proyecto', }, {oid:'1'}); /
		 ******************************************************************/
		/*
		this.openRecordForm({
		form: 'hotel',
		}, {
		oid: '48'
		});*/
		Ext.GlobalEvents.addListener({
			resize: {
				fn: function (w, h, opts) {
					this.hideTopMenu();
					this.onViewResize(w, h, opts);
				},
				scope: this
			}
		});


	},

	// public methods

	hideTopMenu: function () {
		var w = Ext.getBody().getViewSize().width;
		this.headerOpen = false;
		this.headerPanel.setHeight(this.headerHeight);
		/*if (w >= 1280) {
			this.toolbar.show();
		} else {
			this.toolbar.hide();
		}*/
	},
	onViewResize: function (w, h, opts) {
		var windowCMP = Ext.WindowManager.getActive();
		if (windowCMP) {
			if (windowCMP.xtype == "at4window") {
				if (windowCMP.originalWidth < w) {
					windowCMP.setWidth(windowCMP.originalWidth);
				} else {
					windowCMP.setWidth(w);
				}
				if (windowCMP.originalHeight < h) {
					windowCMP.setHeight(windowCMP.originalHeight);
				} else {
					windowCMP.setHeight(h);
				}
			}
			windowCMP.center();
		}
	},
	/**
	 * Registra el gridMetaData para los botones que no abren listado
	 * (Sustituye a openListGrid: es una version recortada)
	 *
	 * @param {Object}
	 *            btn
	 * @param {Object}
	 *            gridMetaData
	 * @private
	 */
	saveGridListMetaData: function (btn, gridMetaData) {
		// Guardamos la información en caché si no existía
		if (!gridMetaDataCache[btn.form]) {
			gridMetaDataCache[btn.form] = gridMetaData;
		}
	},

	/**
	 * recibe un objeto ToolbarElements
	 *
	 * @param {Object}
	 *            toolbarElements
	 * @private
	 */
	updateToolbar: function (toolbarElements) {

		var menus = toolbarElements.menus;

		var defaults = {
			handler: this.onItemClick,
			scope: this,
			cls: 'at4-menuButton',
			scale: 'small',
			titleAlign: "left",
			/*bodyStyle: "text-align: left",
			plugins: 'responsive',
			responsiveConfig: {
				'width < 1280': {
					width: "100%",
					// height: 32
				},

				'width >= 1280': {
					width: null,
					// height: 25
				}
			}*/
		}


		for (var i = 0; i < menus.length; i++) {
			// es necesario asignar el handler a cada item para que se
			// incluya en los menus de los siguientes niveles
			if (menus[i].menu && menus[i].menu.items) {
				// Es un menú
				setMenuDefaults(menus[i].menu, Ext.apply({}, {
					// minWidth: 200,
					/*responsiveConfig: {
						'width < 1280': {
							width: "100%"
						},

						'width >= 1280': {
							width: "auto",
						}
					}*/
				}, defaults));


				menus[i].menu.cls = "at4-headerMenu";
				this.toolbar.insert(i, Ext.apply({
					text: menus[i].text,
					iconCls: menus[i].iconCls,
					scale: 'small',
					menu: Ext.create("Ext.menu.Menu", menus[i].menu)
				}, defaults))

			} else {
				// Es un botón
				Ext.apply(menus[i], defaults);
				this.toolbar.insert(i, menus[i]);
			}
		}

		this.toolbar.add('->');
		// Añade los menús de selección de tema e idioma
		var userLogoutButton = false;
		if (this.showUserLogoutButton) {
			userLogoutButton = {
				id: 'userLogoutButton',
				cls: 'at4-menuButton',
				scale: 'small',
				iconCls: 'glyphicons glyphicons-user glyph-white',
				text: window.username,
				/*plugins: 'responsive',
				responsiveConfig: {
					'width < 1280': {
						width: "100%",
					},

					'width >= 1280': {
						width: null,
					}
				},*/
				menu: Ext.create("Ext.menu.Menu", {
					cls: "at4-headerMenu",
					items: [{
						id: 'logoutButton',
						iconCls: 'glyphicons glyphicons-log-out',
						//text: 'Salir',
						text: this.salirTxt,
						handler: function () {
							location.href = window.logoutUrl;
						},
						width: "auto",
						/*plugins: 'responsive',
						responsiveConfig: {
							'width < 1280': {
								width: "100%"
							},

							'width >= 1280': {
								width: "auto",
							}
						}*/

					}, {
						iconCls: 'glyphicons glyphicons-server-ban',
						text: this.olvidarEstadosTexto, //Traduccion en ApplicationBasic de At4Framework-lang.jsp
						id: 'stateResetButton',
						scope: this,

						/*plugins: 'responsive',
						responsiveConfig: {
							'width < 1280': {
								width: "100%"
							},

							'width >= 1280': {
								width: "auto",
							}
						},*/
						handler: function () {
							Ext.Msg.show({
								title: this.borrarestadAplicacion,
								message: this.mensajeReset,
								buttons: Ext.Msg.YESNO,
								icon: Ext.Msg.QUESTION,
								scope: this,
								fn: function (btn) {
									if (btn === 'yes') {
										Ext.MessageBox.wait("Recargando", "Espere..");
										var stateProvider = Ext.state.Manager.getProvider();
										for (var item in stateProvider.state) {
											Ext.state.Manager.clear(item);
										}

										//recargamos el app
										Ext.state.Manager.getProvider().on("savesuccess", function () {
											window.location.reload();
										}, this);

										//Recargamos los grids?
										//this.reloadTabs(true)
									}
								}
							});
						},

					}]
				})
			};
			this.toolbar.add(userLogoutButton);
		};

		var temaButton = false;
		if (this.showTemaButton) {
			temaButton = {
				cls: 'at4-menuButton',
				tooltip: "Tema",
				tooltip: this.temaTxt,
				iconCls: "glyphicons glyphicons-picture",
				menu: Ext.create("Ext.menu.Menu", {
					// defaults: defaults,
					items: [{
						id: 'at4ThemeButton',
						text: 'Desktop',
						checked: (this.tema == 'at4' ? true : false),
						group: 'theme',
						handler: null,
						scope: this,
						checkHandler: this.onChangeTheme
					}, {
						id: 'at4TouchThemeButton',
						text: 'Touch',
						checked: (this.tema == 'at4-touch' ? true : false),
						group: 'theme',
						handler: null,
						scope: this,
						checkHandler: this.onChangeTheme
					}, {
						id: 'at4AcireButton',
						text: 'Acire',
						checked: (this.tema == 'at4-touch-acire' ? true : false),
						group: 'theme',
						handler: null,
						scope: this,
						checkHandler: this.onChangeTheme
					}, {
						id: 'crispThemeButton',
						text: 'Tema Crisp',
						checked: (this.tema == 'crisp' ? true : false),
						group: 'theme',
						handler: null,
						scope: this,
						checkHandler: this.onChangeTheme
					}, {
						id: 'crispTouchThemeButton',
						text: 'Tema Crisp Touch',
						checked: (this.tema == 'crisp-touch' ? true : false),
						group: 'theme',
						handler: null,
						scope: this,
						checkHandler: this.onChangeTheme
					}]
				})
			}
			this.toolbar.add(temaButton);
		}

		var langButton = false;
		if (this.showLangButton) {
			langButton = {
				tooltip: (this.idioma == 'en' ? 'English' : this.idioma == 'es' ? 'Castellano' : 'Català'),
				cls: 'at4-menuButton',
				//TODO: Localear
				text: "Idioma",
				iconCls: "glyphicons glyphicons-globe-af",
				/*plugins: 'responsive',
				responsiveConfig: {
					'width < 1280': {
						width: "100%",
						//TODO: Localear
						text: "Idioma",
					},

					'width >= 1280': {
						width: null,
						text: '',
					}
				},*/
				menu: Ext.create("Ext.menu.Menu", {
					cls: "at4-headerMenu",
					//TODO: ordenar según el orden en this.availableLangs
					items: [{
						id: 'langButtonEN',
						text: 'English',
						checked: (this.idioma == 'en' ? true : false),
						group: 'idioma',
						handler: null,
						scope: this,
						hidden: this.availableLangs.indexOf('en') == -1,
						/*plugins: 'responsive',
						responsiveConfig: {
							'width < 1280': {
								width: "100%"
							},

							'width >= 1280': {
								width: "auto",
							}
						},*/
						checkHandler: this.onChangeLang
					}, {
						id: 'langButtonES',
						text: 'Castellano',
						checked: (this.idioma == 'es' ? true : false),
						handler: null,
						group: 'idioma',
						scope: this,
						hidden: this.availableLangs.indexOf('es') == -1,
						/*plugins: 'responsive',
						responsiveConfig: {
							'width < 1280': {
								width: "100%"
							},

							'width >= 1280': {
								width: "auto",
							}
						},*/
						checkHandler: this.onChangeLang
					}, {
						id: 'langButtonCA',
						text: 'Català',
						checked: (this.idioma == 'ca' ? true : false),
						handler: null,
						group: 'idioma',
						scope: this,
						hidden: this.availableLangs.indexOf('ca') == -1,
						/*plugins: 'responsive',
						responsiveConfig: {
							'width < 1280': {
								width: "100%"
							},

							'width >= 1280': {
								width: "auto",
							}
						},*/
						checkHandler: this.onChangeLang
					}]
				})
			}
			this.toolbar.add(langButton);
		};

		if(this.customToolbarButton){
			this.toolbar.add(this.customToolbarButton);
		}

		//this.toolbar.add('->', userLogoutButton, temaButton, langButton);
		this.toolbar.doLayout();
		this.statusBar.clearStatus({
			useDefaults: true
		});

	},

	/**
	 * Manejador de clics en el menú de idioma
	 *
	 * @param {Object}
	 *            btn
	 * @private
	 */
	onChangeLang: function (item, checked) {
		if (checked) {
			var href = './index.html?lang=';
			switch (item.id) {
			case "langButtonCA":
				href += 'ca';
				break;
			case "langButtonES":
				href += 'es';
				break;
			case "langButtonEN":
				href += 'en';
				break;
			default:
				break;
			}
			// 		  if (item.id == 'langButtonCA') {
			// 		href += 'ca';
			// 	} else {
			// 	href += 'es';
			// }
			location.href = href;
		}
	},

	/**
	 * Manejador de clics en el menú de cambio de tema
	 *
	 * @param {Object}
	 *            btn
	 * @private
	 */
	onChangeTheme: function (item, checked) {
		if (checked) {
			var href = './index.html?tema=';
			switch (item.id) {
			case "at4ThemeButton":
				href += 'at4';
				break;
			case "at4TouchThemeButton":
				href += 'at4-touch';
				break;
			case "crispThemeButton":
				href += 'crisp';
				break;
			case "crispTouchThemeButton":
				href += 'crisp-touch';
				break;
			case "at4AcireButton":
				href += 'at4-touch-acire';
				break;
			default:
				break;
			}
			// 		  if (item.id == 'langButtonCA') {
			// 		href += 'ca';
			// 	} else {
			// 	href += 'es';
			// }
			location.href = href;
		}
	},

	/**
	 * Manejador de clics en el menú
	 *
	 * @param {Object}
	 *            btn
	 * @private
	 */
	onItemClick: function (btn, e) {
		e.stopEvent();

		if (btn.menu) {
			// Se trata de un menú
			return;
		}
		this.hideTopMenu();
		this.openMenuFormItem(btn);
	},

	// private
	openMenuFormItem: function (btn) {
		if (btn.link) {
			// Se trata de un enlace externo
			this.updateTab(btn.href, btn.text, btn.href, btn.iconCls);
		} else {
			switch (btn.mode) {
			case 'list':
				// Un formulario listado tradicional
				if (gridMetaDataCache[btn.form]) {
					this.openListGrid(btn, gridMetaDataCache[btn.form]);
				} else {
					serverGui.getListMetadata(btn, this.openListGrid, this);
				}
				break;
			case 'new':
				// Un formulario vacío para crear nuevo
				this.openNewRecordForm(btn);
				break;
			case 'plain':
				// Se trata de un feature
				switch (btn.form) {
					/*
					case 'centro':
					if (gridMetaDataCache[btn.form]) {
					this.doOpenCentroPropioRecordForm(btn,
					gridMetaDataCache[btn.form]);
					} else {
					serverGui.getListMetadata(btn,
					this.doOpenCentroPropioRecordForm, this);
					}
					break;
					*/
				case 'configuracion':
					this.openRecordForm({
						form: 'configuracion',
					}, {
						oid: '1'
					});
					break;
				case 'validar':
					serverDatabaseActions.runAction(
						ValidacionService.obtenerInfraccionParaValidar, [],
						this.openValidar,
						serverDatabaseActions.exceptionHandler,
						this
					);
					break;
				case 'auditar':
					serverDatabaseActions.runAction(
						ValidacionService.obtenerInfraccionParaAuditar, [],
						this.openAuditar,
						serverDatabaseActions.exceptionHandler,
						this
					);
					break;
				case 'obrirManualGeneral':

					this.openPdf(btn, 'docs/manual.pdf');

					break;

				}
				break;
			}
		}

	},

	/**
	 * Abre un formulario para un registro.
	 *
	 * @param {Object}
	 *            formItem
	 * @param {Object}
	 *            data
	 * @param {String}
	 *            tituloTab Titulo de la pestaña.
	 */
	openRecordForm: function (formItem, data, tituloTab, isState) {

		var dataContainer = {
			data: data,
			isState: isState
		}

		if (gridMetaDataCache[formItem.form]) {
			this.doOpenRecordForm(formItem, gridMetaDataCache[formItem.form], dataContainer, tituloTab);
		} else {
			serverGui.getListMetadata(formItem, this.doOpenRecordForm, this, dataContainer);
		}

	},

	/**
	* TODO
	* Obtiene el GridMetaData para el form formItem.
	* Llama al callback en la forma: callbackFunction
	getGridMetaData: function (formItem, callbackFunction, source, args) {

	},
	*/

	// private
	doOpenRecordForm: function (formItem, gridMetaData, dataContainer, tituloTab) {
		var data = dataContainer.data;
		var isState = dataContainer.isState;

		// Guardamos la informacion en cache si no existia
		if (!gridMetaDataCache[formItem.form]) {
			gridMetaDataCache[formItem.form] = gridMetaData;
		}
		var oid = data.oid || data.id || data.clave;
		oid = String(oid).replace(" ", "");
		var form = formItem.form;
		var tabId = form + '-plainRecord-' + oid.replace(/[_|.]/g, '-');

		var tab = this.getTab(tabId);
		if (!tab) {
			var text = formItem.text ? formItem.text : gridMetaData.formItem.text;

			text = tituloTab || Ext.String.format(this.registerTabTitle, text);

			tab = Ext.create("At4FrameworkIntranet." + gridMetaData.formClassName, this, form, gridMetaData, {
				id: tabId + Ext.id(),
				closable: true,
				closeAction: "destroy",
				iconCls: formItem.iconCls,
				isStateLoaded: !!isState,
				title: text
			});

			this.tabPanel.add(tab);
			this.registerTabId(tabId, tab);

			tab.loadData(oid, data);

		}
		this.tabPanel.setActiveTab(tab);

	},

	/**
	 * Abre un formulario vacio
	 *
	 * @param {Object}
	 *            formItem
	 */
	openNewRecordForm: function (formItem, extraCfg, requiredData) {
		var itemInfo = {
			formItem: formItem,
			extraCfg: extraCfg,
			requiredData: requiredData
		}
		if (gridMetaDataCache[formItem.form]) {
			this.doOpenNewRecordForm(formItem, gridMetaDataCache[formItem.form], itemInfo);
		} else {
			serverGui.getListMetadata(formItem, this.doOpenNewRecordForm, this, itemInfo);
		}
	},

	openNewWindowForm: function (formItem, parentList) {
		if (gridMetaDataCache[formItem.form]) {
			this.doOpenNewWindowForm(formItem, gridMetaDataCache[formItem.form], parentList);
		} else {
			serverGui.getListMetadata(formItem, this.doOpenNewWindowForm, this, parentList);
		}

	},

	// private
	doOpenNewWindowForm: function (formItem, gridMetaData, parentList) {
		// Guardamos la información en caché si no existía
		if (!gridMetaDataCache[formItem.form]) {
			gridMetaDataCache[formItem.form] = gridMetaData;
		}
		//var window = new Ext.Window({
		var window = Ext.create("Ext.window", {
			// title: this.editarTxt,
			title: formItem.text,
			closable: true,
			modal: true,
			closeAction: 'hide',
			width: 720,
			height: 670,
			deferredRender: false,
			// border:false,
			plain: true,
			layout: 'fit',
			items: [Ext.create(At4FrameworkIntranet[gridMetaData.formClassName], this, formItem.form, gridMetaData, {
				closable: true
					// title: formItem.text
			})]
		});
		window.parentList = parentList;
		window.show();
	},

	// private
	doOpenNewRecordForm: function (formItem, gridMetaData, itemInfo) {
		var requiredData = itemInfo.requiredData;

		var extraCfg = itemInfo.extraCfg ? itemInfo.extraCfg : {};
		// Guardamos la información en caché si no existía
		if (!gridMetaDataCache[formItem.form]) {
			gridMetaDataCache[formItem.form] = gridMetaData;
		}

		var form = formItem.form;

		var tabId = form + '-newForm';
		var tab = this.getTab(tabId);
		if (!tab) {
			/*
			 * gridMetaData no existe var text =
			 * formItem.text?formItem.text:gridMetaData.formItem.text;
			 */
			// var text = formItem.text;
			var text = formItem.text ? formItem.text : gridMetaData.formItem.text;
			text = Ext.String.format(this.newRegisterTabTitle, text);

			//tab = new(At4FrameworkIntranet[gridMetaData.formClassName])(
			var cfg = Ext.apply({
				closable: true,
				isNewForm: true,
				id: gridMetaData.formClassName + "-newForm" + Ext.id(),
				iconCls: formItem.iconCls,
				title: text
			}, extraCfg);
			tab = Ext.create("At4FrameworkIntranet." + gridMetaData.formClassName, this, form, gridMetaData, cfg);
			if (requiredData) {
				tab.setValues(requiredData);
				console.log("RequiredData values set!");
			}

			this.tabPanel.add(tab);
			this.registerTabId(tabId, tab);

		}
		this.tabPanel.setActiveTab(tab);
	},

	/**
	 * Metodo al que notificar cuando se añade un registro.
	 *
	 * @param {Object}
	 *            tab
	 * @param {Object}
	 *            data
	 */
	onNewRecordDone: function (tab, data) {

		var form = data.formName;
		text = tab.title; // Texto por defecto
		var oid = data.rowid;

		if (gridMetaDataCache[data.formName]) { // tenemos cargado el
			// metadata
			var formItem = gridMetaDataCache[data.formName].formItem;
			text = formItem.text;
		}

		/* Actualizamos título e id del tab */
		tab.setTitle(Ext.String.format(this.registerTabTitle, text));

		this.unRegisterTabId(tab);
		var tabId = form + '-plainRecord-' + oid;
		this.registerTabId(tabId, tab);

		/* Recargamos el list */
		var listTabId = form + '-list';
		var listTab = this.getTab(listTabId);
		if (listTab) {
			// TODO: recargar llamando a un método de ListadoGrid
			listTab.store.reload();
		}

		//garrom: Hack para que cuando se añada un titular, se meta este en el contrato
		if (data.formName == "titular") {
			var contrato = this.getTab("contrato-newForm");
			if (contrato) {
				// contrato.fields.titular.store.load();
				// contrato.fields.titular.select(oid);
				var formvals = tab.getValues();

				var valTitularLabel = At4util.formatTitularLabel(formvals);

				var val = {
					titularId: oid,
					titularLabel: valTitularLabel
				};
				contrato.setValues(val)
			}
		}



	},


	/**
	 * Metodo al que notificar cuando se actualiza un registro.
	 *
	 * @param {Object}
	 *            data
	 */
	onUpdateRecordDone: function (data) {

		var form = data.formName;
		/* Recargamos el list */
		var listTabId = form + '-list';
		var listTab = this.getTab(listTabId);
		if (listTab) {
			listTab.store.reload();
		}

	},

	/**
	 * Método al que notificar cuando se elimina un registro.
	 *
	 * @param {Object}
	 *            tab
	 * @param {Object}
	 *            data
	 */
	onDeleteRecordDone: function (tab, data) {

		var formItem = gridMetaDataCache[data.formName].formItem;

		/* Actualizamos título e id del tab */
		var form = formItem.form;
		var oid = data.rowid;

		var tabId = form + '-plain-' + oid;
		var formTab = this.getTab(tabId);

		// Eliminamos el tab del form
		if (formTab) {
			this.unRegisterTabId(formTab);
			this.tabPanel.remove(formTab);
		}

		/* Recargamos el list */
		var listTabId = formItem.form + '-list';
		var listTab = this.getTab(listTabId);
		if (listTab && tab.id != listTab.id) {
			// Si no nos llaman desde listTab
			// TODO: recargar llamando a un método de ListadoGrid
			listTab.store.reload();
			listTab.show();
		}

	},

	/**
	 * Abre el grid de listado con la configuración adicional customConfig
	 */
	openCustomListGrid: function (id, btn, customConfig) {

		btn.extraId = id;
		if (gridMetaDataCache[btn.form]) {
			this.openListGrid(btn, gridMetaDataCache[btn.form], customConfig);
		} else {
			serverGui.getListMetadata(btn, this.openListGrid, this, customConfig);
		}

	},

	/**
	 * Abre el grid de listado de un formulario At4Framework
	 *
	 * @param {Object}
	 *            btn
	 * @param {Object}
	 *            gridMetaData
	 */
	openListGrid: function (btn, gridMetaData, customConfig) {
		// Guardamos la información en caché si no existía
		if (!gridMetaDataCache[btn.form]) {
			gridMetaDataCache[btn.form] = gridMetaData;
		}
		var tabId = btn.form + '-list';

		if (btn.extraId) {
			tabId += '-' + btn.id;
		}

		var tab = this.getTab(tabId);
		if (!tab) {
			var text = btn.text ? btn.text : gridMetaData.formItem.text;
			// La sintaxis At4FrameworkIntranet['ListadoGrid'] es
			// equivalente a At4FrameworkIntranet.ListadoGrid
			tab = new Ext.create("At4FrameworkIntranet." + gridMetaData.listClassName, this.tabPanel, {
				id: tabId + Ext.id(),
				// el grid debe tener un ID reproducible para que funcione el almacén de estado
				closable: true,
				title: text,
				stateId: tabId,
				closeAction: "destroy",
				stateful: true,
				tipo: 'normal',
				iconCls: btn.iconCls
			}, this, gridMetaData, customConfig);

			this.tabPanel.add(tab);
			this.registerTabId(tabId, tab);
		}
		this.tabPanel.setActiveTab(tab);
		//tab.syncSize();
	},

	openLogin: function (btn, href) {
		var tabId = 'pdf_' + Ext.ux.util.MD5(href);
		console.error("Esto no se deberia estar llamando");
		//tabId, tabTitle, targetUrl, iconCls
		return this.addTab(tabId, btn.text, href, btn.iconCls);
	},

	/**
	 * Abre un pdf
	 *
	 * @param {Object}
	 *            btn
	 */
	openPdf: function (btn, href) {
		var tabId = 'pdf_' + Ext.ux.util.MD5(href);
		//tabId, tabTitle, targetUrl, iconCls
		return this.addTab(tabId, btn.text, href, btn.iconCls);
	},

	/**
	 * Devuelve el tab de id tabId
	 *
	 * @param {String}
	 *            tabId
	 * @return {Object}
	 */
	getTab: function (tabId) {
		if (tabIdRegister[tabId]) {
			return tabIdRegister[tabId];
		} else {
			return null;
		}
	},

	/**
	 * Registra un id para un tab
	 *
	 * @param {String}
	 *            tabId
	 * @param {Object}
	 *            tab
	 */
	registerTabId: function (tabId, tab) {
		//tabIdRegister[tabId] = tab.getItemId();
		tabIdRegister[tabId] = tab;
		tab.registeredTabId = tabId;
	},

	/**
	 * Elimina un tab del registro
	 *
	 * @param {Object}
	 *            tab
	 */
	unRegisterTabId: function (tab) {
		if (tabIdRegister[tab.registeredTabId]) {
			delete tabIdRegister[tab.registeredTabId];
		}
	},

	/**
	* Añade un tab a partir de una url, que se cargará en un iframe
	*
	* @param {String}
	*            tabId
	* @param {String}
	*            tabTitle
	* @param {String}
	*            targetUrl
	* @private

	addTab: function(tabId, tabTitle, targetUrl, iconCls) {
	// Para enlaces externos se usa un Iframe
	var newPan = new Ext.ux.ManagedIframePanel({
	title: tabTitle,
	iconCls: iconCls,
	defaultSrc: targetUrl,
	closable: true,
	loadMask: true
	});
	newPan.application = this;
	this.tabPanel.add(newPan).show();
	this.registerTabId(tabId, newPan);
	},*/

	addTab: function (tabId, tabTitle, targetUrl, iconCls) {
		var tab = this.getTab(tabId);
		if (!tab) {
			var tab = Ext.create('At4FrameworkIntranet.IFrame', {
				id: tabId + Ext.id(),
				src: targetUrl,
				title: tabTitle,
				closable: true,
				iconCls: iconCls,
				width: 350,
				height: 350
			});

			tab.application = this;
			tab = this.tabPanel.add(tab).show();
			this.registerTabId(tabId, tab);

		}
		this.tabPanel.setActiveTab(tab);

	},

	/**
	 * Añade un tab a partir de una url, que se cargará en un iframe
	 *
	 * @param {String}
	 *            tabId
	 * @param {String}
	 *            title
	 * @param {String}
	 *            url
	 */
	updateTab: function (tabId, title, url, iconCls) {
		var tab = this.getTab(tabId);
		if (!tab) {
			tab = this.addTab(tabId, title, url, iconCls);
		}
		this.tabPanel.setActiveTab(tab);
	},

	/**
	 * Abre la página de login. Se llama a este método cuando se detecta que
	 * ha expirado la sesion.
	 *
	 * @private
	 */
	openLogin: function (pageData) {
		var me = this;
		//window.top.location.href = 'index.html';
		if (!this.sessionExpiredAlerted) {
			// Queremos evitar que, si se han mandado varias peticiones, muestre mas de un alert

			// this.sessionExpiredAlerted = true;
			var loginVersion = 1;
			if (loginVersion == 1) {

				var windowCMP = Ext.getCmp('loginWindow');
				var loginUri = this.contextPath + '/index.html?fastRelogUser=' + window.username;

				if (!windowCMP) {
					// var loginUri = this.contextPath + '/login/loginForm.html?usuario=test';
					// var loginUri = this.contextPath + '?usuario=test';
					// var loginUri = window.logoutUrl + '?usuario=test';
					var iframe = Ext.create('At4FrameworkIntranet.IFrame', {
						id: Ext.id(),
						autoregister: false,
						listeners: {
							frameload: {
								fn: function (ev) {
									var iframeWindow = ev.target.contentWindow;
									var path = iframeWindow.location.pathname;
									console.log(path);
									switch (path) {
									case this.contextPath + "/login/loginError.html":
									case this.contextPath + "/login/loginForm.html":
										iframe.show();
										me.loginError();
										break;
									case this.contextPath + "/dwr/call/plaincall/GuiService.saveState.dwr":
									case this.contextPath + "/index.html":
										me.loginSuccess();
										break;
									default:
										iframeWindow.location.replace(loginUri)

										break;
									}
								},
								scope: this,
							},
							frameunload: {
								fn: function (ev) {
									iframe.hide();
								},
								scope: this
							},
							domload: {
								fn: function (ev) {
									console.log(arguments);
								},
								scope: this,
							}

						},
						src: loginUri,
					});
					windowCMP = Ext.create({
						xtype: "at4window",
						title: this.windowExpiredSesiontitle,
						id: 'loginWindow',
						width: 1024,
						height: 768,
						closeAction: "destroy",
						layout: 'fit',
						closable: false,
						draggable: false,
						resizable: false,
						modal: true,
						html: '<div style="display: table; height: 100%; width: 100%;"><div style="display: table-cell; vertical-align: middle;"><div class="loader">Loading...</div></div></div>',
						items: [iframe]
					});
				} else {
					var frame = windowCMP.items.items[0];
					frame.show();
					frame.getWin().location.replace(loginUri);
				}

				Ext.getBody().addCls("sesion-caducada");
				windowCMP.show();
			}
			if (loginVersion == 2) {
				console.log("Method unfinished");
				console.warn("Method unfinished");
				var windowCMP = Ext.getCmp('loginWindow');
				if (!windowCMP) {
					this.loginPanel = Ext.create('Ext.form.Panel', {
						url: this.contextPath + "/login/loginForm.html",
						defaults: {
							labelAlign: "top"
						},
						defaultType: 'textfield',
						items: [{
							inputType: "text",
							disabled: true,
							fieldLabel: 'username',
							value: username
						}, {
							inputType: "hidden",
							name: 'username',
							hidden: true,
							value: username
						}, {
							inputType: "password",
							fieldLabel: 'password',
							name: 'password',
							allowBlank: false
						}],
						reader: {
							type: 'xml',
							record: 'meta',
							rootProperty: 'head'
						},
						errorReader: {
							type: 'xml',
							record: 'meta',
							rootProperty: 'head'
						},
						listeners: {
							beforeaction: {
								fn: function (panel, action) {
									action.oldHandleResponse = action.handleResponse;
									action.handleResponse = function (response) {
										response.responseXML = response.responseText;
										return action.oldHandleResponse(response);
									}
								}
							}
						},
						buttons: [{
							xtype: "button",
							text: 'Submit',
							handler: function () {
								var form = this.loginPanel.getForm();
								if (form.isValid()) {
									form.submit({
										success: function (form, action) {
											me.handleLogin(form, action);
										},
										failure: function (form, action) {
											me.handleLogin(form, action);
										}
									});
								}
							},
							scope: this
						}]
					});
					windowCMP = new Ext.Window({
						title: "Login",
						id: 'loginWindow',
						closeAction: "destroy",
						layout: 'fit',
						closable: false,
						draggable: false,
						resizable: false,
						modal: true,
						items: [this.loginPanel]
					});
				}
				windowCMP.show();
			}
			//Ext.getCmp('loginWindow').center()
			//



			/**
			 * {
			            text     : 'Close',
			            handler  : function(){
			                win.hide();
			            }
			        }
			 */
			/*
			 * Esto no funciona bien, pues requiere de recursos (imagenes)
			 * que no puede obtener al haber perdido el login
			 * Ext.Msg.alert({ title: this.sessionExpiredTitle, msg:
			 * this.sessionExpiredMsg, buttons: Ext.Msg.OK, icon:
			 *
			 * Ext.MessageBox.ERROR, fn: function () { document.location =
			 * this.contextPath + '/login/loginForm.html'; }, scope:this,
			 * });


			//alert(this.sessionExpiredTitle + ': ' + this.sessionExpiredMsg);
			//this.sessionExpiredAlerted = false;

			/*
			 * Si redireccionamos al login, tras la autentificacion nos
			 * lleva al recurso pedido, que suele ser el retorno de un
			 * metodo javascript. Para evitarlo, mejor redireccionamos a la
			 * portada; despues, al no estar logueados, nos llevara al login
			 * document.location = this.contextPath +
			 * '/login/loginForm.html';
			 */


			//document.location = this.contextPath + '/index.html';

		}
	},


	// Per a amagar camps amb els seus labels
	hideField: function (field) {
		field.ownerCt.hide(); // hide parent
		field.hide();
		var el = field.getEl();
		if (el != undefined) {
			el.up('.x-form-item').setDisplayed(false); // hide label
		}
	},
	handleLogin: function (form, action) {
		var parser = new DOMParser();
		var htmlDoc = parser.parseFromString(action.response.responseXML, "text/html");
		var metaTags = Ext.fly(htmlDoc).select("meta").elements;
		var attr = "";
		for (i in metaTags) {
			var metaTag = metaTags[i];
			if (metaTags.hasOwnProperty(i)) {
				var attrC = metaTag.getAttribute("data-url");
				if (attrC) {
					attr = attrC;
				}
			}
		}
		switch (attr) {
		case "index":
			this.loginSuccess();
			break;
		case "loginForm":
		case "loginError":
		default:
			this.loginError();
		}
	},
	loginSuccess: function () {
		console.log("logueado guay");
		Ext.getCmp('loginWindow').hide();
		Ext.getBody().removeCls("sesion-caducada");
		this.reloadTabs();
	},
	loginError: function () {
		console.log("logueado error");
	},

	reloadTabs: function (reconfigure) {
		Ext.Msg.hide();
		var mostrarMsg = false;
		for (var i in this.tabPanel.items.items) {
			var item = this.tabPanel.items.items[i];
			if (item.xtype == "gridpanel") {
				if (reconfigure) {
					item.reconfigure(null, item.gridMetaData.columns)
				}
				item.store.load();
			}else if(item.xtype == "form"){
				mostrarMsg = true;
			}
		}
		if(mostrarMsg){
			Ext.Msg.alert(this.afterRelogFormTitle, this.afterRelogFormMsg);
		}
	},

	showField: function (field) {
		field.ownerCt.show();
		field.show();
		var el = field.getEl();
		if (el != undefined) {
			el.up('.x-form-item').setDisplayed(true); // show label
		}
		field.render();
	},
	cargaValidar: function (data) {
		this.doOpenValidar(data, false);
	},
	openValidar: function (data) {
		this.doOpenValidar(data, true);
	},
	doOpenValidar: function (data, obtenerSiguiente) {
		if (!this.validarWindow) {
			this.validarWindow = Ext.create("At4FrameworkIntranet.ValidarForm", {

			});
		}
		if (data) {
			this.validarWindow.obtenerSiguiente = obtenerSiguiente;
			this.validarWindow.loadData(data);
			this.validarWindow.show();
		} else {
			Ext.Msg.alert("Finalizado", "No quedan infracciones por validar");
		}
	},
	/**
	* @author: garrom@at4.net
	*
	* Recarga (cierra, destruye y vuelve a abrir) una pestaña con un
	* grid abierto automaticamente
	*/
	reloadListGrid: function(grid){
		var cfg = {
			form: grid.formPanel.formName,
			iconCls: grid.iconCls,
			text: grid.title,
		};
		var customConfig = grid.customConfig;
		var gridMetaData = grid.gridMetaData;
		grid.close();
		this.openListGrid(cfg, gridMetaData, customConfig);
	}

});

///FIN DE APP
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
Ext.define("At4FrameworkIntranet.MainTabPanel", {
	extend: "Ext.tab.Panel",

	stateful: true,

	applyState: function(state) {
		if (this.isStateListenerApplyed) {
			return;
		}
		this.isStateListenerApplyed = true;
		this.addListener("afterrender", function(panel, options) {
			if (panel.aplicadoEstado) {
				return;
			}
			panel.aplicadoEstado = true;
			var state = options.state;
			for (i in state) {
				var obj = state[i];
				if (typeof obj != "object" || !obj.config) {
					return;
				}
				switch (obj.type) {
					case "formItem":
						if (!obj.config.data.oid) {
							break; //Era un form vacío
						}
						window.setTimeout(function() {
							var obj = this.obj;
							var me = this.scope;
							panel.application.openRecordForm({
								form: obj.config.formName,
								iconCls: obj.config.iconCls
							}, obj.config.data, obj.config.title, true)
						}.bind({
							scope: this,
							obj: obj
						}), 50)
						break;
					case "grid":
						window.setTimeout(function() {
							var obj = this.obj;
							var me = this.scope;
							panel.application.openMenuFormItem({
								form: obj.config.formName,
								mode: "list",
								iconCls: obj.config.iconCls
							});
						}.bind({
							scope: this,
							obj: obj
						}), 50)
						break;
				}
			}
		}, this, {
			state: state
		})

	},
	getState: function() {

		if (this.stateDestroy) {
			return {};
		}
		var toReturn = this.callParent();
		var items = this.items.items;
		var state = [];
		Ext.Array.each(items, function(obj, index, array) {
			var objectType;
			var config = {};

			if (obj.formName) {
				//Es un item abierto
				objectType = "formItem";
				config.formName = obj.formName;
				config.data = {};
				config.data.oid = obj.dataId;
				config.title = obj.title;
				config.iconCls = obj.iconCls;
			} else {
				//Es un grid
				objectType = "grid";
				config.formName = obj.stateId.split("-list")[0];
				config.iconCls = obj.iconCls;
			}
			config.dataId = obj.dataId;
			state.push({
				config: config,
				type: objectType
			});
		});
		//console.log("state save", state);
		return state;
	},
	stateEvents: ["add", "activate", "show", 'collapse', 'expand', 'close', "remove"]

});
// Namespace de At4FrameworkIntranet
Ext.namespace('At4FrameworkIntranet');

Ext.define("At4FrameworkIntranet.ComboBox", {
	extend: "Ext.form.field.ComboBox",
	/**
	 * @class At4FrameworkIntranet.ComboBox
	 * Personalización de ComboBox.<br/>
	 * Además de la configuración por defecto adecuada, incluye control de carga del store para mostrar la etiqueta adecuada tras cargarse los datos.
	 * @extends-ext Ext.form.ComboBox
	 * @author agarcia
	 *
	 * @param {Object} config
	 */
	constructor: function (config) {

		Ext.apply(this, config);
		if (this.autoCarga) {
			this.store.load();
		}
		this.callParent(config);
		this.showAddRelatedButton();
		if (this.showReloadButton) {
			this.getTrigger('reload').show();
		}
	},

	triggers: {
		openRelated: {
			cls: 'trigger-relationlink',
			weight: -1,
			hidden: true,
			handler: function (combo) {
				combo.openRelatedForm(combo);
			}
		},
		addRelated: {
			cls: 'trigger-relationAdd',
			weight: -1,
			hidden: true,
			handler: function (combo) {
				combo.form.application.openNewRecordForm({
					form: combo.relatedForm,
					iconCls: combo.relatedIconCls
				});
			}
		},
		reload: {
			cls: 'trigger-reload',
			weight: -1,
			hidden: true,
			handler: function (combo) {
				combo.store.load(combo.store.lastOptions);
			}
		}
	},

	openRelatedForm: function (combo) {
		var v = combo.getRelatedId(combo);
		if (combo.relatedForm && v) {
			combo.form.application.openRecordForm({
				form: combo.relatedForm,
				iconCls: combo.relatedIconCls
			}, {
				oid: v
			});

		}
	},
	getRelatedId: function (combo) {
		return this.getValue();
	},

	clearValue: function () {
		if (this.disableAfterclear) {
			this.disable();
		}
		this.callParent(arguments);
	},
	showRelatedButton: function () {
		//TODO: mostrar sólo si el usuario tiene permisos de lectura sobre el form
		if (this.showRelated != false) {
			this.getTrigger('openRelated').show();
		}
	},

	showAddRelatedButton: function () {
		//TODO: mostrar sólo si el usuario tiene permisos de lectura sobre el form
		if (this.showAddRelated != false) {
			this.getTrigger('addRelated').show();
		}
	},
	hideRelatedButtons: function () {
		this.getTrigger('addRelated').hide();
		this.getTrigger('openRelated').hide();
	},

	listeners: {
		// change: function(combo, newValue) {
		//     this.getTrigger('openRelated').hide();
		// },
		// select: function(combo, newValue) {
		// //    if (newValue) {
		//         if (combo.relatedForm) {
		//             combo.showRelatedButton();
		//         }
		//     // } else {
		//     //     this.getTrigger('openRelated').hide();
		//     // }
		// }
		change: function (combo) {
			var record = combo.getSelectedRecord();
			this.hideRelatedButtons();
			if (record) {
				if (combo.relatedForm) {
					combo.showRelatedButton();
				}
			} else {
				if (combo.relatedForm) {
					combo.showAddRelatedButton();
				}
			}

		}
	},


	//TODO: Repasar que no este comentando codigo util.
	xtype: "At4Framework-combobox",
	loadingText: 'cargando...',
	minChars: 2, //mínimo número de caracteres a escribir antes de ejecutar la búsqueda

	/**
	 *  Filtra según valores
	 *  @return Colección de filtros a aplicar al store, en el formato que acepta Ext.data.Store#addFilter
	 */
	liveFiltersFn: Ext.emptyFn,

	autoCarga: false,
	showAddRelated: false,
	valueField: 'ID',
	displayField: 'DISPLAY',

	// Importante para que no se dispare el la carga al fijar el valor
	autoLoadOnValue: false,

	setComboValue: function (id, values) {
		var value = "",
			label = "";
		if (typeof values[id] == 'object' && values[id].asString != null) {
			value = values[id].asString;
		} else {
			value = values[id];
		}
		var regex = /Id$/;
		if (regex.test(id)) {
			label = values[id.replace(regex, "Label")];
		} else {
			label = values[id];
		}
		if (!!value && !!label) {
			if (!this.store.isLoaded()) {
				this.store.add({
					ID: value,
					DISPLAY: label
				});
				this.store.loadCount++;
			}
			this.selectValue(value);
		}
	},
	selectValue: function (value) {
		var r = this.store.findRecord("ID", value);
		if (r) {
			this.select(r);
		} else {
			this.setRawValue(value);
		}
	},
	setValue: function (value) {
		if (this.store.isLoaded()) {
			this.callParent(arguments);
		} else {
			this.setRawValue(value);
		}
		if (value && this.disableAfterclear) {
			this.enable();
		}
	}

});

Ext.define("At4FrameworkIntranet.RelatedBox",{
	extend: "Ext.form.field.Text",
	xtype: "At4Framework-relatedbox",
	editable: false,
    triggers: {
		openRelated: {
			cls: 'trigger-relationlink',
			weight: -1,
			//hidden: true,
			handler: function (combo) {
				combo.openRelatedForm(combo);
			}
		}
    },
    openRelatedForm: function (combo) {
		var v = this.relatedId;
		if (combo.relatedForm && v) {
			combo.form.application.openRecordForm({
				form: combo.relatedForm,
				iconCls: combo.relatedIconCls
			}, {
				oid: v
			});

		}
	},
    	setComboValue: function (id, values) {
    		var value = "",
    			label = "";
    		if (typeof values[id] == 'object' && values[id].asString != null) {
    			value = values[id].asString;
    		} else {
    			value = values[id];
    		}
    		var regex = /Id$/;
    		if (regex.test(id)) {
    			label = values[id.replace(regex, "Label")];
    		} else {
    			label = values[id];
    		}
    		if (!!value && !!label) {
    			this.setValue(label);
                this.relatedId = value;
    		}
    	},
});



Ext.define("At4FrameworkIntranet.HiddenComboBox", {
	extend: "Ext.form.field.Hidden",
	xtype: "At4Framework-hiddencombobox",

	setValue: function (value) {
		if ((typeof value) == "object") {
			value = value.asString;
		}
		this.callParent([value]);
	}
});

//Ext.extend(At4FrameworkIntranet.ItemSelector, Ext.ux.ItemSelector, {
Ext.define("At4FrameworkIntranet.ItemSelector", {
	extend: "Ext.ux.ItemSelector",

	listeners: {
		render: function (el) {
			if (this.autoLoadOnRender) {
				this.store.load();
			}
		},
		resize: function (el, width, height, oldWidth, oldHeight, eOpts) {
			// console.log(arguments);
		}
	},
	//Poner a true si solo se quiere mostrar el multiselector de la derecha
	showOnlySelected: false,

	/**
	 * @class At4FrameworkIntranet.ItemSelector
	 * @extends Ext.ux.ItemSelector
	 * Personalización de ItemSelector.<br/>
	 * Además de la configuración por defecto adecuada, añade el método {@link setValue} para fijar el valor inicial al cargar los datos.
	 * @author agarcia
	 *
	 * @param {Object} config
	 */
	constructor: function (config) {
		//console.log("Se esta creando un At4Framework-itemselector");

		//this.initialStore = Ext.clone(config.store);
		this.store = config.fromStore;
		//delete config.fromStore;

		this.store.addListener({
			load: {
				scope: this,
				fn: function () {
					//console.log(arguments);
					this.doLayout();
				}
			}
		})
		this.callParent([config]);
		//Esto evita que se vea mal los ultimos pixeles del itemselector
		this.on("render", function () {
			if (!this.layoutRerendered) {
				this.layoutRerendered = true;
				window.setTimeout(function () {
					this.doLayout();
				}.bind(this), 250)
			}
			//this.bindStore(this.initialStore);
		}, this)
	},


	initComponent: function () {
		var me = this;
		me.callParent();
		me.ddGroup = null;
	},

    setupItems: function() {
		var data = this.callParent(arguments);
		if(this.showOnlySelected){
			return data[2];
		}
		return data;
	},
	moveRec: function (add, recs) {
		if(this.showOnlySelected){
			return;
		}
		var me = this,
			fromField = me.fromField,
			toField = me.toField,
			fromStore = add ? fromField.store : toField.store,
			toStore = add ? toField.store : fromField.store;

		fromStore.suspendEvents();
		toStore.suspendEvents();
		fromStore.remove(recs);
		toStore.add(recs);
		toStore.sort("ORDER", "asc");
		fromStore.resumeEvents();
		toStore.resumeEvents();

		fromField.boundList.refresh();
		toField.boundList.refresh();

		me.syncValue();
	},
	/**
	 * xtype del componente: : 'At4Framework-itemselector'
	 * @type {String}
	 */

	xtype: 'At4Framework-itemselector',
	msWidth: 305,
	msHeight: 200,
	width: 630,
	buttons: ["add", "remove"],
	valueField: "ID",
	displayField: "DISPLAY",
	reloadOnSetValues: false,
	autoLoadOnRender: true,

	//TODO: Localear
	toTitle: "Seleccionados",
	fromTitle: "Disponibles",

	// Garrom: Fix para que sea compatible con items de claves compuestas. El codigo viene del parent (Ext.ux.ItemSelector),
	// modificando unicamente la linea comentada
	getRecordsForValue: function (value) {
		var me = this,
			records = [],
			all = me.store.getRange(),
			valueField = me.valueField,
			i = 0,
			allLen = all.length,
			rec,
			j,
			valueLen;
		for (valueLen = value.length; i < valueLen; ++i) {
			for (j = 0; j < allLen; ++j) {
				rec = all[j];
				//puede que value sea una id compuesta, por lo cual debemos comprobar la posibilidad de coincida con el id.asString
				var testRecord = rec.get(valueField);
				if (value[i] && (testRecord == value[i] || testRecord == value[i].asString)) {
					records.push(rec);
				}
			}
		}

		return records;
	},

});

Ext.define("At4FrameworkIntranet.ImporteField", {
	extend: "Ext.form.field.Number",
	constructor: function (config) {
		//console.log("Se esta creando un At4Framework-ImporteField");
		Ext.apply(this, config);
		this.callParent([{}]);
	},
	/**
	 * xtype del componente: 'At4Framework-importe'
	 * @type {String}
	 */
	xtype: 'At4Framework-importe',
	decimalSeparator: '.',
	allowDecimals: true,
	decimalPrecision: 2
});

//Ext.reg('At4Framework-importe', 'At4FrameworkIntranet.ImporteField');

//Ext.extend(At4FrameworkIntranet.CifNifField, Ext.form.TextField, {
Ext.define("At4FrameworkIntranet.CifNifField", {
	extend: "Ext.form.field.Text",
	constructor: function (config) {
		//console.log("Se esta creando un At4Framework-CifNifField");
		Ext.apply(this, config);
		//At4FrameworkIntranet.CifNifField.superclass.constructor.call(this, {})
		this.callParent([{}]);
	},
	/**
	 * xtype del componente: 'At4Framework-cifnif'
	 * @type {String}
	 */
	xtype: 'At4Framework-cifnif',
	regex: /^[A-Za-z]{1}[0-9]{7,9}$|^[X-Zx-z]{1}[0-9]{7,9}[A-Za-z]{1}$|^[0-9]{7,9}[A-Za-z]$|^[A-Za-z]{1}[0-9]{7}[A-Za-z]{1}$/,
	regexText: this.cifIncorrectoTexto,
	width: At4FrameworkIntranet.FormDefaults.HALF_TEXT_FIELD_WIDTH,
	maxLength: 9

});


Ext.define("At4FrameworkIntranet.PasswordField", {
	extend: "Ext.form.field.Text",
	/**
	 * @class At4FrameworkIntranet.PasswordField
	 * Campo de contraseña que añade validación contra otro campo de "repetir contraseña" {@link At4FrameworkIntranet.RepeatPasswordField}.<br/>
	 * @extends-ext Ext.form.TextField
	 * @author agarcia
	 *
	 * @param {Object} config
	 */
	constructor: function (config) {
		//console.log("Se esta creando un At4Framework-PasswordField");
		Ext.apply(this, config);
		this.callParent(this, {
			listeners: {
				valid: {
					fn: this.onValid,
					scope: this
				}
			}
		})
	},
	/**
	 * xtype del componente: 'At4Framework-password'
	 * @type {String}
	 */
	xtype: 'At4Framework-password',
	width: 195,
	allowBlank: true,
	inputType: 'password',
	minLength: 8,

	/**
	 * @cfg {At4FrameworkIntranet.RepeatPasswordField} rePassField
	 * Campo contra el que validar.
	 */
	/**
	 * Campo contra el que validar. Puede configurarse también desde el campo de repetir contraseña, si se configura en éste initPassinitialPassField
	 * @type {At4FrameworkIntranet.RepeatPasswordField}
	 */
	rePassField: null,

	//private
	onValid: function () {
		if (this.rePassField) {
			this.rePassField.validate();
		}
	}
});


Ext.define("At4FrameworkIntranet.RepeatPasswordField", {
	extend: "At4FrameworkIntranet.PasswordField",

	/**
	 * @class At4FrameworkIntranet.RepeatPasswordField
	 * @extends At4FrameworkIntranet.PasswordField
	 * Campo de repetir contraseña para usar con {@link At4FrameworkIntranet.PasswordField}.<br/>
	 * @author agarcia
	 *
	 * @param {Object} config
	 */
	constructor: function (config) {
		//console.log("Se esta creando un At4Framework-RepeatPasswordField");
		Ext.apply(this, config);
		if (this.initialPassField) {
			this.initialPassField.rePassField = this;
		}
		//At4FrameworkIntranet.RepeatPasswordField.superclass.constructor.call(this, {})
		this.callParent(this, {});
	},
	/**
	 * xtype del componente: 'At4Framework-repeatpassword'
	 * @type {String}
	 */
	xtype: 'At4Framework-repeatpassword',

	/** Etiqueta de texto
	 * @type {String}
	 */
	passwordText: 'Las contraseñas no coinciden', //alert if you enter a password that is not the same

	width: 195,
	allowBlank: true,
	inputType: 'password',

	/**
	 * @cfg {At4FrameworkIntranet.PasswordField} initialPassField
	 * Campo contra el que se valida.
	 */
	/**
	 * Campo contra el que se valida. Al indicarse, este campo se fija como {@link At4FrameworkIntranet.PasswordField#rePassField} en el campo.
	 * @type {At4FrameworkIntranet.PasswordField}
	 */
	initialPassField: null,

	/**
	 * Valida el valor del campo re-password
	 * @param {Mixed} value El valor a validar
	 * @return {Boolean} True si el valor es válido, false en caso contrario
	 */
	validator: function (value) {

		if (this.initialPassField) {

			if (value != this.initialPassField.getValue()) {
				//this.markInvalid(this.passwordText);
				return this.passwordText;
			}

		}

		return true;
	}

});


/*
At4FrameworkIntranet.DateField = function(config){
Ext.apply(this, config);
At4FrameworkIntranet.DateField.superclass.constructor.call(this, {} );
};
Ext.extend(At4FrameworkIntranet.DateField, Ext.form.DateField, {

xtype:'At4Framework-comdate',
format: 'd-m-Y'

});

Ext.reg('At4Framework-comdate', At4FrameworkIntranet.DateField);
*/


Ext.define("At4FrameworkIntranet.Window", {
	extend: "Ext.window.Window",
	xtype: "at4window",

	constructor: function (cfg) {
		Ext.apply(this, cfg);
		cfg = {};
		this.originalHeight = this.height;
		this.originalWidth = this.width;
		this.callParent(arguments);
		this.on("show", At4FrameworkIntranet.resizeFormWindow);
		this.on("resize", At4FrameworkIntranet.resizeFormWindow);
	}
})


At4FrameworkIntranet.resizeFormWindow = function (obj, width, height, oldWidth, oldHeight) {
	if (!obj || !obj || obj.hidden || obj.disabled) {
		return;
	}
	// CALCULATE NEW SIZES
	var winSize = Ext.getBody().getViewSize();
	//var newWidth = Math.min(winSize.width, this.windowWidth);
	//var newHeight = Math.min(winSize.height, this.windowHeight);
	var newWidth = Math.min(winSize.width, width);
	var newHeight = Math.min(winSize.height, height);
	if (!(isNaN(newWidth) || isNaN(newHeight))) {
		obj.setSize(newWidth, newHeight);
	}
	obj.center();
};


Ext.define("Ext.ux.at4.SpaceField", {
	extend: "Ext.container.Container",
	xtype: "spaceField",
	height: 22,
	width: 320
});

Ext.define("At4FrameworkIntranet.FotoField", {
	extend: "Ext.Img",
	src: "img/no_img.jpg",
	loadingSrc: "img/no_img.jpg",
	mixins: [
		"Ext.form.Labelable",
		"Ext.form.field.Field"
	],
	xtype: "imageField",
	setValue: function (value) {
		this.getEl().dom.src = this.loadingSrc;
		if (!value) {
			return;
		}
		var src = "./export/descarregar?objectId=" + value + "&docname=foto-foto&mode=inline";
		if (this.disableCache) {
			src += "&v=" + new Date().getTime();
		}
		this.getEl().dom.src = src;
	}
})




Ext.define("Ext.ux.at4.OneToOneField", {
	extend: "Ext.form.FieldContainer",
	xtype: "otofield",
	minHeight: 50,
	constructor: function () {
		this.button = Ext.create({
			xtype: "button",
			//TODO: Localear
			disaabled: true,
			text: "Abrir",
			handler: function () {
				this.application.openRecordForm({
					iconCls: this.relatedIconCls,
					form: this.relatedForm
				}, {
					oid: this.recordId
				});
			},
			scope: this,
		});
		this.items = [this.button];
		this.callParent(arguments);
	},
	setValue: function (val) {
		if(val){
			this.recordId = val;
			this.button.enable();
		}else{
			this.button.disable();
		}


	}

});


Ext.define("Ext.ux.at4.ynncField", {
	extend: "Ext.form.ComboBox",
	xtype: "ynncField",
	queryMode: 'local',
	valueField: 'ID',
	displayField: 'DISPLAY',
	//minHeight: 50,
	editable: false,
	constructor: function () {
		// The data store containing the list of states
		var datos = Ext.create('Ext.data.Store', {
		    fields: ['DISPLAY', 'ID'],
		    data : [
		        {"DISPLAY":"No", "ID":"0"},
		        {"DISPLAY":"Si", "ID":"1"},
			    {"DISPLAY":"NS", "ID":"2"},
		    ]
		});
		this.store = datos;
		this.callParent(arguments);
	},
	setValue: function(val){
		val = val +"";
		//console.log(val);
		return this.callParent([val]);
	}

});
// Currency Component
Ext.define('Ext.ux.CurrencyField', {
    extend: 'Ext.form.field.Number',
    alias: ['widget.currencyfield'],
    privateFocus: false,
    currency: '€', //change to the symbol you would like to display.
    listeners: {
        render: function(cmp) {
            cmp.showCurrency(cmp);
        },
        blur: function(cmp) {
            cmp.privateFocus = false;
            cmp.showCurrency(cmp);
        },
        focus: function(cmp) {
            cmp.privateFocus = true;
            cmp.setRawValue(cmp.valueToRaw(cmp.getValue()));
        },
        change: function(cmp, value) {
            if(!cmp.privateFocus){
                cmp.showCurrency(cmp);
            }
        }

    },
    showCurrency: function(cmp) {
        cmp.setRawValue(Ext.util.Format.currency(cmp.valueToRaw(cmp.getValue()), cmp.currency, 2, true));
    },
    valueToRaw: function(value) {
        if(!value){
            return value;
        }
        return value.toString().replace(/[^0-9.]/g, '');
    },
    rawToValue: function(value) {
        return Ext.util.Format.round(this.valueToRaw(value), 2);
    },
    getSubmitValue: function(){
        var val = this.callParent(arguments);
        return this.valueToRaw(val);
    },
    getErrors: function(val){
        val = this.rawToValue(val);
        return this.callParent([val]);
    }
});
// END Currency Component
/*Ext.define("At4FrameworkIntranet.RadioGroup", {
	//extend: "Ext.form.RadioGroup",
	height: 50,

	setValue: function(v) {
		var value = {};
		value[this.name] = v;
		//console.log("setting value", value);
		this.group.setValue(value);
	},
	constructor: function(cfg) {
		this.store = cfg.store;
		delete cfg.store;
		this.items = [];
		this.store.each(function(record) {
			//console.log(record);
			this.items.push({
				inputValue: record.data.ID,
				name: cfg.name,
				boxLabel: record.data.DISPLAY
			})
		}, this)
		Ext.apply(cfg, {
			items: this.items,
			setValue: function(v) {
				var value = {};
				value[this.name] = v;
				//console.log("setting value", value);
				this.callParent([value]);
			},
		});
		this.group = Ext.create("Ext.form.RadioGroup", cfg)
		return this.group;
	},
	getFieldEditor: function() {
		console.log("JAAAAJAJAJ");
		return null;
	}
})*/

Ext.define("At4FrameworkIntranet.RadioGroup", {
	extend: "Ext.form.RadioGroup",
	xtype: "at4-radiogroup",
	height: 50,
	setValue: function(v) {
		var value = {};
		value[this.name] = v;
		//console.log("setting value", value);
		this.callParent([value]);
	},
	constructor: function(cfg) {
		var comboConfig = {
			store: cfg.store,
			displayField: cfg.displayField,
			valueField: cfg.valueField
		}
		delete cfg.displayField;
		delete cfg.valueField;
		delete cfg.store;
		this.gridEditor = Ext.create("Ext.form.field.ComboBox", comboConfig);
		cfg.items = [];
		comboConfig.store.each(function(record) {
			this.items.push({
				inputValue: record.data.ID,
				name: cfg.name,
				boxLabel: record.data.DISPLAY
			})
		}, cfg);
		if (At4Framework_modoDesarrollo) {
			console.warn("Revisar que ", this, " tenga el grid con el store filter");
		}
		return this.callParent([cfg]);
	}
})
/**
 * @author: garrom
 * Campo de texto simple con multi idioma y menu desplegable
 */
Ext.define("At4FrameworkIntranet.MultilangText", {
	extend: "Ext.form.field.Text",
	xtype: 'At4FrameworkIntranet-multilangtext',
	mixins: {
		multilang: 'At4FrameworkIntranet.mixin.MenuMultilang'
	},
	//True si activar el cambiar de lenguaje con teclas
	enableKeyEvents: true,

	constructor: function (config) {
		this.callParent(arguments);
		this.mixins.multilang.constructor.call(this, config);
	},
	triggers: {
		selIdioma: {
			cls: "multilang-icon-Es",
			handler: function () {
				this.mixins.multilang.seleccionarIdioma.call(this, this.currentLang + 1);
			}
		},
		dropIdioma: {
			cls: "multilang-all",
			handler: function () {
				this.mixins.multilang.desplegarIdiomas.call(this);
			}
		}
	},
	/*
	    listeners:{
	        render: function(){
	            //garrom: Por alguna extraña razon no se llama a la funcion render del mixin, provocando que el
	            //formulario padre no tenga los campos multiidioma en ellos
	            this.mixins.multilang.listeners.render.call(this);
	        },
	        change: function(){
	            //garrom: Mas de lo mismo:
	            this.mixins.multilang.listeners.change.call(this);
	        }
	    },*/


	initComponent: function () {
		this.callParent();
		this.mixins.multilang.initComponent.call(this);
	},
	getErrors: function () {
		if (this.mixins.multilang.checkError.call(this)) {
			return this.callParent(arguments);
		}
		return [];
	}

});


/**
 * @author: garrom
 * Area de texto grande simple
 */

Ext.define("At4FrameworkIntranet.Textarea", {
	extend: "Ext.form.field.TextArea",
	//override:
	growMin: 80,
	growMax: 350,
	grow: true
});

/**
 * @author: garrom
 * Area de texto grande multilenguaje
 */

Ext.define("At4FrameworkIntranet.MultilangTextarea", {
	extend: "Ext.form.field.TextArea",
	xtype: 'At4FrameworkIntranet-multilangtextarea',
	mixins: {
		multilang: 'At4FrameworkIntranet.mixin.DroppedMultilang'
	},
	width: At4FrameworkIntranet.FormDefaults.TEXT_FIELD_WIDTH,
	//override:
	growMin: 80,
	growMax: 350,
	grow: true,

	triggers: {
		selIdioma: {
			cls: "multilang-icon-Es",
			extraCls: "multilang-icon",
			handler: function () {
				this.seleccionarIdioma.call(this, this.currentLang + 1);
			}
		}
	},
	constructor: function (config) {
		this.callParent(arguments);
		this.mixins.multilang.constructor.call(this, config);
	},

	initComponent: function () {
		this.mixins.multilang.initComponent.call(this, "TextArea");
		this.callParent();
	},
	getErrors: function () {
		if (this.mixins.multilang.checkError.call(this)) {
			return this.callParent(arguments);
		}
		return [];
	}

	/*
	    triggers: {
	        es: {
	            cls: "multilang-icon-Es",
	            extraCls: " multilang-icon",
	            width: "22px",
	            height: "22px"
	        },
	        en: {
	            cls: " multilang-icon-En",
	            extraCls: "multilang-icon",
	            width: "22px",
	            height: "22px"
	        },
	        ca: {
	            cls: "multilang-icon-Ca",
	            extraCls: " multilang-icon",
	            width: "22px",
	            height: "22px"
	        },
	        xx: {
	            cls: "multilang-icon-Xx",
	            extraCls: " multilang-icon",
	            width: "22px",
	            height: "22px"
	        },
	    },*/
	/*
	listeners:{
	    render: function(){
	        //garrom: Por alguna extraña razon no se llama a la funcion render del mixin, provocando que el
	        //formulario padre no tenga los campos multiidioma en ellos
	        this.mixins.multilang.listeners.render.call(this);
	    },
	    change: function(){
	        //garrom: Mas de lo mismo:
	        this.mixins.multilang.listeners.change.call(this);
	    }
	},*/
});


/**
 * @author: garrom
 * Area de texto avanzada (html) con un editor CKE
 */

if (typeof CKEDITOR !== "undefined") {
	Ext.define("At4FrameworkIntranet.HtmlArea", {
		extend: "Ext.ux.CKEditor",
		xtype: 'At4FrameworkIntranet-htmlarea',
		labelStyle: "height: 25px;",
		listeners: {
			resize: function (extjScope, ckeScope) {
				extjScope.ownerCt.doLayout();
			},
			instanceReady: function (extjScope, ckeScope) {
				extjScope.ownerCt.doLayout();
			}
		}
	});


	/**
	 * @author: garrom
	 * Area de texto avanzada (html) con un editor CKE y multi idioma
	 */

	Ext.define("At4FrameworkIntranet.MultilangHtmlArea", {
		extend: "At4FrameworkIntranet.HtmlArea",
		xtype: 'At4Framework-multilanghtmlarea',
		mixins: {
			multilang: 'At4FrameworkIntranet.mixin.simpleMultilang'
		},
		width: At4FrameworkIntranet.FormDefaults.TEXT_FIELD_WIDTH,
		//override:
		grow: false,
		labelAlign: "top",
		/*
    triggers: {
        selIdioma: {
            cls: "multilang-icon-Es",
            extraCls: " multilang-icon",
            handler: function() {
                this.seleccionarIdioma.call(this, this.currentLang + 1);
            }
        }
    },
*/

		constructor: function (config) {
			//console.log("MultilangHtmlArea::constructor");
			this.callParent(arguments);
			this.mixins.multilang.constructor.call(this, config);
			window.temp1 = this;
		},
		initComponent: function () {
			//this.CKConfig.extraPluginTestScope = this;
			//his.mixins.multilang.initComponent.call(this);
			//console.log("MultilangHtmlArea::initComponent");
			this.mixins.multilang.initComponent.call(this, "TextArea");
			this.callParent();
		},
		getErrors: function () {
			if (this.mixins.multilang.checkError.call(this)) {
				return this.callParent(arguments);
			}
			return [];
		},

		listeners: {
			render: function () {
				//garrom: Por alguna extraña razon no se llama a la funcion render del mixin, provocando que el
				//formulario padre no tenga los campos multiidioma en ellos
				this.mixins.multilang.listeners.render.call(this);
			},
			change: function () {
				//garrom: Mas de lo mismo:
				this.mixins.multilang.listeners.change.call(this);
			}
		},

		seleccionarIdioma: function (numero) {
			var prevLang = this.currentLang
			this.currentLang++;
			if (this.currentLang >= this.langs.length) {
				this.currentLang = 0;
			}
			var nextLang = this.currentLang;
			//Seteamos el valor que esta ahora en el editor a su input.
			this.inputs[this.langs[prevLang]].setValue(this.getValue());
			//Seteamos el valor del input del nuevo lang al editor.
			this.setValue(this.inputs[this.langs[nextLang]].getValue());
			//Cambiamos la clase del trigger
			var newCLS = 'multilang-icon-' + this.langs[nextLang];
			this.triggerEl.removeCls('multilang-icon-' + this.langs[prevLang]).addCls(newCLS);
			return newCLS;
		},
		CKConfig: {
			extraPlugins: 'justify,multilang',
			extraPluginFn: function () {
				this.seleccionarIdioma.call(this, this.currentLang + 1);
			},
			toolbarGroups: [{
				name: 'document',
				groups: ['mode', 'document', 'doctools']
			}, {
				name: 'clipboard',
				groups: ['clipboard', 'undo']
			}, {
				name: 'editing',
				groups: ['find', 'selection', 'multilanggroup']
			}, {
				name: 'forms'
			}, {
				name: 'basicstyles',
				groups: ['basicstyles', 'cleanup']
			}, {
				name: 'paragraph',
				groups: ['list', 'indent', 'blocks', 'align', 'bidi']
			}, {
				name: 'links'
			}, {
				name: 'styles',
				groups: ['styles']
			}, {
				name: 'styles'
			}, {
				name: 'colors'
			}, {
				name: 'tools'
			}, {
				name: 'others'
			}, {
				name: 'about'
			}],
			"entities": false,
			"basicEntities": false,
			skin: 'icy_orange',
			preset: 'full',
			languages: {
				'ca': 1,
				'en': 1,
				'es': 1
			}
		}
	});
}
//Namespace de At4FrameworkIntranet
Ext.namespace('At4FrameworkIntranet');

/**
 * @class Ext.form.FileUploadField
 * Definicio del camp per pujar fitxers.
 * És un camp de text TextField amb un un input file que s'envia al servlet
 * adient.
 * La part de multiidioma s'ha fet mirant com estava feta a la resta de JSPs
 * @extends-ext Ext.form.TextField
 * @author okkum
 */

//Ext.form.FileUploadField = Ext.extend(Ext.form.TextField,  {
//TODO: Inutil?
Ext.define("At4FrameworkIntranet.fileuploadfield", {
    extend: "Ext.form.TextField",
    windowHeight: 150,

    constructor: function(cfg) {
        this.addEvents(
            /**
             * @event fileselected
             * Fires when the underlying file input field's value has changed from the user
             * selecting a new file from the system file selection dialog.
             * @param {Ext.form.FileUploadField} this
             * @param {String} value The file value returned by the underlying file input field
             */
            'fileselected'
        );
        this.callParent([cfg]);
    },

    readOnly: true,
    style: 'width: 200px',
    /**
     * @hide
     * @method autoSize
     */
    autoSize: Ext.emptyFn,
    browseTxt: this.browseTxt,


    // private
    //initComponent: function() {
        //Ext.form.FileUploadField.superclass.initComponent.call(this);
   //     this.callParent();
    //},

    // private
    onRender: function(ct, position) {
        this.callParent(arguments);

        this.wrap = this.el.wrap({
            cls: 'x-form-field-wrap x-form-file-wrap'
        });
        this.el.addClass('x-form-file-text');
        this.el.dom.removeAttribute('name');

        this.createFileInput();

        var btnCfg = Ext.applyIf(this.buttonCfg || {}, {
            text: this.browseTxt
        });

        this.button = new Ext.Button(Ext.apply(btnCfg, {
            renderTo: this.wrap,
            cls: 'x-form-file-btn' + (btnCfg.iconCls ? ' x-btn-icon' : '')
        }));

        this.addFileListener();
        //Ext.form.FileUploadField.superclass.onRender.call(this, ct, position);

    },

    // private
    getFileInputId: function() {
        return this.id + '-file';
    },

    // private
    onResize: function(w, h) {
        //Ext.form.FileUploadField.superclass.onResize.call(this, w, h);
        this.callParent(arguments);
        this.wrap.setWidth(w);
    },

    // private
    preFocus: Ext.emptyFn,

    // private
    getResizeEl: function() {
        return this.wrap;
    },

    // private
    getPositionEl: function() {
        return this.wrap;
    },

    // private
    alignErrorIcon: function() {
        this.errorIcon.alignTo(this.wrap, 'tl-tr', [2, 0]);
    },

    //reseta el form, elimina el input y crea uno nuevo para borrar la acción anterior
    reset: function() {

        var fileInput = this.getFileInput();
        if (fileInput != null) {
            Ext.get(fileInput.id).findParentNode("form").reset();

            var duration = 100;
            var thisObj = this;

            //el retardo es para evitar que se duplique el input y no funcione la carga de archivos
            setTimeout(function() {
                thisObj.removeFileInput();
            }, duration);
            setTimeout(function() {
                thisObj.createFileInput();
            }, duration);
            setTimeout(function() {
                thisObj.addFileListener();
            }, duration);

        }

    },

    //private
    createFileInput: function() {
        this.fileInput = this.wrap.createChild({
            //id: this.getFileInputId(),
            name: this.name || this.getId(),
            cls: 'x-form-file',
            tag: 'input',
            type: 'file',
            size: 1
        });
    },

    //private
    removeFileInput: function() {
        this.fileInput.remove();
    },

    //private
    addFileListener: function() {
        this.fileInput.on('change', function() {
            var v = this.fileInput.dom.value;
            this.setValue(v);
            this.fireEvent('fileselected', this, v);
        }, this);

    },

    //public
    getFileInput: function() {
        return this.fileInput;
    }

});

//Ext.reg('fileuploadfield', 'Ext.form.FileUploadField');



Ext.enableDWRUploadFile = function(config) {

    var popup = {};
    popup['submit'] = config.submit;
    popup['check'] = config.check;

    var buttonIcon = config.buttonIcon;
    if (typeof(buttonIcon) == 'undefined') {
        buttonIcon = this.buttonIcon;
    }

    var buttonText = config.buttonText;
    if (typeof(buttonText) == 'undefined' || buttonText == '') {
        buttonText = this.buttonText;
    }

    /*popup['file'] = new At4FrameworkIntranet.fileuploadfield({
        fieldLabel: this.fieldLabel,
        width: 300
    });*/

    popup['file'] = Ext.create("Ext.form.field.File",{
        fieldLabel: this.fieldLabel,
        labelAlign: "top",
        labelWidth: 75,
        width: 300,

    })

    popup['fieldset'] = new Ext.form.FieldSet({
        defaults: {
            msgTarget: 'under',
            validationEvent: true
        },
        border: false,
        labelAlign: "top",
        autoHeight: true,
        autoWidth: true,
        collapsible: false,
        items: [popup['file']]
    });

    popup['nav'] = new Ext.FormPanel({
        labelWidth: 100,
        //frame: true,
        padding: "10 5 10 5",
        width: 200,
        border: false,
        fileUpload: true,
        collapsible: false,
        defaultType: 'textfield',
        items: [popup['fieldset']]
    });

    popup['dlgPopup'] = new Ext.Window({
        modal: true,
        layout: 'fit',
        width: 400,
        height: this.windowHeight,
        closable: false,
        resizable: false,
        plain: true,
        title: this.windowTitle,
        items: [popup['nav']],
        buttons: [{
            text: this.uploadButtonText,
            iconCls: this.uploadButtonIcon,
            handler: function() {
                popup['submit']();
                popup['dlgPopup'].hide();
            }
        }, {
            text: this.closeButtonText,
            iconCls: this.closeButtonIcon,
            handler: function() {
                popup['dlgPopup'].hide();
            }
        }]
    });

    this.uploadButton = new Ext.Button({
        text: buttonText,
        disabled: false,
        tabIndex: config.tabIndex,
        iconCls: buttonIcon,
        disabled: this.disabled,
        scope: this,
        handler: function() {
            if (popup['check']()) {
                var input = popup['file'];
                input.reset();
                popup['dlgPopup'].show();
            }
        }
    });

    this.getFileInput = function() {
        //return popup['file'].inputCell;
        return popup.file.button.fileInputEl.dom;
    }
}
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
// Namespace de At4FrameworkIntranet
Ext.namespace('At4FrameworkIntranet');

/**
 * Panel principal de formulario
 * @class At4FrameworkIntranet.FieldMainPanel
 * Panel principal
 //garrom: Si extiende de Ext.container.Container es mucho mas "baarato"
 * @extends-ext Ext.Panel
 * @author agarcia
 *
 * @param {Object} config
 */
Ext.define("At4FrameworkIntranet.FieldMainPanel", {
	extend: "Ext.container.Container",
	/**
	 * xtype del componente
	 * @type {String}
	 */
	xtype: 'At4Framework-fieldmainpanel',
	defaults: At4FrameworkIntranet.FormDefaults.FIELD_DEFAULTS,
	collapsible: false,
	layout: 'anchor',
	//autoScroll: true,
	labelAlign: 'top',
	border: false,
	//width: "100%"
});

/**
 * TabPanel de formulario
 * @class At4FrameworkIntranet.FormTabPanel
 * Panel principal
 * @extends-ext Ext.TabPanel
 * @author agarcia
 *
 * @param {Object} config
 */
//At4FrameworkIntranet.FormTabPanel = function(config) {
Ext.define("At4FrameworkIntranet.FormTabPanel", {
	extend: "Ext.TabPanel",

	/*constructor: function(config) {
	    Ext.apply(this, config);
	    this.callParent([{}]);
	},*/


	/**
	 * xtype del componente
	 * @type {String}
	 */
	xtype: 'At4Framework-formtabpanel',
	plain: true,
	border: true,
	layout: 'fit',
	bodyBorder: true,
	bodyStyle: "border-top: 0",
	activeTab: 0,
	width: "100%",
	minWidth: 840,
	//height: 500,
	enableTabScroll: true,
	deferredRender: false,
	defaults: {
		layout: 'anchor',
		labelWidth: 80,
		width: "100%",
		defaultType: 'textfield',
		bodyStyle: 'padding:15px 0px 15px 15px',
		hideMode: 'offsets'
	}
});

Ext.define("At4FrameworkIntranet.subFormContainer", {
	extend: "Ext.container.Container",
	xtype: 'At4Framework-subFormContainer',
	margin: "12px 0px 0px 0px",
	width: "100%",
	minWidth: 840,
	//height: "100%",
	layout: 'fit',
});

Ext.define("At4FrameworkIntranet.responsiveContainer", {
	extend: "Ext.container.Container",
	xtype: 'At4Framework-responsiveContainer',
	defaults:  Ext.apply(At4FrameworkIntranet.FormDefaults.COLUMN_DEFAULTS, {
		margin: "0px 10px 10px 10px",
		cls: "at4-field"
	}),
	margin: 15,
	layout: 'column',
});
Ext.define("At4FrameworkIntranet.rowContainer", {
	extend: "Ext.container.Container",
	defaults: Ext.apply(At4FrameworkIntranet.FormDefaults.COLUMN_DEFAULTS, {
		//margin: "0px 10px 10px 10px"
		cls: "at4-field"
	}),
	xtype: 'At4Framework-rowContainer',
	width: "100%",
	cls: "at4-rowContainer",
	minWidth: 840,
	layout: {
		type: 'hbox',
		pack: 'start'
	}
});


/*
 *  @author: cNavarro y gArrom
 *  Es un mixin que puede ser usado en formularios. Da la función timerange que se debe usar dentro del evento "onChange" de un campo datefield.
 *  Usa la siguiente configuración  en las propiedades del field:
 *  @prop startTimeField: Nombre del field del cual cogerá el valor MINIMO que puede tener el campo propietario de la propiedad
 *  @prop endTimeField: Nombre del field del cual cogerá el valor MAXIMO que puede tener el campo propietario de la propiedad
 *  NOTA: Si un campo posee las dos configuraciones, su rango variará entre el mínimo y máximo.
 *
 *  Example:
 *
 *        fields.inicio = new Ext.form.DateField({
 *            name: 'inicio',
 *            ...
 *            endTimeField: 'fin', //below component
 *            listeners: {
 *                change: {
 *                    fn: function(el,value,old, eopts) {this.timerange(value, el)},
 *                    scope: this
 *                }
 *            }
 *        })
 *        fields.fin = new Ext.form.DateField({
 *            name: 'fin',
 *           ...
 *            startTimeField: 'inicio', //above component
 *            listeners: {
 *                change: {
 *                    fn: function(el,value,old, eopts) {this.timerange(value, el)},
 *                    scope: this
 *                }
 *            }
 *        })
 *
 */
Ext.define("At4FrameworkIntranet.mixin.DateRangeValidator", {
	timerange: function (val, field) {
		//formulario
		var name = field.name;
		var fields = this.getForm().getFields().items;
		for (var i = 0; i < fields.length; i++) {
			var otherfield = fields[i];

			if (otherfield.startTimeField == name) {
				otherfield.setMinValue(val);
			}
			if (otherfield.endTimeField == name) {
				otherfield.setMaxValue(val);
			}
		};
		return true;
	}
});


Ext.define("At4FrameworkIntranet.IFrame", {
	extend: "Ext.ux.IFrame",
	autoregister: true,
	constructor: function () {
		var me = this;
		me.callParent(arguments);
		me.addListener("afterrender", function () {
			// console.log(arguments);
			var iframe = me.el.select("iframe").elements[0];
			if (!iframe) {
				return;
			}
			// iframe.addEventListener("loadstart", function(e){
			//     console.log("loadstart", e);
			// });
			// iframe.addEventListener("load", function(e){
			//     console.log("load", e);
			//     iframe.contentWindow.document.addEventListener("unload", function(){
			//         console.log("unload", e);
			//
			//     });
			// });
			// console.log("attach", iframe);

			iframe.onload = function () {
				me.fireEventArgs("frameload", arguments);
				iframe.contentWindow.onunload = function () {
					me.fireEventArgs("frameunload", arguments);
				}
			};

		});
	},
	beforeDestroy: function () {
		if (this.autoregister) {
			this.application.unRegisterTabId(this);
		}
		this.callParent();
	}
})
Ext.define("At4FrameworkIntranet.ExportBasePrompt", {
	extend: "At4FrameworkIntranet.Window",
	xtype: "at4gridSavePrompt",
	width: 300,
	modal: true,
	plain: true,
	title: "Guardar configuracion",
	layout: 'fit',
	height: 220,
	//resizable: false,
	closable: false,
	closeAction: "hide",


    // LOCALE START
    inputLabelTxt: "Nombre",
    sobrescribirLabelTxt: "Nombre duplicado, sobrescribir?",
    configuracionPrivadaLabelTxt: "Configuracion privada",
    guardarLabel: "Guardar",
    cancelarLabel: "Cancelar",
    stateSaveSuccessTxt: "Exito en guardar el estado",
    stateSaveErrorTxt: "Error al guardar el estado, por favor, vuelva a intentarlo mas tarde.",


    expcfgSaveSuccessTxt: "Exito en guardar la configuracion",
    expcfgSaveErrorTxt: "Error al guardar la configuracion, por favor, vuelva a intentarlo mas tarde.",


    //LOCALE END
	constructor: function (cfg) {
		Ext.apply(this, cfg);
		this.loadTrigger = Ext.create("Ext.form.trigger.Trigger", {
			hidden: true,
			cls: "loadingTrigger"
		});

		this.input = Ext.create({
			labelAlign: "top",
			fieldLabel: this.inputLabelTxt,
			xtype: "textfield",
			style: "margin-top: 6px;margin-left: 8px",
			width: 275,
			listeners: {
				change: {
					scope: this,
					fn: this.onChangeFn
				}
			},
			triggers: [this.loadTrigger]
		});

		this.sobrescribir = Ext.create({
			xtype: "checkbox",
			fieldLabel: this.sobrescribirLabelTxt,
			style: "margin-left: 8px",
			width: 275,
			labelWidth: 250,
			hidden: true
		});
		if (this.showPrivada) {
			this.privada = Ext.create({
				xtype: "checkbox",
				fieldLabel: this.configuracionPrivadaLabelTxt,
				style: "margin-left: 8px",
				width: 275,
				labelWidth: 250,
				value: true
			});
		}

		this.save = Ext.create({
			xtype: "button",
			text: this.guardarLabel,
			scope: this,
			handler: this.onSaveFn
		});
		this.cancel = Ext.create({
			xtype: "button",
			text: this.cancelarLabel,
			scope: this,
			handler: this.onCancelFn
		});


		this.items = {
			xtype: "panel",
			buttonAlign: 'right',
			layout: "vbox",
			defaults: {
				style: ""
			},
			items: [this.input, this.sobrescribir, this.privada],
			buttons: [this.save, this.cancel]
		};
		this.callParent();
	},

	show: function (formScope) {
		this.formScope = formScope;
		this.input.setValue();
		this.sobrescribir.setValue();
		this.sobrescribir.hide();
		this.loadTrigger.hide();
		this.callParent();
	},

	onSaveFn: function () {
		var canclose = this.doOnSave(this, this.formScope);
		if (canclose) {
			this.close();
		}
	},
	onCancelFn: function () {
		var canclose = this.doOnClose(this, this.formScope);
		if (canclose) {
			this.close();
		}
	},
	onChangeFn: function () {
		this.doOnChange(this, this.formScope);
	},
});
Ext.define("At4FrameworkIntranet.AppCfgPrompt", {
	extend: "At4FrameworkIntranet.ExportBasePrompt",
	xtype: "at4appConfigSavePrompt",
	doOnClose: function () {
		return true;
	},
	doOnChange: function (el, grid) {

		if (!el.dt) {
			el.dt = new Ext.util.DelayedTask();
		}
		el.loading = true;
		el.loadTrigger.show();
		el.dt.delay(
			750,
			function () {
				GuiService.isAppCfgNameUsed(el.input.getValue(), grid.stateId, function (data) {
					el.loading = false;
					el.loadTrigger.hide();
					if (data) {
						el.valid = true;
						//el.input.clearInvalid();
						el.sobrescribir.hide();
					} else {
						el.valid = false;
						//el.input.markInvalid("Nombre no disponible");
						el.sobrescribir.show();
					}
				})
			}, grid
		)
	},
	doOnSave: function (el, grid) {
		var mustOverwrite = el.sobrescribir.getValue();
		if (el.loading || !(el.valid || (!el.valid && mustOverwrite))) {
			return false;
		}
		var value = el.input.getValue();
		//var state = this.getState();
		var name = grid.stateId;
		//var state = Ext.state.Manager.provider.state[name];
		var state = grid.getState();
		var data = {
			etiqueta: value,
			nombre: name,
			valor: encodeURIComponent(JSON.stringify(state))
		}
		GuiService.saveAppConfig(data, mustOverwrite, function (result) {
			var msg = "";
			if (result) {
				msg = this.stateSaveSuccessTxt;
			} else {
				msg = this.stateSaveErrorTxt;
			}
			Ext.toast({
				html: msg,
				header: false,
				autoCloseDelay: 5000,
				align: "bl"
			})
		})
		return true;
	},
});
Ext.define("At4FrameworkIntranet.ExportCfgPrompt", {
	extend: "At4FrameworkIntranet.ExportBasePrompt",
	xtype: "at4ExportConfigSavePrompt",
	showPrivada: true,
	height: 250,
	doOnClose: function () {
		return true;
	},
	doOnChange: function (el, grid) {

		if (!el.dt) {
			el.dt = new Ext.util.DelayedTask();
		}
		el.loading = true;
		el.loadTrigger.show();
		el.dt.delay(
			750,
			function () {
				GuiService.isExportCfgNameUsed(el.input.getValue(), grid.fromScope.stateId, function (data) {
					el.loading = false;
					el.loadTrigger.hide();
					if (data) {
						el.valid = true;
						//el.input.clearInvalid();
						el.sobrescribir.hide();
					} else {
						el.valid = false;
						//el.input.markInvalid("Nombre no disponible");
						el.sobrescribir.show();
					}
				})
			}, grid
		)
	},
	doOnSave: function (el, form) {
		var mustOverwrite = el.sobrescribir.getValue();
		if (el.loading || !(el.valid || (!el.valid && mustOverwrite))) {
			return false;
		}
		var values = form.getValues();
		var value = el.input.getValue();
		var name = form.fromScope.stateId;
		var isprivada = el.privada.getValue();
		var data = {
			etiqueta: value,
			nombre: name,
			privada: isprivada,
			columnas: encodeURIComponent(JSON.stringify(values.columns)),
			formato: encodeURIComponent(JSON.stringify(values.formato))
		}
		GuiService.saveExportConfig(data, mustOverwrite, function (result) {
			var msg = "";
			if (result) {
				msg = this.expcfgSaveSuccessTxt;
				var fn = form.afterInsertItem || function () {};
				fn = fn.bind(form);
				fn(result);
			} else {
				msg = this.expcfgSaveErrorTxt;
			}
			Ext.toast({
				html: msg,
				header: false,
				autoCloseDelay: 5000,
				align: "bl"
			})
		})
		return true;
	},
});
Ext.define("At4FrameworkIntranet.ExportForm", {
	extend: "Ext.form.Panel",
	xtype: "configureExportForm",



	// LOCALE START
	formatoTxt: "Formato",
	columnasTxt: "Columnas",
	configuracionTxt: "Configuraciones guardadas",
	cargarTxt: "Cargar",
	guardarTxt: "Guardar",
	reiniciarTxt: "Reiniciar",
	borrarTxt: "Borrar",
	cerrarTxt: "Cerrar",
	exportarTxt: "Exportar",
	formats: [{
		label: "Documento Microsoft Excel (xls)",
		code: "xls"
	}, {
		label: "Valores separados por coma (csv)",
		code: "csv"
	}, {
		label: "Documento portable PDF (pdf)",
		code: "pdf"
	}, {
		label: "Documento Microsoft Word (docx)",
		code: "docx"
	}],
	//LOCALE END
	constructor: function (config) {
		this.id = Ext.id();
		this.fromScope = config.application;
		this.nameStateId = config.application.stateId;

		var fields = {};
		var formats = this.formats;
		var formatsStore = Ext.create('Ext.data.Store', {
			fields: ['label', 'code'],
			data: formats
		});
		var columnsData = [];
		for (var i = 0; i < config.customExportColumns.length; i++) {
			var column = config.customExportColumns[i];
			var columnName = column.header;
			var columnDI = column.dataIndex;
			if (columnDI && columnName && column.baseId != "-leftActions-head" && column.baseId != "-rightActions-head") {
				columnsData.push({
					label: columnName,
					code: columnDI
				});
			}
		}

		var columnsStore = Ext.create('Ext.data.Store', {
			fields: ['label', 'code'],
			data: columnsData
		});

		var storefilters = {
			liveFiltersFn: function () {
				return [{
					property: 'nombre',
					value: this.nameStateId
				}];
			}.bind(this)
		}
		fields.formato = Ext.create({
			xtype: "combobox",
			fieldLabel: this.formatoTxt,
			store: formatsStore,
			queryMode: "local",
			editable: false,
			displayField: "label",
			labelAlign: "top",
			name: "formato",
			value: "pdf",
			allowBlank: false,
			width: 250,
			valueField: "code"
		})
		fields.columnas = Ext.create({
			xtype: "At4Framework-itemselector",
			fieldLabel: this.columnasTxt,
			//queryMode: "local",
			ddReorder: false,
			disableDD: true,
			draggable: false,
			name: "columns",
			width: 450,
			height: 400,
			displayField: "DISPLAY",
			labelAlign: "top",
			valueField: "ID",
			//remoteFilter: false,
			//autoLoadOnRender: false,
			fromStore: At4FrameworkIntranet.FormDefaults.getStore(this.fromScope.gridMetaData.formItem.form, {
				name: 'ORDER',
				type: 'int'
			}, null, FormDataService.getExportCols),
		})

		fields.configuracion = new At4FrameworkIntranet.ComboBox({
			labelAlign: "top",
			fieldLabel: this.configuracionTxt,
			store: At4FrameworkIntranet.FormDefaults.getStore('ConfigExportacion', [{
				name: "FORMATO"
			}, {
				name: "COLUMNAS"
			}, {
				name: "EDITABLE",
				type: "boolean"
			}], storefilters, GuiService.getListadoConfigExportacion),
			remoteFilter: false,
			allQuery: this.nameStateId,
			width: At4FrameworkIntranet.FormDefaults.TEXT_FIELD_WIDTH,
			recordPK: 'id',
			showAddRelated: false,
			showReloadButton: true,
			editable: false,
			listeners: {
				change: {
					scope: this,
					fn: function (el, newval, oldval) {
						if (newval && el.getSelectedRecord().data.EDITABLE) {
							this.fields.aplicar.enable();
							this.fields.borrar.enable();
						} else {
							this.fields.aplicar.disable();
							this.fields.borrar.disable();
						}
					}
				}
			}
		})

		fields.aplicar = Ext.create({
			xtype: "button",
			text: this.cargarTxt,
			scope: this,
			disabled: true,
			border: true,
			//margin: "30px 0px 17px 95px;",
			handler: function () {
				var record = this.fields.configuracion.getSelectedRecord();
				var formatoval = JSON.parse(decodeURIComponent(record.get("FORMATO")));
				var columnsval = JSON.parse(decodeURIComponent(record.get("COLUMNAS")));
				this.fields.formato.setValue(formatoval);
				this.fields.columnas.setValue(columnsval);
				// console.log("aplicar", arguments);
			}
		});
		fields.guardar = Ext.create({
			xtype: "button",
			text: this.guardarTxt,
			scope: this,
			border: true,
			handler: function (bt, ev) {
				this.nameWindow.show(this);
			}
		});
		fields.reiniciar = Ext.create({
			xtype: "button",
			text: this.reiniciarTxt,
			scope: this,
			border: true,
			handler: function (bt, ev) {
				this.reset();
			}
		});
		fields.borrar = Ext.create({
			xtype: "button",
			text: this.borrarTxt,
			scope: this,
			disabled: true,
			border: true,
			//margin: "30px 0px 17px 95px;",
			handler: function () {
				var disp = this.fields.configuracion.getDisplayValue()
				var val = this.fields.configuracion.getValue();
				Ext.Msg.show({
					title: 'Seguro?',
					message: 'Esta a punto de borrar una configuracion de exportado. Este cambio no se puede deshacer',
					buttons: Ext.Msg.YESNO,
					icon: Ext.Msg.QUESTION,
					fn: function (btn) {
						if (btn === 'yes') {
							GuiService.removeConfigExportacion(val, function (result) {
								if (result) {
									//borrado guay
									Ext.Msg.alert("Finalizado", "La configuracion \"" + disp + "\" ha sido borrada exitosamente");
									var combo = fields.configuracion;
									combo.clearValue();
									combo.store.load(combo.store.lastOptions);
								} else {
									//borrado error
									Ext.Msg.alert("Error", "Hubo un error en borrar la configuracion \"" + disp + "\".");
								}
							});
						}
					}
				});

			}
		});
		this.fields = fields;
		this.items = {
			xtype: "container",
			scrollable: true,
			height: "100%",
			layout: "anchor",
			items: [{
				xtype: "At4Framework-responsiveContainer",
				layout: "column",
				minHeight: 90,
				border: "0 0 1px 0",
				padding: "7px 15px 0 15px",
				style: {
					borderColor: 'black',
					borderStyle: 'solid'
				},
				items: [fields.configuracion, {
						xtype: "container",
						width: "100%",
						layout: "hbox",
						padding: "10px 20px",
						defaults: {
							margin: '0 5 5 0'
						},
						items: [
							fields.aplicar,
							fields.guardar,
							fields.borrar,
							fields.reiniciar
						]
					}

				],
			}, {
				xtype: "At4Framework-responsiveContainer",
				style: "padding-top: 13px;",
				items: At4FrameworkIntranet.FormDefaults.columns([
					//	[fields.nombre, {}],
					[fields.columnas, fields.formato]
				])
			}]
		}
		var nameWindowID = this.getId() + "nameWindow";
		this.nameWindow = Ext.getCmp(nameWindowID);
		if (!this.nameWindow) {
			this.nameWindow = Ext.create({
				xtype: "at4ExportConfigSavePrompt"
			});
		}
		this.buttons = [
			/*{
						text: "Guardar configuracion de exportacion",
						scope: this,
						handler: function (bt, ev) {
							this.nameWindow.show(this);
						}
					},*/

			{
				text: this.exportarTxt,
				scope: this,
				handler: function (bt, ev) {
					var values = this.getValues();
					var format = values.formato || "pdf";
					var cols = values.columns || [];
					this.fromScope.exportFile(format, null, null, "advancedExport", cols);
					console.log("exportar", arguments);
				}
			}, {
				text: this.cerrarTxt,
				iconCls: At4util.icons.close,
				scope: this,
				cls: "at4-delete",
				style: 'margin: 0px 5px 0px 5px',
				handler: function () {
					this.fromScope.configWindow.close();
				}
			}
		];
		this.callParent();
	},
	afterInsertItem: function (recordRaw) {
		var record = {
			FORMATO: recordRaw.formato,
			COLUMNAS: recordRaw.columnas,
			DISPLAY: recordRaw.etiqueta,
			ID: recordRaw.id,
		}
		var field = this.fields.configuracion;
		field.store.loadRawData([record]);
		field.selectValue(recordRaw.id);
		console.log(record);
	},

});
Ext.define("At4FrameworkIntranet.ExportWindow", {
	extend: "At4FrameworkIntranet.Window",
	xtype: "at4GridListWindow",
	width: 355,
	modal: true,
	plain: true,
	layout: 'fit',
	height: 170,
	resizable: true,
	closable: true,
	closeAction: "destroy",
	// LOCALE START
	title: "Configuraciones de listado",
	cargarTxt: "Cargar",
	seleccionarTxt: "Seleccionar configuracion",
	borrarTxt: "Borrar",
	borrarMsgTitle: 'Seguro?',
	borrarMsgMessage: 'Esta a punto de borrar una configuracion del listado. Este cambio no se puede deshacer',
	borrarMsgOkTitle: "Finalizado",
	borrarMsgOk: "La configuracion %disp% ha sido borrada exitosamente",
	borrarMsgKoTitle: "Error",
	borrarMsgKo: "Hubo un error en borrar la configuracion %disp%.",
	//LOCALE END
	constructor: function (cfg) {
		var fields = {};
		var storefilters = {
			liveFiltersFn: function () {
				return [{
					property: 'nombre',
					value: cfg.name
				}];
			}
		}
		fields.configuracion = new At4FrameworkIntranet.ComboBox({
			labelAlign: "top",
			fieldLabel: this.seleccionarTxt,
			editable: false,
			margin: "5px 0 0 15px",
			width: 320,
			store: At4FrameworkIntranet.FormDefaults.getStore('ConfigAplicacion', {
				name: "VALOR"
			}, storefilters, GuiService.getListadoConfigAplicacion),
			remoteFilter: false,
			recordPK: 'id',
			showReloadButton: true,
			showAddRelated: false,
			listeners: {
				change:{
					scope: this,
					fn: function(el, newval, oldval){
						if(newval){
							fields.borrar.enable();
							fields.cargar.enable();
						}else{
							fields.borrar.disable();
							fields.cargar.disable();
						}
					}
				}
			}
		})
		fields.cargar = Ext.create({
			xtype: "button",
			scope: this,
			showReloadButton: true,
			text: this.cargarTxt,
			disabled: true,
			handler: function () {
				console.log(arguments);
				var record = fields.configuracion.getSelectedRecord();
				var state = JSON.parse(decodeURIComponent(record.data.VALOR));
				console.log(state);
				var canClose = cfg.onLoad(state);
				if (canClose) {
					this.close();
				}
			}
		})
		fields.borrar = Ext.create({
			xtype: "button",
			scope: this,
			showReloadButton: true,
			text: this.borrarTxt,
			disabled: true,
			handler: function () {
				var disp = this.fields.configuracion.getDisplayValue()
				var val = this.fields.configuracion.getValue();
				Ext.Msg.show({
					title: this.borrarMsgTitle,
					message: this.borrarMsgMessage,
					buttons: Ext.Msg.YESNO,
					icon: Ext.Msg.QUESTION,
					fn: function (btn) {
						if (btn === 'yes') {
							GuiService.removeConfigAplicacion(val, function (result) {
								if (result) {
									//borrado guay
									Ext.Msg.alert(this.borrarMsgOkTitle, this.borrarMsgOk.replace("%disp%", disp));
									var combo = fields.configuracion;
									combo.clearValue();
									combo.store.load(combo.store.lastOptions);
								} else {
									//borrado error
									Ext.Msg.alert(this.borrarMsgKoTitle, this.borrarMsgKo.replace("%disp%", disp));
								}
							});
						}
					}
				});
			}
		})
		this.fields = fields;
		this.items = {
			xtype: "panel",
			buttonAlign: 'right',
			layout: "vbox",
			items: [fields.configuracion],
			buttons: [fields.cargar, fields.borrar]
		};
		this.callParent();
	},

});
Ext.define('At4FrameworkIntranet.AbstractGrid', {
	extend: 'Ext.grid.Panel',

	/***********************************************************
	 * Cadenas
	 **********************************************************/

	/**
	 * Etiqueta de texto
	 *
	 * @type {String}
	 */
	yesText: 'Si',

	/**
	 * Etiqueta de texto
	 *
	 * @type {String}
	 */
	noText: 'No',

	/**
	 * Etiqueta de texto
	 *
	 * @type {String}
	 */
	abrirText: 'Abrir',

	/**
	 * Etiqueta de texto
	 *
	 * @type {String}
	 */
	accionesText: 'Acciones',

	/**
	 * Etiqueta de texto
	 *
	 * @type {String}
	 */
	eliminarText: 'Eliminar',

	/**
	 * Etiqueta de texto
	 *
	 * @type {String}
	 */
	guardarText: 'Guardar',

	/**
	 * Etiqueta de texto
	 *
	 * @type {String}
	 */
	guardarTodoText: 'Guardar todo',

	/**
	 * Etiqueta de texto
	 *
	 * @type {String}
	 */
	cancelarTodoText: 'Cancelar todo',

	/**
	 * Etiqueta de texto
	 *
	 * @type {String}
	 */
	pregCancelarTodoText: 'Â¿Cancelar todo?',

	/**
	 * Etiqueta de texto
	 *
	 * @type {String}
	 */
	cancelarTodoMsgText: '¿Desea cancelar todos los cambios pendientes?<br/>Esta acción no se puede deshacer.',

	/**
	 * Etiqueta de texto
	 *
	 * @type {String}
	 */
	copiarText: 'Copiar',

	/**
	 * Etiqueta de texto
	 *
	 * @type {String}
	 */
	nadaHacerText: 'Nada que hacer',

	/**
	 * Etiqueta de texto
	 *
	 * @type {String}
	 */
	noRegistroModificadoText: 'No hay ningún registro modificado.',

	/**
	 * Etiqueta de texto
	 *
	 * @type {String}
	 */
	modificadoElementoText: 'Modificado 1 elemento ',

	/**
	 * Etiqueta de texto
	 *
	 * @type {String}
	 */
	modificadosElementosText: 'Modificados {0} elementos ',

	/**
	 * Etiqueta de texto
	 *
	 * @type {String}
	 */
	limpiarFiltrosText: 'Limpiar filtros',

	/**
	 * Etiqueta de texto
	 *
	 * @type {String}
	 */
	limpiarFiltrosTipText: 'Limpiar los filtros configurados',

	/**
	 * Etiqueta de texto
	 *
	 * @type {String}
	 */
	nuevoText: 'Nuevo',

	/**
	 * Etiqueta de texto
	 *
	 * @type {String}
	 */
	nuevoTipText: 'Añadir nuevo registro',

	/**
	 * Etiqueta de texto
	 *
	 * @type {String}
	 */
	exportarText: 'exportar',

	/**
	 * Etiqueta de texto
	 *
	 * @type {String}
	 */
	exportarTipText: 'convertir a formatos de intecambio',

	/**
	 * Etiqueta de texto
	 *
	 * @type {String}
	 */
	cargandoText: 'cargando ...',

	/**
	 * Etiqueta de texto
	 *
	 * @type {String}
	 */
	noPuedeMoverColumnaText: 'No puede mover esta columna',

	/**
	 * Etiqueta de texto
	 *
	 * @type {String}
	 */
	borrarRegistroTxt: 'Â¿Borrar registro?',

	/**
	 * Etiqueta de texto
	 *
	 * @type {String}
	 */
	borrarSeguroTxt: 'Â¿Borrar el registro {0}?<br/>Esta acción no se puede deshacer.',

	/**
	 * Etiqueta de texto
	 *
	 * @type {String}
	 */
	borrarAuditorias: 'Â¿Borrar el registro {0}?<br/>Esta acción no se puede deshacer.',

	/**
	 * Etiqueta de texto
	 *
	 * @type {String}
	 */
	textExportarPdfSolicitud: 'PDF de la solicitud',

	/**
	 * Etiqueta de texto
	 *
	 * @type {String}
	 */
	textExportarPdfsSolicituds: 'PDFs de les solicituds',

	/**
	 * Etiqueta de texto
	 *
	 * @type {String}
	 */
	pdfs: 'PDFs',

	/**
	 * Etiqueta de texto
	 *
	 * @type {String}
	 */
	textCodigoBarras: 'Lectura de código de barras',

	/**
	 * Etiqueta de texto
	 *
	 * @type {String}
	 */
	codigoBarras: 'Introducir código',

	/**
	 * Etiqueta de texto
	 *
	 * @type {String}
	 */
	textInformeDeutes: 'Informe de Deutes',

	/**
	 * Etiqueta de texto
	 *
	 * @type {String}
	 */
	textInformeDeficiencies: 'Informe de Deficiencies',

	textTramitsAudiencia: 'Tramits audiÃ¨ncia',

	errorInformeDeficiencies: "No es pot generar l'informe de deficiencies. La convocatoria no te aquest tipus d'informe.",

	errorInformeDeutes: "No es pot generar l'informe de deutes. La convocatoria no te aquest tipus d'informe.",

	errorInformeDeutesCompteCorrent: "No es pot generar l'informe de deutes. L'expedient no te el compte de pagament informat.",

	errorInformeTramitsAudiencia: "No es pot generar l'informe de tramis d'audiÃ¨ncia. La convocatoria no te aquest tipus d'informe.",

	/***********************************************************
	 * Fin de cadenas
	 **********************************************************/


	// Flag que indica si se ha ejecutado el autosize de columnas, usado para que éste sólo se ejecute en la primera carga

	autoSizeColumns: function () {
		if (this.autoSized) {
			return;
		}
		if (this.application.tabPanel.getActiveTab() != this && this.rendered) {
			return;
		}
		if (!this.store.isLoaded()) {
			return;
		}

		this.autoSized = true;
		if(At4Framework_modoDesarrollo){
			console.debug("Autosize columns");
		}
		window.setTimeout(function () {
			var columns = this.getView().getHeaderCt().getVisibleGridColumns()
			var columncount = columns.length;
			for (var i = 0; i < columncount; i++) {
				var column = columns[i];
				column.autoSize();
				if(column.width < column.autoSizeMinWidth){
					column.setWidth(column.autoSizeMinWidth);
				}else if(column.width > column.autoSizeMaxWidth){
					column.setWidth(column.autoSizeMaxWidth);
				}
			}
		}.bind(this), 50);
	},

	/**
	 * exporta la última petición al servidor
	 *
	 * @param {String}
	 *            type csv|xls|pdf
	 * @private
	 */
	exportFile: function (type, action, record, filename, exportCols) {

		if (!action) {
			action = './export/exportar';
		}

		var lastParams = this.store.lastOptions;

		filename = filename ? filename : "export";

		/* Combinamos el post */
		var postInputs = {
			filename: filename
		};
		if (lastParams.grouper) {
			postInputs.groupBy = lastParams.grouper._property;
		}

		if (lastParams.sorters) {
			postInputs.direction = lastParams.sorters[0] ? lastParams.sorters[0]._direction : '';
		}
		if (lastParams.groupers) {
			postInputs.sort = lastParams.sorters[0] ? lastParams.groupers[0]._property : '';
		}
		if (lastParams.sorters) {
			postInputs.sort = postInputs.sort ? postInputs.sort : "";
			postInputs.sort += lastParams.sorters[0] ? lastParams.sorters[0]._property : '';
		}
		var filters = lastParams.filters ? lastParams.filters : [];
		var z = 0;
		for (var i = 0; i < filters.length; i++, z++) {
			postInputs['filter_field_' + z] = filters[i]._property;
			var ftype = filters[i].type;
			ftype = (ftype == "multiList") ? "list" : ftype;
			postInputs['filter_type_' + z] = ftype;
			var val = filters[i]._value;
			if (val instanceof Date) {
				val = Ext.Date.format(val, "d/m/Y");
			}
			postInputs['filter_value_' + z] = val;
			if (filters[i]._operator && filters[i].type != "boolean") {
				postInputs['filter_comparison_' + z] = filters[i]._operator;
			}
		}

		for (var i = 0; i < this.extraFilters.length; i++, z++) {
			postInputs['filter_field_' + z] = this.extraFilters[i].field;
			postInputs['filter_type_' + z] = this.extraFilters[i].data.type;
			postInputs['filter_value_' + z] = this.extraFilters[i].data.value;
			if (this.extraFilters[i].data.comparison) {
				postInputs['filter_comparison_' + z] = this.extraFilters[i].data.comparison;
			}
		}

		// Incluimos el tipo de grid
		postInputs.formName = this.gridMetaData.formItem.form;
		postInputs.exportCols = exportCols || [];
		/* Creamos un iframe oculto donde llamar a la descarga */
		var id = Ext.id();
		var frame = document.createElement('iframe');
		/*
		 * var frame = Ext.DomHelper.append(document.body, {
		 * tag:'iframe' });
		 */
		frame.id = id;
		frame.name = id;
		frame.className = 'x-hidden';
		if (Ext.isIE) {
			frame.src = Ext.SSL_SECURE_URL;
		}

		document.body.appendChild(frame);

		if (Ext.isIE) {
			document.frames[id].name = id;
		}

		/* Creamos el formulario con los datos del informe */
		var form = Ext.DomHelper.append(document.body, {
			tag: 'form',
			method: 'post',
			action: action + '.' + type,
			target: id
		});

		// frame.appendChild(form);
		document.body.appendChild(form);

		var hidden;

		for (var prop in postInputs) {

			// append cmd to form
			hidden = document.createElement('input');
			hidden.type = 'hidden';
			hidden.name = prop;
			hidden.value = postInputs[prop];
			form.appendChild(hidden);
		}

		// clave del item del que obtendremos el pdf
		if (record) {
			var clave = record.get('oid');
			hidden = document.createElement('input');
			hidden.type = 'hidden';
			hidden.name = 'claveItemPdf';
			hidden.value = clave;
			form.appendChild(hidden);
		}

		/*
		 * Creamos el callback para eliminar el frame y el
		 * formulario tras la descarga
		 */
		var callback = function () {
			Ext.EventManager.removeListener(frame, 'load', callback, this);
			/*setTimeout(function() {
			    frame.removeChild(form);
			}, 100);*/
			setTimeout(function () {
				document.body.removeChild(frame);
			}, 110);
		};

		Ext.EventManager.on(frame, 'load', callback, this);

		/* enviamos el formulario */
		form.submit();
	},

	findFirstGroupingField: function (columns) {
		for (i in columns) {
			if (columns[i].groupable) {
				return columns[i].dataIndex;
			}
		}
		return "";
	},
	/*
	 * función para renderizar una celda extrayendo el valor
	 * de un store
	 */
	columnStoreRenderer: function (v, params, record, rowIndex, colIndex) {
		var rendered = "";
		if (v) {
			var storeRecord = null;
			//if ((storeRecord = this.gridMetaData.columns[colIndex].columnStore.getById(v))) {
			if ((storeRecord = params.column.columnStore.getById(v))) {
				rendered = storeRecord.get('DISPLAY');
			} else {
				rendered = v;
			}
		}
		//record.data.rendered_parents = rendered;
		return rendered;
	},








	configureGridMetaData: function () {
		var gridMetaData = this.gridMetaData;
		var customConfig = this.customConfig;

		if (gridMetaData.configured) {

			//Probablemente sea mas optimo un for en vez de un ext.each
			for (var i = 0; i < this.columns.length; i++) {
				var column = this.columns[i];
				this.configureEditMode(column);
				//TODO: garrom: En extj5 no se pueden poner id's duplicados, por lo cual hay que resetearlos.
				// Se deberia mirar una mejor manera
				column.id = this.getId() + column.baseId;
				column.stateId = this.stateId + column.baseId;
			}

			useGroupSummary = gridMetaData.useGroupSummary;

			if (!gridMetaData.disableOpenForm) {
				this.leftRowActions = this.columns[0];
				// this.leftRowActions.id =  this.getId() + "-leftActions-head";
			}
			if (this.gridMetaData.showDeleteButton) {
				this.rightRowActions = this.columns[this.columns.length - 1];
				// this.rightRowActions.id =  this.getId() + "-rightActions-head";
			}

		} else {

			for (var i = 0; i < this.columns.length; i++) {
				var column = this.columns[i];
				this.configureEditMode(column);

				column.baseId = column.dataIndex + "-head";
				column.id = this.getId() + column.baseId;
				column.stateId = this.stateId + column.baseId;
				if (customConfig && customConfig.columns && customConfig.columns[column.dataIndex]) {
					Ext.apply(column, customConfig.columns[column.dataIndex]);
				}

				this.configureRenderers(column);

				this.configureFilters(column);

				// Si no hay configurado ancho, lo ponemos al mínimo. Después el proceso autoSize ya lo ampliará si es necesario
				if (!column.width) {
					column.width = 150;
				}

				this.configureSummaryType(column);


			}

			this.configureRowActions();
			this.bindActions();
			this.gridMetaData.configured = true;
		}
	},

	configureRowActions: function () {
		var customConfig = this.customConfig;
		var configProperties = this.configProperties;
		var gridMetaData = this.gridMetaData;
		if (!gridMetaData.disableOpenForm) {
			this.leftRowActions = Ext.apply({
				header: "&nbsp;",
				xtype: 'actioncolumn',
				width: 50,
				baseId: "-leftActions-head",
				id: this.getId() + "-leftActions-head",
				items: [{
					setIconCls: 'icon-add',
					//http://docs.sencha.com/extjs/4.2.0/#!/api/Ext.grid.column.Action
					icon: 'img/ico/Editar_ico.png', // Use a URL in the icon config
					//tooltip: 'Edit',
					tooltip: this.abrirText,
					handler: function (grid, rowIndex, colIndex) {
						var rec = grid.getStore().getAt(rowIndex);
						//alert("Edit " + rec.get('codigo'));
						//TODO: Test this:
						rec.data.oid = rec.data.oid || rec.data.codigo;
						this.openRecord(rec);
					}.bind(this)
				}]
			}, this.rowActionsDefaults);

			// Añadimos la columna
			this.columns.splice(0, 0, this.leftRowActions);

		}
		// Acciones de la columna derecha (guardar, borrar, exportar pdf, personalizadas)
		this.rightActions = new Array();
		this.hasRowActions = false;


		//TODO:	garrom: Creo que ya no hace falta porque el propio plug-in de
		// 		row edit te pone uno de guardar y otro de cancelar guardar
		if (configProperties.editMode) {
			saveButton = {
				iconCls: 'icon-disk',
				getClass: function (v, meta, rec) {
					if (rec.dirty) {
						return 'icon-disk';
					} else {
						return 'x-item-disabled-icon-disk';
					}
				},
				tooltip: this.guardarText,
				disabled: true,
				hideIndex: 'cannotSave'
			};


			//
			// copyButton = { iconCls:
			// 'icon-application-double', tooltip :
			// this.copiarText, };
			// this.rightActions.push(copyButton);
			//
			cancelButton = {
				iconCls: 'icon-cross',
				getClass: function (v, meta, rec) {
					if (rec.dirty) {
						return 'icon-cross';
					} else {
						return 'x-item-disabled-icon-cross';
					}
				},
				tooltip: this.guardarText,
				disabled: true,
				hideIndex: 'cannotSave'
			};
			this.rightActions.push(saveButton);
			this.rightActions.push(cancelButton);
			this.hasRowActions = true;
		}

		// boton borrar
		if (this.gridMetaData.showDeleteButton) {

			// boton borrar
			deleteButton = {
				iconCls: 'icon-minus',
				tooltip: this.eliminarText,
				hideIndex: 'cannotDelete'
			};
			this.rightActions.push(deleteButton);
			this.hasRowActions = true;
		}

		// acciones personalizadas
		if (customConfig && customConfig.rightActions) {
			for (var i = 0; i < customConfig.rightActions.length; i++) {
				this.rightActions.push(customConfig.rightActions[i]);
			}
			this.hasRowActions = true;
		}
	},

	bindActions: function () {
		if (this.hasRowActions) {
			if (this.rightActions) {
				var items = [];
				for (x in this.rightActions) {
					if (this.rightActions.hasOwnProperty(x)) {
						items.push({
							iconCls: this.rightActions[x].iconCls,
							//disabled: !!this.rightActions[x].disabled,
							getClass: this.rightActions[x].getClass,
							handler: this.rightRowActionsHandler,
							scope: this,
							tooltip: this.rightActions[x].tooltip
						});
					}
				}

				this.rightRowActions = Ext.apply({
					header: this.accionesText,
					xtype: 'actioncolumn',
					baseId: "-rightActions-head",
					id: this.getId() + "-rightActions-head",
					width: 100,
					items: items
				}, this.rowActionsDefaults);

			}
			// Añadimos la columna
			this.columns[this.columns.length] = this.rightRowActions;
		} // cierra (actions)
	},


	// campos editables
	configureEditMode: function (column) {
		var customConfig = this.customConfig;
		var configProperties = this.configProperties;
		if (configProperties.editMode) {
			if (column.editable) {
				var editor = {};
				if (customConfig && customConfig.editor && customConfig.editor[column.dataIndex]) {
					editor = customConfig.editor[column.dataIndex];
				} else {
					editor = this.formPanel.getFieldEditor(column.dataIndex);
				}

				if (editor) {
					column.editor = editor;
					column.editor.grid = this;
					column.editor.boxLabelCls = "at4-hidden";
					column.editor.labelCls = "at4-hidden";
					if (!editor.disabled) {
						column.cls = 'editable-cell-header';
						column.tdCls = 'editable-cell';
					}
				}
			}
		} else {
			column.editable = false;
		}
	},
	// renderers de campos
	configureRenderers: function (column) {
		var customConfig = this.customConfig;
		var gridMetaData = this.gridMetaData;
		/* Si hay un renderer especial, lo configuramos */
		column.minWidth = 70;
		column.maxWidth = 1024;
		column.autoSizeMinWidth = 70;
		column.autoSizeMaxWidth = 240;
		if (customConfig && customConfig.renderers && customConfig.renderers[column.dataIndex]) {
			column.renderer = customConfig.renderers[column.dataIndex];
		} else if (column.sofaRenderer) {
			switch (column.sofaRenderer) {
			case 'text':
				column.renderer = function (value, metaData, record, rowIndex, colIndex, store) {
					metaData.css = 'sofa-wrap-normal';
					var rendered = Ext.util.Format.ellipsis(value, 300);
					//record.data.rendered_parents = rendered;
					return rendered;
				};
				if (!column.width) {
					column.width = 120;
				}
				column.autoSizeMinWidth = 70;
				column.autoSizeMaxWidth = 200;
				// marcamos la columna para no calcular el tamaño
				break;
			case 'largetext':
				column.renderer = function (value, metaData, record, rowIndex, colIndex, store) {
					metaData.css = 'sofa-wrap-normal';
					var rendered = Ext.util.Format.ellipsis(value, 300);
					return rendered;
				};
				if (!column.width) {
					column.width = 240;
				}
				column.autoSizeMinWidth = 160;
				column.autoSizeMaxWidth = 240;
				// marcamos la columna para no calcular el tamaño
				break;
			case 'many2many':
				column.renderer = function (value, metaData, record, rowIndex, colIndex, store) {
					metaData.css = 'sofa-wrap-normal';
					if (value == '' || value == null || value.length < 1) {
						return value;
					}
					/* separando con un separador */
					var separator = ', ';
					var ret = '';
					for (var i = 0; i < value.length; i++) {
						if (i > 0) {
							ret += separator;
						}
						ret += value[i].primaryLabel;
					}

					return ret;
				};
				if (!column.width) {
					column.width = 240;
				}
				column.autoSizeMinWidth = 240;
				column.autoSizeMaxWidth = 240;
				// marcamos la columna para no calcular el tamaño
				break;
			case 'password':
				column.renderer = function (value, metaData, record, rowIndex, colIndex, store) {
					return "********";
				};
				break;
			case 'date':
				column.renderer = function (value, metaData, record, rowIndex, colIndex, store) {
					var rendered = "";
					if (value) {
						rendered = Ext.Date.format(value, 'd-m-Y');
					}
					return rendered;
				}
				break;
			case 'datetime':
				column.renderer = function (value, metaData, record, rowIndex, colIndex, store) {
					var rendered = "";
					if (value) {
						rendered = Ext.Date.format(value, 'd-m-Y H:i');
					}
					return rendered;
				}
				break;
			case 'time':
				column.renderer = Ext.util.Format.dateRenderer('H:i:s');
				break;
			case 'euromoney':
				column.renderer = Ext.util.Format.euroMoney;
				column.align = 'right';
				break;
			case 'bulkimage':
			case 'binfile':
				column.renderer = function (
					value, metaData, record,
					rowIndex, colIndex, store) {
					return value ? this.yesText : this.noText;
				}.bind(this);
				break;
			case 'boolean':
				column.renderer = function (
					value, metaData, record,
					rowIndex, colIndex, store) {
					if (value === null) {
						return '';
					}
					return value ? this.yesText : this.noText;
				}.bind(this);
				break;
			case 'popup':

				var modelName = 'At4FrameworkIntranet.simpleStoreModel' + gridMetaData.formItem.form + column.dataIndex;
				if (!eval(modelName)) {
					Ext.define(modelName, {
						extend: 'Ext.data.Model',
						fields: ['ID', 'DISPLAY'],
						idProperty: "ID"
					});
				}
				column.columnStore = Ext.create("Ext.data.Store", {
					model: modelName,
					data: column.sofaStoreValues
				});
				column.renderer = this.columnStoreRenderer.bind(this);
				break;

			case 'relationpopup':

				// TODO: configurar los filtros tipo "list"

				var columnName = column.dataIndex;
				var relatedForm = column.relatedForm;

				column.columnStore = Ext.create("Ext.data.Store", {
					proxy: serverDatabaseActions.createRelationPopupProxy(relatedForm),
					reader: {
						type: "json",
						totalProperty: "totalNumRecords",
						rootProperty: "resultados",
						id: 'ID'
					},
					fields: [{
						name: "ID"
					}, {
						name: "DISPLAY"
					}],
				});

				column.columnStore.load();
				column.renderer = this.columnStoreRenderer.bind(this);
				break;

			case 'checkbox':
				break;
			}
		}


	},
	// filtros de campos
	configureFilters: function (column) {
		var configProperties = this.configProperties;
		var customConfig = this.customConfig;
		if (configProperties.useFilters) {
			var newFilter = null;
			if (column.sofaFilter) {
				var type = column.sofaFilter.type;
				switch (type) {
				case "multicombo":
					if (!column.columnStore) {

						if (customConfig && customConfig.columnStore && customConfig.columnStore[column.dataIndex]) {
							column.columnStore = customConfig.columnStore[column.dataIndex];
						} else {
							var relatedForm = column.relatedForm;
							column.columnStore = At4FrameworkIntranet.FormDefaults.getStore(relatedForm);
						}

					}

					if (column.columnStore) {
						column.sofaFilter.type = 'multiList';
						//column.sofaFilter.type = 'list';
						column.sofaFilter.labelField = "DISPLAY";
						column.sofaFilter.idField = "ID";
						column.sofaFilter.phpMode = true;
						column.sofaFilter.store = column.columnStore;
						/* if (column.sofaStoreValues) {
							 column.sofaFilter.mode = 'local';
						 }*/
						newFilter = column.sofaFilter;
					}
					break;
					// case "multiList":
				case "list":
					if (column.sofaStoreValues) {
						column.sofaFilter.labelField = 'DISPLAY';
						column.sofaFilter.phpMode = true;
						column.sofaFilter.options = column.sofaStoreValues;
						newFilter = column.sofaFilter;
					}
					break;
				default:
					newFilter = column.sofaFilter;
					break;

				}
				column.filter = column.sofaFilter;
			}

		}
	},
	// summary de campos
	configureSummaryType: function (column) {
		var configProperties = this.configProperties;
		// Si está configurado el tipo de sumario, marcamos para que se incluya el plugin
		if (column.summaryType) {
			this.gridMetaData.useGroupSummary = true;
			//column.summaryType = "count";
			column.summaryRenderer = function (value, metaData, record, rowIndex, colIndex, store) {
				if (this.renderer) {
					value = this.renderer(value, metaData, record, rowIndex, colIndex, store);
				}
				//console.log(colIndex + metaData.column.text + ": " + value);
				//this.renderizadoSummary = metaData.column.text + ": " + value;
				this.renderizadoSummary = metaData[this.id].text + ": " + value;
				//metaData.tdAttr = 'style="color: red; background-color: #F1F2F4 !important;"'
				return value;
			}.bind(column);
		}
	},
	rightRowActionsHandler: function (grid, rowIndex, colIndex, action, event, record) {
		//console.log(action.iconCls);
		switch (action.iconCls) { // alert("??" + action);
		case 'icon-minus':
			this.deleteRecord(record);
			break;
		case 'icon-disk':
			this.updateRecord(record);
			break;
		case 'icon-cross':
			this.rejectRecord(record);
			break;
		case 'icon-arrow-up':
			this.actualizarPosicion(record, 'up');
			break;
		case 'icon-arrow-down':
			this.actualizarPosicion(record, 'down');
			break;
		case 'icon-map':
			this.mostrarMapa(record);
			break;
		case 'icon-application-double':
			alert('duplicado');
			break;
		default:
			Ext.toast("Error: Accion no reconocida.");
			break;
		}
	},

	/*applyState: function(state){
		console.log(arguments);
		 this.callParent(arguments);
		 //his.store.load();
	},
	getState: function () {
		console.log(arguments);
		var state = this.callParent(arguments);
		return state;
	}
	applyState: function (state) {
		//test.columns[6].setVisible(false);
		//Ext.each(this.columns, function (i, column) {

		//});
		this.reconfigure(this.store, state.columns);
	},
	getState: function () {
		var me = this;
		//state = me.callParent(),
		var state = {};
		state.columns = [];
		storeState = me.store.getState();
		Ext.each(this.columns, function ( column, i) {
			state.columns[i] = {
				width: column.width,
				visible: column.isVisible(),
				id: column.stateId
			}
		}.bind(me));
		return state;
	}*/

});
﻿ // Namespace de At4FrameworkIntranet
Ext.namespace('At4FrameworkIntranet');
/**
 * @reworked.
 * @author: garrom@at4.net
 */
Ext.define('At4FrameworkIntranet.ListadoGrid', {
	extend: 'At4FrameworkIntranet.AbstractGrid',
	uses: ['Ext.ux.grid.PageSize'],

	/**
	 * @class At4FrameworkIntranet.ListadoGrid Una especialización de grid.Panel para tratar las
	 *        diferentes funcionalidades de listado de At4FrameworkIntranet
	 * @author agarcia
	 */
	constructor: function (viewer, config, application, gridMetaData, customConfig) {
		this.debugConstructorCallTime = new Date();
		this.viewer = viewer;
		this.application = application;
		this.customConfig = customConfig;
		this.autoSized = false;

		Ext.apply(this, config);

		/* Metadata del grid, recibida del servidor */
		this.gridMetaData = gridMetaData;

		/*
		 * Número de filtros activos, para llevar control del estado del botón "limpiar filtros"
		 */
		this.activeFilterCount = 0;

		// Permite configurar el grid
		if (customConfig) {
			if (customConfig.gridConfig) {
				Ext.apply(specialConfig, customConfig.gridConfig);
			}
		}

		// Según el tipo de grid que nos piden, vamos a configurar un objeto con propiedades
		var configProperties = new At4FrameworkIntranet.ListadoGridConfig(this, specialConfig);
		configProperties.editMode = gridMetaData.editable;
		this.editMode = configProperties.editMode;

		/*******************************************************
		 * Configuración del Store general del grid 1.- Record
		 * 2.- Reader 3.- Store
		 ******************************************************/
		this.columns = gridMetaData.columns;

		/*
		 * tipo de grid: (por definir, ejemplos: normal,
		 * editable, agrupable, etc )
		 */

		this.tipo = gridMetaData.editable ? "editable" : config.tipo;

		// var campos = gridMetaData.recordFields;

		var modelName = "At4FrameworkIntranet.dataModel" + this.id;

		var model = "";

		this.extraFilters = customConfig ? customConfig.extraFilters : [];

		if (Ext.ClassManager.isCreated(modelName)) {
			model = Ext.ClassManager.get(modelName);
		} else {
			model = Ext.define(modelName, {
				extend: 'Ext.data.Model',
				idProperty: "oid",
				proxy: {
					type: "dwr",
					dwrFunction: FormDataService.getListado,
					dwrParams: [this.gridMetaData.formItem.form],
					listeners: this.getListeners(this.extraFilters),
					reader: {
						type: "json",
						totalProperty: "totalNumRecords",
						rootProperty: "resultados",
						model: model
					}
				},
				fields: gridMetaData.recordFields
			});
		};


		var storeConfig = {
			model: model,
			// needed for groupBy to be passed through to remote source
			groupField: configProperties.groupField || gridMetaData.defaultGroupBy || "",

			listeners: {
				// Evitamos recargar los datos perdiendo modificaciones
				beforeload: function (store, options) {
					if (store.getModifiedRecords().length > 0) {
						Ext.Msg.alert(
							'Debe cancelar los cambios',
							'Existen registros modificados sin guardar<br/>debe guardar o cancelar los cambios para poder continuar');
						return false;
					}

				},
				load: {
					scope: this,
					fn: function (store, records, successful, eOpts) {
						if (!store.groupField && !store.isGrouped()) {
							this.getView().getFeature(0).disable();
						}
						this.autoSizeColumns();
					}
				}

			},
			pageSize: this.myPageSize,
			remoteSort: true,
			remoteFilter: true,
		};

		this.store = Ext.create("Ext.data.Store", storeConfig);

		if (configProperties.sortField) {
			this.store.setSorters([{
				property: configProperties.sortField,
				direction: configProperties.sortDirection ? configProperties.sortDirection : 'ASC'
			}]);
		} else if (gridMetaData.defaultSort) {
			//Ordenación por defecto
			this.store.setSorters([{
				property: gridMetaData.defaultSort,
				direction: gridMetaData.defaultDirection ? gridMetaData.defaultDirection : 'ASC'
			}]);
		}


		/*******************************************************
		 * Definición general de columnas. Las usadas en todas
		 * las configuraciones
		 ******************************************************/

		var useGroupSummary = false;
		this.formPanelName = "At4FrameworkIntranet." + gridMetaData.formClassName;
		if (configProperties.editMode) {
			this.formPanel = Ext.create(this.formPanelName, this.application, gridMetaData.formItem.form, gridMetaData, {
				id: Ext.id()
			});
		}
		// TODO: Usar el ComponentManager para no tener que crear un form cada vez. Este codigo falla.
		// El form se destruye al cerrar el grid, y da errores al volverlo a abrr
		// if (configProperties.editMode) {
		// 	var formName = "At4FrameworkIntranet." + gridMetaData.formClassName;
		// 	var idForm = gridMetaData.formClassName + "-editForm";
		// 	this.formPanel = Ext.ComponentManager.get(idForm);
		// 	if(!this.formPanel){
		// 		this.formPanel = Ext.create(formName, this.application, gridMetaData.formItem.form, gridMetaData, {
		// 			id: idForm
		// 		});
		// 	}
		// }

		this.configProperties = configProperties;
		this.configureGridMetaData();

		/*
		 * Acceso a la barra de estado. Usamos la barra de estado general de la aplicación
		 */
		this.statusBar = Ext.getCmp('At4Framework-status');

		// Configuración de los filtros
		var gridPlugins = [];

		//Barra de acciones de cabecera
		var menubar = [];

		var filterOutButton = Ext.create("Ext.button.Button", {
			//xtype: 'button',
			id: this.getId() + 'filterOutButton',
			text: this.limpiarFiltrosText,
			tooltip: this.limpiarFiltrosTipText,
			//hidden: true,
			// hideMode: "offsets",
			hideMode: "visibility",
			iconCls: 'icon-filter-out',
			scope: this,
			handler: this.clearFilters
		});

		var hasRightItem = false;

		if (customConfig && customConfig.buttons) {
			for (i = 0; i < customConfig.buttons.length; i++) {
				var customButton = Ext.create("Ext.button.Button", customConfig.buttons[i]);
				menubar.splice(0, 0, customButton);
			}
			hasRightItem = true;
		}

		if (this.gridMetaData.showNewButton) {
			var newButton = Ext.create("Ext.button.Button", {
				text: this.nuevoText,
				tooltip: this.nuevoTipText,
				iconCls: 'icon-plus',
				scope: this,
				handler: this.newRecord
			});
			menubar.splice(0, 0, newButton);
			hasRightItem = true;
		}
		if (hasRightItem) {
			menubar.push("-");
		}
		menubar.push(filterOutButton);
		menubar.push("->");

		// controles de guardar todo y cancelar todo
		if (configProperties.editMode) {
			var separator = {
				xtype: 'tbseparator',
				id: this.getId() + 'buttonsSeparator',
			};
			menubar.push(separator);
			var that = this;
			var editButtonOne = Ext.create("Ext.button.Button", {
				text: this.guardarTodoText,
				iconCls: 'icon-disk-all',
				scope: this,
				id: this.getId() + 'saveallButton',
				handler: this.commitChanges
			});
			menubar.push(editButtonOne);
			var editButtonTwo = Ext.create("Ext.button.Button", {
				text: this.cancelarTodoText,
				iconCls: 'icon-undo',
				id: this.getId() + 'cancelallButton',
				scope: this,
				handler: this.rejectChanges
			});
			menubar.push(editButtonTwo);
		}

		this.displaySummaryItem = Ext.create("Ext.toolbar.TextItem", {
			text: ""
		});

		menubar.push(this.displaySummaryItem);

		if (this.showResetStateButton) {
			menubar.push({
				text: this.olvidarEstadoTexto,
				iconCls: 'glyphicons glyphicons-cloud-minus',
				scope: this,
				handler: function () {
					Ext.Msg.show({
						title: this.borrarEstadoListado,
						message: this.mensajeEstado,
						buttons: Ext.Msg.YESNO,
						icon: Ext.Msg.QUESTION,
						scope: this,
						fn: function (btn) {
							if (btn === 'yes') {
								this.resetStateFn();
							}
						}
					});
				}
			})
		}


		var formats = [{
			text: "excel",
			iconCls: 'icon-export-excel',
			scope: this,
			handler: function () {
				this.exportFile('xls');
			}
		}, {
			text: "csv",
			iconCls: 'icon-export-csv',
			scope: this,
			handler: function () {
				this.exportFile('csv');
			}
		}, {
			text: "pdf",
			iconCls: 'icon-export-pdf',
			scope: this,
			handler: function () {
				this.exportFile('pdf');
			}
		}, {
			text: "docx",
			iconCls: 'icon-export-docx',
			scope: this,
			handler: function () {
				this.exportFile('docx');
			}
		}];

		if (this.gridMetaData.customExportFormats) {
			var len = this.gridMetaData.customExportFormats.length;
			for (var i = 0; i < len; i++) {
				var format = this.gridMetaData.customExportFormats[i];

				formats.push({
					text: format,
					iconCls: 'icon-export-' + format,
					scope: this,
					handler: function () {
						this.exportFile(format);
					}
				});
			}
		}

		if (false && this.gridMetaData.showExportControls) {

			// Añadimos los controles para exportar
			menubar.push('-');

			menubar.push(new Ext.button.Button({
				text: this.exportarText,
				tooltip: this.exportarTipText,
				iconCls: At4util.icons.exportar,
				menu: {
					items: formats
				}
			}));

		}
		// Nuevos botones de exportar
		//TODO: Localear
		if (true || this.showNeuExportButton) {
			var configWindowID = this.getId() + "configWindow";
			this.configWindow = Ext.getCmp(configWindowID);
			if (!this.configWindow) {
				this.gridConfigForm = Ext.create("At4FrameworkIntranet.ExportForm", {
					customExportFormats: this.gridMetaData.customExportFormats,
					customExportColumns: this.columns,
					application: this
				});
				this.configWindow = Ext.create({
					xtype: "at4window",
					width: 850,
					modal: true,
					plain: true,
					title: this.configExportWindowTitle,
					layout: 'fit',
					height: 680,
					id: configWindowID,
					closeAction: "hide",
					items: [this.gridConfigForm]
				});
			}

			var nameWindowID = this.getId() + "nameWindow";
			this.nameWindow = Ext.getCmp(nameWindowID);
			if (!this.nameWindow) {
				this.nameWindow = Ext.create({
					xtype: "at4appConfigSavePrompt"
				});
			}
			var subMenuConfigure = {
				text: "Configurar",
				iconCls: At4util.icons.configure,
				menu: {
					items: [{
						text: this.configMenuGuardarHeaderLabel,
						scope: this,
						iconCls: At4util.icons.save,
						handler: function () {
							var me = this;
							this.nameWindow.show(this);
						}
					}, {
						text: this.configMenuAplicarHeaderLabel,
						scope: this,
						iconCls: At4util.icons.apply,
						handler: function () {
							Ext.create("At4FrameworkIntranet.ExportWindow", {
								name: this.stateId,
								onLoad: function (state) {
									var provider = Ext.state.Manager.getProvider();
									Ext.ux.state.HttpProvider.superclass.set.call(provider, this.stateId, state);
									this.application.reloadListGrid(this);
									return true;
								}.bind(this)
							}).show();
						},
					}, {
						text: this.configMenuReiniciarHeaderLabel,
						scope: this,
						iconCls: At4util.icons.restart,
						handler: function () {
							this.reconfigure(null, this.gridMetaData.columns);
						}
					}]
				}
			};
			formats.push({
				text: this.configMenuAvanzadoHeaderLabel,
				scope: this,
				iconCls: At4util.icons.avanzado,
				handler: function () {
					this.configWindow.show(this);
				}
			})
			var subMenuExport = {
				text: this.exportarText,
				iconCls: At4util.icons.exportar,
				menu: {
					items: formats,
				}
			};
			var extraSubMenuHerramientas = this.extraSubMenuHerramientas ? this.extraSubMenuHerramientas : null;
			var exportMenu = Ext.create("Ext.button.Button", {
				text: this.herramientasText,
				tooltip: this.exportarTipText,
				iconCls: At4util.icons.herramientas,
				menu: {
					items: [
						subMenuConfigure,
						subMenuExport,
						extraSubMenuHerramientas
					]
				}
			});
			menubar.push('-');
			menubar.push(exportMenu);
		}


		//var menuToolbar = new Ext.Toolbar(menubar);
		var menuToolbar = Ext.create("Ext.toolbar.Toolbar", {
			items: menubar
		})

		if (customConfig && customConfig.selectionModel) {
			selectionModel = customConfig.selectionModel;
		}

		/*******************************************************
		 * Configuración de la vista del grid
		 ******************************************************/

		var view = null;
		var viewConfig = {
			forceFit: false,
			enableRowBody: false
		}
		viewConfig.groupTextTpl = '{text}';
		if (customConfig && customConfig.viewConfig) {
			Ext.apply(viewConfig, customConfig.viewConfig);
		}

		var parentFeatures = [];


		this.filtersActivos = [];

		if (configProperties.useFilters) {
			gridPlugins.push({
				ptype: 'gridfilters',
				stateId: this.getStateId() + "-pFilters",
			});
		}

		if (this.gridMetaData.useGroupSummary) {
			parentFeatures.push({
				ftype: 'groupingsummary',
				groupByText: this.groupByTextLabel,
				showGroupsText: this.showGroupsTextLabel,
			});
		} else {
			parentFeatures.push({
				ftype: 'grouping',
				groupByText: this.groupByTextLabel,
				showGroupsText: this.showGroupsTextLabel,
			});

		}


		/* Especializamos la configuración según el tipo de grid */
		var specialConfig = {};
		switch (this.tipo) {
		case 'normal':
			specialConfig = {
				editMode: false
			};
			break;
		case 'editable':
			specialConfig = {
				editMode: true
			};
			gridPlugins.push({
				ptype: 'cellediting',
				clicksToEdit: 2
			});
			break;
		}

		/*******************************************************
		 * Llamamos al constructor
		 ******************************************************/
		this.callParent([{
			region: 'center',

			viewConfig: {
				enableTextSelection: true,
			},

			features: parentFeatures,

			stripeRows: true,

			dockedItems: [menuToolbar, {
				xtype: 'pagingtoolbar',
				pageSize: this.myPageSize,
				store: this.store,
				dock: 'bottom',
				displayInfo: true,
				plugins: [new Ext.ux.grid.PageSize()]
			}],

			loadMask: {
				msg: this.cargandoText
			},
			plugins: gridPlugins,

			listeners: {
				// evita que se editen filas que total no se pueden grabar
				beforeedit: function (nose, row, eopts) {
					if (row.record.get('cannotUpdate')) {
						return false;
					}
				},
				afterrender: function (component, eOpts) {
					this.setOutButtons();
					this.batchButtons();
				},
				destroy: function (panel, eOpts) {
					this.application.unRegisterTabId(panel);
					this.autoSized = false;
				},
				edit: function (plugin, ctxt, eOpts) {
					var fieldEditor = ctxt.grid.formPanel.getFieldEditor(ctxt.field, true);
					if (fieldEditor.xtype == "At4Framework-combobox") {
						var record = fieldEditor.getStore().findRecord("ID", ctxt.value);
						var newVal = record.data["DISPLAY"];
						ctxt.record.set(ctxt.field, newVal);
						ctxt.record.set(ctxt.field + "Id", ctxt.value);
						ctxt.record.set(ctxt.field + "Label", newVal);
					}
					this.batchButtons();
				},
				validateedit: function (plugin, ctxt, eOpts) {
					var fieldEditor = ctxt.grid.formPanel.getFieldEditor(ctxt.field, true);
					if (fieldEditor.xtype == "At4Framework-combobox") {
						var record = fieldEditor.getStore().findRecord("ID", ctxt.value);
						if (!(ctxt.value != ctxt.originalValue && record)) {
							return false;
						}
					}
					return true;
				},

				filterchange: function (store, filters, eOpts) {
					this.activeFilterCount = filters.length;
					this.setOutButtons();
				},

				columnmove: function (container, column, inicio, destino, eOpts) {
					if (container.getVisibleGridColumns().length <= destino) {
						// Si la que se ha movido se mueve a la ultima posicion, esta se devuelve a la penultima
						// porque la ultima debe ser siempre el rowactions
						var headerCt = this.headerCt;
						var length = headerCt.getGridColumns().length - 1;
						headerCt.move(length, length - 1);
						this.getView().refresh();
					}
				},
				columnschanged: function (container, options) {
					this.autoSizeColumns();
				},
				show: {
					scope: this,
					fn: this.autoSizeColumns
				},
				add: {
					scope: this,
					fn: this.autoSizeColumns
				}


				//TODO: Test de states:
				/*
				                staterestore: function(form, state, eOpts) {
				                    //console.debug("ListadoGrid stateRestore\n", state);
				                },
				                statesave: function(form, state, eOpts) {
				                    // console.debug("ListadoGrid statesave\n", state);
				                },
				                beforestaterestore: function(form, state, eOpts) {
				                    //state = Ext.clone(state);
				                    //console.debug("ListadoGrid beforestateRestore\n", state);
				                },*/
				/*
				beforestatesave: function(form, state, eOpts) {
				    //Todo: En teoria, al haber quitado el autosize personalizado, esto no deberia hacer falta
				    if (state.columns) {
				        for (i in state.columns) {
				            var w = state.columns[i].width;
				            if (!isNaN(w) && w > 15) {
				                state.columns[i].width = w - 15;
				            }
				        }
				    }
				    //console.debug("ListadoGrid beforestatesave\n", state);
				}*/
			}
		}]);

		if(At4Framework_modoDesarrollo){
			console.debug("Tiempo de carga de ListadoGrid: " + (new Date() - this.debugConstructorCallTime) + "ms");
		}
	},

	/***********************************************************
	 * Métodos de acciones sobre el grid
	 **********************************************************/

	/**
	 * Abre el formulario del registro
	 *
	 * @param {Ext.data.Record}
	 *            record
	 */
	openRecord: function (record) {
		this.application.openRecordForm(
			this.gridMetaData.formItem, record.data);
	},

	/**
	 * Abre el formulario en blanco
	 */
	newRecord: function () {
		this.application.openNewRecordForm(this.gridMetaData.formItem);
	},
	/*
	    onActivateFilter: function(id) {
	        if (id && !this.activeFilterCount[id]) {
	            this.activeFilterCount[id] = true;
	        }
	        //this.activeFilterCount++;
	        this.setOutButtons();
	    },

	    onDeactivateFilter: function(id) {
	        //this.activeFilterCount--;
	        if (id && this.activeFilterCount[id]) {
	            delete this.activeFilterCount[id];
	        }
	        if (this.rendered) {
	            this.setOutButtons();
	        }

	    },*/

	clearFilters: function () {
		this.filters.clearFilters();
		this.activeFilterCount = 0;
		if (this.rendered) {
			this.setOutButtons();
		}
	},

	/**
	 * Fija el estado de los botones de cancelar búsqueda y
	 * limpiar filtro
	 *
	 * @private
	 */
	setOutButtons: function () {
		var button = Ext.get(this.getId() + 'filterOutButton');
		if (this.activeFilterCount > 0) {
			//if (Object.keys(this.activeFilterCount).length > 0) {
			if (button) {
				//button.setVisible(true);
				button.show()
			}
		} else {
			//button = Ext.get(this.getId() + 'filterOutButton');
			if (button) {
				//button.setVisible(false);
				button.hide()
			}
		}
	},
	batchButtons: function () {
		if (this.editMode) {
			var btSave = Ext.get(this.getId() + 'saveallButton');
			var btDelete = Ext.get(this.getId() + 'cancelallButton');
			var separator = Ext.get(this.getId() + 'buttonsSeparator');
			var modRecords = this.store.getModifiedRecords();
			if (modRecords.length > 0) {
				btSave.show();
				btDelete.show();
				separator.show();
			} else {
				btSave.hide();
				btDelete.hide();
				separator.hide();
			}
			this.doLayout();
		}
	},

	/**
	 * Guarda los cambios en 1 registro
	 *
	 * @private
	 * @param {Ext.data.Record}
	 *            record
	 */
	updateRecord: function (record) {
		//TODO: garrom: En teoria cuando llega aqui ya se ha terminado de editar
		//this.stopEditing();
		//this.stopEditing();
		var codiLinea = record.get('oid');
		/*
		 * if (!this.compruebaIntegridadLinea(record)) { return
		 * false; }
		 */
		// actualizamos la línea
		if (record.dirty) {
			serverDatabaseActions.updateGrid(this.gridMetaData.formItem.form, [codiLinea], [record], this.updateRecordCallback, this);
		} else {
			Ext.Msg.alert(this.nadaHacerText, this.noRegistroModificadoText);
		}
	},

	/**
	 * Cancela los cambios en 1 registro
	 *
	 * @private
	 * @param {Ext.data.Record}
	 *            record
	 */
	rejectRecord: function (record) {
		record.reject()
		this.batchButtons();
		this.setOutButtons();
	},

	/**
	 * Guarda todos los cambios
	 */
	commitChanges: function () {
		// TODO: En teoria cuando se llega aqui ya ha finalizado la edicion
		//this.stopEditing(); // Detiene la edición

		var records = this.store.getModifiedRecords();
		if (!records.length) {
			Ext.Msg.alert(this.nadaHacerText,
				this.noRegistroModificadoText);
			return;
		}

		var idsRecord = [];
		var recordsToUpdate = [];
		var codiLinea;

		Ext.each(records, function (r, i) {
			codiLinea = r.get('oid');

			/*
			 * if (!this.compruebaIntegridadLinea(r)) { return
			 * false; }
			 */

			idsRecord.push(codiLinea);
			recordsToUpdate.push(r);
		}, this);

		serverDatabaseActions.updateGrid(this.gridMetaData.formItem.form, idsRecord, recordsToUpdate, this.updateRecordCallback, this);

	},

	/**
	 * Descarta todos los cambios
	 *
	 * @private
	 */
	rejectChanges: function () {

		var records = this.store.getModifiedRecords();
		if (!records.length) {
			Ext.Msg.alert(this.nadaHacerText,
				this.noRegistroModificadoText);
			return;
		}

		var store = this.store;

		Ext.Msg.show({
			title: this.pregCancelarTodoText,
			msg: this.cancelarTodoMsgText,
			icon: Ext.Msg.QUESTION,
			buttons: Ext.Msg.YESNO,
			scope: this,
			fn: function (response) {
				if ('yes' !== response) {
					return;
				}
				store.rejectChanges();
				this.batchButtons();

			}
		});
	},

	/**
	 * Elimina un registro. Si es nuevo lo elimina del grid, si
	 * estaba en base de datos, además efectúa la llamada ajax
	 * para borrarlo
	 *
	 * @param {Object} record
	 * @private
	 */
	deleteRecord: function (record) {
		Ext.Msg.show({
			title: this.borrarRegistroTxt,
			msg: Ext.String.format(this.borrarSeguroTxt, '<b>' + record.data.oid + '</b>'),
			icon: Ext.Msg.QUESTION,
			buttons: Ext.Msg.YESNO,
			scope: this,
			fn: function (response) {
				if ('yes' !== response) {
					return;
				}
				var clave = record.data.oid;
				if (clave == 0) {
					// La linea no se había añadido
					record.commit();
					this.store.remove(record);
				} else {
					// Obtiene el menú
					serverDatabaseActions.deleteForm(
						this.gridMetaData.formItem.form,
						clave, this.deleteRecordCallback,
						this);

				}
			}
		});
	}, // eo function deleteRecord

	updateRecordCallback: function (records, resultadoActualizacion) {

		if (resultadoActualizacion.correcto) {

			var statusText = '';

			var len = records.length;
			for (var i = 0; i < len; i++) {
				records[i].commit();
			}
			if (len > 0) {
				if (len > 1) {
					statusText += Ext.String.format(this.modificadosElementosText, len);
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
		this.batchButtons();
	},

	/**
	 * Método al que se vuelve después de la llamada Ajax a
	 * borrar registro
	 *
	 * @private
	 */
	deleteRecordCallback: function (id, resultadoActualizacion) {
		if (resultadoActualizacion.correcto) {
			var key = this.store.find('oid', id);
			if (key != -1) {
				var record = this.store.getAt(key);
				record.commit();
				this.store.remove(record);
				// Notificamos a la aplicación de la eliminación
				// del registro
				this.application.onDeleteRecordDone(this, {
					rowid: id,
					formName: this.gridMetaData.formItem.form
				});
				this.statusBar.setStatus({
					text: 'Borrado 1 elemento',
					clear: true
						// auto-clear after a set interval
				});

			}
		} else {
			var message = resultadoActualizacion.message;
			Ext.Msg.alert('Error:', message);
		}

	},

	/**
	 * Muestra un popup con googleMaps
	 *
	 * @param {record}
	 */
	mostrarMapa: function (record) {
		mapwin = new Ext.Window({
			layout: 'fit',
			title: 'GMap Window',
			closeAction: 'hide',
			width: 400,
			height: 400,
			x: 40,
			y: 60,
			items: {
				xtype: 'gmappanel',
				zoomLevel: 4,
				gmapType: 'map',
				mapConfOpts: [
					'enableScrollWheelZoom',
					'enableDoubleClickZoom',
					'enableDragging'
				],
				mapControls: ['GSmallMapControl',
					'GMapTypeControl',
					'NonExistantControl'
				],
				setCenter: {
					geoCodeAddr: record.data.codiPais,
					marker: {
						title: 'Pais'
					}
				}
			}
		});

		mapwin.show();
	},

	/**
	 * cambia la posicion del item
	 *
	 * @param {String}
	 *            type up|down
	 */
	actualizarPosicion: function (record, action) {
		var clave = record.get('oid');
		serverDatabaseActions.actualizarPosicion(this.gridMetaData.formItem.form, clave, action, this.actualizarPosicionCallback, this);
	},

	actualizarPosicionCallback: function (resultadoActualizacion) {
		if (resultadoActualizacion.correcto) {

			/* Recargamos el list */
			var listTabId = this.gridMetaData.formItem.form + '-list';
			var listTab = this.application.getTab(listTabId);
			if (listTab) {
				listTab.store.reload();
				listTab.show();
			}

		} else {
			var message = resultadoActualizacion.message;
			Ext.Msg.alert('Error:', message);
		}
	},
	getListeners: function (extraFilters) {
		return {
			beforeload: function (dataProxy, params, dwrParams) {
				var sorter = "";
				var dirs = "";
				var filtrosRaw = params.filters || [];
				var filtros = [];
				var sorters = params.sorters || null;
				for (i in sorters) {
					if (sorters.hasOwnProperty(i)) {
						if (i > 0) {
							sorter += ",";
							dirs += ",";
						}
						if (i >= 0) {
							sorter += sorters[i]._property;
							dirs += sorters[i]._direction;
						}
					}
				}
				for (i in extraFilters) {
					if (extraFilters.hasOwnProperty(i)) {
						filtros.push(extraFilters[i]);
					}
				}
				for (i in filtrosRaw) {
					if (filtrosRaw.hasOwnProperty(i)) {
						var serialized = filtrosRaw[i].serialize();
						var valueString = "";
						if (typeof serialized.value == "object") {
							for (x in serialized.value) {
								if (typeof serialized.value[x] == "string") {
									if (x == 0) {
										valueString = serialized.value[x];
									} else {
										valueString += "," + serialized.value[x];
									}
								}
							}
						} else {
							valueString = serialized.value;
						}

						var type = (serialized.type == "multiList") ? "list" : serialized.type;

						var data = {
							type: type,
							value: valueString,
							//comparison: serialized.operator
						};
						if (serialized.type == "number" || serialized.type == "numeric" || serialized.type == "date") {
							data.comparison = serialized.operator;
						};
						if (typeof data.value !== "undefined") {
							filtros.push({
								field: serialized.property,
								data: data
							});
						}
					}
				}
				params.currentPage = params.page ? params.page : 1;
				params.pageSize = params.limit ? params.limit : 30;
				if (params && params.grouper) {
					params.groupBy = params.grouper._property;
				}

				params[dataProxy.loadArgsKey] = [dwrParams[0], filtros, {
					//start: (params.currentPage - 1) * params.pageSize,
					start: params.start,
					limit: params.pageSize,
					sort: sorter,
					direction: dirs,
					groupBy: params.groupBy
				}];

			},

			exception: function (dataProxy, response, operation) {
				Ext.Msg.alert('Error:', response.message ? response.message : response);
			},
			endprocessresponse: function (dataProxy, response, operation) {
				if (response.aggregates) {
					var dataIndex, msg = "";
					var found = false;
					for (var i = 0; i < this.gridMetaData.columns.length; i++) {
						dataIndex = this.gridMetaData.columns[i].dataIndex;
						if (response.aggregates[dataIndex]) {
							found = true;
							msg += " " + this.gridMetaData.columns[i].header + ": " + this.gridMetaData.columns[i].renderer(response.aggregates[dataIndex]);
						}
					}
					if (found) {
						Ext.fly(this.displaySummaryItem.getEl()).update(msg);
						this.doLayout();
					}
				}
			}.bind(this)
		};
	},

	resetStateFn: function () {
		console.log("Reseteando estado de: " + this.stateId);
		var provider = Ext.state.Manager.getProvider()
		if (provider) {
			provider.clear(this.stateId);
		}
		this.statusBar.setStatus({
			text: this.resetListadoTexto + this.title,
			clear: true
				// auto-clear after a set interval
		});
	},

	/*
	var stateProvider = Ext.state.Manager.getProvider();
	//undefined
	stateProvider.get("animal-list");
	//datos sobre animal list
	stateProvider.clear("animal-list");
	//undefined //Nota: Se reenvia el estado
	stateProvider.get("animal-list");
	//YA NO HAY datos sobre animal list



	//Here it comes. This is how to clear all states
	for (var item in stateProvider.state) {
	    Ext.state.Manager.clear(item);
	}*/

	//Defaults start

	//Número por defecto de registros por página
	myPageSize: 30,
	stateful: true,
	showResetStateButton: false,

	rowActionsDefaults: {
		draggable: false,
		groupable: false,
		resizable: false,
		sortable: false,
		hideable: false,
	},

	//Defaults end

});
/**
 * @class At4FrameworkIntranet.ListadoGridConfig Contiene la configuración del
 *        grid de formulario At4FrameworkIntranet según el tipo de vista que se
 *        desee mostrar
 * @author agarcia
 * @constructor
 * 
 * @param {At4FrameworkIntranet.ListadoGrid}
 *            grid
 * @param {Object}
 *            config
 */
At4FrameworkIntranet.ListadoGridConfig = function(grid, config) {

	/**
	 * Permitir editar, guardar, etc. Se desactiva para los listados<br/> TODO:
	 * no se usa, el listado no es editable (desactivar?)
	 * 
	 * @type {boolean}
	 */
	this.editMode = true;

	/**
	 * Activar filtros de columna
	 * 
	 * @type {boolean}
	 */
	this.useFilters = true;

	/**
	 * Columna de ordenación por defecto
	 * 
	 * @type {String}
	 */
	this.sortField = '';

	/**
	 * Direccion de la ordenación por defecto
	 * 
	 * @type {String}
	 */
	this.sortDirection = '';

	/**
	 * Activar la agrupacion por columna
	 * 
	 * @type {boolean}
	 */
	this.useGrouping = true;

	/**
	 * Columna de agrupación por defecto
	 * 
	 * @type {String}
	 */
	this.groupField = null;

	/**
	 * Incluir acciones en los grupos
	 * 
	 * @type {boolean}
	 */
	this.groupActions = false;

	Ext.apply(this, config);

	/**
	 * Referencia al grid que usa esta configuración
	 * 
	 * @type {At4FrameworkIntranet.ListadoGrid}
	 */
	this.grid = grid;

}
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
﻿ // Namespace de At4FrameworkIntranet
Ext.namespace('At4FrameworkIntranet');

Ext.define("At4FrameworkIntranet.FilePanel", {
	extend: "Ext.form.FieldSet",
	width: 320,
	xtype: "at4-filepanel",
	style: 'margin-top: 20px',
	collapsible: false,
	disableUpload: false,
	disableDownlowd: false,
	disableDelete: false,

	mostrarDescargar: function(mostrar){
		if(mostrar && !this.disableDownlowd){
			this.descarregarArxiu.setVisible(true);
		}else{
			this.descarregarArxiu.setVisible(false);
		}
	},

	mostrarEliminar: function(mostrar){
		if(mostrar && !this.disableDelete){
				this.eliminarArxiu.setVisible(true);
		}else{
			this.eliminarArxiu.setVisible(false);
		}
	},
	mostrarEnviar: function(mostrar){
		if(mostrar && !this.disableUpload){
			this.afegirArxiuBoto.uploadButton.setVisible(true);
		}else{
			this.afegirArxiuBoto.uploadButton.setVisible(false);
		}
	},




	/**
	 * @class At4FrameworkIntranet.FilePanel
	 * Clase de panel de archivo descargable
	 * @extends-ext Ext.Panel
	 * @author agarcia
	 * @constructor
	 *
	 * @param {At4FrameworkIntranet.BasicForm} parentFormPanel Formulario contenedor
	 * @param {Object} config
	 */
	constructor: function (parentFormPanel, config) {
		//console.log("Se esta creando un FilePanel");
		Ext.apply(this, config);
		this.parentFormPanel = parentFormPanel;
		//Necesitamos saber si se trata de un subform
		/*
		if (parentFormPanel.subFormName) {
			this.inSubForm = true;
		} else {
			this.inSubForm = false;
		}*/
		//TOOD: garrom: Asi mejor?
		this.inSubForm = (!!parentFormPanel.subFormName);
		//Botón para descargar archivo
		this.descarregarArxiu = new Ext.Button({
			style: 'margin: 0 5px 0 5px',
			text: this.descargarArchivoTxt,
			hidden: true,
			disabled: this.disableDownlowd,
			//cls: "at4-download",
			tabIndex: this.tabIndex + 20,
			handler: function () {

				//Construcción del formulario para descargar el pdf
				var form = Ext.DomHelper.append(document.body, {
					tag: 'form',
					method: 'post',
					action: this.urlDescarga,
					target: this.id
				});

				var claveObjecte = document.createElement('input');
				claveObjecte.type = 'hidden';
				claveObjecte.name = 'objectId';
				claveObjecte.value = this.parentFormPanel.dataId;
				form.appendChild(claveObjecte);

				// añadimos el nombre con el que se descargarán los ficheros
				var docname = document.createElement('input');
				docname.type = 'hidden';
				docname.name = 'docname';
				docname.value = this.docname;
				form.appendChild(docname);

				// Si es una imagen, añadimos el modo inline
				if (this.isImage) {
					var modeinline = document.createElement('input');
					modeinline.type = 'hidden';
					modeinline.name = 'mode';
					modeinline.value = 'inline';
					form.appendChild(modeinline);
				}

				form.submit();

			},
			scope: this
		});

		//Botón para eliminar archivo
		this.eliminarArxiu = new Ext.Button({
			style: 'margin: 0 5px 0 5px',
			text: this.eliminarArchivoTxt,
			hidden: true,
			disabled: this.disableDelete,
			tabIndex: this.tabIndex + 30,
			handler: function () {

				Ext.Msg.show({
					title: this.eliminarArchivoInformacionTxt,
					msg: this.eliminarArchivoConfirmacionTxt,
					icon: Ext.Msg.QUESTION,
					buttons: Ext.Msg.YESNO,
					scope: this,
					fn: function (response) {
						if ('yes' !== response) {
							return;
						}

						serverDatabaseActions.runAction(
							FormDataService.eliminarDocumento, [this.docname, this.parentFormPanel.dataId],
							function (data) {
								if (data.correcto) {
									if (this.isImage) {
										this.imagePreview.setVisible(false);
									} else {
										Ext.MessageBox.alert(this.eliminarArchivoInformacionTxt,
											this.eliminarArchivoCorrectoTxt);
									}
									this.mostrarDescargar(false);
									this.mostrarEliminar(false);
									if (this.inSubForm) {
										this.parentFormPanel.parentPanel.onUpdateRecordDone(this.parentFormPanel, data.updatedElement, this.parentFormPanel.currentRecord);
									}

								} else {
									Ext.Msg.show({
										title: this.eliminarArchivoErrorTxt,
										msg: data.message,
										buttons: Ext.Msg.OK,
										icon: Ext.MessageBox.ERROR
									});
								}
							},
							serverDatabaseActions.exceptionHandler,
							this
						)
					}
				});
			},
			scope: this
		});

		//Botón para subir archivo
		this.afegirArxiuBoto = new Ext.enableDWRUploadFile({
			style: 'padding: 0px 0px 7px 0px; margin: 0 5px 0 5px',
			name: 'arxiu',
			buttonText: this.subirArchivoTxt,
			buttonIcon: '',
			tabIndex: this.tabIndex + 10,
			check: function () {
				return true;
			},
			submit: function () {

				//obtenemos el objeto que contiene el file, y después obtenemos el valor del file usando el id generado para el objeto contenedor
				//var fileAux = this.afegirArxiuBoto.getFileInput();
				//var file = dwr.util.getValue(fileAux.id);
				var file = this.afegirArxiuBoto.getFileInput();

				console.log(file.value);
				serverDatabaseActions.runAction(
					FormDataService.guardarDocumento, [this.docname, file, this.parentFormPanel.dataId],
					function (data) {
						if (data.correcto) {
							this.mostrarDescargar(true);
							if (this.isImage) {
								this.imagePreview.doPreview();
							} else {
								Ext.MessageBox.alert(this.subirArchivoInformacionTxt, this.subirArchivoCorrectoTxt);
							}
							this.mostrarEliminar(true);
							if (this.inSubForm) {
								this.parentFormPanel.parentPanel.onUpdateRecordDone(this.parentFormPanel, data.updatedElement, this.parentFormPanel.currentRecord);
							}
							if (data.warnings.length > 0) {
								for (i in data.warnings) {
									if (data.warnings.hasOwnProperty(i)) {
										Ext.toast({
											html: data.warnings[i],
											header: false,
											autoCloseDelay: 5000,
											align: "bl"
										});
									}

								}
							}

						} else {
							Ext.Msg.show({
								title: this.subirArchivoErrorTxt,
								msg: data.message,
								buttons: Ext.Msg.OK,
								icon: Ext.MessageBox.ERROR
							});
						}
					},
					serverDatabaseActions.exceptionHandler,
					this
				)

				//}.createDelegate(this)
			}.bind(this)
		});

		var parentItems = [];

		/*this.dataConstrains = new Ext.form.field.Display({
			value: "",
			border: 0,
			minHeight: 0,
			editable: false,
		});
		this.dataConstrains = new Ext.container.Container({
			value: "",
			border: 0,
			minHeight: 0,
			editable: false,
		});*/
		this.dataConstrains = new Ext.Component({
			value: "",
			border: 0,
			minHeight: 0,
			editable: false,
		});

		if (this.isImage) {
			this.imagePreview = new Ext.Img({
				style: 'max-height: 99%; max-width:99%; border:1px solid black; margin-bottom: 5px',
				doPreview: function () {

					//Construcción del formulario para descargar el pdf
					var url = this.urlDescarga;
					url += '?objectId=' + this.parentFormPanel.dataId;
					url += '&docname=' + this.docname;
					url += '&mode=inline';
					url += '&random=' + Math.random();
					this.imagePreview.setSrc(url);
					this.imagePreview.setVisible(true);
				}.bind(this),
				//Este listener lo que hace es forzar la recalculacion de tamaños al padre, sin esto, hara overflow al cargar la imagen
				listeners: {
					load: {
						element: 'el', //the rendered img element
						scope: this,
						fn: function () {
							if (this.imagePreview.src) {
								//console.log("img loaded");
								//console.log("Tiempo de carga = " + (new Date() - startingLoad));
								this.parentFormPanel.doLayout();
							}
						}
					}
				}
			});
			parentItems.push({
				xtype: "container",
				style: "text-align: center",
				items: [this.imagePreview]
			});
		}

		this.infoConstrains = new Ext.Button({
			name: this.fieldName,
			text: this.comprobarConstrainsTxt,
			buttonIcon: '',
			parentFormPanel: parentFormPanel,
			constrainsModel: this.constrainsModel,
			tabIndex: this.tabIndex + 40,
			disabled: false,
			hidden: !!this.disableConstrains,
			scope: this,
			handler: this.onInfoConstrainsClick,
		});

		parentItems = parentItems.concat([{
			xtype: "container",
			layout: "hbox",
			margin: "5px 0 5px 0",
			width: "100%",
			defaults: {
				width: "33%"
			},
			items: [this.afegirArxiuBoto.uploadButton, this.descarregarArxiu, this.eliminarArxiu]
		}, {
			xtype: "container",
			margin: "10px 0 10px 0",
			items: [this.infoConstrains]
		}, {
			xtype: "container",
			minHeight: 0,
			height: "auto",
			items: [this.dataConstrains]
		}])

		this.callParent([{
			xtype: 'fieldset',
			style: "margin-top: 0 ;",
			padding: 15,
			title: this.titleTxt,
			border: true,
			labelAlign: "top",
			autoHeight: true,
			hidden: true,
			items: parentItems
		}]);

		config.listeners = {
			//'afterload'	:this.afterLoadRecord.createDelegate(this)
			//,'afteremptyform' : this.afterEmptyForm.createDelegate(this)
			afterload: Ext.bind(this.afterLoadRecord, this),
			afteremptyform: Ext.bind(this.afteremptyform, this)
		}
		this.mostrarDescargar(true);
		this.mostrarEliminar(true);
		this.mostrarEnviar(true);

	},
	/** Nombre del formulario que trata la subida y descarga
	 * @type {String}
	 */
	docname: null

	/** Título del panel
	 * @type {String}
	 */
	,
	titleTxt: 'Archivo'

	/** Etiqueta de texto
	 * @type {String}
	 */
	,
	descargarArchivoTxt: 'Descargar'

	/** Etiqueta de texto
	 * @type {String}
	 */
	,
	eliminarArchivoTxt: 'Eliminar'

	/** Etiqueta de texto
	 * @type {String}
	 */
	,
	eliminarArchivoInformacionTxt: 'Información'

	/** Etiqueta de texto
	 * @type {String}
	 */
	,
	eliminarArchivoConfirmacionTxt: '¿Eliminar archivo?<br\/>Esta acción no se puede deshacer.'

	/** Etiqueta de texto
	 * @type {String}
	 */
	,
	eliminarArchivoCorrectoTxt: 'Archivo eliminado correctamente.'

	/** Etiqueta de texto
	 * @type {String}
	 */
	,
	eliminarArchivoErrorTxt: 'Error eliminando archivo.'

	/** Etiqueta de texto
	 * @type {String}
	 */
	,
	subirArchivoTxt: 'Añadir'

	/** Etiqueta de texto
	 * @type {String}
	 */
	,
	subirArchivoInformacionTxt: 'Información'

	/** Etiqueta de texto
	 * @type {String}
	 */
	,
	subirArchivoCorrectoTxt: 'Archivo añadido correctamente'

	/** Etiqueta de texto
	 * @type {String}
	 */
	,
	subirArchivoErrorTxt: 'Error añadiendo archivo'


	/** url de descarga de archivos
	 * @type {String}
	 */
	,
	urlDescarga: './export/descarregar'

	/** Nombre del campo donde está el archivo
	 * @type {String}
	 */
	,
	fieldName: null

	/**
	 * Indica que se trate el archivo como una imagen
	 */
	,
	isImage: false

	,
	afterEmptyForm: function (record) {

		this.setVisible(false);
		this.mostrarDescargar(false);
		this.mostrarEliminar(false);
	}

	,
	afterLoadRecord: function (dataId, record) {

		var canDelete = false;
		var canUpdate = false;
		//console.log(this,this.inSubForm);
		if (this.inSubForm) {
			//record = dataId;
			dataId = record.data.oid;
			canDelete = this.parentFormPanel.editable;
			canUpdate = this.parentFormPanel.editable;
		} else {
			canDelete = record.canUpdate; //Si se puede actualizar el formulario, entonces se puede eliminar el archivo
			canUpdate = record.canUpdate;
		}

		var algoVisible = false;
		if (record.data[this.fieldName] != null &&
			record.data[this.fieldName] != "") {
			if (canDelete) {
				this.mostrarEliminar(true);
			} else {
				this.mostrarEliminar(false);
			}
			if (canUpdate) {
				this.mostrarEnviar(true)
			} else {
				this.mostrarEnviar(false)
			}
			this.descarregarArxiu.setVisible(true);
			if (this.canDownload) {
				this.descarregarArxiu.enable();
			}
			if (this.isImage) {
				this.imagePreview.doPreview();
			}
			algoVisible = true;
		} else {
			this.descarregarArxiu.setVisible(false);
			this.mostrarEliminar(false);
			if (this.isImage) {
				this.imagePreview.setVisible(false);
			}
			if (canUpdate) {
				this.mostrarEnviar(true)
				algoVisible = true;
			} else {
				this.mostrarEnviar(false)
			}
		}

		if (dataId && algoVisible) {
			this.setVisible(true);
		}


	},
	/**
	 *
	 * Override para hacer compatible esto con QTIP
	 */
	createTitleCmp: function () {
		var me = this,
			cfg = {
				xtype: 'component',
				html: me.title,
				ui: me.ui,
				cls: me.baseCls + '-header-text',
				id: me.id + '-legendTitle'
			};

		if (me.collapsible && me.toggleOnTitleClick) {
			cfg.listeners = {
				click: {
					element: 'el',
					scope: me,
					fn: me.toggle
				}
			};
			cfg.cls += ' ' + me.baseCls + '-header-text-collapsible';
		}
		///garrom: Añade el qtip en el header
		if (!cfg.listeners) {
			cfg.listeners = {};
		}
		if (me.qtip) {
			cfg.listeners["afterrender"] = {
				//element: 'el',
				scope: me,
				fn: function (el, opts) {
					el.getEl().set({
						"data-qtip": this.qtip
					})
				}
			}
		}
		//garrom: fin
		return (me.titleCmp = Ext.widget(cfg));
	},

	initEvents: function () {
		At4FrameworkIntranet.FilePanel.superclass.initEvents.call(this);
		//this.parentFormPanel.addListener('afterload', this.afterLoadRecord.createDelegate(this));
		this.parentFormPanel.addListener('afterload', this.afterLoadRecord.bind(this));
		//		this.parentFormPanel.addListener('afteremptyform', this.afterEmptyForm.createDelegate(this));
		this.parentFormPanel.addListener('afteremptyform', this.afterEmptyForm.bind(this));
	},
	showConstrainMessage: function (data, isRaw) {
		var html = "";
		if (isRaw) {
			//this.dataConstrains.update(data);
			html = data;
		} else {
			if (this.isImage) {
				html = At4util.formatConstrains(data);
			} else {
				html = At4util.formatFileConstrains(data);
			}
		}
		//this.getSizeModel().height.shrinkWrap = false;
		this.dataConstrains.update(html);

	},

	onInfoConstrainsClick: function (btn, eopts) {
		var partFormName = btn.parentFormPanel.formName ? btn.parentFormPanel.formName : btn.parentFormPanel.subFormName;
		// var formItem = partFormName + "-" + btn.name;
		var formItem;

		if (this.formItem) {
			formItem = this.formItem;
		} else {
			Ext.log.warn("No formItem set, using docname.")
			formItem = this.docname;
		}
		var cached = At4FrameworkIntranet.app.cache.constrains[formItem];
		if (cached && (new Date() - cached.date < 7200000)) {
			this.showConstrainMessage(cached.data);
		} else {
			this.showConstrainMessage(this.cargandoConstrainsTxt, true);
			var fn = this.isImage ? "obtenerConstraints" : "obtenerFileConstraints";
			serverDatabaseActions.runSilentAction(FormDataService[fn], [formItem], function (response) {
				var obj = {
					data: response,
					date: new Date()
				}
				At4FrameworkIntranet.app.cache.constrains[this.formItem] = obj;
				this.scope.showConstrainMessage(obj.data);
			}.bind({
				formItem: formItem,
				scope: this
			}), function () {
				this.scope.showConstrainMessage(this.scope.errorConstrainsTxt, true);
			}.bind({
				formItem: formItem,
				scope: this
			}));
		}

	}

});
//Filename: ImagePreviewPanel
Ext.namespace('At4FrameworkIntranet');

Ext.define("At4FrameworkIntranet.ImagePreviewPanel", {
	extend: "At4FrameworkIntranet.BasicPanel",
	cls: "at4imagePanel",
	itemSelector: "div.thumb-wrap",

	constructor: function (parentFormPanel, config) {
		//TODO: Localear
		this.isFotoGrande = true;
		this.aumentaTamano = {
			xtype: "button",
			text: "Cambiar tamaño",
			handler: this.toggleSize,
			scope: this
		};
		/*this.disminuyeTamano = {
			xtype: "button",
			text: "Disminuir tamaño"
		};*/
		this.extraButtons = [this.aumentaTamano /*,this.disminuyeTamano*/ ];

		this.callParent(arguments);
	},
	toggleSize: function () {
		if (!this.isFotoGrande) {
			this.setSize(true);
			this.isFotoGrande = true;
		} else {
			this.setSize(false);
			this.isFotoGrande = false;
		}

	},
	setSize: function (grande) {
		if (this.el) {
			if (grande) {
				this.el.select(".fotoPanel").addCls("grande");
			} else {
				this.el.select(".fotoPanel").removeCls("grande");
			}
			this.doLayout();
		}
	},

	onRenderDragZoneFunction: function (view, eopts) {
		this.setSize(this.isFotoGrande);
		//Activamos dragNdrop para los records que tengan el campo orden
		if (this.orderField && this.store.getModel().getField(this.orderField)) {
			// console.log("Metiendo eventos");
			var fotos = view.getEl().query(".thumb-wrap");
			var dragBefore = view.getEl().query(".drop-before");
			var dragAfter = view.getEl().query(".drop-after");

			var zoneConfig = {
				view: view,
				//ddGroup: "fotoGroup"
			};
			var overrides = {
				startDrag: function (e) {
					Ext.each(fotos, function (el) {
						if (this.el == el) {
							return;
						}
						Ext.fly(el).addCls('noEventsPls');
					});
					//console.log('startDrag');
					var xy = this.el.getXY()
						//console.log("x: " + xy[0] + "  //  y: " + xy[1]);
					this.initialPosition = xy;
				},
				onDrag: function (e) {
					//move the item where the mouse moves
					//console.log('onDrag');
					this.el.setXY([e.getX() - 32, e.getY() - 32]);
				},
				onDragEnter: function (e, id) {
					var splited = id.split("Foto");
					var data = {
						idElemento: this.id.split("foto")[1],
						targetPos: splited[0],
						targetId: splited[1]
					};
					if (data.idElemento != data.targetId) {
						Ext.fly(id).addCls('valid-zone');
					}
				},
				onDragOver: function (e, id) {

				},
				onDragOut: function (e, id) {
					//console.log('onDragOut');
					Ext.fly(id).removeCls('valid-zone');
				},
				onDragDrop: function (e, id) {
					Ext.each(fotos, function (el) {
						Ext.fly(el).removeCls('noEventsPls');
					});
					var splited = id.split("Foto");
					var data = {
						idElemento: this.id.split(e.target.dataset["nombre"])[1],
						targetPos: splited[0],
						targetId: splited[1]
					};
					if (data.idElemento == data.targetId) {
						return this.onInvalidDrop();
					}
					//console.log(data);
					view.fireEvent("recordsOrdered", view, data);
				},
				onInvalidDrop: function () {
					this.el.setXY(this.initialPosition);
					Ext.each(fotos, function (el) {
						Ext.fly(el).removeCls('noEventsPls');
					});

					//console.log('onInvalidDrop');
				},
				endDrag: function (e, id) {
					//console.log('endDrag');
				}
			};
			Ext.each(fotos, function (el) {
				var dd = Ext.create('Ext.dd.DD', el, 'fotoDDGroup', {
					isTarget: false
				});
				Ext.apply(dd, overrides);
			});

			Ext.each(dragBefore, function (el) {
				var elId = el.getAttribute("id");
				var mainTarget = Ext.create('Ext.dd.DDTarget', elId, 'fotoDDGroup', {
					ignoreSelf: false
				});
			});

			Ext.each(dragAfter, function (el) {
				var elId = el.getAttribute("id");
				var mainTarget = Ext.create('Ext.dd.DDTarget', elId, 'fotoDDGroup', {
					ignoreSelf: false
				});
			});
		}
	},
	onRecordsOrdered: function (view, data) {
		var store = view.getStore();
		var items = store.getData().items;
		var source = store.getById(data.idElemento);
		var sourceIdx = items.indexOf(source);
		var target = store.getById(data.targetId);

		store.beginUpdate();
		store.remove(source);
		var targetIndex = items.indexOf(target);
		var targetIndex = data.targetPos == "before" ? targetIndex : targetIndex + 1;
		store.insert(targetIndex, source);
		var suorden = 0;
		var orderField = this.orderField
		store.each(function (record) {
			suorden++;
			record.set(orderField, suorden);
		})
		store.endUpdate();
		//para que el view recargue
		store.loadData(store.getData().items);
		//para que se vuelvan a bindear las imagenes
		this.isBussy = true;
		this.onRenderDragZoneFunction(view);
		this.sendUpdatedFields();
	},
	sendUpdatedFields: function () {
		// console.log("Records sent!");
		var formName = this.editForm.application.formName;
		var formId = this.editForm.application.dataId;
		var subFormName = this.editForm.subFormName;
		//var items = this.store.getModifiedRecords();
		//TODO: garrom: No se porque pero ahora los records no se marcan como modificados
		var items = this.store.getData().items;
		var fotos = this.dataView.getEl().query(".thumb-wrap");
		Ext.each(fotos, function (el) {
			Ext.fly(el).addCls('noEventsPls');
		});
		serverDatabaseActions.updateSubFormList(formName, subFormName, formId, items, this.updateRecordCallback, this);
	},
	updateRecordCallback: function () {
		this.callParent(arguments);
		//para que se vuelvan a bindear las imagenes
		this.isBussy = false;
		this.onRenderDragZoneFunction(this.dataView);
	},
	cancelUpdatedFields: function () {
		var store = this.dataView.store;
		store.rejectChanges();
		this.checkUpdatedFelds();
		store.loadData(store.getData().items);
		this.onRenderDragZoneFunction(this.dataView);
	},
	dataViewDefaultConfig: {
		//emptyText: '##################EMPTY##################',
		bodyStyle: 'padding: 0px 0px 0px 0px',
		autoHeight: true,
		autoScroll: false,
		//layout: 'fit',
		layout: 'fit',
		multiSelect: false,
		singleSelect: true,
		//overCls: 'x-view-container-over',
		overItemCls: 'x-view-over',
		selectedItemCls: 'x-view-selected',

	},
	onUpdateRecordDone: function (form, newRecord, oldRecord) {
		if (!newRecord) {
			return;
		}
		var store = this.dataView.getStore();
		store.remove(store.findRecord("id", oldRecord.id));
		return this.onNewRecordDone(form, newRecord);
	},
	onNewRecordDone: function (form, newRecord) {
		var store = this.dataView.getStore();
		var resultado = this.reader.readRecords({
			'resultados': [newRecord],
			'totalNumRecords': 1
		});
		var record = resultado.records[0];
		store.add(record);
		store.loadData(store.getData().items);
		this.onRenderDragZoneFunction(this.dataView);
		return record;
	},
    afterDeleteForm: function(response) {
		var store = this.dataView.getStore();
        if (response.success) {
			//Notificamos a la aplicación de la eliminación del registro
			//var records = this.dataView.getSelectedRecords();
			var record = this.dataView.getRecord(this.dataView.getSelectedNodes()[0]);
			store.remove(record);
			//notificamos en barra de estado
			this.statusBar.setStatus({
				text: this.eliminadoTxt,
				clear: true // auto-clear after a set interval
			});
			store.loadData(store.getData().items);
			this.onRenderDragZoneFunction(this.dataView);
		} else {
            Ext.Msg.alert('Error:', response.message);
        }
	},
	setValues: function(){
		this.callParent(arguments);
		this.onRenderDragZoneFunction(this.dataView);
	},


	autoScroll: false,

});
// Namespace de At4FrameworkIntranet
Ext.namespace('At4FrameworkIntranet');

//Ext.extend(At4FrameworkIntranet.RelationPopupPanel, Ext.form.FieldSet, {
Ext.define("At4FrameworkIntranet.RelationPopupPanel", {
		extend: "Ext.form.FieldSet",
		/**
		 * @class At4FrameworkIntranet.RelationPopupPanel Clase de relation popup (un
		 *        ComboBox con enlace al formulario relacionado)
		 * @extends-ext Ext.Panel
		 * @author agarcia
		 * @constructor
		 *
		 * @param {At4FrameworkIntranet.BasicForm}
		 *            parentFormPanel Formulario contenedor
		 * @param {Object}
		 *            config
		 */
		constructor: function(parentFormPanel, combo, config) {
			console.log("Se esta llamando al constructor de RelationPopupPanel");
			Ext.apply(this, config);

			this.parentFormPanel = parentFormPanel;
			this.combo = combo;

			// Necesitamos saber si se trata de un subform
			if (parentFormPanel.subFormName) {
				this.inSubForm = true;
			} else {
				this.inSubForm = false;
			}

			//Private
			this.getApplication = function() {

				var p = this.parentFormPanel;
				while (p.subFormName) {
					p = p.parentPanel; //Buscamos el form de mayor nivel
				}
				return p.application;


			}

			this.viewRelated = new Ext.Button({
				// TODO: localear
				text: ">",
				tooltip: "Pulse para ver el registro",
				hidden: true,
				handler: function(button, event) {
					if (this.combo.getValue()) {
						this.parentFormPanel.application.openRecordForm({
							form: this.relatedFormName
						}, {
							oid: this.combo.getValue()
						});
					}
				},
				style: 'margin-top:18px',
				scope: this
			});

			var width = null;

			if (config.width > 0) {
				this.combo.setWidth(config.width - 30);
				width = config.width;
			} else if ((this.combo.width + 0) > 0) {
				width = this.combo.width + 30;
			}

			//At4FrameworkIntranet.RelationPopupPanel.superclass.constructor.call(this, {
			this.callParent(this, {
				xtype: 'fieldset',
				layout: 'column',
				border: false,
				labelAlign: "top",
				autoHeight: true,
				hidden: false,
				collapsible: false,
				style: 'margin-bottom: 0px;padding: 0px;',
				width: width,

				defaults: {
					msgTarget: 'under',
					validationEvent: true,
					border: false,
					labelAlign: "top",
					autoHeight: true,
					autoWidth: true,
					collapsible: false
				},


				items: [{
					xtype: 'fieldset',
					items: [this.combo]
				}, {
					items: [this.viewRelated]
				}]


			});

		},
		/**
		 * Nombre del formulario relacionado
		 *
		 * @type {String}
		 */
		relatedFormName: null

		,
		verTxt: 'ver'

		,
		onChange: function() {

			if (this.combo.getValue()) {
				this.viewRelated.setVisible(true);
			} else {
				this.viewRelated.setVisible(false);
			}

		}

		,
		initEvents: function() {
			At4FrameworkIntranet.RelationPopupPanel.superclass.initEvents.call(this);
			var activar = true;

			if (this.inSubForm) {

				//Queremos comprobar que el subform sea diferente al formulario base, para no tratar de abrir el mismo registro base
				var p = this.parentFormPanel;
				while (p.subFormName) {
					p = p.parentPanel; //Buscamos el form de mayor nivel
					if (p.formName && p.formName == this.relatedFormName) {
						activar = false;
					}
				}
			}

			if (activar) {
				this.combo.addListener('change', this.onChange.createDelegate(this));
				this.parentFormPanel.addListener('afterload', this.onChange.createDelegate(this));
			}

		}


	}

);
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
/**
 * @author Gregor Biering
 * @author  (http://kalmatrongeorgia.ge/dwrExtjs4Store/DwrProxy.js) first runnable version
 * @author Sencha
 * @class Ext.ux.DwrProxy
 * @extends Ext.data.proxy.Proxy
 *
 * CRUD-Proxy for DWR 3.0. Coded based on the idea of http://kalmatrongeorgia.ge/dwrExtjs4Store/DwrProxy.js
 * and the @class Ext.data.proxy.Server, Ext.data.proxy.AjaxProxy,Ext.data.proxy.RestProxy
 *
 */
Ext.define('Ext.ux.DwrProxy', {
		requires: ['Ext.util.MixedCollection', 'Ext.data.Request'],
		extend: 'Ext.data.proxy.Direct',
		alias: 'proxy.dwr',
		alternateClassName: ['Ext.data.dwrProxy'],
		/**
		 * @cfg {Boolean} passDwrStoreParams
		 * Send store parameter like "limit","start","page" to Dwr
		 */
		passDwrStoreParams: false,
		appendId: true,
		timeout: undefined,
		loadArgsKey: 'dwrFunctionArgs',
		constructor: function(config) {
			var me = this;

			config = config || {};

			//this.addEvents('exception');
			me.callParent([config]);

			/**
			 * @cfg {Object} extraParams
			 * Extra parameters that will be included on every request. Individual requests with params of the same name
			 * will override these params when they are in conflict.
			 */
			me.extraParams = config.extraParams || {};
		},
		create: function() {
			return this.doRequest.apply(this, arguments);
		},
		read: function(operation) {
			var dataProxy = this;
			var params = operation.config;

			/* agarcia TODO: esto no hace nada en extjs5
			dataProxy.filters = (config.params && config.params.filter) ? JSON.parse(operation.params.filter) : null;
			*/

			if (dataProxy.fireEvent("beforeload", dataProxy, params, this.dwrParams) !== false) {
				var loadArgs = params[this.loadArgsKey]; // the Array or Object to build up the "dwrFunctionArgs"
				var dwrFunctionArgs = []; // the arguments that will be passed to the dwrFunction
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
				// the scope for calling the dwrFunction doesn't matter, so we simply set it to Object.
				//this.dwrFunction.apply(Object, dwrFunctionArgs);
				this.dwrParams = dwrFunctionArgs;
				return this.doRequest.apply(this, arguments);
			} else { // the beforeload event was vetoed
				callback.call(scope || this, null, arg, false);
			}

		},
		update: function() {
			return this.doRequest.apply(this, arguments);
		},
		destroy: function() {
			return this.doRequest.apply(this, arguments);
		},
		doRequest: function(operation, callback, scope) {
			var me = this;
			var writer = this.getWriter();

			/// agarcia TODO: diría que esto en la práctica no hace nada, ya que el request que retorna no se usa para la petición
			request = this.buildRequest(operation, callback, scope);

			if (operation.allowWrite()) {
				request = writer.write(request);
			}

			// creating param list that is going to be sent to Dwr.
			// and adding the request.param as the first parameter
			/*
			if (this.passDwrStoreParams)
				var dwrParams = [request.params];
			else if (operation.action !== 'read') {
				if (Ext.isArray(request.jsonData))
					var dwrParams = [request.jsonData];
				else
					var dwrParams = [
						[request.jsonData]
					];
			} else*/
			var dwrParams = []

			// adding parameters if there are defined any in proxy
			// configuration
			if (typeof(me.dwrParams) === 'object') {
				dwrParams = dwrParams.concat(me.dwrParams);
			}

			dwrParams.push({
				callback: function(x) {
					me.processResponse(true, operation, request, x, callback, scope);
				},
				scope: scope,
				timeout: this.timeout,
				errorHandler: function(message, ex) {
					if(!message){
						message = JSON.stringify(ex);
					}
					if (console != undefined) {
						console.log(message);
					} else if (windows != undefined) {
						if (windows.console != undefined)
							windows.console.log(message);
					}

					me.processResponse(false, operation, request, message, callback, scope);
				}
			});

			// /making a call
			if (Ext.isFunction(me.dwrFunction)) {
				me.dwrFunction.apply(null, dwrParams);
			} else {
				switch (operation.action) {
					case 'read':
						me.dwrFunction.read.apply(null, dwrParams);
						break;
					case 'create':
						me.dwrFunction.create.apply(null, dwrParams);
						break;
					case 'update':
						me.dwrFunction.create.apply(null, dwrParams);
						break;
					case 'destroy':
						me.dwrFunction["delete"].apply(null, dwrParams);
						break;
					default:
						me.processResponse(false, operation, request, 'operation "' + operation.action + '" not available', callback, scope);
				}
			}

			return request;
		},

		processResponse: function(success, operation, request, response) {
			var me = this,
				exception, reader, resultSet;

			me.fireEvent('beginprocessresponse', me, response, operation);

			if (success === true) {
				reader = me.getReader();

				if (response.status === 204) {
					resultSet = reader.getNullResultSet();
				} else {
					resultSet = reader.readRecords(response);
				}

				operation.process(resultSet, request, response);
				exception = !operation.wasSuccessful();
			} else {
				me.setException(operation, response);
				exception = true;
			}

			if (exception) {
				me.fireEvent('exception', me, response, operation);
			}

			me.afterRequest(request, success);

			me.fireEvent('endprocessresponse', me, response, operation);
		},

		/** agarcia TODO: diría que esto en la práctica no hace nada, ya que el request que retorna no se usa para la petición
		 * Creates and returns an Ext.data.Request object based on the options passed by the {@link Ext.data.Store Store}
		 * that this Proxy is attached to.
		 * @param {Ext.data.Operation} operation The {@link Ext.data.Operation Operation} object to execute
		 * @return {Ext.data.Request} The request object
		 */
		buildRequest: function(operation) {
			var params = Ext.applyIf(operation.params || {}, this.extraParams || {}),
				request;

			//copy any sorters, filters etc into the params so they can be sent over the wire
			params = Ext.applyIf(params, this.getParams(operation));

			if (operation.id && !params.id) {
				params.id = operation.id;
			}

			request = Ext.create('Ext.data.Request', {
				params: params,
				records: operation.records,
				operation: operation
			});

			/*
			 * Save the request on the Operation. Operations don't usually care about Request and Response data, but in the
			 * ServerProxy and any of its subclasses we add both request and response as they may be useful for further processing
			 */
			operation.request = request;

			return request;
		},
		/**
		 * @private
		 * Copy any sorters, filters etc into the params so they can be sent over the wire
		 */
		getParams: function(operation) {
			var me = this,
				params = {},
				isDef = Ext.isDefined,
				groupers = operation.groupers,
				sorters = operation.sorters,
				filters = operation.filters;

			Ext.apply(params, {
				page: operation.page,
				start: operation.start,
				limit: operation.limit
			});

			if (groupers && groupers.length > 0) {
				Ext.apply(params, {
					groupers: me.encodeSorters(groupers)
				});
			}

			if (sorters && sorters.length > 0) {
				Ext.apply(params, {
					sorters: me.encodeSorters(sorters)
				});
			}

			if (filters && filters.length > 0) {
				Ext.apply(params, {
					filters: me.encodeFilters(filters)
				});
			}

			return params;
		},

		/**
		 * Encodes the array of {@link Ext.util.Sorter} objects into a string to be sent in the request url. By default,
		 * this simply JSON-encodes the sorter data
		 * @param {Ext.util.Sorter[]} sorters The array of {@link Ext.util.Sorter Sorter} objects
		 * @return {String} The encoded sorters
		 */
		encodeSorters: function(sorters) {
			var min = [],
				length = sorters.length,
				i = 0;

			for (; i < length; i++) {
				min[i] = {
					property: sorters[i].getProperty(),
					direction: sorters[i].direction()
				};
			}
			return this.applyEncoding(min);

		},
		/**
		 * Encode any values being sent to the server. Can be overridden in subclasses.
		 * @private
		 * @param {Array} An array of sorters/filters.
		 * @return {Object} The encoded value
		 */
		applyEncoding: function(value) {
			//return Ext.encode(value);
			//agarcia: para Dwr no aplicamos encoding
			return value;
		},
		/**
		 * Encodes the array of {@link Ext.util.Filter} objects into a string to be sent in the request url. By default,
		 * this simply JSON-encodes the filter data
		 * @param {Ext.util.Filter[]} filters The array of {@link Ext.util.Filter Filter} objects
		 * @return {String} The encoded filters
		 */
		encodeFilters: function(filters) {
			var min = [],
				length = filters.length,
				i = 0;

			for (; i < length; i++) {
				min[i] = {
					property: filters[i].property ? filters[i].property : filters[i].getProperty(),
					value: filters[i].value ? filters[i].value : filters[i].getValue()
				};
			}
			return this.applyEncoding(min);
		},
		/**
		 * Sets up an exception on the operation
		 * @private
		 * @param {Ext.data.Operation} operation The operation
		 * @param {Object} response The response
		 */
		setException: function(operation, response) {
			var status = (response != null ? response.status : "Error");
			var statusText = (response != null ? response.statusText : "No se ha obtenido respuesta del servidor");
			operation.setException({
				status: status,
				statusText: statusText
			});
		},
		/**
		 * Optional callback function which can be used to clean up after a request has been completed.
		 * @param {Ext.data.Request} request The Request object
		 * @param {Boolean} success True if the request was successful
		 * @method
		 */
		afterRequest: Ext.emptyFn,

		listeners: {
			exception: function(proxy, response, operation) {
				Ext.Msg.alert('Error', response);
			}
		}
	},
	function() {
		// backwards compatibility, remove in Ext JS 5.0
		//Ext.data.HttpProxy = this;
	});
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
/**
 * @class ServerGui
 * Implementación DWR del interfaz GUI: acceso a las características de menús, etc. en el servidor.<br/>
 * Basado en "javascript singleton pattern" (http://www.dhtmlkitchen.com/learn/js/singleton/) 
 * @singleton
 * @author agarcia
 */
serverGui = new function ServerGui() {
   

		/** Devuelve la estructura de elementos del menú como objeto ToolbarElements,
		 *  que contiene 2 propiedades: menus e icons, cada una de las cuales es un
		 *  vector de objetos MenuItem:
		 * 	{
		 * 		text: String
		 * 		menu: Vector<MenuItem>
		 *  }
		 * @param {Function} callbackFunction Función a la cuál llamar
		 * @param {Object} source objeto (scope) en el que ejecutar la función
         * @return {Array} 
		 */
		this.getToolBarElements = function(callbackFunction, source){
			GuiService.getToolBarElements({
				callback: function(dataFromServer){
					callbackFunction.call(source, dataFromServer);
				}
			});

		}

		/** Devuelve la configuración (GridMetaData) para configurar un grid de ListadoGrid
		 *
		 * @param {Object} btn Identificación del formulario a generarl
		 * @param {Function} callbackFunction Función a la cuál llamar
		 * @param {Object} source objeto (scope) en el que ejecutar la función
		 * @param {Object} callbackArgs argumentos para callbackFunction
		 * @return {Object}
		 */
		this.getListMetadata = function(btn, callbackFunction, source, callbackArgs){
			
			//Extraemos de btn, las propiedades que forman el objeto FormItem
			var formItem = {
				id: btn.id
				,text: btn.text
				,href: btn.href
				,form: btn.form
				,mode: btn.mode
				,iconCls: btn.iconCls
				,parameters: btn.parameters
			}
			
			FormDataService.getListMetadata(formItem, {
				callback: function(dataFromServer){
					callbackFunction.call(source, formItem, dataFromServer, callbackArgs);
				}
			});

		}


}
