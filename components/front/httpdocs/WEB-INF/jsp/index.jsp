<%@page pageEncoding="UTF-8"%>
<%@page import="es.caib.avaedi.common.realm.Constants" %>
<%@page import="java.util.Properties" %>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="<c:out value='${rc.locale.language}'/>" >
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta data-url="index">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" >
			<%--
			MUY IMPORTANTE:
			Si se añaden archivos js estáticos aquí deben añadirse también en el
			build.xml del front para que se concatenen y minifiquen para producción
			Por "estáticos" queremos decir los que no se generan por jsp
		--%>
		<!--[if IE]>
		<link rel="stylesheet" type="text/css" href="css/ieFix.css"/>
		<![endif]-->


		<%

		Properties props =(Properties)request.getAttribute("propertyConfigurer");

		int extjsVersion = 5;

		String tema = request.getParameter("tema");


		boolean modoDesarrollo = "true".equals(props.getProperty("front.modoDesarrollo"));

		boolean enableGmaps = "true".equals(props.getProperty("front.enableGmaps"));
		
		boolean enableCKE = "true".equals(props.getProperty("front.enableCKE"));


		if(tema == null){
			tema = props.getProperty("front.themeName");
		}
		if(enableGmaps){
		%>
			<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?v=3&sensor=false"></script>
		<%} 
		if(enableCKE){
		%>
			<!-- CKEditor  -->
			<script type="text/javascript" src="ext<%=extjsVersion%>/uxAt4/ckeditor/ckeditor/ckeditor.js"></script>
		<%}%>
		
		<script type="text/javascript">
		var At4Framework_modoDesarrollo = <%=modoDesarrollo %>;
		var At4Framework_activeTheme = "<%=tema %>";
		var pathToDwrServlet = "<%= request.getContextPath() %>/dwr";
		var logoutUrl = '<%= request.getContextPath() %>/logout.jsp';
		var username = '${request.userPrincipal.name}';
		var GwcAccess = {
				municipio: <%= request.isUserInRole(Constants.MUNICIPI) %>,
		}

		</script>
		<!-- Clases DWR -->
		<script type='text/javascript' src='dwr/util.js'></script>
		<script type='text/javascript' src='dwr/engine.js'></script>
		<script type='text/javascript' src='dwr/interface/GuiService.js'></script>
		<script type='text/javascript' src='dwr/interface/FormDataService.js'></script>
		<%

		String themeurl = props.getProperty("front.themeUrl");

		String themejsurl = "js/tema/"+ tema+".js";
		String themebaseurl = themeurl.replace("{0}", tema) + tema+"-all.css";
		String themespecurl = themeurl.replace("{0}", tema)+ "/tema.css";

		if (!modoDesarrollo) {

			//Modo en producción
			%><script type="text/javascript" src="ext<%=extjsVersion%>/ext-all.js"></script>
			<script type="text/javascript" src="gen-js-front/ext-extensions-static-min.js"></script>
			<script type="text/javascript" src="gen-js-front/At4Framework-static-min.js"></script>
			<script type="text/javascript" src="gen-js-front/avaedi-app-static-min.js"></script>
			<script type="text/javascript" src="gen-js-front/avaedi-forms-static-min.js"></script>


			<%
		} else {
			//Modo en desarrollo
			%>

			<script type="text/javascript" src="ext<%=extjsVersion%>/ext-all-debug.js"></script>

			<!--  Fix para un bug en el number filter de EXTJS -->
			<script type="text/javascript" src="js/core/At4FrameworkIntranet/util/numberFilterFix.js"></script>

			<!--  extensiones 5.x -->
        	<script type="text/javascript" src="ext<%=extjsVersion%>/ux/GMapPanel.js"></script>
			<script type="text/javascript" src="ext<%=extjsVersion%>/ux/statusbar/StatusBar.js"></script>
			<script type="text/javascript" src="ext<%=extjsVersion%>/ux/MultiSelect.js"></script>
			<script type="text/javascript" src="ext<%=extjsVersion%>/uxAt4/filter/MultiListFilter.js"></script>
			<script type="text/javascript" src="ext<%=extjsVersion%>/uxAt4/gmapsfield/BaseGMapField.js"></script>
			<script type="text/javascript" src="ext<%=extjsVersion%>/uxAt4/gmapsfield/PointGMapField.js"></script>
			<script type="text/javascript" src="ext<%=extjsVersion%>/uxAt4/gmapsfield/PolyGMapField.js"></script>
			<script type="text/javascript" src="ext<%=extjsVersion%>/uxAt4/gmapsfield/ZonaPointGMapField.js"></script>
			<script type="text/javascript" src="ext<%=extjsVersion%>/uxAt4/triStateCB/triStateCheckBox.js"></script>
			<script type="text/javascript" src="ext<%=extjsVersion%>/var/RowActions.js"></script>

			<script type="text/javascript" src="js/core/At4FrameworkIntranet/app/MainTabPanel.js"></script>

			<script type="text/javascript" src="js/core/At4FrameworkIntranet/field/NumericField.js"></script>
			<script type="text/javascript" src="ext<%=extjsVersion%>/ux/ItemSelector.js"></script>
			<script type="text/javascript" src="ext<%=extjsVersion%>/var/HttpProvider.js"></script>
			<script type="text/javascript" src="ext<%=extjsVersion%>/var/util.js"></script>

			<script type="text/javascript" src="ext<%=extjsVersion%>/var/XCheckbox.js"></script>
			<script type="text/javascript" src="ext<%=extjsVersion%>/var/VCheckbox.js"></script>

		    <!-- Color Picker -->
		    <script type="text/javascript" src="ext<%=extjsVersion%>/ux/colorpick/ColorUtils.js"></script>
		    <script type="text/javascript" src="ext<%=extjsVersion%>/ux/colorpick/Selection.js"></script>
		    <script type="text/javascript" src="ext<%=extjsVersion%>/ux/colorpick/ColorMapController.js"></script>
		    <script type="text/javascript" src="ext<%=extjsVersion%>/ux/colorpick/ColorMap.js"></script>
		    <script type="text/javascript" src="ext<%=extjsVersion%>/ux/colorpick/SelectorModel.js"></script>
		    <script type="text/javascript" src="ext<%=extjsVersion%>/ux/colorpick/SelectorController.js"></script>
		    <script type="text/javascript" src="ext<%=extjsVersion%>/ux/colorpick/ColorPreview.js"></script>
		    <script type="text/javascript" src="ext<%=extjsVersion%>/ux/colorpick/SliderController.js"></script>
		    <script type="text/javascript" src="ext<%=extjsVersion%>/ux/colorpick/Slider.js"></script>
		    <script type="text/javascript" src="ext<%=extjsVersion%>/ux/colorpick/SliderAlpha.js"></script>
		    <script type="text/javascript" src="ext<%=extjsVersion%>/ux/colorpick/SliderSaturation.js"></script>
		    <script type="text/javascript" src="ext<%=extjsVersion%>/ux/colorpick/SliderValue.js"></script>
		    <script type="text/javascript" src="ext<%=extjsVersion%>/ux/colorpick/SliderHue.js"></script>
		    <script type="text/javascript" src="ext<%=extjsVersion%>/ux/colorpick/Selector.js"></script>
		    <script type="text/javascript" src="ext<%=extjsVersion%>/ux/colorpick/Field.js"></script>

			<script type="text/javascript" src="ext<%=extjsVersion%>/uxAt4/colorpick/ColorPickField.js"></script>
    		<link rel="stylesheet" type="text/css" href="ext<%=extjsVersion%>/ux/colorpick/resources/ext-ux-all.css"/>

			<script type="text/javascript" src="ext<%=extjsVersion%>/ux/TabCloseMenu.js"></script>

			<!-- Extensiones propias -->
			<script type="text/javascript" src="js/core/At4FrameworkIntranet/util/Format.js"></script>
			<script type="text/javascript" src="js/core/At4FrameworkIntranet/app/DwrStateProvider.js"></script>
			<!-- Implementación del interfaz GUI para DWR -->
			<script type='text/javascript' src='js/svrInt/dwr/ServerGui.js'></script>
			<script type='text/javascript' src='js/svrInt/dwr/ServerDatabaseActions.js'></script>
			<!-- DWRProxy para ext -->
			<script type='text/javascript' src='js/svrInt/dwr/DwrProxy.js'></script>
			<script type='text/javascript' src='js/svrInt/dwr/DwrSubmit.js'></script>
			<script type='text/javascript' src='js/svrInt/dwr/DwrLoad.js'></script>

			<!-- Modulo para At4FrameworkIntranet
			<script type="text/javascript" src="js/core/At4FrameworkIntranet/app/At4FrameworkIntranet.js"></script>-->
			<script type="text/javascript" src="js/core/At4FrameworkIntranet/mixins/ApplicationBasic.js"></script>
			<script type="text/javascript" src="js/core/At4FrameworkIntranet/util/At4Util.js"></script>
			<script type="text/javascript" src="js/core/At4FrameworkIntranet/grid/AbstractGrid.js"></script>
			<script type="text/javascript" src="js/core/At4FrameworkIntranet/grid/ListadoGrid.js"></script>
			<%-- <script type="text/javascript" src="js/core/ListadoGrid.mergebackup.js"></script> --%>
			<script type="text/javascript" src="js/core/At4FrameworkIntranet/grid/ListadoGridConfig.js"></script>


			<!--  clase base de formularios -->
			<script type="text/javascript" src="js/core/At4FrameworkIntranet/form/BaseForm.js"></script>
			<script type="text/javascript" src="js/core/At4FrameworkIntranet/form/BasicForm.js"></script>
			<script type="text/javascript" src="js/core/At4FrameworkIntranet/form/BasicSubForm.js"></script>
			<script type="text/javascript" src="js/core/At4FrameworkIntranet/panel/BasicPanel.js"></script>
			<!--<script type="text/javascript" src="js/core/At4FrameworkIntranet/BaseEditorGridPanel.js"></script>
			<script type="text/javascript" src="js/core/At4FrameworkIntranet/BaseNestedEditorGridPanel.js"></script>-->
			<script type="text/javascript" src="ext<%=extjsVersion%>/uxAt4/ckeditor/Ext.ux.CKEditor.js"></script>
			<script type="text/javascript" src="js/core/At4FrameworkIntranet/util/vtypes.js"></script>
			<script type="text/javascript" src="js/core/At4FrameworkIntranet/panel/FilePanel.js"></script>
			<script type="text/javascript" src="js/core/At4FrameworkIntranet/panel/RelationPopupPanel.js"></script>
			<script type="text/javascript" src="js/core/At4FrameworkIntranet/util/FormDefaultsBase.js"></script>
			<script type="text/javascript" src="js/core/At4FrameworkIntranet/mixins/MultilangMixin.js"></script>
			<script type="text/javascript" src="ext<%=extjsVersion%>/ux/IFrame.js"></script>
			<script type="text/javascript" src="js/core/At4FrameworkIntranet/form/FormBuilder.js"></script>
			<script type="text/javascript" src="js/core/At4FrameworkIntranet/field/RadioGroup.js"></script>
			<script type="text/javascript" src="js/core/At4FrameworkIntranet/field/TextFields.js"></script>

			<%--
				UX.DATETIME
			--%>

			<script type="text/javascript" src="js/core/At4FrameworkIntranet/field/datetime/Ext.ux.form.field.Time.js"></script>
			<script type="text/javascript" src="js/core/At4FrameworkIntranet/field/datetime/Ext.ux.picker.DateTime.js"></script>
			<script type="text/javascript" src="js/core/At4FrameworkIntranet/field/datetime/Ext.local.en.ux.picker.DateTime.js"></script>
			<script type="text/javascript" src="js/core/At4FrameworkIntranet/field/datetime/Ext.ux.form.field.DateTime.js"></script>

			<%--
				UX.DATETIME END
			--%>

			<script type="text/javascript" src="js/core/LocalApp/FormDefaults.js"></script>
			<script type="text/javascript" src="js/core/At4FrameworkIntranet/field/FormFields.js"></script>


			<script type="text/javascript" src="js/core/At4FrameworkIntranet/grid/export/ExportForm.js"></script>
			<script type="text/javascript" src="js/core/At4FrameworkIntranet/grid/export/ExportWindow.js"></script>
			<script type="text/javascript" src="js/core/At4FrameworkIntranet/grid/export/prompt/ExportBasePrompt.js"></script>
			<script type="text/javascript" src="js/core/At4FrameworkIntranet/grid/export/prompt/ExportCfgPrompt.js"></script>
			<script type="text/javascript" src="js/core/At4FrameworkIntranet/grid/export/prompt/AppCfgPrompt.js"></script>


			<script type="text/javascript" src="ext<%=extjsVersion%>/uxAt4/filterItemSelector.js"></script>

			<!--<script type="text/javascript" src="js/core/At4FrameworkIntranet/OpenFormPanel.js"></script>-->

			<script type="text/javascript" src="ext<%=extjsVersion%>/ux/Image.js"></script>
			<script type="text/javascript" src="ext<%=extjsVersion%>/ux/pageSize.js"></script>
			<script type="text/javascript" src="js/core/At4FrameworkIntranet/field/UploadFileForm.js"></script>

			<script type="text/javascript" src="js/core/At4FrameworkIntranet/panel/ImagePreviewPanel.js"></script>

			<%-- TODO: Quitar? --%>
			<%-- <script type="text/javascript" src="js/app/UbicacionCamaraPanel.js"></script> --%>

			<!-- Extension para tratar archivos PDF -->

			<script type="text/javascript" src="ext<%=extjsVersion%>/ux/panel/PDF.js"></script>
			<script type="text/javascript" src="ext<%=extjsVersion%>/ux/util/PDF/TextLayerBuilder.js"></script>


			<!-- Extension para añadir fila de filtros en grid -->

			<%-- <script type="text/javascript" src="ext<%=extjsVersion%>/ux/HeaderFilter/filterfield/button/OperatorButton.js"></script>
			<script type="text/javascript" src="ext<%=extjsVersion%>/ux/HeaderFilter/filterfield/filters/Filter.js"></script>
			<link rel="stylesheet" type="text/css" href="ext<%=extjsVersion%>/ux/HeaderFilter/css/operator-button.css" /> --%>

			<!--  formularios, subforms, grids y paneles generados -->
			<!--  formularios generados -->

		<script type="text/javascript" src="js/core/LocalApp/InspeccionBaseForm.js"></script>
        <script type="text/javascript" src="js/form/AcusticaRuidosInterioresHorizontalesForm.js"></script>
        <script type="text/javascript" src="js/form/EdificioForm.js"></script>
        <script type="text/javascript" src="js/form/CimentacionesForm.js"></script>
        <script type="text/javascript" src="js/form/UsuarioForm.js"></script>
        <script type="text/javascript" src="js/form/EstructuraForm.js"></script>
        <script type="text/javascript" src="js/form/AcusticaDatosGeneralesForm.js"></script>
        <script type="text/javascript" src="js/form/InstalacionesForm.js"></script>
        <script type="text/javascript" src="js/form/AcusticaRuidosExterioresForm.js"></script>
        <script type="text/javascript" src="js/form/AcusticaRuidoInstalacionesForm.js"></script>
        <script type="text/javascript" src="js/form/AcusticaComprobacionesForm.js"></script>
        <script type="text/javascript" src="js/form/ViaForm.js"></script>
        <script type="text/javascript" src="js/form/AcusticaRuidosInterioresUnionesForm.js"></script>
        <script type="text/javascript" src="js/form/AccesibilidadValoracionFinalesForm.js"></script>
        <script type="text/javascript" src="js/form/InspeccionForm.js"></script>
        <script type="text/javascript" src="js/form/AcusticasForm.js"></script>
        <script type="text/javascript" src="js/form/MunicipioForm.js"></script>
        <script type="text/javascript" src="js/form/InformeForm.js"></script>
        <script type="text/javascript" src="js/form/AcusticaRuidosInterioresVerticalesForm.js"></script>
        <script type="text/javascript" src="js/form/TipoViaForm.js"></script>
        <script type="text/javascript" src="js/form/CerramientosCubiertasForm.js"></script>
        <script type="text/javascript" src="js/form/AccesibilidadAjustesRazonablesForm.js"></script>
        <script type="text/javascript" src="js/form/ConservacionForm.js"></script>
        <script type="text/javascript" src="js/form/EficienciasEnergeticasForm.js"></script>
        <script type="text/javascript" src="js/form/AcusticaValoracionFinalForm.js"></script>
        <script type="text/javascript" src="js/form/AccesibilidadPublicosForm.js"></script>
        <script type="text/javascript" src="js/form/AcusticaMejorasAcusticasForm.js"></script>
        <script type="text/javascript" src="js/form/IslaForm.js"></script>

			<!-- La APP YA NO debe cargarse despues de aplicarse los idiomas -->
			<script type="text/javascript" src="js/core/At4FrameworkIntranet/app/At4FrameworkIntranet.js"></script>
			<script type="text/javascript" src="js/core/LocalApp/ieeImport/ImportIeeForm.js"></script>
			<script type="text/javascript" src="js/core/LocalApp/ieeImport/ImportIteForm.js"></script>
			<script type="text/javascript" src="js/core/LocalApp/ieeImport/SubsanacioForm.js"></script>
			<script type="text/javascript" src="js/core/LocalApp/ieeImport/InspeccionGrid.js"></script>
			<script type="text/javascript" src="js/core/LocalApp/App.js"></script>
			<% } %>

			<!--  Localización -->

			<script type="text/javascript" src="ext<%=extjsVersion%>/base/src/locale/ext-lang-<c:out value='${rc.locale.language}'/>.js"></script>
			<script type="text/javascript" src="js/lang/ux-lang.js"></script>
			<script type="text/javascript" src="js/lang/At4Framework-lang.js"></script>
			<script type="text/javascript" src="js/lang/forms-lang.js"></script>
			<script type="text/javascript" src="js/lang/popup-lang.js"></script>

			<script type="text/javascript" src="js/core/Bootstrap.js"></script>

			<!--  cargamos css especiales del sitio -->
			<link rel="stylesheet" type="text/css" href="ext<%=extjsVersion%>/ux/util/PDF/TextLayerBuilder.css" />

			<link rel="stylesheet" type="text/css" href="ext<%=extjsVersion%>/ux/css/ItemSelector.css" />
			<link rel="stylesheet" type="text/css" href="css/At4Framework.css" />
			<link rel="stylesheet" type="text/css" href="css/header.css" />
			<link rel="stylesheet" type="text/css" href="css/LocalApp.css" />
			<link rel="stylesheet" type="text/css" href="css/glyphicons/css/glyphicons.css" />
			<!--  cargamos un tema -->
			<script type="text/javascript" src="ext5/packages/ext-theme-crisp/build/ext-theme-crisp-debug.js"></script>
			<link rel="stylesheet" type="text/css" href="ext5/packages/ext-theme-crisp/build/resources/ext-theme-crisp-all-debug.css" />

			<!-- Tema seleccionado
			<link rel="stylesheet" type="text/css" href="<%=themespecurl%>" />-->
			<script type="text/javascript" src="<%=themejsurl%>"></script>
			<link rel="stylesheet" type="text/css" href="<%=themebaseurl%>" />
			<!-- -->
			<%-- //DESCOMENTAR PARA ACTIVAR EL SELECTOR DE TEMAS POR GET - ->
			<script type="text/javascript" src="ext<%=extjsVersion%>/packages/ext-theme-<%=tema%>/build/ext-theme-<%=tema%>-debug.js"></script>
			<link rel="stylesheet" type="text/css" href="ext<%=extjsVersion%>/packages/ext-theme-<%=tema%>/build/resources/ext-theme-<%=tema%>-all-debug.css" />
		--%>

		<!-- Tema base -->
		<%--ACTIVAR ESTO SI SE PUEDE ELEGIR ENTRE UN TEMA NORMAL Y UN TOUCH

		if(tema.toLowerCase().contains("at4")){
			if(tema.toLowerCase().contains("touch")){

				<script type="text/javascript" src="ext5/packages/ext-theme-crisp-touch/build/ext-theme-crisp-touch-debug.js"></script>
				<link rel="stylesheet" type="text/css" href="ext5/packages/ext-theme-crisp-touch/build/resources/ext-theme-crisp-touch-all-debug.css" />

			}else{

				<script type="text/javascript" src="ext5/packages/ext-theme-crisp/build/ext-theme-crisp-debug.js"></script>
				<link rel="stylesheet" type="text/css" href="ext5/packages/ext-theme-crisp/build/resources/ext-theme-crisp-all-debug.css" />

			}
		}
		--%>

		<title><spring:message code="header.titulo" /></title>
	</head>

	<body scroll="no" id="At4Framework" style="margin-left:0px; border: 1px solid black;">
		<div id="capsal">
			<a href="#">Tornar a la Intranet</a>
			<img src="img/govern/logo_caib.gif" alt="Govern de les Illes Balears" />
			<h1><spring:message code="header.titulo" /></h1>
		</div>
		<div id="tabs"></div>

	</body>

</html>
