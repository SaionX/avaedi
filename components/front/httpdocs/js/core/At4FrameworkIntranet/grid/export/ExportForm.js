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
