<%@page pageEncoding="UTF-8" contentType="application/javascript; charset=UTF-8"%>

<%@ include file="/WEB-INF/jsp/include.jsp" %>
/**
 * Localización para extensiones de terceros usadas en At4Framework
 * @author agarcia
 */

if(Ext.ux.grid.PageSize) {
  	Ext.override(Ext.ux.grid.PageSize, {
    	beforeText          : '<spring:message code="Ext.ux.grid.PageSize.beforeText" text="Elementos por página" javaScriptEscape="true"/>',
    	afterText          : '<spring:message code="Ext.ux.grid.PageSize.afterText" text="Elementos por página" javaScriptEscape="true"/>'
  	});
}


if(Ext.grid.filters.Filters) {
    Ext.apply(Ext.grid.filters.Filters.prototype, {
         menuFilterText:'<spring:message code="Ext.ux.grid.GridFilters.menuFilterText" text="Filtros" javaScriptEscape="true"/>'
    });
}

/**
if(Ext.ux.tree.ParentLoader) {    
    Ext.apply(Ext.ux.tree.ParentLoader.prototype, {
         errorTxt:'<spring:message code="Ext.ux.tree.ParentLoader.errorTxt" javaScriptEscape="true"/>'
    });
}
*/


if(Ext.ux.TabCloseMenu) {
    Ext.override(Ext.ux.TabCloseMenu, {
    	closeTabText: '<spring:message code="Ext.ux.TabCloseMenu.closeTabText" text="Cierra pestaña" javaScriptEscape="true"/>',
    	closeOthersTabsText: '<spring:message code="Ext.ux.TabCloseMenu.closeOthersTabsText" text="Cierra otras pestañas" javaScriptEscape="true"/>',
    	closeAllTabsText: '<spring:message code="Ext.ux.TabCloseMenu.closeAllTabsText" text="Cierra todas pestañas" javaScriptEscape="true"/>'
    })
}





