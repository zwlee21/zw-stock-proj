package org.nodej.amqp.example;

import org.springframework.scheduling.annotation.Scheduled;

public class MarketAQueuePriceProducer extends RandomPriceProducer {
	
	
	@Scheduled(fixedRate=2000)
	public void sendStockOne(){
		Stock sk = produceStock();
		System.out.println("sending " + sk.getStockName()+" "+sk.getStockNo());		
		getRabbitTemplate().convertAndSend(sk);
	}

}
