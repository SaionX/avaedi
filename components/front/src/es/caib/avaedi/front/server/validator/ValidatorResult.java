package es.caib.avaedi.front.server.validator;

public class ValidatorResult {
	private boolean valid;
	private String error;

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public ValidatorResult(boolean valid, String error) {
		super();
		this.valid = valid;
		this.error = error;
	}

}
