

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;

public class MoveCursor {

	private Robot robot = null;
	private Dimension screen = null;
	private int screenWidth=0, screenHeight=0;
	
	public MoveCursor() {
		try {
		    robot = new Robot();
		    Toolkit toolkit = Toolkit.getDefaultToolkit();
		    screen = toolkit.getScreenSize();
		    screenWidth = (int)screen.getWidth();
		    screenHeight = 	(int)screen.getHeight();
		} catch (AWTException e) {
		}
	}
	
	public void moveCursorToLazyFitnessIcon() {
		if(robot != null) {
			mouveCursor((screenWidth - (screenWidth/16)), (screenHeight - (screenHeight - (screenHeight/17))));
			leftClick();
		}
		
	}
	public void moveCursorToLazyFitnessSetClassName() {
		if(robot != null) {
			mouveCursor((screenWidth - (screenWidth/5) + (screenWidth/28)), (screenHeight -  (screenHeight - (screenHeight/7) - (screenHeight/13))));
			leftClick();
		}
	}
	public void moveCursorToLazyFitnessSetHour() {
		if(robot != null) {
			mouveCursor((screenWidth - (screenWidth/5) + (screenWidth/28)), (screenHeight -  (screenHeight - (screenHeight/8) - (screenHeight/7))));
			leftClick();
		}
	}
	public void moveCursorToLazyFitnessFirstStep() {
		if(robot != null) {
			mouveCursor((screenWidth - (screenWidth/5) + (screenWidth/28)), (screenHeight -  (screenHeight - (screenHeight/8) - (screenHeight/6))));
			leftClick();
		}
	}
	public void moveCursorToLazyFitnessSecondStep() {
		if(robot != null) {
			mouveCursor((screenWidth - (screenWidth/5) + (screenWidth/28)), (screenHeight -  (screenHeight - (screenHeight/7) - (screenHeight/6))));
			leftClick();
		}
	}
	public void moveCursorToLazyFitnessThirdStep() {
		if(robot != null) {
			mouveCursor((screenWidth - (screenWidth/5) + (screenWidth/28)), (screenHeight -  (screenHeight - (screenHeight/7) - (screenHeight/5))));
			leftClick();
		}
	}
	public void moveCursorToLazyFitnessFourthStep() {
		if(robot != null) {
			mouveCursor((screenWidth - (screenWidth/5) + (screenWidth/28)), (screenHeight -  (screenHeight - (screenHeight/6) - (screenHeight/5))));
			leftClick();
		}
	}
	
	
	private void mouveCursor(int x, int y) {
		robot.mouseMove(x, y);
		robot.delay(5);
	}
	
	private void leftClick() {
		click(MouseEvent.BUTTON1_MASK);
	}
	
	private void rigthClick() {
		click(MouseEvent.BUTTON2_MASK);
	}
	
	private void click(int button) {
		robot.mousePress(button);
		robot.mouseRelease(button);
	}
}
