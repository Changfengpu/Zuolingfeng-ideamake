package com.ideamake.dome.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ideamake.dome.model.Role;
import com.ideamake.dome.service.RoleService;

@Controller
public class RoleController {
	//自动注入 角色服务
	@Autowired
	private RoleService r;
	
	/**
	 * 找查权限接口  
	 * @param 传入用户的权限编号
	 * @return 返回 一个角色role对象
	 * 
	 * */
	@RequestMapping(value="/findRole")
	@ResponseBody
	public Role findRoleController(int r_id) {
		return r.findRole(r_id);
	}
	
	
}
