package cronmanagement.services.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import cronmanagement.bean.CronDetails;
import cronmanagement.dao.CronDetailsDAO;
import cronmanagement.services.CronDetailsService;

@Service
public class CronDetailsServiceImpl implements CronDetailsService {

	public final static Log LOGGER = LogFactory
			.getLog(CronDetailsServiceImpl.class);

	@Resource
	MessageSource cronmanagementMessageSource;

	@Autowired
	CronDetailsDAO cronDetailsDAO;

	@Override
	public List<CronDetails> getCronDetails() {
		return cronDetailsDAO.getCronDetails();

	}
}
