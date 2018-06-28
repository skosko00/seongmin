package org.kh.users.model.service;

import java.util.ArrayList;

import org.kh.users.model.vo.Users;

public interface UserService {
	public int insertUser(Users users);
	public Users idCheck(String userId);
	public Users oneUserSelect(Users users);
	public ArrayList<Users> allUser();
	public int deleteUser(Users users);
	public int updateUser(Users users);
}
