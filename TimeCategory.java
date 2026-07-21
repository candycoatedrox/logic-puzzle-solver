public class TimeCategory extends NumericalCategory {

    private Time[] values;
    private Time step;

    // --- CONSTRUCTORS ---

    /* Main constructor; use setCategory() to set values and clue template later */
    public TimeCategory(String name, int count) {
        super(name, count);
    }

    public TimeCategory(String name, int count, Time startValue, Time step, String clueTemplate) {
        super(name, count, startValue.getDoubleValue(), step.getDoubleValue(), clueTemplate);
        this.step = step;

        Time val = startValue;
        for (int i = 0; i < count; i++) {
            values[i] = val;
            updateDisplayValue(i);
            val.addToThis(step);
        }
    }

    // TODO... more constructors. don't require feeding a Time directly in

    // --- SET CATEGORY ---

    // TODO... note: NO DISPLAYNOUN!

    // --- GETTERS & SETTERS ---

    @Override
    public void setDisplayNoun(String noun) {
    }
    
    @Override
    protected String rawDisplayValue(int i) {
        return values[i].toString();
    }
    
}
