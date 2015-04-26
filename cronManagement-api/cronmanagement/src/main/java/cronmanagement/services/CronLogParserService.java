package cronmanagement.services;

import java.io.InputStream;
import java.util.List;

import cronmanagement.bean.CronLogBean;

public interface CronLogParserService {
    /**
     * This method is used to get all the cronlogs 
     * @param inputStream
     * @return
     */
    public List<CronLogBean> getCronLogs(InputStream inputStream);

    /**
     * This method is used to get all the cronlogbean 
     * @param logInfo
     * @return
     */
    public CronLogBean getCronLogBean(String logInfo);

    /**
     * This method is used to get all the update cronlogs
     * @param cronLogList
     * @return
     */
    public List<CronLogBean> updateCronLogs(List<CronLogBean> cronLogList);

}
