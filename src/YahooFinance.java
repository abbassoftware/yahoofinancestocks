


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;




public class YahooFinance {
    
    
    public  String getStockQuote(List<String> symbols) throws Exception {

        // Sanity check
        for(int i =0; i< symbols.size(); i++) {
            String symbol = symbols.get(i);
            if( symbol == null || symbol.isEmpty() ) {
                throw new Exception("null or empty symbol");
            }
        }
        
        
        String allSymbolsQuery = "";
        
        for(int i =0; i< symbols.size(); i++) {
            String symbol = symbols.get(i);
            if(i == 0) { 
                allSymbolsQuery = symbol;
            }
            else { 
                allSymbolsQuery = allSymbolsQuery + "%22%2C%20%22" + symbol;
            }
        }
       
        String url = "http://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20yahoo.finance.quotes%20where%20symbol%20in%20(%22"
                + URLEncoder.encode(allSymbolsQuery.toUpperCase(), "UTF-8")
                +
                "%22)&format=json&env=store://datatables.org/alltableswithkeys";      
   

        // Form the HTTP request to Yahoo
     
        // Create a URL and open a connection
        URL YahooURL = new URL(url);
        HttpURLConnection con = (HttpURLConnection) YahooURL.openConnection();

        // Set the HTTP Request type method to GET (Default: GET)
        con.setRequestMethod("GET");

        // Created a BufferedReader to read the contents of the request.
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }

        // MAKE SURE TO CLOSE YOUR CONNECTION!
        in.close();
        
        
        //Create and return the result
        
        String httpResponseString = response.toString();
        System.out.println( "HTTP Response String: " + httpResponseString );

        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject)parser.parse( httpResponseString );
        System.out.println("JSON Object: " + jsonObject);

        JSONObject query = (JSONObject) jsonObject.get("query");
        //System.out.println("Query: " + query);
        JSONObject results = (JSONObject) query.get("results");
        System.out.println("Results: " + results);

        return results.toJSONString();
    }
    
    
   
}
