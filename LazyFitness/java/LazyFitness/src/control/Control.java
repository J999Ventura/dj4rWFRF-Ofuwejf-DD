package control;

import model.TaskCreator;
import model.WriteBat;
import view.InitialPage;
import view.OnScheduleListener;

public class Control implements OnScheduleListener{
	
	private TaskCreator task;
	
	public Control() {
		task = new TaskCreator();
		
		InitialPage frame = new InitialPage();
		frame.setOnScheduleListener(this);
		frame.setVisible(true);
	}

	@Override
	public void onActionSchedule(String cName, String cHour, String date) {
		
		WriteBat write = new WriteBat();
		String cDirectory = System.getProperty("user.dir");
		String batPath = cDirectory + "\\..\\bat\\launchTaskFitness.bat";
		write.writeToBat(cName, cHour, cDirectory, batPath);
		
		task.createTask(date, cHour, batPath);
	}

	@Override
	public void onDeleteSchedule() {
		task.removeTask();
	}
	
	
	
}
