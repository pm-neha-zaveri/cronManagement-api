package cronmanagement.services.impl;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import cronmanagement.services.CronRunningStatusService;
import cronmanagement.utility.FileUtility;

@Service
public class CronRunningStatusServiceImpl implements CronRunningStatusService {

    public final static Log LOGGER = LogFactory.getLog(CronRunningStatusServiceImpl.class);

    @Override
    public String getCronRunningStatus(String server, String cronName) throws IOException {
    	LOGGER.debug("Within " + getClass().getName()
				+ " getCronRunningStatus method. Server :: "+server+" cron name :: "+cronName);
        if(cronName != null && cronName.trim().length() > 0)
            cronName = cronName.substring(cronName.indexOf(" /"),cronName.length());
        String result = executeCommand(server, cronName);
        if (result.indexOf("true") != -1)
            return new String("Running");
        else
            return new String("Not Running");
    }

    public String executeCommand(String server, String cronName) throws IOException {
    	LOGGER.debug("Within " + getClass().getName()
				+ " executeCommand method. Server :: "+server+" cron name"+cronName);
        String cronListsh = FileUtility.getPropertyValue("REMOTE_CRON_STATUS_SCRIPT");
        String[] args = new String[] {cronListsh, server, cronName };
        String shResponse = FileUtility.runBashCommand(args);
        return shResponse;

    }
}
