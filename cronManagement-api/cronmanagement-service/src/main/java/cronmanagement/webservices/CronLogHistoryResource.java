package cronmanagement.webservices;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cronmanagement.bean.CronLogBean;
import cronmanagement.services.CronLogHistoryService;

/**
 * 
 * @author neha-zaveri
 *
 */
@Component
@Path("/cronLogHistory")
public class CronLogHistoryResource {

    public final static Log LOGGER = LogFactory.getLog(CronLogHistoryResource.class);

    @Autowired
    CronLogHistoryService cronLogHistoryService;

    /**
     * This method is used to get cron log history
     * @return
     */
    @GET
    @Produces("application/json")
    public List<CronLogBean> getCronLogHistory() {
        LOGGER.info("Within " + getClass().getName() + " getCronLogHistory method.");
        return cronLogHistoryService.getCronLogHistory();
    }

    /**
     * This method is used to get cron log history by cronId
     * @param cronId
     * @return
     */
    @GET
    @Produces("application/json")
    @Path("/cron/{cronId}")
    public List<CronLogBean> getCronLogHistoryByCronId(@PathParam("cronId") Integer cronId) {
        LOGGER.info("Within " + getClass().getName() + " getCronLogHistory method. CronId :: " + cronId);
        return cronLogHistoryService.getCronLogHistoryByCronId(cronId);
    }

    /**
     * This method is used to get cron log history by serverId
     * @param serverId
     * @return
     */
    @GET
    @Produces("application/json")
    @Path("/server/{serverId}")
    public List<CronLogBean> getCronLogHistoryByServerId(@PathParam("serverId") Integer serverId) {
        LOGGER.info("Within " + getClass().getName() + " getCronLogHistory method. ServerId :: " + serverId);
        return cronLogHistoryService.getCronLogHistoryByServerId(serverId);
    }

}
