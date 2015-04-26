package cronmanagement.services;

import java.util.List;

import cronmanagement.bean.CronForecast;

public interface CronForeCastService {
    /**
     * This method is used to get all the CronForecast history
     * @return
     */
    public List<CronForecast> getCronForecastHistory();

    /**
     * This method is used to get all the CronForecast by cronId
     * @param cronId
     * @return
     */
    public List<CronForecast> getCronForecastHistoryByCronId(Integer cronId);

    /**
     * This method is used to get all the CronForecast by serverId
     * @param serverId
     * @return
     */
    public List<CronForecast> getCronForecastHistoryByServerId(Integer serverId);

    /**
     * This method is used to save all the CronForecast 
     * @param CronForecasts
     */
    public void saveCronForecastHistory(List<CronForecast> CronForecasts);
}
