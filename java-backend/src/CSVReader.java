import java.io.*;
import java.util.*;

public class CSVReader {
    public static ArrayList<Double> readPrices(String filePath){
        ArrayList<Double> prices = new ArrayList<>();

        try(BufferedReader br = new BufferedReader (new FileReader(filePath))){
            String line;
            br.readLine();

            while ((line =br.readLine()) != null) {
                line = line.trim();
                
                if (line.startsWith("\"") && line.endsWith("\"")) {
                    line = line.substring(1, line.length() - 1);
                }
                String[] parts = line.split(",");

                if (parts.length<2) {
                    continue;
                }

                double price = Double.parseDouble(parts[1]);
                prices.add(price);
            }
        }catch (IOException e) {
            throw new RuntimeException("Failed to read CSV file: " + filePath, e);
        }
    
        if (prices.isEmpty()) {
            throw new IllegalStateException("No valid price data found");
        }
    

        return prices;
    }
}
