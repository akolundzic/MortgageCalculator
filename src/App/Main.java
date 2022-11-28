package App;

import java.util.Scanner;
import java.io.InputStreamReader;

public class Main {
    // Main method
    public static void main(String[] args) {

        InputStreamReader rdr = new InputStreamReader(System.in);
        Scanner scan = new Scanner(rdr);
        CalculateMortg calc = new CalculateMortg(scan);
        // calc.paymentSchedule();
        calc.paymentSchedule();
        scan.close();
    }
}
