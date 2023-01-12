package com.nestedcode.jsontomap;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

@RestController

public class MutualFundController {

	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private SaveBeanDAO mydao;
	@GetMapping("/mfdata")
	public Iterable<SaveBean> getData(){
		String jsondata = restTemplate.getForObject("https://api.mfapi.in/mf/108152", String.class);
		//System.out.print(jsondata);
		Gson gson = new Gson();
		Map<String,Map> myMap = gson.fromJson(jsondata, Map.class);
		//System.out.println(myMap.get("data"));
		List list = (List) myMap.get("data");
		Iterator ir = list.iterator();
		while(ir.hasNext()){
			//System.out.println(ir.next());
			String newjson = gson.toJson(ir.next());
			//System.out.println(newjson);
			Map<String,String> myMapN = gson.fromJson(newjson, Map.class);
			SaveBean bean = new SaveBean();
			bean.setDate(myMapN.get("date"));
			bean.setNav(myMapN.get("nav"));
			String dateVal = myMapN.get("date");
			Collection<SaveBean> beansize = mydao.getAlldata(dateVal, myMapN.get("nav"));
			if(beansize.size()==0){
				mydao.save(bean);
			}
			
		}
		return mydao.findAll();
	}

}
