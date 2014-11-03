package td_secu_nomade;

import java.io.IOException;

import smali.ReadSmali;
import smali.SmaliAnalyse;
import xml.Parser;

public class Main {

	public static void main(String[] args) {
		Parser parser = new Parser();
		SmaliAnalyse smaliAnalyse = new SmaliAnalyse();

		Boolean xml = false;
		Boolean activities = false;
		Boolean services = false;
		Boolean permissions = false;
		Boolean smali = false;
		Boolean info = false;
		

		for (String s : args) {
			if( s.equals("-xml") ) xml = true;
			if (s.equals("-a"))	activities = true;
			if (s.equals("-s")) services = true;
			if (s.equals("-p"))	permissions = true;
			
			if( s.equals("-smali") ) smali = true;
			if( s.equals("-i") ) info = true;
		}

		if (xml) {
			if (activities)
				parser.activities("test");
		}
		else if( smali) {
			if( info ) {
				
			}
		}
	}
}
