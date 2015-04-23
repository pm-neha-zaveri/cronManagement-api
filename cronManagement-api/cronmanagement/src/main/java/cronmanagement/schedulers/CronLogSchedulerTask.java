package cronmanagement.schedulers;

import java.io.InputStream;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import cronmanagement.bean.CronLogBean;
import cronmanagement.services.CronLogHistoryService;
import cronmanagement.services.CronLogParserService;

@Service
public class CronLogSchedulerTask {

    public final static Log LOGGER = LogFactory.getLog(CronLogSchedulerTask.class);

    @Value("${cronlogfilepath}")
    private String cronlogfilepath;

    @Autowired
    CronLogParserService cronLogParserService;
    
    @Autowired
    CronLogHistoryService cronLogHistoryService;

    public void fetchAndSaveCronLogs() {
        executeCommand();
    }

    public void executeCommand() {
        // readFile();
        LOGGER.info("Executing  || ...");
        LOGGER.debug("Executing  || ...");
        LOGGER.error("Executing  || ...");
        // readFile(null);
    }

    public void readFile(InputStream inputStream) {
        List<CronLogBean> cronJobs = cronLogParserService.getCronLogs(inputStream);
        LOGGER.info("cronJobs : "+cronJobs);
        // TODO save to DB
        cronLogHistoryService.saveCronLogHistory(cronJobs);
    }

}
