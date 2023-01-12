package com.nestedcode.DAO;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.nestedcode.bean.AddressBean;

import lombok.RequiredArgsConstructor;


public interface AddressConnection extends CrudRepository<AddressBean, Integer>{

	
}
