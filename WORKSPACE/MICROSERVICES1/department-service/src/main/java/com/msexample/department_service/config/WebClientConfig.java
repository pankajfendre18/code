package com.msexample.department_service.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancedExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import com.msexample.department_service.client.EmployeeClient;

@Configuration
public class WebClientConfig {

	@Autowired
	private LoadBalancedExchangeFilterFunction filterFunction;

    @Bean
    WebClient employeeWebClient() {
		return WebClient.builder().baseUrl("http://employee-service").filter(filterFunction).build();
	}

    @Bean
    EmployeeClient employeeClient() {
		HttpServiceProxyFactory httpServiceProxyFactory = HttpServiceProxyFactory
				.builderFor(WebClientAdapter.create(employeeWebClient())).build();
		return httpServiceProxyFactory.createClient(EmployeeClient.class);
	}
}
