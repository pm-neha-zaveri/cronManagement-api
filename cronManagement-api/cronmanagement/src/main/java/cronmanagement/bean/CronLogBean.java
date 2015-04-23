package cronmanagement.bean;

import java.io.Serializable;
import java.util.Date;

public class CronLogBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Date startTime;
	private Date endTime;
	private String cronName;
	private String serverIp;
	private Integer processId;

	public String getServerIp() {
		return serverIp;
	}

	public void setServerIp(String serverIp) {
		this.serverIp = serverIp;
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

	public String getCronName() {
		return cronName;
	}

	public void setCronName(String cronName) {
		this.cronName = cronName;
	}

	@Override
	public String toString() {
		return "CronLogBean [startTime=" + startTime + ", endTime=" + endTime
				+ ", cronName=" + cronName + ", serverIp=" + serverIp
				+ ", processId=" + processId + "]\n";
	}

}
