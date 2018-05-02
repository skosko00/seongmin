package book.kh.com.controller;

import java.util.ArrayList;

import book.kh.com.model.service.CustomerService;
import book.kh.com.model.vo.Customer;

public class CustomerController {
	
	public CustomerController() {}
	private CustomerService cs = new CustomerService();

	public ArrayList<Customer> allCustomer() {
		ArrayList<Customer> list = cs.allCustomer();
		
		if(list.isEmpty())return null;
		else return list;

	}

	public ArrayList<Customer> searchName(String name) {
		ArrayList<Customer> list = cs.searchName(name);
		
		if(list.isEmpty())return null;
		else return list;
		
	}

	public Customer searchId(String memberId) {
		return cs.searchId(memberId);
		
	}

	public String insertCustomer(Customer c) {
		if(cs.insertCustomer(c)>0)
		{
			return "회원이 추가되었습니다.";
		}
		else
		{
			return "회원 추가에 실패했습니다.";
		}
		
	}

	public String updateCustomer(Customer c) {
		if(cs.updateCustomer(c)>0)
		{
			return "회원 수정이 완료되었습니다.";
		}
		else
		{
			return "회원 수정에 실패했습니다.";
		}
		
	}

	public String deleteCustomer(Customer c) {
		if(cs.deleteCustomer(c)>0)
		{
			return "회원이 삭제되었습니다.";
		}
		else
		{
			return "회원 삭제에 실패했습니다.";
		}
		
	}

}
