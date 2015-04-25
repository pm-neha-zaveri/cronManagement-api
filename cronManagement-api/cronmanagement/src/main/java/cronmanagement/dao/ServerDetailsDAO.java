package cronmanagement.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import cronmanagement.bean.ServerBean;

@Service
public interface ServerDetailsDAO {

    public List<ServerBean> getServerDetails();

    public ServerBean getServerDetailsByServerId(@Param("serverId") Integer serverId);

    public List<ServerBean> getServerDetailsByDCId(@Param("dcId") Integer dcId);

    public void updateServerHealth(@Param("healthPercenatge") Integer healthPercenatge,
            @Param("serverId") Integer serverId);

}
