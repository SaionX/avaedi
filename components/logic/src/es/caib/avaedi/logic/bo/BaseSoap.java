package es.caib.avaedi.logic.bo;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;

import es.caib.avaedi.at4forms.common.util.log.LogService;
import es.caib.avaedi.meh.OVCCallejero.CallejeroCatastroSoapProxy;
import es.caib.avaedi.meh.OVCCallejeroCodigo.CallejeroCodigosCatastroSoapProxy;
import es.caib.avaedi.meh.OVCCoordenadas.OVCCoordenadasSoapProxy;
import es.caib.avaedi.meh.catastro.CatastroSoapException;
import es.caib.avaedi.meh.catastro.ConsultaCallejero;
import es.caib.avaedi.meh.catastro.ConsultaCoord;
import es.caib.avaedi.meh.catastro.ConsultaDnp;
import es.caib.avaedi.meh.catastro.ConsultaMunicipieror;
import es.caib.avaedi.meh.catastro.ConsultaNumereror;
import es.caib.avaedi.meh.catastro.Err;
import es.caib.avaedi.meh.catastro.Lerr;

public class BaseSoap {

	protected static Logger log = LogService.getLogger(BaseSoap.class);
	protected static final String PROVINCIA = "ILLES BALEARS";
	protected static final String PROVINCIAID = "07";
	protected static final String SRS = "EPSG:25831";

	protected CallejeroCatastroSoapProxy catastroProxy = new CallejeroCatastroSoapProxy();
	protected CallejeroCodigosCatastroSoapProxy catastroCodigoProxy = new CallejeroCodigosCatastroSoapProxy();
	protected OVCCoordenadasSoapProxy coordenadasProxy = new OVCCoordenadasSoapProxy();

	protected void checkPeticion(ConsultaDnp resultadoSoap) throws CatastroSoapException {
		if (resultadoSoap.getLerr() != null) {
			this.checkPeticion(resultadoSoap.getLerr());
		}
	}

	protected void checkPeticion(ConsultaMunicipieror municipios) throws CatastroSoapException {
		if (municipios.getLerr() != null) {
			this.checkPeticion(municipios.getLerr());
		}
	}

	protected void checkPeticion(ConsultaCallejero callejero) throws CatastroSoapException {
		if (callejero.getLerr() != null) {
			this.checkPeticion(callejero.getLerr());
		}
	}

	protected void checkPeticion(ConsultaNumereror numerero) throws CatastroSoapException {
		if (numerero.getLerr() != null) {
			//this.checkPeticion(numerero.getLerr(), new String[]{"43"});
			this.checkPeticion(numerero.getLerr());
		}
	}

	protected void checkPeticion(ConsultaCoord coordenadas) throws CatastroSoapException {
		if (coordenadas.getLerr() != null) {
			this.checkPeticion(coordenadas.getLerr());
		}
	}

	private void checkPeticion(Lerr errs) throws CatastroSoapException {
		this.checkPeticion(errs, new String[0]);
	}

	private void checkPeticion(Lerr errs, String[] ignore) throws CatastroSoapException {
		List<String> ignorelist = Arrays.asList(ignore);
		for (Err err : errs.getErr()) {
			if(!(ignore != null && ignorelist.contains(err.getCod()))){
				int errCode = Integer.parseInt(err.getCod());
				throw new CatastroSoapException(errCode, err.getDes());
			}
		}

	}

}
