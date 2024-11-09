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
