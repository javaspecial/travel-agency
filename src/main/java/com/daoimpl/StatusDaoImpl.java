package com.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.StatusDao;
import com.helper.PosLog;
import com.model.Status;

@Repository
@Transactional
public class StatusDaoImpl implements StatusDao {
	@Autowired
	SessionFactory session;

	@SuppressWarnings("unchecked")
	@Override
	public List<Status> list() {
		Session currentSession = session.openSession();
		try {
			Criteria criteria = currentSession.createCriteria(Status.class);
			return criteria.list();
		} catch (Exception e) {
			PosLog.error(e.getMessage());
			return null;
		} finally {
			closeSession(currentSession);
		}
	}

	@Override
	public boolean delete(Status status) {
		Session currentSession = session.getCurrentSession();
		Transaction transaction = currentSession.beginTransaction();
		try {
			currentSession.delete(status);
			transaction.commit();
		} catch (Exception e) {
			PosLog.error(e.getMessage());
			return false;
		}
		return true;

	}

	@Override
	public boolean update(Status status) {
		Session currentSession = session.getCurrentSession();
		Transaction transaction = currentSession.beginTransaction();
		try {
			currentSession.update(status);
			transaction.commit();
		} catch (Exception e) {
			PosLog.error(e.getMessage());
			return false;
		}
		return true;

	}

	@Override
	public boolean save(Status status) throws Exception {
		Session currentSession = session.getCurrentSession();
		Transaction transaction = currentSession.beginTransaction();
		try {
			currentSession.save(status);
			transaction.commit();
		} catch (Exception e) {
			PosLog.error(e.getMessage());
			return false;
		}
		return true;

	}

	public void closeSession(Session session) {
		if (session != null) {
			session.close();
		}
	}

}
