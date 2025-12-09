public class UtilTest {
    public static void main(String[] args) {

        double r = MathFinanceUtil.annualizeReturn(0.08, 100);
        double v = MathFinanceUtil.annualizeVolatility(0.015);
        double s = MathFinanceUtil.sharpe(r, v, 0.02);

        System.out.println("Annualized Return: " + r);
        System.out.println("Annualized Volatility: " + v);
        System.out.println("Sharpe: " + s);
    }
}