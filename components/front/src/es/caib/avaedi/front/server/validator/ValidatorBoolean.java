package es.caib.avaedi.front.server.validator;

public class ValidatorBoolean implements ValidatorBase {
	private boolean nullable;

	public ValidatorBoolean(boolean nullable) {
		super();
		this.nullable = nullable;
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
		if (!this.isNullable() && (valor == null || valor.equals("null"))) {
			return false;
		}
		return true;
	}

	@Override
	public String getErrorMsg(String valor) {
		return null;
	}

}
