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
