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
