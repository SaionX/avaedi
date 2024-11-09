package es.caib.avaedi.at4forms.front.items;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.directwebremoting.annotations.DataTransferObject;

@DataTransferObject
public class StateData {
	private Map<String, StateDataItem> dataMap = new HashMap<String, StateDataItem>();
	private boolean success = true;

	public StateData() {
	}

	public void put(StateDataItem stateItem) {
		this.dataMap.put(stateItem.getName(), stateItem);
	}

	public StateData(List<StateDataItem> data) {
		this.setData(data);
	}

	public StateData(List<StateDataItem> data, boolean success) {
		this.setData(data);
		this.setSuccess(success);
	}
	/**
	 * @return the data
	 */
	public List<StateDataItem> getData() {
		return new ArrayList<StateDataItem>(this.dataMap.values());
	}
	/**
	 * @param data the data to set
	 */
	public void setData(List<StateDataItem> data) {
		for (StateDataItem stateItem : data) {
			this.put(stateItem);
		}
	}
	/**
	 * @return the success
	 */
	public boolean isSuccess() {
		return this.success;
	}
	/**
	 * @param success the success to set
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}

}

