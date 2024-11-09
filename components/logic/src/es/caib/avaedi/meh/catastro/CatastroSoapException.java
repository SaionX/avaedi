package es.caib.avaedi.meh.catastro;

import java.util.HashMap;

public class CatastroSoapException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5747061646098110240L;
	private Integer code;
	private String msg;

	public CatastroSoapException(Integer catastroCode, String msg) {

		if (catastroCode == null) {
			this.code = 500;
		} else {
			Integer errorMap = CatastroSoapException.soaperrorsmap.get(catastroCode);
			this.code = errorMap;
			if (errorMap == null) {
				this.code = 500;
			}
		}

		this.msg = msg;

	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	protected static HashMap<Integer, Integer> soaperrorsmap = CatastroSoapException.getSoapErrors();

	private static HashMap<Integer, Integer> getSoapErrors() {
		HashMap<Integer, Integer> errores = new HashMap<Integer, Integer>();
		errores.put(1, 500);
		//MAN ERROR EN EL SERVIDOR
		errores.put(2, 406);
		//CAL LA REFERENCIA CATASTRAL ES OBLIGATORIA 
		errores.put(3, 406);
		//CAL LA REFERENCIA CATASTRAL DEBE TENER 14,18 o 20 POSICIONES
		errores.put(4, 406);
		//CAL LA REFERENCIA CATASTRAL NO ESTÁ CORRECTAMENTE FORMADA
		errores.put(5, 404);
		//CAL NO EXISTE NINGÚN INMUEBLE CON LOS PARÁMETROS INDICADOS
		errores.put(6, 500);
		//CAL ERROR AL CONSULTAR LA REFERENCIA
		errores.put(7, 406);
		//CAL LA REF ERENCIA CATASTRAL DEBE SER UNA COMBINACIÓN DE LETRAS Y NÚMEROS HASTA UN TOTAL DE 20 CARACTERES.
		errores.put(8, 406);
		//CAL EL HUSO GEOGRÁFICO DEBE SER UNA SECUENCIA DE HASTA 10 CARACTERES.
		errores.put(9, 404);
		//9 CAL LA REFERENCIA CATASTRAL NO EXISTE
		errores.put(10, 500);
		//CAL ERROR AL CONSULTAR LA REFERENCIA
		errores.put(11, 406);
		//11 CAL LA PROVINCIA ES OBLIGATORIA
		errores.put(15, 404);
		//12 CAL LA PROVINCIA NO EXISTE
		errores.put(13, 406);
		//13 CAL LA PROVINCIA DEBE SER UNA SECUENCIA DE HASTA 25 CARACTERES.
		errores.put(15, 500);
		//15 CAL ERROR AL BUSCAR LAS COORDENADAS
		errores.put(16, 404);
		//16 CAL  PARA ESAS COORDENADAS NO HAY REFERENCIA DISPONIBLE
		errores.put(17, 406);
		//17 CAL LA REFERENCIA CATASTRAL ES OBLIGATORIA
		errores.put(20, 500);
		//20 CAL ERROR AL CONSULTAR EL MUNICIPIO
		errores.put(21, 406);
		//21 CAL EL MUNICIPIO ES OBLIGATORIO.
		errores.put(22, 404);
		//22 CAL EL MUNICIPIO NO EXISTE.
		errores.put(23, 406);
		//23 CAL EL CÓDIGO DE MUNICIPIO DEBE SER UNA SECUENCIA DE HASTA 3 DÍGITOS.
		errores.put(24, 406);
		//24 CAL EL MUNICIPIO DEBE SER UNA SECUENCIA DE HASTA 40 CARACTERES.
		errores.put(31, 406);
		//31 CAL EL TIPO DE VIA ES OBLIGATORIO.
		errores.put(32, 406);
		//32 CAL LA VIA ES OBLIGATORIA.
		errores.put(33, 404);
		//33 CAL LA VÍA NO EXISTE
		errores.put(34, 406);
		//34 CAL EL NOMBRE DE LA VÍA DEBE SER UNA SECUENCIA DE HASTA 25 CARACTERES
		errores.put(35, 406);
		//35 CAL EL TIPO DE VÍA DEBE SER UNA SECUENCIA DE HASTA 5 CARACTERES
		errores.put(36, 406);
		//36 CAL EL CÓDIGO DE VÍA DEBE SER UNA SECUENCIA DE HASTA 5 DÍGITOS.
		errores.put(41, 406);
		//41 CAL EL NÚMERO ES OBLIGATORIO.
		errores.put(42, 406);
		//42 CAL EL NÚMERO DEBE SER UNA SECUENCIA DE HASTA 4 DÍGITOS. 
		errores.put(43, 404);
		//43 CAL EL NUMERO NO EXISTE
		errores.put(51, 406);
		//51 CAL EL BLOQUE DEBE SER UNA SECUENCIA DE HASTA 4 CARACTERES.
		errores.put(53, 406);
		//53 CAL ERROR EN EL FORMATO DEL BLOQUE, ESCALERA, PLANTA O PUERTA
		errores.put(61, 406);
		//61 CAL EL POLIGONO ES OBLIGATORIO
		errores.put(62, 406);
		//62 CAL LA PARCELA ES OBLIGATORIA
		errores.put(63, 406);
		//63 CAL EL POLÍGONO DEBE SER UNA SECUENCIA DE HASTA 3 DÍGITOS.
		errores.put(64, 406);
		//64 CAL LA PARCELA DEBE SER UNA SECUENCIA DE HASTA 5 DÍGITOS.
		errores.put(71, 500);
		//71 CAL ERROR AL RECUPERAR EL DOMICILIO
		errores.put(72, 404);
		//72 CAL NO HAY CARTOGRAFIA DISPONIBLE
		errores.put(73, 500);
		//73 CAL ERROR AL BUSCAR LA PARCELA
		errores.put(74, 500);
		//74 CAL ERROR AL GENERAR EL RETORNO
		errores.put(75, 406);
		//75 CAL EL CAMPO SRS ES OBLIGATORIO
		errores.put(76, 406);
		//76 CAL LA COORDENADA X OBLIGATORIA
		errores.put(77, 406);
		//77 CAL LA COORDENADA X DEBE SER UN VALOR NUMÉRICO
		errores.put(78, 406);
		//78 CAL LA COORDENADA Y DEBE SER UN VALOR NUMÉRICO
		errores.put(79, 406);
		//79 CAL LA COORDENADA Y OBLIGATORIA 
		return errores;
	}

}
