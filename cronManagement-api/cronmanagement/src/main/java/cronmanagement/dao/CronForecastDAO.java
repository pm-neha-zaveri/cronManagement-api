package cronmanagement.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import cronmanagement.bean.CronForecast;

@Service
public interface CronForecastDAO {

    public List<CronForecast> getCronForecastHistory();

    public List<CronForecast> getCronForecastHistoryByCronId(@Param("cronId") Integer cronId);

    public List<CronForecast> getCronForecastHistoryByServerId(@Param("serverId") Integer serverId);

    public void saveCronForecastHistory(@Param("CronForeCasts") List<CronForecast> CronForecasts);
    
}
