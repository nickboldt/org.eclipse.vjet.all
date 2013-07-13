package org.eclipse.vjet.vsf.dapunit;

import org.eclipse.vjet.dsf.common.exceptions.DsfRuntimeException;

public class DapUnitValidationFailureException extends DsfRuntimeException {

	private static final long serialVersionUID = 1L;

	public DapUnitValidationFailureException(final String message) {
		super(message);
	}
}
