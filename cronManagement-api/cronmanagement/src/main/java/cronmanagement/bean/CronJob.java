package cronmanagement.bean;

import java.io.Serializable;

public class CronJob implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer cronId;
    private Integer serverId;
    private String cronExpression;
    private String cronName;
    private String cronCommand;
    private String cronStatus;
    private String cronComment;
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

}
