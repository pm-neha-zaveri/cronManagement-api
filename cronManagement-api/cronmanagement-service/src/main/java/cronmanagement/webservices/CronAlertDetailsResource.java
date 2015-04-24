package cronmanagement.webservices;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cronmanagement.bean.CronAlert;
import cronmanagement.services.CronAlertDetailsService;

@Component
@Path("/cronAlertDetails")
public class CronAlertDetailsResource {

    public final static Log LOGGER = LogFactory.getLog(CronAlertDetailsResource.class);

    @Autowired
    CronAlertDetailsService cronAlertDetailsService;

    @GET
    @Produces("application/json")
    public List<CronAlert> getAllCronAlert() {
        return cronAlertDetailsService.getAllCronAlert();
    }

    @GET
    @Produces("application/json")
    @Path("/server/{serverId}")
    public List<CronAlert> getAllCronAlertByServerId(@PathParam("serverId") Integer serverId) {
        return cronAlertDetailsService.getAllCronAlertByServerId(serverId);
    }

    @GET
    @Produces("application/json")
    @Path("/dc/{dcId}")
    public List<CronAlert> getAllCronAlertByDCId(@PathParam("dcId") Integer dcId) {
        return cronAlertDetailsService.getAllCronAlertByDCId(dcId);
    }

    @GET
    @Produces("application/json")
    @Path("/cron/{cronId}")
    public List<CronAlert> getAllCronAlertByCronId(@PathParam("cronId") Integer cronId) {
        return cronAlertDetailsService.getAllCronAlertByCronId(cronId);
    }

    @GET
    @Produces("application/json")
    @Path("/savealert/")
    public void saveCronAlert(@QueryParam("cronName")String cronName,HttpServletRequest request) {
        CronAlert cronAlert = new CronAlert();
        cronAlertDetailsService.saveCronAlert(cronAlert);
    }

}
