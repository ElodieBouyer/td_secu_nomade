package smali;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class GenerationDot {

	private Map<String,Set<String>> calls;
	
	public GenerationDot(){
		this.calls = new HashMap<String,Set<String>>();
	}
	
	public String getNextFunction(){
		return "lol";
	}
}
