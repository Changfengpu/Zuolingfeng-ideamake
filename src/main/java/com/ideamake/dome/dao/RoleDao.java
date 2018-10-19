package com.ideamake.dome.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.ideamake.dome.model.Role;

@Mapper
public interface RoleDao {
	/**
	 * 这些是具体的权限服务类的sql语句实现
	 * 
	 * */
	@Select("select * from role where r_id = #{r_id}")
	Role findRole(int r_id);
}
