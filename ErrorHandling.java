package librarymanagementsystem;

import java.util.*;

public class ErrorHandling {
    public int validateIntegerInput(int val, String msg, Scanner sc) {
        while (true) {
            try {
                System.out.println(msg);
                val = sc.nextInt();
                sc.nextLine();
                if (val < 0 || val > 100) {
                    System.out.println("Input is out of range. Please enter a number between 1 and 100.");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                sc.nextLine();
            }
        }
        return val;
    }

    public String validateStringInput(String val, String msg, Scanner sc) {
        while (true) {
            System.out.println(msg);
            val = sc.nextLine().trim();

            if (val.isEmpty()) {
                System.out.println("Input cannot be empty. Please enter a valid input.");
                continue;
            }

            if (!val.matches("^[A-Za-z ]+$")) {
                System.out.println("Invalid input. Please use alphabets only (no numbers or special characters).");
                continue;
            }

            break;
        }
        return val;
    }
}