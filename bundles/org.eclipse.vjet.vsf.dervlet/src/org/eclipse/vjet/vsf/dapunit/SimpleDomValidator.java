package org.eclipse.vjet.vsf.dapunit;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.vjet.dsf.dap.cnr.DapCaptureData.IDomChange;
import org.eclipse.vjet.vsf.dapunit.DomError.Type;


public class SimpleDomValidator implements IDomValidator {
	
	private String[] m_regExFilters;
	
	//
	// Constructors
	//
	public SimpleDomValidator(){}
	
	public SimpleDomValidator(final String[] regExFilters){
		m_regExFilters = regExFilters;
	}

	//
	// Satisfy IDomValidator
	//
	@Override
	public DomError validate(final IDomChange expected, final IDomChange actual) {
		
		if (expected == null || expected.toString() == null){
			return new DomError(Type.EXPECTED_DOM_CHANGE_NULL, "No more dom change expected");
		}
		
		if (actual == null || actual.toString() == null){
			return new DomError(Type.ACTUAL_DOM_CHANGE_NULL, "Actual dom change is null");
		}
		
		if (actual.toString().equals(expected.toString())){
			return null;
		}
		
		if (isEquals(actual.toString(), expected.toString())){
			return null;
		}

		return new DomError(Type.ACTUAL_DOM_CHANGE_INVALID, "Actual dom change doesn't match extected dom change");
	}

	//
	// API
	//
	public String[] getRegExFilters() {
		return m_regExFilters;
	}

	public SimpleDomValidator setRegExFilters(String[] regExFilters) {
		m_regExFilters = regExFilters;
		return this;
	}
	
	//
	// Private
	//
	private boolean isEquals(String source, String target) {
		boolean equals = source.equalsIgnoreCase(target);
		if (!equals && m_regExFilters != null) {
			for (int i = 0; i < m_regExFilters.length; i++) {
				String filter = m_regExFilters[i];
				Pattern p = Pattern.compile(filter);
				Matcher sourceMatcher = p.matcher(source);
				Matcher targetMatcher = p.matcher(target);
				String sourceNew = sourceMatcher.replaceAll(filter);
				String targetNew = targetMatcher.replaceAll(filter);
				if (sourceNew.equalsIgnoreCase(targetNew)) {
					return true;
				}
			}
		}
		return equals;
	}
}
