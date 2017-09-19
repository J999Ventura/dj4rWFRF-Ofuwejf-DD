

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class WriteWords {

	private Robot robot = null;
	
	public WriteWords() {
		try {
		    robot = new Robot();
		} catch (AWTException e) {
		}
	}
	
	public void writeClassName(String name) {
		try {
			robot.keyPress(KeyEvent.VK_SHIFT);
			write(name);
			robot.keyRelease(KeyEvent.VK_SHIFT);
		}
		catch(Exception e) {
			robot.keyRelease(KeyEvent.VK_SHIFT);
			e.printStackTrace();
		}
	}
	
	public void writeClassHour(String hour) {
		try {
			String[] splited = hour.split(":");
			write(splited[0]);
			robot.keyPress(KeyEvent.VK_SHIFT);
			robot.keyPress(KeyEvent.VK_PERIOD);
			robot.keyRelease(KeyEvent.VK_PERIOD);
			robot.keyRelease(KeyEvent.VK_SHIFT);
			write(splited[1]);
		}
		catch(Exception e) {
			robot.keyRelease(KeyEvent.VK_PERIOD);
			robot.keyRelease(KeyEvent.VK_SHIFT);
			e.printStackTrace();
		}
	}
	
	private void write(String word) {
		char[] letters = word.toCharArray();
		for(int i = 0; i < letters.length; i++) {
			int myKey = (int)letters[i];
			robot.keyPress(myKey);
			robot.keyRelease(myKey);
		}
	}
	
}
