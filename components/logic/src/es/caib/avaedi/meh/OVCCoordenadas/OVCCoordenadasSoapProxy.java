package es.caib.avaedi.meh.OVCCoordenadas;

public class OVCCoordenadasSoapProxy implements es.caib.avaedi.meh.OVCCoordenadas.OVCCoordenadasSoap {
	private String _endpoint = null;
	private es.caib.avaedi.meh.OVCCoordenadas.OVCCoordenadasSoap oVCCoordenadasSoap = null;

	public OVCCoordenadasSoapProxy() {
		_initOVCCoordenadasSoapProxy();
	}

	public OVCCoordenadasSoapProxy(String endpoint) {
		_endpoint = endpoint;
		_initOVCCoordenadasSoapProxy();
	}

	private void _initOVCCoordenadasSoapProxy() {
		try {
			oVCCoordenadasSoap = (new es.caib.avaedi.meh.OVCCoordenadas.OVCCoordenadasLocator()).getOVCCoordenadasSoap();
			if (oVCCoordenadasSoap != null) {
				if (_endpoint != null)
					((javax.xml.rpc.Stub) oVCCoordenadasSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
				else
					_endpoint = (String) ((javax.xml.rpc.Stub) oVCCoordenadasSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
			}

		} catch (javax.xml.rpc.ServiceException serviceException) {
		}
	}

	public String getEndpoint() {
		return _endpoint;
	}

	public void setEndpoint(String endpoint) {
		_endpoint = endpoint;
		if (oVCCoordenadasSoap != null)
			((javax.xml.rpc.Stub) oVCCoordenadasSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);

	}

	public es.caib.avaedi.meh.OVCCoordenadas.OVCCoordenadasSoap getOVCCoordenadasSoap() {
		if (oVCCoordenadasSoap == null)
			_initOVCCoordenadasSoapProxy();
		return oVCCoordenadasSoap;
	}

	public es.caib.avaedi.meh.catastro.www.Consulta_Coordenadas consulta_CPMRC(java.lang.String provincia, java.lang.String municipio, java.lang.String SRS, java.lang.String RC) throws java.rmi.RemoteException {
		if (oVCCoordenadasSoap == null)
			_initOVCCoordenadasSoapProxy();
		return oVCCoordenadasSoap.consulta_CPMRC(provincia, municipio, SRS, RC);
	}

	public es.caib.avaedi.meh.catastro.www.Consulta_Coordenadas consulta_RCCOOR(java.lang.String SRS, java.lang.String coordenada_X, java.lang.String coordenada_Y) throws java.rmi.RemoteException {
		if (oVCCoordenadasSoap == null)
			_initOVCCoordenadasSoapProxy();
		return oVCCoordenadasSoap.consulta_RCCOOR(SRS, coordenada_X, coordenada_Y);
	}

	public es.caib.avaedi.meh.catastro.www.Consulta_Coordenadas_Distancia consulta_RCCOOR_Distancia(java.lang.String SRS, java.lang.String coordenada_X, java.lang.String coordenada_Y) throws java.rmi.RemoteException {
		if (oVCCoordenadasSoap == null)
			_initOVCCoordenadasSoapProxy();
		return oVCCoordenadasSoap.consulta_RCCOOR_Distancia(SRS, coordenada_X, coordenada_Y);
	}

}