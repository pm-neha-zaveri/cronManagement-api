package cronmanagement.services.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cronmanagement.bean.CronForecast;
import cronmanagement.dao.CronForecastDAO;
import cronmanagement.services.CronForeCastService;
/**
 * 
 * @author neha-zaveri
 *
 */
@Service
public class CronForeCastServiceImpl implements CronForeCastService {

    public final static Log LOGGER = LogFactory.getLog(CronForeCastServiceImpl.class);

    @Autowired
    CronForecastDAO cronForecastDAO;

    @Override
    public List<CronForecast> getCronForecastHistory() {
        List<CronForecast> cronForeCastList = null;
        try {
            LOGGER.debug("Within " + getClass().getName() + " getCronForecastHistory method");
            cronForeCastList = cronForecastDAO.getCronForecastHistory();
            if(cronForeCastList != null){
                for (CronForecast cronForecast : cronForeCastList) {
                    cronForecast.setStartTime(cronForecast.getStartTime().replace(".0", ""));
                    cronForecast.setEndTime(cronForecast.getEndTime().replace(".0", ""));
                }
            }
        } catch (Exception exception) {
            LOGGER.error("Exception occured while fetching forecasting details" + exception.getMessage(), exception);
        }
        return cronForeCastList;
    }

    @Override
    public List<CronForecast> getCronForecastHistoryByCronId(Integer cronId) {
        List<CronForecast> cronForeCastList = null;
        try {
            LOGGER.debug("Within " + getClass().getName() + " getCronForecastHistoryByCronId method. CronId :: "
                    + cronId);
            cronForeCastList = cronForecastDAO.getCronForecastHistoryByCronId(cronId);
            if(cronForeCastList != null){
                for (CronForecast cronForecast : cronForeCastList) {
                    cronForecast.setStartTime(cronForecast.getStartTime().replace(".0", ""));
                    cronForecast.setEndTime(cronForecast.getEndTime().replace(".0", ""));
                }
            }
        } catch (Exception exception) {
            LOGGER.error("Exception occured while fetching forecasting details" + exception.getMessage(), exception);
        }
        return cronForeCastList;
    }

    @Override
    public List<CronForecast> getCronForecastHistoryByServerId(Integer serverId) {
        List<CronForecast> cronForeCastList = null;
        try {
            LOGGER.debug("Within " + getClass().getName() + " getCronForecastHistoryByServerId method. ServerId :: "
                    + serverId);
            cronForeCastList = cronForecastDAO.getCronForecastHistoryByServerId(serverId);
            if(cronForeCastList != null){
                for (CronForecast cronForecast : cronForeCastList) {
                    cronForecast.setStartTime(cronForecast.getStartTime().replace(".0", ""));
                    cronForecast.setEndTime(cronForecast.getEndTime().replace(".0", ""));
                }
            }
        } catch (Exception exception) {
            LOGGER.error("Exception occured while fetching forecasting details" + exception.getMessage(), exception);
        }
        return cronForeCastList;
    }

    @Override
    public void saveCronForecastHistory(List<CronForecast> CronForecasts) {
        try {
            LOGGER.info("Within " + getClass().getName() + " saveCronForecastHistory method");
            cronForecastDAO.saveCronForecastHistory(CronForecasts);
        } catch (Exception exception) {
            LOGGER.error("Exception occured while fetching forecasting details" + exception.getMessage(), exception);
        }

    }

}
