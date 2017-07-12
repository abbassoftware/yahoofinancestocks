import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class OutPutCSVGenerator {
    
    private String filePath;
    private List<Stock> stocks;
    public OutPutCSVGenerator(String filePath, List<Stock> stocks) {
        this.filePath = filePath;
        this.stocks = stocks;
    }
    
    public void genetareCSV() throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new File(filePath));
        StringBuilder sb = new StringBuilder();
        sb.append("Stock Symbol");
        sb.append(',');
        sb.append("Current Price");
        sb.append(',');
        sb.append("Year Target Price");
        sb.append(',');
        sb.append("Year High");
        sb.append(',');
        sb.append("Year Low");
        sb.append('\n');

        pw.write(sb.toString());
        for(int i=0; i< stocks.size(); i++) {
            StringBuilder sbinner = new StringBuilder();
            sbinner.append(stocks.get(i).getStockSymbol());
            sbinner.append(',');
            sbinner.append(stocks.get(i).getCurrentPrice());
            sbinner.append(',');
            sbinner.append(stocks.get(i).getTargetPrice());
            sbinner.append(',');
            sbinner.append(stocks.get(i).getYearHigh());
            sbinner.append(',');
            sbinner.append(stocks.get(i).getYearLow());
            sbinner.append('\n');
    
            pw.write(sbinner.toString());
        }
        pw.close();
    }

}
