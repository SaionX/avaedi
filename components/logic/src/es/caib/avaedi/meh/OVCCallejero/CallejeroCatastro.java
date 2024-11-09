/**
 * Callejero_x0020_de_x0020_la_x0020_sede_x0020_electronica_x0020_del_x0020_catastro.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package es.caib.avaedi.meh.OVCCallejero;

import javax.xml.rpc.ServiceException;

public interface CallejeroCatastro extends javax.xml.rpc.Service {

	/**
	 * Servicios de consulta del callejero de la sede electronica del catastro.
	 */
	public java.lang.String getCallejero_x0020_de_x0020_la_x0020_sede_x0020_electronica_x0020_del_x0020_catastroSoapAddress();

	public CallejeroCatastroSoap getCallejero_x0020_de_x0020_la_x0020_sede_x0020_electronica_x0020_del_x0020_catastroSoap() throws ServiceException;

	public CallejeroCatastroSoap getCallejero_x0020_de_x0020_la_x0020_sede_x0020_electronica_x0020_del_x0020_catastroSoap(java.net.URL portAddress) throws ServiceException;
}
