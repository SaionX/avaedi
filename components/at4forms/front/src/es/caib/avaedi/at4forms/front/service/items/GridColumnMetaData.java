package es.caib.avaedi.at4forms.front.service.items;

import org.directwebremoting.annotations.DataTransferObject;

/**
 * Describe la configuración de una columna de un grid
 * @author agarcia
 *
 */
@DataTransferObject
public class GridColumnMetaData {

	public static final String RENDERER_LARGETEXT = "largetext";
	public static final String RENDERER_MANY2MANY = "many2many";
	public static final String RENDERER_PASSWORD = "password";
	public static final String RENDERER_DATE = "date";
	public static final String RENDERER_DATETIME = "datetime";
	public static final String RENDERER_TIME = "time";
	public static final String RENDERER_EUROMONEY = "euromoney";
	public static final String RENDERER_BULKIMAGE = "bulkimage";
	public static final String RENDERER_BINFILE = "binfile";
	public static final String RENDERER_BOOLEAN = "boolean";
	public static final String RENDERER_POPUP = "popup";
	public static final String RENDERER_RELATIONPOPUP = "relationpopup";

	public static final String SUMMARY_SUM 		= "sum";
	public static final String SUMMARY_COUNT 	= "count";
	public static final String SUMMARY_MAX 		= "max";
	public static final String SUMMARY_MIN 		= "min";
	public static final String SUMMARY_AVERAGE 	= "average";
	
	
	private String header;
	private String tooltip;
	private String dataIndex;
	private boolean sortable = true;
	private boolean groupable = false;
	private int width = 0;
	private boolean fixed = false;
	private String sofaRenderer;
	private String[][] sofaStoreValues;
	private GridColumnFilter sofaFilter;
	private boolean editable = false;
	private String summaryType = null;
	private boolean hidden;
	private String relatedForm;

	public GridColumnMetaData(String dataIndex, String header) {
		this.dataIndex = dataIndex;
		this.header = header;
	}
	/**
	 * header o etiqueta
	 */
	public String getHeader() {
		return this.header;
	}

	public void setHeader(String header) {
		this.header = header;
	}
	/**
	 * dataIndex (Identificador)
	 */
	public String getDataIndex() {
		return this.dataIndex;
	}

	public void setDataIndex(String dataIndex) {
		this.dataIndex = dataIndex;
	}

	/**
	 * Indica si la columna es ordenable
	 */
	public boolean isSortable() {
		return this.sortable;
	}

	public void setSortable(boolean sortable) {
		this.sortable = sortable;
	}

	/**
	 * Indica si la columna es agrupable
	 */
	public boolean isGroupable() {
		return this.groupable;
	}

	public void setGroupable(boolean groupable) {
		this.groupable = groupable;
	}

	/**
	 * Ancho en píxeles
	 */
	public int getWidth() {
		return this.width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * Indica si la columna es fija (no se puede redimensionar)
	 */
	public boolean isFixed() {
		return this.fixed;
	}

	public void setFixed(boolean fixed) {
		this.fixed = fixed;
	}

	/**
	 * tipo de renderer a crear para la columna
	 * @param renderer
	 */
	public void setSofaRenderer(String renderer) {
		this.sofaRenderer = renderer;

	}
	/**
	 * tipo de renderer a crear para la columna
	 */
	public String getSofaRenderer() {
		return this.sofaRenderer;
	}

	/** Filtro configurado para la columna
	 */
	public GridColumnFilter getSofaFilter() {
		return this.sofaFilter;
	}

	public void setSofaFilter(GridColumnFilter sofaFilter) {
		this.sofaFilter = sofaFilter;
		if (sofaFilter != null) {
			sofaFilter.setDataIndex(this.getDataIndex());
		}
	}

	public void setSofaFilter(String type) {
		this.setSofaFilter( new GridColumnFilter( type) );

	}

	/**
	 * Tooltip para el header de la columna
	 */
	public String getTooltip() {
		if (this.tooltip != null) {
			if (this.tooltip.equals("null.") || this.tooltip.equals("null.null.") || this.tooltip.equals("null.null.null.")) {
				return null;
			}
		}
		return this.tooltip;
	}

	public void setTooltip(String tooltip) {
		this.tooltip = tooltip;
	}

	//	aamengual - hacer la columna editable

	/**
	 * @return editable
	 */
	public boolean isEditable() {
		return this.editable;
	}

	/**
	 * @param editable setea el boleano editable
	 */
	public void setEditable(boolean editable) {
		this.editable = editable;
	}
	
	// Valores para el tipo de columna POPUP
	/**
	 * @return the sofaStoreValues
	 * @see 
	 */
	public String[][] getSofaStoreValues() {
		return this.sofaStoreValues;
	}
	/**
	 * @param sofaStoreValues the sofaStoreValues to set
	 */
	public void setSofaStoreValues(String[][] sofaStoreValues) {
		this.sofaStoreValues = sofaStoreValues;
	}
	
	
	public String getSummaryType() {
		return summaryType;
	}
	
	public void setSummaryType(String summary) {
		this.summaryType  = summary;
		
	}
	public void setHidden(boolean b) {
		this.hidden = b;
	}
	public boolean isHidden() {
		return hidden;
	}
	public void setRelatedForm(String relatedForm) {
		this.relatedForm = relatedForm;
	}
	public String getRelatedForm() {
		return relatedForm;
	}
	
}
