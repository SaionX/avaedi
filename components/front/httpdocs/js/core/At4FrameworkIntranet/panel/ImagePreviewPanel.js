//Filename: ImagePreviewPanel
Ext.namespace('At4FrameworkIntranet');

Ext.define("At4FrameworkIntranet.ImagePreviewPanel", {
	extend: "At4FrameworkIntranet.BasicPanel",
	cls: "at4imagePanel",
	itemSelector: "div.thumb-wrap",

	constructor: function (parentFormPanel, config) {
		//TODO: Localear
		this.isFotoGrande = true;
		this.aumentaTamano = {
			xtype: "button",
			text: "Cambiar tamaño",
			handler: this.toggleSize,
			scope: this
		};
		/*this.disminuyeTamano = {
			xtype: "button",
			text: "Disminuir tamaño"
		};*/
		this.extraButtons = [this.aumentaTamano /*,this.disminuyeTamano*/ ];

		this.callParent(arguments);
	},
	toggleSize: function () {
		if (!this.isFotoGrande) {
			this.setSize(true);
			this.isFotoGrande = true;
		} else {
			this.setSize(false);
			this.isFotoGrande = false;
		}

	},
	setSize: function (grande) {
		if (this.el) {
			if (grande) {
				this.el.select(".fotoPanel").addCls("grande");
			} else {
				this.el.select(".fotoPanel").removeCls("grande");
			}
			this.doLayout();
		}
	},

	onRenderDragZoneFunction: function (view, eopts) {
		this.setSize(this.isFotoGrande);
		//Activamos dragNdrop para los records que tengan el campo orden
		if (this.orderField && this.store.getModel().getField(this.orderField)) {
			// console.log("Metiendo eventos");
			var fotos = view.getEl().query(".thumb-wrap");
			var dragBefore = view.getEl().query(".drop-before");
			var dragAfter = view.getEl().query(".drop-after");

			var zoneConfig = {
				view: view,
				//ddGroup: "fotoGroup"
			};
			var overrides = {
				startDrag: function (e) {
					Ext.each(fotos, function (el) {
						if (this.el == el) {
							return;
						}
						Ext.fly(el).addCls('noEventsPls');
					});
					//console.log('startDrag');
					var xy = this.el.getXY()
						//console.log("x: " + xy[0] + "  //  y: " + xy[1]);
					this.initialPosition = xy;
				},
				onDrag: function (e) {
					//move the item where the mouse moves
					//console.log('onDrag');
					this.el.setXY([e.getX() - 32, e.getY() - 32]);
				},
				onDragEnter: function (e, id) {
					var splited = id.split("Foto");
					var data = {
						idElemento: this.id.split("foto")[1],
						targetPos: splited[0],
						targetId: splited[1]
					};
					if (data.idElemento != data.targetId) {
						Ext.fly(id).addCls('valid-zone');
					}
				},
				onDragOver: function (e, id) {

				},
				onDragOut: function (e, id) {
					//console.log('onDragOut');
					Ext.fly(id).removeCls('valid-zone');
				},
				onDragDrop: function (e, id) {
					Ext.each(fotos, function (el) {
						Ext.fly(el).removeCls('noEventsPls');
					});
					var splited = id.split("Foto");
					var data = {
						idElemento: this.id.split(e.target.dataset["nombre"])[1],
						targetPos: splited[0],
						targetId: splited[1]
					};
					if (data.idElemento == data.targetId) {
						return this.onInvalidDrop();
					}
					//console.log(data);
					view.fireEvent("recordsOrdered", view, data);
				},
				onInvalidDrop: function () {
					this.el.setXY(this.initialPosition);
					Ext.each(fotos, function (el) {
						Ext.fly(el).removeCls('noEventsPls');
					});

					//console.log('onInvalidDrop');
				},
				endDrag: function (e, id) {
					//console.log('endDrag');
				}
			};
			Ext.each(fotos, function (el) {
				var dd = Ext.create('Ext.dd.DD', el, 'fotoDDGroup', {
					isTarget: false
				});
				Ext.apply(dd, overrides);
			});

			Ext.each(dragBefore, function (el) {
				var elId = el.getAttribute("id");
				var mainTarget = Ext.create('Ext.dd.DDTarget', elId, 'fotoDDGroup', {
					ignoreSelf: false
				});
			});

			Ext.each(dragAfter, function (el) {
				var elId = el.getAttribute("id");
				var mainTarget = Ext.create('Ext.dd.DDTarget', elId, 'fotoDDGroup', {
					ignoreSelf: false
				});
			});
		}
	},
	onRecordsOrdered: function (view, data) {
		var store = view.getStore();
		var items = store.getData().items;
		var source = store.getById(data.idElemento);
		var sourceIdx = items.indexOf(source);
		var target = store.getById(data.targetId);

		store.beginUpdate();
		store.remove(source);
		var targetIndex = items.indexOf(target);
		var targetIndex = data.targetPos == "before" ? targetIndex : targetIndex + 1;
		store.insert(targetIndex, source);
		var suorden = 0;
		var orderField = this.orderField
		store.each(function (record) {
			suorden++;
			record.set(orderField, suorden);
		})
		store.endUpdate();
		//para que el view recargue
		store.loadData(store.getData().items);
		//para que se vuelvan a bindear las imagenes
		this.isBussy = true;
		this.onRenderDragZoneFunction(view);
		this.sendUpdatedFields();
	},
	sendUpdatedFields: function () {
		// console.log("Records sent!");
		var formName = this.editForm.application.formName;
		var formId = this.editForm.application.dataId;
		var subFormName = this.editForm.subFormName;
		//var items = this.store.getModifiedRecords();
		//TODO: garrom: No se porque pero ahora los records no se marcan como modificados
		var items = this.store.getData().items;
		var fotos = this.dataView.getEl().query(".thumb-wrap");
		Ext.each(fotos, function (el) {
			Ext.fly(el).addCls('noEventsPls');
		});
		serverDatabaseActions.updateSubFormList(formName, subFormName, formId, items, this.updateRecordCallback, this);
	},
	updateRecordCallback: function () {
		this.callParent(arguments);
		//para que se vuelvan a bindear las imagenes
		this.isBussy = false;
		this.onRenderDragZoneFunction(this.dataView);
	},
	cancelUpdatedFields: function () {
		var store = this.dataView.store;
		store.rejectChanges();
		this.checkUpdatedFelds();
		store.loadData(store.getData().items);
		this.onRenderDragZoneFunction(this.dataView);
	},
	dataViewDefaultConfig: {
		//emptyText: '##################EMPTY##################',
		bodyStyle: 'padding: 0px 0px 0px 0px',
		autoHeight: true,
		autoScroll: false,
		//layout: 'fit',
		layout: 'fit',
		multiSelect: false,
		singleSelect: true,
		//overCls: 'x-view-container-over',
		overItemCls: 'x-view-over',
		selectedItemCls: 'x-view-selected',

	},
	onUpdateRecordDone: function (form, newRecord, oldRecord) {
		if (!newRecord) {
			return;
		}
		var store = this.dataView.getStore();
		store.remove(store.findRecord("id", oldRecord.id));
		return this.onNewRecordDone(form, newRecord);
	},
	onNewRecordDone: function (form, newRecord) {
		var store = this.dataView.getStore();
		var resultado = this.reader.readRecords({
			'resultados': [newRecord],
			'totalNumRecords': 1
		});
		var record = resultado.records[0];
		store.add(record);
		store.loadData(store.getData().items);
		this.onRenderDragZoneFunction(this.dataView);
		return record;
	},
    afterDeleteForm: function(response) {
		var store = this.dataView.getStore();
        if (response.success) {
			//Notificamos a la aplicación de la eliminación del registro
			//var records = this.dataView.getSelectedRecords();
			var record = this.dataView.getRecord(this.dataView.getSelectedNodes()[0]);
			store.remove(record);
			//notificamos en barra de estado
			this.statusBar.setStatus({
				text: this.eliminadoTxt,
				clear: true // auto-clear after a set interval
			});
			store.loadData(store.getData().items);
			this.onRenderDragZoneFunction(this.dataView);
		} else {
            Ext.Msg.alert('Error:', response.message);
        }
	},
	setValues: function(){
		this.callParent(arguments);
		this.onRenderDragZoneFunction(this.dataView);
	},


	autoScroll: false,

});
