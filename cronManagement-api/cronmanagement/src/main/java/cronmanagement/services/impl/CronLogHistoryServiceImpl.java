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

	public final static Log LOGGER = LogFactory
			.getLog(CronLogHistoryServiceImpl.class);

	@Autowired
	CronLogHistoryDAO cronLogHistoryDAO;

	@Override
	public List<CronLogBean> getCronLogHistory() {
		List<CronLogBean> cronList = cronLogHistoryDAO.getCronLogHistory();
		for (CronLogBean cronLogBean : cronList) {
			cronLogBean.setStartTime(cronLogBean.getStartTime().replace(".0",
					""));
			cronLogBean.setEndTime(cronLogBean.getEndTime().replace(".0", ""));
		}

		return cronList;
	}

	@Override
	public List<CronLogBean> getCronLogHistoryByCronId(Integer cronId) {
		List<CronLogBean> cronList = cronLogHistoryDAO
				.getCronLogHistoryByCronId(cronId);
		for (CronLogBean cronLogBean : cronList) {
			cronLogBean.setStartTime(cronLogBean.getStartTime().replace(".0",
					""));
			cronLogBean.setEndTime(cronLogBean.getEndTime().replace(".0", ""));
		}

		return cronList;
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
