package cronmanagement.services.impl;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cronmanagement.bean.HealthCheck;
import cronmanagement.bean.ServerBean;
import cronmanagement.dao.HealthCheckDAO;
import cronmanagement.services.DataCenterDetailsService;
import cronmanagement.services.HealthCheckService;
import cronmanagement.services.ServerDetailsService;

/**
 * 
 * @author raghunandanG
 * 
 * This service will calculate health of server and data center and save both of them to database.
 *
 */
@Service
public class HealthCheckServiceImpl implements HealthCheckService {

    public final static Log LOGGER = LogFactory.getLog(HealthCheckServiceImpl.class);

    @Autowired
    HealthCheckDAO healthCheckDAO;

    @Autowired
    ServerDetailsService serverDetailsService;

    @Autowired
    DataCenterDetailsService dataCenterDetailsService;

    /**
     * Method will return true if health of server and data center are successfully updated to database.
     * @return {@link Boolean}
     */
    @Override
    public Boolean calculateHealth() {
        Boolean isUpdated = false;
        List<HealthCheck> cronAlertList = null;
        List<HealthCheck> cronLogList = null;
        List<ServerBean> serverList = serverDetailsService.getServerDetails();
        HealthCheck tempHealthParam = new HealthCheck();
        Integer healthPercentage = 100;
        try {
            cronAlertList = healthCheckDAO.getCronAlertDetails();
            cronLogList = healthCheckDAO.getCronLogDetails();

            Iterator<ServerBean> serverIterator = serverList.iterator();
            while (serverIterator.hasNext()) {
                HealthCheck cronAlertParam = null;
                HealthCheck cronLogParam = null;
                ServerBean serverBean = serverIterator.next();
                tempHealthParam.setServerId(serverBean.getId());
                if (cronAlertList != null && cronAlertList.contains(tempHealthParam)) {
                    cronAlertParam = cronAlertList.get(cronAlertList.indexOf(tempHealthParam));
                }
                if (cronLogList != null && cronLogList.contains(tempHealthParam)) {
                    cronLogParam = cronLogList.get(cronLogList.indexOf(tempHealthParam));
                }
                if (cronAlertParam != null) {
                    if (cronLogParam != null) {
                        if (cronLogParam.getTotal() < cronAlertParam.getTotal()) {
                            healthPercentage = 100;
                        } else {
                            healthPercentage = ((int) ((cronLogParam.getTotal() - cronAlertParam.getTotal()) / cronLogParam
                                    .getTotal()) * 100);
                        }
                    }
                } else {
                    healthPercentage = 100;
                }
                serverDetailsService.updateServerHealth(healthPercentage, serverBean.getId());
                isUpdated = true;
            }

        } catch (Exception exception) {
            LOGGER.error("Exception occured while calculating health" + exception.getMessage(), exception);
        }
        LOGGER.info("cronAlertList : " + cronAlertList + " cronLogList : " + cronLogList + " isUpdated : " + isUpdated);
        return isUpdated;
    }

}
