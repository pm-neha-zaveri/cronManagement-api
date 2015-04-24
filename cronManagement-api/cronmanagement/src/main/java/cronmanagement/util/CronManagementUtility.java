package cronmanagement.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CronManagementUtility {
    public static String runBashCommand(String command[]) throws IOException {

        Process proc = null;
        StringBuilder stringResponse = new StringBuilder();
        try {
            Runtime rt = Runtime.getRuntime();
            // System.out.println("command :: " + command);
            proc = rt.exec(command);
            BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String s;
            while ((s = reader.readLine()) != null) {
                stringResponse.append(s).append("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Terminate the subprocess and free all resources after processing
            if (proc != null) {
                proc.destroy();
            }
        }

        return stringResponse.toString();
    }

}
