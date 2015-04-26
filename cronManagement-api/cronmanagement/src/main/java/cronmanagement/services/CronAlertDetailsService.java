package cronmanagement.services;

import java.text.ParseException;
import java.util.List;

import cronmanagement.bean.CronAlert;

public interface CronAlertDetailsService {
    /**
     * 
     * @return
     * This method will list all cron alerts available in the system
     */
    List<CronAlert> getAllCronAlert();

    /**
     * 
     * @param serverId
     * @return
     * This method will list all cron alerts available in the system for given serverId
     */
    List<CronAlert> getAllCronAlertByServerId(Integer serverId);

    /**
     * 
     * @param dcId
     * @return
     * This method will list all cron alerts available in the system for given dcId
     */
    List<CronAlert> getAllCronAlertByDCId(Integer dcId);

    /**
     * 
     * @param cronId
     * @return
     * This method will list all cron alerts available in the system for given cronId
     */
    List<CronAlert> getAllCronAlertByCronId(Integer cronId);
    /**
     * 
     * @param cronAlert
     * @throws ParseException
     * 
     */
    void saveCronAlertDataToDB(CronAlert cronAlert) throws ParseException;

}
