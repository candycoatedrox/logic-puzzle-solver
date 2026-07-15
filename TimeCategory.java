public class TimeCategory extends NumericalCategory {

    private Time[] values;
    private Time step;

    // --- CONSTRUCTORS ---

    public TimeCategory(String name, int count, Time startValue, Time step, String displayNoun, String clueTemplate) {
        super(name, count, startValue.getDoubleValue(), step.getDoubleValue(), displayNoun, clueTemplate);
        this.step = step;

        Time val = startValue;
        for (int i = 0; i < count; i++) {
            values[i] = val;
            updateDisplayValue(i);
            val.addToThis(step);
        }
    }

    // TODO... more constructors. don't require feeding a Time directly in

    // --- GETTERS & SETTERS ---
    
    @Override
    protected String rawDisplayValue(int i) {
        return values[i].toString();
    }
    
}
