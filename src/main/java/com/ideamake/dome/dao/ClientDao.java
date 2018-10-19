package com.ideamake.dome.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ideamake.dome.model.Client;
@Mapper
public interface ClientDao {
	/**
	 * 这些是具体的客户服务类的sql语句实现
	 * 
	 * */
	 @Insert("insert into client (c_name,c_sex,c_phone,recorder_id,record_time) values (#{c_name},#{c_sex},#{c_phone},#{recorder_id},#{record_time})")
	 int insertClient(Client c);
	 @Delete("delete from client where c_id=#{c_id}")
	 int deleteClient(int c_id);
	 @Update("update client set c_name=#{c_name},c_sex=#{c_sex},c_phone=#{c_phone},recorder_id=#{recorder_id},record_time=#{record_time} where c_id=#{c_id}")
	 int updateClient(Client c);
	 @Select("select * from client")
	 List<Client> findAllClient();
	 @Select("select * from client where c_id=#{c_id}")
	 Client findClient(Client c);
	 
}

