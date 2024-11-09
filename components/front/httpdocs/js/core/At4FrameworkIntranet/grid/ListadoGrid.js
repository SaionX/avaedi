 // Namespace de At4FrameworkIntranet
Ext.namespace('At4FrameworkIntranet');
/**
 * @reworked.
 * @author: garrom@at4.net
 */
Ext.define('At4FrameworkIntranet.ListadoGrid', {
	extend: 'At4FrameworkIntranet.AbstractGrid',
	uses: ['Ext.ux.grid.PageSize'],

	/**
	 * @class At4FrameworkIntranet.ListadoGrid Una especialización de grid.Panel para tratar las
	 *        diferentes funcionalidades de listado de At4FrameworkIntranet
	 * @author agarcia
	 */
	constructor: function (viewer, config, application, gridMetaData, customConfig) {
		this.debugConstructorCallTime = new Date();
		this.viewer = viewer;
		this.application = application;
		this.customConfig = customConfig;
		this.autoSized = false;

		Ext.apply(this, config);

		/* Metadata del grid, recibida del servidor */
		this.gridMetaData = gridMetaData;

		/*
		 * Número de filtros activos, para llevar control del estado del botón "limpiar filtros"
		 */
		this.activeFilterCount = 0;

		// Permite configurar el grid
		if (customConfig) {
			if (customConfig.gridConfig) {
				Ext.apply(specialConfig, customConfig.gridConfig);
			}
		}

		// Según el tipo de grid que nos piden, vamos a configurar un objeto con propiedades
		var configProperties = new At4FrameworkIntranet.ListadoGridConfig(this, specialConfig);
		configProperties.editMode = gridMetaData.editable;
		this.editMode = configProperties.editMode;

		/*******************************************************
		 * Configuración del Store general del grid 1.- Record
		 * 2.- Reader 3.- Store
		 ******************************************************/
		this.columns = gridMetaData.columns;

		/*
		 * tipo de grid: (por definir, ejemplos: normal,
		 * editable, agrupable, etc )
		 */

		this.tipo = gridMetaData.editable ? "editable" : config.tipo;

		// var campos = gridMetaData.recordFields;

		var modelName = "At4FrameworkIntranet.dataModel" + this.id;

		var model = "";

		this.extraFilters = customConfig ? customConfig.extraFilters : [];

		if (Ext.ClassManager.isCreated(modelName)) {
			model = Ext.ClassManager.get(modelName);
		} else {
			model = Ext.define(modelName, {
				extend: 'Ext.data.Model',
				idProperty: "oid",
				proxy: {
					type: "dwr",
					dwrFunction: FormDataService.getListado,
					dwrParams: [this.gridMetaData.formItem.form],
					listeners: this.getListeners(this.extraFilters),
					reader: {
						type: "json",
						totalProperty: "totalNumRecords",
						rootProperty: "resultados",
						model: model
					}
				},
				fields: gridMetaData.recordFields
			});
		};


		var storeConfig = {
			model: model,
			// needed for groupBy to be passed through to remote source
			groupField: configProperties.groupField || gridMetaData.defaultGroupBy || "",

			listeners: {
				// Evitamos recargar los datos perdiendo modificaciones
				beforeload: function (store, options) {
					if (store.getModifiedRecords().length > 0) {
						Ext.Msg.alert(
							'Debe cancelar los cambios',
							'Existen registros modificados sin guardar<br/>debe guardar o cancelar los cambios para poder continuar');
						return false;
					}

				},
				load: {
					scope: this,
					fn: function (store, records, successful, eOpts) {
						if (!store.groupField && !store.isGrouped()) {
							this.getView().getFeature(0).disable();
						}
						this.autoSizeColumns();
					}
				}

			},
			pageSize: this.myPageSize,
			remoteSort: true,
			remoteFilter: true,
		};

		this.store = Ext.create("Ext.data.Store", storeConfig);

		if (configProperties.sortField) {
			this.store.setSorters([{
				property: configProperties.sortField,
				direction: configProperties.sortDirection ? configProperties.sortDirection : 'ASC'
			}]);
		} else if (gridMetaData.defaultSort) {
			//Ordenación por defecto
			this.store.setSorters([{
				property: gridMetaData.defaultSort,
				direction: gridMetaData.defaultDirection ? gridMetaData.defaultDirection : 'ASC'
			}]);
		}


		/*******************************************************
		 * Definición general de columnas. Las usadas en todas
		 * las configuraciones
		 ******************************************************/

		var useGroupSummary = false;
		this.formPanelName = "At4FrameworkIntranet." + gridMetaData.formClassName;
		if (configProperties.editMode) {
			this.formPanel = Ext.create(this.formPanelName, this.application, gridMetaData.formItem.form, gridMetaData, {
				id: Ext.id()
			});
		}
		// TODO: Usar el ComponentManager para no tener que crear un form cada vez. Este codigo falla.
		// El form se destruye al cerrar el grid, y da errores al volverlo a abrr
		// if (configProperties.editMode) {
		// 	var formName = "At4FrameworkIntranet." + gridMetaData.formClassName;
		// 	var idForm = gridMetaData.formClassName + "-editForm";
		// 	this.formPanel = Ext.ComponentManager.get(idForm);
		// 	if(!this.formPanel){
		// 		this.formPanel = Ext.create(formName, this.application, gridMetaData.formItem.form, gridMetaData, {
		// 			id: idForm
		// 		});
		// 	}
		// }

		this.configProperties = configProperties;
		this.configureGridMetaData();

		/*
		 * Acceso a la barra de estado. Usamos la barra de estado general de la aplicación
		 */
		this.statusBar = Ext.getCmp('At4Framework-status');

		// Configuración de los filtros
		var gridPlugins = [];

		//Barra de acciones de cabecera
		var menubar = [];

		var filterOutButton = Ext.create("Ext.button.Button", {
			//xtype: 'button',
			id: this.getId() + 'filterOutButton',
			text: this.limpiarFiltrosText,
			tooltip: this.limpiarFiltrosTipText,
			//hidden: true,
			// hideMode: "offsets",
			hideMode: "visibility",
			iconCls: 'icon-filter-out',
			scope: this,
			handler: this.clearFilters
		});

		var hasRightItem = false;

		if (customConfig && customConfig.buttons) {
			for (i = 0; i < customConfig.buttons.length; i++) {
				var customButton = Ext.create("Ext.button.Button", customConfig.buttons[i]);
				menubar.splice(0, 0, customButton);
			}
			hasRightItem = true;
		}

		if (this.gridMetaData.showNewButton) {
			var newButton = Ext.create("Ext.button.Button", {
				text: this.nuevoText,
				tooltip: this.nuevoTipText,
				iconCls: 'icon-plus',
				scope: this,
				handler: this.newRecord
			});
			menubar.splice(0, 0, newButton);
			hasRightItem = true;
		}
		if (hasRightItem) {
			menubar.push("-");
		}
		menubar.push(filterOutButton);
		menubar.push("->");

		// controles de guardar todo y cancelar todo
		if (configProperties.editMode) {
			var separator = {
				xtype: 'tbseparator',
				id: this.getId() + 'buttonsSeparator',
			};
			menubar.push(separator);
			var that = this;
			var editButtonOne = Ext.create("Ext.button.Button", {
				text: this.guardarTodoText,
				iconCls: 'icon-disk-all',
				scope: this,
				id: this.getId() + 'saveallButton',
				handler: this.commitChanges
			});
			menubar.push(editButtonOne);
			var editButtonTwo = Ext.create("Ext.button.Button", {
				text: this.cancelarTodoText,
				iconCls: 'icon-undo',
				id: this.getId() + 'cancelallButton',
				scope: this,
				handler: this.rejectChanges
			});
			menubar.push(editButtonTwo);
		}

		this.displaySummaryItem = Ext.create("Ext.toolbar.TextItem", {
			text: ""
		});

		menubar.push(this.displaySummaryItem);

		if (this.showResetStateButton) {
			menubar.push({
				text: this.olvidarEstadoTexto,
				iconCls: 'glyphicons glyphicons-cloud-minus',
				scope: this,
				handler: function () {
					Ext.Msg.show({
						title: this.borrarEstadoListado,
						message: this.mensajeEstado,
						buttons: Ext.Msg.YESNO,
						icon: Ext.Msg.QUESTION,
						scope: this,
						fn: function (btn) {
							if (btn === 'yes') {
								this.resetStateFn();
							}
						}
					});
				}
			})
		}


		var formats = [{
			text: "excel",
			iconCls: 'icon-export-excel',
			scope: this,
			handler: function () {
				this.exportFile('xls');
			}
		}, {
			text: "csv",
			iconCls: 'icon-export-csv',
			scope: this,
			handler: function () {
				this.exportFile('csv');
			}
		}, {
			text: "pdf",
			iconCls: 'icon-export-pdf',
			scope: this,
			handler: function () {
				this.exportFile('pdf');
			}
		}, {
			text: "docx",
			iconCls: 'icon-export-docx',
			scope: this,
			handler: function () {
				this.exportFile('docx');
			}
		}];

		if (this.gridMetaData.customExportFormats) {
			var len = this.gridMetaData.customExportFormats.length;
			for (var i = 0; i < len; i++) {
				var format = this.gridMetaData.customExportFormats[i];

				formats.push({
					text: format,
					iconCls: 'icon-export-' + format,
					scope: this,
					handler: function () {
						this.exportFile(format);
					}
				});
			}
		}

		if (false && this.gridMetaData.showExportControls) {

			// Añadimos los controles para exportar
			menubar.push('-');

			menubar.push(new Ext.button.Button({
				text: this.exportarText,
				tooltip: this.exportarTipText,
				iconCls: At4util.icons.exportar,
				menu: {
					items: formats
				}
			}));

		}
		// Nuevos botones de exportar
		//TODO: Localear
		if (true || this.showNeuExportButton) {
			var configWindowID = this.getId() + "configWindow";
			this.configWindow = Ext.getCmp(configWindowID);
			if (!this.configWindow) {
				this.gridConfigForm = Ext.create("At4FrameworkIntranet.ExportForm", {
					customExportFormats: this.gridMetaData.customExportFormats,
					customExportColumns: this.columns,
					application: this
				});
				this.configWindow = Ext.create({
					xtype: "at4window",
					width: 850,
					modal: true,
					plain: true,
					title: this.configExportWindowTitle,
					layout: 'fit',
					height: 680,
					id: configWindowID,
					closeAction: "hide",
					items: [this.gridConfigForm]
				});
			}

			var nameWindowID = this.getId() + "nameWindow";
			this.nameWindow = Ext.getCmp(nameWindowID);
			if (!this.nameWindow) {
				this.nameWindow = Ext.create({
					xtype: "at4appConfigSavePrompt"
				});
			}
			var subMenuConfigure = {
				text: "Configurar",
				iconCls: At4util.icons.configure,
				menu: {
					items: [{
						text: this.configMenuGuardarHeaderLabel,
						scope: this,
						iconCls: At4util.icons.save,
						handler: function () {
							var me = this;
							this.nameWindow.show(this);
						}
					}, {
						text: this.configMenuAplicarHeaderLabel,
						scope: this,
						iconCls: At4util.icons.apply,
						handler: function () {
							Ext.create("At4FrameworkIntranet.ExportWindow", {
								name: this.stateId,
								onLoad: function (state) {
									var provider = Ext.state.Manager.getProvider();
									Ext.ux.state.HttpProvider.superclass.set.call(provider, this.stateId, state);
									this.application.reloadListGrid(this);
									return true;
								}.bind(this)
							}).show();
						},
					}, {
						text: this.configMenuReiniciarHeaderLabel,
						scope: this,
						iconCls: At4util.icons.restart,
						handler: function () {
							this.reconfigure(null, this.gridMetaData.columns);
						}
					}]
				}
			};
			formats.push({
				text: this.configMenuAvanzadoHeaderLabel,
				scope: this,
				iconCls: At4util.icons.avanzado,
				handler: function () {
					this.configWindow.show(this);
				}
			})
			var subMenuExport = {
				text: this.exportarText,
				iconCls: At4util.icons.exportar,
				menu: {
					items: formats,
				}
			};
			var extraSubMenuHerramientas = this.extraSubMenuHerramientas ? this.extraSubMenuHerramientas : null;
			var exportMenu = Ext.create("Ext.button.Button", {
				text: this.herramientasText,
				tooltip: this.exportarTipText,
				iconCls: At4util.icons.herramientas,
				menu: {
					items: [
						subMenuConfigure,
						subMenuExport,
						extraSubMenuHerramientas
					]
				}
			});
			menubar.push('-');
			menubar.push(exportMenu);
		}


		//var menuToolbar = new Ext.Toolbar(menubar);
		var menuToolbar = Ext.create("Ext.toolbar.Toolbar", {
			items: menubar
		})

		if (customConfig && customConfig.selectionModel) {
			selectionModel = customConfig.selectionModel;
		}

		/*******************************************************
		 * Configuración de la vista del grid
		 ******************************************************/

		var view = null;
		var viewConfig = {
			forceFit: false,
			enableRowBody: false
		}
		viewConfig.groupTextTpl = '{text}';
		if (customConfig && customConfig.viewConfig) {
			Ext.apply(viewConfig, customConfig.viewConfig);
		}

		var parentFeatures = [];


		this.filtersActivos = [];

		if (configProperties.useFilters) {
			gridPlugins.push({
				ptype: 'gridfilters',
				stateId: this.getStateId() + "-pFilters",
			});
		}

		if (this.gridMetaData.useGroupSummary) {
			parentFeatures.push({
				ftype: 'groupingsummary',
				groupByText: this.groupByTextLabel,
				showGroupsText: this.showGroupsTextLabel,
			});
		} else {
			parentFeatures.push({
				ftype: 'grouping',
				groupByText: this.groupByTextLabel,
				showGroupsText: this.showGroupsTextLabel,
			});

		}


		/* Especializamos la configuración según el tipo de grid */
		var specialConfig = {};
		switch (this.tipo) {
		case 'normal':
			specialConfig = {
				editMode: false
			};
			break;
		case 'editable':
			specialConfig = {
				editMode: true
			};
			gridPlugins.push({
				ptype: 'cellediting',
				clicksToEdit: 2
			});
			break;
		}

		/*******************************************************
		 * Llamamos al constructor
		 ******************************************************/
		this.callParent([{
			region: 'center',

			viewConfig: {
				enableTextSelection: true,
			},

			features: parentFeatures,

			stripeRows: true,

			dockedItems: [menuToolbar, {
				xtype: 'pagingtoolbar',
				pageSize: this.myPageSize,
				store: this.store,
				dock: 'bottom',
				displayInfo: true,
				plugins: [new Ext.ux.grid.PageSize()]
			}],

			loadMask: {
				msg: this.cargandoText
			},
			plugins: gridPlugins,

			listeners: {
				// evita que se editen filas que total no se pueden grabar
				beforeedit: function (nose, row, eopts) {
					if (row.record.get('cannotUpdate')) {
						return false;
					}
				},
				afterrender: function (component, eOpts) {
					this.setOutButtons();
					this.batchButtons();
				},
				destroy: function (panel, eOpts) {
					this.application.unRegisterTabId(panel);
					this.autoSized = false;
				},
				edit: function (plugin, ctxt, eOpts) {
					var fieldEditor = ctxt.grid.formPanel.getFieldEditor(ctxt.field, true);
					if (fieldEditor.xtype == "At4Framework-combobox") {
						var record = fieldEditor.getStore().findRecord("ID", ctxt.value);
						var newVal = record.data["DISPLAY"];
						ctxt.record.set(ctxt.field, newVal);
						ctxt.record.set(ctxt.field + "Id", ctxt.value);
						ctxt.record.set(ctxt.field + "Label", newVal);
					}
					this.batchButtons();
				},
				validateedit: function (plugin, ctxt, eOpts) {
					var fieldEditor = ctxt.grid.formPanel.getFieldEditor(ctxt.field, true);
					if (fieldEditor.xtype == "At4Framework-combobox") {
						var record = fieldEditor.getStore().findRecord("ID", ctxt.value);
						if (!(ctxt.value != ctxt.originalValue && record)) {
							return false;
						}
					}
					return true;
				},

				filterchange: function (store, filters, eOpts) {
					this.activeFilterCount = filters.length;
					this.setOutButtons();
				},

				columnmove: function (container, column, inicio, destino, eOpts) {
					if (container.getVisibleGridColumns().length <= destino) {
						// Si la que se ha movido se mueve a la ultima posicion, esta se devuelve a la penultima
						// porque la ultima debe ser siempre el rowactions
						var headerCt = this.headerCt;
						var length = headerCt.getGridColumns().length - 1;
						headerCt.move(length, length - 1);
						this.getView().refresh();
					}
				},
				columnschanged: function (container, options) {
					this.autoSizeColumns();
				},
				show: {
					scope: this,
					fn: this.autoSizeColumns
				},
				add: {
					scope: this,
					fn: this.autoSizeColumns
				}


				//TODO: Test de states:
				/*
				                staterestore: function(form, state, eOpts) {
				                    //console.debug("ListadoGrid stateRestore\n", state);
				                },
				                statesave: function(form, state, eOpts) {
				                    // console.debug("ListadoGrid statesave\n", state);
				                },
				                beforestaterestore: function(form, state, eOpts) {
				                    //state = Ext.clone(state);
				                    //console.debug("ListadoGrid beforestateRestore\n", state);
				                },*/
				/*
				beforestatesave: function(form, state, eOpts) {
				    //Todo: En teoria, al haber quitado el autosize personalizado, esto no deberia hacer falta
				    if (state.columns) {
				        for (i in state.columns) {
				            var w = state.columns[i].width;
				            if (!isNaN(w) && w > 15) {
				                state.columns[i].width = w - 15;
				            }
				        }
				    }
				    //console.debug("ListadoGrid beforestatesave\n", state);
				}*/
			}
		}]);

		if(At4Framework_modoDesarrollo){
			console.debug("Tiempo de carga de ListadoGrid: " + (new Date() - this.debugConstructorCallTime) + "ms");
		}
	},

	/***********************************************************
	 * Métodos de acciones sobre el grid
	 **********************************************************/

	/**
	 * Abre el formulario del registro
	 *
	 * @param {Ext.data.Record}
	 *            record
	 */
	openRecord: function (record) {
		this.application.openRecordForm(
			this.gridMetaData.formItem, record.data);
	},

	/**
	 * Abre el formulario en blanco
	 */
	newRecord: function () {
		this.application.openNewRecordForm(this.gridMetaData.formItem);
	},
	/*
	    onActivateFilter: function(id) {
	        if (id && !this.activeFilterCount[id]) {
	            this.activeFilterCount[id] = true;
	        }
	        //this.activeFilterCount++;
	        this.setOutButtons();
	    },

	    onDeactivateFilter: function(id) {
	        //this.activeFilterCount--;
	        if (id && this.activeFilterCount[id]) {
	            delete this.activeFilterCount[id];
	        }
	        if (this.rendered) {
	            this.setOutButtons();
	        }

	    },*/

	clearFilters: function () {
		this.filters.clearFilters();
		this.activeFilterCount = 0;
		if (this.rendered) {
			this.setOutButtons();
		}
	},

	/**
	 * Fija el estado de los botones de cancelar búsqueda y
	 * limpiar filtro
	 *
	 * @private
	 */
	setOutButtons: function () {
		var button = Ext.get(this.getId() + 'filterOutButton');
		if (this.activeFilterCount > 0) {
			//if (Object.keys(this.activeFilterCount).length > 0) {
			if (button) {
				//button.setVisible(true);
				button.show()
			}
		} else {
			//button = Ext.get(this.getId() + 'filterOutButton');
			if (button) {
				//button.setVisible(false);
				button.hide()
			}
		}
	},
	batchButtons: function () {
		if (this.editMode) {
			var btSave = Ext.get(this.getId() + 'saveallButton');
			var btDelete = Ext.get(this.getId() + 'cancelallButton');
			var separator = Ext.get(this.getId() + 'buttonsSeparator');
			var modRecords = this.store.getModifiedRecords();
			if (modRecords.length > 0) {
				btSave.show();
				btDelete.show();
				separator.show();
			} else {
				btSave.hide();
				btDelete.hide();
				separator.hide();
			}
			this.doLayout();
		}
	},

	/**
	 * Guarda los cambios en 1 registro
	 *
	 * @private
	 * @param {Ext.data.Record}
	 *            record
	 */
	updateRecord: function (record) {
		//TODO: garrom: En teoria cuando llega aqui ya se ha terminado de editar
		//this.stopEditing();
		//this.stopEditing();
		var codiLinea = record.get('oid');
		/*
		 * if (!this.compruebaIntegridadLinea(record)) { return
		 * false; }
		 */
		// actualizamos la línea
		if (record.dirty) {
			serverDatabaseActions.updateGrid(this.gridMetaData.formItem.form, [codiLinea], [record], this.updateRecordCallback, this);
		} else {
			Ext.Msg.alert(this.nadaHacerText, this.noRegistroModificadoText);
		}
	},

	/**
	 * Cancela los cambios en 1 registro
	 *
	 * @private
	 * @param {Ext.data.Record}
	 *            record
	 */
	rejectRecord: function (record) {
		record.reject()
		this.batchButtons();
		this.setOutButtons();
	},

	/**
	 * Guarda todos los cambios
	 */
	commitChanges: function () {
		// TODO: En teoria cuando se llega aqui ya ha finalizado la edicion
		//this.stopEditing(); // Detiene la edición

		var records = this.store.getModifiedRecords();
		if (!records.length) {
			Ext.Msg.alert(this.nadaHacerText,
				this.noRegistroModificadoText);
			return;
		}

		var idsRecord = [];
		var recordsToUpdate = [];
		var codiLinea;

		Ext.each(records, function (r, i) {
			codiLinea = r.get('oid');

			/*
			 * if (!this.compruebaIntegridadLinea(r)) { return
			 * false; }
			 */

			idsRecord.push(codiLinea);
			recordsToUpdate.push(r);
		}, this);

		serverDatabaseActions.updateGrid(this.gridMetaData.formItem.form, idsRecord, recordsToUpdate, this.updateRecordCallback, this);

	},

	/**
	 * Descarta todos los cambios
	 *
	 * @private
	 */
	rejectChanges: function () {

		var records = this.store.getModifiedRecords();
		if (!records.length) {
			Ext.Msg.alert(this.nadaHacerText,
				this.noRegistroModificadoText);
			return;
		}

		var store = this.store;

		Ext.Msg.show({
			title: this.pregCancelarTodoText,
			msg: this.cancelarTodoMsgText,
			icon: Ext.Msg.QUESTION,
			buttons: Ext.Msg.YESNO,
			scope: this,
			fn: function (response) {
				if ('yes' !== response) {
					return;
				}
				store.rejectChanges();
				this.batchButtons();

			}
		});
	},

	/**
	 * Elimina un registro. Si es nuevo lo elimina del grid, si
	 * estaba en base de datos, además efectúa la llamada ajax
	 * para borrarlo
	 *
	 * @param {Object} record
	 * @private
	 */
	deleteRecord: function (record) {
		Ext.Msg.show({
			title: this.borrarRegistroTxt,
			msg: Ext.String.format(this.borrarSeguroTxt, '<b>' + record.data.oid + '</b>'),
			icon: Ext.Msg.QUESTION,
			buttons: Ext.Msg.YESNO,
			scope: this,
			fn: function (response) {
				if ('yes' !== response) {
					return;
				}
				var clave = record.data.oid;
				if (clave == 0) {
					// La linea no se había añadido
					record.commit();
					this.store.remove(record);
				} else {
					// Obtiene el menú
					serverDatabaseActions.deleteForm(
						this.gridMetaData.formItem.form,
						clave, this.deleteRecordCallback,
						this);

				}
			}
		});
	}, // eo function deleteRecord

	updateRecordCallback: function (records, resultadoActualizacion) {

		if (resultadoActualizacion.correcto) {

			var statusText = '';

			var len = records.length;
			for (var i = 0; i < len; i++) {
				records[i].commit();
			}
			if (len > 0) {
				if (len > 1) {
					statusText += Ext.String.format(this.modificadosElementosText, len);
				} else {
					statusText += this.modificadoElementoText;
				}
			}

			this.statusBar.setStatus({
				text: statusText,
				clear: true
					// auto-clear after a set interval
			});

		} else {
			var message = resultadoActualizacion.message;
			Ext.Msg.alert('Error:', message);
		}
		this.batchButtons();
	},

	/**
	 * Método al que se vuelve después de la llamada Ajax a
	 * borrar registro
	 *
	 * @private
	 */
	deleteRecordCallback: function (id, resultadoActualizacion) {
		if (resultadoActualizacion.correcto) {
			var key = this.store.find('oid', id);
			if (key != -1) {
				var record = this.store.getAt(key);
				record.commit();
				this.store.remove(record);
				// Notificamos a la aplicación de la eliminación
				// del registro
				this.application.onDeleteRecordDone(this, {
					rowid: id,
					formName: this.gridMetaData.formItem.form
				});
				this.statusBar.setStatus({
					text: 'Borrado 1 elemento',
					clear: true
						// auto-clear after a set interval
				});

			}
		} else {
			var message = resultadoActualizacion.message;
			Ext.Msg.alert('Error:', message);
		}

	},

	/**
	 * Muestra un popup con googleMaps
	 *
	 * @param {record}
	 */
	mostrarMapa: function (record) {
		mapwin = new Ext.Window({
			layout: 'fit',
			title: 'GMap Window',
			closeAction: 'hide',
			width: 400,
			height: 400,
			x: 40,
			y: 60,
			items: {
				xtype: 'gmappanel',
				zoomLevel: 4,
				gmapType: 'map',
				mapConfOpts: [
					'enableScrollWheelZoom',
					'enableDoubleClickZoom',
					'enableDragging'
				],
				mapControls: ['GSmallMapControl',
					'GMapTypeControl',
					'NonExistantControl'
				],
				setCenter: {
					geoCodeAddr: record.data.codiPais,
					marker: {
						title: 'Pais'
					}
				}
			}
		});

		mapwin.show();
	},

	/**
	 * cambia la posicion del item
	 *
	 * @param {String}
	 *            type up|down
	 */
	actualizarPosicion: function (record, action) {
		var clave = record.get('oid');
		serverDatabaseActions.actualizarPosicion(this.gridMetaData.formItem.form, clave, action, this.actualizarPosicionCallback, this);
	},

	actualizarPosicionCallback: function (resultadoActualizacion) {
		if (resultadoActualizacion.correcto) {

			/* Recargamos el list */
			var listTabId = this.gridMetaData.formItem.form + '-list';
			var listTab = this.application.getTab(listTabId);
			if (listTab) {
				listTab.store.reload();
				listTab.show();
			}

		} else {
			var message = resultadoActualizacion.message;
			Ext.Msg.alert('Error:', message);
		}
	},
	getListeners: function (extraFilters) {
		return {
			beforeload: function (dataProxy, params, dwrParams) {
				var sorter = "";
				var dirs = "";
				var filtrosRaw = params.filters || [];
				var filtros = [];
				var sorters = params.sorters || null;
				for (i in sorters) {
					if (sorters.hasOwnProperty(i)) {
						if (i > 0) {
							sorter += ",";
							dirs += ",";
						}
						if (i >= 0) {
							sorter += sorters[i]._property;
							dirs += sorters[i]._direction;
						}
					}
				}
				for (i in extraFilters) {
					if (extraFilters.hasOwnProperty(i)) {
						filtros.push(extraFilters[i]);
					}
				}
				for (i in filtrosRaw) {
					if (filtrosRaw.hasOwnProperty(i)) {
						var serialized = filtrosRaw[i].serialize();
						var valueString = "";
						if (typeof serialized.value == "object") {
							for (x in serialized.value) {
								if (typeof serialized.value[x] == "string") {
									if (x == 0) {
										valueString = serialized.value[x];
									} else {
										valueString += "," + serialized.value[x];
									}
								}
							}
						} else {
							valueString = serialized.value;
						}

						var type = (serialized.type == "multiList") ? "list" : serialized.type;

						var data = {
							type: type,
							value: valueString,
							//comparison: serialized.operator
						};
						if (serialized.type == "number" || serialized.type == "numeric" || serialized.type == "date") {
							data.comparison = serialized.operator;
						};
						if (typeof data.value !== "undefined") {
							filtros.push({
								field: serialized.property,
								data: data
							});
						}
					}
				}
				params.currentPage = params.page ? params.page : 1;
				params.pageSize = params.limit ? params.limit : 30;
				if (params && params.grouper) {
					params.groupBy = params.grouper._property;
				}

				params[dataProxy.loadArgsKey] = [dwrParams[0], filtros, {
					//start: (params.currentPage - 1) * params.pageSize,
					start: params.start,
					limit: params.pageSize,
					sort: sorter,
					direction: dirs,
					groupBy: params.groupBy
				}];

			},

			exception: function (dataProxy, response, operation) {
				Ext.Msg.alert('Error:', response.message ? response.message : response);
			},
			endprocessresponse: function (dataProxy, response, operation) {
				if (response.aggregates) {
					var dataIndex, msg = "";
					var found = false;
					for (var i = 0; i < this.gridMetaData.columns.length; i++) {
						dataIndex = this.gridMetaData.columns[i].dataIndex;
						if (response.aggregates[dataIndex]) {
							found = true;
							msg += " " + this.gridMetaData.columns[i].header + ": " + this.gridMetaData.columns[i].renderer(response.aggregates[dataIndex]);
						}
					}
					if (found) {
						Ext.fly(this.displaySummaryItem.getEl()).update(msg);
						this.doLayout();
					}
				}
			}.bind(this)
		};
	},

	resetStateFn: function () {
		console.log("Reseteando estado de: " + this.stateId);
		var provider = Ext.state.Manager.getProvider()
		if (provider) {
			provider.clear(this.stateId);
		}
		this.statusBar.setStatus({
			text: this.resetListadoTexto + this.title,
			clear: true
				// auto-clear after a set interval
		});
	},

	/*
	var stateProvider = Ext.state.Manager.getProvider();
	//undefined
	stateProvider.get("animal-list");
	//datos sobre animal list
	stateProvider.clear("animal-list");
	//undefined //Nota: Se reenvia el estado
	stateProvider.get("animal-list");
	//YA NO HAY datos sobre animal list



	//Here it comes. This is how to clear all states
	for (var item in stateProvider.state) {
	    Ext.state.Manager.clear(item);
	}*/

	//Defaults start

	//Número por defecto de registros por página
	myPageSize: 30,
	stateful: true,
	showResetStateButton: false,

	rowActionsDefaults: {
		draggable: false,
		groupable: false,
		resizable: false,
		sortable: false,
		hideable: false,
	},

	//Defaults end

});
