package model;

import java.io.IOException;

public class TaskCreator {

	private final int incrementMin = 1;
	

	public void createTask(String date, String time, String filePath) {
		String startTime = getStartTime(time);
		date = getProcessedDate(time, date);
		try {
			Runtime.getRuntime().exec(new String[]{"cmd", "/c", "SCHTASKS /Create /TN lazyFitness /TR " + filePath + " /SC ONCE /SD " + date + " /ST " + startTime});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean removeTask() {
		try {
			Runtime.getRuntime().exec(new String[]{"cmd", "/c", "SCHTASKS /Delete /TN lazyFitness /f"});
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	private String getProcessedDate(String time, String date) {
		String[] timeSplited = time.split(":");
		int hourTime = Integer.parseInt(timeSplited[0]);
		
		if(hourTime < 10) {
			String[] dateSplited = date.split("/");
			int day = Integer.parseInt(dateSplited[0]) - 1;
			return day + "/" + dateSplited[1] + "/" + dateSplited[2];
		}else {
			return date;
		}
		
	}
	
	private String getStartTime(String time) {
		String[] timeSplited = time.split(":");
		String hourString = timeSplited[0];
		String minString = "";
		int hourTime = Integer.parseInt(timeSplited[0]);
		
		/* decrease the time to 10 hours because it is when the reservation starts */
		if(hourTime >= 10) {
			hourTime -= 10;
		}else {
			hourTime += 10 + 4;
		}
		
		/* write the correct numbers */
		if(hourTime < 10) 
			hourString = "0"+hourTime;
		else
			hourString = "" + hourTime;
		
		int minTime = Integer.parseInt(timeSplited[1]);
		if(minTime < 10) {
			minTime +=incrementMin;
			minString = "0"+minTime;
		}else {
			minString = ""+(minTime + incrementMin);
		}
		
		return hourString + ":" + minString;
	}
}
