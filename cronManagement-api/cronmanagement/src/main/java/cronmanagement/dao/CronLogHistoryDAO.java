package cronmanagement.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import cronmanagement.bean.CronJob;
import cronmanagement.bean.CronLogBean;

@Service
public interface CronLogHistoryDAO {
    
    public List<CronLogBean> getCronLogHistory();

    public void insertCronLogHistory(@Param("cronLogs") List<CronLogBean> cronLogs);
    
    public void updateCronLogHistory(@Param("cronLogs") List<CronLogBean> cronLogs);

}
