package es.caib.avaedi.front.server.validator;

public class ValidatorRegex implements ValidatorBase {
	public static String EMAIL_REGEX = "^(([a-zA-Z]|[0-9])|([-]|[_]|[.]))+[@](([a-zA-Z0-9])|([-])){2,63}[.](([a-zA-Z0-9]){2,3})";

	private String regex;
	private boolean nullable;
	private String errorMsg = "El campo %s incorrecto.";

	public ValidatorRegex(boolean nullable, String regex) {
		this.regex = regex;
		this.nullable = nullable;
	}

	public void setRegex(String regex) {
		this.regex = regex;
	}

	public String getRegex() {
		return regex;
	}

	@Override
	public boolean isNullable() {
		return this.nullable;
	}

	@Override
	public void setNullable(boolean nullable) {
		this.nullable = nullable;
	}

	@Override
	public boolean validate(String valor) {
		if (valor == null && this.nullable) {
			return true;
		}
		if (valor == null && !this.nullable) {
			return false;
		}
		return valor.matches(this.regex);
	}

	@Override
	public String getErrorMsg(String valor) {
		if (this.validate(valor)) {
			return errorMsg;
		}
		return null;
	}

}
