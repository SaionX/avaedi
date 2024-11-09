package es.caib.avaedi.at4forms.front.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.activation.DataSource;

public class BufferedDataSource implements DataSource {


    private byte[] _data;
    private String _name;
    private String _type;


    public BufferedDataSource(byte[] data, String name, String type) {

        _data = data;
        _name = name;
        _type = type;
    }

    public String getContentType() {

        return _type;

    }

    public InputStream getInputStream() throws IOException {

        return new ByteArrayInputStream(_data);

    }

    public String getName() {

        return _name;

    }

    public OutputStream getOutputStream() throws IOException {

        OutputStream out = new ByteArrayOutputStream();
        out.write(_data);
        return out;

    }
}