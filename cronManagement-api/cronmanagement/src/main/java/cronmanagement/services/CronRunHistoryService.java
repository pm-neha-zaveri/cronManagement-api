package cronmanagement.services;

import java.util.List;

import cronmanagement.bean.CronRunHistory;

public interface CronRunHistoryService {
	List<CronRunHistory> getCronRunHistory();
}
