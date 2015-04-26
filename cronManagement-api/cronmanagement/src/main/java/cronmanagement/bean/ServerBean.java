package cronmanagement.bean;

import java.io.Serializable;
/**
 * 
 * @author neha-zaveri
 *
 */
public class ServerBean implements Serializable{

    private static final long serialVersionUID = 1L;
    private Integer id;
    private String serverIP;
    private String description;
    private Integer dcId;
    private String serverHealth;

    public String getServerHealth() {
		return serverHealth;
	}

	public void setServerHealth(String serverHealth) {
		this.serverHealth = serverHealth;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ServerBean [id=" + id + ", serverIP=" + serverIP + ", description=" + description + ", dcId=" + dcId
                + "]";
    }

    public String getServerIP() {
        return serverIP;
    }

    public void setServerIP(String serverIP) {
        this.serverIP = serverIP;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDcId() {
        return dcId;
    }

    public void setDcId(Integer dcId) {
        this.dcId = dcId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((serverIP == null) ? 0 : serverIP.hashCode());
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
        ServerBean other = (ServerBean) obj;
        if (other.serverIP != null && serverIP != null && !serverIP.trim().equals(other.serverIP.trim()))
            return false;
        return true;
    }

}
