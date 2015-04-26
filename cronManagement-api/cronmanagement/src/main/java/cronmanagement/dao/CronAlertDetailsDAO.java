package cronmanagement.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cronmanagement.bean.CronAlert;

/**
 * 
 * @author raghunandanG
 * 
 * This will perform operations on CronAlert Data.
 *
 */
public interface CronAlertDetailsDAO {

    /**
     * Method will return Cron alerts.
     * @return List<CronAlert>
     */
    List<CronAlert> getAllCronAlert();
    
    /**
     * Method will return Cron alerts for a Server.
     * @return List<CronAlert>
     */
    List<CronAlert> getAllCronAlertByServerId(@Param("serverId")Integer serverId);
    
    /**
     * Method will return Cron alerts for a DC.
     * @return List<CronAlert>
     */
    List<CronAlert> getAllCronAlertByDCId(@Param("dcId")Integer dcId);
    
    /**
     * Method will return Cron alerts for a Cron.
     * @return List<CronAlert>
     */
    List<CronAlert> getAllCronAlertByCronId(@Param("cronId")Integer cronId);
    
    /**
     * Method will save Cron Alert details to DB.
     * @param cronAlert
     */
    void saveCronAlert(@Param("cronAlert")CronAlert cronAlert);
    
}
