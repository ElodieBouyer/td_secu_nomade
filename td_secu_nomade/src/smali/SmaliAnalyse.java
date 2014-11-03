package smali;

import java.io.IOException;

public class SmaliAnalyse {
	
	private InformationClass infoClass;

	
	public SmaliAnalyse() {
		this.infoClass = new InformationClass();
		ReadSmali read = new ReadSmali("/home/elodie/Documents/master-2/securite_nomade/td2/Challenge5/smali/secu/fifth/AccessVerifier.smali");
		try {
			System.out.println(read.getBuffer().readLine());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
