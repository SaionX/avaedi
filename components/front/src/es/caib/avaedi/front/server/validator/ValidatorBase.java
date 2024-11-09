package es.caib.avaedi.front.server.validator;

public interface ValidatorBase {
	public boolean isNullable();

	public void setNullable(boolean nullable);

	public boolean validate(String valor);

	String getErrorMsg(String errorMsg);
}
