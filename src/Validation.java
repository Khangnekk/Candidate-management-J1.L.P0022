
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author zed25
 */
public class Validation {

    public static int checkInt(String msg, int min, int max) {
        Scanner sc = new Scanner(System.in);
        String input;
        double output;
        // Loop use to until output in corect format
        while (true) {
            System.out.print(msg);
            input = sc.nextLine();
            // Check the existence of Input
            if (input.isEmpty()) {
                System.out.println("Input could not be Empty. Please enter positive integer");
                continue;
            }
            try {
                output = Double.parseDouble(input);
                // compare value of input with output
                if ((int) output != output) {
                    throw new Error();
                }
                // Compare output less than min or output greater than max
                if (output < min || output > max) {
                    System.out.println("Please enter in range " + min + " to " + max);
                    continue;
                }
                break;
            } catch (NumberFormatException exception) {
                System.out.println("Input could not be a string. Please enter positive integer");
            } catch (Error RealNum) {
                System.out.println("Input could not be a real number. Please enter positive integer");
            }
        }
        return (int) output;
    }

    public static Date enterDate(String msg, String err) {
        Scanner sc = new Scanner(System.in);
        int yearCurrent = Calendar.getInstance().get(Calendar.YEAR);
        int monthCurrent = Calendar.getInstance().get(Calendar.MONTH);
        int dayCurrent = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        String input;
        Date date;
        SimpleDateFormat sdm = new SimpleDateFormat("dd/MM/yyyy");
        while (true) {
            System.out.print(msg);
            input = sc.nextLine();
            if (input.isEmpty()) {
                System.err.println("Date could not be empty.");
                continue;
            }
            try {
                date = sdm.parse(input);
                if (!input.equals(sdm.format(date))) {
                    throw new Exception();
                }
                int thisYear = Integer.parseInt(input.substring(6));
                int thisMonth = Integer.parseInt(input.substring(3,5));
                int thisDay = Integer.parseInt(input.substring(0,2));
                if ((thisYear==yearCurrent && thisMonth==monthCurrent && thisDay > dayCurrent)
                        ||(thisYear==yearCurrent && thisMonth>monthCurrent)
                        || (thisYear>yearCurrent)){
                    System.out.println(err);
                    continue;
                }
                break;
            } catch (Exception e) {
                System.err.println("Date to correct format(dd/mm/yyyy)");
            }
        }

        return date;
    }

    public static boolean checkYesNo(String msg) {
        Scanner sc = new Scanner(System.in);
        String input;
        System.out.println(msg);
        input = sc.nextLine();
        // Loop until user enter correct 'y' or 'n'
        while (true) {
            // Condition use to check input is empty
            if (input.isEmpty()) {
                System.out.println("Input could not be empty");
            } else {
                // Condition use to check input equals 'Y' or 'y'
                switch (input) {
                    case "Y":
                    case "y":
                        return true;
                    case "N":
                    case "n":
                        return false;
                    default:
                        System.out.println("Please enter Yes(Y) or No(N)");
                        break;
                }
            }
        }
    }

    public static String checkInputString() {
        Scanner sc = new Scanner(System.in);
        //loop until user input correct
        while (true) {
            String result = sc.nextLine().trim();
            // Condition use to check input is empty
            if (result.isEmpty()) {
                System.err.println("Not empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }

    public static String checkInputPhone() {
        /*
        \\d{10} user must be input 10 number
        \\d* user can input more number or not
         */
        String PHONE_VALID = "^\\d{10}\\d*$";
        while (true) {
            String result = checkInputString();
            //check user input phone valid
            if (result.matches(PHONE_VALID)) {
                return result;
            } else {
                System.err.println("Phone is number with minimum 10 characters");
                System.out.print("Enter again: ");
            }
        }
    }

    public static String checkInputEmail() {
        /*
        [A-Za-z0-9.-+%]+ user must be input from a-z ignore case,0-9 and .-+% least one times
        @ user must be input "@"
        [A-Za-z.-]+ user mustbe input from a-z ignore case, "." "-" least one times
        \\. user must be input "."
        [A-Za-z]{2,4} user must be input from a-z ignore 2 - 4 times
         */
        String EMAIL_VALID = "^[A-Za-z0-9.+-_%]+@[A-Za-z.-]+\\.[A-Za-z]{2,4}$";
        //loop until user input correct
        while (true) {
            String result = checkInputString();
            //check user input email valid
            if (result.matches(EMAIL_VALID)) {
                return result;
            } else {
                System.err.println("Email with format <account name>@<domain>");
                System.out.print("Enter again: ");
            }
        }
    }

    public static String checkInputGraduationRank() {
        while (true) {
            String result = checkInputString();
            if (result.equalsIgnoreCase("Excellence")
                    || result.equalsIgnoreCase("Good")
                    || result.equalsIgnoreCase("Fair")
                    || result.equalsIgnoreCase("Poor")) {
                return result;
            } else {
                System.err.println("Please input string: Excellence, Good, Fair, Poor");
                System.out.print("Enter again: ");
            }
        }
    }

    public static boolean checkIdExist(ArrayList<Candidate> candidates, String id) {
        for (Candidate candidate : candidates) {
            if (candidate.getId().equalsIgnoreCase(id)) {
                System.err.println("Id exist.");
                return false;
            }
        }
        return true;
    }

    public static int checkInputExprience(int birthDate) {
        int yearCurrent = Calendar.getInstance().get(Calendar.YEAR);
        int age = yearCurrent - birthDate;
        while (true) {
            int yearExperience = checkInt("Enter year experience: ", 1, 100);
            if (yearExperience > age) {
                System.err.println("Experience must be smaller than age");
            } else {
                return yearExperience;
            }
        }

    }

}
