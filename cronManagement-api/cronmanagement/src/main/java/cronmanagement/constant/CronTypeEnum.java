package cronmanagement.constant;

public enum CronTypeEnum {
    ReportingCron("ReportingCron"), DatabaseCron("DatabaseCron"), SystemCron("SystemCron"), ApplicationCron("ApplicationCron");

    private final String cronType;

    CronTypeEnum(String cronType) {
        this.cronType = cronType;
    }
}
