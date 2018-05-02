package com.kh.java.controller;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.kh.java.model.vo.Product;
import com.kh.java.service.ProductService;

public class ProductController {
	public ProductController() {}

	public ArrayList<Product> fisrtView() {
		ArrayList<Product> list = new ProductService().fisrtView();
		if(list.isEmpty()) {
			return null;
		}else
		{
			return list;
		}
	}

	public ArrayList<Product> allChart() {
		ArrayList<Product> list = new ProductService().allChart();
		if(list.isEmpty()) {
			return null;
		}else
		{
			return list;
		}
	}

	public int insert(Product p) {
		int result = new ProductService().insert(p);
		return result;
	}

	public int update(Product p, String id) {
		int result = new ProductService().update(p, id);
		if(result>0)
		{
			JOptionPane.showMessageDialog(null, "수정되었습니다.");
		}
		else
		{
			JOptionPane.showMessageDialog(null, "수정에 실패했습니다.");
		}
		return result;
	}

	public int delete(Product p) {
		int result = new ProductService().delete(p);
		return result;
	}

	public ArrayList<Product> search(String connection, String select) {
		ArrayList<Product> list = new ProductService().search(connection,select);
		if(list.isEmpty()) {
			return null;
		}else
		{
			return list;
		}
	}

}
