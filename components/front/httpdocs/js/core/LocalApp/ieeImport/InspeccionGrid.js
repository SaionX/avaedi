Ext.define("At4FrameworkIntranet.InspeccionGrid", {
	extend: "At4FrameworkIntranet.ListadoGrid",
	constructor: function () {

		var ruta = './export/inspeccionExportar';

		var formats = [{
			text: "excel",
			iconCls: 'icon-export-excel',
			scope: this,
			handler: function () {
				this.exportFile('xls', ruta);
			}
		}, {
			text: "csv",
			iconCls: 'icon-export-csv',
			scope: this,
			handler: function () {
				this.exportFile('csv', ruta);
			}
		}, {
			text: "pdf",
			iconCls: 'icon-export-pdf',
			scope: this,
			handler: function () {
				this.exportFile('pdf', ruta);
			}
		}, {
			text: "docx",
			iconCls: 'icon-export-docx',
			scope: this,
			handler: function () {
				this.exportFile('docx', ruta);
			}
		}];

		this.extraSubMenuHerramientas = {
			text: "Exportacion combinada",
			iconCls: "glyphicons glyphicons-package",
			menu: {
				items: formats
			}
		};
		this.callParent(arguments);
	}
})
