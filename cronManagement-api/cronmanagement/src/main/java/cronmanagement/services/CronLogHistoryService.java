package cronmanagement.services;

import java.util.List;

import cronmanagement.bean.CronLogBean;

public interface CronLogHistoryService {
    
    public List<CronLogBean> getCronLog();
    
    public void saveCronLog(List<CronLogBean> cronLogBeans);
    
    public void updateCronLog(List<CronLogBean> cronLogBeans);

}
