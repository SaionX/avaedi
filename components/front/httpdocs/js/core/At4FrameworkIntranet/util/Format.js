// Namespace de Ext.util
Ext.namespace('Ext.util');

/**
 * @class Ext.util.Format
 * Extensiones (overrides) a la clase de ext
 * @extends-ext Ext.util.Format
 * 
 */

/**
 * Formatea un número como moneda €
 * @method euroMoney
 * @param {Number/String} v El valor numérico a formatear
 * @return {String} La cadena monetaria formateada
 */
Ext.util.Format.euroMoney = function(v) {

	v = (Math.round((v - 0) * 100)) / 100;
	v = (v == Math.floor(v)) ? v + ".00" : ((v * 10 == Math.floor(v * 10)) ? v + "0" : v);
	v = String(v);
	var ps = v.split('.');
	var whole = ps[0];
	var sub = ps[1] ? ',' + ps[1] : ',00';
	var r = /(\d+)(\d{3})/;
	while (r.test(whole)) {
		whole = whole.replace(r, '$1' + '.' + '$2');
	}
	v = whole + sub;
	return v + " €";

};

Ext.util.Format.Doblers = function(v) {

	v = (Math.round((v - 0) * 100)) / 100;
	v = (v == Math.floor(v)) ? v + ".00" : ((v * 10 == Math.floor(v * 10)) ? v + "0" : v);
	v = String(v);
	var ps = v.split('.');
	var whole = ps[0];
	var sub = ps[1] ? ',' + ps[1] : ',00';
	var r = /(\d+)(\d{3})/;
	while (r.test(whole)) {
		whole = whole.replace(r, '$1' + '.' + '$2');
	}
	v = whole + sub;
	return v;

};


/**
 * Formatea un número según el locale 'ES': ###.###,##
 * @method esNumber
 * @param {Number/String} v El valor numérico a formatear
 * @return {String} La cadena formateada
 */
Ext.util.Format.esNumber = function(v) {

	v = String(v);

	var ps = v.split('.');
	var whole = ps[0];
	var sub = ps[1] ? ',' + ps[1] : '';
	var r = /(\d+)(\d{3})/;
	while (r.test(whole)) {
		whole = whole.replace(r, '$1' + '.' + '$2');
	}
	return whole + sub;

}

Ext.apply(Ext.util.Format, {
	numberFormat: {
		decimalSeparator: ',',
		decimalPrecision: 2,
		groupingSeparator: '.',
		groupingSize: 3,
		currencySymbol: '€'
	},

	/**
	 * Formatea un número según la configuración recibida en numberFormat
	 * @param {Object} value El valor numérico a formatear
	 * @param {Object} numberFormat Objeto conteniendo las propiedades: decimalSeparator, decimalPrecision, groupingSeparator, groupingSize, currencySymbol
	 */
	formatNumber: function(value, numberFormat) {
		var format = Ext.apply(Ext.apply({}, this.numberFormat), numberFormat);
		if (typeof value !== 'number') {
			value = String(value);
			if (format.currencySymbol) {
				value = value.replace(format.currencySymbol, '');
			}
			if (format.groupingSeparator) {
				value = value.replace(new RegExp(format.groupingSeparator, 'g'), '');
			}
			if (format.decimalSeparator !== '.') {
				value = value.replace(format.decimalSeparator, '.');
			}
			value = parseFloat(value);
		}
		var neg = value < 0;
		value = Math.abs(value).toFixed(format.decimalPrecision);
		var i = value.indexOf('.');
		if (i >= 0) {
			if (format.decimalSeparator !== '.') {
				value = value.slice(0, i) + format.decimalSeparator + value.slice(i + 1);
			}
		} else {
			i = value.length;
		}
		if (format.groupingSeparator) {
			while (i > format.groupingSize) {
				i -= format.groupingSize;
				value = value.slice(0, i) + format.groupingSeparator + value.slice(i);
			}
		}
		if (format.currencySymbol) {
			value = format.currencySymbol + value;
		}
		if (neg) {
			value = '-' + value;
		}
		return value;
	}
});
