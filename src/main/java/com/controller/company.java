package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.model.companyModel;
import com.model.responseMessage;

import companyDao.companyDetailsDao;

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
}
