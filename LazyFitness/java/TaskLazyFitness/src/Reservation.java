

public class Reservation{
	
	private static OpenChrome openC = new OpenChrome();
	private static MoveCursor moveC = new MoveCursor();
	private static WriteWords write = new WriteWords();
	private final static String url = "http://www.myhut.pt";
	
	public static void main(String[] args) {
		startReservation(args[0], args[1]);
	}
	
	public static void startReservation(String cName, String cHour) {
		openC.openChromeBrowser(url);
		sleep(5000);
		moveC.moveCursorToLazyFitnessIcon();
		sleep(2000);
		moveC.moveCursorToLazyFitnessSetClassName();
		write.writeClassName(cName);
		sleep(1000);
		moveC.moveCursorToLazyFitnessSetHour();
		write.writeClassHour(cHour);
		sleep(1000);
		moveC.moveCursorToLazyFitnessFirstStep();
		sleep(4000);
		moveC.moveCursorToLazyFitnessSecondStep();
		sleep(4000);
		moveC.moveCursorToLazyFitnessThirdStep();
		sleep(11000);
		moveC.moveCursorToLazyFitnessFourthStep();
		sleep(1000);
	}
	
	private static void sleep(int miliseconds) {
		try {
			Thread.sleep(miliseconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
