package es.caib.avaedi.logic.bo;

import java.awt.Point;
import java.io.StringReader;
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import es.caib.avaedi.at4forms.common.exception.GenericBusinessException;
import es.caib.avaedi.logic.vo.EdificioSoapVO;
import es.caib.avaedi.logic.vo.MunicipioFormVO;
import es.caib.avaedi.logic.vo.NumeroSoapVO;
import es.caib.avaedi.logic.vo.TipoViaFormVO;
import es.caib.avaedi.logic.vo.ViaFormVO;
import es.caib.avaedi.meh.catastro.Bico;
import es.caib.avaedi.meh.catastro.CatastroSoapException;
import es.caib.avaedi.meh.catastro.ConsultaCoord;
import es.caib.avaedi.meh.catastro.ConsultaDnp;
import es.caib.avaedi.meh.catastro.ConsultaNumereror;
import es.caib.avaedi.meh.catastro.Geo;
import es.caib.avaedi.meh.catastro.Locs;
import es.caib.avaedi.meh.catastro.Nump;
import es.caib.avaedi.meh.catastro.Rc;
import es.caib.avaedi.meh.catastro.Rcdnp;
import es.caib.avaedi.meh.catastro.www.Callejero;
import es.caib.avaedi.meh.catastro.www.Consulta_Coordenadas;
import es.caib.avaedi.meh.catastro.www.Consulta_DNP;

@Repository("DatosCatastroBean")
public class DatosCatastroBean extends BaseSoap implements DatosCatastroBO {

	@Autowired
	@Qualifier("ViaBean")
	@EJB
	protected ViaBO viaBO;

	@Autowired
	@Qualifier("TipoViaBean")
	@EJB
	protected TipoViaBO tipoViaBO;

	@Autowired
	@Qualifier("MunicipioBean")
	@EJB
	protected MunicipioBO municipioBO;

	@Override
	public EdificioSoapVO getEdificio(Integer viaId, String numero, boolean withCoords) throws GenericBusinessException, CatastroSoapException {
		ViaFormVO via = viaBO.load(viaId);
		MunicipioFormVO municipio = municipioBO.load(via.getMunicipioId());
		TipoViaFormVO tipoVia = tipoViaBO.load(via.getTipoViaId());
		ConsultaDnp resultadoSoap = null;

		try {
			Consulta_DNP dnplocXML = catastroCodigoProxy.consulta_DNPLOC_Codigos(PROVINCIAID, String.valueOf(municipio.getCodigoCatastro()), "", String.valueOf(via.getCodigoCatastro()), numero, "", "", "", "");

			String dnplocS = dnplocXML.get_any()[0].toString();

			JAXBContext dnpppContext = JAXBContext.newInstance(es.caib.avaedi.meh.catastro.ConsultaDnp.class);
			Unmarshaller dnpppUn = dnpppContext.createUnmarshaller();
			StringReader dnpppReader = new StringReader(dnplocS);
			resultadoSoap = (es.caib.avaedi.meh.catastro.ConsultaDnp) dnpppUn.unmarshal(dnpppReader);

			this.checkPeticion(resultadoSoap);

			Bico bico = resultadoSoap.getBico();
			Rc rc = null;
			if (bico == null) {
				rc = resultadoSoap.getLrcdnp().getRcdnp().get(0).getRc();
			} else {
				rc = bico.getBi().getIdbi().getRc();
			}
			String codigoCatastroCorto = rc.getPc1() + rc.getPc2();
			String codigoCatastroLargo = codigoCatastroCorto + rc.getCar() + rc.getCc1() + rc.getCc2();
			if (bico == null) {
				//Consulta_DNP bicoxml = catastroProxy.consulta_DNPRC(PROVINCIA, municipio.getNombre(), codigoCatastroLargo);
				Consulta_DNP bicoxml = catastroCodigoProxy.consulta_DNPRC_Codigos(PROVINCIAID, String.valueOf(municipio.getCodigoCatastro()), "", codigoCatastroLargo);
				String bicoS = bicoxml.get_any()[0].toString();
				StringReader bicoReader = new StringReader(bicoS);
				ConsultaDnp bicoResult = (es.caib.avaedi.meh.catastro.ConsultaDnp) dnpppUn.unmarshal(bicoReader);
				this.checkPeticion(bicoResult);
				bico = bicoResult.getBico();
			}

			EdificioSoapVO ret = this.bico2Edificio(bico, tipoVia, via);
			ret.setNumeroCatastro(numero);
			/*
			 * if( bico.getBi() != null && bico.getBi().getDt() != null &&
			 * bico.getBi().getDt().getLocs() != null &&
			 * bico.getBi().getDt().getLocs().getLous() != null &&
			 * bico.getBi().getDt().getLocs().getLous().getLourb() != null &&
			 * bico.getBi().getDt().getLocs().getLous().getLourb().getDir() !=
			 * null &&
			 * bico.getBi().getDt().getLocs().getLous().getLourb().getDir
			 * ().getPlp() != null){ //Iluminati confirmed! /!\
			 * ret.setNumeroCatastro
			 * (bico.getBi().getDt().getLocs().getLous().getLourb
			 * ().getDir().getPlp()); }
			 */

			//try{
			//	ret.setNumeroCatastro(bico.getBi().getDt().getLocs().getLous().getLourb().getDir().getPlp());
			//}catch(NullPointerException e){
			//	log.warn("Error al obtener localizacion de municipio", e);
			//}

			if (withCoords) {
				this.updateCoords(ret);
			}
			return ret;
		} catch (RemoteException e) {
			throw new GenericBusinessException(e);
		} catch (JAXBException e) {
			throw new GenericBusinessException(e);
		}
	}

	@Override
	public EdificioSoapVO getEdificio(Integer viaId, String numero) throws GenericBusinessException, CatastroSoapException {
		return this.getEdificio(viaId, numero, true);
	}

	@Override
	public EdificioSoapVO getEdificio(String refCat) throws GenericBusinessException, CatastroSoapException {
		ConsultaDnp resultadoSoap = null;

		try {
			Consulta_DNP dnplocXML = catastroProxy.consulta_DNPRC("", "", refCat);

			String dnplocS = dnplocXML.get_any()[0].toString();

			JAXBContext dnpppContext = JAXBContext.newInstance(es.caib.avaedi.meh.catastro.ConsultaDnp.class);
			Unmarshaller dnpppUn = dnpppContext.createUnmarshaller();
			StringReader dnpppReader = new StringReader(dnplocS);
			resultadoSoap = (es.caib.avaedi.meh.catastro.ConsultaDnp) dnpppUn.unmarshal(dnpppReader);

			this.checkPeticion(resultadoSoap);
			Bico bico = resultadoSoap.getBico();

			EdificioSoapVO ret = this.bico2Edificio(bico);

			return ret;

		} catch (JAXBException e) {
			throw new GenericBusinessException(e);
		} catch (RemoteException e) {
			throw new GenericBusinessException(e);
		}
	}

	@Override
	public ConsultaDnp getDatosByRef(String refCat) throws GenericBusinessException, CatastroSoapException {
		ConsultaDnp resultadoSoap = null;

		try {
			Consulta_DNP dnplocXML = catastroProxy.consulta_DNPRC("", "", refCat);

			String dnplocS = dnplocXML.get_any()[0].toString();

			JAXBContext dnpppContext = JAXBContext.newInstance(es.caib.avaedi.meh.catastro.ConsultaDnp.class);
			Unmarshaller dnpppUn = dnpppContext.createUnmarshaller();
			StringReader dnpppReader = new StringReader(dnplocS);
			resultadoSoap = (es.caib.avaedi.meh.catastro.ConsultaDnp) dnpppUn.unmarshal(dnpppReader);
			
			if(resultadoSoap.getBico() == null && resultadoSoap.getLrcdnp() != null && resultadoSoap.getLrcdnp().getRcdnp() != null && resultadoSoap.getLrcdnp().getRcdnp().size() > 0){
				for(Rcdnp sugerencia : resultadoSoap.getLrcdnp().getRcdnp()){
					Rc referencia = sugerencia.getRc();
					if(referencia == null || referencia.getPc1() == null || referencia.getPc2() == null || referencia.getCar() == null || referencia.getCc1() == null || referencia.getCc2() == null ){
						continue;
					}
					String newRefCat = referencia.getPc1()+referencia.getPc2()+referencia.getCar()+referencia.getCc1()+referencia.getCc2();
					return this.getDatosByRef(newRefCat);
				}
				throw new GenericBusinessException("No se ha encontrado ninguna referencia completa en la lista de sugerencias");
				

			}
			if(resultadoSoap.getBico() != null){
				this.checkPeticion(resultadoSoap);
				return resultadoSoap;
			}else{
				throw new GenericBusinessException("No se ha encontrado ningun edificio con esa referencia ni ha habido sugerencias");
			}
		} catch (JAXBException e) {
			throw new GenericBusinessException(e);
		} catch (RemoteException e) {
			throw new GenericBusinessException(e);
		}
	}

	@Override
	public EdificioSoapVO bico2Edificio(Bico bico, TipoViaFormVO tipoVia, ViaFormVO via) {
		EdificioSoapVO ret = new EdificioSoapVO();

		Date antiguedad = null;
		XMLGregorianCalendar ant = bico.getBi().getDebi().getAnt();
		int year = 0;
		if (ant != null) {
			antiguedad = ant.toGregorianCalendar().getTime();
			Calendar antiguedadC = Calendar.getInstance();
			antiguedadC.setTime(antiguedad);
			year = antiguedadC.get(Calendar.YEAR);
		}
		Rc rc = bico.getBi().getIdbi().getRc();

		String codigoCatastroCorto = rc.getPc1() + rc.getPc2();
		String codigoCatastroLargo = codigoCatastroCorto + rc.getCar() + rc.getCc1() + rc.getCc2();
		ret.setCodigoCatastroCorto(codigoCatastroCorto);
		ret.setCodigoCatastroLargo(codigoCatastroLargo);

		if (tipoVia != null && via != null) {
			String viaLabeles = tipoVia.getNombreEs() + " " + via.getNombre();
			String viaLabelca = tipoVia.getNombreCa() + " " + via.getNombre();
			ret.setViaLabelEs(viaLabeles);
			ret.setViaLabelCa(viaLabelca);
		}

		ret.setAntiguedad(year);
		return ret;
	}

	@Override
	public EdificioSoapVO bico2Edificio(Bico bico) {
		MunicipioFormVO municipio = null;
		ViaFormVO via = null;
		TipoViaFormVO tvia = null;
		try {
			String municipioCodigoCatastro = bico.getBi().getDt().getLoine().getCm();
			Locs localizacion = bico.getBi().getDt().getLocs();
			String viaCodigoCatastro = "";
			if(localizacion.getLous()!= null){
				viaCodigoCatastro = localizacion.getLous().getLourb().getDir().getCv();
			}else if(localizacion.getLors() != null){
				viaCodigoCatastro = localizacion.getLors().getLourb().getDir().getCv();
			}else{
				throw new GenericBusinessException("Impossible recuperar datos de localizacion del edificio");
			}
			municipio = municipioBO.findByCodigoCatastro(Integer.valueOf(municipioCodigoCatastro));
			via = this.viaBO.findViaDeMunicipio(Integer.valueOf(viaCodigoCatastro), municipio.getClave());
			tvia = this.tipoViaBO.load(via.getTipoViaId());
		} catch (NumberFormatException nfe) {
			log.error("Hubo numberformatException al recuperar datos de localizacion de edificio. probablemente el catastro no haya devuelto un string con un int bien formado", nfe);
		} catch (NullPointerException npe) {
			log.error("Hubo nullpointer al recuperar datos de localizacion de edificio", npe);
		} catch (GenericBusinessException gbe) {
			log.error("Error generico", gbe);
		}
		return this.bico2Edificio(bico, tvia, via);
	}

	@Override
	public EdificioSoapVO updateCoords(EdificioSoapVO resultado) throws GenericBusinessException {
		try {
			Point coords = this.getCoords(resultado.getCodigoCatastroCorto());
			resultado.setCentroX(BigDecimal.valueOf(coords.getX()));
			resultado.setCentroY(BigDecimal.valueOf(coords.getY()));

		} catch (Exception e) {
			throw new GenericBusinessException(e);
		}
		return resultado;
	}

	@Override
	public Point getCoords(String codigocatastro) throws GenericBusinessException {
		Point ret = new Point();
		try {
			Consulta_Coordenadas coordenadasX = coordenadasProxy.consulta_CPMRC("", "", SRS, codigocatastro);

			JAXBContext dnpppContext = JAXBContext.newInstance(ConsultaCoord.class);
			Unmarshaller dnpppUn = dnpppContext.createUnmarshaller();
			StringReader dnpppReader = new StringReader(coordenadasX.get_any()[0].toString());
			ConsultaCoord coordenadas = (ConsultaCoord) dnpppUn.unmarshal(dnpppReader);

			this.checkPeticion(coordenadas);

			Geo geo = coordenadas.getCoordenadas().getCoord().get(0).getGeo();
			//resultado.setCentroX(BigDecimal.valueOf(Double.parseDouble(geo.getXcen())));
			//resultado.setCentroY(BigDecimal.valueOf(Double.parseDouble(geo.getYcen())));
			ret.setLocation(Double.parseDouble(geo.getXcen()), Double.parseDouble(geo.getYcen()));

		} catch (Exception e) {
			throw new GenericBusinessException(e);
		}
		return ret;
	}

	@Override
	public List<NumeroSoapVO> getNumeros(int municipioId, int viaId, String query) throws GenericBusinessException, CatastroSoapException {
		MunicipioFormVO municipio = this.municipioBO.load(municipioId);
		ViaFormVO via = this.viaBO.load(viaId);

		List<NumeroSoapVO> ret = new ArrayList<NumeroSoapVO>();

		ConsultaNumereror numereros;
		try {
			Callejero numereroXML = catastroCodigoProxy.obtenerNumereroCodigos(PROVINCIAID, String.valueOf(municipio.getCodigoCatastro()), "", String.valueOf(via.getCodigoCatastro()), query);
			//obtenerNumerero(PROVINCIAID, municipio, tipoVia, nombreVia, numero);

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

		for (Nump num : numereros.getNumerero().getNump()) {
			try {
				ret.add(new NumeroSoapVO(Integer.parseInt(num.getNum().getPnp())));
			} catch (NumberFormatException e) {
				throw new GenericBusinessException(e);
			}
		}

		return ret;
	}

	@Override
	public es.caib.avaedi.meh.catastro.www.Consulta_Coordenadas getReferenciasByLoc(String coordenadaX, String coordenadaY) throws GenericBusinessException {
		Consulta_Coordenadas resultado;
		try {
			resultado = coordenadasProxy.consulta_RCCOOR(SRS, coordenadaX, coordenadaY);
		} catch (RemoteException e) {
			throw new GenericBusinessException(e);
		}
		return resultado;
	}

}
