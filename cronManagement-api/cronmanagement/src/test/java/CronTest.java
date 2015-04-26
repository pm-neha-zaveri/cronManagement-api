import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cronmanagement.bean.CronAlert;
import cronmanagement.services.CronAlertDetailsService;
import cronmanagement.services.CronJobParserService;
import cronmanagement.services.CronLogParserService;
import cronmanagement.services.impl.CronJobParserServiceImpl;

public class CronTest {

    CronJobParserService cronJobParserService;

    CronLogParserService cronLogParserService;

    // @Autowired
    CronAlertDetailsService cronAlertDetailsService;

    // @Test
    public void test() {
        System.out.println(cronJobParserService.getCronJob("#comment ",
                "00 09-18 * * 1-5 /home/ramesh/bin/check-db-status", 1));
        System.out.println(cronJobParserService.getCronJob("#comment ", "30 08 10 06 * /home/ramesh/full-backup", 1));
        System.out.println(cronJobParserService.getCronJob("#comment ",
                "00 11,16 * * * /home/ramesh/bin/incremental-backup", 1));
        System.out.println(cronJobParserService.getCronJob("#comment ",
                "00 09-18 * * * /home/ramesh/bin/check-db-status", 1));
        System.out.println(cronJobParserService
                .getCronJob("#comment ", "*/10 * * * * /home/ramesh/check-disk-space", 1));
        System.out.println(cronJobParserService.getCronJob("#comment ", "@monthly /home/sathiya/monthly-backup", 1));
        System.out.println(cronJobParserService.getCronJob("#comment ",
                "@yearly /home/ramesh/centos/bin/annual-maintenance", 1));
    }

    // @Test
    public void testFile() throws FileNotFoundException {
        cronJobParserService = new CronJobParserServiceImpl();
        File file = new File("jobdetails.txt");
        System.out.println(cronJobParserService.parse(new FileInputStream(file)));
    }

    // @Test
    public void testTwoCrons() throws FileNotFoundException {
        System.out.println(cronJobParserService.isEqual("40 * * * * /usr/bin/php test.php >> file.txt",
                "40 * * * * /usr/bin/php test1.php >> file.txt"));
        System.out.println(cronJobParserService.isEqual("40 * * * * /usr/bin/php test.php >> file.txt",
                "   40 * * * * /usr/bin/php test.php >> file.txt"));
    }

    @Test
    public void testCronLog() throws FileNotFoundException {
        File file = new File("cron_log.txt");
        System.out.println(cronLogParserService.getCronLogs(new FileInputStream(file)));
    }

    // @Test
    public void testCronTask() throws FileNotFoundException {
        ApplicationContext context = new ClassPathXmlApplicationContext("cronmanagement-context.xml");
        cronJobParserService = (CronJobParserService) context.getBean("cronJobParserService");
    }

    //@Test
    public void sendAlertTest() {
        CronAlert cronAlert = new CronAlert();
        cronAlertDetailsService.sendAlert(cronAlert);

    }
}
