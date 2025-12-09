public abstract class Asset implements ReturnCalculable{
    protected String symbol;
    protected double lastPrice;

    public Asset(String symbol, double lastPrice){
        this.symbol = symbol;
        this.lastPrice = lastPrice;
    }

    public String getSymbol() { return symbol; }

    public double getLastPrice() { return lastPrice; }

    public abstract String getType();

    /* 
    public String getType() {
        return "Generic Asset";
    }
    */
    
}
