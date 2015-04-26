package cronmanagement.services;

import java.util.List;

import cronmanagement.bean.CronLogBean;

public interface CronLogHistoryService {
    /**
     * This method is used to get all the cronlog history
     * 
     * @return
     */
    public List<CronLogBean> getCronLogHistory();

    /**
     * This method is used to get all the cronlog history by cronId
     * 
     * @param cronId
     * @return
     */
    public List<CronLogBean> getCronLogHistoryByCronId(Integer cronId);

    /**
     * This method is used to get all the cronlog history by serverId
     * 
     * @param serverId
     * @return
     */
    public List<CronLogBean> getCronLogHistoryByServerId(Integer serverId);

    /**
     * This method is used to save all the cronlog (Currently used by
     * schedulers)
     * 
     * @param cronLogs
     */
    public void saveCronLogHistory(List<CronLogBean> cronLogs);

}
