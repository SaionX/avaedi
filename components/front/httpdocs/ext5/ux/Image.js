//Ext.ux.Image = Ext.extend(Ext.Component, {

Ext.define("Ext.ux.Image", {
    extend: "Ext.Component",
    autoEl: {
        tag: 'img',
        src: Ext.BLANK_IMAGE_URL,
        cls: 'tng-managed-image'
    },

    //  Add our custom processing to the onRender phase.
    //  We add a ‘load’ listener to our element.
    onRender: function() {
        Ext.ux.Image.superclass.onRender.apply(this, arguments);
        this.el.on('load', this.onLoad, this);
        if (this.url) {
            this.setSrc(this.url);
        }
    },

    onLoad: function() {
        this.fireEvent('load', this);
    },

    setSrc: function(src) {
        if (this.rendered) {
            this.el.dom.src = src;
        } else {
            this.url = src;
        }
    }
});

//Ext.reg('image', 'Ext.ux.Image');