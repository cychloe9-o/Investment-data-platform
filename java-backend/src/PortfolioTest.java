import java.util.ArrayList;
import java.text.DecimalFormat;

public class PortfolioTest {
    public static void main(String[] args) {

        DecimalFormat percent = new DecimalFormat("0.00%");
        DecimalFormat decimal4 = new DecimalFormat("0.0000");

        // Stock AAPL
        ArrayList<Double> pricesA = new ArrayList<>();
        pricesA.add(100.0);
        pricesA.add(105.0);
        pricesA.add(102.0);
        pricesA.add(108.0);
        pricesA.add(103.0);

        Stock AAPL = new Stock("AAPL", pricesA);

        // Stock MSFT
        ArrayList<Double> pricesM = new ArrayList<>();
        pricesM.add(200.0);
        pricesM.add(202.0);
        pricesM.add(210.0);
        pricesM.add(215.0);
        
        Stock MSFT = new Stock("MSFT", pricesM);

        // Portfolio
        Portfolio portfolio = new Portfolio();
        portfolio.addStock(AAPL);
        portfolio.addStock(MSFT);

        System.out.println("===== Portfolio Analysis =====\n");

        System.out.println("Number of Stocks: " + portfolio.size());
        System.out.println("Portfolio Return: " + percent.format(portfolio.getPortfolioReturn()));
        System.out.println("Portfolio Vol: " + decimal4.format(portfolio.getPortfolioVolatility()));

        System.out.println("\nStocks included:");
        for (Stock s : portfolio.getStocks()) {
            System.out.println(" - " + s.getSymbol());
        }

        System.out.println("\n==============================");
    }
}