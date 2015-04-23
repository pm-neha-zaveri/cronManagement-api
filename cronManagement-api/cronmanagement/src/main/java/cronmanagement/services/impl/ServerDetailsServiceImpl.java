package cronmanagement.services.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cronmanagement.bean.ServerBean;
import cronmanagement.dao.ServerDetailsDAO;
import cronmanagement.services.ServerDetailsService;

@Service
public class ServerDetailsServiceImpl implements ServerDetailsService {

    public final static Log LOGGER = LogFactory.getLog(ServerDetailsServiceImpl.class);

    @Autowired
    ServerDetailsDAO serverDetailsDAO;

    @Override
    public ServerBean getServerDetailByIp(String ipAddress) {
        ServerBean serverDetail = null;
        if (ipAddress != null && ipAddress.trim().length() > 0) {
            List<ServerBean> serverDetailsList = serverDetailsDAO.getServerDetails();
            if (serverDetailsList != null) {
                for (ServerBean serverDetails : serverDetailsList) {
                    if (serverDetails.getServerIP() != null
                            && serverDetails.getServerIP().trim().equals(ipAddress.trim())) {
                        return serverDetail;
                    }
                }
            }
        }
        return serverDetail;
    }

    @Override
    public List<ServerBean> getServerDetails() {
        return serverDetailsDAO.getServerDetails();
    }

    @Override
    public ServerBean getServerDetailsByServerId(Integer serverId) {
        return serverDetailsDAO.getServerDetailsByServerId(serverId);
    }

    @Override
    public List<ServerBean> getServerDetailsByDCId(Integer dcId) {
        return serverDetailsDAO.getServerDetailsByDCId(dcId);
    }

}
