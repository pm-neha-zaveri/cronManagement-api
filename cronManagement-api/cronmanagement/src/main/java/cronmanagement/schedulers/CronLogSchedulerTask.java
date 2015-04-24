package cronmanagement.schedulers;

import java.io.InputStream;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cronmanagement.bean.CronLogBean;
import cronmanagement.services.CronLogHistoryService;
import cronmanagement.services.CronLogParserService;
import cronmanagement.util.CronManagementUtility;
import cronmanagement.utility.FileUtility;

@Service
public class CronLogSchedulerTask {

	public final static Log LOGGER = LogFactory
			.getLog(CronLogSchedulerTask.class);

	@Autowired
	CronLogParserService cronLogParserService;

	@Autowired
	CronLogHistoryService cronLogHistoryService;

	public void fetchAndSaveCronLogs() {
		executeCommand();
	}

	public void executeCommand() {
		String cronListsh = FileUtility
				.getPropertyValue("REMOTE_CRON_LOG_SCRIPT");
		InputStream shResponse = CronManagementUtility
				.runBashCommand(cronListsh);
		readFile(shResponse);
	}

	public void readFile(InputStream inputStream) {
		List<CronLogBean> cronLogs = cronLogParserService
				.getCronLogs(inputStream);
		LOGGER.info("cronJobs : " + cronLogs);
		cronLogHistoryService.saveCronLogHistory(cronLogs);
	}

}
