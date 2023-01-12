package com.nestedcode.jsontomap;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestTemplateonfig {

	@Bean
	public RestTemplate getREstTemplate(){
		return new RestTemplate();
	}
}
