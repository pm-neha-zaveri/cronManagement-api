package cronmanagement.webservices;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cronmanagement.bean.CronJob;
import cronmanagement.bean.ServerBean;
import cronmanagement.services.CronRunningStatusService;
import cronmanagement.services.ServerDetailsService;

@Component
@Path("/cronRunningStatus")
public class CronRunningStatusResource {
    
    public final static Log LOGGER = LogFactory.getLog(CronRunningStatusResource.class);
    
    @Autowired
    CronRunningStatusService cronRunningStatusService;
    
    @Autowired
    CronJobDetailsResource cronJobDetailsResource;
    
    @Autowired
    ServerDetailsService serverDetailsResource;
    
    @GET
    @Produces("application/json")
    public String getCronLogHistoryByCronId(@QueryParam("cronId") Integer cronId,@QueryParam("serverId") Integer serverId) {
        if(cronId == null)
            cronId = 0;
        if(serverId == null)
            serverId = 0;
        CronJob cronJob = cronJobDetailsResource.getCronByCronId(cronId);
        ServerBean serverBean = serverDetailsResource.getServerDetailsByServerId(serverId);
        
        if(cronJob != null && serverBean != null){
            return cronRunningStatusService.getCronRunningStatus(cronJob.getCronName(),serverBean.getServerIP());
        }
        return new String("Invalid Parameters.");
    }
    
}
