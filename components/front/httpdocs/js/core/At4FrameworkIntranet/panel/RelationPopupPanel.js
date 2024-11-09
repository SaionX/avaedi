// Namespace de At4FrameworkIntranet
Ext.namespace('At4FrameworkIntranet');

//Ext.extend(At4FrameworkIntranet.RelationPopupPanel, Ext.form.FieldSet, {
Ext.define("At4FrameworkIntranet.RelationPopupPanel", {
		extend: "Ext.form.FieldSet",
		/**
		 * @class At4FrameworkIntranet.RelationPopupPanel Clase de relation popup (un
		 *        ComboBox con enlace al formulario relacionado)
		 * @extends-ext Ext.Panel
		 * @author agarcia
		 * @constructor
		 *
		 * @param {At4FrameworkIntranet.BasicForm}
		 *            parentFormPanel Formulario contenedor
		 * @param {Object}
		 *            config
		 */
		constructor: function(parentFormPanel, combo, config) {
			console.log("Se esta llamando al constructor de RelationPopupPanel");
			Ext.apply(this, config);

			this.parentFormPanel = parentFormPanel;
			this.combo = combo;

			// Necesitamos saber si se trata de un subform
			if (parentFormPanel.subFormName) {
				this.inSubForm = true;
			} else {
				this.inSubForm = false;
			}

			//Private
			this.getApplication = function() {

				var p = this.parentFormPanel;
				while (p.subFormName) {
					p = p.parentPanel; //Buscamos el form de mayor nivel
				}
				return p.application;


			}

			this.viewRelated = new Ext.Button({
				// TODO: localear
				text: ">",
				tooltip: "Pulse para ver el registro",
				hidden: true,
				handler: function(button, event) {
					if (this.combo.getValue()) {
						this.parentFormPanel.application.openRecordForm({
							form: this.relatedFormName
						}, {
							oid: this.combo.getValue()
						});
					}
				},
				style: 'margin-top:18px',
				scope: this
			});

			var width = null;

			if (config.width > 0) {
				this.combo.setWidth(config.width - 30);
				width = config.width;
			} else if ((this.combo.width + 0) > 0) {
				width = this.combo.width + 30;
			}

			//At4FrameworkIntranet.RelationPopupPanel.superclass.constructor.call(this, {
			this.callParent(this, {
				xtype: 'fieldset',
				layout: 'column',
				border: false,
				labelAlign: "top",
				autoHeight: true,
				hidden: false,
				collapsible: false,
				style: 'margin-bottom: 0px;padding: 0px;',
				width: width,

				defaults: {
					msgTarget: 'under',
					validationEvent: true,
					border: false,
					labelAlign: "top",
					autoHeight: true,
					autoWidth: true,
					collapsible: false
				},


				items: [{
					xtype: 'fieldset',
					items: [this.combo]
				}, {
					items: [this.viewRelated]
				}]


			});

		},
		/**
		 * Nombre del formulario relacionado
		 *
		 * @type {String}
		 */
		relatedFormName: null

		,
		verTxt: 'ver'

		,
		onChange: function() {

			if (this.combo.getValue()) {
				this.viewRelated.setVisible(true);
			} else {
				this.viewRelated.setVisible(false);
			}

		}

		,
		initEvents: function() {
			At4FrameworkIntranet.RelationPopupPanel.superclass.initEvents.call(this);
			var activar = true;

			if (this.inSubForm) {

				//Queremos comprobar que el subform sea diferente al formulario base, para no tratar de abrir el mismo registro base
				var p = this.parentFormPanel;
				while (p.subFormName) {
					p = p.parentPanel; //Buscamos el form de mayor nivel
					if (p.formName && p.formName == this.relatedFormName) {
						activar = false;
					}
				}
			}

			if (activar) {
				this.combo.addListener('change', this.onChange.createDelegate(this));
				this.parentFormPanel.addListener('afterload', this.onChange.createDelegate(this));
			}

		}


	}

);
