package cronmanagement.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import cronmanagement.bean.CronLogBean;

@Service
public interface CronLogHistoryDAO {

    public List<CronLogBean> getCronLogHistory();

    public List<CronLogBean> getCronLogHistoryByCronId(@Param("cronId") Integer cronId);

    public List<CronLogBean> getCronLogHistoryByServerId(@Param("serverId") Integer serverId);

    public void saveCronLogHistory(@Param("cronLogs") List<CronLogBean> cronLogs);

}
