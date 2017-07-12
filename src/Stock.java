
public class Stock {

    private String stockSymbol;
    
    private String targetPrice;
    private String currentPrice;
    private String yearHigh;
    private String yearLow;
    
    
    public Stock(String stockSymbol , String targetPrice , String currentPrice,
            String yearHigh, String yearLow) {
        this.stockSymbol = stockSymbol;
        this.targetPrice = targetPrice;
        this.currentPrice = currentPrice;
        this.yearHigh = yearHigh;
        this.yearLow = yearLow;
    }
    public String getStockSymbol() {
        return stockSymbol;
    }
    public void setStockSymbol(String stockSymbol) {
        this.stockSymbol = stockSymbol;
    }
    public String getTargetPrice() {
        return targetPrice;
    }
    public void setTargetPrice(String targetPrice) {
        this.targetPrice = targetPrice;
    }
    public String getCurrentPrice() {
        return currentPrice;
    }
    public void setCurrentPrice(String currentPrice) {
        this.currentPrice = currentPrice;
    }
    public String getYearHigh() {
        return yearHigh;
    }
    public void setYearHigh(String yearHigh) {
        this.yearHigh = yearHigh;
    }
    public String getYearLow() {
        return yearLow;
    }
    public void setYearLow(String yearLow) {
        this.yearLow = yearLow;
    }
    @Override
    public String toString() {
        return "Stock [stockSymbol=" + stockSymbol + ", targetPrice=" + targetPrice + ", currentPrice=" + currentPrice
                + ", yearHigh=" + yearHigh + ", yearLow=" + yearLow + "]";
    }
   
    
}
