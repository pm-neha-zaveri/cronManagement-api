package cronmanagement.bean;

import java.io.Serializable;

public class CronAlert implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private Integer cronId;
    private Integer serverId;
    private Integer dcId;
    private String alertDescription;
    private String startTime;
    private String endTime;
    private Integer runTime;
    private Integer threshold;
    private Long processId;
    private String cronName;
    private String serverIP;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getProcessId() {
		return processId;
	}

	public void setProcessId(Long processId) {
		this.processId = processId;
	}

	public String getCronName() {
		return cronName;
	}

	public void setCronName(String cronName) {
		this.cronName = cronName;
	}

	public String getServerIP() {
		return serverIP;
	}

	public void setServerIP(String serverIP) {
		this.serverIP = serverIP;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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

    public Integer getDcId() {
        return dcId;
    }

    public void setDcId(Integer dcId) {
        this.dcId = dcId;
    }

    public String getAlertDescription() {
        return alertDescription;
    }

    public void setAlertDescription(String alertDescription) {
        this.alertDescription = alertDescription;
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

    public Integer getRunTime() {
        return runTime;
    }

    public void setRunTime(Integer runTime) {
        this.runTime = runTime;
    }

    public Integer getThreshold() {
        return threshold;
    }

    public void setThreshold(Integer threshold) {
        this.threshold = threshold;
    }


    @Override
    public String toString() {
        return "CronAlert [id=" + id + ", cronId=" + cronId + ", serverId=" + serverId + ", dcId=" + dcId
                + ", alertDescription=" + alertDescription + ", startTime=" + startTime + ", endTime=" + endTime
                + ", runTime=" + runTime + ", threshold=" + threshold + "]";
    }
}
