package com.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.LocationDao;
import com.helper.PosLog;
import com.model.Location;

@Repository
@Transactional
public class LocationDaoImpl implements LocationDao {
	@Autowired
	SessionFactory session;

	@SuppressWarnings("unchecked")
	@Override
	public List<Location> getListOfLocation() {
		Session currentSession = session.openSession();
		List<Location> listOfLocation = null;
		try {
			listOfLocation = currentSession.createQuery("from Location").list();
		} catch (Exception e) {
			PosLog.error(e.getMessage());
			return null;
		} finally {
			closeSession(currentSession);
		}
		return listOfLocation;
	}

	@Override
	public boolean save(Location location) throws Exception {
		Session currentSession = session.openSession();
		Transaction transaction = currentSession.beginTransaction();
		try {
			currentSession.save(location);
			transaction.commit();
		} catch (Exception e) {
			PosLog.error(e.getMessage());
			return false;
		} finally {
			closeSession(currentSession);
		}
		return true;

	}

	public void closeSession(Session session) {
		if (session != null) {
			session.close();
		}
	}
}
