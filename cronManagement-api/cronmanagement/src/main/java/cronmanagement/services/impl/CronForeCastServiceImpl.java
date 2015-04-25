package cronmanagement.services.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cronmanagement.bean.CronForecast;
import cronmanagement.dao.CronForecastDAO;
import cronmanagement.services.CronForeCastService;

@Service
public class CronForeCastServiceImpl implements CronForeCastService {

    public final static Log LOGGER = LogFactory.getLog(CronForeCastServiceImpl.class);

    @Autowired
    CronForecastDAO cronForecastDAO;

    @Override
    public List<CronForecast> getCronForecastHistory() {
        List<CronForecast> cronForeCastList = null;
        try {
            LOGGER.info("Within " + getClass().getName() + " getCronForecastHistory method");
            cronForeCastList = cronForecastDAO.getCronForecastHistory();
        } catch (Exception exception) {
            LOGGER.error("Exception occured while fetching forecasting details" + exception.getMessage(), exception);
        }
        return cronForeCastList;
    }

    @Override
    public List<CronForecast> getCronForecastHistoryByCronId(Integer cronId) {
        List<CronForecast> cronForeCastList = null;
        try {
            LOGGER.info("Within " + getClass().getName() + " getCronForecastHistoryByCronId method. CronId :: "
                    + cronId);
            cronForeCastList = cronForecastDAO.getCronForecastHistoryByCronId(cronId);
        } catch (Exception exception) {
            LOGGER.error("Exception occured while fetching forecasting details" + exception.getMessage(), exception);
        }
        return cronForeCastList;
    }

    @Override
    public List<CronForecast> getCronForecastHistoryByServerId(Integer serverId) {
        List<CronForecast> cronForeCastList = null;
        try {
            LOGGER.info("Within " + getClass().getName() + " getCronForecastHistoryByServerId method. ServerId :: "
                    + serverId);
            cronForeCastList = cronForecastDAO.getCronForecastHistoryByServerId(serverId);
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
