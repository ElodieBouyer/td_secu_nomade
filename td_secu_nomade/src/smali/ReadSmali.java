package smali;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadSmali {

	private String text;

	public ReadSmali(String path) {
		super();
		readFile(path);
	}

	/**
	 * Donne le contenue du fichier smali.
	 * @return
	 */
	public String getText() {
		return text;
	}

	private void readFile(String path) {

		try{
			BufferedReader buff = new BufferedReader(new FileReader(path));

			try {
				String line;

				while ((line = buff.readLine()) != null) {
					text += line;
				}
			} 
			finally {
				buff.close();
			}
		} 
		catch (IOException ioe) {

			System.out.println("Erreur --" + ioe.toString());
		}
	}
}
