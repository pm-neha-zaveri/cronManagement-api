package cronmanagement.webservices;

import javax.annotation.Resource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cronmanagement.services.CronRunningStatusService;

@Resource
@Path("/cronRunningStatus")
public class CronRunningStatusResource {
    
    public final static Log LOGGER = LogFactory.getLog(CronRunningStatusResource.class);
    
    @Autowired
    CronRunningStatusService cronRunningStatusService;
    
    @GET
    @Produces("application/json")
    public String getCronLogHistoryByCronId(@QueryParam("cronId") Integer cronId) {
        return cronRunningStatusService.getCronRunningStatus(cronId);
    }
    
}
