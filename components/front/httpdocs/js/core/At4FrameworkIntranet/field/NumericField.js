// Currency Component
Ext.define('Ext.ux.CurrencyField', {
    extend: 'Ext.form.field.Number',
    alias: ['widget.currencyfield'],
    privateFocus: false,
    currency: '€', //change to the symbol you would like to display.
    listeners: {
        render: function(cmp) {
            cmp.showCurrency(cmp);
        },
        blur: function(cmp) {
            cmp.privateFocus = false;
            cmp.showCurrency(cmp);
        },
        focus: function(cmp) {
            cmp.privateFocus = true;
            cmp.setRawValue(cmp.valueToRaw(cmp.getValue()));
        },
        change: function(cmp, value) {
            if(!cmp.privateFocus){
                cmp.showCurrency(cmp);
            }
        }

    },
    showCurrency: function(cmp) {
        cmp.setRawValue(Ext.util.Format.currency(cmp.valueToRaw(cmp.getValue()), cmp.currency, 2, true));
    },
    valueToRaw: function(value) {
        if(!value){
            return value;
        }
        return value.toString().replace(/[^0-9.]/g, '');
    },
    rawToValue: function(value) {
        return Ext.util.Format.round(this.valueToRaw(value), 2);
    },
    getSubmitValue: function(){
        var val = this.callParent(arguments);
        return this.valueToRaw(val);
    },
    getErrors: function(val){
        val = this.rawToValue(val);
        return this.callParent([val]);
    }
});
// END Currency Component
