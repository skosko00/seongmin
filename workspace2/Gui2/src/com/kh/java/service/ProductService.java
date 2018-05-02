package com.kh.java.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.java.dao.ProductDAO;
import com.kh.java.model.template.ProductTemplate;
import com.kh.java.model.vo.Product;

public class ProductService {
	public ProductService() {}

	public ArrayList<Product> fisrtView() {
		Connection conn = ProductTemplate.connection();
		ArrayList<Product> list = new ProductDAO().fisrtView(conn);
		ProductTemplate.close(conn);
		return list;		
	}
	public ArrayList<Product> allChart() {
		Connection conn = ProductTemplate.connection();
		ArrayList<Product> list = new ProductDAO().allChart(conn);
		ProductTemplate.close(conn);
		return list;	
	}

	public int insert(Product p) {
		Connection conn = ProductTemplate.connection();
		int result = new ProductDAO().insert(conn,p);

		if(result>0)
		{
			ProductTemplate.commit(conn);
		}else
		{
			ProductTemplate.rollback(conn);
		}
		ProductTemplate.close(conn);
		return result;
	}

	public int update(Product p, String id) {
		Connection conn = ProductTemplate.connection();
		int result = new ProductDAO().update(conn,p, id);
		if(result>0)
		{
			ProductTemplate.commit(conn);
		}
		else
		{
			ProductTemplate.rollback(conn);
		}
		ProductTemplate.close(conn);
		return result;
	}

	public int delete(Product p) {
		Connection conn = ProductTemplate.connection();
		int result = new ProductDAO().delete(conn,p);
		if(result>0)
		{
			ProductTemplate.commit(conn);
		}
		else
		{
			ProductTemplate.rollback(conn);
		}
		ProductTemplate.close(conn);
		return result;
	}

	public ArrayList<Product> search(String connection, String select) {
		Connection conn = ProductTemplate.connection();
		ArrayList<Product> list = null;
		if(connection=="id")
		{
			list = new ProductDAO().searchId(conn, select);
		}
		else if(connection=="name")
		{
			list = new ProductDAO().searchName(conn, select);
		}
		ProductTemplate.close(conn);
		return list;		
	}


}
