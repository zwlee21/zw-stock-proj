package org.nodej.amqp.example;


import org.springframework.scheduling.annotation.Scheduled;

public class MarketBQueuePriceProducer extends RandomPriceProducer {	
	
	@Scheduled(fixedRate=3000)
	public void sendStockOne(){
		Stock sk = produceStock();
		System.out.println("sending " + sk.getStockName()+" "+sk.getStockNo());		
		getRabbitTemplate().convertAndSend(sk);
	}

}
