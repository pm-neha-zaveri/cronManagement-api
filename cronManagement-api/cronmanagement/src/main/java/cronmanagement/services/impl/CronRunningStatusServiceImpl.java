package cronmanagement.services.impl;

import java.io.InputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import cronmanagement.services.CronRunningStatusService;
import cronmanagement.util.CronManagementUtility;
import cronmanagement.utility.FileUtility;

@Service
public class CronRunningStatusServiceImpl implements CronRunningStatusService {

	public final static Log LOGGER = LogFactory
			.getLog(CronRunningStatusServiceImpl.class);

	@Override
	public String getCronRunningStatus(String server, String cronName) {
		boolean isRunning = Boolean.valueOf(executeCommand().toString());
		String result = new String("Not Running");

		if (isRunning) {
			result = new String("Running");
		}
		return result;
	}

	public InputStream executeCommand() {
		String cronListsh = FileUtility
				.getPropertyValue("REMOTE_CRON_LOG_SCRIPT");
		InputStream shResponse = CronManagementUtility
				.runBashCommand(cronListsh);
		return shResponse;

	}
}
