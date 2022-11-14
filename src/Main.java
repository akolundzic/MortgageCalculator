import java.awt.*;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Scanner;
import java.io.InputStreamReader;
import java.io.Reader;



public class Main {
    
    // class definition
    final int Constant = 2;

    public static void main(String[] args) {
        // creating object of Class
        // creating object of Class

        Point point1 = new Point(1, 2);
        point1.x = 5;
        // System.out.println(point2);
        // String message = "Hello \"World!\"";// short cut for new String("Hello Word")
        // System.out.println(".\\directory\n");
        // System.out.println(message.replace("o", "a"));// for example users length
        // System.out.println(message.indexOf("H"));
        int[] numbers = { 1, 2, 5, 4 };
        // int[] numbers= new int[3];
        // numbers[0] = 1;
        // numbers[1]=2;
        Arrays.sort(numbers);
        // System.out.println(Arrays.toString(numbers));
        // multidim arrays
        // float[][] matrix = new float[2][4];
        float[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 } };
        // System.out.println(Arrays.deepToString(matrix));
        // arithmatic expressions
        float res = (float) 10 / (float) 3;
        // post and prefex
        int x = 1;
        int y = x++;// value is copied first into y and THAN incremented
        // System.out.println("but x =" + x + " and y =" + y);
        x = 1;
        y = ++x;// value is copied first into y and THAN incremented
        // System.out.println(" x =" + x + " and y =" + y);
        x = 1;
        x += 3;
        // System.out.println(x);
        // String xstring = "2";// parse to integer
        // Integer.parseInt(xstring);
        // System.out.println(xstring);
        // // casting
        // float zahl = (float) 10 / 2.5F;
        // System.out.println(zahl);
        // // math classe
        // System.out.println(Math.max(1, 1.9));
        // System.out.println((int) Math.round(Math.random() * 5));

        // System.out.println(NumberFormat.getPercentInstance().format(0.5));
        // user in and output
        // System.out.print("Name :");
        // Scanner scan = new Scanner(System.in);
        // String name = scan.nextLine().trim();
        // System.out.println(name);
        // NumberFormat percentagtest = NumberFormat.getPercentInstance();

        // scan.close();

        // https://www.bankrate.com/mortgages/mortgage-calculator/

        Calculate obj = new Calculate(12,5F,1200F);
        // System.

        InputStreamReader rdr = new InputStreamReader(System.in);
        Scanner scan = new Scanner(rdr);
        System.out.print(" mortgage amount:");
        String input = scan.nextLine();
        System.out.print(input);
        obj.testInputstring(input,scan);
       
        scan.close();
       

    }

}
