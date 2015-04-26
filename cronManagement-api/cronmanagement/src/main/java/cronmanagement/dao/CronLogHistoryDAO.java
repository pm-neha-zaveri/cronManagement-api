package cronmanagement.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cronmanagement.bean.CronLogBean;
/**
 * 
 * @author raghunandanG
 * 
 * This will perform operation on Cron Log History.
 *
 */
public interface CronLogHistoryDAO {

    /**
     * Will return all cron log history.
     * 
     * @return List<CronLogBean>
     */
    public List<CronLogBean> getCronLogHistory();

    /**
     * Will return all cron log history of a Cron.
     * @return List<CronLogBean>
     */
    public List<CronLogBean> getCronLogHistoryByCronId(@Param("cronId") Integer cronId);

    /**
     * Will return all cron log history of a Server.
     * @return List<CronLogBean>
     */
    public List<CronLogBean> getCronLogHistoryByServerId(@Param("serverId") Integer serverId);

    /**
     * Will persist cron log history details in database
     * @param cronLogs
     */
    public void saveCronLogHistory(@Param("cronLogs") List<CronLogBean> cronLogs);

}
