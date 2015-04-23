package cronmanagement.services;

import java.util.List;

import cronmanagement.bean.DataCenterBean;

public interface DataCenterDetailsService {

    List<DataCenterBean> getAllDataCenters();
    
    DataCenterBean getDataCenterById(Integer dcId);
    
}
