package cronmanagement.dao;

import java.util.List;
import cronmanagement.bean.CronManagement;


public interface CronDetailsDAO {

    List<CronManagement> getCronManagement();        
}
