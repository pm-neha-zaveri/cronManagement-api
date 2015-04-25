package cronmanagement.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.pubmatic.apiutils.bean.RequestDetails;

import cronmanagement.bean.CronJob;

@Service
public interface CronJobDetailsDAO {

    public List<CronJob> getCronJobDetails();

    public List<CronJob> getCronJobDetailsByServerId(@Param("serverId") Integer serverId);

    public CronJob getCronJobDetailsByCronId(@Param("cronId") Integer cronId);

    public void saveAllCronJobs(@Param("cronJobs") List<CronJob> cronJobs);

    public void updateAllCronJobs(@Param("cronJob") CronJob cronJob);

    public List<CronJob> getCronJobDetailsByCronType(@Param("cronType") String cronType);

    public List<CronJob> getCronJobByServerIdAndCronName(@Param("serverId") Integer serverId,
            @Param("cronName") String cronName);

    public void deleteCronJobs(@Param("cronIds") List<Integer> cronIds);

    public List<CronJob> getCronJobDetails(@Param("requestDetails") RequestDetails requestDetails);

    public void updateCronAlertCountDetails();

    public void updateCronLogCountDetails();

    public void updateThresholdDetails();

}
