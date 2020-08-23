package br.com.virtual.store.ws.bean.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.virtual.store.ws.service.UserService;
import br.com.virtual.store.ws.service.impl.UserServiceImpl;

@Configuration
public class BeanConfigs {

	@Bean
	public UserService createUserService() {
		return new UserServiceImpl();
	}
}
