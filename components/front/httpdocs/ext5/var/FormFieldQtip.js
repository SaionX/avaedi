// Namespace 
Ext.namespace('Ext.form');

/**
 * @class Ext.form.Field
 * Extensiones (overrides) a la clase de ext
 * @extends-ext Ext.form.Field
 * 
 */

/**
 * Permite indicar 'qtip' en campos de formulario<br/>
 * ver: http://extjs.com/forum/showthread.php?t=16326
 * @method afterRender
 */
//Ext.form.Field.prototype.afterRender = Ext.form.Field.prototype.afterRender.createSequence(function() {	
Ext.form.Field.prototype.afterRender = Ext.Function.createSequence(Ext.form.Field.prototype.afterRender, function() {
	if (this.qtip) {
		Ext.QuickTips.register({
			target: this.getEl(),
			dismissDelay: 30000,
			text: this.qtip,
			enabled: true
		});
		var label = formFieldQtipFindLabel(this);
		if (label) {
			Ext.QuickTips.register({
				target: label,
				dismissDelay: 30000,
				text: this.qtip,
				enabled: true
			});
		}
	}
});
var formFieldQtipFindLabel = function(field) {
	var wrapDiv = null;
	var label = null
		//find form-element and label?
	wrapDiv = field.getEl().up('div.x-form-element');
	if (wrapDiv) {
		label = wrapDiv.child('label');
	}
	if (label) {
		return label;
	}
	//find form-item and label
	wrapDiv = field.getEl().up('div.x-form-item');
	if (wrapDiv) {
		label = wrapDiv.child('label');
	}
	if (label) {
		return label;
	}
}