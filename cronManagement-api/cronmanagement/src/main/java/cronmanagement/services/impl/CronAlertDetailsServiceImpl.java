package cronmanagement.services.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cronmanagement.bean.CronAlert;
import cronmanagement.bean.CronAlertRequestBean;
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
		return cronAlertDetailsDAO.getAllCronAlert();
	}

	@Override
	public List<CronAlert> getAllCronAlertByServerId(Integer serverId) {
		return cronAlertDetailsDAO.getAllCronAlertByServerId(serverId);
	}

	@Override
	public List<CronAlert> getAllCronAlertByDCId(Integer dcId) {
		return cronAlertDetailsDAO.getAllCronAlertByDCId(dcId);
	}

	@Override
	public List<CronAlert> getAllCronAlertByCronId(Integer cronId) {
		return cronAlertDetailsDAO.getAllCronAlertByCronId(cronId);
	}

	@Override
	public void saveCronAlert(CronAlert cronAlert) {
		cronAlertDetailsDAO.saveCronAlert(cronAlert);
	}

	@Override
	public void saveCronAlertDataToDB(CronAlertRequestBean cronAlertRequestBean)
			throws ParseException {

		CronAlert cronAlert = new CronAlert();
		Boolean isValidData = false;
		ServerBean serverBean = serverDetailsService
				.getServerDetailByIp(cronAlertRequestBean.getCronServerIP() == null ? ""
						: cronAlertRequestBean.getCronServerIP().trim());
		if (serverBean != null && cronAlertRequestBean.getCronName() != null
				&& cronAlertRequestBean.getCronName().trim().length() > 0) {
			List<CronJob> cronJobList = cronJobDetailsService
					.getCronJobByServerIdAndCronName(serverBean.getId(),
							new String("%" + cronAlertRequestBean.getCronName()
									+ "%"));
			CronJob cronJob = (cronJobList != null && cronJobList.size() > 0 ? cronJobList
					.get(0) : null);
			cronAlert.setServerId(serverBean.getId());
			cronAlert.setDcId(serverBean.getDcId());
			if (cronJob != null) {
				cronAlert.setCronId(cronJob.getCronId());
				if (cronAlertRequestBean.getCronStartTime() != null
						&& cronAlertRequestBean.getCronStartTime().trim()
								.length() > 0)
					cronAlert.setStartTime(sql_formatter.format(formatter
							.parse(cronAlertRequestBean.getCronStartTime()
									.replace('_', ' '))));
				if (cronAlertRequestBean.getCronEndTime() != null
						&& cronAlertRequestBean.getCronEndTime().trim()
								.length() > 0)
					cronAlert.setEndTime(sql_formatter.format(formatter
							.parse(cronAlertRequestBean.getCronEndTime()
									.replace('_', ' '))));
				if (cronAlertRequestBean.getActualRunTimeSec() != null
						&& cronAlertRequestBean.getActualRunTimeSec().trim()
								.length() > 0)
					cronAlert.setRunTime(Integer.parseInt(cronAlertRequestBean
							.getActualRunTimeSec()) * 1000);
				if (cronAlertRequestBean.getActualRunTimeSec() != null
						&& cronAlertRequestBean.getActualRunTimeSec().trim()
								.length() > 0)
					cronAlert.setRunTime(Integer.parseInt(cronAlertRequestBean
							.getActualRunTimeSec()));
				if (cronAlertRequestBean.getThreshhold() != null
						&& cronAlertRequestBean.getThreshhold().trim().length() > 0)
					cronAlert.setThreshold(Integer
							.parseInt(cronAlertRequestBean.getThreshhold()));
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
