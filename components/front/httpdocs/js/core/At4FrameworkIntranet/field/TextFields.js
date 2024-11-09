/**
 * @author: garrom
 * Campo de texto simple con multi idioma y menu desplegable
 */
Ext.define("At4FrameworkIntranet.MultilangText", {
	extend: "Ext.form.field.Text",
	xtype: 'At4FrameworkIntranet-multilangtext',
	mixins: {
		multilang: 'At4FrameworkIntranet.mixin.MenuMultilang'
	},
	//True si activar el cambiar de lenguaje con teclas
	enableKeyEvents: true,

	constructor: function (config) {
		this.callParent(arguments);
		this.mixins.multilang.constructor.call(this, config);
	},
	triggers: {
		selIdioma: {
			cls: "multilang-icon-Es",
			handler: function () {
				this.mixins.multilang.seleccionarIdioma.call(this, this.currentLang + 1);
			}
		},
		dropIdioma: {
			cls: "multilang-all",
			handler: function () {
				this.mixins.multilang.desplegarIdiomas.call(this);
			}
		}
	},
	/*
	    listeners:{
	        render: function(){
	            //garrom: Por alguna extraña razon no se llama a la funcion render del mixin, provocando que el
	            //formulario padre no tenga los campos multiidioma en ellos
	            this.mixins.multilang.listeners.render.call(this);
	        },
	        change: function(){
	            //garrom: Mas de lo mismo:
	            this.mixins.multilang.listeners.change.call(this);
	        }
	    },*/


	initComponent: function () {
		this.callParent();
		this.mixins.multilang.initComponent.call(this);
	},
	getErrors: function () {
		if (this.mixins.multilang.checkError.call(this)) {
			return this.callParent(arguments);
		}
		return [];
	}

});


/**
 * @author: garrom
 * Area de texto grande simple
 */

Ext.define("At4FrameworkIntranet.Textarea", {
	extend: "Ext.form.field.TextArea",
	//override:
	growMin: 80,
	growMax: 350,
	grow: true
});

/**
 * @author: garrom
 * Area de texto grande multilenguaje
 */

Ext.define("At4FrameworkIntranet.MultilangTextarea", {
	extend: "Ext.form.field.TextArea",
	xtype: 'At4FrameworkIntranet-multilangtextarea',
	mixins: {
		multilang: 'At4FrameworkIntranet.mixin.DroppedMultilang'
	},
	width: At4FrameworkIntranet.FormDefaults.TEXT_FIELD_WIDTH,
	//override:
	growMin: 80,
	growMax: 350,
	grow: true,

	triggers: {
		selIdioma: {
			cls: "multilang-icon-Es",
			extraCls: "multilang-icon",
			handler: function () {
				this.seleccionarIdioma.call(this, this.currentLang + 1);
			}
		}
	},
	constructor: function (config) {
		this.callParent(arguments);
		this.mixins.multilang.constructor.call(this, config);
	},

	initComponent: function () {
		this.mixins.multilang.initComponent.call(this, "TextArea");
		this.callParent();
	},
	getErrors: function () {
		if (this.mixins.multilang.checkError.call(this)) {
			return this.callParent(arguments);
		}
		return [];
	}

	/*
	    triggers: {
	        es: {
	            cls: "multilang-icon-Es",
	            extraCls: " multilang-icon",
	            width: "22px",
	            height: "22px"
	        },
	        en: {
	            cls: " multilang-icon-En",
	            extraCls: "multilang-icon",
	            width: "22px",
	            height: "22px"
	        },
	        ca: {
	            cls: "multilang-icon-Ca",
	            extraCls: " multilang-icon",
	            width: "22px",
	            height: "22px"
	        },
	        xx: {
	            cls: "multilang-icon-Xx",
	            extraCls: " multilang-icon",
	            width: "22px",
	            height: "22px"
	        },
	    },*/
	/*
	listeners:{
	    render: function(){
	        //garrom: Por alguna extraña razon no se llama a la funcion render del mixin, provocando que el
	        //formulario padre no tenga los campos multiidioma en ellos
	        this.mixins.multilang.listeners.render.call(this);
	    },
	    change: function(){
	        //garrom: Mas de lo mismo:
	        this.mixins.multilang.listeners.change.call(this);
	    }
	},*/
});


/**
 * @author: garrom
 * Area de texto avanzada (html) con un editor CKE
 */

if (typeof CKEDITOR !== "undefined") {
	Ext.define("At4FrameworkIntranet.HtmlArea", {
		extend: "Ext.ux.CKEditor",
		xtype: 'At4FrameworkIntranet-htmlarea',
		labelStyle: "height: 25px;",
		listeners: {
			resize: function (extjScope, ckeScope) {
				extjScope.ownerCt.doLayout();
			},
			instanceReady: function (extjScope, ckeScope) {
				extjScope.ownerCt.doLayout();
			}
		}
	});


	/**
	 * @author: garrom
	 * Area de texto avanzada (html) con un editor CKE y multi idioma
	 */

	Ext.define("At4FrameworkIntranet.MultilangHtmlArea", {
		extend: "At4FrameworkIntranet.HtmlArea",
		xtype: 'At4Framework-multilanghtmlarea',
		mixins: {
			multilang: 'At4FrameworkIntranet.mixin.simpleMultilang'
		},
		width: At4FrameworkIntranet.FormDefaults.TEXT_FIELD_WIDTH,
		//override:
		grow: false,
		labelAlign: "top",
		/*
    triggers: {
        selIdioma: {
            cls: "multilang-icon-Es",
            extraCls: " multilang-icon",
            handler: function() {
                this.seleccionarIdioma.call(this, this.currentLang + 1);
            }
        }
    },
*/

		constructor: function (config) {
			//console.log("MultilangHtmlArea::constructor");
			this.callParent(arguments);
			this.mixins.multilang.constructor.call(this, config);
			window.temp1 = this;
		},
		initComponent: function () {
			//this.CKConfig.extraPluginTestScope = this;
			//his.mixins.multilang.initComponent.call(this);
			//console.log("MultilangHtmlArea::initComponent");
			this.mixins.multilang.initComponent.call(this, "TextArea");
			this.callParent();
		},
		getErrors: function () {
			if (this.mixins.multilang.checkError.call(this)) {
				return this.callParent(arguments);
			}
			return [];
		},

		listeners: {
			render: function () {
				//garrom: Por alguna extraña razon no se llama a la funcion render del mixin, provocando que el
				//formulario padre no tenga los campos multiidioma en ellos
				this.mixins.multilang.listeners.render.call(this);
			},
			change: function () {
				//garrom: Mas de lo mismo:
				this.mixins.multilang.listeners.change.call(this);
			}
		},

		seleccionarIdioma: function (numero) {
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
			var newCLS = 'multilang-icon-' + this.langs[nextLang];
			this.triggerEl.removeCls('multilang-icon-' + this.langs[prevLang]).addCls(newCLS);
			return newCLS;
		},
		CKConfig: {
			extraPlugins: 'justify,multilang',
			extraPluginFn: function () {
				this.seleccionarIdioma.call(this, this.currentLang + 1);
			},
			toolbarGroups: [{
				name: 'document',
				groups: ['mode', 'document', 'doctools']
			}, {
				name: 'clipboard',
				groups: ['clipboard', 'undo']
			}, {
				name: 'editing',
				groups: ['find', 'selection', 'multilanggroup']
			}, {
				name: 'forms'
			}, {
				name: 'basicstyles',
				groups: ['basicstyles', 'cleanup']
			}, {
				name: 'paragraph',
				groups: ['list', 'indent', 'blocks', 'align', 'bidi']
			}, {
				name: 'links'
			}, {
				name: 'styles',
				groups: ['styles']
			}, {
				name: 'styles'
			}, {
				name: 'colors'
			}, {
				name: 'tools'
			}, {
				name: 'others'
			}, {
				name: 'about'
			}],
			"entities": false,
			"basicEntities": false,
			skin: 'icy_orange',
			preset: 'full',
			languages: {
				'ca': 1,
				'en': 1,
				'es': 1
			}
		}
	});
}
