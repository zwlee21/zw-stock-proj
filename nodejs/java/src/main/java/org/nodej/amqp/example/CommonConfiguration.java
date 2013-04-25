package org.nodej.amqp.example;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.config.AbstractRabbitConfiguration;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.SingleConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;

public abstract class CommonConfiguration extends AbstractRabbitConfiguration {

	protected static final String exchange = "node_exchange";
	protected String queueName = "java_queue";
	private String routingKey = "key.a.b";

	public CommonConfiguration() {
		super();
	}

	@Bean
	public ConnectionFactory connectionFactory() {
		SingleConnectionFactory connectionFactory = new SingleConnectionFactory("localhost");
		connectionFactory.setUsername("guest");
		connectionFactory.setPassword("guest");
		return connectionFactory;
	}

	@Override
	public RabbitTemplate rabbitTemplate() {
		RabbitTemplate template = new RabbitTemplate(connectionFactory());
		template.setRoutingKey(routingKey);
		template.setQueue(queueName);
		return template;
	}

	@Bean
	public Binding binding() {
		Queue q = new Queue(queueName);
		AmqpAdmin admina = amqpAdmin();
		admina.declareQueue(q);
		Binding binding = new Binding(q, new DirectExchange(exchange), routingKey);
		admina.declareBinding(binding);
		return binding;
	}

}