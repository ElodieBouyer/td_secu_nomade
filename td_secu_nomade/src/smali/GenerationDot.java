package smali;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class GenerationDot {

	private Map<String,Set<String>> calls;
	
	public GenerationDot(){
		this.calls = new HashMap<String,Set<String>>();
	}
	
	public String getNextFunction(String smali){
		StringTokenizer st = new StringTokenizer(smali);
		String mot = "";
		while (st.hasMoreElements()){
			mot = st.nextToken();
			if (mot.equals("invoke-super") || mot.equals("invoke-virtual") || mot.equals("invoke-direct") 
					|| mot.equals("invoke-static")|| mot.equals("invoke-interface")|| mot.equals("invoke-virtual/range")
					|| mot.equals("invoke-direct/range")|| mot.equals("invoke-super/range")
					|| mot.equals("invoke-static/range")|| mot.equals("invoke-interface-range")){
				
				StringTokenizer st2 = new StringTokenizer(mot,"->");
				
			}
		}
		return "lol";
	}
}
