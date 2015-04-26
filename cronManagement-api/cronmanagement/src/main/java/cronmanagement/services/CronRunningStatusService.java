package cronmanagement.services;

import java.io.IOException;

public interface CronRunningStatusService {
    /**
     * 
     * @param server
     * @param cronName
     * @return
     * @throws IOException
     */
    public String getCronRunningStatus(String server, String cronName) throws IOException;

}
