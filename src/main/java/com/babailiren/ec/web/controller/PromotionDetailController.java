package com.babailiren.ec.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.babailiren.ec.service.PromotionDetailService;

@Controller
public class PromotionDetailController {
	
	@Autowired
	private PromotionDetailService promotionDetailService;

}
