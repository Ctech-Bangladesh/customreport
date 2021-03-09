package org.openmrs.module.customreport.api.impl.doaImpl;

import org.hibernate.SessionFactory;
import org.openmrs.api.db.hibernate.DbSessionFactory;
import org.openmrs.module.customreport.api.dao.CustomReportDao;
import org.openmrs.module.customreport.model.RegistrationCollection;
import org.openmrs.module.customreport.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CustomReportDaoImpl implements CustomReportDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public String welCome() {
		sessionFactory.getCurrentSession();
		return "Alhamdulillah";
	}
	
	@Override
	public List<Team> getAllTeam() {
		return sessionFactory.getCurrentSession().createCriteria(Team.class).list();
	}
	
	@Override
	@Transactional
	public void saveTeam(Team team) {
		sessionFactory.getCurrentSession().save(team);
	}
	
	@Override
	public List<RegistrationCollection> getAllRegCollection() {
		return sessionFactory.getCurrentSession().createCriteria(RegistrationCollection.class).list();
	}
}
