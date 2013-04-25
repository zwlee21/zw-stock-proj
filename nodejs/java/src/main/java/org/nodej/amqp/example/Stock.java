package org.nodej.amqp.example;
public class Stock {
	private String marketNo;
	private String stockNo;
	private String  stockName;
	private String  buyInPrice;
	private String  sellOutPrice;
	private String totalCount;
	public String getStockNo() {
		return stockNo;
	}
	public void setStockNo(String stockNo) {
		this.stockNo = stockNo;
	}
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public String getBuyInPrice() {
		return buyInPrice;
	}
	public void setBuyInPrice(String buyInPrice) {
		this.buyInPrice = buyInPrice;
	}
	public String getSellOutPrice() {
		return sellOutPrice;
	}
	public void setSellOutPrice(String sellOutPrice) {
		this.sellOutPrice = sellOutPrice;
	}
	public String getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}
	public String getMarketNo() {
		return marketNo;
	}
	public void setMarketNo(String marketNo) {
		this.marketNo = marketNo;
	}

}

