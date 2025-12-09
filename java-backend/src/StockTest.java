import java.text.DecimalFormat;

public class StockTest {
    public static void main(String[] args) {

        DecimalFormat pct = new DecimalFormat("0.00%");
        DecimalFormat dec4 = new DecimalFormat("0.0000");

        Stock s = new Stock("AAPL", new double[]{100, 105, 102, 108, 103});

        System.out.println("==== Stock Metrics ====");
        System.out.println("Symbol: " + s.getSymbol());
        System.out.println("Return: " + pct.format(s.getReturn()));
        System.out.println("Volatility: " + pct.format(s.getVolatility()));
        System.out.println("Max Drawdown: " + pct.format(s.getMaxDrawdown()));

        System.out.println("\nLog Returns:");
        for (double r : s.getLogReturns()) {
            System.out.println("  " + dec4.format(r));
        }
    }
}