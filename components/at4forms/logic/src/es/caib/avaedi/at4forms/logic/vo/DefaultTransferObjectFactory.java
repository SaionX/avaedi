package es.caib.avaedi.at4forms.logic.vo;

//import org.springframework.beans.BeanUtils;

import org.springframework.beans.BeanUtils;

import es.caib.avaedi.at4forms.common.basedao.Model;
import es.caib.avaedi.at4forms.common.exception.TransferObjectCreateException;
import es.caib.avaedi.logic.server.vo.RestVO;


/**
 * Métodos y utilidades para trasformar modelos en Transfer Objects
 * @author agarcia
 */
public class DefaultTransferObjectFactory {

	/**
	 * The logger object.
	 */
	//private static Logger log = LogService.getLogger(TransferObjectFactoryBase.class);


	/**
	 * The logger object.
	 */
	//private static Logger log = LogService.getLogger(TransferObjectFactoryBase.class);


	public static void copyProperties(ListadoVO voDest, Model boOrig, String[] ignoreProperties) throws TransferObjectCreateException {
    	BeanUtils.copyProperties(boOrig, voDest, ignoreProperties);
	}

	public static void copyProperties(Model boDest, ListadoVO voOrig, String[] ignoreProperties) throws TransferObjectCreateException {
    	BeanUtils.copyProperties(voOrig, boDest, ignoreProperties);
	}
	
	public static void copyProperties(RestVO boDest, Model voOrig, String[] ignoreProperties) throws TransferObjectCreateException {
    	BeanUtils.copyProperties(voOrig, boDest, ignoreProperties);
	}


	
	
	
	/* * Transformers para AuditoriaVista * */
	/*
	public static Transformer<AuditoriaVista, AuditoriaVistaListadoVO> auditoriaVista2ListadoTransformer() {
		return new auditoriaVista2ListadoTransformer();
	}

	public static class auditoriaVista2ListadoTransformer implements Transformer<AuditoriaVista, AuditoriaVistaListadoVO> {
		public AuditoriaVistaListadoVO transform(AuditoriaVista instance) {
	    	AuditoriaVistaListadoVO ret = new AuditoriaVistaListadoVO();
	    	try {
	    		copyProperties(ret, instance, new String[]{"auditorias"});

	    		// set auditories
	    		ret.setAuditorias( new TreeSet<AuditoriaListadoVO>(CollectionUtils.collect(instance.getAuditorias(), auditoria2ListadoTransformer() )) );
							

			} catch (TransferObjectCreateException e) {
				throw new FunctorException(e);
			}
	    	return ret;
		}
	}
*/
	/*
	public static Transformer<AuditoriaVista, AuditoriaVistaFormVO> auditoriaVista2FormTransformer() {
		return new auditoriaVista2FormTransformer();
	}

	public static class auditoriaVista2FormTransformer implements Transformer<AuditoriaVista, AuditoriaVistaFormVO> {
		public AuditoriaVistaFormVO transform(AuditoriaVista instance) {
			AuditoriaVistaFormVO ret = new AuditoriaVistaFormVO();
	    	try {
	    		copyProperties(ret, instance, new String[]{"auditorias"});
							
	    		// set auditories
	    		ret.setAuditorias( new TreeSet<AuditoriaListadoVO>(CollectionUtils.collect(instance.getAuditorias(), auditoria2ListadoTransformer() )) );

							

			} catch (TransferObjectCreateException e) {
				throw new FunctorException(e);
			}
	    	return ret;
		}
	}
	*/

	
	
	/* * Transformers para EstadoAplicacion * 
	public static class estadoAplicacion2ListadoTransformer implements Transformer<EstadoAplicacion, EstadoAplicacionListadoVO> {
		public EstadoAplicacionListadoVO transform(EstadoAplicacion instance) {
	    	EstadoAplicacionListadoVO ret = new EstadoAplicacionListadoVO();
	    	try {
				copyProperties(ret, instance, null);
							

			} catch (TransferObjectCreateException e) {
				throw new FunctorException(e);
			}
	    	return ret;
		}
	}

	public static Transformer<EstadoAplicacion, EstadoAplicacionListadoVO> estadoAplicacion2ListadoTransformer() {
		return new estadoAplicacion2ListadoTransformer();
	}

	public static class estadoAplicacion2FormTransformer implements Transformer<EstadoAplicacion, EstadoAplicacionFormVO> {
		public EstadoAplicacionFormVO transform(EstadoAplicacion instance) {
			EstadoAplicacionFormVO ret = new EstadoAplicacionFormVO();
	    	try {
				copyProperties(ret, instance, new String[]{});
							

							

			} catch (TransferObjectCreateException e) {
				throw new FunctorException(e);
			}
	    	return ret;
		}
	}

	public static Transformer<EstadoAplicacion, EstadoAplicacionFormVO> estadoAplicacion2FormTransformer() {
		return new estadoAplicacion2FormTransformer();
	}
	
	
	*/
	
	
	/* * Transformers para Auditoria * 
	public static class auditoria2ListadoTransformer implements Transformer<Auditoria, AuditoriaListadoVO> {
		public AuditoriaListadoVO transform(Auditoria instance) {
	    	AuditoriaListadoVO ret = new AuditoriaListadoVO();
	    	try {
				copyProperties(ret, instance, null);
							

			} catch (TransferObjectCreateException e) {
				throw new FunctorException(e);
			}
	    	return ret;
		}
	}

	public static Transformer<Auditoria, AuditoriaListadoVO> auditoria2ListadoTransformer() {
		return new auditoria2ListadoTransformer();
	}

	public static class auditoria2FormTransformer implements Transformer<Auditoria, AuditoriaFormVO> {
		public AuditoriaFormVO transform(Auditoria instance) {
			AuditoriaFormVO ret = new AuditoriaFormVO();
	    	try {
				copyProperties(ret, instance, new String[]{});
							

							

			} catch (TransferObjectCreateException e) {
				throw new FunctorException(e);
			}
	    	return ret;
		}
	}

	public static Transformer<Auditoria, AuditoriaFormVO> auditoria2FormTransformer() {
		return new auditoria2FormTransformer();
	}
	*/
	
	


}
