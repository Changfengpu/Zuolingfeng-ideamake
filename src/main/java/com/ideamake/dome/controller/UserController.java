package com.ideamake.dome.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ideamake.dome.model.User;
import com.ideamake.dome.service.UserService;

@Controller
public class UserController {
	//自动注入 用户服务
	@Autowired
	private UserService userservice;
	
	/**
	 * 找查所有用户接口  
	 * @param 
	 * @return 返回 一个用户对象的List
	 * 
	 * */
	@RequestMapping(value="/findAllUser")
	@ResponseBody
	public List<User> findAllUserController(){
		return userservice.findAllUser();
	}
	
	/**
	 * 找查单个用户接口  
	 * @param 传入用户编号
	 * @return 返回 一个用户对象
	 * 
	 * */
	@RequestMapping(value="/findUser")
	@ResponseBody
	public User findUserController(int u_id){
		return userservice.findUser(u_id);
	}
	
	/**
	 * 添加用户接口  
	 * @param 传入一个用户对象 User
	 * @return 返回 1表示成功
	 * 
	 * */
	@RequestMapping(value="/inserUser")
	@ResponseBody
	public int insertUserController(User u){
		return userservice.insertUser(u);
	}
	
	/**
	 * 修改用户接口  
	 * @param 传入一个用户对象 User
	 * @return 返回 1表示成功
	 * 
	 * */
	@RequestMapping(value="/updateUser")
	@ResponseBody
	public int updateUserController(User u){
		return userservice.updateUser(u);
	}
	
	/**
	 * 删除用户接口  
	 * @param 传入一个用户编号
	 * @return 返回 1表示成功
	 * 
	 * */
	@RequestMapping(value="/deleteUser")
	@ResponseBody
	public int deleteUserController(int u_id){
		return userservice.deleteUser(u_id);
	}
	
	/**
	 * 销售额排序接口  
	 * @param 
	 * @return 返回 一个已经按总销售额排好序的用户对象List集合
	 * 
	 * */
	@RequestMapping(value="/countDesc")
	@ResponseBody
	public List<User> countDescController(){
		return userservice.countDesc();
	}
	
	/**
	 * 销售额按指定日期范围排序接口  
	 * @param 传入一个起始日期bdate，一个结束日期edate
	 * @return 返回 一个按所给日期范围排好序的用户对象List集合
	 * 
	 * */
	@RequestMapping(value="/countDescFreedom")
	@ResponseBody
	public List<User> countDescFreedomController(String bdate,String edate){
	System.out.println(bdate+edate);
		return userservice.countDescFreedom(bdate,edate);
	}
}
