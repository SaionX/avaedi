package es.caib.avaedi.at4forms.common.audit;

import es.caib.avaedi.at4forms.logic.vo.FormVO;

import org.directwebremoting.annotations.DataTransferObject;

/**
 * TransferObject para el formulario AuditOperation
 */
@DataTransferObject
public class AuditOperationFormVO extends AuditOperationListadoVO implements FormVO {

	private static final long serialVersionUID = 1L;


    public AuditOperationFormVO() {
    }

}


