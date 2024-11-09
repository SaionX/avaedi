package es.caib.avaedi.at4forms.logic.bo;

import org.apache.commons.collections4.Transformer;

public interface ListadoTransformer<T, LO> extends Transformer<T, LO> {

	LO transform(T instance, LO ret);
	
}
