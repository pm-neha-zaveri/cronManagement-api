package cronmanagement.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cronmanagement.bean.CronRunHistory;
import cronmanagement.dao.CronRunHistoryDAO;
import cronmanagement.services.CronRunHistoryService;

@Service
public class CronRunHistoryServiceImpl implements CronRunHistoryService {

	@Autowired
	private CronRunHistoryDAO cronRunHistoryDAO;

	@Override
	public List<CronRunHistory> getCronRunHistory() {
		return cronRunHistoryDAO.getCronRunHistory();
	}

}
