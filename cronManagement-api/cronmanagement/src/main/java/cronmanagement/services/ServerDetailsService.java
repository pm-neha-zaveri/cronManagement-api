package cronmanagement.services;

import java.util.List;

import cronmanagement.bean.ServerBean;


public interface ServerDetailsService {

    public List<ServerBean> getServerDetails();

    public ServerBean getServerDetailsByServerId(Integer serverId);

    public ServerBean getServerDetailsByDCId(Integer dcId);
    
    public ServerBean getServerDetailByIp(String ipAddress);

}
