package es.caib.avaedi.at4forms.logic.vo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;


/**
 * VO genérico basado en un java.util.Map
 * @author agarcia
 *
 */
public class BaseMapVO extends BaseVO implements FormVO, Map<String, Object> {

	@Override
	public Serializable getPrimaryKey() {
		return this.internalMap.hashCode();
	}
	
	
	private Map<String, Object> internalMap = new Hashtable<String, Object>();

	public void clear() {
		this.internalMap.clear();
	}

	public boolean containsKey(Object key) {
		return this.internalMap.containsKey(key);
	}

	public boolean containsValue(Object value) {
		return this.internalMap.containsValue(value);
	}

	public Set<java.util.Map.Entry<String, Object>> entrySet() {
		return this.internalMap.entrySet();
	}

	public Object get(Object key) {
		return this.internalMap.get(key);
	}

	public boolean isEmpty() {
		return this.internalMap.isEmpty();
	}

	public Set<String> keySet() {
		return this.internalMap.keySet();
	}

	public Object put(String key, Object value) {
		return this.internalMap.put(key, value);
	}

	public void putAll(Map<? extends String, ? extends Object> t) {
		this.internalMap.putAll(t);

	}

	public Object remove(Object key) {
		return this.internalMap.remove(key);
	}

	public int size() {
		return this.internalMap.size();
	}

	public Collection<Object> values() {
		return this.internalMap.values();
	}

	// TODO Racionalizar el uso de BaseMapVO (no deberian ser necesarios estos métodos fake
	@Override
	public void setDateCreation(Date ahora) {
	}

	@Override
	public void setLastModified(Date ahora) {
	}

	@Override
	public void setCreatorUser(String username) {
	}

	@Override
	public void setModUser(String username) {
	}

	@Override
	public String getPrimaryLabel() {
		return null;
	}




}
