package cronmanagement.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cronmanagement.bean.DataCenterBean;

/**
 * 
 * @author raghunandanG
 * 
 * This will provide data center details.
 *
 */
public interface DataCenterDetailsDAO {

    /**
     * Will give all the active data centers
     * @return List<DataCenterBean>
     */
    List<DataCenterBean> getAllDataCenters();
    
    /**
     * Will return data center by id.
     * @param dcId
     * @return DataCenterBean
     */
    DataCenterBean getDataCenterById(@Param("dcId") Integer dcId);

    /**
     * This will update DC health.
     */
    void updateDataCenterHealth();
    
}
