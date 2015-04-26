package cronmanagement.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cronmanagement.bean.ServerBean;

/**
 * 
 * @author raghunandanG
 * 
 *         This will provide Server details.
 *
 */
public interface ServerDetailsDAO {

    /**
     * Will return all Server Details.
     * 
     * @return List<ServerBean>
     */
    public List<ServerBean> getServerDetails();

    /**
     * Will return Server Details for a Server.
     * 
     * @return List<ServerBean>
     */
    public ServerBean getServerDetailsByServerId(@Param("serverId") Integer serverId);

    /**
     * Will return all Server Details for a Data Center.
     * 
     * @return List<ServerBean>
     */
    public List<ServerBean> getServerDetailsByDCId(@Param("dcId") Integer dcId);

    /**
     * Will update Server Health.
     * 
     * @param healthPercenatge
     * @param serverId
     */
    public void updateServerHealth(@Param("healthPercenatge") Integer healthPercenatge,
            @Param("serverId") Integer serverId);

}
