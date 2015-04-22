package cronmanagement.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import cronmanagement.bean.CronDetails;

@Service
public interface CronDetailsDAO {

	public List<CronDetails> getCronDetails();
}
