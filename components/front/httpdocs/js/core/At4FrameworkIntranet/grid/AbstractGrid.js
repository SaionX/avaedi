Ext.define('At4FrameworkIntranet.AbstractGrid', {
	extend: 'Ext.grid.Panel',

	/***********************************************************
	 * Cadenas
	 **********************************************************/

	/**
	 * Etiqueta de texto
	 *
	 * @type {String}
	 */
	yesText: 'Si',

	/**
	 * Etiqueta de texto
	 *
	 * @type {String}
	 */
	noText: 'No',

	/**
	 * Etiqueta de texto
	 *
	 * @type {String}
	 */
	abrirText: 'Abrir',

	/**
	 * Etiqueta de texto
	 *
	 * @type {String}
	 */
	accionesText: 'Acciones',

	/**
	 * Etiqueta de texto
	 *
	 * @type {String}
	 */
	eliminarText: 'Eliminar',

	/**
	 * Etiqueta de texto
	 *
	 * @type {String}
	 */
	guardarText: 'Guardar',

	/**
	 * Etiqueta de texto
	 *
	 * @type {String}
	 */
	guardarTodoText: 'Guardar todo',

	/**
	 * Etiqueta de texto
	 *
	 * @type {String}
	 */
	cancelarTodoText: 'Cancelar todo',

	/**
	 * Etiqueta de texto
	 *
	 * @type {String}
	 */
	pregCancelarTodoText: 'Â¿Cancelar todo?',

	/**
	 * Etiqueta de texto
	 *
	 * @type {String}
	 */
	cancelarTodoMsgText: '¿Desea cancelar todos los cambios pendientes?<br/>Esta acción no se puede deshacer.',

	/**
	 * Etiqueta de texto
	 *
	 * @type {String}
	 */
	copiarText: 'Copiar',

	/**
	 * Etiqueta de texto
	 *
	 * @type {String}
	 */
	nadaHacerText: 'Nada que hacer',

	/**
	 * Etiqueta de texto
	 *
	 * @type {String}
	 */
	noRegistroModificadoText: 'No hay ningún registro modificado.',

	/**
	 * Etiqueta de texto
	 *
	 * @type {String}
	 */
	modificadoElementoText: 'Modificado 1 elemento ',

	/**
	 * Etiqueta de texto
	 *
	 * @type {String}
	 */
	modificadosElementosText: 'Modificados {0} elementos ',

	/**
	 * Etiqueta de texto
	 *
	 * @type {String}
	 */
	limpiarFiltrosText: 'Limpiar filtros',

	/**
	 * Etiqueta de texto
	 *
	 * @type {String}
	 */
	limpiarFiltrosTipText: 'Limpiar los filtros configurados',

	/**
	 * Etiqueta de texto
	 *
	 * @type {String}
	 */
	nuevoText: 'Nuevo',

	/**
	 * Etiqueta de texto
	 *
	 * @type {String}
	 */
	nuevoTipText: 'Añadir nuevo registro',

	/**
	 * Etiqueta de texto
	 *
	 * @type {String}
	 */
	exportarText: 'exportar',

	/**
	 * Etiqueta de texto
	 *
	 * @type {String}
	 */
	exportarTipText: 'convertir a formatos de intecambio',

	/**
	 * Etiqueta de texto
	 *
	 * @type {String}
	 */
	cargandoText: 'cargando ...',

	/**
	 * Etiqueta de texto
	 *
	 * @type {String}
	 */
	noPuedeMoverColumnaText: 'No puede mover esta columna',

	/**
	 * Etiqueta de texto
	 *
	 * @type {String}
	 */
	borrarRegistroTxt: 'Â¿Borrar registro?',

	/**
	 * Etiqueta de texto
	 *
	 * @type {String}
	 */
	borrarSeguroTxt: 'Â¿Borrar el registro {0}?<br/>Esta acción no se puede deshacer.',

	/**
	 * Etiqueta de texto
	 *
	 * @type {String}
	 */
	borrarAuditorias: 'Â¿Borrar el registro {0}?<br/>Esta acción no se puede deshacer.',

	/**
	 * Etiqueta de texto
	 *
	 * @type {String}
	 */
	textExportarPdfSolicitud: 'PDF de la solicitud',

	/**
	 * Etiqueta de texto
	 *
	 * @type {String}
	 */
	textExportarPdfsSolicituds: 'PDFs de les solicituds',

	/**
	 * Etiqueta de texto
	 *
	 * @type {String}
	 */
	pdfs: 'PDFs',

	/**
	 * Etiqueta de texto
	 *
	 * @type {String}
	 */
	textCodigoBarras: 'Lectura de código de barras',

	/**
	 * Etiqueta de texto
	 *
	 * @type {String}
	 */
	codigoBarras: 'Introducir código',

	/**
	 * Etiqueta de texto
	 *
	 * @type {String}
	 */
	textInformeDeutes: 'Informe de Deutes',

	/**
	 * Etiqueta de texto
	 *
	 * @type {String}
	 */
	textInformeDeficiencies: 'Informe de Deficiencies',

	textTramitsAudiencia: 'Tramits audiÃ¨ncia',

	errorInformeDeficiencies: "No es pot generar l'informe de deficiencies. La convocatoria no te aquest tipus d'informe.",

	errorInformeDeutes: "No es pot generar l'informe de deutes. La convocatoria no te aquest tipus d'informe.",

	errorInformeDeutesCompteCorrent: "No es pot generar l'informe de deutes. L'expedient no te el compte de pagament informat.",

	errorInformeTramitsAudiencia: "No es pot generar l'informe de tramis d'audiÃ¨ncia. La convocatoria no te aquest tipus d'informe.",

	/***********************************************************
	 * Fin de cadenas
	 **********************************************************/


	// Flag que indica si se ha ejecutado el autosize de columnas, usado para que éste sólo se ejecute en la primera carga

	autoSizeColumns: function () {
		if (this.autoSized) {
			return;
		}
		if (this.application.tabPanel.getActiveTab() != this && this.rendered) {
			return;
		}
		if (!this.store.isLoaded()) {
			return;
		}

		this.autoSized = true;
		if(At4Framework_modoDesarrollo){
			console.debug("Autosize columns");
		}
		window.setTimeout(function () {
			var columns = this.getView().getHeaderCt().getVisibleGridColumns()
			var columncount = columns.length;
			for (var i = 0; i < columncount; i++) {
				var column = columns[i];
				column.autoSize();
				if(column.width < column.autoSizeMinWidth){
					column.setWidth(column.autoSizeMinWidth);
				}else if(column.width > column.autoSizeMaxWidth){
					column.setWidth(column.autoSizeMaxWidth);
				}
			}
		}.bind(this), 50);
	},

	/**
	 * exporta la última petición al servidor
	 *
	 * @param {String}
	 *            type csv|xls|pdf
	 * @private
	 */
	exportFile: function (type, action, record, filename, exportCols) {

		if (!action) {
			action = './export/exportar';
		}

		var lastParams = this.store.lastOptions;

		filename = filename ? filename : "export";

		/* Combinamos el post */
		var postInputs = {
			filename: filename
		};
		if (lastParams.grouper) {
			postInputs.groupBy = lastParams.grouper._property;
		}

		if (lastParams.sorters) {
			postInputs.direction = lastParams.sorters[0] ? lastParams.sorters[0]._direction : '';
		}
		if (lastParams.groupers) {
			postInputs.sort = lastParams.sorters[0] ? lastParams.groupers[0]._property : '';
		}
		if (lastParams.sorters) {
			postInputs.sort = postInputs.sort ? postInputs.sort : "";
			postInputs.sort += lastParams.sorters[0] ? lastParams.sorters[0]._property : '';
		}
		var filters = lastParams.filters ? lastParams.filters : [];
		var z = 0;
		for (var i = 0; i < filters.length; i++, z++) {
			postInputs['filter_field_' + z] = filters[i]._property;
			var ftype = filters[i].type;
			ftype = (ftype == "multiList") ? "list" : ftype;
			postInputs['filter_type_' + z] = ftype;
			var val = filters[i]._value;
			if (val instanceof Date) {
				val = Ext.Date.format(val, "d/m/Y");
			}
			postInputs['filter_value_' + z] = val;
			if (filters[i]._operator && filters[i].type != "boolean") {
				postInputs['filter_comparison_' + z] = filters[i]._operator;
			}
		}

		for (var i = 0; i < this.extraFilters.length; i++, z++) {
			postInputs['filter_field_' + z] = this.extraFilters[i].field;
			postInputs['filter_type_' + z] = this.extraFilters[i].data.type;
			postInputs['filter_value_' + z] = this.extraFilters[i].data.value;
			if (this.extraFilters[i].data.comparison) {
				postInputs['filter_comparison_' + z] = this.extraFilters[i].data.comparison;
			}
		}

		// Incluimos el tipo de grid
		postInputs.formName = this.gridMetaData.formItem.form;
		postInputs.exportCols = exportCols || [];
		/* Creamos un iframe oculto donde llamar a la descarga */
		var id = Ext.id();
		var frame = document.createElement('iframe');
		/*
		 * var frame = Ext.DomHelper.append(document.body, {
		 * tag:'iframe' });
		 */
		frame.id = id;
		frame.name = id;
		frame.className = 'x-hidden';
		if (Ext.isIE) {
			frame.src = Ext.SSL_SECURE_URL;
		}

		document.body.appendChild(frame);

		if (Ext.isIE) {
			document.frames[id].name = id;
		}

		/* Creamos el formulario con los datos del informe */
		var form = Ext.DomHelper.append(document.body, {
			tag: 'form',
			method: 'post',
			action: action + '.' + type,
			target: id
		});

		// frame.appendChild(form);
		document.body.appendChild(form);

		var hidden;

		for (var prop in postInputs) {

			// append cmd to form
			hidden = document.createElement('input');
			hidden.type = 'hidden';
			hidden.name = prop;
			hidden.value = postInputs[prop];
			form.appendChild(hidden);
		}

		// clave del item del que obtendremos el pdf
		if (record) {
			var clave = record.get('oid');
			hidden = document.createElement('input');
			hidden.type = 'hidden';
			hidden.name = 'claveItemPdf';
			hidden.value = clave;
			form.appendChild(hidden);
		}

		/*
		 * Creamos el callback para eliminar el frame y el
		 * formulario tras la descarga
		 */
		var callback = function () {
			Ext.EventManager.removeListener(frame, 'load', callback, this);
			/*setTimeout(function() {
			    frame.removeChild(form);
			}, 100);*/
			setTimeout(function () {
				document.body.removeChild(frame);
			}, 110);
		};

		Ext.EventManager.on(frame, 'load', callback, this);

		/* enviamos el formulario */
		form.submit();
	},

	findFirstGroupingField: function (columns) {
		for (i in columns) {
			if (columns[i].groupable) {
				return columns[i].dataIndex;
			}
		}
		return "";
	},
	/*
	 * función para renderizar una celda extrayendo el valor
	 * de un store
	 */
	columnStoreRenderer: function (v, params, record, rowIndex, colIndex) {
		var rendered = "";
		if (v) {
			var storeRecord = null;
			//if ((storeRecord = this.gridMetaData.columns[colIndex].columnStore.getById(v))) {
			if ((storeRecord = params.column.columnStore.getById(v))) {
				rendered = storeRecord.get('DISPLAY');
			} else {
				rendered = v;
			}
		}
		//record.data.rendered_parents = rendered;
		return rendered;
	},








	configureGridMetaData: function () {
		var gridMetaData = this.gridMetaData;
		var customConfig = this.customConfig;

		if (gridMetaData.configured) {

			//Probablemente sea mas optimo un for en vez de un ext.each
			for (var i = 0; i < this.columns.length; i++) {
				var column = this.columns[i];
				this.configureEditMode(column);
				//TODO: garrom: En extj5 no se pueden poner id's duplicados, por lo cual hay que resetearlos.
				// Se deberia mirar una mejor manera
				column.id = this.getId() + column.baseId;
				column.stateId = this.stateId + column.baseId;
			}

			useGroupSummary = gridMetaData.useGroupSummary;

			if (!gridMetaData.disableOpenForm) {
				this.leftRowActions = this.columns[0];
				// this.leftRowActions.id =  this.getId() + "-leftActions-head";
			}
			if (this.gridMetaData.showDeleteButton) {
				this.rightRowActions = this.columns[this.columns.length - 1];
				// this.rightRowActions.id =  this.getId() + "-rightActions-head";
			}

		} else {

			for (var i = 0; i < this.columns.length; i++) {
				var column = this.columns[i];
				this.configureEditMode(column);

				column.baseId = column.dataIndex + "-head";
				column.id = this.getId() + column.baseId;
				column.stateId = this.stateId + column.baseId;
				if (customConfig && customConfig.columns && customConfig.columns[column.dataIndex]) {
					Ext.apply(column, customConfig.columns[column.dataIndex]);
				}

				this.configureRenderers(column);

				this.configureFilters(column);

				// Si no hay configurado ancho, lo ponemos al mínimo. Después el proceso autoSize ya lo ampliará si es necesario
				if (!column.width) {
					column.width = 150;
				}

				this.configureSummaryType(column);


			}

			this.configureRowActions();
			this.bindActions();
			this.gridMetaData.configured = true;
		}
	},

	configureRowActions: function () {
		var customConfig = this.customConfig;
		var configProperties = this.configProperties;
		var gridMetaData = this.gridMetaData;
		if (!gridMetaData.disableOpenForm) {
			this.leftRowActions = Ext.apply({
				header: "&nbsp;",
				xtype: 'actioncolumn',
				width: 50,
				baseId: "-leftActions-head",
				id: this.getId() + "-leftActions-head",
				items: [{
					setIconCls: 'icon-add',
					//http://docs.sencha.com/extjs/4.2.0/#!/api/Ext.grid.column.Action
					icon: 'img/ico/Editar_ico.png', // Use a URL in the icon config
					//tooltip: 'Edit',
					tooltip: this.abrirText,
					handler: function (grid, rowIndex, colIndex) {
						var rec = grid.getStore().getAt(rowIndex);
						//alert("Edit " + rec.get('codigo'));
						//TODO: Test this:
						rec.data.oid = rec.data.oid || rec.data.codigo;
						this.openRecord(rec);
					}.bind(this)
				}]
			}, this.rowActionsDefaults);

			// Añadimos la columna
			this.columns.splice(0, 0, this.leftRowActions);

		}
		// Acciones de la columna derecha (guardar, borrar, exportar pdf, personalizadas)
		this.rightActions = new Array();
		this.hasRowActions = false;


		//TODO:	garrom: Creo que ya no hace falta porque el propio plug-in de
		// 		row edit te pone uno de guardar y otro de cancelar guardar
		if (configProperties.editMode) {
			saveButton = {
				iconCls: 'icon-disk',
				getClass: function (v, meta, rec) {
					if (rec.dirty) {
						return 'icon-disk';
					} else {
						return 'x-item-disabled-icon-disk';
					}
				},
				tooltip: this.guardarText,
				disabled: true,
				hideIndex: 'cannotSave'
			};


			//
			// copyButton = { iconCls:
			// 'icon-application-double', tooltip :
			// this.copiarText, };
			// this.rightActions.push(copyButton);
			//
			cancelButton = {
				iconCls: 'icon-cross',
				getClass: function (v, meta, rec) {
					if (rec.dirty) {
						return 'icon-cross';
					} else {
						return 'x-item-disabled-icon-cross';
					}
				},
				tooltip: this.guardarText,
				disabled: true,
				hideIndex: 'cannotSave'
			};
			this.rightActions.push(saveButton);
			this.rightActions.push(cancelButton);
			this.hasRowActions = true;
		}

		// boton borrar
		if (this.gridMetaData.showDeleteButton) {

			// boton borrar
			deleteButton = {
				iconCls: 'icon-minus',
				tooltip: this.eliminarText,
				hideIndex: 'cannotDelete'
			};
			this.rightActions.push(deleteButton);
			this.hasRowActions = true;
		}

		// acciones personalizadas
		if (customConfig && customConfig.rightActions) {
			for (var i = 0; i < customConfig.rightActions.length; i++) {
				this.rightActions.push(customConfig.rightActions[i]);
			}
			this.hasRowActions = true;
		}
	},

	bindActions: function () {
		if (this.hasRowActions) {
			if (this.rightActions) {
				var items = [];
				for (x in this.rightActions) {
					if (this.rightActions.hasOwnProperty(x)) {
						items.push({
							iconCls: this.rightActions[x].iconCls,
							//disabled: !!this.rightActions[x].disabled,
							getClass: this.rightActions[x].getClass,
							handler: this.rightRowActionsHandler,
							scope: this,
							tooltip: this.rightActions[x].tooltip
						});
					}
				}

				this.rightRowActions = Ext.apply({
					header: this.accionesText,
					xtype: 'actioncolumn',
					baseId: "-rightActions-head",
					id: this.getId() + "-rightActions-head",
					width: 100,
					items: items
				}, this.rowActionsDefaults);

			}
			// Añadimos la columna
			this.columns[this.columns.length] = this.rightRowActions;
		} // cierra (actions)
	},


	// campos editables
	configureEditMode: function (column) {
		var customConfig = this.customConfig;
		var configProperties = this.configProperties;
		if (configProperties.editMode) {
			if (column.editable) {
				var editor = {};
				if (customConfig && customConfig.editor && customConfig.editor[column.dataIndex]) {
					editor = customConfig.editor[column.dataIndex];
				} else {
					editor = this.formPanel.getFieldEditor(column.dataIndex);
				}

				if (editor) {
					column.editor = editor;
					column.editor.grid = this;
					column.editor.boxLabelCls = "at4-hidden";
					column.editor.labelCls = "at4-hidden";
					if (!editor.disabled) {
						column.cls = 'editable-cell-header';
						column.tdCls = 'editable-cell';
					}
				}
			}
		} else {
			column.editable = false;
		}
	},
	// renderers de campos
	configureRenderers: function (column) {
		var customConfig = this.customConfig;
		var gridMetaData = this.gridMetaData;
		/* Si hay un renderer especial, lo configuramos */
		column.minWidth = 70;
		column.maxWidth = 1024;
		column.autoSizeMinWidth = 70;
		column.autoSizeMaxWidth = 240;
		if (customConfig && customConfig.renderers && customConfig.renderers[column.dataIndex]) {
			column.renderer = customConfig.renderers[column.dataIndex];
		} else if (column.sofaRenderer) {
			switch (column.sofaRenderer) {
			case 'text':
				column.renderer = function (value, metaData, record, rowIndex, colIndex, store) {
					metaData.css = 'sofa-wrap-normal';
					var rendered = Ext.util.Format.ellipsis(value, 300);
					//record.data.rendered_parents = rendered;
					return rendered;
				};
				if (!column.width) {
					column.width = 120;
				}
				column.autoSizeMinWidth = 70;
				column.autoSizeMaxWidth = 200;
				// marcamos la columna para no calcular el tamaño
				break;
			case 'largetext':
				column.renderer = function (value, metaData, record, rowIndex, colIndex, store) {
					metaData.css = 'sofa-wrap-normal';
					var rendered = Ext.util.Format.ellipsis(value, 300);
					return rendered;
				};
				if (!column.width) {
					column.width = 240;
				}
				column.autoSizeMinWidth = 160;
				column.autoSizeMaxWidth = 240;
				// marcamos la columna para no calcular el tamaño
				break;
			case 'many2many':
				column.renderer = function (value, metaData, record, rowIndex, colIndex, store) {
					metaData.css = 'sofa-wrap-normal';
					if (value == '' || value == null || value.length < 1) {
						return value;
					}
					/* separando con un separador */
					var separator = ', ';
					var ret = '';
					for (var i = 0; i < value.length; i++) {
						if (i > 0) {
							ret += separator;
						}
						ret += value[i].primaryLabel;
					}

					return ret;
				};
				if (!column.width) {
					column.width = 240;
				}
				column.autoSizeMinWidth = 240;
				column.autoSizeMaxWidth = 240;
				// marcamos la columna para no calcular el tamaño
				break;
			case 'password':
				column.renderer = function (value, metaData, record, rowIndex, colIndex, store) {
					return "********";
				};
				break;
			case 'date':
				column.renderer = function (value, metaData, record, rowIndex, colIndex, store) {
					var rendered = "";
					if (value) {
						rendered = Ext.Date.format(value, 'd-m-Y');
					}
					return rendered;
				}
				break;
			case 'datetime':
				column.renderer = function (value, metaData, record, rowIndex, colIndex, store) {
					var rendered = "";
					if (value) {
						rendered = Ext.Date.format(value, 'd-m-Y H:i');
					}
					return rendered;
				}
				break;
			case 'time':
				column.renderer = Ext.util.Format.dateRenderer('H:i:s');
				break;
			case 'euromoney':
				column.renderer = Ext.util.Format.euroMoney;
				column.align = 'right';
				break;
			case 'bulkimage':
			case 'binfile':
				column.renderer = function (
					value, metaData, record,
					rowIndex, colIndex, store) {
					return value ? this.yesText : this.noText;
				}.bind(this);
				break;
			case 'boolean':
				column.renderer = function (
					value, metaData, record,
					rowIndex, colIndex, store) {
					if (value === null) {
						return '';
					}
					return value ? this.yesText : this.noText;
				}.bind(this);
				break;
			case 'popup':

				var modelName = 'At4FrameworkIntranet.simpleStoreModel' + gridMetaData.formItem.form + column.dataIndex;
				if (!eval(modelName)) {
					Ext.define(modelName, {
						extend: 'Ext.data.Model',
						fields: ['ID', 'DISPLAY'],
						idProperty: "ID"
					});
				}
				column.columnStore = Ext.create("Ext.data.Store", {
					model: modelName,
					data: column.sofaStoreValues
				});
				column.renderer = this.columnStoreRenderer.bind(this);
				break;

			case 'relationpopup':

				// TODO: configurar los filtros tipo "list"

				var columnName = column.dataIndex;
				var relatedForm = column.relatedForm;

				column.columnStore = Ext.create("Ext.data.Store", {
					proxy: serverDatabaseActions.createRelationPopupProxy(relatedForm),
					reader: {
						type: "json",
						totalProperty: "totalNumRecords",
						rootProperty: "resultados",
						id: 'ID'
					},
					fields: [{
						name: "ID"
					}, {
						name: "DISPLAY"
					}],
				});

				column.columnStore.load();
				column.renderer = this.columnStoreRenderer.bind(this);
				break;

			case 'checkbox':
				break;
			}
		}


	},
	// filtros de campos
	configureFilters: function (column) {
		var configProperties = this.configProperties;
		var customConfig = this.customConfig;
		if (configProperties.useFilters) {
			var newFilter = null;
			if (column.sofaFilter) {
				var type = column.sofaFilter.type;
				switch (type) {
				case "multicombo":
					if (!column.columnStore) {

						if (customConfig && customConfig.columnStore && customConfig.columnStore[column.dataIndex]) {
							column.columnStore = customConfig.columnStore[column.dataIndex];
						} else {
							var relatedForm = column.relatedForm;
							column.columnStore = At4FrameworkIntranet.FormDefaults.getStore(relatedForm);
						}

					}

					if (column.columnStore) {
						column.sofaFilter.type = 'multiList';
						//column.sofaFilter.type = 'list';
						column.sofaFilter.labelField = "DISPLAY";
						column.sofaFilter.idField = "ID";
						column.sofaFilter.phpMode = true;
						column.sofaFilter.store = column.columnStore;
						/* if (column.sofaStoreValues) {
							 column.sofaFilter.mode = 'local';
						 }*/
						newFilter = column.sofaFilter;
					}
					break;
					// case "multiList":
				case "list":
					if (column.sofaStoreValues) {
						column.sofaFilter.labelField = 'DISPLAY';
						column.sofaFilter.phpMode = true;
						column.sofaFilter.options = column.sofaStoreValues;
						newFilter = column.sofaFilter;
					}
					break;
				default:
					newFilter = column.sofaFilter;
					break;

				}
				column.filter = column.sofaFilter;
			}

		}
	},
	// summary de campos
	configureSummaryType: function (column) {
		var configProperties = this.configProperties;
		// Si está configurado el tipo de sumario, marcamos para que se incluya el plugin
		if (column.summaryType) {
			this.gridMetaData.useGroupSummary = true;
			//column.summaryType = "count";
			column.summaryRenderer = function (value, metaData, record, rowIndex, colIndex, store) {
				if (this.renderer) {
					value = this.renderer(value, metaData, record, rowIndex, colIndex, store);
				}
				//console.log(colIndex + metaData.column.text + ": " + value);
				//this.renderizadoSummary = metaData.column.text + ": " + value;
				this.renderizadoSummary = metaData[this.id].text + ": " + value;
				//metaData.tdAttr = 'style="color: red; background-color: #F1F2F4 !important;"'
				return value;
			}.bind(column);
		}
	},
	rightRowActionsHandler: function (grid, rowIndex, colIndex, action, event, record) {
		//console.log(action.iconCls);
		switch (action.iconCls) { // alert("??" + action);
		case 'icon-minus':
			this.deleteRecord(record);
			break;
		case 'icon-disk':
			this.updateRecord(record);
			break;
		case 'icon-cross':
			this.rejectRecord(record);
			break;
		case 'icon-arrow-up':
			this.actualizarPosicion(record, 'up');
			break;
		case 'icon-arrow-down':
			this.actualizarPosicion(record, 'down');
			break;
		case 'icon-map':
			this.mostrarMapa(record);
			break;
		case 'icon-application-double':
			alert('duplicado');
			break;
		default:
			Ext.toast("Error: Accion no reconocida.");
			break;
		}
	},

	/*applyState: function(state){
		console.log(arguments);
		 this.callParent(arguments);
		 //his.store.load();
	},
	getState: function () {
		console.log(arguments);
		var state = this.callParent(arguments);
		return state;
	}
	applyState: function (state) {
		//test.columns[6].setVisible(false);
		//Ext.each(this.columns, function (i, column) {

		//});
		this.reconfigure(this.store, state.columns);
	},
	getState: function () {
		var me = this;
		//state = me.callParent(),
		var state = {};
		state.columns = [];
		storeState = me.store.getState();
		Ext.each(this.columns, function ( column, i) {
			state.columns[i] = {
				width: column.width,
				visible: column.isVisible(),
				id: column.stateId
			}
		}.bind(me));
		return state;
	}*/

});
