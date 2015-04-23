package cronmanagement.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cronmanagement.bean.ServerDetails;
import cronmanagement.dao.ServerDetailsDAO;
import cronmanagement.services.ServerDetailsService;

@Service
public class ServerDetailsServiceImpl implements ServerDetailsService {
    
	@Autowired
	ServerDetailsDAO serverDetailsDAO;

	@Override
	public List<ServerDetails> getServerList() {
		return serverDetailsDAO.getServerDetails();
	}

    @Override
    public ServerDetails getServerDetailByIp(String ipAddress) {
        ServerDetails serverDetail = null;
        if(ipAddress != null && ipAddress.trim().length() > 0){
            List<ServerDetails> serverDetailsList = serverDetailsDAO.getServerDetails();
            if(serverDetailsList != null ){
                for(ServerDetails serverDetails : serverDetailsList){
                    if(serverDetails.getServerIP() != null && serverDetails.getServerIP().trim().equals(ipAddress.trim())){
                        return serverDetail;
                    }
                }
            }
        }
        return serverDetail;
    }
	
	

}
