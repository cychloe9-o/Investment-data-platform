import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        try{
            ArrayList<Double> prices = CSVReader.readPrices("AAPL.csv");

        Asset aapl = new Stock("AAPL", prices);

        System.out.println("Return = " + ((ReturnCalculable) aapl).getReturn());
        System.out.println("Volatility = " + ((VolatilityCalculable) aapl).getVolatility());
        }catch(Exception e){
            System.err.println("System error: " + e.getMessage());
        }     

        ExecutorService executor = Executors.newFixedThreadPool(3);
        ArrayList<Double> prices = CSVReader.readPrices("AAPL.csv");

        Asset aapl = new Stock("AAPL", prices);
        executor.submit(new ReturnTask(aapl));

        executor.shutdown();

    }
}