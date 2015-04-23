package cronmanagement.utility;

import java.io.File;
import java.util.Calendar;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class FileUtility {
    
    public final static Log LOGGER = LogFactory.getLog(FileUtility.class);
    
    public static void renameFile(String cronjobfilepath) {
        File oldfile = new File(cronjobfilepath);
        String newFileName = Calendar.getInstance().getTimeInMillis()
                + cronjobfilepath;
        File newfile = new File(newFileName);

        if (oldfile.renameTo(newfile)) {
            LOGGER.info("Rename succesful"+cronjobfilepath +" to "+newFileName);
            oldfile.delete();
        } else {
            LOGGER.info("Rename failed");
        }
    }

}
