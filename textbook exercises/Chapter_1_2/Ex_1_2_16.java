
public class Ex_1_2_16 {
    public static class Rational {
        private long numerator;
        private long denominator;

        public Rational(long numerator, long denominator) {
            if (denominator == 0) {
                throw new IllegalArgumentException("Denominator cannot be zero.");
            }
            // simplify the fraction
            long gcd = gcd(numerator, denominator);
            this.numerator = numerator / gcd;
            this.denominator = denominator / gcd;

        }

        // compute the greatest common divisor using Euclid's algorithm
        private static long gcd(long a, long b) {
            if (b == 0)
                return a;
            long r = a % b;
            return gcd(b, r);
        }

        // sum of this number and b
        public Rational plus(Rational b) {
            // x1/y1 + x2/y2 = (x1*y2 + x2*y1) / y1*y2
            long newDenominator = this.denominator * b.denominator;
            long newNumerator = this.numerator * b.denominator + b.numerator * this.denominator;
            Rational sum = new Rational(newNumerator, newDenominator);
            return sum;
        }

        // difference of this number and b
        public Rational minus(Rational b) {
            // x1/y2 - x2/y2 = (x1*y2 - x2*y1) / y1*y2
            long newDenominator = this.denominator * b.denominator;
            long newNumerator = this.numerator * b.denominator - b.numerator * this.denominator;
            Rational diff = new Rational(newNumerator, newDenominator);
            return diff;
        }

        // product of this number and b
        public Rational times(Rational b) {
            // x1/y1 * x2/y2 = x1*x2 / y1*y2
            long newDenominator = this.denominator * b.denominator;
            long newNumerator = this.numerator * b.numerator;
            Rational product = new Rational(newNumerator, newDenominator);
            return product;

        }

        // quotient of this number and b
        public Rational divides(Rational b) {
            // x1/y1 / x2/y2 = x1/y1 * y2/x2 = x1*y2 / y1*x2
            if (b.numerator == 0) {
                throw new IllegalArgumentException("Division by zero.");
            }
            long newDenominator = this.denominator * b.numerator;
            long newNumerator = this.numerator * b.denominator;
            Rational quotient = new Rational(newNumerator, newDenominator);
            return quotient;
        }

        // is this number equal to that
        public boolean equals(Rational other) {
            if (other == this)
                return true;
            if (other == null)
                return false;
            if (other.getClass() != this.getClass())
                return false;
            Rational that = (Rational) other;
            return that.denominator == this.denominator &&
                    that.numerator == this.numerator;
        }

        // string representation
        public String toString() {
            if (denominator == 1)
                return Long.toString(numerator);
            return numerator + "/" + denominator;
        }

    }

    // Test client
    public static void main(String[] args) {
        Rational r1 = new Rational(1, 2);
        Rational r2 = new Rational(2, 3);
        System.out.println("r1 = " + r1);
        System.out.println("r2 = " + r2);
        System.out.println("r1 + r2 = " + r1.plus(r2)); // 1/2 + 2/3 = 3/6 + 4/6 = 7/6
        System.out.println("r1 - r2 = " + r1.minus(r2)); // 3/6 - 4/6 = 1/-6
        System.out.println("r1 * r2 = " + r1.times(r2)); // 1/2 * 2/3 = 2/6 = 1/3
        System.out.println("r1 / r2 = " + r1.divides(r2)); // 1/2 / 2/3 = 1/2 * 3/2 = 3/4
        System.out.println("r1 equals r2? " + r1.equals(r2)); // 1/2 != 2/3
    }
}
