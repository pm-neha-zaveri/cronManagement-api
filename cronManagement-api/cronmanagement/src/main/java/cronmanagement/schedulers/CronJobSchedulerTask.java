package cronmanagement.schedulers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cronmanagement.bean.CronJob;
import cronmanagement.constant.Constants;
import cronmanagement.services.CronJobDetailsService;
import cronmanagement.services.CronJobParserService;
import cronmanagement.utility.FileUtility;

@Service
public class CronJobSchedulerTask {

    public final static Log LOGGER = LogFactory.getLog(CronJobSchedulerTask.class);

    @Autowired
    CronJobParserService cronJobParserService;

    @Autowired
    CronJobDetailsService cronDetailsService;

    public void fetchAndSaveCronDetails() throws IOException {
        executeCommand();
    }

    public void executeCommand() throws IOException {
        String cronListsh = FileUtility.getPropertyValue("REMOTE_CRON_LIST_SCRIPT");
        String args[] = new String[] { cronListsh, Constants.FIRST_PARAM };
        String shResponse = FileUtility.runBashCommand(args);
        readFile(shResponse);
    }

    public void readFile(String inputString) {
        InputStream inputStream = new ByteArrayInputStream(inputString.getBytes());
        List<CronJob> cronJobs = cronJobParserService.parse(inputStream);
        updateCronDetails(createServerCronJobMap(cronJobs));
    }

    public Map<Integer, List<CronJob>> createServerCronJobMap(List<CronJob> latestCronJobs) {
        Map<Integer, List<CronJob>> serverCronJobMap = new LinkedHashMap<Integer, List<CronJob>>();
        Iterator<CronJob> iterator = latestCronJobs.iterator();
        List<CronJob> cronJobList = null;
        CronJob tempCronJob = null;
        while (iterator.hasNext()) {
            tempCronJob = iterator.next();
            if (serverCronJobMap.get(tempCronJob.getServerId()) != null) {
                serverCronJobMap.get(tempCronJob.getServerId()).add(tempCronJob);
                serverCronJobMap.put(tempCronJob.getServerId(), serverCronJobMap.get(tempCronJob.getServerId()));
            } else {
                cronJobList = new ArrayList<CronJob>();
                cronJobList.add(tempCronJob);
                serverCronJobMap.put(tempCronJob.getServerId(), cronJobList);
            }
        }
        LOGGER.info("serverCronJobMap : " + serverCronJobMap);
        return serverCronJobMap;
    }

    private void updateCronDetails(Map<Integer, List<CronJob>> latestCronJobs) {
        List<CronJob> newlyCronJobs = new ArrayList<CronJob>();
        List<CronJob> toBeUpdatedCronJobs = new ArrayList<CronJob>();
        List<Integer> toBeDeletedCronJobs = new ArrayList<Integer>();
        if (latestCronJobs != null && latestCronJobs.size() > 0) {
            Set<Entry<Integer, List<CronJob>>> entrySet = latestCronJobs.entrySet();
            for (Entry<Integer, List<CronJob>> entry : entrySet) {
                List<CronJob> savedCronJobByServerId = cronDetailsService.getCronJobDetailsByServerId(entry.getKey());
                List<CronJob> currentCronJobByServerId = entry.getValue();
                List<CronJob> bkupCronJobByServerId = new ArrayList<CronJob>(currentCronJobByServerId);
                Iterator<CronJob> currentCronJobIterator = currentCronJobByServerId.iterator();
                while (currentCronJobIterator.hasNext()) {
                    CronJob cronJob = currentCronJobIterator.next();
                    if (savedCronJobByServerId.indexOf(cronJob) != -1) {
                        if (!((CronJob) savedCronJobByServerId.get(savedCronJobByServerId.indexOf(cronJob)))
                                .getCronStatus().equals(cronJob.getCronStatus())) {
                            cronJob.setCronId(((CronJob) savedCronJobByServerId.get(savedCronJobByServerId
                                    .indexOf(cronJob))).getCronId());
                            toBeUpdatedCronJobs.add(cronJob);
                        }
                        currentCronJobIterator.remove();
                    }
                }
                newlyCronJobs.addAll(currentCronJobByServerId);
                Iterator<CronJob> savedCronJobIterator = savedCronJobByServerId.iterator();
                while (savedCronJobIterator.hasNext()) {
                    CronJob cronJob = savedCronJobIterator.next();
                    if (bkupCronJobByServerId.indexOf(cronJob) == -1) {
                        toBeDeletedCronJobs.add(cronJob.getCronId());
                    }
                }
            }
        }

        LOGGER.info("newlyCronJobs : " + newlyCronJobs + " toBeUpdatedCronJobs : " + toBeUpdatedCronJobs
                + " toBeDeletedCronJobs : " + toBeDeletedCronJobs);

        if (newlyCronJobs.size() > 0)
            cronDetailsService.saveAllCronJobs(newlyCronJobs);

        if (toBeUpdatedCronJobs != null) {
            for (CronJob cronJob : toBeUpdatedCronJobs) {
                cronDetailsService.updateAllCronJobs(cronJob);
            }
        }

        if (toBeDeletedCronJobs != null && toBeDeletedCronJobs.size() > 0)
            cronDetailsService.deleteCronJobs(toBeDeletedCronJobs);
    }

}
