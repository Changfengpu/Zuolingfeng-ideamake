package com.ideamake.dome.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.ideamake.dome.model.User;

@Mapper
public interface UserDao {
	/**
	 * 这些是具体的用户服务类的sql语句实现
	 * 
	 * */
	@Select("select * from user where u_id=#{u_id}")
	User findUser(int u_id);
	@Select("select * from user")
	List<User> findAllUser();
	@Select("select * from user where username=#{username}")
	User findUserByName(String username);
	@Insert("insert into user (username,password,realname,r_id) values(#{username},#{password},#{realname},#{r_id})")
	int insertUser(User u);
	@Update("update user set username=#{username},password=#{password},realname=#{realname},r_id=#{r_id} where u_id=#{u_id}")
	int updateUser(User u);
	@Delete("delete from user where u_id=#{u_id}")
	int deleteUser(int u_id);
	@Select("select count(*) from client where recorder_id=#{u_id}")
	int getClientCount(int u_id);
	@Select("SELECT  user.u_id, user.realname,COUNT(user.u_id) AS sale_count FROM `user`,`client` WHERE user.u_id = client.recorder_id GROUP BY user.u_id ORDER BY sale_count DESC")
	List<User> countDesc();
	@Select("SELECT  user.u_id, user.realname,COUNT(user.u_id) AS sale_count FROM `user`,`client` WHERE user.u_id = client.recorder_id AND client.record_time BETWEEN #{bdate} AND #{edate} GROUP BY user.u_id ORDER BY sale_count DESC")
	List<User> countDescFreedom(@Param("bdate")String bdate,@Param("edate")String edate);
}
