import java.util.ArrayList;

public class WeightedPortfolioTest {
    public static void main(String[] args) {
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
        
        WeightedPortfolio wp = new WeightedPortfolio();
        wp.addStock(MSFT, 0.2);
        wp.addStock(AAPL, 0.8);
               
        System.out.println("Weighted Portfolio Average Return: "+wp.getWeightedReturn());
    }

}
