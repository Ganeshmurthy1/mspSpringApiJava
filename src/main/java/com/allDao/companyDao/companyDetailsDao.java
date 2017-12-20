package com.allDao.companyDao;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Restrictions;
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
		companyModel returnData= null;
		try{
			session = sessionFactory.openSession();
			Criteria cr = session.createCriteria(companyModel.class);
			Conjunction conjuct = Restrictions.conjunction();
			
			conjuct.add(Restrictions.eq("mailID", logData.getMailID()));
			conjuct.add(Restrictions.eq("password", logData.getPassword()));
			cr.add(conjuct);
			logData = (companyModel) cr.uniqueResult();
			System.out.println("logData"+logData);
		/*	if(logData !=null && logData.getId()>0){
				returnData = logData;
			}else{
				returnData = null;
			}*/
			
		}catch (HibernateException h){
			
		}
		
		return logData;
		
	}

}

