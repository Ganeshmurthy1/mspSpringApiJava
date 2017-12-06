package com.stockReportDao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.model.stockData;

public class stockDao {
	@Autowired
	SessionFactory  sessionFactory;
	public stockData insert(stockData stkData) {
		Session session=null;
		Transaction tx=null;
		try{
			session=sessionFactory.openSession();
			tx=	session.beginTransaction();
			session.save(stkData);
			tx.commit();
		}catch(HibernateException h){
			if(tx!=null){
				tx.rollback();
			}
			
		}
		return stkData;
		 
	}

	
	public List<stockData> selectAll(){
		Session session=null;
		stockData stockData = null; 
		List<stockData> totalStockModals=null;
		try{
			session=sessionFactory.openSession();
			Criteria cr=session.createCriteria(stockData.class);
			totalStockModals=cr.list();
		}catch(HibernateException h){
		h.printStackTrace();
		}
	 return totalStockModals;
		
	}
}
