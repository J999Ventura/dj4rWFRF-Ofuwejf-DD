package control;

import java.awt.EventQueue;

import view.InitialPage;

public class Launcher {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Control ctr = new Control();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}
