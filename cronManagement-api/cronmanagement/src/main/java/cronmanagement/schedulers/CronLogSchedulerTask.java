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

	public void fetchAndSaveCronLogs() throws IOException {
		executeCommand();
	}

	public void executeCommand() throws IOException {
		String cronListsh = FileUtility
				.getPropertyValue("REMOTE_CRON_LOGS_SCRIPT");
		String[] args = new String[]{cronListsh};
		String shResponse = CronManagementUtility
				.runBashCommand(args);
		readFile(shResponse);
	}

	public void readFile(String inputString) {
		InputStream inputStream = new ByteArrayInputStream(inputString.getBytes());
		System.out.println(inputString);
		List<CronLogBean> cronLogs = cronLogParserService
				.getCronLogs(inputStream);
		LOGGER.info("cronJobs : " + cronLogs);
		cronLogHistoryService.saveCronLogHistory(cronLogs);
	}

}
