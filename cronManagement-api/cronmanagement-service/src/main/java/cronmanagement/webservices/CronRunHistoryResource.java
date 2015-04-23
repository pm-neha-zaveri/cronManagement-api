package cronmanagement.webservices;

import java.util.List;

import javax.annotation.Resource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;

import cronmanagement.bean.CronRunHistory;
import cronmanagement.services.CronRunHistoryService;

@Resource
@Path("/cronRunHistory")
public class CronRunHistoryResource {
	@Autowired
	CronRunHistoryService cronRunHistoryService;

	@GET
	@Produces("application/json")
	public List<CronRunHistory> getCronRunHistory() {
		return cronRunHistoryService.getCronRunHistory();
	}

}
