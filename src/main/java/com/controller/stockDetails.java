package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.allDao.stockReportDao.stockDao;
import com.model.responseMessage;
import com.model.stockData;
 

@RestController
@RequestMapping(value= "/stock")
public class stockDetails {
	@Autowired stockDao stkDao;
	@RequestMapping(value="/add", method = RequestMethod.POST, headers = {"Accept=application/json"})
	public responseMessage addStock(@RequestBody stockData stkData){
		stockData stdData = stkDao.insert(stkData);
		responseMessage res = new responseMessage();
		String message="";
		if(stdData != null && stdData.getId()>0){
			System.out.println("Name -----Inserted--");
			message="Successfully Inserted";
			res.setMessage(message); 
		}else{
			System.out.println("Name ---Not --Inserted--");
			message="Failed Inserted";
			res.setMessage(message); 
		}
		
		return res;
	}
	
	
	@RequestMapping(value="/getProductList", method = RequestMethod.GET,headers = {"Accept=application/json"})
	public List<stockData> getProductList(){
		List<stockData> stockModals =stkDao.selectAll();
		return stockModals;
		
	}
	
}
