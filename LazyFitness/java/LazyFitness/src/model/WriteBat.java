package model;

import java.io.IOException;

public class WriteBat {

	public void writeToBat(String cName, String cHour, String cDirectory, String filePath) {
		try {
			Runtime.getRuntime().exec(new String[]{"cmd", "/c", "echo java -jar " + cDirectory + "\\..\\exec\\taskFitness.jar \"" + cName + "\" \"" + cHour + "\" > " + filePath});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
}
