import java.util.ArrayList;
import java.text.DecimalFormat;

public class PortfolioTest {
    public static void main(String[] args) {

        DecimalFormat percent = new DecimalFormat("0.00%");
        DecimalFormat decimal4 = new DecimalFormat("0.0000");

        ArrayList<Double> pricesA = new ArrayList<>();
        pricesA.add(100.0);
        pricesA.add(105.0);
        pricesA.add(102.0);
        pricesA.add(110.0);

        ArrayList<Double> pricesM = new ArrayList<>();
        pricesM.add(200.0);
        pricesM.add(195.0);
        pricesM.add(210.0);
        pricesM.add(215.0);
        
        ArrayList<Double> pricesT = new ArrayList<>();
        pricesT.add(150.0);
        pricesT.add(160.0);
        pricesT.add(155.0);
        pricesT.add(170.0);

        Stock AAPL = new Stock("AAPL", pricesA);        
        Stock MSFT = new Stock("MSFT", pricesM);
        Stock TSLA = new Stock("TSLA", pricesT);
        
        Portfolio portfolio = new Portfolio();
        portfolio.addStock(AAPL,0.4);
        portfolio.addStock(MSFT,0.4);
        portfolio.addStock(TSLA,0.2);

        System.out.println("===== Portfolio Analysis =====\n");
        System.out.println(pricesA);
        portfolio.printStocks();
       
        System.out.println("\nWeighted Return: " + percent.format(portfolio.getWeightedReturn()));
        System.out.println("Portfolio Volatility: " + percent.format(portfolio.getPortfolioVolatility()));
        System.out.println("Sharpe Ratio: " + decimal4.format(portfolio.getSharpeRatio(0.02)));
    }
}