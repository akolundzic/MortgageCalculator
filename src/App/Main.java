package App;

import java.util.Scanner;
import java.io.InputStreamReader;

public class Main {
    // Main method
    public static void main(String[] args) {

        InputStreamReader rdr = new InputStreamReader(System.in);
        Scanner scan = new Scanner(rdr);
        var inputuser = new TestInput(scan);
        
        String[] field = { "Total loan amount [€]", "Interest Rate [%]", "Term period [years]" };
        double[] minVal = {1000, 0.5, 1};
        double[] maxVal = {1_000_000, 5, 35};
        //get user input parameters
        double loanAmount_Userinput =inputuser.testInputstring(field[0],minVal[0],maxVal[0]);
        double interestRate_Userinput =inputuser.testInputstring(field[1],minVal[1],maxVal[1]);
        int term_Userinput = (int)inputuser.testInputstring(field[2],minVal[2],maxVal[2]);
         
        
        var calc = new CalculateMortg(loanAmount_Userinput,interestRate_Userinput,term_Userinput);
        String userQuestion = "Do you want to see the Payment Schedule for " + calc.getTerm() + " months ?";
        boolean userAnwer = inputuser.aksUserWhatToPrint(userQuestion);
    
        var report = new MortgageReport(calc);//print mortgage report
        
        report.paymentSchedule(userAnwer);
        scan.close();
    }
}
