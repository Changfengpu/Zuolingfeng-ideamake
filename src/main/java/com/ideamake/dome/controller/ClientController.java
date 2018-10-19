package com.ideamake.dome.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ideamake.dome.model.Client;
import com.ideamake.dome.service.ClientService;


@Controller
public class ClientController {
	@Autowired 
	/** clientservice 是客户服务层 */
	private ClientService clientservice;
	
	/**
	 * 这个方法是用来增加客户信息
	 * @param 传入一个客户Client对象
	 * @return 返回1代表成功
	 */
	@RequestMapping("insertClient")
	@ResponseBody
    public int insertClientController(Client c) {
		return clientservice.insertClientService(c);
	}
	

	/**
	 * 这个方法是用来删除客户信息
	 * @param 传入一个客户编号id
	 * @return 返回1代表成功
	 */
	@RequestMapping("/deleteClient")
	@ResponseBody
    public int deleteClientController(int c_id) {
	
		return clientservice.deleteClientService(c_id);
	}
	
	/**
	 * 这个方法是用来更新客户信息
	 * @param 传入一个客户Client 对象
	 * @return 返回1代表成功
	 */
	@RequestMapping("/updatetClient")
	@ResponseBody
    public int updateClientController(Client c) {
		return clientservice.updateClientService(c);
	}
	
	/**
	 * 这个方法是用来找查所有客户信息
	 * @param 
	 * @return 返回客户的一个List集合
	 */
	@RequestMapping("/findAllClient")
	@ResponseBody
    public List<Client> findAllClientController() {
		return clientservice.findAllClientService();
	}
	
	/**
	 * 这个方法是用来找查单个客户信息
	 * @param 传入一个客户Client 对象
	 * @return 返回一个客户对象
	 */
	@RequestMapping("/findClient")
	@ResponseBody
    public Client findClientController(Client c) {
		return clientservice.findClientService(c);
	}
}
