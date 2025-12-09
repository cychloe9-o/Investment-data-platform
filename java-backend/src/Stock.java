import java.util.ArrayList;

public class Stock extends Asset implements ReturnCalculable{
    private String symbol;
    private ArrayList<Double> prices;
    private double simpleReturn;
    private ArrayList<Double> logReturns;
    private double volatility;
    private double maxDrawdown;

    public Stock(String symbol, ArrayList<Double> prices) {
        super(symbol, prices.get(prices.size() - 1));
        this.symbol = symbol;
        this.prices = prices;
        calculateAll();
    }

    public Stock(String symbol, double[] priceArray) {
        super(symbol, priceArray[priceArray.length - 1]);
        this.symbol = symbol;
        this.prices = new ArrayList<>();
        for (double p : priceArray) {
            this.prices.add(p);
        }
        calculateAll();
    }

    private void calculateAll() {
        calculateSimpleReturn();
        calculateLogReturns();
        calculateVolatility();
        calculateMaxDrawdown();
    }

    private void calculateSimpleReturn(){
        if (prices.size() < 2) {
            this.simpleReturn = 0.0;
        }
        this.simpleReturn = (prices.get(prices.size()-1)/prices.get(0)-1);
    }

    private void calculateLogReturns() {
        logReturns = new ArrayList<>();

        for (int i=1; i < prices.size(); i++){
            double r = Math.log(prices.get(i) / prices.get(i-1));
            logReturns.add(r);
        }
    }

    private void calculateVolatility() {
        
        if (logReturns.size() < 2) {
            this.volatility = 0.0;
            return;
        }
        double mean = 0;
        for(double r: logReturns) mean+=r;
        mean = mean/logReturns.size();

        double variance = 0;
        for(double r: logReturns) variance += Math.pow(r - mean,2);
        variance /= logReturns.size();

        this.volatility = Math.sqrt(variance);
    }

    private void calculateMaxDrawdown() {
        double peak = prices.get(0);
        double maxDD = 0;

        for(double r: prices){
            if (r > peak) {
                peak = r;
            }
            double drawdown = (r-peak)/peak;
            if (drawdown < maxDD) {
                maxDD = drawdown;
            }
        }

        this.maxDrawdown = maxDD;
    }

    public String getSymbol() { return symbol; }
    
    public ArrayList<Double> getLogReturns() { return logReturns; }
    public double getVolatility() { return volatility; }
    public double getMaxDrawdown() { return maxDrawdown; }

    @Override
    public String getType() {return "Stock";}
    @Override
    public double getReturn() { return simpleReturn; }
}
