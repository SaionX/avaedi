At4util = {};
At4util.formatConstrainsLegacy = function(data) {
	var xrec = data.XRecommended ? data.XRecommended : null;
	var yrec = data.YRecommended ? data.YRecommended : null;
	var xrec_pro = data.XRecommendedMandatory ? data.XRecommendedMandatory : null;
	var yrec_pro = data.YRecommendedMandatory ? data.YRecommendedMandatory : null;

	var xmax = data.XMax ? data.XMax : null;
	var ymax = data.YMax ? data.YMax : null;
	var xmax_pro = data.XMaxMandatory ? data.XMaxMandatory : null;
	var ymax_pro = data.YMaxMandatory ? data.YMaxMandatory : null;

	var xmin = data.XMin ? data.XMin : null;
	var ymin = data.YMin ? data.YMin : null;
	var xmin_pro = data.XMinMandatory ? data.XMinMandatory : null;
	var ymin_pro = data.YMinMandatory ? data.YMinMandatory : null;

	var donemax = false;
	var donemin = false;
	var html = "";
	if (yrec || xrec || xrec_pro || yrec_pro || xmax || ymax || ymax_pro || xmax_pro || ymin || xmin || ymin_pro || xmin_pro) {
		if (xrec_pro && xrec && yrec_pro && yrec) {
			html = "Tamaño <b> obligatorio </b>: " + xrec + "x" + yrec + " pixels<br>";
		} else {
			if (xrec && xrec_pro) {
				html += "Ancho <b>obligatorio</b>: " + xrec + "pixels<br>";
			}
			if (yrec && yrec_pro) {
				html += "Alto <b>obligatorio</b>: " + yrec + "pixels<br>";
			}
			if (xrec && yrec) {
				html += "Tamaño <b>recomendado</b>: " + xrec + "x" + yrec + " pixeles<br>";
			}
			if (xmax_pro && xmax && ymax_pro && ymax) {
				html += "Tamaño <b>maximo</b>: " + xmax + "x" + ymax + " pixeles<br>";
				donemax = true;
			}
			if (xmin_pro && xmin && ymin_pro && ymin) {
				html += "Tamaño <b>minimo</b>: " + xmin + "x" + ymin + " pixeles<br>";
				donemin = true;
			}
			if (!xmax_pro && xmax && !ymax_pro && ymax) {
				html += "Tamaño <b>maximo recomendado</b>: " + xmax + "x" + ymax + " pixeles<br>";
				donemax = true;
			}
			if (!xmin_pro && xmin && !ymin_pro && ymin) {
				html += "Tamaño <b>minimo recomendado</b>: " + xmin + "x" + ymin + " pixeles<br>";
				donemin = true;
			}
			if (!donemax) {
				if (xmax && xmax_pro) {
					html += "Ancho <b>maximo obligatorio</b>: " + xmax + "pixeles <br>";
				} else if (xmax) {
					html += "Ancho <b>maximo recomendado</b>: " + xmax + "pixeles <br>";

				}
			}
			if (ymax && ymax_pro) {
				html += "Alto <b>maximo obligatorio</b>: " + ymax + "pixeles <br>";
			} else if (ymax) {
				html += "Alto <b>maximo recomendado</b>: " + ymax + "pixeles <br>";

			}
			if (!donemin) {
				if (xmin && xmin_pro) {
					html += "Ancho <b>minimo obligatorio</b>: " + xmin + "pixeles <br>";
				} else if (ymin) {
					html += "Ancho <b>minimo recomendado</b>: " + xmin + "pixeles <br>";
				}
			}
			if (ymin && ymin_pro) {
				html += "Alto <b>minimo obligatorio</b>: " + ymin + "pixeles <br>";
			} else if (ymin) {
				html += "Alto <b>minimo recomendado</b>: " + ymin + "pixeles <br>";
			}

		}
	} else {
		html = "No hay restricciones para este archivo";
	}
	return html;
};

At4util.formatConstrainsLocale = function(data) {
	var xrec = data.XRecommended ? data.XRecommended : null;
	var yrec = data.YRecommended ? data.YRecommended : null;
	var xrec_pro = data.XRecommendedMandatory ? data.XRecommendedMandatory : null;
	var yrec_pro = data.YRecommendedMandatory ? data.YRecommendedMandatory : null;

	var xmax = data.XMax ? data.XMax : null;
	var ymax = data.YMax ? data.YMax : null;
	var xmax_pro = data.XMaxMandatory ? data.XMaxMandatory : null;
	var ymax_pro = data.YMaxMandatory ? data.YMaxMandatory : null;

	var xmin = data.XMin ? data.XMin : null;
	var ymin = data.YMin ? data.YMin : null;
	var xmin_pro = data.XMinMandatory ? data.XMinMandatory : null;
	var ymin_pro = data.YMinMandatory ? data.YMinMandatory : null;

	var donemax = false;
	var donemin = false;
	var html = "";
	var loc = At4util.constrainsLang;
	if (yrec || xrec || xrec_pro || yrec_pro || xmax || ymax || ymax_pro || xmax_pro || ymin || xmin || ymin_pro || xmin_pro) {
		if (xrec_pro && xrec && yrec_pro && yrec) {
			html = loc.tObligado + Ext.String.format(loc.dos, xrec, yrec) + loc.br;
		} else {
			if (xrec && xrec_pro) {
				html += loc.wObligado + Ext.String.format(loc.uno, xrec) + loc.br;
				//html += "Ancho <b>obligatorio</b>: " + xrec + "pixels<br>";
			}
			if (yrec && yrec_pro) {
				html += loc.hObligado + Ext.String.format(loc.uno, yrec) + loc.br;
				//html += "Alto <b>obligatorio</b>: " + yrec + "pixels<br>";
			}
			if (xrec && yrec) {
				html += loc.tRecomendado + Ext.String.format(loc.dos, xrec, yrec) + loc.br;
				//html += "Tamaño <b>recomendado</b>: " + xrec + "x" + yrec + " pixeles<br>";
			}
			if (xmax_pro && xmax && ymax_pro && ymax) {
				html += loc.tMax + Ext.String.format(loc.dos, xmax, ymax) + loc.br;
				//html += "Tamaño <b>maximo</b>: " + xmax + "x" + ymax + " pixeles<br>";
				donemax = true;
			}
			if (xmin_pro && xmin && ymin_pro && ymin) {
				html += loc.tMin + Ext.String.format(loc.dos, xmin, ymin) + loc.br;
				//html += "Tamaño <b>minimo</b>: " + xmin + "x" + ymin + " pixeles<br>";
				donemin = true;
			}
			if (!xmax_pro && xmax && !ymax_pro && ymax) {
				html += loc.tMaxRecomendado + Ext.String.format(loc.dos, xmax, ymax) + loc.br;
				//html += "Tamaño <b>maximo recomendado</b>: " + xmax + "x" + ymax + " pixeles<br>";
				donemax = true;
			}
			if (!xmin_pro && xmin && !ymin_pro && ymin) {
				html += loc.tMinRecomendado + Ext.String.format(loc.dos, xmin, ymin) + loc.br;
				//html += "Tamaño <b>minimo recomendado</b>: " + xmin + "x" + ymin + " pixeles<br>";
				donemin = true;
			}
			if (!donemax) {
				if (xmax && xmax_pro) {
					html += loc.wMaxObligado + Ext.String.format(loc.uno, xmax) + loc.br;
					//html += "Ancho <b>maximo obligatorio</b>: " + xmax + "pixeles <br>";
				} else if (xmax) {
					html += loc.wMaxRecomendado + Ext.String.format(loc.uno, xmax) + loc.br;
					//html += "Ancho <b>maximo recomendado</b>: " + xmax + "pixeles <br>";
				}
			}
			if (ymax && ymax_pro) {
				html += loc.hMaxObligado + Ext.String.format(loc.uno, ymax) + loc.br;
				//html += "Alto <b>maximo obligatorio</b>: " + ymax + "pixeles <br>";
			} else if (ymax) {
				html += loc.hMaxRecomendado + Ext.String.format(loc.uno, ymax) + loc.br;
				//html += "Alto <b>maximo recomendado</b>: " + ymax + "pixeles <br>";
			}
			if (!donemin) {
				if (xmin && xmin_pro) {
					html += loc.wMinObligado + Ext.String.format(loc.uno, xmin) + loc.br;
					//html += "Ancho <b>minimo obligatorio</b>: " + xmin + "pixeles <br>";
				} else if (ymin) {
					html += loc.wMinRecomendado + Ext.String.format(loc.uno, xmin) + loc.br;
					//html += "Ancho <b>minimo recomendado</b>: " + xmin + "pixeles <br>";
				}
			}
			if (ymin && ymin_pro) {
				html += loc.hMinObligado + Ext.String.format(loc.uno, ymin) + loc.br;
				//html += "Alto <b>minimo obligatorio</b>: " + ymin + "pixeles <br>";
			} else if (ymin) {
				html += loc.hMinRecomendado + Ext.String.format(loc.uno, ymin) + loc.br;
				//html += "Alto <b>minimo recomendado</b>: " + ymin + "pixeles <br>";
			}
		}
	} else {
		html = loc.noHay;
		//html = "No hay restricciones para este archivo";
	}
	return html;
};

At4util.formatConstrains = function(data) {
	var usarLocale = true;
	if (usarLocale) {
		return At4util.formatConstrainsLocale(data);
	}
	return At4util.formatConstrainsLegacy(data);
};

At4util.formatFileConstrainsString = function(data) {
	var loc = At4util.constrainsLang;
	var br = loc.br;
	var html = "";
	if (data.maxKb > 0) {
		html += loc.tMax + " " + data.maxKb + loc.kb + br;
	}
	//html += "Tamaño <b>maximo</b>: " + data.maxKb + "Kb." + br;
	html += br + loc.formatosAdmitidos + br;
	//html += br + "Formatos admitidos:" + br;
	var contador = 0;
	for (i in data.mimeTypes) {
		if (contador != 0) {
			html += ", ";
		}
		contador++;
		html += i;
	};
	if (contador == 0) {
		html += loc.todosFormatos;
		//html += "Todos los formatos estan admitidos.";
	}
	return html;
};

At4util.formatFileConstrainsTable = function(data) {
	var loc = At4util.constrainsLang;
	var br = loc.br;
	var html = "";
	if (data.maxKb > 0) {
		html += loc.tMax + " " + data.maxKb + loc.kb + br;
	}
	//html += "Tamaño <b>maximo</b>: " + data.maxKb + "Kb." + br;
	html += br + loc.formatosAdmitidos + br;
	//html += br + "Formatos admitidos:" + br;
	var length = Object.keys(data.mimeTypes).length;
	if (length > 0) {
		html += loc.table.start;
		//html += "<table><thead><tr><th>Formato</th><th>Mime</th></tr></thead><tbody>";
		for (i in data.mimeTypes) {
			html += Ext.String.format(loc.table.row, i, data.mimeTypes[i]);
			//html += "<tr><td>" + i + "</td><td>" + data.mimeTypes[i] + "</td></tr>";
		};
		html += loc.table.end;
		//html += "</tbody></table>";
	}
	if (length == 0) {
		html += loc.todosFormatos;
		//html += "Todos los formatos estan admitidos.";
	}
	return html;
};

At4util.formatFileConstrains = function(data) {
	var table = false;
	if (table) {
		return At4util.formatFileConstrainsTable(data);
	}
	return At4util.formatFileConstrainsString(data);
};


At4util.icons = {
	//Old: 'icon-plus',
	plus: "glyphicons glyphicons-plus-sign",
	//Old: 'icon-update'
	update: "glyphicons glyphicons-restart",
	//Old: 'icon-minus'
	remove: 'glyphicons glyphicons-bin',
	//Old: 'icon-open'
	editar: 'glyphicons glyphicons-edit',
	//Old: 'icon-add'
	add: 'glyphicons glyphicons-plus-sign',
	//Old: 'icon-export'
	exportar: 'glyphicons glyphicons-file-export',
	//Old: 'icon-close'
	close: 'glyphicons glyphicons-remove',
	//glyphicons glyphicons-floppy-disk
	order: 'glyphicons glyphicons-disk-saved',
	herramientas: 'glyphicons glyphicons-settings',
	avanzado: 'glyphicons glyphicons-more-windows',
	configure: "glyphicons glyphicons-cogwheel",

	save: "glyphicons glyphicons-floppy-disk",
	restart: "glyphicons glyphicons-restart",

	apply: "glyphicons glyphicons-download-alt",

	auditarForm: "glyphicons glyphicons-cardio",
	validarForm: "glyphicons glyphicons-eye-open",
	validar: "glyphicons glyphicons-ok-circle",
	rechazar: "glyphicons glyphicons-remove-circle",
	posponer: "glyphicons glyphicons-roundabout",
};

At4util.formatTitularLabel = function(formvals){
	var valNombre = formvals.nombre;
	var valApellidos = formvals.apellidos;
	var valApellidosRep = formvals.apellidosRepresentante;
	var valTitularLabel = "";
	if(valNombre!= null){
		valTitularLabel += valNombre + " - ";
	}
	valTitularLabel += valApellidos;
	if(valApellidosRep != null){
		valTitularLabel += " - " + valApellidosRep;
	}
	return valTitularLabel;
}


//Objeto que ayudara a generar los tabIndex de los formularios
At4util.tabIndexHelper = function(firstTabItem, tabsPerItem) {
	//constructor
	this.tabItem = firstTabItem ? firstTabItem : 1;
	//Por donde empezara el tabItem
	this.tabsPerItem = tabsPerItem ? tabsPerItem : 100;
	//Cantidad de "tabs" que avanzara por cada item.

};

At4util.tabIndexHelper.prototype.getNext = function() {
	this.tabItem = this.tabItem + this.tabsPerItem;
	return this.tabItem;
};
