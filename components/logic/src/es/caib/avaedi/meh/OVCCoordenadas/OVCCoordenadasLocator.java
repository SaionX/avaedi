/**
 * OVCCoordenadasLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package es.caib.avaedi.meh.OVCCoordenadas;

public class OVCCoordenadasLocator extends org.apache.axis.client.Service implements es.caib.avaedi.meh.OVCCoordenadas.OVCCoordenadas {

	public OVCCoordenadasLocator() {
	}

	public OVCCoordenadasLocator(org.apache.axis.EngineConfiguration config) {
		super(config);
	}

	public OVCCoordenadasLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
		super(wsdlLoc, sName);
	}

	// Use to get a proxy class for OVCCoordenadasSoap
	private java.lang.String OVCCoordenadasSoap_address = "http://ovc.catastro.meh.es/ovcservweb/OVCSWLocalizacionRC/OVCCoordenadas.asmx";

	public java.lang.String getOVCCoordenadasSoapAddress() {
		return OVCCoordenadasSoap_address;
	}

	// The WSDD service name defaults to the port name.
	private java.lang.String OVCCoordenadasSoapWSDDServiceName = "OVCCoordenadasSoap";

	public java.lang.String getOVCCoordenadasSoapWSDDServiceName() {
		return OVCCoordenadasSoapWSDDServiceName;
	}

	public void setOVCCoordenadasSoapWSDDServiceName(java.lang.String name) {
		OVCCoordenadasSoapWSDDServiceName = name;
	}

	public es.caib.avaedi.meh.OVCCoordenadas.OVCCoordenadasSoap getOVCCoordenadasSoap() throws javax.xml.rpc.ServiceException {
		java.net.URL endpoint;
		try {
			endpoint = new java.net.URL(OVCCoordenadasSoap_address);
		} catch (java.net.MalformedURLException e) {
			throw new javax.xml.rpc.ServiceException(e);
		}
		return getOVCCoordenadasSoap(endpoint);
	}

	public es.caib.avaedi.meh.OVCCoordenadas.OVCCoordenadasSoap getOVCCoordenadasSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
		try {
			es.caib.avaedi.meh.OVCCoordenadas.OVCCoordenadasSoapStub _stub = new es.caib.avaedi.meh.OVCCoordenadas.OVCCoordenadasSoapStub(portAddress, this);
			_stub.setPortName(getOVCCoordenadasSoapWSDDServiceName());
			return _stub;
		} catch (org.apache.axis.AxisFault e) {
			return null;
		}
	}

	public void setOVCCoordenadasSoapEndpointAddress(java.lang.String address) {
		OVCCoordenadasSoap_address = address;
	}

	/**
	 * For the given interface, get the stub implementation. If this service has
	 * no port for the given interface, then ServiceException is thrown.
	 */
	public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
		try {
			if (es.caib.avaedi.meh.OVCCoordenadas.OVCCoordenadasSoap.class.isAssignableFrom(serviceEndpointInterface)) {
				es.caib.avaedi.meh.OVCCoordenadas.OVCCoordenadasSoapStub _stub = new es.caib.avaedi.meh.OVCCoordenadas.OVCCoordenadasSoapStub(new java.net.URL(OVCCoordenadasSoap_address), this);
				_stub.setPortName(getOVCCoordenadasSoapWSDDServiceName());
				return _stub;
			}
		} catch (java.lang.Throwable t) {
			throw new javax.xml.rpc.ServiceException(t);
		}
		throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
	}

	/**
	 * For the given interface, get the stub implementation. If this service has
	 * no port for the given interface, then ServiceException is thrown.
	 */
	public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
		if (portName == null) {
			return getPort(serviceEndpointInterface);
		}
		java.lang.String inputPortName = portName.getLocalPart();
		if ("OVCCoordenadasSoap".equals(inputPortName)) {
			return getOVCCoordenadasSoap();
		} else {
			java.rmi.Remote _stub = getPort(serviceEndpointInterface);
			((org.apache.axis.client.Stub) _stub).setPortName(portName);
			return _stub;
		}
	}

	public javax.xml.namespace.QName getServiceName() {
		return new javax.xml.namespace.QName("http://tempuri.org/OVCServWeb/OVCCoordenadas", "OVCCoordenadas");
	}

	private java.util.HashSet ports = null;

	public java.util.Iterator getPorts() {
		if (ports == null) {
			ports = new java.util.HashSet();
			ports.add(new javax.xml.namespace.QName("http://tempuri.org/OVCServWeb/OVCCoordenadas", "OVCCoordenadasSoap"));
		}
		return ports.iterator();
	}

	/**
	 * Set the endpoint address for the specified port name.
	 */
	public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {

		if ("OVCCoordenadasSoap".equals(portName)) {
			setOVCCoordenadasSoapEndpointAddress(address);
		} else { // Unknown Port Name
			throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
		}
	}

	/**
	 * Set the endpoint address for the specified port name.
	 */
	public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
		setEndpointAddress(portName.getLocalPart(), address);
	}

}
