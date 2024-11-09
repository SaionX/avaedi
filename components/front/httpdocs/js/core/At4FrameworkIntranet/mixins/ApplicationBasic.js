Ext.define("At4FrameworkIntranet.ApplicationBasic", {
    extend: 'Ext.Mixin',

	// public properties, e.g. strings to translate

	/* * Cadenas de locale */

	/**
	 * Texto por defecto en la barra de estado
	 *
	 * @type {String}
	 */
	statusBarDefaultTxt: 'Listo',

	/**
	 * Mensaje loading mientras se carga el menu
	 *
	 * @type {String}
	 */
	cargandoMenuTxt: 'Cargando menú...',

	/**
	 * Titulo del tab de registro
	 *
	 * @type {String}
	 */
	registerTabTitle: '{0}: registro',

	/**
	 * Titulo del tab de nuevo registro
	 *
	 * @type {String}
	 */
	newRegisterTabTitle: '{0}: nuevo',

	/**
	 * Titulo del tab de registro de apertura directa
	 *
	 * @type {String}
	 */
	registerTabTitleAperturaDirecta: '{0}: ',

	/**
	 * Titulo del tab inicial
	 *
	 * @type {String}
	 */
	startTabTitle: 'Inicio',

	/**
	 * Titulo del mensaje de sesión expirada
	 *
	 * @type {String}
	 */
	sessionExpiredTitle: 'Sesión expirada',

	/**
	 * Texto del mensaje de sesión expirada
	 *
	 * @type {String}
	 */
	sessionExpiredMsg: 'Su sesión ha expirado, por favor, autentifíquese de nuevo.\nPara evitar esto en el futuro, marque la casilla "Recordar la contraseña"',

	/**
	 * Texto de la caja de insertar codigo de barras
	 *
	 * @type {String}
	 */
	introducir: 'Introducir:',

	/**
	 * Texto de la cabecera de mensaje de error
	 *
	 * @type {String}
	 */
	error: 'Error',

	/**
	 * Idioma actual
	 *
	 * @type {String}
	 */
	idioma: 'es',

	/**
	 * Tema actual
	 *
	 * @type {String}
	 */
	tema: At4Framework_activeTheme ? At4Framework_activeTheme : "at4",

	/**
	 * Contexto actual
	 *
	 * @type {String} TODO: generalizar
	 */
	contextPath: '/acireback',

	/**
	 * Panel con la barra de menús
	 *
	 * @type Ext.Toolbar
	 */
	toolbar: null,

	/**
	 * Panel de pestañas
	 *
	 * @type Ext.TabPanel
	 */
	tabPanel: null,

	/**
	 * barra de estado
	 *
	 * @type Ext.StatusBar
	 */
	statusBar: null,

	menuSearchPlaceholder: "Abrir...",

    //TODO: Localear
    afterRelogFormMsg: "Su sesión caducó al realizar su última acción y ésta fue rechazada, por favor vuelva a realizar dicha acción.",
    afterRelogFormTitle: "Advertencia!",
});
