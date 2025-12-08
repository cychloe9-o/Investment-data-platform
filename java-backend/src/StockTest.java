import java.util.ArrayList;

public class StockTest {
    public static void main(String[] args) {
        ArrayList<Double> prices = new ArrayList<>();
        prices.add(100.0);
        prices.add(105.0);
        prices.add(108.0);


        Stock apple = new Stock("AAPL", prices);

        System.out.println("Symbol: " + apple.getSymbol());
        System.out.println("Return: " + (apple.getReturn() * 100) + "%");
    }
}
