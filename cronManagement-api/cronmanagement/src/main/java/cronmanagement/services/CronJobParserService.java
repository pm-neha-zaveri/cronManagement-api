package cronmanagement.services;

import java.io.InputStream;
import java.util.List;

import cronmanagement.bean.CronJob;

public interface CronJobParserService {

    public List<CronJob> parse(InputStream inputStream);

    public CronJob getCronJob(String cronComment, String cronJobInfo, Integer serverId);

    /**
     * Method will identify that given line is a cron or a Comment
     * 
     * @param line
     * @return
     */
    public boolean isComment(String line);

    /**
     * Method will compare 2 complete cron information and return the result
     * 
     * @param completeCron1
     * @param completeCron2
     * @return
     */
    public boolean isEqual(String completeCron1, String completeCron2);
}
