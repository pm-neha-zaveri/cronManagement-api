package cronmanagement.webservices;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cronmanagement.bean.CronAlert;
import cronmanagement.services.CronAlertDetailsService;

@Resource
@Path("/cronAlertDetails")
public class CronAlertDetailsResource {

    public final static Log LOGGER = LogFactory.getLog(CronAlertDetailsResource.class);

    @Autowired
    CronAlertDetailsService cronAlertDetailsService;

    @GET
    @Produces("application/json")
    List<CronAlert> getAllCronAlert() {
        return cronAlertDetailsService.getAllCronAlert();
    }

    @GET
    @Produces("application/json")
    List<CronAlert> getAllCronAlertByServerId(@QueryParam("serverId") Integer serverId) {
        return cronAlertDetailsService.getAllCronAlertByServerId(serverId);
    }

    @GET
    @Produces("application/json")
    List<CronAlert> getAllCronAlertByDCId(@QueryParam("dcId") Integer dcId) {
        return cronAlertDetailsService.getAllCronAlertByDCId(dcId);
    }

    @GET
    @Produces("application/json")
    List<CronAlert> getAllCronAlertByCronId(@QueryParam("cronId") Integer cronId) {
        return cronAlertDetailsService.getAllCronAlertByCronId(cronId);
    }

    @GET
    @Produces("application/json")
    void saveCronAlert(HttpServletRequest request) {
        CronAlert cronAlert = new CronAlert();
        cronAlertDetailsService.saveCronAlert(cronAlert);
    }

}
