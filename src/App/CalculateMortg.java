package App;

import java.text.DecimalFormat;

public class CalculateMortg {

    DecimalFormat formatter = new DecimalFormat("#.##");

    private int term = 0;
    private double PMT = 0;// the total monthly mortgage payment
    private double r = 0;// fixed yearly interest rate
    private double totalLoanAmount = 0; // total loan amount
    // constants

    private final static double RATEPERMONTH = 12 * 100;

    public CalculateMortg(double totalLoanAmount, double interestRate, int term) {
        this.totalLoanAmount = totalLoanAmount;
        this.r = interestRate / RATEPERMONTH;
        this.term = term * 12;
    }

    // Formula totalAmount *[(1+r)^term-(1-r)^umber_of_payments_made])/(1+r)^term-1]
    private double restBalancePerMonth(int i) {
        double power = Math.pow((1 + this.r), this.term);
        double powerDecrement = Math.pow((1 + this.r), i);
        double result = this.totalLoanAmount * ((power - powerDecrement) / (power - 1));
        return result;
    }

    private double roundNumber(double numberin) {
        return (Math.round(numberin * 100.0)) / 100.0;
    }

    // ---- public methods -----
    // calculate mortgage
    public double fixedPMT() {

        // M = P [ r(1 + r)^n ] / [ (1 + r)^n – 1].
        double power = Math.pow((1 + this.r), this.term);
        double res = (this.totalLoanAmount * this.r * power) / (power - 1D);
        this.PMT = Double.parseDouble(formatter.format(res));
        return this.PMT;
    }

    public double[] getBalance_WholeTerm() {
        var restBalancearray = new double[getTerm()-1];

        for (short i = 1; i <= restBalancearray.length; i++) {
            restBalancearray[i - 1] = roundNumber(restBalancePerMonth(i));
        }
        return restBalancearray;
    }

    public int getTerm() {
        return this.term;
    }

};
