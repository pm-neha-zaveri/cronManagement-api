package cronmanagement.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pubmatic.apiutils.bean.RequestDetails;

import cronmanagement.bean.CronJob;

/**
 * 
 * @author raghunandanG
 * 
 *         This will perform operations on CronJob.
 *
 */
public interface CronJobDetailsDAO {

    /**
     * This method will return all CronJob which are not Deleted.
     * 
     * @return List<CronJob>
     */
    public List<CronJob> getCronJobDetails();

    /**
     * This method will return all CronJob of a Server which are not Deleted.
     * 
     * @return List<CronJob>
     */
    public List<CronJob> getCronJobDetailsByServerId(@Param("serverId") Integer serverId);

    /**
     * This method will return CronJob which is not Deleted.
     * 
     * @return CronJob
     */
    public CronJob getCronJobDetailsByCronId(@Param("cronId") Integer cronId);

    /**
     * Will save CronDetails to Database.
     * 
     * @param cronJobs
     */
    public void saveAllCronJobs(@Param("cronJobs") List<CronJob> cronJobs);

    /**
     * Will update CronDetails to database.
     * 
     * @param cronJob
     */
    public void updateAllCronJobs(@Param("cronJob") CronJob cronJob);

    /**
     * Will give Cron Job List by cron Type.
     * 
     * @param cronType
     * @return List<CronJob>
     */
    public List<CronJob> getCronJobDetailsByCronType(@Param("cronType") String cronType);

    /**
     * Will return Cron Job Details by Server and cronName
     * 
     * @param serverId
     * @param cronName
     * @return List<CronJob>
     */
    public List<CronJob> getCronJobByServerIdAndCronName(@Param("serverId") Integer serverId,
            @Param("cronName") String cronName);

    /**
     * Delete cron Job details from database.
     * 
     * @param cronIds
     */
    public void deleteCronJobs(@Param("cronIds") List<Integer> cronIds);

    public List<CronJob> getCronJobDetails(@Param("requestDetails") RequestDetails requestDetails);

    /**
     * Method will update total Cron alerts for all Crons.
     */
    public void updateCronAlertCountDetails();

    /**
     * Method will update total Cron logs for all Crons.
     */
    public void updateCronLogCountDetails();

    /**
     * Method will update threshold for all Crons.
     */
    public void updateThresholdDetails();

}
