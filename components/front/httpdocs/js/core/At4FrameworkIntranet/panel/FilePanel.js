 // Namespace de At4FrameworkIntranet
Ext.namespace('At4FrameworkIntranet');

Ext.define("At4FrameworkIntranet.FilePanel", {
	extend: "Ext.form.FieldSet",
	width: 320,
	xtype: "at4-filepanel",
	style: 'margin-top: 20px',
	collapsible: false,
	disableUpload: false,
	disableDownlowd: false,
	disableDelete: false,

	mostrarDescargar: function(mostrar){
		if(mostrar && !this.disableDownlowd){
			this.descarregarArxiu.setVisible(true);
		}else{
			this.descarregarArxiu.setVisible(false);
		}
	},

	mostrarEliminar: function(mostrar){
		if(mostrar && !this.disableDelete){
				this.eliminarArxiu.setVisible(true);
		}else{
			this.eliminarArxiu.setVisible(false);
		}
	},
	mostrarEnviar: function(mostrar){
		if(mostrar && !this.disableUpload){
			this.afegirArxiuBoto.uploadButton.setVisible(true);
		}else{
			this.afegirArxiuBoto.uploadButton.setVisible(false);
		}
	},




	/**
	 * @class At4FrameworkIntranet.FilePanel
	 * Clase de panel de archivo descargable
	 * @extends-ext Ext.Panel
	 * @author agarcia
	 * @constructor
	 *
	 * @param {At4FrameworkIntranet.BasicForm} parentFormPanel Formulario contenedor
	 * @param {Object} config
	 */
	constructor: function (parentFormPanel, config) {
		//console.log("Se esta creando un FilePanel");
		Ext.apply(this, config);
		this.parentFormPanel = parentFormPanel;
		//Necesitamos saber si se trata de un subform
		/*
		if (parentFormPanel.subFormName) {
			this.inSubForm = true;
		} else {
			this.inSubForm = false;
		}*/
		//TOOD: garrom: Asi mejor?
		this.inSubForm = (!!parentFormPanel.subFormName);
		//Botón para descargar archivo
		this.descarregarArxiu = new Ext.Button({
			style: 'margin: 0 5px 0 5px',
			text: this.descargarArchivoTxt,
			hidden: true,
			disabled: this.disableDownlowd,
			//cls: "at4-download",
			tabIndex: this.tabIndex + 20,
			handler: function () {

				//Construcción del formulario para descargar el pdf
				var form = Ext.DomHelper.append(document.body, {
					tag: 'form',
					method: 'post',
					action: this.urlDescarga,
					target: this.id
				});

				var claveObjecte = document.createElement('input');
				claveObjecte.type = 'hidden';
				claveObjecte.name = 'objectId';
				claveObjecte.value = this.parentFormPanel.dataId;
				form.appendChild(claveObjecte);

				// añadimos el nombre con el que se descargarán los ficheros
				var docname = document.createElement('input');
				docname.type = 'hidden';
				docname.name = 'docname';
				docname.value = this.docname;
				form.appendChild(docname);

				// Si es una imagen, añadimos el modo inline
				if (this.isImage) {
					var modeinline = document.createElement('input');
					modeinline.type = 'hidden';
					modeinline.name = 'mode';
					modeinline.value = 'inline';
					form.appendChild(modeinline);
				}

				form.submit();

			},
			scope: this
		});

		//Botón para eliminar archivo
		this.eliminarArxiu = new Ext.Button({
			style: 'margin: 0 5px 0 5px',
			text: this.eliminarArchivoTxt,
			hidden: true,
			disabled: this.disableDelete,
			tabIndex: this.tabIndex + 30,
			handler: function () {

				Ext.Msg.show({
					title: this.eliminarArchivoInformacionTxt,
					msg: this.eliminarArchivoConfirmacionTxt,
					icon: Ext.Msg.QUESTION,
					buttons: Ext.Msg.YESNO,
					scope: this,
					fn: function (response) {
						if ('yes' !== response) {
							return;
						}

						serverDatabaseActions.runAction(
							FormDataService.eliminarDocumento, [this.docname, this.parentFormPanel.dataId],
							function (data) {
								if (data.correcto) {
									if (this.isImage) {
										this.imagePreview.setVisible(false);
									} else {
										Ext.MessageBox.alert(this.eliminarArchivoInformacionTxt,
											this.eliminarArchivoCorrectoTxt);
									}
									this.mostrarDescargar(false);
									this.mostrarEliminar(false);
									if (this.inSubForm) {
										this.parentFormPanel.parentPanel.onUpdateRecordDone(this.parentFormPanel, data.updatedElement, this.parentFormPanel.currentRecord);
									}

								} else {
									Ext.Msg.show({
										title: this.eliminarArchivoErrorTxt,
										msg: data.message,
										buttons: Ext.Msg.OK,
										icon: Ext.MessageBox.ERROR
									});
								}
							},
							serverDatabaseActions.exceptionHandler,
							this
						)
					}
				});
			},
			scope: this
		});

		//Botón para subir archivo
		this.afegirArxiuBoto = new Ext.enableDWRUploadFile({
			style: 'padding: 0px 0px 7px 0px; margin: 0 5px 0 5px',
			name: 'arxiu',
			buttonText: this.subirArchivoTxt,
			buttonIcon: '',
			tabIndex: this.tabIndex + 10,
			check: function () {
				return true;
			},
			submit: function () {

				//obtenemos el objeto que contiene el file, y después obtenemos el valor del file usando el id generado para el objeto contenedor
				//var fileAux = this.afegirArxiuBoto.getFileInput();
				//var file = dwr.util.getValue(fileAux.id);
				var file = this.afegirArxiuBoto.getFileInput();

				console.log(file.value);
				serverDatabaseActions.runAction(
					FormDataService.guardarDocumento, [this.docname, file, this.parentFormPanel.dataId],
					function (data) {
						if (data.correcto) {
							this.mostrarDescargar(true);
							if (this.isImage) {
								this.imagePreview.doPreview();
							} else {
								Ext.MessageBox.alert(this.subirArchivoInformacionTxt, this.subirArchivoCorrectoTxt);
							}
							this.mostrarEliminar(true);
							if (this.inSubForm) {
								this.parentFormPanel.parentPanel.onUpdateRecordDone(this.parentFormPanel, data.updatedElement, this.parentFormPanel.currentRecord);
							}
							if (data.warnings.length > 0) {
								for (i in data.warnings) {
									if (data.warnings.hasOwnProperty(i)) {
										Ext.toast({
											html: data.warnings[i],
											header: false,
											autoCloseDelay: 5000,
											align: "bl"
										});
									}

								}
							}

						} else {
							Ext.Msg.show({
								title: this.subirArchivoErrorTxt,
								msg: data.message,
								buttons: Ext.Msg.OK,
								icon: Ext.MessageBox.ERROR
							});
						}
					},
					serverDatabaseActions.exceptionHandler,
					this
				)

				//}.createDelegate(this)
			}.bind(this)
		});

		var parentItems = [];

		/*this.dataConstrains = new Ext.form.field.Display({
			value: "",
			border: 0,
			minHeight: 0,
			editable: false,
		});
		this.dataConstrains = new Ext.container.Container({
			value: "",
			border: 0,
			minHeight: 0,
			editable: false,
		});*/
		this.dataConstrains = new Ext.Component({
			value: "",
			border: 0,
			minHeight: 0,
			editable: false,
		});

		if (this.isImage) {
			this.imagePreview = new Ext.Img({
				style: 'max-height: 99%; max-width:99%; border:1px solid black; margin-bottom: 5px',
				doPreview: function () {

					//Construcción del formulario para descargar el pdf
					var url = this.urlDescarga;
					url += '?objectId=' + this.parentFormPanel.dataId;
					url += '&docname=' + this.docname;
					url += '&mode=inline';
					url += '&random=' + Math.random();
					this.imagePreview.setSrc(url);
					this.imagePreview.setVisible(true);
				}.bind(this),
				//Este listener lo que hace es forzar la recalculacion de tamaños al padre, sin esto, hara overflow al cargar la imagen
				listeners: {
					load: {
						element: 'el', //the rendered img element
						scope: this,
						fn: function () {
							if (this.imagePreview.src) {
								//console.log("img loaded");
								//console.log("Tiempo de carga = " + (new Date() - startingLoad));
								this.parentFormPanel.doLayout();
							}
						}
					}
				}
			});
			parentItems.push({
				xtype: "container",
				style: "text-align: center",
				items: [this.imagePreview]
			});
		}

		this.infoConstrains = new Ext.Button({
			name: this.fieldName,
			text: this.comprobarConstrainsTxt,
			buttonIcon: '',
			parentFormPanel: parentFormPanel,
			constrainsModel: this.constrainsModel,
			tabIndex: this.tabIndex + 40,
			disabled: false,
			hidden: !!this.disableConstrains,
			scope: this,
			handler: this.onInfoConstrainsClick,
		});

		parentItems = parentItems.concat([{
			xtype: "container",
			layout: "hbox",
			margin: "5px 0 5px 0",
			width: "100%",
			defaults: {
				width: "33%"
			},
			items: [this.afegirArxiuBoto.uploadButton, this.descarregarArxiu, this.eliminarArxiu]
		}, {
			xtype: "container",
			margin: "10px 0 10px 0",
			items: [this.infoConstrains]
		}, {
			xtype: "container",
			minHeight: 0,
			height: "auto",
			items: [this.dataConstrains]
		}])

		this.callParent([{
			xtype: 'fieldset',
			style: "margin-top: 0 ;",
			padding: 15,
			title: this.titleTxt,
			border: true,
			labelAlign: "top",
			autoHeight: true,
			hidden: true,
			items: parentItems
		}]);

		config.listeners = {
			//'afterload'	:this.afterLoadRecord.createDelegate(this)
			//,'afteremptyform' : this.afterEmptyForm.createDelegate(this)
			afterload: Ext.bind(this.afterLoadRecord, this),
			afteremptyform: Ext.bind(this.afteremptyform, this)
		}
		this.mostrarDescargar(true);
		this.mostrarEliminar(true);
		this.mostrarEnviar(true);

	},
	/** Nombre del formulario que trata la subida y descarga
	 * @type {String}
	 */
	docname: null

	/** Título del panel
	 * @type {String}
	 */
	,
	titleTxt: 'Archivo'

	/** Etiqueta de texto
	 * @type {String}
	 */
	,
	descargarArchivoTxt: 'Descargar'

	/** Etiqueta de texto
	 * @type {String}
	 */
	,
	eliminarArchivoTxt: 'Eliminar'

	/** Etiqueta de texto
	 * @type {String}
	 */
	,
	eliminarArchivoInformacionTxt: 'Información'

	/** Etiqueta de texto
	 * @type {String}
	 */
	,
	eliminarArchivoConfirmacionTxt: '¿Eliminar archivo?<br\/>Esta acción no se puede deshacer.'

	/** Etiqueta de texto
	 * @type {String}
	 */
	,
	eliminarArchivoCorrectoTxt: 'Archivo eliminado correctamente.'

	/** Etiqueta de texto
	 * @type {String}
	 */
	,
	eliminarArchivoErrorTxt: 'Error eliminando archivo.'

	/** Etiqueta de texto
	 * @type {String}
	 */
	,
	subirArchivoTxt: 'Añadir'

	/** Etiqueta de texto
	 * @type {String}
	 */
	,
	subirArchivoInformacionTxt: 'Información'

	/** Etiqueta de texto
	 * @type {String}
	 */
	,
	subirArchivoCorrectoTxt: 'Archivo añadido correctamente'

	/** Etiqueta de texto
	 * @type {String}
	 */
	,
	subirArchivoErrorTxt: 'Error añadiendo archivo'


	/** url de descarga de archivos
	 * @type {String}
	 */
	,
	urlDescarga: './export/descarregar'

	/** Nombre del campo donde está el archivo
	 * @type {String}
	 */
	,
	fieldName: null

	/**
	 * Indica que se trate el archivo como una imagen
	 */
	,
	isImage: false

	,
	afterEmptyForm: function (record) {

		this.setVisible(false);
		this.mostrarDescargar(false);
		this.mostrarEliminar(false);
	}

	,
	afterLoadRecord: function (dataId, record) {

		var canDelete = false;
		var canUpdate = false;
		//console.log(this,this.inSubForm);
		if (this.inSubForm) {
			//record = dataId;
			dataId = record.data.oid;
			canDelete = this.parentFormPanel.editable;
			canUpdate = this.parentFormPanel.editable;
		} else {
			canDelete = record.canUpdate; //Si se puede actualizar el formulario, entonces se puede eliminar el archivo
			canUpdate = record.canUpdate;
		}

		var algoVisible = false;
		if (record.data[this.fieldName] != null &&
			record.data[this.fieldName] != "") {
			if (canDelete) {
				this.mostrarEliminar(true);
			} else {
				this.mostrarEliminar(false);
			}
			if (canUpdate) {
				this.mostrarEnviar(true)
			} else {
				this.mostrarEnviar(false)
			}
			this.descarregarArxiu.setVisible(true);
			if (this.canDownload) {
				this.descarregarArxiu.enable();
			}
			if (this.isImage) {
				this.imagePreview.doPreview();
			}
			algoVisible = true;
		} else {
			this.descarregarArxiu.setVisible(false);
			this.mostrarEliminar(false);
			if (this.isImage) {
				this.imagePreview.setVisible(false);
			}
			if (canUpdate) {
				this.mostrarEnviar(true)
				algoVisible = true;
			} else {
				this.mostrarEnviar(false)
			}
		}

		if (dataId && algoVisible) {
			this.setVisible(true);
		}


	},
	/**
	 *
	 * Override para hacer compatible esto con QTIP
	 */
	createTitleCmp: function () {
		var me = this,
			cfg = {
				xtype: 'component',
				html: me.title,
				ui: me.ui,
				cls: me.baseCls + '-header-text',
				id: me.id + '-legendTitle'
			};

		if (me.collapsible && me.toggleOnTitleClick) {
			cfg.listeners = {
				click: {
					element: 'el',
					scope: me,
					fn: me.toggle
				}
			};
			cfg.cls += ' ' + me.baseCls + '-header-text-collapsible';
		}
		///garrom: Añade el qtip en el header
		if (!cfg.listeners) {
			cfg.listeners = {};
		}
		if (me.qtip) {
			cfg.listeners["afterrender"] = {
				//element: 'el',
				scope: me,
				fn: function (el, opts) {
					el.getEl().set({
						"data-qtip": this.qtip
					})
				}
			}
		}
		//garrom: fin
		return (me.titleCmp = Ext.widget(cfg));
	},

	initEvents: function () {
		At4FrameworkIntranet.FilePanel.superclass.initEvents.call(this);
		//this.parentFormPanel.addListener('afterload', this.afterLoadRecord.createDelegate(this));
		this.parentFormPanel.addListener('afterload', this.afterLoadRecord.bind(this));
		//		this.parentFormPanel.addListener('afteremptyform', this.afterEmptyForm.createDelegate(this));
		this.parentFormPanel.addListener('afteremptyform', this.afterEmptyForm.bind(this));
	},
	showConstrainMessage: function (data, isRaw) {
		var html = "";
		if (isRaw) {
			//this.dataConstrains.update(data);
			html = data;
		} else {
			if (this.isImage) {
				html = At4util.formatConstrains(data);
			} else {
				html = At4util.formatFileConstrains(data);
			}
		}
		//this.getSizeModel().height.shrinkWrap = false;
		this.dataConstrains.update(html);

	},

	onInfoConstrainsClick: function (btn, eopts) {
		var partFormName = btn.parentFormPanel.formName ? btn.parentFormPanel.formName : btn.parentFormPanel.subFormName;
		// var formItem = partFormName + "-" + btn.name;
		var formItem;

		if (this.formItem) {
			formItem = this.formItem;
		} else {
			Ext.log.warn("No formItem set, using docname.")
			formItem = this.docname;
		}
		var cached = At4FrameworkIntranet.app.cache.constrains[formItem];
		if (cached && (new Date() - cached.date < 7200000)) {
			this.showConstrainMessage(cached.data);
		} else {
			this.showConstrainMessage(this.cargandoConstrainsTxt, true);
			var fn = this.isImage ? "obtenerConstraints" : "obtenerFileConstraints";
			serverDatabaseActions.runSilentAction(FormDataService[fn], [formItem], function (response) {
				var obj = {
					data: response,
					date: new Date()
				}
				At4FrameworkIntranet.app.cache.constrains[this.formItem] = obj;
				this.scope.showConstrainMessage(obj.data);
			}.bind({
				formItem: formItem,
				scope: this
			}), function () {
				this.scope.showConstrainMessage(this.scope.errorConstrainsTxt, true);
			}.bind({
				formItem: formItem,
				scope: this
			}));
		}

	}

});
