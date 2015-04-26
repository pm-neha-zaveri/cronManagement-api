package cronmanagement.services.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.pubmatic.apiutils.bean.RequestDetails;

import cronmanagement.bean.CronJob;
import cronmanagement.dao.CronJobDetailsDAO;
import cronmanagement.services.CronJobDetailsService;
/**
 * 
 * @author neha-zaveri
 *
 */
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
    public List<CronJob> getCronJobDetails(RequestDetails requestDetails) {
        return cronDetailsDAO.getCronJobDetails(requestDetails);
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
    public void updateAllCronJobs(CronJob cronJob) {
        cronDetailsDAO.updateAllCronJobs(cronJob);
    }

    @Override
    public List<CronJob> getCronJobDetailsByCronType(String cronType) {
        return cronDetailsDAO.getCronJobDetailsByCronType(cronType);
    }

    @Override
    public List<CronJob> getCronJobByServerIdAndCronName(Integer serverId, String cronName) {
        return cronDetailsDAO.getCronJobByServerIdAndCronName(serverId, cronName);
    }

    @Override
    public void deleteCronJobs(List<Integer> cronIds) {
        cronDetailsDAO.deleteCronJobs(cronIds);
    }

    @Override
    public void updateCronJobDetails() {
        cronDetailsDAO.updateCronAlertCountDetails();
        cronDetailsDAO.updateCronLogCountDetails();
//        cronDetailsDAO.updateThresholdDetails();
    }

}
