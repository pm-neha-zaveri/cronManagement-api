package cronmanagement.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cronmanagement.bean.CronAlert;

public interface CronAlertDetailsDAO {

    List<CronAlert> getAllCronAlert();
    
    List<CronAlert> getAllCronAlertByServerId(@Param("serverId")Integer serverId);
    
    List<CronAlert> getAllCronAlertByDCId(@Param("dcId")Integer dcId);
    
    List<CronAlert> getAllCronAlertByCronId(@Param("cronId")Integer cronId);
    
    void saveCronAlert(@Param("cronAlert")CronAlert cronAlert);
    
}
