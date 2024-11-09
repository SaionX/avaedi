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