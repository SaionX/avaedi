///INICIO DE APP
Ext.define("At4FrameworkIntranet.At4FrameworkIntranet", {
	extend: "At4FrameworkIntranet.ApplicationBasic",
	/*mixins: {
		base: 'At4FrameworkIntranet.mixin.ApplicationBasic',
	},*/
	toolbarHeight: 45,
	headerImageWidth: 160,
	showUserLogoutButton: true,
	showTemaButton: true,
	showLangButton: true,
	availableLangs: ["ca", "es", "en"],
	constructor: function (options) {
		Ext.apply(this, options);
		dwr.engine.setTextHtmlHandler(this.openLogin.bind(this));
		//Garrom: Variable cache para añadir cosillas

		this.cache = {
			constrains: {}
		};
		this.util = {};

		this.toolbar = Ext.create('Ext.toolbar.Toolbar', {
			cls: 'top-toolbar',
			height: this.toolbarHeight,
			columnWidth: 1,
			flex: 1,
			width: "100%",
			border: false,
			// padding: 0,
			/*plugins: 'responsive',
			responsiveConfig: {
				'width < 1280': {
					region: 'south',
					hidden: true,
					margin: 0,
					layout: {
						type: 'box',
						vertical: true,
						align: "begin"
					}
				},

				'width >= 1280': {
					region: 'center',
					hidden: false,
					//margin: "4px 0 0 0",
					layout: {
						type: 'box',
						vertical: false,
						align: "middle"
					}
				}
			},*/
			items: [' '
				// Añdir aqui elementos al toolbar general
			]
		});

		var header = Ext.get('header');
		var headerPanelItems = [];
		if (header) {
			headerPanelItems.push({
				xtype: 'box',
				el: 'header',
				border: false
			});
		}
		var headerHeight = header ? header.getBottom() + this.toolbarHeight : this.toolbarHeight;
		/**
		 * garrom:
		 * Insertamos un elemento de imagen para que sea el logo de la aplicacion.
		 * Dicha imagen debe ser ~raiz/img/applogo.jpg
		 */
		this.headerHeight = headerHeight;
		var imageLogoWidth = 215;
		this.headerImageLogo = Ext.create("Ext.Img", {
			src: 'img/applogo.png',
			width: imageLogoWidth,
			height: headerHeight,
			imgCls: "logo",
			autoEl: {
				tag: 'a',
				href: '.',
				target: '_self',
				width: imageLogoWidth,
				height: headerHeight,

			},
			cls: "headerImage",
			region: "west",

		});
		/*this.menuButton = Ext.create({
			xtype: "button",
			// text: "| | |",
			region: "east",
			width: 75,
			cls: "responsive-menu",
			iconCls: "glyphicons glyphicons-menu-hamburger",
			scope: this,
			height: headerHeight,
			handler: function (element, event) {
				event.stopPropagation();
				window.setTimeout(function () {
					if (this.headerOpen) {
						this.headerOpen = false;
						this.headerPanel.setHeight(headerHeight);
						this.toolbar.hide();
					} else {
						this.headerOpen = true;
						var height = 300;
						this.toolbar.setHeight(height - headerHeight);
						this.headerPanel.setHeight(height);
						this.toolbar.show();
					}
				}.bind(this), 70);

			},

			plugins: 'responsive',
			responsiveConfig: {
				'width < 1280': {
					hidden: false
				},

				'width >= 1280': {
					hidden: true
				}
			}
		})*/

		//headerPanelItems.push(this.headerImageLogo);
		headerPanelItems.push(this.toolbar);
		//headerPanelItems.push(this.menuButton)

		this.headerPanel = Ext.create('Ext.Panel', {
			border: false,
			layout: 'hbox',
			region: 'north',
			height: headerHeight,
			items: headerPanelItems,
			cls: "header-panel",
			// collapsible: true,
			// hideCollapseTool: false,
			header: false,
			// collapsed: Ext.getBody().getWidth()<1280,
			// collapseMode: "mini",
			/*//plugins: 'responsive',
			responsiveConfig: {
				'width < 1280': {
					region: 'west',
					layout: {
						type: 'box',
						vertical: true,
					},
					height: headerHeight,
					collapsed: true
				},

				'width >= 1280': {
					region: 'north',
					height: headerHeight,
					layout: {
						type: 'box',
						vertical: false,
					},
					hidden: false,
					collapsed: false
				}
			}*/
		})

		this.statusBar = Ext.create('Ext.ux.StatusBar', {
			id: 'At4Framework-status',
			autoClear: 10000,
			defaultText: this.statusBarDefaultTxt
		});

		var mainPanel;

		// Main (Tabbed) Panel
		//TODO: Como el state va un poco chungo por ahora, solo se va a usar cuando modoDesarollo = false;
		var mainTabPanelClass = At4Framework_modoDesarrollo ? "At4FrameworkIntranet.MainTabPanel" : "Ext.tab.Panel";
		this.tabPanel = Ext.create(mainTabPanelClass, {
			region: 'center',
			layoutOnTabChange: true,
			stateful: true,
			stateId: "maintabpanel",
			// evita el bug:
			// http://extjs.com/forum/showthread.php?t=32630&highlight=layout%3A%27column%27
			deferredRender: false,
			autoScroll: true,
			enableTabScroll: true,
			margins: '0 4 4 0',
			activeTab: 0,
			bodyStyle: "overflow: hidden",
			cls: "at4-top-toolbar",
			width: 900,
			application: this,
			bbar: this.statusBar,
			items: [],
			plugins: [
				Ext.create('Ext.ux.TabCloseMenu', {})
			],
			/*
			listeners: {
			show: {
			fn: this.onTestShow,
			scope: this
		}
	}*/


			// Necessari si es vol recargar el tab cada pic que s'activa.
			// Necessari per quan es volen actualitzar les dades dinamicament
			// de dos forms que tenen elements relacionats.
			/*
			 * , listeners:{ beforetabchange :{ fn:function(tabpanel, newtab,
			 * curtab) { if (newtab.form != null){ if (newtab.tabcarregatabans !=
			 * null) { newtab.submitActualizar(); } else {
			 * newtab.tabcarregatabans = true; } } } } }
			 */
		});
		mainPanel = this.tabPanel;

		// aamengual - pie
		var footer = Ext.get('footer');
		if (footer) {
			//garrom: He cambiado esto de Ext.Panel a container para mejorar rendimiento
			var footerPanel = Ext.create('Ext.container.Container', {
				border: false,
				layout: 'fit',
				region: 'south',
				cls: 'alma-header',
				height: 31,
				items: [{
					el: footer
				}]
			});
		}

		// Configure viewport
		this.viewport = Ext.create('Ext.container.Viewport', {
			layout: 'border',
			border: false,
			padding: '48 0 0 0',
			items: [this.headerPanel, mainPanel, footerPanel]
		});

		this.updateToolbar(At4FrameworkIntranet.Bootstraper.menuPrincipal);

		/*******************************************************************
		 * Solo usado en desarrollo, para abrir de inicio un tab
		 * this.openRecordForm ( { form: 'proyecto', }, {oid:'1'}); /
		 ******************************************************************/
		/*
		this.openRecordForm({
		form: 'hotel',
		}, {
		oid: '48'
		});*/
		Ext.GlobalEvents.addListener({
			resize: {
				fn: function (w, h, opts) {
					this.hideTopMenu();
					this.onViewResize(w, h, opts);
				},
				scope: this
			}
		});


	},

	// public methods

	hideTopMenu: function () {
		var w = Ext.getBody().getViewSize().width;
		this.headerOpen = false;
		this.headerPanel.setHeight(this.headerHeight);
		/*if (w >= 1280) {
			this.toolbar.show();
		} else {
			this.toolbar.hide();
		}*/
	},
	onViewResize: function (w, h, opts) {
		var windowCMP = Ext.WindowManager.getActive();
		if (windowCMP) {
			if (windowCMP.xtype == "at4window") {
				if (windowCMP.originalWidth < w) {
					windowCMP.setWidth(windowCMP.originalWidth);
				} else {
					windowCMP.setWidth(w);
				}
				if (windowCMP.originalHeight < h) {
					windowCMP.setHeight(windowCMP.originalHeight);
				} else {
					windowCMP.setHeight(h);
				}
			}
			windowCMP.center();
		}
	},
	/**
	 * Registra el gridMetaData para los botones que no abren listado
	 * (Sustituye a openListGrid: es una version recortada)
	 *
	 * @param {Object}
	 *            btn
	 * @param {Object}
	 *            gridMetaData
	 * @private
	 */
	saveGridListMetaData: function (btn, gridMetaData) {
		// Guardamos la información en caché si no existía
		if (!gridMetaDataCache[btn.form]) {
			gridMetaDataCache[btn.form] = gridMetaData;
		}
	},

	/**
	 * recibe un objeto ToolbarElements
	 *
	 * @param {Object}
	 *            toolbarElements
	 * @private
	 */
	updateToolbar: function (toolbarElements) {

		var menus = toolbarElements.menus;

		var defaults = {
			handler: this.onItemClick,
			scope: this,
			cls: 'at4-menuButton',
			scale: 'small',
			titleAlign: "left",
			/*bodyStyle: "text-align: left",
			plugins: 'responsive',
			responsiveConfig: {
				'width < 1280': {
					width: "100%",
					// height: 32
				},

				'width >= 1280': {
					width: null,
					// height: 25
				}
			}*/
		}


		for (var i = 0; i < menus.length; i++) {
			// es necesario asignar el handler a cada item para que se
			// incluya en los menus de los siguientes niveles
			if (menus[i].menu && menus[i].menu.items) {
				// Es un menú
				setMenuDefaults(menus[i].menu, Ext.apply({}, {
					// minWidth: 200,
					/*responsiveConfig: {
						'width < 1280': {
							width: "100%"
						},

						'width >= 1280': {
							width: "auto",
						}
					}*/
				}, defaults));


				menus[i].menu.cls = "at4-headerMenu";
				this.toolbar.insert(i, Ext.apply({
					text: menus[i].text,
					iconCls: menus[i].iconCls,
					scale: 'small',
					menu: Ext.create("Ext.menu.Menu", menus[i].menu)
				}, defaults))

			} else {
				// Es un botón
				Ext.apply(menus[i], defaults);
				this.toolbar.insert(i, menus[i]);
			}
		}

		this.toolbar.add('->');
		// Añade los menús de selección de tema e idioma
		var userLogoutButton = false;
		if (this.showUserLogoutButton) {
			userLogoutButton = {
				id: 'userLogoutButton',
				cls: 'at4-menuButton',
				scale: 'small',
				iconCls: 'glyphicons glyphicons-user glyph-white',
				text: window.username,
				/*plugins: 'responsive',
				responsiveConfig: {
					'width < 1280': {
						width: "100%",
					},

					'width >= 1280': {
						width: null,
					}
				},*/
				menu: Ext.create("Ext.menu.Menu", {
					cls: "at4-headerMenu",
					items: [{
						id: 'logoutButton',
						iconCls: 'glyphicons glyphicons-log-out',
						//text: 'Salir',
						text: this.salirTxt,
						handler: function () {
							location.href = window.logoutUrl;
						},
						width: "auto",
						/*plugins: 'responsive',
						responsiveConfig: {
							'width < 1280': {
								width: "100%"
							},

							'width >= 1280': {
								width: "auto",
							}
						}*/

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

					}]
				})
			};
			this.toolbar.add(userLogoutButton);
		};

		var temaButton = false;
		if (this.showTemaButton) {
			temaButton = {
				cls: 'at4-menuButton',
				tooltip: "Tema",
				tooltip: this.temaTxt,
				iconCls: "glyphicons glyphicons-picture",
				menu: Ext.create("Ext.menu.Menu", {
					// defaults: defaults,
					items: [{
						id: 'at4ThemeButton',
						text: 'Desktop',
						checked: (this.tema == 'at4' ? true : false),
						group: 'theme',
						handler: null,
						scope: this,
						checkHandler: this.onChangeTheme
					}, {
						id: 'at4TouchThemeButton',
						text: 'Touch',
						checked: (this.tema == 'at4-touch' ? true : false),
						group: 'theme',
						handler: null,
						scope: this,
						checkHandler: this.onChangeTheme
					}, {
						id: 'at4AcireButton',
						text: 'Acire',
						checked: (this.tema == 'at4-touch-acire' ? true : false),
						group: 'theme',
						handler: null,
						scope: this,
						checkHandler: this.onChangeTheme
					}, {
						id: 'crispThemeButton',
						text: 'Tema Crisp',
						checked: (this.tema == 'crisp' ? true : false),
						group: 'theme',
						handler: null,
						scope: this,
						checkHandler: this.onChangeTheme
					}, {
						id: 'crispTouchThemeButton',
						text: 'Tema Crisp Touch',
						checked: (this.tema == 'crisp-touch' ? true : false),
						group: 'theme',
						handler: null,
						scope: this,
						checkHandler: this.onChangeTheme
					}]
				})
			}
			this.toolbar.add(temaButton);
		}

		var langButton = false;
		if (this.showLangButton) {
			langButton = {
				tooltip: (this.idioma == 'en' ? 'English' : this.idioma == 'es' ? 'Castellano' : 'Català'),
				cls: 'at4-menuButton',
				//TODO: Localear
				text: "Idioma",
				iconCls: "glyphicons glyphicons-globe-af",
				/*plugins: 'responsive',
				responsiveConfig: {
					'width < 1280': {
						width: "100%",
						//TODO: Localear
						text: "Idioma",
					},

					'width >= 1280': {
						width: null,
						text: '',
					}
				},*/
				menu: Ext.create("Ext.menu.Menu", {
					cls: "at4-headerMenu",
					//TODO: ordenar según el orden en this.availableLangs
					items: [{
						id: 'langButtonEN',
						text: 'English',
						checked: (this.idioma == 'en' ? true : false),
						group: 'idioma',
						handler: null,
						scope: this,
						hidden: this.availableLangs.indexOf('en') == -1,
						/*plugins: 'responsive',
						responsiveConfig: {
							'width < 1280': {
								width: "100%"
							},

							'width >= 1280': {
								width: "auto",
							}
						},*/
						checkHandler: this.onChangeLang
					}, {
						id: 'langButtonES',
						text: 'Castellano',
						checked: (this.idioma == 'es' ? true : false),
						handler: null,
						group: 'idioma',
						scope: this,
						hidden: this.availableLangs.indexOf('es') == -1,
						/*plugins: 'responsive',
						responsiveConfig: {
							'width < 1280': {
								width: "100%"
							},

							'width >= 1280': {
								width: "auto",
							}
						},*/
						checkHandler: this.onChangeLang
					}, {
						id: 'langButtonCA',
						text: 'Català',
						checked: (this.idioma == 'ca' ? true : false),
						handler: null,
						group: 'idioma',
						scope: this,
						hidden: this.availableLangs.indexOf('ca') == -1,
						/*plugins: 'responsive',
						responsiveConfig: {
							'width < 1280': {
								width: "100%"
							},

							'width >= 1280': {
								width: "auto",
							}
						},*/
						checkHandler: this.onChangeLang
					}]
				})
			}
			this.toolbar.add(langButton);
		};

		if(this.customToolbarButton){
			this.toolbar.add(this.customToolbarButton);
		}

		//this.toolbar.add('->', userLogoutButton, temaButton, langButton);
		this.toolbar.doLayout();
		this.statusBar.clearStatus({
			useDefaults: true
		});

	},

	/**
	 * Manejador de clics en el menú de idioma
	 *
	 * @param {Object}
	 *            btn
	 * @private
	 */
	onChangeLang: function (item, checked) {
		if (checked) {
			var href = './index.html?lang=';
			switch (item.id) {
			case "langButtonCA":
				href += 'ca';
				break;
			case "langButtonES":
				href += 'es';
				break;
			case "langButtonEN":
				href += 'en';
				break;
			default:
				break;
			}
			// 		  if (item.id == 'langButtonCA') {
			// 		href += 'ca';
			// 	} else {
			// 	href += 'es';
			// }
			location.href = href;
		}
	},

	/**
	 * Manejador de clics en el menú de cambio de tema
	 *
	 * @param {Object}
	 *            btn
	 * @private
	 */
	onChangeTheme: function (item, checked) {
		if (checked) {
			var href = './index.html?tema=';
			switch (item.id) {
			case "at4ThemeButton":
				href += 'at4';
				break;
			case "at4TouchThemeButton":
				href += 'at4-touch';
				break;
			case "crispThemeButton":
				href += 'crisp';
				break;
			case "crispTouchThemeButton":
				href += 'crisp-touch';
				break;
			case "at4AcireButton":
				href += 'at4-touch-acire';
				break;
			default:
				break;
			}
			// 		  if (item.id == 'langButtonCA') {
			// 		href += 'ca';
			// 	} else {
			// 	href += 'es';
			// }
			location.href = href;
		}
	},

	/**
	 * Manejador de clics en el menú
	 *
	 * @param {Object}
	 *            btn
	 * @private
	 */
	onItemClick: function (btn, e) {
		e.stopEvent();

		if (btn.menu) {
			// Se trata de un menú
			return;
		}
		this.hideTopMenu();
		this.openMenuFormItem(btn);
	},

	// private
	openMenuFormItem: function (btn) {
		if (btn.link) {
			// Se trata de un enlace externo
			this.updateTab(btn.href, btn.text, btn.href, btn.iconCls);
		} else {
			switch (btn.mode) {
			case 'list':
				// Un formulario listado tradicional
				if (gridMetaDataCache[btn.form]) {
					this.openListGrid(btn, gridMetaDataCache[btn.form]);
				} else {
					serverGui.getListMetadata(btn, this.openListGrid, this);
				}
				break;
			case 'new':
				// Un formulario vacío para crear nuevo
				this.openNewRecordForm(btn);
				break;
			case 'plain':
				// Se trata de un feature
				switch (btn.form) {
					/*
					case 'centro':
					if (gridMetaDataCache[btn.form]) {
					this.doOpenCentroPropioRecordForm(btn,
					gridMetaDataCache[btn.form]);
					} else {
					serverGui.getListMetadata(btn,
					this.doOpenCentroPropioRecordForm, this);
					}
					break;
					*/
				case 'configuracion':
					this.openRecordForm({
						form: 'configuracion',
					}, {
						oid: '1'
					});
					break;
				case 'validar':
					serverDatabaseActions.runAction(
						ValidacionService.obtenerInfraccionParaValidar, [],
						this.openValidar,
						serverDatabaseActions.exceptionHandler,
						this
					);
					break;
				case 'auditar':
					serverDatabaseActions.runAction(
						ValidacionService.obtenerInfraccionParaAuditar, [],
						this.openAuditar,
						serverDatabaseActions.exceptionHandler,
						this
					);
					break;
				case 'obrirManualGeneral':

					this.openPdf(btn, 'docs/manual.pdf');

					break;

				}
				break;
			}
		}

	},

	/**
	 * Abre un formulario para un registro.
	 *
	 * @param {Object}
	 *            formItem
	 * @param {Object}
	 *            data
	 * @param {String}
	 *            tituloTab Titulo de la pestaña.
	 */
	openRecordForm: function (formItem, data, tituloTab, isState) {

		var dataContainer = {
			data: data,
			isState: isState
		}

		if (gridMetaDataCache[formItem.form]) {
			this.doOpenRecordForm(formItem, gridMetaDataCache[formItem.form], dataContainer, tituloTab);
		} else {
			serverGui.getListMetadata(formItem, this.doOpenRecordForm, this, dataContainer);
		}

	},

	/**
	* TODO
	* Obtiene el GridMetaData para el form formItem.
	* Llama al callback en la forma: callbackFunction
	getGridMetaData: function (formItem, callbackFunction, source, args) {

	},
	*/

	// private
	doOpenRecordForm: function (formItem, gridMetaData, dataContainer, tituloTab) {
		var data = dataContainer.data;
		var isState = dataContainer.isState;

		// Guardamos la informacion en cache si no existia
		if (!gridMetaDataCache[formItem.form]) {
			gridMetaDataCache[formItem.form] = gridMetaData;
		}
		var oid = data.oid || data.id || data.clave;
		oid = String(oid).replace(" ", "");
		var form = formItem.form;
		var tabId = form + '-plainRecord-' + oid.replace(/[_|.]/g, '-');

		var tab = this.getTab(tabId);
		if (!tab) {
			var text = formItem.text ? formItem.text : gridMetaData.formItem.text;

			text = tituloTab || Ext.String.format(this.registerTabTitle, text);

			tab = Ext.create("At4FrameworkIntranet." + gridMetaData.formClassName, this, form, gridMetaData, {
				id: tabId + Ext.id(),
				closable: true,
				closeAction: "destroy",
				iconCls: formItem.iconCls,
				isStateLoaded: !!isState,
				title: text
			});

			this.tabPanel.add(tab);
			this.registerTabId(tabId, tab);

			tab.loadData(oid, data);

		}
		this.tabPanel.setActiveTab(tab);

	},

	/**
	 * Abre un formulario vacio
	 *
	 * @param {Object}
	 *            formItem
	 */
	openNewRecordForm: function (formItem, extraCfg, requiredData) {
		var itemInfo = {
			formItem: formItem,
			extraCfg: extraCfg,
			requiredData: requiredData
		}
		if (gridMetaDataCache[formItem.form]) {
			this.doOpenNewRecordForm(formItem, gridMetaDataCache[formItem.form], itemInfo);
		} else {
			serverGui.getListMetadata(formItem, this.doOpenNewRecordForm, this, itemInfo);
		}
	},

	openNewWindowForm: function (formItem, parentList) {
		if (gridMetaDataCache[formItem.form]) {
			this.doOpenNewWindowForm(formItem, gridMetaDataCache[formItem.form], parentList);
		} else {
			serverGui.getListMetadata(formItem, this.doOpenNewWindowForm, this, parentList);
		}

	},

	// private
	doOpenNewWindowForm: function (formItem, gridMetaData, parentList) {
		// Guardamos la información en caché si no existía
		if (!gridMetaDataCache[formItem.form]) {
			gridMetaDataCache[formItem.form] = gridMetaData;
		}
		//var window = new Ext.Window({
		var window = Ext.create("Ext.window", {
			// title: this.editarTxt,
			title: formItem.text,
			closable: true,
			modal: true,
			closeAction: 'hide',
			width: 720,
			height: 670,
			deferredRender: false,
			// border:false,
			plain: true,
			layout: 'fit',
			items: [Ext.create(At4FrameworkIntranet[gridMetaData.formClassName], this, formItem.form, gridMetaData, {
				closable: true
					// title: formItem.text
			})]
		});
		window.parentList = parentList;
		window.show();
	},

	// private
	doOpenNewRecordForm: function (formItem, gridMetaData, itemInfo) {
		var requiredData = itemInfo.requiredData;

		var extraCfg = itemInfo.extraCfg ? itemInfo.extraCfg : {};
		// Guardamos la información en caché si no existía
		if (!gridMetaDataCache[formItem.form]) {
			gridMetaDataCache[formItem.form] = gridMetaData;
		}

		var form = formItem.form;

		var tabId = form + '-newForm';
		var tab = this.getTab(tabId);
		if (!tab) {
			/*
			 * gridMetaData no existe var text =
			 * formItem.text?formItem.text:gridMetaData.formItem.text;
			 */
			// var text = formItem.text;
			var text = formItem.text ? formItem.text : gridMetaData.formItem.text;
			text = Ext.String.format(this.newRegisterTabTitle, text);

			//tab = new(At4FrameworkIntranet[gridMetaData.formClassName])(
			var cfg = Ext.apply({
				closable: true,
				isNewForm: true,
				id: gridMetaData.formClassName + "-newForm" + Ext.id(),
				iconCls: formItem.iconCls,
				title: text
			}, extraCfg);
			tab = Ext.create("At4FrameworkIntranet." + gridMetaData.formClassName, this, form, gridMetaData, cfg);
			if (requiredData) {
				tab.setValues(requiredData);
				console.log("RequiredData values set!");
			}

			this.tabPanel.add(tab);
			this.registerTabId(tabId, tab);

		}
		this.tabPanel.setActiveTab(tab);
	},

	/**
	 * Metodo al que notificar cuando se añade un registro.
	 *
	 * @param {Object}
	 *            tab
	 * @param {Object}
	 *            data
	 */
	onNewRecordDone: function (tab, data) {

		var form = data.formName;
		text = tab.title; // Texto por defecto
		var oid = data.rowid;

		if (gridMetaDataCache[data.formName]) { // tenemos cargado el
			// metadata
			var formItem = gridMetaDataCache[data.formName].formItem;
			text = formItem.text;
		}

		/* Actualizamos título e id del tab */
		tab.setTitle(Ext.String.format(this.registerTabTitle, text));

		this.unRegisterTabId(tab);
		var tabId = form + '-plainRecord-' + oid;
		this.registerTabId(tabId, tab);

		/* Recargamos el list */
		var listTabId = form + '-list';
		var listTab = this.getTab(listTabId);
		if (listTab) {
			// TODO: recargar llamando a un método de ListadoGrid
			listTab.store.reload();
		}

		//garrom: Hack para que cuando se añada un titular, se meta este en el contrato
		if (data.formName == "titular") {
			var contrato = this.getTab("contrato-newForm");
			if (contrato) {
				// contrato.fields.titular.store.load();
				// contrato.fields.titular.select(oid);
				var formvals = tab.getValues();

				var valTitularLabel = At4util.formatTitularLabel(formvals);

				var val = {
					titularId: oid,
					titularLabel: valTitularLabel
				};
				contrato.setValues(val)
			}
		}



	},


	/**
	 * Metodo al que notificar cuando se actualiza un registro.
	 *
	 * @param {Object}
	 *            data
	 */
	onUpdateRecordDone: function (data) {

		var form = data.formName;
		/* Recargamos el list */
		var listTabId = form + '-list';
		var listTab = this.getTab(listTabId);
		if (listTab) {
			listTab.store.reload();
		}

	},

	/**
	 * Método al que notificar cuando se elimina un registro.
	 *
	 * @param {Object}
	 *            tab
	 * @param {Object}
	 *            data
	 */
	onDeleteRecordDone: function (tab, data) {

		var formItem = gridMetaDataCache[data.formName].formItem;

		/* Actualizamos título e id del tab */
		var form = formItem.form;
		var oid = data.rowid;

		var tabId = form + '-plain-' + oid;
		var formTab = this.getTab(tabId);

		// Eliminamos el tab del form
		if (formTab) {
			this.unRegisterTabId(formTab);
			this.tabPanel.remove(formTab);
		}

		/* Recargamos el list */
		var listTabId = formItem.form + '-list';
		var listTab = this.getTab(listTabId);
		if (listTab && tab.id != listTab.id) {
			// Si no nos llaman desde listTab
			// TODO: recargar llamando a un método de ListadoGrid
			listTab.store.reload();
			listTab.show();
		}

	},

	/**
	 * Abre el grid de listado con la configuración adicional customConfig
	 */
	openCustomListGrid: function (id, btn, customConfig) {

		btn.extraId = id;
		if (gridMetaDataCache[btn.form]) {
			this.openListGrid(btn, gridMetaDataCache[btn.form], customConfig);
		} else {
			serverGui.getListMetadata(btn, this.openListGrid, this, customConfig);
		}

	},

	/**
	 * Abre el grid de listado de un formulario At4Framework
	 *
	 * @param {Object}
	 *            btn
	 * @param {Object}
	 *            gridMetaData
	 */
	openListGrid: function (btn, gridMetaData, customConfig) {
		// Guardamos la información en caché si no existía
		if (!gridMetaDataCache[btn.form]) {
			gridMetaDataCache[btn.form] = gridMetaData;
		}
		var tabId = btn.form + '-list';

		if (btn.extraId) {
			tabId += '-' + btn.id;
		}

		var tab = this.getTab(tabId);
		if (!tab) {
			var text = btn.text ? btn.text : gridMetaData.formItem.text;
			// La sintaxis At4FrameworkIntranet['ListadoGrid'] es
			// equivalente a At4FrameworkIntranet.ListadoGrid
			tab = new Ext.create("At4FrameworkIntranet." + gridMetaData.listClassName, this.tabPanel, {
				id: tabId + Ext.id(),
				// el grid debe tener un ID reproducible para que funcione el almacén de estado
				closable: true,
				title: text,
				stateId: tabId,
				closeAction: "destroy",
				stateful: true,
				tipo: 'normal',
				iconCls: btn.iconCls
			}, this, gridMetaData, customConfig);

			this.tabPanel.add(tab);
			this.registerTabId(tabId, tab);
		}
		this.tabPanel.setActiveTab(tab);
		//tab.syncSize();
	},

	openLogin: function (btn, href) {
		var tabId = 'pdf_' + Ext.ux.util.MD5(href);
		console.error("Esto no se deberia estar llamando");
		//tabId, tabTitle, targetUrl, iconCls
		return this.addTab(tabId, btn.text, href, btn.iconCls);
	},

	/**
	 * Abre un pdf
	 *
	 * @param {Object}
	 *            btn
	 */
	openPdf: function (btn, href) {
		var tabId = 'pdf_' + Ext.ux.util.MD5(href);
		//tabId, tabTitle, targetUrl, iconCls
		return this.addTab(tabId, btn.text, href, btn.iconCls);
	},

	/**
	 * Devuelve el tab de id tabId
	 *
	 * @param {String}
	 *            tabId
	 * @return {Object}
	 */
	getTab: function (tabId) {
		if (tabIdRegister[tabId]) {
			return tabIdRegister[tabId];
		} else {
			return null;
		}
	},

	/**
	 * Registra un id para un tab
	 *
	 * @param {String}
	 *            tabId
	 * @param {Object}
	 *            tab
	 */
	registerTabId: function (tabId, tab) {
		//tabIdRegister[tabId] = tab.getItemId();
		tabIdRegister[tabId] = tab;
		tab.registeredTabId = tabId;
	},

	/**
	 * Elimina un tab del registro
	 *
	 * @param {Object}
	 *            tab
	 */
	unRegisterTabId: function (tab) {
		if (tabIdRegister[tab.registeredTabId]) {
			delete tabIdRegister[tab.registeredTabId];
		}
	},

	/**
	* Añade un tab a partir de una url, que se cargará en un iframe
	*
	* @param {String}
	*            tabId
	* @param {String}
	*            tabTitle
	* @param {String}
	*            targetUrl
	* @private

	addTab: function(tabId, tabTitle, targetUrl, iconCls) {
	// Para enlaces externos se usa un Iframe
	var newPan = new Ext.ux.ManagedIframePanel({
	title: tabTitle,
	iconCls: iconCls,
	defaultSrc: targetUrl,
	closable: true,
	loadMask: true
	});
	newPan.application = this;
	this.tabPanel.add(newPan).show();
	this.registerTabId(tabId, newPan);
	},*/

	addTab: function (tabId, tabTitle, targetUrl, iconCls) {
		var tab = this.getTab(tabId);
		if (!tab) {
			var tab = Ext.create('At4FrameworkIntranet.IFrame', {
				id: tabId + Ext.id(),
				src: targetUrl,
				title: tabTitle,
				closable: true,
				iconCls: iconCls,
				width: 350,
				height: 350
			});

			tab.application = this;
			tab = this.tabPanel.add(tab).show();
			this.registerTabId(tabId, tab);

		}
		this.tabPanel.setActiveTab(tab);

	},

	/**
	 * Añade un tab a partir de una url, que se cargará en un iframe
	 *
	 * @param {String}
	 *            tabId
	 * @param {String}
	 *            title
	 * @param {String}
	 *            url
	 */
	updateTab: function (tabId, title, url, iconCls) {
		var tab = this.getTab(tabId);
		if (!tab) {
			tab = this.addTab(tabId, title, url, iconCls);
		}
		this.tabPanel.setActiveTab(tab);
	},

	/**
	 * Abre la página de login. Se llama a este método cuando se detecta que
	 * ha expirado la sesion.
	 *
	 * @private
	 */
	openLogin: function (pageData) {
		var me = this;
		//window.top.location.href = 'index.html';
		if (!this.sessionExpiredAlerted) {
			// Queremos evitar que, si se han mandado varias peticiones, muestre mas de un alert

			// this.sessionExpiredAlerted = true;
			var loginVersion = 1;
			if (loginVersion == 1) {

				var windowCMP = Ext.getCmp('loginWindow');
				var loginUri = this.contextPath + '/index.html?fastRelogUser=' + window.username;

				if (!windowCMP) {
					// var loginUri = this.contextPath + '/login/loginForm.html?usuario=test';
					// var loginUri = this.contextPath + '?usuario=test';
					// var loginUri = window.logoutUrl + '?usuario=test';
					var iframe = Ext.create('At4FrameworkIntranet.IFrame', {
						id: Ext.id(),
						autoregister: false,
						listeners: {
							frameload: {
								fn: function (ev) {
									var iframeWindow = ev.target.contentWindow;
									var path = iframeWindow.location.pathname;
									console.log(path);
									switch (path) {
									case this.contextPath + "/login/loginError.html":
									case this.contextPath + "/login/loginForm.html":
										iframe.show();
										me.loginError();
										break;
									case this.contextPath + "/dwr/call/plaincall/GuiService.saveState.dwr":
									case this.contextPath + "/index.html":
										me.loginSuccess();
										break;
									default:
										iframeWindow.location.replace(loginUri)

										break;
									}
								},
								scope: this,
							},
							frameunload: {
								fn: function (ev) {
									iframe.hide();
								},
								scope: this
							},
							domload: {
								fn: function (ev) {
									console.log(arguments);
								},
								scope: this,
							}

						},
						src: loginUri,
					});
					windowCMP = Ext.create({
						xtype: "at4window",
						title: this.windowExpiredSesiontitle,
						id: 'loginWindow',
						width: 1024,
						height: 768,
						closeAction: "destroy",
						layout: 'fit',
						closable: false,
						draggable: false,
						resizable: false,
						modal: true,
						html: '<div style="display: table; height: 100%; width: 100%;"><div style="display: table-cell; vertical-align: middle;"><div class="loader">Loading...</div></div></div>',
						items: [iframe]
					});
				} else {
					var frame = windowCMP.items.items[0];
					frame.show();
					frame.getWin().location.replace(loginUri);
				}

				Ext.getBody().addCls("sesion-caducada");
				windowCMP.show();
			}
			if (loginVersion == 2) {
				console.log("Method unfinished");
				console.warn("Method unfinished");
				var windowCMP = Ext.getCmp('loginWindow');
				if (!windowCMP) {
					this.loginPanel = Ext.create('Ext.form.Panel', {
						url: this.contextPath + "/login/loginForm.html",
						defaults: {
							labelAlign: "top"
						},
						defaultType: 'textfield',
						items: [{
							inputType: "text",
							disabled: true,
							fieldLabel: 'username',
							value: username
						}, {
							inputType: "hidden",
							name: 'username',
							hidden: true,
							value: username
						}, {
							inputType: "password",
							fieldLabel: 'password',
							name: 'password',
							allowBlank: false
						}],
						reader: {
							type: 'xml',
							record: 'meta',
							rootProperty: 'head'
						},
						errorReader: {
							type: 'xml',
							record: 'meta',
							rootProperty: 'head'
						},
						listeners: {
							beforeaction: {
								fn: function (panel, action) {
									action.oldHandleResponse = action.handleResponse;
									action.handleResponse = function (response) {
										response.responseXML = response.responseText;
										return action.oldHandleResponse(response);
									}
								}
							}
						},
						buttons: [{
							xtype: "button",
							text: 'Submit',
							handler: function () {
								var form = this.loginPanel.getForm();
								if (form.isValid()) {
									form.submit({
										success: function (form, action) {
											me.handleLogin(form, action);
										},
										failure: function (form, action) {
											me.handleLogin(form, action);
										}
									});
								}
							},
							scope: this
						}]
					});
					windowCMP = new Ext.Window({
						title: "Login",
						id: 'loginWindow',
						closeAction: "destroy",
						layout: 'fit',
						closable: false,
						draggable: false,
						resizable: false,
						modal: true,
						items: [this.loginPanel]
					});
				}
				windowCMP.show();
			}
			//Ext.getCmp('loginWindow').center()
			//



			/**
			 * {
			            text     : 'Close',
			            handler  : function(){
			                win.hide();
			            }
			        }
			 */
			/*
			 * Esto no funciona bien, pues requiere de recursos (imagenes)
			 * que no puede obtener al haber perdido el login
			 * Ext.Msg.alert({ title: this.sessionExpiredTitle, msg:
			 * this.sessionExpiredMsg, buttons: Ext.Msg.OK, icon:
			 *
			 * Ext.MessageBox.ERROR, fn: function () { document.location =
			 * this.contextPath + '/login/loginForm.html'; }, scope:this,
			 * });


			//alert(this.sessionExpiredTitle + ': ' + this.sessionExpiredMsg);
			//this.sessionExpiredAlerted = false;

			/*
			 * Si redireccionamos al login, tras la autentificacion nos
			 * lleva al recurso pedido, que suele ser el retorno de un
			 * metodo javascript. Para evitarlo, mejor redireccionamos a la
			 * portada; despues, al no estar logueados, nos llevara al login
			 * document.location = this.contextPath +
			 * '/login/loginForm.html';
			 */


			//document.location = this.contextPath + '/index.html';

		}
	},


	// Per a amagar camps amb els seus labels
	hideField: function (field) {
		field.ownerCt.hide(); // hide parent
		field.hide();
		var el = field.getEl();
		if (el != undefined) {
			el.up('.x-form-item').setDisplayed(false); // hide label
		}
	},
	handleLogin: function (form, action) {
		var parser = new DOMParser();
		var htmlDoc = parser.parseFromString(action.response.responseXML, "text/html");
		var metaTags = Ext.fly(htmlDoc).select("meta").elements;
		var attr = "";
		for (i in metaTags) {
			var metaTag = metaTags[i];
			if (metaTags.hasOwnProperty(i)) {
				var attrC = metaTag.getAttribute("data-url");
				if (attrC) {
					attr = attrC;
				}
			}
		}
		switch (attr) {
		case "index":
			this.loginSuccess();
			break;
		case "loginForm":
		case "loginError":
		default:
			this.loginError();
		}
	},
	loginSuccess: function () {
		console.log("logueado guay");
		Ext.getCmp('loginWindow').hide();
		Ext.getBody().removeCls("sesion-caducada");
		this.reloadTabs();
	},
	loginError: function () {
		console.log("logueado error");
	},

	reloadTabs: function (reconfigure) {
		Ext.Msg.hide();
		var mostrarMsg = false;
		for (var i in this.tabPanel.items.items) {
			var item = this.tabPanel.items.items[i];
			if (item.xtype == "gridpanel") {
				if (reconfigure) {
					item.reconfigure(null, item.gridMetaData.columns)
				}
				item.store.load();
			}else if(item.xtype == "form"){
				mostrarMsg = true;
			}
		}
		if(mostrarMsg){
			Ext.Msg.alert(this.afterRelogFormTitle, this.afterRelogFormMsg);
		}
	},

	showField: function (field) {
		field.ownerCt.show();
		field.show();
		var el = field.getEl();
		if (el != undefined) {
			el.up('.x-form-item').setDisplayed(true); // show label
		}
		field.render();
	},
	cargaValidar: function (data) {
		this.doOpenValidar(data, false);
	},
	openValidar: function (data) {
		this.doOpenValidar(data, true);
	},
	doOpenValidar: function (data, obtenerSiguiente) {
		if (!this.validarWindow) {
			this.validarWindow = Ext.create("At4FrameworkIntranet.ValidarForm", {

			});
		}
		if (data) {
			this.validarWindow.obtenerSiguiente = obtenerSiguiente;
			this.validarWindow.loadData(data);
			this.validarWindow.show();
		} else {
			Ext.Msg.alert("Finalizado", "No quedan infracciones por validar");
		}
	},
	/**
	* @author: garrom@at4.net
	*
	* Recarga (cierra, destruye y vuelve a abrir) una pestaña con un
	* grid abierto automaticamente
	*/
	reloadListGrid: function(grid){
		var cfg = {
			form: grid.formPanel.formName,
			iconCls: grid.iconCls,
			text: grid.title,
		};
		var customConfig = grid.customConfig;
		var gridMetaData = grid.gridMetaData;
		grid.close();
		this.openListGrid(cfg, gridMetaData, customConfig);
	}

});

///FIN DE APP
