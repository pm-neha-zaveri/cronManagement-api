package cronmanagement.bean;

import java.io.Serializable;

public class DataCenterBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private String dcName;
    private String latitude;
    private String longitude;
    private Integer dcHealth;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDcName() {
        return dcName;
    }

    public void setDcName(String dcName) {
        this.dcName = dcName;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public Integer getDcHealth() {
        return dcHealth;
    }

    public void setDcHealth(Integer dcHealth) {
        this.dcHealth = dcHealth;
    }

    @Override
    public String toString() {
        return "DataCenterBean [id=" + id + ", dcName=" + dcName + ", latitude=" + latitude + ", longitude="
                + longitude + ", dcHealth=" + dcHealth + "]";
    }

}
