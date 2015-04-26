package cronmanagement.services.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cronmanagement.bean.ServerBean;
import cronmanagement.dao.ServerDetailsDAO;
import cronmanagement.services.ServerDetailsService;
import cronmanagement.utility.CacheUtil;
/**
 * 
 * @author neha-zaveri
 *
 */
@Service
public class ServerDetailsServiceImpl implements ServerDetailsService {

    public final static Log LOGGER = LogFactory.getLog(ServerDetailsServiceImpl.class);

    public static final String serverDetailCache = "serverDetailCache";
    public static final String serverDetailCacheKey = "serverDetailCacheKey";

    @Autowired
    ServerDetailsDAO serverDetailsDAO;

    @Override
    public ServerBean getServerDetailByIp(String ipAddress) {
        LOGGER.debug("Within " + getClass().getName() + " getServerDetailByIp method. IpAddress :: "+ipAddress);
        if (ipAddress != null && ipAddress.trim().length() > 0) {
            List<ServerBean> serverDetailsList = serverDetailsDAO.getServerDetails();
            if (serverDetailsList != null) {
                for (ServerBean serverDetails : serverDetailsList) {
                    if (serverDetails.getServerIP() != null
                            && serverDetails.getServerIP().trim().equals(ipAddress.trim())) {
                        return serverDetails;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public List<ServerBean> getServerDetails() {
        LOGGER.debug("Within " + getClass().getName() + " getServerDetails method");
        @SuppressWarnings("unchecked")
        List<ServerBean> serverDetails = (List<ServerBean>) CacheUtil.get(serverDetailCache, serverDetailCacheKey);
        if (serverDetails == null || serverDetails.size() == 0) {
            serverDetails = serverDetailsDAO.getServerDetails();
            CacheUtil.put(serverDetailCache, serverDetailCacheKey, serverDetails);
        }
        return serverDetailsDAO.getServerDetails();
    }

    @Override
    public ServerBean getServerDetailsByServerId(Integer serverId) {
        LOGGER.debug("Within " + getClass().getName() + " getServerDetailsByServerId method. ServerId :: "+serverId);
        return serverDetailsDAO.getServerDetailsByServerId(serverId);
    }

    @Override
    public List<ServerBean> getServerDetailsByDCId(Integer dcId) {
        LOGGER.debug("Within " + getClass().getName() + " getServerDetailsByDCId method");
        return serverDetailsDAO.getServerDetailsByDCId(dcId);
    }

    @Override
    public void updateServerHealth(Integer healthPercenatge, Integer serverId) {
        try{
            LOGGER.debug("Within " + getClass().getName() + " updateServerHealth method");
            serverDetailsDAO.updateServerHealth(healthPercenatge, serverId);
        }catch(Exception exception){
            LOGGER.error("Exception occured while saving health "+exception.getMessage(),exception);
        }
    }

}
