package cronmanagement.webservices;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cronmanagement.bean.CronJob;
import cronmanagement.services.CronJobDetailsService;

@Component
@Path("/cronDetails")
public class CronJobDetailsResource {

    public final static Log LOGGER = LogFactory.getLog(CronJobDetailsResource.class);

    @Autowired
    CronJobDetailsService cronJobDetailsService;

    @GET
    @Produces("application/json")
    public List<CronJob> getCronList() {
        return cronJobDetailsService.getCronJobDetails();
    }

    @GET
    @Produces("application/json")
    public List<CronJob> getCronListByServerId(@QueryParam("serverId") Integer serverId) {
        return cronJobDetailsService.getCronJobDetailsByServerId(serverId);
    }

    @GET
    @Produces("application/json")
    public CronJob getCronByCronId(@QueryParam("cronId") Integer cronId) {
        return cronJobDetailsService.getCronJobDetailsByCronId(cronId);
    }

    @GET
    @Produces("application/json")
    public CronJob getCronListByCronName(@QueryParam("cronName") String cronName) {
        return cronJobDetailsService.getCronDetailsByCronName(cronName);
    }

}
