package App;

import java.util.Scanner;

public class TestInput {

    Scanner scan;

    public TestInput(Scanner scan) {
        this.scan = scan;
    }

    public double testInputstring(String field, double minValue, double maxValue) {

        System.out.print(field + ":");
        String input;
        boolean check = true;
        double inputUser = 0D;

        while (check) {
            input = this.scan.nextLine();
            if (input.matches("((-|\\+)?[0-9]+(\\.[0-9]+)?)+")) {
                inputUser = Double.parseDouble(input);
                if (inputUser <= 0.0) {
                    System.out.println(field + " cannot be negative or zero");
                    System.out.print(field + ":");
                } else if ((inputUser < minValue) || (inputUser > maxValue)) {
                    System.out.println("Total Amount has to be in range of " + minValue + "-" + maxValue + ".");
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
        return inputUser;
    }

    public boolean aksUserWhatToPrint(String userQuestion) {
        boolean answer = false;
        System.out.println(userQuestion);
        System.out.print("type yes : ");

        System.out.print("");
        String response = scan.nextLine();
        if (response.matches("yes")) {
            answer = true;
        }
        return answer;
    }
};
