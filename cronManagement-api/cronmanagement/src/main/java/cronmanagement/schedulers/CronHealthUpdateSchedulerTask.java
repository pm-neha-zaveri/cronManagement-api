package cronmanagement.schedulers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cronmanagement.services.HealthCheckService;

@Service
public class CronHealthUpdateSchedulerTask {

    public final static Log LOGGER = LogFactory.getLog(CronHealthUpdateSchedulerTask.class);
    
    @Autowired
    HealthCheckService healthCheckService;
    
    public void updateHealthCheckData(){
        LOGGER.info("Within " + getClass().getName() + " updateHealthCheckData method.");
        healthCheckService.calculateHealth();
    }
    
}
