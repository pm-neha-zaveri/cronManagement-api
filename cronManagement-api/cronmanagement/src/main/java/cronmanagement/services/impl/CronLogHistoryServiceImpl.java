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
    public List<CronLogBean> getCronLogHistory() {
        return cronLogHistoryDAO.getCronLogHistory();
    }

    @Override
    public List<CronLogBean> getCronLogHistoryByCronId(Integer cronId) {
        return cronLogHistoryDAO.getCronLogHistoryByCronId(cronId);
    }

    @Override
    public List<CronLogBean> getCronLogHistoryByServerId(Integer serverId) {
        return cronLogHistoryDAO.getCronLogHistoryByServerId(serverId);
    }

    @Override
    public void saveCronLogHistory(List<CronLogBean> cronLogs) {
        cronLogHistoryDAO.saveCronLogHistory(cronLogs);
    }

}
