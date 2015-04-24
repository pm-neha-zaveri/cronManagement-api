package cronmanagement.services;

import java.io.IOException;

public interface CronRunningStatusService {

    public String getCronRunningStatus(String server,String cronName) throws IOException;

}
