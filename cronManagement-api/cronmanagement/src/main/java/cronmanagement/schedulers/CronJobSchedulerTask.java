package cronmanagement.schedulers;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cronmanagement.bean.CronJob;
import cronmanagement.services.CronJobDetailsService;
import cronmanagement.services.CronJobParserService;

@Service
public class CronJobSchedulerTask {
    
    public final static Log LOGGER = LogFactory.getLog(CronJobSchedulerTask.class);

	@Autowired
	CronJobParserService cronJobParserService;
	
	@Autowired
	CronJobDetailsService cronDetailsService;

	public void fetchAndSaveCronDetails() {
		executeCommand();
	}

	public void executeCommand() {
	    LOGGER.info("Executing...");
	    LOGGER.debug("Executing...");
	    LOGGER.error("Executing...");
//		readFile(null);
	}

	public void readFile(InputStream inputStream) {
		List<CronJob> cronJobs = cronJobParserService.parse(inputStream);
        updateCronDetails(createServerCronJobMap(cronJobs));
	}

	public Map<Integer, List<CronJob>> createServerCronJobMap(
			List<CronJob> latestCronJobs) {
		Map<Integer, List<CronJob>> serverCronJobMap = new LinkedHashMap<Integer, List<CronJob>>();
		Iterator<CronJob> iterator = latestCronJobs.iterator();
		List<CronJob> cronJobList = null;
		CronJob tempCronJob = null;
		while (iterator.hasNext()) {
			tempCronJob = iterator.next();
			if (serverCronJobMap.get(tempCronJob.getServerId()) != null) {
				serverCronJobMap.get(tempCronJob.getServerId())
						.add(tempCronJob);
				serverCronJobMap.put(tempCronJob.getServerId(),
						serverCronJobMap.get(tempCronJob.getServerId()));
			} else {
				cronJobList = new ArrayList<CronJob>();
				cronJobList.add(tempCronJob);
				serverCronJobMap.put(tempCronJob.getServerId(), cronJobList);
			}
		}
		LOGGER.info("serverCronJobMap : "+serverCronJobMap);
		return serverCronJobMap;
	}

	private void updateCronDetails(Map<Integer, List<CronJob>> latestCronJobs) {
		Map<Integer, List<CronJob>> existingCronJobs = latestCronJobs; 
		if (existingCronJobs == null) {
			// TODO Save JObs to DB
		} else {
			for (int i = 0; i < existingCronJobs.size()
					|| i < latestCronJobs.size(); i++) {
			}
		}
	}

}
