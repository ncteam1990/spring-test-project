package com.nestedcode.jsontomap;

import java.util.Collection;
import java.util.List;

import org.hibernate.validator.constraints.ParameterScriptAssert;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nestedcode.bean.AddressBean;

public interface SaveBeanDAO extends CrudRepository<SaveBean,Integer>{

	@Query(value="SELECT * FROM save_bean p where p.date=:date and p.nav=:nav", nativeQuery = true)
	Collection<SaveBean> getAlldata(@Param("date") String date, @Param("nav") String nav);
}
