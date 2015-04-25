package cronmanagement.services;

import java.util.List;

import cronmanagement.bean.CronForecast;

public interface CronForeCastService {

    public List<CronForecast> getCronForecastHistory();

    public List<CronForecast> getCronForecastHistoryByCronId(Integer cronId);

    public List<CronForecast> getCronForecastHistoryByServerId(Integer serverId);

    public void saveCronForecastHistory(List<CronForecast> CronForecasts);
}
