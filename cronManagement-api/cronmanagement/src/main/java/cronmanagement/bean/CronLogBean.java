package cronmanagement.bean;

import java.io.Serializable;

public class CronLogBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private Integer cronId;
    private Integer serverId;
    private String startTime;
    private String endTime;
    private Integer processId;
    private Long runTime = -1l;

    public Long getRunTime() {
        return runTime;
    }

    public void setRunTime(Long runTime) {
        this.runTime = runTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProcessId() {
        return processId;
    }

    public void setProcessId(Integer processId) {
        this.processId = processId;
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

    @Override
    public String toString() {
        return "CronLogBean [id=" + id + ", cronId=" + cronId + ", serverId=" + serverId + ", startTime=" + startTime
                + ", endTime=" + endTime + ", processId=" + processId + ", runTime=" + runTime + "]";
    }

}
