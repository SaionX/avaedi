package es.caib.avaedi.front.server;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.fasterxml.jackson.databind.ObjectMapper;

import es.caib.avaedi.at4forms.common.exception.GenericBusinessException;
import es.caib.avaedi.at4forms.common.util.log.LogService;
import es.caib.avaedi.at4forms.front.controller.DocumentDownload;
import es.caib.avaedi.at4forms.front.service.MessageService;
import es.caib.avaedi.front.server.service.RestService;
import es.caib.avaedi.front.server.validator.ValidableField;
import es.caib.avaedi.front.server.validator.ValidatorResult;
import es.caib.avaedi.logic.bo.BlobBO;
import es.caib.avaedi.logic.server.vo.RestBaseVO;
import es.caib.avaedi.logic.vo.BlobFormVO;

public class BaseRestService extends MessageService {
	/**
	 * Objeto Log
	 */

	protected static Logger log = LogService.getLogger(RestService.class);

	private static ObjectMapper mapper = new ObjectMapper();;

	@Autowired
	@Qualifier("BlobBean")
	protected BlobBO blobBO;

	/**
	 * Utiliza la fecha de modificacion y la primary key de un objeto que
	 * extenda de BaseVo y devuelve un hash md5 de todos los elementos de la
	 * lista
	 * 
	 * @param lista
	 *            lista que se iterara para coger los valores
	 * @return hash en MD5 de los valores
	 */
	protected String hashList(Collection<? extends RestBaseVO> lista) {
		String hash = "";
		StringBuilder sb = new StringBuilder(hash);

		for (RestBaseVO obj : lista) {
			sb.append(obj.getLastModified().getTime());
			sb.append(obj.getPrimaryKey());
		}
		hash = sb.toString();
		hash = DigestUtils.md5Hex(hash);
		return hash;

	}

	protected ObjectMapper getMapper() {
		return BaseRestService.mapper;
	}

	/*
	 * @OPTIONS
	 * 
	 * @Path("/v1/*") public Response options() { return Response.ok("")
	 * .header("Access-Control-Allow-Origin", "*")
	 * .header("Access-Control-Allow-Headers",
	 * "origin, content-type, accept, authorization")
	 * .header("Access-Control-Allow-Credentials", "true")
	 * .header("Access-Control-Allow-Methods",
	 * "GET, POST, PUT, DELETE, OPTIONS, HEAD")
	 * .header("Access-Control-Max-Age", "1209600") .header("x-frame-options",
	 * "SAMEORIGIN") .build(); }
	 * 
	 * @OPTIONS
	 * 
	 * @Path("v1") public Response optionsAll() { return Response.ok("")
	 * .header("Access-Control-Allow-Origin", "*")
	 * .header("Access-Control-Allow-Headers",
	 * "origin, content-type, accept, authorization")
	 * .header("Access-Control-Allow-Credentials", "true")
	 * .header("Access-Control-Allow-Methods",
	 * "GET, POST, PUT, DELETE, OPTIONS, HEAD")
	 * .header("Access-Control-Max-Age", "1209600") .header("x-frame-options",
	 * "SAMEORIGIN") .build(); }
	 */

	/**
	 * Recoge un objeto de uriInfo y devuelve una string con la ruta y los
	 * parametros del get ordenados y concatenados
	 * 
	 * @param uriInfo
	 * 
	 * @return Un string del GET con los parametros ordenados
	 * @author garrom@at4.net
	 */
	protected String buildUri(UriInfo uriInfo) {
		MultivaluedMap<String, String> params = uriInfo.getQueryParameters();
		Set<String> keys = params.keySet();
		String[] keysArray = keys.toArray(new String[keys.size()]);
		Arrays.sort(keysArray);
		String uri = uriInfo.getPath();
		StringBuilder sb = new StringBuilder(uri);
		for (String i : keysArray) {
			sb.append(i);
			sb.append(params.get(i));
		}
		return sb.toString();
	}

	/**
	 * Devuelve los datos de una uri concatenados con "otherData" hasheado en
	 * MD5
	 * 
	 * @param uriInfo
	 *            Para recoger los valores del uri
	 * @param otherData
	 *            Informacion adicional a meter al hash
	 * @return String con el hash md5
	 * @author garrom@at4.net
	 */
	protected String buildEtag(UriInfo uriInfo, String otherData) {
		String uri = this.buildUri(uriInfo);
		uri = uri + otherData;
		uri = DigestUtils.md5Hex(uri);
		return uri;
	}

	/**
	 * Copiado de eCongres. Obtener imagen de un producto
	 * 
	 * @param idProducto
	 *            ID de la producto (req)
	 * @param idImagen
	 *            ID de la imagen (req)
	 * 
	 * @return Objeto con informacion sobre la imagen
	 * @throws GenericBusinessException
	 */
	protected DocumentDownload obtenerImagen(int primaryKey, int idImagen, String mime) throws GenericBusinessException {

		DocumentDownload ret = null;

		/*
		 * FotoProductoFormVO instance = this.fotoproductoBO.load(idImagen);
		 * Long referenciaImagen = null; Serializable instancePK = null; if
		 * (instance == null) { referenciaImagen = (long) idImagen; instancePK =
		 * primaryKey; } else { referenciaImagen = instance.getFoto();
		 * instancePK = instance.getProductoId(); mime = instance.getFotoMime();
		 * if (instance != null && instancePK != null) { //Es foto de producto
		 * if (!instancePK.equals(primaryKey)) {
		 * log.error("Petición incorrecta: la imagen " + idImagen +
		 * " no existe o no pertecene al objeto " + primaryKey +
		 * ", pertenece al " + instancePK); throw new
		 * WebApplicationException(404); } } }
		 * 
		 * 
		 * 
		 * if (referenciaImagen == null) { throw new
		 * WebApplicationException(503); } BlobFormVO archivo =
		 * this.blobBO.load(referenciaImagen); if (archivo != null) { ret = new
		 * DocumentDownload(); ret.setData(archivo.getData());
		 * ret.setMime(mime); ret.setFilename("imagenProducto_" + instancePK +
		 * "_" + archivo.getClave()); }
		 */

		return ret;
	}

	/**
	 * @return Obtenemos información de la imagen mediante Long y String
	 * @throws GenericBusinessException
	 */
	protected DocumentDownload obtenerImagenEspecifica(Long code, String mime) throws GenericBusinessException {
		DocumentDownload ret = null;
		if (code == null) {
			log.error("No obtiene la imagen");
			throw new WebApplicationException(404);
		}
		BlobFormVO archivo = this.blobBO.load(code);
		if (archivo != null) {
			ret = new DocumentDownload();
			ret.setData(archivo.getDatos());
			ret.setMime(mime);
			ret.setFilename("imagenEspecifica_" + code + "_" + archivo.getClave());
		}

		return ret;
	}

	/**
	 * Metodo encargado de validar las peticiones REST (POST).
	 * 
	 * @param valorString
	 *            Valor para la validación de un String
	 * @param id
	 *            nombre de la tabla para tratarla dentro del metodo
	 * @throws GenericBusinessException
	 */
	protected String validarString(String valorString, String id) throws GenericBusinessException {
		//Comprobacion para Nombre, Apellidos que no sean NULL
		//log.error(id);
		if (id == "nombre" || id == "apellidos") {
			if (valorString.equals("") || valorString.equals(null) || valorString == null) {
				String error = "El Nombre,Apellido no puede ser null";
				log.error(error);
				return error;
			}
			if (!valorString.matches("^[a-zA-Z0-9].{2,62}.$")) {
				String error = "Nombre/Apellido incorrecto";
				log.error(error);
				return error;
			}
		}
		//Validacion para Direccion,Población,Observaciones
		if (id == "direccion" || id == "poblacion") {
			if ((!valorString.equals(""))) {
				if (!valorString.matches("^[a-zA-Z0-9].{2,62}.$")) {
					String error = "Direccion/Poblacion/Observaciones incorrecta";
					log.error(error);
					return error;
				}
			}

		}
		//Validacion para CP
		if (id == "cp" && (!valorString.equals(""))) {
			if (!valorString.matches("[0-9]{5}")) {
				String error = "El CP tiene unos valores distintos a 5 digitos";
				log.error(error);
				return error;
			}
		}
		//Validacion Telefono
		if (id == "telefono" && (!valorString.equals(""))) {
			if (!valorString.matches("[0-9]{9}")) {
				String error = "El Telefono tiene valor distinto a 9 digitos";
				log.error(error);
				return error;
			}
		}
		//Validacion Email
		if (id == "email" && (!valorString.equals(""))) {
			if (!valorString.matches("^(([a-zA-Z]|[0-9])|([-]|[_]|[.]))+[@](([a-zA-Z0-9])|([-])){2,63}[.](([a-zA-Z0-9]){2,3})")) {
				String error = "Email incorrecto";
				log.error(error);
				return error;
			}
		}
		//Validacion Token, Id del dispositivo
		if (id == "token" || id == "id") {
			if (valorString.equals("") || valorString.equals(" ") || valorString.equals(null) || valorString == null) {
				String error = "El Token/ID no puede ser null";
				log.error(error);
				return error;
			}
		}
		//Validacion tipo dispositivo
		if (id == "tipo") {
			if (!valorString.matches("android")) {
				if (!valorString.matches("ios")) {
					String error = "El tipo de dispositivo tiene que ser ios o android";
					log.error(error);
					return error;
				}
			}
		}
		throw new GenericBusinessException("No hay configuracion de validacion para el campo: " + id);
	}

	protected ValidatorResult validateFields(ArrayList<ValidableField> fields) {
		StringBuilder error = new StringBuilder();
		boolean hasErrors = false;
		for (ValidableField field : fields) {
			if (!field.isValid()) {
				hasErrors = true;
				error.append(field.getErrors());
			}
		}
		return new ValidatorResult(hasErrors, error.toString());
	}

}
