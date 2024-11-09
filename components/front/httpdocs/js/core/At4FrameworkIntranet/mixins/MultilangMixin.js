/**
 * @author: garrom
 * Mixin de simpleMultilang. Añade la posibilidad de multiIdioma a un campo.
 * Para ello solo se tiene que añadir los triggers con el boton y que llame a los metodos de este mixin
 * Ejemplo:
 *
 * Ext.define("xxx", {
 *     extend: "xxx",
 *     mixins: {
 *         multilang: 'At4Framework.mixin.simpleMultilang'
 *     },
 *     triggers: {
 *         selIdioma: {
 *             cls: "multilang-icon-Es",
 *             handler: function() {
 *                 this.mixin.multilangseleccionarIdioma.call(this, this.currentLang + 1);
 *             }
 *         }
 *     },
 *     (...)
 * });
 *
 */

Ext.define('At4FrameworkIntranet.mixin.simpleMultilang', {
    extend: 'Ext.Mixin',

    menuAll: null,
    flagSetValue: true,

    width: At4FrameworkIntranet.FormDefaults.TEXT_FIELD_WIDTH,

    langs: ['Es', 'Ca'],

    //Sobreescribible por instalación
    //langs: ['Es', 'En', 'Ca', 'De'],
    //OJO! Hay que editar tambien basicform multilangRE para que el getFieldEditor funcione bien


    //langs: ['Es', 'En', 'Ct'],


    /* constructor: function(config) {
         //this.initConfig(config);
         console.log("mixin constructor called");
     },*/

    /*initComponent: function() {
        var i;
        var lang;
        var name;
        this.inputs = {};
        //TODO: el idioma inicial
        this.currentLang = 0;
        for (i = 0; i < this.langs.length; i++) {
            lang = this.langs[i];
            name = this.name + lang;
            this.inputs[lang] = new Ext.form.field.Text({
                name: this.name + lang,
                multilang: this,
                lang: lang,
                hidden: true,
                setValue: function(v, reloaded) {
                    Ext.form.field.Text.superclass.setValue.call(this, v);
                    if (!reloaded) {
                        this.multilang.setLangValue(this.lang, v);
                    }
                }
            })
        }
    },*/
    initComponent: function(inputType) {
        //this.callParent();
        var i;
        var lang;
        var name;
        this.inputs = {};
        this.inputsArray = [];
        var inputType = inputType ? inputType : "Text";

        //TODO: el idioma inicial
        this.currentLang = 0;

        for (i = 0; i < this.langs.length; i++) {
            lang = this.langs[i];
            name = this.name + lang;
            var item = Ext.create("Ext.form.field." + inputType, {
                name: this.name + lang,
                multilang: this,
                lang: lang,
                style: "margin: 0px 3px 0px 3px; left: 0px; width: 100%",
                //label: "test"+lang,
                labelAlign: "left",
                hidden: true,
                triggers: {
                    selIdioma: {
                        cls: "multilang-icon-" + lang,
                        extraCls: "multilang-icon-static"
                    }
                },
                setValue: function(v) {

                    Ext.form.field[inputType].superclass.setValue.call(this, v);
                    this.multilang.setLangValue(this.lang, v);
                }
            });
            this.inputs[lang] = item;
            if (this.parentForm) {
                this.parentForm.hiddenFields.push(item);
            }
            this.inputsArray.push(item);
        }
        this.menuAll = Ext.create('Ext.menu.Menu', {
            cls: "multilang-menu",
            layout: 'vbox'
        });
    },

    seleccionarIdioma: function(numero) {
        this.inputs[this.langs[this.currentLang]].setValue(this.getValue());
        var prevLang = this.currentLang;

        this.currentLang = numero;
        if (this.currentLang >= this.langs.length) {
            this.currentLang = 0;
        }
        if (this.currentLang < 0) {
            this.currentLang = this.langs.length - 1;
        }
        this.setValue(this.inputs[this.langs[this.currentLang]].getValue());
        this.triggers.selIdioma.el.removeCls('multilang-icon-' + this.langs[prevLang]).addCls('multilang-icon-' + this.langs[this.currentLang]);
    },

    setLangValue: function(lang, v) {
        if (lang !== this.langs[this.currentLang]) {
            //console.log("LANG: El lang", lang, "no es el actual", this.langs[this.currentLang], "para valor", v);
            return;
        }
        if (!this.flagSetValue) {
            //console.log("LANG: El flagSetValue es falso", lang, v);
            this.flagSetValue = true;
            return;
        }
        //console.log("LANG: seteamos value", lang, v);
        this.setValue(v);
    },
    listeners: {
        render: function(el, eOpts) {
            var i, lang, name;
            for (i = 0; i < this.langs.length; i++) {
                lang = this.langs[i];
                name = this.name + lang;
                this.ownerCt.add(this.inputs[lang]);
            }

        },
        change: function() {
            var input = this.inputs[this.langs[this.currentLang]];
            var value = this.getValue();
            input.setValue(value, true);
            this.flagSetValue = false;
        }
    },

    /**
     * Sobreescribimos getErrors para poder desactivar validación para los idiomas secundarios
     * TODO: Cada idioma podría tener sus características de validación, pero por ahora sólo tenemos los del idioma principal
     */

    checkError: function(value) {
        /*
                if (this.currentLang == 0) {
                    //return At4FrameworkIntranet.MultilangText.superclass.getErrors.apply(this, arguments);
                    return this.callParent(arguments);
                } else {
                    return [];
                }*/
        return this.currentLang == 0;
    }

});


/**
 * @author: garrom
 * Extension del mixin: At4Framework.mixin.simpleMultilang
 * Mixin de MenuMultilang. Añade al multiidioma, un menu desplegable
 * Para ello solo hay que añadir al trigger existente uno nuevo
 * Ejemplo:
 *
 * Ext.define("xxx", {
 *     extend: "xxx",
 *     mixins: {
 *         multilang: 'At4Framework.mixin.MenuMultilang'
 *     },
 *     triggers: {
 *         selIdioma: {
 *             cls: "multilang-icon-Es",
 *             handler: function() {
 *                 this.mixin.multilangseleccionarIdioma.call(this, this.currentLang + 1);
 *             }
 *         },
 *         dropIdioma: {
 *            cls: "multilang-all",
 *            handler: function() {
 *                this.mixins.multilang.desplegarIdiomas.call(this);
 *           }
 *     },
 *     (...)
 * });
 *
 */
Ext.define('At4FrameworkIntranet.mixin.MenuMultilang', {
    extend: 'At4FrameworkIntranet.mixin.simpleMultilang',

    desplegarIdiomas: function() {
        if (!this.itemsAddedToMenu) {
            this.menuAll.add(this.menuItems);
            this.itemsAddedToMenu = true;
        }
        for (i = 0; i < this.menuAll.items.items.length; i++) {
            if (this.menuAll.items.items[i].lang == this.langs[this.currentLang]) {
                this.menuAll.items.items[i].hide();
            } else {
                this.menuAll.items.items[i].show();
            }
        }
        var xy = this.getXY();
        xy[1] = xy[1] + this.getHeight();
        this.menuAll.setWidth(this.getWidth());
        this.menuAll.showAt(xy);
    },

    initComponent: function() {
        this.callParent(arguments);
        this.menuItems = [];
        //Añade un editor al menu que lo que hara es cambiar el valor del field que debe.
        Ext.each(this.inputsArray, function(input, inputIndex, inputsArray) {
            var item = {
                xtype: "textfield",
                triggers: input.triggers,
                lang: input.lang,
                inputMainField: input,
                listeners: {
                    change: {
                        fn: function(obj, value) {
                            this.setValue(value);
                            //console.log("menu changed");
                        },
                        scope: input
                    },
                    render: {
                        fn: function(obj, opts) {
                            obj.setValue(obj.inputMainField.getValue());
                        }
                    }
                },
            };
            this.menuItems.push(item);
            var actualizarValueFn = function(obj, value) {
                if (obj.tempField) {
                    console.log("tempField changed");
                    obj.tempField.setValue(value);
                } else {
                    for (i in this.menuAll.items.items) {
                        if (this.menuAll.items.items.hasOwnProperty(i)) {
                            obj.tempField = this.menuAll.items.items[i];
                            if (obj.tempField.lang == obj.lang) {
                                obj.tempField.setValue(value);
                                break;
                            }
                        }
                    }
                }
            };
            input.addListener("change", actualizarValueFn, this);


        }, this);

    },

    menuItems: [],
    itemsAddedToMenu: false,

    listeners: {
        render: function(el, eOpts) {
            var i, lang, name;
            for (i = 0; i < this.langs.length; i++) {
                lang = this.langs[i];
                name = this.name + lang;
                this.ownerCt.add(this.inputs[lang]);
            }


        },
        keypress: function(comp, ev, eOpts) {
            var avanzar = true;
            switch (ev.keyCode) {
                case 13:
                    avanzar = true;
                    break;
                case 18:
                    avanzar = false;
                    break;
                default:
                    return;
            }
            avanzar = ev.shiftKey ? !avanzar : avanzar;
            if (avanzar) {
                this.seleccionarIdioma(this.currentLang + 1);
            } else {
                this.seleccionarIdioma(this.currentLang - 1);
            }
        },
        change: function() {
            this.inputs[this.langs[this.currentLang]].setValue(this.getValue(), true);
            //this.inputs[this.langs[this.currentLang]].inputMainField.setValue(this.getValue(), true);
        }
    },

    /*initComponent: function() {
        //this.callParent();
        var i;
        var lang;
        var name;
        this.inputs = {};
        this.inputsArray = [];

        //TODO: el idioma inicial
        this.currentLang = 0;

        for (i = 0; i < this.langs.length; i++) {
            lang = this.langs[i];
            name = this.name + lang;
            var item = Ext.create("Ext.form.field.Text", {
                name: this.name + lang,
                multilang: this,
                lang: lang,
                style: "margin: 0px 3px 0px 3px; left: 0px; width: 100%",
                //label: "test"+lang,
                labelAlign: "left",
                hidden: true,
                triggers: {
                    selIdioma: {
                        cls: "multilang-icon-" + lang,
                    }
                },
                setValue: function(v) {
                    Ext.form.field.Text.superclass.setValue.call(this, v);
                    this.multilang.setLangValue(this.lang, v);
                }
            });
            this.inputs[lang] = item;
            this.inputsArray.push(item);
        }
        this.menuAll = Ext.create('Ext.menu.Menu', {});
    }*/
});

Ext.define('At4FrameworkIntranet.mixin.DroppedMultilang', {
    extend: 'At4FrameworkIntranet.mixin.simpleMultilang'
});
