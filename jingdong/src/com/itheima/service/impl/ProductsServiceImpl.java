package com.itheima.service.impl;

import org.apache.solr.client.solrj.SolrQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itheima.dao.ProductDao;
import com.itheima.pojo.PageResult;
import com.itheima.service.ProductsService;
@Service
public class ProductsServiceImpl implements ProductsService {
	@Autowired
	private ProductDao productDao;
	/**
	 * 需求:接受前台参数,调用dao查询索引库
	 * 功能:参数封装,页码计算
	 * 参数:String queryString,String catalog_name,String price,Integer page,Integer rows,String sort
	 * 返回值:PageResult
	 */
	
	@Override
	public PageResult queryProductsWithSolrIndex(String queryString, String catalog_name, String price, Integer page,
			Integer rows, String sort) {
		// 创建solrQuery对象,封装所有参数
		SolrQuery solrQuery = new SolrQuery();
		return null;
	}

}
