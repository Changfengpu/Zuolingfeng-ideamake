package com.ideamake.dome.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.security.SecurityUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class LoginController {
	/**
	 * 登录接口  
	 * @param 传入username，password
	 * @return 返回 0表示登录成功，1表示登录失败
	 * 
	 * */
	
	@RequestMapping(value="/logins",method = RequestMethod.POST)
	@ResponseBody
	public int  logins(HttpServletRequest req,HttpSession session) {
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		
		UsernamePasswordToken token=new UsernamePasswordToken(username,password);
		Subject subject=SecurityUtils.getSubject();
		try {
			subject.login(token);
			return 0;
		}catch (Exception e) {
			return 1;
		}
		
	
	}
	
	//整合shiro 用户退出登录
	/**
	 * 注销接口  
	 * @param 
	 * @return 
	 * 
	 * */
		@RequestMapping(value="/logout")
		public void logout(HttpSession session) {
			Subject subject = SecurityUtils.getSubject();
			subject.logout();
		}
}
