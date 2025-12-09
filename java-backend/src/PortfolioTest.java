import java.util.ArrayList;
import java.text.DecimalFormat;

public class PortfolioTest {
    public static void main(String[] args) {

        DecimalFormat percent = new DecimalFormat("0.00%");
        DecimalFormat decimal4 = new DecimalFormat("0.0000");

        Stock AAPL = new Stock("AAPL", new double[]{100,105,102,110});
        Stock MSFT = new Stock("MSFT", new double[]{200,195,210,215});
        Stock TSLA = new Stock("TSLA", new double[]{150,160,155,170});
        
        Portfolio portfolio = new Portfolio();
        portfolio.addStock(AAPL,0.4);
        portfolio.addStock(MSFT,0.4);
        portfolio.addStock(TSLA,0.2);

        System.out.println("===== Portfolio Analysis =====\n");
        portfolio.printStocks();
       
        System.out.println("\nWeighted Return: " + percent.format(portfolio.getWeightedReturn()));
        System.out.println("Portfolio Volatility: " + percent.format(portfolio.getPortfolioVolatility()));
        System.out.println("Sharpe Ratio: " + decimal4.format(portfolio.getSharpeRatio(0.02)));
    }
}