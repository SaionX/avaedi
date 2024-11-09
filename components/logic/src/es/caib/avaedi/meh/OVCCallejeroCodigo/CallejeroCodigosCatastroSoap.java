/**
 * Callejero_x0020_de_x0020_la_x0020_sede_x0020_electrónica_x0020_del_x0020_catastroSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package es.caib.avaedi.meh.OVCCallejeroCodigo;

public interface CallejeroCodigosCatastroSoap extends java.rmi.Remote {

	/**
	 * Servicio de consulta de datos no protegidos para un inmueble por su
	 * referencia catastral (Por códigos).
	 */
	public es.caib.avaedi.meh.catastro.www.Consulta_DNP consulta_DNPRC_Codigos(java.lang.String codigoProvincia, java.lang.String codigoMunicipio, java.lang.String codigoMunicipioINE, java.lang.String RC) throws java.rmi.RemoteException;

	/**
	 * Servicio de consulta de provincias.
	 */
	public es.caib.avaedi.meh.catastro.www.Provincias obtenerProvincias() throws java.rmi.RemoteException;

	/**
	 * Servicio de consulta de municipios para una provincia (Por códigos).
	 */
	public es.caib.avaedi.meh.catastro.www.Municipios obtenerMunicipiosCodigos(java.lang.String codigoProvincia, java.lang.String codigoMunicipio, java.lang.String codigoMunicipioIne) throws java.rmi.RemoteException;

	/**
	 * Servicio de consulta de vias para un municipio (Por códigos).
	 */
	public es.caib.avaedi.meh.catastro.www.Callejero obtenerCallejeroCodigos(java.lang.String codigoProvincia, java.lang.String codigoMunicipio, java.lang.String codigoMunicipioINE, java.lang.String codigoVia) throws java.rmi.RemoteException;

	/**
	 * Servicio de consulta de números para una via (Por códigos).
	 */
	public es.caib.avaedi.meh.catastro.www.Callejero obtenerNumereroCodigos(java.lang.String codigoProvincia, java.lang.String codigoMunicipio, java.lang.String codigoMunicipioINE, java.lang.String codigoVia, java.lang.String numero) throws java.rmi.RemoteException;

	/**
	 * Servicio de consulta de datos no protegidos para un inmueble por su
	 * localización (Por códigos).
	 */
	public es.caib.avaedi.meh.catastro.www.Consulta_DNP consulta_DNPLOC_Codigos(java.lang.String codigoProvincia, java.lang.String codigoMunicipio, java.lang.String codigoMunicipioINE, java.lang.String codigoVia, java.lang.String numero, java.lang.String bloque, java.lang.String escalera, java.lang.String planta, java.lang.String puerta) throws java.rmi.RemoteException;

	/**
	 * Servicio de consulta de datos no protegidos para un inmueble por su
	 * polígono parcela (Por códigos).
	 */
	public es.caib.avaedi.meh.catastro.www.Consulta_DNPPP consulta_DNPPP_Codigos(java.lang.String codigoProvincia, java.lang.String codigoMunicipio, java.lang.String codigoMunicipioINE, java.lang.String poligono, java.lang.String parcela) throws java.rmi.RemoteException;
}
