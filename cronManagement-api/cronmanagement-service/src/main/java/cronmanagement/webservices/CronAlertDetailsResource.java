package cronmanagement.webservices;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

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
import cronmanagement.bean.CronJob;
import cronmanagement.bean.ServerBean;
import cronmanagement.schedulers.CronLogSchedulerTask;
import cronmanagement.services.CronAlertDetailsService;
import cronmanagement.services.CronJobDetailsService;
import cronmanagement.services.ServerDetailsService;

@Component
@Path("/cronAlertDetails")
public class CronAlertDetailsResource {

    public final static Log LOGGER = LogFactory.getLog(CronAlertDetailsResource.class);

    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
    SimpleDateFormat sql_formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    @Autowired
    CronAlertDetailsService cronAlertDetailsService;

    @Autowired
    CronJobDetailsService cronJobDetailsService;

    @Autowired
    ServerDetailsService serverDetailsService;

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
    @Path("/savealert/")
    // 24-04-2015_18:39:16
    public void saveCronAlert(@QueryParam("cronServerIp") String cronServerIp,
            @QueryParam("cronStartTime") String cronStartTime, @QueryParam("cronEndTime") String cronEndTime,
            @QueryParam("threshold") String threshold, @QueryParam("cronName") String cronName,
            @QueryParam("actualRunTimeSec") String actualRunTimeSec) {
        try {
            boolean isValidData = false;
            CronAlert cronAlert = new CronAlert();
            ServerBean serverBean = serverDetailsService.getServerDetailByIp(cronServerIp == null ? "" : cronServerIp
                    .trim());
            if (serverBean != null && cronName != null && cronName.trim().length() > 0) {
                List<CronJob> cronJobList = cronJobDetailsService.getCronJobByServerIdAndCronName(serverBean.getId(),
                        new String("%" + cronName + "%"));
                CronJob cronJob = (cronJobList != null && cronJobList.size() > 0 ? cronJobList.get(0) : null);
                cronAlert.setServerId(serverBean.getId());
                cronAlert.setDcId(serverBean.getDcId());
                if (cronJob != null) {
                    cronAlert.setCronId(cronJob.getCronId());
                    if (cronStartTime != null && cronStartTime.trim().length() > 0)
                        cronAlert.setStartTime(sql_formatter.format(formatter.parse(cronStartTime.replace('_', ' '))));
                    if (cronEndTime != null && cronEndTime.trim().length() > 0)
                        cronAlert.setEndTime(sql_formatter.format(formatter.parse(cronEndTime.replace('_', ' '))));
                    if (actualRunTimeSec != null && actualRunTimeSec.trim().length() > 0)
                        cronAlert.setRunTime(Integer.parseInt(actualRunTimeSec) * 1000);
                    if (actualRunTimeSec != null && actualRunTimeSec.trim().length() > 0)
                        cronAlert.setRunTime(Integer.parseInt(actualRunTimeSec));
                    if (threshold != null && threshold.trim().length() > 0)
                        cronAlert.setThreshold(Integer.parseInt(threshold));
                    cronAlert.setAlertDescription("Unexpected Behaviour Observed");
                    isValidData = true;
                }
            }
            LOGGER.info("cronAlert : " + cronAlert + " isValidData : " + isValidData);
            if (isValidData)
                cronAlertDetailsService.saveCronAlert(cronAlert);
            else
                LOGGER.info("Invalid Data");
        } catch (Exception exception) {
            LOGGER.error("saveCronAlert : " + exception.getMessage(), exception);
        }
    }

}
