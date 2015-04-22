package cronmanagement.services.impl;


import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.context.MessageSource;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import com.pubmatic.apiutils.bean.PageSupporter;
import com.pubmatic.apiutils.bean.RequestDetails;
import com.pubmatic.apiutils.bean.PageSupporter;
import com.pubmatic.apiutils.exception.DataValidationException;
import com.pubmatic.apiutils.exception.ServiceException;
import cronmanagement.bean.CronManagement;
import cronmanagement.services.CronDetailsService;


@Service
public class CronDetailsServiceImpl implements CronDetailsService{

    public final static Log LOGGER = LogFactory.getLog(CronDetailsServiceImpl.class);

    @Resource
    MessageSource  cronmanagementMessageSource;   
    
    @Override
    public CronManagement get(Long userId, Long idToGet) throws ServiceException, DataValidationException {
        // TODO Auto-generated method stub	
	CronManagement changeObjectName = new CronManagement();
        changeObjectName.setName("Demo API");
        changeObjectName.setId(1L);

        return changeObjectName;
    }

    @Override
    public PageSupporter<CronManagement> search(Long userId, RequestDetails requestDetails) throws ServiceException,
            DataValidationException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CronManagement create(Long userId, CronManagement entityToCreate) throws ServiceException, DataValidationException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CronManagement update(Long userId, CronManagement entityToUpdate) throws ServiceException, DataValidationException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Boolean delete(Long userId, Long entityIdToDel) throws ServiceException, DataValidationException {
        // TODO Auto-generated method stub
        return null;
    } 
}
