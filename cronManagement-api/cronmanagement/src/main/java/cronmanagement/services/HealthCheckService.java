package cronmanagement.services;

public interface HealthCheckService {

    /**
     * Method will return true if health of server and data center are successfully updated to database.
     * @return {@link Boolean}
     */
    Boolean calculateHealth();
}
