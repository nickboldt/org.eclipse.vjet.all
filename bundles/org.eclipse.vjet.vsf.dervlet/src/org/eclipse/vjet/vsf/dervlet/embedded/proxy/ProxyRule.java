package org.eclipse.vjet.vsf.dervlet.embedded.proxy;

public class ProxyRule {

	public final static int INCLUDES = 0;
	public final static int EXCLUDES = 1;
	public final static int NOT_MATCH = 2;
	
	private String m_resourceURI;
	private String m_includes;
	private String m_excludes;
	private boolean isV4Resource = false;
	
	public ProxyRule(String resourceURI, String includes, String excludes) {
		m_resourceURI = resourceURI;
		m_includes = includes;
		m_excludes = excludes;
		
		isV4Resource = resourceURI.toUpperCase().indexOf("V4") == 0;
	}
	
	public String getExcludes() {
		return m_excludes;
	}
	
	/*public void setExcludes(String excludes) {
		this.m_excludes = excludes;
	}
*/	
	public String getIncludes() {
		return m_includes;
	}
	
	
	public int match(String uri) {
		
		if (m_resourceURI == null) {
			return NOT_MATCH;
		}
		
		if (!matchURI(uri)) {
			return NOT_MATCH;
		}
		
		if (isV4Resource) {
			return matchV4(uri);
		}
		
		if (match (m_includes, uri)) {
			return match(m_excludes, uri)? EXCLUDES: INCLUDES;
		}
		
		return NOT_MATCH;
	}

	private int matchV4(String uri) {
		String[] auri = uri.split("/");
		String fileName = auri[auri.length -1];
		
		int type = auri[1].toUpperCase().equals("V4CSS")? ProxyServerConfig.CSS: ProxyServerConfig.JS; 
			
		String[] elements = fileName.split("_");
		if (elements.length > 1) {
			AppSpecRule appSpecRule = ProxyServerConfig.getInstance().getAppSpecRules(type).get(elements[0]);
			if (appSpecRule !=  null) {
				return appSpecRule.match(fileName, this.m_resourceURI)? INCLUDES: EXCLUDES;
			}
		}
		
		return EXCLUDES;
	}
	
	public boolean matchURI(String uri) {
		String[] auri = uri.split("/");
		if (auri.length <= 1 || !auri[1].equals(this.m_resourceURI)) {
			return false;
		} else {
			return true;
		}
	}
	
	public boolean match(String patterns, String str) {
		if (patterns == null) {
			return false;
		}
		
		String[] patternArr = patterns.split(",");
		
		for (int i = 0 ; i < patternArr.length; i++) {
			if (this.match("/" + this.m_resourceURI + "/" + patternArr[i], str, false)) {
				return true;
			}
		}
		
		return false;
	}
	
    public boolean match(String pattern, String str,
			boolean isCaseSensitive) {
		char[] patArr = pattern.toCharArray();
		char[] strArr = str.toCharArray();
		int patIdxStart = 0;
		int patIdxEnd = patArr.length - 1;
		int strIdxStart = 0;
		int strIdxEnd = strArr.length - 1;
		char ch;

		boolean containsStar = false;
		for (int i = 0; i < patArr.length; i++) {
			if (patArr[i] == '*') {
				containsStar = true;
				break;
			}
		}

		if (!containsStar) {
			// No '*'s, so we make a shortcut
			if (patIdxEnd != strIdxEnd) {
				return false; // Pattern and string do not have the same size
			}
			for (int i = 0; i <= patIdxEnd; i++) {
				ch = patArr[i];
				if (ch != '?') {
					if (isCaseSensitive && ch != strArr[i]) {
						return false; // Character mismatch
					}
					if (!isCaseSensitive
							&& Character.toUpperCase(ch) != Character
									.toUpperCase(strArr[i])) {
						return false; // Character mismatch
					}
				}
			}
			return true; // String matches against pattern
		}

		if (patIdxEnd == 0) {
			return true; // Pattern contains only '*', which matches anything
		}

		// Process characters before first star
		while ((ch = patArr[patIdxStart]) != '*' && strIdxStart <= strIdxEnd) {
			if (ch != '?') {
				if (isCaseSensitive && ch != strArr[strIdxStart]) {
					return false; // Character mismatch
				}
				if (!isCaseSensitive
						&& Character.toUpperCase(ch) != Character
								.toUpperCase(strArr[strIdxStart])) {
					return false; // Character mismatch
				}
			}
			patIdxStart++;
			strIdxStart++;
		}
		if (strIdxStart > strIdxEnd) {
			// All characters in the string are used. Check if only '*'s are
			// left in the pattern. If so, we succeeded. Otherwise failure.
			for (int i = patIdxStart; i <= patIdxEnd; i++) {
				if (patArr[i] != '*') {
					return false;
				}
			}
			return true;
		}

		// Process characters after last star
		while ((ch = patArr[patIdxEnd]) != '*' && strIdxStart <= strIdxEnd) {
			if (ch != '?') {
				if (isCaseSensitive && ch != strArr[strIdxEnd]) {
					return false; // Character mismatch
				}
				if (!isCaseSensitive
						&& Character.toUpperCase(ch) != Character
								.toUpperCase(strArr[strIdxEnd])) {
					return false; // Character mismatch
				}
			}
			patIdxEnd--;
			strIdxEnd--;
		}
		if (strIdxStart > strIdxEnd) {
			// All characters in the string are used. Check if only '*'s are
			// left in the pattern. If so, we succeeded. Otherwise failure.
			for (int i = patIdxStart; i <= patIdxEnd; i++) {
				if (patArr[i] != '*') {
					return false;
				}
			}
			return true;
		}

		// process pattern between stars. padIdxStart and patIdxEnd point
		// always to a '*'.
		while (patIdxStart != patIdxEnd && strIdxStart <= strIdxEnd) {
			int patIdxTmp = -1;
			for (int i = patIdxStart + 1; i <= patIdxEnd; i++) {
				if (patArr[i] == '*') {
					patIdxTmp = i;
					break;
				}
			}
			if (patIdxTmp == patIdxStart + 1) {
				// Two stars next to each other, skip the first one.
				patIdxStart++;
				continue;
			}
			// Find the pattern between padIdxStart & padIdxTmp in str between
			// strIdxStart & strIdxEnd
			int patLength = (patIdxTmp - patIdxStart - 1);
			int strLength = (strIdxEnd - strIdxStart + 1);
			int foundIdx = -1;
			strLoop: for (int i = 0; i <= strLength - patLength; i++) {
				for (int j = 0; j < patLength; j++) {
					ch = patArr[patIdxStart + j + 1];
					if (ch != '?') {
						if (isCaseSensitive
								&& ch != strArr[strIdxStart + i + j]) {
							continue strLoop;
						}
						if (!isCaseSensitive
								&& Character.toUpperCase(ch) != Character
										.toUpperCase(strArr[strIdxStart + i + j])) {
							continue strLoop;
						}
					}
				}

				foundIdx = strIdxStart + i;
				break;
			}

			if (foundIdx == -1) {
				return false;
			}

			patIdxStart = patIdxTmp;
			strIdxStart = foundIdx + patLength;
		}

		// All characters in the string are used. Check if only '*'s are left
		// in the pattern. If so, we succeeded. Otherwise failure.
		for (int i = patIdxStart; i <= patIdxEnd; i++) {
			if (patArr[i] != '*') {
				return false;
			}
		}
		return true;
	}

	public String getResourceURI() {
		return m_resourceURI;
	}

	public void setRresourceURI(String m_resourceuri) {
		m_resourceURI = m_resourceuri;
	}
	
}
