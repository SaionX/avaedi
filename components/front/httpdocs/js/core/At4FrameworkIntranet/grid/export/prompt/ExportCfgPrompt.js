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
