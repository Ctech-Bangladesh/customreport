package org.openmrs.module.customreport.api.impl.serviceImpl;

import org.openmrs.module.customreport.api.dao.CustomReportDao;
import org.openmrs.module.customreport.api.service.CustomReportService;
import org.openmrs.module.customreport.model.RegistrationCollection;
import org.openmrs.module.customreport.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomReportServiceImpl implements CustomReportService {
	
	@Autowired
	private CustomReportDao customReportDao;
	
	@Override
	public String welCome() {
		return customReportDao.welCome();
	}
	
	@Override
	public List<Team> getAllTeam() {
		return customReportDao.getAllTeam();
	}
	
	@Override
	@Transactional
	public void saveTeam(Team team) {
		customReportDao.saveTeam(team);
	}
	
	@Override
	public List<RegistrationCollection> getAllRegCollection() {
		return customReportDao.getAllRegCollection();
	}
}
