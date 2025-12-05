import java.util.ArrayList;
import java.text.DecimalFormat;

public class StockAnalysisTest {
    public static void main(String[] args) {
        DecimalFormat decimal2 = new DecimalFormat("#,###.00");

        ArrayList<Double> prices = new ArrayList<>();
        prices.add(100.0);
        prices.add(105.0);
        prices.add(102.0);
        prices.add(108.0);
        prices.add(103.0);

        Stock s = new Stock("AAPL", prices);
        System.out.println("Symbol: "+s.getSymbol());
        System.out.println("Return: "+decimal2.format(s.getReturn()));
        System.out.println("Volatility: "+decimal2.format(s.getVolatility()));
        System.out.println("Max Drawdown: "+decimal2.format(s.getMaxDrawdown()));
        System.out.println("Log Returns: " +decimal2.format(s.getLogReturns()));
    }

}
