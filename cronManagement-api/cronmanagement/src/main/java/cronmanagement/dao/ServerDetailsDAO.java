package cronmanagement.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import cronmanagement.bean.ServerDetails;

@Service
public interface ServerDetailsDAO {

	public List<ServerDetails> getServerDetails();

}
