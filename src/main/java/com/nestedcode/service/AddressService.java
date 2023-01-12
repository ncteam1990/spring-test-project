package com.nestedcode.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nestedcode.DAO.AddressConnection;
import com.nestedcode.bean.AddressBean;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AddressService {
	
	@Autowired
	private AddressConnection connection;
	
	public List<AddressBean> getAllAddress(){
		return (List<AddressBean>) connection.findAll();
	}
	public AddressBean saveAddress(AddressBean bean){
		return connection.save(bean);
	}
	public Optional<AddressBean> getById(Integer id){
		return connection.findById(id);
	}
}
