package cronmanagement.services.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import cronmanagement.bean.CronLogBean;
import cronmanagement.services.CronLogParserService;

@Component
public class CronLogParserServiceImpl implements CronLogParserService{
    
    public final static Log LOGGER = LogFactory.getLog(CronLogParserServiceImpl.class);

	private final static String CRON_JOB_NAME = "Cron_Job_Name";
	private final static String CRONJOB_LOG = "CRONJOB LOG";

//	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd kk:mm:ss");
	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy kk:mm:ss");

	@Override
	public List<CronLogBean> getCronLogs(InputStream inputStream) {
		List<CronLogBean> cronLogList = new ArrayList<CronLogBean>();
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				inputStream));
		String logInfo = null;
		try {
			while ((logInfo = reader.readLine()) != null) {
				while (logInfo != null && logInfo.indexOf(CRON_JOB_NAME) == -1) {
					logInfo = reader.readLine();
				}
				logInfo = reader.readLine();
				while (logInfo != null) {
					cronLogList.add(getCronLogBean(logInfo));
					logInfo = reader.readLine();
					if (logInfo != null && logInfo.indexOf(CRONJOB_LOG) != -1) {
						break;
					}
				}
			}
		} catch (IOException e) {
		    LOGGER.error("Exception occured : "+e.getMessage(),e);
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
				    LOGGER.error("Exception occured : "+e.getMessage(),e);
				}
			}
		}
		Collections.sort(cronLogList, new CronLogComparator());
		return updateCronLogs(cronLogList);
	}

	@Override
	public CronLogBean getCronLogBean(String logInfo) {
		CronLogBean cronLogBean = null;
		String tokens[] = logInfo.trim().split("\\|");
		cronLogBean = new CronLogBean();
		cronLogBean.setCronName(tokens[0]);
		try {
			if (tokens.length > 1 && tokens[1].trim().length() > 0)
				cronLogBean.setServerIp(tokens[1].trim());
			if (tokens.length > 2 && tokens[2].trim().length() > 0)
				cronLogBean.setStartTime(formatter.parse(tokens[2].trim()));
			if (tokens.length > 3 && tokens[3].trim().length() > 0)
				cronLogBean.setEndTime(formatter.parse(tokens[3].trim()));
			if (tokens.length > 4 && tokens[4].trim().length() > 0)
				cronLogBean.setProcessId(Integer.parseInt(tokens[4].trim()));
		} catch (ParseException e) {
		    LOGGER.error("Exception occured : "+e.getMessage(),e);
		}
		return cronLogBean;
	}

	@Override
	public List<CronLogBean> updateCronLogs(List<CronLogBean> cronLogList) {
		List<CronLogBean> updatedCronLogs = new ArrayList<CronLogBean>();
		ListIterator<CronLogBean> iterator = cronLogList.listIterator();
		while (iterator.hasNext()) {
			CronLogBean cronLogBean1 = iterator.next();
			if (cronLogBean1.getStartTime() == null) {
				updatedCronLogs.add(cronLogBean1);
			} else {
				if (iterator.hasNext()) {
					CronLogBean cronLogBean2 = iterator.next();
					if (cronLogBean1.getCronName().equals(
							cronLogBean2.getCronName())) {
						if (cronLogBean2.getEndTime() != null) {
							cronLogBean1.setEndTime(cronLogBean2.getEndTime());
						}else{
							iterator.previous();
						}
						updatedCronLogs.add(cronLogBean1);
					} else {
						iterator.previous();
					}
				}
			}

		}
		return updatedCronLogs;
	}
}

class CronLogComparator implements Comparator<CronLogBean> {

	public int compare(CronLogBean o1, CronLogBean o2) {
		int result =  o1.getCronName().compareTo(o2.getCronName());
		if(result == 0 && o1.getProcessId() != null && o2.getProcessId() != null){
			return o1.getProcessId().compareTo(o2.getProcessId());
		} 
		return result;
	}

}