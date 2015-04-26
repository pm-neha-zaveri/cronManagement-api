package cronmanagement.webservices;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cronmanagement.services.HealthCheckService;

/**
 * 
 * @author raghunandanG
 *
 */
@Component
@Path("/calculateHealth")
public class HealthCheckResource {

    public final static Log LOGGER = LogFactory.getLog(CronAlertDetailsResource.class);

    @Autowired
    HealthCheckService healthCheckService;

    /**
     * This method is used to calculate health
     * @return
     */
    @GET
    @Path("/health")
    @Produces("application/json")
    public Boolean calculateHealth() {
        try {
            return healthCheckService.calculateHealth();
        } catch (Exception exception) {
            LOGGER.error("Exception occured while calculating health : " + exception.getMessage(), exception);
        }
        return false;
    }

}
