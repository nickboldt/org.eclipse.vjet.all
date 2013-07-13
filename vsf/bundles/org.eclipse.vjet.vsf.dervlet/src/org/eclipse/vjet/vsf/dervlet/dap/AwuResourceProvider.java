package org.eclipse.vjet.vsf.dervlet.dap;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.vjet.dsf.common.exceptions.DsfRuntimeException;
import org.eclipse.vjet.dsf.common.resource.ResourceUtil;
import org.eclipse.vjet.dsf.liveconnect.client.DLCHttpResource;
import org.eclipse.vjet.dsf.liveconnect.client.IDLCResourceProvider;

//import com.ebay.dsf.common.exceptions.DsfRuntimeException;
//import com.ebay.dsf.liveconnect.client.DLCHttpResource;
//import com.ebay.dsf.liveconnect.client.IDLCResourceProvider;
//import com.ebay.dsf.test.utils.FileUtils;
//import com.ebay.kernel.resource.ResourceUtil;

public class AwuResourceProvider implements IDLCResourceProvider {

	private static final String BASE = "/awu";

	private Map<String, String> mimeMap = new HashMap<String, String>();

	public AwuResourceProvider() {
		mimeMap.put("gif", "image/gif");
		mimeMap.put("png", "image/png");
		mimeMap.put("jpg", "image/jpeg");
		mimeMap.put("css", "text/css");
		mimeMap.put("js", "application/javascript");
	}

	@Override
	public String getBaseUrl() {
		return AwuResourceProvider.BASE;
	}

	@Override
	public DLCHttpResource getResource(String name) {
		if(name.startsWith("AwuResourceProvider")) return null;

		byte[] content = null;
		try {
			InputStream is = ResourceUtil.getResourceAsStream(AwuResourceProvider.class, name);
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			while(is.available()>0) {
				os.write(is.read());
			}
			content = os.toByteArray();
		} catch (IOException e) {
			throw new DsfRuntimeException(e);
		}

		DLCHttpResource resource = null;
		if(content!=null) {
			resource = new DLCHttpResource();
			resource.setName(name);
			resource.setContent(content);
			String ext = name.substring(name.lastIndexOf(".")+1,name.length());
			String type = mimeMap.get(ext);
			if(type==null) type = "";
			resource.setMimeType(type);
		}

		return resource;
	}

}
