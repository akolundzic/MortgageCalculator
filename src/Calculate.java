
import java.util.Scanner;
import java.text.DecimalFormat;
//calculation of the mortgage
//formula:totalLoanAmountIn*[ r(1 + r)^n ] / [ (1 + r)^n – 1]

public class Calculate {
    DecimalFormat formatter = new DecimalFormat( "#.##" );
    // instance variables
    final double perMonth = 12F*100F;
    Scanner scan;
    int n;//term in months
    double PMT;// the total monthly mortgage payment
    double r;//fixed yearly interest rate
    double totalLoanAmount; // total loan amount 
    //constructor
    public Calculate(int termIn, double interestRateIN, double totalLoanAmountIn) {
        this.n = termIn * 12; // Multiply the number of years in your loan term by 12
        this.PMT = 0.0D;
        this.r = interestRateIN /perMonth;// r[%] -> absolute monthly rate r/(100*12)
        this.totalLoanAmount = totalLoanAmountIn; 
    }

    public double fixedPMT() {
        // M = P [ i(1 + i)^n ] / [ (1 + i)^n – 1]. 
        double power = Math.pow((1+this.r),this.n);
        double res = (this.totalLoanAmount * this.r * power)/(power-1D);
        this.PMT = Double.parseDouble(formatter.format(res));
        return this.PMT;
    }

};
