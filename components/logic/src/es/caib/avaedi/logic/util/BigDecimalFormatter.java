package es.caib.avaedi.logic.util;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class BigDecimalFormatter extends XmlAdapter<String, BigDecimal> {
	
	private static NumberFormat formatter = NumberFormat.getInstance(Locale.FRANCE);

	@Override
	public String marshal(BigDecimal arg0) throws Exception {
		return BigDecimalFormatter.formatter.format(arg0);
	}

	@Override
	public BigDecimal unmarshal(String arg0) throws Exception {
	    Number number = BigDecimalFormatter.formatter.parse(arg0);
	    double d = number.doubleValue();
		return new BigDecimal(d);
	}
}
