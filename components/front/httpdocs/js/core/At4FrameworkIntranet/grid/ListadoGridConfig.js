/**
 * @class At4FrameworkIntranet.ListadoGridConfig Contiene la configuración del
 *        grid de formulario At4FrameworkIntranet según el tipo de vista que se
 *        desee mostrar
 * @author agarcia
 * @constructor
 * 
 * @param {At4FrameworkIntranet.ListadoGrid}
 *            grid
 * @param {Object}
 *            config
 */
At4FrameworkIntranet.ListadoGridConfig = function(grid, config) {

	/**
	 * Permitir editar, guardar, etc. Se desactiva para los listados<br/> TODO:
	 * no se usa, el listado no es editable (desactivar?)
	 * 
	 * @type {boolean}
	 */
	this.editMode = true;

	/**
	 * Activar filtros de columna
	 * 
	 * @type {boolean}
	 */
	this.useFilters = true;

	/**
	 * Columna de ordenación por defecto
	 * 
	 * @type {String}
	 */
	this.sortField = '';

	/**
	 * Direccion de la ordenación por defecto
	 * 
	 * @type {String}
	 */
	this.sortDirection = '';

	/**
	 * Activar la agrupacion por columna
	 * 
	 * @type {boolean}
	 */
	this.useGrouping = true;

	/**
	 * Columna de agrupación por defecto
	 * 
	 * @type {String}
	 */
	this.groupField = null;

	/**
	 * Incluir acciones en los grupos
	 * 
	 * @type {boolean}
	 */
	this.groupActions = false;

	Ext.apply(this, config);

	/**
	 * Referencia al grid que usa esta configuración
	 * 
	 * @type {At4FrameworkIntranet.ListadoGrid}
	 */
	this.grid = grid;

}