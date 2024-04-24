import edu.princeton.cs.algs4.StdOut;

public class Ex_1_2_17 {
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
            assert canAdd(this.numerator, b.denominator) && canAdd(b.numerator, this.denominator)
                    : "Addition would overflow";
            // x1/y1 + x2/y2 = (x1*y2 + x2*y1) / y1*y2
            long newDenominator = this.denominator * b.denominator;
            long newNumerator = this.numerator * b.denominator + b.numerator * this.denominator;
            Rational sum = new Rational(newNumerator, newDenominator);
            return sum;
        }

        // difference of this number and b
        public Rational minus(Rational b) {
            assert canAdd(this.numerator, b.denominator) && canAdd(b.numerator, this.denominator)
                    : "Subtraction would overflow";
            // x1/y2 - x2/y2 = (x1*y2 - x2*y1) / y1*y2
            long newDenominator = this.denominator * b.denominator;
            long newNumerator = this.numerator * b.denominator - b.numerator * this.denominator;
            Rational diff = new Rational(newNumerator, newDenominator);
            return diff;
        }

        // product of this number and b
        public Rational times(Rational b) {
            assert canMultiply(this.numerator, b.numerator) && canMultiply(this.denominator, b.denominator)
                    : "Multiplication would overflow";
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
            assert canMultiply(this.numerator, b.denominator) && canMultiply(this.denominator, b.numerator)
                    : "Division would overflow";
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

        private static boolean canAdd(long x, long y) {
            long sum = x + y;
            return ((x ^ sum) & (y ^ sum)) >= 0;
        }

        private static boolean canMultiply(long x, long y) {
            if (x == 0 || y == 0)
                return true;
            if (x == Long.MIN_VALUE || y == Long.MIN_VALUE) {
                // Special case where multiplication could overflow despite checks
                return false;
            }
            long product = x * y;
            return (product / y == x) && (product / x == y);
        }

    }

    public static void main(String[] args) {
        // Test overflow conditions
        // Usage: java -ea Ex_1_2_17
        try {
            Rational overflowTest = new Rational(Long.MAX_VALUE, 1).times(new Rational(2, 1));
            StdOut.println("Overflow test result: " + overflowTest);
        } catch (ArithmeticException e) {
            StdOut.println("Caught overflow during multiplication: " + e.getMessage());
        }
    }
}
