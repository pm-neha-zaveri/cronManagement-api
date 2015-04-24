package cronmanagement.services.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import cronmanagement.services.CronRunningStatusService;

@Service
public class CronRunningStatusServiceImpl implements CronRunningStatusService {

    public final static Log LOGGER = LogFactory.getLog(CronRunningStatusServiceImpl.class);

    @Value("${cron.processstatus.script.path}")
    private String cronjobstatusfilepath;

    @Override
    public String getCronRunningStatus(String server,String cronName) {
        LOGGER.error("cronjobstatusfilepath : " + cronjobstatusfilepath);
        boolean isRunning = true;
        String result = new String("Not Running");
        
        if (isRunning) {
            result = new String("Running");
        }
        return result;
    }

}
