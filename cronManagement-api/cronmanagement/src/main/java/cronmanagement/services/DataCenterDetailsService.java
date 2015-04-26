package cronmanagement.services;

import java.util.List;

import cronmanagement.bean.DataCenterBean;

public interface DataCenterDetailsService {
    /**
     * This method will return all the dataCenters available in the system
     * 
     * @return
     */
    public List<DataCenterBean> getAllDataCenters();

    /**
     * This method will return datacenters based on dcId
     * 
     * @param dcId
     * @return
     */
    public DataCenterBean getDataCenterById(Integer dcId);

    /**
     * This method is used to periodically update the datacenters by schedulers
     */
    public void updateDataCenterHealth();

}
