public class StockTest {
    public static void main(String[] args) {
        double[] prices = { 100.0, 102.0, 105.0, 110.0 };

        Stock apple = new Stock("AAPL", prices);

        System.out.println("Symbol: " + apple.getSymbol());
        System.out.println("Return: " + (apple.getReturn() * 100) + "%");
    }
}
