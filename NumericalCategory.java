public class NumericalCategory extends Category {
    
    private double[] values;
    private double step;

    private String[] displayValues;

    // --- CONSTRUCTORS ---

    /* Main constructor; use setCategory() to set values and clue template later */
    public NumericalCategory(String name, int count) {
        super(name, count);
        this.values = new double[count];
    }

    public NumericalCategory(String name, int count, double startValue, double step, String clueTemplate) {
        super(name, count);
        this.step = step;
        this.clueTemplate = clueTemplate;

        values = new double[count];
        double val = startValue;
        for (int i = 0; i < count; i++) {
            values[i] = val;
            clueValues[i] = clueTemplate.replace("$VAL", String.valueOf(val));
            val += step;
        }
    }

    public NumericalCategory(String name, int count, double startValue, double step) {
        this(name, count, startValue, step, "$VAL");
    }

    public NumericalCategory(String name, int count, int startValue, double step, String clueTemplate) {
        this(name, count, (double)startValue, step, clueTemplate);
    }

    public NumericalCategory(String name, int count, int startValue, double step) {
        this(name, count, (double)startValue, step, "$VAL");
    }

    public NumericalCategory(String name, int count, int startValue, int step, String clueTemplate) {
        this(name, count, (double)startValue, (double)step, clueTemplate);
    }

    public NumericalCategory(String name, int count, int startValue, int step) {
        this(name, count, (double)startValue, (double)step, "$VAL");
    }

    // --- GETTERS & SETTERS ---

    public void setCategory(double startValue, double step, String clueTemplate) {
        this.clueTemplate = clueTemplate;

        double val = startValue;
        for (int i = 0; i < getCount(); i++) {
            values[i] = val;
            clueValues[i] = clueTemplate.replace("$VAL", String.valueOf(val));
            val += step;
        }
    }

    public void setCategory(int startValue, double step, String clueTemplate) {
        setCategory((double)startValue, step, clueTemplate);
    }

    public void setCategory(int startValue, int step, String clueTemplate) {
        setCategory((double)startValue, (double)step, clueTemplate);
    }

    public int getCount() {
        return values.length;
    }

    public double[] getValues() {
        return values;
    }

    public void setValues(double startValue, double step) {
        double val = startValue;
        for (int i = 0; i < getCount(); i++) {
            values[i] = val;
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

    public double getStep() {
        return step;
    }

    @Override
    public void setClueValues() {
        for (int i = 0; i < getCount(); i++) {
            clueValues[i] = clueTemplate.replace("$VAL", String.valueOf(values[i]));
        }
    }

    public double nStepDifference(int n) {
        return step * n;
    }

}
