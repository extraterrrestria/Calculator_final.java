import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println(" __ __ __ __ __ __ __ __ __ __ __ __ __ __ __\n" + "|---------------------------------- \n" + "|Welcome to Fraction Stack Calculator! \n"
                + "|----------------------------------");
        System.out.println("|Following operations are supported : \n" + "|1. Addition (+) \n" + "|2. Subtraction (-) \n"
                + "|3. Multiplication (*) \n" + "|4. Division (:) \n" + "|You can use brackets ( & ) \n" + "|");
        System.out.println("| Please enter the expression dividing each token with spaces  \n" + "| Example:         4/2 + 3/5 * ( 7/8 + 3/4 ) \n" + "|__ __ __ __ __ __ __ __ __ __ __ __ __ __ __\n");
        Scanner in = new Scanner(System.in);

        boolean userWantsToQuit = false;
        while (!userWantsToQuit) {
            try {
                String input = in.nextLine();
                if (input.equals("quit")) {
                    System.out.print("Thanks for using Fraction Stack Calculator. Have a nice day!");
                    userWantsToQuit = true;
                } else {
                    System.out.println("Result: " + Calculator.solve(input));
                }
            } catch (NumberFormatException e) {
                System.err.println("ERROR -> illegal expression");
            } catch (Fraction.ZeroDenominatorException ze){
                System.err.println(ze.getMessage());
            }
        }
    }
}

