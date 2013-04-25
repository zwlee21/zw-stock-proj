

import org.springframework.scheduling.annotation.Scheduled;

public class QueueFivePriceProducer extends RandomPriceProducer {	
	
	@Scheduled(fixedRate=7000)
	public void sendStockOne(){
		Stock sk = produceStock("南方航空",12380);
		System.out.println("sending " + sk.getStockName()+" "+sk.getStockNo());		
		getRabbitTemplate().convertAndSend(sk);
	}

}
