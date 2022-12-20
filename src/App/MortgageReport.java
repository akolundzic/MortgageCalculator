package App;

public class MortgageReport {

    private CalculateMortg calculator;

    public MortgageReport(CalculateMortg calculator) {

        this.calculator = calculator;
    }

    // Print the dynamic balanceplan for the whole term in months
    private void balancePlan() {
        for (int i = 0; i < calculator.getTerm(); i++) {
            double result = calculator.roundNumber(calculator.restBalancePerMonth(i));
            System.out.println(result + " €");
        }
    }

    private void seePaymentSchedule(boolean userAnswer) {

        if (userAnswer) {
            System.out.println("-----------------------");
            System.out.println("PAYMENT SCHEDULE");
            System.out.println("-----------------------");
            balancePlan();
        }
    }

    public void paymentSchedule(boolean userAnswer) {

        System.out.println("");
        System.out.println("MORTGAGE");
        System.out.println("------------------------");
        System.out.println("Monthly payment is: " + calculator.fixedPMT() + "€");
        System.out.println();
        seePaymentSchedule(userAnswer);
    }
};
