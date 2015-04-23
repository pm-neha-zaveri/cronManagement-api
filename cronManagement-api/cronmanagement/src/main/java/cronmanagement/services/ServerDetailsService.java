package cronmanagement.services;

import java.util.List;

import org.springframework.stereotype.Service;

import cronmanagement.bean.ServerDetails;


@Service
public interface ServerDetailsService {

    public List<ServerDetails> getServerList();

    public ServerDetails getServerDetailByIp(String ipAddress);

}
