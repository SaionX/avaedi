//Namespace de At4FrameworkIntranet
Ext.namespace('At4FrameworkIntranet');

//Ext.extend(At4FrameworkIntranet.BaseNestedEditorGridPanel, At4FrameworkIntranet.BaseEditorGridPanel,{
Ext.define("At4FrameworkIntranet.BaseNestedEditorGridPanel", {
	extend: "At4FrameworkIntranet.BaseEditorGridPanel",

	/**
	 * @class At4FrameworkIntranet.BaseNestedEditorGridPanel
	 * Define la clase base de un EditorGridPanel que permite anidar grids.
	 * @extends At4FrameworkIntranet.BaseEditorGridPanel
	 * @author dsanchez
	 * @constructor
	 * 
	 * @param {At4FrameworkIntranet.BasicForm} parentFormPanel
	 * @param {Object} config
	 */

	constructor: function(parentFormPanel, config) {
		console.log("Se esta creando un BaseNestedEditorGridPanel");
		Ext.apply(this, config);

		this.txtBorrarFilaHijos = "No pots esborrar una fila amb fills.";

		if (this.readerRoot && this.dataSource) {

			var subReader = new Ext.data.JsonReader({
				totalProperty: "totalNumRecords",
				rootProperty: this.readerRoot
			}, this.dataRecord);

			if (!this.dataSource[this.readerRoot]) {
				this.dataSource[this.readerRoot] = [];
			}

			config.store = new Ext.data.Store({
				reader: subReader,
				remoteSort: false,
				data: this.dataSource
			});
		}

		var that = this;

		this.abrirText = 'Obrir';
		this.agregarSubitemText = "Añadir item";
		this.borrarSubitemText = "Eliminar item";

		var acciones = [];

		if (this.showEditRowButton) {

			// Acción abrir
			acciones.push({
				iconCls: At4util.icons.editar,
				style: 'margin: 0px 0 0 4px; display: inline-block;',
				qtip: this.abrirText,
				hideIndex: 'cannotOpen'
			});

		}

		// Acciones de agregar y eliminar elementos en la misma fila.
		if (this.showDeleteRowButton) {

			// Acción de borrar elemento hijo
			acciones.push({
				iconCls: "icon-remove-child",
				style: "margin: 2px 4px 0 0; display: inline-block;",
				qtip: this.borrarSubitemText,
				hideIndex: 'cannotDelete'
			});

		}

		if (this.showAddRowButton) {

			// Acción añadir elemento hijo
			acciones.push({
				iconCls: At4util.icons.add,
				style: "margin: 2px 4px 0 0; display: inline-block;",
				qtip: this.agregarSubitemText,
				hideIndex: 'cannotAdd'
			});

		}

		//Acciones de la izquierda (abrir)      
		if (this.enableLeftRowActions && (this.showEditRowButton || this.showDeleteRowButton || this.showAddRowButton)) {
			this.leftRowActions = new Ext.ux.grid.RowActions({
				header: '',
				fixed: true,
				locked: true,
				id: 'left-actions',
				autoWidth: true,
				//width: 48,
				//widthSlope: 50,
				//widthIntercept: Ext.isSafari ? 4 : 2,
				hideMode: 'visibility',
				actions: acciones,

				/*
				 * Sobreescribimos el método getData para poder añadir los campos que usaremos como hideIndex
				 * @param {Object} value
				 * @param {Object} cell
				 * @param {Object} record
				 */
				getData: function(value, cell, record) {
					var data = record.data;

					//Si no existe cada una de las propiedades en el registro del grid, la incluimos
					if (!data.hasOwnProperty('cannotOpen')) {
						data.cannotOpen = false;
					}
					if (!data.hasOwnProperty('cannotDelete')) {
						data.cannotDelete = false;
					}
					if (!data.hasOwnProperty('cannotAdd')) {
						data.cannotAdd = false;
					}
					return data || {};
				},

				listeners: {
					'action': {
						fn: function(grid, record, action, row, col) {
							switch (action) {
								case At4util.icons.editar:
									this.openRowAction(grid, record, action, row, col);
									break;

								case At4util.icons.add:
									this.addChildAction(grid, record, action, row, col);
									break;

								case "icon-remove-child":
									this.removeRowAction(grid, record, action, row, col);
									break;

							}
						},
						scope: this
					}
				}
			});
		}

		/**
		 * Método para expandir todas las filas padres e hijos a la vez.
		 */
		this.expandAllRows = function() {

			for (var i = 0; i < this.getStore().getCount(); i++) {
				if (this.getView().getRow(i)) {
					this.expander.expandRow(i);
				}
			}

			//cnavarro: Poner un setTimeout con retraso cero le da al navegador tiempo a ejecutar tareas del DOM
			//	Ver: http://stackoverflow.com/questions/779379/why-does-settimeoutfn-0-sometimes-help
			setTimeout(function() {
				for (var id in this.childrenGrids) {
					this.childrenGrids[id].expandAllRows();
				}
			}.createDelegate(this), 0);

		}

		/**
		 * Método para contraer todas las filas.
		 */
		this.collapseAllRows = function() {
			for (var i = 0; i < this.getStore().getCount(); i++) {
				this.expander.collapseRow(i);
			}
		}

		// Contador de instancias para generar subgrids con ids diferentes.
		this.gridInstanceCounter = 0;

		this.refreshGrid = function() {
			var renderedChildren = [];
			for (var id in this.childrenGrids) {
				if (!this.childrenGrids.hasOwnProperty(id) || !id || !this.childrenGrids[id]) {
					continue;
				}
				var index = this.childrenGrids[id].parentRowNumber;
				this.childrenGrids[id].destroy();
				delete this.childrenGrids[id];
				renderedChildren.push({
					id: id,
					rowIndex: index
				});
			}
			this.getView().refresh();
			for (var i = 0; i < renderedChildren.length; i++) {
				this.expander.expandRow(renderedChildren[i].rowIndex);
			}
		}.createDelegate(this);

		this.deleteSubGrids = function() {
			for (var id in this.childrenGrids) {
				if (!this.childrenGrids.hasOwnProperty(id) || !id || !this.childrenGrids[id]) {
					continue;
				}
				this.childrenGrids[id].destroy();
				delete this.childrenGrids[id];
			}
			this.getView().refresh();
		}.createDelegate(this);

		// Mantenemos la referencia a la lista "abuelo" y a todos los nietos.
		// Se mantiene para poder deseleccionar los elementos de otros grids al hacer click en un grid padre/hijo.
		this.grandparentGrid = config.grandparentGrid ? config.grandparentGrid : this;
		this.grandchildrenGrid = [];
		this.childrenGrids = {};

		if (!this.expanderConfig) {
			this.expanderConfig = {
				tpl: new Ext.XTemplate('<div class="detailData">', '', '</div>'),
				lazyRender: false,
				listeners: {
					scope: this,
					expand: this.expandFunc
				},

				// Render para no mostrar el botón de expandir si no hay elementos hijos.
				renderer: function(v, p, record) {

					// ¿Se especificó el campo del registro con los hijos, y existen hijos? 
					if (this.nombreCampoDatosHijos && record.data[this.nombreCampoDatosHijos] && record.data[this.nombreCampoDatosHijos].length) {

						// Sí, mostramos el botón de desplegar.
						p.cellAttr = 'rowspan="2"';
						return '<div class="x-grid3-row-expander"></div>';

					} else {
						p.id = '';
						return '&#160;';
						/*
						p.cellAttr = 'rowspan="2"';
						return '<div class="x-grid3-row-expander x-grid3-row-expanderno-children"></div>';
						*/
					}

				}.createDelegate(this),

				expandOnEnter: false,
				expandOnDblClick: false
			};
		}

		this.expander = new Ext.grid.RowExpander(this.expanderConfig);

		this.viewConfig = {
				forceFit: true
			},
			this.collapsible = true;
		this.animCollapse = false;
		//iconCls: 'icon-grid' 

		var pluginColumns = [];
		if (this.enableExpander) {
			pluginColumns = pluginColumns.concat(this.expander);
		}
		if (this.enableLeftRowActions && (this.showEditRowButton || this.showDeleteRowButton || this.showAddRowButton)) {
			pluginColumns = pluginColumns.concat(this.leftRowActions);
		}

		this.plugins = pluginColumns;
		this.cm = new Ext.grid.ColumnModel(pluginColumns.concat(this.baseColumnas));

		this.extraButtons = [

			new Ext.Button({ //Expand All Button
				id: this.getId() + '-expandAllButton',
				text: "Expandir tots",
				iconCls: 'icon-tree',
				scope: this,
				disabled: false,
				hidden: false,
				style: 'margin: 0px 5px 0px 10px;',
				handler: function(b, ev) {
					this.expandAllRows();
				}
			}),
			new Ext.Button({ //Collapse All Button
				id: this.getId() + '-collapseAllButton',
				text: "Contraure tots",
				iconCls: 'icon-untree',
				scope: this,
				disabled: false,
				hidden: false,
				style: 'margin: 0px 5px 0px 10px;',
				handler: function(b, ev) {
					this.collapseAllRows();
				}
			})
		];


		this.updateParent = function() {
			/*
        if (this.parentFormPanel.parentPanel != null) { //Se trata de un panel anidado
            var parentData = Ext.ux.util.clone(this.parentFormPanel.currentRecord.data);
            parentData[this.name] = [];
            for (var i = 0; i < this.store.getCount(); i++) {
                parentData[this.name][i] = this.store.getAt(i).data;
            }
            this.parentFormPanel.parentPanel.onUpdateRecordDone(this.parentFormPanel, parentData, this.parentFormPanel.currentRecord);
        }
		*/
		}

		/*
	this.updateParent = function () {
		if (this.gridParent) {
			var parentData = Ext.ux.util.clone(this.parentFormPanel.currentRecord.data);
            parentData[this.name] = [];
            for (var i = 0; i < this.store.getCount(); i++) {
                parentData[this.name][i] = this.store.getAt(i).data;
            }
            this.gridParent.onUpdateRecordDone(this.gridParent, parentData, this.parentFormPanel.currentRecord);
		}
	}
	*/

		/**
		 * Se llama a este método tras añadir un nuevo registro desde la ventana de subformulario
		 * @param {At4FrameworkIntranet.BasicSubForm} form subformulario
		 * @param {Ext.data.Record} newRecord registro añadido
		 */
		this.onNewRecordDone = function(form, newRecord) {

			var resultado = this.reader.readRecords({
				'resultados': [newRecord],
				'totalNumRecords': 1
			});

			this.store.add(resultado.records);

			this.updateParent();

			if (this.gridParent) {
				this.gridParent.syncFromChildren();
			}

			return resultado.records[0];

		}

		//Sobreescribe la misma función de BaseEditorGridPanel
		this.afterDeleteForm = function(response) {

			if (response.success) {
				//Notificamos a la aplicación de la eliminación del registro
				var records = this.getSelectionModel().getSelections();

				this.store.remove(records[0]);
				//notificamos en barra de estado
				this.statusBar.setStatus({
					text: this.eliminadoTxt,
					clear: true // auto-clear after a set interval
				});

				if (this.gridParent) {
					this.gridParent.syncFromChildren();
					/*
					//Encontrar fila correspodiente al grid hijo
					var rows = this.gridParent.store.getRange();
					var ctr=0;
					var index = null;
				
					for(var i in rows) {
						if (rows[i].data[this.rowIdColumnName]==this.parentRowID) {
							index = ctr;
							break;
						}
						ctr += 1;
					}
				
					//Actualizar datos del record correspondiente
					this.gridParent.getStore().getRange();
					*/
				}

			} else {
				Ext.Msg.alert('Error:', response.message);
			}

		}

		this.syncFromChildren = function() {
			//iterate children grids
			for (var id in this.childrenGrids) {

				if (!this.childrenGrids.hasOwnProperty(id)) {
					continue;
				}
				if (!this.childrenGrids[id] || !this.childrenGrids[id].store) {
					continue;
				}

				//Recreate the children array for the record
				var records = this.childrenGrids[id].getStore().getRange();
				var children = [];
				for (var recordId = 0; recordId < records.length; recordId++) {
					if (!records.hasOwnProperty(recordId)) {
						continue;
					}
					children.push(records[recordId].data);
				}


				//find row, substitute children array
				var thisrecords = this.getStore().getRange();
				var ctr = 0;
				for (var recordId = 0; recordId < thisrecords.length; recordId++) {
					if (!thisrecords.hasOwnProperty(recordId)) {
						continue;
					}
					if (thisrecords[recordId].data[this.rowIdColumnName] != id) {
						ctr += 1;
						continue;
					}

					this.store.data.items[ctr].data[this.nombreCampoDatosHijos] = children;
					//this.store.getAt(ctr).set(this.nombreCampoDatosHijos, children);
					//this.store.remove(thisrecords[recordId]);
					//thisrecords[recordId].data[this.nombreCampoDatosHijos] = children;
					//this.store.insert(ctr, thisrecords[recordId]);
					break;
				}

				if (children.length == 0) {

					this.childrenGrids[id].destroy();
					delete this.childrenGrids[id];
				}

				//Refresh child grid
				//this.childrenGrids[id].getView().refresh();
			}

			//Refresh this grid
			this.refreshGrid();

		}.createDelegate(this);

		this.onUpdateRecordDone = function(form, newRecord, oldRecord) {

			var resultado = this.reader.readRecords({
				'resultados': [newRecord],
				'totalNumRecords': 1
			});
			var index = this.store.indexOf(oldRecord);

			//Modifico los datos raw del objeto y hago un refresh del view del grid
			//this.store.data.items[index].data = resultado.records[0].data;
			/*
			if (index<0) {
				console.error("INDEX", index);
				this.updateParent();
				return resultado.records[0];
			}
		
			console.log("PRESET:", oldRecord, newRecord);
			for(var field in oldRecord.data) {
				if (field=="oid") { continue; }
				console.log("SET:", index, field, newRecord[field], "| was:", this.store.getAt(index).data[field]);
				this.store.getAt(index).set(field, newRecord[field]);
			}
			this.store.commitChanges();
		
			this.view.refresh();
			*/
			//Borrar el record elimina cualquier subgrid que pueda tener por rowexpander


			this.store.remove(oldRecord);
			this.store.insert(index, resultado.records);
			form.currentRecord = this.store.getAt(index);

			//this.syncFromChildren();

			this.updateParent();

			return resultado.records[0];
		}.createDelegate(this);


		//At4FrameworkIntranet.BaseNestedEditorGridPanel.superclass.constructor.call(this, parentFormPanel, config);
		this.callParent(this, parentFormPanel, config);
		//agarcia TODO: ¿estos métodos no deberían estar en el prototipo y no en el constructor? 
		// Limpia todas las filas seleccionadas.
		this.clearSelections = function() {
			this.getSelectionModel().clearSelections();

			for (var i = 0; i < this.grandchildrenGrid.length; i++) {
				if (this.grandchildrenGrid[i].rendered) {
					this.grandchildrenGrid[i].getSelectionModel().clearSelections();
				}
			}

		}.createDelegate(this);

		// Método llamado antes de hacer click sobre una fila.
		this.getSelectionModel().on('beforerowselect', function() {

			// Basta con limpiar el grid "abuelo" ya que este se encargará de limpiar todos los grids.
			if (this.grandparentGrid) {
				this.grandparentGrid.clearSelections();
			}

		}.createDelegate(this));
	},

	gridParent: null,
	enableExpander: true,
	expanderConfig: false,
	rowIdColumnName: 'codi',
	enableLeftRowActions: true,
	showEditRowButton: true,
	showAddRowButton: true,
	showDeleteRowButton: true,


	/**
	 * Carga el contenido del panel. Sobreescribimos este método para refrescar el grid.
	 * @param {Array} data Vector de registros a cargar
	 */
	setValues: function(data) {
		At4FrameworkIntranet.BaseNestedEditorGridPanel.superclass.setValues.call(this, data);
		this.deleteSubGrids();
	},


	/**
	 * Método para crear un Grid hijo.
	 * @param {Object} id
	 * @param {Object} record
	 */
	createChildGrid: function(id, record) {

		if (!this.childrenGrids[id]) {

			this.gridInstanceCounter++;

			this.childrenGrids[id] = new At4FrameworkIntranet[this.nombreClase](this.parentFormPanel, {
				id: this.getId() + "-subgrid" + this.gridInstanceCounter,
				//store: store,
				enableHdMenu: true,
				stripeRows: false,
				autoWidth: true,
				autoHeight: true,
				editable: true,
				gridParent: this,

				readerRoot: this.nombreCampoDatosHijos,
				dataSource: record.data,

				parentRowNumber: this.store.indexOf(record),
				parentRowID: record.data[this.rowIdColumnName],
				grandparentGrid: this.grandparentGrid,
				tbar: null,
				style: 'margin: 0 0 8px 0;'
			});

		}

		return this.childrenGrids[id];

	},

	/**
	 * Función ejecutada al expandir una fila.
	 * @param {Object} ex
	 * @param {Object} record
	 * @param {Object} body
	 * @param {Object} rowIndex
	 */
	expandFunc: function(ex, record, body, rowIndex) {
		var grid = this.createChildGrid(record.data[this.rowIdColumnName], record);

		// Comprobamos que haya hijos para expandir y que el grid aun no ha sido renderizado
		if (!grid.rendered && grid.store.getTotalCount() > 0) {

			grid.renderTo = Ext.DomQuery.select("div.detailData", body)[0];
			grid.render(grid.renderTo);

			// Evitamos la propagación de eventos.
			grid.getEl().swallowEvent(['mousedown', 'click', 'dblclick']);
		}

		if (this.grandparentGrid) {
			this.grandparentGrid.grandchildrenGrid.push(grid);
		}

	},

	/**
	 * Método que ejecuta la acción de abrir fila (rueda dentada)
	 */
	openRowAction: function(grid, record, action, row, col) {
		this.formWindow.show();
		this.editForm.loadData(record);
		this.expander.collapseRow(row);
		if (typeof this.childrenGrids[record.data[this.rowIdColumnName]] && typeof this.childrenGrids[record.data[this.rowIdColumnName]] == "object") {
			this.childrenGrids[record.data[this.rowIdColumnName]].destroy();
			this.childrenGrids[record.data[this.rowIdColumnName]] = null;
		}
	},

	/**
	 * Método que ejecuta la acción de nuevo hijo (+)
	 */
	addChildAction: function(grid, record, action, row, col) {
		// Creamos / obtenemos el grid hijo.
		var childGrid = this.createChildGrid(record.data[this.rowIdColumnName], record);
		childGrid.formWindow.show();
		childGrid.editForm.emptyForm();

		var subFormConfig = {};
		subFormConfig[this.subFormIdName] = record.data[this.rowIdColumnName];
		childGrid.editForm.setValues(subFormConfig);

		this.editingRow = row;
		return childGrid;
	},

	/**
	 * Método que ejecuta la acción de eliminar fila (aspa)
	 */
	removeRowAction: function(grid, record, action, row, col) {
		if (record.data[this.nombreCampoDatosHijos] && record.data[this.nombreCampoDatosHijos].length) {
			alert(this.txtBorrarFilsHijos);
		} else {
			this.doDeleteRow();
		}
	}



});