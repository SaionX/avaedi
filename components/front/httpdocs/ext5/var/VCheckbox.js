/*global Ext */

Ext.ns('Ext.ux.form');
/**
 * @class Ext.ux.VCheckbox
 * @extends-ext Ext.form.Checkbox
 */
//Ext.ux.form.VCheckbox = Ext.extend(Ext.ux.form.XCheckbox, {
Ext.define("Ext.ux.form.VCheckbox", {
	extend: "Ext.ux.form.XCheckbox",
	checkedCls: 'v-form-check-checked',

	focusCls: 'v-form-check-focus',

	overCls: 'v-form-check-over',

	mouseDownCls: 'v-form-check-down',

	baseCls: 'v-form-check'

}); // eo extend

// register xtype
//Ext.reg('vcheckbox', 'Ext.ux.form.VCheckbox');

// eo file