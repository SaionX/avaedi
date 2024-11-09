Ext.define('At4FrameworkIntranet.ColorPickField', {
    extend: 'Ext.ux.colorpick.Field',
    editable: true,
    listeners: {
        change: function(me, newval, oldval){
            if(newval != oldval){
                me.updateValue(newval);
            }
        }
    }
});
