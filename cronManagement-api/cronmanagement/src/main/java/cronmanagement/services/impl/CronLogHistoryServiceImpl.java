package cronmanagement.services.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cronmanagement.bean.CronLogBean;
import cronmanagement.dao.CronLogHistoryDAO;
import cronmanagement.services.CronLogHistoryService;

/**
 * 
 * @author neha-zaveri
 *
 */
@Service
public class CronLogHistoryServiceImpl implements CronLogHistoryService {

    public final static Log LOGGER = LogFactory.getLog(CronLogHistoryServiceImpl.class);

    @Autowired
    CronLogHistoryDAO cronLogHistoryDAO;

    @Override
    public List<CronLogBean> getCronLogHistory() {
        LOGGER.debug("Within " + getClass().getName() + " getCronLogHistory method.");
        List<CronLogBean> cronList = cronLogHistoryDAO.getCronLogHistory();
        if (cronList != null) {
            for (CronLogBean cronLogBean : cronList) {
                if (cronLogBean.getStartTime() != null)
                    cronLogBean.setStartTime(cronLogBean.getStartTime().replace(".0", ""));
                if (cronLogBean.getEndTime() != null)
                    cronLogBean.setEndTime(cronLogBean.getEndTime().replace(".0", ""));
            }
        }

        return cronList;
    }

    @Override
    public List<CronLogBean> getCronLogHistoryByCronId(Integer cronId) {
        LOGGER.debug("Within " + getClass().getName() + " getCronLogHistoryByCronId method. CronId :: " + cronId);
        List<CronLogBean> cronList = cronLogHistoryDAO.getCronLogHistoryByCronId(cronId);
        if (cronList != null) {
            for (CronLogBean cronLogBean : cronList) {
                if (cronLogBean.getStartTime() != null)
                    cronLogBean.setStartTime(cronLogBean.getStartTime().replace(".0", ""));
                if (cronLogBean.getEndTime() != null)
                    cronLogBean.setEndTime(cronLogBean.getEndTime().replace(".0", ""));
            }
        }

        return cronList;
    }

    @Override
    public List<CronLogBean> getCronLogHistoryByServerId(Integer serverId) {
        LOGGER.debug("Within " + getClass().getName() + " getCronLogHistoryByServerId method. ServerId :: " + serverId);
        List<CronLogBean> cronList = cronLogHistoryDAO.getCronLogHistoryByServerId(serverId);
        if (cronList != null) {
            for (CronLogBean cronLogBean : cronList) {
                if (cronLogBean.getStartTime() != null)
                    cronLogBean.setStartTime(cronLogBean.getStartTime().replace(".0", ""));
                if (cronLogBean.getEndTime() != null)
                    cronLogBean.setEndTime(cronLogBean.getEndTime().replace(".0", ""));
            }
        }
        return cronList;
    }

    @Override
    public void saveCronLogHistory(List<CronLogBean> cronLogs) {
        LOGGER.info("Within " + getClass().getName() + " saveCronLogHistory method.");
        if (cronLogs != null && cronLogs.size() > 0)
            cronLogHistoryDAO.saveCronLogHistory(cronLogs);
    }

}
