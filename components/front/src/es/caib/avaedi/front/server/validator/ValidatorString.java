package es.caib.avaedi.front.server.validator;

public class ValidatorString implements ValidatorBase {
	private boolean nullable;
	private Integer minLength;
	private Integer maxLength;
	private String cantContain;
	private String mustContain;
	private String lengthError = "El campo %s no cumple con los tamaños indicados";
	private String contentError = "El contenido del campo %s no es correcto";

	public ValidatorString(boolean nullable) {
		super();
		this.nullable = nullable;
	}

	public ValidatorString(boolean nullable, Integer minLength, Integer maxLength, String cantContain, String mustContain) {
		super();
		this.nullable = nullable;
		this.minLength = minLength;
		this.maxLength = maxLength;
		this.cantContain = cantContain;
		this.mustContain = mustContain;
	}

	public ValidatorString(boolean nullable, String cantContain, String mustContain) {
		super();
		this.nullable = nullable;
		this.cantContain = cantContain;
		this.mustContain = mustContain;
	}

	public ValidatorString(boolean nullable, Integer minLength, Integer maxLength) {
		super();
		this.nullable = nullable;
		this.minLength = minLength;
		this.maxLength = maxLength;
	}

	private boolean isLenghtValid(String valor) {
		if (minLength != null && maxLength != null) {
			int length = valor.length();
			if (length > minLength && length < maxLength) {
				return true;
			} else {
				return false;
			}
		}
		return true;
	}

	private boolean isContentValid(String valor) {
		if (cantContain != null && mustContain != null) {
			int cant = valor.indexOf(cantContain);
			int must = valor.indexOf(mustContain);
			if (cant < 0 && must > 0) {
				return true;
			} else {
				return false;
			}
		}

		return false;
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
		return isLenghtValid(valor) && isContentValid(valor);
	}

	@Override
	public String getErrorMsg(String valor) {
		String error = "";
		boolean hasErrors = false;
		if (!isLenghtValid(valor)) {
			hasErrors = true;
			error += this.lengthError;
		}
		if (!isContentValid(valor)) {
			hasErrors = true;
			error += this.contentError;
		}
		if (hasErrors) {
			return error;
		} else {
			return null;
		}
	}

	public int getMinLength() {
		return minLength;
	}

	public void setMinLength(int minLength) {
		this.minLength = minLength;
	}

	public int getMaxLength() {
		return maxLength;
	}

	public void setMaxLength(int maxLength) {
		this.maxLength = maxLength;
	}

	public String getCantContain() {
		return cantContain;
	}

	public void setCantContain(String cantContain) {
		this.cantContain = cantContain;
	}

	public String getMustContain() {
		return mustContain;
	}

	public void setMustContain(String mustContain) {
		this.mustContain = mustContain;
	}

}
