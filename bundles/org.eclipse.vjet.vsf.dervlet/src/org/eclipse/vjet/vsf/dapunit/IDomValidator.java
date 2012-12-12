package org.eclipse.vjet.vsf.dapunit;

import org.eclipse.vjet.dsf.dap.cnr.DapCaptureData.IDomChange;

public interface IDomValidator {
	DomError validate(IDomChange expected, IDomChange actual);
}
