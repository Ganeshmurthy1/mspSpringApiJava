package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.cfg.beanvalidation.ActivationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.allDao.companyDao.companyDetailsDao;
import com.model.companyModel;
import com.model.responseMessage;

 
 

@RestController
@RequestMapping(value="/compReg")
public class company {
	@Autowired companyDetailsDao compDao;	
	@RequestMapping(value="/register", method = RequestMethod.POST, headers={"Accept=application/json"})
	public responseMessage addCompany(@RequestBody companyModel compData){
		 
		companyModel compregister = compDao.signup(compData);
		 
		responseMessage res = new responseMessage();
		String message = "";
		if(compregister != null && compregister.getId()>0){
			System.out.println("company Registered------");
			message="Successfully Inserted";
			res.setMessage(message);
		}else{
			System.out.println("Name ---Not --Inserted--");
			message="Failed Inserted";
			res.setMessage(message); 
		}
		
		return res;
		
	}
	@RequestMapping(value="/login", method = RequestMethod.POST, headers={"Accept=application/json"})
	public responseMessage companyLogin(@RequestBody companyModel compData, HttpServletRequest req){
		companyModel compLogin = compDao.signIn(compData);
		responseMessage res = new responseMessage();
		String message = "";
		 
		HttpSession session = req.getSession();
		if(compLogin != null){
		 message="Successfully Logged";			 
			res.setMessage(message);
			res.setData(compLogin);
			res.setStatus(200);
		}else{
			 message="Please check the credentials";	
			res.setMessage(message);
			res.setData(null);
			res.setStatus(500);
		}
		
		 
		 
		return res;
		
	}
}
