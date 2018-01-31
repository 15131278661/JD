package com.itheima.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itheima.dao.ProductDao;
import com.itheima.pojo.PageResult;
import com.itheima.pojo.Product;

@Repository
public class ProductDaoImpl implements ProductDao {
	@Autowired
	private SolrServer solrServer;

	/**
	 * 需求：实现商品查询功能
	 */
	@Override
	public PageResult queryProductsWithSolr(SolrQuery solrQuery) {
		// 创建分页查询包装类
		PageResult pageResult = new PageResult();
		// 创建商品列表集合对象,封装从索引库中查询商品集合数据
		List<Product> pList = new ArrayList<Product>();
		try {
			// 根据solrServer封装查询条件;
			QueryResponse response = solrServer.query(solrQuery);
			// 获取文档集合
			SolrDocumentList solrDocumentList = response.getResults();
			// 获取文档总记录数
			Long numFound = solrDocumentList.getNumFound();
			// 将文档总记录数封装到pageRequest中
			pageResult.setRecordCount(numFound);
			// 循环文档集合,获取每一个文档
			for (SolrDocument solrDocument : solrDocumentList) {
				// 创建商品对象
				Product product = new Product();
				// 获取文档id
				String id = (String) solrDocument.get("id");
				product.setPid(id);
				// 获取商品名称
				String product_name = (String) solrDocument.get("product_name");
				// 获取高亮
				Map<String, Map<String, List<String>>> highlighting = response.getHighlighting();
				// 根据文档id获取高亮map
				Map<String, List<String>> map = highlighting.get(id);
				// 根据高亮字段获取高亮集合
				List<String> list = map.get("product_name");
				// 只给标题设置高亮,高亮数组中只有一个高亮
				if (list != null && list.size() > 0) {
					product_name = list.get(0);
				}
				// 设置标题
				product.setName(product_name);
				// 获取商品价格
				Float product_price = (Float) solrDocument.get("product_price");
				product.setPrice(product_price);

				// 获取商品图片地址
				String product_picture = (String) solrDocument.get("product_picture");
				product.setPicture(product_picture);

				// 把从索引库中查询出商品数据封装集合
				pList.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageResult;
	}

}
