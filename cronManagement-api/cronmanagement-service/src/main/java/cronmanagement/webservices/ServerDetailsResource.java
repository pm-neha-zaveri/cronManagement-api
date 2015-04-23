package cronmanagement.webservices;

import java.util.List;

import javax.annotation.Resource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;

import cronmanagement.bean.ServerBean;
import cronmanagement.services.ServerDetailsService;

@Resource
@Path("/server")
public class ServerDetailsResource {

	@Autowired
	ServerDetailsService serverDetailsService;

	@GET
	@Produces("application/json")
	public List<ServerBean> getServerList() {
		return serverDetailsService.getServerList();
	}

}
