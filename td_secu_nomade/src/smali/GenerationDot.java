package smali;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class GenerationDot {

	private Map<String,Set<String>> calls;
	
	public GenerationDot(){
		this.calls = new HashMap<String,Set<String>>();
	}
	
	public void generateDOT(){
		try{
			File file = new File("calls.dot");
			
			if (!file.exists()) {
				file.createNewFile();
			}
	
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("digraph calls {\n");
			System.out.println(calls.toString());
			for (String s1 : calls.keySet()){
				for (String s2 : calls.get(s1)){
					bw.write(s1+" -> "+s2+";\n");
				}
			}
			bw.write("}");
			bw.close();fw.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void run(BufferedReader buffer){
		String line = "";
		String currentMethod = "";
		HashSet<String> functions = new HashSet<String>();
		try {
			while ((line = buffer.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(line);
				String mot = "";
				if (st.hasMoreElements()){
					mot = st.nextToken();
					if (mot.equals(".method")){
						Pattern p = Pattern.compile("[a-zA-Z0-9<>]+ *\\(");
						Matcher m = p.matcher(line);
						if (m.find()){
							currentMethod = line.substring(m.start(), m.end()-1);
							System.out.println("Méthode trouvée : "+currentMethod);
						}
					}
					if(mot.equals("invoke-super") ||mot.equals("invoke-super/range")){
						System.out.println("Fonction trouvée");
						Pattern p = Pattern.compile("->[a-zA-Z0-9<>]+\\(");
						Matcher m = p.matcher(line);
						if (m.find()){
							functions.add("super"+line.substring(m.start()+2, m.end()-1));
						}
					}
					if (mot.equals("invoke-virtual") || mot.equals("invoke-direct") 
							|| mot.equals("invoke-static")|| mot.equals("invoke-interface")|| mot.equals("invoke-virtual/range")
							|| mot.equals("invoke-direct/range")|| mot.equals("invoke-static/range")|| mot.equals("invoke-interface-range")){
						Pattern p = Pattern.compile("->[a-zA-Z0-9<>]+\\(");
						Matcher m = p.matcher(line);
						if (m.find()){
							functions.add(line.substring(m.start()+2, m.end()-1));
							System.out.println("Fonction trouvée : "+line.substring(m.start()+2, m.end()-1));
						}
					}
					if (mot.equals(".end") && st.nextToken().equals("method")){
						System.out.println("fin méthode");
						calls.put(currentMethod,functions);
						functions = new HashSet<String>();
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		generateDOT();
	}
}
