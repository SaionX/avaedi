/**
 * @class ServerGui
 * Implementación DWR del interfaz GUI: acceso a las características de menús, etc. en el servidor.<br/>
 * Basado en "javascript singleton pattern" (http://www.dhtmlkitchen.com/learn/js/singleton/) 
 * @singleton
 * @author agarcia
 */
serverGui = new function ServerGui() {
   

		/** Devuelve la estructura de elementos del menú como objeto ToolbarElements,
		 *  que contiene 2 propiedades: menus e icons, cada una de las cuales es un
		 *  vector de objetos MenuItem:
		 * 	{
		 * 		text: String
		 * 		menu: Vector<MenuItem>
		 *  }
		 * @param {Function} callbackFunction Función a la cuál llamar
		 * @param {Object} source objeto (scope) en el que ejecutar la función
         * @return {Array} 
		 */
		this.getToolBarElements = function(callbackFunction, source){
			GuiService.getToolBarElements({
				callback: function(dataFromServer){
					callbackFunction.call(source, dataFromServer);
				}
			});

		}

		/** Devuelve la configuración (GridMetaData) para configurar un grid de ListadoGrid
		 *
		 * @param {Object} btn Identificación del formulario a generarl
		 * @param {Function} callbackFunction Función a la cuál llamar
		 * @param {Object} source objeto (scope) en el que ejecutar la función
		 * @param {Object} callbackArgs argumentos para callbackFunction
		 * @return {Object}
		 */
		this.getListMetadata = function(btn, callbackFunction, source, callbackArgs){
			
			//Extraemos de btn, las propiedades que forman el objeto FormItem
			var formItem = {
				id: btn.id
				,text: btn.text
				,href: btn.href
				,form: btn.form
				,mode: btn.mode
				,iconCls: btn.iconCls
				,parameters: btn.parameters
			}
			
			FormDataService.getListMetadata(formItem, {
				callback: function(dataFromServer){
					callbackFunction.call(source, formItem, dataFromServer, callbackArgs);
				}
			});

		}


}