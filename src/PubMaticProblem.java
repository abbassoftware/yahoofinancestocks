import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.json.simple.parser.ParseException;

import java.nio.file.Paths;

public class PubMaticProblem {
    
    private static int ONE_BATCH = 40;
    
    public static void main(String[] args) {
        
        try {
            
            long progStartTime = System.currentTimeMillis();
            System.out.println("Program start time" +  progStartTime);
            InputFileParser inputFileParser = new InputFileParser(Paths.get(".").toAbsolutePath().normalize().toString() + "/res/Stocks.txt");
            List<String> symbols = inputFileParser.parse();
            
            List<Stock> allStocks = processSymbols(symbols); 
            
            new OutPutCSVGenerator(Paths.get(".").toAbsolutePath().normalize().toString() + "/res/StocksOut.csv", allStocks).genetareCSV();
            
            
            long progEndTime = System.currentTimeMillis();
            System.out.println("Progra end time" +  progEndTime);
            System.out.println("Time to Run the program :" + (progEndTime -  progStartTime));
           
        } catch (Exception e) {
            System.out.println("Exception" + e.toString());
            e.printStackTrace();
        }
        
     
    }
    
    static private List<Stock> processSymbols(List<String> symbols) throws ParseException, Exception {
        List<Stock> allStocks = new ArrayList<>();
        ArrayList<String> batch = new ArrayList<>();

        while(!symbols.isEmpty()) {
            
            batch.add(symbols.get(0));
            symbols.remove(0);
            if(batch.size() >= ONE_BATCH) {
                List<Stock> stocks = new StockJsonParser(new YahooFinance().getStockQuote(batch)).parse();
                for(int i = 0; i < stocks.size(); i++) {
                    allStocks.add(stocks.get(i));
                }
                batch.clear();
            }
         } 
        if(!batch.isEmpty()) {
            List<Stock> stocks = new StockJsonParser(new YahooFinance().getStockQuote(batch)).parse();
            for(int i = 0; i < stocks.size(); i++) {
                allStocks.add(stocks.get(i));
            }
            batch.clear();
        }
        
        return allStocks;
    }

}
