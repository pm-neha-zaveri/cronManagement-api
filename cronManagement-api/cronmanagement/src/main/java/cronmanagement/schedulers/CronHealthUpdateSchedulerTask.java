package cronmanagement.schedulers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cronmanagement.services.HealthCheckService;

@Service
public class CronHealthUpdateSchedulerTask {

    @Autowired
    HealthCheckService healthCheckService;
    
    public void updateHealthCheckData(){
        healthCheckService.calculateHealth();
    }
    
}
