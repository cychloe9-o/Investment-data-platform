import java.util.ArrayList;

public class WeightedPortfolio {
    private ArrayList<Stock> stocks;
    private ArrayList<Double> weights;

    public WeightedPortfolio(){
        this.stocks = new ArrayList<>();
        this.weights = new ArrayList<>();
    }

    public void addStock(Stock stock, double weight){
        stocks.add(stock);
        weights.add(weight);
    } 

    public double getWeightedReturn(){

        double weightedReturn =0.0;
        for(int i=0; i<stocks.size(); i++){
            weightedReturn += stocks.get(i).getReturn() * weights.get(i);
        }

        return weightedReturn;
    }
}
