package cronmanagement.webservices;

import java.util.List;

import javax.annotation.Resource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;

import cronmanagement.bean.CronJob;
import cronmanagement.services.CronDetailsService;

@Resource
@Path("/cronDetails")
public class CronDetailsResource {

	@Autowired 
	CronDetailsService cronDetailsService;
	
	@GET
	@Produces("application/json")
	public List<CronJob> getCronList()
	{
		return cronDetailsService.getCronDetails();
	}
	
	
}
