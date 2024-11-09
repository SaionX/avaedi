// Namespace de At4FrameworkIntranet
Ext.namespace('At4FrameworkIntranet');

//Ext.extend(At4FrameworkIntranet.BaseEditorGridPanel, Ext.grid.EditorGridPanel, {
Ext.define("At4FrameworkIntranet.BaseEditorGridPanel", {
	extend: "Ext.grid.Panel",
	/**
	 * @class At4FrameworkIntranet.BasicPanel
	 * Clase base de paneles de subformularios de At4Framework
	 * @extends-ext At4FrameworkIntranet.BaseEditorGridPanel 
	 * @author dsanchez
	 * @constructor
	 * 
	 * @param {At4FrameworkIntranet.BasicForm} parentFormPanel Formulario contenedor
	 * @param {Object} config
	 */
	constructor: function(parentFormPanel, config) {
		console.log("Se esta creando un BaseEditorGridPanel");
		Ext.apply(this, config);

		this.filterListeners = {
			activate: this.onActivateFilter,
			deactivate: this.onDeactivateFilter,
			scope: this
		};

		this.addEvents({
			/**
			 * @event afterload Se dispara tras cargar los datos del grid
			 * @param {BaseEditorGridPanel} grid grid
			 * @param {Array} data Vector de registros a cargar
			 */
			'afterload': true
		});


		if (this.filteroptions && this.filteroptions.filters) {

			for (var i in this.filteroptions.filters) {
				this.filteroptions.filters[i].listeners = this.filterListeners;
			}

			this.filteroptions.stateId = this.getId() + "-filterState";

			// Ñapa para mantener los filtros, ya que GridFilters hace delete de filteroptions.filters.
			var tempfilters = this.filteroptions.filters;

			this.filters = new Ext.ux.grid.GridFilters(this.filteroptions);

			this.filteroptions.filters = tempfilters;

			this.plugins.push(this.filters);
		}

		this.parentFormPanel = parentFormPanel;

		if (this.deferredLoad) {
			this.dataLoaded = false;
		} else {
			this.dataLoaded = true;
		}

		this.isActiveTab = false;

		/*Acceso a la barra de estado. Usamos la barra de estado general de la aplicación
		 */
		this.statusBar = Ext.getCmp('At4Framework-status');

		//TODO: addEnabled
		var addEnabled = true;

		this.reader = new Ext.data.JsonReader({
			totalProperty: "totalNumRecords",
			rootProperty: "resultados"
		}, this.dataRecord);


		var storeConfig = {
			remoteSort: false,
			reader: this.reader
		};

		// Si nos viene definido el store lo utilizamos.
		if (!config.hasOwnProperty('store')) {
			this.store = new Ext.data.Store(storeConfig);
			//this.store.load();
		}

		if (this.editForm) {
			this.formWindow = new Ext.Window({
				title: this.editarTxt,
				closable: true,
				modal: true,
				closeAction: 'hide',
				width: this.windowWidth,
				height: this.windowHeight,
				deferredRender: false,
				//border:false,
				plain: true,
				layout: 'fit',
				items: [this.editForm]
			});
			this.editForm.setParentPanel(this);
			Ext.EventManager.onWindowResize(At4FrameworkIntranet.resizeFormWindow, this);
			this.formWindow.on('show', At4FrameworkIntranet.resizeFormWindow, this);
		}



		this.newButton = new Ext.Button({
			id: this.getId() + '-newButton',
			text: this.nuevoTxt,
			iconCls: At4util.icons.add,
			scope: this,
			disabled: !addEnabled,
			hidden: !this.showNewButton,
			style: 'margin: 0px 5px 0px 10px;',
			handler: function() {
				this.formWindow.show();
				this.editForm.emptyForm();
			}
		});

		this.editButton = new Ext.Button({
			id: this.getId() + '-editButton',
			text: this.editarTxt,
			iconCls: At4util.icons.editar,
			scope: this,
			disabled: true,
			hidden: !this.showEditButton,
			style: 'margin: 0px 5px 0px 10px;',
			handler: function() {
				var record = this.getSelectionModel().getSelected();
				if (!record) {
					this.disableRecordEdit();
					return;
				}
				this.formWindow.show();
				this.editForm.loadData(record);
			}
		});

		this.saveButton = new Ext.Button({
			id: this.getId() + '-saveButton',
			text: "Guardar", //LOCALE
			iconCls: 'icon-disk',
			scope: this,
			disabled: false,
			hidden: !this.showSaveButton,
			style: 'margin: 0px 5px 0px 10px;',
			handler: function() {
				this.getStore().commitChanges();
			}
		});

		//this.expandAllButton = new Ext.Button();

		this.clearFiltersButton = new Ext.Button({
			id: this.getId() + '-clearFiltersButton',
			text: "Netejar filtres",
			iconCls: 'icon-filter-out',
			scope: this,
			disabled: false,
			hidden: true,
			style: 'margin: 0px 5px 0px 10px;',
			handler: function() {
				if (this.filters) {
					this.filters.clearFilters();
				}
			}
		});


		this.getStore().on('update', function(store, record, operation) {

			if (operation == Ext.data.Record.COMMIT) {

				if (record.data.oid) {

					if (this.parentFormPanel.application.formName != null) {

						serverDatabaseActions.runAction(
							FormDataService.updateSubForm, [this.parentFormPanel.formName, this.parentFormPanel.dataId, this.subFormName, record.data.oid, record.data],
							this.afterUpdateForm,
							this.afterUpdateError,
							this
						);

					} else { //es tracta d'un subform anidat

						serverDatabaseActions.runAction(
							FormDataService.updateSubForm, [this.parentFormPanel.formName, this.parentFormPanel.dataId, this.subFormName, record.data.oid, record.data],
							this.afterUpdateForm,
							this.afterUpdateError,
							this
						);
					}
				} else {

					if (this.parentFormPanel.application.formName != null) {

						serverDatabaseActions.runAction(
							FormDataService.addSubForm, [this.parentFormPanel.formName, this.parentFormPanel.dataId, this.subFormName, record.data],
							this.afterUpdateForm,
							this.afterUpdateError,
							this
						);

					} else { //es tracta d'un subform anidat

						serverDatabaseActions.runAction(
							FormDataService.addSubForm, [this.parentFormPanel.subFormName, this.parentFormPanel.dataId, this.subFormName, record.data],
							this.afterUpdateForm,
							this.afterUpdateError,
							this
						);

					}

				}

			}
		}.createDelegate(this));

		this.afterUpdateForm = function(form, action) {

			//var record = this.parentPanel.onUpdateRecordDone(this, action.result.updatedElement, this.currentRecord);

			//this.onUpdateRecordDone(this, action.result.updatedElement, this.currentRecord);
			//notificamos en barra de estado
			this.statusBar.setStatus({
				text: this.actualizadoTxt,
				clear: true // auto-clear after a set interval
			});

			//this.loadData(record);
			//this.parentPanel.closeForm();
		};

		this.afterUpdateError = function(form, data) {

			if (data.result && data.result.correcto) {
				Ext.Msg.alert('<spring:message code="forms.general.success" javaScriptEscape="true"/>', data.result.message);
			} else {
				if (data.result) {
					Ext.Msg.alert('<spring:message code="forms.general.error" javaScriptEscape="true"/>', data.result.message);
				} else {
					Ext.Msg.alert('<spring:message code="forms.general.error" javaScriptEscape="true"/>', "Error desconocido");
				}
			}

		}

		this.afterInsertForm = function(form, action) {
			//Cargamos los datos recién insertados
			//var rowid = action.result.addedElementKeys[0];
			//Notificamos a la aplicación de la inserción del nuevo registro
			//this.parentPanel.onNewRecordDone(this, action.result.updatedElement);
			//notificamos en barra de estado
			this.statusBar.setStatus({
				text: this.anyadidoTxt,
				clear: true // auto-clear after a set interval
			});
			//this.parentPanel.closeForm();
		}

		this.afterInsertFailureForm = function(form, data) {
			if (data.result != null && data.result.correcto) {
				Ext.Msg.alert('<spring:message code="forms.general.success" javaScriptEscape="true"/>', data.result.message);
			} else if (data.result != null) {
				Ext.Msg.alert('<spring:message code="forms.general.error" javaScriptEscape="true"/>', data.result.message);
			}
		}

		this.doDeleteRow = function() {
			Ext.Msg.show({
				title: this.borrarRegistroTxt,
				msg: this.seguroTxt,
				icon: Ext.Msg.QUESTION,
				buttons: Ext.Msg.YESNO,
				scope: this,
				fn: function(response) {
					if ('yes' !== response) {
						return;
					}

					//var records = this.dataView.getSelectedRecords();
					var records = this.getSelectionModel().getSelections();

					var dataId = records[0].data.oid;
					var formName = null;
					var parentId = null;
					if (this.formName) {

						formName = this.formName;
						parentId = records[0].data[this.subFormIdName];

					} else if (this.parentFormPanel.formName) {

						formName = this.parentFormPanel.formName;
						parentId = this.parentFormPanel.dataId;

					} else {

						formName = this.parentFormPanel.subFormName;
						parentId = this.parentFormPanel.dataId;

					}

					serverDatabaseActions.runAction(
						FormDataService.deleteSubForm, [
							formName,
							parentId,
							this.editForm.subFormName,
							dataId
						],
						this.afterDeleteForm,
						serverDatabaseActions.exceptionHandler,
						this
					)
				}
			});
		}.createDelegate(this);

		this.deleteButton = new Ext.Button({
			id: this.getId() + '-deleteButton',
			text: this.borrarTxt,
			iconCls: At4util.icons.remove,
			scope: this,
			disabled: true,
			hidden: !this.showDeleteButton,
			style: 'margin: 0px 5px 0px 10px;',
			handler: function() {
				this.doDeleteRow();
			}
		});

		var viewConfig = {};
		if (this.viewConfig) {
			viewConfig = this.viewConfig;
		}
		viewConfig.forceFit = true;

		var allButtons = [
			this.newButton,
			this.editButton,
			this.deleteButton,
			this.saveButton,
			//this.expandAllButton,
			this.clearFiltersButton
		].concat(this.extraButtons);


		//At4FrameworkIntranet.BaseEditorGridPanel.superclass.constructor.call(this, {
		this.callParent(this, {

			/*store: new Ext.data.Store({
	        reader: reader,
	        data: xg.dummyData
	    }),*/

			viewConfig: viewConfig,

			sm: new Ext.grid.RowSelectionModel({
				singleSelect: true
			}),
			/*width:600,
			height:300,
			frame:true,*/
			//title:'Framed with Checkbox Selection and Horizontal Scrolling',
			//iconCls:'icon-grid',

			deferredRender: false,

			// Mostramos la barra de botones por defecto si no nos viene definida.
			tbar: config.hasOwnProperty("tbar") ? config.tbar : new Ext.Toolbar({
				id: this.getId() + '-toolbar',
				hidden: false,
				items: allButtons
			}),

			listeners: config.hasOwnProperty("listeners") ? config.listeners : {

				/*
				'rowdblclick': {
					fn: function(grid, rowIndex, event) {
						var record = grid.getStore().getAt(rowIndex); 
						if (record) {
							this.formWindow.show();
							this.editForm.loadData(record);
						}
					}
				},
				*/

				// NOTA: queremos que por defecto estén desactivados los paneles multiform, sin embargo
				// hacerlo con disabled:true, hace que no se renderizen correctamente, por lo que añadimos
				// el evento afterlayout para que se desactiven automáticamente tras renderizarse.
				'afterlayout': {
					fn: function(p) {
						p.disable();
					},
					single: true // important, as many layouts can occur
				},

				// En paneles con modo de carga de datos 'deferred', ésta se ejecutará cuando
				// se active el panel. 
				'activate': {
					fn: function(p) {
						p.isActiveTab = true;
						if (p.parentFormPanel.dataId && p.deferredLoad && !p.dataLoaded) {
							//Hay registro cargado en el form principal y el panel tiene carga diferida
							p.parentFormPanel.loadSubpanelData(p.parentFormPanel.dataId, p.name);
							p.dataLoaded = true;
						}

					}
				},
				'deactivate': {
					fn: function(p) {
						p.isActiveTab = false;
					}
				}
			}
		});

		//var that = this;
		this.getSelectionModel().on('rowselect', function(rownIndex, record) {
			this.enableRecordEdit();
		}.createDelegate(this));
		this.getSelectionModel().on('rowdeselect', function(rownIndex, record) {
			this.disableRecordEdit();
		}.createDelegate(this));

		if (this.filters) {
			this.filters.clearFilters();
		}
	},
	filters: null,
	filteroptions: null,
	activeFilterCount: 0,
	onActivateFilter: function() {
		this.activeFilterCount++;
		this.filterButtonControl();
	},
	onDeactivateFilter: function() {
		this.activeFilterCount--;
		this.filterButtonControl();
	},
	filterButtonControl: function() {
		this.clearFiltersButton.setVisible(this.activeFilterCount > 0);
	},

	plugins: [],
	extraButtons: [],

	/** Etiqueta de texto
	 * @type {String}
	 */
	nuevoTxt: 'Nou',

	/** Etiqueta de texto
	 * @type {String}
	 */
	borrarTxt: 'Esborrar',

	/** Etiqueta de texto
	 * @type {String}
	 */
	editarTxt: 'Editar',

	/** Etiqueta de texto
	 * @type {String}
	 */
	eliminadoTxt: 'Eliminat 1 element',

	/** Etiqueta de texto
	 * @type {String}
	 */
	ejecutandoTxt: 'Executant...',

	/** Etiqueta de texto
	 * @type {String}
	 */
	espereTxt: 'esperi...',

	/** Etiqueta de texto
	 * @type {String}
	 */
	borrarRegistroTxt: 'Esborrar registre?',

	/** Etiqueta de texto
	 * @type {String}
	 */
	seguroTxt: 'està segur?<br/>Aqusta acció no es pot desfer.',

	/** Etiqueta de texto
	 * @type {String}
	 */
	eliminadoTxt: 'Eliminat 1 element',

	/** Ancho de la ventana. Por defecto, 400
	 * @type {Number} 
	 */
	windowWidth: 400,

	/** Alto de la ventana. Por defecto, 400
	 * @type {Number} 
	 */
	windowHeight: 400,

	/**
	 * Indica si se debe mostrar el botón general de guardar
	 */
	showSaveButton: true,
	/**
	 * Indica si se debe mostrar el botón general de borrar
	 */
	showDeleteButton: true,
	/**
	 * Indica si se debe mostrar el botón general de editar
	 */
	showEditButton: true,
	/**
	 * Indica si se debe mostrar el botón general de nuevo
	 */
	showNewButton: true,


	//private        
	editable: false,

	/** Indica que la carga de los datos se hace en el momento de necesitarse (cuando se activa el panel)
	 * IMPORTANTE: esto sólo funciona para paneles incluidos en un TabPanel de un formulario principal 
	 * @type {boolean}
	 */
	deferredLoad: false,

	/**
	 * Cuando el panel está dentro de un tabPanel, indica si es el tab activo 
	 */
	isActiveTab: false,


	/**
	 * Plantilla Ext.XTemplate para los registros del panel 
	 * @type {Ext.XTemplate}
	 */
	tpl: null,

	/**
	 * itemSelector para el DataView 
	 * Descripción de DataView.itemSelector: "This is a required setting. A simple CSS selector 
	 * (e.g. div.some-class or span:first-child) that will be used to determine what nodes this
	 *  DataView will be working with.
	 *  @type {String}
	 */
	itemSelector: null,

	/**
	 * Ext.data.Record que define los datos del panel
	 * @type {Ext.data.Record}
	 */
	dataRecord: null,

	/**
	 * Formulario para editar los registros
	 * @type {At4FrameworkIntranet.BasicSubForm}
	 */
	editForm: null,

	/**
	 * Carga el contenido del panel
	 * @param {Array} data Vector de registros a cargar
	 */
	setValues: function(data) {
		this.store.removeAll();
		var resultado = this.reader.readRecords({
			'resultados': data,
			'totalNumRecords': data.length
		});
		this.store.add(resultado.records);
		return this.fireEvent('afterload', this, data);
	},

	/**
	 * Devuelve el número de subitems en el panel
	 * @return {Number}
	 */
	getTotalCount: function() {
		/* This value is not updated when changing the contents of the Store locally.
		return this.store.getTotalCount();  
		*/
		return this.store.getCount();
	},

	/**
	 * Desactiva las acciones de edición del registro
	 */
	disableRecordEdit: function() {
		this.editButton.disable();
		this.deleteButton.disable();
	},

	/**
	 * Activa las acciones de edición del registro
	 */
	enableRecordEdit: function() {
		if (this.editable) {
			this.editButton.enable();
			this.deleteButton.enable();
		}
	},

	/**
	 * Cierra la ventana del formulario
	 */
	closeForm: function() {
		this.formWindow.hide();
	},

	updateParent: function() {
		if (this.parentFormPanel.parentPanel != null) { //Se trata de un panel anidado
			var parentData = Ext.ux.util.clone(this.parentFormPanel.currentRecord.data);
			parentData[this.name] = [];
			for (var i = 0; i < this.store.getCount(); i++) {
				parentData[this.name][i] = this.store.getAt(i).data;
			}
			this.parentFormPanel.parentPanel.onUpdateRecordDone(this.parentFormPanel, parentData, this.parentFormPanel.currentRecord);
		}
	},


	/**
	 * Se llama a este método tras añadir un nuevo registro desde la ventana de subformulario
	 * @param {At4FrameworkIntranet.BasicSubForm} form subformulario
	 * @param {Ext.data.Record} newRecord registro añadido
	 */
	onNewRecordDone: function(form, newRecord) {

		var resultado = this.reader.readRecords({
			'resultados': [newRecord],
			'totalNumRecords': 1
		});
		this.store.add(resultado.records);

		this.updateParent();

		return resultado.records[0];

	},

	/**
	 * Elimina la carga de los datos
	 */
	unload: function() {
		this.store.removeAll();
		this.dataLoaded = false;
	},

	//private
	afterDeleteForm: function(response) {

		if (response.success) {
			//Notificamos a la aplicación de la eliminación del registro
			//var records = this.dataView.getSelectedRecords();
			var records = this.getSelectionModel().getSelections();

			this.store.remove(records[0]);
			//notificamos en barra de estado
			this.statusBar.setStatus({
				text: this.eliminadoTxt,
				clear: true // auto-clear after a set interval
			});

		} else {
			Ext.Msg.alert('Error:', response.message);
		}

	},

	/**
	 * Se llama a este método tras modificar un registro desde la ventana de subformulario
	 * @param {At4FrameworkIntranet.BasicSubForm} form subformulario
	 * @param {Ext.data.Record} newRecord Registro modificado
	 * @param {Ext.data.Record} oldRecord Registro antiguo
	 */
	onUpdateRecordDone: function(form, newRecord, oldRecord) {

		var resultado = this.reader.readRecords({
			'resultados': [newRecord],
			'totalNumRecords': 1
		});
		var index = this.store.indexOf(oldRecord);

		this.store.remove(oldRecord);
		this.store.insert(index, resultado.records);
		form.currentRecord = this.store.getAt(index);

		this.updateParent();

		return resultado.records[0];
	},

	/**
	 * Activa/desactiva la edición del panel mostrando los botones de añadir/borrar/editar 
	 * @param {boolean} editable
	 */
	setEditable: function(editable) {
		this.editable = editable;
		/* Esto provoca errores de visualización
		this.getTopToolbar().setVisible(editable);
		*/
		if (this.showNewButton) {
			this.newButton.setVisible(editable);
		}
		if (this.showEditButton) {
			this.editButton.setVisible(editable);
		}
		if (this.showDeleteButton) {
			this.deleteButton.setVisible(editable);
		}

		if (this.editForm) {
			this.editForm.setEditable(editable);
		}

	}
});