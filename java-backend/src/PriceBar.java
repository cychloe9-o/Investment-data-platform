import java.time.LocalDate;

public class PriceBar {
    private final String symbol;
    private final LocalDate date;
    private final double close;

    public PriceBar(String symbol,LocalDate date, double close){
        this.symbol = symbol;
        this.date = date;
        this.close = close;
    }

    public String getSymbol(){return symbol;}
    public LocalDate getDate(){return date;}
    public double getClose(){return close;}

    @Override
    public String toString() {
        return symbol + " " + date + " close=" + close;
    }

}
