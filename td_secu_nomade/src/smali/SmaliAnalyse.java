package smali;

import java.io.BufferedReader;
import java.io.IOException;

public class SmaliAnalyse {

	private InformationClass infoClass;
	private BufferedReader buffer;

	static private String name = ".class";
	static private String method = ".method";
	static private String field = ".field";
	static private String mstatic = "static";

	public SmaliAnalyse() {
		super();
		this.infoClass = new InformationClass();
	}

	public String getInfo(BufferedReader buffer) {
		this.buffer = buffer;

		findInfo();

		return infoClass.getInfo();
	}

	private void findInfo() {
		String line = "";
		try {
			while( (line = buffer.readLine()) != null) {
				if( line.contains(name) ) {
					while( line.contains(" ") ) {
						line = line.substring(line.indexOf(" ")+1);
					}
					this.infoClass.setName(line.substring(0, line.length()-1));
				}
				
				else if( line.contains(method)) {
					line = line.substring(method.length()+1);
					String access = line.substring(0,line.indexOf(' '));

					line = line.substring(access.length()+1);
					String name;
					if( line.indexOf(' ') == -1 ) name = line.substring(0,line.indexOf('('));
					else name = line.substring(0,line.indexOf(' '));
					if( name.equals(mstatic)) {
						access += " ";
						access += mstatic;
						line = line.substring(mstatic.length()+1);
						if( line.indexOf(' ') == -1 ) name = line.substring(0,line.indexOf('('));
						else name = line.substring(0,line.indexOf(' '));
					}
					
					this.infoClass.addMethod(name, access);
				}
				
				else if( line.contains(field)) {
					line = line.substring(method.length()+1);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
