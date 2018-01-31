package com.itheima.service;

import com.itheima.pojo.PageResult;

public interface ProductsService {
	
	/**
	 * 需求:接受前台参数,调用dao查询索引库
	 * 功能:参数封装,页码计算
	 * 参数:String queryString,String catalog_name,String price,Integer page,Integer rows,String sort
	 * 返回值:PageResult
	 */
	public PageResult queryProductsWithSolrIndex(String queryString,String catalog_name,String price,Integer page,Integer rows,String sort);

}
