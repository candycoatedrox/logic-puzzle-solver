public class NumericalCategory extends Category {
    
    protected double[] values;
    protected double step;
    
    protected boolean isInteger = false;

    protected String displayNoun = ""; // account for possible plurals...? (ex. 1 ft/2 ft)
    protected String[] displayValues;

    // --- CONSTRUCTORS ---

    /* Main constructor; use setCategory() to set values and clue template later */
    public NumericalCategory(String name, int count) {
        super(name, count);
        values = new double[count];
        displayValues = new String[count];
    }

    public NumericalCategory(String name, int count, double startValue, double step, String displayNoun, String clueTemplate) {
        this(name, count);
        this.step = step;
        updateIsInteger();
        this.displayNoun = displayNoun;
        this.clueTemplate = clueTemplate;

        double val = startValue;
        for (int i = 0; i < count; i++) {
            values[i] = val;
            updateDisplayValue(i);
            val += step;
        }
    }

    public NumericalCategory(String name, int count, int startValue, double step, String displayNoun, int displayType, String clueTemplate) {
        this(name, count, (double)startValue, step, displayNoun, clueTemplate);
    }

    public NumericalCategory(String name, int count, int startValue, int step, String displayNoun, int displayType, String clueTemplate) {
        this(name, count, (double)startValue, (double)step, displayNoun, clueTemplate);
    }

    public NumericalCategory(String name, int count, double startValue, double step, String displayNoun, int displayType) {
        this(name, count, startValue, step, displayNoun, "{VAL}");
    }

    public NumericalCategory(String name, int count, int startValue, double step, String displayNoun, int displayType) {
        this(name, count, (double)startValue, step, displayNoun, "{VAL}");
    }

    public NumericalCategory(String name, int count, int startValue, int step, String displayNoun, int displayType) {
        this(name, count, (double)startValue, (double)step, displayNoun, "{VAL}");
    }

    public NumericalCategory(String name, int count, int startValue, double step, String displayNoun, String clueTemplate) {
        this(name, count, (double)startValue, step, displayNoun, clueTemplate);
    }

    public NumericalCategory(String name, int count, int startValue, int step, String displayNoun, String clueTemplate) {
        this(name, count, (double)startValue, (double)step, displayNoun, clueTemplate);
    }

    public NumericalCategory(String name, int count, double startValue, double step, int displayType, String clueTemplate) {
        this(name, count, startValue, step, "", clueTemplate);
    }

    public NumericalCategory(String name, int count, int startValue, double step, int displayType, String clueTemplate) {
        this(name, count, (double)startValue, step, "", clueTemplate);
    }

    public NumericalCategory(String name, int count, int startValue, int step, int displayType, String clueTemplate) {
        this(name, count, (double)startValue, (double)step, "", clueTemplate);
    }

    public NumericalCategory(String name, int count, double startValue, double step, String displayNoun) {
        this(name, count, startValue, step, displayNoun, "{VAL}");
    }

    public NumericalCategory(String name, int count, int startValue, double step, String displayNoun) {
        this(name, count, (double)startValue, step, displayNoun, "{VAL}");
    }

    public NumericalCategory(String name, int count, int startValue, int step, String displayNoun) {
        this(name, count, (double)startValue, (double)step, displayNoun, "{VAL}");
    }

    public NumericalCategory(String name, int count, double startValue, double step, int displayType) {
        this(name, count, startValue, step, "", "{VAL}");
    }

    public NumericalCategory(String name, int count, int startValue, double step, int displayType) {
        this(name, count, (double)startValue, step, "", "{VAL}");
    }

    public NumericalCategory(String name, int count, int startValue, int step, int displayType) {
        this(name, count, (double)startValue, (double)step, "", "{VAL}");
    }

    public NumericalCategory(String name, int count, double startValue, double step) {
        this(name, count, startValue, step, "", "{VAL}");
    }

    public NumericalCategory(String name, int count, int startValue, double step) {
        this(name, count, (double)startValue, step, "", "{VAL}");
    }

    public NumericalCategory(String name, int count, int startValue, int step) {
        this(name, count, (double)startValue, (double)step, "", "{VAL}");
    }

    // --- SET CATEGORY ---

    public void setCategory(double startValue, double step, String displayNoun, String clueTemplate) {
        this.step = step;
        this.displayNoun = displayNoun;
        this.clueTemplate = clueTemplate;

        double val = startValue;
        for (int i = 0; i < getCount(); i++) {
            values[i] = val;
            updateDisplayValue(i);
            val += step;
        }
    }

    public void setCategory(int startValue, double step, String displayNoun, String clueTemplate) {
        setCategory((double)startValue, step, displayNoun, clueTemplate);
    }

    public void setCategory(int startValue, int step, String displayNoun, String clueTemplate) {
        setCategory((double)startValue, (double)step, displayNoun, clueTemplate);
    }

    public void setCategory(double startValue, double step, String displayNoun) {
        setCategory(startValue, step, displayNoun, "{VAL}");
    }

    public void setCategory(int startValue, double step, String displayNoun) {
        setCategory((double)startValue, step, displayNoun, "{VAL}");
    }

    public void setCategory(int startValue, int step, String displayNoun) {
        setCategory((double)startValue, (double)step, displayNoun, "{VAL}");
    }

    public void setDisplay(String displayNoun, String clueTemplate) {
        this.displayNoun = displayNoun;
        this.clueTemplate = clueTemplate;
        updateDisplayValues();
    }

    // --- GETTERS & SETTERS ---

    @Override
    public int getCount() {
        return values.length;
    }

    public double[] getValues() {
        return values;
    }

    public void setValues(double startValue, double step) {
        this.step = step;
        double val = startValue;
        for (int i = 0; i < getCount(); i++) {
            values[i] = val;
            updateDisplayValue(i);
            val += step;
        }
        
    }

    public void setValues(int startValue, double step) {
        setValues((double)startValue, step);
    }

    public void setValues(int startValue, int step) {
        setValues((double)startValue, (double)step);
    }

    public double getValue(int i) {
        return values[i];
    }

    public double getStartValue() {
        return values[0];
    }

    public double getHighestValue() {
        if (step > 0) {
            return values[getCount() - 1];
        } else {
            return values[0];
        }
    }

    public double getLowestValue() {
        if (step > 0) {
            return values[0];
        } else {
            return values[getCount() - 1];
        }
    }

    public double getStep() {
        return step;
    }

    public double nStepDifference(int n) {
        return step * n;
    }

    public int getDisplayType() {
        if (isPrice()) return 1;
        else if (isTime()) return 2;
        else if (isDate()) return 3;
        else if (isOrdinal()) return 4;
        else return 0;
    }

    public boolean isStandard() {
        return !isPrice() && !isTime() && !isDate() && !isOrdinal();
    }

    public boolean isPrice() {
        return this instanceof PriceCategory;
    }

    public boolean isTime() {
        return this instanceof TimeCategory;
    }

    public boolean isDate() {
        return this instanceof DateCategory;
    }

    public boolean isOrdinal() {
        return this instanceof OrdinalCategory;
    }

    protected void updateIsInteger() {
        isInteger = Utils.isInteger(getStartValue()) && Utils.isInteger(step);
    }

    public boolean displaysAsInteger() {
        return isStandard() && isInteger;
    }

    public String getDisplayNoun() {
        return displayNoun;
    }

    public boolean hasDisplayNoun() {
        return !displayNoun.isEmpty();
    }

    public void setDisplayNoun(String noun) {
        displayNoun = noun;
        updateDisplayValues();
    }

    @Override
    public String[] getDisplayValues() {
        String[] displayVals = new String[getCount()];
        for (int i = 0; i < getCount(); i++) {
            displayVals[i] = getDisplayValue(i);
        }
        return displayVals;
    }

    @Override
    public String getDisplayValue(int i) {
        return displayValues[i];
    }

    @Override
    protected void updateDisplayValue(int i) {
        displayValues[i] = rawDisplayValue(i);
        if (hasDisplayNoun()) displayValues[i] += " " + displayNoun;
        updateClueValue(i);
    }

    protected String rawDisplayValue(int i) {
        double value = values[i];
        if (displaysAsInteger()) {
            return String.valueOf((int)value);
        } else {
            return String.valueOf(value);
        }
    }

    @Override
    protected final void updateClueValue(int i) {
        clueValues[i] = clueTemplate.replace("{VAL}", displayValues[i]);
    }

}
