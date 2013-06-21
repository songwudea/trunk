package com.babailiren.ec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.babailiren.ec.repository.dao.ReturnPurchaseDao;

@Service
public class ReturnPurchaseService {
	
	@Autowired
	private ReturnPurchaseDao returnPurchaseDao; 
	
	
}
