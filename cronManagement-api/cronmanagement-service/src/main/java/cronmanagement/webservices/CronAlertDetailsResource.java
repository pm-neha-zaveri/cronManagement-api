package cronmanagement.webservices;

import java.text.ParseException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cronmanagement.bean.CronAlert;
import cronmanagement.schedulers.CronJobSchedulerTask;
import cronmanagement.schedulers.CronLogSchedulerTask;
import cronmanagement.services.CronAlertDetailsService;

/**
 * 
 * @author neha-zaveri
 *
 */
@Component
@Path("/cronAlertDetails")
public class CronAlertDetailsResource {

    public final static Log LOGGER = LogFactory.getLog(CronAlertDetailsResource.class);

    @Autowired
    CronAlertDetailsService cronAlertDetailsService;

    @Autowired
    CronLogSchedulerTask cronLogSchedulerTask;

    @Autowired
    CronJobSchedulerTask cronJobSchedulerTask;

    /**
     * This method is used to get cron alert
     * @return
     */
    @GET
    @Produces("application/json")
    public List<CronAlert> getAllCronAlert() {
        return cronAlertDetailsService.getAllCronAlert();
    }

    /**
     * This method is used to get cron alert history by serverId
     * @param serverId
     * @return
     */
    @GET
    @Produces("application/json")
    @Path("/server/{serverId}")
    public List<CronAlert> getAllCronAlertByServerId(@PathParam("serverId") Integer serverId) {
        LOGGER.debug("Within " + getClass().getName() + " getAllCronAlertByServerId method ServerId:: " + serverId);
        return cronAlertDetailsService.getAllCronAlertByServerId(serverId);
    }

    /**
     * This method is used to get cron alert by dcId
     * @param dcId
     * @return
     */
    @GET
    @Produces("application/json")
    @Path("/dc/{dcId}")
    public List<CronAlert> getAllCronAlertByDCId(@PathParam("dcId") Integer dcId) {
        LOGGER.debug("Within " + getClass().getName() + " getAllCronAlertByDCId method. DcId :: " + dcId);
        return cronAlertDetailsService.getAllCronAlertByDCId(dcId);
    }

    /**
     * This method is used to get cron alert by cronId
     * @param cronId
     * @return
     */
    @GET
    @Produces("application/json")
    @Path("/cron/{cronId}")
    public List<CronAlert> getAllCronAlertByCronId(@PathParam("cronId") Integer cronId) {
        LOGGER.debug("Within " + getClass().getName() + " getAllCronAlertByCronId method. CronId :: " + cronId);
        return cronAlertDetailsService.getAllCronAlertByCronId(cronId);
    }

    /**
     * This method is used to save cron alert
     * @param cronAlert
     * @throws ParseException
     */
    @POST
    @Consumes("application/json")
    public void saveCronAlert(CronAlert cronAlert) throws ParseException {
        LOGGER.debug("Within " + getClass().getName() + " saveCronAlert method.");
        cronAlertDetailsService.saveCronAlertDataToDB(cronAlert);
    }

}
