package cronmanagement.webservices;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cronmanagement.bean.DataCenterBean;
import cronmanagement.services.DataCenterDetailsService;
/**
 * 
 * @author neha-zaveri
 *
 */
@Component
@Path("/dataCenterDetails")
public class DataCenterDetailsResource {

	public final static Log LOGGER = LogFactory
			.getLog(DataCenterDetailsResource.class);

	@Autowired
	DataCenterDetailsService dataCenterDetailsService;

	@GET
	@Produces("application/json")
	public List<DataCenterBean> getAllDataCenters() {
        LOGGER.info("Within " + getClass().getName() + " getAllDataCenters method.");
		return dataCenterDetailsService.getAllDataCenters();
	}

	@GET
	@Produces("application/json")
	@Path("/dc/{dcId}")
	public DataCenterBean getDataCenterById(@PathParam("dcId") Integer dcId) {
		LOGGER.info("Within " + getClass().getName()
				+ " getDataCenterById method. DcId :: " + dcId);
		return dataCenterDetailsService.getDataCenterById(dcId);
	}

}
