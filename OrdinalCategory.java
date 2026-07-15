public class OrdinalCategory extends NumericalCategory {

    // --- CONSTRUCTORS ---

    public OrdinalCategory(String name, int count, int startValue, int step, String displayNoun, String clueTemplate) {
        super(name, count, startValue, step, displayNoun, clueTemplate);
        if (startValue <= 0 || startValue + step*5 <= 0) throw new IllegalArgumentException("All values in an ordinal category must be positive");
    }

    public OrdinalCategory(String name, int count, int startValue, int step, String displayNoun) {
        this(name, count, startValue, step, displayNoun, "{VAL}");
    }

    public OrdinalCategory(String name, int count, int startValue, int step) {
        this(name, count, startValue, step, "", "{VAL}");
    }

    public OrdinalCategory(String name, int count, int startValue, String displayNoun, String clueTemplate) {
        this(name, count, startValue, 1, displayNoun, clueTemplate);
    }

    public OrdinalCategory(String name, int count, int startValue, String displayNoun) {
        this(name, count, startValue, 1, displayNoun, "{VAL}");
    }

    public OrdinalCategory(String name, int count, int startValue) {
        this(name, count, startValue, 1, "", "{VAL}");
    }

    public OrdinalCategory(String name, int count, String displayNoun, String clueTemplate) {
        this(name, count, 1, 1, displayNoun, clueTemplate);
    }

    public OrdinalCategory(String name, int count, String displayNoun) {
        this(name, count, 1, 1, displayNoun, "{VAL}");
    }

    public OrdinalCategory(String name, int count) {
        this(name, count, 1, 1, "", "{VAL}");
    }

    // --- GETTERS & SETTERS ---
    
    @Override
    protected String rawDisplayValue(int i) {
        return Utils.numToOrdinalString(values[i]);
    }
    
}
