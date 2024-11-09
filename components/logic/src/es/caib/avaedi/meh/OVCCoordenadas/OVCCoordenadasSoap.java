/**
 * OVCCoordenadasSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package es.caib.avaedi.meh.OVCCoordenadas;

public interface OVCCoordenadasSoap extends java.rmi.Remote {

	/**
	 * Servicio de consulta de coordenadas por Provincia, Municipio y Referencia
	 * Catastral.
	 */
	public es.caib.avaedi.meh.catastro.www.Consulta_Coordenadas consulta_CPMRC(java.lang.String provincia, java.lang.String municipio, java.lang.String SRS, java.lang.String RC) throws java.rmi.RemoteException;

	/**
	 * Servicio de consulta de Referencia Catastral por Coordenadas.
	 */
	public es.caib.avaedi.meh.catastro.www.Consulta_Coordenadas consulta_RCCOOR(java.lang.String SRS, java.lang.String coordenada_X, java.lang.String coordenada_Y) throws java.rmi.RemoteException;

	/**
	 * Servicio de consulta lista de Referencias Catastrales por distancia a
	 * unas Coordenadas.
	 */
	public es.caib.avaedi.meh.catastro.www.Consulta_Coordenadas_Distancia consulta_RCCOOR_Distancia(java.lang.String SRS, java.lang.String coordenada_X, java.lang.String coordenada_Y) throws java.rmi.RemoteException;
}
