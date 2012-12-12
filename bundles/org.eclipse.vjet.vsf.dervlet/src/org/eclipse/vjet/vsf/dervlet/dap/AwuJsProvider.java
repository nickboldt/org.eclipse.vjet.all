package org.eclipse.vjet.vsf.dervlet.dap;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.eclipse.vjet.dsf.common.exceptions.DsfRuntimeException;
import org.eclipse.vjet.dsf.common.resource.ResourceUtil;
import org.eclipse.vjet.dsf.json.serializer.JsonRpcSerializer;
import org.eclipse.vjet.dsf.liveconnect.client.IDLCJsProvider;


public class AwuJsProvider implements IDLCJsProvider {

	private static byte[] DLC_CLIENT_JS = null;

	public AwuJsProvider() {
	}

	/**
	 * get data in byte[] from specified resource
	 */
	private static byte[] getData(Class<?> anchor, String resourceName) {
		byte[] buffer = new byte[1024];
		int numRead = 0;
		try {
			InputStream is = ResourceUtil.getResourceAsStream(anchor, resourceName);
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			while ((numRead = is.read(buffer)) > 0) {
				os.write(buffer, 0, numRead);
			}
			is.close();
			return os.toByteArray();
		} catch (IOException e) {
			throw new DsfRuntimeException(e);
		}
	}

	@Override
	public byte[] getClientJs() {
		if(DLC_CLIENT_JS == null) {
			DLC_CLIENT_JS = new StringBuffer(1024)
			  .append("\n\n")
			  .append("var AWU_Props = ")
			  .append(getHtmlTagProperties()).append(";\n\n")
			  .append("var AWU_Cats = ")
			  .append(PropertyBasedVldCmdGrouping.jsonizeCategories()).append(";\n\n")
			  .append("var AWU_Props2Cat = ")
			  .append(PropertyBasedVldCmdGrouping.jsonizeGrouping()).append(";\n\n")
			  .append(new String(getData(AwuJsProvider.class, "AwuClient.js"))).toString().getBytes();
		}
		return DLC_CLIENT_JS;
	}

	public static String getHtmlTagProperties() {

		Map<String, List<String>> tag2Properties = StaticVldCmdRegistry.getAvailableCmds();
		JsonRpcSerializer serializer = new JsonRpcSerializer();
		String result = "";
		try {
			serializer.registerDefaultSerializers();
			result = serializer.toJSON(tag2Properties);
			//System.out.println(result);
		} catch (Exception e) {
			throw new DsfRuntimeException(e);
		}

		if(result.equals("")) {
			result = "{}";
		}
		return result;
	}


}
