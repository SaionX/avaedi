package es.caib.avaedi.at4forms.front.controller;

public class DocumentDownload {

	private String filename;
    private byte[] data;
    private String mime;

    public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public byte[] getData() {
		return data;
	}
	public void setData(byte[] data) {
		this.data = data;
	}
	public String getMime() {
		return mime;
	}
	public void setMime(String mime) {
		this.mime = mime;
	}
	
	
}
