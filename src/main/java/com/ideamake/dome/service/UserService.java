package com.ideamake.dome.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideamake.dome.dao.UserDao;
import com.ideamake.dome.model.User;

@Service
public class UserService {
	/**
	 * 这是用户的服务类，用来实现控制类接口的中转站
	 * 
	 * */
	@Autowired
	private UserDao userdao;
	
	public  List<User> findAllUser() {
		return userdao.findAllUser();
	}
	public User findUser(int u_id) {
		return userdao.findUser(u_id);
	}
	public User findUserByName(String username) {
		return userdao.findUserByName(username);
	}
	public int insertUser(User u) {
		return userdao.insertUser(u);
	}
	public int updateUser(User u) {
		return userdao.updateUser(u);
	}
	public int deleteUser(int u_id) {
		return userdao.deleteUser(u_id);
	}
	public int getClientCount(int u_id) {
		return userdao.getClientCount(u_id);
	}
	public List<User>countDesc(){
		return userdao.countDesc();
	}
	public List<User>countDescFreedom(String bdate,String edate){
		return userdao.countDescFreedom(bdate,edate);
	}
}
