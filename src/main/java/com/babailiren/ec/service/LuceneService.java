package com.babailiren.ec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.babailiren.ec.repository.dao.ItemDao;

@Service
public class LuceneService {
	@Autowired
	private ItemDao itemDao;
	
	
	
}
