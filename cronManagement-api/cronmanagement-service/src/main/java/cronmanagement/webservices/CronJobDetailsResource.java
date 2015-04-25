package cronmanagement.webservices;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jsoup.Connection;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pubmatic.apiutils.bean.ReportingRequest;
import com.pubmatic.apiutils.bean.RequestDetails;
import com.pubmatic.apiutils.utils.RequestParserUtil;

import cronmanagement.bean.CronJob;
import cronmanagement.services.CronJobDetailsService;

@Component
@Path("/cronDetails")
public class CronJobDetailsResource {

    public final static Log LOGGER = LogFactory.getLog(CronJobDetailsResource.class);

    @Autowired
    CronJobDetailsService cronJobDetailsService;

    @GET
    @Consumes("application/json")
    @Produces("application/json")
    public List<CronJob> getCronList(@QueryParam("") ReportingRequest reportingRequest) {
        RequestDetails requestDetails = RequestParserUtil.parseReportngRequest(reportingRequest, CronJob.class);
        return cronJobDetailsService.getCronJobDetails(requestDetails);
    }

    @GET
    @Produces("application/json")
    @Path("/server/{serverId}")
    public List<CronJob> getCronListByServerId(@PathParam("serverId") Integer serverId) {
        LOGGER.info("Within " + getClass().getName() + " getCronListByServerId method. ServerId :: " + serverId);
        return cronJobDetailsService.getCronJobDetailsByServerId(serverId);
    }

    @GET
    @Produces("application/json")
    @Path("/cron/{cronId}")
    public CronJob getCronByCronId(@PathParam("cronId") Integer cronId) {
        LOGGER.info("Within " + getClass().getName() + " getCronByCronId method. CronId :: " + cronId);
        return cronJobDetailsService.getCronJobDetailsByCronId(cronId);
    }

    @GET
    @Produces("application/json")
    @Path("/cronType")
    public List<CronJob> getCronListByCronType(@QueryParam("cronType") String cronType) {
        LOGGER.info("Within " + getClass().getName() + " getCronListByCronType method. CronType :: " + cronType);
        return cronJobDetailsService.getCronJobDetailsByCronType(cronType);
    }

    @GET
    @Produces("application/json")
    @Path("/nextSchedules")
    public List<String> getCronsSchedulesTime(@QueryParam("cronExp") String cronExp,
            @QueryParam("iterations") Integer iterations) {
        LOGGER.info("Within " + getClass().getName() + " getCronListByCronType method. cronExp :: " + cronExp
                + " iterations : " + iterations);
        List<String> futureExecutionTime = new ArrayList<String>();
        try {
            URL url = new URL("http://cron.schlitt.info/index.php?cron=" + cronExp + "&iterations=" + 10 + "&test=Test");
            Connection con = Jsoup.connect(url.toString()).userAgent("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/535.21 (KHTML, like Gecko) Chrome/19.0.1042.0 Safari/535.21").timeout(10000).ignoreHttpErrors(true).followRedirects(true);;
            Response resp = con.execute();
            Document doc=con.get();
            if (doc != null) {
                for (int i = 1; i <= iterations; i++) {
                    Elements elements = doc.select("body ol li:eq(" + i + ")");
                    if (elements != null && elements.text() != null && elements.text().trim().length() > 0) {
                        futureExecutionTime.add(elements.text().trim());
                    }
                }
            }
        } catch (Exception exception) {
            LOGGER.error("Exception occured while fetching future schedules : " + exception.getMessage(), exception);
        }

        return futureExecutionTime;

    }

}
