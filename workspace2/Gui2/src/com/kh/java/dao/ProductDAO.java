package com.kh.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.java.model.template.ProductTemplate;
import com.kh.java.model.vo.Product;

public class ProductDAO {
	public ProductDAO() {}

	public ArrayList<Product> fisrtView(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Product> list = new ArrayList<Product>();
		Product p = null;
		
		String query = "select * from product";
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			while(rset.next())
			{
				p = new Product();
				p.setProductId(rset.getString("product_id"));
				p.setPName(rset.getString("p_name"));
				p.setPrice(rset.getInt("price"));
				p.setDescription(rset.getString("description"));
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ProductTemplate.close(rset);
			ProductTemplate.close(pstmt);
		}
		return list;
	}
	
	public ArrayList<Product> allChart(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Product> list = new ArrayList<Product>();
		Product p = null;
		
		String query = "select * from product";
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			while(rset.next())
			{
				p = new Product();
				p.setProductId(rset.getString("product_id"));
				p.setPName(rset.getString("p_name"));
				p.setPrice(rset.getInt("price"));
				p.setDescription(rset.getString("description"));
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ProductTemplate.close(rset);
			ProductTemplate.close(pstmt);
		}
		return list;
	}

	public int insert(Connection conn, Product p) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "insert into product values(?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, p.getProductId());
			pstmt.setString(2, p.getPName());
			pstmt.setInt(3, p.getPrice());
			pstmt.setString(4, p.getDescription());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ProductTemplate.close(pstmt);
		}
		return result;
	}

	public int update(Connection conn, Product p, String id) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "update product set product_id=?,p_name=?,price=?,description=? where product_id=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, p.getProductId());
			pstmt.setString(2, p.getPName());
			pstmt.setInt(3, p.getPrice());
			pstmt.setString(4, p.getDescription());
			pstmt.setString(5, id);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ProductTemplate.close(pstmt);
		}
		return result;
	}

	public int delete(Connection conn, Product p) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "delete product where product_id=? and p_name=? and price=? and description=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, p.getProductId());
			pstmt.setString(2, p.getPName());
			pstmt.setInt(3, p.getPrice());
			pstmt.setString(4, p.getDescription());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ProductTemplate.close(pstmt);
		}
		return result;
	}

	public ArrayList<Product> searchId(Connection conn, String select) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Product> list = new ArrayList<Product>();
		Product p = null;
		
		String query="select * from product where product_id like ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+select+"%");
			rset = pstmt.executeQuery();
			while(rset.next())
			{
				p = new Product();
				p.setProductId(rset.getString("product_id"));
				p.setPName(rset.getString("p_name"));
				p.setPrice(rset.getInt("price"));
				p.setDescription(rset.getString("description"));
				list.add(p);
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ProductTemplate.close(rset);
			ProductTemplate.close(pstmt);
		}
		return list;
	}
	public ArrayList<Product> searchName(Connection conn, String select) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Product> list = new ArrayList<Product>();
		Product p = null;
		
		String query="select * from product where p_name like ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+select+"%");
			rset = pstmt.executeQuery();
			while(rset.next())
			{
				p = new Product();
				p.setProductId(rset.getString("product_id"));
				p.setPName(rset.getString("p_name"));
				p.setPrice(rset.getInt("price"));
				p.setDescription(rset.getString("description"));
				list.add(p);
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ProductTemplate.close(rset);
			ProductTemplate.close(pstmt);
		}
		return list;
	}
}
