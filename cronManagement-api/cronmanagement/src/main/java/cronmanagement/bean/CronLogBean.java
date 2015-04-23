package cronmanagement.bean;

import java.io.Serializable;
import java.util.Date;

public class CronLogBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private Integer cronId;
    private Integer serverId;
    private Date startTime;
    private Date endTime;
    private Integer processId;
    private Integer threshold;
    private Long runTime = -1l;

    public Integer getThreshold() {
        return threshold;
    }

    public void setThreshold(Integer threshold) {
        this.threshold = threshold;
    }

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

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
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

    @Override
    public String toString() {
        return "CronLogBean [id=" + id + ", cronId=" + cronId + ", serverId=" + serverId + ", startTime=" + startTime
                + ", endTime=" + endTime + ", processId=" + processId + ", threshold=" + threshold + ", runTime="
                + runTime + "]";
    }

}
