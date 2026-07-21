public class MonthCategory extends NumericalCategory {

    // --- CONSTRUCTORS ---

    /* Main constructor; use setCategory() to set values later */
    public MonthCategory(String name, int count) {
        super(name, count);
    }

    public MonthCategory(String name, int count, int startValue, int step) {
        super(name, count, startValue, step);
        if (startValue <= 0 || startValue + step*5 <= 0) throw new IllegalArgumentException("All values in a month category must be positive");
    }

    public MonthCategory(String name, int count, int startValue) {
        this(name, count, startValue, 1);
    }

    // --- SET CATEGORY ---

    @Override
    public void setCategory(double startValue, double step, String displayNoun, String clueTemplate) {
        setValues(startValue, step);
    }

    @Override
    public void setCategory(double startValue, double step, String clueTemplate) {
        setValues(startValue, step);
    }

    @Override
    public void setCategory(int startValue, double step, String displayNoun, String clueTemplate) {
        setValues(startValue, step);
    }

    @Override
    public void setCategory(int startValue, int step, String displayNoun, String clueTemplate) {
        setValues(startValue, step);
    }

    @Override
    public void setCategory(int startValue, double step, String displayNoun) {
        setValues(startValue, step);
    }

    @Override
    public void setCategory(int startValue, int step, String displayNoun) {
        setValues(startValue, step);
    }

    @Override
    public void setDisplay(String displayNoun, String clueTemplate) {
    }

    // --- GETTERS & SETTERS ---

    @Override
    public void setValues(int startValue, int step) {
        this.step = step;
        double val = startValue;
        for (int i = 0; i < getCount(); i++) {
            values[i] = val;
            updateDisplayValue(i);
            val += step;
        }
    }

    @Override
    public void setValues(int startValue, double step) {
        setValues(startValue, (int)step);
    }

    @Override
    public void setValues(double startValue, double step) {
        setValues((int)startValue, (int)step);
    }

    @Override
    public double getValue(int i) {
        double rawValue = values[i];
        if (rawValue <= 12) {
            return rawValue;
        } else {
            rawValue %= 12;
            if (rawValue == 0) rawValue = 12;
            return rawValue;
        }
    }

    public double getRawValue(int i) {
        return values[i];
    }

    @Override
    public void setClueTemplate(String template) {
    }

    @Override
    public void setDisplayNoun(String noun) {
    }
    
    @Override
    protected String rawDisplayValue(int i) {
        return Date.nameOfMonth((int)getValue(i));
    }
    
}
