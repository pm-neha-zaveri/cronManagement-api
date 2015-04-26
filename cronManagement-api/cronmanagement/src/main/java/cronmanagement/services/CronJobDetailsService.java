package cronmanagement.services;

import java.util.List;

import com.pubmatic.apiutils.bean.RequestDetails;

import cronmanagement.bean.CronJob;

public interface CronJobDetailsService {
    /**
     * This method is used to return all cron job details by serverId
     * 
     * @param serverId
     * @return
     */
    public List<CronJob> getCronJobDetailsByServerId(Integer serverId);

    /**
     * This method is used to return all cron job details by cronId
     * 
     * @param cronId
     * @return
     */
    public CronJob getCronJobDetailsByCronId(Integer cronId);

    /**
     * This method is used to return all cron job details
     * 
     * @param cronJobs
     */
    public void saveAllCronJobs(List<CronJob> cronJobs);

    /**
     * This method is used to update all cron job details
     * 
     * @param cronJob
     */
    public void updateAllCronJobs(CronJob cronJob);

    /**
     * 
     * @param cronIds
     */
    public void deleteCronJobs(List<Integer> cronIds);

    /**
     * This method is used to return all cron job details by cronName
     * 
     * @param cronName
     * @return
     */

    public CronJob getCronDetailsByCronName(String cronName);

    /**
     * This method is used to return all cron job details by cronType
     * 
     * @param cronType
     * @return
     */
    public List<CronJob> getCronJobDetailsByCronType(String cronType);

    /**
     * This method is used to return all cron job details by serverId and
     * cronName
     * 
     * @param serverId
     * @param cronName
     * @return
     */
    public List<CronJob> getCronJobByServerIdAndCronName(Integer serverId, String cronName);

    /**
     * This method is used to return all cron job details by search criteria
     * 
     * @param requestDetails
     * @return
     */
    List<CronJob> getCronJobDetails(RequestDetails requestDetails);

    /**
     * This method is used to update all cron job details
     */
    public void updateCronJobDetails();
}
