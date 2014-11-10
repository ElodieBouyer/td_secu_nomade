package td_secu_nomade;

import smali.ReadSmali;
import smali.SmaliAnalyse;
import xml.Parser;

public class Main {

	public static void main(String[] args) {
		Parser parser = new Parser();
		SmaliAnalyse smaliAnalyse = new SmaliAnalyse();

		String path = null;

		Boolean xml = false;
		Boolean activities = false;
		Boolean services = false;
		Boolean permissions = false;
		Boolean smali = false;
		Boolean info = false;

		for (int i = 0; i < args.length; i++) {

			// Pour la partie manifest.
			if (args[i].equals("-xml"))
				xml = true;
			if (args[i].equals("-a"))
				activities = true;
			if (args[i].equals("-s"))
				services = true;
			if (args[i].equals("-p"))
				permissions = true;

			// Pour la partie smali.
			if (args[i].equals("-smali"))
				smali = true;
			if (args[i].equals("-i"))
				info = true;

			// Path du fichier.
			if (args[i].equals("-p"))
				path = args[i + 1];
		}

		// Si mauvais path.
		if (path == null) {
			System.out
					.println("Vous n'avez pas donnés de path pour votre analyse.");
			return;
		}

		/*
		 * TODO : Si le path est un dossier : - Trouver tous les fichiers smali
		 * pour faire l'analyse sur chacun d'eux. - Trouver le manifest.
		 */

		ReadSmali smaliFile = new ReadSmali(path);

		if (xml) {
			if (activities)
				parser.activities(path);
		} else if (smali) {
			if (info) {
				System.out.println(smaliAnalyse.getInfo(smaliFile.getBuffer()));
			}
		}

		smaliFile.closeBuffer();
	}
}
