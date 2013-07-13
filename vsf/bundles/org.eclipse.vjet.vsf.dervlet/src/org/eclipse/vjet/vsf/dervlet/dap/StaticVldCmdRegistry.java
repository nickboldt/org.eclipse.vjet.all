package org.eclipse.vjet.vsf.dervlet.dap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.vjet.vsf.dapunit.StaticVldCommand;

public class StaticVldCmdRegistry {
	private static Map<String, StaticVldCommand> commands = new HashMap<String, StaticVldCommand>();
	
	public static void addCommand(StaticVldCommand cmd){
		commands.put(cmd.getCmdName(), cmd);
	}
	
	public static StaticVldCommand getCommand(String cmdName){
		return commands.get(cmdName);
	}
	
	/**
	 * @return Map<String, List<String>>
	 * Key: regex
	 * Value: available cmd on this regex
	 */
	public static Map<String, List<String>> getAvailableCmds(){
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for (StaticVldCommand cmd : commands.values()) {
			addEntry(map, cmd.getTargetRegex(), cmd.getCmdName());
		}
		return map;
	}
	
	private static void addEntry(Map<String, List<String>> map, String regex, String cmd){
		List<String> list = map.get(regex); 
		if(list == null){
			list = new ArrayList<String>();
			map.put(regex, list);
		}
		list.add(cmd);
	}
}
