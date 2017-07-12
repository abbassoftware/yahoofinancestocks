import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class InputFileParser {
    
    public String filepath;
    public InputFileParser(String filePath) {
        this.filepath = filePath;
    }
    
    public List<String>  parse() throws IOException {
        
        ArrayList<String> symbols = new ArrayList<String>();
        
        FileInputStream fstream = new FileInputStream(filepath);
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

        String strLine;

        //Read File Line By Line
        while ((strLine = br.readLine()) != null)   {
            symbols.add(strLine);
        }

        //Close the input stream
        br.close();
        
        return symbols;
        
        
    }

}
