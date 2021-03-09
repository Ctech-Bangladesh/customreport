package org.openmrs.module.customreport.api.service;

import org.openmrs.module.customreport.model.RegistrationCollection;
import org.openmrs.module.customreport.model.Team;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CustomReportService {
	
	public String welCome();
	
	public List<Team> getAllTeam();
	
	public void saveTeam(Team team);
	
	public List<RegistrationCollection> getAllRegCollection();
}
