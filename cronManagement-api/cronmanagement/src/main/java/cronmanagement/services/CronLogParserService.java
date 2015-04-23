package cronmanagement.services;

import java.io.InputStream;
import java.util.List;

import cronmanagement.bean.CronLogBean;

public interface CronLogParserService {

    public List<CronLogBean> getCronLogs(InputStream inputStream);

    public CronLogBean getCronLogBean(String logInfo);

    public List<CronLogBean> updateCronLogs(List<CronLogBean> cronLogList);

}
