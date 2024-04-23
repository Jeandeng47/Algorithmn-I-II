
public class Ex_1_2_12 {
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
        try {
            SmartDate date = new SmartDate(3, 15, 2020); // A known Sunday
            System.out.println("Date created: " + date);
            System.out.println("Day of the week: " + date.dayOfWeek(date.month(), date.day(), date.year()));
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

    }
}