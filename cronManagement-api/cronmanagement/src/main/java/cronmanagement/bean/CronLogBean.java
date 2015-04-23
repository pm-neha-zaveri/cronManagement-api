package cronmanagement.bean;

import java.io.Serializable;
import java.util.Date;

public class CronLogBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private Date startTime;
    private Date endTime;
    private Integer cronId;
    private Integer serverId;
    private Integer processId;
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
        return "CronLogBean [id=" + id + ", startTime=" + startTime + ", endTime=" + endTime + ", cronId=" + cronId
                + ", serverId=" + serverId + ", processId=" + processId + ", status=" + status + "]\n";
    }

}
