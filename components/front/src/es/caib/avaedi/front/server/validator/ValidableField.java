package es.caib.avaedi.front.server.validator;

import es.caib.avaedi.at4forms.common.util.StringUtils;

public class ValidableField {
	private String nombre;
	private String valor;
	private ValidatorBase validator;
	private String NULLERRORMSG = "El campo %s no puede estar vacio.";

	public ValidableField(String valor, String nombre, ValidatorBase validator) {
		this.nombre = nombre;
		this.valor = valor;
		this.validator = validator;
	}

	public ValidableField(Integer valor, String nombre, ValidatorBase validator) {
		this.valor = String.valueOf(valor);
		this.nombre = nombre;
		this.validator = validator;
	}

	public ValidableField(Boolean valor, String nombre, ValidatorBase validator) {
		this.valor = String.valueOf(valor);
		this.nombre = nombre;
		this.validator = validator;
	}

	public ValidableField(Double valor, String nombre, ValidatorBase validator) {
		this.valor = String.valueOf(valor);
		this.nombre = nombre;
		this.validator = validator;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public ValidatorBase getValidator() {
		return validator;
	}

	public void setValidator(ValidatorBase validator) {
		this.validator = validator;
	}

	public boolean isValid() {
		boolean valorVacio = StringUtils.isEmpty(this.valor);
		if (!this.validator.isNullable() && valorVacio) {
			return false;
		}
		return this.validator.validate(this.valor);
	}

	public String getErrors() {
		String error = "";
		boolean errorOcurred = false;
		boolean valorVacio = StringUtils.isEmpty(this.valor);
		if (!this.validator.isNullable() && valorVacio) {
			errorOcurred = true;
			error += String.format(this.NULLERRORMSG, this.nombre);
		}
		if (this.validator.validate(this.valor)) {
			errorOcurred = true;
			error += String.format(this.NULLERRORMSG, this.nombre);
		}
		if (errorOcurred) {
			return error;
		} else {
			return null;
		}

	}

}
