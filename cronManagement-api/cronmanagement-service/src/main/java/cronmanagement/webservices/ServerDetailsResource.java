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

/**
 * 
 * @author neha-zaveri
 *
 */
@Component
@Path("/serverDetails")
public class ServerDetailsResource {

    public final static Log LOGGER = LogFactory.getLog(ServerDetailsResource.class);

    @Autowired
    ServerDetailsService serverDetailsService;

    /**
     * This method is used to get all server Details
     * @return
     */
    @GET
    @Produces("application/json")
    public List<ServerBean> getServerDetails() {
        LOGGER.info("Within " + getClass().getName() + " getServerDetails method.");
        return serverDetailsService.getServerDetails();
    }

    /**
     * This method is used to get all serverDetails by server id
     * @param serverId
     * @return
     */
    @GET
    @Produces("application/json")
    @Path("/server/{serverId}")
    public ServerBean getServerDetailsByServerId(@PathParam("serverId") Integer serverId) {
        LOGGER.info("Within " + getClass().getName() + " getServerDetailsByServerId method. ServerId :: " + serverId);
        return serverDetailsService.getServerDetailsByServerId(serverId);
    }

    /**
     * This method is used to get all server details by serverId
     * @param dcId
     * @return
     */
    @GET
    @Produces("application/json")
    @Path("/dc/{dcId}")
    public List<ServerBean> getServerDetailsByDCId(@PathParam("dcId") Integer dcId) {
        LOGGER.info("Within " + getClass().getName() + " getServerDetailsByDCId method. DcId :: " + dcId);
        return serverDetailsService.getServerDetailsByDCId(dcId);
    }

    /**
     * This method is used to get serverDetaisl by serverIP
     * @param ipAddress
     * @return
     */
    @GET
    @Produces("application/json")
    @Path("/ipaddress/")
    public ServerBean getServerDetailByIp(@QueryParam("ipAddress") String ipAddress) {
        LOGGER.info("Within " + getClass().getName() + " getServerDetailByIp method. IpAddress :: " + ipAddress);
        return serverDetailsService.getServerDetailByIp(ipAddress);
    }

}
