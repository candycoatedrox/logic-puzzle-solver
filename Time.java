public class Time {
    
    private int hour;
    private int minute;

    // --- CONSTRUCTOR ---

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
        }

        if (hour >= 24) {
            hour %= 24;
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
        Time sum = new Time(hour + (int)other, minute + minutesFromDouble(other));
        return sum;
    }

    public Time add(int hours, int minutes) {
        return new Time(hour + hours, minute + minutes);
    }

    public Time add(int minutes) {
        return add(0, minutes);
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

    // TODO: subtract, multiply, divide (by int)

    // --- MISC ---

    public static int minutesFromDouble(double d) {
        return (int)((d % 1) * 60);
    }

    @Override
    public String toString() {
        String s = getHour12() + ":" + minute;
        if (isPM()) s += "pm";
        else s += "am";
        return s;
    }

}
