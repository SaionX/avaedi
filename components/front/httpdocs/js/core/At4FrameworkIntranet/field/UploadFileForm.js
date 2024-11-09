//Namespace de At4FrameworkIntranet
Ext.namespace('At4FrameworkIntranet');

/**
 * @class Ext.form.FileUploadField
 * Definicio del camp per pujar fitxers.
 * És un camp de text TextField amb un un input file que s'envia al servlet
 * adient.
 * La part de multiidioma s'ha fet mirant com estava feta a la resta de JSPs
 * @extends-ext Ext.form.TextField
 * @author okkum
 */

//Ext.form.FileUploadField = Ext.extend(Ext.form.TextField,  {
//TODO: Inutil?
Ext.define("At4FrameworkIntranet.fileuploadfield", {
    extend: "Ext.form.TextField",
    windowHeight: 150,

    constructor: function(cfg) {
        this.addEvents(
            /**
             * @event fileselected
             * Fires when the underlying file input field's value has changed from the user
             * selecting a new file from the system file selection dialog.
             * @param {Ext.form.FileUploadField} this
             * @param {String} value The file value returned by the underlying file input field
             */
            'fileselected'
        );
        this.callParent([cfg]);
    },

    readOnly: true,
    style: 'width: 200px',
    /**
     * @hide
     * @method autoSize
     */
    autoSize: Ext.emptyFn,
    browseTxt: this.browseTxt,


    // private
    //initComponent: function() {
        //Ext.form.FileUploadField.superclass.initComponent.call(this);
   //     this.callParent();
    //},

    // private
    onRender: function(ct, position) {
        this.callParent(arguments);

        this.wrap = this.el.wrap({
            cls: 'x-form-field-wrap x-form-file-wrap'
        });
        this.el.addClass('x-form-file-text');
        this.el.dom.removeAttribute('name');

        this.createFileInput();

        var btnCfg = Ext.applyIf(this.buttonCfg || {}, {
            text: this.browseTxt
        });

        this.button = new Ext.Button(Ext.apply(btnCfg, {
            renderTo: this.wrap,
            cls: 'x-form-file-btn' + (btnCfg.iconCls ? ' x-btn-icon' : '')
        }));

        this.addFileListener();
        //Ext.form.FileUploadField.superclass.onRender.call(this, ct, position);

    },

    // private
    getFileInputId: function() {
        return this.id + '-file';
    },

    // private
    onResize: function(w, h) {
        //Ext.form.FileUploadField.superclass.onResize.call(this, w, h);
        this.callParent(arguments);
        this.wrap.setWidth(w);
    },

    // private
    preFocus: Ext.emptyFn,

    // private
    getResizeEl: function() {
        return this.wrap;
    },

    // private
    getPositionEl: function() {
        return this.wrap;
    },

    // private
    alignErrorIcon: function() {
        this.errorIcon.alignTo(this.wrap, 'tl-tr', [2, 0]);
    },

    //reseta el form, elimina el input y crea uno nuevo para borrar la acción anterior
    reset: function() {

        var fileInput = this.getFileInput();
        if (fileInput != null) {
            Ext.get(fileInput.id).findParentNode("form").reset();

            var duration = 100;
            var thisObj = this;

            //el retardo es para evitar que se duplique el input y no funcione la carga de archivos
            setTimeout(function() {
                thisObj.removeFileInput();
            }, duration);
            setTimeout(function() {
                thisObj.createFileInput();
            }, duration);
            setTimeout(function() {
                thisObj.addFileListener();
            }, duration);

        }

    },

    //private
    createFileInput: function() {
        this.fileInput = this.wrap.createChild({
            //id: this.getFileInputId(),
            name: this.name || this.getId(),
            cls: 'x-form-file',
            tag: 'input',
            type: 'file',
            size: 1
        });
    },

    //private
    removeFileInput: function() {
        this.fileInput.remove();
    },

    //private
    addFileListener: function() {
        this.fileInput.on('change', function() {
            var v = this.fileInput.dom.value;
            this.setValue(v);
            this.fireEvent('fileselected', this, v);
        }, this);

    },

    //public
    getFileInput: function() {
        return this.fileInput;
    }

});

//Ext.reg('fileuploadfield', 'Ext.form.FileUploadField');



Ext.enableDWRUploadFile = function(config) {

    var popup = {};
    popup['submit'] = config.submit;
    popup['check'] = config.check;

    var buttonIcon = config.buttonIcon;
    if (typeof(buttonIcon) == 'undefined') {
        buttonIcon = this.buttonIcon;
    }

    var buttonText = config.buttonText;
    if (typeof(buttonText) == 'undefined' || buttonText == '') {
        buttonText = this.buttonText;
    }

    /*popup['file'] = new At4FrameworkIntranet.fileuploadfield({
        fieldLabel: this.fieldLabel,
        width: 300
    });*/

    popup['file'] = Ext.create("Ext.form.field.File",{
        fieldLabel: this.fieldLabel,
        labelAlign: "top",
        labelWidth: 75,
        width: 300,

    })

    popup['fieldset'] = new Ext.form.FieldSet({
        defaults: {
            msgTarget: 'under',
            validationEvent: true
        },
        border: false,
        labelAlign: "top",
        autoHeight: true,
        autoWidth: true,
        collapsible: false,
        items: [popup['file']]
    });

    popup['nav'] = new Ext.FormPanel({
        labelWidth: 100,
        //frame: true,
        padding: "10 5 10 5",
        width: 200,
        border: false,
        fileUpload: true,
        collapsible: false,
        defaultType: 'textfield',
        items: [popup['fieldset']]
    });

    popup['dlgPopup'] = new Ext.Window({
        modal: true,
        layout: 'fit',
        width: 400,
        height: this.windowHeight,
        closable: false,
        resizable: false,
        plain: true,
        title: this.windowTitle,
        items: [popup['nav']],
        buttons: [{
            text: this.uploadButtonText,
            iconCls: this.uploadButtonIcon,
            handler: function() {
                popup['submit']();
                popup['dlgPopup'].hide();
            }
        }, {
            text: this.closeButtonText,
            iconCls: this.closeButtonIcon,
            handler: function() {
                popup['dlgPopup'].hide();
            }
        }]
    });

    this.uploadButton = new Ext.Button({
        text: buttonText,
        disabled: false,
        tabIndex: config.tabIndex,
        iconCls: buttonIcon,
        disabled: this.disabled,
        scope: this,
        handler: function() {
            if (popup['check']()) {
                var input = popup['file'];
                input.reset();
                popup['dlgPopup'].show();
            }
        }
    });

    this.getFileInput = function() {
        //return popup['file'].inputCell;
        return popup.file.button.fileInputEl.dom;
    }
}
