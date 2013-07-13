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
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.eclipse.vjet.dsf.common.Z;
import org.eclipse.vjet.dsf.common.context.BaseSubCtx;
import org.eclipse.vjet.dsf.common.context.ContextHelper;
import org.eclipse.vjet.dsf.common.context.DsfCtx;
import org.eclipse.vjet.dsf.resource.content.runtime.BaseVariationResolver;


/**
 * Defines a thread-local context to hold Permutation-related data
 * including the locale and target. All Permutation-related
 * information is available or settable on this context.
 *
 */
public class Permutation extends BaseSubCtx implements Serializable {
	private static final long serialVersionUID = -3734003316566272166L;
	private static PermutationSpec s_permutationSpec = new DefaultPermutationSpec();

	private final Locale m_language;
	private final String m_target;
	private final String m_external;
	private final String m_innerStr;
	private final List<String> m_compatibleExternals;
	private final Permutation m_parent;
	private String m_country;

	public static PermutationSpec getPermutationSpec() {
		return s_permutationSpec;
	}

	public static void setPermutationSpec(final PermutationSpec permutationSpec) {
		s_permutationSpec = permutationSpec;
	}

	// context related ops
	public static Permutation getFromCtx() {
		return getFromCtx(DsfCtx.ctx());
	}

	public static Permutation getFromCtx(final DsfCtx ctx) {
		Permutation context = CtxAssociator.getCtx(ctx);
		if (context == null) {
			context = getDefault();
			setToCtx(context);
		}
		return context;
	}

	public static void resetCtx() {
		setToCtx(getDefault());
	}

	public static void setToCtx(final Permutation permutation) {
		CtxAssociator.setCtx(permutation);
	}

	public static void updateCtx(final Locale locale, final String target) {
		setToCtx(create(locale, target));
	}

	public static void updateCtx(final Locale locale) {
		updateCtx(locale, null);
	}

	public static boolean isDefaultTarget(final String target) {
		return getPermutationSpec().isDefaultTarget(target);
	}

	// spec related ops
	public static boolean isDefault(final Permutation permutation) {
		return getPermutationSpec().isDefaultPermutation(permutation);
	}

	public static Permutation getDefault() {
		return getPermutationSpec().getDefaultPermutation();
	}

	// factory ops
	public static Permutation create(final Locale locale) {
		return create(locale, null);
	}

	public static Permutation create(final Locale locale, final String target) {
		return new Permutation(locale, target);
	}

	public static Permutation createLanguagePermutation(final Permutation parent, final Locale language) {
		return new Permutation(parent, language, parent.getTarget());
	}

	public static Permutation createLanguagePermutation(final Permutation parent, final Locale language, final String target) {
		return new Permutation(parent, language, target);
	}

	public static Permutation createCountryPermutation(final Permutation parent, final String country) {
		return new Permutation(parent, country, parent.getTarget());
	}

	public static Permutation createCountryPermutation(final Permutation parent, final String country, final String target) {
		return new Permutation(parent, country, target);
	}

	public static Permutation fromExternal(final String external) {
		return fromExternal(external,false);
	}

	public static Permutation fromExternal(final String external, boolean useDefaultTarget){
		return getPermutationSpec().fromExternalWithDefault(external, useDefaultTarget);
	}


	public static Locale fromExternalLocale(final String external){
		return getPermutationSpec().fromExternalLocale(external);
	}
	
	public static Map<String, BaseVariationResolver> getVariationResolvers() {
		return getVariationCtx().getVariationResolvers();
	}

	
	public static void setVariationResolvers(List<BaseVariationResolver> resolvers) {
		getVariationCtx().addVariationResolvers(resolvers);
	}
	
	public static void registerVariationResolver(BaseVariationResolver resolver) {		
		getVariationCtx().registerVariationResolver(resolver);
	}
	
	private static VariationCtx getVariationCtx() {
		VariationCtx variationCtx = CtxAssociator.getVariationCtx(DsfCtx.ctx());
		if (variationCtx == null) {
			variationCtx = new VariationCtx();
			CtxAssociator.setVariationCtx(variationCtx);
		}
		return variationCtx;
	}

	protected Permutation(final Permutation parent, final Locale extLanguage, final String target) {
		this(parent, null, extLanguage, target);
	}

	protected Permutation(final Locale locale, final String target) {
		this(null, null, locale, target);
	}

	protected Permutation(final Permutation parent, final String country, final String target) {
		this(parent, country, null, target);
	}

	protected Permutation(final Permutation parent, final String country, final Locale language, final String target) {
		m_parent = parent;
		m_country = country;
		if (language == null) {
			if (m_parent != null) {
				m_language = parent.getLanguage();
			}
			else {
				m_language = getPermutationSpec().getDefaultPermutation().getLocale();
			}
		} 
		else {
			m_language = language;
		}
		m_target = target;
		m_innerStr = asString();
		m_external = getPermutationSpec().toExternal(this);
		m_compatibleExternals 
			= getPermutationSpec().getExternalsWithResolutionOrder(this);
	}

	public void setToCtx() {
		Permutation.setToCtx(this);
	}

	public boolean isDefault() {
		return getPermutationSpec().isDefaultPermutation(this);
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || !(o instanceof Permutation)) {
			return false;
		}
		Permutation permutation = (Permutation) o;
		return m_innerStr.equals(permutation.m_innerStr);
	}

	@Override
	public int hashCode() {
		return m_innerStr.hashCode();
	}

	private String asString() {
		StringBuffer buf = new StringBuffer();
		if (isLanguageSpecific()) {
			buf.append(m_language);
			buf.append(PermutationSpec.VARIATION_SEPARATOR);
			buf.append(m_parent.asString());
		}
		if (isCountrySpecific()) {
			buf.append(m_country);
			buf.append(PermutationSpec.VARIATION_SEPARATOR);
			buf.append(m_parent.asString());
		}
		else {
			if (m_language != null) {
				buf.append(m_language);
			}
			if (m_language != null && m_target != null) {
				buf.append(PermutationSpec.TARGET_DELIMETER);
			}
			if (m_target != null) {
				buf.append(m_target);
			}
		}
		return buf.toString();
	}

	public String toExternal() {
		return m_external;
	}

	public List<String> getExternalsWithResolutionOrder() {
		return m_compatibleExternals;
	}

	/**  
	 * ATTENTION: do not use this method for country specific logic.
	 * Please use PC/Site policy and only if it is not possible, please use Permutation.getCountry method 
	 * @return
	 * @deprecated please use getLanguage method
	 */
	public Locale getLocale() {
		return m_language;
	}

	public Locale getLanguage() {
		return m_language;
	}
	
	public String getCountry() {
		if (isLanguageSpecific()) {
			return m_parent.getCountry();
		}
		if (isCountrySpecific()) {
			return m_country;
		}
		return m_language.getCountry();
	}

	public String getTarget() {
		return m_target;
	}

	public Permutation getParent() {
		return m_parent;
	}

	public boolean isExtended() {
		return m_parent != null;
	}

	public boolean isLanguageSpecific() {
		return isExtended() && m_country == null;
	}

	public boolean isCountrySpecific() {
		return isExtended() && m_country != null;
	}
	
	public static boolean isLanguageSpecific(String external) {
		return PermutationSpec.isLanguagePermutation(external);
	}

	//
	// Override(s) from Object
	//
	@Override
	public String toString() {
		Z z = new Z();
		if (isLanguageSpecific()) {
			z.format("language", m_language);
			z.format("locale", getParent().getLocale());
		}
		else {
			z.format("locale", m_language);
		}
		z.format("target", m_target);
		if (isCountrySpecific()) {
			z.format("country", m_country);
		}
		z.format("external", m_external);
		z.format("compatibleExternals", m_compatibleExternals) ;
		z.format("spec", getPermutationSpec());
		return z.toString();
	}

	/**
	 * Associate with DsfCtx
	 */
	private static class CtxAssociator extends ContextHelper {
		private static final String CTX_NAME = 
				Permutation.class.getSimpleName();
		private static final String VARIATION_CTX_NAME = 
				VariationCtx.class.getSimpleName();
		

		protected static Permutation getCtx(final DsfCtx ctx) {
			return (Permutation) getSubCtx(ctx, CTX_NAME);
		}

		protected static void setCtx(final Permutation ctx) {
			setSubCtx(DsfCtx.ctx(), CTX_NAME, ctx);
		}
		
		protected static VariationCtx getVariationCtx(final DsfCtx ctx) {
			return (VariationCtx) getSubCtx(ctx, VARIATION_CTX_NAME);
		}

		protected static void setVariationCtx(final VariationCtx variationCtx) {
			setSubCtx(DsfCtx.ctx(), VARIATION_CTX_NAME, variationCtx);
		}
	}

	public static void main(String[] args) {
		System.out.println(Permutation.fromExternal("en_US"));
		System.out.println(Permutation.fromExternal("en"));
		System.out.println(Permutation.fromExternal("en_US_autos"));
		System.out.println(Permutation.fromExternal("en_US__T"));
		System.out.println(Permutation.fromExternal("en__T"));
		System.out.println(Permutation.fromExternal("en_US_autos__T"));
		System.out.println(Permutation.fromExternal("en_CN"));
		System.out.println(Permutation.fromExternal("en_CN__T"));
		System.out.println(Permutation.fromExternal("en_CN_autos__T"));
		System.out.println(Permutation.fromExternal("dd_CN"));
		System.out.println(Permutation.fromExternal("dd_CN__T"));
		System.out.println(Permutation.fromExternal("dd_CN_autos__T"));
		System.out.println(Permutation.fromExternal("en_DD"));
		System.out.println(Permutation.fromExternal("en_DD__T"));
		System.out.println(Permutation.fromExternal("en_DD_autos__T"));

	}

}
