package es.caib.avaedi.meh.OVCCallejeroCodigo;

public class CallejeroCodigosCatastroSoapProxy implements CallejeroCodigosCatastroSoap {
	private String _endpoint = null;
	private CallejeroCodigosCatastroSoap callejero_x0020_de_x0020_la_x0020_sede_x0020_electronica_x0020_del_x0020_catastroSoap = null;

	public CallejeroCodigosCatastroSoapProxy() {
		_initCallejero_x0020_de_x0020_la_x0020_sede_x0020_electronica_x0020_del_x0020_catastroSoapProxy();
	}

	public CallejeroCodigosCatastroSoapProxy(String endpoint) {
		_endpoint = endpoint;
		_initCallejero_x0020_de_x0020_la_x0020_sede_x0020_electronica_x0020_del_x0020_catastroSoapProxy();
	}

	private void _initCallejero_x0020_de_x0020_la_x0020_sede_x0020_electronica_x0020_del_x0020_catastroSoapProxy() {
		try {
			callejero_x0020_de_x0020_la_x0020_sede_x0020_electronica_x0020_del_x0020_catastroSoap = (new CallejeroCodigosCatastroLocator()).getCallejero_x0020_de_x0020_la_x0020_sede_x0020_electronica_x0020_del_x0020_catastroSoap();
			if (callejero_x0020_de_x0020_la_x0020_sede_x0020_electronica_x0020_del_x0020_catastroSoap != null) {
				if (_endpoint != null)
					((javax.xml.rpc.Stub) callejero_x0020_de_x0020_la_x0020_sede_x0020_electronica_x0020_del_x0020_catastroSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
				else
					_endpoint = (String) ((javax.xml.rpc.Stub) callejero_x0020_de_x0020_la_x0020_sede_x0020_electronica_x0020_del_x0020_catastroSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
			}

		} catch (javax.xml.rpc.ServiceException serviceException) {
		}
	}

	public String getEndpoint() {
		return _endpoint;
	}

	public void setEndpoint(String endpoint) {
		_endpoint = endpoint;
		if (callejero_x0020_de_x0020_la_x0020_sede_x0020_electronica_x0020_del_x0020_catastroSoap != null)
			((javax.xml.rpc.Stub) callejero_x0020_de_x0020_la_x0020_sede_x0020_electronica_x0020_del_x0020_catastroSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);

	}

	public CallejeroCodigosCatastroSoap getCallejero_x0020_de_x0020_la_x0020_sede_x0020_electronica_x0020_del_x0020_catastroSoap() {
		if (callejero_x0020_de_x0020_la_x0020_sede_x0020_electronica_x0020_del_x0020_catastroSoap == null)
			_initCallejero_x0020_de_x0020_la_x0020_sede_x0020_electronica_x0020_del_x0020_catastroSoapProxy();
		return callejero_x0020_de_x0020_la_x0020_sede_x0020_electronica_x0020_del_x0020_catastroSoap;
	}

	public es.caib.avaedi.meh.catastro.www.Consulta_DNP consulta_DNPRC_Codigos(java.lang.String codigoProvincia, java.lang.String codigoMunicipio, java.lang.String codigoMunicipioINE, java.lang.String RC) throws java.rmi.RemoteException {
		if (callejero_x0020_de_x0020_la_x0020_sede_x0020_electronica_x0020_del_x0020_catastroSoap == null)
			_initCallejero_x0020_de_x0020_la_x0020_sede_x0020_electronica_x0020_del_x0020_catastroSoapProxy();
		return callejero_x0020_de_x0020_la_x0020_sede_x0020_electronica_x0020_del_x0020_catastroSoap.consulta_DNPRC_Codigos(codigoProvincia, codigoMunicipio, codigoMunicipioINE, RC);
	}

	public es.caib.avaedi.meh.catastro.www.Provincias obtenerProvincias() throws java.rmi.RemoteException {
		if (callejero_x0020_de_x0020_la_x0020_sede_x0020_electronica_x0020_del_x0020_catastroSoap == null)
			_initCallejero_x0020_de_x0020_la_x0020_sede_x0020_electronica_x0020_del_x0020_catastroSoapProxy();
		return callejero_x0020_de_x0020_la_x0020_sede_x0020_electronica_x0020_del_x0020_catastroSoap.obtenerProvincias();
	}

	public es.caib.avaedi.meh.catastro.www.Municipios obtenerMunicipiosCodigos(java.lang.String codigoProvincia, java.lang.String codigoMunicipio, java.lang.String codigoMunicipioIne) throws java.rmi.RemoteException {
		if (callejero_x0020_de_x0020_la_x0020_sede_x0020_electronica_x0020_del_x0020_catastroSoap == null)
			_initCallejero_x0020_de_x0020_la_x0020_sede_x0020_electronica_x0020_del_x0020_catastroSoapProxy();
		return callejero_x0020_de_x0020_la_x0020_sede_x0020_electronica_x0020_del_x0020_catastroSoap.obtenerMunicipiosCodigos(codigoProvincia, codigoMunicipio, codigoMunicipioIne);
	}

	public es.caib.avaedi.meh.catastro.www.Callejero obtenerCallejeroCodigos(java.lang.String codigoProvincia, java.lang.String codigoMunicipio, java.lang.String codigoMunicipioINE, java.lang.String codigoVia) throws java.rmi.RemoteException {
		if (callejero_x0020_de_x0020_la_x0020_sede_x0020_electronica_x0020_del_x0020_catastroSoap == null)
			_initCallejero_x0020_de_x0020_la_x0020_sede_x0020_electronica_x0020_del_x0020_catastroSoapProxy();
		return callejero_x0020_de_x0020_la_x0020_sede_x0020_electronica_x0020_del_x0020_catastroSoap.obtenerCallejeroCodigos(codigoProvincia, codigoMunicipio, codigoMunicipioINE, codigoVia);
	}

	public es.caib.avaedi.meh.catastro.www.Callejero obtenerNumereroCodigos(java.lang.String codigoProvincia, java.lang.String codigoMunicipio, java.lang.String codigoMunicipioINE, java.lang.String codigoVia, java.lang.String numero) throws java.rmi.RemoteException {
		if (callejero_x0020_de_x0020_la_x0020_sede_x0020_electronica_x0020_del_x0020_catastroSoap == null)
			_initCallejero_x0020_de_x0020_la_x0020_sede_x0020_electronica_x0020_del_x0020_catastroSoapProxy();
		return callejero_x0020_de_x0020_la_x0020_sede_x0020_electronica_x0020_del_x0020_catastroSoap.obtenerNumereroCodigos(codigoProvincia, codigoMunicipio, codigoMunicipioINE, codigoVia, numero);
	}

	public es.caib.avaedi.meh.catastro.www.Consulta_DNP consulta_DNPLOC_Codigos(java.lang.String codigoProvincia, java.lang.String codigoMunicipio, java.lang.String codigoMunicipioINE, java.lang.String codigoVia, java.lang.String numero, java.lang.String bloque, java.lang.String escalera, java.lang.String planta, java.lang.String puerta) throws java.rmi.RemoteException {
		if (callejero_x0020_de_x0020_la_x0020_sede_x0020_electronica_x0020_del_x0020_catastroSoap == null)
			_initCallejero_x0020_de_x0020_la_x0020_sede_x0020_electronica_x0020_del_x0020_catastroSoapProxy();
		return callejero_x0020_de_x0020_la_x0020_sede_x0020_electronica_x0020_del_x0020_catastroSoap.consulta_DNPLOC_Codigos(codigoProvincia, codigoMunicipio, codigoMunicipioINE, codigoVia, numero, bloque, escalera, planta, puerta);
	}

	public es.caib.avaedi.meh.catastro.www.Consulta_DNPPP consulta_DNPPP_Codigos(java.lang.String codigoProvincia, java.lang.String codigoMunicipio, java.lang.String codigoMunicipioINE, java.lang.String poligono, java.lang.String parcela) throws java.rmi.RemoteException {
		if (callejero_x0020_de_x0020_la_x0020_sede_x0020_electronica_x0020_del_x0020_catastroSoap == null)
			_initCallejero_x0020_de_x0020_la_x0020_sede_x0020_electronica_x0020_del_x0020_catastroSoapProxy();
		return callejero_x0020_de_x0020_la_x0020_sede_x0020_electronica_x0020_del_x0020_catastroSoap.consulta_DNPPP_Codigos(codigoProvincia, codigoMunicipio, codigoMunicipioINE, poligono, parcela);
	}

}