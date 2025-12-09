public class Main {
    public static void main(String[] args) {
        System.out.println("Java backend placeholder");
        Asset a1 = new Stock("AAPL", new double[]{100,105,110});
        Asset a2 = new CryptoCurrency("BTC", 67000, 0.75);

        System.out.println(a1.getType());
        System.out.println(a2.getType());

        System.out.println(a1.getReturn());
        System.out.println(a2.getReturn());

        Asset e = new ETF("QQQ", new double[]{300, 310, 320});
        System.out.println(e.getReturn());
    }
}