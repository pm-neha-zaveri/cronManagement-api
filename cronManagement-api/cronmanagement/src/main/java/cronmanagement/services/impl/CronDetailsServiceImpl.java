package cronmanagement.services.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import cronmanagement.bean.CronJob;
import cronmanagement.dao.CronDetailsDAO;
import cronmanagement.services.CronDetailsService;

@Service
public class CronDetailsServiceImpl implements CronDetailsService {

	public final static Log LOGGER = LogFactory
			.getLog(CronDetailsServiceImpl.class);

	@Resource
	MessageSource cronmanagementMessageSource;

	@Autowired
	CronDetailsDAO cronDetailsDAO;

	@Override
	public List<CronJob> getCronDetails() {
		return cronDetailsDAO.getCronDetails();

	}

    @Override
    public List<CronJob> getCronDetailsByServerId(Integer serverId) {
        return cronDetailsDAO.getCronDetailsByServerId(serverId);
    }

    @Override
    public CronJob getCronDetailsByCronId(Integer cronId) {
        return cronDetailsDAO.getCronDetailsByCronId(cronId);
    }

    @Override
    public CronJob getCronDetailsByCronName(String cronName) {
        List<CronJob> cronJobs = cronDetailsDAO.getCronDetails();
        CronJob cronJob = null;
        if(cronJobs != null && cronJobs.size() > 0){
            for(CronJob temCronJob : cronJobs){
                if(temCronJob.getCronName() != null && temCronJob.getCronName().trim().equals(cronName)){
                    cronJob = temCronJob;
                    break;
                }
            }
        }
        return cronJob;
    }
}
