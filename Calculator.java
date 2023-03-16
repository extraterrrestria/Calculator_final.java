import java.util.Stack;

class Calculator {

    static Stack<Fraction> numberStack = new Stack<>(); // creating a stack which stores fractions
    static Stack<String> operatorStack = new Stack<>(); // creating a stack with operators


    private static int priority(String op) {
        int pr = 0;
        switch (op) {
            case ("+"):
            case ("-"): {
                pr = 2;
                break;
            }
            case ("*"):
            case (":"): {
                pr = 3;
                break;
            }
            case ("("): {
                pr = 1;
                break;
            }
            case (")"): {
                pr = -1;
                break;
            }
        }
        return pr;
    }

    /*  check if element is fraction*/
    public static boolean isFraction(String element) throws Fraction.ZeroDenominatorException {
        String[] num_den = element.split("/");
        Fraction f = new Fraction(Integer.parseInt(num_den[0]), Integer.parseInt(num_den[1]));
        return true;
    }

    /*  convert element from string to fraction to make calculations possible*/
    public static Fraction toFraction(String element) throws Fraction.ZeroDenominatorException {
        String[] num_den = element.split("/");
        return new Fraction(Integer.parseInt(num_den[0]), Integer.parseInt(num_den[1]));
    }

    /*  check if element is operator*/
    public static boolean isOperator(String element) {
        return element.equals("+") || element.equals("-") || element.equals("*") || element.equals(":");
    }

    /* performs calculations according to the operator, when needed, uses last operator and two last fractions */
    private static void calculate() {

        String operator = operatorStack.pop();
        Fraction f2 = numberStack.pop();
        Fraction f1 = numberStack.pop();

        switch (operator) {
            case "+":
                numberStack.push(Fraction.addition(f1, f2));
                break;
            case "-":
                numberStack.push(Fraction.subtraction(f1, f2));
                break;
            case "*":
                numberStack.push(Fraction.multiplication(f1, f2));
                break;
            case ":":
                numberStack.push(Fraction.division(f1, f2));
                break;
        }
    }


    public static String solve(String expression) {
        String[] elements = expression.split(" ");

        for (String element : elements) { //for (int i = 0;  i < elements.length; i++)
            if (priority(element) == 1) {
                operatorStack.push(element);
            } else if (priority(element) == -1) {
                while (!(priority(operatorStack.peek()) == 1)) {
                    calculate();
                }
                operatorStack.pop(); // get rid of "(" in stack
            } else if (isOperator(element)) {
                if (operatorStack.isEmpty()) {
                    operatorStack.push(element);
                } else {
                    if (priority(operatorStack.peek()) < priority(element)) {
                        operatorStack.push(element);
                    } else {
                        calculate();
                        operatorStack.push(element);
                    }
                }
            } else if (isFraction(element)) {
                numberStack.push(toFraction(element));
            }
        }
        if (numberStack.size() == 1 && operatorStack.isEmpty()){
            numberStack.push(Fraction.reducer(numberStack.pop()));
        }

        while (!(numberStack.size() == 1)) {
            calculate();
        }
        return numberStack.pop().toString();
    }
}

