package cronmanagement.services.impl;

import java.io.IOException;

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
	public String getCronRunningStatus(String server, String cronName)
			throws IOException {
		boolean isRunning = Boolean.valueOf(executeCommand());
		String result = new String("Not Running");

		if (isRunning) {
			result = new String("Running");
		}
		return result;
	}

	public String executeCommand() throws IOException {
		String cronListsh = FileUtility
				.getPropertyValue("REMOTE_CRON_STATUS_SCRIPT");
		String shResponse = CronManagementUtility.runBashCommand(cronListsh);
		return shResponse;

	}
}
