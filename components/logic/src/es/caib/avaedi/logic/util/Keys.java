package es.caib.avaedi.logic.util;

/**
 * Constantes generales
 * 
 * @author agarcia
 * 
 */
public class Keys {

	public final static String SNNC_NO = "0";
	public final static String SNNC_SI = "1";
	public final static String SNNC_NC = "2";
	
	//Inspeccion - datos generales - iee completa
	public final static String INSPECCION_IEE_COMPLETA_CON_ITE_REALIZADA = "0";
	public final static String INSPECCION_IEE_COMPLETA_COMPLETO = "1";
	
	//Inspeccion - datos generales - Datos edificio Id parcela
	public final static String INSPECCION_EDIFICACION_EXENTA_AISLADA_O__PAREADA_EN_PARCELA_BLOQUE_ABIERTO = "1";
	public final static String INSPECCION_EDIFICACION_ENTRE_MEDIANERAS_ADOSADA_EDIFICACION_EN_MANZANA_CERRADA = "2";
	
	//Inspeccion - datos generales - Datos edificio Id núcleo escaleras
	public final static String INSPECCION_EDIFICACION_UN_SOLO_NUCLEO = "1";
	public final static String INSPECCION_EDIFICACION_DOS_O_MAS_NUCLEOS= "2";
	
	//Inspeccion - datos generales - Datos edificio Id unnúcleo escaleras
	public final static String INSPECCION_EDIFICACION_SIN_ASCENSOR  = "1";
	public final static String INSPECCION_EDIFICACION_CON_UN_ASCENSOR = "2";
	public final static String INSPECCION_EDIFICACION_CON_DOS_O_MAS_ASCENSORES = "3";
	
	//Inspeccion - datos generales - Datos edificio Id uso
	public final static String INSPECCION_EDIFICACION_RESIDENCIAL_PUBLICO = "1";
	public final static String INSPECCION_EDIFICACION_RESIDENCIAL_PRIVADO = "2";
	public final static String INSPECCION_EDIFICACION_ADMINISTRATIVO = "3";
	public final static String INSPECCION_EDIFICACION_DOCENTE = "4";
	public final static String INSPECCION_EDIFICACION_COMERCIAL = "5";
	public final static String INSPECCION_EDIFICACION_INDUSTRIAL = "6";
	public final static String INSPECCION_EDIFICACION_SANITARIO = "7";
	public final static String INSPECCION_EDIFICACION_OTRO = "8";
	
	//Inspeccion - edificio - Id edificio comunes
	public final static String INSPECCION_EDIFICIO_NO = "1";
	public final static String INSPECCION_EDIFICIO_SI = "2";
	
	//Inspeccion - edificio - Id edificio objeto
	public final static String INSPECCION_EDIFICIO_UNICO_EDIFICIO  = "1";
	public final static String INSPECCION_EDIFICIO_PARTE_EDIFICIO_FUNCIONALMENTE_INDEPENDIENTE_DEL_RESTO = "2";
	public final static String INSPECCION_EDIFICIO_OTRO_CASO = "3";
	
	//Inspeccion - edificio - Id propiedad regimen
	public final static String INSPECCION_EDIFICIO_COMUNIDAD_PROPIETARIOS  = "1";
	public final static String INSPECCION_EDIFICIO_PROPIETARIO_UNICO = "2";
	public final static String INSPECCION_EDIFICIO_VARIOS_PROPIETARIOS = "3";
	public final static String INSPECCION_EDIFICIO_OTROS = "4";
	
	//Cerramientos Cubiertas - cubierta - Id inclinada aislamiento termico
	public final static String CERRAMIENTOS_CUBIERTA_INCLINADA_AISLAMIENTO_TERMICO_SI  = "1";
	public final static String CERRAMIENTOS_CUBIERTA_INCLINADA_AISLAMIENTO_TERMICO_NO = "2";
	public final static String CERRAMIENTOS_CUBIERTA_INCLINADA_AISLAMIENTO_TERMICO_SE_DESCONOCE  = "3";
	
	//Cerramientos Cubiertas - cubierta - Id plana lamina impermeabilizante
	public final static String CERRAMIENTOS_CUBIERTA_PLANA_LAMINA_IMPERMEABILIZANTE_SI  = "1";
	public final static String CERRAMIENTOS_CUBIERTA_PLANA_LAMINA_IMPERMEABILIZANTE_NO = "2";
	public final static String CERRAMIENTOS_CUBIERTA_PLANA_LAMINA_IMPERMEABILIZANTE_SE_DESCONOCE  = "3";
	
	//Cerramientos Cubiertas - cubierta - Id plana aislamiento termico
	public final static String CERRAMIENTOS_CUBIERTA_PLANA_AISLAMIENTO_TERMICO_SI  = "1";
	public final static String CERRAMIENTOS_CUBIERTA_PLANA_AISLAMIENTO_TERMICO_NO = "2";
	public final static String CERRAMIENTOS_CUBIERTA_PLANA_AISLAMIENTO_TERMICO_SE_DESCONOCE  = "3";
	
	//Cerramientos Cubiertas - fachada principal - Id camara aire 
	public final static String CERRAMIENTOS_FACHADA_PRINCIPAL_CAMA_AIRE_SI  = "1";
	public final static String CERRAMIENTOS_FACHADA_PRINCIPAL_CAMA_AIRE_NO = "2";
	public final static String CERRAMIENTOS_FACHADA_PRINCIPAL_CAMA_AIRE_SE_DESCONOCE  = "3";
	
	//Cerramientos Cubiertas - fachada principal - Id aislamiento termico 
	public final static String CERRAMIENTOS_FACHADA_PRINCIPAL_AISLAMIENTO_TERMICO_SI  = "1";
	public final static String CERRAMIENTOS_FACHADA_PRINCIPAL_AISLAMIENTO_TERMICO_NO = "2";
	public final static String CERRAMIENTOS_FACHADA_PRINCIPAL_AISLAMIENTO_TERMICO_SE_DESCONOCE  = "3";
	
	//Cerramientos Cubiertas - otras fachadas - Id camara aire
	public final static String CERRAMIENTOS_FACHADA_OTRAS_FACHADAS_CAMA_AIRE_SI  = "1";
	public final static String CERRAMIENTOS_FACHADA_OTRAS_FACHADAS_CAMA_AIRE_NO = "2";
	public final static String CERRAMIENTOS_FACHADA_OTRAS_FACHADAS_CAMA_AIRE_SE_DESCONOCE  = "3";
	
	//Cerramientos Cubiertas - otras fachadas - Id aislamiento termico
	public final static String CERRAMIENTOS_FACHADA_OTRAS_FACHADAS_AISLAMIENTO_TERMICO_SI  = "1";
	public final static String CERRAMIENTOS_FACHADA_OTRAS_FACHADAS_AISLAMIENTO_TERMICO_NO = "2";
	public final static String CERRAMIENTOS_FACHADA_OTRAS_FACHADAS_AISLAMIENTO_TERMICO_SE_DESCONOCE  = "3";
	
	//Instalaciones - acs - Tiene central
	public final static String INSTALACIONES_ACS_TIENE_CENTRAL_SI  = "1";
	public final static String INSTALACIONES_ACS_TIENE_CENTRAL_NO = "0";
	
	//Instalaciones - acs - Tiene
	public final static String INSTALACIONES_ACS_TIENE_SI  = "1";
	public final static String INSTALACIONES_ACS_TIENE_NO = "0";
	
	//Instalaciones - calefaccion - Tiene central
	public final static String INSTALACIONES_CALEFACCION_TIENE_CENTRAL_SI  = "1";
	public final static String INSTALACIONES_CALEFACCION_TIENE_CENTRAL_NO = "0";
	
	//Instalaciones - calefaccion - Tiene
	public final static String INSTALACIONES_CALEFACCION_TIENE_SI  = "1";
	public final static String INSTALACIONES_CALEFACCION_TIENE_NO = "0";
	
	//Instalaciones - refrigeracion - Tiene colectivo
	public final static String INSTALACIONES_REFRIGERACION_TIENE_COLECTIVO_SI  = "1";
	public final static String INSTALACIONES_REFRIGERACION_TIENE_COLECTIVO_NO = "0";
	
	//Instalaciones - refrigeracion - Tiene
	public final static String INSTALACIONES_REFRIGERACION_TIENE_SI  = "1";
	public final static String INSTALACIONES_REFRIGERACION_TIENE_NO = "0";
	
	//Instalaciones - ventilacion - cuartos humedos
	public final static String INSTALACIONES_VENTILACION_CUARTOS_HUMEDOS_SI  = "1";
	public final static String INSTALACIONES_VENTILACION_CUARTOS_HUMEDOS_NO = "0";
	
	//Instalaciones - ventilacion - tiene ventilacion
	public final static String INSTALACIONES_VENTILACION_TIENE_SI  = "1";
	public final static String INSTALACIONES_VENTILACION_TIENE_NO = "0";
	
	//Instalaciones - otros - comunicaciones ict
	public final static String INSTALACIONES_COMUNICACIONES_ICT_TIENE_SI  = "1";
	public final static String INSTALACIONES_COMUNICACIONES_ICT_TIENE_NO = "0";
	
	//Instalaciones - otros - contra incendios
	public final static String INSTALACIONES_CONTRA_INCENDIOS_TIENE_SI  = "1";
	public final static String INSTALACIONES_CONTRA_INCENDIOS_TIENE_NO = "0";
	
	//Instalaciones - otros - contra rayo
	public final static String INSTALACIONES_CONTRA_RAYO_TIENE_SI  = "1";
	public final static String INSTALACIONES_CONTRA_RAYO_TIENE_NO = "0";
	
	//Instalaciones - otros - gas canalizado
	public final static String INSTALACIONES_GAS_CANALIZADO_TIENE_SI  = "1";
	public final static String INSTALACIONES_GAS_CANALIZADO_TIENE_NO = "0";
	
	//Conservacion - es tecnico inspeccion
	public final static String CONSERVACION_ES_TECNICO_INSPECCION_SI  = "1";
	public final static String CONSERVACION_ES_TECNICO_INSPECCION_NO = "0";
	
	//Conservacion - valoraciones id
	public final static String CONSERVACION_VALORACIONES_ID_FAVORABLE  = "1";
	public final static String CONSERVACION_VALORACIONES_ID_DESFAVORABLE = "2";
	
	//Conservacion - existe peligro inminente
	public final static String CONSERVACION_PELIGRO_INMINENTE_SI  = "1";
	public final static String CONSERVACION_PELIGRO_INMINENTE_NO = "0";
	
	//Eficiencia energetica - es tecnico inspeccion
	public final static String EFICIENCIA_ES_TECNICO_INSPECCION_SI  = "1";
	public final static String EFICIENCIA_ES_TECNICO_INSPECCION_NO = "0";
	
	//Eficiencia energetica - calificacion calefaccion
	public final static String EFICIENCIA_CALIFICACION_CALEFACCION_A  = "1";
	public final static String EFICIENCIA_CALIFICACION_CALEFACCION_B = "2";
	public final static String EFICIENCIA_CALIFICACION_CALEFACCION_C = "3";
	public final static String EFICIENCIA_CALIFICACION_CALEFACCION_D = "4";
	public final static String EFICIENCIA_CALIFICACION_CALEFACCION_E = "5";
	public final static String EFICIENCIA_CALIFICACION_CALEFACCION_F = "6";
	public final static String EFICIENCIA_CALIFICACION_CALEFACCION_G = "7";
	public final static String EFICIENCIA_CALIFICACION_CALEFACCION_NC = "8";
	
	//Eficiencia energetica - calificacion refrigeracion
	public final static String EFICIENCIA_CALIFICACION_REFRIGERACION_A  = "1";
	public final static String EFICIENCIA_CALIFICACION_REFRIGERACION_B = "2";
	public final static String EFICIENCIA_CALIFICACION_REFRIGERACION_C = "3";
	public final static String EFICIENCIA_CALIFICACION_REFRIGERACION_D = "4";
	public final static String EFICIENCIA_CALIFICACION_REFRIGERACION_E = "5";
	public final static String EFICIENCIA_CALIFICACION_REFRIGERACION_F = "6";
	public final static String EFICIENCIA_CALIFICACION_REFRIGERACION_G = "7";
	public final static String EFICIENCIA_CALIFICACION_REFRIGERACION_NC = "8";
	
	//Eficiencia energetica - calificacion global
	public final static String EFICIENCIA_CALIFICACION_GLOBAL_A  = "1";
	public final static String EFICIENCIA_CALIFICACION_GLOBAL_B = "2";
	public final static String EFICIENCIA_CALIFICACION_GLOBAL_C = "3";
	public final static String EFICIENCIA_CALIFICACION_GLOBAL_D = "4";
	public final static String EFICIENCIA_CALIFICACION_GLOBAL_E = "5";
	public final static String EFICIENCIA_CALIFICACION_GLOBAL_F = "6";
	public final static String EFICIENCIA_CALIFICACION_GLOBAL_G = "7";
	public final static String EFICIENCIA_CALIFICACION_GLOBAL_NC = "8";
	
	//Eficiencia energetica - calificacion primaria
	public final static String EFICIENCIA_CALIFICACION_PRIMARIA_A  = "1";
	public final static String EFICIENCIA_CALIFICACION_PRIMARIA_B = "2";
	public final static String EFICIENCIA_CALIFICACION_PRIMARIA_C = "3";
	public final static String EFICIENCIA_CALIFICACION_PRIMARIA_D = "4";
	public final static String EFICIENCIA_CALIFICACION_PRIMARIA_E = "5";
	public final static String EFICIENCIA_CALIFICACION_PRIMARIA_F = "6";
	public final static String EFICIENCIA_CALIFICACION_PRIMARIA_G = "7";
	public final static String EFICIENCIA_CALIFICACION_PRIMARIA_NC = "8";
	
	//Accesibilidad publicos - datos generales - 1 por cada 50
	public final static String ACCESIBILIDAD_PUBLICOS_1_POR_CADA_50_SI  = "1";
	public final static String ACCESIBILIDAD_PUBLICOS_1_POR_CADA_50_NO = "0";
	
	//Accesibilidad publicos - datos generales - minimo 1
	public final static String ACCESIBILIDAD_PUBLICOS_MINIMO_1_SI  = "1";
	public final static String ACCESIBILIDAD_PUBLICOS_MINIMO_1_NO = "0";
	
	//Accesibilidad publicos - datos generales - minimo 2
	public final static String ACCESIBILIDAD_PUBLICOS_MINIMO_2_SI  = "1";
	public final static String ACCESIBILIDAD_PUBLICOS_MINIMO_2_NO = "0";
	
	//Accesibilidad publicos - datos generales - minimo 4
	public final static String ACCESIBILIDAD_PUBLICOS_MINIMO_4_SI  = "1";
	public final static String ACCESIBILIDAD_PUBLICOS_MINIMO_4_NO = "0";
	
	//Accesibilidad publicos - datos generales - minimo 6
	public final static String ACCESIBILIDAD_PUBLICOS_MINIMO_6_SI  = "1";
	public final static String ACCESIBILIDAD_PUBLICOS_MINIMO_6_NO = "0";
	
	//Accesibilidad publicos - datos generales - minimo 8
	public final static String ACCESIBILIDAD_PUBLICOS_MINIMO_8_SI  = "1";
	public final static String ACCESIBILIDAD_PUBLICOS_MINIMO_8_NO = "0";
	
	//Accesibilidad publicos - datos generales - aparcamiento comercial por fraccion
	public final static String ACCESIBILIDAD_APARCAMIENTO_COMERCIAL_POR_FRACCION_SI  = "1";
	public final static String ACCESIBILIDAD_APARCAMIENTO_COMERCIAL_POR_FRACCION_NO = "0";
	
	//Accesibilidad publicos - datos generales - aparcamiento otros usos minimo aparcamientos una mas por fracion
	public final static String ACCESIBILIDAD_APARCAMIENTO_UNA_MAS_POR_FRACCION_SI  = "1";
	public final static String ACCESIBILIDAD_APARCAMIENTO_UNA_MAS_POR_FRACCION_NO = "0";
	
	//Accesibilidad publicos - datos generales - aparcamiento otros usos minimo aparcamientos una por fracion
	public final static String ACCESIBILIDAD_APARCAMIENTO_UNA_POR_FRACCION_SI  = "1";
	public final static String ACCESIBILIDAD_APARCAMIENTO_UNA_POR_FRACCION_NO = "0";
	
	//Accesibilidad publicos - datos generales - aparcamiento residencial publico por alojamiento
	public final static String ACCESIBILIDAD_APARCAMIENTO_RESIDENCIAL_PUBLICO_POR_ALOJAMIENTO_SI  = "1";
	public final static String ACCESIBILIDAD_APARCAMIENTO_RESIDENCIAL_PUBLICO_POR_ALOJAMIENTO_NO = "0";
	
	//Accesibilidad publicos - datos generales - aparcamiento silla ruedas
	public final static String ACCESIBILIDAD_APARCAMIENTO_SILLA_RUEDAS_SI  = "1";
	public final static String ACCESIBILIDAD_APARCAMIENTO_SILLA_RUEDAS_NO = "0";
	
	//Accesibilidad publicos - entre planta - accesible
	public final static String ACCESIBILIDAD_ACCESIBLE_SI  = "1";
	public final static String ACCESIBILIDAD_ACCESIBLE_NO = "0";
	
	//Accesibilidad publicos - entre planta - ascensor no accesible
	public final static String ACCESIBILIDAD_ASCENSOR_NO_ACCESIBLE_SI  = "1";
	public final static String ACCESIBILIDAD_ASCENSOR_NO_ACCESIBLE_NO = "0";
	
	//Accesibilidad publicos - entre planta - ascensor o rampa accesible
	public final static String ACCESIBILIDAD_ASCENSOR_O_RAMPA_ACCESIBLE_SI  = "1";
	public final static String ACCESIBILIDAD_ASCENSOR_O_RAMPA_ACCESIBLE_NO = "0";
	
	//Accesibilidad publicos - entre planta - ascensor o rampa no accesible
	public final static String ACCESIBILIDAD_ASCENSOR_O_RAMPA_NO_ACCESIBLE_SI  = "1";
	public final static String ACCESIBILIDAD_ASCENSOR_O_RAMPA_NO_ACCESIBLE_NO = "0";
	
	//Accesibilidad publicos - entre planta - elementos accesibles
	public final static String ACCESIBILIDAD_ELEMENTOS_ACCESIBLES_SI  = "1";
	public final static String ACCESIBILIDAD_ELEMENTOS_ACCESIBLES_NO = "0";
	
	//Accesibilidad publicos - entre planta - elementos accesibles ascensor no accesible
	public final static String ACCESIBILIDAD_ELEMENTOS_ACCESIBLES_ASCENSOR_NO_ACCESIBLE_SI  = "1";
	public final static String ACCESIBILIDAD_ELEMENTOS_ACCESIBLES_ASCENSOR_NO_ACCESIBLE_NO = "0";
	
	//Accesibilidad publicos - entre planta - elementos accesibles ascensor o rampa accesible
	public final static String ACCESIBILIDAD_ELEMENTOS_ACCESIBLES_ASCENSOR_O_RAMPA_ACCESIBLE_SI  = "1";
	public final static String ACCESIBILIDAD_ELEMENTOS_ACCESIBLES_ASCENSOR_O_RAMPA_ACCESIBLE_NO = "0";
	
	//Accesibilidad publicos - entre planta - elementos accesibles ascensor o rampa no accesible
	public final static String ACCESIBILIDAD_ELEMENTOS_ACCESIBLES_ASCENSOR_O_RAMPA_NO_ACCESIBLE_SI  = "1";
	public final static String ACCESIBILIDAD_ELEMENTOS_ACCESIBLES_ASCENSOR_O_RAMPA_NO_ACCESIBLE_NO = "0";
	
	//Accesibilidad publicos - entre planta - no accesible
	public final static String ACCESIBILIDAD_NO_ACCESIBLE_SI  = "1";
	public final static String ACCESIBILIDAD_NO_ACCESIBLE_NO = "0";
	
	//Accesibilidad publicos - entre planta - no accesible ascensor no acceisble
	public final static String ACCESIBILIDAD_NO_ACCESIBLE_ASCENSOR_NO_ACCESIBLE_SI  = "1";
	public final static String ACCESIBILIDAD_NO_ACCESIBLE_ASCENSOR_NO_ACCESIBLE_NO = "0";
	
	//Accesibilidad publicos - entre planta - no accesible ascensor o rampa accesible
	public final static String ACCESIBILIDAD_NO_ACCESIBLE_ASCENSOR_0_RAMPA_ACCESIBLE_SI  = "1";
	public final static String ACCESIBILIDAD_NO_ACCESIBLE_ASCENSOR_O_RAMPA_ACCESIBLE_NO = "0";
	
	//Accesibilidad publicos - entre planta - no accesible ascensor o rampa no accesible
	public final static String ACCESIBILIDAD_NO_ACCESIBLE_ASCENSOR_0_RAMPA_NO_ACCESIBLE_SI  = "1";
	public final static String ACCESIBILIDAD_NO_ACCESIBLE_ASCENSOR_O_RAMPA_NO_ACCESIBLE_NO = "0";
	
	//Accesibilidad publicos - entre planta - zona uso publico
	public final static String ACCESIBILIDAD_ZONAS_USO_PUBLICO_SI  = "1";
	public final static String ACCESIBILIDAD_ZONAS_USO_PUBLICO_NO = "0";
	
	//Accesibilidad publicos - entre planta - zona uso publico ascensor no accesible
	public final static String ACCESIBILIDAD_ZONA_USO_PUBLICO_ASCENSOR_NO_ACCESIBLE_SI  = "1";
	public final static String ACCESIBILIDAD_ZONA_USO_PUBLICO_ASCENSOR_NO_ACCESIBLE_NO = "0";
	
	//Accesibilidad publicos - entre planta - zona uso publico ascensor o rampa accesible
	public final static String ACCESIBILIDAD_ZONA_USO_PUBLICO_ASCENSOR_O_RAMPA_ACCESIBLE_SI  = "1";
	public final static String ACCESIBILIDAD_ZONA_USO_PUBLICO_ASCENSOR_O_RAMPA_ACCESIBLE_NO = "0";
	
	//Accesibilidad publicos - entre planta - zona uso publico ascensor o rampa no  accesible
	public final static String ACCESIBILIDAD_ZONA_USO_PUBLICO_ASCENSOR_O_RAMPA_NO_ACCESIBLE_SI  = "1";
	public final static String ACCESIBILIDAD_ZONA_USO_PUBLICO_ASCENSOR_O_RAMPA_NO_ACCESIBLE_NO = "0";
	
	//Accesibilidad publicos - informacion señalizacion - ascensores
	public final static String ACCESIBILIDAD_ASCENSORES_SI  = "1";
	public final static String ACCESIBILIDAD_ASCENSORES_NO = "0";
	
	//Accesibilidad publicos - informacion señalizacion - ascensores braille arabigo
	public final static String ACCESIBILIDAD_ASCENSORES_BRAILLE_ARABIGO_SI  = "1";
	public final static String ACCESIBILIDAD_ASCENSORES_BRAILLE_ARABIGO_NO = "0";
	
	//Accesibilidad publicos - informacion señalizacion - ascensores numero planta
	public final static String ACCESIBILIDAD_ASCENSORES_NUMERO_PLANTA_SI  = "1";
	public final static String ACCESIBILIDAD_ASCENSORES_NUMERO_PLANTA_NO = "0";
	
	//Accesibilidad publicos - informacion señalizacion - bandas visuales tactiles
	public final static String ACCESIBILIDAD_BANDAS_VISUALES_TACTILES_SI  = "1";
	public final static String ACCESIBILIDAD_BANDAS_VISUALES_TACTILES_NO = "0";
	
	//Accesibilidad publicos - informacion señalizacion - bandas visuales tactiles arranque escalera
	public final static String ACCESIBILIDAD_ARRANQUE_ESCALERAS_SI  = "1";
	public final static String ACCESIBILIDAD_ARRANQUE_ESCALERAS_NO = "0";
	
	//Accesibilidad publicos - informacion señalizacion - bandas visuales tactiles color contrastado
	public final static String ACCESIBILIDAD_COLOR_CONTRASTADO_SI  = "1";
	public final static String ACCESIBILIDAD_COLOR_CONTRASTADO_NO = "0";
	
	//Accesibilidad publicos - informacion señalizacion - bandas visuales tactiles itinerario accesible
	public final static String ACCESIBILIDAD_ITINERARIO_ACCESIBLE_SI  = "1";
	public final static String ACCESIBILIDAD_ITINERARIO_ACCESIBLE_NO = "0";
	
	//Accesibilidad publicos - informacion señalizacion - bandas visuales tactiles relieve exterior
	public final static String ACCESIBILIDAD_RELIEVE_EXTERIOR_SI  = "1";
	public final static String ACCESIBILIDAD_RELIEVE_EXTERIOR_NO = "0";
	
	//Accesibilidad publicos - informacion señalizacion - bandas visuales tactiles relieve interior
	public final static String ACCESIBILIDAD_RELIEVE_INTERIOR_SI  = "1";
	public final static String ACCESIBILIDAD_RELIEVE_INTERIOR_NO = "0";
	
	//Accesibilidad publicos - informacion señalizacion - privado sia aparcamiento
	public final static String ACCESIBILIDAD_PRIVADO_SIA_APACAMIENTO_SI  = "1";
	public final static String ACCESIBILIDAD_PRIVADO_SIA_APACAMIENTO_NO = "0";
	
	//Accesibilidad publicos - informacion señalizacion - privado sia ascensores
	public final static String ACCESIBILIDAD_PRIVADO_SIA_ASCENSORES_SI  = "1";
	public final static String ACCESIBILIDAD_PRIVADO_SIA_ASCENSORES_NO = "0";
	
	//Accesibilidad publicos - informacion señalizacion - privado sia entradas
	public final static String ACCESIBILIDAD_PRIVADO_SIA_ENTRADAS_SI  = "1";
	public final static String ACCESIBILIDAD_PRIVADO_SIA_ENTRADAS_NO = "0";
	
	//Accesibilidad publicos - informacion señalizacion - privado sia itinerarios
	public final static String ACCESIBILIDAD_PRIVADO_SIA_ITINERARIOS_SI  = "1";
	public final static String ACCESIBILIDAD_PRIVADO_SIA_ITINERARIOS_NO = "0";
	
	//Accesibilidad publicos - informacion señalizacion - privado sia plazas reservadas
	public final static String ACCESIBILIDAD_PRIVADO_SIA_PLAZAS_RESERVADAS_SI  = "1";
	public final static String ACCESIBILIDAD_PRIVADO_SIA_PLAZAS_RESERVADAS_NO = "0";
	
	//Accesibilidad publicos - informacion señalizacion - privado sia aparcamiento
	public final static String ACCESIBILIDAD_PUBLICO_SIA_APACAMIENTO_SI  = "1";
	public final static String ACCESIBILIDAD_PUBLICO_SIA_APACAMIENTO_NO = "0";
	
	//Accesibilidad publicos - informacion señalizacion - publico sia ascensores
	public final static String ACCESIBILIDAD_PUBLICO_SIA_ASCENSORES_SI  = "1";
	public final static String ACCESIBILIDAD_PUBLICO_SIA_ASCENSORES_NO = "0";
	
	//Accesibilidad publicos - informacion señalizacion - publico sia entradas
	public final static String ACCESIBILIDAD_PUBLICO_SIA_ENTRADAS_SI  = "1";
	public final static String ACCESIBILIDAD_PUBLICO_SIA_ENTRADAS_NO = "0";
	
	//Accesibilidad publicos - informacion señalizacion - publico sia itinerarios
	public final static String ACCESIBILIDAD_PUBLICO_SIA_ITINERARIOS_SI  = "1";
	public final static String ACCESIBILIDAD_PUBLICO_SIA_ITINERARIOS_NO = "0";
	
	//Accesibilidad publicos - informacion señalizacion - publico sia plazas reservadas
	public final static String ACCESIBILIDAD_PUBLICO_SIA_PLAZAS_RESERVADAS_SI  = "1";
	public final static String ACCESIBILIDAD_PUBLICO_SIA_PLAZAS_RESERVADAS_NO = "0";
	
	//Accesibilidad publicos - informacion señalizacion - publico sia puntos atencion
	public final static String ACCESIBILIDAD_PUBLICO_SIA_PUNTOS_ATENCION_SI  = "1";
	public final static String ACCESIBILIDAD_PUBLICO_SIA_PUNTOS_ATENCION_NO = "0";
	
	//Accesibilidad publicos - informacion señalizacion - publico sia servicios higienicos
	public final static String ACCESIBILIDAD_PUBLICO_SIA_SERVICIOS_HIGIENICOS_SI  = "1";
	public final static String ACCESIBILIDAD_PUBLICO_SIA_SERVICIOS_HIGIENICOS_NO = "0";
	
	//Accesibilidad publicos - informacion señalizacion - bucle magnetico
	public final static String ACCESIBILIDAD_BUCLE_MAGNETICO_SI  = "1";
	public final static String ACCESIBILIDAD_BUCLE_MAGNETICO_NO = "0";
	
	//Accesibilidad publicos - informacion señalizacion - bucle magnetico señalizado
	public final static String ACCESIBILIDAD_BUCLE_MAGNETICO_SENALIZADO_SI  = "1";
	public final static String ACCESIBILIDAD_BUCLE_MAGNETICO_SENALIZADO_NO = "0";
	
	//Accesibilidad publicos - informacion señalizacion - servicios higienicos señalizados
	public final static String ACCESIBILIDAD_SERVICIOS_HIGIENICOS_SENALIZADOS_SI  = "1";
	public final static String ACCESIBILIDAD_SERVICIOS_HIGIENICOS_SENALIZADOS_NO = "0";
	
	//Accesibilidad publicos - informacion señalizacion - sianorma
	public final static String ACCESIBILIDAD_SIANORMA_SI  = "1";
	public final static String ACCESIBILIDAD_SIANORMA_NO = "0";
	
	//Accesibilidad publicos - tecnico y otros datos - es tecnico inspeccion
	public final static String ACCESIBILIDAD_TECNICO_INSPECCION_SI  = "1";
	public final static String ACCESIBILIDAD_TECNICO_INSPECCION_NO = "0";
	
	//Accesibilidad publicos - tecnico y otros datos - exterior edificio itinerio accesible
	public final static String ACCESIBILIDAD_EDIFICIO_ITINERARIO_ACCESIBLE_VIA_PUBLICA_SI  = "1";
	public final static String ACCESIBILIDAD_EDIFICIO_ITINERARIO_ACCESIBLE_VIA_PUBLICA_NO = "0";
	
	//Accesibilidad publicos - tecnico y otros datos - exterior edificio itinerio accesible
	public final static String ACCESIBILIDAD_EDIFICIO_ITINERARIO_ACCESIBLE_ZONAS_COMUNES_SI  = "1";
	public final static String ACCESIBILIDAD_EDIFICIO_ITINERARIO_ACCESIBLE_ZONAS_COMUNES_NO = "0";
	
	//Accesibilidad publicos - tecnico y otros datos - plantas itinerarios accesible elementos accesibles
	public final static String ACCESIBILIDAD_PLANTAS_ITINERARIO_ELEMENTOS_ACCESIBLES_SI  = "1";
	public final static String ACCESIBILIDAD_PLANTAS_ITINERARIO_ELEMENTOS_ACCESIBLES_NO = "0";
	
	//Accesibilidad publicos - tecnico y otros datos - plantas itinerarios accesible entresi
	public final static String ACCESIBILIDAD_PLANTAS_ITINERARIO_ENTRESI_SI  = "1";
	public final static String ACCESIBILIDAD_PLANTAS_ITINERARIO_ENTRESI_NO = "0";
	
	//Accesibilidad publicos - tecnico y otros datos - plantas itinerarios accesible zona uso privado
	public final static String ACCESIBILIDAD_PLANTAS_ITINERARIO_ZONA_USO_PRIVADO_SI  = "1";
	public final static String ACCESIBILIDAD_PLANTAS_ITINERARIO_ZONA_USO_PRIVADO_NO = "0";
	
	//Accesibilidad publicos - tecnico y otros datos - plantas itinerarios accesible zona uso publico
	public final static String ACCESIBILIDAD_PLANTAS_ITINERARIO_ZONA_USO_PUBLICO_SI  = "1";
	public final static String ACCESIBILIDAD_PLANTAS_ITINERARIO_ZONA_USO_PUBLICO_NO = "0";
	
	//Accesibilidad publicos - tecnico y otros datos - plazas reservadas discapacidad auditiva
	public final static String ACCESIBILIDAD_PLANTAS_ITINERARIO_DISCAPACIDAD_AUDITIVA_SI  = "1";
	public final static String ACCESIBILIDAD_PLANTAS_ITINERARIO_DISCAPACIDAD_AUDITIVA_NO = "0";
	
	//Accesibilidad publicos - tecnico y otros datos - plazas reservadas silla ruedas
	public final static String ACCESIBILIDAD_PLANTAS_ITINERARIO_SILLA_RUEDAS_SI  = "1";
	public final static String ACCESIBILIDAD_PLANTAS_ITINERARIO_SILLA_RUEDAS_NO = "0";
	
	//Accesibilidad publicos - tecnico y otros datos - plazas reservadas zona espera silla ruedas
	public final static String ACCESIBILIDAD_PLANTAS_ITINERARIO_ZONA_ESPERA_SILLA_RUEDAS_SI  = "1";
	public final static String ACCESIBILIDAD_PLANTAS_ITINERARIO_ZONA_ESPERA_SILLA_RUEDAS_NO = "0";
	
	//Accesibilidad publicos - tecnico y otros datos - servicios higienicos aseo accesible
	public final static String ACCESIBILIDAD_PLANTAS_ITINERARIO_ASEO_ACCESIBLE_SI  = "1";
	public final static String ACCESIBILIDAD_PLANTAS_ITINERARIO_ASEO_ACCESIBLE_NO = "0";
	
	//Accesibilidad publicos - tecnico y otros datos - servicios higienicos cabina ducha accesible
	public final static String ACCESIBILIDAD_PLANTAS_ITINERARIO_CABINA_DUCHA_ACCESIBLE_SI  = "1";
	public final static String ACCESIBILIDAD_PLANTAS_ITINERARIO_CABINA_DUCHA_ACCESIBLE_NO = "0";
	
	//Accesibilidad publicos - tecnico y otros datos - mecanismos accesibles
	public final static String ACCESIBILIDAD_MECANISMOS_ACCESIBLES_SI  = "1";
	public final static String ACCESIBILIDAD_MECANISMOS_ACCESIBLES_NO = "0";
	
	//Accesibilidad publicos - tecnico y otros datos - mobiliario fijo punto accesible
	public final static String ACCESIBILIDAD_MOBILIARIO_FIJO_PUNTO_ACCESIBLE_SI  = "1";
	public final static String ACCESIBILIDAD_MOBILIARIO_FIJO_PUNTO_ACCESIBLE_NO = "0";
	
	//Accesibilidad publicos - tecnico y otros datos - mobiliario fijo punto accesible
	public final static String ACCESIBILIDAD_ENTRADA_ACCESIBLE_PISCINAS_SI  = "1";
	public final static String ACCESIBILIDAD_ENTRADA_ACCESIBLE_PISCINAS_NO = "0";
	
	//Accesibilidad Valoracion Final - valores si/no
	public final static String ACCESIBILIDAD_VALORACION_FINAL_SI  = "1";
	public final static String ACCESIBILIDAD_VALORACION_FINAL_NO = "0";
	
	//Acustica Comprobaciones - valores si/no
	public final static String ACUSTICA_COMPROBACIONES_SI  = "1";
	public final static String ACUSTICA_COMPROBACIONES_NO = "0";
	
	//Acustica Valoracion Final - valores
	public final static String ACUSTICA_VALORACION_DEFICIENTE  = "4";
	public final static String ACUSTICA_VALORACION_REGULAR = "3";
	public final static String ACUSTICA_VALORACION_RAZONABLE  = "2";
	public final static String ACUSTICA_VALORACION_BUENO = "1";
	
	//Accesibilidad - ajustes razonables si/no
	public final static String ACCESIBILIDAD_AJUSTES_RAZONABLES_SI  = "1";
	public final static String ACCESIBILIDAD_AJUSTES_RAZONABLES_NO = "0";
	
	//Acustica Valoracion Final - valores
	public final static String ACUSTICA_MEJORAS_DEFICIENTE  = "4";
	public final static String ACUSTICA_MEJORAS_REGULAR = "3";
	public final static String ACUSTICA_MEJORAS_RAZONABLE  = "2";
	public final static String ACUSTICA_MEJORAS_BUENO = "1";
	
	//Acusticas -  si/no
	public final static String ACUSTICAS_SI  = "1";
	public final static String ACUSTICAS_NO = "0";
	
	//Acustica - ruido instalaciones  si/no
	public final static String ACUSTICA_RUIDO_INSTALACIONES_NS  = "2";
	public final static String ACUSTICA_RUIDO_INSTALACIONES_SI  = "1";
	public final static String ACUSTICA_RUIDO_INSTALACIONES_NO = "0";
	
	//Acustica - ruido exteriores  si/no
	public final static String ACUSTICA_RUIDO_EXTERIORES_NS  = "2";
	public final static String ACUSTICA_RUIDO_EXTERIORES_SI  = "1";
	public final static String ACUSTICA_RUIDO_EXTERIORES_NO = "0";
	
	//Acustica - ruido interiores horizontales  si/no
	public final static String ACUSTICA_RUIDO_INTERIORES_HORIZONTALES_NS  = "2";
	public final static String ACUSTICA_RUIDO_INTERIORES_HORIZONTALES_SI  = "1";
	public final static String ACUSTICA_RUIDO_INTERIORES_HORIZONTALES_NO = "0";
	
	//Acustica - ruido interiores uniones  si/no
	public final static String ACUSTICA_RUIDO_INTERIORES_UNIONES_NS  = "2";
	public final static String ACUSTICA_RUIDO_INTERIORES_UNIONES_SI  = "1";
	public final static String ACUSTICA_RUIDO_INTERIORES_UNIONES_NO = "0";
	
	//Acustica - ruido interiores verticales  si/no
	public final static String ACUSTICA_RUIDO_INTERIORES_VERTICALES_NS  = "2";
	public final static String ACUSTICA_RUIDO_INTERIORES_VERTICALES_SI  = "1";
	public final static String ACUSTICA_RUIDO_INTERIORES_VERTICALES_NO = "0";
}
