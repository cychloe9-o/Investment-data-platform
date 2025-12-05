import java.util.ArrayList;

public class Stock {
    private String symbol;
    private ArrayList<Double> prices;

public Stock(String symbol, ArrayList<Double> prices){
    this.symbol = symbol;
    this.prices = prices;
}

public double getReturn(){
    if (prices.size() < 2) {
        return 0.0;
    }
    return (prices.get(prices.size()-1)/prices.get(0)-1);
}

public String getSymbol(){
    return symbol;
}

public ArrayList<Double> getLogReturns(){
    ArrayList<Double> logReturns = new ArrayList<>();

    for (int i=1; i < prices.size(); i++){
        double r = Math.log(prices.get(i) / prices.get(i-1));
        logReturns.add(r);
    }
    return logReturns;
}

public double getVolatility(){
    ArrayList<Double> logReturns = getLogReturns();
    if (logReturns.size() < 2) return 0.0;

    double mean = 0;
    for(double r: logReturns) mean+=r;
    mean = mean/logReturns.size();

    double variance = 0;
    for(double r: logReturns) variance += Math.pow(r - mean,2);
    variance /= logReturns.size();

    return Math.sqrt(variance);
}

public double getMaxDrawdown(){
    double peak = prices.get(0);
    double maxDrawdown = 0;

    for(double r: prices){
        if (r > peak) {
            peak = r;
        }
        double drawdown = (r-peak)/peak;
        if (drawdown < maxDrawdown) {
            maxDrawdown = drawdown;
        }
    }

    return maxDrawdown;
}

}
