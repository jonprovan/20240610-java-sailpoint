package com.skillstorm.config;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

	@Value("${exchange.name}")
	private String exchangeName;
	
	@Bean
	public TopicExchange topicExchange() {
		return new TopicExchange(exchangeName);
	}
	
	@Bean
	public MessageConverter messageConverter() {
		// this is used to convert java objects into JSON for when we publish
		return new Jackson2JsonMessageConverter();
	}
}
