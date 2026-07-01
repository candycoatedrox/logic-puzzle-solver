public class NumericalCategory extends AbstractCategory {
    
    private double[] values;
    private double step;

    private String[] displayValues;

    // --- CONSTRUCTORS ---

    public NumericalCategory(int count, double startValue, double step, String clueTemplate) {
        this.step = step;
        this.clueTemplate = clueTemplate;

        values = new double[count];
        clueValues = new String[count];
        double val = startValue;
        for (int i = 0; i < count; i++) {
            values[i] = val;
            clueValues[i] = clueTemplate.replace("$VAL", String.valueOf(val));
            val += step;
        }
    }

    public NumericalCategory(int count, double startValue, double step) {
        this(count, startValue, step, "$VAL");
    }

    public NumericalCategory(int count, int startValue, int step, String clueTemplate) {
        this(count, (double)startValue, (double)step, clueTemplate);
    }

    public NumericalCategory(int count, int startValue, int step) {
        this(count, (double)startValue, (double)step, "$VAL");
    }

    // --- GETTERS ---

    public double[] getValues() {
        return values;
    }

    public double getValue(int i) {
        return values[i];
    }

    public double getStep() {
        return step;
    }

    public int getCount() {
        return values.length;
    }

    public double nStepDifference(int n) {
        return step * n;
    }

}
