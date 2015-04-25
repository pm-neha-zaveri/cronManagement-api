package cronmanagement.bean;

import java.io.Serializable;

public class CronForecast implements Serializable{

    private static final long serialVersionUID = 1L;
    private Integer id;
    private Integer cronId;
    private Integer serverId;
    private String startTime;
    private String endTime;
    private Long runTime = -1l;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCronId() {
        return cronId;
    }

    public void setCronId(Integer cronId) {
        this.cronId = cronId;
    }

    public Integer getServerId() {
        return serverId;
    }

    public void setServerId(Integer serverId) {
        this.serverId = serverId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Long getRunTime() {
        return runTime;
    }

    public void setRunTime(Long runTime) {
        this.runTime = runTime;
    }

    @Override
    public String toString() {
        return "CronForeCast [id=" + id + ", cronId=" + cronId + ", serverId=" + serverId + ", startTime=" + startTime
                + ", endTime=" + endTime + ", runTime=" + runTime + "]\n";
    }

}
