

import java.io.IOException;

public class OpenChrome {
	
	public boolean openChromeBrowser(String url) {
		try {
			Runtime.getRuntime().exec(new String[]{"cmd", "/c", "start chrome " + url});
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
