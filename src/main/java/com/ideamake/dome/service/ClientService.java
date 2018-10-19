package com.ideamake.dome.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideamake.dome.dao.ClientDao;
import com.ideamake.dome.model.Client;

@Service
public class ClientService {
	/**
	 * 这是客户的服务类，用来实现控制类接口的中转站
	 * 
	 * */
 
@Autowired
private ClientDao clientdao;

public int insertClientService(Client c) {
	return clientdao.insertClient(c);
}
public int deleteClientService(int c_id) {
	return clientdao.deleteClient(c_id);
}
public int updateClientService(Client c) {
	
	return clientdao.updateClient(c);
}
public List<Client> findAllClientService() {
	return clientdao.findAllClient();
}
public Client findClientService(Client c) {
	return clientdao.findClient(c);
}
}
