/**
 * Callejero_x0020_de_x0020_la_x0020_sede_x0020_electronica_x0020_del_x0020_catastroSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package es.caib.avaedi.meh.OVCCallejero;

public interface CallejeroCatastroSoap extends java.rmi.Remote {

	/**
	 * Servicio de consulta de datos no protegidos para un inmueble por su
	 * referencia catastral.
	 */
	public es.caib.avaedi.meh.catastro.www.Consulta_DNP consulta_DNPRC(java.lang.String provincia, java.lang.String municipio, java.lang.String RC) throws java.rmi.RemoteException;

	/**
	 * Servicio de consulta de provincias.
	 */
	public es.caib.avaedi.meh.catastro.www.Provincias obtenerProvincias() throws java.rmi.RemoteException;

	/**
	 * Servicio de consulta de municipios para una provincia.
	 */
	public es.caib.avaedi.meh.catastro.www.Municipios obtenerMunicipios(java.lang.String provincia, java.lang.String municipio) throws java.rmi.RemoteException;

	/**
	 * Servicio de consulta de vias para un municipio.
	 */
	public es.caib.avaedi.meh.catastro.www.Callejero obtenerCallejero(java.lang.String provincia, java.lang.String municipio, java.lang.String tipoVia, java.lang.String nombreVia) throws java.rmi.RemoteException;

	/**
	 * Servicio de consulta de números para una via.
	 */
	public es.caib.avaedi.meh.catastro.www.Callejero obtenerNumerero(java.lang.String provincia, java.lang.String municipio, java.lang.String tipoVia, java.lang.String nomVia, java.lang.String numero) throws java.rmi.RemoteException;

	/**
	 * Servicio de consulta de datos no protegidos para un inmueble por su
	 * localizacion.
	 */
	public es.caib.avaedi.meh.catastro.www.Consulta_DNP consulta_DNPLOC(java.lang.String provincia, java.lang.String municipio, java.lang.String sigla, java.lang.String calle, java.lang.String numero, java.lang.String bloque, java.lang.String escalera, java.lang.String planta, java.lang.String puerta) throws java.rmi.RemoteException;

	/**
	 * Servicio de consulta de datos no protegidos para un inmueble por su
	 * polígono parcela.
	 */
	public es.caib.avaedi.meh.catastro.www.Consulta_DNPPP consulta_DNPPP(java.lang.String provincia, java.lang.String municipio, java.lang.String poligono, java.lang.String parcela) throws java.rmi.RemoteException;
}
