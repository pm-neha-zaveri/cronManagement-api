package cronmanagement.bean;

import java.util.Date;

public class CronRunHistory {
	private Long id;
	private Long cronId;
	private Date startDate;
	private Date endDate;
	private Boolean status;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCronId() {
		return cronId;
	}
	public void setCronId(Long cronId) {
		this.cronId = cronId;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}

}
