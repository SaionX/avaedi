package es.caib.avaedi.front.server.validator;

public class ValidatorNumber implements ValidatorBase {
	private boolean nullable;
	private Double min;
	private Double max;
	private Double equal;
	private Double notEqual;
	private String errorEq = "El campo %s no es igual al valor necesario.";
	private String errorNEq = "El campo %s no debe ser igual al valor necesario.";
	private String errorMin = "El campo %s no es menor que el valor especificado.";
	private String errorMax = "El campo %s no es mayor que el valor especificado.";

	public ValidatorNumber(boolean nullable, Double min, Double max, Double equal, Double notEqual) {
		super();
		this.nullable = nullable;
		this.min = min;
		this.max = max;
		this.equal = equal;
		this.notEqual = notEqual;
	}

	public ValidatorNumber(boolean nullable) {
		super();
		this.nullable = nullable;
	}

	public ValidatorNumber(boolean nullable, Double equal) {
		super();
		this.nullable = nullable;
		this.equal = equal;
	}

	public ValidatorNumber(boolean nullable, Double equal, Double notEqual) {
		super();
		this.nullable = nullable;
		this.equal = equal;
		this.notEqual = notEqual;
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
		Double val = Double.parseDouble(valor);
		if (!this.isNullable() && val == null) {
			return false;
		}
		if (this.equal != null) {
			if (!val.equals(this.equal)) {
				return false;
			}
		}
		if (this.notEqual != null) {
			if (val.equals(this.notEqual)) {
				return false;
			}
		}
		if (this.min != null) {
			if (!(val.compareTo(this.min) < 0)) {
				return false;
			}
		}
		if (this.max != null) {
			if (!(val.compareTo(this.max) > 0)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public String getErrorMsg(String valor) {
		Double val = Double.parseDouble(valor);
		String error = "";
		if (this.equal != null) {
			if (!val.equals(this.equal)) {
				error += this.errorEq;
			}
		}
		if (this.notEqual != null) {
			if (val.equals(this.notEqual)) {
				error += this.errorNEq;
			}
		}
		if (this.min != null) {
			if (!(val.compareTo(this.min) < 0)) {
				return this.errorMin;
			}
		}
		if (this.max != null) {
			if (!(val.compareTo(this.max) > 0)) {
				return this.errorMax;
			}
		}
		return error;
	}

}
