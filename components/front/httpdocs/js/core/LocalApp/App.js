/**
 * AT4APPLICATION
 *
 * @Config: "headerImageWidth": Tamaño (ancho) que tendra la imagen de logo
 * @Default: 160
 * @Config: "toolbarHeight": Tamaño (alto) que tendra el toolbar de arriba (incluyendo imagen)
 * @Default: 45
 * @Config: "showUserLogoutButton": En true, se mostrara el icono con el nombre de usuario y desplegable para cerrar sesion
 * @Default: true
 * @Config: "showTemaButton": En true, se mostrara el icono con el tema activo y desplegable para cambiarlo
 * @Default: true
 * @Config: "showLangButton": En true, se mostrara el icono con el idioma actual y desplegable para cambiarlo
 * @Default: true
 *
 * @TODO:
 * @Config: "responsiveMenu": En true, el menu entrara en modo responsive a partir de width < 1280. Puede afectar al rendimiento.
 * @Default: true
 *
 */


Ext.define("At4FrameworkIntranet.Application", {
	extend: "At4FrameworkIntranet.At4FrameworkIntranet",
	headerImageWidth: 260,
	toolbarHeight: 40,
	showUserLogoutButton: false,
	showTemaButton: false,
	showLangButton: false,
	responsiveMenu: false,
	availableLangs: ["ca", "es"],

	constructor: function () {
		this.customToolbarButton = {
			tooltip: (this.idioma == 'en' ? 'English' : this.idioma == 'es' ? 'Castellano' : 'Català'),
			cls: 'at4-menuButton',
			//TODO: Localear
			text: "Inicio",
			iconCls: "glyphicons glyphicons-modal-window",
			menu: Ext.create("Ext.menu.Menu", {
				cls: "at4-headerMenu",
				items: [{
						text: "Idioma",
						iconCls: "glyphicons glyphicons-globe-af",
						menu: [{
							id: 'langButtonEN',
							text: 'English',
							checked: (this.idioma == 'en' ? true : false),
							group: 'idioma',
							handler: null,
							scope: this,
							hidden: this.availableLangs.indexOf('en') == -1,
							checkHandler: this.onChangeLang
						}, {
							id: 'langButtonES',
							text: 'Castellano',
							checked: (this.idioma == 'es' ? true : false),
							handler: null,
							group: 'idioma',
							scope: this,
							hidden: this.availableLangs.indexOf('es') == -1,
							checkHandler: this.onChangeLang
						}, {
							id: 'langButtonCA',
							text: 'Català',
							checked: (this.idioma == 'ca' ? true : false),
							handler: null,
							group: 'idioma',
							scope: this,
							hidden: this.availableLangs.indexOf('ca') == -1,
							checkHandler: this.onChangeLang
						}]
					}, {
						iconCls: 'glyphicons glyphicons-server-ban',
						text: this.olvidarEstadosTexto, //Traduccion en ApplicationBasic de At4Framework-lang.jsp
						id: 'stateResetButton',
						scope: this,

						/*plugins: 'responsive',
						responsiveConfig: {
							'width < 1280': {
								width: "100%"
							},

							'width >= 1280': {
								width: "auto",
							}
						},*/
						handler: function () {
							Ext.Msg.show({
								title: this.borrarestadAplicacion,
								message: this.mensajeReset,
								buttons: Ext.Msg.YESNO,
								icon: Ext.Msg.QUESTION,
								scope: this,
								fn: function (btn) {
									if (btn === 'yes') {
										Ext.MessageBox.wait("Recargando", "Espere..");
										var stateProvider = Ext.state.Manager.getProvider();
										for (var item in stateProvider.state) {
											Ext.state.Manager.clear(item);
										}

										//recargamos el app
										Ext.state.Manager.getProvider().on("savesuccess", function () {
											window.location.reload();
										}, this);

										//Recargamos los grids?
										//this.reloadTabs(true)
									}
								}
							});
						},

					}
				]
			})
		}
		this.callParent(arguments);
	},

	openMenuFormItem: function (btn) {
		if (!btn.link) {
			if (btn.mode === "plain") {
				if (btn.form == "openImportForm") {
					var ventana = Ext.create("At4FrameworkIntranet.ImportIeeWindow");
					ventana.show();
					return;
				}
				if (btn.form == "openImportSubForm") {
					var ventana = Ext.create("At4FrameworkIntranet.SubsanacioWindow");
					ventana.show();
					return;
				}
				if (btn.form == "openImportIteForm") {
					var ventana = Ext.create("At4FrameworkIntranet.ImportIteWindow");
					ventana.show();
					return;
				}
			}
		}
		this.callParent(arguments);
	}
})
