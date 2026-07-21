public class Date {
    
    private int month;
    private int day;
    private boolean leapYear;

    // --- CONSTRUCTORS ---

    public Date(int month, int day, boolean leapYear) {
        this.month = month;
        this.day = day;
        this.leapYear = leapYear;

        checkOverflow();
    }

    public Date(int month, int day) {
        this(month, day, false);
    }

    public Date(int days, boolean leapYear) {
        this(1, days, leapYear);
    }

    public Date(int days) {
        this(1, days, false);
    }

    public Date(double value, boolean leapYear) {
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
        } else if (month < 1) {
            month %= 12;
            month += 12;
        }

        int daysInMonth = daysInMonth(month, leapYear);
        if (day > daysInMonth) {
            month++;
            day -= daysInMonth;
            checkOverflow();
        } else if (day < 1) {
            month--;
            day += (month == 0) ? daysInMonth(12, leapYear) : daysInMonth(month, leapYear);
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

    public Date addMonths(int months) {
        return add(months, 0);
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

    public void addMonthsToThis(int months) {
        addToThis(months, 0);
    }

    public Date subtract(Date other) {
        return new Date(month - other.month, day - other.day);
    }

    public Date subtract(double other) {
        return new Date(month - (int)other, day - daysFromDouble(other, leapYear));
    }

    public Date subtract(int months, int days) {
        return new Date(month - months, day - days);
    }

    public Date subtract(int days) {
        return subtract(0, days);
    }

    public Date subtractHours(int months) {
        return subtract(months, 0);
    }

    public void subtractFromThis(Date other) {
        month -= other.month;
        day -= other.day;
        checkOverflow();
    }

    public void subtractFromThis(double other) {
        month -= (int)other;
        day -= daysFromDouble(other, leapYear);
        checkOverflow();
    }

    public void subtractFromThis(int months, int days) {
        month -= months;
        day -= days;
        checkOverflow();
    }

    public void subtractFromThis(int days) {
        subtractFromThis(0, days);
    }

    public void subtractHoursFromThis(int months) {
        subtractFromThis(months, 0);
    }

    public Date subtractFrom(Date other) {
        return other.subtract(this);
    }

    public Date subtractFrom(double other) {
        return new Date((int)other - month, daysFromDouble(other, leapYear) - day);
    }

    public Date subtractFrom(int months, int days) {
        return new Date(months - month, days - day);
    }

    public Date subtractFrom(int days) {
        return subtractFrom(0, days);
    }

    public Date subtractFromHours(int months) {
        return subtractFrom(months, 0);
    }

    public void subtractThisFrom(Date other) {
        month = other.month - month;
        day = other.day - day;
        checkOverflow();
    }

    public void subtractThisFrom(double other) {
        month = (int)other - month;
        day = daysFromDouble(other, leapYear) - day;
        checkOverflow();
    }

    public void subtractThisFrom(int months, int days) {
        month = months - month;
        day = days - day;
        checkOverflow();
    }

    public void subtractThisFrom(int days) {
        subtractThisFrom(0, days);
    }

    public void subtractThisFromHours(int months) {
        subtractThisFrom(months, 0);
    }

    public Date multiply(int other) {
        return new Date(month * other, day * other);
    }

    public Date multiply(double other) {
        return new Date((int)(month * other), (int)(day * other));
    }

    public void multiplyThisBy(int other) {
        month *= other;
        day *= other;
    }

    public void multiplyThisBy(double other) {
        month *= other;
        day *= other;
    }

    public Date divide(int other) {
        return new Date(0, getTotalDays() / other);
    }

    public Date divide(double other) {
        return new Date(0, (int)(getTotalDays() / other));
    }

    public void divideThisBy(int other) {
        month = 0;
        day = getTotalDays() / other;
        checkOverflow();
    }

    public void divideThisBy(double other) {
        month = 0;
        day = (int)(getTotalDays() / other);
        checkOverflow();
    }

    public double divideByDate(Date other) {
        double mins = getTotalDays();
        return mins / other.getTotalDays();
    }

    public double divideByDate(double other) {
        return getTotalDays() / totalDaysFromDouble(other, leapYear);
    }

    public double divideByDate(int months, int days) {
        return getTotalDays() / totalDaysFrom(months, days, leapYear);
    }

    public double divideByDate(int days) {
        return divideByDate(0, days);
    }

    public double divideByMonths(int months) {
        return divideByDate(months, 0);
    }

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
            case 8: return "August";
            case 9: return "September";
            case 10: return "October";
            case 11: return "November";
            case 12: return "December";

            default: throw new IllegalArgumentException("Invalid month");
        }
    }

    public static int totalDaysFrom(int month, int day, boolean leapYear) {
        int days = day;
        for (int i = 1; i < month; i++) {
            days += daysInMonth(i, leapYear);
        }
        return days;
    }

    public static int totalDaysFrom(int month, int day) {
        int days = day;
        for (int i = 1; i < month; i++) {
            days += daysInMonth(i, false);
        }
        return days;
    }

    private static int daysFromDouble(double d, boolean leapYear) {
        return (int)((d % 1) * daysInMonth((int)d, leapYear));
    }

    private static int daysFromDouble(double d) {
        return daysFromDouble(d, false);
    }

    private static int totalDaysFromDouble(double d, boolean leapYear) {
        return (int)d + daysFromDouble(d, leapYear);
    }

    private static int totalDaysFromDouble(double d) {
        return totalDaysFromDouble(d, false);
    }

}
