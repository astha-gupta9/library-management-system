package librarymanagementsystem;

import java.util.*;

public class ErrorHandling {
    public int validateMenuChoice(int val, String msg, Scanner sc) {
        while (true) {
            try {
                System.out.print(msg + " ");
                String input = sc.nextLine();
                val = Integer.parseInt(input);
                if (val < 0 || val > 9) {
                    System.out.println("Input choice. Please choose an option between 0 and 9.");
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

    public int validateID(int val, String msg, Scanner sc) {
        while (true) {
            try {
                System.out.print(msg + " ");
                String input = sc.nextLine();
                val = Integer.parseInt(input);
                if (val < 100 || val > 1000) {
                    System.out.println("Input is out of range. Please enter a ID between 100 and 1000.");
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

    public int validateIntegerInput(int val, String msg, Scanner sc) {
        while (true) {
            try {
                System.out.print(msg + " ");
                String input = sc.nextLine();
                val = Integer.parseInt(input);
                if (val < 0 || val > 100) {
                    System.out.println("Input is out of range. Please enter a number between 0 and 100.");
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
            System.out.print(msg + " ");
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