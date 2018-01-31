package com.itheima.dao;

import org.apache.solr.client.solrj.SolrQuery;

import com.itheima.pojo.PageResult;

public interface ProductDao {
	/**
	 * 需求：实现dao层的查询功能
	 */
	PageResult queryProductsWithSolr(SolrQuery solrQuery);
}

