package cronmanagement.bean;

import java.io.Serializable;

import com.pubmatic.apiutils.annotations.Dimension;

public class CronJob implements Serializable {

    private static final long serialVersionUID = 1L;
    @Dimension(columName="id")
    private Integer cronId;
    @Dimension(columName="serverId")
    private Integer serverId;
    private String cronExpression;
    private String cronName;
    private String cronCommand;
    private String cronStatus;
    private String cronComment;
    @Dimension(columName="cronType")
    private String cronType;

    public String getCronType() {
        return cronType;
    }

    public void setCronType(String cronType) {
        this.cronType = cronType;
    }

    public String getCronComment() {
        return cronComment;
    }

    public void setCronComment(String cronComment) {
        this.cronComment = cronComment;
    }

    public Integer getCronId() {
        return cronId;
    }

    public void setCronId(Integer cronId) {
        this.cronId = cronId;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    public String getCronName() {
        return cronName;
    }

    public void setCronName(String completeCron) {
        this.cronName = completeCron;
    }

    public String getCronCommand() {
        return cronCommand;
    }

    public void setCronCommand(String cronCommand) {
        this.cronCommand = cronCommand;
    }

    public String getCronStatus() {
        return cronStatus;
    }

    public void setCronStatus(String cronStatus) {
        this.cronStatus = cronStatus;
    }

    public Integer getServerId() {
        return serverId;
    }

    public void setServerId(Integer serverId) {
        this.serverId = serverId;
    }

    @Override
    public String toString() {
        return "CronJob [cronId=" + cronId + ", serverId=" + serverId + ", cronExpression=" + cronExpression
                + ", cronName=" + cronName + ", cronCommand=" + cronCommand + ", cronStatus=" + cronStatus
                + ", cronComment=" + cronComment + ", cronType=" + cronType + "]\n";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cronName == null) ? 0 : cronName.replace('#', ' ').trim().hashCode());
        result = prime * result + ((serverId == null) ? 0 : serverId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CronJob other = (CronJob) obj;
        if (cronName == null) {
            if (other.cronName != null)
                return false;
        } else if (!cronName.replace('#', ' ').trim().equals(other.cronName.replace('#', ' ').trim()))
            return false;
        if (serverId == null) {
            if (other.serverId != null)
                return false;
        } else if (!serverId.equals(other.serverId))
            return false;
        return true;
    }

}
