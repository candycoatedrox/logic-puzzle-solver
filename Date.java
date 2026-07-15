public class Date {
    
    private int month;
    private int day;
    private boolean leapYear;

    // --- CONSTRUCTOR ---

    public Date(int month, int day, boolean leapYear) {
        if (month < 0 || day < 0) throw new IllegalArgumentException("Day and month must be positive");

        this.month = month;
        this.day = day;
        this.leapYear = leapYear;

        checkOverflow();
    }

    public Date(int month, int day) {
        this(month, day, false);
    }

    public Date(double value, boolean leapYear) {
        if (value < 0) throw new IllegalArgumentException("Date must have a positive value");

        month = (int)value;
        day = daysFromDouble(value, leapYear);
        this.leapYear = leapYear;

        checkOverflow();
    }

    public Date(double value) {
        this(value, false);
    }

    // --- GETTERS & SETTERS ---

    private void checkOverflow() {
        if (month > 12) {
            month %= 12;
            if (month == 0) month = 12;
        }

        int daysInMonth = daysInMonth(month, leapYear);
        if (day > daysInMonth) {
            month++;
            day -= daysInMonth;
            checkOverflow();
        }
    }

    public int getMonth() {
        return month;
    }

    public String getMonthName() {
        return nameOfMonth(month);
    }

    public int getDay() {
        return day;
    }

    public boolean isLeapYear() {
        return leapYear;
    }

    public int getTotalDays() {
        int days = day;
        for (int i = 1; i < month; i++) {
            days += daysInMonth(i, leapYear);
        }
        return days;
    }

    public double getDoubleValue() {
        return month + (day / (double)daysInMonth(month, leapYear));
    }

    // --- ARITHMETIC ---

    public Date add(Date other) {
        return new Date(month + other.month, day + other.day, leapYear || other.leapYear);
    }

    public Date add(double other) {
        return new Date(month + (int)other, day + daysFromDouble(other, leapYear));
    }

    public Date add(int months, int days) {
        return new Date(month + months, day + days);
    }

    public Date add(int days) {
        return add(0, days);
    }

    public void addToThis(Date other) {
        month += other.month;
        day += other.day;
        checkOverflow();
    }

    public void addToThis(double other) {
        month += (int)other;
        day += daysFromDouble(other, leapYear);
        checkOverflow();
    }

    public void addToThis(int months, int days) {
        month += months;
        day += days;
        checkOverflow();
    }

    public void addToThis(int days) {
        addToThis(0, days);
    }

    // TODO: subtract, multiply, divide (by int)

    // --- MISC ---

    @Override
    public String toString() {
        return nameOfMonth(month) + " " + day;
    }

    // --- STATIC ---

    public static int daysInMonth(int month, boolean leapYear) {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12: return 31;

            case 4:
            case 6:
            case 9:
            case 11: return 30;

            case 2:
                if (leapYear) return 29;
                else return 28;

            default: throw new IllegalArgumentException("Invalid month");
        }
    }

    public static int daysInMonth(int month) {
        return daysInMonth(month, false);
    }

    public static String nameOfMonth(int month) {
        switch (month) {
            case 1: return "January";
            case 2: return "February";
            case 3: return "March";
            case 4: return "April";
            case 5: return "May";
            case 6: return "June";
            case 7: return "July";

            default: throw new IllegalArgumentException("Invalid month");
        }
    }

    private static int daysFromDouble(double d, boolean leapYear) {
        return (int)((d % 1) * daysInMonth((int)d, leapYear));
    }

    private static int daysFromDouble(double d) {
        return daysFromDouble(d, false);
    }

}
