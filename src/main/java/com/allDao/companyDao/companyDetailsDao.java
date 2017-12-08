package com.allDao.companyDao;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.model.companyModel;

public class companyDetailsDao {
	@Autowired
	SessionFactory sessionFactory ;
	
	public companyModel signup(companyModel compData){
		Session session=null;
		Transaction tx=null;
		try{
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.save(compData);
			tx.commit();
		}catch (HibernateException h) {
			 if(tx != null){
				 tx.rollback();
			 }
		}
		return compData;
	}
	
	public companyModel signIn(companyModel logData) {
		Session session=null;
		 
		try{
			session = sessionFactory.openSession();
			Criteria cr = session.createCriteria(companyModel.class);
			 
			
			
		}catch (HibernateException h){
			
		}
		
		return logData;
		
	}

}

