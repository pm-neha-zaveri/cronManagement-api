package cronmanagement.dao;

import java.util.List;

import cronmanagement.bean.HealthCheck;
/**
 * 
 * @author raghunandanG
 * 
 * This will provide Health Check details.
 *
 */
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
