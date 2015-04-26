package cronmanagement.services;

import java.util.List;

import cronmanagement.bean.ServerBean;

public interface ServerDetailsService {
    /**
     * This method is used to get all details of the server available in the
     * system
     * 
     * @return
     * 
     */
    public List<ServerBean> getServerDetails();

    /**
     * This method is used to get all details of the server available in the
     * system by serverId
     * 
     * @param serverId
     * @return
     */
    public ServerBean getServerDetailsByServerId(Integer serverId);

    /**
     * This method is used to get all details of the server available in the
     * system by datacenterId
     * 
     * @param dcId
     * @return
     */
    public List<ServerBean> getServerDetailsByDCId(Integer dcId);

    /**
     * This method is used to get all details of the server available in the
     * system by serverIP
     * 
     * @param ipAddress
     * @return
     */
    public ServerBean getServerDetailByIp(String ipAddress);

    /**
     * This method is currently used by the schedulers to update server health
     * 
     * @param healthPercenatge
     * @param serverId
     */
    public void updateServerHealth(Integer healthPercenatge, Integer serverId);

}
