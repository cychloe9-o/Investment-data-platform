
public class MathFinanceUtil {
    public static double annualizeReturn(double totalReturn, int days) {
        return Math.pow(1 + totalReturn, 252.0 / days) - 1;
    }
    
    public static double annualizeVolatility(double dailyVol) {
        return dailyVol * Math.sqrt(252);
    }

    public static double sharpe(double annualReturn, double annualVol, double rf) {
        return (annualReturn - rf) / annualVol;
}

}
