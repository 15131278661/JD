package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product/")
public class ProductController {
	/**
	 * 
	 * 需求：实现页面跳转
	 * @return
	 */
	@RequestMapping("/list")
	public String list(){
		return "product_list";
	}
	
}
