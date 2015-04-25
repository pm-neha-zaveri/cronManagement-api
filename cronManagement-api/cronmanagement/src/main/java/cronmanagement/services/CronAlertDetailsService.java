package cronmanagement.services;

import java.text.ParseException;
import java.util.List;

import cronmanagement.bean.CronAlert;

public interface CronAlertDetailsService {

	List<CronAlert> getAllCronAlert();

	List<CronAlert> getAllCronAlertByServerId(Integer serverId);

	List<CronAlert> getAllCronAlertByDCId(Integer dcId);

	List<CronAlert> getAllCronAlertByCronId(Integer cronId);

	void saveCronAlert(CronAlert cronAlert);

	void saveCronAlertDataToDB(CronAlert cronAlert) throws ParseException;

}
