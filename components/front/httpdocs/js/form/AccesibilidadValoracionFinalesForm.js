//Namespace de  At4FrameworkIntranet
Ext.namespace('At4FrameworkIntranet');

/**
 * @class At4FrameworkIntranet.AccesibilidadValoracionFinalesForm
 * Contiene la configuración del formulario: AccesibilidadValoracionFinales
 * @author garrom
 * @constructor
 * @extends At4FrameworkIntranet.BasicForm
 * @param {Object} application La aplicación que contiene el formulario, normalmente será {@link At4FrameworkIntranet.app}
 * @param {String} formName Nombre del formulario
 * @param {Object} gridMetaData Configuración gridMetadata
 * @param {Object} config Configuración para Ext.form.FormPanel
 */

Ext.define("At4FrameworkIntranet.AccesibilidadValoracionFinalesForm", {
	extend: "At4FrameworkIntranet.InspeccionBaseForm",
	constructor: function (application, formName, gridMetaData, config) {
		Ext.apply(this, config);
		var tabHelper = new At4util.tabIndexHelper(this.tabIndex);

		var columnDefaults = At4FrameworkIntranet.FormDefaults.COLUMN_DEFAULTS;
		var fieldDefaults = At4FrameworkIntranet.FormDefaults.FIELD_DEFAULTS;

		var fields = {}


		var deficienciasViviendaInformacionsenalizacionStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'deficienciasViviendaInformacionsenalizacion') {
				deficienciasViviendaInformacionsenalizacionStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var deficienciasViviendaInformacionsenalizacionStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: deficienciasViviendaInformacionsenalizacionStoreValues
		});
		var deficienciasPublicoAlojamientosaccesiblesStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'deficienciasPublicoAlojamientosaccesibles') {
				deficienciasPublicoAlojamientosaccesiblesStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var deficienciasPublicoAlojamientosaccesiblesStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: deficienciasPublicoAlojamientosaccesiblesStoreValues
		});
		var deficienciasPublicoAparcamientoStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'deficienciasPublicoAparcamiento') {
				deficienciasPublicoAparcamientoStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var deficienciasPublicoAparcamientoStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: deficienciasPublicoAparcamientoStoreValues
		});
		var deficienciasPublicoEntreplantasStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'deficienciasPublicoEntreplantas') {
				deficienciasPublicoEntreplantasStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var deficienciasPublicoEntreplantasStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: deficienciasPublicoEntreplantasStoreValues
		});
		var deficienciasPublicoPiscinasStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'deficienciasPublicoPiscinas') {
				deficienciasPublicoPiscinasStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var deficienciasPublicoPiscinasStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: deficienciasPublicoPiscinasStoreValues
		});
		var deficienciasPublicoMecanismosStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'deficienciasPublicoMecanismos') {
				deficienciasPublicoMecanismosStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var deficienciasPublicoMecanismosStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: deficienciasPublicoMecanismosStoreValues
		});

		var deficienciasPublicoPlazasreservadasStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'deficienciasPublicoPlazasreservadas') {
				deficienciasPublicoPlazasreservadasStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var deficienciasPublicoPlazasreservadasStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: deficienciasPublicoPlazasreservadasStoreValues
		});

		var deficienciasPublicoPlantasStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'deficienciasPublicoPlantas') {
				deficienciasPublicoPlantasStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var deficienciasPublicoPlantasStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: deficienciasPublicoPlantasStoreValues
		});

		var deficienciasPublicoExteriorStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'deficienciasPublicoExterior') {
				deficienciasPublicoExteriorStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var deficienciasPublicoExteriorStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: deficienciasPublicoExteriorStoreValues
		});

		var deficienciasPublicoMobiliariofijoStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'deficienciasPublicoMobiliariofijo') {
				deficienciasPublicoMobiliariofijoStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var deficienciasPublicoMobiliariofijoStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: deficienciasPublicoMobiliariofijoStoreValues
		});

		var deficienciasPublicoServicioshigienicosStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'deficienciasPublicoServicioshigienicos') {
				deficienciasPublicoServicioshigienicosStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var deficienciasPublicoServicioshigienicosStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: deficienciasPublicoServicioshigienicosStoreValues
		});

		var deficienciasPublicoInformacionsenalizacionStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'deficienciasPublicoInformacionsenalizacion') {
				deficienciasPublicoInformacionsenalizacionStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var deficienciasPublicoInformacionsenalizacionStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: deficienciasPublicoInformacionsenalizacionStoreValues
		});

		var deficienciasViviendaPlantasStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'deficienciasViviendaPlantas') {
				deficienciasViviendaPlantasStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var deficienciasViviendaPlantasStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: deficienciasViviendaPlantasStoreValues
		});

		var deficienciasViviendaPiscinasStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'deficienciasViviendaPiscinas') {
				deficienciasViviendaPiscinasStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var deficienciasViviendaPiscinasStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: deficienciasViviendaPiscinasStoreValues
		});

		var deficienciasViviendaEntreplantasStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'deficienciasViviendaEntreplantas') {
				deficienciasViviendaEntreplantasStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var deficienciasViviendaEntreplantasStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: deficienciasViviendaEntreplantasStoreValues
		});

		var deficienciasViviendaMecanismosStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'deficienciasViviendaMecanismos') {
				deficienciasViviendaMecanismosStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var deficienciasViviendaMecanismosStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: deficienciasViviendaMecanismosStoreValues
		});

		var deficienciasViviendaAparcamientoStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'deficienciasViviendaAparcamiento') {
				deficienciasViviendaAparcamientoStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var deficienciasViviendaAparcamientoStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: deficienciasViviendaAparcamientoStoreValues
		});
		var deficienciasViviendaExteriorStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'deficienciasViviendaExterior') {
				deficienciasViviendaExteriorStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var deficienciasViviendaExteriorStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: deficienciasViviendaExteriorStoreValues
		});

		var deficienciasViviendaServicioshigienicosStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'deficienciasViviendaServicioshigienicos') {
				deficienciasViviendaServicioshigienicosStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var deficienciasViviendaServicioshigienicosStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: deficienciasViviendaServicioshigienicosStoreValues
		});

		var satisfaceCondicionesBasicasStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'satisfaceCondicionesBasicas') {
				satisfaceCondicionesBasicasStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var satisfaceCondicionesBasicasStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: satisfaceCondicionesBasicasStoreValues
		});


		fields.claveInforme = new Ext.form.NumberField({
			name: 'claveInforme',
			fieldLabel: this.claveInformeHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 3, 15),
			disableUpdates: true,
			disabled: true,
			hideTrigger: true,
			allowBlank: false,
			allowDecimals: false,
			maxValue: 2147483647
		})
		fields.edificio = new At4FrameworkIntranet.RelatedBox({
			name: 'edificioId',
			fieldLabel: this.edificioHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(6, 3, 12),
			relatedIconCls: "glyphicons glyphicons-building",
			relatedForm: 'edificio'
		})

		/*fields.inspeccion = new At4FrameworkIntranet.ComboBox({
		    name: 'inspeccionId',
		    fieldLabel: this.inspeccionHeaderLabel,
		    tabIndex: tabHelper.getNext(),
		    width: At4FrameworkIntranet.FormDefaults.size(3, 3, 15),
		    allowBlank: false,
		    store: At4FrameworkIntranet.FormDefaults.getStore('Inspeccion'),
		    recordPK: 'id',
		    relatedForm: 'inspeccion'
		})*/


		fields.inspeccionId = Ext.create("Ext.ux.at4.OneToOneField", {
			name: 'inspeccionId',
			fieldLabel: this.inspeccionHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 2, 12),
			border: true,
			application: application,
			relatedIconCls: "",
			relatedForm: 'inspeccion'
		})

		fields.satisfaceCondicionesBasicas = Ext.create('Ext.form.ComboBox', {
			name: 'satisfaceCondicionesBasicas',
			fieldLabel: this.satisfaceCondicionesBasicasHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(4.166, 0, 12),
			store: satisfaceCondicionesBasicasStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})
		fields.deficienciasPublicoExterior = Ext.create('Ext.form.ComboBox', {
			name: 'deficienciasPublicoExterior',
			fieldLabel: this.deficienciasPublicoExteriorHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 2, 12),
			store: deficienciasPublicoExteriorStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})
		fields.deficienciasPublicoEntreplantas = Ext.create('Ext.form.ComboBox', {
			name: 'deficienciasPublicoEntreplantas',
			fieldLabel: this.deficienciasPublicoEntreplantasHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.deficienciasPublicoEntreplantasDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 2, 12),
			store: deficienciasPublicoEntreplantasStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})
		fields.deficienciasPublicoPlantas = Ext.create('Ext.form.ComboBox', {
			name: 'deficienciasPublicoPlantas',
			fieldLabel: this.deficienciasPublicoPlantasHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 2, 12),
			store: deficienciasPublicoPlantasStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})
		fields.deficienciasPublicoAlojamientosaccesibles = Ext.create('Ext.form.ComboBox', {
			name: 'deficienciasPublicoAlojamientosaccesibles',
			fieldLabel: this.deficienciasPublicoAlojamientosaccesiblesHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.deficienciasPublicoAlojamientosaccesiblesDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 2, 12),
			store: deficienciasPublicoAlojamientosaccesiblesStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})
		fields.deficienciasPublicoAparcamiento = Ext.create('Ext.form.ComboBox', {
			name: 'deficienciasPublicoAparcamiento',
			fieldLabel: this.deficienciasPublicoAparcamientoHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.deficienciasPublicoAparcamientoDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 2, 12),
			store: deficienciasPublicoAparcamientoStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})
		fields.deficienciasPublicoPlazasreservadas = Ext.create('Ext.form.ComboBox', {
			name: 'deficienciasPublicoPlazasreservadas',
			fieldLabel: this.deficienciasPublicoPlazasreservadasHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.deficienciasPublicoPlazasreservadasDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 2, 12),
			store: deficienciasPublicoPlazasreservadasStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})
		fields.deficienciasPublicoPiscinas = Ext.create('Ext.form.ComboBox', {
			name: 'deficienciasPublicoPiscinas',
			fieldLabel: this.deficienciasPublicoPiscinasHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 2, 12),
			store: deficienciasPublicoPiscinasStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})
		fields.deficienciasPublicoMobiliariofijo = Ext.create('Ext.form.ComboBox', {
			name: 'deficienciasPublicoMobiliariofijo',
			fieldLabel: this.deficienciasPublicoMobiliariofijoHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.deficienciasPublicoMobiliariofijoDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 2, 12),
			store: deficienciasPublicoMobiliariofijoStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		fields.deficienciasPublicoServicioshigienicos = Ext.create('Ext.form.ComboBox', {
			name: 'deficienciasPublicoServicioshigienicos',
			fieldLabel: this.deficienciasPublicoServicioshigienicosHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.deficienciasPublicoServicioshigienicosDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 2, 12),
			store: deficienciasPublicoServicioshigienicosStore,
			queryMode: 'local',
			labelStyle: 'white-space: nowrap',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})









		fields.deficienciasPublicoMecanismos = Ext.create('Ext.form.ComboBox', {
			name: 'deficienciasPublicoMecanismos',
			fieldLabel: this.deficienciasPublicoMecanismosHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.deficienciasPublicoMecanismosDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 2, 12),
			store: deficienciasPublicoMecanismosStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})
		fields.deficienciasViviendaInformacionsenalizacion = Ext.create('Ext.form.ComboBox', {
			name: 'deficienciasViviendaInformacionsenalizacion',
			fieldLabel: this.deficienciasViviendaInformacionsenalizacionHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.deficienciasViviendaInformacionsenalizacionDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(4.166, 0, 12),
			store: deficienciasViviendaInformacionsenalizacionStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})
		fields.deficienciasPublicoInformacionsenalizacion = Ext.create('Ext.form.ComboBox', {
			name: 'deficienciasPublicoInformacionsenalizacion',
			fieldLabel: this.deficienciasPublicoInformacionsenalizacionHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.deficienciasPublicoInformacionsenalizacionDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(5, 2, 12),
			store: deficienciasPublicoInformacionsenalizacionStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})









		fields.deficienciasViviendaPlantas = Ext.create('Ext.form.ComboBox', {
			name: 'deficienciasViviendaPlantas',
			fieldLabel: this.deficienciasViviendaPlantasHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 2, 12),
			store: deficienciasViviendaPlantasStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})
		fields.deficienciasViviendaEntreplantas = Ext.create('Ext.form.ComboBox', {
			name: 'deficienciasViviendaEntreplantas',
			fieldLabel: this.deficienciasViviendaEntreplantasHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.deficienciasViviendaEntreplantasDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 2, 12),
			store: deficienciasViviendaEntreplantasStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})






		fields.deficienciasViviendaMecanismos = Ext.create('Ext.form.ComboBox', {
			name: 'deficienciasViviendaMecanismos',
			fieldLabel: this.deficienciasViviendaMecanismosHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.deficienciasViviendaMecanismosDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 2, 12),
			store: deficienciasViviendaMecanismosStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})


		fields.deficienciasViviendaAparcamiento = Ext.create('Ext.form.ComboBox', {
			name: 'deficienciasViviendaAparcamiento',
			fieldLabel: this.deficienciasViviendaAparcamientoHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.deficienciasViviendaAparcamientoDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 2, 12),
			store: deficienciasViviendaAparcamientoStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})


		fields.deficienciasViviendaExterior = Ext.create('Ext.form.ComboBox', {
			name: 'deficienciasViviendaExterior',
			fieldLabel: this.deficienciasViviendaExteriorHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.deficienciasViviendaExteriorDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 2, 12),
			store: deficienciasViviendaExteriorStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})


		fields.deficienciasViviendaServicioshigienicos = Ext.create('Ext.form.ComboBox', {
			name: 'deficienciasViviendaServicioshigienicos',
			fieldLabel: this.deficienciasViviendaServicioshigienicosHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.deficienciasViviendaServicioshigienicosDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 2, 12),
			store: deficienciasViviendaServicioshigienicosStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})


		fields.deficienciasViviendaPiscinas = Ext.create('Ext.form.ComboBox', {
			name: 'deficienciasViviendaPiscinas',
			fieldLabel: this.deficienciasViviendaPiscinasHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.deficienciasViviendaPiscinasDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 2, 12),
			store: deficienciasViviendaPiscinasStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})


		this.fields = fields;
		var items = [{
			xtype: 'At4Framework-fieldmainpanel',
			items: [
				At4FrameworkIntranet.FormDefaults.rows([
					[fields.claveInforme, fields.edificio, fields.inspeccionId],
					[fields.satisfaceCondicionesBasicas],
					[{

						xtype: 'fieldset',
						border: true,
						title: this.deficienciasCondicionesFuncionalesTitleLabel,
						items: [{
							xtype: "At4Framework-rowContainer",
							minWidth: false,
							items: [fields.deficienciasPublicoExterior, fields.deficienciasPublicoEntreplantas, fields.deficienciasPublicoPlantas]

						}]
					}],
					[{

						xtype: 'fieldset',
						border: true,
						title: this.deficienciasEnDotacionDeElementosAccesiblesTitleLabel,
						items: [{
							xtype: "At4Framework-rowContainer",
							minWidth: false,
							items: [fields.deficienciasPublicoAlojamientosaccesibles, fields.deficienciasPublicoAparcamiento, fields.deficienciasPublicoPlazasreservadas]
						}, {
							xtype: "At4Framework-rowContainer",
							minWidth: false,
							items: [fields.deficienciasPublicoPiscinas, fields.deficienciasPublicoMobiliariofijo, fields.deficienciasPublicoServicioshigienicos]
						}, {
							xtype: "At4Framework-rowContainer",
							minWidth: false,
							items: [fields.deficienciasPublicoMecanismos]
						}]
					}],
					[{

						xtype: 'fieldset',
						border: true,
						title: this.deficienciasEnDotacionCaracterizacionSenalización,
						items: [{
							xtype: "At4Framework-rowContainer",
							minWidth: false,
							items: [fields.deficienciasViviendaInformacionsenalizacion, fields.deficienciasPublicoInformacionsenalizacion]
						}]
					}],
					[{

						xtype: 'fieldset',
						border: true,
						title: this.deficienciasGeneralesTitleLabel,
						items: [{
							xtype: "At4Framework-rowContainer",
							minWidth: false,
							items: [fields.deficienciasViviendaPlantas, fields.deficienciasViviendaEntreplantas, fields.deficienciasViviendaMecanismos]
						}, {
							xtype: "At4Framework-rowContainer",
							minWidth: false,
							items: [fields.deficienciasViviendaAparcamiento, fields.deficienciasViviendaExterior, fields.deficienciasViviendaServicioshigienicos]
						}, {
							xtype: "At4Framework-rowContainer",
							minWidth: false,
							items: [fields.deficienciasViviendaPiscinas]
						}, ]
					}],
					[At4FrameworkIntranet.FormDefaults.resumenAuditoria()]
				])
			]
		}];



		this.maxTabIndex = tabHelper.getNext();
		this.callParent([application, formName, gridMetaData, items, config]);
	}
});
