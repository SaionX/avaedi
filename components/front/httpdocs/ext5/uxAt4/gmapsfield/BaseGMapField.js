Ext.define("At4FrameworkIntranet.BaseGMapField", {
	extend: "Ext.form.FieldContainer",
	mixins: [
		'Ext.form.Labelable',
		'Ext.form.field.Field'
	],
	width: "100%",
	height: 650,
	layout: 'vbox',

	gmapsReady: false,
	isEditing: false,
	name: "at4mapfield",
	fieldLabel: "at4mapfield",
	labelAlign: "top",
	markerIcon: "ext5/uxAt4/gmapsfield/img/pinxito.png",

	showEditButton: false,
	showHelpButton: false,
	showCancelButton: false,

	valueCache: null,


	constructor: function (options) {
		var me = this;
		window.test = me;
		Ext.apply(this, options);
		this.callParent();
		var panelSuperior = false;
		if (me.showEditButton) {
			panelSuperior = true;
			me.button = new Ext.button.Button({
				xtype: "button",
				text: me.editPolytxt,
				btnID: "edit",
				listeners: {
					click: {
						fn: me.buttonHandler,
						scope: me
					}
				}
			});
		}
		if (me.showCancelButton) {
			panelSuperior = true;
			me.cancelButton = new Ext.button.Button({
				xtype: "button",
				btnID: "cancel",
				text: me.cancelButtonTxt,
				listeners: {
					click: {
						fn: me.cancelButtonHandler,
						scope: me
					}
				}
			});
		}


		if (me.showHelpButton) {
			panelSuperior = true;
			me.helpButton = new Ext.button.Button({
				xtype: "button",
				text: me.buttonHelpTxt,
				margin: "0 0 0 20",
				btnID: "help",
				listeners: {
					click: {
						fn: me.buttonHelpHandler,
						scope: me
					}
				}
			});
		}

		me.map = Ext.create('Ext.panel.Panel', {
			closeAction: "hide",
			//title: 'GMap Window',
			layout: 'fit',
			//region:'center',
			width: me.width,
			height: me.height - 60,
			items: {
				xtype: 'gmappanel',
				gmapType: 'map',
				border: true,

				center: {
					lat: 39.570718,
					lng: 2.650641
				},
				mapOptions: {
					//disableDefaultUI: true,
					streetViewControl: false,
					mapTypeId: google.maps.MapTypeId.ROADMAP,
					styles: [{
						"featureType": "poi",
						"elementType": "labels.text",
						"stylers": [{
							"visibility": "off"
						}]
					}, {
						"elementType": "labels.icon",
						"stylers": [{
							"visibility": "off"
						}]
					}]
				},
				listeners: {
					"mapready": {
						fn: function (extjsOBJ, gmapsOBJ) {
							me.gmaps = gmapsOBJ;
							me.gmapsReady = true;
							me.onMapReady();
						}
					}
				}
			}
		});
		if (panelSuperior) {
			me.panelSuperior = new Ext.panel.Panel({
				height: 35,
				defaults: {
					margin: "0 5px 0px 5px"
				},
				margin: "7px 0px 7px 0px",
				//region:'west',
				//items: [me.btGuardarPol, me.btEditarPol, me.btTest]
				items: [me.button, me.helpButton, me.cancelButton]

			});
			me.items.add(me.panelSuperior);
		}
		me.items.add(me.map);
		me.border = true;
		me.addCls("at4-gmapField");
	},
	onMapClick: function (event) {
		var me = this;
		if (!me.isEditing) {
			return;
		}
		var lat = event.latLng.lat();
		var lng = event.latLng.lng();
		var latLng = new google.maps.LatLng(lat, lng);
		me.addMarker(latLng);
	},

	onMapReady: function () {
		var me = this;
		if (me.valueCache) {
			me.mapReadySetValue(me.valueCache);
		}
		me.gmaps.addListener('click', function (ev) {
			me.onMapClick(ev);
		});
	},

	getValue: function () {
		console.log("getValue");
		console.warn("Not implemented yet");
		return "Not implemented";
	},
	getSubmitData: function () {
		console.log("getSubmitData");
		console.warn("Not implemented yet");
		return "Not implemented";
	},
	setValue: function (val) {
		var me = this;
		if (me.gmapsReady) {
			me.mapReadySetValue(val);
		} else {
			me.valueCache = val;
		}
	},
	mapReadySetValue: function (val) {
		console.log(val);
		console.log("setValue");
		console.warn("Not implemented yet");
	},
	centerMap: function (val1, val2) {
		var me = this;
		var latLng;
		if (typeof (val1) == "object") {
			latLng = val1;
		} else {
			var lat = val1,
				lng = val2;
			latLng = new google.maps.LatLng(lat, lng)
		}
		me.gmaps.setCenter(latLng);
	}

});
if (typeof google !== "undefined") {
	google.maps.Polygon.prototype.my_getBounds = function () {
		var bounds = new google.maps.LatLngBounds()
		this.getPath().forEach(function (element, index) {
			bounds.extend(element)
		})
		return bounds
	}
}
