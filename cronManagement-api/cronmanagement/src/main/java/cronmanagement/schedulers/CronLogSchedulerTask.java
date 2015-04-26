package cronmanagement.schedulers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cronmanagement.bean.CronLogBean;
import cronmanagement.services.CronLogHistoryService;
import cronmanagement.services.CronLogParserService;
import cronmanagement.utility.FileUtility;

/**
 * @author raghunandanG This Scheduler will fetch Cron Log details from remote
 *         server.
 */
@Service
public class CronLogSchedulerTask {

    public final static Log LOGGER = LogFactory.getLog(CronLogSchedulerTask.class);

    @Autowired
    CronLogParserService cronLogParserService;

    @Autowired
    CronLogHistoryService cronLogHistoryService;

    /**
     * Method will be invoked at the Scheduled time.
     * 
     * @throws IOException
     */
    public void fetchAndSaveCronLogs() throws IOException {
        try {
            String cronListsh = FileUtility.getPropertyValue("REMOTE_CRON_LOGS_SCRIPT");
            String[] args = new String[] { cronListsh };
            String shResponse = FileUtility.runBashCommand(args);
            parseInputStream(shResponse);
        } catch (Exception exception) {
            LOGGER.error("Exception occured while fetching data " + exception.getMessage(), exception);
        }
    }

    /**
     * Method will parse input stream and save data to database.
     * 
     * @param inputString
     */
    public void parseInputStream(String inputString) {
        InputStream inputStream = new ByteArrayInputStream(inputString.getBytes());
        List<CronLogBean> cronLogs = cronLogParserService.getCronLogs(inputStream);
        LOGGER.info("cronJobs : " + cronLogs);
        cronLogHistoryService.saveCronLogHistory(cronLogs);
    }

}
