package org.eclipse.vjet.vsf.dapunit;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleMsgValidator implements IMsgValidator {
	
	private String[] m_regExFilters;
	
	//
	// Constructors
	//
	public SimpleMsgValidator(){}
	
	public SimpleMsgValidator(final String[] regExFilters){
		m_regExFilters = regExFilters;
	}

	//
	// Satisfy IDomValidator
	//
	@Override
	public MsgError validate(final String expected, final String actual) {
		
		if (expected == null){
			return new MsgError("No more msg expected");
		}
		
		if (actual == null){
			return new MsgError("Actual msg is null");
		}
		
		if (actual.equals(expected)){
			return null;
		}
		
		if (isEquals(actual, expected)){
			return null;
		}

		return new MsgError("Actual msg doesn't match extected msg");
	}

	//
	// API
	//
	public String[] getRegExFilters() {
		return m_regExFilters;
	}

	public SimpleMsgValidator setRegExFilters(String[] regExFilters) {
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
