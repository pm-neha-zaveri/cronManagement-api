package cronmanagement.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import cronmanagement.bean.CronJob;

@Service
public interface CronDetailsDAO {

    public List<CronJob> getCronDetails();

    public List<CronJob> getCronDetailsByServerId(@Param("serverId")Integer serverId);

    public CronJob getCronDetailsByCronId(@Param("cronId")Integer cronId);

    public void saveAll(@Param("cronJobs") List<CronJob> cronJobs);
}
