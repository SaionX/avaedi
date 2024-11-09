Ext.define("At4FrameworkIntranet.ZonaPointGMapField", {
	extend: "At4FrameworkIntranet.PointGMapField",
	xtype: "At4ZonaPointGMapField",

	//locale
	editPolytxt: "Editar",
	savePolytxt: "Aceptar",
	buttonHelpTxt: "Ayuda",
	helpWindowTitle: "Ayuda: Selector de ubicacion sobre mapa",
	helpHtml: "<div>Test</div>",
	//end locale

	showEditButton: true,
	showHelpButton: false,
	isEditing: false,

	constructor: function() {
		this.callParent(arguments);
		var me = this;
		me.zonas = [];

	},
	disable: function(){
		var me = this;
		me.disabled = true;
		me.button.disable();
	},
	enable: function(){
		var me = this;
		me.disabled = false;
		me.button.enable();
	},

	buttonHandler: function(btn) {
		var me = this;
		if (me.isEditing) {
			return me.stopEdit(btn);
		} else {
			btn.setText(me.savePolytxt);
			return me.startEdit(btn);
		}
	},

	onMapReady: function() {
		this.callParent();
		var me = this;
		me.map.mask();
	},
	mostrarZonas: function() {
		var me = this;
		me.store.each(function(item) {
			console.log(item);
		});
	},
	mapReadySetValue: function(val) {
		var me = this;
		if (val && val.x && val.y) {
			var myLatLng = new google.maps.LatLng({
				lat: val.y,
				lng: val.x
			});
			me.centerMap(myLatLng);
			me.addMarker(myLatLng);
		}else{
			if(me.marker){
				me.marker.setMap(null);
				me.marker = null;
			}
		}
	},

	startEdit: function() {
		var me = this;
		me.isEditing = true;
		me.button.setText(me.savePolytxt);
		me.map.unmask();
	},
	stopEdit: function() {
		var me = this;
		me.isEditing = false;
		me.button.setText(me.editPolytxt);
		me.map.mask();
		if(me.marker){
			me.centerMap(me.marker.getPosition());
		}
	},

	setValue: function(){
		this.stopEdit();
		return this.callParent(arguments);
	},

	getValue:function(){
		this.stopEdit();
		return this.callParent();
	}
	/*
	ocultarZonas: function() {

},

createaStore: function() {
var me = this;
var modelName = "At4FrameworkIntranet.zonasPointModel-" + me.name;
var model = "";
var campos = [{
name: "ID"
}, {
name: "DISPLAY"
}];
if (Ext.ClassManager.isCreated(modelName)) {
model = Ext.ClassManager.get(modelName);
} else {
model = Ext.define(modelName, {
extend: 'Ext.data.Model',
fields: campos,
proxy: {
type: "dwr",
dwrFunction: FormDataService.devolverZonasPoly,
reader: {
type: "json",
totalProperty: "totalNumRecords",
rootProperty: "resultados",
model: modelName
},
//dwrParams: [formName, fieldName],
listeners: {
'beforeload': function(dataProxy, config) {
var params = config.params ? config.params : [];
},
'loadexception': function(dataProxy, message, loadCallback, exception) {
Ext.Msg.alert('Error:', message);
}
}
}
});
}
var store = Ext.create("Ext.data.Store", {
model: model
});
return store;
}
*/

});
