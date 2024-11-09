Ext.define("At4FrameworkIntranet.PointGMapField", {
	extend: "At4FrameworkIntranet.BaseGMapField",
	xtype: "At4PointGMapField",

	showEditButton: false,
	showHelpButton: false,
	isEditing: true,

	marker: null,

	addMarker: function(myLatLng) {
		var me = this;
		if (me.marker) {
			me.marker.setMap(null);
		}
		me.marker = new google.maps.Marker({
			position: myLatLng,
			title: '#Localizacion',
			icon: me.markerIcon,
			map: me.gmaps
		});
	},


	getValue: function() {
		var me = this;
		if (!me.marker) {
			return null;
		}
		var position = me.marker.getPosition();
		var data = {
			y: position.lat(),
			x: position.lng()
		};
		return JSON.stringify(data);
	},
	getSubmitData: function() {
		var me = this;
		var data = {};
		data[me.name] = me.getValue();
		return data;
	},
});