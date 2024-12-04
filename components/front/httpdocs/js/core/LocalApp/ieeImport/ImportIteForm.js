Ext.define("At4FrameworkIntranet.ImportIteWindow", {
	extend: "At4FrameworkIntranet.Window",
	title: "ITE (asimilable a IEE de 30 años)",
	closable: false,
	closeAction: "destroy",
	height: 460,
	width: 600,
	resizable: false,
	modal: true,
	cls: "importarieewindow",

	constructor: function (cfg) {
		var me = this;

		var form = Ext.create("At4FrameworkIntranet.ImportIteForm");
		form.cancelarButton = Ext.create({
			text: "Cancelar",
			xtype: "button",
			handler: function (btn, ev) {
				form.cancelarClick(form, btn, ev, me)
			}
		});
		form.avanzarButton = Ext.create({
			xtype: "button",
			text: "Siguiente",
			scope: me,
			ventanaScope: me,
			handler: function (btn, ev) {
				form.avanzarClick(form, btn, ev, me);
			}
		});
		form.cerrarButton = Ext.create({
			xtype: "button",
			text: "Cerrar",
			scope: me,
			ventanaScope: me,
			handler: function (btn, ev) {
				form.cerrarClick(form, btn, ev, me);
			}
		});
		form.changeButtons(1);
		me.items = [form];
		me.buttons = [form.cancelarButton, form.avanzarButton, form.cerrarButton];
		me.callParent(arguments);
		form.ventanaScope = me;
	}

});




Ext.define("At4FrameworkIntranet.ImportIteForm", {
	extend: "Ext.panel.Panel",
	layout: 'card',
	cls: "importariee",
	activeItem: 0, // index or id
	requestactive: false,

	changeButtons: function (state) {
		//1 cancelar / siguiente | 2 cancelar / reintentar | 3 guardar y abrir / guardar y cerrar
		var bt1 = this.cancelarButton;
		var bt2 = this.avanzarButton;
		var bt3 = this.cerrarButton;
		var allcls = ["alert", "info", "done", "warn"];
		bt1.removeCls(allcls);
		bt2.removeCls(allcls);
		bt3.removeCls(allcls);
		switch (state) {
		case 1:
			bt1.setText("Cancelar");
			bt2.setText("Siguiente");
			bt1.addCls("alert");
			bt2.addCls("info");
			bt3.hide();
			break;
		case 2:
			bt1.setText("Cancelar");
			bt2.setText("Reintentar");
			bt1.addCls("alert");
			bt2.addCls("warn");
			bt3.hide();
			break;
		case 3:
			bt1.setText("Revertir");
			bt2.setText("Guardar y abrir informe");
			bt3.setText("Guardar y cerrar");
			bt1.addCls("alert");
			bt2.addCls("done");
			bt3.addCls("info");
			bt3.show();
			break;
		}

	},
	acciones: {
		enviarImportacion: function () {
			var layout = this.getLayout();
			var pdfItem = this.primerFormFields.documentoPdf;
			var dataItem = this.primerFormFields.fechaFirma;
			var cadastreItem = this.primerFormFields.numeroCatastro;
			var pdfvalid = pdfItem.isValid();
			var dataValida = dataItem.isValid();
			var cadastreValid = cadastreItem.isValid();
			if (!pdfvalid || !dataValida || !cadastreValid) {
				return;
			}
			var pdfInput = pdfItem.getTrigger("filebutton").component.fileInputEl.dom;
			var dataValue = this.primerFormFields.fechaFirma.getValue();
			var cadastreValue = this.primerFormFields.numeroCatastro.getValue();
			var favorableValue = this.primerFormFields.favorable.getValue();
			if (!this.requestactive) {
				this.requestactive = true;
				//TODO:
				serverDatabaseActions.runAction(FormDataService.importIte, [pdfInput, dataValue, cadastreValue, favorableValue], function (data, callee) {
					var itemToGo = 1;
					this.requestactive = false;
					//TODO:
					//var data = window.testIee;
					//console.log(data);
					if (!data.correcto) {
						this.changeButtons(2);
						var errorTPL = "<div class='ko-invalid'><span class='glyphicons glyphicons-remove-circle'></span>{0}</div>";
						var errorMsg = errorTPL.replace("{0}", data.errorMsg);
						this.tercerFormItems.box.update(errorMsg);
						this.tercerFormItems.logField.setValue(data.errorHtml);
						itemToGo = 2;
					} else {
						itemToGo = 1;
						this.loadIee(data);
						this.changeButtons(3);
					}
					this.activeItem = itemToGo;
					layout.setActiveItem(itemToGo);
					//TODO
				}.bind(this));
			} else {
				console.info("Se han intentado enviar diversas solicitudes de importacion")
			}
		},
		guardarYCerrar: function () {
			if (!this.requestactive) {
				this.submitSaveImport(function (data) {
					this.requestactive = false;
					// //console.log(data);
					this.ventanaScope.destroy();
				});
			} else {
				console.info("Se han intentado enviar diversas solicitudes de guardar datos")
			}
		},
		guardarYAbrir: function () {
			if (!this.requestactive) {
				this.submitSaveImport(function (dataUpdate) {
					//console.log(dataUpdate);
					this.ventanaScope.destroy();

					At4FrameworkIntranet.app.openRecordForm(this.formItem, {
						oid: dataUpdate.claveInforme
					});
				});
			} else {
				console.info("Se han intentado enviar diversas solicitudes de guardar datos")
			}
		},
		errorReintentar: function () {
			var layout = this.getLayout();
			this.changeButtons(1);
			this.activeItem = 0;
			layout.setActiveItem(0);
			this.primerFormFields.documentoIee.reset();
			this.primerFormFields.documentoPdf.reset();
		},
		cerrarVentana: function () {
			this.ventanaScope.destroy();
		},
		cancelarImportacionActiva: function () {
			//TODO:
			serverDatabaseActions.runAction(FormDataService.cancelImport, [this.claveInforme], function (val) {
				//console.log(arguments)
				if (val) {
					this.acciones.cerrarVentana.call(this);
					Ext.Msg.alert('Correcto', 'Importacion revertida');
				} else {
					this.acciones.cerrarVentana.call(this);
					Ext.Msg.alert('Advertencia', 'No se pudo revertir la importación, por favor contacte con un administrador');
				}

			}, serverDatabaseActions.exceptionHandler, this)
		}

	},

	avanzarClick: function (form, btn, ev, ventana) {
		//console.log("Avanzar click", this.activeItem);
		if (this.activeItem == 0) {
			this.acciones.enviarImportacion.call(this);
		} else if (this.activeItem == 1) {
			this.acciones.guardarYAbrir.call(this);
		} else if (this.activeItem == 2) {
			this.acciones.errorReintentar.call(this);
		}
	},
	cerrarClick: function (form, btn, ev, ventana) {
		//console.log("Cerrar click", this.activeItem);
		if (this.activeItem == 0) {
			//nothing
		} else if (this.activeItem == 1) {
			this.acciones.guardarYCerrar.call(this);
		} else if (this.activeItem == 2) {
			//nothing
		}
	},
	cancelarClick: function (form, btn, ev, ventana) {
		//console.log("Cancelar click", this.activeItem);
		if (this.activeItem == 0) {
			this.acciones.cerrarVentana.call(this);
		} else if (this.activeItem == 1) {
			this.acciones.cancelarImportacionActiva.call(this);
		} else if (this.activeItem == 2) {
			this.acciones.cerrarVentana.call(this);
		}
	},
	submitSaveImport: function (callback) {
		if (!this.segundoFormItems.estadoInforme.validate() || (this.segundoFormItems.nuevoEdificioAction.isVisible() && !this.segundoFormItems.nuevoEdificioAction.validate()) || (this.segundoFormItems.numeroExtra.isVisible() && !this.segundoFormItems.numeroExtra.validate())) {
			return;
		}
		this.requestactive = true;
		var eInfId = this.segundoFormItems.estadoInforme.getValue();
		var numExt = this.segundoFormItems.numeroExtra.getValue();
		var nuevoEdificioAction = this.segundoFormItems.nuevoEdificioAction.getValue();

		serverDatabaseActions.runAction(
			FormDataService.saveImport, [this.claveInforme, eInfId, numExt, nuevoEdificioAction],
			callback.bind(this),
			this
		);
		// FormDataService.saveImport(this.claveInforme, eInfId, numExt, callback.bind(this))

		//console.log('Guardando actualizacion');
	},
	loadIee: function (data) {
		//console.log(data);
		this.claveInforme = data.primaryKey;
		/*this.segundoFormItems.estadoInforme.setComboValue("estadoInformeId", {
			estadoInformeId: data.estadoInformeId,
			estadoInformeLabel: data.estadoInformeLabel
		})*/

		/*this.segundoFormItems.via.setComboValue("viaId", {
			viaId: data.viaId,
			viaLabel: data.viaLabel
		})*/

		debugger
		// var estadoSelected = 3;
		var estadoSelected = data.estadoInformeId;
		var estadosData = data.estadoInformeDisponibles;

		// Si l'estat no és un dels disponibles, inicialitzam el combo a desfavorable
		var isEstadoDisponible = estadosData.some(function(estado) {
			return estado.clave === estadoSelected;
		});
		if (!isEstadoDisponible) {
			estadoSelected = 3;
		}
		var estadosInformeStore = Ext.create('Ext.data.Store', {
			fields: ['clave', 'nombreEs', 'nombreCa'],
			data: estadosData
		});

		// for (var key in estadosData) {
		// 	if (estadosData.hasOwnProperty(key)) {
		// 		var estado = estadosData[key];
		// 		if (estado.clave != 3) {
		// 			estadoSelected = estado.clave;
		// 		}
		// 	}
		// }


		var edificiosData = data.edificiosDisponibles;
		var data1 = data.edificiosDisponibles[0];
		edificiosData.unshift({
			"clave": -1,
			"primaryLabel": "[Crear un nuevo registro]",
			"numeroExtra": data1.numeroExtra,
			"numeroCatastro": data1.numeroCatastro,
			"viaLabel": data1.viaLabel,
		})

		var nuevoEdificioStore = Ext.create('Ext.data.Store', {
			fields: ['clave', 'primaryLabel', 'numeroExtra', 'numeroCatastro', 'viaLabel'],
			data: edificiosData
		});

		this.segundoFormItems.nuevoEdificioAction.setStore(nuevoEdificioStore);

		this.segundoFormItems.estadoInforme.setStore(estadosInformeStore);

		this.segundoFormItems.estadoInforme.setValue(estadoSelected);

		this.segundoFormItems.nuevoEdificio.setHidden(!data.edificioExistia);

		this.segundoFormItems.nuevoEdificioAction.setHidden(!data.edificioExistia);

		this.segundoFormItems.nuevoEdificioAction.setValue(-1);

		this.segundoFormItems.numeroExtra.setHidden(!data.edificioExistia);

		//this.segundoFormItems.numeroCatastro.setValue(data.numeroCatastro);

		//this.segundoFormItems.numeroExtra.setValue(data.numeroExtra);
	},

	constructor: function (config) {
		Ext.apply(this, config);
		var tabHelper = new At4util.tabIndexHelper(this.tabIndex);

		var primerFormFields = {}

		primerFormFields.documentoPdf = Ext.create({
			//fieldLabel: "Documenteo PDF .pdf",
			allowBlank: false,
			margin: "0 30px",
			xtype: "filefield",
			width: 500,
			name: "filePDF"
		});
		primerFormFields.fechaFirma = new Ext.form.DateField({
			name: 'fechaFirma',
			fieldLabel: "Fecha firma",
			// fieldLabel: this.fechaInformeHeaderLabel,
			// tabIndex: tabHelper.getNext(),
			margin: "0 30px",
			width: 170,
			disabled: false,
			allowBlank: false,
			format: 'd-m-Y'
		});

		primerFormFields.tipusIee = Ext.create({
			xtype: "hidden",
			name: 'tipusIee',
			value: 'T30'
		});
		primerFormFields.renovacio = Ext.create({
			xtype: "hidden",
			name: 'renovacio',
			value: false
		});
		primerFormFields.subsana = Ext.create({
			xtype: "hidden",
			name: 'subsana',
			value: false
		});

		primerFormFields.numeroCatastro = new Ext.form.TextField({
			name: 'numeroCatastro',
			fieldLabel: "Numero catastro",
			// labelAttrTpl: " data-qtip='" + this.numeroCatastroDescriptionLabel + "'",
			// tabIndex: tabHelper.getNext(),
			margin: "0px",
			editable: true,
			disabled: false,
			allowBlank: false,
			width: 300,
			maxLength: 64
		});
		primerFormFields.favorable = Ext.create({
			margin: "0 30px",
			xtype: "checkbox",
			name: 'favorable',
			boxLable: 'favorable'
		})

		/*primerFormFields.submit = Ext.create({
			xtype: "button",
			text: "Test",
			scope: this,
			border: true,
			handler: function () {
				var ieeInput = this.primerFormFields.documentoIee.getTrigger("filebutton").component.fileInputEl.dom;
				var pdfInput = this.primerFormFields.documentoPdf.getTrigger("filebutton").component.fileInputEl.dom;
				FormDataService.importIte(ieeInput, pdfInput, function (data, callee) {
					//console.log(data);
				});
				//console.log('You clicked the button!');
			}
		})*/

		this.primerFormFields = primerFormFields;
		var formFields = [{
			xtype: 'At4Framework-fieldmainpanel',
			items: [
				At4FrameworkIntranet.FormDefaults.rows(
					[
						[{
							xtype: "container",
							margin: "15px 15px 0px 30px",
							html: "<span class='iee'><span class='icono pdf'></span><span class='texto'>Documento PDF </span>(.pdf)</span>"
						}],
						[primerFormFields.documentoPdf],
						[primerFormFields.fechaFirma,
						primerFormFields.numeroCatastro],
						[{
							xtype: "container",
							margin: "15px 15px 0px 30px",
							html: "<span class='iee'><span class='texto'>Es favorable? </span></span>"
						}],
						[primerFormFields.favorable],
						[{
							xtype: "container",
							margin: "15px 0 0 15px",
							width: 500,
							//height: 120,
							html: "<span class='regimg'></span>"
						}],
						[primerFormFields.renovacio, primerFormFields.subsana, primerFormFields.tipusIee]
						//[primerFormFields.submit]
						//,
						//At4FrameworkIntranet.FormDefaults.resumenAuditoria()
					], {}, {
						minWidth: null,
					}
				)
			]
		}];


		var segundoFormItems = {};
		//Direccion completa, estado, si el edificio existia, edificio.numero_extra, abrir informe

		segundoFormItems.numeroCatastro = new Ext.form.TextField({
			name: 'numeroCatastro',
			fieldLabel: "Numero catastro",
			labelAttrTpl: " data-qtip='" + this.numeroCatastroDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			editable: false,
			width: At4FrameworkIntranet.FormDefaults.size(3, 2, 12),
			maxLength: 64
		})
		segundoFormItems.via = new Ext.form.TextField({
			name: 'viaId',
			fieldLabel: "Via",
			tabIndex: tabHelper.getNext(),
			//allowBlank: false,
			//store: At4FrameworkIntranet.FormDefaults.getStore('Via'),
			//recordPK: 'clave',
			editable: false,
			//hideTrigger: true,
			// relatedForm: 'via',
			width: At4FrameworkIntranet.FormDefaults.size(4, 2, 12)
		})
		segundoFormItems.numeroExtra = new Ext.form.TextField({
			name: 'numeroExtra',
			fieldLabel: "Numero extra",
			// labelAttrTpl: " data-qtip='" + this.numeroExtraDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			allowBlank: false,
			width: At4FrameworkIntranet.FormDefaults.size(4, 2, 12),
			maxLength: 64
		})
		/*var liveFiltersFn = function () {
			return [{
				property: 'clave',
				value: 3
			}];
		}*/
		/*	var displayField = "nombreEs";
			if (At4FrameworkIntranet.app.idioma === "ca") {
				displayField = "nombreCa";
			}
			this.segundoFormItems.estadoInforme.setDisplayField(displayField);*/
		//segundoFormItems.estadoInforme = new At4FrameworkIntranet.ComboBox({
		segundoFormItems.estadoInforme = Ext.create("Ext.form.field.ComboBox", {
			name: 'estadoInformeId',
			fieldLabel: "Estado del informe",
			//labelAttrTpl: " data-qtip='" + this.estadoInformeDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 2, 12),
			allowBlank: false,
			valueField: "clave",
			displayField: At4FrameworkIntranet.app.idioma === "ca" ? "nombreCa" : "nombreEs",
			/*store: At4FrameworkIntranet.FormDefaults.getStore('EstadoInforme', {}, {
				liveFiltersFn: liveFiltersFn
			}),*/
			//recordPK: 'clave',
		})
		segundoFormItems.resultado = Ext.create({
			xtype: "container",
			width: At4FrameworkIntranet.FormDefaults.size(7, 0, 12),
			height: "auto",
			html: '<div class="ok-valid"><span class="glyphicons glyphicons-ok-circle"></span><div class="mensaje"> Subida de informe realizada con éxito.<span class="block">Por favor, compruebe los siguientes datos:</span></div></div>'
		});
		segundoFormItems.nuevoEdificio = Ext.create({
			xtype: "container",
			height: "auto",
			hidden: true,
			width: At4FrameworkIntranet.FormDefaults.size(7, 0, 12),
			html: '<div class="edificio-existente"><span class="glyphicons glyphicons-warning-sign"></span> <span style="font-weight: bold;">El edificio ya existia</span><p style="line-height: normal;margin: 0;font-size: smaller;">Rellenar el campo "Numero extra" y seleccionar la opción [Crear un nuevo registro] solamente en el caso de estar importando un informe de un nuevo edificio que tiene la misma referéncia catastral que otro edificio ya existente en el sistema (Caso de múltiples edificios con la misma referencia catastral). En caso contrario seleccionar el edificio existente al que se realiza el informe.</p></div>'
		});

		segundoFormItems.nuevoEdificioAction = Ext.create("Ext.form.field.ComboBox", {
			name: 'nuevoEdificioAction',
			//fieldLabel: "Accion edificio",
			//labelAttrTpl: " data-qtip='" + this.estadoInformeDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(7, 0, 12),
			allowBlank: false,
			queryMode: 'local',
			hidden: true,
			displayField: 'primaryLabel',
			valueField: 'clave',
			listeners: {
				change: {
					fn: function (el, newValue, oldValue, eOpts) {
						//console.log(arguments);
						var record = el.getSelectedRecord();
						if (!record) {
							return;
						}
						var data = record.getData();
						if (data.clave === -1) {
							this.segundoFormItems.numeroExtra.show();
						} else {
							this.segundoFormItems.numeroExtra.hide();
						}
						this.segundoFormItems.via.setValue(data.viaLabel)
						this.segundoFormItems.numeroCatastro.setValue(data.numeroCatastro)
						//this.segundoFormItems.numeroExtra.setValue(data.numeroExtra)

					},
					scope: this
				}
			}
			//store: nuevoEdificioStore,
			// margin: "0,0,0,65px"
		});

		this.segundoFormItems = segundoFormItems;
		/*var formFields2 = At4FrameworkIntranet.FormDefaults.rows([
			[segundoFormItems.resultado],
			[segundoFormItems.estadoInforme, segundoFormItems.numeroExtra],
			[segundoFormItems.nuevoEdificio],
			[segundoFormItems.nuevoEdificioAction],
			[segundoFormItems.numeroCatastro, segundoFormItems.via],
		], {}, {
			minWidth: null,
			margin: "10px 40px"
		});*/
		var formFields2 = {
			xtype: "At4Framework-fieldmainpanel",
			items: [{
				xtype: "At4Framework-rowContainer",
				items: [segundoFormItems.resultado],
				margin: "10px 40px"
			}, {
				xtype: "At4Framework-rowContainer",
				items: [segundoFormItems.estadoInforme, segundoFormItems.numeroExtra],
				margin: "10px 40px"
			}, {
				xtype: "At4Framework-rowContainer",
				items: [segundoFormItems.nuevoEdificio],
				margin: "0 40px"
			}, {
				xtype: "At4Framework-rowContainer",
				items: [segundoFormItems.nuevoEdificioAction],
				margin: "0 40px"
			}, {
				xtype: "At4Framework-rowContainer",
				items: [segundoFormItems.via, segundoFormItems.numeroCatastro],
				margin: "10px 40px"
			}]
		};


		var tercerFormItems = {};
		tercerFormItems.box = Ext.create({
			xtype: "container",
			width: "100%",
			html: 'Step 3',
			margin: "10px 40px"
		});
		tercerFormItems.logField = Ext.create({
			xtype: "htmleditor",
			cls: "out log",
			//fieldStyle: "font-family: monospace !important; background-color: #eeeeee;",
			//fieldLabel: "Salida de log",
			editable: false,
			//height: At4FrameworkIntranet.FormDefaults.size(8),
			//width: At4FrameworkIntranet.FormDefaults.size(17),
			width: "100%",
			value: "<br>",
			readOnly: true,
			listeners: {
				render: {
					scope: this, // need form component level, not field function level
					fn: function () {
						tercerFormItems.logField.getToolbar().hide();
					}
				},
				initialize: function (editor) {
					var styles = {
						"font-family": "monospace",
						"background-color": "#eeeeee"
					};
					Ext.DomHelper.applyStyles(editor.getEditorBody(), styles);
				}
			}
			//html: "Log test"
		})

		var errorFS = Ext.create({
			xtype: "fieldset",
			width: "100%",
			border: true,
			collapsible: true,
			collapsed: true,
			title: "Traza del error",
			items: [tercerFormItems.logField],
		})
		this.tercerFormItems = tercerFormItems;
		/*var formFields3 = [{
			xtype: 'At4Framework-fieldmainpanel',
			height: 300,
			layout: {
				type: "hbox",
				align: "middle"
			},
			items: this.tercerFormItems.box
		}]*/

		var formFields3 = At4FrameworkIntranet.FormDefaults.rows([
			[this.tercerFormItems.box],
			[errorFS]
		], {}, {
			minWidth: null,
		});

		var items = [{
			//Formulario de entrada de datos
			items: formFields
		}, {
			//Formulario de datos correctos
			items: formFields2
		}, {
			//Formulario de error
			items: formFields3
		}]
		this.items = items;
		this.callParent();
	},
	formItem: {
		"form": "informe",
		"href": null,
		"iconCls": "glyphicons glyphicons-newspaper",
		"id": null,
		"link": false,
		"menu": null,
		"mode": "list",
		"parameters": null,
		"text": "Informe"
	}
});

//TODO: QUITAR
window.testIee = {
	"claveInforme": 1607,
	"correcto": true,
	"creatorUser": null,
	"dateCreation": null,
	"edificioExistia": true,
	"edificiosDisponibles": [{
		"clave": -1,
		"primaryLabel": "[Crear un nuevo registro]",
		"numeroExtra": "Obligado",
		"numeroCatastro": "79",
		"viaLabel": "CONQUISTADOR",
		"id": "extModel224-1"
	}, {
		"antiguedad": 0,
		"centroX": 486776,
		"centroY": 4392639,
		"clave": 706,
		"creatorUser": "admin",
		"dateCreation": "2016-12-05T13:56:42.859Z",
		"informes": [{
			"clave": 1561,
			"creatorUser": "admin",
			"dateCreation": "2017-01-10T09:53:11.732Z",
			"edificioId": 706,
			"edificioLabel": "CONQUISTADOR, 79 (Obligado)",
			"estadoInformeId": 3,
			"estadoInformeLabel": "En tramitación",
			"fechaAlta": "2017-01-09T23:00:00.000Z",
			"fechaInforme": "2017-01-09T23:00:00.000Z",
			"ieeArxiu": 1562,
			"ieeArxiuMime": "application/octet-stream",
			"inspeccionId": 1561,
			"inspeccionLabel": "1561",
			"lastModified": "2017-01-10T09:53:11.732Z",
			"modUser": "admin",
			"municipioId": 353,
			"municipioLabel": "BINISSALEM",
			"pdfArxiu": 1561,
			"pdfArxiuMime": "application/pdf",
			"primaryKey": 1561,
			"primaryLabel": "1561"
		}, {
			"clave": 1544,
			"creatorUser": "admin",
			"dateCreation": "2017-01-10T09:28:23.898Z",
			"edificioId": 706,
			"edificioLabel": "CONQUISTADOR, 79 (Obligado)",
			"estadoInformeId": 2,
			"estadoInformeLabel": "Desfavorable",
			"fechaAlta": "2017-01-09T23:00:00.000Z",
			"fechaInforme": "2017-01-09T23:00:00.000Z",
			"ieeArxiu": 1548,
			"ieeArxiuMime": "application/octet-stream",
			"inspeccionId": 1544,
			"inspeccionLabel": "1544",
			"lastModified": "2017-01-10T09:28:23.898Z",
			"modUser": "admin",
			"municipioId": 353,
			"municipioLabel": "BINISSALEM",
			"pdfArxiu": 1547,
			"pdfArxiuMime": "application/pdf",
			"primaryKey": 1544,
			"primaryLabel": "1544"
		}, {
			"clave": 1604,
			"creatorUser": "admin",
			"dateCreation": "2017-01-10T11:39:09.504Z",
			"edificioId": 706,
			"edificioLabel": "CONQUISTADOR, 79 (Obligado)",
			"estadoInformeId": 5,
			"estadoInformeLabel": "En curso",
			"fechaAlta": "2017-01-09T23:00:00.000Z",
			"fechaInforme": "2017-01-09T23:00:00.000Z",
			"ieeArxiu": 1588,
			"ieeArxiuMime": "application/octet-stream",
			"inspeccionId": 1604,
			"inspeccionLabel": "1604",
			"lastModified": "2017-01-10T11:39:09.504Z",
			"modUser": "admin",
			"municipioId": 353,
			"municipioLabel": "BINISSALEM",
			"pdfArxiu": 1587,
			"pdfArxiuMime": "application/pdf",
			"primaryKey": 1604,
			"primaryLabel": "1604"
		}, {
			"clave": 1605,
			"creatorUser": "admin",
			"dateCreation": "2017-01-10T11:41:24.947Z",
			"edificioId": 706,
			"edificioLabel": "CONQUISTADOR, 79 (Obligado)",
			"estadoInformeId": 5,
			"estadoInformeLabel": "En curso",
			"fechaAlta": "2017-01-09T23:00:00.000Z",
			"fechaInforme": "2017-01-09T23:00:00.000Z",
			"ieeArxiu": 1590,
			"ieeArxiuMime": "application/octet-stream",
			"inspeccionId": 1605,
			"inspeccionLabel": "1605",
			"lastModified": "2017-01-10T11:41:24.947Z",
			"modUser": "admin",
			"municipioId": 353,
			"municipioLabel": "BINISSALEM",
			"pdfArxiu": 1589,
			"pdfArxiuMime": "application/pdf",
			"primaryKey": 1605,
			"primaryLabel": "1605"
		}, {
			"clave": 1606,
			"creatorUser": "admin",
			"dateCreation": "2017-01-10T11:45:15.687Z",
			"edificioId": 706,
			"edificioLabel": "CONQUISTADOR, 79 (Obligado)",
			"estadoInformeId": 5,
			"estadoInformeLabel": "En curso",
			"fechaAlta": "2017-01-09T23:00:00.000Z",
			"fechaInforme": "2017-01-09T23:00:00.000Z",
			"ieeArxiu": 1592,
			"ieeArxiuMime": "application/octet-stream",
			"inspeccionId": 1606,
			"inspeccionLabel": "1606",
			"lastModified": "2017-01-10T11:45:15.687Z",
			"modUser": "admin",
			"municipioId": 353,
			"municipioLabel": "BINISSALEM",
			"pdfArxiu": 1591,
			"pdfArxiuMime": "application/pdf",
			"primaryKey": 1606,
			"primaryLabel": "1606"
		}, {
			"clave": 1602,
			"creatorUser": "admin",
			"dateCreation": "2017-01-10T11:24:39.466Z",
			"edificioId": 706,
			"edificioLabel": "CONQUISTADOR, 79 (Obligado)",
			"estadoInformeId": 5,
			"estadoInformeLabel": "En curso",
			"fechaAlta": "2017-01-09T23:00:00.000Z",
			"fechaInforme": "2017-01-09T23:00:00.000Z",
			"ieeArxiu": 1584,
			"ieeArxiuMime": "application/octet-stream",
			"inspeccionId": 1602,
			"inspeccionLabel": "1602",
			"lastModified": "2017-01-10T11:24:39.466Z",
			"modUser": "admin",
			"municipioId": 353,
			"municipioLabel": "BINISSALEM",
			"pdfArxiu": 1583,
			"pdfArxiuMime": "application/pdf",
			"primaryKey": 1602,
			"primaryLabel": "1602"
		}, {
			"clave": 1521,
			"creatorUser": "admin",
			"dateCreation": "2017-01-10T08:50:26.479Z",
			"edificioId": 706,
			"edificioLabel": "CONQUISTADOR, 79 (Obligado)",
			"estadoInformeId": 2,
			"estadoInformeLabel": "Desfavorable",
			"fechaAlta": "2017-01-09T23:00:00.000Z",
			"fechaInforme": "2017-01-09T23:00:00.000Z",
			"ieeArxiu": 1522,
			"ieeArxiuMime": "application/octet-stream",
			"inspeccionId": 1521,
			"inspeccionLabel": "1521",
			"lastModified": "2017-01-10T08:50:26.479Z",
			"modUser": "admin",
			"municipioId": 353,
			"municipioLabel": "BINISSALEM",
			"pdfArxiu": 1521,
			"pdfArxiuMime": "application/pdf",
			"primaryKey": 1521,
			"primaryLabel": "1521"
		}, {
			"clave": 1522,
			"creatorUser": "admin",
			"dateCreation": "2017-01-10T08:56:35.920Z",
			"edificioId": 706,
			"edificioLabel": "CONQUISTADOR, 79 (Obligado)",
			"estadoInformeId": 2,
			"estadoInformeLabel": "Desfavorable",
			"fechaAlta": "2017-01-09T23:00:00.000Z",
			"fechaInforme": "2017-01-09T23:00:00.000Z",
			"ieeArxiu": 1524,
			"ieeArxiuMime": "application/octet-stream",
			"inspeccionId": 1522,
			"inspeccionLabel": "1522",
			"lastModified": "2017-01-10T08:56:35.920Z",
			"modUser": "admin",
			"municipioId": 353,
			"municipioLabel": "BINISSALEM",
			"pdfArxiu": 1523,
			"pdfArxiuMime": "application/pdf",
			"primaryKey": 1522,
			"primaryLabel": "1522"
		}, {
			"clave": 1523,
			"creatorUser": "admin",
			"dateCreation": "2017-01-10T08:57:08.424Z",
			"edificioId": 706,
			"edificioLabel": "CONQUISTADOR, 79 (Obligado)",
			"estadoInformeId": 2,
			"estadoInformeLabel": "Desfavorable",
			"fechaAlta": "2017-01-09T23:00:00.000Z",
			"fechaInforme": "2017-01-09T23:00:00.000Z",
			"ieeArxiu": 1526,
			"ieeArxiuMime": "application/octet-stream",
			"inspeccionId": 1523,
			"inspeccionLabel": "1523",
			"lastModified": "2017-01-10T08:57:08.424Z",
			"modUser": "admin",
			"municipioId": 353,
			"municipioLabel": "BINISSALEM",
			"pdfArxiu": 1525,
			"pdfArxiuMime": "application/pdf",
			"primaryKey": 1523,
			"primaryLabel": "1523"
		}, {
			"clave": 1601,
			"creatorUser": "admin",
			"dateCreation": "2017-01-10T11:13:47.550Z",
			"edificioId": 706,
			"edificioLabel": "CONQUISTADOR, 79 (Obligado)",
			"estadoInformeId": 3,
			"estadoInformeLabel": "En tramitación",
			"fechaAlta": "2017-01-09T23:00:00.000Z",
			"fechaInforme": "2017-01-09T23:00:00.000Z",
			"ieeArxiu": 1582,
			"ieeArxiuMime": "application/octet-stream",
			"inspeccionId": 1601,
			"inspeccionLabel": "1601",
			"lastModified": "2017-01-10T11:13:47.550Z",
			"modUser": "admin",
			"municipioId": 353,
			"municipioLabel": "BINISSALEM",
			"pdfArxiu": 1581,
			"pdfArxiuMime": "application/pdf",
			"primaryKey": 1601,
			"primaryLabel": "1601"
		}, {
			"clave": 1603,
			"creatorUser": "admin",
			"dateCreation": "2017-01-10T11:24:58.788Z",
			"edificioId": 706,
			"edificioLabel": "CONQUISTADOR, 79 (Obligado)",
			"estadoInformeId": 5,
			"estadoInformeLabel": "En curso",
			"fechaAlta": "2017-01-09T23:00:00.000Z",
			"fechaInforme": "2017-01-09T23:00:00.000Z",
			"ieeArxiu": 1586,
			"ieeArxiuMime": "application/octet-stream",
			"inspeccionId": 1603,
			"inspeccionLabel": "1603",
			"lastModified": "2017-01-10T11:24:58.788Z",
			"modUser": "admin",
			"municipioId": 353,
			"municipioLabel": "BINISSALEM",
			"pdfArxiu": 1585,
			"pdfArxiuMime": "application/pdf",
			"primaryKey": 1603,
			"primaryLabel": "1603"
		}, {
			"clave": 1541,
			"creatorUser": "admin",
			"dateCreation": "2017-01-10T09:05:04.892Z",
			"edificioId": 706,
			"edificioLabel": "CONQUISTADOR, 79 (Obligado)",
			"estadoInformeId": 2,
			"estadoInformeLabel": "Desfavorable",
			"fechaAlta": "2017-01-09T23:00:00.000Z",
			"fechaInforme": "2017-01-09T23:00:00.000Z",
			"ieeArxiu": 1542,
			"ieeArxiuMime": "application/octet-stream",
			"inspeccionId": 1541,
			"inspeccionLabel": "1541",
			"lastModified": "2017-01-10T09:05:04.892Z",
			"modUser": "admin",
			"municipioId": 353,
			"municipioLabel": "BINISSALEM",
			"pdfArxiu": 1541,
			"pdfArxiuMime": "application/pdf",
			"primaryKey": 1541,
			"primaryLabel": "1541"
		}, {
			"clave": 1542,
			"creatorUser": "admin",
			"dateCreation": "2017-01-10T09:20:20.546Z",
			"edificioId": 706,
			"edificioLabel": "CONQUISTADOR, 79 (Obligado)",
			"estadoInformeId": 2,
			"estadoInformeLabel": "Desfavorable",
			"fechaAlta": "2017-01-09T23:00:00.000Z",
			"fechaInforme": "2017-01-09T23:00:00.000Z",
			"ieeArxiu": 1544,
			"ieeArxiuMime": "application/octet-stream",
			"inspeccionId": 1542,
			"inspeccionLabel": "1542",
			"lastModified": "2017-01-10T09:20:20.546Z",
			"modUser": "admin",
			"municipioId": 353,
			"municipioLabel": "BINISSALEM",
			"pdfArxiu": 1543,
			"pdfArxiuMime": "application/pdf",
			"primaryKey": 1542,
			"primaryLabel": "1542"
		}, {
			"clave": 1543,
			"creatorUser": "admin",
			"dateCreation": "2017-01-10T09:25:17.582Z",
			"edificioId": 706,
			"edificioLabel": "CONQUISTADOR, 79 (Obligado)",
			"estadoInformeId": 2,
			"estadoInformeLabel": "Desfavorable",
			"fechaAlta": "2017-01-09T23:00:00.000Z",
			"fechaInforme": "2017-01-09T23:00:00.000Z",
			"ieeArxiu": 1546,
			"ieeArxiuMime": "application/octet-stream",
			"inspeccionId": 1543,
			"inspeccionLabel": "1543",
			"lastModified": "2017-01-10T09:25:17.582Z",
			"modUser": "admin",
			"municipioId": 353,
			"municipioLabel": "BINISSALEM",
			"pdfArxiu": 1545,
			"pdfArxiuMime": "application/pdf",
			"primaryKey": 1543,
			"primaryLabel": "1543"
		}, {
			"clave": 1185,
			"creatorUser": "admin",
			"dateCreation": "2016-12-05T15:06:44.769Z",
			"edificioId": 706,
			"edificioLabel": "CONQUISTADOR, 79 (Obligado)",
			"estadoInformeId": 2,
			"estadoInformeLabel": "Desfavorable",
			"fechaAlta": "2016-12-04T23:00:00.000Z",
			"fechaInforme": "2016-12-04T23:00:00.000Z",
			"ieeArxiu": 1150,
			"ieeArxiuMime": "application/octet-stream",
			"inspeccionId": 1185,
			"inspeccionLabel": "1185",
			"lastModified": "2016-12-05T15:06:44.769Z",
			"modUser": "admin",
			"municipioId": 353,
			"municipioLabel": "BINISSALEM",
			"pdfArxiu": 1149,
			"pdfArxiuMime": "application/pdf",
			"primaryKey": 1185,
			"primaryLabel": "1185"
		}],
		"lastModified": "2016-12-05T13:56:42.859Z",
		"modUser": "admin",
		"municipioId": 353,
		"municipioLabel": "BINISSALEM",
		"numeroCatastro": "79",
		"numeroExtra": "Obligado",
		"primaryKey": 706,
		"primaryLabel": "CONQUISTADOR, 79 (Obligado)",
		"referenciaCatastral": "6928216DD8962N",
		"viaId": 3639,
		"viaLabel": "CONQUISTADOR",
		"id": "extModel224-2"
	}, {
		"antiguedad": 0,
		"centroX": 486776,
		"centroY": 4392639,
		"clave": 861,
		"creatorUser": "admin",
		"dateCreation": "2016-12-05T13:56:42.859Z",
		"informes": [{
			"clave": 1501,
			"creatorUser": "admin",
			"dateCreation": "2017-01-10T08:12:57.222Z",
			"edificioId": 861,
			"edificioLabel": "CONQUISTADOR, 79",
			"estadoInformeId": 2,
			"estadoInformeLabel": "Desfavorable",
			"fechaAlta": "2017-01-09T23:00:00.000Z",
			"fechaInforme": "2017-01-09T23:00:00.000Z",
			"ieeArxiu": 1502,
			"ieeArxiuMime": "application/octet-stream",
			"inspeccionId": 1501,
			"inspeccionLabel": "1501",
			"lastModified": "2017-01-10T08:12:57.222Z",
			"modUser": "admin",
			"municipioId": 353,
			"municipioLabel": "BINISSALEM",
			"pdfArxiu": 1501,
			"pdfArxiuMime": "application/pdf",
			"primaryKey": 1501,
			"primaryLabel": "1501"
		}],
		"lastModified": "2016-12-05T13:56:42.859Z",
		"modUser": "admin",
		"municipioId": 353,
		"municipioLabel": "BINISSALEM",
		"numeroCatastro": "79",
		"numeroExtra": null,
		"primaryKey": 861,
		"primaryLabel": "CONQUISTADOR, 79",
		"referenciaCatastral": "6928216DD8962N",
		"viaId": 3639,
		"viaLabel": "CONQUISTADOR",
		"id": "extModel224-3"
	}, {
		"antiguedad": 0,
		"centroX": 486776,
		"centroY": 4392639,
		"clave": 663,
		"creatorUser": "admin",
		"dateCreation": "2016-12-05T13:56:42.859Z",
		"informes": [],
		"lastModified": "2016-12-05T13:56:42.859Z",
		"modUser": "admin",
		"municipioId": 353,
		"municipioLabel": "BINISSALEM",
		"numeroCatastro": "79",
		"numeroExtra": null,
		"primaryKey": 663,
		"primaryLabel": "CONQUISTADOR, 79",
		"referenciaCatastral": "6928216DD8962N",
		"viaId": 3639,
		"viaLabel": "CONQUISTADOR",
		"id": "extModel224-4"
	}, {
		"antiguedad": 0,
		"centroX": 486776,
		"centroY": 4392639,
		"clave": 664,
		"creatorUser": "admin",
		"dateCreation": "2016-12-05T13:56:42.859Z",
		"informes": [{
			"clave": 1143,
			"creatorUser": "admin",
			"dateCreation": "2016-12-05T13:56:39.777Z",
			"edificioId": 664,
			"edificioLabel": "CONQUISTADOR, 79",
			"estadoInformeId": 2,
			"estadoInformeLabel": "Desfavorable",
			"fechaAlta": "2016-12-04T23:00:00.000Z",
			"fechaInforme": "2016-12-04T23:00:00.000Z",
			"ieeArxiu": 1106,
			"ieeArxiuMime": "application/octet-stream",
			"inspeccionId": 1143,
			"inspeccionLabel": "1143",
			"lastModified": "2016-12-05T13:56:39.777Z",
			"modUser": "admin",
			"municipioId": 353,
			"municipioLabel": "BINISSALEM",
			"pdfArxiu": 1105,
			"pdfArxiuMime": "application/pdf",
			"primaryKey": 1143,
			"primaryLabel": "1143"
		}],
		"lastModified": "2016-12-05T13:56:42.859Z",
		"modUser": "admin",
		"municipioId": 353,
		"municipioLabel": "BINISSALEM",
		"numeroCatastro": "79",
		"numeroExtra": null,
		"primaryKey": 664,
		"primaryLabel": "CONQUISTADOR, 79",
		"referenciaCatastral": "6928216DD8962N",
		"viaId": 3639,
		"viaLabel": "CONQUISTADOR",
		"id": "extModel224-5"
	}, {
		"antiguedad": 0,
		"centroX": 486776,
		"centroY": 4392639,
		"clave": 862,
		"creatorUser": "admin",
		"dateCreation": "2016-12-05T13:56:42.859Z",
		"informes": [{
			"clave": 1524,
			"creatorUser": "admin",
			"dateCreation": "2017-01-10T08:58:36.450Z",
			"edificioId": 862,
			"edificioLabel": "CONQUISTADOR, 79",
			"estadoInformeId": 4,
			"estadoInformeLabel": "Anulado",
			"fechaAlta": "2017-01-09T23:00:00.000Z",
			"fechaInforme": "2017-01-09T23:00:00.000Z",
			"ieeArxiu": 1528,
			"ieeArxiuMime": "application/octet-stream",
			"inspeccionId": 1524,
			"inspeccionLabel": "1524",
			"lastModified": "2017-01-10T09:01:57.527Z",
			"modUser": "admin",
			"municipioId": 353,
			"municipioLabel": "BINISSALEM",
			"pdfArxiu": 1527,
			"pdfArxiuMime": "application/pdf",
			"primaryKey": 1524,
			"primaryLabel": "1524"
		}],
		"lastModified": "2016-12-05T13:56:42.859Z",
		"modUser": "admin",
		"municipioId": 353,
		"municipioLabel": "BINISSALEM",
		"numeroCatastro": "79",
		"numeroExtra": null,
		"primaryKey": 862,
		"primaryLabel": "CONQUISTADOR, 79",
		"referenciaCatastral": "6928216DD8962N",
		"viaId": 3639,
		"viaLabel": "CONQUISTADOR",
		"id": "extModel224-6"
	}, {
		"antiguedad": 0,
		"centroX": 486776,
		"centroY": 4392639,
		"clave": 881,
		"creatorUser": "admin",
		"dateCreation": "2016-12-05T13:56:42.859Z",
		"informes": [{
			"clave": 1545,
			"creatorUser": "admin",
			"dateCreation": "2017-01-10T09:29:05.151Z",
			"edificioId": 881,
			"edificioLabel": "CONQUISTADOR, 79 (Obligado)",
			"estadoInformeId": 2,
			"estadoInformeLabel": "Desfavorable",
			"fechaAlta": "2017-01-09T23:00:00.000Z",
			"fechaInforme": "2017-01-09T23:00:00.000Z",
			"ieeArxiu": 1550,
			"ieeArxiuMime": "application/octet-stream",
			"inspeccionId": 1545,
			"inspeccionLabel": "1545",
			"lastModified": "2017-01-10T09:29:05.151Z",
			"modUser": "admin",
			"municipioId": 353,
			"municipioLabel": "BINISSALEM",
			"pdfArxiu": 1549,
			"pdfArxiuMime": "application/pdf",
			"primaryKey": 1545,
			"primaryLabel": "1545"
		}],
		"lastModified": "2016-12-05T13:56:42.859Z",
		"modUser": "admin",
		"municipioId": 353,
		"municipioLabel": "BINISSALEM",
		"numeroCatastro": "79",
		"numeroExtra": "Obligado",
		"primaryKey": 881,
		"primaryLabel": "CONQUISTADOR, 79 (Obligado)",
		"referenciaCatastral": "6928216DD8962N",
		"viaId": 3639,
		"viaLabel": "CONQUISTADOR",
		"id": "extModel224-7"
	}],
	"errorHtml": null,
	"errorMsg": null,
	"estadoInformeDisponibles": [{
		"clave": 3,
		"creatorUser": null,
		"dateCreation": "2016-10-10T13:15:23.000Z",
		"lastModified": "2016-10-10T13:15:23.000Z",
		"modUser": null,
		"nombreCa": "En tramitació",
		"nombreEs": "En tramitación",
		"primaryKey": 3,
		"primaryLabel": "En tramitación",
		"id": "extModel222-1"
	}, {
		"clave": 2,
		"creatorUser": null,
		"dateCreation": "2016-10-10T13:15:23.000Z",
		"lastModified": "2016-10-10T13:15:23.000Z",
		"modUser": null,
		"nombreCa": "Desfavorable",
		"nombreEs": "Desfavorable",
		"primaryKey": 2,
		"primaryLabel": "Desfavorable",
		"id": "extModel222-2"
	}],
	"estadoInformeId": 5,
	"estadoInformeLabel": "En curso",
	"lastModified": null,
	"modUser": null,
	"primaryKey": 1607,
	"primaryLabel": "En curso"
}
