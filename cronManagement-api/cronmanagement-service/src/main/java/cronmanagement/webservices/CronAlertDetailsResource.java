package cronmanagement.webservices;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cronmanagement.bean.CronAlert;
import cronmanagement.bean.CronJob;
import cronmanagement.bean.ServerBean;
import cronmanagement.services.CronAlertDetailsService;
import cronmanagement.services.CronJobDetailsService;
import cronmanagement.services.ServerDetailsService;

@Component
@Path("/cronAlertDetails")
public class CronAlertDetailsResource {

    public final static Log LOGGER = LogFactory.getLog(CronAlertDetailsResource.class);

    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy kk:mm:ss");

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

    @POST
    @Produces("application/json")
    @Path("/savealert/")
    public void saveCronAlert(HttpServletRequest request) {
        try {
            LOGGER.info("saveCronAlert : " + request.getParameterMap());
            String cronName = request.getParameter("cronName");
            String cronServerIp = request.getParameter("cronServerIp");
            String cronStartTime = request.getParameter("cronStartTime");
            String cronEndTime = request.getParameter("cronEndTime");
            String threshold = request.getParameter("threshold");
            String actualRunTimeSec = request.getParameter("actualRunTimeSec");
            boolean isValidData = true;
            CronAlert cronAlert = new CronAlert();
            if (cronName != null && cronName.trim().length() > 0) {
                CronJob cronJob = cronJobDetailsService.getCronDetailsByCronName(cronName == null ? "" : cronName
                        .trim());
                if (cronJob != null) {
                    cronAlert.setCronId(cronJob.getCronId());
                    ServerBean serverBean = serverDetailsService.getServerDetailByIp(cronServerIp == null ? ""
                            : cronServerIp.trim());
                    if (serverBean != null) {
                        cronAlert.setServerId(serverBean.getId());
                        if(!cronJob.getServerId().equals(serverBean.getId())){
                            isValidData = false;
                        }else{
                            if (cronStartTime != null && cronStartTime.trim().length() > 0)
                                cronAlert.setStartTime(cronStartTime);
                            if (cronEndTime != null && cronEndTime.trim().length() > 0)
                                cronAlert.setEndTime(cronEndTime);
                            if(actualRunTimeSec != null && actualRunTimeSec.trim().length() > 0)
                                cronAlert.setRunTime(Integer.parseInt(actualRunTimeSec)*1000);
                            if(actualRunTimeSec != null && actualRunTimeSec.trim().length() > 0)
                                cronAlert.setRunTime(Integer.parseInt(actualRunTimeSec));
                            if(threshold != null && threshold.trim().length() > 0)
                                cronAlert.setThreshold(Integer.parseInt(threshold));
                        }
                    }else{
                        isValidData = false;
                    }
                }else{
                    isValidData = false;
                }
                LOGGER.info("cronAlert : "+cronAlert+" isValidData : "+isValidData);
            }else{
                isValidData = false;
            }
            if(isValidData)
                cronAlertDetailsService.saveCronAlert(cronAlert);
            else
                LOGGER.info("Invalid Data");
        } catch (Exception exception) {
            LOGGER.error("saveCronAlert : " + exception.getMessage(), exception);
        }
        
    }

}
