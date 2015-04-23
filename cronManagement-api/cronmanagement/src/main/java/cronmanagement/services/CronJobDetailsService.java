package cronmanagement.services;

import java.util.List;

import cronmanagement.bean.CronJob;

public interface CronJobDetailsService {
    public List<CronJob> getCronJobDetails();

    public List<CronJob> getCronJobDetailsByServerId(Integer serverId);

    public CronJob getCronJobDetailsByCronId(Integer cronId);

    public void saveAllCronJobs(List<CronJob> cronJobs);

    public void updateAllCronJobs(List<CronJob> cronJobs);
    
    public CronJob getCronDetailsByCronName(String cronName);
}
