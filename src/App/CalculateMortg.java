package App;

import java.util.Scanner;
import java.text.DecimalFormat;

public class CalculateMortg {

    DecimalFormat formatter = new DecimalFormat("#.##");
    private int term = 0;
    private double PMT = 0F;// the total monthly mortgage payment
    private double r = 0F;// fixed yearly interest rate
    private double totalLoanAmount = 0F; // total loan amount
    private String[] variableString = { "Loan amount[€]", "Interest Rate [%]", "Term period [years]" };

    // constants
    final double perMonth = 12F * 100F;
    final float classTreshold = 100_000F;
    final float minLoan = 1000;
    final float maxLoan = 1_000_000F;
    Scanner scan;

    public CalculateMortg(Scanner scan) {
        this.scan = scan;
        setParameters();
    }

    public void setParameters() {
        int i = 0;
        float[] copyArray = new float[3];
        for (String outString : this.variableString) {
            copyArray[i] = this.testInputstring(outString, scan, i);
            i++;
        }
        this.totalLoanAmount = copyArray[0];
        this.r = copyArray[1] / perMonth;
        this.term = (int) copyArray[2] * 12;
    }

    public int getTerm() {
        return this.term;
    }

    public double getTotalLoanAmount() {
        return this.totalLoanAmount;
    }

    public double getr() {
        return this.r;
    }

    public double getPMT() {
        return this.PMT;
    }

    // check user input type
    public float testInputstring(String field, Scanner scan, int i) {

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
                } else if (i == 0 && (inputFl < minLoan) || (inputFl > maxLoan)) {
                    System.out.println("Total Amount has to be in range of 1000-1 Mio €.");
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

        // M = P [ r(1 + r)^n ] / [ (1 + r)^n – 1].
        double power = Math.pow((1 + this.r), this.term);
        double res = (this.totalLoanAmount * this.r * power) / (power - 1D);
        this.PMT = Double.parseDouble(formatter.format(res));
        return this.PMT;
    }

    public double roundNumber(double numberin) {
        return (Math.round(numberin * 100.0)) / 100.0;
    }

    // Formula totalAmount *[(1+r)^term-(1-r)^umber_of_payments_made])/(1+r)^term-1]
    public double restBalancePerMonth(int i) {
        double power = Math.pow((1 + this.r), this.term);
        double powerDecrement = Math.pow((1 + this.r), i);
        double result = this.totalLoanAmount * ((power - powerDecrement) / (power - 1));
        return result;
    }

    public void balancePlan() {
        for (int i = 0; i < this.term; i++) {
            double result = roundNumber(restBalancePerMonth(i));
            System.out.println(result + " €");
        }
    }

    public void seePaymentSchedule() {
        String response;
        System.out.println("Do you want to see the Payment Schedule for " + this.term + " months ?");
        
        while (true) {
            System.out.print("type yes :");
            System.out.println("");
            response = this.scan.nextLine();
            if (response.matches("yes")) {
                balancePlan();
                break;
            } else {
                System.out.println("ok");
                break;
            }
        }
    }

    public void paymentSchedule() {
        System.out.println("");
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Monthly payment is:" + fixedPMT() + "€");
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("-------");
        // get monthly payment
        seePaymentSchedule();

    }
};
