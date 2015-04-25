package cronmanagement.services.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cronmanagement.bean.DataCenterBean;
import cronmanagement.dao.DataCenterDetailsDAO;
import cronmanagement.services.DataCenterDetailsService;

@Service
public class DataCenterDetailsServiceImpl implements DataCenterDetailsService {

    public final static Log LOGGER = LogFactory.getLog(CronAlertDetailsServiceImpl.class);

    @Autowired
    DataCenterDetailsDAO dataCenterDetailsDAO;

    @Override
    public List<DataCenterBean> getAllDataCenters() {
        LOGGER.debug("Within " + getClass().getName() + "getAllDataCenters method");
        return dataCenterDetailsDAO.getAllDataCenters();
    }

    @Override
    public DataCenterBean getDataCenterById(Integer dcId) {
        LOGGER.debug("Within " + getClass().getName() + "getDataCenterById method. DcId :: " + dcId);
        return dataCenterDetailsDAO.getDataCenterById(dcId);
    }

    @Override
    public void updateServerHealth() {
        try {
            LOGGER.debug("Within " + getClass().getName() + "updateServerHealth method.");
            dataCenterDetailsDAO.updateServerHealth();
        } catch (Exception exception) {
            LOGGER.error("Exception occured while updating data center health " + exception.getMessage(), exception);
        }
    }

}
