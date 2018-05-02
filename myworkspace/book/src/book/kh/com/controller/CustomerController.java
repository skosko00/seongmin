package book.kh.com.controller;

import java.util.ArrayList;

import book.kh.com.model.dao.CustomerDAO;
import book.kh.com.model.vo.Customer;

public class CustomerController {
	
	public CustomerController() {}
	CustomerDAO cd = new CustomerDAO();

	public ArrayList<Customer> allCustomer() {
		ArrayList<Customer> list = cd.allCustomer();
		
		if(list.isEmpty())return null;
		else return list;

	}

	public ArrayList<Customer> searchName(String name) {
		ArrayList<Customer> list = cd.searchName(name);
		
		if(list.isEmpty())return null;
		else return list;
		
	}

	public Customer searchId(String memberId) {
		return cd.searchId(memberId);
		
	}

	public String insertCustomer(Customer c) {
		if(cd.insertCustomer(c)>0)
		{
			return "회원이 추가되었습니다.";
		}
		else
		{
			return "회원 추가에 실패했습니다.";
		}
		
	}

	public String updateCustomer(Customer c) {
		if(cd.updateCustomer(c)>0)
		{
			return "회원 수정이 완료되었습니다.";
		}
		else
		{
			return "회원 수정에 실패했습니다.";
		}
		
	}

	public String deleteCustomer(Customer c) {
		if(cd.deleteCustomer(c)>0)
		{
			return "회원이 삭제되었습니다.";
		}
		else
		{
			return "회원 삭제에 실패했습니다.";
		}
		
	}

}
