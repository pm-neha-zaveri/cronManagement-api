package cronmanagement.bean;

import java.io.Serializable;
/**
 * 
 * @author raghunandanG
 *
 */
public class HealthCheck implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long total;
    private Integer cronId;
    private Integer serverId;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
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
        return "HealthParam [total=" + total + ", cronId=" + cronId + ", serverId=" + serverId + "]\n";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
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
        HealthCheck other = (HealthCheck) obj;
        if (serverId == null) {
            if (other.serverId != null)
                return false;
        } else if (!serverId.equals(other.serverId))
            return false;
        return true;
    }

}
