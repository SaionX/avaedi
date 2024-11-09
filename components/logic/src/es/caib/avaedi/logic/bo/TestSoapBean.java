package es.caib.avaedi.logic.bo;

import java.io.StringReader;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import es.caib.avaedi.at4forms.common.exception.GenericBusinessException;
import es.caib.avaedi.at4forms.common.search.FilterConfig;
import es.caib.avaedi.at4forms.common.search.PagingConfig;
import es.caib.avaedi.at4forms.common.search.ResultadoBusqueda;
import es.caib.avaedi.logic.vo.MunicipioFormVO;
import es.caib.avaedi.logic.vo.TipoViaFormVO;
import es.caib.avaedi.logic.vo.ViaFormVO;
import es.caib.avaedi.logic.vo.ViaListadoVO;
import es.caib.avaedi.meh.catastro.Bico;
import es.caib.avaedi.meh.catastro.CatastroSoapException;
import es.caib.avaedi.meh.catastro.ConsultaCallejero;
import es.caib.avaedi.meh.catastro.ConsultaCoord;
import es.caib.avaedi.meh.catastro.ConsultaDnp;
import es.caib.avaedi.meh.catastro.ConsultaMunicipieror;
import es.caib.avaedi.meh.catastro.ConsultaNumereror;
import es.caib.avaedi.meh.catastro.Df;
import es.caib.avaedi.meh.catastro.Muni;
import es.caib.avaedi.meh.catastro.Numereror;
import es.caib.avaedi.meh.catastro.www.Callejero;
import es.caib.avaedi.meh.catastro.www.Consulta_Coordenadas;
import es.caib.avaedi.meh.catastro.www.Consulta_DNP;
import es.caib.avaedi.meh.catastro.www.Municipios;

@Repository("TestSoapBean")
public class TestSoapBean extends BaseSoap implements TestSoapBO {

	@Autowired
	@Qualifier("ViaBean")
	protected ViaBO viaBO;

	@Autowired
	@Qualifier("TipoViaBean")
	protected TipoViaBO tipoViaBO;

	@Autowired
	@Qualifier("MunicipioBean")
	protected MunicipioBO municipioBO;

	@Override
	public List<Muni> getMunicipios(String provincia) throws GenericBusinessException, CatastroSoapException {

		if (provincia == null) {
			provincia = PROVINCIA;
		}
		ConsultaMunicipieror municipios;
		try {

			Municipios municipiosXML = catastroProxy.obtenerMunicipios(provincia, "");
			String minicipiosS = municipiosXML.get_any()[0].toString();
			JAXBContext MunicipiosContext = JAXBContext.newInstance(ConsultaMunicipieror.class);
			Unmarshaller municipieroUnmarshaller = MunicipiosContext.createUnmarshaller();
			StringReader municipioReader = new StringReader(minicipiosS);
			municipios = (ConsultaMunicipieror) municipieroUnmarshaller.unmarshal(municipioReader);

			this.checkPeticion(municipios);

		} catch (JAXBException e) {
			throw new GenericBusinessException(e);
		} catch (RemoteException e) {
			throw new GenericBusinessException(e);
		}

		return municipios.getMunicipiero().getMuni();

	}

	@Override
	public List<Df> getCalles(String municipio, String tipoVia, String nombreVia) throws GenericBusinessException, CatastroSoapException {
		String provincia = "ILLES BALEARS";
		ConsultaCallejero callejeros;
		try {

			Callejero callejerosXML = catastroProxy.obtenerCallejero(provincia, municipio, tipoVia, nombreVia);
			String callejerosS = callejerosXML.get_any()[0].toString();
			JAXBContext callejeroContext = JAXBContext.newInstance(ConsultaCallejero.class);
			Unmarshaller callejeroUnm = callejeroContext.createUnmarshaller();
			StringReader calolejeroReader = new StringReader(callejerosS);
			callejeros = (ConsultaCallejero) callejeroUnm.unmarshal(calolejeroReader);
			this.checkPeticion(callejeros);

		} catch (JAXBException e) {
			throw new GenericBusinessException(e);
		} catch (RemoteException e) {
			throw new GenericBusinessException(e);
		}

		return callejeros.getCallejero().getCalle();

	}

	/**
	 * Parámetros de entrada.
	 * 
	 * @param Provincia
	 *            Obligatorio. Denominación de una provincia según lo devuelto
	 *            en el listado de provincias.
	 * 
	 * @param Municipio
	 *            Obligatorio. Denominación de un municipio según lo devuelto en
	 *            el listado de municipios.
	 * @param TipoVia
	 *            Obligatorio. Abreviatura del tipo de vía. Ver listado de
	 *            abreviaturas en el Anexo I.
	 * @param NombreVía
	 *            Obligatorio. Cadena con el nombre o parte del nombre de la
	 *            vía.
	 * @param Número
	 *            Obligatorio. Número del que se desea conocer la referencia
	 *            catastral. En caso de que el valor de alguno de estos
	 *            parámetros no exista en la base de datos del catastro, se
	 *            devuelve un error (“La provincia no existe”, “El municipio no
	 *            existe” etc.) y una lista de candidatos de acuerdo a lo
	 *            descrito en los servicios anteriores.
	 * @param Bloque
	 *            Opcional.
	 * @param Escalera
	 *            Opcional
	 * @param Planta
	 *            Opcional
	 * @param Puerta
	 *            Opcional
	 * @throws CatastroSoapException
	 */
	@Override
	public Bico getConsulta(String provincia, String municipio, String tipoVia, String calle, String numero, String bloque, String escalera, String planta, String puerta) throws GenericBusinessException, CatastroSoapException {
		ConsultaDnp dnpppros;

		if (provincia == null) {
			provincia = "ILLES BALEARS";
		}
		try {
			Consulta_DNP dnplocXML = catastroProxy.consulta_DNPLOC(provincia, municipio, tipoVia, calle, numero, bloque, escalera, planta, puerta);
			String dnplocS = dnplocXML.get_any()[0].toString();

			JAXBContext dnpppContext = JAXBContext.newInstance(ConsultaDnp.class);
			Unmarshaller dnpppUn = dnpppContext.createUnmarshaller();
			StringReader dnpppReader = new StringReader(dnplocS);
			dnpppros = (ConsultaDnp) dnpppUn.unmarshal(dnpppReader);
			this.checkPeticion(dnpppros);

		} catch (JAXBException e) {
			throw new GenericBusinessException(e);
		} catch (RemoteException e) {
			throw new GenericBusinessException(e);
		}

		return dnpppros.getBico();
	}

	@Override
	public Bico getConsulta(String municipio, String nombreVia, String numero) throws GenericBusinessException, CatastroSoapException {
		List<FilterConfig> viaFilters = new ArrayList<FilterConfig>();

		ResultadoBusqueda<ViaListadoVO> viaRB = viaBO.getListado(viaFilters, new PagingConfig());
		if (viaRB.getTotalNumRecords() < 1) {
			throw new GenericBusinessException("No vias/calles found");
		}
		ViaListadoVO via = viaRB.getResultados().iterator().next();
		TipoViaFormVO tipoVia = tipoViaBO.load(via.getTipoViaId());

		return this.getConsulta("ILLES BALEARS", municipio, tipoVia.getCodigoCatastro(), via.getNombre(), numero, "", "", "", "");

	}

	@Override
	public Bico getConsulta(Integer municipioId, Integer viaId, String numero) throws GenericBusinessException, CatastroSoapException {

		ViaFormVO via = viaBO.load(viaId);
		if (municipioId == null) {
			municipioId = via.getMunicipioId();
		}
		MunicipioFormVO municipio = municipioBO.load(municipioId);
		TipoViaFormVO tipoVia = tipoViaBO.load(via.getTipoViaId());

		return this.getConsulta("ILLES BALEARS", municipio.getNombre(), tipoVia.getCodigoCatastro(), via.getNombre(), numero, "", "", "", "");
	}

	@Override
	public Numereror getNumeros(String provincia, String municipio, String tipoVia, String nombreVia, String numero) throws GenericBusinessException, CatastroSoapException {
		ConsultaNumereror numereros;
		try {
			Callejero numereroXML = catastroProxy.obtenerNumerero(provincia, municipio, tipoVia, nombreVia, numero);

			String numereroS = numereroXML.get_any()[0].toString();
			JAXBContext numereroContext = JAXBContext.newInstance(ConsultaNumereror.class);
			Unmarshaller numereroUnm = numereroContext.createUnmarshaller();
			StringReader numereroReader = new StringReader(numereroS);
			numereros = (ConsultaNumereror) numereroUnm.unmarshal(numereroReader);
			this.checkPeticion(numereros);

		} catch (JAXBException e) {
			throw new GenericBusinessException(e);
		} catch (RemoteException e) {
			throw new GenericBusinessException(e);
		}
		return numereros.getNumerero();
	}

	@Override
	public Numereror getNumeros(Integer viaId, String numero) throws GenericBusinessException, CatastroSoapException {
		ViaFormVO via = viaBO.load(viaId);
		MunicipioFormVO municipio = municipioBO.load(via.getMunicipioId());
		TipoViaFormVO tipoVia = tipoViaBO.load(via.getTipoViaId());

		return this.getNumeros("ILLES BALEARS", municipio.getNombre(), tipoVia.getCodigoCatastro(), via.getNombre(), numero);
	}

	@Override
	public ConsultaCoord getCoordenadas(String municipio, String referenciaCatastral) throws GenericBusinessException, CatastroSoapException {
		ConsultaCoord coordenadas;
		try {
			Consulta_Coordenadas resultado = coordenadasProxy.consulta_CPMRC(PROVINCIA, municipio, SRS, referenciaCatastral);
			String coordsS = resultado.get_any()[0].toString();
			JAXBContext coordenadasContext = JAXBContext.newInstance(ConsultaCoord.class);
			Unmarshaller provincieroUnmarshaller = coordenadasContext.createUnmarshaller();
			StringReader provinciasReader = new StringReader(coordsS);
			coordenadas = (ConsultaCoord) provincieroUnmarshaller.unmarshal(provinciasReader);
			this.checkPeticion(coordenadas);
		} catch (RemoteException e) {
			throw new GenericBusinessException(e);
		} catch (JAXBException e) {
			throw new GenericBusinessException(e);
		}
		return coordenadas;
	}

}
