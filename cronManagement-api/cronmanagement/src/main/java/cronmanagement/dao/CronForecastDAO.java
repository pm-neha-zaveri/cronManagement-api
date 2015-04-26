package cronmanagement.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cronmanagement.bean.CronForecast;

/**
 * 
 * @author raghunandanG
 * 
 *         This will fetch Forecast details for crons.
 *
 */
public interface CronForecastDAO {

    /**
     * Method will return all cron's Forecast details
     * 
     * @return List<CronForecast>
     */
    public List<CronForecast> getCronForecastHistory();

    /**
     * Method will return cron's Forecast details
     * 
     * @return List<CronForecast>
     */
    public List<CronForecast> getCronForecastHistoryByCronId(@Param("cronId") Integer cronId);

    /**
     * Method will return all cron's on a Server Forecast details
     * 
     * @return List<CronForecast>
     */
    public List<CronForecast> getCronForecastHistoryByServerId(@Param("serverId") Integer serverId);

    /**
     * Will save Forcast details to database.
     * @param CronForecasts
     */
    public void saveCronForecastHistory(@Param("CronForeCasts") List<CronForecast> CronForecasts);

}
