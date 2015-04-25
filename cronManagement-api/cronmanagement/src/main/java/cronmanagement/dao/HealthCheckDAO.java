package cronmanagement.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import cronmanagement.bean.HealthCheck;

@Service
public interface HealthCheckDAO {

    /**
     * Method will return cron alert count group by  server.
     * @return {@link List}
     */
    List<HealthCheck> getCronAlertDetails();

    /**
     * Method will return cron log count group by  server.
     * @return {@link List}
     */
    List<HealthCheck> getCronLogDetails();

}
