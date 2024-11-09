package es.caib.avaedi.logic.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

import org.apache.poi.util.IOUtils;

public class ArchivoDTO implements Serializable{
	
	private static final long serialVersionUID = -7293640460588854196L;
	
	private String filename;
	private String mimeType;
	private InputStream stream;
	
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getMimeType() {
		return mimeType;
	}
	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}
	public InputStream getStream() {
		return stream;
	}
	public void setStream(InputStream stream) {
		this.stream = stream;
	}
	
	public byte[] getByteData() throws IOException{
		InputStream is = this.getStream();
		byte[] bytes = IOUtils.toByteArray(is);
		return bytes;
	}
	
	
	
}
