package cronmanagement.utility;

import java.io.File;
import java.io.InputStream;
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
		String newFileName = Calendar.getInstance().getTimeInMillis()
				+ cronjobfilepath;
		File newfile = new File(newFileName);

		if (oldfile.renameTo(newfile)) {
			LOGGER.info("Rename succesful" + cronjobfilepath + " to "
					+ newFileName);
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
				InputStream inputStream = new ClassPathResource(
						"cronmanagement.properties").getInputStream();
				cronManangementProperties.load(inputStream);
				inputStream.close();
			}
		} catch (Exception exp) {
			LOGGER.error("Error in loading " + "cronmanagement.properties");
			exp.printStackTrace();
		}
		return cronManangementProperties.getProperty(propKey);
	}

}
