
import java.util.Scanner;
import java.text.DecimalFormat;

//calculation of the mortgage
//formula:totalLoanAmountIn*[ r(1 + r)^n ] / [ (1 + r)^n – 1]

public class Calculate {
    DecimalFormat formatter = new DecimalFormat("#.##");
    // instance variables
    final double perMonth = 12F * 100F;
    final float classTreshold = 100_000F;
    final float minLoan = 1000;
    final float maxLoan = 1_000_000F;

    Scanner scan;
    String classStatus; // economy or first
    String[] variableString = { "Loan amount[€]", "Interest Rate [%]", "Term period [years]" };
    float[] keyVal = new float[3];
    int n = 1;// term in months
    double PMT = 0F;// the total monthly mortgage payment
    double r = 0F;// fixed yearly interest rate
    double totalLoanAmount = 0F; // total loan amount
    boolean elligbile;

    // constructor

    public Calculate(int termIn, double interestRateIN, double totalLoanAmountIn) {
        this.n = termIn * 12; // Multiply the number of years in your loan term by 12
        this.PMT = 0.0D;
        this.r = interestRateIN / perMonth;// r[%] -> absolute monthly rate r/(100*12)
        this.totalLoanAmount = totalLoanAmountIn;
    }

    // 2. constructor
    public Calculate(Scanner scan) {
        int i = 0;
        for (String outString : variableString) {
            keyVal[i] = this.testInputstring(outString, scan);
            i++;
        }
        this.totalLoanAmount = keyVal[0];
        this.r = keyVal[1] / perMonth;
        this.n = (int) keyVal[2] * 12;
        this.elligbile= this.totalLoanAmount > minLoan ? true:false;
    }

    // which category: first or economy?
    public String getClassStatus() {
        this.classStatus = totalLoanAmount > this.classTreshold ? "First" : "Economy";
        return this.classStatus;
    }

    // check user input type
    public float testInputstring(String field, Scanner scan) {

        System.out.print(field + ":");
        String input;
        boolean check = true;
        Float inputFl = 0F;
        while (check) {
            input = scan.nextLine();
            if (input.matches("((-|\\+)?[0-9]+(\\.[0-9]+)?)+")) {
                inputFl = Float.parseFloat(input);
                if (inputFl <= 0.0) {
                    System.out.println(field + " cannot be negative or zero");
                    System.out.print(field + ":");
                } else {
                    check = false;
                }
            } else if (input.isEmpty()) {
                System.out.println(field + " cannot be empty");
                System.out.print(field + ":");
                check = true;
            } else {
                System.out.println(field + " must be a number ");
                System.out.print(field + ":");
            }
        }
        return inputFl;
    }

    // calculate mortgage
    public double fixedPMT() {
       
        // M = P [ i(1 + i)^n ] / [ (1 + i)^n – 1].
        double power = Math.pow((1 + this.r), this.n);
        double res = (this.totalLoanAmount * this.r * power) / (power - 1D);
        this.PMT = Double.parseDouble(formatter.format(res));
        return this.PMT;
       
    }

};
