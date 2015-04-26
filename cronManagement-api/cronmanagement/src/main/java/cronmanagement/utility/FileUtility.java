package cronmanagement.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.io.ClassPathResource;

public class FileUtility {

    public final static Log LOGGER = LogFactory.getLog(FileUtility.class);

    private static Properties cronManangementProperties = null;

    public static void renameFile(String cronjobfilepath) {
        File oldfile = new File(cronjobfilepath);
        String newFileName = Calendar.getInstance().getTimeInMillis() + cronjobfilepath;
        File newfile = new File(newFileName);

        if (oldfile.renameTo(newfile)) {
            LOGGER.info("Rename succesful" + cronjobfilepath + " to " + newFileName);
            oldfile.delete();
        } else {
            LOGGER.info("Rename failed");
        }
    }

    public static String getPropertyValue(String propKey) {
        // Load the properties file only once
        try {
            if (cronManangementProperties == null) {
                cronManangementProperties = new Properties();
                InputStream inputStream = new ClassPathResource("cronmanagement.properties").getInputStream();
                cronManangementProperties.load(inputStream);
                inputStream.close();
            }
        } catch (Exception exp) {
            LOGGER.error("Error in loading " + "cronmanagement.properties");
            exp.printStackTrace();
        }
        return cronManangementProperties.getProperty(propKey);
    }

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
                if (s.indexOf("spawn") != -1) {
                    s = reader.readLine();
                    s = reader.readLine();
                }
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
