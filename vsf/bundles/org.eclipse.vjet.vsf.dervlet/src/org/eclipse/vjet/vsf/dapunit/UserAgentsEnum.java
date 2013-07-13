package org.eclipse.vjet.vsf.dapunit;

import java.util.ArrayList;

import org.eclipse.vjet.dsf.common.enums.BaseEnum;


public class UserAgentsEnum extends BaseEnum {
	private String m_browser;

	public static final UserAgentsEnum NONE = new UserAgentsEnum(
			"None",
			0, "None");

	public static final UserAgentsEnum IE_6_DOT_0 = new UserAgentsEnum(
			"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.2; WOW64; SV1; .NET CLR 1.1.4322; .NET CLR 2.0.50727; InfoPath.1)",
			1, "IE6.0");

	public static final UserAgentsEnum FF_2_DOT_0 = new UserAgentsEnum(
			"Mozilla/5.0 (Windows; U; Windows NT 5.2; en-US; rv:1.8.1.12) Gecko/20081217 Firefox/2.0.0.20",
			2, "FF 2.0.0.20");

	public static final UserAgentsEnum FF_3_DOT_0 = new UserAgentsEnum(
			"Mozilla/5.0 (Windows; U; Windows NT 5.2; en-US; rv:1.9.0.1) Gecko/2008070208 Firefox/3.0.1",
			3, "FF 3.0.1");

	public static final UserAgentsEnum SAFARI_MAC_2_DOT_0 = new UserAgentsEnum(
			"Mozilla/5.0 (Macintosh; U; PPC Mac OS; pl-pl) AppleWebKit/412 (KHTML, like Gecko) Safari/412",
			4, "Safari Mac 2.0");

	public static final UserAgentsEnum SAFARI_WIN_4_DOT_0 = new UserAgentsEnum(
			"Mozilla/5.0 (Windows; U; Windows NT 6.0; ja-JP) AppleWebKit/528.16 (KHTML, like Gecko) Version/4.0 Safari/528.16",
			5, "Safari Win 4.0");

	
	private UserAgentsEnum(String name, int intValue, String browser) {
		super(intValue, name);
		m_browser = browser;
	}

	public static ArrayList<UserAgentsEnum> getTierOneList() {
		ArrayList<UserAgentsEnum> list = new ArrayList<UserAgentsEnum>();
		list.add(IE_6_DOT_0);
//		list.add(FF_2_DOT_0);
		list.add(FF_3_DOT_0);
//		list.add(SAFARI_MAC_2_DOT_0);
		return list;
	}

	public String getBrowser() {
		return m_browser;
	}
}
