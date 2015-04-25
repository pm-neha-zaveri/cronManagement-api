package cronmanagement.services.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cronmanagement.bean.CronAlert;
import cronmanagement.bean.CronJob;
import cronmanagement.bean.ServerBean;
import cronmanagement.dao.CronAlertDetailsDAO;
import cronmanagement.services.CronAlertDetailsService;
import cronmanagement.services.CronJobDetailsService;
import cronmanagement.services.ServerDetailsService;

@Service
public class CronAlertDetailsServiceImpl implements CronAlertDetailsService {

	public final static Log LOGGER = LogFactory
			.getLog(CronAlertDetailsServiceImpl.class);

	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
	SimpleDateFormat sql_formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

	@Autowired
	CronAlertDetailsDAO cronAlertDetailsDAO;

	@Autowired
	ServerDetailsService serverDetailsService;

	@Autowired
	CronJobDetailsService cronJobDetailsService;

	@Override
	public List<CronAlert> getAllCronAlert() {
		LOGGER.info("Within " + getClass().getName()
				+ " getAllCronAlert method.");
		return cronAlertDetailsDAO.getAllCronAlert();
	}

	@Override
	public List<CronAlert> getAllCronAlertByServerId(Integer serverId) {
		LOGGER.info("Within " + getClass().getName()
				+ " getAllCronAlertByServerId method.");
		return cronAlertDetailsDAO.getAllCronAlertByServerId(serverId);
	}

	@Override
	public List<CronAlert> getAllCronAlertByDCId(Integer dcId) {
		LOGGER.info("Within " + getClass().getName()
				+ " getAllCronAlertByDCId method.");
		return cronAlertDetailsDAO.getAllCronAlertByDCId(dcId);
	}

	@Override
	public List<CronAlert> getAllCronAlertByCronId(Integer cronId) {
		LOGGER.info("Within " + getClass().getName()
				+ " getAllCronAlertByCronId method.");
		return cronAlertDetailsDAO.getAllCronAlertByCronId(cronId);
	}

	@Override
	public void saveCronAlert(CronAlert cronAlert) {
		LOGGER.info("Within " + getClass().getName() + " saveCronAlert method.");
		cronAlertDetailsDAO.saveCronAlert(cronAlert);
	}

	@Override
	public void saveCronAlertDataToDB(CronAlert cronAlert)
			throws ParseException {
		LOGGER.info("Within " + getClass().getName()
				+ " saveCronAlertDataToDB method.");
		Boolean isValidData = false;
		ServerBean serverBean = serverDetailsService
				.getServerDetailByIp(cronAlert.getServerIP() == null ? ""
						: cronAlert.getServerIP().trim());
		if (serverBean != null && cronAlert.getCronName() != null
				&& cronAlert.getCronName().trim().length() > 0) {
			List<CronJob> cronJobList = cronJobDetailsService
					.getCronJobByServerIdAndCronName(serverBean.getId(),
							new String("%" + cronAlert.getCronName() + "%"));
			CronJob cronJob = (cronJobList != null && cronJobList.size() > 0 ? cronJobList
					.get(0) : null);
			cronAlert.setServerId(serverBean.getId());
			cronAlert.setDcId(serverBean.getDcId());
			if (cronJob != null) {
				cronAlert.setCronId(cronJob.getCronId());
				if (cronAlert.getStartTime() != null
						&& cronAlert.getStartTime().trim().length() > 0)
					cronAlert
							.setStartTime(sql_formatter.format(formatter
									.parse(cronAlert.getStartTime().replace(
											'_', ' '))));
				if (cronAlert.getEndTime() != null
						&& cronAlert.getEndTime().trim().length() > 0)
					cronAlert.setEndTime(sql_formatter.format(formatter
							.parse(cronAlert.getEndTime().replace('_', ' '))));
				if (cronAlert.getRunTime() != null
						&& cronAlert.getRunTime() > 0)
					cronAlert.setRunTime(cronAlert.getRunTime() * 1000);
				if (cronAlert.getThreshold() != null
						&& cronAlert.getThreshold() > 0)
					cronAlert.setRunTime(cronAlert.getThreshold() * 1000);
				cronAlert.setAlertDescription("Unexpected Behaviour Observed");
				isValidData = true;
			}

		}
		LOGGER.info("cronAlert : " + cronAlert + " isValidData : "
				+ isValidData);
		if (isValidData)
			saveCronAlert(cronAlert);
		else
			LOGGER.info("Invalid Data");
	}

}
