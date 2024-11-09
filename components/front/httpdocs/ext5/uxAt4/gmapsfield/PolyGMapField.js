Ext.define("At4FrameworkIntranet.PolyGMapField", {
	extend: "At4FrameworkIntranet.BaseGMapField",
	xtype: "At4PolyGMapField",

	//locale
	editPolytxt: "Redibujar",
	savePolytxt: "Aceptar",
	buttonHelpTxt: "Ayuda",
	cancelButtonTxt: "Cancelar",
	helpWindowTitle: "Ayuda: Editor de poligonos sobre mapa",
	helpHtml: "<div>Test</div>",
	//end locale

	showEditButton: true,
	showHelpButton: false,
	showCancelButton: true,

	constructor: function(options) {
		var me = this;
		Ext.apply(this, options);
		this.callParent();
		me.cancelButton.hide();
		me.store = new Ext.data.SimpleStore({
			fields: ['id', 'lat', 'lng'],
		});
		me.coords = [];
		me.markers = [];
	},

	buttonHandler: function(btn) {
		var me = this;
		if (btn.btnID == "edit") {
			if (me.isEditing) {
				me.isEditing = false;
				me.map.mask();
				me.button.setText(me.editPolytxt);
				return me.guardarPolHandler(btn);
			} else {
				me.isEditing = true;
				me.map.unmask();
				me.button.setText(me.savePolytxt);
				return me.editarPolHandler(btn);
			}
		} else {
			me.isEditing = false;
			me.map.mask();
			me.button.setText(me.editPolytxt);
			me.cancelButton.hide();
			me.showPoly();
		}


	},

	editarPolHandler: function(btn) {
		var me = this;
		me.cancelButton.show();
		if (me.polygon) {
			me.polygon.setMap(null);
		}
		me.store.clearData();
		return;
		/*
		//Este codigo repinta los datos
		me.store.each(function(item) {
			var myLatLng = new google.maps.LatLng({
				lat: item.get("lat"),
				lng: item.get("lng")
			});
			me.addMarker(myLatLng);
		})
		*/
	},

	cancelButtonHandler: function(btn) {
		var me = this;
		me.buttonHandler(btn);
	},

	showPoly: function() {
		var me = this;
		me.poly.getPath().clear();
		Ext.each(me.markers, function(obj) {
			obj.setMap(null);
		});
		if (me.polygon) {
			me.polygon.setMap(null);
		}
		me.polygon = new google.maps.Polygon({
			paths: me.coords,
			strokeColor: '#FF0000',
			strokeOpacity: 0.5,
			strokeWeight: 3,
			fillColor: '#FF0000',
			fillOpacity: 0.15
		});
		me.polygon.setMap(me.gmaps);

		var bounds = me.polygon.my_getBounds();
		me.gmaps.fitBounds(bounds);
		me.centerMap(bounds.getCenter());

	},

	buttonHelpHandler: function() {
		var me = this;
		Ext.create('Ext.window.Window', {
			title: me.helpWindowTitle,
			closeAction: "destroy",
			height: 200,
			width: 400,
			html: me.helpHtml
		}).show();
	},

	guardarPolHandler: function() {
		var me = this;
		me.cancelButton.hide();
		//marker.setMap(null);
		//me.poly.setMap(null);
		me.coords = [];
		me.store.each(function(obj) {
			coord = {
				lat: obj.get("lat"),
				lng: obj.get("lng")
			};
			me.coords.push(coord);
		});
		me.showPoly();
	},

	onMapReady: function() {
		this.callParent();
		var me = this;
		me.poly = new google.maps.Polyline({
			strokeColor: '#000000',
			strokeOpacity: 1.0,
			strokeWeight: 3
		});
		me.poly.setMap(me.gmaps);
	},


	addMarker: function(latLng) {
		var me = this;
		me.saveMark(latLng);
		var path = me.poly.getPath();
		path.push(latLng);
		var marker = new google.maps.Marker({
			position: latLng,
			title: '#' + path.getLength() + latLng.lat() + ":" + latLng.lng(),
			icon: me.markerIcon,
			map: me.gmaps
		});
		marker.addListener('click', function(ev) {
			me.onMarkerClick(ev, marker);
		});
		me.markers.push(marker);
	},
	saveMark: function(latLng) {
		var me = this;
		var lat = latLng.lat();
		var lng = latLng.lng();
		var id = lat + ":" + lng;
		if (me.store.getById(id)) return;
		me.store.add({
			lat: lat,
			lng: lng,
			id: id
		});
	},

	onMarkerClick: function(event, marker) {
		var me = this;
		me.poly.getPath().forEach(function(el, index) {
			if (el == event.latLng) {
				me.poly.getPath().removeAt(index);
				marker.setMap(null);
				me.store.removeAt(index, 1);
			}
		});
		console.log(arguments);
	},
	getValue: function() {
		var me = this;
		/*var datos = [];
		me.store.each(function(obj) {
			var coord = {
				y: obj.get("lat"),
				x: obj.get("lng")
			};
			datos.push(coord);
		});
		return datos;*/
		return me.coords;
	},
	getSubmitData: function() {
		var me = this;
		var data = {};
		data[me.name] = JSON.stringify(me.getValue());
		return data;
	},
	mapReadySetValue: function(val) {
		var me = this;
		if (!val || !val.points) {
			console.warn("El formato de los datos recibidos es erroneo");
			return;
		}
		var points = val.points;
		var bounds = new google.maps.LatLngBounds();
		Ext.each(points, function(point) {
			var lat = point.y;
			var lng = point.x;
			var coord = {
				lat: lat,
				lng: lng
			};
			me.coords.push(coord);
		})
		me.showPoly();
		me.map.mask();

	}



});