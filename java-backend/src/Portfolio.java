import java.util.ArrayList;

public class Portfolio {
    private ArrayList<Stock> stocks;

    public Portfolio(){
        this.stocks = new ArrayList<>();
    }

    public void addStock(Stock stock){
        stocks.add(stock);
    }

    public int size(){
        return stocks.size();
    }

    public double getPortfolioReturn(){
        if(size() == 0)return 0.0;

        double pofolioReturn = 0.0;
        for(Stock s: stocks){
            pofolioReturn += s.getReturn();
        }
        return pofolioReturn / size();
    }

    public double getPortfolioVolatility(){
        if (size()==0) {
            return 0.0;
        }

        double volatility = 0.0;
        for(Stock s: stocks){
            volatility += s.getVolatility();
        }

        return volatility / size();
    }

    public ArrayList<Stock>getStocks(){
        return stocks;
    }

    public void printStocks(){
        for (Stock s: stocks){
            System.out.println(s.getSymbol() + " return = "+ s.getReturn());
        }
    }
}
