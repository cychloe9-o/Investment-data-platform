import java.util.ArrayList;

public class ETF extends Asset implements ReturnCalculable {
    private String symbol;
    private ArrayList<Double> prices;
    
    public ETF(String symbol, ArrayList<Double>prices){
        super(symbol, prices.get(prices.size()-1));
        this.symbol = symbol;
        this.prices = prices;
    }

    public ETF(String symbol, double[] priceArray) {
        super(symbol, priceArray[priceArray.length - 1]);
        this.symbol = symbol;
        this.prices = new ArrayList<>();
        for (double p : priceArray) {
            this.prices.add(p);
        }
    }

    @Override
    public String getType(){
        return "ETF";
    }

    @Override
    public double getReturn(){
        return prices.get(prices.size()-1)/prices.get(0)-1;
    }

}
