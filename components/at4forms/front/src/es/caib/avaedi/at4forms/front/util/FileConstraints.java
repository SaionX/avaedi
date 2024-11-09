package es.caib.avaedi.at4forms.front.util;

import java.util.HashMap;
import java.util.Map;

import org.directwebremoting.annotations.DataTransferObject;

@DataTransferObject
public class FileConstraints {

	public static final int NOT_VALIDATED = 0;
	public static final int VALID = 1;
	public static final int INVALID_SIZE = 2;
	public static final int INVALID_TYPE = 3;

	int maxKb;
	private Map<String, String> mimeTypes = new HashMap<String, String>();
	
	/**
	 * Constructor con kb máximos. Se admiten todos los mimetypes registrados por defecto en {@link ImageUtil.MIME_TYPES} 
	 * @param maxKb
	 */
	public FileConstraints (
			int maxKb
			) {
		
		this.maxKb = maxKb;
		this.mimeTypes = ImageUtil.MIME_TYPES;
	}
	/**
	 * @param maxKb
	 * @param mimeTypes Mapa de extensiones y tipos mime 
	 */
	public FileConstraints (
			int maxKb, Map<String, String> mimeTypes
			) {
		
		this.maxKb = maxKb;
		this.mimeTypes = mimeTypes;
	}

	/**
	 * 
	 * @param maxKb
	 * @param extensions Listado de extensiones, de entre las registradas por defecto en {@link ImageUtil.MIME_TYPES}
	 */
	public FileConstraints (
			int maxKb, String[] extensions
			) {
		
		this.maxKb = maxKb;
		for (String ex : extensions) {
			if (ImageUtil.MIME_TYPES.containsKey(ex)) {
				this.mimeTypes.put(ex, ImageUtil.MIME_TYPES.get(ex));
			}
		}
	}

	public FileConstraints() {
		this(0);
	}

	public FileConstraints(String[] extensions) {
		this(0, extensions);
	}

	/**
	 * Lista de extensiones separada por comas
	 * @param maxKb
	 * @param extensions
	 */
	public FileConstraints(int maxKb, String extensions) {
		this(maxKb, extensions.split(","));
	}

	public FileConstraints(String extensions) {
		this(0, extensions.split(","));
	}
	
	
	public int getMaxKb() {
		return maxKb;
	}
	public void setMaxKb(int maxKb) {
		this.maxKb = maxKb;
	}
	public Map<String, String> getMimeTypes() {
		return mimeTypes;
	}
	public void setMimeTypes(Map<String, String> mimeTypes) {
		this.mimeTypes = mimeTypes;
	}


}