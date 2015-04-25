package cronmanagement.services;

import java.util.List;

import cronmanagement.bean.ServerBean;


public interface ServerDetailsService {

    public List<ServerBean> getServerDetails();

    public ServerBean getServerDetailsByServerId(Integer serverId);

    public List<ServerBean> getServerDetailsByDCId(Integer dcId);
    
    public ServerBean getServerDetailByIp(String ipAddress);
    
    public void updateServerHealth(Integer healthPercenatge,Integer serverId);

}
