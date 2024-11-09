//Namespace de  At4FrameworkIntranet
Ext.namespace('At4FrameworkIntranet');

/**
 * @class At4FrameworkIntranet.InspeccionForm
 * Contiene la configuración del formulario: Inspeccion
 * @author garrom
 * @constructor
 * @extends At4FrameworkIntranet.BasicForm
 * @param {Object} application La aplicación que contiene el formulario, normalmente será {@link At4FrameworkIntranet.app}
 * @param {String} formName Nombre del formulario
 * @param {Object} gridMetaData Configuración gridMetadata
 * @param {Object} config Configuración para Ext.form.FormPanel
 */

Ext.define("At4FrameworkIntranet.InspeccionForm", {
	extend: "At4FrameworkIntranet.InspeccionBaseForm",
	constructor: function (application, formName, gridMetaData, config) {
		Ext.apply(this, config);
		var tabHelper = new At4util.tabIndexHelper(this.tabIndex);

		var columnDefaults = At4FrameworkIntranet.FormDefaults.COLUMN_DEFAULTS;
		var fieldDefaults = At4FrameworkIntranet.FormDefaults.FIELD_DEFAULTS;


		var fields = {}
		//------Campos cabecera------
		fields.id = new Ext.form.NumberField({
			cls: 'tiny-text',
			name: 'id',
			fieldLabel: this.idHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 1, 15),
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

		// fields.informe = new At4FrameworkIntranet.ComboBox({
		// 		name: 'informeId',
		// 		fieldLabel: this.informeHeaderLabel,
		// 		tabIndex: tabHelper.getNext(),
		// 		width: At4FrameworkIntranet.FormDefaults.size(3, 1, 15),
		// 		allowBlank: false,
		// 		store: At4FrameworkIntranet.FormDefaults.getStore('Informe'),
		// 		recordPK: 'clave',
		// 		relatedForm: 'informe'
		// 	})

		fields.informeId = Ext.create("Ext.ux.at4.OneToOneField", {
			name: 'informeId',
			fieldLabel: this.informeHeaderLabel,
			tabIndex: tabHelper.getNext(),
			border: true,
			application: application,
			relatedIconCls: "glyphicons glyphicons-newspaper",
			relatedForm: 'informe'
		})

		fields.principal = new Ext.ux.form.XCheckbox({
			name: 'principal',
			margin: "24 0 0 10 ",
			boxLabel: this.principalHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 5, 13),
		})
		//----------------------------
		//--------Datos generales-----
		fields.accesibilidadAjustesrazonablesCostes = new Ext.form.TextField({
			name: 'accesibilidadAjustesrazonablesCostes',
			fieldLabel: this.accesibilidadAjustesrazonablesCostesHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.accesibilidadAjustesrazonablesCostesDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(5, 2, 16),
			maxLength: 255
		})
		fields.conservacionDatosgeneralesArchivos = new Ext.form.TextField({
			name: 'conservacionDatosgeneralesArchivos',
			fieldLabel: this.conservacionDatosgeneralesArchivosHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.conservacionDatosgeneralesArchivosDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(5, 2, 16),
			maxLength: 255
		})

		/**fields.ieeCompleta = new Ext.form.NumberField({
			cls: 'tiny-text',
			name: 'ieeCompleta',
			fieldLabel: this.ieeCompletaHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 2, 16),
			allowDecimals: false,
			maxValue: 2147483647
		})**/


		var ieeStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'ieeCompleta') {
				ieeStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var ieeStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: ieeStoreValues
		});

		fields.ieeCompleta = Ext.create('Ext.form.ComboBox', {
			name: 'ieeCompleta',
			fieldLabel: this.ieeCompletaHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 2, 16),
			store: ieeStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})



		fields.alturaSobreRasante = new Ext.form.NumberField({
			cls: 'tiny-text',
			name: 'alturaSobreRasante',
			fieldLabel: this.alturaSobreRasanteHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 5, 16),
			decimalSeparator: ',',
			allowDecimals: true,
			decimalPrecision: 10,
			maxValue: 1.0E10 //1
		})
		fields.mediaViviendasPorPlanta = new Ext.form.NumberField({
			cls: 'tiny-text',
			name: 'mediaViviendasPorPlanta',
			fieldLabel: this.mediaViviendasPorPlantaHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 5, 16),
			allowDecimals: false,
			maxValue: 2147483647
		})
		fields.numAparcamientos = new Ext.form.NumberField({
			cls: 'tiny-text',
			name: 'numAparcamientos',
			fieldLabel: this.numAparcamientosHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 5, 16),
			allowDecimals: false,
			maxValue: 2147483647
		})
		fields.numLocales = new Ext.form.NumberField({
			cls: 'tiny-text',
			name: 'numLocales',
			fieldLabel: this.numLocalesHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 5, 16),
			allowDecimals: false,
			maxValue: 2147483647
		})
		fields.numTrasteros = new Ext.form.NumberField({
			cls: 'tiny-text',
			name: 'numTrasteros',
			fieldLabel: this.numTrasterosHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 5, 16),
			allowDecimals: false,
			maxValue: 2147483647
		})
		fields.numViviendas = new Ext.form.NumberField({
			cls: 'tiny-text',
			name: 'numViviendas',
			fieldLabel: this.numViviendasHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 5, 16),
			allowDecimals: false,
			maxValue: 2147483647
		})
		fields.anoConstruccion = new Ext.form.NumberField({
			cls: 'tiny-text',
			name: 'anoConstruccion',
			fieldLabel: this.anoConstruccionHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 5, 16),
			allowDecimals: false,
			maxValue: 2147483647
		})
		fields.anoConstruccionReferencia = new Ext.form.TextField({
			name: 'anoConstruccionReferencia',
			fieldLabel: this.anoConstruccionReferenciaHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(4, 5, 16),
			maxLength: 255
		})
		fields.anoRehabilitacion = new Ext.form.NumberField({
			cls: 'tiny-text',
			name: 'anoRehabilitacion',
			fieldLabel: this.anoRehabilitacionHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 5, 16),
			allowDecimals: false,
			maxValue: 2147483647
		})
		fields.anoRehabilitacionReferencia = new Ext.form.TextField({
			name: 'anoRehabilitacionReferencia',
			fieldLabel: this.anoRehabilitacionReferenciaHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(4, 5, 16),
			maxLength: 255
		})

		var nucleosEscalerasTipoIdStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'inspeccionDatosedificioNucleosescalerasTipoId') {
				nucleosEscalerasTipoIdStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var nucleosEscalerasTipoIdStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: nucleosEscalerasTipoIdStoreValues
		});

		fields.inspeccionDatosedificioNucleosescalerasTipoId = Ext.create('Ext.form.ComboBox', {
			name: 'inspeccionDatosedificioNucleosescalerasTipoId',
			fieldLabel: this.inspeccionDatosedificioNucleosescalerasTipoIdHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.inspeccionDatosedificioNucleosescalerasTipoIdDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 3, 12),
			store: nucleosEscalerasTipoIdStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var parcelaTipoIdStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'inspeccionDatosedificioParcelaTipoId') {
				parcelaTipoIdStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var parcelaIdStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: parcelaTipoIdStoreValues
		});

		fields.inspeccionDatosedificioParcelaTipoId = Ext.create('Ext.form.ComboBox', {
			name: 'inspeccionDatosedificioParcelaTipoId',
			fieldLabel: this.inspeccionDatosedificioParcelaTipoIdHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.inspeccionDatosedificioParcelaTipoIdDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(4, 3, 12),
			store: parcelaIdStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var unnucleosEscalerasTipoIdStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'inspeccionDatosedificioUnnucleoescalerasTipoId') {
				unnucleosEscalerasTipoIdStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var unnucleosEscalerasTipoIdStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: unnucleosEscalerasTipoIdStoreValues
		});

		fields.inspeccionDatosedificioUnnucleoescalerasTipoId = Ext.create('Ext.form.ComboBox', {
			name: 'inspeccionDatosedificioUnnucleoescalerasTipoId',
			fieldLabel: this.inspeccionDatosedificioUnnucleoescalerasTipoIdHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.inspeccionDatosedificioUnnucleoescalerasTipoIdDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 3, 12),
			store: unnucleosEscalerasTipoIdStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var usoTipoIdStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'inspeccionDatosedificioUsoTipoId') {
				usoTipoIdStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var usoTipoIdStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: usoTipoIdStoreValues
		});

		fields.inspeccionDatosedificioUsoTipoId = Ext.create('Ext.form.ComboBox', {
			name: 'inspeccionDatosedificioUsoTipoId',
			fieldLabel: this.inspeccionDatosedificioUsoTipoIdHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.inspeccionDatosedificioUsoTipoIdDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 3, 12),
			store: usoTipoIdStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		fields.plantasBajoRasanteUsoPrincipal = new Ext.form.NumberField({
			cls: 'tiny-text',
			name: 'plantasBajoRasanteUsoPrincipal',
			fieldLabel: this.plantasBajoRasanteUsoPrincipalHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.plantasBajoRasanteUsoPrincipalDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 2, 7),
			allowDecimals: false,
			maxValue: 2147483647
		})
		fields.plantasBajoRasanteUsosSecundarios = new Ext.form.NumberField({
			cls: 'tiny-text',
			name: 'plantasBajoRasanteUsosSecundarios',
			fieldLabel: this.plantasBajoRasanteUsosSecundariosHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.plantasBajoRasanteUsosSecundariosDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 2, 7),
			allowDecimals: false,
			maxValue: 2147483647
		})
		fields.plantasBajoRasanteUsosSecundariosTipo = new Ext.form.TextField({
			name: 'plantasBajoRasanteUsosSecundariosTipo',
			fieldLabel: this.plantasBajoRasanteUsosSecundariosTipoHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.plantasBajoRasanteUsosSecundariosTipoDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 2, 7),
			maxLength: 255
		})
		fields.plantasSobreRasanteUsoPrincipal = new Ext.form.NumberField({
			cls: 'tiny-text',
			name: 'plantasSobreRasanteUsoPrincipal',
			fieldLabel: this.plantasSobreRasanteUsoPrincipalHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.plantasSobreRasanteUsoPrincipalDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 2, 7),
			allowDecimals: false,
			maxValue: 2147483647
		})
		fields.plantasSobreRasanteUsosSecundarios = new Ext.form.NumberField({
			cls: 'tiny-text',
			name: 'plantasSobreRasanteUsosSecundarios',
			fieldLabel: this.plantasSobreRasanteUsosSecundariosHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.plantasSobreRasanteUsosSecundariosDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 2, 7),
			allowDecimals: false,
			maxValue: 2147483647
		})
		fields.plantasSobreRasanteUsosSecundariosTipo = new Ext.form.TextField({
			name: 'plantasSobreRasanteUsosSecundariosTipo',
			fieldLabel: this.plantasSobreRasanteUsosSecundariosTipoHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.plantasSobreRasanteUsosSecundariosTipoDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 2, 7),
			maxLength: 255
		})
		//------------------------------------
		//--------Superficies-----------------



		fields.totalAscensores = new Ext.form.TextField({
			name: 'totalAscensores',
			fieldLabel: this.totalAscensoresHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2.5, 3, 15),
			maxLength: 255
		})
		fields.totalEscaleras = new Ext.form.TextField({
			name: 'totalEscaleras',
			fieldLabel: this.totalEscalerasHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2.5, 3, 15),
			maxLength: 255
		})
		fields.totalViviendasConAccesoVariosNucleos = new Ext.form.TextField({
			name: 'totalViviendasConAccesoVariosNucleos',
			fieldLabel: this.totalViviendasConAccesoVariosNucleosHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.totalViviendasConAccesoVariosNucleosDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(5, 3, 15),
			maxLength: 255
		})
		fields.totalViviendasSinAccesoAscensor = new Ext.form.TextField({
			name: 'totalViviendasSinAccesoAscensor',
			fieldLabel: this.totalViviendasSinAccesoAscensorHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.totalViviendasSinAccesoAscensorDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(5, 3, 15),
			maxLength: 255
		})
		fields.usoTexto = new Ext.form.TextField({
			name: 'usoTexto',
			fieldLabel: this.usoTextoHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(5.5, 4, 15),
			maxLength: 255
		})
		fields.numero = new Ext.form.NumberField({
			cls: 'tiny-text',
			name: 'numero',
			fieldLabel: this.numeroHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(1.5, 4, 15),
			allowDecimals: false,
			maxValue: 2147483647
		})
		fields.tipoVia = new Ext.form.TextField({
			name: 'tipoVia',
			fieldLabel: this.tipoViaHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 4, 15),
			maxLength: 255
		})
		fields.via = new Ext.form.TextField({
			name: 'via',
			fieldLabel: this.viaHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 4, 15),
			maxLength: 255
		})
		fields.referenciaCatastral = new Ext.form.TextField({
			name: 'referenciaCatastral',
			fieldLabel: this.referenciaCatastralHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(4, 4, 15),
			maxLength: 255
		})
		fields.superficieConstruida = new Ext.form.NumberField({
			name: 'superficieConstruida',
			fieldLabel: this.superficieConstruidaHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2.5, 5, 12),
			decimalSeparator: ',',
			allowDecimals: true,
			decimalPrecision: 10,
			maxValue: 1.0E10 //1
		})
		fields.superficieMediaAparcamientos = new Ext.form.NumberField({
			name: 'superficieMediaAparcamientos',
			fieldLabel: this.superficieMediaAparcamientosHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2.5, 5, 11),
			decimalSeparator: ',',
			allowDecimals: true,
			decimalPrecision: 10,
			maxValue: 1.0E10 //1
		})
		fields.superficieMediaLocales = new Ext.form.NumberField({
			name: 'superficieMediaLocales',
			fieldLabel: this.superficieMediaLocalesHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2.5, 5, 12),
			decimalSeparator: ',',
			allowDecimals: true,
			decimalPrecision: 10,
			maxValue: 1.0E10 //1
		})
		fields.superficieMediaTrasteros = new Ext.form.NumberField({
			name: 'superficieMediaTrasteros',
			fieldLabel: this.superficieMediaTrasterosHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2.5, 5, 12),
			decimalSeparator: ',',
			allowDecimals: true,
			decimalPrecision: 10,
			maxValue: 1.0E10 //1
		})
		fields.superficieMediaViviendas = new Ext.form.NumberField({
			name: 'superficieMediaViviendas',
			fieldLabel: this.superficieMediaViviendasHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2.5, 2, 12),
			decimalSeparator: ',',
			allowDecimals: true,
			decimalPrecision: 10,
			maxValue: 1.0E10 //1
		})
		fields.superficieParcela = new Ext.form.NumberField({
			name: 'superficieParcela',
			fieldLabel: this.superficieParcelaHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2.5, 5, 12),
			decimalSeparator: ',',
			allowDecimals: true,
			decimalPrecision: 10,
			maxValue: 1.0E10 //1
		})

		//----------------------
		//-----Edificio-----
		fields.edificioCodigoPostal = new Ext.form.TextField({
			name: 'edificioCodigoPostal',
			fieldLabel: this.edificioCodigoPostalHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 3, 10),
			maxLength: 255
		})
		fields.edificioComunTexto = new Ext.form.TextField({
			name: 'edificioComunTexto',
			fieldLabel: this.edificioComunTextoHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 3, 10),
			maxLength: 255
		})
		fields.edificioNumeroManual = new Ext.form.TextField({
			name: 'edificioNumeroManual',
			fieldLabel: this.edificioNumeroManualHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 3, 10),
			maxLength: 255
		})
		fields.edificioObjetoTexto = new Ext.form.TextField({
			name: 'edificioObjetoTexto',
			fieldLabel: this.edificioObjetoTextoHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 3, 10),
			maxLength: 255
		})
		fields.edificioPisoLetra = new Ext.form.TextField({
			name: 'edificioPisoLetra',
			fieldLabel: this.edificioPisoLetraHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 2, 10),
			maxLength: 255
		})
		fields.edificioPoblacion = new Ext.form.TextField({
			name: 'edificioPoblacion',
			fieldLabel: this.edificioPoblacionHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(4, 2, 10),
			maxLength: 255
		})
		fields.edificioProvincia = new Ext.form.TextField({
			name: 'edificioProvincia',
			fieldLabel: this.edificioProvinciaHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(4, 2, 10),
			maxLength: 255
		})
		fields.edificioProvinciaId = new Ext.form.NumberField({
			cls: 'tiny-text',
			name: 'edificioProvinciaId',
			fieldLabel: this.edificioProvinciaIdHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 3, 10),
			allowDecimals: false,
			maxValue: 2147483647
		})
		fields.edificioRegimenTexto = new Ext.form.TextField({
			name: 'edificioRegimenTexto',
			fieldLabel: this.edificioRegimenTextoHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 3, 10),
			maxLength: 255
		})
		fields.edificioTipoViaManual = new Ext.form.TextField({
			name: 'edificioTipoViaManual',
			fieldLabel: this.edificioTipoViaManualHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 3, 10),
			maxLength: 255
		})
		fields.edificioViaManual = new Ext.form.TextField({
			name: 'edificioViaManual',
			fieldLabel: this.edificioViaManualHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 3, 10),
			maxLength: 255
		})
		fields.edificioObservaciones = new Ext.form.TextArea({
			name: 'edificioObservaciones',
			fieldLabel: this.edificioObservacionesHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(10, 0, 10),
			maxLength: 255
		})

		var edificioComunesTipoIdStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'edificioInspeccionIdentificacionedificioComunesTipoId') {
				edificioComunesTipoIdStore = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var edificioComunesTipoIdStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: edificioComunesTipoIdStore
		});

		fields.edificioInspeccionIdentificacionedificioComunesTipoId = Ext.create('Ext.form.ComboBox', {
			name: 'edificioInspeccionIdentificacionedificioComunesTipoId',
			fieldLabel: this.edificioInspeccionIdentificacionedificioComunesTipoIdHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.edificioInspeccionIdentificacionedificioComunesTipoIdDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 2, 10),
			store: edificioComunesTipoIdStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var edificioObjetoIdStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'edificioInspeccionIdentificacionedificioObjetoTipoId') {
				edificioObjetoIdStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var edificioObjetoIdStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: edificioObjetoIdStoreValues
		});

		fields.edificioInspeccionIdentificacionedificioObjetoTipoId = Ext.create('Ext.form.ComboBox', {
			name: 'edificioInspeccionIdentificacionedificioObjetoTipoId',
			fieldLabel: this.edificioInspeccionIdentificacionedificioObjetoTipoIdHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.edificioInspeccionIdentificacionedificioObjetoTipoIdDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(5, 2, 10),
			store: edificioObjetoIdStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})

		var propiedadRegimenIdStoreValues = [];
		//Buscamos la  columna para obtener los valores del store
		for (var i = 0; i < gridMetaData.columns.length; i++) {
			if (gridMetaData.columns[i].dataIndex == 'edificioInspeccionPropiedadRegimenTipoId') {
				propiedadRegimenIdStoreValues = gridMetaData.columns[i].sofaStoreValues;
			}
		}
		var propiedadRegimenIdStore = Ext.create('Ext.data.Store', {
			fields: ['ID', 'DISPLAY'],
			idProperty: "ID",
			data: propiedadRegimenIdStoreValues
		});

		fields.edificioInspeccionPropiedadRegimenTipoId = Ext.create('Ext.form.ComboBox', {
			name: 'edificioInspeccionPropiedadRegimenTipoId',
			fieldLabel: this.edificioInspeccionPropiedadRegimenTipoIdHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.edificioInspeccionPropiedadRegimenTipoIdDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 2, 10),
			store: propiedadRegimenIdStore,
			queryMode: 'local',
			valueField: 'ID',
			displayField: 'DISPLAY',
		})
		//----------------------
		//------Técnico, Titular y representante------
		fields.tecnicoNif = new Ext.form.TextField({
			name: 'tecnicoNif',
			fieldLabel: this.tecnicoNifHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 2, 12),
			maxLength: 255
		})
		fields.tecnicoTecnico = new Ext.form.TextField({
			name: 'tecnicoTecnico',
			fieldLabel: this.tecnicoTecnicoHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(4.5, 2, 12),
			maxLength: 255
		})
		fields.tecnicoTitulacion = new Ext.form.TextField({
			name: 'tecnicoTitulacion',
			fieldLabel: this.tecnicoTitulacionHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(6, 2, 12),
			maxLength: 255
		})
		fields.propiedadNif = new Ext.form.TextField({
			name: 'propiedadNif',
			fieldLabel: this.propiedadNifHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 1, 10),
			maxLength: 255
		})
		fields.propiedadTitular = new Ext.form.TextField({
			name: 'propiedadTitular',
			fieldLabel: this.propiedadTitularHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(8, 1, 10),
			maxLength: 255
		})
		fields.representanteCodigoPostal = new Ext.form.TextField({
			name: 'representanteCodigoPostal',
			fieldLabel: this.representanteCodigoPostalHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 4, 12),
			maxLength: 255
		})
		fields.representanteCondicion = new Ext.form.TextField({
			name: 'representanteCondicion',
			fieldLabel: this.representanteCondicionHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 4, 12),
			maxLength: 255
		})
		fields.representanteDireccion = new Ext.form.TextField({
			name: 'representanteDireccion',
			fieldLabel: this.representanteDireccionHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 4, 12),
			maxLength: 255
		})
		fields.representanteEmail = new Ext.form.TextField({
			name: 'representanteEmail',
			fieldLabel: this.representanteEmailHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 4, 12),
			maxLength: 255
		})
		fields.representanteNif = new Ext.form.TextField({
			name: 'representanteNif',
			fieldLabel: this.representanteNifHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 4, 12),
			maxLength: 255
		})
		fields.representanteNombre = new Ext.form.TextField({
			name: 'representanteNombre',
			fieldLabel: this.representanteNombreHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 4, 12),
			maxLength: 255
		})
		fields.representantePoblacion = new Ext.form.TextField({
			name: 'representantePoblacion',
			fieldLabel: this.representantePoblacionHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 4, 12),
			maxLength: 255
		})
		fields.representanteProvincia = new Ext.form.TextField({
			name: 'representanteProvincia',
			fieldLabel: this.representanteProvinciaHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 4, 12),
			maxLength: 255
		})
		fields.representanteTelefonoFijo = new Ext.form.TextField({
			name: 'representanteTelefonoFijo',
			fieldLabel: this.representanteTelefonoFijoHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 4, 12),
			maxLength: 255
		})
		fields.representanteTelefonoMovil = new Ext.form.TextField({
			name: 'representanteTelefonoMovil',
			fieldLabel: this.representanteTelefonoMovilHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 4, 12),
			maxLength: 255
		})
		//---------------------------------------
		//---------Otros datos---------

		fields.accesibilidadPublicosId = Ext.create("Ext.ux.at4.OneToOneField", {
			application: application,
			name: 'accesibilidadPublicosId',
			fieldLabel: this.accesibilidadPublicosHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 2, 12),
			allowBlank: false,
			//store: At4FrameworkIntranet.FormDefaults.getStore('AccesibilidadPublicos'),
			recordPK: 'claveInforme',
			relatedForm: 'accesibilidadpublicos'
		})
		fields.accesibilidadValoracionFinalesId = Ext.create("Ext.ux.at4.OneToOneField", {
			application: application,
			name: 'accesibilidadValoracionFinalesId',
			fieldLabel: this.accesibilidadValoracionFinalesHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 2, 12),
			allowBlank: false,
			//store: At4FrameworkIntranet.FormDefaults.getStore('AccesibilidadValoracionFinales'),
			recordPK: 'claveInforme',
			relatedForm: 'accesibilidadvaloracionfinales'
		})
		fields.accesibilidadAjustesRazonablesId = Ext.create("Ext.ux.at4.OneToOneField", {
			application: application,
			name: 'accesibilidadAjustesRazonablesId',
			fieldLabel: this.accesibilidadAjustesRazonablesHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 2, 12),
			allowBlank: false,
			//store: At4FrameworkIntranet.FormDefaults.getStore('AccesibilidadAjustesRazonables'),
			recordPK: 'claveInforme',
			relatedForm: 'accesibilidadajustesrazonables'
		})
		fields.acusticasId = Ext.create("Ext.ux.at4.OneToOneField", {
			application: application,
			name: 'acusticasId',
			fieldLabel: this.acusticasHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2.5, 4, 12),
			allowBlank: false,
			//store: At4FrameworkIntranet.FormDefaults.getStore('Acusticas'),
			recordPK: 'claveInforme',
			relatedForm: 'acusticas'
		})
		fields.acusticaDatosGeneralesId = Ext.create("Ext.ux.at4.OneToOneField", {
			application: application,
			name: 'acusticaDatosGeneralesId',
			fieldLabel: this.acusticaDatosGeneralesHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2.5, 4, 12),
			allowBlank: false,
			//store: At4FrameworkIntranet.FormDefaults.getStore('AcusticaDatosGenerales'),
			recordPK: 'claveInforme',
			relatedForm: 'acusticadatosgenerales'
		})
		fields.acusticaValoracionFinalId = Ext.create("Ext.ux.at4.OneToOneField", {
			application: application,
			name: 'acusticaValoracionFinalId',
			fieldLabel: this.acusticaValoracionFinalHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2.5, 4, 12),
			allowBlank: false,
			//store: At4FrameworkIntranet.FormDefaults.getStore('AcusticaValoracionFinal'),
			recordPK: 'claveInforme',
			relatedForm: 'acusticavaloracionfinal'
		})
		fields.acusticaComprobacionesId = Ext.create("Ext.ux.at4.OneToOneField", {
			application: application,
			name: 'acusticaComprobacionesId',
			fieldLabel: this.acusticaComprobacionesHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2.5, 4, 12),
			allowBlank: false,
			//store: At4FrameworkIntranet.FormDefaults.getStore('AcusticaComprobaciones'),
			recordPK: 'claveInforme',
			relatedForm: 'acusticacomprobaciones'
		})

		/*
		fields.acusticaMejorasAcusticasId = Ext.create("Ext.ux.at4.OneToOneField", {
			application: application,
			name: 'acusticaMejorasAcusticasId',
			fieldLabel: this.acusticaMejorasAcusticasHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2.5, 4, 12),
			allowBlank: false,
			//store: At4FrameworkIntranet.FormDefaults.getStore('AcusticaMejorasAcusticas'),
			recordPK: 'claveInforme',
			relatedForm: 'acusticamejorasacusticas'
		})
		*/


		this.openAcusticaMejorasAcusticas = new Ext.Button({
			text: this.acusticaMejorasAcusticasHeaderLabel,
			margin: "10px 0 0 10px",
			border: true,
			handler: function (button, event) {
				var form = {
					form: 'acusticamejorasacusticas',
					text: this.acusticaMejorasAcusticasHeaderLabel + ": " + this.dataId,
					id: "ama" + this.dataId,
					iconCls: "glyphicons glyphicons-blog"
				}
				var customConfig = {
					extraFilters: [{
						field: 'inspeccion',
						data: {
							type: 'numeric',
							comparison: 'eq',
							value: this.dataId
						}
					}]
				}
				this.application.openCustomListGrid('acusticamejorasacusticas' + this.dataId, form, customConfig);
			},
			scope: this
		});


		fields.acusticaRuidoInstalacionesId = Ext.create("Ext.ux.at4.OneToOneField", {
			application: application,
			name: 'acusticaRuidoInstalacionesId',
			fieldLabel: this.acusticaRuidoInstalacionesHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2.5, 4, 12),
			allowBlank: false,
			//store: At4FrameworkIntranet.FormDefaults.getStore('AcusticaRuidoInstalaciones'),
			recordPK: 'claveInforme',
			relatedForm: 'acusticaruidoinstalaciones'
		})
		fields.acusticaRuidosExterioresId = Ext.create("Ext.ux.at4.OneToOneField", {
			application: application,
			name: 'acusticaRuidosExterioresId',
			fieldLabel: this.acusticaRuidosExterioresHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2.5, 4, 12),
			allowBlank: false,
			//store: At4FrameworkIntranet.FormDefaults.getStore('AcusticaRuidosExteriores'),
			recordPK: 'claveInforme',
			relatedForm: 'acusticaruidosexteriores'
		})


		fields.acusticaRuidosInterioresHorizontalesId = Ext.create("Ext.ux.at4.OneToOneField", {
			application: application,
			name: 'acusticaRuidosInterioresHorizontalesId',
			fieldLabel: this.acusticaRuidosInterioresHorizontalesHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2.5, 4, 12),
			allowBlank: false,
			//store: At4FrameworkIntranet.FormDefaults.getStore('AcusticaRuidosInterioresHorizontales'),
			recordPK: 'claveInforme',
			relatedForm: 'acusticaruidosinterioreshorizontales'
		})
		fields.acusticaRuidosInterioresVerticalesId = Ext.create("Ext.ux.at4.OneToOneField", {
			application: application,
			name: 'acusticaRuidosInterioresVerticalesId',
			fieldLabel: this.acusticaRuidosInterioresVerticalesHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2.5, 4, 12),
			allowBlank: false,
			//	store: At4FrameworkIntranet.FormDefaults.getStore('AcusticaRuidosInterioresVerticales'),
			recordPK: 'claveInforme',
			relatedForm: 'acusticaruidosinterioresverticales'
		})
		fields.acusticaRuidosInterioresUnionesId = Ext.create("Ext.ux.at4.OneToOneField", {
			application: application,
			name: 'acusticaRuidosInterioresUnionesId',
			fieldLabel: this.acusticaRuidosInterioresUnionesHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2.5, 4, 12),
			allowBlank: false,
			//store: At4FrameworkIntranet.FormDefaults.getStore('AcusticaRuidosInterioresUniones'),
			recordPK: 'claveInforme',
			relatedForm: 'acusticaruidosinterioresuniones'
		})


		fields.cerramientosCubiertasId = Ext.create("Ext.ux.at4.OneToOneField", {
			application: application,
			name: 'cerramientosCubiertasId',
			fieldLabel: this.cerramientosCubiertasHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 2, 7),
			allowBlank: false,
			//store: At4FrameworkIntranet.FormDefaults.getStore('CerramientosCubiertas'),
			recordPK: 'claveInforme',
			relatedForm: 'cerramientoscubiertas'
		})
		fields.instalacionesId = Ext.create("Ext.ux.at4.OneToOneField", {
			application: application,
			name: 'instalacionesId',
			fieldLabel: this.instalacionesHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 2, 7),
			allowBlank: false,
			//store: At4FrameworkIntranet.FormDefaults.getStore('Instalaciones'),
			recordPK: 'claveInforme',
			relatedForm: 'instalaciones'
		})
		fields.estructuraId = Ext.create("Ext.ux.at4.OneToOneField", {
			application: application,
			name: 'estructuraId',
			fieldLabel: this.estructuraHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 2, 7),
			allowBlank: false,
			//store: At4FrameworkIntranet.FormDefaults.getStore('Estructura'),
			recordPK: 'claveInforme',
			relatedForm: 'estructura'
		})
		fields.eficienciasEnergeticasId = Ext.create("Ext.ux.at4.OneToOneField", {
			application: application,
			name: 'eficienciasEnergeticasId',
			fieldLabel: this.eficienciasEnergeticasHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 2, 7),
			allowBlank: false,
			//store: At4FrameworkIntranet.FormDefaults.getStore('EficienciasEnergeticas'),
			recordPK: 'claveInforme',
			relatedForm: 'eficienciasenergeticas'
		})
		fields.cimentacionesId = Ext.create("Ext.ux.at4.OneToOneField", {
			application: application,
			name: 'cimentacionesId',
			fieldLabel: this.cimentacionesHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 2, 7),
			allowBlank: false,
			//store: At4FrameworkIntranet.FormDefaults.getStore('Cimentaciones'),
			recordPK: 'claveInforme',
			relatedForm: 'cimentaciones'
		})
		fields.conservacionId = Ext.create("Ext.ux.at4.OneToOneField", {
			application: application,
			name: 'conservacionId',
			fieldLabel: this.conservacionHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 2, 7),
			allowBlank: false,
			//store: At4FrameworkIntranet.FormDefaults.getStore('Conservacion'),
			recordPK: 'claveInforme',
			relatedForm: 'conservacion'
		})
		fields.fechasVisitas = new At4FrameworkIntranet.BasicPanel(this, {
			id: this.getId() + '-fechasVisitas',
			name: 'fechasVisitas',
			title: this.fechasVisitasHeaderLabel,
			editForm: new At4FrameworkIntranet.FechaVisitaSubForm(this, formName),
			windowWidth: 750,
			windowHeight: 400,
			tpl: At4FrameworkIntranet.FechaVisitaSubForm.PANEL_TPL,
			dataRecord: At4FrameworkIntranet.FechaVisitaSubForm.RECORD,
			deferredLoad: false
		})
		fields.valoracionesParciales = new At4FrameworkIntranet.BasicPanel(this, {
			id: this.getId() + '-valoracionesParciales',
			name: 'valoracionesParciales',
			title: this.valoracionesParcialesHeaderLabel,
			editForm: new At4FrameworkIntranet.ValoracionParcialSubForm(this, formName),
			windowWidth: 750,
			windowHeight: 400,
			tpl: At4FrameworkIntranet.ValoracionParcialSubForm.PANEL_TPL,
			dataRecord: At4FrameworkIntranet.ValoracionParcialSubForm.RECORD,
			deferredLoad: false
		})
		fields.documentacionOtros = new At4FrameworkIntranet.BasicPanel(this, {
			id: this.getId() + '-documentacionOtros',
			name: 'documentacionOtros',
			title: this.documentacionOtrosHeaderLabel,
			editForm: new At4FrameworkIntranet.DocumentacionOtroSubForm(this, formName),
			windowWidth: 750,
			windowHeight: 400,
			tpl: At4FrameworkIntranet.DocumentacionOtroSubForm.PANEL_TPL,
			dataRecord: At4FrameworkIntranet.DocumentacionOtroSubForm.RECORD,
			deferredLoad: false
		})
		fields.deficiencias = new At4FrameworkIntranet.BasicPanel(this, {
			id: this.getId() + '-deficiencias',
			name: 'deficiencias',
			title: this.deficienciasHeaderLabel,
			editForm: new At4FrameworkIntranet.DeficienciaSubForm(this, formName),
			windowWidth: 750,
			windowHeight: 400,
			tpl: At4FrameworkIntranet.DeficienciaSubForm.PANEL_TPL,
			dataRecord: At4FrameworkIntranet.DeficienciaSubForm.RECORD,
			deferredLoad: false
		})
		fields.valores = new At4FrameworkIntranet.ItemSelector({
			name: 'valores',
			//fieldLabel: this.valoresHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(14, 0, 14),
			height: 500,
			showOnlySelected: true,
			toTitle: null,
			fromTitle: null,
			fromStore: At4FrameworkIntranet.FormDefaults.getStore('Valor'),
			recordPK: 'id',
			relatedForm: 'valor'
		})
		fields.historicos = new At4FrameworkIntranet.BasicPanel(this, {
			id: this.getId() + '-historicos',
			name: 'historicos',
			title: this.historicosHeaderLabel,
			editForm: new At4FrameworkIntranet.HistoricoSubForm(this, formName),
			windowWidth: 750,
			windowHeight: 400,
			tpl: At4FrameworkIntranet.HistoricoSubForm.PANEL_TPL,
			dataRecord: At4FrameworkIntranet.HistoricoSubForm.RECORD,
			deferredLoad: false
		})

		this.fields = fields;
		this.multiForms = {
			fechasVisitas: fields.fechasVisitas,
			valoracionesParciales: fields.valoracionesParciales,
			documentacionOtros: fields.documentacionOtros,
			deficiencias: fields.deficiencias,
			historicos: fields.historicos
		};

		var items = [
			At4FrameworkIntranet.FormDefaults.rows([
				[fields.id, fields.edificio, fields.informeId, fields.principal]
			]), {
				xtype: 'At4Framework-formtabpanel',
				id: 'panelTabs-' + this.id,
				items: [{
					xtype: 'At4Framework-fieldmainpanel',
					//title: "Datos Generales",
					title: this.datosGeneralesTitleLabel,
					items: [
						At4FrameworkIntranet.FormDefaults.rows([
							[fields.accesibilidadAjustesrazonablesCostes, fields.conservacionDatosgeneralesArchivos, fields.ieeCompleta],
							[fields.alturaSobreRasante, fields.mediaViviendasPorPlanta, fields.numAparcamientos, fields.numLocales, fields.numTrasteros, fields.numViviendas],
							[fields.anoConstruccion, fields.anoConstruccionReferencia, fields.anoRehabilitacion, fields.anoRehabilitacionReferencia],
							//inspeccion
							[{

								xtype: 'fieldset',
								border: true,
								title: this.inspeccionDatosEdificioTitleLabel,
								items: [{
									xtype: "At4Framework-rowContainer",
									minWidth: false,
									items: [fields.inspeccionDatosedificioNucleosescalerasTipoId, fields.inspeccionDatosedificioParcelaTipoId, fields.inspeccionDatosedificioUnnucleoescalerasTipoId, fields.inspeccionDatosedificioUsoTipoId]
								}]

							}],
							[{

								xtype: 'fieldset',
								border: true,
								title: this.plantasBajoRasanteTitleLabel,
								items: [{
									xtype: "At4Framework-rowContainer",
									minWidth: false,
									items: [fields.plantasBajoRasanteUsoPrincipal, fields.plantasBajoRasanteUsosSecundarios, fields.plantasBajoRasanteUsosSecundariosTipo]
								}]

							}],
							[{

								xtype: 'fieldset',
								border: true,
								title: this.plantasSobreRasanteTitleLabel,
								items: [{
									xtype: "At4Framework-rowContainer",
									minWidth: false,
									items: [fields.plantasSobreRasanteUsoPrincipal, fields.plantasSobreRasanteUsosSecundarios, fields.plantasSobreRasanteUsosSecundariosTipo]
								}]

							}],


						]),
					]
				}, {
					xtype: 'At4Framework-fieldmainpanel',
					title: this.superficiesTitleLabel,
					items: [
						At4FrameworkIntranet.FormDefaults.rows([
							//superficies
							[fields.totalAscensores, fields.totalEscaleras, fields.totalViviendasConAccesoVariosNucleos, fields.totalViviendasSinAccesoAscensor],
							[fields.usoTexto, fields.numero, fields.tipoVia, fields.via, fields.referenciaCatastral],
							[{
								xtype: 'fieldset',
								border: true,
								margin: "25 0 0 0",
								title: this.inspecciónIdentificacionesTitleLabel,
								items: At4FrameworkIntranet.FormDefaults.rows([
									[fields.superficieConstruida, fields.superficieMediaAparcamientos, fields.superficieMediaLocales, fields.superficieMediaTrasteros, fields.superficieMediaViviendas, fields.superficieParcela]
								])

							}],
						]),

					]
				}, {
					xtype: 'At4Framework-fieldmainpanel',
					title: this.edificioTitleLabel,
					items: [
						At4FrameworkIntranet.FormDefaults.rows([
							//edifico
							[fields.edificioCodigoPostal, fields.edificioComunTexto, fields.edificioNumeroManual, fields.edificioObjetoTexto],
							[fields.edificioPisoLetra, fields.edificioPoblacion, fields.edificioProvincia],
							[fields.edificioProvinciaId, fields.edificioRegimenTexto, fields.edificioTipoViaManual, fields.edificioViaManual],
							[fields.edificioObservaciones],
							[{
								xtype: 'fieldset',
								border: true,
								title: this.inspecciónIdentificacionesTitleLabel,
								items: [{
									xtype: "At4Framework-rowContainer",
									minWidth: false,
									items: [fields.edificioInspeccionIdentificacionedificioComunesTipoId, fields.edificioInspeccionIdentificacionedificioObjetoTipoId, fields.edificioInspeccionPropiedadRegimenTipoId]
								}]

							}],
						]),

					]
				}, {
					xtype: 'At4Framework-fieldmainpanel',
					title: this.tecnicoTitularRepresentanteTitleLabel,
					items: [
						At4FrameworkIntranet.FormDefaults.rows([
							//titular y representante
							[fields.tecnicoNif, fields.tecnicoTecnico, fields.tecnicoTitulacion],
							[fields.propiedadNif, fields.propiedadTitular],
							[{
								xtype: 'fieldset',
								border: true,
								title: this.representanteTitleLabel,
								items: At4FrameworkIntranet.FormDefaults.rows([
									[fields.representanteCodigoPostal, fields.representanteCondicion, fields.representanteDireccion, fields.representanteEmail, fields.representanteNif],
									[fields.representanteNombre, fields.representantePoblacion, fields.representanteProvincia, fields.representanteTelefonoFijo, fields.representanteTelefonoMovil]
								])

							}],

						]),


					]
				}, {
					xtype: 'At4Framework-fieldmainpanel',
					title: this.otrosDatosTitleLabel,
					items: [
						At4FrameworkIntranet.FormDefaults.rows([
							//otros datos
							//accesibilidad
							[{
								xtype: 'fieldset',
								border: true,
								title: this.accesibilidadTitleLabel,
								items: [{
									xtype: "At4Framework-rowContainer",
									minWidth: false,
									items: [fields.accesibilidadPublicosId, fields.accesibilidadValoracionFinalesId, fields.accesibilidadAjustesRazonablesId]
								}]
							}],

							//acustica
							[{
								xtype: 'fieldset',
								border: true,
								title: this.acusticaTitleLabel,
								items: [{
									xtype: "At4Framework-rowContainer",
									minWidth: false,
									items: [fields.acusticasId, fields.acusticaDatosGeneralesId, fields.acusticaValoracionFinalId, fields.acusticaComprobacionesId],
								}]
							}],
							[{
								xtype: 'fieldset',
								border: true,
								title: this.acusticaRuidoTitleLabel,
								items: [{
									xtype: "At4Framework-rowContainer",
									minWidth: false,
									items: [fields.acusticaRuidoInstalacionesId, fields.acusticaRuidosExterioresId, fields.acusticaRuidosInterioresHorizontalesId, fields.acusticaRuidosInterioresVerticalesId, fields.acusticaRuidosInterioresUnionesId]
								}]
							}],
							[this.openAcusticaMejorasAcusticas],
							[fields.cerramientosCubiertasId, fields.instalacionesId, fields.estructuraId],
							[fields.eficienciasEnergeticasId, fields.cimentacionesId, fields.conservacionId]
						]),

					]
				}, {
					xtype: 'At4Framework-fieldmainpanel',
					title: this.valoresSeleccionadosTitleLabel,
					items: [
						At4FrameworkIntranet.FormDefaults.rows([
							[fields.valores]
						])
					]
				}, fields.fechasVisitas, fields.valoracionesParciales, fields.documentacionOtros, fields.deficiencias, fields.historicos]
			},
			At4FrameworkIntranet.FormDefaults.rows([
				[At4FrameworkIntranet.FormDefaults.resumenAuditoria()]
			])
		];



		this.maxTabIndex = tabHelper.getNext();
		this.callParent([application, formName, gridMetaData, items, config]);
	}
});
/**
 * @class At4FrameworkIntranet.FechaVisitaSubForm
 * Contiene la configuración del subformulario: FechaVisita
 * @author  agarcia@at4.net
 * @constructor
 * @extends At4FrameworkIntranet.BasicSubForm
 * @param {Object} application La aplicación que contiene el formulario, normalmente será {@link At4FrameworkIntranet.app}
 * @param {Object} config Configuración para Ext.form.FormPanel
 */
Ext.define("At4FrameworkIntranet.FechaVisitaSubForm", {
	extend: "At4FrameworkIntranet.BasicSubForm",
	constructor: function (application, formName, gridMetaData, config) {
			Ext.apply(this, config);
			var tabHelper = new At4util.tabIndexHelper(this.tabIndex);
			this.subFormName = 'fechasVisitas';
			//TODO: Para extjs4 esto era antes this.getId()
			this.id = application.getId() + "-" + this.subFormName + "SubForm";
			this.columnDefaults = At4FrameworkIntranet.FormDefaults.COLUMN_DEFAULTS;
			this.fieldDefaults = At4FrameworkIntranet.FormDefaults.FIELD_DEFAULTS;

			var fields = {}

			fields.id = new Ext.form.NumberField({
				cls: 'tiny-text',
				name: 'id',
				fieldLabel: this.idHeaderLabel,
				tabIndex: tabHelper.getNext(),
				width: At4FrameworkIntranet.FormDefaults.size(3, 1, 7),
				disableUpdates: true,
				disabled: true,
				hideTrigger: true,
				allowBlank: false,
				allowDecimals: false,
				maxValue: 9223372036854775807
			})

			fields.fecha = new Ext.form.TextField({
				name: 'fecha',
				fieldLabel: this.fechaHeaderLabel,
				tabIndex: tabHelper.getNext(),
				width: At4FrameworkIntranet.FormDefaults.size(4, 1, 7),
				maxLength: 255
			})

			this.maxTabIndex = tabHelper.getNext();
			this.fields = fields;
			var items = [{
				xtype: 'At4Framework-fieldmainpanel',
				title: this.titleLabel,
				items: [
					At4FrameworkIntranet.FormDefaults.rows([
						[fields.id, fields.fecha],
						[At4FrameworkIntranet.FormDefaults.resumenAuditoria()]
					]),
				]
			}];



			this.callParent([application, items, config]);
		}

		/**
		 * Template para el panel
		 * TODO: en ext4, migrar a static
		 */
		//At4FrameworkIntranet.FechaVisitaSubForm.PANEL_TPL = new Ext.XTemplate(
		,
	statics: {
		PANEL_TPL: new Ext.XTemplate(
				'<table class="listadoPanel">',
				'<tbody>',
				'<tr>',

				'<th>{[this.getLabel("id")]}</th>',
				'<th>{[this.getLabel("fecha")]}</th>',
				'</tr>',
				'<tpl for=".">',
				'<tr class="filaListadoPanel">',

				'<td>{id}</td>',
				'<td>{fecha}</td>',
				'</tr>',
				'</tpl>',
				'</tbody>',
				'</table>', {
					getLabel: function (name) {
						return At4FrameworkIntranet.FormDefaults.getFieldLabel("FechaVisitaSubForm", name);
					}
				}
			)


			/**
			 * Record para el subform
			 * TODO: en ext4, migrar a static
			 */
			//At4FrameworkIntranet.FechaVisitaSubForm.RECORD = Ext.data.Record.create(
			,
		MODEL: Ext.define('At4FrameworkIntranet.InspeccionFechaVisitamodel', {
			extend: 'Ext.data.Model',
			idProperty: "oid",
			fields: [
				//Añadimos el campo de oid al registro (el campo oid es el "object identifier")
				{
					name: "oid",
					mapping: "id",
					type: "int"
				}

				, {
					name: "id",
					type: "int"
				}, {
					name: "fecha",
					type: "string"
				}
			]
		}),
		RECORD: 'At4FrameworkIntranet.InspeccionFechaVisitamodel'
	}

});

/**
 * @class At4FrameworkIntranet.ValoracionParcialSubForm
 * Contiene la configuración del subformulario: ValoracionParcial
 * @author  agarcia@at4.net
 * @constructor
 * @extends At4FrameworkIntranet.BasicSubForm
 * @param {Object} application La aplicación que contiene el formulario, normalmente será {@link At4FrameworkIntranet.app}
 * @param {Object} config Configuración para Ext.form.FormPanel
 */
Ext.define("At4FrameworkIntranet.ValoracionParcialSubForm", {
	extend: "At4FrameworkIntranet.BasicSubForm",
	constructor: function (application, formName, gridMetaData, config) {
			Ext.apply(this, config);
			var tabHelper = new At4util.tabIndexHelper(this.tabIndex);
			this.subFormName = 'valoracionesParciales';
			//TODO: Para extjs4 esto era antes this.getId()
			this.id = application.getId() + "-" + this.subFormName + "SubForm";
			this.columnDefaults = At4FrameworkIntranet.FormDefaults.COLUMN_DEFAULTS;
			this.fieldDefaults = At4FrameworkIntranet.FormDefaults.FIELD_DEFAULTS;

			var fields = {}

			fields.id = new Ext.form.NumberField({
				cls: 'tiny-text',
				name: 'id',
				fieldLabel: this.idHeaderLabel,
				tabIndex: tabHelper.getNext(),
				width: At4FrameworkIntranet.FormDefaults.size(2, 2, 10),
				disableUpdates: true,
				disabled: true,
				hideTrigger: true,
				allowBlank: false,
				allowDecimals: false,
				maxValue: 9223372036854775807
			})

			fields.conservacionSistemasconstructivosTipoId = new Ext.form.NumberField({
				cls: 'tiny-text',
				name: 'conservacionSistemasconstructivosTipoId',
				fieldLabel: this.conservacionSistemasconstructivosTipoIdHeaderLabel,
				labelAttrTpl: " data-qtip='" + this.conservacionSistemasconstructivosTipoIdDescriptionLabel + "'",
				tabIndex: tabHelper.getNext(),
				width: At4FrameworkIntranet.FormDefaults.size(4, 2, 10),
				allowDecimals: false,
				maxValue: 2147483647
			})
			fields.conservacionValoracionesTipoId = new Ext.form.NumberField({
				cls: 'tiny-text',
				name: 'conservacionValoracionesTipoId',
				fieldLabel: this.conservacionValoracionesTipoIdHeaderLabel,
				labelAttrTpl: " data-qtip='" + this.conservacionValoracionesTipoIdDescriptionLabel + "'",
				tabIndex: tabHelper.getNext(),
				width: At4FrameworkIntranet.FormDefaults.size(4, 2, 10),
				allowDecimals: false,
				maxValue: 2147483647
			})
			fields.plazoFinObras = new Ext.form.TextField({
				name: 'plazoFinObras',
				fieldLabel: this.plazoFinObrasHeaderLabel,
				tabIndex: tabHelper.getNext(),
				width: At4FrameworkIntranet.FormDefaults.size(5, 1, 10),
				maxLength: 255
			})
			fields.plazoInicioObras = new Ext.form.TextField({
				name: 'plazoInicioObras',
				fieldLabel: this.plazoInicioObrasHeaderLabel,
				tabIndex: tabHelper.getNext(),
				width: At4FrameworkIntranet.FormDefaults.size(5, 1, 10),
				maxLength: 255
			})

			this.maxTabIndex = tabHelper.getNext();
			this.fields = fields;
			var items = [{
				xtype: 'At4Framework-fieldmainpanel',
				title: this.titleLabel,
				items: [
					At4FrameworkIntranet.FormDefaults.rows([
						[fields.id, fields.conservacionSistemasconstructivosTipoId, fields.conservacionValoracionesTipoId],
						[fields.plazoFinObras, fields.plazoInicioObras],
						[At4FrameworkIntranet.FormDefaults.resumenAuditoria()]
					]),
				]
			}];



			this.callParent([application, items, config]);
		}

		/**
		 * Template para el panel
		 * TODO: en ext4, migrar a static
		 */
		//At4FrameworkIntranet.ValoracionParcialSubForm.PANEL_TPL = new Ext.XTemplate(
		,
	statics: {
		PANEL_TPL: new Ext.XTemplate(
				'<table class="listadoPanel">',
				'<tbody>',
				'<tr>',

				'<th>{[this.getLabel("id")]}</th>',
				'<th>{[this.getLabel("conservacionSistemasconstructivosTipoId")]}</th>',
				'<th>{[this.getLabel("conservacionValoracionesTipoId")]}</th>',
				'<th>{[this.getLabel("plazoFinObras")]}</th>',
				'<th>{[this.getLabel("plazoInicioObras")]}</th>',
				'</tr>',
				'<tpl for=".">',
				'<tr class="filaListadoPanel">',

				'<td>{id}</td>',
				'<td>{conservacionSistemasconstructivosTipoId}</td>',
				'<td>{conservacionValoracionesTipoId}</td>',
				'<td>{plazoFinObras}</td>',
				'<td>{plazoInicioObras}</td>',
				'</tr>',
				'</tpl>',
				'</tbody>',
				'</table>', {
					getLabel: function (name) {
						return At4FrameworkIntranet.FormDefaults.getFieldLabel("ValoracionParcialSubForm", name);
					}
				}
			)


			/**
			 * Record para el subform
			 * TODO: en ext4, migrar a static
			 */
			//At4FrameworkIntranet.ValoracionParcialSubForm.RECORD = Ext.data.Record.create(
			,
		MODEL: Ext.define('At4FrameworkIntranet.InspeccionValoracionParcialmodel', {
			extend: 'Ext.data.Model',
			idProperty: "oid",
			fields: [
				//Añadimos el campo de oid al registro (el campo oid es el "object identifier")
				{
					name: "oid",
					mapping: "id",
					type: "int"
				}

				, {
					name: "id",
					type: "int"
				}, {
					name: "conservacionSistemasconstructivosTipoId",
					type: "int"
				}, {
					name: "conservacionValoracionesTipoId",
					type: "int"
				}, {
					name: "plazoFinObras",
					type: "string"
				}, {
					name: "plazoInicioObras",
					type: "string"
				}
			]
		}),
		RECORD: 'At4FrameworkIntranet.InspeccionValoracionParcialmodel'
	}

});

/**
 * @class At4FrameworkIntranet.DocumentacionOtroSubForm
 * Contiene la configuración del subformulario: DocumentacionOtro
 * @author  agarcia@at4.net
 * @constructor
 * @extends At4FrameworkIntranet.BasicSubForm
 * @param {Object} application La aplicación que contiene el formulario, normalmente será {@link At4FrameworkIntranet.app}
 * @param {Object} config Configuración para Ext.form.FormPanel
 */
Ext.define("At4FrameworkIntranet.DocumentacionOtroSubForm", {
	extend: "At4FrameworkIntranet.BasicSubForm",
	constructor: function (application, formName, gridMetaData, config) {
			Ext.apply(this, config);
			var tabHelper = new At4util.tabIndexHelper(this.tabIndex);
			this.subFormName = 'documentacionOtros';
			//TODO: Para extjs4 esto era antes this.getId()
			this.id = application.getId() + "-" + this.subFormName + "SubForm";
			this.columnDefaults = At4FrameworkIntranet.FormDefaults.COLUMN_DEFAULTS;
			this.fieldDefaults = At4FrameworkIntranet.FormDefaults.FIELD_DEFAULTS;

			var fields = {}

			fields.id = new Ext.form.NumberField({
				cls: 'tiny-text',
				name: 'id',
				fieldLabel: this.idHeaderLabel,
				tabIndex: tabHelper.getNext(),
				width: At4FrameworkIntranet.FormDefaults.size(2, 1, 10),
				disableUpdates: true,
				disabled: true,
				hideTrigger: true,
				allowBlank: false,
				allowDecimals: false,
				maxValue: 9223372036854775807
			})

			fields.texto = new Ext.form.TextField({
				name: 'texto',
				fieldLabel: this.textoHeaderLabel,
				tabIndex: tabHelper.getNext(),
				width: At4FrameworkIntranet.FormDefaults.size(8, 1, 10),
				maxLength: 255
			})

			this.maxTabIndex = tabHelper.getNext();
			this.fields = fields;
			var items = [{
				xtype: 'At4Framework-fieldmainpanel',
				title: this.titleLabel,
				items: [
					At4FrameworkIntranet.FormDefaults.rows([
						[fields.id, fields.texto],
						[At4FrameworkIntranet.FormDefaults.resumenAuditoria()]
					]),
				]
			}];



			this.callParent([application, items, config]);
		}

		/**
		 * Template para el panel
		 * TODO: en ext4, migrar a static
		 */
		//At4FrameworkIntranet.DocumentacionOtroSubForm.PANEL_TPL = new Ext.XTemplate(
		,
	statics: {
		PANEL_TPL: new Ext.XTemplate(
				'<table class="listadoPanel">',
				'<tbody>',
				'<tr>',

				'<th>{[this.getLabel("id")]}</th>',
				'<th>{[this.getLabel("texto")]}</th>',
				'</tr>',
				'<tpl for=".">',
				'<tr class="filaListadoPanel">',

				'<td>{id}</td>',
				'<td>{texto}</td>',
				'</tr>',
				'</tpl>',
				'</tbody>',
				'</table>', {
					getLabel: function (name) {
						return At4FrameworkIntranet.FormDefaults.getFieldLabel("DocumentacionOtroSubForm", name);
					}
				}
			)


			/**
			 * Record para el subform
			 * TODO: en ext4, migrar a static
			 */
			//At4FrameworkIntranet.DocumentacionOtroSubForm.RECORD = Ext.data.Record.create(
			,
		MODEL: Ext.define('At4FrameworkIntranet.InspeccionDocumentacionOtromodel', {
			extend: 'Ext.data.Model',
			idProperty: "oid",
			fields: [
				//Añadimos el campo de oid al registro (el campo oid es el "object identifier")
				{
					name: "oid",
					mapping: "id",
					type: "int"
				}

				, {
					name: "id",
					type: "int"
				}, {
					name: "texto",
					type: "string"
				}
			]
		}),
		RECORD: 'At4FrameworkIntranet.InspeccionDocumentacionOtromodel'
	}

});

/**
 * @class At4FrameworkIntranet.DeficienciaSubForm
 * Contiene la configuración del subformulario: Deficiencia
 * @author  agarcia@at4.net
 * @constructor
 * @extends At4FrameworkIntranet.BasicSubForm
 * @param {Object} application La aplicación que contiene el formulario, normalmente será {@link At4FrameworkIntranet.app}
 * @param {Object} config Configuración para Ext.form.FormPanel
 */
Ext.define("At4FrameworkIntranet.DeficienciaSubForm", {
	extend: "At4FrameworkIntranet.BasicSubForm",
	constructor: function (application, formName, gridMetaData, config) {
			Ext.apply(this, config);
			var tabHelper = new At4util.tabIndexHelper(this.tabIndex);
			this.subFormName = 'deficiencias';
			//TODO: Para extjs4 esto era antes this.getId()
			this.id = application.getId() + "-" + this.subFormName + "SubForm";
			this.columnDefaults = At4FrameworkIntranet.FormDefaults.COLUMN_DEFAULTS;
			this.fieldDefaults = At4FrameworkIntranet.FormDefaults.FIELD_DEFAULTS;

			var fields = {}

			fields.id = new Ext.form.NumberField({
				cls: 'tiny-text',
				name: 'id',
				fieldLabel: this.idHeaderLabel,
				tabIndex: tabHelper.getNext(),
				width: At4FrameworkIntranet.FormDefaults.size(2, 2, 10),
				disableUpdates: true,
				disabled: true,
				hideTrigger: true,
				allowBlank: false,
				allowDecimals: false,
				maxValue: 9223372036854775807
			})
			fields.deficienciaTipo = new At4FrameworkIntranet.ComboBox({
				name: 'deficienciaTipoId',
				fieldLabel: this.deficienciaTipoHeaderLabel,
				tabIndex: tabHelper.getNext(),
				width: At4FrameworkIntranet.FormDefaults.size(3, 2, 10),
				allowBlank: false,
				store: At4FrameworkIntranet.FormDefaults.getStore('DeficienciaTipo'),
				recordPK: 'id',
				relatedForm: 'deficienciatipo'
			})

			fields.conservacionSistemasconstructivosTipoId = new Ext.form.NumberField({
				cls: 'tiny-text',
				name: 'conservacionSistemasconstructivosTipoId',
				fieldLabel: this.conservacionSistemasconstructivosTipoIdHeaderLabel,
				labelAttrTpl: " data-qtip='" + this.conservacionSistemasconstructivosTipoIdDescriptionLabel + "'",
				tabIndex: tabHelper.getNext(),
				width: At4FrameworkIntranet.FormDefaults.size(5, 2, 10),
				allowDecimals: false,
				maxValue: 2147483647
			})
			fields.descripcionDeficiencia = new Ext.form.TextField({
				name: 'descripcionDeficiencia',
				fieldLabel: this.descripcionDeficienciaHeaderLabel,
				tabIndex: tabHelper.getNext(),
				width: At4FrameworkIntranet.FormDefaults.size(3, 2, 10),
				maxLength: 255
			})
			fields.esGrave = new Ext.form.NumberField({
				cls: 'tiny-text',
				name: 'esGrave',
				fieldLabel: this.esGraveHeaderLabel,
				tabIndex: tabHelper.getNext(),
				width: At4FrameworkIntranet.FormDefaults.size(3, 2, 10),
				allowDecimals: false,
				maxValue: 2147483647
			})
			fields.localizacionDeficiencia = new Ext.form.TextField({
				name: 'localizacionDeficiencia',
				fieldLabel: this.localizacionDeficienciaHeaderLabel,
				tabIndex: tabHelper.getNext(),
				width: At4FrameworkIntranet.FormDefaults.size(4, 2, 10),
				maxLength: 255
			})
			fields.nombreDeficiencia = new Ext.form.TextField({
				name: 'nombreDeficiencia',
				fieldLabel: this.nombreDeficienciaHeaderLabel,
				tabIndex: tabHelper.getNext(),
				width: At4FrameworkIntranet.FormDefaults.size(5, 1, 10),
				maxLength: 255
			})
			fields.pruebasEnsayosRealizados = new Ext.form.TextField({
				name: 'pruebasEnsayosRealizados',
				fieldLabel: this.pruebasEnsayosRealizadosHeaderLabel,
				tabIndex: tabHelper.getNext(),
				width: At4FrameworkIntranet.FormDefaults.size(5, 1, 10),
				maxLength: 255
			})
			fields.observaciones = new Ext.form.TextArea({
				name: 'observaciones',
				fieldLabel: this.observacionesHeaderLabel,
				tabIndex: tabHelper.getNext(),
				width: At4FrameworkIntranet.FormDefaults.size(10, 0, 10),
				maxLength: 255
			})

			this.maxTabIndex = tabHelper.getNext();
			this.fields = fields;
			var items = [{
				xtype: 'At4Framework-fieldmainpanel',
				items: [
					At4FrameworkIntranet.FormDefaults.rows([
						[fields.id, fields.deficienciaTipo, fields.conservacionSistemasconstructivosTipoId],
						[fields.descripcionDeficiencia, fields.esGrave, fields.localizacionDeficiencia],
						[fields.nombreDeficiencia, fields.pruebasEnsayosRealizados],
						[fields.observaciones],
						[At4FrameworkIntranet.FormDefaults.resumenAuditoria()]
					]),
				]
			}];



			this.callParent([application, items, config]);
		}

		/**
		 * Template para el panel
		 * TODO: en ext4, migrar a static
		 */
		//At4FrameworkIntranet.DeficienciaSubForm.PANEL_TPL = new Ext.XTemplate(
		,
	statics: {
		PANEL_TPL: new Ext.XTemplate(
				'<table class="listadoPanel">',
				'<tbody>',
				'<tr>',

				'<th>{[this.getLabel("id")]}</th>',
				'<th>{[this.getLabel("deficienciaTipo")]}</th>',
				'<th>{[this.getLabel("conservacionSistemasconstructivosTipoId")]}</th>',
				'<th>{[this.getLabel("descripcionDeficiencia")]}</th>',
				'<th>{[this.getLabel("esGrave")]}</th>',
				'<th>{[this.getLabel("localizacionDeficiencia")]}</th>',
				'<th>{[this.getLabel("nombreDeficiencia")]}</th>',
				'<th>{[this.getLabel("observaciones")]}</th>',
				'<th>{[this.getLabel("pruebasEnsayosRealizados")]}</th>',
				'</tr>',
				'<tpl for=".">',
				'<tr class="filaListadoPanel">',

				'<td>{id}</td>',
				'<td>{deficienciaTipoLabel}</td>',
				'<td>{conservacionSistemasconstructivosTipoId}</td>',
				'<td>{descripcionDeficiencia}</td>',
				'<td>{esGrave}</td>',
				'<td>{localizacionDeficiencia}</td>',
				'<td>{nombreDeficiencia}</td>',
				'<td>{observaciones}</td>',
				'<td>{pruebasEnsayosRealizados}</td>',
				'</tr>',
				'</tpl>',
				'</tbody>',
				'</table>', {
					getLabel: function (name) {
						return At4FrameworkIntranet.FormDefaults.getFieldLabel("DeficienciaSubForm", name);
					}
				}
			)


			/**
			 * Record para el subform
			 * TODO: en ext4, migrar a static
			 */
			//At4FrameworkIntranet.DeficienciaSubForm.RECORD = Ext.data.Record.create(
			,
		MODEL: Ext.define('At4FrameworkIntranet.InspeccionDeficienciamodel', {
			extend: 'Ext.data.Model',
			idProperty: "oid",
			fields: [
				//Añadimos el campo de oid al registro (el campo oid es el "object identifier")
				{
					name: "oid",
					mapping: "id",
					type: "int"
				}

				, {
					name: "id",
					type: "int"
				}, {
					name: "deficienciaTipoId",
					type: "int"
				}, {
					name: "deficienciaTipoLabel",
					type: "auto"
				}, {
					name: "deficienciaTipo",
					mapping: "deficienciaTipoLabel",
					type: "auto"
				}, {
					name: "conservacionSistemasconstructivosTipoId",
					type: "int"
				}, {
					name: "descripcionDeficiencia",
					type: "string"
				}, {
					name: "esGrave",
					type: "int"
				}, {
					name: "localizacionDeficiencia",
					type: "string"
				}, {
					name: "nombreDeficiencia",
					type: "string"
				}, {
					name: "observaciones",
					type: "string"
				}, {
					name: "pruebasEnsayosRealizados",
					type: "string"
				}
			]
		}),
		RECORD: 'At4FrameworkIntranet.InspeccionDeficienciamodel'
	}

});

/**
 * @class At4FrameworkIntranet.HistoricoSubForm
 * Contiene la configuración del subformulario: Historico
 * @author  agarcia@at4.net
 * @constructor
 * @extends At4FrameworkIntranet.BasicSubForm
 * @param {Object} application La aplicación que contiene el formulario, normalmente será {@link At4FrameworkIntranet.app}
 * @param {Object} config Configuración para Ext.form.FormPanel
 */
Ext.define("At4FrameworkIntranet.HistoricoSubForm", {
	extend: "At4FrameworkIntranet.BasicSubForm",
	constructor: function (application, formName, gridMetaData, config) {
			Ext.apply(this, config);
			var tabHelper = new At4util.tabIndexHelper(this.tabIndex);
			this.subFormName = 'historicos';
			//TODO: Para extjs4 esto era antes this.getId()
			this.id = application.getId() + "-" + this.subFormName + "SubForm";
			this.columnDefaults = At4FrameworkIntranet.FormDefaults.COLUMN_DEFAULTS;
			this.fieldDefaults = At4FrameworkIntranet.FormDefaults.FIELD_DEFAULTS;

			var fields = {}

			fields.id = new Ext.form.NumberField({
				cls: 'tiny-text',
				name: 'id',
				fieldLabel: this.idHeaderLabel,
				tabIndex: tabHelper.getNext(),
				width: At4FrameworkIntranet.FormDefaults.size(2, 2, 10),
				disableUpdates: true,
				disabled: true,
				hideTrigger: true,
				allowBlank: false,
				allowDecimals: false,
				maxValue: 9223372036854775807
			})

			fields.fechaInspeccion = new Ext.form.TextField({
				name: 'fechaInspeccion',
				fieldLabel: this.fechaInspeccionHeaderLabel,
				tabIndex: tabHelper.getNext(),
				width: At4FrameworkIntranet.FormDefaults.size(4, 2, 10),
				maxLength: 255
			})
			fields.gradoEjecucionEfectividadObras = new Ext.form.TextField({
				name: 'gradoEjecucionEfectividadObras',
				fieldLabel: this.gradoEjecucionEfectividadObrasHeaderLabel,
				labelAttrTpl: " data-qtip='" + this.gradoEjecucionEfectividadObrasDescriptionLabel + "'",
				tabIndex: tabHelper.getNext(),
				width: At4FrameworkIntranet.FormDefaults.size(4, 2, 10),
				maxLength: 255
			})
			fields.resultado = new Ext.form.TextField({
				name: 'resultado',
				fieldLabel: this.resultadoHeaderLabel,
				tabIndex: tabHelper.getNext(),
				width: At4FrameworkIntranet.FormDefaults.size(5, 1, 10),
				maxLength: 255
			})
			fields.tecnico = new Ext.form.TextField({
				name: 'tecnico',
				fieldLabel: this.tecnicoHeaderLabel,
				tabIndex: tabHelper.getNext(),
				width: At4FrameworkIntranet.FormDefaults.size(5, 1, 10),
				maxLength: 255
			})
			fields.observaciones = new Ext.form.TextArea({
				name: 'observaciones',
				fieldLabel: this.observacionesHeaderLabel,
				tabIndex: tabHelper.getNext(),
				width: At4FrameworkIntranet.FormDefaults.size(10, 0, 10),
				maxLength: 255
			})

			this.maxTabIndex = tabHelper.getNext();
			this.fields = fields;
			var items = [{
				xtype: 'At4Framework-fieldmainpanel',
				items: [
					At4FrameworkIntranet.FormDefaults.rows([
						[fields.id, fields.fechaInspeccion, fields.gradoEjecucionEfectividadObras],
						[fields.resultado, fields.tecnico],
						[fields.observaciones],
						[At4FrameworkIntranet.FormDefaults.resumenAuditoria()]
					])
				]
			}];



			this.callParent([application, items, config]);
		}

		/**
		 * Template para el panel
		 * TODO: en ext4, migrar a static
		 */
		//At4FrameworkIntranet.HistoricoSubForm.PANEL_TPL = new Ext.XTemplate(
		,
	statics: {
		PANEL_TPL: new Ext.XTemplate(
				'<table class="listadoPanel">',
				'<tbody>',
				'<tr>',

				'<th>{[this.getLabel("id")]}</th>',
				'<th>{[this.getLabel("fechaInspeccion")]}</th>',
				'<th>{[this.getLabel("gradoEjecucionEfectividadObras")]}</th>',
				'<th>{[this.getLabel("observaciones")]}</th>',
				'<th>{[this.getLabel("resultado")]}</th>',
				'<th>{[this.getLabel("tecnico")]}</th>',
				'</tr>',
				'<tpl for=".">',
				'<tr class="filaListadoPanel">',

				'<td>{id}</td>',
				'<td>{fechaInspeccion}</td>',
				'<td>{gradoEjecucionEfectividadObras}</td>',
				'<td>{observaciones}</td>',
				'<td>{resultado}</td>',
				'<td>{tecnico}</td>',
				'</tr>',
				'</tpl>',
				'</tbody>',
				'</table>', {
					getLabel: function (name) {
						return At4FrameworkIntranet.FormDefaults.getFieldLabel("HistoricoSubForm", name);
					}
				}
			)


			/**
			 * Record para el subform
			 * TODO: en ext4, migrar a static
			 */
			//At4FrameworkIntranet.HistoricoSubForm.RECORD = Ext.data.Record.create(
			,
		MODEL: Ext.define('At4FrameworkIntranet.InspeccionHistoricomodel', {
			extend: 'Ext.data.Model',
			idProperty: "oid",
			fields: [
				//Añadimos el campo de oid al registro (el campo oid es el "object identifier")
				{
					name: "oid",
					mapping: "id",
					type: "int"
				}

				, {
					name: "id",
					type: "int"
				}, {
					name: "fechaInspeccion",
					type: "string"
				}, {
					name: "gradoEjecucionEfectividadObras",
					type: "string"
				}, {
					name: "observaciones",
					type: "string"
				}, {
					name: "resultado",
					type: "string"
				}, {
					name: "tecnico",
					type: "string"
				}
			]
		}),
		RECORD: 'At4FrameworkIntranet.InspeccionHistoricomodel'
	}

});
