Ext.define("Ext.ux.colorpick.Field",{
    extend: "Ext.form.field.Text",
    xtype: "colorpicker",
    triggers: {
        preview: {
            cls: 'my-preview-trigger',
            handler: function() {
                console.log('foo trigger clicked');
            }
        }
    },

    // preSubTpl: [
    //     '<div id="{cmpId}-triggerWrap" data-ref="triggerWrap" class="{triggerWrapCls} {triggerWrapCls}-{ui}">',
    //     "<span>test</span>",
    //     '<div id={cmpId}-inputWrap data-ref="inputWrap" class="{inputWrapCls} {inputWrapCls}-{ui}">'
    // ],
})


Ext.define("At4FrameworkIntranet.ColorWindow",{
    extend: "Ext.window.Window",
    height: 500,
    width: 500,
    layout: "hbox",
    constructor: function(){
        this.hex = Ext.create({
            xtype: "textfield",
            listeners:{
                change:{
                    scope: this,
                    fn: this.onInputChange
                }
            }
        })
        this.rfield = Ext.create({
            xtype: "numberfield",
            maxValue: 255,
            minValue: 0,
            listeners:{
                change:{
                    scope: this,
                    fn: this.onRGBChange
                }
            }
        })
        this.gfield = Ext.create({
            xtype: "numberfield",
            maxValue: 255,
            minValue: 0,
            listeners:{
                change:{
                    scope: this,
                    fn: this.onRGBChange
                }
            }
        })
        this.bfield = Ext.create({
            xtype: "numberfield",
            maxValue: 255,
            minValue: 0,
            listeners:{
                change:{
                    scope: this,
                    fn: this.onRGBChange
                }
            }
        })
        // this.afield = Ext.create({
        //     xtype: "textfield"
        // })
        this.degradado = Ext.create({
            xtype: "component",
            width: 200,
            height: 200
        })
        this.slider = Ext.create({
            xtype: "component",
            width: 30,
            height: 200
        })

        this.items = [
             this.degradado, this.slider, {
                 xtype: "container",
                 layour: "vbox",
                 items: [
                     this.hex, this.rfield, this.gfield, this.bfield, this.afield
                 ]
             }
        ];
        this.listeners = {
            afterrender: {
                scope: this,
                fn: function(){
                    console.log(arguments);
                    var me = this;
                    this.colorPicker = ColorPicker(this.slider.el.dom, this.degradado.el.dom, function(hex,hsv,rgb, mouse, slider){
                    //     ColorPicker.positionIndicators(
                    //        document.getElementById('slide-indicator'),
                    //        document.getElementById('picker-indicator'),
                    //        mouseSlide, mousePicker
                    //    );
                        me.onEditorChange(hex,hsv,rgb);
                    });
                }
            }
        }
        this.callParent();

    },

    onEditorChange: function(hex,hsv,rgb){
        if(this.oldValue == hex){
            return;
        }
        this.oldValue = hex;
        this.hex.setValue(hex);
        this.rfield.setValue(rgb.r);
        this.gfield.setValue(rgb.g);
        this.bfield.setValue(rgb.b);
        console.log(hex,hsv,rgb);
    },

    onRGBChange: function(){
        var r = this.rfield.getValue();
        var g = this.gfield.getValue();
        var b = this.bfield.getValue();
        this.colorPicker.setRgb({ r: r, g: g, b: b });
    },

    onInputChange: function(input, newval, oldval){
        this.colorPicker.setHex(newval);
    }

})

Ext.onReady(function(){
    Ext.create("At4FrameworkIntranet.ColorWindow").show();
})
