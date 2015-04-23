package cronmanagement.webservices;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cronmanagement.bean.ServerBean;
import cronmanagement.services.ServerDetailsService;

@Component
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
    @Path("/server/{serverId}")
    public ServerBean getServerDetailsByServerId(@PathParam("serverId") Integer serverId) {
        return serverDetailsService.getServerDetailsByServerId(serverId);
    }

    @GET
    @Produces("application/json")
    @Path("/dc/{dcId}")
    public List<ServerBean> getServerDetailsByDCId(@PathParam("dcId") Integer dcId) {
        return serverDetailsService.getServerDetailsByDCId(dcId);
    }

    @GET
    @Produces("application/json")
    @Path("/ipaddress/")
    public ServerBean getServerDetailByIp(@QueryParam("ipAddress") String ipAddress) {
        return serverDetailsService.getServerDetailByIp(ipAddress);
    }

}
