import java.util.ArrayList;
import java.text.DecimalFormat;

public class PortfolioTest {
    public static void main(String[] args) {

        DecimalFormat percent = new DecimalFormat("0.00%");
        DecimalFormat decimal4 = new DecimalFormat("0.0000");

        ArrayList<Double> pricesA = new ArrayList<>();
        pricesA.add(100.0);
        pricesA.add(105.0);
        pricesA.add(110.0);

        ArrayList<Double> pricesM = new ArrayList<>();
        pricesM.add(200.0);
        pricesM.add(195.0);
        pricesM.add(210.0);


        Stock AAPL = new Stock("AAPL", pricesA);        
        Stock MSFT = new Stock("MSFT", pricesM);

        
        Portfolio portfolio = new Portfolio();
        portfolio.addStock(AAPL);
        portfolio.addStock(MSFT);

        System.out.println("===== Portfolio Analysis =====\n");
        System.out.println(pricesA);
        portfolio.printStocks();
       
        System.out.println("Portfolio Average Return: "+portfolio.getPortfolioReturn());
    }
}