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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cronmanagement.bean.CronJob;
import cronmanagement.bean.CronLogBean;
import cronmanagement.bean.ServerBean;
import cronmanagement.services.CronJobDetailsService;
import cronmanagement.services.CronLogParserService;
import cronmanagement.services.ServerDetailsService;

@Component
public class CronLogParserServiceImpl implements CronLogParserService {

    public final static Log LOGGER = LogFactory.getLog(CronLogParserServiceImpl.class);

    private final static String CRONJOB_LOG = "CRONJOB LOG";

    @Autowired
    CronJobDetailsService cronJobDetailsService;

    @Autowired
    ServerDetailsService serverDetailsService;

    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
    SimpleDateFormat sql_formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    @Override
    public List<CronLogBean> getCronLogs(InputStream inputStream) {
        List<CronLogBean> cronLogList = new ArrayList<CronLogBean>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String logInfo = null;
        CronLogBean cronLogBean = null;
        try {
            while ((logInfo = reader.readLine()) != null) {
                while (logInfo != null && logInfo.trim().length() > 0) {
                    cronLogBean = getCronLogBean(logInfo);
                    if (cronLogBean != null)
                        cronLogList.add(getCronLogBean(logInfo));
                    logInfo = reader.readLine();
                    if (logInfo != null && logInfo.indexOf(CRONJOB_LOG) != -1) {
                        break;
                    }
                }
            }
        } catch (IOException e) {
            LOGGER.error("Exception occured : " + e.getMessage(), e);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    LOGGER.error("Exception occured : " + e.getMessage(), e);
                }
            }
        }
        Collections.sort(cronLogList, new CronLogComparator());
        LOGGER.info("cronLogList  : " + cronLogList);
        return updateCronLogs(cronLogList);
    }

    @Override
    public CronLogBean getCronLogBean(String logInfo) {
        CronLogBean cronLogBean = null;
        String tokens[] = logInfo.trim().split("\\|");
        try {
            Integer serverId = getServerIdByServeriP(tokens[1].trim());
            if (serverId != null) {
                List<CronJob> cronJobList = cronJobDetailsService.getCronJobByServerIdAndCronName(serverId, new String(
                        "%" + tokens[0] + "%"));
                CronJob cronJob = (cronJobList != null && cronJobList.size() > 0 ? cronJobList.get(0) : null);
                if (cronJob != null) {
                    cronLogBean = new CronLogBean();
                    cronLogBean.setServerId(serverId);
                    cronLogBean.setCronId(cronJob.getCronId());
                    if (tokens.length > 2 && tokens[2].trim().length() > 0)
                        cronLogBean.setStartTime(sql_formatter.format(formatter.parse(tokens[2].trim())));
                    if (tokens.length > 3 && tokens[3].trim().length() > 0)
                        cronLogBean.setEndTime(sql_formatter.format(formatter.parse(tokens[3].trim())));
                    if (tokens.length > 4 && tokens[4].trim().length() > 0)
                        cronLogBean.setProcessId(Integer.parseInt(tokens[4].trim()));
                }
            }
        } catch (ParseException e) {
            LOGGER.error("Exception occured : " + e.getMessage(), e);
        }
        return cronLogBean;
    }

    private Integer getServerIdByServeriP(String serverIp) {
        ServerBean serverDetails = serverDetailsService.getServerDetailByIp(serverIp);
        return (serverDetails != null ? serverDetails.getId().intValue() : 0);
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
                    if (cronLogBean1.getCronId().equals(cronLogBean2.getCronId())) {
                        if (cronLogBean2.getEndTime() != null) {
                            cronLogBean1.setEndTime(cronLogBean2.getEndTime());
                            try {
                                cronLogBean1.setRunTime(sql_formatter.parse(cronLogBean1.getEndTime()).getTime()
                                        - sql_formatter.parse(cronLogBean1.getStartTime()).getTime());
                            } catch (ParseException e) {
                                LOGGER.error("Exception occured while setting runtime : End Time "
                                        + cronLogBean1.getEndTime() + " Start Time " + cronLogBean1.getStartTime());
                            }
                        } else {
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
        int result = o1.getCronId().compareTo(o2.getCronId());
        if (result == 0 && o1.getServerId() != null && o2.getServerId() != null)
            result = o1.getServerId().compareTo(o2.getServerId());
        if (result == 0 && o1.getProcessId() != null && o2.getProcessId() != null) {
            return o1.getProcessId().compareTo(o2.getProcessId());
        }
        return result;
    }

}
