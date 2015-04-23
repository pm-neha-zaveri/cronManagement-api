package cronmanagement.services.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import cronmanagement.bean.CronJob;
import cronmanagement.dao.CronJobDetailsDAO;
import cronmanagement.services.CronJobDetailsService;

@Service
public class CronJobDetailsServiceImpl implements CronJobDetailsService {

    public final static Log LOGGER = LogFactory.getLog(CronJobDetailsServiceImpl.class);

    @Resource
    MessageSource cronmanagementMessageSource;

    @Autowired
    CronJobDetailsDAO cronDetailsDAO;

    @Override
    public CronJob getCronDetailsByCronName(String cronName) {
        List<CronJob> cronJobs = cronDetailsDAO.getCronJobDetails();
        CronJob cronJob = null;
        if (cronJobs != null && cronJobs.size() > 0) {
            for (CronJob temCronJob : cronJobs) {
                if (temCronJob.getCronName() != null && temCronJob.getCronName().trim().equals(cronName.trim())) {
                    cronJob = temCronJob;
                    break;
                }
            }
        }
        return cronJob;
    }

    @Override
    public List<CronJob> getCronJobDetails() {
        return cronDetailsDAO.getCronJobDetails();
    }

    @Override
    public List<CronJob> getCronJobDetailsByServerId(Integer serverId) {
        return cronDetailsDAO.getCronJobDetailsByServerId(serverId);
    }

    @Override
    public CronJob getCronJobDetailsByCronId(Integer cronId) {
        return cronDetailsDAO.getCronJobDetailsByCronId(cronId);
    }

    @Override
    public void saveAllCronJobs(List<CronJob> cronJobs) {
        cronDetailsDAO.saveAllCronJobs(cronJobs);
    }

    @Override
    public void updateAllCronJobs(List<CronJob> cronJobs) {
        cronDetailsDAO.updateAllCronJobs(cronJobs);
    }

}
