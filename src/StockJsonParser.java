import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.util.ArrayList;
import java.util.List;

public class StockJsonParser {
    
    private String stockJson;
    
    public StockJsonParser(String json) {
        this.stockJson = json;
    }
    
    public List<Stock> parse() throws ParseException  {
        
        List<Stock> stocks = new ArrayList<>();
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject)parser.parse( stockJson );
        Object quoteObject = jsonObject.get("quote");
        if(quoteObject instanceof JSONArray) {
            JSONArray quoteArray = (JSONArray)quoteObject;
            for(int i = 0; i < quoteArray.size(); i++) {
                  JSONObject stockJson = (JSONObject) quoteArray.get(i);
                  stocks.add(getStockFromJson(stockJson));
            }
        }
        else {
            JSONObject quote = (JSONObject)quoteObject;
            stocks.add(getStockFromJson(quote));
        }
        
        return stocks;
    }
    
    private Stock getStockFromJson(JSONObject stockJson) {
        String symbol = (String) stockJson.get("symbol");
        String yearHigh = (String) stockJson.get("YearLow");
        String yearLow = (String) stockJson.get("YearHigh");
        String price = (String) stockJson.get("LastTradePriceOnly");
        String oneYeTradePrice = (String) stockJson.get("OneyrTargetPrice");
        return new Stock(symbol, oneYeTradePrice, price, yearHigh, yearLow);
    }

    

}
