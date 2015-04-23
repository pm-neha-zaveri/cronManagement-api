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

import cronmanagement.bean.CronLogBean;
import cronmanagement.services.CronLogHistoryService;

@Component
@Path("/cronLogHistory")
public class CronLogHistoryResource {

    public final static Log LOGGER = LogFactory.getLog(CronLogHistoryResource.class);

    @Autowired
    CronLogHistoryService cronLogHistoryService;

    @GET
    @Produces("application/json")
    public List<CronLogBean> getCronLogHistory() {
        return cronLogHistoryService.getCronLogHistory();
    }

    @GET
    @Produces("application/json")
    public List<CronLogBean> getCronLogHistoryByCronId(@QueryParam("cronId") Integer cronId) {
        return cronLogHistoryService.getCronLogHistoryByCronId(cronId);
    }

    @GET
    @Produces("application/json")
    public List<CronLogBean> getCronLogHistoryByServerId(@QueryParam("serverId") Integer serverId) {
        return cronLogHistoryService.getCronLogHistoryByServerId(serverId);
    }

}
