package es.caib.avaedi.front.server.service;

import io.swagger.annotations.Api;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import es.caib.avaedi.at4forms.common.exception.GenericBusinessException;
import es.caib.avaedi.front.server.BaseRestService;
import es.caib.avaedi.front.server.RestServiceException;
import es.caib.avaedi.iee.model.InspeccionType;
import es.caib.avaedi.logic.bo.DatosCatastroBO;
import es.caib.avaedi.logic.bo.ImportadorCatastroBO;
import es.caib.avaedi.logic.bo.TestSoapBO;
import es.caib.avaedi.logic.util.At4Utilities;
import es.caib.avaedi.meh.catastro.Bico;
import es.caib.avaedi.meh.catastro.CatastroSoapException;
import es.caib.avaedi.meh.catastro.Df;
import es.caib.avaedi.meh.catastro.Muni;
import es.caib.avaedi.meh.catastro.www.Consulta_Coordenadas;

/**
 * Servicio rest de test
 * 
 * @author garrom@at4.net
 * 
 */

@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
@Path("/test")
@Component
@Api
public class RestTestService extends BaseRestService {

	protected TestSoapBO datosSoapBO;
	protected ImportadorCatastroBO importadorCatastroBo;
	protected DatosCatastroBO datosCatastroBO;

	@Context
    public void setServletContext(ServletContext context) {
		WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(context);
		importadorCatastroBo = (ImportadorCatastroBO) applicationContext.getBean("ImportadorCatastroBean");
		datosSoapBO = (TestSoapBO) applicationContext.getBean("TestSoapBean");
		datosCatastroBO = (DatosCatastroBO) applicationContext.getBean("DatosCatastroBean");
    }	
	
	
	@GET
	@Path("importacionMunicipios")
	public Response getTestImportacionMunicipios(@QueryParam("provincia") String provincia) throws GenericBusinessException {
		String result;
		try {
			result = importadorCatastroBo.importarMunicipios();
		} catch (CatastroSoapException e) {
			throw new RestServiceException(e.getCode(), e.getMsg());
		}
		return Response.ok(result).build();
	}

	@GET
	@Path("importacionVias")
	public Response getTestImportacionVias(@QueryParam("municipio") String municipio) throws GenericBusinessException {
		String result;
		try {
			result = importadorCatastroBo.importarVias(municipio);
		} catch (CatastroSoapException e) {
			throw new RestServiceException(e.getCode(), e.getMsg());
		}
		return Response.ok(result).build();
	}

	@GET
	@Path("municipios")
	public Response getTestMunicipios(@QueryParam("provincia") String provincia) throws GenericBusinessException {
		if (provincia == null) {
			provincia = "";
		}
		List<Muni> result;
		try {
			result = datosSoapBO.getMunicipios(provincia);
		} catch (CatastroSoapException e) {
			throw new RestServiceException(e.getCode(), e.getMsg());
		}
		return Response.ok(result).build();
	}

	@GET
	@Path("calles")
	public Response getTestCalles(@QueryParam("municipio") String municipio, @QueryParam("tipoVia") String tipoVia, @QueryParam("nombreVia") String nombreVia) throws GenericBusinessException {
		if (municipio == null) {
			municipio = "";
		}
		if (tipoVia == null) {
			tipoVia = "";
		}
		if (nombreVia == null) {
			nombreVia = "";
		}

		List<Df> result;
		try {
			result = datosSoapBO.getCalles(municipio, tipoVia, nombreVia);
		} catch (CatastroSoapException e) {
			throw new RestServiceException(e.getCode(), e.getMsg());
		}
		return Response.ok(result).build();
	}

	@GET
	@Path("consulta")
	public Response getTestConsulta(@QueryParam("municipio") String municipio, @QueryParam("numero") String numero, @QueryParam("tipoVia") String tipoVia, @QueryParam("nombreVia") String nombreVia) throws GenericBusinessException {
		if (municipio == null) {
			municipio = "";
		}
		if (tipoVia == null) {
			tipoVia = "";
		}
		if (nombreVia == null) {
			nombreVia = "";
		}

		Bico result;
		try {
			result = datosSoapBO.getConsulta(null, municipio, "", nombreVia, numero, "", "", "", "");
		} catch (CatastroSoapException e) {
			throw new RestServiceException(e.getCode(), e.getMsg());
		}
		return Response.ok(result).build();
	}

	final int BUFFER = 2048;

	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("testReadIEE")
	public Response postTestIee(@FormDataParam("file") InputStream fileInputStream, @FormDataParam("file") FormDataContentDisposition contentDispositionHeader) throws GenericBusinessException, IOException {
		/*
		 * String xmlraw = null; boolean archiveFound = false; Exception ex =
		 * null;
		 * 
		 * try { InputStream fis = fileInputStream; ZipArchiveInputStream zis =
		 * new ZipArchiveInputStream(new BufferedInputStream(fis)); ArchiveEntry
		 * entry; while ((entry = zis.getNextEntry()) != null) { if
		 * ("iee.xml".equals(entry.getName())) { xmlraw =
		 * At4Utilities.inputStreamToString(zis); archiveFound = true; } }
		 * zis.close(); } catch (Exception e) { e.printStackTrace(); ex = e; }
		 * 
		 * if (!archiveFound || ex != null) { throw new
		 * RestServiceException(406,
		 * "El archivo enviado no es un archivo .iee correcto."); }
		 * InspeccionType xmlparsed = new InspeccionType();
		 * 
		 * try { JAXBContext context =
		 * JAXBContext.newInstance(InspeccionType.class); Unmarshaller
		 * unmarshaller = context.createUnmarshaller(); StringReader xmlReader =
		 * new StringReader(xmlraw);
		 * 
		 * xmlparsed = (InspeccionType) unmarshaller.unmarshal(xmlReader);
		 * 
		 * } catch (JAXBException e) { throw new RestServiceException(500,
		 * "Error en el tratado de los datos de iee"); }
		 */
		return Response.ok("Commented method").build();
	}

	@GET
	@Path("testParseXml")
	public Response getTestParseXml() throws JAXBException, IOException {
		StringBuilder result = new StringBuilder();
		Calendar cal = Calendar.getInstance();

		String menudefinitionFile = "resources/iee.xml";

		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		InputStream inStream = loader.getResourceAsStream(menudefinitionFile);

		String xmlraw = At4Utilities.inputStreamToString(inStream);

		JAXBContext dnpppContext = JAXBContext.newInstance(InspeccionType.class);
		Unmarshaller dnpppUn = dnpppContext.createUnmarshaller();
		StringReader dnpppReader = new StringReader(xmlraw);

		InspeccionType xmlparsed = new InspeccionType();
		try {
			xmlparsed = (InspeccionType) dnpppUn.unmarshal(dnpppReader);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return Response.ok(xmlparsed.toString()).build();
	}

	@GET
	@Path("testGeoloc")
	public Response getTestGeoLoc(@QueryParam("cx") String coordenadaX, @QueryParam("cy") String coordenadaY) throws GenericBusinessException{
		Consulta_Coordenadas result = datosCatastroBO.getReferenciasByLoc(coordenadaX, coordenadaY);
		return Response.ok(result).build();
		
	}
	// save uploaded file to new location
	private void writeToFile(InputStream uploadedInputStream, String uploadedFileLocation) {

		try {
			OutputStream out = new FileOutputStream(new File(uploadedFileLocation));
			int read = 0;
			byte[] bytes = new byte[1024];

			out = new FileOutputStream(new File(uploadedFileLocation));
			while ((read = uploadedInputStream.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
