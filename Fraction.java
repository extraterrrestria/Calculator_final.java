public class Fraction {
    private int numerator;
    private int denominator;

    int getNum() {
        return numerator;
    }

    int getDen() {
        return denominator;
    }

    public Fraction(int numerator, int denominator) throws ZeroDenominatorException {

        if (denominator == 0) {
            throw new ZeroDenominatorException();
        } else {
            this.numerator = numerator;
            this.denominator = denominator;
        }
    }

    public Fraction(int numerator) {
        this.numerator = numerator;
        this.denominator = 1;
    }

    public Fraction() {
        this.numerator = 1;
        this.denominator = 1;
    }

    public static Fraction addition(Fraction f1, Fraction f2) {
        Fraction f3;
        if (f1.getDen() == f2.getDen()) {
            f3 = new Fraction(f1.getNum() + f2.getNum(), f1.getDen());
        } else {
            f3 = new Fraction(f1.getNum() * f2.getDen() + f2.getNum() * f1.getDen(), f1.getDen() * f2.getDen());
        }
        reducer(f3);
        return f3;
    }


    public Fraction add(Fraction f) {
        Fraction res = new Fraction(this.numerator * f.getDen() + f.getNum() * this.denominator, this.denominator * f.getDen());
        reducer(res);
        return res;
    }


    public static Fraction subtraction(Fraction f1, Fraction f2) {
        Fraction f3;
        if (f1.getDen() == f2.getDen()) {
            f3 = new Fraction(f1.getNum() - f2.getNum(), f1.getDen());
        } else {
            f3 = new Fraction(f1.getNum() * f2.getDen() - f2.getNum() * f1.getDen(), f1.getDen() * f2.getDen());
        }
        reducer(f3);
        return f3;
    }

    public Fraction subtract(Fraction f) {
        Fraction res = new Fraction(this.numerator * f.getDen() - f.getNum() * this.denominator, this.denominator * f.getDen());
        reducer(res);
        return res;
    }


    public static Fraction multiplication(Fraction f1, Fraction f2) {
        Fraction f3 = new Fraction(f1.getNum() * f2.getNum(), f1.getDen() * f2.getDen());
        reducer(f3);
        return f3;
    }

    public Fraction multiply(Fraction f) {
        Fraction res = new Fraction(this.numerator * f.getNum(), this.denominator * f.getDen());
        reducer(res);
        return res;
    }

    public static Fraction division(Fraction f1, Fraction f2) {
        Fraction f3 = new Fraction(f1.getNum() * f2.getDen(), f1.getDen() * f2.getNum());
        reducer(f3);
        return f3;
    }

    public Fraction divide(Fraction f) {
        Fraction res = new Fraction(this.numerator * f.getDen(), this.denominator * f.getNum());
        reducer(res);
        return res;
    }

    public static int gcd(int a, int b) { //Greatest Common Divisor
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }

    public static Fraction reducer(Fraction f) {
        int d = gcd(f.numerator, f.denominator);
        f.numerator = f.numerator / d;
        f.denominator = f.denominator / d;
        if (f.numerator > 0 && f.denominator < 0) {
            f.numerator = -f.numerator;
            f.denominator = -f.denominator;
        }
        if (f.numerator < 0 && f.denominator < 0) {
            f.numerator = Math.abs(f.numerator);
            f.denominator = Math.abs(f.denominator);
        }
        return f;
    }

    public String toString() {
        return this.numerator + "/" + this.denominator;
    }

    public class ZeroDenominatorException extends IllegalArgumentException {
        public static final String error = "ERROR -> denominator can't be zero";

        public ZeroDenominatorException() {
            super(error); // Call constructor of parent Exception
        }
    }
}


