import java.util.Scanner;
import java.io.InputStreamReader;

public class Main {
    public static float testInputstring(String field, Scanner scan) {
        
        System.out.print(field+":");
        String input; 
        boolean check = true;
        Float inputFl = 0F;
        while (check) {
            input = scan.nextLine();
            if (input.isEmpty()) {
                System.out.println(field+" cannot be empty:");
                System.out.print(field+":");
                check = true;
            }
            else if (input.matches("((-|\\+)?[0-9]+(\\.[0-9]+)?)+")) {
                inputFl = Float.parseFloat(input);
                if (inputFl <= 0.0 ) {
                System.out.println(field+" cannot be negative or zero ");
                System.out.print(field+":");
                }
                else{
                    check = false;
                }
            }
            else{
                System.out.println(field+" must be a number ");
                System.out.print(field+":");
            }
        }
       
        return inputFl;
    }
    //Main method
    public static void main(String[] args) {

        InputStreamReader rdr = new InputStreamReader(System.in);
        Scanner scan = new Scanner(rdr);
        float totalLoanAmountIn =testInputstring("Loan amount[€]",scan);
        float interestRateIN =testInputstring("Interest Rate [%]",scan);
        float termFl =testInputstring("Term period [years]",scan);
        int termIn =(int) termFl;
        Calculate obj = new Calculate(termIn, interestRateIN,totalLoanAmountIn);
        System.out.println("Your monthly mortgage payment is :"+obj.fixedPMT()+" €");

        scan.close();
    }
}
