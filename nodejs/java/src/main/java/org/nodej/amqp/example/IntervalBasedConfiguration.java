package org.nodej.amqp.example;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.JsonMessageConverter;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.ScheduledAnnotationBeanPostProcessor;

@Configuration
public class IntervalBasedConfiguration extends CommonConfiguration {
	@Bean
	public BeanPostProcessor postProcessor() {
		return new ScheduledAnnotationBeanPostProcessor();
	}
	
	
	@Override
	public RabbitTemplate rabbitTemplate() {
		RabbitTemplate template = new RabbitTemplate(connectionFactory());		
		template.setExchange(exchange);
		template.setMessageConverter(new JsonMessageConverter());
		return template;
	}

    
	@Bean
	public MarketAQueuePriceProducer queueOnePriceProducer(){
		String[][] stocks = new String[][]{
				{"002680","百洋股份"},
				{"002681","煌上煌"},
				{"002682","红旗连锁"},
				{"002683","长江股份"},
				{"002684","博实股份"},
				{"002685","光线传媒"},
				{"002686","掌趣科技"},
				{"002687","美盛文化"},
				{"002688","金杯汽车"},
				{"002689","一汽大众"}			
		};
		MarketAQueuePriceProducer producer = new MarketAQueuePriceProducer();
		producer.setRabbitTemplate(rabbitTemplate());
		producer.setQueueName("queue_java_A");
        producer.setRoutingKey("key.q.a");
        producer.setMarketNo("123688");
        producer.setStocks(stocks);
		return producer;
	}
	@Bean
	public MarketBQueuePriceProducer queueTwoPriceProducer(){
		String[][] stocks = new String[][]{
				{"002665","澳柯玛"},
				{"002666","新华龙"},
				{"002667","华润锦华"},
				{"002668","锦港Ｂ股"},
				{"002669","自仪Ｂ股"}	,
				{"002660","悦达投资"},
				{"002661","杭钢股份"},
				{"002662","中航投资"},
				{"002663","ST二重"},
				{"002664","嘉宝集团"}						
		};
		MarketBQueuePriceProducer producer = new MarketBQueuePriceProducer();
		producer.setRabbitTemplate(rabbitTemplate());
		producer.setQueueName("queue_java_B");
        producer.setRoutingKey("key.q.b");
        producer.setMarketNo("124599");
        producer.setStocks(stocks);
		return producer;
	}
	
	@Bean
	public MarketCQueuePriceProducer queueThreePriceProducer(){
		String[][] stocks = new String[][]{
				{"002880","中金黄金"},
				{"002881","东方钽业"},
				{"002882","新赛股份"},
				{"002883","登海种业"},
				{"002884","SST华新"},
				{"002885","德信无线"},
				{"002886","中国电信"},
				{"002887","橡果国际"},
				{"002888","华视传媒"},
				{"002889","乐语中国"}			
		};
		MarketCQueuePriceProducer producer = new MarketCQueuePriceProducer();
		producer.setRabbitTemplate(rabbitTemplate());
		producer.setQueueName("queue_java_C");
		producer.setRoutingKey("key.q.c");
	    producer.setMarketNo("12456");
	    producer.setStocks(stocks);
        return producer;
	}
	@Bean
	public MarketDQueuePriceProducer queueFourPriceProducer(){
		String[][] stocks = new String[][]{
				{"003680","世纪佳缘"},
				{"003681","世纪互联"},
				{"003682","腾讯控股"},
				{"003683","阿里巴巴"},
				{"003684","金山软件"},
				{"003685","优酷"},
				{"003686","当当网"},
				{"003687","新东方教育"},
				{"003688","人人网"},
				{"003689","完美时空"}			
		};
		MarketDQueuePriceProducer producer = new MarketDQueuePriceProducer();
		producer.setRabbitTemplate(rabbitTemplate());
		producer.setQueueName("queue_java_D");
        producer.setRoutingKey("key.q.d");
        producer.setMarketNo("12888");
	    producer.setStocks(stocks);
		return producer;
	}
	@Bean
	public MarketEQueuePriceProducer queueFivePriceProducer(){
		String[][] stocks = new String[][]{
				{"003380","搜狐"},
				{"003381","畅游"},
				{"003382","新浪"},
				{"003383","网易"},
				{"003384","百度"},
				{"003385","盛大网络"},
				{"003386","携程网"},
				{"003387","侨兴环球"},
				{"003388","前程无忧"},
				{"003389","空中网"}			
		};
		MarketEQueuePriceProducer producer = new MarketEQueuePriceProducer();
		producer.setRabbitTemplate(rabbitTemplate()); 
		producer.setQueueName("queue_java_E");
        producer.setRoutingKey("key.q.e");
        producer.setMarketNo("16888");
        producer.setStocks(stocks);
		return producer;
	}
	
	
}
