package cronmanagement.util;

import java.io.InputStream;

public class CronManagementUtility {
	public static InputStream runBashCommand(String command) {

		Process proc = null;
		try {
			Runtime rt = Runtime.getRuntime();
			proc = rt.exec(command);
			if (proc != null) {
				return proc.getInputStream();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Terminate the subprocess and free all resources after processing
			if (proc != null) {
				proc.destroy();
			}
		}
		return null;
	}

}
