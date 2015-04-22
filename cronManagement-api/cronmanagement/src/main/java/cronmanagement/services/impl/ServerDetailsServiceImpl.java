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

}
