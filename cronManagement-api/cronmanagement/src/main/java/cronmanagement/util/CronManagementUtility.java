package cronmanagement.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.pubmatic.castrum.exceptions.APIException;

public class CronManagementUtility {
	public static String runBashCommand(String[] command) throws APIException {

		StringBuffer sb = new StringBuffer();
		Process proc = null;
		String data = null;
		try {
			Runtime rt = Runtime.getRuntime();
			proc = rt.exec(command);
			BufferedReader br = new BufferedReader(new InputStreamReader(
					proc.getInputStream()));
			while ((data = br.readLine()) != null) {
				sb.append(data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Terminate the subprocess and free all resources after processing
			if (proc != null) {
				proc.destroy();
			}
		}
		return sb.toString();
	}

}
