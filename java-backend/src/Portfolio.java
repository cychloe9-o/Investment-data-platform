import java.util.ArrayList;


//only works for stock now
public class Portfolio {
    private ArrayList<Stock> stocks;
    private ArrayList<Double> weights;

    public Portfolio(){
        this.stocks = new ArrayList<>();
        this.weights = new ArrayList<>();
    }

    //Initiate, diff from the following one
    public void addStock(Stock stock){
        stocks.add(stock);
        weights.add(1.0/stocks.size());
    }

    public void addStock(Stock stock, double weight){
        if (weight < 0) {
            throw new IllegalArgumentException("Weight cannot be negative");
        }

        stocks.add(stock);
        weights.add(weight);
    } 

    public int size(){
        return stocks.size();
    }

    public double getAverageReturn(){
        if(size() == 0)return 0.0;

        double pofolioReturn = 0.0;
        for(Stock s: stocks){
            pofolioReturn += s.getReturn();
        }
        return pofolioReturn / size();
    }

    public double getWeightedReturn(){

        double weightedReturn =0.0;
        for(int i=0; i<stocks.size(); i++){
            weightedReturn += stocks.get(i).getReturn() * weights.get(i);
        }

        return weightedReturn;
    }

    public ArrayList<Double> getPortfolioLogReturns(){

        ArrayList<Double> logReturns = new ArrayList<>();

        for(int t=0;t<stocks.get(0).getLogReturns().size();t++){
            double dailyLogReturn = 0.0;
            for(int i=0; i<stocks.size(); i++){
                dailyLogReturn += stocks.get(i).getLogReturns().get(t) * weights.get(i); 
            }
            logReturns.add(dailyLogReturn);
        }   
        
        return logReturns;
    }

    public double getPortfolioVolatility() {
        ArrayList<Double> logs = getPortfolioLogReturns();

        double mean = 0.0;
        for (double r : logs) mean += r;
        mean /= logs.size();

        double sumSq = 0.0;
        for (double r : logs) sumSq += Math.pow(r - mean, 2);

        return Math.sqrt(sumSq / logs.size());
    }

    public ArrayList<Stock>getStocks(){
        return stocks;
    }

    public double getSharpeRatio(double riskFreeRate) {
        double excessReturn = getWeightedReturn() - riskFreeRate;
        return excessReturn / getPortfolioVolatility();
    }

    public void printStocks() {
        for (int i = 0; i < stocks.size(); i++) {
            Stock s = stocks.get(i);
            double w = weights.get(i);
            System.out.println(s.getSymbol() + "  (w=" + w + ")  Return=" + s.getReturn());
        }
    }
}
