Ext.define("At4FrameworkIntranet.Bootstraper",{
    singleton: true,
    menuPrincipal: false,
    runIfReady: function () {
    	if (this.menuPrincipal && this.stateLoaded) {
            if (typeof CKEDITOR !== "undefined") {
    		          CKEDITOR.config.language = At4FrameworkIntranet.ApplicationBasic.prototype.idioma;
            }
    		window.At4FrameworkIntranet.app = Ext.create("At4FrameworkIntranet.Application");
    	}
    },
    run: function(){

        	//DwrStateProvider: True si se utiliza estado por DWR, falso si por cookie
        	var DwrStateProvider = true;

        	serverGui.getToolBarElements(function (data) {
        		this.menuPrincipal = data;
        		this.runIfReady();
        	}, this);

        	if (DwrStateProvider) {
        		// Para usar DwrStateProvider
        		Ext.state.Manager.setProvider(Ext.create("At4FrameworkIntranet.DwrStateProvider", {
        			saveAction: GuiService.saveState,
        			loadAction: GuiService.loadState,
        			autoRead: true,
        			logFailure: true,
        			listeners: {
        				readsuccess: {
        					fn: function () {
        						//console.log("Provider loaded");
        						this.stateLoaded = true;
        						this.runIfReady();
        					},
                            scope: this
        				}
        			},
        			logSuccess: true
        		}));
        	} else {
        		// PARA USAR CookieProvider
        		this.stateLoaded = true;
        		Ext.state.Manager.setProvider(Ext.create("Ext.state.CookieProvider", {}));
        	}
    }
})
Ext.onReady(function(){
    if (window == window.parent) {
        //Si window y window.parent no son el mismo, es que esta cargando dentro de un iframe, por eso, ni iniciamos.
        At4FrameworkIntranet.Bootstraper.run();
    }
})

var quickTipConfig = {
	trackMouse: false,
	anchor: 'top'
};
Ext.tip.QuickTipManager.init(true, quickTipConfig);


/**
 * Lista de ids internos de tab
 *
 * @private
 */
var tabIdRegister = [];

// private functions
var setMenuDefaults = function (menuConfig, defaults) {
	menuConfig.defaults = defaults;
	menuConfig.listeners = defaults.listeners;
	for (var i = 0; i < menuConfig.items.length; i++) {
		if (menuConfig.items[i].menu) {
			setMenuDefaults(menuConfig.items[i].menu, defaults)
		}
	}

}

// private variables

var gridMetaDataCache = [];


// Variable global per tal d'identificar univocament formularis nous.
var conNouReg = 0;

// Ext.QuickTips.init();
//
// Hace que por defecto estos componentes no guarden estado, para
// evitar este problema:
// http://www.sencha.com/forum/archive/index.php/t-37472.html

Ext.override(Ext.form.FormPanel, {
	stateful: false
});
Ext.override(Ext.form.Field, {
	stateful: false
});
Ext.override(Ext.form.Labelable, {
	msgTarget: "under"
});
Ext.override(Ext.form.field.Base, {
	msgTarget: "under"
});
Ext.override(Ext.form.field.Text, {
	setValue: function (value) {
		var me = this,
			inputEl = me.inputEl;
		me.fireEvent("setValue", me, value);

		if (inputEl && me.emptyText && !Ext.isEmpty(value)) {
			inputEl.removeCls(me.emptyUICls);
			me.valueContainsPlaceholder = false;
		}

		me.callParent(arguments);

		me.applyEmptyText();
		return me;
	}
});

Ext.override(Ext.form.field.Date, {
	valueToRaw: function (value) {
		if (value == "Invalid Date") {
			value = null;
		}
		return this.formatDate(this.parseDate(value));
	},
    emptyText: "dd-mm-aaaa"
});

Ext.override(Ext.form.TextArea, {
	grow: true
});

Ext.define('Ext.override.grid.filters.filter.Base', {
	override: 'Ext.grid.filters.filter.Base',
	createFilter: function (config, key) {
		var me = this,
			filter = me.callParent(arguments),
			type = me.getInitialConfig('type');
		filter.type = type;
		return filter;
	}
});
Ext.define('Ext.override.util.Filter', {
	override: 'Ext.util.Filter',
	getState: function () {
		var me = this,
			state = this.callParent(arguments);
		if (me.type) {
			state.type = me.type;
		}
		return state;
	}
});

//FIX DEL BUG AL AGRUPAR POR UNA COLUMNA DONDE HAY NULLS
//http://forums.ext.net/showthread.php?60224&p=275467&viewfull=1#post275467

Ext.grid.feature.Grouping.override({
    // Overridden because of #919
    getMetaGroup: function (group) {
        var metaGroupCache = this.metaGroupCache || this.createCache(),
            key,
            metaGroup;

        if (group.isModel) {
            group = this.getGroup(group);
        }

        if (group != null) { // #919. Do not replace with "!==", beucase it should filter for null and undefined.
            key = (typeof group === 'string') ? group : group.getGroupKey();
            metaGroup = metaGroupCache[key];

            if (!metaGroup) {
                metaGroup = metaGroupCache[key] = {
                    isCollapsed: false,
                    lastGroup: null,
                    lastGroupGeneration: null,
                    lastFilterGeneration: null,
                    aggregateRecord: new Ext.data.Model()
                };

                if (!metaGroupCache.map) {
                    metaGroupCache.map = {};
                }

                metaGroupCache.map[key] = true;
            }
        }

        return metaGroup;
    }
});
