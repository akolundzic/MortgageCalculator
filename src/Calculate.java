
public class Calculate {

    // instance variables
    final float perMonth = 1200F;
    int n;
    float PMT;
    float r;// (interest rate per year divided by 100 divided by 12)is in percentage
    float mortgateAmount; // mortgage amount,
    // constructor to instantiate

    public Calculate(int fixdedMortgageIn, float interestRateIN, float mortgateAmountIn) {
        this.n = fixdedMortgageIn * 12; // Multiply the number of years in your loan term by 12
        this.PMT = 0.0F;// the total monthly mortgage payment
        this.r = interestRateIN / (perMonth);
        this.mortgateAmount = mortgateAmountIn; // the principal loan amount
    }

    // Calculate mortgage amount PMT
    public double fixdedMortgagelyPMT() {

        double xn = 2;
        double n = 2;
        // returns 5 power of 4 i.e. 5*5*5*5
        double res = Math.pow(xn - 1, n);
        return res;
    }

};
