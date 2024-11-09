package es.caib.avaedi.at4forms.common.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.UUID;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import es.caib.avaedi.logic.util.RuntimeServerHelper;
import es.caib.avaedi.logic.vo.BlobFormVO;


/**
 * @author agarcia
 * 
 */
public class ArchivoUtil {

	private static final String RUTA_CONFIG = "es.caib.avaedi.archivos.rutaArchivosEnFileSystem";
	private static Log log = LogFactory.getLog(ArchivoUtil.class);

	/**
	 * Exporta el BLOB asociado a un objeto de tipo Archivo al sistema de
	 * archivos.
	 * 
	 * @param archivo
	 * @throws IOException
	 */
	public static void exportaArchivoAFilesystem(BlobFormVO archivo) throws IOException {

		deleteArchivo(archivo); //Borramos el archivo anterior si existía
		
		if (archivo.getPath() == null) {
			String fileName = UUID.randomUUID().toString();
			archivo.setPath(fileName);
		}
		String path = obtenerRutaArchivoEnFilesystem(archivo);
		File f = new File(path );
		escribeArchivoAFilesystem(f, archivo.getDatos());

	}


	/**
	 * Lee los datos de un archivo que ya ha sido exportado al sistema de
	 * archivos.
	 * 
	 * @param archivo
	 * @return
	 * @throws IOException
	 */
	public static byte[] obtenerDatosArchivoEnFilesystem(BlobFormVO archivo) throws IOException {

		byte[] datos = null;

		InputStream in = new FileInputStream(obtenerRutaArchivoEnFilesystem(archivo));
		datos = IOUtils.toByteArray(in);
		in.close();

		return datos;

	}

	public static boolean existeArchivoEnFilesystem(BlobFormVO a) throws IOException {
		
		if (a == null)
			return false;

		String rutaArchivosEnFileSystem = obtenerRutaArchivoEnFilesystem(a);
		File f = new File(rutaArchivosEnFileSystem);

		return f.exists();

	}


	public static void borrarArchivo(BlobFormVO a) throws IOException {

		if (existeArchivoEnFilesystem(a)) {

			// El archivo a borrar.
			File f = new File(obtenerRutaArchivoEnFilesystem(a));

			try {

				f.delete();

			} catch (SecurityException e) {

				log.error(e);
				throw new IOException(e);

			}

		}

	}

	private static void escribeArchivoAFilesystem(File f, byte[] datos) throws IOException {

		if (datos != null) {

			InputStream in = new ByteArrayInputStream(datos);
			OutputStream out = new FileOutputStream(f);

			byte[] buf = new byte[1024];
			int len;

			while ((len = in.read(buf)) > 0) {
				out.write(buf, 0, len);
			}

			out.close();
			in.close();

		}

	}

	private static String obtenerRutaArchivosEnFileSystem() throws IOException {
		String rutaArchivosEnFileSystem = null;
		if (RuntimeServerHelper.getInstance().isJBoss()) {
			rutaArchivosEnFileSystem = System.getProperty(RUTA_CONFIG);
		} else {
			//NOTA: sólo para para entorno de desarrollo  
			Properties prop = new Properties();
			String propFileName = "application.properties";
			InputStream inputStream = ArchivoUtil.class.getClassLoader().getResourceAsStream(propFileName);
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
			rutaArchivosEnFileSystem = prop.getProperty(RUTA_CONFIG);
		}
		if (rutaArchivosEnFileSystem == null || rutaArchivosEnFileSystem.length() == 0) {
			throw new IOException("Falta configurar " + RUTA_CONFIG);
		}

		return rutaArchivosEnFileSystem;

	}
	
	

	public static String obtenerRutaArchivoEnFilesystem(BlobFormVO archivo) throws IOException {

		String rutaArchivosMicrosite = obtenerRutaArchivosEnFileSystem();
		checkDirArchivos(rutaArchivosMicrosite);

		// Ruta: [rutaArchivosMicrosites]/idArchivo
		return rutaArchivosMicrosite + File.separator + archivo.getPath();

	}


	private static void checkDirArchivos(String rutaArchivosEnFileSystem) throws IOException {

		File dirArchivos = new File(rutaArchivosEnFileSystem);

		if (!dirArchivos.exists()) {

			try {

				dirArchivos.mkdir();

			} catch (SecurityException e) {

				e.printStackTrace();
				throw new IOException("Error creando la ruta de archivos" + rutaArchivosEnFileSystem);

			}

		} else {

			if (!dirArchivos.isDirectory()) {
				throw new IOException("El archivo existe pero no es un directorio " + rutaArchivosEnFileSystem);
			}

		}

	}


	private static void deleteArchivo(BlobFormVO archivo) throws IOException {

		if (archivo != null && archivo.getPath() != null) {
			
			String rutaArchivo = obtenerRutaArchivoEnFilesystem(archivo);
			File fArchivo = new File(rutaArchivo);
	
			if (fArchivo.exists()) {
				fArchivo.delete();
			}
			
		}

	}


}
