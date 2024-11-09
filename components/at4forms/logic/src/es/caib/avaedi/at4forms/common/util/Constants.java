
package es.caib.avaedi.at4forms.common.util;

import java.util.Arrays;
import java.util.List;


/**
 * Constants - constantes
 *
 * @author agarcia
 */
public class Constants {

	// Propietats
	public static final String CODI_IDIOMA_DEFECTE						= "es";
	public static final List<String> TABLAS_NO_AUDITABLES				= Arrays.asList( new String[]{"Auditoria","ArchivoBlob","EstadoAplicacion"} );

	
	public static final Integer PLAZO_INICIAL_IEE = 55;
	public static final Integer PLAZO_SIGUIENTE_IEE = 10;
	public static final int ANYO_CORTE = 1963;
	public static final int ANYO_CORTE_ITE = 2018;

	public static final int ESTADO_INFORME_FAVORABLE = 1;
	public static final int ESTADO_INFORME_DESFAVORABLE = 2;
	public static final int ESTADO_INFORME_EN_TRAMITE = 3;
	public static final int ESTADO_INFORME_ANULADO = 4;
	public static final int ESTADO_INFORME_EN_CURSO = 5;

	

}
