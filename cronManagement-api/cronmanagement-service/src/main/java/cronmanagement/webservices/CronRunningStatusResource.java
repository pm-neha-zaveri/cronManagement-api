package cronmanagement.webservices;

import java.io.IOException;

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

	public final static Log LOGGER = LogFactory
			.getLog(CronRunningStatusResource.class);

	@Autowired
	CronRunningStatusService cronRunningStatusService;

	@Autowired
	CronJobDetailsResource cronJobDetailsResource;

	@Autowired
	ServerDetailsService serverDetailsResource;

	@GET
	@Produces("application/json")
	public String getCronLogHistoryByCronId(@QueryParam("cronId") Integer cronId)
			throws IOException {
        LOGGER.info("Within " + getClass().getName() + " getCronLogHistoryByCronId method. CronId :: " + cronId);
		if (cronId == null)
			cronId = 0;
		CronJob cronJob = cronJobDetailsResource.getCronByCronId(cronId);
		if (cronJob != null) {
			ServerBean serverBean = serverDetailsResource
					.getServerDetailsByServerId(cronJob.getServerId());
			if (serverBean != null)
				return cronRunningStatusService.getCronRunningStatus(
						serverBean.getServerIP(), cronJob.getCronName());
		}
		return new String("Invalid Parameters.");
	}

}
