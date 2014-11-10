package smali;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadSmali {

	private BufferedReader buffer;

	public ReadSmali(String path) {
		super();
		try {
			buffer = new BufferedReader(new FileReader(path));
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			buffer.mark(0);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public BufferedReader getBuffer() {
		return buffer;
	}

	public void closeBuffer() {
		try {
			buffer.close();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void resetBuffer(){
		try {
			buffer.reset();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
