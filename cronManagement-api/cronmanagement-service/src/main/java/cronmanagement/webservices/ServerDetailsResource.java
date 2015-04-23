package cronmanagement.webservices;

import java.util.List;

import javax.annotation.Resource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cronmanagement.bean.ServerBean;
import cronmanagement.services.ServerDetailsService;

@Resource
@Path("/serverDetails")
public class ServerDetailsResource {

    public final static Log LOGGER = LogFactory.getLog(ServerDetailsResource.class);

    @Autowired
    ServerDetailsService serverDetailsService;

    @GET
    @Produces("application/json")
    public List<ServerBean> getServerDetails() {
        return serverDetailsService.getServerDetails();
    }

    @GET
    @Produces("application/json")
    public ServerBean getServerDetailsByServerId(@QueryParam("serverId") Integer serverId) {
        return serverDetailsService.getServerDetailsByServerId(serverId);
    }

    @GET
    @Produces("application/json")
    public ServerBean getServerDetailsByDCId(@QueryParam("dcId") Integer dcId) {
        return serverDetailsService.getServerDetailsByDCId(dcId);
    }

    @GET
    @Produces("application/json")
    public ServerBean getServerDetailByIp(@QueryParam("ipAddress") String ipAddress) {
        return serverDetailsService.getServerDetailByIp(ipAddress);
    }

}
