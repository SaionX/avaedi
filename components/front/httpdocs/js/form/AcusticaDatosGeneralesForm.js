//Namespace de  At4FrameworkIntranet
Ext.namespace('At4FrameworkIntranet');

/**
 * @class At4FrameworkIntranet.AcusticaDatosGeneralesForm
 * Contiene la configuración del formulario: AcusticaDatosGenerales
 * @author garrom
 * @constructor
 * @extends At4FrameworkIntranet.BasicForm
 * @param {Object} application La aplicación que contiene el formulario, normalmente será {@link At4FrameworkIntranet.app}
 * @param {String} formName Nombre del formulario
 * @param {Object} gridMetaData Configuración gridMetadata
 * @param {Object} config Configuración para Ext.form.FormPanel
 */

Ext.define("At4FrameworkIntranet.AcusticaDatosGeneralesForm", {
	extend: "At4FrameworkIntranet.InspeccionBaseForm",
	constructor: function (application, formName, gridMetaData, config) {
		Ext.apply(this, config);
		var tabHelper = new At4util.tabIndexHelper(this.tabIndex);

		var columnDefaults = At4FrameworkIntranet.FormDefaults.COLUMN_DEFAULTS;
		var fieldDefaults = At4FrameworkIntranet.FormDefaults.FIELD_DEFAULTS;


		var fields = {}

		fields.claveInforme = new Ext.form.NumberField({
			name: 'claveInforme',
			fieldLabel: this.claveInformeHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 2, 12),
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
			width: At4FrameworkIntranet.FormDefaults.size(6, 2, 12),
			relatedIconCls: "glyphicons glyphicons-building",
			relatedForm: 'edificio'
		})

		/*fields.inspeccion = new At4FrameworkIntranet.ComboBox({
		    name: 'inspeccionId',
		    fieldLabel: this.inspeccionHeaderLabel,
		    tabIndex: tabHelper.getNext(),
		    width: At4FrameworkIntranet.FormDefaults.size(3, 2, 7),
		    allowBlank: false,
		    store: At4FrameworkIntranet.FormDefaults.getStore('Inspeccion'),
		    recordPK: 'id',
		    relatedForm: 'inspeccion'
		})*/


		fields.inspeccionId = Ext.create("Ext.ux.at4.OneToOneField", {
			name: 'inspeccionId',
			fieldLabel: this.inspeccionHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(4, 2, 12),
			border: true,
			application: application,
			relatedIconCls: "",
			relatedForm: 'inspeccion'
		})
		fields.tipoAreaAcustica = new Ext.form.TextField({
			name: 'tipoAreaAcustica',
			fieldLabel: this.tipoAreaAcusticaHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 3, 12),
			maxLength: 255
		})
		fields.indiceRuidoDia = new Ext.form.NumberField({
			name: 'indiceRuidoDia',
			fieldLabel: this.indiceRuidoDiaHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(2, 3, 12),
			allowDecimals: false,
			maxValue: 2147483647
		})
		fields.objetivoCalidadAcustica = new Ext.form.NumberField({
			name: 'objetivoCalidadAcustica',
			fieldLabel: this.objetivoCalidadAcusticaHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 3, 12),
			allowDecimals: false,
			maxValue: 2147483647
		})
		fields.estudioEspecifico = new Ext.form.NumberField({
			name: 'estudioEspecifico',
			fieldLabel: this.estudioEspecificoHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(3, 2, 12),
			allowDecimals: false,
			maxValue: 2147483647
		})
		fields.zonaRuidoAeronaves = Ext.create("Ext.ux.at4.ynncField", {
			name: 'zonaRuidoAeronaves',
			fieldLabel: this.zonaRuidoAeronavesHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(4, 2, 12),
			allowDecimals: false,
			maxValue: 2147483647
		})
		fields.fachadasNoExpuestasRuido = Ext.create("Ext.ux.at4.ynncField", {
			name: 'fachadasNoExpuestasRuido',
			fieldLabel: this.fachadasNoExpuestasRuidoHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(4, 2, 12),
			allowDecimals: false,
			maxValue: 2147483647
		})
		fields.recintosInstalacionesRecintosHabitables = new Ext.form.TextField({
			name: 'recintosInstalacionesRecintosHabitables',
			fieldLabel: this.recintosInstalacionesRecintosHabitablesHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.recintosInstalacionesRecintosHabitablesDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(6, 2, 12),
			maxLength: 255
		})
		fields.recintosInstalacionesZonasComunes = new Ext.form.TextField({
			name: 'recintosInstalacionesZonasComunes',
			fieldLabel: this.recintosInstalacionesZonasComunesHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.recintosInstalacionesZonasComunesDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(6, 2, 12),
			maxLength: 255
		})





        fields.recintosProtegidosAscensor = Ext.create("Ext.ux.at4.ynncField", {
            name: 'recintosProtegidosAscensor',
            fieldLabel: this.recintosProtegidosAscensorHeaderLabel,
            tabIndex: tabHelper.getNext(),
            width: At4FrameworkIntranet.FormDefaults.size(4, 2, 12),
            allowDecimals: false,
            maxValue: 2147483647
        })
		fields.recintosProtegidosZonaComun = Ext.create("Ext.ux.at4.ynncField", {
			name: 'recintosProtegidosZonaComun',
			fieldLabel: this.recintosProtegidosZonaComunHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(4, 2, 12),
			allowDecimals: false,
			maxValue: 2147483647
		})
		fields.recintosProtegidosRecintosInstalaciones = Ext.create("Ext.ux.at4.ynncField", {
			name: 'recintosProtegidosRecintosInstalaciones',
			fieldLabel: this.recintosProtegidosRecintosInstalacionesHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.recintosProtegidosRecintosInstalacionesDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(4, 2, 12),
			allowDecimals: false,
			maxValue: 2147483647
		})
		fields.recintosProtegidosRecintosProtegidos = Ext.create("Ext.ux.at4.ynncField", {
			name: 'recintosProtegidosRecintosProtegidos',
			fieldLabel: this.recintosProtegidosRecintosProtegidosHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.recintosProtegidosRecintosProtegidosDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(4, 2, 12),
			allowDecimals: false,
			maxValue: 2147483647
		})
		fields.recintosProtegidosRecintosHabitables = Ext.create("Ext.ux.at4.ynncField", {
			name: 'recintosProtegidosRecintosHabitables',
			fieldLabel: this.recintosProtegidosRecintosHabitablesHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.recintosProtegidosRecintosHabitablesDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(4, 2, 12),
			allowDecimals: false,
			maxValue: 2147483647
		})
		fields.existenRecintosInstalaciones = new Ext.form.TextField({
			name: 'existenRecintosInstalaciones',
			fieldLabel: this.existenRecintosInstalacionesHeaderLabel,
			labelAttrTpl: " data-qtip='" + this.existenRecintosInstalacionesDescriptionLabel + "'",
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(4, 0, 12),
			maxLength: 255
		})
		fields.observaciones = new Ext.form.TextArea({
			name: 'observaciones',
			fieldLabel: this.observacionesHeaderLabel,
			tabIndex: tabHelper.getNext(),
			width: At4FrameworkIntranet.FormDefaults.size(12, 0, 12),
			maxLength: 255
		})


		this.fields = fields;
		var items = [{
			xtype: 'At4Framework-fieldmainpanel',
			items: [
				At4FrameworkIntranet.FormDefaults.rows([
					[fields.claveInforme, fields.edificio, fields.inspeccionId],
					[fields.tipoAreaAcustica, fields.indiceRuidoDia, fields.objetivoCalidadAcustica, fields.estudioEspecifico],
					[fields.zonaRuidoAeronaves, fields.fachadasNoExpuestasRuido],
					[fields.recintosInstalacionesRecintosHabitables, fields.recintosInstalacionesZonasComunes],
					[{

						xtype: 'fieldset',
						border: true,
						title: this.recintosProtegidosEnElEdificioTitleLabel,
						items: [{
							xtype: "At4Framework-rowContainer",
							minWidth: false,
							items: [fields.recintosProtegidosAscensor, fields.recintosProtegidosZonaComun]

						}, {
							xtype: "At4Framework-rowContainer",
							minWidth: false,
							items: [fields.recintosProtegidosRecintosInstalaciones, fields.recintosProtegidosRecintosProtegidos, fields.recintosProtegidosRecintosHabitables]

						}]

					}],
					[fields.existenRecintosInstalaciones],
					[fields.observaciones],
					[At4FrameworkIntranet.FormDefaults.resumenAuditoria()]
				])
			]
		}];



		this.maxTabIndex = tabHelper.getNext();
		this.callParent([application, formName, gridMetaData, items, config]);
	}
});
