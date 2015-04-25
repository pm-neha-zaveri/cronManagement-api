package cronmanagement.services;

import java.util.List;

import cronmanagement.bean.CronLogBean;

public interface CronLogHistoryService {

	public List<CronLogBean> getCronLogHistory();

	public List<CronLogBean> getCronLogHistoryByCronId(Integer cronId);

	public List<CronLogBean> getCronLogHistoryByServerId(Integer serverId);

	public void saveCronLogHistory(List<CronLogBean> cronLogs);

}
