package org.nodej.amqp.example;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;

public abstract class RandomPriceProducer {
    private RabbitTemplate rabbitTemplate;
    private int ramdonNo;
    private String[][] stocks;
    private String marketNo;
    
	public String getMarketNo() {
		return marketNo;
	}

	public void setMarketNo(String marketNo) {
		this.marketNo = marketNo;
	}

	public String[][] getStocks() {
		return stocks;
	}

	public void setStocks(String[][] stocks) {
		this.stocks = stocks;
	}

	public void setRabbitTemplate(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}	
	
	public RabbitTemplate getRabbitTemplate() {
		return this.rabbitTemplate;
	}	
	
	public void setQueueName(String name){
		this.rabbitTemplate.setQueue(name);
		
	}
        public void setRoutingKey(String name){		
                this.rabbitTemplate.setRoutingKey(name);		
	}
        
    @Scheduled(fixedRate=60000)
    public void changeStockNo(){
    	this.ramdonNo  = (int)(Math.random()*10);
    		
    } 
    
    protected String[] getRandomStockName(){
    	return this.stocks[this.ramdonNo];
    }
	
	private String getBuyPrice(double random) {
		NumberFormat formatter = new DecimalFormat("#0.00");
		return formatter.format(random * 100);
	}

        private String getSellPrice(double random) {
		NumberFormat formatter = new DecimalFormat("#0.00");
		return formatter.format(random * 100);
	}

        private String getTotalCount(double random) {
		NumberFormat formatter = new DecimalFormat("#0");
		return formatter.format(random * 100000);
	}
        
     public Stock produceStock(){
    	 
    	   String[] stockInfo = getRandomStockName();
    	   Stock sk = new Stock();     	   
    	   String stockNo =stockInfo[0];
    	   String name = stockInfo[1];
    	   sk.setMarketNo(marketNo);
    	   sk.setStockName(name);
    	   sk.setStockNo(stockNo);
    	   sk.setBuyInPrice(getBuyPrice(Math.random()));
    	   sk.setSellOutPrice(getSellPrice(Math.random()));
    	   sk.setTotalCount(getTotalCount(Math.random())); 
    	   return sk;
    	   
       }
}
