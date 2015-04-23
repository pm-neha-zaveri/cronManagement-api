package cronmanagement.services.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cronmanagement.bean.CronLogBean;
import cronmanagement.dao.CronLogHistoryDAO;
import cronmanagement.services.CronLogHistoryService;

@Service
public class CronLogHistoryServiceImpl implements CronLogHistoryService {

    public final static Log LOGGER = LogFactory.getLog(CronLogHistoryServiceImpl.class);

    @Autowired
    CronLogHistoryDAO cronLogHistoryDAO;

    @Override
    public List<CronLogBean> getCronLog() {
        return cronLogHistoryDAO.getCronLogHistory();
    }

    @Override
    public void saveCronLog(List<CronLogBean> cronLogBeans) {
        cronLogHistoryDAO.insertCronLogHistory(cronLogBeans);
    }

    @Override
    public void updateCronLog(List<CronLogBean> cronLogBeans) {
        cronLogHistoryDAO.updateCronLogHistory(cronLogBeans);
    }

}
