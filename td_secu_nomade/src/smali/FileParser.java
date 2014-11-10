package smali;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileParser {

	public static List<String> listFilesForFolder(final File folder) {
		List<String> files = new ArrayList<String>();
		for (final File fileEntry : folder.listFiles()) {
			if (fileEntry.isDirectory()) {
				listFilesForFolder(fileEntry);
			} else {
				String fn = fileEntry.getName();
				if (fn.substring(fn.length()-5, fn.length()).equals("smali")){
					files.add((fileEntry.getPath()));
				}
			}
		}
		return files;
	}
}
