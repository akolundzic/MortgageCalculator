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

    // ---- public methods -----
    // calculate mortgage
    public double fixedPMT() {

        // M = P [ r(1 + r)^n ] / [ (1 + r)^n – 1].
        double power = Math.pow((1 + this.r), this.term);
        double res = (this.totalLoanAmount * this.r * power) / (power - 1D);
        this.PMT = Double.parseDouble(formatter.format(res));
        return this.PMT;
    }

    // Formula totalAmount *[(1+r)^term-(1-r)^umber_of_payments_made])/(1+r)^term-1]
    public double restBalancePerMonth(int i) {
        double power = Math.pow((1 + this.r), this.term);
        double powerDecrement = Math.pow((1 + this.r), i);
        double result = this.totalLoanAmount * ((power - powerDecrement) / (power - 1));
        return result;
    }

    public int getTerm() {
        return this.term;
    }

    public double roundNumber(double numberin) {
        return (Math.round(numberin * 100.0)) / 100.0;
    }
};
