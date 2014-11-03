package td_secu_nomade;

import xml.Parser;

public class Main {

	public static void main(String[] args) {
		Parser parser = new Parser();

		Boolean xml = false;
		Boolean activities = false;
		Boolean services = false;
		Boolean permissions = false;

		for (String s : args) {
			if (s.equals("-xml"))
				xml = true;
			if (s.equals("-a"))
				activities = true;
			if (s.equals("-s"))
				services = true;
			if (s.equals("-p"))
				permissions = true;
		}

		if (xml) {
			if (activities)
				parser.activities("test");
		}
	}
}
