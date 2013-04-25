package org.nodej.amqp.example;


import org.springframework.scheduling.annotation.Scheduled;

public class MarketCQueuePriceProducer extends RandomPriceProducer {	
	
	@Scheduled(fixedRate=4000)
	public void sendStockOne(){
		Stock sk = produceStock();
		System.out.println("sending " + sk.getStockName()+" "+sk.getStockNo());		
		getRabbitTemplate().convertAndSend(sk);
	}

}
