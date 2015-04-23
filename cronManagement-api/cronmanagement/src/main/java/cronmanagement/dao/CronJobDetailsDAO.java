package cronmanagement.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import cronmanagement.bean.CronJob;

@Service
public interface CronJobDetailsDAO {

    public List<CronJob> getCronJobDetails();

    public List<CronJob> getCronJobDetailsByServerId(@Param("serverId")Integer serverId);

    public CronJob getCronJobDetailsByCronId(@Param("cronId")Integer cronId);

    public void saveAllCronJobs(@Param("cronJobs") List<CronJob> cronJobs);
    
    public void updateAllCronJobs(@Param("cronJobs") List<CronJob> cronJobs);
}
