package cronmanagement.bean;

import java.io.Serializable;

public class CronAlertRequestBean implements Serializable {
	private Long processId;
	private String cronName;
	private String cronServerIP;
	private String cronStartTime;
	private String cronEndTime;
	private String threshhold;
	private String actualRunTimeSec;

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

	public String getCronServerIP() {
		return cronServerIP;
	}

	public void setCronServerIP(String cronServerIP) {
		this.cronServerIP = cronServerIP;
	}

	public String getCronStartTime() {
		return cronStartTime;
	}

	public void setCronStartTime(String cronStartTime) {
		this.cronStartTime = cronStartTime;
	}

	public String getCronEndTime() {
		return cronEndTime;
	}

	public void setCronEndTime(String cronEndTime) {
		this.cronEndTime = cronEndTime;
	}

	public String getThreshhold() {
		return threshhold;
	}

	public void setThreshhold(String threshhold) {
		this.threshhold = threshhold;
	}

	public String getActualRunTimeSec() {
		return actualRunTimeSec;
	}

	public void setActualRunTimeSec(String actualRunTimeSec) {
		this.actualRunTimeSec = actualRunTimeSec;
	}

}
