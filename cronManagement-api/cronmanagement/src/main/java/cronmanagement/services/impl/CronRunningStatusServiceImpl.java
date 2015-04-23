package cronmanagement.services.impl;

import org.springframework.stereotype.Service;

import cronmanagement.services.CronRunningStatusService;

@Service
public class CronRunningStatusServiceImpl implements CronRunningStatusService{

    @Override
    public String getCronRunningStatus(Integer cronId) {
        boolean isRunning = true;
        String result = new String("Not Running");
        if(isRunning){
            result = new String("Running");
        }
        return result;
    }

}
