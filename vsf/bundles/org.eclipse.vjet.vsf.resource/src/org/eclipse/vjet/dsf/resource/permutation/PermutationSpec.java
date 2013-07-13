/*******************************************************************************
 * Copyright (c) 2012 eBay Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     eBay Inc. - initial API and implementation
 *******************************************************************************/
package org.eclipse.vjet.dsf.resource.permutation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Provides methods for working with Permutations, mapping
 * from external forms to a Permutation and vice-versa,
 * getting all known Permutations, and so forth.
 * 
 * Permutations can be obtained from external Locale-like
 * strings if you only have such a string using code like:
 * 
 * <pre>
 *    Permutation perm = Permutation.fromExternal("de_DE");
 *
 */
public abstract class PermutationSpec implements Serializable {

	static final String TARGET_DELIMETER = "__";
	static final String VARIATION_SEPARATOR = "___";
	protected Permutation[] m_allPermutations = new Permutation[0];


	//
	// Framework
	//
	public abstract Permutation getDefaultPermutation();
	abstract public String getDefaultTarget();
	
	//
	// API
	//
	public Permutation[] getAllPermutations() {
		return m_allPermutations;
	}
	
	//
	// Lookup permutation for this permutation spec. Only registered 
	// permutations are returned. This method won't dynamically create
	// permutation when it is missing.
	// 
	// Ideally, this method should be abstract. However, making this
	// method abstract breaks backward compatibility. The question is
	// do we want to break everybody and force them to implement this method
	// during upgrade? Or we come up with some reasonable default behavior
	// so if they don't change their code, it would still working?
	// 
	// Overall, we decide the later approach is better. 
	//
	public Permutation lookup(Locale language, String target){
		return lookupInternal(language, null, target);
	}
	
	public Permutation lookup(Locale language, String country, String target){
		return lookupInternal(language, country, target);
	}
	
	private Permutation lookupInternal(Locale language, String country, String target){
		if(m_allPermutations == null){
			return null;
		}
		
		for(Permutation perm: m_allPermutations){
			if((safeEquals(language, perm.getLanguage()) && safeEquals(target, perm.getTarget()) && safeEquals(country, perm.getCountry()))){
				return perm;
			}
		}
		
		return null;
	}

	public boolean safeEquals(Object o1, Object o2){
		if(o1 == null && o2 == null){
			return true;
		}
		
		if(o1 == null || o2 == null){
			return false;
		}
		
		return o1.equals(o2);
	}
	
	

	public boolean isDefaultPermutation(Permutation permutation) {
		Permutation defaultPermutation = getDefaultPermutation();
		if (defaultPermutation == null) {
			return (permutation == null);
		}
		return defaultPermutation.equals(permutation);
	}

	public boolean isDefaultTarget(String target) {
		String defaultTarget = getDefaultTarget();
		if (defaultTarget == null) {
			return (target == null);
		}
		return defaultTarget.equals(target);
	}
	
	public static boolean isLanguagePermutation(String external) {
		return external != null 
			&& external.contains(VARIATION_SEPARATOR) // if it contains '____'
			&& external.charAt(0) >= 'a' && external.charAt(0) <= 'z'; // if it starts with locale: xx_XX____
	}
	
	public String toExternal(Permutation permutation) {
		if (permutation == null) {
			return null;
		}
		
		if (permutation.isLanguageSpecific()) {
			return toExternal(permutation.getParent(), permutation.getLocale());
		}
		
		if (permutation.isCountrySpecific()) {
			return toExternal(permutation.getParent(), permutation.getCountry());
		}
		
		Locale locale = permutation.getLocale();
		String target = permutation.getTarget();
		
		return toExternal(locale, target);
	}

	public String toExternal(Locale locale, String target) {
		StringBuffer buf = new StringBuffer();
		if (locale != null) {
			buf.append(locale);
		}
		if (locale != null && target != null && !isDefaultTarget(target)) {
			buf.append(TARGET_DELIMETER);
		}
		if (target != null && !isDefaultTarget(target)) {
			buf.append(target);
		}
		return buf.toString();
	}

	public String toExternal(Permutation parent, Locale language) {
		StringBuffer buf = new StringBuffer();
		buf.append(language)
			.append(VARIATION_SEPARATOR)
			.append(parent.toExternal());
		return buf.toString();
	}

	public String toExternal(Permutation parent, String country) {
		StringBuffer buf = new StringBuffer();
		buf.append(country)
			.append(VARIATION_SEPARATOR)
			.append(parent.toExternal());
		return buf.toString();
	}

	public Permutation fromExternal(String external) {
		return fromExternalWithDefault(external, false);
	}
	
	/**
	 * Returns a Permutation from compatible external string
	 * @param external - the compatible external string.  i.e. de_DE
	 * @param useDefaultTarget - if true, returns a permutation with default target set. otherwise, returns a permutation with null target
	 * @return
	 */
	public Permutation fromExternalWithDefault(String external, boolean useDefaultTarget) {
		if (external == null || external.length() == 0) {
			return getDefaultPermutation();
		}
		
		if (external.contains(VARIATION_SEPARATOR)) {

			String[] tokens = external.split(VARIATION_SEPARATOR, 2);

			Permutation parent = fromExternalWithDefault(tokens[1], useDefaultTarget);

			if (tokens[0].length() == 2 
					&& tokens[0].toUpperCase().equals(tokens[0])) { // country specific permutation
				return extendByCountry(parent, tokens[0]);
			}
			else {
				Locale language = fromExternalLocale(tokens[0]);
				return extendByLanguage(parent, language);
			}
		}
		
		String localeStr = external;
		String target = null;
		int targetIdx = external.lastIndexOf(TARGET_DELIMETER);
		if (targetIdx != -1) {
			target = external.substring(targetIdx + TARGET_DELIMETER.length());
			localeStr = external.substring(0, targetIdx);
		}
		else{
			if(useDefaultTarget){
				target = getDefaultTarget();
			}
		}
		Locale locale = fromExternalLocale(localeStr);
		
		if (locale == null) {
			return null;
		}
		
		Permutation perm = lookupInternal(locale, null, target);
		if(perm == null){
			perm = Permutation.create(locale, target);
		}
		
		return perm;
	}
	
	public Locale fromExternalLocale(String localeStr) {
		
		if (localeStr == null) {
			return null;
		}
		
		String lang = localeStr;
		String country = "";
		String var = "";
		int contryIdx = localeStr.indexOf("_");
		if (contryIdx != -1) {
			lang = localeStr.substring(0, contryIdx);
			country = localeStr.substring(contryIdx + 1);
			int varIdx = country.indexOf("_");
			if (varIdx != -1) {
				var = country.substring(varIdx + 1);
				country = country.substring(0, varIdx);
			}
		}
		boolean isLangValid = isValidLanguage(lang);
		boolean isCountryValid = false;
		if (country.length() == 0) {
			isCountryValid = true;
		} else {
			for (String validCn : Locale.getISOCountries()) {
				if (validCn.equals(country)) {
					isCountryValid = true;
					break;
				}
			}
		}
		if (!isLangValid || !isCountryValid) {
			return null;
		}
		Locale locale = new Locale(lang, country, var);
		return locale;
	}
	
	protected boolean isValidLanguage(String lang) {
		boolean isLangValid = false;
		for (String validLang : Locale.getISOLanguages()) {
			if (validLang.equals(lang)) {
				isLangValid = true;
				break;
			}
		}
		return isLangValid;
	} 

	public List<String> getExternalsWithResolutionOrder(Permutation permutation) {
		if (permutation == null) {
			return null;
		}
		List<String> result = new ArrayList<String>(4);
		result.add(permutation.toExternal());
		Locale locale = permutation.getLocale();
		if (locale != null) {
			String localeStr = locale.toString();
			if (!result.contains(localeStr)) {
				result.add(localeStr);
			}
			if (locale.getVariant() != null
					&& locale.getVariant().length() != 0) {
				Locale localeWithVar = new Locale(locale.getLanguage(), locale
						.getCountry());
				localeStr = localeWithVar.toString();
				if (!result.contains(localeStr)) {
					result.add(localeStr);
				}
			}
			if (locale.getCountry() != null
					&& locale.getCountry().length() != 0) {
				Locale localeWithCountry = new Locale(locale.getLanguage());
				localeStr = localeWithCountry.toString();
				if (!result.contains(localeStr)) {
					result.add(localeStr);
				}
			}
		}
		result.add("");
		return result;
	}

	protected static Permutation[] listToArray(List<Permutation> list) {
		Permutation[] result = new Permutation[list.size()];
		list.toArray(result);
		return result;
	}
	
	public Locale[] getSupportedLanguages(Permutation permutation) {
		if (permutation.isCountrySpecific()) {
			permutation = permutation.getParent();
		}
		return new Locale[]{ permutation.getLocale() };
	}

	public Permutation extendByLanguage(Permutation permutation, final Locale language) {
		return extendByLanguage(permutation, language, permutation.getTarget());
	}

	protected Permutation extendByLanguage(Permutation permutation, final Locale language, String target) {
		if (permutation.getLanguage().equals(language)) {
			return permutation; // skip
		}
		if (permutation.isLanguageSpecific()) {
			throw new RuntimeException("Parent permutation cannot be of language Permutation type, permutation: " + permutation.toExternal());
		}
		return new Permutation(permutation, language, target);
	}
	
	public Permutation extendByCountry(Permutation parent, String country) {
		return extendByCountry(parent, country, parent.getTarget());
	}

	protected Permutation extendByCountry(Permutation parent, String country, String target) {
		
		if (parent.getCountry().equals(country)) {
			return parent; // skip
		}
		
		if (parent.isExtended()) {
			throw new RuntimeException("Parent permutation is already extended permutation, parent: " 
					+ parent.toExternal()
					+ ", country: " + country);
		}
		
		Permutation perm = lookupInternal(parent.getLanguage(), country, target);
		if (perm == null) {
			perm = Permutation.createCountryPermutation(parent, country, target);
		}
		return perm;
	}
	
}
