package es.caib.avaedi.at4forms.front.service.items;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.directwebremoting.annotations.DataTransferObject;

import es.caib.avaedi.at4forms.front.items.FormItem;


/**
 * Transfer Object que contiene la configuración base de un grid de formulario
 * @author agarcia
 *
 */
@DataTransferObject
public class GridMetaData {

	private FormItem formItem;

	private List<GridColumnMetaData> columns = new ArrayList<GridColumnMetaData>();
	private List<GridRecordFieldMetaData> recordFields = new ArrayList<GridRecordFieldMetaData>();
	private Map<String, GridColumnMetaData> columnsMap = new HashMap<String, GridColumnMetaData>();
	private Map<String, GridRecordFieldMetaData> recordFieldsMap = new HashMap<String, GridRecordFieldMetaData>();

	private String formClassName = null;
	private String listClassName = null;

	private boolean showExportControls = false;

	private boolean showNewButton = true;
	private boolean showUpdateButton = true;
	private boolean showDeleteButton = true;
	
	private boolean editable = false;
	private boolean disableOpenForm = false;
	
	private String defaultSort = "";
	private String defaultDirection = "";
	private String defaultGroupBy = "";

	private List<String> customExportFormats = new ArrayList<String>();

	public GridMetaData(FormItem formItem) {
		this.formItem = formItem;
	}

	/** FormItem que representa el grid
	 * @return FormItem que representa el grid
	 */
	public FormItem getFormItem() {
		return this.formItem;
	}

	/** Fija el FormItem que representa el grid
	 * @param formItem FormItem que representa el grid
	 */
	public void setFormItem(FormItem formItem) {
		this.formItem = formItem;
	}

	/**
	 * @return the recordFields
	 */
	public List<GridRecordFieldMetaData> getRecordFields() {
		return this.recordFields;
	}

	/**
	 * @return the columns
	 */
	public List<GridColumnMetaData> getColumns() {
		return this.columns;
	}

	public void addRecordField (GridRecordFieldMetaData record) {
		this.recordFieldsMap.put(record.getName().toUpperCase(), record);
		this.recordFields.add(record);
	}

	public void addColumn (GridColumnMetaData column) {
		this.columnsMap.put(column.getDataIndex().toUpperCase(), column);
		this.columns.add(column);
	}

	public void removeColumn(String columnName) {
		GridColumnMetaData column = this.getColumn(columnName);
		this.columnsMap.remove(columnName);
		this.columns.remove(column);
	}
	
	
	public void insertAfter(String columnName, GridColumnMetaData newColumn) {
		this.columnsMap.put(newColumn.getDataIndex().toUpperCase(), newColumn);
		int index = this.columns.indexOf(this.getColumn(columnName));
		this.columns.add(index + 1, newColumn);
	}
	

	public GridColumnMetaData getColumn(String dataIndex) {
		return this.columnsMap.get(dataIndex.toUpperCase());
	}

	public GridRecordFieldMetaData getRecordField(String name) {
		return this.recordFieldsMap.get(name.toUpperCase());
	}

	/**
	 * @return the showExportControls
	 */
	public boolean isShowExportControls() {
		return this.showExportControls;
	}

	/**
	 * @param showExportControls the showExportControls to set
	 */
	public void setShowExportControls(boolean showExportControls) {
		this.showExportControls = showExportControls;
	}

	/**
	 * @return the formClassName
	 */
	public String getFormClassName() {
		return this.formClassName;
	}

	/**
	 * @param formClassName the formClassName to set
	 */
	public void setFormClassName(String formClassName) {
		this.formClassName = formClassName;
	}

	/**
	 * @return the listClassName
	 */
	public String getListClassName() {
		return this.listClassName;
	}

	/**
	 * @param listClassName the listClassName to set
	 */
	public void setListClassName(String listClassName) {
		this.listClassName = listClassName;
	}

	/**
	 * @return the showNewButton
	 */
	public boolean isShowNewButton() {
		return this.showNewButton;
	}

	/**
	 * @param showNewButton the showNewButton to set
	 */
	public void setShowNewButton(boolean showNewButton) {
		this.showNewButton = showNewButton;
	}

	/**
	 * @return the showUpdateButton
	 */
	public boolean isShowUpdateButton() {
		return this.showUpdateButton;
	}

	/**
	 * @param showUpdateButton the showUpdateButton to set
	 */
	public void setShowUpdateButton(boolean showUpdateButton) {
		this.showUpdateButton = showUpdateButton;
	}

	/**
	 * @return the showDeleteButton
	 */
	public boolean isShowDeleteButton() {
		return this.showDeleteButton;
	}

	/**
	 * @param showDeleteButton the showDeleteButton to set
	 */
	public void setShowDeleteButton(boolean showDeleteButton) {
		this.showDeleteButton = showDeleteButton;
	}
	
	/**
	 * @return the editable
	 */
	public boolean isEditable() {
		return editable;
	}

	/**
	 * @param editable the editable to set
	 */
	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public void setDisableOpenForm(boolean disableOpenForm) {
		this.disableOpenForm = disableOpenForm;
	}

	/**
	 * Desactiva el formulario, implica que no se pueden abrir registros. Para grids que no precisan más info.
	 * @return
	 */
	public boolean isDisableOpenForm() {
		return disableOpenForm;
	}

	/**
	 * @param defaultSort
	 */
	public void setDefaultSort(String defaultSort) {
		this.defaultSort = defaultSort;
	}

	/**
	 * Campo por defecto por el cual ordenar
	 * @return
	 */
	public String getDefaultSort() {
		return defaultSort;
	}

	public void setDefaultDirection(String defaultDirection) {
		this.defaultDirection = defaultDirection;
	}

	/**
	 * Dirección de ordenación por defecto (si está fijado defaultSort
	 * @return
	 */
	public String getDefaultDirection() {
		return defaultDirection;
	}

	public void setDefaultGroupBy(String defaultGroupBy) {
		this.defaultGroupBy = defaultGroupBy;
	}

	/**
	 * Campo de agrupación por defecto
	 * @return
	 */
	public String getDefaultGroupBy() {
		return defaultGroupBy;
	}

	public void addCustomExportFormat(String format) {
		
		this.customExportFormats .add(format);
		
	}

	public List<String> getCustomExportFormats() {
		return customExportFormats;
	}


}
