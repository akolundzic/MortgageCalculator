import java.awt.*;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Scanner;
import java.io.InputStreamReader;





public class Main {
    public static String testInputstring(String field, Scanner scan) {
        
        System.out.print(field+":");
        String input = scan.nextLine();
       
        while (input.isEmpty()) {
            System.out.print(field + " cannot be empty :");
            input = scan.nextLine();
            // System.out.println(input.isEmpty());
        }
        return input;
    }
    // class definition
    final int Constant = 2;

    public static void main(String[] args) {

        InputStreamReader rdr = new InputStreamReader(System.in);
        Scanner scan = new Scanner(rdr);
        
        double totalLoanAmountIn =Double.parseDouble(testInputstring("Loan amount[€]",scan));
        double interestRateIN =Double.parseDouble(testInputstring("Interest Rate [%]",scan));
        int termIn =Integer.parseInt(testInputstring("Term period [years]",scan));
        Calculate obj = new Calculate(termIn, interestRateIN,totalLoanAmountIn);
        System.out.println(obj.fixedPMT());

        scan.close();

    }

}
