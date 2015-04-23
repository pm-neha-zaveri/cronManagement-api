package cronmanagement.services.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cronmanagement.bean.CronAlert;
import cronmanagement.dao.CronAlertDetailsDAO;
import cronmanagement.services.CronAlertDetailsService;

@Service
public class CronAlertDetailsServiceImpl implements CronAlertDetailsService {

    public final static Log LOGGER = LogFactory.getLog(CronAlertDetailsServiceImpl.class);

    @Autowired
    CronAlertDetailsDAO cronAlertDetailsDAO;

    @Override
    public List<CronAlert> getAllCronAlert() {
        return cronAlertDetailsDAO.getAllCronAlert();
    }

    @Override
    public List<CronAlert> getAllCronAlertByServerId(Integer serverId) {
        return cronAlertDetailsDAO.getAllCronAlertByServerId(serverId);
    }

    @Override
    public List<CronAlert> getAllCronAlertByDCId(Integer dcId) {
        return cronAlertDetailsDAO.getAllCronAlertByDCId(dcId);
    }

    @Override
    public List<CronAlert> getAllCronAlertByCronId(Integer cronId) {
        return cronAlertDetailsDAO.getAllCronAlertByCronId(cronId);
    }

    @Override
    public void saveCronAlert(CronAlert cronAlert) {
        cronAlertDetailsDAO.saveCronAlert(cronAlert);
    }

}
