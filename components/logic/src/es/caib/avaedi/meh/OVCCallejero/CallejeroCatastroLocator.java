/**
 * Callejero_x0020_de_x0020_la_x0020_sede_x0020_electronica_x0020_del_x0020_catastroLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package es.caib.avaedi.meh.OVCCallejero;

import javax.xml.rpc.ServiceException;

public class CallejeroCatastroLocator extends org.apache.axis.client.Service implements CallejeroCatastro {

	/**
	 * Servicios de consulta del callejero de la sede electronica del catastro.
	 */

	public CallejeroCatastroLocator() {
	}

	public CallejeroCatastroLocator(org.apache.axis.EngineConfiguration config) {
		super(config);
	}

	public CallejeroCatastroLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws ServiceException {
		super(wsdlLoc, sName);
	}

	// Use to get a proxy class for Callejero_x0020_de_x0020_la_x0020_sede_x0020_electronica_x0020_del_x0020_catastroSoap
	private java.lang.String Callejero_x0020_de_x0020_la_x0020_sede_x0020_electronica_x0020_del_x0020_catastroSoap_address = "http://ovc.catastro.meh.es/ovcservweb/OVCSWLocalizacionRC/OVCCallejero.asmx";

	public java.lang.String getCallejero_x0020_de_x0020_la_x0020_sede_x0020_electronica_x0020_del_x0020_catastroSoapAddress() {
		return Callejero_x0020_de_x0020_la_x0020_sede_x0020_electronica_x0020_del_x0020_catastroSoap_address;
	}

	// The WSDD service name defaults to the port name.
	private java.lang.String Callejero_x0020_de_x0020_la_x0020_sede_x0020_electronica_x0020_del_x0020_catastroSoapWSDDServiceName = "Callejero_x0020_de_x0020_la_x0020_sede_x0020_electronica_x0020_del_x0020_catastro.Soap";

	public java.lang.String getCallejero_x0020_de_x0020_la_x0020_sede_x0020_electronica_x0020_del_x0020_catastroSoapWSDDServiceName() {
		return Callejero_x0020_de_x0020_la_x0020_sede_x0020_electronica_x0020_del_x0020_catastroSoapWSDDServiceName;
	}

	public void setCallejero_x0020_de_x0020_la_x0020_sede_x0020_electronica_x0020_del_x0020_catastroSoapWSDDServiceName(java.lang.String name) {
		Callejero_x0020_de_x0020_la_x0020_sede_x0020_electronica_x0020_del_x0020_catastroSoapWSDDServiceName = name;
	}

	public CallejeroCatastroSoap getCallejero_x0020_de_x0020_la_x0020_sede_x0020_electronica_x0020_del_x0020_catastroSoap() throws ServiceException {
		java.net.URL endpoint;
		try {
			endpoint = new java.net.URL(Callejero_x0020_de_x0020_la_x0020_sede_x0020_electronica_x0020_del_x0020_catastroSoap_address);
		} catch (java.net.MalformedURLException e) {
			throw new ServiceException(e);
		}
		return getCallejero_x0020_de_x0020_la_x0020_sede_x0020_electronica_x0020_del_x0020_catastroSoap(endpoint);
	}

	public CallejeroCatastroSoap getCallejero_x0020_de_x0020_la_x0020_sede_x0020_electronica_x0020_del_x0020_catastroSoap(java.net.URL portAddress) throws ServiceException {
		try {
			CallejeroCatastroSoapStub _stub = new CallejeroCatastroSoapStub(portAddress, this);
			_stub.setPortName(getCallejero_x0020_de_x0020_la_x0020_sede_x0020_electronica_x0020_del_x0020_catastroSoapWSDDServiceName());
			return _stub;
		} catch (org.apache.axis.AxisFault e) {
			return null;
		}
	}

	public void setCallejero_x0020_de_x0020_la_x0020_sede_x0020_electronica_x0020_del_x0020_catastroSoapEndpointAddress(java.lang.String address) {
		Callejero_x0020_de_x0020_la_x0020_sede_x0020_electronica_x0020_del_x0020_catastroSoap_address = address;
	}

	/**
	 * For the given interface, get the stub implementation. If this service has
	 * no port for the given interface, then ServiceException is thrown.
	 */
	public java.rmi.Remote getPort(Class serviceEndpointInterface) throws ServiceException {
		try {
			if (CallejeroCatastroSoap.class.isAssignableFrom(serviceEndpointInterface)) {
				CallejeroCatastroSoapStub _stub = new CallejeroCatastroSoapStub(new java.net.URL(Callejero_x0020_de_x0020_la_x0020_sede_x0020_electronica_x0020_del_x0020_catastroSoap_address), this);
				_stub.setPortName(getCallejero_x0020_de_x0020_la_x0020_sede_x0020_electronica_x0020_del_x0020_catastroSoapWSDDServiceName());
				return _stub;
			}
		} catch (java.lang.Throwable t) {
			throw new ServiceException(t);
		}
		throw new ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
	}

	/**
	 * For the given interface, get the stub implementation. If this service has
	 * no port for the given interface, then ServiceException is thrown.
	 */
	public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws ServiceException {
		if (portName == null) {
			return getPort(serviceEndpointInterface);
		}
		java.lang.String inputPortName = portName.getLocalPart();
		if ("Callejero_x0020_de_x0020_la_x0020_sede_x0020_electronica_x0020_del_x0020_catastro.Soap".equals(inputPortName)) {
			return getCallejero_x0020_de_x0020_la_x0020_sede_x0020_electronica_x0020_del_x0020_catastroSoap();
		} else {
			java.rmi.Remote _stub = getPort(serviceEndpointInterface);
			((org.apache.axis.client.Stub) _stub).setPortName(portName);
			return _stub;
		}
	}

	public javax.xml.namespace.QName getServiceName() {
		return new javax.xml.namespace.QName("http://tempuri.org/OVCServWeb/OVCCallejero", "Callejero_x0020_de_x0020_la_x0020_sede_x0020_electronica_x0020_del_x0020_catastro.");
	}

	private java.util.HashSet ports = null;

	public java.util.Iterator getPorts() {
		if (ports == null) {
			ports = new java.util.HashSet();
			ports.add(new javax.xml.namespace.QName("http://tempuri.org/OVCServWeb/OVCCallejero", "Callejero_x0020_de_x0020_la_x0020_sede_x0020_electronica_x0020_del_x0020_catastro.Soap"));
		}
		return ports.iterator();
	}

	/**
	 * Set the endpoint address for the specified port name.
	 */
	public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws ServiceException {

		if ("Callejero_x0020_de_x0020_la_x0020_sede_x0020_electronica_x0020_del_x0020_catastroSoap".equals(portName)) {
			setCallejero_x0020_de_x0020_la_x0020_sede_x0020_electronica_x0020_del_x0020_catastroSoapEndpointAddress(address);
		} else { // Unknown Port Name
			throw new ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
		}
	}

	/**
	 * Set the endpoint address for the specified port name.
	 */
	public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws ServiceException {
		setEndpointAddress(portName.getLocalPart(), address);
	}

}
