public class CryptoCurrency extends Asset implements ReturnCalculable{
    private double volatility;

    public CryptoCurrency(String symbol, double lastPrice, double volatility) {
        super(symbol, lastPrice);
        this.volatility = volatility;
    }

    @Override
    public String getType() {
        return "Crypto";
    }

    public double getVolatility() {
        return volatility;
    }


    //Set 5000 as an initial price
    @Override
    public double getReturn(){
        return (lastPrice/5000-1);
    }
}
