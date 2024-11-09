Ext.define("At4FrameworkIntranet.FilterItemSelector", {
    extend: "Ext.form.FieldContainer",
    mixins: [
        //"Ext.form.Labelable",
        "Ext.form.field.Field"
    ],

    layout: "vbox",
    // margin: 0,
    padding: 0,

    constructor: function(cfg){
        this.fieldLabel = cfg.fieldLabel;
        this.hidden = cfg.hidden;
        delete cfg.hidden;
        delete cfg.fieldLabel;
        if(!cfg.listeners){
            cfg.listeners = {};
        }
        cfg.listeners.resize = {
            scope: this,
            fn: function(el, width, height, oldWidth, oldHeight, opts){
                if(height<oldHeight){
                    //console.log("aaay");
                    el.setHeight(oldHeight)
                    //return false;
                }
            }
        }
        this.selectorInput = Ext.create("At4FrameworkIntranet.ItemSelector", cfg);
        this.filterInput = Ext.create({
            xtype: "textfield",
            width: 200,
            emptyText: "Filtrar...",
            tabIndex: -1,
            enableKeyEvents: true,
            width: At4FrameworkIntranet.FormDefaults.HALF_TEXT_FIELD_WIDTH,
            listeners: {
                change:{
                    scope: this,
                    fn: function(input, newval, oldval){
                        if(newval){
                            var filter = {
                                property: "DISPLAY",
                                id: "searchFilter",
                                operator: "like",
                                type: "string",
                                value: newval
                            };
                            this.selectorInput.fromStore.remoteFilter = false;
                            // this.selectorInput.fromStore.addFilter(filter);
                            // this.selectorInput.fromStore.fireEvent("load", this.selectorInput.fromStore)
                            this.selectorInput.fromField.store.addFilter(filter)
                        }else{
                            this.selectorInput.fromField.store.clearFilter();
                        }
                    }
                },
                keypress: {
                    scope: this,
                    fn: function(el, ev, eopts){
                        // console.log(arguments);
                        if(ev.keyCode == 13){
                            // console.log("buscar");
                            var value = this.selectorInput.fromField.store.getRange();
                            this.selectorInput.moveRec(true, value);
                            el.blur();
                            el.setValue("");
                            // this.selectorInput.setValue(value);
                        }
                    }
                }
            }
        });
        var primercont = this.filterInput;
        if(cfg.extraFilter){
            cfg.extraFilter.margin = "0 0 0 15";
            primercont =
                {
                    xtype: "container",
                    layout: "hbox",
                    margin: "2 0 7 0",
                    items: [this.filterInput, cfg.extraFilter]
                };
        }
        this.items = [primercont, this.selectorInput];
        this.callParent();
        // window.test = this;
    },
    setValue: function(value){
        this.selectorInput.setValue(value);
    },
    getValue: function(){
        return this.selectorInput.getValue();
    }

})
