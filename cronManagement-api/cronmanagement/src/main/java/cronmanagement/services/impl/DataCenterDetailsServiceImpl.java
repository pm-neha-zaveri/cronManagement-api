package cronmanagement.services.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cronmanagement.bean.DataCenterBean;
import cronmanagement.dao.DataCenterDetailsDao;
import cronmanagement.services.DataCenterDetailsService;

@Service
public class DataCenterDetailsServiceImpl implements DataCenterDetailsService {

    public final static Log LOGGER = LogFactory.getLog(CronAlertDetailsServiceImpl.class);

    @Autowired
    DataCenterDetailsDao dataCenterDetailsDao;

    @Override
    public List<DataCenterBean> getAllDataCenters() {
        return dataCenterDetailsDao.getAllDataCenters();
    }

    @Override
    public DataCenterBean getDataCenterById(Integer dcId) {
        return dataCenterDetailsDao.getDataCenterById(dcId);
    }

}
