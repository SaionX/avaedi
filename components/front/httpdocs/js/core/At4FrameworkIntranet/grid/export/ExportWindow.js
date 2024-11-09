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
