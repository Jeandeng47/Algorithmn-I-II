import edu.princeton.cs.algs4.StdOut;

public class Ex_1_2_13 {
    public static class Transaction {
        private String who;
        private SmartDate when;
        private double amount;

        public Transaction(String who, SmartDate when, double amount) {
            if (who == null || who.isEmpty()) {
                throw new IllegalArgumentException("Name could not be null or empty");
            }
            if (amount < 0) {
                throw new IllegalArgumentException("Amount must be a non-negative number");
            }
            this.who = who;
            this.when = when;
            this.amount = amount;
        }

        public String who() {
            return this.who;
        }

        public SmartDate when() {
            return this.when;
        }

        public double amount() {
            return this.amount;
        }

        public String toString() {
            return String.format("Transaction: [ who: %s, when: %s, amount: %.2f]",
                    who(), when().toString(), amount());
        }

    }

    public static class SmartDate {
        private final int month;
        private final int day;
        private final int year;

        private boolean isValidDate(int m, int d, int y) {
            if (m < 1 || m > 12)
                return false;
            if (d < 1)
                return false;

            int[] daysInMonth = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
            if (isLeapYear(y))
                daysInMonth[2] = 29;

            int dayMax = daysInMonth[m];
            return d <= dayMax;
        }

        private boolean isLeapYear(int y) {
            // case 1: divisible by 4 but non-divisible by 100
            // case 2: divisible by 100
            if ((y % 4 == 0) && (y % 100 != 0)
                    || (y % 400 == 0)) {
                return true;
            }
            return false;
        }

        public String dayOfWeek(int month, int day, int year) {
            int m = (month < 3) ? month + 12 : month;
            int y = (month < 3) ? year - 1 : year;
            int q = day;
            int k = y % 100; // year of the century
            int j = y / 100; // zero-based century
            int h = (q + (13 * (m + 1) / 5) + k + (k / 4) + (j / 4) + (5 * j)) % 7;
            String[] days = { "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" };
            return days[h];
        }

        public SmartDate(int m, int d, int y) {
            if (!isValidDate(m, d, y)) {
                throw new IllegalArgumentException("Invalid date: " + m + "/" + d + "/" + y);
            }
            this.month = m;
            this.day = d;
            this.year = y;
        }

        public int month() {
            return this.month;
        }

        public int day() {
            return this.day;
        }

        public int year() {
            return this.year;
        }

        public String toString() {
            return month() + "/" + day() + "/" + year();
        }

        public boolean equals(Object x) {
            if (this == x)
                return true;
            if (x == null)
                return false;
            if (this.getClass() != x.getClass())
                return false;
            SmartDate that = (SmartDate) x;
            if (this.month == that.month &&
                    this.day == that.day &&
                    this.year == that.year) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        SmartDate date = new SmartDate(4, 1, 2021);
        Transaction transaction = new Transaction("Alice", date, 999.0);
        StdOut.println(transaction);
    }
}
