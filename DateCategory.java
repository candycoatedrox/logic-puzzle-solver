public class DateCategory extends NumericalCategory {

    private Date[] values;
    private Date step;

    // --- CONSTRUCTORS ---

    /* Main constructor; use setCategory() to set values and clue template later */
    public DateCategory(String name, int count) {
        super(name, count);
    }

    public DateCategory(String name, int count, Date startValue, Date step, String displayNoun, String clueTemplate) {
        super(name, count, startValue.getDoubleValue(), step.getDoubleValue(), displayNoun, clueTemplate);
        this.step = step;

        Date val = startValue;
        for (int i = 0; i < count; i++) {
            values[i] = val;
            updateDisplayValue(i);
            val.addToThis(step);
        }
    }

    // TODO... more constructors. don't require feeding a Date directly in

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

    // TODO... display values for step differently if it's months vs. days
    
}
