package com.ideamake.dome.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideamake.dome.dao.RoleDao;
import com.ideamake.dome.model.Role;

@Service
public class RoleService {
	/**
	 * 这是权限的服务类，用来实现控制类接口的中转站
	 * 
	 * */
	@Autowired
	private RoleDao roledao;
	
	public Role findRole(int r_id) {
		return roledao.findRole(r_id);
	}
}
