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
