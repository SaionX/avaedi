/*
ExtJS 4.x wrapper for CKEditor (http://ckeditor.com/)
https://github.com/fp0/extjs4-ckeditor
*/

//Adaptacion a Extjs5 hecha por GArrom.

if (typeof CKEDITOR !== "undefined") {
	Ext.define('Ext.ux.CKEditor', {
		extend: 'Ext.form.field.TextArea',
		alias: 'widget.ckeditor',

		isReady: false,
		valueCache: null,

		initComponent: function () {
			this.callParent(arguments);
			//this.fireEvent("render", this, this.editor);
			//console.log("Define afterrender");
			this.on("afterrender", function () {
				var size = {
					height: this.getHeight() + 100,
					width: this.getWidth()
				};
				Ext.apply(this.CKConfig, size);

				this.editor = CKEDITOR.replace(this.inputEl.id, this.CKConfig);
				this.editor.name = this.name;
				this.editor.extField = this;
				this.dt = new Ext.util.DelayedTask(function () {
					this.extField.fireEvent("change");
				});
				this.editor.on("change", function () {
					this.extField.dt.delay(500, null, this);
				});

				//console.log("Define instanceReady");
				this.editor.on("instanceReady", function () {
					//console.log("instanceReady", this.isReady);
					this.fireEvent("instanceReady", this, this.editor);
					this.isReady = true;
					if (this.valueCache) {
						this.setValue(this.valueCache);
					}
				}, this);

				this.dtResize = new Ext.util.DelayedTask();

				this.editor.on("resize", function (evt) {
					// console.log("resized", arguments);
					this.extField.dtResize.delay(500, function () {
						this.fireEvent("resize", this, this.editor);
					}, this.extField);
				});
			}, this);
		},

		onRender: function (ct, position) {
			if (!this.el) {
				this.defaultAutoCreate = {
					tag: 'textarea',
					autocomplete: 'off'
				};
			}
			this.callParent(arguments)
		},

		setValue: function (value) {
			var me = this;
			if (this.isReady) {
				if (this.editor) {
					this.editor.setData(value);
					//console.log("EDITOR: seteamos value", value);
				} else {
					//console.log("EDITOR: no esta ready", value);
				}
				this.callParent(arguments);
			} else {

				//console.log("EDITOR: ponemos valor en cache", value);
			}
			this.valueCache = value;
		},

		getValue: function () {
			if (this.editor) {
				//console.log("Devolviendo datos");
				return this.editor.getData();
			} else {
				//console.log("No hay datos que retornar")
				return ''
			}
		}
	});

	(function () {
		CKEDITOR.plugins.add('multilang', {
			init: function (editor) {
				var pluginName = 'multilang';
				editor.ui.addButton('multilang', {
					label: 'Cambiar idioma',
					command: 'OpenWindow',
					toolbar: 'multilanggroup',
					icon: 'langimg/multilang-icon-Es.png'
				});
				var cmd = editor.addCommand('OpenWindow', {
					exec: showMyDialog
				});
			}
		});

		function showMyDialog(e) {
			var extjs = e.extField;
			var cls = extjs.seleccionarIdioma.call(extjs, extjs.currentLang + 1);
			//CKEDITOR.plugins.getPath('multilang');
			var btn = Ext.select("#" + e.id + "_toolbox .cke_button__multilang_icon").elements[0];
			//btn.style.backgroundImage.match(/https?:\/\/[^\)\"\']*/)[0]

			/*
			var newCls = btn.style.backgroundImage.split("langimg/")[0];
			newCls += "langimg/" + cls + ".png" + "\")";
			*/

			var origin = window.location.protocol + "//" + window.location.host;
			var pathName = window.location.pathname;
			var path = "";
			pathName = pathName.split("/");
			if (pathName.length > 3) {
				//garrom: No esta testeado, pero si hay mas de una ruta de path, deberia funcionar
				for (var i = 1; i < pathName.length - 1; i++) {
					path = "/" + pathName[i];
				};
			} else {
				path = "/" + pathName[pathName.length - 2];
			}
			var imgUrl = origin + path + "/ext5/uxAt4/ckeditor/ckeditor/langimg/" + cls + ".png";
			var newCls = "url(\"" + imgUrl + "\")";
			btn.style.backgroundImage = newCls;
		}
	})();
}
