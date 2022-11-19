import java.util.Scanner;
import java.io.InputStreamReader;

public class Main {
    // Main method
    public static void main(String[] args) {

        InputStreamReader rdr = new InputStreamReader(System.in);
        Scanner scan = new Scanner(rdr);
        Calculate obj = new Calculate(scan);
        System.out.println("Your monthly mortgage payment is:"+obj.fixedPMT()+"€.");
        scan.close();
    }
}
