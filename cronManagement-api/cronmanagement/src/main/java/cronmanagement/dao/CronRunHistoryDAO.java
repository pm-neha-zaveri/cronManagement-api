package cronmanagement.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import cronmanagement.bean.CronRunHistory;
@Service
public interface CronRunHistoryDAO {
	public List<CronRunHistory> getCronRunHistory();
}
