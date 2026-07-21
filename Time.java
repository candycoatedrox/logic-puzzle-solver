public class Time {
    
    private int hour;
    private int minute;

    // --- CONSTRUCTORS ---

    public Time(int hour, int minute) {
        if (hour < 0 || minute < 0) throw new IllegalArgumentException("Hour and minute must be positive");

        this.hour = hour;
        this.minute = minute;
        checkOverflow();
    }

    public Time(int hour) {
        this(hour, 0);
    }

    public Time(double value) {
        if (value < 0) throw new IllegalArgumentException("Time must have a positive value");

        hour = (int)value;
        minute = minutesFromDouble(value);
        checkOverflow();
    }

    // --- GETTERS & SETTERS ---

    private void checkOverflow() {
        if (minute >= 60) {
            hour += minute / 60;
            minute %= 60;
        } else if (minute < 0) {
            hour -= (minute / -60) + 1;
            minute %= 60;
            minute += 60;
        }

        if (hour >= 24) {
            hour %= 24;
        } else if (hour < 0) {
            hour %= 24;
            hour += 24;
        }
    }

    public int getHour() {
        return hour;
    }

    public int getHour12() {
        int raw = hour % 12;
        if (raw == 0) return 12;
        else return raw;
    }

    public int getMinute() {
        return minute;
    }

    public int getTotalMinutes() {
        return (hour * 60) + minute;
    }

    public boolean isPM() {
        return hour == 0 || hour > 11;
    }

    public double getDoubleValue() {
        return hour + (minute / 60.0);
    }

    // --- ARITHMETIC ---

    public Time add(Time other) {
        return new Time(hour + other.hour, minute + other.minute);
    }

    public Time add(double other) {
        return new Time(hour + (int)other, minute + minutesFromDouble(other));
    }

    public Time add(int hours, int minutes) {
        return new Time(hour + hours, minute + minutes);
    }

    public Time add(int minutes) {
        return add(0, minutes);
    }

    public Time addHours(int hours) {
        return add(hours, 0);
    }

    public void addToThis(Time other) {
        hour += other.hour;
        minute += other.minute;
        checkOverflow();
    }

    public void addToThis(double other) {
        hour += (int)other;
        minute += minutesFromDouble(other);
        checkOverflow();
    }

    public void addToThis(int hours, int minutes) {
        hour += hours;
        minute += minutes;
        checkOverflow();
    }

    public void addToThis(int minutes) {
        addToThis(0, minutes);
    }

    public void addHoursToThis(int hours) {
        addToThis(hours, 0);
    }

    public Time subtract(Time other) {
        return new Time(hour - other.hour, minute - other.minute);
    }

    public Time subtract(double other) {
        return new Time(hour - (int)other, minute - minutesFromDouble(other));
    }

    public Time subtract(int hours, int minutes) {
        return new Time(hour - hours, minute - minutes);
    }

    public Time subtract(int minutes) {
        return subtract(0, minutes);
    }

    public Time subtractHours(int hours) {
        return subtract(hours, 0);
    }

    public void subtractFromThis(Time other) {
        hour -= other.hour;
        minute -= other.minute;
        checkOverflow();
    }

    public void subtractFromThis(double other) {
        hour -= (int)other;
        minute -= minutesFromDouble(other);
        checkOverflow();
    }

    public void subtractFromThis(int hours, int minutes) {
        hour -= hours;
        minute -= minutes;
        checkOverflow();
    }

    public void subtractFromThis(int minutes) {
        subtractFromThis(0, minutes);
    }

    public void subtractHoursFromThis(int hours) {
        subtractFromThis(hours, 0);
    }

    public Time subtractFrom(Time other) {
        return other.subtract(this);
    }

    public Time subtractFrom(double other) {
        return new Time((int)other - hour, minutesFromDouble(other) - minute);
    }

    public Time subtractFrom(int hours, int minutes) {
        return new Time(hours - hour, minutes - minute);
    }

    public Time subtractFrom(int minutes) {
        return subtractFrom(0, minutes);
    }

    public Time subtractFromHours(int hours) {
        return subtractFrom(hours, 0);
    }

    public void subtractThisFrom(Time other) {
        hour = other.hour - hour;
        minute = other.minute - minute;
        checkOverflow();
    }

    public void subtractThisFrom(double other) {
        hour = (int)other - hour;
        minute = minutesFromDouble(other) - minute;
        checkOverflow();
    }

    public void subtractThisFrom(int hours, int minutes) {
        hour = hours - hour;
        minute = minutes - minute;
        checkOverflow();
    }

    public void subtractThisFrom(int minutes) {
        subtractThisFrom(0, minutes);
    }

    public void subtractThisFromHours(int hours) {
        subtractThisFrom(hours, 0);
    }

    public Time multiply(int other) {
        return new Time(hour * other, minute * other);
    }

    public Time multiply(double other) {
        return new Time((int)(hour * other), (int)(minute * other));
    }

    public void multiplyThisBy(int other) {
        hour *= other;
        minute *= other;
    }

    public void multiplyThisBy(double other) {
        hour *= other;
        minute *= other;
    }

    public Time divide(int other) {
        return new Time(0, getTotalMinutes() / other);
    }

    public Time divide(double other) {
        return new Time(0, (int)(getTotalMinutes() / other));
    }

    public void divideThisBy(int other) {
        hour = 0;
        minute = getTotalMinutes() / other;
        checkOverflow();
    }

    public void divideThisBy(double other) {
        hour = 0;
        minute = (int)(getTotalMinutes() / other);
        checkOverflow();
    }

    public double divideByTime(Time other) {
        double mins = getTotalMinutes();
        return mins / other.getTotalMinutes();
    }

    public double divideByTime(double other) {
        return getTotalMinutes() / totalMinutesFromDouble(other);
    }

    public double divideByTime(int hours, int minutes) {
        return getTotalMinutes() / totalMinutesFrom(hours, minutes);
    }

    public double divideByTime(int minutes) {
        return divideByTime(0, minutes);
    }

    public double divideByHours(int hours) {
        return divideByTime(hours, 0);
    }

    // --- MISC ---

    public String toString(boolean militaryTime) {
        if (militaryTime) {
            return hour + ":" + minute;
        } else {
            String s = getHour12() + ":" + minute;
            if (isPM()) s += "pm";
            else s += "am";
            return s;
        }
    }

    @Override
    public String toString() {
        return toString(false);
    }

    // --- STATIC ---

    public static int totalMinutesFrom(int hours, int minutes) {
        return (hours * 60) + minutes;
    }

    public static int minutesFromDouble(double d) {
        return (int)((d % 1) * 60);
    }

    public static int totalMinutesFromDouble(double d) {
        return ((int)d * 60) + minutesFromDouble(d);
    }

}
