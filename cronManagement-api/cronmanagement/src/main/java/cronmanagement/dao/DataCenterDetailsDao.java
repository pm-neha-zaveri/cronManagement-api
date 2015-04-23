package cronmanagement.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cronmanagement.bean.DataCenterBean;

public interface DataCenterDetailsDao {

    List<DataCenterBean> getAllDataCenters();
    
    DataCenterBean getDataCenterById(@Param("dcId") Integer dcId);
    
}
