package es.caib.avaedi.logic.bo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import es.caib.avaedi.at4forms.common.exception.GenericBusinessException;
import es.caib.avaedi.logic.vo.EdificioFormVO;
import es.caib.avaedi.logic.vo.EdificioListadoVO;
import es.caib.avaedi.logic.vo.MunicipioFormVO;
import es.caib.avaedi.logic.vo.TipoViaFormVO;
import es.caib.avaedi.logic.vo.ViaFormVO;
import es.caib.avaedi.meh.catastro.Bico;
import es.caib.avaedi.meh.catastro.CatastroSoapException;
import es.caib.avaedi.meh.catastro.Df;
import es.caib.avaedi.meh.catastro.Lrcdnp;
import es.caib.avaedi.meh.catastro.Muni;
import es.caib.avaedi.meh.catastro.Rc;
import es.caib.avaedi.meh.catastro.Rcdnp;

@Repository("ImportadorCatastroBean")
public class ImportadorCatastroBean implements ImportadorCatastroBO {
	private String CREATOR_USER = "importador_soap";

	private static HashMap<String, String> tipos = ImportadorCatastroBean.getTipos();

	@Autowired
	@Qualifier("TestSoapBean")
	protected TestSoapBO testSoapBO;

	@Autowired
	@Qualifier("MunicipioBean")
	protected MunicipioBO municipioBO;

	@Autowired
	@Qualifier("ViaBean")
	protected ViaBO viaBO;

	@Autowired
	@Qualifier("TipoViaBean")
	protected TipoViaBO tipoViaBO;

	@Override
	public MunicipioFormVO municipioSoap2VO(Muni instance) {
		Date now = new Date();
		MunicipioFormVO ret = new MunicipioFormVO();

		ret.setNombre(instance.getNm());
		ret.setCodigoCatastro(Integer.parseInt(instance.getLocat().getCmc().toString()));
		ret.setCodigoIne(Integer.parseInt(instance.getLoine().getCm().toString()));
		ret.setIslaId(1);

		ret.setLastModified(now);
		ret.setDateCreation(now);
		ret.setCreatorUser(CREATOR_USER);
		ret.setModUser(CREATOR_USER);
		return ret;
	}

	@Override
	public EdificioFormVO bicoSoap2VO(Bico instance) {
		if (instance == null) {
			return null;
		}
		EdificioFormVO ret = new EdificioFormVO();
		Date antiguedad = null;
		XMLGregorianCalendar ant = instance.getBi().getDebi().getAnt();
		int year = 0;
		if (ant != null) {
			antiguedad = ant.toGregorianCalendar().getTime();
			Calendar antiguedadC = Calendar.getInstance();
			antiguedadC.setTime(antiguedad);
			year = antiguedadC.get(Calendar.YEAR);
		}

		ret.setAntiguedad(year);
		//ret.setNumeroCatastro(numeroCatastro);
		ret.setReferenciaCatastral(instance.getBi().getIdbi().getRc().getPc1() + instance.getBi().getIdbi().getRc().getPc2());
		ret.setCentroX(new BigDecimal(470710.27));
		ret.setCentroY(new BigDecimal(4380395.56));
		return ret;
	}

	@Override
	public String importarMunicipios() throws GenericBusinessException, CatastroSoapException {
		String info = "";
		List<Muni> municipios = testSoapBO.getMunicipios("ILLES BALEARS");
		for (Muni municipioRaw : municipios) {
			MunicipioFormVO municipio = municipioSoap2VO(municipioRaw);
			try {

				if (this.municipioBO.findByNombre(municipio.getNombre()) == null) {
					municipioBO.add(municipio);
					info += "Añadido municipio: " + municipio.getNombre() + " . ";
				} else {
					info += "Municipio con nombre " + municipio.getNombre() + " ya existe. ";
				}

			} catch (GenericBusinessException e) {
				info += "error añadiendo municipio. " + municipio.getNombre() + " . ";
				e.printStackTrace();
			}
		}

		return info;
	}

	@Override
	public String importarVias(String municipioS) throws GenericBusinessException, CatastroSoapException {
		String info = "";
		Date now = new Date();
		String user = "importador";
		MunicipioFormVO municipio = municipioBO.findByNombre(municipioS);
		//MunicipioFormVO municipio = null;
		if (municipio == null) {
			return "No existe este municipio en la bdd";
		}
		List<Df> calles = testSoapBO.getCalles(municipioS, "", "");
		for (Df calleS : calles) {
			ViaFormVO via = new ViaFormVO();
			via.setCodigoCatastro(Integer.parseInt(calleS.getDir().getCv()));
			via.setNombre(calleS.getDir().getNv());

			String codigoCatastroVia = calleS.getDir().getTv();

			TipoViaFormVO tipoVia = tipoViaBO.findByCodigoCatastro(codigoCatastroVia);
			if (tipoVia == null) {
				TipoViaFormVO newTipoVia = new TipoViaFormVO();
				String nombre = tipos.get(codigoCatastroVia);
				if (nombre == null) {
					nombre = codigoCatastroVia;
				}
				newTipoVia.setNombreEs(nombre);
				newTipoVia.setCodigoCatastro(codigoCatastroVia);
				newTipoVia.setDateCreation(now);
				newTipoVia.setModUser(user);
				newTipoVia.setLastModified(now);
				newTipoVia.setCreatorUser(user);
				tipoVia = tipoViaBO.add(newTipoVia);
			}
			via.setTipoViaId(tipoVia.getClave());
			via.setMunicipioId(municipio.getClave());
			via.setDateCreation(now);
			via.setModUser(user);
			via.setLastModified(now);
			via.setCreatorUser(user);

			//if (viaBO.findViaDeMunicipio(via.getCodigoCatastro(), municipio.getClave()) == null && viaBO.findViaDeMunicipioNombre(via.getNombre(), municipio.getClave()) == null){
			if (viaBO.findViaDuplicada(via.getNombre(), via.getMunicipioId(), via.getTipoViaId()) == null) {
				viaBO.add(via);
			} else {
				info += "Via " + via.getNombre() + " ya existe.";
			}
		}
		return info;
	}

	@Override
	public List<EdificioListadoVO> lrcdnpSoap2VO(Lrcdnp instance) {
		if (instance == null) {
			return null;
		}
		List<EdificioListadoVO> ret = new ArrayList<EdificioListadoVO>();

		for (Rcdnp edi : instance.getRcdnp()) {
			EdificioListadoVO edificio = new EdificioListadoVO();
			Rc rc = edi.getRc();
			edificio.setReferenciaCatastral(rc.getPc1() + rc.getPc2());

		}
		/*
		 * Date antiguedad = null; instance.getRcdnp() XMLGregorianCalendar ant
		 * = instance.getBi().getDebi().getAnt(); int year = 0; if(ant != null){
		 * antiguedad = ant.toGregorianCalendar().getTime(); Calendar
		 * antiguedadC = Calendar.getInstance();
		 * antiguedadC.setTime(antiguedad); year =
		 * antiguedadC.get(Calendar.YEAR); }
		 */

		//ret.setAntiguedad(year);
		//ret.setNumeroCatastro(numeroCatastro);
		//ret.setCentroX(centroX);
		//ret.setCentroY(centroY);
		return ret;
	}

	private static HashMap<String, String> getTipos() {
		HashMap<String, String> tipos = new HashMap<String, String>();
		tipos.put("AC", "Acceso");
		tipos.put("AG", "Agregado");
		tipos.put("AL", "Aldea, alameda");
		tipos.put("AN", "Andador");
		tipos.put("AR", "Area, arrabal");
		tipos.put("AU", "Autopista");
		tipos.put("AV", "Avenida");
		tipos.put("AY", "Arroyo");
		tipos.put("BJ", "Bajada");
		tipos.put("BL", "Bloque");
		tipos.put("BO", "Barrio");
		tipos.put("BQ", "Barranquil");
		tipos.put("BR", "Barranco");
		tipos.put("CA", "Cañada");
		tipos.put("CG", "Colegio, cigarral");
		tipos.put("CH", "Chalet");
		tipos.put("CI", "Cinturon");
		tipos.put("CJ", "Calleja, callejon");
		tipos.put("CL", "Calle");
		tipos.put("CM", "Camino, carmen");
		tipos.put("CN", "Colonia");
		tipos.put("CO", "Concejo, colegio");
		tipos.put("CP", "Campa, campo");
		tipos.put("CR", "Carretera, carrera");
		tipos.put("CS", "Caserio");
		tipos.put("CT", "Cuesta, costanilla");
		tipos.put("CU", "Conjunto");
		tipos.put("CY", "Caleya");
		tipos.put("CZ", "Callizo");
		tipos.put("DE", "Detrás");
		tipos.put("DP", "Diputacion");
		tipos.put("DS", "Diseminados");
		tipos.put("ED", "Edificios");
		tipos.put("EM", "Extramuros");
		tipos.put("EN", "Entrada, ensanche");
		tipos.put("EP", "Espalda");
		tipos.put("ER", "Extrarradio");
		tipos.put("ES", "Escalinata");
		tipos.put("EX", "Explanada");
		tipos.put("FC", "Ferrocarril");
		tipos.put("FN", "Finca");
		tipos.put("GL", "Glorieta");
		tipos.put("GR", "Grupo");
		tipos.put("GV", "Gran via");
		tipos.put("HT", "Huerta, huerto");
		tipos.put("JR", "Jardines");
		tipos.put("LA", "Lago");
		tipos.put("LD", "Lado, ladera");
		tipos.put("LG", "Lugar");
		tipos.put("MA", "Malecon");
		tipos.put("MC", "Mercado");
		tipos.put("ML", "Muelle");
		tipos.put("MN", "Municipio");
		tipos.put("MS", "Masias");
		tipos.put("MT", "Monte");
		tipos.put("MZ", "Manzana");
		tipos.put("PB", "Poblado");
		tipos.put("PC", "Placeta");
		tipos.put("PD", "Partida");
		tipos.put("PI", "Particular");
		tipos.put("PJ", "Pasaje, pasadizo");
		tipos.put("PL", "Poligono");
		tipos.put("PM", "Paramo");
		tipos.put("PQ", "Parroquia, parque");
		tipos.put("PR", "Prolongacion, continuac.");
		tipos.put("PS", "Paseo");
		tipos.put("PT", "Puente");
		tipos.put("PU", "Pasadizo");
		tipos.put("PZ", "Plaza");
		tipos.put("QT", "Quinta");
		tipos.put("RA", "Raconada");
		tipos.put("RB", "Rambla");
		tipos.put("RC", "Rincon, rincona");
		tipos.put("RD", "Ronda");
		tipos.put("RM", "Ramal");
		tipos.put("RP", "Rampa");
		tipos.put("RR", "Riera");
		tipos.put("RU", "Rua");
		tipos.put("SA", "Salida");
		tipos.put("SC", "Sector");
		tipos.put("SD", "Senda");
		tipos.put("SL", "Solar");
		tipos.put("SN", "Salon");
		tipos.put("SU", "Subida");
		tipos.put("TN", "Terrenos");
		tipos.put("TO", "Torrente");
		tipos.put("TR", "Travesia");
		tipos.put("UR", "Urbanizacion");
		tipos.put("VA", "Valle");
		tipos.put("VD", "Viaducto");
		tipos.put("VI", "Via");
		tipos.put("VL", "Vial");
		tipos.put("VR", "Vereda");
		return tipos;
	}

}
