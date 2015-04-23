package cronmanagement.services;

import java.util.List;

import cronmanagement.bean.CronJob;

public interface CronDetailsService {
    public List<CronJob> getCronDetails();

    public List<CronJob> getCronDetailsByServerId(Integer serverId);

    public CronJob getCronDetailsByCronId(Integer cronId);
    
    public CronJob getCronDetailsByCronName(String cronName);
}
