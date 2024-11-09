package es.caib.avaedi.at4forms.front.util;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import org.directwebremoting.io.FileTransfer;
import org.imgscalr.Scalr;
import org.imgscalr.Scalr.Method;
import org.imgscalr.Scalr.Mode;
import org.slf4j.Logger;

import es.caib.avaedi.at4forms.common.util.log.LogService;
import es.caib.avaedi.at4forms.front.service.DefaultBaseService;


public class ImageUtil {

	/**
	 * The logger object.
	 */
	private static Logger log = LogService.getLogger(ImageUtil.class);

	public static final Map<String, String> MIME_TYPES = new HashMap<String, String>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		{
		put("html" , "text/html");
	    put("txt" , "text/plain");
	    put("gif" , "image/gif");
	    put("jpg" , "image/jpeg");
	    put("png" , "image/png");
	    put("ico" , "image/x-icon");
	    put("avi" , "video/x-msvideo");
	    put("mov" , "video/quicktime");
	    put("swf" , "application/x-shockwave-flash");
	    put("mp3" , "audio/mpeg3");
	    put("mpg" , "video/mpeg ");
	    put("mid" , "audio/midi");
	    put("js" , "application/x-javascript");
	    put("css" , "text/css");
	    put("xml" , "text/xml");
	    put("xsl" , "text/xml");
	    put("xslt" , "application/xsl-xml");
	    put("doc" , "application/msword");
	    put("pdf" , "application/pdf");
	    put("zip" , "application/zip");
	    put("xls" , "application/vnd.ms-excel");
	    put("ppt" , "application/vnd.ms-powerpoint");
	    put("tex" , "application/x-tex");
	    put("sxw" , "application/vnd.sun.xml.writer");
	    put("odt" , "application/vnd.oasis.opendocument.text");
	    put("rar" , "application/x-rar");
	    put("tar" , "application/x-tar");
	    put("tgz" , "application/x-gzip-compressed");
	    put("gz" , "application/x-gzip");
		put("docx", "application/vnd.openxmlformats-officedocument.wordprocessingml.document");
		put("rtf", "text/rtf");
		put("ogg", "audio/ogg");
		put("ogv", "video/ogg");
		put("docx", "application/vnd.openxmlformats-officedocument.wordprocessingml.document");
		put("rtf", "text/rtf");
		put("ogg", "audio/ogg");
		put("ogv", "video/ogg");		
		}
	};

	private static short sum(short image_contents){
        if (image_contents < 0){
            image_contents = (short)(image_contents + (short)256);
        }
        return image_contents;
    }

    private static short[] getPositiveShort(short[] array){
        for (int t=0;t<array.length;t++){
            if (array[t]<0){
                //Haz la marcara
                array[t] = (short)(array[t] & 0xFF);
            }
        }
        return array;
    }
	
    public static class ImageSize {
        public static final int GIF = 1;
		public static final int JPEG = 2;
		public static final int PNG = 3;
		/**
		 * Shockwave flash
		 */
		public static final int FWS = 4;
		/**
		 * Compressed Shockwave flash
		 */
		public static final int CWS = 13;
    	
    	public int type;
    	public String mime;
    	public int x;
    	public int y;
    	
    }
    
    
    /**
     * Devuelve las características de una imagen
     * @param image_content
     * @return
     */
    public static ImageSize getImageSize(byte image_content[]){

    	int headerLenght = Math.min(image_content.length, 10);
    	byte[] headerAr = new byte[headerLenght];
    	for (int i = 0; i < headerLenght; i++) {
    		headerAr[i] = image_content[i];

    	}
    	String header = new String (headerAr);

    	ImageSize size = new ImageSize();
        if (header.substring(0,3).equals("GIF")){
            size.type = ImageSize.GIF;
            size.mime = "image/gif";
            //width
            size.x = sum(image_content[6])+256*sum(image_content[7]);
            //heigth
            size.y = sum(image_content[8])+256*sum(image_content[9]);
        }
        else if (header.substring(6,10).equals("JFIF") || header.substring(6,10).equals("Exif")){
            ReadJPG jpg = new ReadJPG();
            //Creo una copia de image_content
            short[] image_jpg = new short[image_content.length];
            for (int y=0;y<image_content.length;y++){
                image_jpg [y] = image_content [y];
            }

            //Creo una copia de image_content
            jpg.setImageContent(getPositiveShort(image_jpg));
            int[] jpgSize = jpg.getJPGSize();
        	size.type = ImageSize.JPEG;
            size.mime = "image/jpeg";
            size.x = jpgSize[0];
            size.y = jpgSize[1];
        }
        else if (header.substring(1,4).equals("PNG")){
        	size.type = ImageSize.PNG;
            size.mime = "image/png";
            size.x = sum(image_content[19])+256*sum(image_content[18])+512*sum(image_content[17])+1024*sum(image_content[16]);
            size.y = sum(image_content[23])+256*sum(image_content[22])+512*sum(image_content[21])+1024*sum(image_content[20]);
        }
        else if (header.substring(0,3).equals("FWS")){
        	//shockwafe flash
            SWFReader swfReader = new SWFReader( image_content );
        	size.type = ImageSize.FWS;
            size.mime = "application/x-shockwave-flash";
            size.x = swfReader.getWidth();
            size.y = swfReader.getHeight();
        }
        else if (header.substring(0,3).equals("CWS")){
        	//compressed shockwafe flash
            SWFReader swfReader = new SWFReader( image_content );
            size.type = ImageSize.CWS;
            size.mime = "application/x-shockwave-flash";
            size.x = swfReader.getWidth();
            size.y = swfReader.getHeight();
        }

        return size;
    }

    public static byte[] resizeToconstraints(byte[] image, ImageSize originalSize, ImageConstraints constraints) throws IOException {
		
		if (validateImageSize(originalSize.x, originalSize.y, constraints) != ImageConstraints.INVALID) {
			return image; //Nada que hacer
		} else {
			int x, y;
			if (constraints.xRecommendedMandatory) {
				x = constraints.xRecommended;
			} else if (constraints.xMaxMandatory) {
				x = constraints.xMax; 
			/* En principio, si estamos redimensionando es pq ha fallado un constraint mandatorio. No tenemos en cuenta los recomendados
			} else if (constraints.xRecommended > 0) {
				x = constraints.xRecommended;
			} else if (constraints.xMax > 0) {
				x = constraints.xMax;
			*/
			} else {
				x = 0;
			}

			if (constraints.yRecommendedMandatory) {
				y = constraints.yRecommended;
			} else if (constraints.yMaxMandatory) {
				y = constraints.yMax; 
			/* En principio, si estamos redimensionando es pq ha fallado un constraint mandatorio. No tenemos en cuenta los recomendados
			} else if (constraints.yRecommended > 0) {
				y = constraints.yRecommended;
			} else if (constraints.yMax > 0) {
				y = constraints.yMax;
			*/
			} else {
				y = 0;
			}
			
			if (x == 0 && y == 0) {
				throw new IllegalArgumentException("Error en los constraints al ejecutar resizeToconstraints (x == 0 && y == 0)");
			} else if (y == 0) {
				y = originalSize.y * x/originalSize.x; //Fijamos y proporcionalmente a x
			} else if (x == 0) {
				x = originalSize.x * y/originalSize.y; //Fijamos x proporcionalmente a y
			}

			if (originalSize.y < y || originalSize.x < x) {
				//No podemos adecuar una imagen menor que el objetivo final
				return image;
			}
			
			//Cargamos la imagen original 
			InputStream in = new ByteArrayInputStream(image);
			BufferedImage bufImage = ImageIO.read(in); 			
			
			//Vamos a ver si es necesario hacer un crop
			double ratioObjetivo = (double)x / (double)y;
			double ratioOriginal = (double)originalSize.x / (double)originalSize.y;

			log.debug("ratioObjetivo " + ratioObjetivo+ " , ratioOriginal " + ratioOriginal);
			
			if (ratioObjetivo != ratioOriginal) {
				//Tenemos que hacer un crop a la mayor imagen que cumpla el mismo ratio
			
				if (ratioOriginal > ratioObjetivo) {
					
					//La imagen original es más apaisada que la imagen objetivo, hay que quitar ancho para solucionarlo
					//La fórmula sale de: ratioObjetivo = x' / OriginalY (mantenemos constante la y, variamos la x)
					int xp = (int)((double)ratioObjetivo * (double)originalSize.y); 
					int left = (originalSize.x - xp) / 2; //Centramos el recorte
					bufImage = Scalr.crop(bufImage, left , 0, xp, originalSize.y);
					log.debug("croped X to " + xp  + " , " + originalSize.y);
					
				} else {
					
					//La imagen original es más alta que la imagen objetivo, hay que quitar alto para solucionarlo
					//La fórmula sale de: ratioObjetivo = OriginalX / y' (mantenemos constante la x, calculamos la nueva y)
					int yp = (int)(originalSize.x / ratioObjetivo);
					int top = (originalSize.y - yp) / 2; //Centramos el recorte
					bufImage = Scalr.crop(bufImage, 0, top , originalSize.x, yp);
					log.debug("croped Y to " + originalSize.x  + " , " + yp);

				}
				
			}
			
			// Finalmente redimensionamos al objetivo
			bufImage = Scalr.resize(bufImage, Method.QUALITY, Mode.AUTOMATIC, x, y);
			
			return getImageBytes(bufImage, originalSize);
			
		}
		
	}
	
	private static byte[] getImageBytes(BufferedImage bufImage, ImageSize originalSize) throws IOException {

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		if (originalSize.type == ImageSize.GIF) {
			ImageIO.write( bufImage, "gif", baos );
		} else if (originalSize.type == ImageSize.JPEG) {
			ImageIO.write( bufImage, "jpg", baos );
		} else if (originalSize.type == ImageSize.PNG) {
			ImageIO.write( bufImage, "png", baos );
		} else {
			throw new IOException("No se cómo convertir el tipo " + originalSize.type);
		}

		baos.flush();
		return baos.toByteArray();

		/*
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write( bufImage, "jpg", baos );
		baos.flush();
		byte[] imageInByte = baos.toByteArray();
		*/
		/* Este método parece que no funciona
		//bufImage.getData().getDataBuffer().getDataType() == 
		//byte[] imageBytes = ((DataBufferByte) bufImage.getData().getDataBuffer()).getData();
		DataBuffer dataBuffer = bufImage.getData().getDataBuffer();
		if (dataBuffer.getDataType() == DataBuffer.TYPE_BYTE ) {
			return ((DataBufferByte) dataBuffer).getData();
		} else if (dataBuffer.getDataType() == DataBuffer.TYPE_INT) {
			int[] ints = ((DataBufferInt)dataBuffer).getData();
			byte[] datas = new byte[ints.length];
			for (int i=0; i<ints.length; i++){
				datas[i] = Byte.valueOf(datas[i]);
			}
			return datas;
		} else if (dataBuffer.getDataType() == DataBuffer.TYPE_USHORT) {
			short[] ints = ((DataBufferUShort)dataBuffer).getData();
			byte[] datas = new byte[ints.length];
			for (int i=0; i<ints.length; i++){
				datas[i] = Byte.valueOf(datas[i]);
			}
			return datas;
		} else {
			throw new IOException("No se cómo convertir el tipo " + dataBuffer.getDataType());
		}
		*/

	}

	

	
	
	/**
	 * 
	 * @param xsended
	 * @param ysended
	 * @param constraints
	 * @return
	 */
    public static int validateImageSize(int xsended, int ysended, ImageConstraints constraints){

    	/*
		xrec = x tamaño exacto
		yrec = y tamaño exacto
		xrec_pro = puesto a "1" indica que xrec es tamaño obligatorio
		yrec_pro = puesto a "1" indica que yrec es tamaño obligatorio
		xmax = x màxima
		ymax = y màxima
		xmax_pro = Indica que el xmax es obligatorio
		ymax_pro = Indica que el ymax es obligatorio
		xmin, ymin, xmin_pro, ymin_pro análogos a los máximos
    	 */

        if ((xsended!=0) && (ysended!=0)) {
            int xrec=0,yrec=0,xmax=0,ymax=0,xmin=0,ymin=0;
            boolean xrec_pro=false,yrec_pro=false,xmax_pro=false,ymax_pro=false,xmin_pro=false,ymin_pro=false;
            
			xrec = constraints.xRecommended;
			yrec = constraints.yRecommended;
			xrec_pro = constraints.xRecommendedMandatory;
			yrec_pro = constraints.yRecommendedMandatory;
			xmax = constraints.xMax;
			ymax = constraints.yMax;
			xmax_pro = constraints.xMaxMandatory;
			ymax_pro = constraints.yMaxMandatory;
			xmin = constraints.xMin;
			ymin = constraints.yMin;
			xmin_pro = constraints.xMinMandatory;
			ymin_pro = constraints.yMinMandatory;

            if (
            ((xsended != xrec) && (xrec!=0) && (xrec_pro)) ||
            ((ysended != yrec) && (yrec!=0) && (yrec_pro)) ||
            ((xsended > xmax) && (xmax!=0) && (xmax_pro)) ||
            ((ysended > ymax) && (ymax!=0) && (ymax_pro)) ||
            ((xsended < xmin) && (xmin!=0) && (xmin_pro)) ||
            ((ysended < ymin) && (ymin!=0) && (ymin_pro))
            ){

            	return ImageConstraints.INVALID;

            } else if(
            ((xsended != xrec) && (xrec!=0)) ||
            ((ysended != yrec) && (yrec!=0)) ||
            ((xsended > xmax) && (xmax!=0)) ||
            ((ysended > ymax) && (ymax!=0)) ||
            ((xsended < xmin) && (xmin!=0)) ||
            ((ysended < ymin) && (ymin!=0))
            ) {

                return ImageConstraints.WARNING;
            }

            return ImageConstraints.VALID;
        }
        else {
            return ImageConstraints.INVALID;
        }
    }
    
    
    
    /**
	 * 
	 * @param xsended
	 * @param ysended
	 * @param constraints
	 * @return
	 */
    public static int validateFile(FileTransfer file, byte[] contents, FileConstraints constraints){

    	
    	if (constraints.getMaxKb() != 0) {
    		if (Math.ceil(contents.length / 1024) > constraints.getMaxKb() ) {
    			return FileConstraints.INVALID_SIZE;
    		}
    	}
    	
    	if (getMime(file, contents, constraints) != null) {
    		return FileConstraints.VALID;
    	}
    	return FileConstraints.INVALID_TYPE; //Extensión no reconocida
    	

    }

    /**
     * Descubre el mime más adecuado según el archivo recibido y la configuración de constraints
     * @param file
     * @param contents
     * @param constraints
     * @return
     */
	public static String getMime(FileTransfer file, byte[] contents, FileConstraints constraints) {

        if (file.getFilename() != null && file.getFilename().contains(".")) {
        	//Validamos con la extensión
            String ext = file.getFilename().substring(file.getFilename().lastIndexOf('.') + 1).toLowerCase();
            
            if (ext.length() > 0) {
                if (constraints.getMimeTypes().containsKey(ext)) {
                	return constraints.getMimeTypes().get(ext);
                }
            }
        }
        
		try {
	        //Tratamos de detectar el mime y validarlo según el contenido
			InputStream is = new BufferedInputStream(new ByteArrayInputStream(contents));
			String mimeType = URLConnection.guessContentTypeFromStream(is);
			if (constraints.getMimeTypes().values().contains(mimeType)) {
            	return mimeType;
			}
		} catch (IOException e) {
        	//No hemos encontrado el mime por ahora
		}				
		
		//Probamos con el mime que nos envía el navegador
		if (constraints.getMimeTypes().values().contains(file.getMimeType())) {
        	return file.getMimeType();
		}
		
		
		return null;
	
	}
    
	
    
}
