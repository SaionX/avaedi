// Usa Ext.ux.CKEditor.
// Docs del CKEditor (usado por Ext.ux.CKEditor)
// http://docs.ckeditor.com/#!/guide/dev_installation

if (typeof CKEDITOR !== "undefined") {
	Ext.define("At4FrameworkIntranet.MultilangTextarea", {
		extend: "Ext.ux.CKEditor",
		xtype: 'At4Framework-multilangtextarea',
		width: At4FrameworkIntranet.FormDefaults.TEXT_FIELD_WIDTH,
		//Sobreescribible por instalación
		langs: ['Es', 'En', 'Ct', 'Xx'],
		//override:
		grow: false,
		//Triggers:
		firstLang: 0,
		triggers: {
			selIdioma: {
				cls: "multilang-icon-Es",
				handler: function () {
					var prevLang = this.currentLang
					this.currentLang++;
					if (this.currentLang >= this.langs.length) {
						this.currentLang = 0;
					}
					var nextLang = this.currentLang;
					//Seteamos el valor que esta ahora en el editor a su input.
					this.inputs[this.langs[prevLang]].setValue(this.getValue());
					//Seteamos el valor del input del nuevo lang al editor.
					this.setValue(this.inputs[this.langs[nextLang]].getValue());
					//Cambiamos la clase del trigger
					this.triggerEl.removeCls('multilang-icon-' + this.langs[prevLang]).addCls('multilang-icon-' + this.langs[nextLang]);
				}
			}
			// TODO: Falta implementar el trigger2 para que cuando le des se despliegue una lista de los idiomas disponibles
		},

		initComponent: function () {
			var i;
			var lang;
			var name;
			this.inputs = {};
			this.currentLang = this.firstLang ? firstLang : 0;
			for (i = 0; i < this.langs.length; i++) {
				lang = this.langs[i];
				name = this.name + lang;
				this.inputs[lang] = new Ext.form.Hidden({
					name: this.name + lang,
					multilang: this,
					lang: lang,
					setValue: function (v, reloaded) {
						Ext.form.Hidden.superclass.setValue.call(this, v);
						if (!reloaded) {
							this.multilang.setLangValue(this.lang, v);
						}
					}
				})
			}
			this.callParent();
		},

		setLangValue: function (lang, v) {
			if (lang == this.langs[this.currentLang]) {
				this.setValue(v);
			}
		},

		listeners: {
			render: function (el, eOpts) {
				var i, lang, name;
				for (i = 0; i < this.langs.length; i++) {
					lang = this.langs[i];
					name = this.name + lang;
					this.ownerCt.add(this.inputs[lang]);
				}

			},
			change: function () {
				this.inputs[this.langs[this.currentLang]].setValue(this.getValue(), true);
			},
		},


		/*
		    constructor: function() {
		        console.log(arguments);
		        this.callParent(arguments);
		    },*/

		/**
		 * Sobreescribimos getErrors para poder desactivar validación para los idiomas secundarios
		 * TODO: Cada idioma podría tener sus características de validación, pero por ahora sólo tenemos los del idioma principal
		 */

		getErrors: function (value) {
			if (this.currentLang == 0) {
				//return At4FrameworkIntranet.MultilangText.superclass.getErrors.apply(this, arguments);
				return this.callParent(arguments);
			} else {
				return [];
			}
		}

	});
}
