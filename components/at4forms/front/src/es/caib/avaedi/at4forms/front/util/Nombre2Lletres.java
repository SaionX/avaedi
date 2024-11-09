package es.caib.avaedi.at4forms.front.util;


public class Nombre2Lletres {
	public static final boolean LLETRA_MINUSCULA = false;
	public static final boolean LLETRA_MAJUSCULA = true;

	//private static int numero;
	//private static String importe_parcial;
	private static String num;
	private static String num_letra;
	private static String num_letram;
	private static String num_letradm;
	private static String num_letracm;
	private static String num_letramm;
	private static String num_letradmm;


	private static String unidad(int numero){

		switch (numero){
		case 9:
				num = "nou";
				break;
		case 8:
				num = "vuit";
				break;
		case 7:
				num = "set";
				break;
		case 6:
				num = "sis";
				break;
		case 5:
				num = "cinc";
				break;
		case 4:
				num = "quatre";
				break;
		case 3:
				num = "tres";
				break;
		case 2:
				num = "dos";
				break;
		case 1:
				num = "un";
				break;
		case 0:
				num = "";
				break;
		}
		return num;
	}

	private static String decena(int numero){

		if ((numero >= 90) && (numero <= 99))
		{
			num_letra = "noranta ";
			if (numero > 90) {
				num_letra = num_letra.substring(0, num_letra.length()-1).concat("-").concat(unidad(numero - 90));
			}
		}
		else if ((numero >= 80) && (numero <= 89))
		{
			num_letra = "vuitanta ";
			if (numero > 80) {
				num_letra = num_letra.substring(0, num_letra.length()-1).concat("-").concat(unidad(numero - 80));
			}
		}
		else if ((numero >= 70) && (numero <= 79))
		{
			num_letra = "setanta ";
			if (numero > 70) {
				num_letra = num_letra.substring(0, num_letra.length()-1).concat("-").concat(unidad(numero - 70));
			}
		}
		else if ((numero >= 60) && (numero <= 69))
		{
			num_letra = "seixanta ";
			if (numero > 60) {
				num_letra = num_letra.substring(0, num_letra.length()-1).concat("-").concat(unidad(numero - 60));
			}
		}
		else if ((numero >= 50) && (numero <= 59))
		{
			num_letra = "cinquanta ";
			if (numero > 50) {
				num_letra = num_letra.substring(0, num_letra.length()-1).concat("-").concat(unidad(numero - 50));
			}
		}
		else if ((numero >= 40) && (numero <= 49))
		{
			num_letra = "quaranta ";
			if (numero > 40) {
				num_letra = num_letra.substring(0, num_letra.length()-1).concat("-").concat(unidad(numero - 40));
			}
		}
		else if ((numero >= 30) && (numero <= 39))
		{
			num_letra = "trenta ";
			if (numero > 30) {
				num_letra = num_letra.substring(0, num_letra.length()-1).concat("-").concat(unidad(numero - 30));
			}
		}
		else if ((numero >= 20) && (numero <= 29))
		{

			num_letra = "vint ";
			if (numero > 20) {
				num_letra = num_letra.substring(0, num_letra.length()-1).concat("-i-").concat(unidad(numero - 20));
			}
		}
		else if ((numero >= 10) && (numero <= 19))
		{
			switch (numero){
			case 10:

				num_letra = "deu ";
				break;

			case 11:

				num_letra = "onze ";
				break;

			case 12:

				num_letra = "dotze ";
				break;

			case 13:

				num_letra = "tretze ";
				break;

			case 14:

				num_letra = "catorze ";
				break;

			case 15:

				num_letra = "quinze ";
				break;

			case 16:

				num_letra = "setze ";
				break;

			case 17:

				num_letra = "disset ";
				break;

			case 18:

				num_letra = "divuit ";
				break;

			case 19:

				num_letra = "dinou ";
				break;

			}
		} else {
			num_letra = unidad(numero);
		}

	return num_letra;
	}

	private static String centena(int numero){
		if (numero >= 100)
		{
			if ((numero >= 900) && (numero <= 999))
			{
				num_letra = "nou-cents ";
				if (numero > 900) {
					num_letra = num_letra.concat(decena(numero - 900));
				}
			}
			else if ((numero >= 800) && (numero <= 899))
			{
				num_letra = "vuit-cents ";
				if (numero > 800) {
					num_letra = num_letra.concat(decena(numero - 800));
				}
			}
			else if ((numero >= 700) && (numero <= 799))
			{
				num_letra = "set-cents ";
				if (numero > 700) {
					num_letra = num_letra.concat(decena(numero - 700));
				}
			}
			else if ((numero >= 600) && (numero <= 699))
			{
				num_letra = "sis-cents ";
				if (numero > 600) {
					num_letra = num_letra.concat(decena(numero - 600));
				}
			}
			else if ((numero >= 500) && (numero <= 599))
			{
				num_letra = "cinc-cents ";
				if (numero > 500) {
					num_letra = num_letra.concat(decena(numero - 500));
				}
			}
			else if ((numero >= 400) && (numero <= 499))
			{
				num_letra = "quatre-cents ";
				if (numero > 400) {
					num_letra = num_letra.concat(decena(numero - 400));
				}
			}
			else if ((numero >= 300) && (numero <= 399))
			{
				num_letra = "tres-cents ";
				if (numero > 300) {
					num_letra = num_letra.concat(decena(numero - 300));
				}
			}
			else if ((numero >= 200) && (numero <= 299))
			{
				num_letra = "dos-cents ";
				if (numero > 200) {
					num_letra = num_letra.concat(decena(numero - 200));
				}
			}
			else if ((numero >= 100) && (numero <= 199))
			{
				num_letra = "cent ";
				if (numero > 100) {
					num_letra = num_letra.concat(decena(numero - 100));
				}
			}
		} else {
			num_letra = decena(numero);
		}

		return num_letra;
	}

	private static String miles(int numero){
		if ((numero >= 1000) && (numero <2000)){
			num_letram = ("mil ").concat(centena(numero%1000));
		}
		if ((numero >= 2000) && (numero <10000)){
			num_letram = unidad(numero/1000).concat(" mil ").concat(centena(numero%1000));
		}
		if (numero < 1000) {
			num_letram = centena(numero);
		}

		return num_letram;
	}

	private static String decmiles(int numero){
		if (numero == 10000) {
			num_letradm = "deu mil";
		}
		if ((numero > 10000) && (numero <20000)){
			num_letradm = decena(numero/1000).concat("mil ").concat(centena(numero%1000));
		}
		if ((numero >= 20000) && (numero <100000)){
			num_letradm = decena(numero/1000).concat(" mil ").concat(miles(numero%1000));
		}


		if (numero < 10000) {
			num_letradm = miles(numero);
		}

		return num_letradm;
	}

	private static String cienmiles(int numero){
		if (numero == 100000) {
			num_letracm = "cent mil";
		}
		if ((numero >= 100000) && (numero <1000000)){
			num_letracm = centena(numero/1000).concat(" mil ").concat(centena(numero%1000));
		}
		if (numero < 100000) {
			num_letracm = decmiles(numero);
		}
		return num_letracm;
	}

	private static String millon(int numero){
		if ((numero >= 1000000) && (numero <2000000)){
			num_letramm = ("Un milió ").concat(cienmiles(numero%1000000));
		}
		if ((numero >= 2000000) && (numero <10000000)){
			num_letramm = unidad(numero/1000000).concat(" milions ").concat(cienmiles(numero%1000000));
		}
		if (numero < 1000000) {
			num_letramm = cienmiles(numero);
		}

		return num_letramm;
	}

	private static String decmillon(int numero){
		if (numero == 10000000) {
			num_letradmm = "deu milions";
		}
		if ((numero > 10000000) && (numero <20000000)){
			num_letradmm = decena(numero/1000000).concat("milions ").concat(cienmiles(numero%1000000));
		}
		if ((numero >= 20000000) && (numero <100000000)){
			num_letradmm = decena(numero/1000000).concat(" milions ").concat(millon(numero%1000000));
		}


		if (numero < 10000000) {
			num_letradmm = millon(numero);
		}

		return num_letradmm;
	}


	public static String convertirLetras(int numero, boolean tipoLetra){
		String num_letras = "";
		if( numero == 0 )
		{
			num_letras = "zero";
		}
		else
		{
			num_letras = decmillon(numero);
		}
		if (tipoLetra == LLETRA_MAJUSCULA){
			return num_letras.toUpperCase();
		} else {
			return num_letras;
		}

	}
}
