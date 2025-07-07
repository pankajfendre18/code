package com.example.cab_book_driver.service.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import com.example.cab_book_driver.service.constant.AppConstant;

@Configuration
public class KafkaConfig {

	@Bean
	NewTopic topic() {
		return TopicBuilder.name(AppConstant.CAB_LOCATION).build();
	}
}
