package com.nestedcode.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.nestedcode.bean.AddressBean;
import com.nestedcode.exceptionNC.UserNotFoundException;
import com.nestedcode.responseNC.ResponseNc;
import com.nestedcode.service.AddressService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AddressController {
	@Autowired
	private AddressService service;
	
	@SuppressWarnings("null")
	@GetMapping("/address")
	public ResponseNc getAddress(){
		ResponseNc responseMap = new ResponseNc();
		Map<String, Object> mainMessage = new HashMap<>();		
		mainMessage.put("mainmessage", service.getAllAddress());
		responseMap.setMainMessage(mainMessage);
		return responseMap;
	}
	@PostMapping("/address")
	public ResponseEntity<ResponseNc> saveAddress(@Valid @RequestBody AddressBean bean){
		//System.out.print(address.get);
		ResponseNc responseMap = new ResponseNc();
		Map<String, Object> mainMessage = new HashMap<>();
		AddressBean saveBean = service.saveAddress(bean);
		mainMessage.put("mainmessage", saveBean);
		responseMap.setMainMessage(mainMessage);
		return new ResponseEntity<ResponseNc>(responseMap, HttpStatus.CREATED);
	}

	@GetMapping("/address/id/{id}")
	public Optional<AddressBean> getById(@PathVariable String id) throws UserNotFoundException{
		//System.out.print("hello--> "+service.getById(Integer.parseInt(id)));
		if(!service.getById(Integer.parseInt(id)).isPresent()){
			throw new UserNotFoundException("User Not found");
		}
		return service.getById(Integer.parseInt(id));
	}
}
