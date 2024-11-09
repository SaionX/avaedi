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
