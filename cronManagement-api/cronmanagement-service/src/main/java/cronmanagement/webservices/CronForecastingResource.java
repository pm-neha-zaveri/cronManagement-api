package cronmanagement.webservices;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cronmanagement.bean.CronForecast;
import cronmanagement.services.CronForeCastService;

@Component
@Path("/cronForcasting")
public class CronForecastingResource {

    public final static Log LOGGER = LogFactory.getLog(CronForecastingResource.class);

    @Autowired
    CronForeCastService cronForeCastService;

    @GET
    @Produces("application/json")
    public List<CronForecast> getCronForecastHistory() {
        LOGGER.info("Within " + getClass().getName() + " getCronForecastHistory method.");
        List<CronForecast> cronForeCastList = new ArrayList<CronForecast>();
        try {
            cronForeCastList = cronForeCastService.getCronForecastHistory();
        } catch (Exception exception) {
            LOGGER.error("Exception occured while fetching forecasting details" + exception.getMessage(), exception);
        }
        return cronForeCastList;
    }

    @GET
    @Produces("application/json")
    @Path("/cron/{cronId}")
    public List<CronForecast> getCronForecastHistoryByCronId(@PathParam("cronId") Integer cronId) {
        LOGGER.info("Within " + getClass().getName() + " getCronForecastHistoryByCronId method.");
        List<CronForecast> cronForeCastList = new ArrayList<CronForecast>();
        try {
            cronForeCastList = cronForeCastService.getCronForecastHistoryByCronId(cronId);
        } catch (Exception exception) {
            LOGGER.error("Exception occured while fetching forecasting details" + exception.getMessage(), exception);
        }
        return cronForeCastList;
    }

    @GET
    @Produces("application/json")
    @Path("/server/{serverId}")
    public List<CronForecast> getCronForecastHistoryByServerId(@PathParam("serverId") Integer serverId) {
        LOGGER.info("Within " + getClass().getName() + " getCronForecastHistoryByServerId method.");
        List<CronForecast> cronForeCastList = new ArrayList<CronForecast>();
        try {
            cronForeCastList = cronForeCastService.getCronForecastHistoryByServerId(serverId);
        } catch (Exception exception) {
            LOGGER.error("Exception occured while fetching forecasting details" + exception.getMessage(), exception);
        }
        return cronForeCastList;
    }

}
